package androidx.room.solver;

import androidx.room.compiler.processing.XArrayType;
import androidx.room.compiler.processing.XEnumTypeElement;
import androidx.room.compiler.processing.XEnumTypeElementKt;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.compiler.processing.XTypeKt;
import androidx.room.ext.CollectionTypeNames;
import androidx.room.ext.CommonTypeNames;
import androidx.room.ext.GuavaBaseTypeNames;
import androidx.room.ext.Xelement_extKt;
import androidx.room.ext.Xtype_extKt;
import androidx.room.log.RLog;
import androidx.room.parser.ParsedQuery;
import androidx.room.parser.SQLTypeAffinity;
import androidx.room.processor.Context;
import androidx.room.processor.EntityProcessorKt;
import androidx.room.processor.FieldProcessor;
import androidx.room.processor.PojoProcessor;
import androidx.room.processor.ProcessorErrors;
import androidx.room.solver.binderprovider.CoroutineFlowResultBinderProviderKt;
import androidx.room.solver.binderprovider.CursorQueryResultBinderProvider;
import androidx.room.solver.binderprovider.DataSourceFactoryQueryResultBinderProvider;
import androidx.room.solver.binderprovider.DataSourceQueryResultBinderProvider;
import androidx.room.solver.binderprovider.GuavaListenableFutureQueryResultBinderProviderKt;
import androidx.room.solver.binderprovider.InstantQueryResultBinderProvider;
import androidx.room.solver.binderprovider.ListenableFuturePagingSourceQueryResultBinderProviderKt;
import androidx.room.solver.binderprovider.LiveDataQueryResultBinderProvider;
import androidx.room.solver.binderprovider.PagingSourceQueryResultBinderProviderKt;
import androidx.room.solver.binderprovider.RxCallableQueryResultBinderProvider;
import androidx.room.solver.binderprovider.RxJava2PagingSourceQueryResultBinderProviderKt;
import androidx.room.solver.binderprovider.RxJava3PagingSourceQueryResultBinderProviderKt;
import androidx.room.solver.binderprovider.RxQueryResultBinderProvider;
import androidx.room.solver.prepared.binder.PreparedQueryResultBinder;
import androidx.room.solver.prepared.binderprovider.GuavaListenableFuturePreparedQueryResultBinderProvider;
import androidx.room.solver.prepared.binderprovider.InstantPreparedQueryResultBinderProvider;
import androidx.room.solver.prepared.binderprovider.PreparedQueryResultBinderProvider;
import androidx.room.solver.prepared.binderprovider.RxPreparedQueryResultBinderProvider;
import androidx.room.solver.prepared.result.PreparedQueryResultAdapter;
import androidx.room.solver.query.parameter.ArrayQueryParameterAdapter;
import androidx.room.solver.query.parameter.BasicQueryParameterAdapter;
import androidx.room.solver.query.parameter.CollectionQueryParameterAdapter;
import androidx.room.solver.query.parameter.QueryParameterAdapter;
import androidx.room.solver.query.result.ArrayQueryResultAdapter;
import androidx.room.solver.query.result.EntityRowAdapter;
import androidx.room.solver.query.result.GuavaImmutableMultimapQueryResultAdapter;
import androidx.room.solver.query.result.GuavaOptionalQueryResultAdapter;
import androidx.room.solver.query.result.ImmutableListQueryResultAdapter;
import androidx.room.solver.query.result.ImmutableMapQueryResultAdapter;
import androidx.room.solver.query.result.ListQueryResultAdapter;
import androidx.room.solver.query.result.MapQueryResultAdapter;
import androidx.room.solver.query.result.MultimapQueryResultAdapter;
import androidx.room.solver.query.result.OptionalQueryResultAdapter;
import androidx.room.solver.query.result.PojoRowAdapter;
import androidx.room.solver.query.result.QueryMappedRowAdapter;
import androidx.room.solver.query.result.QueryResultAdapter;
import androidx.room.solver.query.result.QueryResultBinder;
import androidx.room.solver.query.result.RowAdapter;
import androidx.room.solver.query.result.SingleColumnRowAdapter;
import androidx.room.solver.query.result.SingleEntityQueryResultAdapter;
import androidx.room.solver.query.result.SingleNamedColumnRowAdapter;
import androidx.room.solver.shortcut.binder.DeleteOrUpdateMethodBinder;
import androidx.room.solver.shortcut.binder.InsertOrUpsertMethodBinder;
import androidx.room.solver.shortcut.binderprovider.DeleteOrUpdateMethodBinderProvider;
import androidx.room.solver.shortcut.binderprovider.GuavaListenableFutureDeleteOrUpdateMethodBinderProvider;
import androidx.room.solver.shortcut.binderprovider.GuavaListenableFutureInsertMethodBinderProvider;
import androidx.room.solver.shortcut.binderprovider.GuavaListenableFutureUpsertMethodBinderProvider;
import androidx.room.solver.shortcut.binderprovider.InsertOrUpsertMethodBinderProvider;
import androidx.room.solver.shortcut.binderprovider.InstantDeleteOrUpdateMethodBinderProvider;
import androidx.room.solver.shortcut.binderprovider.InstantInsertMethodBinderProvider;
import androidx.room.solver.shortcut.binderprovider.InstantUpsertMethodBinderProvider;
import androidx.room.solver.shortcut.binderprovider.RxCallableDeleteOrUpdateMethodBinderProvider;
import androidx.room.solver.shortcut.binderprovider.RxCallableInsertMethodBinderProvider;
import androidx.room.solver.shortcut.binderprovider.RxCallableUpsertMethodBinderProvider;
import androidx.room.solver.shortcut.result.DeleteOrUpdateMethodAdapter;
import androidx.room.solver.shortcut.result.InsertOrUpsertMethodAdapter;
import androidx.room.solver.types.BoxedBooleanToBoxedIntConverter;
import androidx.room.solver.types.BoxedPrimitiveColumnTypeAdapter;
import androidx.room.solver.types.ByteArrayColumnTypeAdapter;
import androidx.room.solver.types.ByteBufferColumnTypeAdapter;
import androidx.room.solver.types.ColumnTypeAdapter;
import androidx.room.solver.types.CompositeAdapter;
import androidx.room.solver.types.CursorValueReader;
import androidx.room.solver.types.EnumColumnTypeAdapter;
import androidx.room.solver.types.PrimitiveBooleanToIntConverter;
import androidx.room.solver.types.PrimitiveColumnTypeAdapter;
import androidx.room.solver.types.StatementValueBinder;
import androidx.room.solver.types.StringColumnTypeAdapter;
import androidx.room.solver.types.TypeConverter;
import androidx.room.solver.types.UuidColumnTypeAdapter;
import androidx.room.verifier.ColumnInfo;
import androidx.room.verifier.QueryResultInfo;
import androidx.room.vo.BuiltInConverterFlags;
import androidx.room.vo.BuiltInConverterFlagsKt;
import androidx.room.vo.MapInfo;
import androidx.room.vo.ShortcutQueryParameter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSetMultimap;
import com.lynx.jsbridge.LynxResourceModule;
import com.squareup.javapoet.e;
import com.squareup.javapoet.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 T2\u00020\u0001:\u0001TB/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020!H\u0002J\"\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010#\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'J\u001a\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010%J\u0010\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020!J\u000e\u0010.\u001a\u00020/2\u0006\u0010-\u001a\u00020!J\u001c\u00100\u001a\u0004\u0018\u00010\u00062\u0006\u0010#\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u001e\u00101\u001a\u0004\u0018\u0001022\u0006\u0010-\u001a\u00020!2\f\u00103\u001a\b\u0012\u0004\u0012\u0002040\u0005J\u001c\u00105\u001a\u0002062\u0006\u0010-\u001a\u00020!2\f\u00103\u001a\b\u0012\u0004\u0012\u0002040\u0005J\u0018\u00107\u001a\u0004\u0018\u0001082\u0006\u0010-\u001a\u00020!2\u0006\u00109\u001a\u00020:J\u0016\u0010;\u001a\u00020<2\u0006\u0010-\u001a\u00020!2\u0006\u00109\u001a\u00020:J\u0018\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010-\u001a\u00020!2\u0006\u0010?\u001a\u00020'J \u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010-\u001a\u00020!2\u0006\u00109\u001a\u00020:2\u0006\u0010B\u001a\u00020CJ3\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010-\u001a\u00020!2\u0006\u00109\u001a\u00020:2\u0019\b\u0002\u0010D\u001a\u0013\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020F0E¢\u0006\u0002\bGJ\u001e\u0010H\u001a\u00020I2\u0006\u0010-\u001a\u00020!2\u0006\u00109\u001a\u00020:2\u0006\u0010B\u001a\u00020CJ1\u0010H\u001a\u00020I2\u0006\u0010-\u001a\u00020!2\u0006\u00109\u001a\u00020:2\u0019\b\u0002\u0010D\u001a\u0013\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020F0E¢\u0006\u0002\bGJ$\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010-\u001a\u00020!2\u0006\u00109\u001a\u00020:2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010MJ\u001a\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010%J\u001e\u0010Q\u001a\u0004\u0018\u0001022\u0006\u0010-\u001a\u00020!2\f\u00103\u001a\b\u0012\u0004\u0012\u0002040\u0005J\u001c\u0010R\u001a\u0002062\u0006\u0010-\u001a\u00020!2\f\u00103\u001a\b\u0012\u0004\u0012\u0002040\u0005J\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010P\u001a\u00020!H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011¨\u0006U"}, d2 = {"Landroidx/room/solver/TypeAdapterStore;", "", "context", "Landroidx/room/processor/Context;", "columnTypeAdapters", "", "Landroidx/room/solver/types/ColumnTypeAdapter;", "typeConverterStore", "Landroidx/room/solver/TypeConverterStore;", "builtInConverterFlags", "Landroidx/room/vo/BuiltInConverterFlags;", "(Landroidx/room/processor/Context;Ljava/util/List;Landroidx/room/solver/TypeConverterStore;Landroidx/room/vo/BuiltInConverterFlags;)V", "getContext", "()Landroidx/room/processor/Context;", "deleteOrUpdateBinderProvider", "Landroidx/room/solver/shortcut/binderprovider/DeleteOrUpdateMethodBinderProvider;", "getDeleteOrUpdateBinderProvider", "()Ljava/util/List;", "insertBinderProviders", "Landroidx/room/solver/shortcut/binderprovider/InsertOrUpsertMethodBinderProvider;", "getInsertBinderProviders", "preparedQueryResultBinderProviders", "Landroidx/room/solver/prepared/binderprovider/PreparedQueryResultBinderProvider;", "getPreparedQueryResultBinderProviders", "queryResultBinderProviders", "Landroidx/room/solver/QueryResultBinderProvider;", "getQueryResultBinderProviders", "getTypeConverterStore$room_compiler", "()Landroidx/room/solver/TypeConverterStore;", "upsertBinderProviders", "getUpsertBinderProviders", "createDefaultTypeAdapter", "type", "Landroidx/room/compiler/processing/XType;", "findColumnTypeAdapter", "out", "affinity", "Landroidx/room/parser/SQLTypeAffinity;", "skipDefaultConverter", "", "findCursorValueReader", "Landroidx/room/solver/types/CursorValueReader;", "output", "findDeleteOrUpdateAdapter", "Landroidx/room/solver/shortcut/result/DeleteOrUpdateMethodAdapter;", "typeMirror", "findDeleteOrUpdateMethodBinder", "Landroidx/room/solver/shortcut/binder/DeleteOrUpdateMethodBinder;", "findDirectAdapterFor", "findInsertAdapter", "Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter;", LynxResourceModule.PARAMS_KEY, "Landroidx/room/vo/ShortcutQueryParameter;", "findInsertMethodBinder", "Landroidx/room/solver/shortcut/binder/InsertOrUpsertMethodBinder;", "findPreparedQueryResultAdapter", "Landroidx/room/solver/prepared/result/PreparedQueryResultAdapter;", "query", "Landroidx/room/parser/ParsedQuery;", "findPreparedQueryResultBinder", "Landroidx/room/solver/prepared/binder/PreparedQueryResultBinder;", "findQueryParameterAdapter", "Landroidx/room/solver/query/parameter/QueryParameterAdapter;", "isMultipleParameter", "findQueryResultAdapter", "Landroidx/room/solver/query/result/QueryResultAdapter;", "extras", "Landroidx/room/solver/TypeAdapterExtras;", "extrasCreator", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "findQueryResultBinder", "Landroidx/room/solver/query/result/QueryResultBinder;", "findRowAdapter", "Landroidx/room/solver/query/result/RowAdapter;", "columnName", "", "findStatementValueBinder", "Landroidx/room/solver/types/StatementValueBinder;", "input", "findUpsertAdapter", "findUpsertMethodBinder", "getAllColumnAdapters", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TypeAdapterStore {
    public static final Companion Companion = null;
    private final BuiltInConverterFlags builtInConverterFlags;
    private final List<ColumnTypeAdapter> columnTypeAdapters;
    private final Context context;
    private final List<DeleteOrUpdateMethodBinderProvider> deleteOrUpdateBinderProvider;
    private final List<InsertOrUpsertMethodBinderProvider> insertBinderProviders;
    private final List<PreparedQueryResultBinderProvider> preparedQueryResultBinderProviders;
    private final List<QueryResultBinderProvider> queryResultBinderProviders;
    private final TypeConverterStore typeConverterStore;
    private final List<InsertOrUpsertMethodBinderProvider> upsertBinderProviders;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J/\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f\"\u00020\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/room/solver/TypeAdapterStore$Companion;", "", "()V", "copy", "Landroidx/room/solver/TypeAdapterStore;", "context", "Landroidx/room/processor/Context;", "store", "create", "builtInConverterFlags", "Landroidx/room/vo/BuiltInConverterFlags;", "extras", "", "(Landroidx/room/processor/Context;Landroidx/room/vo/BuiltInConverterFlags;[Ljava/lang/Object;)Landroidx/room/solver/TypeAdapterStore;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static final void create$addAny(ArrayList<TypeConverter> r5, ArrayList<ColumnTypeAdapter> r10, Object r11) {
            if ((r11 instanceof TypeConverter) == false) goto L6;
            r5.add(r11);
            return;
        L6:
            if ((r11 instanceof ColumnTypeAdapter) == false) goto L9;
            r10.add(r11);
            return;
        L9:
            if ((r11 instanceof List) == false) goto L16;
            Iterator r12 = ((Iterable) r11).iterator();
        L12:
            if (r12.hasNext() == false) goto L19;
            create$addAny(r5, r10, r12.next());
            goto L12
        L19:
            return;
        L16:
            throw new IllegalArgumentException("unknown extra " + r11);
        }

        private static final void create$addColumnAdapter(ArrayList<ColumnTypeAdapter> r5, ColumnTypeAdapter r10) {
            r5.add(r10);
        }

        private static final void create$addTypeConverter(ArrayList<TypeConverter> r5, TypeConverter r10) {
            r5.add(r10);
        }

        public final TypeAdapterStore copy(Context r10, TypeAdapterStore r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "store");
            return new TypeAdapterStore(r10, TypeAdapterStore.access$getColumnTypeAdapters$p(r11), r11.getTypeConverterStore$room_compiler(), TypeAdapterStore.access$getBuiltInConverterFlags$p(r11), null);
        }

        public final TypeAdapterStore create(Context r10, BuiltInConverterFlags r11, Object... r12) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "builtInConverterFlags");
            Intrinsics.checkNotNullParameter(r12, "extras");
            ArrayList r5 = new ArrayList();
            ArrayList r13 = new ArrayList();
            int r14 = r12.length;
            int r15 = 0;
        L3:
            if (r15 >= r14) goto L5;
            create$addAny(r13, r5, r12[r15]);
            r15 = r15 + 1;
            goto L3
        L5:
            List<PrimitiveColumnTypeAdapter> r16 = PrimitiveColumnTypeAdapter.Companion.createPrimitiveAdapters(r10.getProcessingEnv());
            Iterator<T> r17 = r16.iterator();
        L7:
            if (r17.hasNext() == false) goto L9;
            create$addColumnAdapter(r5, (ColumnTypeAdapter) r17.next());
            goto L7
        L9:
            Iterator<T> r18 = BoxedPrimitiveColumnTypeAdapter.Companion.createBoxedPrimitiveAdapters(r16).iterator();
        L11:
            if (r18.hasNext() == false) goto L13;
            create$addColumnAdapter(r5, (ColumnTypeAdapter) r18.next());
            goto L11
        L13:
            Iterator<T> r19 = StringColumnTypeAdapter.Companion.create(r10.getProcessingEnv()).iterator();
        L15:
            if (r19.hasNext() == false) goto L17;
            create$addColumnAdapter(r5, (ColumnTypeAdapter) r19.next());
            goto L15
        L17:
            Iterator<T> r20 = ByteArrayColumnTypeAdapter.Companion.create(r10.getProcessingEnv()).iterator();
        L19:
            if (r20.hasNext() == false) goto L21;
            create$addColumnAdapter(r5, (ColumnTypeAdapter) r20.next());
            goto L19
        L21:
            Iterator<T> r21 = ByteBufferColumnTypeAdapter.Companion.create(r10.getProcessingEnv()).iterator();
        L23:
            if (r21.hasNext() == false) goto L25;
            create$addColumnAdapter(r5, (ColumnTypeAdapter) r21.next());
            goto L23
        L25:
            Iterator<T> r22 = PrimitiveBooleanToIntConverter.INSTANCE.create(r10.getProcessingEnv()).iterator();
        L27:
            if (r22.hasNext() == false) goto L29;
            create$addTypeConverter(r13, (TypeConverter) r22.next());
            goto L27
        L29:
            Iterator<T> r23 = BoxedBooleanToBoxedIntConverter.INSTANCE.create(r10.getProcessingEnv()).iterator();
        L31:
            if (r23.hasNext() == false) goto L33;
            create$addTypeConverter(r13, (TypeConverter) r23.next());
            goto L31
        L33:
            TypeConverterStore.Companion r24 = TypeConverterStore.Companion;
            ArrayList r25 = new ArrayList(CollectionsKt.h(r5));
            Iterator r26 = r5.iterator();
        L35:
            if (r26.hasNext() == false) goto L38;
            r25.add(((ColumnTypeAdapter) r26.next()).getOut());
            goto L35
        L38:
            return new TypeAdapterStore(r10, r5, r24.create(r10, r13, r25), r11, null);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ TypeAdapterStore(Context r5, List r10, TypeConverterStore r11, BuiltInConverterFlags r12, DefaultConstructorMarker r13) {
        this(r5, r10, r11, r12);
    }

    public static final /* synthetic */ BuiltInConverterFlags access$getBuiltInConverterFlags$p(TypeAdapterStore r5) {
        return r5.builtInConverterFlags;
    }

    public static final /* synthetic */ List access$getColumnTypeAdapters$p(TypeAdapterStore r5) {
        return r5.columnTypeAdapters;
    }

    private final ColumnTypeAdapter createDefaultTypeAdapter(XType r5) {
        XTypeElement r10 = r5.getTypeElement();
        if (BuiltInConverterFlagsKt.isEnabled(this.builtInConverterFlags.getEnums()) == false) goto L9;
        if (r10 == null) goto L9;
        if (XEnumTypeElementKt.isEnum(r10) != true) goto L9;
        return new EnumColumnTypeAdapter((XEnumTypeElement) r10);
    L9:
        if (BuiltInConverterFlagsKt.isEnabled(this.builtInConverterFlags.getUuid()) == true) goto L11;
    L13:
        return null;
    L11:
        if (Xtype_extKt.isUUID(r5) == false) goto L13;
        return new UuidColumnTypeAdapter(r5);
    }

    private static final ColumnTypeAdapter findColumnTypeAdapter$findTypeConverterAdapter$6(SQLTypeAffinity r5, TypeAdapterStore r10, XType r11) {
        if (r5 == null) goto L5;
        List<XType> r12 = r5.getTypeMirrors(r10.context.getProcessingEnv());
    L6:
        TypeConverter r13 = r10.typeConverterStore.findConverterIntoStatement(r11, r12);
        if (r13 != null) goto L9;
        return null;
    L9:
        TypeConverter r14 = r10.typeConverterStore.reverse(r13);
        if (r14 != null) goto L15;
        r14 = r10.typeConverterStore.findTypeConverter(r13.getTo(), r11);
        if (r14 != null) goto L15;
        return null;
    L15:
        return new CompositeAdapter(r11, (ColumnTypeAdapter) CollectionsKt.first(r10.getAllColumnAdapters(r13.getTo())), r13, r14);
    L5:
        r12 = null;
        goto L6
    }

    private static final ColumnTypeAdapter findCursorValueReader$findTypeConverterAdapter$5(SQLTypeAffinity r5, TypeAdapterStore r10, XType r11) {
        if (r5 == null) goto L5;
        List<XType> r12 = r5.getTypeMirrors(r10.context.getProcessingEnv());
    L6:
        TypeConverter r13 = r10.typeConverterStore.findConverterFromCursor(r12, r11);
        if (r13 != null) goto L10;
        return null;
    L10:
        return new CompositeAdapter(r11, (ColumnTypeAdapter) CollectionsKt.first(r10.getAllColumnAdapters(r13.getFrom())), null, r13);
    L5:
        r12 = null;
        goto L6
    }

    private final ColumnTypeAdapter findDirectAdapterFor(XType r5, SQLTypeAffinity r10) {
        Iterator<T> r11 = getAllColumnAdapters(r5).iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Object r12 = r11.next();
        ColumnTypeAdapter r13 = (ColumnTypeAdapter) r12;
        if (r10 == null) goto L12;
        if (r13.getTypeAffinity() != r10) goto L4;
    L12:
        return (ColumnTypeAdapter) r12;
    L10:
        r12 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QueryResultAdapter findQueryResultAdapter$default(TypeAdapterStore r5, XType r10, ParsedQuery r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = AnonymousClass1.INSTANCE;
    L6:
        return r5.findQueryResultAdapter(r10, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QueryResultBinder findQueryResultBinder$default(TypeAdapterStore r5, XType r10, ParsedQuery r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = C01401.INSTANCE;
    L6:
        return r5.findQueryResultBinder(r10, r11, r12);
    }

    public static /* synthetic */ RowAdapter findRowAdapter$default(TypeAdapterStore r5, XType r10, ParsedQuery r11, String r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = null;
    L6:
        return r5.findRowAdapter(r10, r11, r12);
    }

    private static final ColumnTypeAdapter findStatementValueBinder$findTypeConverterAdapter(SQLTypeAffinity r5, TypeAdapterStore r10, XType r11) {
        if (r5 == null) goto L5;
        List<XType> r12 = r5.getTypeMirrors(r10.context.getProcessingEnv());
    L6:
        TypeConverter r13 = r10.typeConverterStore.findConverterIntoStatement(r11, r12);
        if (r13 != null) goto L9;
        return null;
    L9:
        ColumnTypeAdapter r14 = (ColumnTypeAdapter) CollectionsKt.firstOrNull(r10.getAllColumnAdapters(r13.getTo()));
        if (r14 != null) goto L13;
        return null;
    L13:
        return new CompositeAdapter(r11, r14, r13, null);
    L5:
        r12 = null;
        goto L6
    }

    private final List<ColumnTypeAdapter> getAllColumnAdapters(XType r5) {
        List<ColumnTypeAdapter> r10 = this.columnTypeAdapters;
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if (r5.isSameType(((ColumnTypeAdapter) r13).getOut()) == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        return r11;
    }

    public final ColumnTypeAdapter findColumnTypeAdapter(XType r5, SQLTypeAffinity r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "out");
        if (r5.isError() == false) goto L5;
        return null;
    L5:
        ColumnTypeAdapter r12 = findDirectAdapterFor(r5, r10);
        if (r12 == null) goto L8;
        return r12;
    L8:
        ColumnTypeAdapter r13 = findColumnTypeAdapter$findTypeConverterAdapter$6(r10, this, r5);
        if (r13 == null) goto L11;
        return r13;
    L11:
        if (r11 == true) goto L15;
        ColumnTypeAdapter r14 = createDefaultTypeAdapter(r5);
        if (r14 == null) goto L15;
        return r14;
    L15:
        return null;
    }

    public final CursorValueReader findCursorValueReader(XType r5, SQLTypeAffinity r10) {
        Intrinsics.checkNotNullParameter(r5, "output");
        if (r5.isError() == false) goto L5;
        return null;
    L5:
        ColumnTypeAdapter r11 = findColumnTypeAdapter(r5, r10, true);
        if (r11 == null) goto L8;
        return r11;
    L8:
        ColumnTypeAdapter r12 = findCursorValueReader$findTypeConverterAdapter$5(r10, this, r5);
        if (r12 == null) goto L11;
        return r12;
    L11:
        ColumnTypeAdapter r13 = createDefaultTypeAdapter(r5);
        if (r13 == null) goto L14;
        return r13;
    L14:
        return null;
    }

    public final DeleteOrUpdateMethodAdapter findDeleteOrUpdateAdapter(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "typeMirror");
        return DeleteOrUpdateMethodAdapter.Companion.create(r5);
    }

    public final DeleteOrUpdateMethodBinder findDeleteOrUpdateMethodBinder(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "typeMirror");
        Iterator<T> r10 = this.deleteOrUpdateBinderProvider.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        DeleteOrUpdateMethodBinderProvider r11 = (DeleteOrUpdateMethodBinderProvider) r10.next();
        if (r11.matches(r5) == false) goto L4;
        return r11.provide(r5);
    L10:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final InsertOrUpsertMethodAdapter findInsertAdapter(XType r5, List<ShortcutQueryParameter> r10) {
        Intrinsics.checkNotNullParameter(r5, "typeMirror");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        return InsertOrUpsertMethodAdapter.Companion.createInsert(this.context, r5, r10);
    }

    public final InsertOrUpsertMethodBinder findInsertMethodBinder(XType r5, List<ShortcutQueryParameter> r10) {
        Intrinsics.checkNotNullParameter(r5, "typeMirror");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Iterator<T> r11 = this.insertBinderProviders.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        InsertOrUpsertMethodBinderProvider r12 = (InsertOrUpsertMethodBinderProvider) r11.next();
        if (r12.matches(r5) == false) goto L4;
        return r12.provide(r5, r10);
    L10:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final PreparedQueryResultAdapter findPreparedQueryResultAdapter(XType r5, ParsedQuery r10) {
        Intrinsics.checkNotNullParameter(r5, "typeMirror");
        Intrinsics.checkNotNullParameter(r10, "query");
        return PreparedQueryResultAdapter.Companion.create(r5, r10.getType());
    }

    public final PreparedQueryResultBinder findPreparedQueryResultBinder(XType r5, ParsedQuery r10) {
        Intrinsics.checkNotNullParameter(r5, "typeMirror");
        Intrinsics.checkNotNullParameter(r10, "query");
        Iterator<T> r11 = this.preparedQueryResultBinderProviders.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        PreparedQueryResultBinderProvider r12 = (PreparedQueryResultBinderProvider) r11.next();
        if (r12.matches(r5) == false) goto L4;
        return r12.provide(r5, r10);
    L10:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final QueryParameterAdapter findQueryParameterAdapter(XType r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "typeMirror");
        BasicQueryParameterAdapter r11 = null;
        if (this.context.getCOMMON_TYPES().getREADONLY_COLLECTION().getRawType().isAssignableFrom(r5) == false) goto L19;
        StatementValueBinder r12 = findStatementValueBinder(((XType) CollectionsKt.first(r5.getTypeArguments())).extendsBoundOrSelf(), null);
        if (r12 == null) goto L7;
        CollectionQueryParameterAdapter r13 = new CollectionQueryParameterAdapter(r12);
    L8:
        StatementValueBinder r14 = findStatementValueBinder(r5, null);
        if (r14 == null) goto L11;
        r11 = new BasicQueryParameterAdapter(r14);
    L11:
        if (r10 == false) goto L15;
        if (r13 == null) goto L17;
        return r13;
    L17:
        return r11;
    L15:
        if (r11 != null) goto L17;
        return r13;
    L7:
        r13 = null;
        goto L8
    L19:
        if (XTypeKt.isArray(r5) == false) goto L27;
        XArrayType r15 = (XArrayType) r5;
        if (Xtype_extKt.isNotByte(r15.getComponentType()) == false) goto L27;
        StatementValueBinder r16 = findStatementValueBinder(r15.getComponentType(), null);
        if (r16 != null) goto L26;
        return null;
    L26:
        return new ArrayQueryParameterAdapter(r16);
    L27:
        StatementValueBinder r17 = findStatementValueBinder(r5, null);
        if (r17 != null) goto L31;
        return null;
    L31:
        return new BasicQueryParameterAdapter(r17);
    }

    public final QueryResultAdapter findQueryResultAdapter(XType r5, ParsedQuery r10, Function1<? super TypeAdapterExtras, Unit> r11) {
        Intrinsics.checkNotNullParameter(r5, "typeMirror");
        Intrinsics.checkNotNullParameter(r10, "query");
        Intrinsics.checkNotNullParameter(r11, "extrasCreator");
        TypeAdapterExtras r12 = new TypeAdapterExtras();
        r11.invoke(r12);
        return findQueryResultAdapter(r5, r10, r12);
    }

    public final QueryResultBinder findQueryResultBinder(XType r5, ParsedQuery r10, Function1<? super TypeAdapterExtras, Unit> r11) {
        Intrinsics.checkNotNullParameter(r5, "typeMirror");
        Intrinsics.checkNotNullParameter(r10, "query");
        Intrinsics.checkNotNullParameter(r11, "extrasCreator");
        TypeAdapterExtras r12 = new TypeAdapterExtras();
        r11.invoke(r12);
        return findQueryResultBinder(r5, r10, r12);
    }

    public final RowAdapter findRowAdapter(final XType r11, final ParsedQuery r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "typeMirror");
        Intrinsics.checkNotNullParameter(r12, "query");
        if (r11.isError() == false) goto L5;
        return null;
    L5:
        final XTypeElement r5 = r11.getTypeElement();
        if (r5 != null) goto L8;
    L89:
        if (r13 == null) goto L109;
        QueryResultInfo r14 = r12.getResultInfo();
        if (r14 == null) goto L104;
        List<ColumnInfo> r15 = r14.getColumns();
        if (r15 == null) goto L104;
        Iterator<T> r16 = r15.iterator();
    L96:
        if (r16.hasNext() == false) goto L100;
        Object r10 = r16.next();
        if (Intrinsics.areEqual(((ColumnInfo) r10).getName(), r13) == false) goto L96;
    L101:
        ColumnInfo r17 = (ColumnInfo) r10;
        if (r17 == null) goto L104;
        SQLTypeAffinity r18 = r17.getType();
    L105:
        CursorValueReader r19 = findCursorValueReader(r11, r18);
        if (r19 == null) goto L109;
        return new SingleNamedColumnRowAdapter(r19, r13);
    L100:
        r10 = null;
    L104:
        r18 = null;
    L109:
        CursorValueReader r110 = findCursorValueReader(r11, null);
        if (r110 != null) goto L113;
        return null;
    L113:
        return new SingleColumnRowAdapter(r110);
    L8:
        if (r11.getTypeName().k() == true) goto L89;
        if (r11.getTypeArguments().isEmpty() == true) goto L12;
        return null;
    L12:
        final QueryResultInfo r20 = r12.getResultInfo();
        if (r20 != null) goto L15;
    L19:
        Pair r21 = new Pair(null, null);
    L20:
        PojoRowAdapter r22 = (PojoRowAdapter) r21.component1();
        RLog.CollectingMessager r23 = (RLog.CollectingMessager) r21.component2();
        if (r22 != null) goto L29;
        if (r12.getResultInfo() != null) goto L29;
        if (Xelement_extKt.isEntityElement(r5) == false) goto L29;
        return new EntityRowAdapter(EntityProcessorKt.EntityProcessor$default(this.context, r5, null, 4, null).process());
    L29:
        if (r22 == null) goto L37;
        if (r23 != null) goto L32;
    L34:
        if (r23 == null) goto L36;
        RLog.CollectingMessager.writeTo$default(r23, this.context, null, 2, null);
    L36:
        return r22;
    L32:
        if (r23.hasErrors() != true) goto L34;
    L37:
        if (r13 == null) goto L57;
        QueryResultInfo r24 = r12.getResultInfo();
        if (r24 == null) goto L52;
        List<ColumnInfo> r25 = r24.getColumns();
        if (r25 == null) goto L52;
        Iterator<T> r26 = r25.iterator();
    L44:
        if (r26.hasNext() == false) goto L48;
        Object r27 = r26.next();
        if (Intrinsics.areEqual(((ColumnInfo) r27).getName(), r13) == false) goto L44;
    L49:
        ColumnInfo r28 = (ColumnInfo) r27;
        if (r28 == null) goto L52;
        SQLTypeAffinity r29 = r28.getType();
    L53:
        CursorValueReader r30 = findCursorValueReader(r11, r29);
        if (r30 == null) goto L57;
        return new SingleNamedColumnRowAdapter(r30, r13);
    L48:
        r27 = null;
    L52:
        r29 = null;
    L57:
        if (r20 == null) goto L61;
        List<ColumnInfo> r111 = r20.getColumns();
        if (r111 == null) goto L61;
        int r112 = r111.size();
    L62:
        if (r112 != 1) goto L74;
        if (r20 == null) goto L69;
        List<ColumnInfo> r113 = r20.getColumns();
        if (r113 == null) goto L69;
        ColumnInfo r114 = r113.get(0);
        if (r114 == null) goto L69;
        SQLTypeAffinity r115 = r114.getType();
    L70:
        CursorValueReader r116 = findCursorValueReader(r11, r115);
        if (r116 == null) goto L74;
        return new SingleColumnRowAdapter(r116);
    L69:
        r115 = null;
    L74:
        if (r22 == null) goto L79;
        if (r23 == null) goto L77;
        RLog.CollectingMessager.writeTo$default(r23, this.context, null, 2, null);
    L77:
        return r22;
    L79:
        if (r12.getResultInfo() == null) goto L81;
    L88:
        return null;
    L81:
        if (Xtype_extKt.isNotVoid(r11) == false) goto L88;
        if (Xtype_extKt.isNotVoidObject(r11) == false) goto L88;
        if (Xtype_extKt.isNotKotlinUnit(r11) == false) goto L88;
        return new PojoRowAdapter(this.context, null, r12, PojoProcessor.Companion.createFor$default(PojoProcessor.Companion, this.context, r5, FieldProcessor.BindingScope.READ_FROM_CURSOR, null, null, 16, null).process(), r11);
    L61:
        r112 = 1;
        goto L62
    L15:
        if (r12.getErrors().isEmpty() == false) goto L19;
        if (r20.getError() != null) goto L19;
        r21 = this.context.collectLogs(new C01411(r5, r20, r12, r11));
        goto L20
    }

    public final StatementValueBinder findStatementValueBinder(XType r5, SQLTypeAffinity r10) {
        Intrinsics.checkNotNullParameter(r5, "input");
        if (r5.isError() == false) goto L5;
        return null;
    L5:
        ColumnTypeAdapter r11 = findDirectAdapterFor(r5, r10);
        if (r11 == null) goto L8;
        return r11;
    L8:
        ColumnTypeAdapter r12 = findStatementValueBinder$findTypeConverterAdapter(r10, this, r5);
        if (r12 == null) goto L11;
        return r12;
    L11:
        ColumnTypeAdapter r13 = createDefaultTypeAdapter(r5);
        if (r13 == null) goto L14;
        return r13;
    L14:
        return null;
    }

    public final InsertOrUpsertMethodAdapter findUpsertAdapter(XType r5, List<ShortcutQueryParameter> r10) {
        Intrinsics.checkNotNullParameter(r5, "typeMirror");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        return InsertOrUpsertMethodAdapter.Companion.createUpsert(this.context, r5, r10);
    }

    public final InsertOrUpsertMethodBinder findUpsertMethodBinder(XType r5, List<ShortcutQueryParameter> r10) {
        Intrinsics.checkNotNullParameter(r5, "typeMirror");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Iterator<T> r11 = this.upsertBinderProviders.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        InsertOrUpsertMethodBinderProvider r12 = (InsertOrUpsertMethodBinderProvider) r11.next();
        if (r12.matches(r5) == false) goto L4;
        return r12.provide(r5, r10);
    L10:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<DeleteOrUpdateMethodBinderProvider> getDeleteOrUpdateBinderProvider() {
        return this.deleteOrUpdateBinderProvider;
    }

    public final List<InsertOrUpsertMethodBinderProvider> getInsertBinderProviders() {
        return this.insertBinderProviders;
    }

    public final List<PreparedQueryResultBinderProvider> getPreparedQueryResultBinderProviders() {
        return this.preparedQueryResultBinderProviders;
    }

    public final List<QueryResultBinderProvider> getQueryResultBinderProviders() {
        return this.queryResultBinderProviders;
    }

    public final TypeConverterStore getTypeConverterStore$room_compiler() {
        return this.typeConverterStore;
    }

    public final List<InsertOrUpsertMethodBinderProvider> getUpsertBinderProviders() {
        return this.upsertBinderProviders;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeAdapterStore(Context r5, List<? extends ColumnTypeAdapter> r10, TypeConverterStore r11, BuiltInConverterFlags r12) {
        this.context = r5;
        this.columnTypeAdapters = r10;
        this.typeConverterStore = r11;
        this.builtInConverterFlags = r12;
        ArrayList r13 = new ArrayList();
        r13.add(new CursorQueryResultBinderProvider(r5));
        r13.add(new LiveDataQueryResultBinderProvider(r5));
        r13.add(GuavaListenableFutureQueryResultBinderProviderKt.GuavaListenableFutureQueryResultBinderProvider(r5));
        r13.addAll(RxQueryResultBinderProvider.Companion.getAll(r5));
        r13.addAll(RxCallableQueryResultBinderProvider.Companion.getAll(r5));
        r13.add(new DataSourceQueryResultBinderProvider(r5));
        r13.add(new DataSourceFactoryQueryResultBinderProvider(r5));
        r13.add(RxJava2PagingSourceQueryResultBinderProviderKt.RxJava2PagingSourceQueryResultBinderProvider(r5));
        r13.add(RxJava3PagingSourceQueryResultBinderProviderKt.RxJava3PagingSourceQueryResultBinderProvider(r5));
        r13.add(ListenableFuturePagingSourceQueryResultBinderProviderKt.ListenableFuturePagingSourceQueryResultBinderProvider(r5));
        r13.add(PagingSourceQueryResultBinderProviderKt.PagingSourceQueryResultBinderProvider(r5));
        r13.add(CoroutineFlowResultBinderProviderKt.CoroutineFlowResultBinderProvider(r5));
        r13.add(new InstantQueryResultBinderProvider(r5));
        this.queryResultBinderProviders = r13;
        ArrayList r14 = new ArrayList();
        r14.addAll(RxPreparedQueryResultBinderProvider.Companion.getAll(r5));
        r14.add(new GuavaListenableFuturePreparedQueryResultBinderProvider(r5));
        r14.add(new InstantPreparedQueryResultBinderProvider(r5));
        this.preparedQueryResultBinderProviders = r14;
        ArrayList r15 = new ArrayList();
        r15.addAll(RxCallableInsertMethodBinderProvider.Companion.getAll(r5));
        r15.add(new GuavaListenableFutureInsertMethodBinderProvider(r5));
        r15.add(new InstantInsertMethodBinderProvider(r5));
        this.insertBinderProviders = r15;
        ArrayList r16 = new ArrayList();
        r16.addAll(RxCallableDeleteOrUpdateMethodBinderProvider.Companion.getAll(r5));
        r16.add(new GuavaListenableFutureDeleteOrUpdateMethodBinderProvider(r5));
        r16.add(new InstantDeleteOrUpdateMethodBinderProvider(r5));
        this.deleteOrUpdateBinderProvider = r16;
        ArrayList r17 = new ArrayList();
        r17.addAll(RxCallableUpsertMethodBinderProvider.Companion.getAll(r5));
        r17.add(new GuavaListenableFutureUpsertMethodBinderProvider(r5));
        r17.add(new InstantUpsertMethodBinderProvider(r5));
        this.upsertBinderProviders = r17;
    }

    public final QueryResultAdapter findQueryResultAdapter(XType r22, ParsedQuery r23, TypeAdapterExtras r24) {
        Intrinsics.checkNotNullParameter(r22, "typeMirror");
        Intrinsics.checkNotNullParameter(r23, "query");
        Intrinsics.checkNotNullParameter(r24, "extras");
        if (r22.isError() == false) goto L6;
        return null;
    L6:
        if (XTypeKt.isArray(r22) == false) goto L15;
        XArrayType r10 = (XArrayType) r22;
        if (Xtype_extKt.isNotByte(r10.getComponentType()) == false) goto L15;
        RowAdapter r5 = findRowAdapter$default(this, r10.getComponentType(), r23, null, 4, null);
        if (r5 != null) goto L13;
        return null;
    L13:
        return new ArrayQueryResultAdapter(r5);
    L15:
        if (r22.getTypeArguments().isEmpty() == false) goto L22;
        RowAdapter r11 = findRowAdapter$default(this, r22, r23, null, 4, null);
        if (r11 != null) goto L20;
        return null;
    L20:
        return new SingleEntityQueryResultAdapter(r11);
    L22:
        if (Intrinsics.areEqual(r22.getRawType().getTypeName(), GuavaBaseTypeNames.INSTANCE.getOPTIONAL()) == false) goto L29;
        XType r12 = (XType) CollectionsKt.first(r22.getTypeArguments());
        RowAdapter r13 = findRowAdapter$default(this, r12.makeNullable(), r23, null, 4, null);
        if (r13 != null) goto L27;
        return null;
    L27:
        return new GuavaOptionalQueryResultAdapter(r12, new SingleEntityQueryResultAdapter(r13));
    L29:
        if (Intrinsics.areEqual(r22.getRawType().getTypeName(), CommonTypeNames.INSTANCE.getOPTIONAL()) == false) goto L36;
        XType r14 = (XType) CollectionsKt.first(r22.getTypeArguments());
        RowAdapter r15 = findRowAdapter$default(this, r14.makeNullable(), r23, null, 4, null);
        if (r15 != null) goto L34;
        return null;
    L34:
        return new OptionalQueryResultAdapter(r14, new SingleEntityQueryResultAdapter(r15));
    L36:
        if (r22.isTypeOf(Reflection.getOrCreateKotlinClass(ImmutableList.class)) == false) goto L43;
        XType r16 = ((XType) CollectionsKt.first(r22.getTypeArguments())).extendsBoundOrSelf();
        RowAdapter r17 = findRowAdapter$default(this, r16, r23, null, 4, null);
        if (r17 != null) goto L41;
        return null;
    L41:
        return new ImmutableListQueryResultAdapter(r16, r17);
    L43:
        if (r22.isTypeOf(Reflection.getOrCreateKotlinClass(List.class)) == false) goto L50;
        XType r18 = ((XType) CollectionsKt.first(r22.getTypeArguments())).extendsBoundOrSelf();
        RowAdapter r19 = findRowAdapter$default(this, r18, r23, null, 4, null);
        if (r19 != null) goto L48;
        return null;
    L48:
        return new ListQueryResultAdapter(r18, r19);
    L50:
        if (r22.isTypeOf(Reflection.getOrCreateKotlinClass(ImmutableMap.class)) == false) goto L57;
        XType r20 = r22.getTypeArguments().get(0).extendsBoundOrSelf();
        XType r21 = r22.getTypeArguments().get(1).extendsBoundOrSelf();
        QueryResultAdapter r25 = findQueryResultAdapter(this.context.getProcessingEnv().getDeclaredType(this.context.getProcessingEnv().requireTypeElement(Reflection.getOrCreateKotlinClass(Map.class)), new XType[]{r20, r21}), r23, r24);
        if (r25 != null) goto L55;
        return null;
    L55:
        return new ImmutableMapQueryResultAdapter(this.context, r23, r20, r21, r25);
    L57:
        if (r22.isTypeOf(Reflection.getOrCreateKotlinClass(ImmutableSetMultimap.class)) == false) goto L59;
    L159:
        XType r26 = r22.getTypeArguments().get(0).extendsBoundOrSelf();
        XType r27 = r22.getTypeArguments().get(1).extendsBoundOrSelf();
        if (r27.getTypeElement() != null) goto L164;
        this.context.getLogger().e("Guava multimap 'value' type argument does not represent a class. Found " + r27 + ".", new Object[0]);
        return null;
    L164:
        if (r22.isTypeOf(Reflection.getOrCreateKotlinClass(ImmutableListMultimap.class)) == false) goto L168;
        e r28 = e.n(ImmutableListMultimap.class);
    L166:
        e r29 = r28;
        MapInfo r110 = (MapInfo) r24.getData(Reflection.getOrCreateKotlinClass(MapInfo.class));
        if (r110 == null) goto L173;
        String r30 = r110.getKeyColumnName();
    L174:
        RowAdapter r31 = findRowAdapter(r26, r23, r30);
        if (r31 != null) goto L177;
        return null;
    L177:
        if (r110 == null) goto L179;
        String r32 = r110.getValueColumnName();
    L180:
        RowAdapter r33 = findRowAdapter(r27, r23, r32);
        if (r33 != null) goto L183;
        return null;
    L183:
        MultimapQueryResultAdapter.Companion.validateMapTypeArgs(r26, r27, findCursorValueReader(r26, null), findCursorValueReader(r27, null), r110, this.context.getLogger());
        Context r34 = this.context;
        if ((r31 instanceof QueryMappedRowAdapter) == true) goto L187;
        r31 = null;
    L187:
        QueryMappedRowAdapter r111 = (QueryMappedRowAdapter) r31;
        if (r111 != null) goto L191;
        return null;
    L191:
        if ((r33 instanceof QueryMappedRowAdapter) == true) goto L194;
        r33 = null;
    L194:
        QueryMappedRowAdapter r112 = (QueryMappedRowAdapter) r33;
        if (r112 != null) goto L198;
        return null;
    L198:
        return new GuavaImmutableMultimapQueryResultAdapter(r34, r23, r26, r27, r111, r112, r29);
    L179:
        r32 = null;
        goto L180
    L173:
        r30 = null;
        goto L174
    L168:
        if (r22.isTypeOf(Reflection.getOrCreateKotlinClass(ImmutableSetMultimap.class)) == false) goto L199;
        r28 = e.n(ImmutableSetMultimap.class);
        goto L166
    L199:
        this.context.getLogger().e(ProcessorErrors.INSTANCE.getDO_NOT_USE_GENERIC_IMMUTABLE_MULTIMAP(), new Object[0]);
        return null;
    L59:
        if (r22.isTypeOf(Reflection.getOrCreateKotlinClass(ImmutableListMultimap.class)) == true) goto L159;
        if (r22.isTypeOf(Reflection.getOrCreateKotlinClass(ImmutableMultimap.class)) == true) goto L159;
        if (r22.isTypeOf(Reflection.getOrCreateKotlinClass(Map.class)) == true) goto L71;
        x r35 = r22.getRawType().getTypeName();
        CollectionTypeNames r36 = CollectionTypeNames.INSTANCE;
        if (Intrinsics.areEqual(r35, r36.getARRAY_MAP()) == true) goto L71;
        if (Intrinsics.areEqual(r22.getRawType().getTypeName(), r36.getLONG_SPARSE_ARRAY()) == true) goto L71;
        if (Intrinsics.areEqual(r22.getRawType().getTypeName(), r36.getINT_SPARSE_ARRAY()) == true) goto L71;
    L100:
        return null;
    L71:
        x r37 = r22.getRawType().getTypeName();
        CollectionTypeNames r38 = CollectionTypeNames.INSTANCE;
        if (Intrinsics.areEqual(r37, r38.getLONG_SPARSE_ARRAY()) == false) goto L75;
        XType r39 = this.context.getProcessingEnv().requireType(x.f15024i);
    L79:
        if (Intrinsics.areEqual(r22.getRawType().getTypeName(), r38.getLONG_SPARSE_ARRAY()) == false) goto L82;
        e r113 = r38.getLONG_SPARSE_ARRAY();
    L85:
        if (r113 == null) goto L87;
        XType r40 = r22.getTypeArguments().get(0).extendsBoundOrSelf();
    L89:
        if (r40.getTypeElement() != null) goto L92;
        this.context.getLogger().e("Multimap 'value' collection type argument does not represent a class. Found " + r40 + ".", new Object[0]);
        return null;
    L92:
        MapInfo r114 = (MapInfo) r24.getData(Reflection.getOrCreateKotlinClass(MapInfo.class));
        if (this.context.getCOMMON_TYPES().getREADONLY_COLLECTION().getRawType().isAssignableFrom(r40.getRawType()) == true) goto L95;
        XType r115 = r40;
        if (r114 == null) goto L133;
        String r41 = r114.getKeyColumnName();
    L134:
        RowAdapter r42 = findRowAdapter(r39, r23, r41);
        if (r42 != null) goto L137;
        return null;
    L137:
        if (r114 == null) goto L139;
        String r43 = r114.getValueColumnName();
    L140:
        RowAdapter r44 = findRowAdapter(r115, r23, r43);
        if (r44 != null) goto L143;
        return null;
    L143:
        MultimapQueryResultAdapter.Companion.validateMapTypeArgs(r39, r115, findCursorValueReader(r39, null), findCursorValueReader(r115, null), r114, this.context.getLogger());
        Context r45 = this.context;
        if ((r42 instanceof QueryMappedRowAdapter) == true) goto L147;
        r42 = null;
    L147:
        QueryMappedRowAdapter r46 = (QueryMappedRowAdapter) r42;
        if (r46 != null) goto L151;
        return null;
    L151:
        if ((r44 instanceof QueryMappedRowAdapter) == true) goto L154;
        r44 = null;
    L154:
        QueryMappedRowAdapter r116 = (QueryMappedRowAdapter) r44;
        if (r116 != null) goto L158;
        return null;
    L158:
        return new MapQueryResultAdapter(r45, r23, r39, r115, r46, r116, null, Intrinsics.areEqual(r22.getRawType().getTypeName(), r38.getARRAY_MAP()), r113);
    L139:
        r43 = null;
        goto L140
    L133:
        r41 = null;
        goto L134
    L95:
        if (r40.isTypeOf(Reflection.getOrCreateKotlinClass(List.class)) == false) goto L97;
    L101:
        XType r47 = ((XType) CollectionsKt.single(r40.getTypeArguments())).extendsBoundOrSelf();
        if (r114 == null) goto L104;
        String r48 = r114.getKeyColumnName();
    L105:
        RowAdapter r49 = findRowAdapter(r39, r23, r48);
        if (r49 != null) goto L108;
        return null;
    L108:
        if (r114 == null) goto L110;
        String r50 = r114.getValueColumnName();
    L111:
        RowAdapter r51 = findRowAdapter(r47, r23, r50);
        if (r51 != null) goto L114;
        return null;
    L114:
        MultimapQueryResultAdapter.Companion.validateMapTypeArgs(r39, r47, findCursorValueReader(r39, null), findCursorValueReader(r47, null), r114, this.context.getLogger());
        Context r117 = this.context;
        if ((r49 instanceof QueryMappedRowAdapter) == true) goto L118;
        r49 = null;
    L118:
        QueryMappedRowAdapter r118 = (QueryMappedRowAdapter) r49;
        if (r118 != null) goto L122;
        return null;
    L122:
        if ((r51 instanceof QueryMappedRowAdapter) == true) goto L125;
        r51 = null;
    L125:
        QueryMappedRowAdapter r52 = (QueryMappedRowAdapter) r51;
        if (r52 != null) goto L129;
        return null;
    L129:
        return new MapQueryResultAdapter(r117, r23, r39, r47, r118, r52, r40, Intrinsics.areEqual(r22.getRawType().getTypeName(), r38.getARRAY_MAP()), r113);
    L110:
        r50 = null;
        goto L111
    L104:
        r48 = null;
        goto L105
    L97:
        if (r40.isTypeOf(Reflection.getOrCreateKotlinClass(Set.class)) == true) goto L101;
        this.context.getLogger().e(ProcessorErrors.INSTANCE.valueCollectionMustBeListOrSet(r40.getTypeName()), new Object[0]);
        goto L100
    L87:
        r40 = r22.getTypeArguments().get(1).extendsBoundOrSelf();
        goto L89
    L82:
        if (Intrinsics.areEqual(r22.getRawType().getTypeName(), r38.getINT_SPARSE_ARRAY()) == false) goto L84;
        r113 = r38.getINT_SPARSE_ARRAY();
        goto L85
    L84:
        r113 = null;
        goto L85
    L75:
        if (Intrinsics.areEqual(r22.getRawType().getTypeName(), r38.getINT_SPARSE_ARRAY()) == false) goto L77;
        r39 = this.context.getProcessingEnv().requireType(x.f15023h);
        goto L79
    L77:
        r39 = r22.getTypeArguments().get(0).extendsBoundOrSelf();
        goto L79
    }

    public final QueryResultBinder findQueryResultBinder(XType r5, ParsedQuery r10, TypeAdapterExtras r11) {
        Intrinsics.checkNotNullParameter(r5, "typeMirror");
        Intrinsics.checkNotNullParameter(r10, "query");
        Intrinsics.checkNotNullParameter(r11, "extras");
        Iterator<T> r12 = this.queryResultBinderProviders.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        QueryResultBinderProvider r13 = (QueryResultBinderProvider) r12.next();
        if (r13.matches(r5) == false) goto L4;
        return r13.provide(r5, r10, r11);
    L10:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}

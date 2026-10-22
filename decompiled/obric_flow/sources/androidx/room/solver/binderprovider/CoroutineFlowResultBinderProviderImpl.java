package androidx.room.solver.binderprovider;

import androidx.room.compiler.processing.XType;
import androidx.room.ext.KotlinTypeNames;
import androidx.room.parser.ParsedQuery;
import androidx.room.parser.Table;
import androidx.room.processor.Context;
import androidx.room.processor.ProcessorErrors;
import androidx.room.solver.QueryResultBinderProvider;
import androidx.room.solver.TypeAdapterExtras;
import androidx.room.solver.query.result.CoroutineFlowResultBinder;
import androidx.room.solver.query.result.QueryResultAdapter;
import androidx.room.solver.query.result.QueryResultBinder;
import com.squareup.javapoet.e;
import com.squareup.javapoet.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Landroidx/room/solver/binderprovider/CoroutineFlowResultBinderProviderImpl;", "Landroidx/room/solver/QueryResultBinderProvider;", "context", "Landroidx/room/processor/Context;", "(Landroidx/room/processor/Context;)V", "getContext", "()Landroidx/room/processor/Context;", "matches", "", "declared", "Landroidx/room/compiler/processing/XType;", "provide", "Landroidx/room/solver/query/result/QueryResultBinder;", "query", "Landroidx/room/parser/ParsedQuery;", "extras", "Landroidx/room/solver/TypeAdapterExtras;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class CoroutineFlowResultBinderProviderImpl implements QueryResultBinderProvider {
    private static final List<e> CHANNEL_TYPE_NAMES = null;
    public static final Companion Companion = null;
    private final Context context;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R%\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/room/solver/binderprovider/CoroutineFlowResultBinderProviderImpl$Companion;", "", "<init>", "()V", "", "Lcom/squareup/javapoet/e;", "kotlin.jvm.PlatformType", "CHANNEL_TYPE_NAMES", "Ljava/util/List;", "getCHANNEL_TYPE_NAMES", "()Ljava/util/List;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final List<e> getCHANNEL_TYPE_NAMES() {
            return CoroutineFlowResultBinderProviderImpl.access$getCHANNEL_TYPE_NAMES$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        KotlinTypeNames r5 = KotlinTypeNames.INSTANCE;
        CHANNEL_TYPE_NAMES = CollectionsKt.listOf(new e[]{r5.getCHANNEL(), r5.getSEND_CHANNEL(), r5.getRECEIVE_CHANNEL()});
    }

    public CoroutineFlowResultBinderProviderImpl(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.context = r5;
    }

    public static final /* synthetic */ List access$getCHANNEL_TYPE_NAMES$cp() {
        return CHANNEL_TYPE_NAMES;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // androidx.room.solver.QueryResultBinderProvider
    public boolean matches(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        if (r5.getTypeArguments().size() == 1) goto L5;
        return false;
    L5:
        x r10 = r5.getRawType().getTypeName();
        if (CollectionsKt.contains(CHANNEL_TYPE_NAMES, r10) == false) goto L10;
        this.context.getLogger().e(ProcessorErrors.INSTANCE.invalidChannelType(r10.toString()), new Object[0]);
        return false;
    L10:
        return Intrinsics.areEqual(r10, KotlinTypeNames.INSTANCE.getFLOW());
    }

    @Override // androidx.room.solver.QueryResultBinderProvider
    public QueryResultBinder provide(XType r5, ParsedQuery r10, TypeAdapterExtras r11) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        Intrinsics.checkNotNullParameter(r10, "query");
        Intrinsics.checkNotNullParameter(r11, "extras");
        XType r12 = (XType) CollectionsKt.first(r5.getTypeArguments());
        QueryResultAdapter r13 = this.context.getTypeAdapterStore().findQueryResultAdapter(r12, r10, r11);
        if (r13 == null) goto L6;
        List<String> r14 = r13.accessedTableNames();
        if (r14 == null) goto L6;
    L7:
        Set<Table> r15 = r10.getTables();
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator<T> r17 = r15.iterator();
    L9:
        if (r17.hasNext() == false) goto L11;
        r16.add(((Table) r17.next()).getName());
        goto L9
    L11:
        Set r18 = CollectionsKt.toSet(CollectionsKt.plus(r14, r16));
        if (r18.isEmpty() == false) goto L15;
        this.context.getLogger().e(ProcessorErrors.INSTANCE.getOBSERVABLE_QUERY_NOTHING_TO_OBSERVE(), new Object[0]);
    L15:
        return new CoroutineFlowResultBinder(r12, r18, r13);
    L6:
        r14 = CollectionsKt.emptyList();
        goto L7
    }
}

package androidx.room.vo;

import ai.j0;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.CollectionTypeNames;
import androidx.room.ext.CommonTypeNames;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.String_extKt;
import androidx.room.parser.ParsedQuery;
import androidx.room.parser.SQLTypeAffinity;
import androidx.room.parser.SqlParser;
import androidx.room.processor.Context;
import androidx.room.processor.ProcessorErrors;
import androidx.room.solver.CodeGenScope;
import androidx.room.solver.TypeAdapterStore;
import androidx.room.solver.query.parameter.QueryParameterAdapter;
import androidx.room.solver.query.result.RowAdapter;
import androidx.room.solver.query.result.SingleColumnRowAdapter;
import androidx.room.solver.types.CursorValueReader;
import androidx.room.verifier.ColumnInfo;
import androidx.room.verifier.DatabaseVerificationErrors;
import androidx.room.verifier.DatabaseVerifier;
import androidx.room.verifier.QueryResultInfo;
import androidx.room.writer.QueryWriter;
import androidx.room.writer.RelationCollectorMethodWriter;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import com.squareup.javapoet.t;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import java.nio.ByteBuffer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u001e\b\u0086\b\u0018\u0000 ^2\u00020\u0001:\u0002^_BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 J7\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b#\u0010$J\u0015\u0010%\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b%\u0010\u0019JF\u0010+\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0016\u001a\u00020\u00152\u001d\u0010*\u001a\u0019\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00170'¢\u0006\u0002\b)¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b5\u00104J\u0010\u00106\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b:\u0010;J\u0010\u0010<\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b<\u0010=Jj\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b@\u0010AJ\u0010\u0010C\u001a\u00020BHÖ\u0001¢\u0006\u0004\bC\u0010DJ\u001a\u0010F\u001a\u00020\u00112\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bF\u0010GR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010H\u001a\u0004\bI\u0010.R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010J\u001a\u0004\bK\u00100R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010L\u001a\u0004\bM\u00102R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010N\u001a\u0004\bO\u00104R\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010N\u001a\u0004\bP\u00104R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010Q\u001a\u0004\bR\u00107R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010S\u001a\u0004\bT\u00109R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010U\u001a\u0004\bV\u0010;R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010W\u001a\u0004\bX\u0010=R\"\u0010Y\u001a\u00020\u001a8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010A\"\u0004\b\\\u0010]¨\u0006`"}, d2 = {"Landroidx/room/vo/RelationCollector;", "", "Landroidx/room/vo/Relation;", "relation", "Landroidx/room/parser/SQLTypeAffinity;", "affinity", "Lcom/squareup/javapoet/v;", "mapTypeName", "Lcom/squareup/javapoet/x;", "keyTypeName", "relationTypeName", "Landroidx/room/writer/QueryWriter;", "queryWriter", "Landroidx/room/solver/query/result/RowAdapter;", "rowAdapter", "Landroidx/room/parser/ParsedQuery;", "loadAllQuery", "", "relationTypeIsCollection", "<init>", "(Landroidx/room/vo/Relation;Landroidx/room/parser/SQLTypeAffinity;Lcom/squareup/javapoet/v;Lcom/squareup/javapoet/x;Lcom/squareup/javapoet/x;Landroidx/room/writer/QueryWriter;Landroidx/room/solver/query/result/RowAdapter;Landroidx/room/parser/ParsedQuery;Z)V", "Landroidx/room/solver/CodeGenScope;", "scope", "", "writeInitCode", "(Landroidx/room/solver/CodeGenScope;)V", "", "cursorVarName", "", "Landroidx/room/vo/FieldWithIndex;", "fieldsWithIndices", "writeReadParentKeyCode", "(Ljava/lang/String;Ljava/util/List;Landroidx/room/solver/CodeGenScope;)V", "Lkotlin/Pair;", "Landroidx/room/vo/Field;", "writeReadCollectionIntoTmpVar", "(Ljava/lang/String;Ljava/util/List;Landroidx/room/solver/CodeGenScope;)Lkotlin/Pair;", "writeCollectionCode", "indexVar", "Lkotlin/Function2;", "Lcom/squareup/javapoet/g;", "Lkotlin/ExtensionFunctionType;", "postRead", "readKey", "(Ljava/lang/String;Ljava/lang/String;Landroidx/room/solver/CodeGenScope;Lkotlin/jvm/functions/Function2;)V", "component1", "()Landroidx/room/vo/Relation;", "component2", "()Landroidx/room/parser/SQLTypeAffinity;", "component3", "()Lcom/squareup/javapoet/v;", "component4", "()Lcom/squareup/javapoet/x;", "component5", "component6", "()Landroidx/room/writer/QueryWriter;", "component7", "()Landroidx/room/solver/query/result/RowAdapter;", "component8", "()Landroidx/room/parser/ParsedQuery;", "component9", "()Z", "copy", "(Landroidx/room/vo/Relation;Landroidx/room/parser/SQLTypeAffinity;Lcom/squareup/javapoet/v;Lcom/squareup/javapoet/x;Lcom/squareup/javapoet/x;Landroidx/room/writer/QueryWriter;Landroidx/room/solver/query/result/RowAdapter;Landroidx/room/parser/ParsedQuery;Z)Landroidx/room/vo/RelationCollector;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/room/vo/Relation;", "getRelation", "Landroidx/room/parser/SQLTypeAffinity;", "getAffinity", "Lcom/squareup/javapoet/v;", "getMapTypeName", "Lcom/squareup/javapoet/x;", "getKeyTypeName", "getRelationTypeName", "Landroidx/room/writer/QueryWriter;", "getQueryWriter", "Landroidx/room/solver/query/result/RowAdapter;", "getRowAdapter", "Landroidx/room/parser/ParsedQuery;", "getLoadAllQuery", "Z", "getRelationTypeIsCollection", "varName", "Ljava/lang/String;", "getVarName", "setVarName", "(Ljava/lang/String;)V", "Companion", "LongSparseArrayKeyQueryParameterAdapter", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RelationCollector {
    public static final Companion Companion = null;
    private static final LongSparseArrayKeyQueryParameterAdapter LONG_SPARSE_ARRAY_KEY_QUERY_PARAM_ADAPTER = null;
    private final SQLTypeAffinity affinity;
    private final x keyTypeName;
    private final ParsedQuery loadAllQuery;
    private final v mapTypeName;
    private final QueryWriter queryWriter;
    private final Relation relation;
    private final boolean relationTypeIsCollection;
    private final x relationTypeName;
    private final RowAdapter rowAdapter;
    public String varName;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000f\u001a\u0016\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001d2\u0006\u0010\u001c\u001a\u00020\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d¢\u0006\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Landroidx/room/vo/RelationCollector$Companion;", "", "<init>", "()V", "Landroidx/room/processor/Context;", "context", "Landroidx/room/vo/Relation;", "relation", "Landroidx/room/parser/SQLTypeAffinity;", "affinityFor", "(Landroidx/room/processor/Context;Landroidx/room/vo/Relation;)Landroidx/room/parser/SQLTypeAffinity;", "Lkotlin/Pair;", "Lcom/squareup/javapoet/x;", "kotlin.jvm.PlatformType", "", "relationTypeFor", "(Landroidx/room/vo/Relation;)Lkotlin/Pair;", "affinity", "keyType", "relationTypeName", "Lcom/squareup/javapoet/v;", "temporaryMapTypeFor", "(Landroidx/room/processor/Context;Landroidx/room/parser/SQLTypeAffinity;Lcom/squareup/javapoet/x;Lcom/squareup/javapoet/x;)Lcom/squareup/javapoet/v;", "Landroidx/room/compiler/processing/XType;", "keyTypeMirrorFor", "(Landroidx/room/processor/Context;Landroidx/room/parser/SQLTypeAffinity;)Landroidx/room/compiler/processing/XType;", "keyTypeFor", "(Landroidx/room/processor/Context;Landroidx/room/parser/SQLTypeAffinity;)Lcom/squareup/javapoet/x;", "baseContext", "", "relations", "Landroidx/room/vo/RelationCollector;", "createCollectors", "(Landroidx/room/processor/Context;Ljava/util/List;)Ljava/util/List;", "Landroidx/room/vo/RelationCollector$LongSparseArrayKeyQueryParameterAdapter;", "LONG_SPARSE_ARRAY_KEY_QUERY_PARAM_ADAPTER", "Landroidx/room/vo/RelationCollector$LongSparseArrayKeyQueryParameterAdapter;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r5 = new int[SQLTypeAffinity.values().length];
                r5[SQLTypeAffinity.INTEGER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r5[SQLTypeAffinity.REAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r5[SQLTypeAffinity.TEXT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r5[SQLTypeAffinity.BLOB.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                $EnumSwitchMapping$0 = r5;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private final SQLTypeAffinity affinityFor(final Context r5, final Relation r10) {
            CursorValueReader r11 = r10.getParentField().getCursorValueReader();
            final SQLTypeAffinity r12 = null;
            if (r11 == null) goto L5;
            final SQLTypeAffinity r13 = r11.affinity();
        L6:
            CursorValueReader r14 = r10.getEntityField().getCursorValueReader();
            if (r14 == null) goto L9;
            final SQLTypeAffinity r15 = r14.affinity();
        L10:
            Junction r16 = r10.getJunction();
            if (r16 == null) goto L17;
            Field r17 = r16.getParentField();
            if (r17 == null) goto L17;
            CursorValueReader r18 = r17.getCursorValueReader();
            if (r18 == null) goto L17;
            final SQLTypeAffinity r19 = r18.affinity();
        L18:
            Junction r20 = r10.getJunction();
            if (r20 == null) goto L26;
            Field r21 = r20.getEntityField();
            if (r21 == null) goto L26;
            CursorValueReader r22 = r21.getCursorValueReader();
            if (r22 == null) goto L26;
            r12 = r22.affinity();
        L26:
            if (r10.getJunction() == null) goto L29;
            affinityFor$checkAffinity(r15, r12, new RelationCollector$Companion$affinityFor$1(r5, r10, r15, r12));
            return affinityFor$checkAffinity(r13, r19, new RelationCollector$Companion$affinityFor$2(r5, r10, r13, r19));
        L29:
            return affinityFor$checkAffinity(r13, r15, new RelationCollector$Companion$affinityFor$3(r5, r10, r13, r15));
        L17:
            r19 = null;
            goto L18
        L9:
            r15 = null;
            goto L10
        L5:
            r13 = null;
            goto L6
        }

        private static final SQLTypeAffinity affinityFor$checkAffinity(SQLTypeAffinity r5, SQLTypeAffinity r10, Function0<Unit> r11) {
            if (r5 == null) goto L5;
            if (r5 != r10) goto L5;
            return r5;
        L5:
            r11.invoke();
            return SQLTypeAffinity.TEXT;
        }

        private static final RowAdapter createCollectors$lambda$0$getDefaultRowAdapter(Context r10, Relation r11, ParsedQuery r12) {
            return TypeAdapterStore.findRowAdapter$default(r10.getTypeAdapterStore(), r11.getPojoType(), r12, null, 4, null);
        }

        private final x keyTypeFor(Context r5, SQLTypeAffinity r10) {
            int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
            if (r11 == 1) goto L15;
            if (r11 == 2) goto L19;
            if (r11 == 3) goto L18;
            if (r11 == 4) goto L17;
            return r5.getCOMMON_TYPES().getSTRING().getTypeName();
        L17:
            return x.e(ByteBuffer.class);
        L18:
            return x.e(String.class);
        L19:
            return x.f15027l.b();
        L15:
            return x.f15024i.b();
        }

        private final XType keyTypeMirrorFor(Context r5, SQLTypeAffinity r10) {
            XProcessingEnv r11 = r5.getProcessingEnv();
            int r12 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
            if (r12 == 1) goto L15;
            if (r12 == 2) goto L19;
            if (r12 == 3) goto L18;
            if (r12 == 4) goto L17;
            return r5.getCOMMON_TYPES().getSTRING();
        L17:
            return r11.requireType("java.nio.ByteBuffer");
        L18:
            return r5.getCOMMON_TYPES().getSTRING();
        L19:
            return r11.requireType("java.lang.Double");
        L15:
            return r11.requireType("java.lang.Long");
        }

        private final Pair<x, Boolean> relationTypeFor(Relation r5) {
            if ((XTypeNameKt.toJavaPoet(r5.getField().getTypeName()) instanceof v) == false) goto L13;
            x r10 = XTypeNameKt.toJavaPoet(r5.getField().getTypeName());
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.squareup.javapoet.ParameterizedTypeName");
            v r11 = (v) r10;
            e r12 = r11.f15021x;
            CommonTypeNames r13 = CommonTypeNames.INSTANCE;
            if (Intrinsics.areEqual(r12, r13.getLIST()) == false) goto L8;
            v r14 = v.n(e.n(ArrayList.class), new x[]{r5.getPojoTypeName()});
        L14:
            return TuplesKt.to(r14, Boolean.TRUE);
        L8:
            if (Intrinsics.areEqual(r11.f15021x, r13.getSET()) == false) goto L10;
            r14 = v.n(e.n(HashSet.class), new x[]{r5.getPojoTypeName()});
            goto L14
        L10:
            r14 = v.n(e.n(ArrayList.class), new x[]{r5.getPojoTypeName()});
            goto L14
        L13:
            return TuplesKt.to(r5.getPojoTypeName(), Boolean.FALSE);
        }

        private final v temporaryMapTypeFor(Context r5, SQLTypeAffinity r10, x r11, x r12) {
            XProcessingEnv r13 = r5.getProcessingEnv();
            CollectionTypeNames r14 = CollectionTypeNames.INSTANCE;
            boolean r15 = false;
            if (r13.findTypeElement(r14.getLONG_SPARSE_ARRAY()) == null) goto L5;
            boolean r16 = true;
        L7:
            if (r5.getProcessingEnv().findTypeElement(r14.getARRAY_MAP()) == null) goto L9;
            r15 = true;
        L9:
            if (r16 == true) goto L11;
        L13:
            if (r15 == false) goto L16;
            return v.n(r14.getARRAY_MAP(), new x[]{r11, r12});
        L16:
            return v.n(e.n(HashMap.class), new x[]{r11, r12});
        L11:
            if (r10 != SQLTypeAffinity.INTEGER) goto L13;
            return v.n(r14.getLONG_SPARSE_ARRAY(), new x[]{r12});
        L5:
            r16 = false;
            goto L7
        }

        public final List<RelationCollector> createCollectors(Context r26, List<Relation> r27) {
            Context r5 = r26;
            Intrinsics.checkNotNullParameter(r5, "baseContext");
            Intrinsics.checkNotNullParameter(r27, "relations");
            ArrayList r10 = new ArrayList(CollectionsKt.h(r27));
            Iterator r11 = r27.iterator();
        L4:
            if (r11.hasNext() == false) goto L40;
            Relation r12 = (Relation) r11.next();
            Context r13 = r5.fork(r12.getField().getElement(), SetsKt.setOf(Warning.CURSOR_MISMATCH));
            Companion r14 = RelationCollector.Companion;
            SQLTypeAffinity r15 = r14.affinityFor(r13, r12);
            x r16 = r14.keyTypeFor(r13, r15);
            Pair<x, Boolean> r17 = r14.relationTypeFor(r12);
            x r18 = r17.component1();
            boolean r19 = r17.component2().booleanValue();
            v r20 = r14.temporaryMapTypeFor(r13, r15, r16, r18);
            String r110 = r12.createLoadAllSql();
            ParsedQuery r111 = SqlParser.Companion.parse(r110);
            ArrayList r112 = r10;
            Iterator r28 = r11;
            r13.getChecker().check(r111.getErrors().isEmpty(), r12.getField().getElement(), CollectionsKt.q(r111.getErrors(), "\n", null, null, 0, null, null, 62), new Object[0]);
            RelationCollector r21 = null;
            if (r111.getErrors().isEmpty() == false) goto L17;
            DatabaseVerifier r22 = r13.getDatabaseVerifier();
            if (r22 == null) goto L10;
            QueryResultInfo r23 = r22.analyze(r110);
        L11:
            r111.setResultInfo(r23);
            if (r23 == null) goto L14;
            SQLException r24 = r23.getError();
        L15:
            if (r24 == null) goto L17;
            r13.getLogger().e(r12.getField().getElement(), DatabaseVerificationErrors.INSTANCE.cannotVerifyQuery(r23.getError()), new Object[0]);
            goto L17
        L14:
            r24 = null;
            goto L15
        L10:
            r23 = null;
        L17:
            QueryResultInfo r25 = r111.getResultInfo();
            e r29 = r20.f15021x;
            CollectionTypeNames r30 = CollectionTypeNames.INSTANCE;
            if (Intrinsics.areEqual(r29, r30.getLONG_SPARSE_ARRAY()) == false) goto L20;
            QueryParameter r31 = new QueryParameter(RelationCollectorMethodWriter.PARAM_MAP_VARIABLE, RelationCollectorMethodWriter.PARAM_MAP_VARIABLE, r13.getProcessingEnv().requireTypeElement(r30.getLONG_SPARSE_ARRAY()).getType(), RelationCollector.access$getLONG_SPARSE_ARRAY_KEY_QUERY_PARAM_ADAPTER$cp());
        L21:
            QueryWriter r113 = new QueryWriter(CollectionsKt.listOf(r31), CollectionsKt.listOf(new Pair(CollectionsKt.first(r111.getBindSections()), r31)), r111);
            if (r12.getProjection().size() != 1) goto L33;
            if (r25 == null) goto L33;
            if (r25.getColumns().size() != 1) goto L27;
        L28:
            CursorValueReader r32 = r13.getTypeAdapterStore().findCursorValueReader(r12.getPojoType(), ((ColumnInfo) CollectionsKt.first(r25.getColumns())).getType());
            if (r32 != null) goto L32;
            RowAdapter r33 = createCollectors$lambda$0$getDefaultRowAdapter(r13, r12, r111);
        L31:
            RowAdapter r114 = r33;
        L34:
            if (r114 != null) goto L37;
            r13.getLogger().e(r12.getField().getElement(), ProcessorErrors.INSTANCE.cannotFindQueryResultAdapter(r12.getPojoType().getTypeName()), new Object[0]);
        L38:
            r112.add(r21);
            r11 = r28;
            r10 = r112;
            r5 = r26;
            goto L4
        L37:
            r21 = new RelationCollector(r12, r15, r20, r16, r18, r113, r114, r111, r19);
            goto L38
        L32:
            r114 = new SingleColumnRowAdapter(r32);
            goto L34
        L27:
            if (r25.getColumns().size() == 2) goto L28;
        L33:
            r33 = createCollectors$lambda$0$getDefaultRowAdapter(r13, r12, r111);
            goto L31
        L20:
            XType r34 = r14.keyTypeMirrorFor(r13, r15);
            XType r35 = r13.getProcessingEnv().getDeclaredType(r13.getProcessingEnv().requireTypeElement("java.util.Set"), new XType[]{r34});
            r31 = new QueryParameter(RelationCollectorMethodWriter.KEY_SET_VARIABLE, RelationCollectorMethodWriter.KEY_SET_VARIABLE, r35, r13.getTypeAdapterStore().findQueryParameterAdapter(r35, true));
            goto L21
        L40:
            return CollectionsKt.m(r10);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Landroidx/room/vo/RelationCollector$LongSparseArrayKeyQueryParameterAdapter;", "Landroidx/room/solver/query/parameter/QueryParameterAdapter;", "()V", "bindToStmt", "", "inputVarName", "", "stmtVarName", "startIndexVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "getArgCount", "outputVarName", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class LongSparseArrayKeyQueryParameterAdapter extends QueryParameterAdapter {
        public LongSparseArrayKeyQueryParameterAdapter() {
            super(true);
        }

        @Override // androidx.room.solver.query.parameter.QueryParameterAdapter
        public void bindToStmt(String r10, String r11, String r12, CodeGenScope r13) {
            Intrinsics.checkNotNullParameter(r10, "inputVarName");
            Intrinsics.checkNotNullParameter(r11, "stmtVarName");
            g r14 = androidx.room.jarjarred.org.antlr.runtime.a.k(r12, "startIndexVarName", "scope", r13);
            String r15 = r13.getTmpVar("_item");
            String r5 = Javapoet_extKt.getL();
            String r16 = Javapoet_extKt.getL();
            String r17 = Javapoet_extKt.getL();
            r14.e(j0.q(androidx.constraintlayout.motion.widget.a.y("for (int ", r5, " = 0; ", r16, " < "), r17, ".size(); i++)"), new Object[]{"i", "i", r10});
            String r18 = Javapoet_extKt.getL();
            String r19 = Javapoet_extKt.getL();
            String r20 = Javapoet_extKt.getL();
            r14.c(j0.q(androidx.constraintlayout.motion.widget.a.y("long ", r18, " = ", r19, ".keyAt("), r20, ")"), new Object[]{r15, r10, "i"});
            StringBuilder r21 = androidx.room.jarjarred.org.antlr.runtime.a.y(Javapoet_extKt.getL(), ".bindLong(", Javapoet_extKt.getL(), ", ", Javapoet_extKt.getL());
            r21.append(")");
            r14.c(r21.toString(), new Object[]{r11, r12, r15});
            r14.c(j0.j(Javapoet_extKt.getL(), " ++"), new Object[]{r12});
            r14.g();
        }

        @Override // androidx.room.solver.query.parameter.QueryParameterAdapter
        public void getArgCount(String r10, String r11, CodeGenScope r12) {
            Intrinsics.checkNotNullParameter(r10, "inputVarName");
            g r5 = androidx.room.jarjarred.org.antlr.runtime.a.k(r11, "outputVarName", "scope", r12);
            String r13 = Javapoet_extKt.getT();
            String r14 = Javapoet_extKt.getL();
            String r15 = Javapoet_extKt.getL();
            r5.c(j0.q(androidx.constraintlayout.motion.widget.a.y("final ", r13, " ", r14, " = "), r15, ".size()"), new Object[]{x.f15023h, r11, r10});
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[SQLTypeAffinity.values().length];
            r5[SQLTypeAffinity.INTEGER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r5[SQLTypeAffinity.REAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r5[SQLTypeAffinity.TEXT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r5[SQLTypeAffinity.BLOB.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r5;
        }
    }

    static {
        Companion = new Companion(null);
        LONG_SPARSE_ARRAY_KEY_QUERY_PARAM_ADAPTER = new LongSparseArrayKeyQueryParameterAdapter();
    }

    public RelationCollector(Relation r5, SQLTypeAffinity r10, v r11, x r12, x r13, QueryWriter r14, RowAdapter r15, ParsedQuery r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r5, "relation");
        Intrinsics.checkNotNullParameter(r10, "affinity");
        Intrinsics.checkNotNullParameter(r11, "mapTypeName");
        Intrinsics.checkNotNullParameter(r12, "keyTypeName");
        Intrinsics.checkNotNullParameter(r13, "relationTypeName");
        Intrinsics.checkNotNullParameter(r14, "queryWriter");
        Intrinsics.checkNotNullParameter(r15, "rowAdapter");
        Intrinsics.checkNotNullParameter(r16, "loadAllQuery");
        this.relation = r5;
        this.affinity = r10;
        this.mapTypeName = r11;
        this.keyTypeName = r12;
        this.relationTypeName = r13;
        this.queryWriter = r14;
        this.rowAdapter = r15;
        this.loadAllQuery = r16;
        this.relationTypeIsCollection = r17;
    }

    public static final /* synthetic */ LongSparseArrayKeyQueryParameterAdapter access$getLONG_SPARSE_ARRAY_KEY_QUERY_PARAM_ADAPTER$cp() {
        return LONG_SPARSE_ARRAY_KEY_QUERY_PARAM_ADAPTER;
    }

    public static /* synthetic */ RelationCollector copy$default(RelationCollector r10, Relation r11, SQLTypeAffinity r12, v r13, x r14, x r15, QueryWriter r16, RowAdapter r17, ParsedQuery r18, boolean r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        Relation r5 = r10.relation;
    L7:
        if ((r20 & 2) == 0) goto L9;
        SQLTypeAffinity r22 = r10.affinity;
    L11:
        if ((r20 & 4) == 0) goto L13;
        v r23 = r10.mapTypeName;
    L15:
        if ((r20 & 8) == 0) goto L17;
        x r24 = r10.keyTypeName;
    L19:
        if ((r20 & 16) == 0) goto L21;
        x r25 = r10.relationTypeName;
    L23:
        if ((r20 & 32) == 0) goto L25;
        QueryWriter r26 = r10.queryWriter;
    L27:
        if ((r20 & 64) == 0) goto L29;
        RowAdapter r27 = r10.rowAdapter;
    L31:
        if ((r20 & 128) == 0) goto L33;
        ParsedQuery r28 = r10.loadAllQuery;
    L35:
        if ((r20 & 256) == 0) goto L37;
        boolean r29 = r10.relationTypeIsCollection;
    L39:
        return r10.copy(r5, r22, r23, r24, r25, r26, r27, r28, r29);
    L37:
        r29 = r19;
        goto L39
    L33:
        r28 = r18;
        goto L35
    L29:
        r27 = r17;
        goto L31
    L25:
        r26 = r16;
        goto L27
    L21:
        r25 = r15;
        goto L23
    L17:
        r24 = r14;
        goto L19
    L13:
        r23 = r13;
        goto L15
    L9:
        r22 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }

    private static final void readKey$lambda$8$addKeyReadStatement(RelationCollector r13, g r14, x r15, String r16, String r17, String r18, String r19, Function2<? super g, ? super String, Unit> r20) {
        if (Intrinsics.areEqual(r13.keyTypeName, x.e(ByteBuffer.class)) == false) goto L6;
        String r5 = Javapoet_extKt.getT();
        String r10 = Javapoet_extKt.getL();
        String r11 = Javapoet_extKt.getT();
        String r12 = Javapoet_extKt.getL();
        String r110 = Javapoet_extKt.getL();
        String r111 = Javapoet_extKt.getL();
        StringBuilder r21 = androidx.constraintlayout.motion.widget.a.y("final ", r5, " ", r10, " = ");
        androidx.constraintlayout.motion.widget.a.C(r21, r11, ".wrap(", r12, ".");
        r14.c(androidx.constraintlayout.motion.widget.a.u(r21, r110, "(", r111, "))"), new Object[]{r15, r16, r13.keyTypeName, r17, r18, r19});
    L7:
        r20.mo2invoke(r14, r16);
        return;
    L6:
        String r22 = Javapoet_extKt.getT();
        String r23 = Javapoet_extKt.getL();
        String r24 = Javapoet_extKt.getL();
        String r25 = Javapoet_extKt.getL();
        String r112 = Javapoet_extKt.getL();
        StringBuilder r26 = androidx.constraintlayout.motion.widget.a.y("final ", r22, " ", r23, " = ");
        androidx.constraintlayout.motion.widget.a.C(r26, r24, ".", r25, "(");
        r14.c(j0.q(r26, r112, ")"), new Object[]{r15, r16, r17, r18, r19});
        goto L7
    }

    public final Relation component1() {
        return this.relation;
    }

    public final SQLTypeAffinity component2() {
        return this.affinity;
    }

    public final v component3() {
        return this.mapTypeName;
    }

    public final x component4() {
        return this.keyTypeName;
    }

    public final x component5() {
        return this.relationTypeName;
    }

    public final QueryWriter component6() {
        return this.queryWriter;
    }

    public final RowAdapter component7() {
        return this.rowAdapter;
    }

    public final ParsedQuery component8() {
        return this.loadAllQuery;
    }

    public final boolean component9() {
        return this.relationTypeIsCollection;
    }

    public final RelationCollector copy(Relation r12, SQLTypeAffinity r13, v r14, x r15, x r16, QueryWriter r17, RowAdapter r18, ParsedQuery r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r12, "relation");
        Intrinsics.checkNotNullParameter(r13, "affinity");
        Intrinsics.checkNotNullParameter(r14, "mapTypeName");
        Intrinsics.checkNotNullParameter(r15, "keyTypeName");
        Intrinsics.checkNotNullParameter(r16, "relationTypeName");
        Intrinsics.checkNotNullParameter(r17, "queryWriter");
        Intrinsics.checkNotNullParameter(r18, "rowAdapter");
        Intrinsics.checkNotNullParameter(r19, "loadAllQuery");
        return new RelationCollector(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RelationCollector) == true) goto L8;
        return false;
    L8:
        RelationCollector r10 = (RelationCollector) r5;
        if (Intrinsics.areEqual(this.relation, r10.relation) == true) goto L12;
        return false;
    L12:
        if (this.affinity == r10.affinity) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.mapTypeName, r10.mapTypeName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.keyTypeName, r10.keyTypeName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.relationTypeName, r10.relationTypeName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.queryWriter, r10.queryWriter) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.rowAdapter, r10.rowAdapter) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.loadAllQuery, r10.loadAllQuery) == true) goto L33;
        return false;
    L33:
        if (this.relationTypeIsCollection == r10.relationTypeIsCollection) goto L35;
        return false;
    L35:
        return true;
    }

    public final SQLTypeAffinity getAffinity() {
        return this.affinity;
    }

    public final x getKeyTypeName() {
        return this.keyTypeName;
    }

    public final ParsedQuery getLoadAllQuery() {
        return this.loadAllQuery;
    }

    public final v getMapTypeName() {
        return this.mapTypeName;
    }

    public final QueryWriter getQueryWriter() {
        return this.queryWriter;
    }

    public final Relation getRelation() {
        return this.relation;
    }

    public final boolean getRelationTypeIsCollection() {
        return this.relationTypeIsCollection;
    }

    public final x getRelationTypeName() {
        return this.relationTypeName;
    }

    public final RowAdapter getRowAdapter() {
        return this.rowAdapter;
    }

    public final String getVarName() {
        String r5 = this.varName;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("varName");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r5 = this.relation.hashCode() * 31;
        int r10 = (this.affinity.hashCode() + r5) * 31;
        int r11 = (this.mapTypeName.hashCode() + r10) * 31;
        int r12 = (this.keyTypeName.hashCode() + r11) * 31;
        int r13 = (this.relationTypeName.hashCode() + r12) * 31;
        int r14 = (this.queryWriter.hashCode() + r13) * 31;
        int r15 = (this.rowAdapter.hashCode() + r14) * 31;
        int r16 = (this.loadAllQuery.hashCode() + r15) * 31;
        boolean r17 = this.relationTypeIsCollection;
        ?? r18 = r17;
        if (r17 == false) goto L6;
        r18 = 1;
    L6:
        return r16 + r18;
    }

    public final void readKey(String r12, String r13, CodeGenScope r14, Function2<? super g, ? super String, Unit> r15) {
        Intrinsics.checkNotNullParameter(r12, "cursorVarName");
        Intrinsics.checkNotNullParameter(r14, "scope");
        Intrinsics.checkNotNullParameter(r15, "postRead");
        SQLTypeAffinity r5 = this.affinity;
        int r10 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r10 != 1) goto L5;
        String r11 = "getLong";
    L10:
        String r16 = r11;
        g r17 = r14.builder();
        if (Intrinsics.areEqual(this.mapTypeName.f15021x, CollectionTypeNames.INSTANCE.getLONG_SPARSE_ARRAY()) == false) goto L18;
        x r18 = this.keyTypeName.m();
    L17:
        x r19 = r18;
        String r20 = r14.getTmpVar("_tmpKey");
        if (this.relation.getParentField().getNonNull() == false) goto L22;
        readKey$lambda$8$addKeyReadStatement(this, r17, r19, r20, r12, r16, r13, r15);
        return;
    L22:
        r17.e(j0.l("if (!", Javapoet_extKt.getL(), ".isNull(", Javapoet_extKt.getL(), "))"), new Object[]{r12, r13});
        readKey$lambda$8$addKeyReadStatement(this, r17, r19, r20, r12, r16, r13, r15);
        r17.g();
        return;
    L18:
        r18 = this.keyTypeName;
        goto L17
    L5:
        if (r10 == 2) goto L12;
        r11 = "getString";
        if (r10 == 3) goto L10;
        if (r10 != 4) goto L10;
        r11 = "getBlob";
        goto L10
    L12:
        r11 = "getDouble";
        goto L10
    }

    public final void setVarName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.varName = r5;
    }

    public String toString() {
        Relation r5 = this.relation;
        SQLTypeAffinity r10 = this.affinity;
        v r11 = this.mapTypeName;
        x r12 = this.keyTypeName;
        x r13 = this.relationTypeName;
        QueryWriter r14 = this.queryWriter;
        RowAdapter r15 = this.rowAdapter;
        ParsedQuery r16 = this.loadAllQuery;
        boolean r17 = this.relationTypeIsCollection;
        StringBuilder r18 = new StringBuilder("RelationCollector(relation=");
        r18.append(r5);
        r18.append(", affinity=");
        r18.append(r10);
        r18.append(", mapTypeName=");
        r18.append(r11);
        r18.append(", keyTypeName=");
        r18.append(r12);
        r18.append(", relationTypeName=");
        r18.append(r13);
        r18.append(", queryWriter=");
        r18.append(r14);
        r18.append(", rowAdapter=");
        r18.append(r15);
        r18.append(", loadAllQuery=");
        r18.append(r16);
        r18.append(", relationTypeIsCollection=");
        return j0.r(r18, r17, ")");
    }

    public final void writeCollectionCode(CodeGenScope r10) {
        Intrinsics.checkNotNullParameter(r10, "scope");
        t r5 = r10.getWriter().getOrCreateMethod(new RelationCollectorMethodWriter(this));
        r10.builder().c(androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getN(), "(", Javapoet_extKt.getL(), ")"), new Object[]{r5, getVarName()});
    }

    public final void writeInitCode(CodeGenScope r10) {
        Intrinsics.checkNotNullParameter(r10, "scope");
        setVarName(r10.getTmpVar("_collection" + String_extKt.capitalize(String_extKt.stripNonJava(this.relation.getField().getPath()), Locale.US)));
        g r11 = r10.builder();
        String r5 = Javapoet_extKt.getT();
        String r12 = Javapoet_extKt.getL();
        r11.c(j0.q(androidx.constraintlayout.motion.widget.a.y("final ", r5, " ", r12, " = new "), Javapoet_extKt.getT(), "()"), new Object[]{this.mapTypeName, getVarName(), this.mapTypeName});
    }

    public final Pair<String, Field> writeReadCollectionIntoTmpVar(String r10, List<FieldWithIndex> r11, CodeGenScope r12) {
        Intrinsics.checkNotNullParameter(r10, "cursorVarName");
        Intrinsics.checkNotNullParameter(r11, "fieldsWithIndices");
        Intrinsics.checkNotNullParameter(r12, "scope");
        Iterator<T> r13 = r11.iterator();
    L3:
        String r5 = null;
        if (r13.hasNext() == false) goto L8;
        Object r14 = r13.next();
        if (((FieldWithIndex) r14).getField() != this.relation.getParentField()) goto L3;
    L9:
        FieldWithIndex r15 = (FieldWithIndex) r14;
        if (r15 == null) goto L13;
        r5 = r15.getIndexVar();
    L13:
        if (this.relationTypeIsCollection == false) goto L15;
        String r16 = "Collection";
    L16:
        final String r17 = r12.getTmpVar(CodeGenScope.TMP_VAR_DEFAULT_PREFIX + String_extKt.capitalize(String_extKt.stripNonJava(this.relation.getField().getName()), Locale.US) + r16);
        g r18 = r12.builder();
        r18.c(androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getT(), " ", Javapoet_extKt.getL(), " = null"), new Object[]{this.relationTypeName, r17});
        readKey(r10, r5, r12, new RelationCollector$writeReadCollectionIntoTmpVar$1$1(r17, this));
        if (this.relationTypeIsCollection == false) goto L20;
        r18.e(j0.k("if (", Javapoet_extKt.getL(), " == null)"), new Object[]{r17});
        r18.c(androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getL(), " = new ", Javapoet_extKt.getT(), "()"), new Object[]{r17, this.relationTypeName});
        r18.g();
    L20:
        return TuplesKt.to(r17, this.relation.getField());
    L15:
        r16 = "";
        goto L16
    L8:
        r14 = null;
        goto L9
    }

    public final void writeReadParentKeyCode(String r5, List<FieldWithIndex> r10, final CodeGenScope r11) {
        Intrinsics.checkNotNullParameter(r5, "cursorVarName");
        Intrinsics.checkNotNullParameter(r10, "fieldsWithIndices");
        Intrinsics.checkNotNullParameter(r11, "scope");
        Iterator<T> r12 = r10.iterator();
    L3:
        String r13 = null;
        if (r12.hasNext() == false) goto L8;
        Object r14 = r12.next();
        if (((FieldWithIndex) r14).getField() != this.relation.getParentField()) goto L3;
    L9:
        FieldWithIndex r15 = (FieldWithIndex) r14;
        if (r15 == null) goto L12;
        r13 = r15.getIndexVar();
    L12:
        r11.builder();
        readKey(r5, r13, r11, new RelationCollector$writeReadParentKeyCode$1$1(this, r11));
        return;
    L8:
        r14 = null;
        goto L9
    }
}

package androidx.room.writer;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.ext.AndroidTypeNames;
import androidx.room.ext.CollectionTypeNames;
import androidx.room.ext.CommonTypeNames;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.ext.String_extKt;
import androidx.room.solver.CodeGenScope;
import androidx.room.solver.query.result.PojoRowAdapter;
import androidx.room.solver.query.result.RowAdapter;
import androidx.room.vo.Relation;
import androidx.room.vo.RelationCollector;
import com.bytedance.ai.event.MessageIndication;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import com.squareup.javapoet.m;
import com.squareup.javapoet.s;
import com.squareup.javapoet.u;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import java.util.Set;
import javax.lang.model.element.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011¨\u0006\u0013"}, d2 = {"Landroidx/room/writer/RelationCollectorMethodWriter;", "Landroidx/room/writer/TypeWriter$SharedMethodSpec;", "Landroidx/room/vo/RelationCollector;", "collector", "<init>", "(Landroidx/room/vo/RelationCollector;)V", "", "getUniqueKey", "()Ljava/lang/String;", "methodName", "Landroidx/room/writer/TypeWriter;", "writer", "Lcom/squareup/javapoet/s;", "builder", "", MessageIndication.STATUS_PREPARE, "(Ljava/lang/String;Landroidx/room/writer/TypeWriter;Lcom/squareup/javapoet/s;)V", "Landroidx/room/vo/RelationCollector;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RelationCollectorMethodWriter extends TypeWriter.SharedMethodSpec {
    public static final Companion Companion = null;
    public static final String KEY_SET_VARIABLE = "__mapKeySet";
    public static final String PARAM_MAP_VARIABLE = "_map";
    private final RelationCollector collector;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/room/writer/RelationCollectorMethodWriter$Companion;", "", "()V", "KEY_SET_VARIABLE", "", "PARAM_MAP_VARIABLE", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RelationCollectorMethodWriter(RelationCollector r5) {
        Intrinsics.checkNotNullParameter(r5, "collector");
        super(a.p("fetchRelationship", String_extKt.stripNonJava(r5.getRelation().getEntity().getTableName()), "As", String_extKt.stripNonJava(r5.getRelation().getPojoTypeName().toString())));
        this.collector = r5;
    }

    public static final /* synthetic */ RelationCollector access$getCollector$p(RelationCollectorMethodWriter r5) {
        return r5.collector;
    }

    private static final void prepare$lambda$12$addBatchPutAllStatement(g r5, boolean r10, RelationCollectorMethodWriter r11, u r12, String r13) {
        if (r10 == false) goto L5;
        v r14 = v.n(CommonTypeNames.INSTANCE.getMAP(), new x[]{(x) r11.collector.getMapTypeName().f15022y.get(0), (x) r11.collector.getMapTypeName().f15022y.get(1)});
        StringBuilder r15 = androidx.room.jarjarred.org.antlr.runtime.a.y(Javapoet_extKt.getN(), ".putAll((", Javapoet_extKt.getT(), ") ", Javapoet_extKt.getL());
        r15.append(")");
        r5.c(r15.toString(), new Object[]{r12, r14, r13});
        return;
    L5:
        r5.c(androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getN(), ".putAll(", Javapoet_extKt.getL(), ")"), new Object[]{r12, r13});
    }

    @Override // androidx.room.writer.TypeWriter.SharedMethodSpec
    public String getUniqueKey() {
        Relation r5 = this.collector.getRelation();
        return "RelationCollectorMethodWriter-" + this.collector.getMapTypeName() + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + XTypeNameKt.toJavaPoet(r5.getEntity().getTypeName()) + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + r5.getEntityField().getColumnName() + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + r5.getPojoTypeName() + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + r5.createLoadAllSql();
    }

    @Override // androidx.room.writer.TypeWriter.SharedMethodSpec
    public void prepare(String r36, TypeWriter r37, s r38) {
        Intrinsics.checkNotNullParameter(r36, "methodName");
        Intrinsics.checkNotNullParameter(r37, "writer");
        Intrinsics.checkNotNullParameter(r38, "builder");
        CodeGenScope r14 = new CodeGenScope(r37);
        final Relation r5 = this.collector.getRelation();
        jk.a r10 = u.a(this.collector.getMapTypeName(), PARAM_MAP_VARIABLE, new Modifier[0]);
        r10.l(new Modifier[]{Modifier.FINAL});
        final u r11 = r10.n();
        String r12 = r14.getTmpVar("_sql");
        String r13 = r14.getTmpVar("_stmt");
        g r15 = r14.builder();
        e r16 = this.collector.getMapTypeName().f15021x;
        CollectionTypeNames r17 = CollectionTypeNames.INSTANCE;
        boolean r18 = Intrinsics.areEqual(r16, r17.getLONG_SPARSE_ARRAY());
        boolean r19 = Intrinsics.areEqual(this.collector.getMapTypeName().f15021x, r17.getARRAY_MAP());
        String r20 = " ";
        if (r18 == false) goto L6;
        r15.e(j0.k("if (", Javapoet_extKt.getN(), ".isEmpty())"), new Object[]{r11});
    L7:
        r15.c("return", new Object[0]);
        r15.g();
        r15.c("// check if the size is too big, if so divide", new Object[0]);
        String r21 = j0.l("if(", Javapoet_extKt.getN(), ".size() > ", Javapoet_extKt.getT(), ".MAX_BIND_PARAMETER_CNT)");
        RoomTypeNames r22 = RoomTypeNames.INSTANCE;
        r15.e(r21, new Object[]{r11, r22.getROOM_DB()});
        String r23 = r14.getTmpVar("_tmpInnerMap");
        String r110 = Javapoet_extKt.getT();
        String r24 = Javapoet_extKt.getL();
        String r25 = Javapoet_extKt.getT();
        r15.c(a.t(androidx.room.jarjarred.org.antlr.runtime.a.y(r110, " ", r24, " = new ", r25), "(", Javapoet_extKt.getL(), ".MAX_BIND_PARAMETER_CNT)"), new Object[]{this.collector.getMapTypeName(), r23, this.collector.getMapTypeName(), r22.getROOM_DB()});
        String r26 = r14.getTmpVar("_tmpIndex");
        String r27 = androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getT(), " ", Javapoet_extKt.getL(), " = 0");
        x r111 = x.f15023h;
        r15.c(r27, new Object[]{r111, r26});
        if (r18 == true) goto L10;
        if (r19 == true) goto L10;
        String r28 = r14.getTmpVar("_mapKey");
        String r29 = Javapoet_extKt.getT();
        String r112 = "while(";
        String r30 = Javapoet_extKt.getL();
        String r33 = " = 0";
        CodeGenScope r34 = r14;
        r15.e(j0.q(a.y("for(", r29, " ", r30, " : "), Javapoet_extKt.getL(), ")"), new Object[]{this.collector.getKeyTypeName(), r28, KEY_SET_VARIABLE});
        if (this.collector.getRelationTypeIsCollection() == false) goto L14;
        String r31 = Javapoet_extKt.getL();
        String r32 = Javapoet_extKt.getL();
        String r113 = Javapoet_extKt.getN();
        r15.c(a.t(androidx.room.jarjarred.org.antlr.runtime.a.y(r31, ".put(", r32, ", ", r113), ".get(", Javapoet_extKt.getL(), "))"), new Object[]{r23, r28, r11, r28});
    L15:
        String r114 = " = ";
        String r115 = "final ";
        x r210 = r111;
        r20 = " ";
        String r35 = "++";
    L21:
        r15.c(j0.j(Javapoet_extKt.getL(), r35), new Object[]{r26});
        r15.e(j0.l("if(", Javapoet_extKt.getL(), " == ", Javapoet_extKt.getT(), ".MAX_BIND_PARAMETER_CNT)"), new Object[]{r26, r22.getROOM_DB()});
        r15.c(androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getL(), "(", Javapoet_extKt.getL(), ")"), new Object[]{r36, r23});
        if (this.collector.getRelationTypeIsCollection() == true) goto L24;
        boolean r39 = r19;
        prepare$lambda$12$addBatchPutAllStatement(r15, r39, this, r11, r23);
    L25:
        String r211 = r115;
        StringBuilder r116 = androidx.room.jarjarred.org.antlr.runtime.a.y(Javapoet_extKt.getL(), " = new ", Javapoet_extKt.getT(), "(", Javapoet_extKt.getT());
        r116.append(".MAX_BIND_PARAMETER_CNT)");
        r15.c(r116.toString(), new Object[]{r23, this.collector.getMapTypeName(), r22.getROOM_DB()});
        r15.c(j0.j(Javapoet_extKt.getL(), r33), new Object[]{r26});
        r15.g();
        r15.g();
        r15.e(j0.k("if(", Javapoet_extKt.getL(), " > 0)"), new Object[]{r26});
        r15.c(androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getL(), "(", Javapoet_extKt.getL(), ")"), new Object[]{r36, r23});
        if (this.collector.getRelationTypeIsCollection() == true) goto L28;
        prepare$lambda$12$addBatchPutAllStatement(r15, r39, this, r11, r23);
    L28:
        r15.g();
        r15.c("return", new Object[0]);
        r15.g();
        final CodeGenScope r40 = r34;
        this.collector.getQueryWriter().prepareReadAndBind(r12, r13, r40);
        RowAdapter r41 = this.collector.getRowAdapter();
        if ((r41 instanceof PojoRowAdapter) == true) goto L31;
    L33:
        boolean r42 = false;
    L34:
        String r43 = Javapoet_extKt.getT();
        String r44 = Javapoet_extKt.getL();
        String r45 = Javapoet_extKt.getT();
        String r117 = Javapoet_extKt.getN();
        String r118 = Javapoet_extKt.getL();
        String r119 = Javapoet_extKt.getL();
        String r120 = Javapoet_extKt.getL();
        String r46 = r20;
        StringBuilder r47 = a.y(r211, r43, r46, r44, r114);
        a.C(r47, r45, ".query(", r117, ", ");
        a.C(r47, r118, ", ", r119, ", ");
        String r48 = j0.q(r47, r120, ")");
        e r121 = XTypeNameKt.toJavaPoet(AndroidTypeNames.INSTANCE.getCURSOR());
        e r122 = r22.getDB_UTIL();
        m r123 = DaoWriter.Companion.getDbField();
        if (r42 == false) goto L38;
        String r49 = "true";
    L39:
        final String r124 = "_cursor";
        r15.c(r48, new Object[]{r121, "_cursor", r122, r123, r13, r49, "null"});
        r15.e("try", new Object[0]);
        if (r5.getJunction() == null) goto L42;
        int r50 = r5.getProjection().size();
        String r51 = Javapoet_extKt.getT();
        String r52 = Javapoet_extKt.getL();
        r15.c(a.t(a.y(r211, r51, r46, r52, r114), Javapoet_extKt.getL(), "; // _junction.", Javapoet_extKt.getL()), new Object[]{r210, "_itemKeyIndex", Integer.valueOf(r50), r5.getJunction().getParentField().getColumnName()});
    L43:
        r15.e(j0.k("if (", Javapoet_extKt.getL(), " == -1)"), new Object[]{"_itemKeyIndex"});
        r15.c("return", new Object[0]);
        r15.g();
        RowAdapter.onCursorReady$default(this.collector.getRowAdapter(), "_cursor", r40, null, 4, null);
        final String r53 = r40.getTmpVar("_item");
        r15.e(j0.k(r112, Javapoet_extKt.getL(), ".moveToNext())"), new Object[]{"_cursor"});
        this.collector.readKey("_cursor", "_itemKeyIndex", r40, new RelationCollectorMethodWriter$prepare$1$3$2$1(this, r40, r11, r5, r53, r124));
        r15.g();
        r15.h("finally", new Object[0]);
        r15.c(j0.j(Javapoet_extKt.getL(), ".close()"), new Object[]{"_cursor"});
        r15.g();
        r38.l(new Modifier[]{Modifier.PRIVATE});
        r38.m(r11);
        r38.v(x.d);
        r38.j(r40.builder().f());
        return;
    L42:
        String r54 = Javapoet_extKt.getT();
        String r55 = Javapoet_extKt.getL();
        String r56 = Javapoet_extKt.getT();
        String r125 = Javapoet_extKt.getL();
        String r126 = Javapoet_extKt.getS();
        StringBuilder r57 = a.y(r211, r54, r46, r55, r114);
        a.C(r57, r56, ".getColumnIndex(", r125, ", ");
        r15.c(j0.q(r57, r126, ")"), new Object[]{r210, "_itemKeyIndex", r22.getCURSOR_UTIL(), "_cursor", r5.getEntityField().getColumnName()});
        goto L43
    L38:
        r49 = "false";
        goto L39
    L31:
        if (((PojoRowAdapter) r41).getRelationCollectors().isEmpty() == true) goto L33;
        r42 = true;
        goto L34
    L24:
        r39 = r19;
        goto L25
    L14:
        r15.c(androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getL(), ".put(", Javapoet_extKt.getL(), ", null)"), new Object[]{r23, r28});
    L10:
        r34 = r14;
        r33 = " = 0";
        String r58 = r34.getTmpVar("_mapIndex");
        String r59 = r34.getTmpVar("_limit");
        r15.c(androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getT(), " ", Javapoet_extKt.getL(), r33), new Object[]{r111, r58});
        String r60 = Javapoet_extKt.getT();
        String r127 = Javapoet_extKt.getL();
        r114 = " = ";
        r115 = "final ";
        r15.c(j0.q(a.y(r115, r60, " ", r127, r114), Javapoet_extKt.getN(), ".size()"), new Object[]{r111, r59, r11});
        r210 = r111;
        r112 = "while(";
        r15.e(j0.l(r112, Javapoet_extKt.getL(), " < ", Javapoet_extKt.getL(), ")"), new Object[]{r58, r59});
        if (this.collector.getRelationTypeIsCollection() == false) goto L19;
        String r61 = Javapoet_extKt.getL();
        String r62 = Javapoet_extKt.getN();
        String r128 = Javapoet_extKt.getL();
        String r129 = Javapoet_extKt.getN();
        String r63 = Javapoet_extKt.getL();
        StringBuilder r64 = androidx.room.jarjarred.org.antlr.runtime.a.y(r61, ".put(", r62, ".keyAt(", r128);
        a.C(r64, "), ", r129, ".valueAt(", r63);
        r64.append("))");
        r15.c(r64.toString(), new Object[]{r23, r11, r58, r11, r58});
    L20:
        r35 = "++";
        r15.c(j0.j(Javapoet_extKt.getL(), r35), new Object[]{r58});
        goto L21
    L19:
        StringBuilder r65 = androidx.room.jarjarred.org.antlr.runtime.a.y(Javapoet_extKt.getL(), ".put(", Javapoet_extKt.getN(), ".keyAt(", Javapoet_extKt.getL());
        r65.append("), null)");
        r15.c(r65.toString(), new Object[]{r23, r11, r58});
        goto L20
    L6:
        v r66 = v.n(e.n(Set.class), new x[]{this.collector.getKeyTypeName()});
        String r67 = Javapoet_extKt.getT();
        String r68 = Javapoet_extKt.getL();
        r15.c(j0.q(a.y("final ", r67, " ", r68, " = "), Javapoet_extKt.getN(), ".keySet()"), new Object[]{r66, KEY_SET_VARIABLE, r11});
        r15.e(j0.k("if (", Javapoet_extKt.getL(), ".isEmpty())"), new Object[]{KEY_SET_VARIABLE});
        goto L7
    }
}

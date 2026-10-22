package androidx.room.writer;

import ai.j0;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.parser.ParsedQuery;
import androidx.room.parser.Section;
import androidx.room.solver.CodeGenScope;
import androidx.room.solver.query.parameter.QueryParameterAdapter;
import androidx.room.vo.QueryMethod;
import androidx.room.vo.QueryParameter;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import com.squareup.javapoet.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B7\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u001a\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t0\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ0\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\t0\u00062\u0006\u0010\u0018\u001a\u00020\u0019J4\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\t0\u00062\u0006\u0010\u001b\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\t0\u00062\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u001e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R%\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001f"}, d2 = {"Landroidx/room/writer/QueryWriter;", "", "queryMethod", "Landroidx/room/vo/QueryMethod;", "(Landroidx/room/vo/QueryMethod;)V", "parameters", "", "Landroidx/room/vo/QueryParameter;", "sectionToParamMapping", "Lkotlin/Pair;", "Landroidx/room/parser/Section;", "query", "Landroidx/room/parser/ParsedQuery;", "(Ljava/util/List;Ljava/util/List;Landroidx/room/parser/ParsedQuery;)V", "getParameters", "()Ljava/util/List;", "getQuery", "()Landroidx/room/parser/ParsedQuery;", "getSectionToParamMapping", "bindArgs", "", "outArgsName", "", "listSizeVars", "scope", "Landroidx/room/solver/CodeGenScope;", "createSqlQueryAndArgs", "outSqlQueryName", "prepareQuery", "prepareReadAndBind", "outRoomSQLiteQueryVar", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class QueryWriter {
    private final List<QueryParameter> parameters;
    private final ParsedQuery query;
    private final List<Pair<Section, QueryParameter>> sectionToParamMapping;

    /* JADX WARN: Multi-variable type inference failed */
    public QueryWriter(List<QueryParameter> r5, List<? extends Pair<? extends Section, QueryParameter>> r10, ParsedQuery r11) {
        Intrinsics.checkNotNullParameter(r5, "parameters");
        Intrinsics.checkNotNullParameter(r10, "sectionToParamMapping");
        Intrinsics.checkNotNullParameter(r11, "query");
        this.parameters = r5;
        this.sectionToParamMapping = r10;
        this.query = r11;
    }

    private final List<Pair<QueryParameter, String>> createSqlQueryAndArgs(String r27, String r28, CodeGenScope r29) {
        ArrayList r11 = new ArrayList();
        List<QueryParameter> r5 = this.parameters;
        ArrayList r10 = new ArrayList();
        Iterator<T> r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Object r13 = r12.next();
        QueryParameterAdapter r14 = ((QueryParameter) r13).getQueryParamAdapter();
        if (r14 == null) goto L8;
        boolean r15 = r14.isMultiple();
    L9:
        if (r15 == false) goto L4;
        r10.add(r13);
        goto L4
    L8:
        r15 = false;
        goto L9
    L11:
        List<Pair<Section, QueryParameter>> r16 = this.sectionToParamMapping;
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r16.iterator();
    L13:
        if (r18.hasNext() == false) goto L22;
        Object r19 = r18.next();
        QueryParameter r110 = (QueryParameter) ((Pair) r19).getSecond();
        if (r110 == null) goto L19;
        QueryParameterAdapter r111 = r110.getQueryParamAdapter();
        if (r111 == null) goto L19;
        boolean r112 = r111.isMultiple();
    L20:
        if (r112 == true) goto L13;
        r17.add(r19);
    L19:
        r112 = false;
        goto L20
    L22:
        int r20 = r17.size();
        g r113 = r29.builder();
        if (r10.isEmpty() == true) goto L67;
        String r21 = r29.getTmpVar("_stringBuilder");
        StringBuilder r22 = a.y(Javapoet_extKt.getT(), " ", Javapoet_extKt.getL(), " = ", Javapoet_extKt.getT());
        r22.append(".newStringBuilder()");
        r113.c(r22.toString(), new Object[]{e.n(StringBuilder.class), r21, RoomTypeNames.INSTANCE.getSTRING_UTIL()});
        Iterator r23 = this.query.getSections().iterator();
    L26:
        if (r23.hasNext() == false) goto L63;
        Section r24 = (Section) r23.next();
        if ((r24 instanceof Section.Text) == false) goto L31;
        Iterator r26 = r23;
        r113.c(a.q(Javapoet_extKt.getL(), ".append(", Javapoet_extKt.getS(), ")"), new Object[]{r21, r24.getText()});
    L60:
        r23 = r26;
        r16 = r16;
        goto L26
    L31:
        r26 = r23;
        if ((r24 instanceof Section.NewLine) == false) goto L35;
        r113.c(a.q(Javapoet_extKt.getL(), ".append(", Javapoet_extKt.getS(), ")"), new Object[]{r21, "\n"});
        goto L60
    L35:
        if ((r24 instanceof Section.BindVar) == false) goto L62;
        Iterator r25 = r16.iterator();
    L38:
        if (r25.hasNext() == false) goto L43;
        Object r30 = r25.next();
        Iterator r210 = r25;
        if (Intrinsics.areEqual(((Pair) r30).getFirst(), r24) == true) goto L44;
        r25 = r210;
    L44:
        Pair r31 = (Pair) r30;
        if (r31 == null) goto L60;
        QueryParameter r32 = (QueryParameter) r31.getSecond();
        if (r32 == null) goto L51;
        QueryParameterAdapter r33 = r32.getQueryParamAdapter();
        if (r33 == null) goto L51;
        boolean r34 = r33.isMultiple();
    L52:
        if (r34 == false) goto L59;
        String r35 = r29.getTmpVar("_inputSize");
        Object r114 = r31.getSecond();
        Intrinsics.checkNotNull(r114);
        r11.add(new Pair(r114, r35));
        QueryParameter r36 = (QueryParameter) r31.getSecond();
        if (r36 == null) goto L58;
        QueryParameterAdapter r37 = r36.getQueryParamAdapter();
        if (r37 == null) goto L58;
        Object r38 = r31.getSecond();
        Intrinsics.checkNotNull(r38);
        r37.getArgCount(((QueryParameter) r38).getName(), r35, r29);
    L58:
        StringBuilder r39 = a.y(Javapoet_extKt.getT(), ".appendPlaceholders(", Javapoet_extKt.getL(), ", ", Javapoet_extKt.getL());
        r39.append(")");
        r113.c(r39.toString(), new Object[]{RoomTypeNames.INSTANCE.getSTRING_UTIL(), r21, r35});
        goto L60
    L59:
        r113.c(a.q(Javapoet_extKt.getL(), ".append(", Javapoet_extKt.getS(), ")"), new Object[]{r21, "?"});
    L51:
        r34 = false;
        goto L52
    L43:
        r30 = null;
        goto L44
    L62:
        throw new NoWhenBranchMatchedException();
    L63:
        String r40 = Javapoet_extKt.getT();
        String r41 = Javapoet_extKt.getL();
        String r42 = Javapoet_extKt.getL();
        r113.c(j0.q(androidx.constraintlayout.motion.widget.a.y("final ", r40, " ", r41, " = "), r42, ".toString()"), new Object[]{Javapoet_extKt.getTypeName(Reflection.getOrCreateKotlinClass(String.class)), r27, r21});
        if (r28 == null) goto L89;
        String r43 = r29.getTmpVar("_argCount");
        String r44 = Javapoet_extKt.getT();
        String r45 = Javapoet_extKt.getL();
        String r46 = Javapoet_extKt.getL();
        String r47 = Javapoet_extKt.getL();
        r113.c(j0.q(androidx.constraintlayout.motion.widget.a.y("final ", r44, " ", r45, " = "), r46, r47), new Object[]{x.f15023h, r43, Integer.valueOf(r20), CollectionsKt.q(r11, "", null, null, 0, null, QueryWriter$createSqlQueryAndArgs$1$2.INSTANCE, 30)});
        String r48 = Javapoet_extKt.getT();
        String r49 = Javapoet_extKt.getL();
        String r50 = Javapoet_extKt.getT();
        String r51 = Javapoet_extKt.getL();
        String r52 = Javapoet_extKt.getL();
        StringBuilder r53 = androidx.constraintlayout.motion.widget.a.y("final ", r48, " ", r49, " = ");
        androidx.constraintlayout.motion.widget.a.C(r53, r50, ".acquire(", r51, ", ");
        String r54 = j0.q(r53, r52, ")");
        RoomTypeNames r55 = RoomTypeNames.INSTANCE;
        r113.c(r54, new Object[]{r55.getROOM_SQL_QUERY(), r28, r55.getROOM_SQL_QUERY(), r27, r43});
        return r11;
    L89:
        return r11;
    L67:
        String r56 = Javapoet_extKt.getT();
        String r57 = Javapoet_extKt.getL();
        String r58 = Javapoet_extKt.getS();
        StringBuilder r59 = androidx.constraintlayout.motion.widget.a.y("final ", r56, " ", r57, " = ");
        r59.append(r58);
        r113.c(r59.toString(), new Object[]{Javapoet_extKt.getTypeName(Reflection.getOrCreateKotlinClass(String.class)), r27, this.query.getQueryWithReplacedBindParams()});
        if (r28 == null) goto L90;
        String r60 = Javapoet_extKt.getT();
        String r61 = Javapoet_extKt.getL();
        String r62 = Javapoet_extKt.getT();
        String r63 = Javapoet_extKt.getL();
        String r64 = Javapoet_extKt.getL();
        StringBuilder r65 = androidx.constraintlayout.motion.widget.a.y("final ", r60, " ", r61, " = ");
        androidx.constraintlayout.motion.widget.a.C(r65, r62, ".acquire(", r63, ", ");
        String r66 = j0.q(r65, r64, ")");
        RoomTypeNames r67 = RoomTypeNames.INSTANCE;
        r113.c(r66, new Object[]{r67.getROOM_SQL_QUERY(), r28, r67.getROOM_SQL_QUERY(), r27, Integer.valueOf(r20)});
        return r11;
    L90:
        return r11;
    }

    public final void bindArgs(String r23, List<Pair<QueryParameter, String>> r24, CodeGenScope r25) {
        Intrinsics.checkNotNullParameter(r23, "outArgsName");
        Intrinsics.checkNotNullParameter(r24, "listSizeVars");
        Intrinsics.checkNotNullParameter(r25, "scope");
        if (this.parameters.isEmpty() == false) goto L5;
        return;
    L5:
        g r5 = r25.builder();
        String r10 = r25.getTmpVar("_argIndex");
        r5.c(Javapoet_extKt.getT() + " " + Javapoet_extKt.getL() + " = " + Javapoet_extKt.getL(), new Object[]{x.f15023h, r10, 1});
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = this.sectionToParamMapping.iterator();
        int r13 = 0;
    L7:
        if (r12.hasNext() == false) goto L34;
        Pair r17 = (Pair) r12.next();
        if (r13 <= 0) goto L11;
    L12:
        String r15 = a.q(Javapoet_extKt.getL(), " = ", Javapoet_extKt.getL(), Javapoet_extKt.getL());
        if (r13 <= 0) goto L16;
        Object r14 = Integer.valueOf(r13 + 1);
    L17:
        r5.c(r15, new Object[]{r10, r14, CollectionsKt.q(r11, "", null, null, 0, null, QueryWriter$bindArgs$1$1$1.INSTANCE, 30)});
    L18:
        QueryParameter r16 = (QueryParameter) r17.getSecond();
        if (r16 == null) goto L23;
        QueryParameterAdapter r18 = r16.getQueryParamAdapter();
        if (r18 == null) goto L23;
        r18.bindToStmt(r16.getName(), r23, r10, r25);
    L23:
        Iterator<T> r19 = r24.iterator();
    L25:
        if (r19.hasNext() == false) goto L29;
        Object r110 = r19.next();
        if (Intrinsics.areEqual(((Pair) r110).getFirst(), r16) == false) goto L25;
    L30:
        Pair r111 = (Pair) r110;
        if (r111 == null) goto L32;
        r11.add(r111.getSecond());
        goto L7
    L32:
        r13 = r13 + 1;
        goto L7
    L29:
        r110 = null;
        goto L30
    L16:
        r14 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
        goto L17
    L11:
        if (r11.isEmpty() == true) goto L18;
    }

    public final List<QueryParameter> getParameters() {
        return this.parameters;
    }

    public final ParsedQuery getQuery() {
        return this.query;
    }

    public final List<Pair<Section, QueryParameter>> getSectionToParamMapping() {
        return this.sectionToParamMapping;
    }

    public final List<Pair<QueryParameter, String>> prepareQuery(String r5, CodeGenScope r10) {
        Intrinsics.checkNotNullParameter(r5, "outSqlQueryName");
        Intrinsics.checkNotNullParameter(r10, "scope");
        return createSqlQueryAndArgs(r5, null, r10);
    }

    public final void prepareReadAndBind(String r5, String r10, CodeGenScope r11) {
        Intrinsics.checkNotNullParameter(r5, "outSqlQueryName");
        Intrinsics.checkNotNullParameter(r10, "outRoomSQLiteQueryVar");
        Intrinsics.checkNotNullParameter(r11, "scope");
        bindArgs(r10, createSqlQueryAndArgs(r5, r10, r11), r11);
    }

    public QueryWriter(QueryMethod r5) {
        Intrinsics.checkNotNullParameter(r5, "queryMethod");
        this(r5.getParameters(), r5.getSectionToParamMapping(), r5.getQuery());
    }
}

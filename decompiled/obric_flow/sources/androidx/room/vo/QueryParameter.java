package androidx.room.vo;

import androidx.room.compiler.processing.XType;
import androidx.room.solver.query.parameter.QueryParameterAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Landroidx/room/vo/QueryParameter;", "", "name", "", "sqlName", "type", "Landroidx/room/compiler/processing/XType;", "queryParamAdapter", "Landroidx/room/solver/query/parameter/QueryParameterAdapter;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/room/compiler/processing/XType;Landroidx/room/solver/query/parameter/QueryParameterAdapter;)V", "getName", "()Ljava/lang/String;", "getQueryParamAdapter", "()Landroidx/room/solver/query/parameter/QueryParameterAdapter;", "getSqlName", "getType", "()Landroidx/room/compiler/processing/XType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class QueryParameter {
    private final String name;
    private final QueryParameterAdapter queryParamAdapter;
    private final String sqlName;
    private final XType type;

    public QueryParameter(String r5, String r10, XType r11, QueryParameterAdapter r12) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "sqlName");
        Intrinsics.checkNotNullParameter(r11, "type");
        this.name = r5;
        this.sqlName = r10;
        this.type = r11;
        this.queryParamAdapter = r12;
    }

    public static /* synthetic */ QueryParameter copy$default(QueryParameter r5, String r10, String r11, XType r12, QueryParameterAdapter r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.name;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.sqlName;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.type;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r13 = r5.queryParamAdapter;
    L15:
        return r5.copy(r10, r11, r12, r13);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.sqlName;
    }

    public final XType component3() {
        return this.type;
    }

    public final QueryParameterAdapter component4() {
        return this.queryParamAdapter;
    }

    public final QueryParameter copy(String r5, String r10, XType r11, QueryParameterAdapter r12) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "sqlName");
        Intrinsics.checkNotNullParameter(r11, "type");
        return new QueryParameter(r5, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof QueryParameter) == true) goto L8;
        return false;
    L8:
        QueryParameter r10 = (QueryParameter) r5;
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sqlName, r10.sqlName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r10.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.queryParamAdapter, r10.queryParamAdapter) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getName() {
        return this.name;
    }

    public final QueryParameterAdapter getQueryParamAdapter() {
        return this.queryParamAdapter;
    }

    public final String getSqlName() {
        return this.sqlName;
    }

    public final XType getType() {
        return this.type;
    }

    public int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(this.name.hashCode() * 31, 31, this.sqlName);
        int r10 = (this.type.hashCode() + r5) * 31;
        QueryParameterAdapter r11 = this.queryParamAdapter;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public String toString() {
        String r5 = this.name;
        String r10 = this.sqlName;
        XType r11 = this.type;
        QueryParameterAdapter r12 = this.queryParamAdapter;
        StringBuilder r13 = androidx.constraintlayout.motion.widget.a.y("QueryParameter(name=", r5, ", sqlName=", r10, ", type=");
        r13.append(r11);
        r13.append(", queryParamAdapter=");
        r13.append(r12);
        r13.append(")");
        return r13.toString();
    }
}

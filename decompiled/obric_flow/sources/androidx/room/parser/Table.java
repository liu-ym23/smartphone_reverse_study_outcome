package androidx.room.parser;

import ai.j0;
import cn.nubia.neopush.commons.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/room/parser/Table;", "", "name", "", Constant.ALIAS, "(Ljava/lang/String;Ljava/lang/String;)V", "getAlias", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Table {
    private final String alias;
    private final String name;

    public Table(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, Constant.ALIAS);
        this.name = r5;
        this.alias = r10;
    }

    public static /* synthetic */ Table copy$default(Table r5, String r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.name;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.alias;
    L9:
        return r5.copy(r10, r11);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.alias;
    }

    public final Table copy(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, Constant.ALIAS);
        return new Table(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Table) == true) goto L8;
        return false;
    L8:
        Table r10 = (Table) r5;
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.alias, r10.alias) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int r5 = this.name.hashCode() * 31;
        return this.alias.hashCode() + r5;
    }

    public String toString() {
        return j0.l("Table(name=", this.name, ", alias=", this.alias, ")");
    }
}

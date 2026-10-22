package androidx.room.processor;

import androidx.room.Index;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Landroidx/room/processor/IndexInput;", "", "name", "", "unique", "", "columnNames", "", "orders", "Landroidx/room/Index$Order;", "(Ljava/lang/String;ZLjava/util/List;Ljava/util/List;)V", "getColumnNames", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getOrders", "getUnique", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IndexInput {
    private final List<String> columnNames;
    private final String name;
    private final List<Index.Order> orders;
    private final boolean unique;

    /* JADX WARN: Multi-variable type inference failed */
    public IndexInput(String r5, boolean r10, List<String> r11, List<? extends Index.Order> r12) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r11, "columnNames");
        Intrinsics.checkNotNullParameter(r12, "orders");
        this.name = r5;
        this.unique = r10;
        this.columnNames = r11;
        this.orders = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IndexInput copy$default(IndexInput r5, String r10, boolean r11, List r12, List r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.name;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.unique;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.columnNames;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r13 = r5.orders;
    L15:
        return r5.copy(r10, r11, r12, r13);
    }

    public final String component1() {
        return this.name;
    }

    public final boolean component2() {
        return this.unique;
    }

    public final List<String> component3() {
        return this.columnNames;
    }

    public final List<Index.Order> component4() {
        return this.orders;
    }

    public final IndexInput copy(String r5, boolean r10, List<String> r11, List<? extends Index.Order> r12) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r11, "columnNames");
        Intrinsics.checkNotNullParameter(r12, "orders");
        return new IndexInput(r5, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IndexInput) == true) goto L8;
        return false;
    L8:
        IndexInput r10 = (IndexInput) r5;
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L12;
        return false;
    L12:
        if (this.unique == r10.unique) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.columnNames, r10.columnNames) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.orders, r10.orders) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final List<String> getColumnNames() {
        return this.columnNames;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Index.Order> getOrders() {
        return this.orders;
    }

    public final boolean getUnique() {
        return this.unique;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r5 = this.name.hashCode() * 31;
        boolean r10 = this.unique;
        ?? r11 = r10;
        if (r10 == false) goto L5;
        r11 = 1;
    L5:
        int r12 = (r5 + r11) * 31;
        int r13 = androidx.constraintlayout.motion.widget.a.f(this.columnNames, r12, 31);
        return this.orders.hashCode() + r13;
    }

    public String toString() {
        return "IndexInput(name=" + this.name + ", unique=" + this.unique + ", columnNames=" + this.columnNames + ", orders=" + this.orders + ")";
    }
}

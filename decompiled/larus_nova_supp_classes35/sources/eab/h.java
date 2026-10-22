package eab;

import com.ss.android.lark.widget.table.entity.Column;
import com.ss.android.lark.widget.table.entity.HorizontalAlign;
import com.ss.android.lark.widget.table.entity.VerticalAlign;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import v7b.f0;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h extends v7b.a {
    public final String j;
    public final List<Column> k;
    public final List<b> l;

    public static final class a {
        public final int a;
        public final int b;
        public final HorizontalAlign c;
        public final VerticalAlign d;
        public final boolean e;
        public final s f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b) * 31;
            HorizontalAlign r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            VerticalAlign r5 = this.d;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            int r6 = (r4 + r2) * 31;
            if (this.e == false) goto L13;
            int r7 = 1231;
        L15:
            return ((r6 + r7) * 31) + this.f.hashCode();
        L13:
            r7 = 1237;
            goto L15
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "TableCellData(columnSpan=" + this.a + ", rowSpan=" + this.b + ", horizontalAlign=" + this.c + ", verticalAlign=" + this.d + ", isMerged=" + this.e + ", content=" + this.f + ')';
        }

        public a(int r2, int r3, HorizontalAlign r4, VerticalAlign r5, boolean r6, v7b.e r7) {
            Intrinsics.checkNotNullParameter(r7, "content");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public static final class b {
        public final boolean a;
        public final HorizontalAlign b;
        public final VerticalAlign c;
        public final List<a> d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = r0 * 31;
            HorizontalAlign r2 = this.b;
            int r3 = 0;
            if (r2 != null) goto L9;
            int r4 = 0;
        L10:
            int r5 = (r1 + r4) * 31;
            VerticalAlign r6 = this.c;
            if (r6 == null) goto L15;
            r3 = r6.hashCode();
        L15:
            return ((r5 + r3) * 31) + this.d.hashCode();
        L9:
            r4 = r2.hashCode();
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "TableRowData(isHeader=" + this.a + ", horizontalAlign=" + this.b + ", verticalAlign=" + this.c + ", tableCells=" + this.d + ')';
        }

        public b(boolean r2, HorizontalAlign r3, VerticalAlign r4, List<a> r5) {
            Intrinsics.checkNotNullParameter(r5, "tableCells");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.j.hashCode() * 31) + this.k.hashCode()) * 31) + this.l.hashCode();
    }

    @Override // v7b.s
    public final String toString() {
        return "TableNode(id=" + this.j + ", columns=" + this.k + ", tableRows=" + this.l + ')';
    }

    @Override // v7b.s
    public final s h() {
        return new h(this.j, this.k, this.l);
    }

    @Override // v7b.s
    public final void c(f0 r1) {
        if (r1 == null) goto L5;
        r1.a(this);
        return;
    }

    public h(String r2, List<Column> r3, List<b> r4) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "columns");
        Intrinsics.checkNotNullParameter(r4, "tableRows");
        this.j = r2;
        this.k = r3;
        this.l = r4;
    }
}

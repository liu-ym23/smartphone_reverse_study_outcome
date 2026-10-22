package fla;

import android.graphics.drawable.Drawable;
import com.obric.oui.selection.OActionSheet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final OActionSheet.Companion.ItemStyle a;
    public final Drawable b;
    public final String c;
    public final Integer d;
    public final Function1<Integer, Unit> e;

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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Drawable r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.c.hashCode()) * 31;
        Integer r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Function1<Integer, Unit> r8 = this.e;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionSheetItemData(style=" + this.a + ", icon=" + this.b + ", title=" + this.c + ", textColor=" + this.d + ", clickAction=" + this.e + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(OActionSheet.Companion.ItemStyle r2, Drawable r3, String r4, Integer r5, Function1<? super Integer, Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "style");
        Intrinsics.checkNotNullParameter(r4, "title");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public /* synthetic */ a(OActionSheet.Companion.ItemStyle r9, Drawable r10, String r11, Function1 r12, int r13) {
        if ((r13 & 2) == 0) goto L5;
        Drawable r4 = null;
    L7:
        if ((r13 & 16) == 0) goto L9;
        Function1 r7 = null;
    L10:
        this(r9, r4, r11, null, r7);
        return;
    L9:
        r7 = r12;
        goto L10
    L5:
        r4 = r10;
        goto L7
    }
}

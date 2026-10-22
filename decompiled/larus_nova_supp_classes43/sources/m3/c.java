package m3;

import com.bytedance.ai.bridge.method.bottomsheet.DoubaoBottomSheetButtonRole;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public final DoubaoBottomSheetButtonRole a;
    public final String b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "DoubaoBottomSheetButton(role=" + this.a + ", text=" + this.b + ')';
    }

    public c(DoubaoBottomSheetButtonRole r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "role");
        Intrinsics.checkNotNullParameter(r11, "text");
        this.a = r10;
        this.b = r11;
    }
}

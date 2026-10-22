package rob;

import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.SwitchActionItemId;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j {
    public final int a;
    public final String b;
    public final boolean c;
    public final SwitchActionItemId d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.d.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "SwitchActionData(iconRes=" + this.a + ", title=" + this.b + ", checked=" + this.c + ", itemId=" + this.d + ')';
    }

    public j(String r2, boolean r3, SwitchActionItemId r4) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r4, "itemId");
        this.a = 2131255255;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}

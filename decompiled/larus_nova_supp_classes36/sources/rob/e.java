package rob;

import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.IconWithTitleItemId;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public final int a;
    public final String b;
    public final IconWithTitleItemId c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "IconWithTitleData(iconRes=" + this.a + ", title=" + this.b + ", itemId=" + this.c + ')';
    }

    public e(int r2, String r3, IconWithTitleItemId r4) {
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "itemId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}

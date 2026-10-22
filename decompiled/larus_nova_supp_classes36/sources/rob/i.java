package rob;

import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.SendType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i {
    public final SendType a;
    public final String b;
    public final boolean c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
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
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "SendTypeData(sendType=" + this.a + ", title=" + this.b + ", isSelected=" + this.c + ')';
    }

    public i(SendType r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "sendType");
        Intrinsics.checkNotNullParameter(r3, "title");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}

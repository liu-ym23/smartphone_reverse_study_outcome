package v4;

import com.bytedance.ai.debugscene.tag.DebugTagStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final boolean a;
    public final String b;
    public final DebugTagStyle c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "DebugTag(showTag=" + this.a + ", tagText=" + this.b + ", style=" + this.c + ')';
    }

    public /* synthetic */ a() {
        this(false, "", DebugTagStyle.LEGACY_PREVIEW);
    }

    public a(boolean r10, String r11, DebugTagStyle r12) {
        Intrinsics.checkNotNullParameter(r11, "tagText");
        Intrinsics.checkNotNullParameter(r12, "style");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}

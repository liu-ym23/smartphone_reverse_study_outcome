package nb8;

import com.larus.im.bean.message.Message;
import fh8.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m {
    public final fh8.f a;
    public final Message b;
    public final String c;
    public final t.a d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final fh8.d h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        int r2 = 1231;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.f == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.g == true) goto L14;
        r2 = 1237;
    L14:
        int r6 = (r5 + r2) * 31;
        fh8.d r7 = this.h;
        if (r7 != null) goto L17;
        int r8 = 0;
    L19:
        return r6 + r8;
    L17:
        r8 = r7.hashCode();
        goto L19
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeepThinkContentVmData(markdownCommonInputData=" + this.a + ", message=" + this.b + ", thinkingContent=" + this.c + ", renderViewConfig=" + this.d + ", isDeepThinkingTyping=" + this.e + ", forceRefreshDeepThinkingArea=" + this.f + ", forceRefreshAllSpan=" + this.g + ", deepThinkFoldStatusManager=" + this.h + ')';
    }

    public m(fh8.f r2, Message r3, String r4, t.a r5, boolean r6, boolean r7, boolean r8, fh8.d r9) {
        Intrinsics.checkNotNullParameter(r2, "markdownCommonInputData");
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "thinkingContent");
        Intrinsics.checkNotNullParameter(r5, "renderViewConfig");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}

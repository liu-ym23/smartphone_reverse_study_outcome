package nb8;

import com.larus.im.bean.message.Message;
import fh8.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i {
    public final boolean a;
    public final fh8.d b;
    public final boolean c;
    public final fh8.f d;
    public final Message e;
    public final String f;
    public final boolean g;
    public final t.a h;

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
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
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
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        fh8.d r3 = this.b;
        if (r3 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r2 + r4) * 31;
        if (this.c == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (((((((r5 + r6) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        if (this.g == true) goto L19;
        r1 = 1237;
    L19:
        return ((r7 + r1) * 31) + this.h.hashCode();
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeepThinkContentViewInput(isDeepThinkingStreaming=" + this.a + ", deepThinkFoldStatusManager=" + this.b + ", needRefresh=" + this.c + ", markdownCommonInputData=" + this.d + ", message=" + this.e + ", thinkingContent=" + this.f + ", forceRefreshAllSpan=" + this.g + ", renderViewConfig=" + this.h + ')';
    }

    public i(boolean r2, fh8.d r3, boolean r4, fh8.f r5, Message r6, String r7, boolean r8, t.a r9) {
        Intrinsics.checkNotNullParameter(r5, "markdownCommonInputData");
        Intrinsics.checkNotNullParameter(r6, "message");
        Intrinsics.checkNotNullParameter(r7, "thinkingContent");
        Intrinsics.checkNotNullParameter(r9, "renderViewConfig");
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

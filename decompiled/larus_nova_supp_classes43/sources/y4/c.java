package y4;

import com.bytedance.ai.view.input.v;
import com.bytedance.ai.view.input.w;
import com.bytedance.ai.view.input.x;
import com.bytedance.ai.view.input.y;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public final Function0<String> a;
    public final Function0<String> b;
    public final Function0<b> c;
    public final Function0<Boolean> d;
    public Object e;
    public String f;
    public final Function0<String> g;
    public final Function2<String, String, Boolean> h;

    public c() {
        throw null;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        Object r1 = this.e;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.f;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (((r12 + r14) * 31) + this.g.hashCode()) * 31;
        Function2<String, String, Boolean> r16 = this.h;
        if (r16 == null) goto L15;
        r10 = r16.hashCode();
    L15:
        return r15 + r10;
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "OnSpeakAbility(cvsId=" + this.a + ", botId=" + this.b + ", visualizer=" + this.c + ", isSubmit=" + this.d + ", msgReq=" + this.e + ", taskId=" + this.f + ", appendQuery=" + this.g + ", redirectQuery=" + this.h + ')';
    }

    public c(w r10, x r11, y r12, v r13, Function0 r14, Function2 r15) {
        Intrinsics.checkNotNullParameter(r10, "cvsId");
        Intrinsics.checkNotNullParameter(r11, "botId");
        Intrinsics.checkNotNullParameter(r12, "visualizer");
        Intrinsics.checkNotNullParameter(r13, "isSubmit");
        Intrinsics.checkNotNullParameter(r14, "appendQuery");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = null;
        this.f = null;
        this.g = r14;
        this.h = r15;
    }
}

package ic8;

import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public final boolean a;
    public final Function1<f, Unit> b;
    public final Function1<f, Unit> c;
    public final boolean d;
    public final Function0<Unit> e;
    public final Function5<nr9.g, String, String, String, Message, Unit> f;

    public d() {
        this(false, null, null, false, null, null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        if (this.d == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (((r2 + r1) * 31) + this.e.hashCode()) * 31;
        Function5<nr9.g, String, String, String, Message, Unit> r4 = this.f;
        if (r4 != null) goto L13;
        int r5 = 0;
    L15:
        return r3 + r5;
    L13:
        r5 = r4.hashCode();
        goto L15
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "AIEditParams(showAiEditFunction=" + this.a + ", toAiEditFunctionPage=" + this.b + ", onAiEditFunctionActionShown=" + this.c + ", showVideoExtendFunction=" + this.d + ", onVideoExtendFunctionActionShown=" + this.e + ", toVideoExtendPage=" + this.f + ')';
    }

    public static d a(d r9, Function1 r10, Function5 r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        boolean r3 = r9.a;
    L7:
        if ((r12 & 2) == 0) goto L9;
        r10 = r9.b;
    L9:
        Function1 r4 = r10;
        if ((r12 & 4) == 0) goto L12;
        Function1<f, Unit> r5 = r9.c;
    L14:
        if ((r12 & 8) == 0) goto L16;
        boolean r6 = r9.d;
    L18:
        if ((r12 & 16) == 0) goto L20;
        Function0<Unit> r7 = r9.e;
    L22:
        if ((r12 & 32) == 0) goto L24;
        r11 = r9.f;
    L24:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r4, "toAiEditFunctionPage");
        Intrinsics.checkNotNullParameter(r5, "onAiEditFunctionActionShown");
        Intrinsics.checkNotNullParameter(r7, "onVideoExtendFunctionActionShown");
        return new d(r3, r4, r5, r6, r7, r11);
    L20:
        r7 = null;
        goto L22
    L16:
        r6 = false;
        goto L18
    L12:
        r5 = null;
        goto L14
    L5:
        r3 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(boolean r2, Function1<? super f, Unit> r3, Function1<? super f, Unit> r4, boolean r5, Function0<Unit> r6, Function5<? super nr9.g, ? super String, ? super String, ? super String, ? super Message, Unit> r7) {
        Intrinsics.checkNotNullParameter(r3, "toAiEditFunctionPage");
        Intrinsics.checkNotNullParameter(r4, "onAiEditFunctionActionShown");
        Intrinsics.checkNotNullParameter(r6, "onVideoExtendFunctionActionShown");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public /* synthetic */ d(boolean r6, Function1 r7, Function1 r8, boolean r9, Function0 r10, jy9.p r11, int r12) {
        boolean r1 = false;
        if ((r12 & 1) == 0) goto L5;
        boolean r0 = false;
    L7:
        if ((r12 & 2) == 0) goto L9;
        r7 = new a();
    L9:
        Function1 r2 = r7;
        if ((r12 & 4) == 0) goto L12;
        r8 = new b();
    L12:
        Function1 r3 = r8;
        if ((r12 & 8) != 0) goto L17;
        r1 = r9;
    L17:
        if ((r12 & 16) == 0) goto L19;
        r10 = new c();
    L19:
        Function0 r4 = r10;
        if ((r12 & 32) == 0) goto L22;
        r11 = null;
    L22:
        boolean r13 = r0;
        boolean r14 = r1;
        this(r13, r2, r3, r14, r4, r11);
        return;
    L5:
        r0 = r6;
        goto L7
    }
}

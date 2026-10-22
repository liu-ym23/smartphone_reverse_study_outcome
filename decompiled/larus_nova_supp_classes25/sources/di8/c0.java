package di8;

import android.view.View;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.nestedmenu.NestedMenuScene;
import com.larus.bmhome.chat.nestedmenu.c;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c0 {
    public final NestedMenuScene a;
    public final String b;
    public final View c;
    public final View d;
    public final View e;
    public z0 f;
    public o0 g;
    public final List<String> h;
    public final Function1<c, Unit> i;
    public final Function1<c, Unit> j;
    public final Function0<Unit> k;
    public ReplyOption l;
    public final t1a.b m;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r6 = (c0) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((r0 + r3) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        z0 r5 = this.f;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((((r4 + r6) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        Function1<c, Unit> r8 = this.j;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Function0<Unit> r11 = this.k;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        ReplyOption r14 = this.l;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        t1a.b r17 = this.m;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return r16 + r2;
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "NestedMenuConfig(scene=" + this.a + ", enterFrom=" + this.b + ", hostView=" + this.c + ", sourceView=" + this.d + ", popupHostView=" + this.e + ", actionBarItem=" + this.f + ", uiConfig=" + this.g + ", sectionOrder=" + this.h + ", onClick=" + this.i + ", onUnEnableClick=" + this.j + ", onPopupDismiss=" + this.k + ", replyOption=" + this.l + ", hostVContext=" + this.m + ')';
    }

    public c0(NestedMenuScene r30, String r31, View r32, View r33, View r34, z0 r35, o0 r36, Function1 r37, Function1 r38, Function0 r39, ReplyOption r40, t1a.b r41, int r42) {
        if ((r42 & 16) == 0) goto L5;
        View r7 = r32;
    L7:
        if ((r42 & 64) == 0) goto L9;
        o0 r9 = new o0(false, false, null, false, null, 0, 0, false, null, null, null, null, null, null, false, false, null, null, null, 33554431);
    L11:
        if ((r42 & 128) == 0) goto L13;
        List<String> r10 = h0.a;
    L15:
        if ((r42 & 512) == 0) goto L17;
        Function1 r12 = null;
    L19:
        if ((r42 & 1024) == 0) goto L21;
        Function0 r13 = null;
    L23:
        if ((r42 & 2048) == 0) goto L25;
        ReplyOption r14 = null;
    L27:
        if ((r42 & 4096) == 0) goto L29;
        t1a.b r15 = null;
    L30:
        this(r30, r31, r32, r33, r7, r35, r9, r10, r37, r12, r13, r14, r15);
        return;
    L29:
        r15 = r41;
        goto L30
    L25:
        r14 = r40;
        goto L27
    L21:
        r13 = r39;
        goto L23
    L17:
        r12 = r38;
        goto L19
    L13:
        r10 = null;
        goto L15
    L9:
        r9 = r36;
        goto L11
    L5:
        r7 = r34;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c0(NestedMenuScene r2, String r3, View r4, View r5, View r6, z0 r7, o0 r8, List<String> r9, Function1<? super c, Unit> r10, Function1<? super c, Unit> r11, Function0<Unit> r12, ReplyOption r13, t1a.b r14) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r4, "hostView");
        Intrinsics.checkNotNullParameter(r5, "sourceView");
        Intrinsics.checkNotNullParameter(r6, "popupHostView");
        Intrinsics.checkNotNullParameter(r8, "uiConfig");
        Intrinsics.checkNotNullParameter(r9, "sectionOrder");
        Intrinsics.checkNotNullParameter(r10, "onClick");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
    }
}

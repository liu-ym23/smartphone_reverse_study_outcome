package com.bytedance.ai.view.input;

import com.bytedance.ai.bridge.method.floatinginput.InputMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final Function0<String> a;
    public final Function0<String> b;
    public final Function0<String> c;
    public final Function0<z0<FloatingChatStatus>> d;
    public final Function3<Integer, Float, Float, Boolean> e;
    public final Function1<Boolean, Unit> f;
    public final Function0<Integer> g;
    public final Function2<String, String, Boolean> h;
    public final Function0<z0<InputMode>> i;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
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
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r11.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        Function2<String, String, Boolean> r1 = this.h;
        if (r1 != null) goto L5;
        int r10 = 0;
    L7:
        return ((r0 + r10) * 31) + this.i.hashCode();
    L5:
        r10 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "Ability(botId=" + this.a + ", conversationId=" + this.b + ", appendQuery=" + this.c + ", chatStatus=" + this.d + ", onSpeakEvent=" + this.e + ", onSpeakStatusCallback=" + this.f + ", offset=" + this.g + ", redirectQuery=" + this.h + ", inputMode=" + this.i + ')';
    }

    public a(z r10, a0 r11, b0 r12, c0 r13, d0 r14, e0 r15, f0 r16, g0 r17, h0 r18) {
        Intrinsics.checkNotNullParameter(r10, "botId");
        Intrinsics.checkNotNullParameter(r11, "conversationId");
        Intrinsics.checkNotNullParameter(r12, "appendQuery");
        Intrinsics.checkNotNullParameter(r13, "chatStatus");
        Intrinsics.checkNotNullParameter(r14, "onSpeakEvent");
        Intrinsics.checkNotNullParameter(r15, "onSpeakStatusCallback");
        Intrinsics.checkNotNullParameter(r16, "offset");
        Intrinsics.checkNotNullParameter(r18, "inputMode");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
    }
}

package com.obric.assistant.settings.spi;

import android.view.View;
import com.bytedance.applet.aibridge.p;
import com.obric.assistant.settings.provider.w1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a extends e {
    public final Function1<View, Unit> e;
    public final Function0<String> f;
    public final Function0<String> g;
    public final Function1<Continuation<? super Boolean>, Object> h;
    public final Function0<Boolean> i;
    public final boolean j;
    public final Function0<Boolean> k;
    public final String l;

    public a() {
        throw null;
    }

    @Override // com.obric.assistant.settings.spi.e
    public final Object a(Continuation<? super Boolean> r2) {
        return this.h.invoke(r2);
    }

    public a(String r3, String r4, CharSequence r5, int r6, Function1 r7, Function0 r8, Function0 r9, Function1 r10, w1 r11, boolean r12, Function0 r13, String r14, int r15) {
        if ((r15 & 32) == 0) goto L6;
        r8 = null;
    L6:
        if ((r15 & 64) == 0) goto L9;
        r9 = null;
    L9:
        if ((r15 & 128) == 0) goto L12;
        r10 = new ActionSettingItem$1(null);
    L12:
        if ((r15 & 512) == 0) goto L15;
        r11 = new zb8.c();
    L15:
        if ((r15 & 1024) == 0) goto L18;
        r12 = false;
    L18:
        if ((r15 & 2048) == 0) goto L21;
        r13 = new p();
    L21:
        if ((r15 & 4096) == 0) goto L23;
        r14 = null;
    L23:
        Intrinsics.checkNotNullParameter(r3, "groupId");
        Intrinsics.checkNotNullParameter(r4, "id");
        Intrinsics.checkNotNullParameter(r5, "title");
        Intrinsics.checkNotNullParameter(r7, "onClick");
        Intrinsics.checkNotNullParameter(r10, "visibleCheck");
        Intrinsics.checkNotNullParameter(r11, "showSubtitleRedPot");
        Intrinsics.checkNotNullParameter(r13, "enabled");
        super(r3, r4, r5, r6);
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
    }
}

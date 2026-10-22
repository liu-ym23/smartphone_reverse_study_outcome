package com.obric.assistant.settings.spi;

import android.view.View;
import com.bytedance.applet.aibridge.p;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f extends e {
    public final Function0<Boolean> e;
    public final Function2<Boolean, View, Unit> f;
    public final CharSequence g;
    public final Function1<Continuation<? super Boolean>, Object> h;
    public final Function0<Boolean> i;
    public final boolean j;
    public final String k;
    public final String l;
    public final Function0<Boolean> m;
    public final String n;

    public f() {
        throw null;
    }

    @Override // com.obric.assistant.settings.spi.e
    public final Object a(Continuation<? super Boolean> r2) {
        return this.h.invoke(r2);
    }

    public f(String r16, String r17, CharSequence r18, int r19, Function0 r20, Function2 r21, CharSequence r22, Function1 r23, boolean r24, String r25, Function0 r26, String r27, int r28) {
        if ((r28 & 64) == 0) goto L5;
        CharSequence r4 = null;
    L7:
        if ((r28 & 128) == 0) goto L9;
        Function1 r6 = new SwitchSettingItem$1(null);
    L11:
        if ((r28 & 256) == 0) goto L13;
        zb8.c r7 = new zb8.c();
    L15:
        if ((r28 & 512) == 0) goto L17;
        boolean r8 = false;
    L19:
        if ((r28 & 2048) == 0) goto L21;
        String r9 = null;
    L23:
        if ((r28 & 4096) == 0) goto L25;
        Function0 r10 = new p();
    L27:
        if ((r28 & 8192) == 0) goto L29;
        String r3 = null;
    L30:
        Intrinsics.checkNotNullParameter(r16, "groupId");
        Intrinsics.checkNotNullParameter(r17, "id");
        Intrinsics.checkNotNullParameter(r18, "title");
        Intrinsics.checkNotNullParameter(r20, "isChecked");
        Intrinsics.checkNotNullParameter(r21, "onCheckedChange");
        Intrinsics.checkNotNullParameter(r6, "visibleCheck");
        Intrinsics.checkNotNullParameter(r7, "showRedPot");
        Intrinsics.checkNotNullParameter(r10, "enabled");
        super(r16, r17, r18, r19);
        this.e = r20;
        this.f = r21;
        this.g = r4;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.k = null;
        this.l = r9;
        this.m = r10;
        this.n = r3;
        return;
    L29:
        r3 = r27;
        goto L30
    L25:
        r10 = r26;
        goto L27
    L21:
        r9 = r25;
        goto L23
    L17:
        r8 = r24;
        goto L19
    L13:
        r7 = null;
        goto L15
    L9:
        r6 = r23;
        goto L11
    L5:
        r4 = r22;
        goto L7
    }
}

package com.bytedance.android.live.anchorlink.utils;

import gy.f;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import nc0.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ MultiChannelOptManager a;
    public final /* synthetic */ String b;

    public b(MultiChannelOptManager r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        f r5 = this.a.i;
        Integer r0 = null;
        if (r5 == null) goto L7;
        List<ui6.a> r6 = r5.L0();
        if (r6 == null) goto L7;
        Integer r7 = Integer.valueOf(r6.size());
    L8:
        f r1 = this.a.i;
        if (r1 == null) goto L14;
        s r2 = r1.L();
        if (r2 == null) goto L14;
        r0 = Integer.valueOf(r2.d());
    L14:
        if ((!Intrinsics.areEqual(r7, r0)) == false) goto L27;
        Integer r8 = this.a.a;
        if (r8 != null) goto L19;
    L20:
        Integer r9 = this.a.a;
        if (r9 != null) goto L24;
        return;
    L24:
        if (r9.intValue() != 3) goto L28;
    L25:
        MultiChannelOptManager r11 = this.a;
        r11.b(r11.c, this.b);
        return;
    L28:
        return;
    L19:
        if (r8.intValue() == 2) goto L25;
    L27:
        return;
    L7:
        r7 = null;
        goto L8
    }
}

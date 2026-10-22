package com.bytedance.android.live.liveinteract.interactivesong.impl;

import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ InteractiveSongWidget a;

    public i(InteractiveSongWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        SubscriberJsEvent r6 = (SubscriberJsEvent) r5;
        InteractiveSongWidget r0 = this.a;
        Map r1 = r6.getParams();
        Object r2 = null;
        if (r1 == null) goto L7;
        Object r3 = r1.get("user_type");
        if (r3 == null) goto L7;
        String r4 = r3.toString();
    L8:
        r0.u = r4;
        InteractiveSongWidget r7 = this.a;
        Map r8 = r6.getParams();
        if (r8 == null) goto L13;
        Object r9 = r8.get("source");
        if (r9 == null) goto L13;
        String r10 = r9.toString();
    L14:
        r7.r = r10;
        InteractiveSongWidget r11 = this.a;
        Map r12 = r6.getParams();
        if (r12 == null) goto L17;
        Object r13 = r12.get("mv_autoplay");
    L19:
        if ((r13 instanceof Boolean) == true) goto L21;
        r13 = null;
    L21:
        Boolean r14 = (Boolean) r13;
        if (r14 == null) goto L24;
        boolean r15 = r14.booleanValue();
    L25:
        r11.s = r15;
        InteractiveSongWidget r16 = this.a;
        Map r17 = r6.getParams();
        if (r17 == null) goto L28;
        Object r18 = r17.get("play_layout");
    L30:
        if ((r18 instanceof String) == false) goto L33;
        r2 = r18;
    L33:
        String r19 = (String) r2;
        if (r19 != null) goto L36;
        r19 = "classic";
    L36:
        r16.t = r19;
        return;
    L28:
        r18 = null;
        goto L30
    L24:
        r15 = false;
        goto L25
    L17:
        r13 = null;
    L13:
        r10 = null;
    L7:
        r4 = null;
        goto L8
    }
}

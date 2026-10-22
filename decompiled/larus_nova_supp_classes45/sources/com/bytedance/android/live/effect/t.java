package com.bytedance.android.live.effect;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t {
    public final LiveEffectContextFactoryDelegate$Type a;

    public t(LiveEffectContextFactoryDelegate$Type r1) {
        this.a = r1;
    }

    public void onEvent(com.bytedance.android.live.effect.gesture.a r3) {
        if (r3 == null) goto L14;
        int r0 = r3.a;
        com.bytedance.android.live.effect.gesture.a.C0187a r4 = r3.b;
        switch(r0) {
            case 201: goto L12;
            case 202: goto L11;
            case 203: goto L10;
            case 204: goto L9;
            case 205: goto L8;
            case 206: goto L7;
            case 207: goto L6;
            default: goto L21;
        };
    L6:
        long r1 = r4.d;
        LiveEffectContextFactoryDelegate$Type r5 = this.a;
        List<String> r2 = LiveEffectContext.h;
        LiveEffectContext.a.a(r5).e().e().g();
        return;
    L7:
        float r6 = r4.b;
        LiveEffectContextFactoryDelegate$Type r7 = this.a;
        List<String> r8 = LiveEffectContext.h;
        LiveEffectContext.a.a(r7).e().e().a();
        return;
    L8:
        float r9 = r4.c;
        LiveEffectContextFactoryDelegate$Type r11 = this.a;
        List<String> r12 = LiveEffectContext.h;
        LiveEffectContext.a.a(r11).e().e().e();
        return;
    L9:
        float r13 = r4.b;
        LiveEffectContextFactoryDelegate$Type r14 = this.a;
        List<String> r15 = LiveEffectContext.h;
        LiveEffectContext.a.a(r14).e().e().f();
        return;
    L10:
        float r16 = r4.b;
        LiveEffectContextFactoryDelegate$Type r17 = this.a;
        List<String> r18 = LiveEffectContext.h;
        LiveEffectContext.a.a(r17).e().e().d();
        return;
    L11:
        float r19 = r4.b;
        LiveEffectContextFactoryDelegate$Type r21 = this.a;
        List<String> r22 = LiveEffectContext.h;
        LiveEffectContext.a.a(r21).e().e().c();
        return;
    L12:
        float r23 = r4.b;
        LiveEffectContextFactoryDelegate$Type r24 = this.a;
        List<String> r25 = LiveEffectContext.h;
        LiveEffectContext.a.a(r24).e().e().b();
        return;
    L21:
        return;
    }
}

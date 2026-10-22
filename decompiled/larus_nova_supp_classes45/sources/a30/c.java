package a30;

import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateEffectGameStateResultModel;
import com.bytedance.android.livesdk.gift.platform.business.effect.service.EffectGameStatus;
import com.bytedance.ies.web.jsbridge2.CallContext;
import i12.o;
import kotlin.jvm.internal.Intrinsics;
import w20.kb;
import w20.q3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends q3<kb, LiveUpdateEffectGameStateResultModel> {
    public c() {
    }

    public final void invoke(Object r11, CallContext r12) {
        kb r13 = (kb) r11;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "context");
        i12.e r14 = o.b();
        EffectGameStatus r0 = null;
        if (r14 == null) goto L5;
        Object r15 = com.bytedance.android.scope.m.e.d(r14, l02.e.class);
    L6:
        l02.e r16 = (l02.e) r15;
        if (r16 == null) goto L26;
        Integer r1 = r13.c();
        Integer r2 = r13.b();
        String r17 = r13.a();
        EffectGameStatus.Companion.getClass();
        EffectGameStatus[] r3 = EffectGameStatus.values();
        int r4 = r3.length;
        int r6 = 0;
    L9:
        if (r6 >= r4) goto L20;
        EffectGameStatus r7 = r3[r6];
        int r8 = r7.getValue();
        if (r1 != null) goto L14;
    L16:
        boolean r9 = false;
    L17:
        if (r9 == true) goto L18;
        r6 = r6 + 1;
        goto L9
    L18:
        r0 = r7;
        goto L20
    L14:
        if (r8 != r1.intValue()) goto L16;
        r9 = true;
    L20:
        if (r0 != null) goto L22;
        r0 = EffectGameStatus.IDLE;
    L22:
        r16.a = r0;
        r16.b = r2;
        r16.c = r17;
        return;
    L26:
        return;
    L5:
        r15 = null;
        goto L6
    }
}

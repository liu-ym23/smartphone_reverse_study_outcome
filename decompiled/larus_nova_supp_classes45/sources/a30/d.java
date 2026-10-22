package a30;

import android.text.TextUtils;
import com.bytedance.android.live.browser.jsbridge.base.SendEffectMessageResultModel;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.a0;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import w20.ce;
import w20.w5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends w5<ce, SendEffectMessageResultModel> {
    public d() {
    }

    public final void invoke(Object r11, CallContext r12) {
        ce r13 = (ce) r11;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "context");
        int r1 = 0;
        String r2 = "";
        if (com.bytedance.android.livesdk.gift.platform.core.h.q() == false) goto L84;
        Intrinsics.checkNotNullParameter(r13, "params");
        GiftContext r14 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r14 == null) goto L9;
        com.bytedance.live.datacontext.m r15 = r14.getGiftRenderFilterWrapper();
        if (r15 == null) goto L9;
        ca0.i r16 = (ca0.i) r15.getValue();
    L10:
        ca0.i r3 = r16;
        if (r3 != null) goto L13;
        finishWithFailure();
        return;
    L13:
        boolean r8 = m.g();
        r13.getChannel();
        r13.T();
        r13.g3();
        r13.w3();
        r13.q3();
        String r17 = r13.getChannel();
        if (r17 != null) goto L17;
        r17 = "";
    L17:
        if (TextUtils.equals(r17, "pk") == false) goto L19;
    L22:
        boolean r18 = true;
    L23:
        if (r18 == false) goto L45;
        if (a0.d() == true) goto L45;
        ca0.b r19 = m.c();
        if (r19 == null) goto L83;
        Integer r0 = r13.T();
        if (r0 == null) goto L31;
        int r4 = r0.intValue();
    L32:
        Integer r5 = r13.g3();
        if (r5 == null) goto L35;
        int r6 = r5.intValue();
    L36:
        Integer r7 = r13.w3();
        if (r7 == null) goto L39;
        r1 = r7.intValue();
    L39:
        String r9 = r13.q3();
        if (r9 == null) goto L43;
        r2 = r9;
    L43:
        r19.s(r4, r6, r1, r2);
        goto L83
    L35:
        r6 = 0;
        goto L36
    L31:
        r4 = 0;
    L83:
        r13.q3();
        finishWithSuccess();
        return;
    L45:
        if (Intrinsics.areEqual(r13.getChannel(), "rtc") == false) goto L66;
        com.bytedance.android.live.revenuelink.rtc.f r110 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getRtcService();
        if (r110 == null) goto L83;
        com.bytedance.android.live.revenuelink.rtc.i r21 = r110.getRtcManager();
        if (r21 == null) goto L83;
        Integer r111 = r13.T();
        if (r111 == null) goto L53;
        int r22 = r111.intValue();
    L54:
        Integer r112 = r13.g3();
        long r23 = 0;
        if (r112 == null) goto L57;
        long r24 = r112.intValue();
    L58:
        Integer r113 = r13.w3();
        if (r113 == null) goto L61;
        r23 = r113.intValue();
    L61:
        long r25 = r23;
        String r114 = r13.q3();
        if (r114 != null) goto L64;
        String r26 = "";
    L65:
        r21.W0(r22, r24, r25, r26);
        goto L83
    L64:
        r26 = r114;
        goto L65
    L57:
        r24 = 0;
        goto L58
    L53:
        r22 = 0;
        goto L54
    L66:
        Integer r115 = r13.T();
        if (r115 == null) goto L69;
        int r27 = r115.intValue();
    L70:
        Integer r116 = r13.g3();
        if (r116 == null) goto L73;
        int r28 = r116.intValue();
    L74:
        Integer r117 = r13.w3();
        if (r117 == null) goto L77;
        int r29 = r117.intValue();
    L78:
        String r118 = r13.q3();
        if (r118 != null) goto L81;
        String r31 = "";
    L82:
        r3.b(r27, r28, r29, r31, r8);
        goto L83
    L81:
        r31 = r118;
        goto L82
    L77:
        r29 = 0;
        goto L78
    L73:
        r28 = 0;
        goto L74
    L69:
        r27 = 0;
        goto L70
    L19:
        if (TextUtils.equals(r17, "ai_wish_gift") == true) goto L22;
        r18 = false;
    L9:
        r16 = null;
        goto L10
    L84:
        Intrinsics.checkNotNullParameter(r13, "params");
        if (m.e() == true) goto L88;
        finishWithSuccess();
        return;
    L88:
        if (m.d() == true) goto L117;
        finishWithSuccess();
        return;
    L117:
        Integer r119 = r13.T();     // Catch: Throwable -> L115
        if (r119 == null) goto L93;
        int r120 = r119.intValue();     // Catch: Throwable -> L115
    L94:
        Integer r32 = r13.g3();     // Catch: Throwable -> L115
        if (r32 == null) goto L97;
        int r33 = r32.intValue();     // Catch: Throwable -> L115
    L98:
        Integer r34 = r13.w3();     // Catch: Throwable -> L115
        if (r34 == null) goto L101;
        r1 = r34.intValue();     // Catch: Throwable -> L115
    L101:
        String r121 = r13.q3();     // Catch: Throwable -> L115
        if (r121 == null) goto L106;
        r2 = r121;
    L106:
        if (m.g() == false) goto L110;
        ca0.b r122 = m.c();     // Catch: Throwable -> L115
        if (r122 == null) goto L113;
        r122.j(r120, r33, r1, r2);     // Catch: Throwable -> L115
    L113:
        finishWithSuccess();     // Catch: Throwable -> L115
        return;
    L110:
        or2.a r123 = m.a();     // Catch: Throwable -> L115
        if (r123 == null) goto L113;
        r123.sendMessage(r120, r33, r1, r2);     // Catch: Throwable -> L115
        goto L113
    L97:
        r33 = 0;
        goto L98
    L93:
        r120 = 0;
    L115:
        finishWithFailure();
    }
}

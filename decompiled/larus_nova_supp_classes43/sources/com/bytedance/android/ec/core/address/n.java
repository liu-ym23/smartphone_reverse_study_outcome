package com.bytedance.android.ec.core.address;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.core.utils.u0;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n<V> implements Callable {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        w r0 = AddressSDK.a;
        w r1 = AddressSDK.a;
        r1.getClass();
        int r10 = v.c;
        Lazy r11 = ECSettingKeys.a;
        int r12 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r13 = "";
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r15 = jj4.b.b;     // Catch: Throwable -> L7
        Object r16 = jj4.a.a("ec_address_sdk_config", String.class, "", false);     // Catch: Throwable -> L7
        if (r16 != null) goto L13;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L13:
        String r17 = (String) r16;
        if (r17 != null) goto L16;
    L19:
        boolean r18 = true;
    L21:
        if (r18 == false) goto L57;
        int r19 = s.a;
        s.c(true, null);
        AddressSDKLog.a("init setting empty", false);
    L27:
        v r20 = null;
    L28:
        if (r20 == null) goto L30;
        r1.g = r20;
    L30:
        r1.f = com.bytedance.android.ec.sdk.helper.d.b.getIECSPService().getLong("ec_address_dialog_stat_timestamp", 0);
        r1.a();
        u r21 = AddressSDK.c;
        Integer r22 = AddressSDK.a.g.a().e();
        if (r22 == null) goto L33;
        int r23 = r22.intValue();
    L34:
        r21.b = r23;
        if (AddressSDK.q() == false) goto L40;
        wi.c r24 = AddressSDK.m();
        if (r24 == null) goto L39;
        r24.h("bpea-ecom_address_sdk_trylocate_only_cache", "auom");
    L39:
        w r25 = AddressSDK.a;
    L40:
        wi.c r26 = AddressSDK.m();
        if (r26 == null) goto L43;
        r26.e(new q());
    L43:
        Lazy r27 = AddressSDKLightLocateAB.a;
        if (((AddressSDKLightLocateAB) r27.getValue()).c() == false) goto L48;
        wi.c r28 = AddressSDK.m();
        if (r28 == null) goto L48;
        r28.g(new r());
    L48:
        ECLiveHybridUtil.m("updateAddress", new h());
        ECLiveHybridUtil.m("deleteAddress", new i());
        int r29 = ((AddressSDKLightLocateAB) r27.getValue()).a();
        if (r29 > 0) goto L59;
    L52:
        AddressSDK.h("cool_start", "address_rec_init", false, null, 26);
        return;
    L59:
        Thread.sleep(r29);     // Catch: Throwable -> L54
        goto L52
    L33:
        r23 = 50;
        goto L34
    L57:
        r20 = (v) u0.b(r17, v.class);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        int r30 = s.a;
        s.c(false, th.getMessage());
        int r31 = AddressSDKLog.a;
        String r32 = "init setting exception " + th.getMessage();
        Intrinsics.checkNotNullParameter(r32, MessageIndication.MESSAGE_TYPE_MSG);
        b2.a(new AddressSDKLog$e$1(r32, System.currentTimeMillis(), th));
        goto L27
    L16:
        if (r17.length() == 0) goto L19;
        r18 = false;
    L7:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        Object r34 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r34) == true) goto L12;
        r13 = r34;
    L12:
        r16 = r13;
        goto L13
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}

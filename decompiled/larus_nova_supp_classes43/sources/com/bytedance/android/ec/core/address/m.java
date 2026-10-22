package com.bytedance.android.ec.core.address;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m implements wi.b {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function1 c;

    public final void a(wi.a r10) {
        w r0 = AddressSDK.a;
        w r1 = AddressSDK.a;
        int r11 = r1.g.b().b();
        wi.a r12 = r1.j;
        if (r12 == null) goto L5;
        float r13 = z.a(r12, r10);
    L6:
        AddressSDKLog.a("locate success:distance=" + r13 + " isCacheFirst=" + this.a + " curBtm=" + this.b, false);
        if (r12 != null) goto L9;
    L10:
        AddressSDK.h("location_change", null, false, null, 30);
        r1.j = r10;
    L11:
        w r14 = AddressSDK.a;
        Function1 r15 = this.c;
        if (r15 == null) goto L15;
        Unit r16 = (Unit) r15.invoke(r10);
        return;
    L15:
        return;
    L9:
        if (r13 <= r11) goto L11;
    L5:
        r13 = 0.0f;
        goto L6
    }

    public final void onFailure(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "reason");
        w r0 = AddressSDK.a;
        AddressSDKLog.a("locate fail:" + r10.getMessage() + " isCacheFirst=" + this.a + " curBtm=" + this.b, false);
    }

    public m(boolean r1, String r10, Function1 r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}

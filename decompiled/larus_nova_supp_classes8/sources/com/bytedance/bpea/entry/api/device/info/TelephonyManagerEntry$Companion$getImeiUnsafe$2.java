package com.bytedance.bpea.entry.api.device.info;

import android.telephony.TelephonyManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class TelephonyManagerEntry$Companion$getImeiUnsafe$2 extends Lambda implements Function0<String> {
    final /* synthetic */ int $slot;
    final /* synthetic */ TelephonyManager $this_getImeiUnsafe;

    public TelephonyManagerEntry$Companion$getImeiUnsafe$2(TelephonyManager r1, int r2) {
        this.$this_getImeiUnsafe = r1;
        this.$slot = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m1655invoke() {
        TelephonyManager r8 = this.$this_getImeiUnsafe;
        int r9 = this.$slot;
        f06.c r10 = new f06.c();
        Object[] r11 = {Integer.valueOf(r9)};
        f06.b r12 = new f06.b();
        f06.d r13 = r10.b(101601, "android/telephony/TelephonyManager", "getImei", r8, r11, "java.lang.String", r12);
        if (r13.a == false) goto L5;
        r10.a(101601, "android/telephony/TelephonyManager", "getImei", r8, r11, null, r12, false);
        return (String) r13.b;
    L5:
        String r14 = r8.getImei(r9);
        r10.a(101601, "android/telephony/TelephonyManager", "getImei", r8, r11, r14, r12, true);
        return r14;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1655invoke();
    }
}

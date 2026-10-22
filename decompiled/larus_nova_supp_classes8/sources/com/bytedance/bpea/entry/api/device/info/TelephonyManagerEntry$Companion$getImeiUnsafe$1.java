package com.bytedance.bpea.entry.api.device.info;

import android.telephony.TelephonyManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class TelephonyManagerEntry$Companion$getImeiUnsafe$1 extends Lambda implements Function0<String> {
    final /* synthetic */ TelephonyManager $this_getImeiUnsafe;

    public TelephonyManagerEntry$Companion$getImeiUnsafe$1(TelephonyManager r1) {
        this.$this_getImeiUnsafe = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m1654invoke() {
        TelephonyManager r8 = this.$this_getImeiUnsafe;
        f06.c r9 = new f06.c();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        f06.d r12 = r9.b(101601, "android/telephony/TelephonyManager", "getImei", r8, r10, "java.lang.String", r11);
        if (r12.a == false) goto L5;
        r9.a(101601, "android/telephony/TelephonyManager", "getImei", r8, r10, null, r11, false);
        return (String) r12.b;
    L5:
        String r13 = r8.getImei();
        r9.a(101601, "android/telephony/TelephonyManager", "getImei", r8, r10, r13, r11, true);
        return r13;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1654invoke();
    }
}

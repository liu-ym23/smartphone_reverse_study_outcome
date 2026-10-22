package com.bytedance.android.live.revenue.platform.network.dynamic;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_KMP_REGISTER_MSG_DISPOSE_OPT", "getLIVE_KMP_REGISTER_MSG_DISPOSE_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_AIO_REGISTER_MESSAGE_SUPPORT_BYTELINK", "getLIVE_AIO_REGISTER_MESSAGE_SUPPORT_BYTELINK()Z", 1))};
        a = r0;
        Boolean r3 = Boolean.TRUE;
        Class r4 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_kmp_register_msg_dispose_opt", r3, r4, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_aio_register_message_support_bytelink", r3, r4, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
    }
}

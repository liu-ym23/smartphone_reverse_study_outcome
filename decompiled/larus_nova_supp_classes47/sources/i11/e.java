package i11;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final e f = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(e.class, "multiAnchorCacheListOptEnable", "getMultiAnchorCacheListOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "multiAnchorLeaveMsgConsumeOptEnable", "getMultiAnchorLeaveMsgConsumeOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "multiAnchorMessageRequestEnable", "getMultiAnchorMessageRequestEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "seiLoadForceRequestList", "getSeiLoadForceRequestList()Z", 0))};
        a = r0;
        f = new e();
        Boolean r6 = Boolean.TRUE;
        Class r7 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_cache_list_opt_enable", r6, r7, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_leave_msg_opt_enable", r6, r7, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_message_enable", r6, r7, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("sei_load_force_request_list", r6, r7, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
    }

    public e() {
    }
}

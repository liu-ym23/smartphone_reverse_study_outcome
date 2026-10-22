package y41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty f = null;
    public static final ReadOnlyProperty g = null;
    public static final ReadOnlyProperty h = null;
    public static final ReadOnlyProperty i = null;
    public static final d j = null;

    public d() {
    }

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(d.class, "multiAnchorEnableSelfMicPanel", "getMultiAnchorEnableSelfMicPanel()[Ljava/lang/Integer;", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiAnchorEnableMicPanel", "getMultiAnchorEnableMicPanel()[Ljava/lang/Integer;", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiAnchorEnlargeCountControl", "getMultiAnchorEnlargeCountControl()[Ljava/lang/Integer;", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiAnchorEnableAllEnlarge", "getMultiAnchorEnableAllEnlarge()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiAnchorEnableSelfEnlarge", "getMultiAnchorEnableSelfEnlarge()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiAnchorBlockDigg", "getMultiAnchorBlockDigg()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "anchorLinkFullLayoutEnable", "getAnchorLinkFullLayoutEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiAnchorEnlargeFrequenceControl", "getMultiAnchorEnlargeFrequenceControl()J", 0))};
        a = r0;
        j = new d();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_enable_self_mic_panel", new Integer[]{4, 5, 6, 7, 8, 9}, zn3.a.j, false);
        b = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_enable_mic_panel", new Integer[]{3, 4, 5, 6, 7, 8, 9}, zn3.a.d, false);
        c = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_enlarge_count_control", new Integer[]{4, 5, 6, 7, 8, 9}, zn3.a.b, false);
        d = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[2]);
        Boolean r5 = Boolean.TRUE;
        Class r6 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multilinker_focus_layout_in_all", r5, r6, false);
        e = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multilinker_focus_layout_in_self", r5, r6, false);
        f = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_block_digg", r5, r6, false);
        g = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multilinker_large_layout", r5, r6, false);
        h = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multilinker_focus_layout_action_interval", 3000L, Long.TYPE, false);
        i = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[7]);
    }

    public final boolean a(boolean r3) {
        if (r3 == false) goto L6;
        return false;
    L6:
        return ((Boolean) h.getValue(this, a[6])).booleanValue();
    }
}

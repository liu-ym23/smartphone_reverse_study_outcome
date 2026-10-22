package ay0;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(a.class, "livePcAnchorInteractVideoMarginTop", "getLivePcAnchorInteractVideoMarginTop()F", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "liveSeiFrameCompare", "getLiveSeiFrameCompare()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "liveVRPkCanvasRadioMode", "getLiveVRPkCanvasRadioMode()I", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pc_anchor_interact_video_margin_top", Float.valueOf(0.19f), Float.TYPE, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sei_frame_compare", Boolean.TRUE, Boolean.TYPE, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_vr_pk_canvas_radio_mode", 0, Integer.TYPE, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
    }

    public static final int a() {
        return ((Number) d.getValue(null, a[2])).intValue();
    }
}

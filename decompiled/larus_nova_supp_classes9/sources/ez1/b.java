package ez1;

import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;

    static {
        KProperty[] r1 = {Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_MSESSAGE_BOARD_GIFT_DIALOG_URL", "getLIVE_MSESSAGE_BOARD_GIFT_DIALOG_URL()Ljava/lang/String;", 1))};
        a = r1;
        KmpEnv r3 = KmpEnv.a;
        KmpEnv.a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_message_board_gift_dialog_url", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Fwebcast_native_lynx_gift_douyin%2Fpages%2Fgift%2Fmessage_board_gift%2Ftemplate.js&load_taro=0&enable_canvas=1&width_percent=100&type=popup&gravity=bottom&height=300&web_bg_color=00FFFFFF", String.class, false);
        b = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r1[0]);
    }
}

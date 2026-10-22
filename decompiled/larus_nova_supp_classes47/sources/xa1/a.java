package xa1;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a {
    public static final SettingKey<Boolean> a = null;
    public static final SettingKey<List<String>> b = null;
    public static final SettingKey<Boolean> c = null;
    public static final SettingKey<Boolean> d = null;
    public static final SettingKey<Boolean> e = null;

    static {
        Boolean r1 = Boolean.FALSE;
        a = new SettingKey("live_lynx_mapping_switch", "lynx mapping 开关", r1, r1);
        b = new SettingKey("live_jsb_whitelist", "直播JSB白名单", new ArrayList(), new ArrayList());
        Boolean r2 = Boolean.TRUE;
        c = new SettingKey("live_jsb2_enable_finder_register_fix", "直播容器JSB2MethodFinder修复开启开关", r2, r2);
        d = new SettingKey("enable_anniex_live_pia_fetch_fix", "修复 AnnieXLive PIA FetchV3Method 复用导致的 bug ", r2, r2);
        r2.getClass();
        e = new SettingKey("webcast_use_anniex_redirect", "开启AnnieX 重定向", r1, r1);
    }
}

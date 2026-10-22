package u30;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.setting.TTAppSettingKey;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface e {
    public static final SettingKey<d> a = null;

    static {
        new TTAppSettingKey("live_safe_domain_list", new ArrayList());
        new SettingKey("hotsoon_safe_host_list", new ArrayList());
        new SettingKey("force_js_permission", -1);
        new SettingKey("allow_html_video", Boolean.TRUE);
        new SettingKey("wap_load_time_limit_wifi", -1L);
        new SettingKey("wap_load_time_limit_mobile", -1L);
        new SettingKey("webview_destroy_mode", -1);
        new TTAppSettingKey("js_actlog_url", "");
        new SettingKey("enable_webview_debugging", Boolean.FALSE, "webview debug");
        new SettingKey("advert_cooperation_url", "https://www.chengzijianzhan.com/tetris/page/1614465171474436/");
        a = new SettingKey("live_webview_download_config", new d());
    }
}

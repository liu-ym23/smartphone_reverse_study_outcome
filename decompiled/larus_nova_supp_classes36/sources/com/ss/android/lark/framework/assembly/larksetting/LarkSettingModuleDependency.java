package com.ss.android.lark.framework.assembly.larksetting;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import java.util.Map;
import org.json.JSONObject;
import yzb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(ppb.a.class)
public class LarkSettingModuleDependency implements ppb.a {
    public static final String CONFIG_KEY = "messenger_feed_load_count";
    public static final String CONTACTS_CONFIG = "contacts_config";
    public static final String DYNAMIC_URL = "dynamic_url_mapper";
    private static final String KEY_OP_MONITOR_CONFIG = "monitor";
    public static final String KEY_SHORTLINK = "short_applink_to_long_applink";
    public static final String SETTING_BLANK_DETECT = "blank_detect";
    private static final String TAG = "SettingModuleDependency";
    b mUserListApi;

    public class a implements ppb.a.InterfaceC0313a {
        public a() {
        }
    }

    public LarkSettingModuleDependency() {
    }

    private b getUserListApi() {
        if (this.mUserListApi != null) goto L6;
        this.mUserListApi = (b) LarkContext.spiByDwarf(b.class);
    L6:
        return this.mUserListApi;
    }

    @Override // ppb.a
    public ppb.a.InterfaceC0313a getFeatureGatingDependency() {
        return new a();
    }

    public String getUserId() {
        return getUserListApi().c();
    }

    @Override // ppb.a
    public void fillDefaultKey2LoadConfigMap(Map<String, jpb.a> r5) {
        monitor-enter(r5);
        jpb.a r1 = jpb.a.b;     // Catch: Throwable -> L6
        r5.put(CONFIG_KEY, r1);     // Catch: Throwable -> L6
        jpb.a r2 = new jpb.a();     // Catch: Throwable -> L6
        r2.a = false;     // Catch: Throwable -> L6
        r5.put(KEY_OP_MONITOR_CONFIG, r2);     // Catch: Throwable -> L6
        r5.put(KEY_SHORTLINK, r1);     // Catch: Throwable -> L6
        r5.put(SETTING_BLANK_DETECT, r1);     // Catch: Throwable -> L6
        r5.put(CONTACTS_CONFIG, r1);     // Catch: Throwable -> L6
        r5.put(DYNAMIC_URL, r1);     // Catch: Throwable -> L6
        monitor-exit(r5);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // ppb.a
    public void sendEvent(String r1, JSONObject r2) {
        Statistics.sendEvent(r1, r2);
    }
}

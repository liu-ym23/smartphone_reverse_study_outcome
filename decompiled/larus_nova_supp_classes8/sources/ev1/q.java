package ev1;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q extends SettingKey<Boolean> {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;
    public static final q d = null;

    static {
        d = new q();
        a = "https://p3-webcast.douyinpic.com/obj/webcast/";
        b = "https://p6-webcast.douyinpic.com/obj/webcast/";
        c = "https://p9-webcast.douyinpic.com/obj/webcast/";
    }

    public q() {
        Boolean r1 = Boolean.FALSE;
        super("live_toolbar_icon_opt", "toolbar视觉降级，icon替换", r1, r1);
    }
}

package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w extends SettingKey<Integer> {
    public static final w a = null;

    public w() {
        super("live_enable_match_image_retry_times", "赛事直播间中对抗托盘的图片资源下载的try次数，为1表示没有retry，走老逻辑", 3, 3);
    }

    static {
        a = new w();
    }
}

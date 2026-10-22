package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i4 extends SettingKey<Boolean> {
    public static final i4 a = null;

    static {
        a = new i4();
    }

    public i4() {
        Boolean r1 = Boolean.TRUE;
        super("match_room_land_animutil_listen_focuschange", "赛事直播间横屏动画压缩工具是否监听焦点变化并兜底", r1, r1);
    }
}

package com.bytedance.android.live;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final SettingKey<Boolean> a = null;
    public static final SettingKey<Boolean> b = null;

    static {
        Boolean r1 = Boolean.FALSE;
        Boolean r2 = Boolean.TRUE;
        new SettingKey("web_dialog_user_annie", "web_dialog接口使用annie.", r1, r2);
        a = new SettingKey("live_room_switch_close_all_annie_dialog", "直播间切换时关闭所有annie容器弹窗", r1, r1);
        b = new SettingKey("jsb_context_use_resume_activity", "jsb调用时，若context不为activity，取最近的activity", r2, r2);
    }
}

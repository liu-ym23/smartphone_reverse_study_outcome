package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class i {

    @SerializedName("drop_public_screen_wrong_height")
    public boolean dropWrongHeight;

    @SerializedName("fix_gift_tray_pos")
    public boolean fixGiftTrayPos;

    public i() {
        this.dropWrongHeight = true;
        this.fixGiftTrayPos = true;
    }
}

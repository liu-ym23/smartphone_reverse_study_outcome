package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class OptItem {
    public final long BOTTOM;
    public final long MIDDLE;
    public final long TOP;

    @SerializedName("display_area")
    public long area;

    @SerializedName("item_id")
    public long itemId;

    @SerializedName("priority")
    public long priority;

    public OptItem() {
        this.TOP = 1;
        this.MIDDLE = 2;
        this.BOTTOM = 3;
    }
}

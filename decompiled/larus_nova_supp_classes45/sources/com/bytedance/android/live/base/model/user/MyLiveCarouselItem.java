package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class MyLiveCarouselItem {

    @SerializedName("backup_scene")
    public String backupScene;

    @SerializedName("carousel_interval")
    public int carouselInterval;

    @SerializedName("icon")
    public py.k icon;

    @SerializedName("carousel_items")
    public List<CarouselItem> items;

    @SerializedName("lynx_container")
    public LynxContainer jumpContainer;

    public MyLiveCarouselItem() {
    }
}

package com.bytedance.android.ec.core.imagex;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/l;", "", "", "", "preloadSceneTags", "Ljava/util/List;", "a", "()Ljava/util/List;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("preload_scene_tags")
    private final List<String> preloadSceneTags;

    public l() {
        this.preloadSceneTags = CollectionsKt.mutableListOf(new String[]{"ec_na_mall_header", "ec_na_mall_top_category_tab", "ec_na_mall_topbar"});
    }

    public final List<String> a() {
        return this.preloadSceneTags;
    }
}

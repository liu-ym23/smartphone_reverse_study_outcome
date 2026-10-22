package com.bytedance.android.live.profit.dress.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0013\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001e\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\b\u001a\u0004\b\u001c\u0010\u0016R\"\u0010#\u001a\u00020\u00148&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\b\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010!R\u001a\u0010&\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\b\u001a\u0004\b$\u0010\u0016¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/l;", "Lvh7/c;", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getEffectScenes", "()Ljava/util/List;", "getEffectScenes$annotations", "()V", "effectScenes", "", "getGlobalValid", "()Z", "getGlobalValid$annotations", "globalValid", "", "getAllowListId", "()J", "getAllowListId$annotations", "allowListId", "", "getStartPlayModeBgImg", "()Ljava/lang/String;", "getStartPlayModeBgImg$annotations", "startPlayModeBgImg", "getHonorRanklistBgImg", "getHonorRanklistBgImg$annotations", "honorRanklistBgImg", "getBannerBgImg", "getBannerBgImg$annotations", "bannerBgImg", "getBannerBgImgAudience", "setBannerBgImgAudience", "(Ljava/lang/String;)V", "getBannerBgImgAudience$annotations", "bannerBgImgAudience", "getPlayModeDetailImg", "getPlayModeDetailImg$annotations", "playModeDetailImg", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface l extends vh7.c<l> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "allow_list_id")
    long getAllowListId();

    @FieldName(name = "banner_bg_img")
    String getBannerBgImg();

    @FieldName(name = "banner_bg_img_audience")
    String getBannerBgImgAudience();

    @FieldName(name = "effect_scenes")
    List<Integer> getEffectScenes();

    @FieldName(name = "global_valid")
    boolean getGlobalValid();

    @FieldName(name = "honor_ranklist_bg_img")
    String getHonorRanklistBgImg();

    @FieldName(name = "play_mode_detail_img")
    String getPlayModeDetailImg();

    @FieldName(name = "start_play_mode_bg_img")
    String getStartPlayModeBgImg();

    @FieldName(name = "banner_bg_img_audience#setter")
    void setBannerBgImgAudience(String r1);
}

package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0012\u0010\rR\"\u0010\u001a\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0019\u0010\b\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001e\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001d\u0010\b\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010\"\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b!\u0010\b\u001a\u0004\b\u001f\u0010\u0004\"\u0004\b \u0010\u0006R\u001a\u0010'\u001a\u00020#8&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\b\u001a\u0004\b$\u0010%R\u001a\u0010*\u001a\u00020#8&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\b\u001a\u0004\b(\u0010%R \u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8&X§\u0004¢\u0006\f\u0012\u0004\b,\u0010\b\u001a\u0004\b+\u0010\rR.\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020.8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b3\u0010\b\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/a2;", "Lvh7/c;", BuildConfig.FLAVOR, "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "getScene$annotations", "()V", "scene", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getGiftIds", "()Ljava/util/List;", "setGiftIds", "(Ljava/util/List;)V", "getGiftIds$annotations", "giftIds", "getTagIds", "getTagIds$annotations", "tagIds", "getStartTime", "()J", "setStartTime", "(J)V", "getStartTime$annotations", "startTime", "getEndTime", "setEndTime", "getEndTime$annotations", "endTime", "getExtra", "setExtra", "getExtra$annotations", "extra", BuildConfig.FLAVOR, "getStrategyType", "()I", "getStrategyType$annotations", "strategyType", "getUpdateType", "getUpdateType$annotations", "updateType", "getEffectedGiftIds", "getEffectedGiftIds$annotations", "effectedGiftIds", BuildConfig.FLAVOR, "getEventTrack", "()Ljava/util/Map;", "setEventTrack", "(Ljava/util/Map;)V", "getEventTrack$annotations", "eventTrack", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a2 extends vh7.c<a2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "effected_gift_ids")
    List<Long> getEffectedGiftIds();

    @FieldName(name = "end_time")
    long getEndTime();

    @FieldName(name = "event_track")
    Map<String, String> getEventTrack();

    @FieldName(name = "extra")
    String getExtra();

    @FieldName(name = "gift_ids")
    List<Long> getGiftIds();

    @FieldName(name = "scene")
    String getScene();

    @FieldName(name = "start_time")
    long getStartTime();

    @FieldName(name = "strategy_type")
    int getStrategyType();

    @FieldName(name = "tag_ids")
    List<Long> getTagIds();

    @FieldName(name = "update_type")
    int getUpdateType();

    @FieldName(name = "end_time#setter")
    void setEndTime(long r1);

    @FieldName(name = "event_track#setter")
    void setEventTrack(Map<String, String> r1);

    @FieldName(name = "extra#setter")
    void setExtra(String r1);

    @FieldName(name = "gift_ids#setter")
    void setGiftIds(List<Long> r1);

    @FieldName(name = "scene#setter")
    void setScene(String r1);

    @FieldName(name = "start_time#setter")
    void setStartTime(long r1);
}

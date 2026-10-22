package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/v1;", "Lvh7/c;", BuildConfig.FLAVOR, "getButtonType", "()I", "getButtonType$annotations", "()V", "buttonType", "getSendGiftCount", "getSendGiftCount$annotations", "sendGiftCount", BuildConfig.FLAVOR, "getTextBeforeMission", "()Ljava/lang/String;", "getTextBeforeMission$annotations", "textBeforeMission", "getTextAfterMission", "getTextAfterMission$annotations", "textAfterMission", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface v1 extends vh7.c<v1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "button_type")
    int getButtonType();

    @FieldName(name = "send_gift_count")
    int getSendGiftCount();

    @FieldName(name = "text_after_mission")
    String getTextAfterMission();

    @FieldName(name = "text_before_mission")
    String getTextBeforeMission();
}

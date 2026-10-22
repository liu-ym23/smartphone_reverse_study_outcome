package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/j2;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/gift/model/c2;", BuildConfig.FLAVOR, "getRemainTime", "()J", "setRemainTime", "(J)V", "getRemainTime$annotations", "()V", "remainTime", "Lcom/bytedance/android/live/base/model/message/a5;", "getTimeSuffixText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setTimeSuffixText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "getTimeSuffixText$annotations", "timeSuffixText", "getDeadLineTime", "setDeadLineTime", "getDeadLineTime$annotations", "deadLineTime", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface j2 extends vh7.e<c2>, c2 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "background_color")
    /* synthetic */ String getBackgroundColor();

    @FieldName(name = "countdown_deadline_time")
    long getDeadLineTime();

    @FieldName(name = "display_text")
    /* synthetic */ a5 getDisplayText();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "prefix_image")
    /* synthetic */ py.k getPrefixImage();

    @FieldName(name = "remaining_duration")
    long getRemainTime();

    @FieldName(name = "remaining_duration_suffix_text")
    a5 getTimeSuffixText();

    @FieldName(name = "background_color#setter")
    /* synthetic */ void setBackgroundColor(String r1);

    @FieldName(name = "countdown_deadline_time#setter")
    void setDeadLineTime(long r1);

    @FieldName(name = "display_text#setter")
    /* synthetic */ void setDisplayText(a5 r1);

    @FieldName(name = "prefix_image#setter")
    /* synthetic */ void setPrefixImage(py.k r1);

    @FieldName(name = "remaining_duration#setter")
    void setRemainTime(long r1);

    @FieldName(name = "remaining_duration_suffix_text#setter")
    void setTimeSuffixText(a5 r1);
}

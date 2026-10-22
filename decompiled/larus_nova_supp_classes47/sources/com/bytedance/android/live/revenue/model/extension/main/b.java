package com.bytedance.android.live.revenue.model.extension.main;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0017\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R*\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\u001c\u001a\u00020\u000f8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001f\u001a\u00020\u000f8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001d\u0010\u0011R\u001a\u0010\"\u001a\u00020\u000f8VX\u0097\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0006\u001a\u0004\b \u0010\u0011R\u001a\u0010%\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0006\u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/revenue/model/extension/main/b;", "Lvh7/c;", "", "getPanelSchema", "()Ljava/lang/String;", "getPanelSchema$annotations", "()V", "panelSchema", "", "Lcom/bytedance/android/live/revenue/model/extension/main/d;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getPeriodTexts", "()Ljava/util/List;", "getPeriodTexts$annotations", "periodTexts", "", "getDisplayDuration", "()I", "getDisplayDuration$annotations", "displayDuration", "getJumpSchema", "getJumpSchema$annotations", "jumpSchema", "getAnimationType", "getAnimationType$annotations", "animationType", "getAnimationGap", "getAnimationGap$annotations", "animationGap", "getAnimationFreq", "getAnimationFreq$annotations", "animationFreq", "getTextRoundPeriod", "getTextRoundPeriod$annotations", "textRoundPeriod", "getExtra", "getExtra$annotations", "extra", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface b extends vh7.c<b> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ e castTo(Class r1);

    /* synthetic */ e castToOrNull(Class r1);

    @FieldName(name = "animation_freq")
    int getAnimationFreq();

    @FieldName(name = "animation_gap")
    int getAnimationGap();

    @FieldName(name = "animation_type")
    String getAnimationType();

    @FieldName(name = "display_duration")
    int getDisplayDuration();

    @FieldName(name = "extra")
    String getExtra();

    @FieldName(name = "jump_schema")
    String getJumpSchema();

    @FieldName(name = "panel_schema")
    String getPanelSchema();

    @FieldName(name = "period_texts")
    List<d> getPeriodTexts();

    @FieldName(name = "text_round_period")
    int getTextRoundPeriod();
}

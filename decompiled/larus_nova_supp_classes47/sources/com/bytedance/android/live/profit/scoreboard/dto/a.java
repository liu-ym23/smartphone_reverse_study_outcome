package com.bytedance.android.live.profit.scoreboard.dto;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0007\u001a\u0004\b\n\u0010\u0005R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/dto/a;", "Lvh7/c;", "", "", "getDurationChoices", "()Ljava/util/List;", "getDurationChoices$annotations", "()V", "durationChoices", "Lcom/bytedance/android/live/profit/scoreboard/dto/f;", "getRules", "getRules$annotations", "rules", "Lcom/bytedance/android/live/profit/scoreboard/dto/p;", "getLinkmicInfo", "()Lcom/bytedance/android/live/profit/scoreboard/dto/p;", "getLinkmicInfo$annotations", "linkmicInfo", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface a extends vh7.c<a> {

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.scoreboard.dto.a$a, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class C0050a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "duration_choices")
    List<Long> getDurationChoices();

    @FieldName(name = "linkmic_info")
    p getLinkmicInfo();

    @FieldName(name = "rules")
    List<f> getRules();
}

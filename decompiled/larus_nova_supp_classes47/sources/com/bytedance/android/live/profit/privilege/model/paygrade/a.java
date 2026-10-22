package com.bytedance.android.live.profit.privilege.model.paygrade;

import com.bytedance.android.live.base.model.user.v;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001d\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001c\u0010\u0019R\"\u0010$\u001a\n\u0018\u00010\u001fj\u0004\u0018\u0001` 8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010)\u001a\u00020%8&X§\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0006\u001a\u0004\b&\u0010'R\u001a\u0010.\u001a\u00020*8&X§\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0006\u001a\u0004\b+\u0010,R:\u00104\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010/j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001`08&X§\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0006\u001a\u0004\b1\u00102R\u001a\u00107\u001a\u00020*8&X§\u0004¢\u0006\f\u0012\u0004\b6\u0010\u0006\u001a\u0004\b5\u0010,R\u001c\u0010:\u001a\u0004\u0018\u00010\u00118&X§\u0004¢\u0006\f\u0012\u0004\b9\u0010\u0006\u001a\u0004\b8\u0010\u0013R\u001c\u0010=\u001a\u0004\u0018\u00010\u00118&X§\u0004¢\u0006\f\u0012\u0004\b<\u0010\u0006\u001a\u0004\b;\u0010\u0013R\u001c\u0010@\u001a\u0004\u0018\u00010\u00118&X§\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0006\u001a\u0004\b>\u0010\u0013R\"\u0010C\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u00178&X§\u0004¢\u0006\f\u0012\u0004\bB\u0010\u0006\u001a\u0004\bA\u0010\u0019R\u001a\u0010F\u001a\u00020*8&X§\u0004¢\u0006\f\u0012\u0004\bE\u0010\u0006\u001a\u0004\bD\u0010,R\u001a\u0010I\u001a\u00020*8&X§\u0004¢\u0006\f\u0012\u0004\bH\u0010\u0006\u001a\u0004\bG\u0010,R\"\u0010L\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u00178&X§\u0004¢\u0006\f\u0012\u0004\bK\u0010\u0006\u001a\u0004\bJ\u0010\u0019¨\u0006M"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/paygrade/a;", "Lvh7/c;", "", "getScore", "()J", "getScore$annotations", "()V", "score", "getLevel", "getLevel$annotations", "level", "getThisGradeMinDiamond", "getThisGradeMinDiamond$annotations", "thisGradeMinDiamond", "getThisGradeMaxDiamond", "getThisGradeMaxDiamond$annotations", "thisGradeMaxDiamond", "", "getGradeDescribe", "()Ljava/lang/String;", "getGradeDescribe$annotations", "gradeDescribe", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getNewImIconWithLevel", "()Lpy/k;", "getNewImIconWithLevel$annotations", "newImIconWithLevel", "getNewLiveIcon", "getNewLiveIcon$annotations", "newLiveIcon", "Lcom/bytedance/android/live/base/model/user/v;", "Lcom/bytedance/android/live/api/IGradeBuffInfoKt;", "getBuffInfo", "()Lcom/bytedance/android/live/base/model/user/v;", "getBuffInfo$annotations", "buffInfo", "", "getGradeDescribeShining", "()Z", "getGradeDescribeShining$annotations", "gradeDescribeShining", "", "getDescribeType", "()I", "getDescribeType$annotations", "describeType", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getExtra", "()Ljava/util/Map;", "getExtra$annotations", "extra", "getEffectType", "getEffectType$annotations", "effectType", "getShortDesc", "getShortDesc$annotations", "shortDesc", "getShortPreDesc", "getShortPreDesc$annotations", "shortPreDesc", "getJumpSchema", "getJumpSchema$annotations", "jumpSchema", "getEffectImg", "getEffectImg$annotations", "effectImg", "getEffectDurationMilli", "getEffectDurationMilli$annotations", "effectDurationMilli", "getEffectPlayTimes", "getEffectPlayTimes$annotations", "effectPlayTimes", "getRecentConsumeBadge", "getRecentConsumeBadge$annotations", "recentConsumeBadge", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends c<a> {

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.privilege.model.paygrade.a$a, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C0038a {
    }

    /* synthetic */ e castTo(Class r1);

    /* synthetic */ e castToOrNull(Class r1);

    @FieldName(name = "buff_info")
    v getBuffInfo();

    @FieldName(name = "describe_type")
    int getDescribeType();

    @FieldName(name = "effect_duration_milli")
    int getEffectDurationMilli();

    @FieldName(name = "effect_img")
    k getEffectImg();

    @FieldName(name = "effect_play_times")
    int getEffectPlayTimes();

    @FieldName(name = "effect_type")
    int getEffectType();

    @FieldName(name = "extra")
    Map<String, String> getExtra();

    @FieldName(name = "grade_describe")
    String getGradeDescribe();

    @FieldName(name = "grade_describe_shining")
    boolean getGradeDescribeShining();

    @FieldName(name = "jump_schema")
    String getJumpSchema();

    @FieldName(name = "level")
    long getLevel();

    @FieldName(name = "new_im_icon_with_level")
    k getNewImIconWithLevel();

    @FieldName(name = "new_live_icon")
    k getNewLiveIcon();

    @FieldName(name = "recent_consume_badge")
    k getRecentConsumeBadge();

    @FieldName(name = "score")
    long getScore();

    @FieldName(name = "short_desc")
    String getShortDesc();

    @FieldName(name = "short_pre_desc")
    String getShortPreDesc();

    @FieldName(name = "this_grade_max_diamond")
    long getThisGradeMaxDiamond();

    @FieldName(name = "this_grade_min_diamond")
    long getThisGradeMinDiamond();
}

package com.bytedance.android.live.profit.privilege.model.paygrade;

import com.bytedance.android.live.base.model.user.v;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\bE\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010$\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n\u0012\u0010\b\u0002\u0010%\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n\u0012\u0010\b\u0002\u0010&\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e\u0012\b\b\u0002\u0010'\u001a\u00020\u0010\u0012\b\b\u0002\u0010(\u001a\u00020\u0012\u0012(\b\u0002\u0010)\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u0015\u0012\b\b\u0002\u0010*\u001a\u00020\u0012\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010.\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n\u0012\b\b\u0002\u0010/\u001a\u00020\u0012\u0012\b\b\u0002\u00100\u001a\u00020\u0012\u0012\u0010\b\u0002\u00101\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n¢\u0006\u0004\bX\u0010YJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0003J\u0011\u0010\f\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0003J\u0011\u0010\u000f\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000eHÆ\u0003J\t\u0010\u0011\u001a\u00020\u0010HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0012HÆ\u0003J)\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u0015HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0012HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0012HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0003J\u0097\u0002\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010$\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\u0010\b\u0002\u0010%\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\u0010\b\u0002\u0010&\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e2\b\b\u0002\u0010'\u001a\u00020\u00102\b\b\u0002\u0010(\u001a\u00020\u00122(\b\u0002\u0010)\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00152\b\b\u0002\u0010*\u001a\u00020\u00122\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010.\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\b\b\u0002\u0010/\u001a\u00020\u00122\b\b\u0002\u00100\u001a\u00020\u00122\u0010\b\u0002\u00101\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0001J\t\u00103\u001a\u00020\u0007HÖ\u0001J\t\u00104\u001a\u00020\u0012HÖ\u0001J\u0013\u00106\u001a\u00020\u00102\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u001f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\b8\u00109R\u0017\u0010 \u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u00107\u001a\u0004\b:\u00109R\u0017\u0010!\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b!\u00107\u001a\u0004\b;\u00109R\u0017\u0010\"\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\"\u00107\u001a\u0004\b<\u00109R\u0019\u0010#\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b#\u0010=\u001a\u0004\b>\u0010?R\u001f\u0010$\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8\u0006¢\u0006\f\n\u0004\b$\u0010@\u001a\u0004\bA\u0010BR\u001f\u0010%\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8\u0006¢\u0006\f\n\u0004\b%\u0010@\u001a\u0004\bC\u0010BR\u001f\u0010&\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e8\u0006¢\u0006\f\n\u0004\b&\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010'\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b'\u0010G\u001a\u0004\bH\u0010IR\u0017\u0010(\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b(\u0010J\u001a\u0004\bK\u0010LR7\u0010)\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00158\u0006¢\u0006\f\n\u0004\b)\u0010M\u001a\u0004\bN\u0010OR\u0017\u0010*\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b*\u0010J\u001a\u0004\bP\u0010LR\u0019\u0010+\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b+\u0010=\u001a\u0004\bQ\u0010?R\u0019\u0010,\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b,\u0010=\u001a\u0004\bR\u0010?R\u0019\u0010-\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b-\u0010=\u001a\u0004\bS\u0010?R\u001f\u0010.\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8\u0006¢\u0006\f\n\u0004\b.\u0010@\u001a\u0004\bT\u0010BR\u0017\u0010/\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b/\u0010J\u001a\u0004\bU\u0010LR\u0017\u00100\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b0\u0010J\u001a\u0004\bV\u0010LR\u001f\u00101\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8\u0006¢\u0006\f\n\u0004\b1\u0010@\u001a\u0004\bW\u0010B¨\u0006Z"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/paygrade/PayGrade;", "", "", "component1", "component2", "component3", "component4", "", "component5", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "component6", "component7", "Lcom/bytedance/android/live/base/model/user/v;", "Lcom/bytedance/android/live/api/IGradeBuffInfoKt;", "component8", "", "component9", "", "component10", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "score", "level", "this_grade_min_diamond", "this_grade_max_diamond", "grade_describe", "new_im_icon_with_level", "new_live_icon", "buff_info", "grade_describe_shining", "describe_type", "extra", "effectType", "shortDesc", "shortPreDesc", "jumpSchema", "effectImg", "effectDurationMilli", "effectPlayTimes", "recentConsumeBadge", "copy", "toString", "hashCode", "other", "equals", "J", "getScore", "()J", "getLevel", "getThis_grade_min_diamond", "getThis_grade_max_diamond", "Ljava/lang/String;", "getGrade_describe", "()Ljava/lang/String;", "Lpy/k;", "getNew_im_icon_with_level", "()Lpy/k;", "getNew_live_icon", "Lcom/bytedance/android/live/base/model/user/v;", "getBuff_info", "()Lcom/bytedance/android/live/base/model/user/v;", "Z", "getGrade_describe_shining", "()Z", "I", "getDescribe_type", "()I", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "getEffectType", "getShortDesc", "getShortPreDesc", "getJumpSchema", "getEffectImg", "getEffectDurationMilli", "getEffectPlayTimes", "getRecentConsumeBadge", "<init>", "(JJJJLjava/lang/String;Lpy/k;Lpy/k;Lcom/bytedance/android/live/base/model/user/v;ZILjava/util/Map;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lpy/k;IILpy/k;)V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PayGrade {
    private final v buff_info;
    private final int describe_type;
    private final int effectDurationMilli;
    private final k effectImg;
    private final int effectPlayTimes;
    private final int effectType;
    private final Map<String, String> extra;
    private final String grade_describe;
    private final boolean grade_describe_shining;
    private final String jumpSchema;
    private final long level;
    private final k new_im_icon_with_level;
    private final k new_live_icon;
    private final k recentConsumeBadge;
    private final long score;
    private final String shortDesc;
    private final String shortPreDesc;
    private final long this_grade_max_diamond;
    private final long this_grade_min_diamond;

    public PayGrade() {
        this(0, 0, 0, 0, null, null, null, null, false, 0, null, 0, null, null, null, null, 0, 0, null, 524287, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PayGrade copy$default(PayGrade r17, long r18, long r20, long r22, long r24, String r26, k r27, k r28, v r29, boolean r30, int r32, Map r33, int r34, String r35, String r36, String r37, k r38, int r39, int r310, k r40, int r42, Object r43) {
        if ((r42 & 1) == 0) goto L5;
        long r2 = r17.score;
    L7:
        if ((r42 & 2) == 0) goto L9;
        long r4 = r17.level;
    L11:
        if ((r42 & 4) == 0) goto L13;
        long r6 = r17.this_grade_min_diamond;
    L15:
        if ((r42 & 8) == 0) goto L17;
        long r8 = r17.this_grade_max_diamond;
    L19:
        if ((r42 & 16) == 0) goto L21;
        String r10 = r17.grade_describe;
    L23:
        if ((r42 & 32) == 0) goto L25;
        k r12 = r17.new_im_icon_with_level;
    L27:
        if ((r42 & 64) == 0) goto L29;
        k r13 = r17.new_live_icon;
    L31:
        if ((r42 & 128) == 0) goto L33;
        v r14 = r17.buff_info;
    L35:
        if ((r42 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L37;
        boolean r15 = r17.grade_describe_shining;
    L39:
        if ((r42 & 512) == 0) goto L41;
        int r16 = r17.describe_type;
    L42:
        int r311 = r16;
        if ((r42 & 1024) == 0) goto L45;
        Map r19 = r17.extra;
    L46:
        Map r312 = r19;
        if ((r42 & 2048) == 0) goto L49;
        int r110 = r17.effectType;
    L50:
        int r313 = r110;
        if ((r42 & 4096) == 0) goto L53;
        String r111 = r17.shortDesc;
    L54:
        String r314 = r111;
        if ((r42 & 8192) == 0) goto L57;
        String r112 = r17.shortPreDesc;
    L58:
        String r315 = r112;
        if ((r42 & 16384) == 0) goto L61;
        String r113 = r17.jumpSchema;
    L62:
        String r316 = r113;
        if ((r42 & 32768) == 0) goto L65;
        k r114 = r17.effectImg;
    L66:
        k r317 = r114;
        if ((r42 & 65536) == 0) goto L69;
        int r115 = r17.effectDurationMilli;
    L70:
        int r318 = r115;
        if ((r42 & 131072) == 0) goto L73;
        int r116 = r17.effectPlayTimes;
    L75:
        if ((r42 & 262144) == 0) goto L77;
        k r1 = r17.recentConsumeBadge;
    L79:
        return r17.copy(r2, r4, r6, r8, r10, r12, r13, r14, r15, r311, r312, r313, r314, r315, r316, r317, r318, r116, r1);
    L77:
        r1 = r40;
        goto L79
    L73:
        r116 = r310;
        goto L75
    L69:
        r115 = r39;
        goto L70
    L65:
        r114 = r38;
        goto L66
    L61:
        r113 = r37;
        goto L62
    L57:
        r112 = r36;
        goto L58
    L53:
        r111 = r35;
        goto L54
    L49:
        r110 = r34;
        goto L50
    L45:
        r19 = r33;
        goto L46
    L41:
        r16 = r32;
        goto L42
    L37:
        r15 = r30;
        goto L39
    L33:
        r14 = r29;
        goto L35
    L29:
        r13 = r28;
        goto L31
    L25:
        r12 = r27;
        goto L27
    L21:
        r10 = r26;
        goto L23
    L17:
        r8 = r24;
        goto L19
    L13:
        r6 = r22;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final long component1() {
        return this.score;
    }

    public final int component10() {
        return this.describe_type;
    }

    public final Map<String, String> component11() {
        return this.extra;
    }

    public final int component12() {
        return this.effectType;
    }

    public final String component13() {
        return this.shortDesc;
    }

    public final String component14() {
        return this.shortPreDesc;
    }

    public final String component15() {
        return this.jumpSchema;
    }

    public final k component16() {
        return this.effectImg;
    }

    public final int component17() {
        return this.effectDurationMilli;
    }

    public final int component18() {
        return this.effectPlayTimes;
    }

    public final k component19() {
        return this.recentConsumeBadge;
    }

    public final long component2() {
        return this.level;
    }

    public final long component3() {
        return this.this_grade_min_diamond;
    }

    public final long component4() {
        return this.this_grade_max_diamond;
    }

    public final String component5() {
        return this.grade_describe;
    }

    public final k component6() {
        return this.new_im_icon_with_level;
    }

    public final k component7() {
        return this.new_live_icon;
    }

    public final v component8() {
        return this.buff_info;
    }

    public final boolean component9() {
        return this.grade_describe_shining;
    }

    public final PayGrade copy(long r26, long r28, long r30, long r32, String r34, k r35, k r36, v r37, boolean r38, int r39, Map<String, String> r40, int r42, String r43, String r44, String r45, k r46, int r47, int r48, k r49) {
        return new PayGrade(r26, r28, r30, r32, r34, r35, r36, r37, r38, r39, r40, r42, r43, r44, r45, r46, r47, r48, r49);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof PayGrade) == false) goto L44;
        PayGrade r7 = (PayGrade) r6;
        if (this.score == r7.score) goto L8;
        return false;
    L8:
        if (this.level == r7.level) goto L10;
        return false;
    L10:
        if (this.this_grade_min_diamond == r7.this_grade_min_diamond) goto L12;
        return false;
    L12:
        if (this.this_grade_max_diamond == r7.this_grade_max_diamond) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.grade_describe, r7.grade_describe) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.new_im_icon_with_level, r7.new_im_icon_with_level) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.new_live_icon, r7.new_live_icon) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.buff_info, r7.buff_info) == true) goto L22;
        return false;
    L22:
        if (this.grade_describe_shining == r7.grade_describe_shining) goto L24;
        return false;
    L24:
        if (this.describe_type == r7.describe_type) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.extra, r7.extra) == true) goto L28;
        return false;
    L28:
        if (this.effectType == r7.effectType) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.shortDesc, r7.shortDesc) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.shortPreDesc, r7.shortPreDesc) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.jumpSchema, r7.jumpSchema) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.effectImg, r7.effectImg) == true) goto L38;
        return false;
    L38:
        if (this.effectDurationMilli == r7.effectDurationMilli) goto L40;
        return false;
    L40:
        if (this.effectPlayTimes == r7.effectPlayTimes) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.recentConsumeBadge, r7.recentConsumeBadge) == true) goto L67;
        return false;
    L67:
        return true;
    L44:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    public int hashCode() {
        long r0 = this.score;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.level;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.this_grade_min_diamond;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.this_grade_max_diamond;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        String r8 = this.grade_describe;
        int r9 = 0;
        if (r8 == null) goto L5;
        int r10 = r8.hashCode();
    L6:
        int r12 = (r7 + r10) * 31;
        k r13 = this.new_im_icon_with_level;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (r12 + r14) * 31;
        k r16 = this.new_live_icon;
        if (r16 == null) goto L13;
        int r17 = r16.hashCode();
    L14:
        int r18 = (r15 + r17) * 31;
        v r19 = this.buff_info;
        if (r19 == null) goto L17;
        int r20 = r19.hashCode();
    L18:
        int r22 = (r18 + r20) * 31;
        boolean r23 = this.grade_describe_shining;
        ?? r24 = r23;
        if (r23 == false) goto L21;
        r24 = 1;
    L21:
        int r25 = (((r22 + r24) * 31) + this.describe_type) * 31;
        Map<String, String> r26 = this.extra;
        if (r26 == null) goto L24;
        int r27 = r26.hashCode();
    L25:
        int r28 = (((r25 + r27) * 31) + this.effectType) * 31;
        String r29 = this.shortDesc;
        if (r29 == null) goto L28;
        int r30 = r29.hashCode();
    L29:
        int r32 = (r28 + r30) * 31;
        String r33 = this.shortPreDesc;
        if (r33 == null) goto L32;
        int r34 = r33.hashCode();
    L33:
        int r35 = (r32 + r34) * 31;
        String r36 = this.jumpSchema;
        if (r36 == null) goto L36;
        int r37 = r36.hashCode();
    L37:
        int r38 = (r35 + r37) * 31;
        k r39 = this.effectImg;
        if (r39 == null) goto L40;
        int r40 = r39.hashCode();
    L41:
        int r42 = (((((r38 + r40) * 31) + this.effectDurationMilli) * 31) + this.effectPlayTimes) * 31;
        k r43 = this.recentConsumeBadge;
        if (r43 == null) goto L45;
        r9 = r43.hashCode();
    L45:
        return r42 + r9;
    L40:
        r40 = 0;
        goto L41
    L36:
        r37 = 0;
        goto L37
    L32:
        r34 = 0;
        goto L33
    L28:
        r30 = 0;
        goto L29
    L24:
        r27 = 0;
        goto L25
    L17:
        r20 = 0;
        goto L18
    L13:
        r17 = 0;
        goto L14
    L9:
        r14 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "PayGrade(score=" + this.score + ", level=" + this.level + ", this_grade_min_diamond=" + this.this_grade_min_diamond + ", this_grade_max_diamond=" + this.this_grade_max_diamond + ", grade_describe=" + this.grade_describe + ", new_im_icon_with_level=" + this.new_im_icon_with_level + ", new_live_icon=" + this.new_live_icon + ", buff_info=" + this.buff_info + ", grade_describe_shining=" + this.grade_describe_shining + ", describe_type=" + this.describe_type + ", extra=" + this.extra + ", effectType=" + this.effectType + ", shortDesc=" + this.shortDesc + ", shortPreDesc=" + this.shortPreDesc + ", jumpSchema=" + this.jumpSchema + ", effectImg=" + this.effectImg + ", effectDurationMilli=" + this.effectDurationMilli + ", effectPlayTimes=" + this.effectPlayTimes + ", recentConsumeBadge=" + this.recentConsumeBadge + ")";
    }

    public final v getBuff_info() {
        return this.buff_info;
    }

    public final int getDescribe_type() {
        return this.describe_type;
    }

    public final int getEffectDurationMilli() {
        return this.effectDurationMilli;
    }

    public final k getEffectImg() {
        return this.effectImg;
    }

    public final int getEffectPlayTimes() {
        return this.effectPlayTimes;
    }

    public final int getEffectType() {
        return this.effectType;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getGrade_describe() {
        return this.grade_describe;
    }

    public final boolean getGrade_describe_shining() {
        return this.grade_describe_shining;
    }

    public final String getJumpSchema() {
        return this.jumpSchema;
    }

    public final long getLevel() {
        return this.level;
    }

    public final k getNew_im_icon_with_level() {
        return this.new_im_icon_with_level;
    }

    public final k getNew_live_icon() {
        return this.new_live_icon;
    }

    public final k getRecentConsumeBadge() {
        return this.recentConsumeBadge;
    }

    public final long getScore() {
        return this.score;
    }

    public final String getShortDesc() {
        return this.shortDesc;
    }

    public final String getShortPreDesc() {
        return this.shortPreDesc;
    }

    public final long getThis_grade_max_diamond() {
        return this.this_grade_max_diamond;
    }

    public final long getThis_grade_min_diamond() {
        return this.this_grade_min_diamond;
    }

    public PayGrade(long r4, long r6, long r8, long r10, String r12, k r13, k r14, v r15, boolean r16, int r17, Map<String, String> r18, int r19, String r20, String r22, String r23, k r24, int r25, int r26, k r27) {
        this.score = r4;
        this.level = r6;
        this.this_grade_min_diamond = r8;
        this.this_grade_max_diamond = r10;
        this.grade_describe = r12;
        this.new_im_icon_with_level = r13;
        this.new_live_icon = r14;
        this.buff_info = r15;
        this.grade_describe_shining = r16;
        this.describe_type = r17;
        this.extra = r18;
        this.effectType = r19;
        this.shortDesc = r20;
        this.shortPreDesc = r22;
        this.jumpSchema = r23;
        this.effectImg = r24;
        this.effectDurationMilli = r25;
        this.effectPlayTimes = r26;
        this.recentConsumeBadge = r27;
    }

    public /* synthetic */ PayGrade(long r24, long r26, long r28, long r30, String r32, k r33, k r34, v r35, boolean r36, int r37, Map r38, int r39, String r40, String r42, String r43, k r44, int r45, int r46, k r47, int r48, DefaultConstructorMarker r49) {
        long r2 = 0;
        if ((r48 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r48 & 2) == 0) goto L9;
        long r6 = 0;
    L11:
        if ((r48 & 4) == 0) goto L13;
        long r8 = 0;
    L15:
        if ((r48 & 8) != 0) goto L19;
        r2 = r30;
    L19:
        if ((r48 & 16) == 0) goto L21;
        String r1 = null;
    L23:
        if ((r48 & 32) == 0) goto L25;
        k r12 = null;
    L27:
        if ((r48 & 64) == 0) goto L29;
        k r13 = null;
    L31:
        if ((r48 & 128) == 0) goto L33;
        v r14 = null;
    L35:
        if ((r48 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L37;
        boolean r15 = false;
    L39:
        if ((r48 & 512) == 0) goto L41;
        int r10 = 0;
    L43:
        if ((r48 & 1024) == 0) goto L45;
        Map r16 = null;
    L46:
        Map r410 = r16;
        if ((r48 & 2048) == 0) goto L49;
        int r17 = 0;
    L50:
        int r18 = r17;
        if ((r48 & 4096) == 0) goto L53;
        String r19 = null;
    L54:
        String r110 = r19;
        if ((r48 & 8192) == 0) goto L57;
        String r111 = null;
    L58:
        String r112 = r111;
        if ((r48 & 16384) == 0) goto L61;
        String r113 = null;
    L63:
        if ((r48 & 32768) == 0) goto L65;
        k r114 = null;
    L67:
        if ((r48 & 65536) == 0) goto L69;
        int r20 = 0;
    L71:
        if ((r48 & 131072) == 0) goto L73;
        int r22 = 0;
    L75:
        if ((r48 & 262144) == 0) goto L77;
        k r0 = null;
    L78:
        this(r4, r6, r8, r2, r1, r12, r13, r14, r15, r10, r410, r18, r110, r112, r113, r114, r20, r22, r0);
        return;
    L77:
        r0 = r47;
        goto L78
    L73:
        r22 = r46;
        goto L75
    L69:
        r20 = r45;
        goto L71
    L65:
        r114 = r44;
        goto L67
    L61:
        r113 = r43;
        goto L63
    L57:
        r111 = r42;
        goto L58
    L53:
        r19 = r40;
        goto L54
    L49:
        r17 = r39;
        goto L50
    L45:
        r16 = r38;
        goto L46
    L41:
        r10 = r37;
        goto L43
    L37:
        r15 = r36;
        goto L39
    L33:
        r14 = r35;
        goto L35
    L29:
        r13 = r34;
        goto L31
    L25:
        r12 = r33;
        goto L27
    L21:
        r1 = r32;
        goto L23
    L13:
        r8 = r28;
        goto L15
    L9:
        r6 = r26;
        goto L11
    L5:
        r4 = r24;
        goto L7
    }
}

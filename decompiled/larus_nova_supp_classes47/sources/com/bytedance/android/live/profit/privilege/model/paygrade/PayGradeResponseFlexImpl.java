package com.bytedance.android.live.profit.privilege.model.paygrade;

import am3.g;
import com.bytedance.android.live.base.model.user.v;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.privilege.PayGradeResponse.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0019\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bO\u0010PR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR$\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001b\u0010\u001f\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\"\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR\u001b\u0010%\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u001eR\u001b\u0010(\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010\u001eR\u001d\u0010-\u001a\u0004\u0018\u00010)8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u001c\u001a\u0004\b+\u0010,R\u001b\u00102\u001a\u00020.8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u001c\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u001c\u001a\u0004\b5\u00106R)\u0010<\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u0001088VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u001c\u001a\u0004\b:\u0010;R\u001b\u0010?\u001a\u0002038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u001c\u001a\u0004\b>\u00106R\u001d\u0010B\u001a\u0004\u0018\u00010)8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u001c\u001a\u0004\bA\u0010,R\u001d\u0010E\u001a\u0004\u0018\u00010)8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u001c\u001a\u0004\bD\u0010,R\u001d\u0010H\u001a\u0004\u0018\u00010)8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u001c\u001a\u0004\bG\u0010,R\u001b\u0010K\u001a\u0002038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\u001c\u001a\u0004\bJ\u00106R\u001b\u0010N\u001a\u0002038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u001c\u001a\u0004\bM\u00106¨\u0006Q"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/paygrade/PayGradeResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/paygrade/a;", "Lpy/k;", "newImIconWithLevel", "Lpy/k;", "getNewImIconWithLevel", "()Lpy/k;", "setNewImIconWithLevel", "(Lpy/k;)V", "newLiveIcon", "getNewLiveIcon", "setNewLiveIcon", "Lcom/bytedance/android/live/base/model/user/v;", "buffInfo", "Lcom/bytedance/android/live/base/model/user/v;", "getBuffInfo", "()Lcom/bytedance/android/live/base/model/user/v;", "setBuffInfo", "(Lcom/bytedance/android/live/base/model/user/v;)V", "effectImg", "getEffectImg", "setEffectImg", "recentConsumeBadge", "getRecentConsumeBadge", "setRecentConsumeBadge", "", "score$delegate", "Ljava/lang/Object;", "getScore", "()J", "score", "level$delegate", "getLevel", "level", "thisGradeMinDiamond$delegate", "getThisGradeMinDiamond", "thisGradeMinDiamond", "thisGradeMaxDiamond$delegate", "getThisGradeMaxDiamond", "thisGradeMaxDiamond", "", "gradeDescribe$delegate", "getGradeDescribe", "()Ljava/lang/String;", "gradeDescribe", "", "gradeDescribeShining$delegate", "getGradeDescribeShining", "()Z", "gradeDescribeShining", "", "describeType$delegate", "getDescribeType", "()I", "describeType", "", "extra$delegate", "getExtra", "()Ljava/util/Map;", "extra", "effectType$delegate", "getEffectType", "effectType", "shortDesc$delegate", "getShortDesc", "shortDesc", "shortPreDesc$delegate", "getShortPreDesc", "shortPreDesc", "jumpSchema$delegate", "getJumpSchema", "jumpSchema", "effectDurationMilli$delegate", "getEffectDurationMilli", "effectDurationMilli", "effectPlayTimes$delegate", "getEffectPlayTimes", "effectPlayTimes", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PayGradeResponseFlexImpl extends FlexModelBase<a> implements a, h {

    @SerializedName("describe_type")
    protected int _$$describeType;

    @SerializedName("effect_duration_milli")
    protected int _$$effectDurationMilli;

    @SerializedName("effect_play_times")
    protected int _$$effectPlayTimes;

    @SerializedName("effect_type")
    protected int _$$effectType;

    @SerializedName("extra")
    protected Map<String, String> _$$extra;

    @SerializedName("grade_describe")
    protected String _$$gradeDescribe;

    @SerializedName("grade_describe_shining")
    protected boolean _$$gradeDescribeShining;

    @SerializedName("jump_schema")
    protected String _$$jumpSchema;

    @SerializedName("level")
    protected long _$$level;

    @SerializedName("score")
    protected long _$$score;

    @SerializedName("short_desc")
    protected String _$$shortDesc;

    @SerializedName("short_pre_desc")
    protected String _$$shortPreDesc;

    @SerializedName("this_grade_max_diamond")
    protected long _$$thisGradeMaxDiamond;

    @SerializedName("this_grade_min_diamond")
    protected long _$$thisGradeMinDiamond;

    @SerializedName("buff_info")
    protected v buffInfo;

    @SerializedName("effect_img")
    protected k effectImg;

    @SerializedName("new_im_icon_with_level")
    protected k newImIconWithLevel;

    @SerializedName("new_live_icon")
    protected k newLiveIcon;

    @SerializedName("recent_consume_badge")
    protected k recentConsumeBadge;

    public PayGradeResponseFlexImpl() {
        super(a.class);
        this._$$gradeDescribeShining = false;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.paygrade.a
    public v getBuffInfo() {
        return this.buffInfo;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.paygrade.a
    public final int getDescribeType() {
        return this._$$describeType;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.paygrade.a
    public final int getEffectDurationMilli() {
        return this._$$effectDurationMilli;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.paygrade.a
    public k getEffectImg() {
        return this.effectImg;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.paygrade.a
    public final int getEffectPlayTimes() {
        return this._$$effectPlayTimes;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.paygrade.a
    public final int getEffectType() {
        return this._$$effectType;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.paygrade.a
    public final Map<String, String> getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.paygrade.a
    public final String getGradeDescribe() {
        return this._$$gradeDescribe;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.paygrade.a
    public final boolean getGradeDescribeShining() {
        return this._$$gradeDescribeShining;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.paygrade.a
    public final String getJumpSchema() {
        return this._$$jumpSchema;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.paygrade.a
    public final long getLevel() {
        return this._$$level;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.paygrade.a
    public k getNewImIconWithLevel() {
        return this.newImIconWithLevel;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.paygrade.a
    public k getNewLiveIcon() {
        return this.newLiveIcon;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.paygrade.a
    public k getRecentConsumeBadge() {
        return this.recentConsumeBadge;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.paygrade.a
    public final long getScore() {
        return this._$$score;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.paygrade.a
    public final String getShortDesc() {
        return this._$$shortDesc;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.paygrade.a
    public final String getShortPreDesc() {
        return this._$$shortPreDesc;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.paygrade.a
    public final long getThisGradeMaxDiamond() {
        return this._$$thisGradeMaxDiamond;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.paygrade.a
    public final long getThisGradeMinDiamond() {
        return this._$$thisGradeMinDiamond;
    }

    /* JADX WARN: Type inference failed for: r4v11, types: [com.bytedance.android.live.base.model.user.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v23, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v27, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.lang.Object, py.k] */
    public PayGradeResponseFlexImpl(g r13) {
        super(a.class);
        this._$$extra = new HashMap();
        setThreadSafe(false);
        long r1 = r13.c();
        int r3 = 0;
    L3:
        int r4 = r13.f();
        if (r4 == (-1)) goto L43;
        g.a r7 = decodeExtensionFields(r4, r13);
        switch(r4) {
            case 1: goto L42;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L38;
            case 6: goto L37;
            case 7: goto L36;
            case 8: goto L35;
            case 9: goto L34;
            case 10: goto L33;
            case 11: goto L16;
            case 12: goto L15;
            case 13: goto L14;
            case 14: goto L13;
            case 15: goto L12;
            case 16: goto L11;
            case 17: goto L10;
            case 18: goto L9;
            case 19: goto L8;
            default: goto L7;
        };
    L8:
        this.recentConsumeBadge = f.a(r13, k.class);
        goto L3
    L9:
        this._$$effectPlayTimes = r13.i();
        r3 = r3 | DefaultConfig.MAX_CACHE_ENTRIES;
        goto L3
    L10:
        this._$$effectDurationMilli = r13.i();
        r3 = r3 | 128;
        goto L3
    L11:
        this.effectImg = f.a(r13, k.class);
        goto L3
    L12:
        this._$$jumpSchema = am3.h.c(r13);
        goto L3
    L13:
        this._$$shortPreDesc = am3.h.c(r13);
        goto L3
    L14:
        this._$$shortDesc = am3.h.c(r13);
        goto L3
    L15:
        this._$$effectType = r13.i();
        r3 = r3 | 64;
        goto L3
    L16:
        long r8 = r13.c();
        String r5 = null;
        String r9 = null;
    L17:
        int r10 = r13.f();
        if (r10 == (-1)) goto L25;
        if (r10 != 1) goto L21;
        r5 = am3.h.c(r13);
        goto L17
    L21:
        if (r10 != 2) goto L22;
        r9 = am3.h.c(r13);
        goto L17
    L22:
        am3.h.e(r13);
        goto L17
    L25:
        r13.d(r8);
        Map<String, String> r6 = this._$$extra;
        if (r5 == null) goto L32;
        if (r9 == null) goto L30;
        r6.put(r5, r9);
        goto L3
    L30:
        throw new IllegalStateException("Value must not be null");
    L32:
        throw new IllegalStateException("Key must not be null");
    L33:
        this._$$describeType = r13.i();
        r3 = r3 | 32;
        goto L3
    L34:
        this._$$gradeDescribeShining = am3.h.a(r13);
        r3 = r3 | 16;
        goto L3
    L35:
        this.buffInfo = f.a(r13, v.class);
        goto L3
    L36:
        this.newLiveIcon = f.a(r13, k.class);
        goto L3
    L37:
        this.newImIconWithLevel = f.a(r13, k.class);
        goto L3
    L38:
        this._$$gradeDescribe = am3.h.c(r13);
        goto L3
    L39:
        this._$$thisGradeMaxDiamond = r13.j();
        r3 = r3 | 8;
        goto L3
    L40:
        this._$$thisGradeMinDiamond = r13.j();
        r3 = r3 | 4;
        goto L3
    L41:
        this._$$level = r13.j();
        r3 = r3 | 2;
        goto L3
    L42:
        this._$$score = r13.j();
        r3 = r3 | 1;
        goto L3
    L7:
        am3.h.d(r7, r13);
        goto L3
    L43:
        r13.d(r1);
        setThreadSafe(true);
        if ((r3 & 16) != 0) goto L100;
        this._$$gradeDescribeShining = false;
        return;
    }

    public void setBuffInfo(v r1) {
        this.buffInfo = r1;
    }

    public void setEffectImg(k r1) {
        this.effectImg = r1;
    }

    public void setNewImIconWithLevel(k r1) {
        this.newImIconWithLevel = r1;
    }

    public void setNewLiveIcon(k r1) {
        this.newLiveIcon = r1;
    }

    public void setRecentConsumeBadge(k r1) {
        this.recentConsumeBadge = r1;
    }
}

package com.bytedance.android.live.base.model.user;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.api.IUserHonor;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u0095\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0096\u0001B\t¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016R$\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\"\u0010)\u001a\u00020(8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020(8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\"\u00102\u001a\u00020(8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b2\u0010*\u001a\u0004\b3\u0010,\"\u0004\b4\u0010.R$\u00105\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0013\u001a\u0004\b6\u0010\u0015\"\u0004\b7\u0010\u0017R$\u00108\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0013\u001a\u0004\b9\u0010\u0015\"\u0004\b:\u0010\u0017R$\u0010;\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0013\u001a\u0004\b<\u0010\u0015\"\u0004\b=\u0010\u0017R$\u0010>\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0013\u001a\u0004\b?\u0010\u0015\"\u0004\b@\u0010\u0017R$\u0010A\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0013\u001a\u0004\bB\u0010\u0015\"\u0004\bC\u0010\u0017R\"\u0010D\u001a\u00020\u00108\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR*\u0010L\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010J8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010R\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bR\u0010 \u001a\u0004\bS\u0010\"\"\u0004\bT\u0010$R\"\u0010U\u001a\u00020(8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bU\u0010*\u001a\u0004\bV\u0010,\"\u0004\bW\u0010.R\"\u0010X\u001a\u00020(8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bX\u0010*\u001a\u0004\bY\u0010,\"\u0004\bZ\u0010.R$\u0010[\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b[\u0010\u0013\u001a\u0004\b\\\u0010\u0015\"\u0004\b]\u0010\u0017R$\u0010^\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b^\u0010\u0013\u001a\u0004\b_\u0010\u0015\"\u0004\b`\u0010\u0017R\"\u0010a\u001a\u00020(8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\ba\u0010*\u001a\u0004\bb\u0010,\"\u0004\bc\u0010.R$\u0010d\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bd\u0010 \u001a\u0004\be\u0010\"\"\u0004\bf\u0010$R\"\u0010g\u001a\u00020(8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bg\u0010*\u001a\u0004\bh\u0010,\"\u0004\bi\u0010.R$\u0010j\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bj\u0010 \u001a\u0004\bk\u0010\"\"\u0004\bl\u0010$R\"\u0010m\u001a\u00020(8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bm\u0010*\u001a\u0004\bn\u0010,\"\u0004\bo\u0010.R\"\u0010p\u001a\u00020(8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bp\u0010*\u001a\u0004\bq\u0010,\"\u0004\br\u0010.R$\u0010s\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\"\u0010y\u001a\u00020\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R&\u0010\u007f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010\u0013\u001a\u0005\b\u0080\u0001\u0010\u0015\"\u0005\b\u0081\u0001\u0010\u0017R,\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0083\u0001\u0010\u0015\"\u0005\b\u0084\u0001\u0010\u0017R,\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0086\u0001\u0010\u0015\"\u0005\b\u0087\u0001\u0010\u0017R,\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0089\u0001\u0010\u0015\"\u0005\b\u008a\u0001\u0010\u0017R,\u0010\u008e\u0001\u001a\u0004\u0018\u00010\n2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\n8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u008c\u0001\u0010v\"\u0005\b\u008d\u0001\u0010xR\u0017\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008f\u00018F¢\u0006\b\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001¨\u0006\u0097\u0001"}, d2 = {"Lcom/bytedance/android/live/base/model/user/UserHonor;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lpy/d;", "Lcom/bytedance/android/live/base/model/user/api/IUserHonor;", "other", "", "initWith", "Lpy/k;", "getHonorBuffBadge", "getRecentConsume", "Lcom/bytedance/android/live/base/model/user/v;", "getGradeBuffInfo", "", "o", "", "equals", "", "hashCode", "diamondIcon", "Lpy/k;", "getDiamondIcon", "()Lpy/k;", "setDiamondIcon", "(Lpy/k;)V", "currentHonorIcon", "getCurrentHonorIcon", "setCurrentHonorIcon", "nextHonorIcon", "getNextHonorIcon", "setNextHonorIcon", "", "nextHonorName", "Ljava/lang/String;", "getNextHonorName", "()Ljava/lang/String;", "setNextHonorName", "(Ljava/lang/String;)V", "currentHonorName", "getCurrentHonorName", "setCurrentHonorName", "", "totalDiamond", "J", "getTotalDiamond", "()J", "setTotalDiamond", "(J)V", "currentDiamond", "getCurrentDiamond", "setCurrentDiamond", "nextDiamond", "getNextDiamond", "setNextDiamond", "imIcon", "getImIcon", "setImIcon", "imIconWithLevel", "getImIconWithLevel", "setImIconWithLevel", "_newImIconWithLevel", "get_newImIconWithLevel", "set_newImIconWithLevel", "liveIcon", "getLiveIcon", "setLiveIcon", "mNewLiveIcon", "getMNewLiveIcon", "setMNewLiveIcon", "level", "I", "getLevel", "()I", "setLevel", "(I)V", "", "Lcom/bytedance/android/live/base/model/user/w;", "gradeIconList", "Ljava/util/List;", "getGradeIconList", "()Ljava/util/List;", "setGradeIconList", "(Ljava/util/List;)V", "gradeDescribe", "getGradeDescribe", "setGradeDescribe", "thisGradeMaxDiamond", "getThisGradeMaxDiamond", "setThisGradeMaxDiamond", "thisGradeMinDiamond", "getThisGradeMinDiamond", "setThisGradeMinDiamond", "profileDialogBg", "getProfileDialogBg", "setProfileDialogBg", "profileDialogBackBg", "getProfileDialogBackBg", "setProfileDialogBackBg", "upgradeNeedConsume", "getUpgradeNeedConsume", "setUpgradeNeedConsume", "gradeBanner", "getGradeBanner", "setGradeBanner", "payDiamondBak", "getPayDiamondBak", "setPayDiamondBak", "nextPrivileges", "getNextPrivileges", "setNextPrivileges", "score", "getScore", "setScore", "screenChatType", "getScreenChatType", "setScreenChatType", "_gradeBuffInfo", "Lcom/bytedance/android/live/base/model/user/v;", "get_gradeBuffInfo", "()Lcom/bytedance/android/live/base/model/user/v;", "set_gradeBuffInfo", "(Lcom/bytedance/android/live/base/model/user/v;)V", "gradeDescribeShining", "Z", "getGradeDescribeShining", "()Z", "setGradeDescribeShining", "(Z)V", "_recentConsumeBadge", "get_recentConsumeBadge", "set_recentConsumeBadge", "value", "getNewImIconWithLevel", "setNewImIconWithLevel", "newImIconWithLevel", "getNewLiveIcon", "setNewLiveIcon", "newLiveIcon", "getRecentConsumeBadge", "setRecentConsumeBadge", "recentConsumeBadge", "getBuffInfo", "setBuffInfo", "buffInfo", "Lcom/bytedance/android/live/base/model/ImageModel;", "getIconWithLevel", "()Lcom/bytedance/android/live/base/model/ImageModel;", "iconWithLevel", "<init>", "()V", "Companion", "a", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserHonor extends FlexModelBase<py.d> implements py.d, IUserHonor, vh7.h {
    public static final a Companion = null;
    public static final int HASH_31 = 31;
    public static final int HASH_32 = 32;

    @SerializedName("buff_info")
    protected v _gradeBuffInfo;

    @SerializedName("new_im_icon_with_level")
    protected py.k _newImIconWithLevel;

    @SerializedName("recent_consume_badge")
    protected py.k _recentConsumeBadge;

    @SerializedName("now_diamond")
    protected long currentDiamond;

    @SerializedName("icon")
    protected py.k currentHonorIcon;

    @SerializedName("name")
    protected String currentHonorName;

    @SerializedName("diamond_icon")
    protected py.k diamondIcon;

    @SerializedName("grade_banner")
    protected String gradeBanner;

    @SerializedName("grade_describe")
    protected String gradeDescribe;

    @SerializedName("grade_describe_shining")
    protected boolean gradeDescribeShining;

    @SerializedName("grade_icon_list")
    protected List<w> gradeIconList;

    @SerializedName("im_icon")
    protected py.k imIcon;

    @SerializedName("im_icon_with_level")
    protected py.k imIconWithLevel;

    @SerializedName("level")
    protected int level;

    @SerializedName("live_icon")
    protected py.k liveIcon;

    @SerializedName("new_live_icon")
    protected py.k mNewLiveIcon;

    @SerializedName("next_diamond")
    protected long nextDiamond;

    @SerializedName("next_icon")
    protected py.k nextHonorIcon;

    @SerializedName("next_name")
    protected String nextHonorName;

    @SerializedName("next_privileges")
    protected String nextPrivileges;

    @SerializedName("pay_diamond_bak")
    protected long payDiamondBak;

    @SerializedName("background_back")
    protected py.k profileDialogBackBg;

    @SerializedName(KtvSubElement.BACKGROUND)
    protected py.k profileDialogBg;

    @SerializedName("score")
    protected long score;

    @SerializedName("screen_chat_type")
    protected long screenChatType;

    @SerializedName("this_grade_max_diamond")
    protected long thisGradeMaxDiamond;

    @SerializedName("this_grade_min_diamond")
    protected long thisGradeMinDiamond;

    @SerializedName("total_diamond_count")
    protected long totalDiamond;

    @SerializedName("upgrade_need_consume")
    protected long upgradeNeedConsume;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public UserHonor() {
        super(py.d.class);
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public py.k getHonorBuffBadge() {
        v r0 = this._gradeBuffInfo;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        if (r0.getBuffBadge() == null) goto L8;
        v r1 = this._gradeBuffInfo;
        Intrinsics.checkNotNull(r1);
        return r1.getBuffBadge();
    L8:
        if (getNewImIconWithLevel() == null) goto L11;
        return getNewImIconWithLevel();
    L11:
        return getImIconWithLevel();
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public py.k getNewImIconWithLevel() {
        py.k r0 = this._newImIconWithLevel;
        if (r0 == null) goto L6;
        return (py.k) com.bytedance.android.live.base.model.m.b(r0, ImageModel.class);
    L6:
        return getImIconWithLevel();
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public py.k getNewLiveIcon() {
        py.k r0 = this.mNewLiveIcon;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getLiveIcon();
    }

    public final ImageModel getIconWithLevel() {
        py.k r0 = getNewImIconWithLevel();
        if ((r0 instanceof ImageModel) == true) goto L6;
        r0 = null;
    L6:
        return (ImageModel) r0;
    }

    public int hashCode() {
        int r1 = 0;
        if (getDiamondIcon() == null) goto L7;
        py.k r0 = getDiamondIcon();
        if (r0 == null) goto L7;
        int r2 = r0.hashCode();
    L8:
        int r3 = r2 * 31;
        if (getCurrentHonorIcon() == null) goto L13;
        py.k r4 = getCurrentHonorIcon();
        if (r4 == null) goto L13;
        int r5 = r4.hashCode();
    L14:
        int r6 = (r3 + r5) * 31;
        if (getNextHonorIcon() == null) goto L19;
        py.k r7 = getNextHonorIcon();
        if (r7 == null) goto L19;
        int r8 = r7.hashCode();
    L20:
        int r9 = (r6 + r8) * 31;
        if (getNextHonorName() == null) goto L25;
        String r11 = getNextHonorName();
        if (r11 == null) goto L25;
        int r12 = r11.hashCode();
    L26:
        int r13 = (r9 + r12) * 31;
        if (getCurrentHonorName() == null) goto L31;
        String r14 = getCurrentHonorName();
        if (r14 == null) goto L31;
        int r15 = r14.hashCode();
    L32:
        int r16 = (((((((r13 + r15) * 31) + ((int) (getTotalDiamond() ^ (getTotalDiamond() >>> 32)))) * 31) + ((int) (getCurrentDiamond() ^ (getCurrentDiamond() >>> 32)))) * 31) + ((int) (getNextDiamond() ^ (getNextDiamond() >>> 32)))) * 31;
        if (getImIcon() == null) goto L37;
        py.k r17 = getImIcon();
        if (r17 == null) goto L37;
        int r18 = r17.hashCode();
    L38:
        int r19 = (r16 + r18) * 31;
        if (getImIconWithLevel() == null) goto L43;
        py.k r21 = getImIconWithLevel();
        if (r21 == null) goto L43;
        int r22 = r21.hashCode();
    L44:
        int r23 = (r19 + r22) * 31;
        if (getNewImIconWithLevel() == null) goto L49;
        py.k r24 = getNewImIconWithLevel();
        if (r24 == null) goto L49;
        int r25 = r24.hashCode();
    L50:
        int r26 = (r23 + r25) * 31;
        if (getLiveIcon() == null) goto L55;
        py.k r27 = getLiveIcon();
        if (r27 == null) goto L55;
        int r28 = r27.hashCode();
    L56:
        int r29 = (r26 + r28) * 31;
        if (getNewLiveIcon() == null) goto L61;
        py.k r31 = getNewLiveIcon();
        if (r31 == null) goto L61;
        int r32 = r31.hashCode();
    L62:
        int r33 = (((r29 + r32) * 31) + getLevel()) * 31;
        if (getGradeIconList() == null) goto L67;
        List<w> r34 = getGradeIconList();
        if (r34 == null) goto L67;
        int r35 = r34.hashCode();
    L68:
        int r36 = (r33 + r35) * 31;
        if (getGradeDescribe() == null) goto L73;
        String r37 = getGradeDescribe();
        if (r37 == null) goto L73;
        int r38 = r37.hashCode();
    L74:
        int r39 = (((((r36 + r38) * 31) + ((int) (getThisGradeMaxDiamond() ^ (getThisGradeMaxDiamond() >>> 32)))) * 31) + ((int) (getThisGradeMinDiamond() ^ (getThisGradeMinDiamond() >>> 32)))) * 31;
        if (getProfileDialogBg() == null) goto L79;
        py.k r41 = getProfileDialogBg();
        if (r41 == null) goto L79;
        int r42 = r41.hashCode();
    L80:
        int r43 = (r39 + r42) * 31;
        if (getProfileDialogBackBg() == null) goto L86;
        py.k r44 = getProfileDialogBackBg();
        if (r44 == null) goto L86;
        r1 = r44.hashCode();
    L86:
        return r43 + r1;
    L79:
        r42 = 0;
    L73:
        r38 = 0;
    L67:
        r35 = 0;
    L61:
        r32 = 0;
    L55:
        r28 = 0;
    L49:
        r25 = 0;
    L43:
        r22 = 0;
    L37:
        r18 = 0;
    L31:
        r15 = 0;
    L25:
        r12 = 0;
    L19:
        r8 = 0;
    L13:
        r5 = 0;
    L7:
        r2 = 0;
        goto L8
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public v getBuffInfo() {
        return this._gradeBuffInfo;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public long getCurrentDiamond() {
        return this.currentDiamond;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public py.k getCurrentHonorIcon() {
        return this.currentHonorIcon;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IUserHonor
    public String getCurrentHonorName() {
        return this.currentHonorName;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public py.k getDiamondIcon() {
        return this.diamondIcon;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IUserHonor
    public String getGradeBanner() {
        return this.gradeBanner;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public v getGradeBuffInfo() {
        return this._gradeBuffInfo;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public String getGradeDescribe() {
        return this.gradeDescribe;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public boolean getGradeDescribeShining() {
        return this.gradeDescribeShining;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IUserHonor
    public List<w> getGradeIconList() {
        return this.gradeIconList;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IUserHonor
    public py.k getImIcon() {
        return this.imIcon;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IUserHonor
    public py.k getImIconWithLevel() {
        return this.imIconWithLevel;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public int getLevel() {
        return this.level;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public py.k getLiveIcon() {
        return this.liveIcon;
    }

    public final py.k getMNewLiveIcon() {
        return this.mNewLiveIcon;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public long getNextDiamond() {
        return this.nextDiamond;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public py.k getNextHonorIcon() {
        return this.nextHonorIcon;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IUserHonor
    public String getNextHonorName() {
        return this.nextHonorName;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IUserHonor
    public String getNextPrivileges() {
        return this.nextPrivileges;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IUserHonor
    public long getPayDiamondBak() {
        return this.payDiamondBak;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public py.k getProfileDialogBackBg() {
        return this.profileDialogBackBg;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public py.k getProfileDialogBg() {
        return this.profileDialogBg;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public py.k getRecentConsume() {
        return this._recentConsumeBadge;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public py.k getRecentConsumeBadge() {
        return this._recentConsumeBadge;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public long getScore() {
        return this.score;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public long getScreenChatType() {
        return this.screenChatType;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public long getThisGradeMaxDiamond() {
        return this.thisGradeMaxDiamond;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public long getThisGradeMinDiamond() {
        return this.thisGradeMinDiamond;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public long getTotalDiamond() {
        return this.totalDiamond;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IUserHonor
    public long getUpgradeNeedConsume() {
        return this.upgradeNeedConsume;
    }

    public final v get_gradeBuffInfo() {
        return this._gradeBuffInfo;
    }

    public final py.k get_newImIconWithLevel() {
        return this._newImIconWithLevel;
    }

    public final py.k get_recentConsumeBadge() {
        return this._recentConsumeBadge;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v22, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v26, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v28, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v32, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v34, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v37, types: [com.bytedance.android.live.base.model.user.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v41, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public UserHonor(am3.g r6) {
        super(py.d.class);
        this.gradeIconList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L40;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 29) goto L8;
        this._recentConsumeBadge = vh7.f.a(r6, py.k.class);
        goto L3
    L8:
        if (r2 != 1001) goto L9;
        this.gradeBanner = am3.h.c(r6);
        goto L3
    L9:
        switch(r2) {
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L35;
            case 4: goto L34;
            case 5: goto L33;
            case 6: goto L32;
            case 7: goto L31;
            case 8: goto L30;
            case 9: goto L29;
            case 10: goto L28;
            case 11: goto L27;
            case 12: goto L26;
            case 13: goto L25;
            case 14: goto L24;
            case 15: goto L23;
            case 16: goto L22;
            case 17: goto L21;
            case 18: goto L20;
            case 19: goto L19;
            case 20: goto L18;
            case 21: goto L17;
            case 22: goto L16;
            case 23: goto L15;
            case 24: goto L14;
            case 25: goto L13;
            case 26: goto L12;
            case 27: goto L11;
            default: goto L10;
        };
    L11:
        this.gradeDescribeShining = am3.h.a(r6);
        goto L3
    L12:
        this._gradeBuffInfo = vh7.f.a(r6, v.class);
        goto L3
    L13:
        this.score = r6.j();
        goto L3
    L14:
        this.profileDialogBackBg = vh7.f.a(r6, py.k.class);
        goto L3
    L15:
        this.profileDialogBg = vh7.f.a(r6, py.k.class);
        goto L3
    L16:
        this.nextPrivileges = am3.h.c(r6);
        goto L3
    L17:
        this.upgradeNeedConsume = r6.j();
        goto L3
    L18:
        this.mNewLiveIcon = vh7.f.a(r6, py.k.class);
        goto L3
    L19:
        this._newImIconWithLevel = vh7.f.a(r6, py.k.class);
        goto L3
    L20:
        this.liveIcon = vh7.f.a(r6, py.k.class);
        goto L3
    L21:
        this.imIconWithLevel = vh7.f.a(r6, py.k.class);
        goto L3
    L22:
        this.imIcon = vh7.f.a(r6, py.k.class);
        goto L3
    L23:
        this.screenChatType = r6.j();
        goto L3
    L24:
        this.gradeIconList.add((w) vh7.f.a(r6, w.class));
        goto L3
    L25:
        this.gradeDescribe = am3.h.c(r6);
        goto L3
    L26:
        this.payDiamondBak = r6.j();
        goto L3
    L27:
        this.thisGradeMaxDiamond = r6.j();
        goto L3
    L28:
        this.thisGradeMinDiamond = r6.j();
        goto L3
    L29:
        this.currentDiamond = r6.j();
        goto L3
    L30:
        this.nextDiamond = r6.j();
        goto L3
    L31:
        this.nextHonorIcon = vh7.f.a(r6, py.k.class);
        goto L3
    L32:
        this.level = (int) r6.j();
        goto L3
    L33:
        this.nextHonorName = am3.h.c(r6);
        goto L3
    L34:
        this.currentHonorIcon = vh7.f.a(r6, py.k.class);
        goto L3
    L35:
        this.currentHonorName = am3.h.c(r6);
        goto L3
    L36:
        this.diamondIcon = vh7.f.a(r6, py.k.class);
        goto L3
    L37:
        this.totalDiamond = r6.j();
        goto L3
    L10:
        am3.h.d(r3, r6);
        goto L3
    L40:
        r6.d(r0);
        setThreadSafe(true);
    }

    private final void initWith(IUserHonor r3) {
        setDiamondIcon(r3.getDiamondIcon());
        setCurrentHonorIcon(r3.getCurrentHonorIcon());
        setNextHonorIcon(r3.getNextHonorIcon());
        setNextHonorName(r3.getNextHonorName());
        setCurrentHonorName(r3.getCurrentHonorName());
        setTotalDiamond(r3.getTotalDiamond());
        setCurrentDiamond(r3.getCurrentDiamond());
        setNextDiamond(r3.getNextDiamond());
        setImIcon(r3.getImIcon());
        setImIconWithLevel(r3.getImIconWithLevel());
        setNewImIconWithLevel(r3.getNewImIconWithLevel());
        setLevel(r3.getLevel());
        setLiveIcon(r3.getLiveIcon());
        setNewLiveIcon(r3.getNewLiveIcon());
        setGradeIconList(r3.getGradeIconList());
        setGradeDescribe(r3.getGradeDescribe());
        setGradeDescribeShining(r3.getGradeDescribeShining());
        setThisGradeMaxDiamond(r3.getThisGradeMaxDiamond());
        setThisGradeMinDiamond(r3.getThisGradeMinDiamond());
        setProfileDialogBg(r3.getProfileDialogBg());
        setProfileDialogBackBg(r3.getProfileDialogBackBg());
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L153:
        return false;
    L8:
        if ((!Intrinsics.areEqual(UserHonor.class, r8.getClass())) == true) goto L153;
        UserHonor r9 = (UserHonor) r8;
        if (getTotalDiamond() == r9.getTotalDiamond()) goto L14;
        return false;
    L14:
        if (getCurrentDiamond() == r9.getCurrentDiamond()) goto L17;
        return false;
    L17:
        if (getNextDiamond() == r9.getNextDiamond()) goto L20;
        return false;
    L20:
        if (getLevel() == r9.getLevel()) goto L23;
        return false;
    L23:
        if (getDiamondIcon() == null) goto L26;
        boolean r2 = !Intrinsics.areEqual(getDiamondIcon(), r9.getDiamondIcon());
    L29:
        if (r2 == false) goto L32;
        return false;
    L32:
        if (getCurrentHonorIcon() == null) goto L35;
        boolean r3 = !Intrinsics.areEqual(getCurrentHonorIcon(), r9.getCurrentHonorIcon());
    L38:
        if (r3 == false) goto L41;
        return false;
    L41:
        if (getNextHonorIcon() == null) goto L44;
        boolean r4 = !Intrinsics.areEqual(getNextHonorIcon(), r9.getNextHonorIcon());
    L47:
        if (r4 == false) goto L50;
        return false;
    L50:
        if (getNextHonorName() == null) goto L53;
        boolean r5 = !Intrinsics.areEqual(getNextHonorName(), r9.getNextHonorName());
    L56:
        if (r5 == false) goto L59;
        return false;
    L59:
        if (getCurrentHonorName() == null) goto L62;
        boolean r6 = !Intrinsics.areEqual(getCurrentHonorName(), r9.getCurrentHonorName());
    L65:
        if (r6 == false) goto L68;
        return false;
    L68:
        if (getImIcon() == null) goto L71;
        boolean r7 = !Intrinsics.areEqual(getImIcon(), r9.getImIcon());
    L74:
        if (r7 == false) goto L77;
        return false;
    L77:
        if (getImIconWithLevel() == null) goto L80;
        boolean r11 = !Intrinsics.areEqual(getImIconWithLevel(), r9.getImIconWithLevel());
    L83:
        if (r11 == false) goto L86;
        return false;
    L86:
        if (getNewImIconWithLevel() == null) goto L89;
        boolean r12 = !Intrinsics.areEqual(getNewImIconWithLevel(), r9.getNewImIconWithLevel());
    L92:
        if (r12 == false) goto L95;
        return false;
    L95:
        if (getLiveIcon() == null) goto L98;
        boolean r13 = !Intrinsics.areEqual(getLiveIcon(), r9.getLiveIcon());
    L101:
        if (r13 == false) goto L104;
        return false;
    L104:
        if (getNewLiveIcon() == null) goto L107;
        boolean r14 = !Intrinsics.areEqual(getNewLiveIcon(), r9.getNewLiveIcon());
    L110:
        if (r14 == false) goto L113;
        return false;
    L113:
        if (getGradeIconList() == null) goto L116;
        boolean r15 = !Intrinsics.areEqual(getGradeIconList(), r9.getGradeIconList());
    L119:
        if (r15 == false) goto L122;
        return false;
    L122:
        if (getThisGradeMinDiamond() == r9.getThisGradeMinDiamond()) goto L125;
        return false;
    L125:
        if (getThisGradeMaxDiamond() == r9.getThisGradeMaxDiamond()) goto L128;
        return false;
    L128:
        if (getProfileDialogBg() == null) goto L131;
        boolean r16 = !Intrinsics.areEqual(getProfileDialogBg(), r9.getProfileDialogBg());
    L134:
        if (r16 == false) goto L137;
        return false;
    L137:
        if (getProfileDialogBackBg() == null) goto L140;
        boolean r17 = !Intrinsics.areEqual(getProfileDialogBackBg(), r9.getProfileDialogBackBg());
    L143:
        if (r17 == false) goto L146;
        return false;
    L146:
        if (getGradeDescribe() == null) goto L149;
        return Intrinsics.areEqual(getGradeDescribe(), r9.getGradeDescribe());
    L149:
        if (r9.getGradeDescribe() == null) goto L155;
        return false;
    L155:
        return true;
    L140:
        if (r9.getProfileDialogBackBg() == null) goto L142;
        r17 = true;
        goto L143
    L142:
        r17 = false;
        goto L143
    L131:
        if (r9.getProfileDialogBg() == null) goto L133;
        r16 = true;
        goto L134
    L133:
        r16 = false;
        goto L134
    L116:
        if (r9.getGradeIconList() == null) goto L118;
        r15 = true;
        goto L119
    L118:
        r15 = false;
        goto L119
    L107:
        if (r9.getNewLiveIcon() == null) goto L109;
        r14 = true;
        goto L110
    L109:
        r14 = false;
        goto L110
    L98:
        if (r9.getLiveIcon() == null) goto L100;
        r13 = true;
        goto L101
    L100:
        r13 = false;
        goto L101
    L89:
        if (r9.getNewImIconWithLevel() == null) goto L91;
        r12 = true;
        goto L92
    L91:
        r12 = false;
        goto L92
    L80:
        if (r9.getImIconWithLevel() == null) goto L82;
        r11 = true;
        goto L83
    L82:
        r11 = false;
        goto L83
    L71:
        if (r9.getImIcon() == null) goto L73;
        r7 = true;
        goto L74
    L73:
        r7 = false;
        goto L74
    L62:
        if (r9.getCurrentHonorName() == null) goto L64;
        r6 = true;
        goto L65
    L64:
        r6 = false;
        goto L65
    L53:
        if (r9.getNextHonorName() == null) goto L55;
        r5 = true;
        goto L56
    L55:
        r5 = false;
        goto L56
    L44:
        if (r9.getNextHonorIcon() == null) goto L46;
        r4 = true;
        goto L47
    L46:
        r4 = false;
        goto L47
    L35:
        if (r9.getCurrentHonorIcon() == null) goto L37;
        r3 = true;
        goto L38
    L37:
        r3 = false;
        goto L38
    L26:
        if (r9.getDiamondIcon() == null) goto L28;
        r2 = true;
        goto L29
    L28:
        r2 = false;
        goto L29
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setBuffInfo(v r2) {
        if ((r2 instanceof GradeBuffInfo) == true) goto L5;
        r2 = null;
    L5:
        this._gradeBuffInfo = (GradeBuffInfo) r2;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setCurrentDiamond(long r1) {
        this.currentDiamond = r1;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setCurrentHonorIcon(py.k r1) {
        this.currentHonorIcon = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setCurrentHonorName(String r1) {
        this.currentHonorName = r1;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setDiamondIcon(py.k r1) {
        this.diamondIcon = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setGradeBanner(String r1) {
        this.gradeBanner = r1;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setGradeDescribe(String r1) {
        this.gradeDescribe = r1;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setGradeDescribeShining(boolean r1) {
        this.gradeDescribeShining = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setGradeIconList(List<w> r1) {
        this.gradeIconList = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setImIcon(py.k r1) {
        this.imIcon = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setImIconWithLevel(py.k r1) {
        this.imIconWithLevel = r1;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setLevel(int r1) {
        this.level = r1;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setLiveIcon(py.k r1) {
        this.liveIcon = r1;
    }

    public final void setMNewLiveIcon(py.k r1) {
        this.mNewLiveIcon = r1;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setNewImIconWithLevel(py.k r2) {
        if ((r2 instanceof ImageModel) == true) goto L5;
        r2 = null;
    L5:
        this._newImIconWithLevel = (ImageModel) r2;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setNewLiveIcon(py.k r1) {
        this.mNewLiveIcon = r1;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setNextDiamond(long r1) {
        this.nextDiamond = r1;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setNextHonorIcon(py.k r1) {
        this.nextHonorIcon = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setNextHonorName(String r1) {
        this.nextHonorName = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setNextPrivileges(String r1) {
        this.nextPrivileges = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setPayDiamondBak(long r1) {
        this.payDiamondBak = r1;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setProfileDialogBackBg(py.k r1) {
        this.profileDialogBackBg = r1;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setProfileDialogBg(py.k r1) {
        this.profileDialogBg = r1;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setRecentConsumeBadge(py.k r1) {
        this._recentConsumeBadge = r1;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setScore(long r1) {
        this.score = r1;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setScreenChatType(long r1) {
        this.screenChatType = r1;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setThisGradeMaxDiamond(long r1) {
        this.thisGradeMaxDiamond = r1;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setThisGradeMinDiamond(long r1) {
        this.thisGradeMinDiamond = r1;
    }

    @Override // py.d, com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setTotalDiamond(long r1) {
        this.totalDiamond = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IUserHonor
    public void setUpgradeNeedConsume(long r1) {
        this.upgradeNeedConsume = r1;
    }

    public final void set_gradeBuffInfo(v r1) {
        this._gradeBuffInfo = r1;
    }

    public final void set_newImIconWithLevel(py.k r1) {
        this._newImIconWithLevel = r1;
    }

    public final void set_recentConsumeBadge(py.k r1) {
        this._recentConsumeBadge = r1;
    }

    public static final /* synthetic */ void access$initWith(UserHonor r0, IUserHonor r1) {
        r0.initWith(r1);
    }
}

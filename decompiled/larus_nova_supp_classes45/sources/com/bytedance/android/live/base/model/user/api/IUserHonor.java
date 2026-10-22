package com.bytedance.android.live.base.model.user.api;

import com.bytedance.android.live.base.model.user.v;
import com.bytedance.android.live.base.model.user.w;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import py.d;
import py.k;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\u0004\"\u0004\b\t\u0010\u0006R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0004\"\u0004\b\f\u0010\u0006R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\u0006R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u0006R\u001c\u0010\"\u001a\u00020\u001d8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010%\u001a\u0004\u0018\u00010\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001c\u0010(\u001a\u00020\u001d8&@&X¦\u000e¢\u0006\f\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u001e\u0010+\u001a\u0004\u0018\u00010\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u0012R$\u00102\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,8&@&X¦\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/bytedance/android/live/base/model/user/api/IUserHonor;", "Lpy/d;", "Lpy/k;", "getDiamondIcon", "()Lpy/k;", "setDiamondIcon", "(Lpy/k;)V", "diamondIcon", "getCurrentHonorIcon", "setCurrentHonorIcon", "currentHonorIcon", "getNextHonorIcon", "setNextHonorIcon", "nextHonorIcon", "", "getNextHonorName", "()Ljava/lang/String;", "setNextHonorName", "(Ljava/lang/String;)V", "nextHonorName", "getCurrentHonorName", "setCurrentHonorName", "currentHonorName", "getImIcon", "setImIcon", "imIcon", "getImIconWithLevel", "setImIconWithLevel", "imIconWithLevel", "", "getUpgradeNeedConsume", "()J", "setUpgradeNeedConsume", "(J)V", "upgradeNeedConsume", "getGradeBanner", "setGradeBanner", "gradeBanner", "getPayDiamondBak", "setPayDiamondBak", "payDiamondBak", "getNextPrivileges", "setNextPrivileges", "nextPrivileges", "", "Lcom/bytedance/android/live/base/model/user/w;", "getGradeIconList", "()Ljava/util/List;", "setGradeIconList", "(Ljava/util/List;)V", "gradeIconList", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IUserHonor extends d {
    @Override // py.d
    /* synthetic */ e castTo(Class r1);

    @Override // py.d
    /* synthetic */ e castToOrNull(Class r1);

    /* synthetic */ v getBuffInfo();

    @FieldName(name = "now_diamond")
    /* synthetic */ long getCurrentDiamond();

    k getCurrentHonorIcon();

    String getCurrentHonorName();

    k getDiamondIcon();

    String getGradeBanner();

    /* synthetic */ v getGradeBuffInfo();

    /* synthetic */ String getGradeDescribe();

    /* synthetic */ boolean getGradeDescribeShining();

    List<w> getGradeIconList();

    /* synthetic */ k getHonorBuffBadge();

    k getImIcon();

    k getImIconWithLevel();

    @FieldName(name = "level")
    /* synthetic */ int getLevel();

    @FieldName(name = "live_icon")
    /* synthetic */ k getLiveIcon();

    /* synthetic */ k getNewImIconWithLevel();

    /* synthetic */ k getNewLiveIcon();

    @FieldName(name = "next_diamond")
    /* synthetic */ long getNextDiamond();

    k getNextHonorIcon();

    String getNextHonorName();

    String getNextPrivileges();

    long getPayDiamondBak();

    @FieldName(name = "background_back")
    /* synthetic */ k getProfileDialogBackBg();

    @FieldName(name = KtvSubElement.BACKGROUND)
    /* synthetic */ k getProfileDialogBg();

    /* synthetic */ k getRecentConsume();

    /* synthetic */ k getRecentConsumeBadge();

    /* synthetic */ long getScore();

    @FieldName(name = "screen_chat_type")
    /* synthetic */ long getScreenChatType();

    /* synthetic */ long getThisGradeMaxDiamond();

    /* synthetic */ long getThisGradeMinDiamond();

    @FieldName(name = "total_diamond_count")
    /* synthetic */ long getTotalDiamond();

    long getUpgradeNeedConsume();

    /* synthetic */ void setBuffInfo(v r1);

    @FieldName(name = "now_diamond#setter")
    /* synthetic */ void setCurrentDiamond(long r1);

    void setCurrentHonorIcon(k r1);

    void setCurrentHonorName(String r1);

    void setDiamondIcon(k r1);

    void setGradeBanner(String r1);

    /* synthetic */ void setGradeDescribe(String r1);

    /* synthetic */ void setGradeDescribeShining(boolean r1);

    void setGradeIconList(List<w> r1);

    void setImIcon(k r1);

    void setImIconWithLevel(k r1);

    @FieldName(name = "level#setter")
    /* synthetic */ void setLevel(int r1);

    @FieldName(name = "live_icon#setter")
    /* synthetic */ void setLiveIcon(k r1);

    /* synthetic */ void setNewImIconWithLevel(k r1);

    /* synthetic */ void setNewLiveIcon(k r1);

    @FieldName(name = "next_diamond#setter")
    /* synthetic */ void setNextDiamond(long r1);

    void setNextHonorIcon(k r1);

    void setNextHonorName(String r1);

    void setNextPrivileges(String r1);

    void setPayDiamondBak(long r1);

    @FieldName(name = "background_back#setter")
    /* synthetic */ void setProfileDialogBackBg(k r1);

    @FieldName(name = "background#setter")
    /* synthetic */ void setProfileDialogBg(k r1);

    /* synthetic */ void setRecentConsumeBadge(k r1);

    /* synthetic */ void setScore(long r1);

    @FieldName(name = "screen_chat_type#setter")
    /* synthetic */ void setScreenChatType(long r1);

    /* synthetic */ void setThisGradeMaxDiamond(long r1);

    /* synthetic */ void setThisGradeMinDiamond(long r1);

    @FieldName(name = "total_diamond_count#setter")
    /* synthetic */ void setTotalDiamond(long r1);

    void setUpgradeNeedConsume(long r1);
}

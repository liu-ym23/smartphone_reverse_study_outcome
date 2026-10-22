package py;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0017\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0002R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\u001d\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\t\u001a\u0004\b\u001a\u0010\u0005\"\u0004\b\u001b\u0010\u0007R\"\u0010!\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\t\u001a\u0004\b\u001e\u0010\u0005\"\u0004\b\u001f\u0010\u0007R\"\u0010(\u001a\u00020\"8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\t\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010,\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\t\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR$\u00100\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b/\u0010\t\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000fR\"\u00104\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b3\u0010\t\u001a\u0004\b1\u0010\u0005\"\u0004\b2\u0010\u0007R$\u00108\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b7\u0010\t\u001a\u0004\b5\u0010\r\"\u0004\b6\u0010\u000f¨\u00069"}, d2 = {"Lpy/d;", "Lvh7/c;", "", "", "getTotalDiamond", "()J", "setTotalDiamond", "(J)V", "getTotalDiamond$annotations", "()V", "totalDiamond", "Lpy/k;", "getDiamondIcon", "()Lpy/k;", "setDiamondIcon", "(Lpy/k;)V", "getDiamondIcon$annotations", "diamondIcon", "getCurrentHonorIcon", "setCurrentHonorIcon", "getCurrentHonorIcon$annotations", "currentHonorIcon", "getNextHonorIcon", "setNextHonorIcon", "getNextHonorIcon$annotations", "nextHonorIcon", "getCurrentDiamond", "setCurrentDiamond", "getCurrentDiamond$annotations", "currentDiamond", "getNextDiamond", "setNextDiamond", "getNextDiamond$annotations", "nextDiamond", "", "getLevel", "()I", "setLevel", "(I)V", "getLevel$annotations", "level", "getProfileDialogBg", "setProfileDialogBg", "getProfileDialogBg$annotations", "profileDialogBg", "getProfileDialogBackBg", "setProfileDialogBackBg", "getProfileDialogBackBg$annotations", "profileDialogBackBg", "getScreenChatType", "setScreenChatType", "getScreenChatType$annotations", "screenChatType", "getLiveIcon", "setLiveIcon", "getLiveIcon$annotations", "liveIcon", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d extends vh7.c<d> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ com.bytedance.android.live.base.model.user.v getBuffInfo();

    @FieldName(name = "now_diamond")
    long getCurrentDiamond();

    @FieldName(name = "icon")
    k getCurrentHonorIcon();

    @FieldName(name = "diamond_icon")
    k getDiamondIcon();

    /* synthetic */ com.bytedance.android.live.base.model.user.v getGradeBuffInfo();

    /* synthetic */ String getGradeDescribe();

    /* synthetic */ boolean getGradeDescribeShining();

    /* synthetic */ k getHonorBuffBadge();

    @FieldName(name = "level")
    int getLevel();

    @FieldName(name = "live_icon")
    k getLiveIcon();

    /* synthetic */ k getNewImIconWithLevel();

    /* synthetic */ k getNewLiveIcon();

    @FieldName(name = "next_diamond")
    long getNextDiamond();

    @FieldName(name = "next_icon")
    k getNextHonorIcon();

    @FieldName(name = "background_back")
    k getProfileDialogBackBg();

    @FieldName(name = KtvSubElement.BACKGROUND)
    k getProfileDialogBg();

    /* synthetic */ k getRecentConsume();

    /* synthetic */ k getRecentConsumeBadge();

    /* synthetic */ long getScore();

    @FieldName(name = "screen_chat_type")
    long getScreenChatType();

    /* synthetic */ long getThisGradeMaxDiamond();

    /* synthetic */ long getThisGradeMinDiamond();

    @FieldName(name = "total_diamond_count")
    long getTotalDiamond();

    /* synthetic */ void setBuffInfo(com.bytedance.android.live.base.model.user.v r1);

    @FieldName(name = "now_diamond#setter")
    void setCurrentDiamond(long r1);

    @FieldName(name = "icon#setter")
    void setCurrentHonorIcon(k r1);

    @FieldName(name = "diamond_icon#setter")
    void setDiamondIcon(k r1);

    /* synthetic */ void setGradeDescribe(String r1);

    /* synthetic */ void setGradeDescribeShining(boolean r1);

    @FieldName(name = "level#setter")
    void setLevel(int r1);

    @FieldName(name = "live_icon#setter")
    void setLiveIcon(k r1);

    /* synthetic */ void setNewImIconWithLevel(k r1);

    /* synthetic */ void setNewLiveIcon(k r1);

    @FieldName(name = "next_diamond#setter")
    void setNextDiamond(long r1);

    @FieldName(name = "next_icon#setter")
    void setNextHonorIcon(k r1);

    @FieldName(name = "background_back#setter")
    void setProfileDialogBackBg(k r1);

    @FieldName(name = "background#setter")
    void setProfileDialogBg(k r1);

    /* synthetic */ void setRecentConsumeBadge(k r1);

    /* synthetic */ void setScore(long r1);

    @FieldName(name = "screen_chat_type#setter")
    void setScreenChatType(long r1);

    /* synthetic */ void setThisGradeMaxDiamond(long r1);

    /* synthetic */ void setThisGradeMinDiamond(long r1);

    @FieldName(name = "total_diamond_count#setter")
    void setTotalDiamond(long r1);
}

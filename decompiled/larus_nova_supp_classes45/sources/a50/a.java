package a50;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b6\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b6\u00107R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\b¨\u00068"}, d2 = {"La50/a;", "", "", "shortTouch", "Z", "m", "()Z", "setShortTouch", "(Z)V", "banner", "a", "setBanner", "screencast", "l", "setScreencast", "morePanel", "h", "setMorePanel", "commonCard", "b", "setCommonCard", "interactionInfo", "e", "setInteractionInfo", "voteBackendEnable", "o", "setVoteBackendEnable", "groupUserBackendEnable", "d", "setGroupUserBackendEnable", "taskCenterBackendEnable", "n", "setTaskCenterBackendEnable", "lotteryBackendEnable", "f", "setLotteryBackendEnable", "luckyboxBackendEnable", "g", "setLuckyboxBackendEnable", "dressBackendEnable", "c", "setDressBackendEnable", "lifePack", "getLifePack", "setLifePack", "rank", "j", "setRank", "roomStrategy", "k", "setRoomStrategy", "multiLinkListV2", "i", "setMultiLinkListV2", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("banner")
    private boolean banner;

    @SerializedName("commonCard")
    private boolean commonCard;

    @SerializedName("dress")
    private boolean dressBackendEnable;

    @SerializedName("groupUser")
    private boolean groupUserBackendEnable;

    @SerializedName("interactionInfo")
    private boolean interactionInfo;

    @SerializedName("life_pack")
    private boolean lifePack;

    @SerializedName("lottery")
    private boolean lotteryBackendEnable;

    @SerializedName("luckybox")
    private boolean luckyboxBackendEnable;

    @SerializedName("morePanel")
    private boolean morePanel;

    @SerializedName("multi_link_list_v2")
    private boolean multiLinkListV2;

    @SerializedName("rank_list")
    private boolean rank;

    @SerializedName("room_strategy")
    private boolean roomStrategy;

    @SerializedName("screencast")
    private boolean screencast;

    @SerializedName("shortTouch")
    private boolean shortTouch;

    @SerializedName("taskCenter")
    private boolean taskCenterBackendEnable;

    @SerializedName("vote")
    private boolean voteBackendEnable;

    public a() {
        this.multiLinkListV2 = true;
    }

    public final boolean a() {
        return this.banner;
    }

    public final boolean b() {
        return this.commonCard;
    }

    public final boolean c() {
        return this.dressBackendEnable;
    }

    public final boolean d() {
        return this.groupUserBackendEnable;
    }

    public final boolean e() {
        return this.interactionInfo;
    }

    public final boolean f() {
        return this.lotteryBackendEnable;
    }

    public final boolean g() {
        return this.luckyboxBackendEnable;
    }

    public final boolean h() {
        return this.morePanel;
    }

    public final boolean i() {
        return this.multiLinkListV2;
    }

    public final boolean j() {
        return this.rank;
    }

    public final boolean k() {
        return this.roomStrategy;
    }

    public final boolean l() {
        return this.screencast;
    }

    public final boolean m() {
        return this.shortTouch;
    }

    public final boolean n() {
        return this.taskCenterBackendEnable;
    }

    public final boolean o() {
        return this.voteBackendEnable;
    }
}

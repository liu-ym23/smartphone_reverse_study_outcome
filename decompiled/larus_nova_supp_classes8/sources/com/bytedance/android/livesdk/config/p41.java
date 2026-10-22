package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/config/p41;", "", "", "gameDialogCommonBackground", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "gameDialogLotteryBackground", "b", "wgameInviteLoadAnimWebP", "c", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p41 {

    @SerializedName("game_dialog_common_bg")
    private final String gameDialogCommonBackground;

    @SerializedName("game_dialog_lottery_bg")
    private final String gameDialogLotteryBackground;

    @SerializedName("wgame_invite_load_anim")
    private final String wgameInviteLoadAnimWebP;

    public p41() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof p41) == false) goto L12;
        p41 r4 = (p41) r3;
        if (Intrinsics.areEqual(this.gameDialogCommonBackground, r4.gameDialogCommonBackground) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.gameDialogLotteryBackground, r4.gameDialogLotteryBackground) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.wgameInviteLoadAnimWebP, r4.wgameInviteLoadAnimWebP) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.gameDialogCommonBackground;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.gameDialogLotteryBackground;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.wgameInviteLoadAnimWebP;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveInteractGameConfig(gameDialogCommonBackground=" + this.gameDialogCommonBackground + ", gameDialogLotteryBackground=" + this.gameDialogLotteryBackground + ", wgameInviteLoadAnimWebP=" + this.wgameInviteLoadAnimWebP + ")";
    }

    public final String a() {
        return this.gameDialogCommonBackground;
    }

    public final String b() {
        return this.gameDialogLotteryBackground;
    }

    public final String c() {
        return this.wgameInviteLoadAnimWebP;
    }

    public p41(int r5) {
        StringBuilder r6 = new StringBuilder("https://");
        LiveCommonConstants r1 = LiveCommonConstants.INSTANCE;
        r6.append(r1.getObjectTosPath());
        r6.append("/obj/live-android/ttlive_bg_game_dialog.png");
        String r7 = r6.toString();
        String r2 = "https://" + r1.getObjectTosPath() + "/obj/live-android/ttlive_wgameinvite_dialog_top_bg_lottery.png";
        String r0 = "https://" + r1.getObjectTosPath() + "/obj/live-android/wgame_invite_loading.webp";
        this.gameDialogCommonBackground = r7;
        this.gameDialogLotteryBackground = r2;
        this.wgameInviteLoadAnimWebP = r0;
    }
}

package nh0;

import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.PlayType;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\u0011R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\u0011¨\u0006-"}, d2 = {"Lnh0/m;", "Ltf0/d;", "", "dressId", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/PlayType;", "playType", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/PlayType;", "k", "()Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/PlayType;", "o", "(Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/PlayType;)V", "backgroundColor", "g", "setBackgroundColor", "(Ljava/lang/String;)V", "", "styleType", "Ljava/lang/Integer;", "m", "()Ljava/lang/Integer;", "setStyleType", "(Ljava/lang/Integer;)V", "", "forcePlay", "Z", "i", "()Z", "setForcePlay", "(Z)V", "", "targetScore", "J", "n", "()J", "setTargetScore", "(J)V", "sponsorAvatarUrl", "l", "setSponsorAvatarUrl", "hatUrl", "j", "setHatUrl", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class m extends tf0.d {

    @SerializedName("background_color")
    private String backgroundColor;

    @SerializedName("dress_id")
    private final String dressId;

    @SerializedName("force_play")
    private boolean forcePlay;

    @SerializedName("hat_url")
    private String hatUrl;

    @SerializedName("play_type")
    private PlayType playType;

    @SerializedName("sponsor_avatar_url")
    private String sponsorAvatarUrl;

    @SerializedName("style_type")
    private Integer styleType;

    @SerializedName("target_score")
    private long targetScore;

    @Override // tf0.d
    public final String toString() {
        return "SeatWidgetElementInfo( " + a().name() + ", forcr_play=" + this.forcePlay + ", visible = " + d() + ", userId = " + c() + ", position = " + b() + ", dressId=" + this.dressId + ", playType=" + this.playType + ", backgroundColor=" + this.backgroundColor + ", styleType=" + this.styleType + ')';
    }

    public final String g() {
        return this.backgroundColor;
    }

    public final String h() {
        return this.dressId;
    }

    public final boolean i() {
        return this.forcePlay;
    }

    public final String j() {
        return this.hatUrl;
    }

    public final PlayType k() {
        return this.playType;
    }

    public final String l() {
        return this.sponsorAvatarUrl;
    }

    public final Integer m() {
        return this.styleType;
    }

    public final long n() {
        return this.targetScore;
    }

    @Override // tf0.d
    public final boolean e(tf0.d r8) {
        if (super.e(r8) == true) goto L6;
        return false;
    L6:
        if (this != r8) goto L8;
        return true;
    L8:
        if (r8 != null) goto L10;
        return false;
    L10:
        if ((!Intrinsics.areEqual(m.class, r8.getClass())) == true) goto L39;
        m r9 = (m) r8;
        if (Intrinsics.areEqual(this.dressId, r9.dressId) == true) goto L15;
        return false;
    L15:
        if (this.playType == r9.playType) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.backgroundColor, r9.backgroundColor) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.styleType, r9.styleType) == true) goto L21;
        return false;
    L21:
        if (this.forcePlay == r9.forcePlay) goto L23;
        return false;
    L23:
        if (this.targetScore == r9.targetScore) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.sponsorAvatarUrl, r9.sponsorAvatarUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.hatUrl, r9.hatUrl) == false) goto L38;
        return true;
    L38:
        return false;
    L39:
        return false;
    }

    public final void o(PlayType r1) {
        this.playType = r1;
    }
}

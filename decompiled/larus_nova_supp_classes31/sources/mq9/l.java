package mq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006#"}, d2 = {"Lcom/larus/platform/model/avatar/UserAvatarAuthStyleConfig;", "", "mediaHeightRatio", "", "titleText", "", "subtitleText", "privacyAgreeText", "createButtonTitle", "createButtonBackground", "<init>", "(Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMediaHeightRatio", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTitleText", "()Ljava/lang/String;", "getSubtitleText", "getPrivacyAgreeText", "getCreateButtonTitle", "getCreateButtonBackground", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/platform/model/avatar/UserAvatarAuthStyleConfig;", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class l {

    @SerializedName("createButtonBackground")
    private final String createButtonBackground;

    @SerializedName("createButtonTitle")
    private final String createButtonTitle;

    @SerializedName("mediaHeightRatio")
    private final Float mediaHeightRatio;

    @SerializedName("privacyAgreeText")
    private final String privacyAgreeText;

    @SerializedName("subtitleText")
    private final String subtitleText;

    @SerializedName("titleText")
    private final String titleText;

    public l() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
        if (Intrinsics.areEqual(this.mediaHeightRatio, r6.mediaHeightRatio) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.titleText, r6.titleText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subtitleText, r6.subtitleText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.privacyAgreeText, r6.privacyAgreeText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.createButtonTitle, r6.createButtonTitle) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.createButtonBackground, r6.createButtonBackground) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Float r0 = this.mediaHeightRatio;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.titleText;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.subtitleText;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.privacyAgreeText;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.createButtonTitle;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.createButtonBackground;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserAvatarAuthStyleConfig(mediaHeightRatio=" + this.mediaHeightRatio + ", titleText=" + this.titleText + ", subtitleText=" + this.subtitleText + ", privacyAgreeText=" + this.privacyAgreeText + ", createButtonTitle=" + this.createButtonTitle + ", createButtonBackground=" + this.createButtonBackground + ')';
    }

    public final String a() {
        return this.createButtonBackground;
    }

    public final String b() {
        return this.createButtonTitle;
    }

    public final Float c() {
        return this.mediaHeightRatio;
    }

    public final String d() {
        return this.privacyAgreeText;
    }

    public final String e() {
        return this.subtitleText;
    }

    public final String f() {
        return this.titleText;
    }

    public /* synthetic */ l(int r8) {
        this(Float.valueOf(1.0f), null, null, null, null, null);
    }

    public l(Float r1, String r2, String r3, String r4, String r5, String r6) {
        this.mediaHeightRatio = r1;
        this.titleText = r2;
        this.subtitleText = r3;
        this.privacyAgreeText = r4;
        this.createButtonTitle = r5;
        this.createButtonBackground = r6;
    }
}

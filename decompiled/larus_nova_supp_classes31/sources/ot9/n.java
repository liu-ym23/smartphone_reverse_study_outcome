package ot9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larus/settings/opt/LoginEnhanceConfig;", "", "tipsShowVoiceCode", "", "tipsShowEnterTourist", "tipsShowOtherMethods", "codeVerifyFailTimesOfShowDialog", "", "<init>", "(ZZZI)V", "getTipsShowVoiceCode", "()Z", "getTipsShowEnterTourist", "getTipsShowOtherMethods", "getCodeVerifyFailTimesOfShowDialog", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class n {

    @SerializedName("code_verify_fail_times_of_show_dialog")
    private final int codeVerifyFailTimesOfShowDialog;

    @SerializedName("tips_show_enter_tourist")
    private final boolean tipsShowEnterTourist;

    @SerializedName("tips_show_other_methods")
    private final boolean tipsShowOtherMethods;

    @SerializedName("tips_show_voice_code")
    private final boolean tipsShowVoiceCode;

    public n() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (this.tipsShowVoiceCode == r6.tipsShowVoiceCode) goto L12;
        return false;
    L12:
        if (this.tipsShowEnterTourist == r6.tipsShowEnterTourist) goto L15;
        return false;
    L15:
        if (this.tipsShowOtherMethods == r6.tipsShowOtherMethods) goto L18;
        return false;
    L18:
        if (this.codeVerifyFailTimesOfShowDialog == r6.codeVerifyFailTimesOfShowDialog) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.tipsShowVoiceCode == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.tipsShowEnterTourist == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.tipsShowOtherMethods == true) goto L15;
        r1 = 1237;
    L15:
        return ((r4 + r1) * 31) + this.codeVerifyFailTimesOfShowDialog;
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "LoginEnhanceConfig(tipsShowVoiceCode=" + this.tipsShowVoiceCode + ", tipsShowEnterTourist=" + this.tipsShowEnterTourist + ", tipsShowOtherMethods=" + this.tipsShowOtherMethods + ", codeVerifyFailTimesOfShowDialog=" + this.codeVerifyFailTimesOfShowDialog + ')';
    }

    public final int a() {
        return this.codeVerifyFailTimesOfShowDialog;
    }

    public final boolean b() {
        return this.tipsShowEnterTourist;
    }

    public final boolean c() {
        return this.tipsShowOtherMethods;
    }

    public final boolean d() {
        return this.tipsShowVoiceCode;
    }

    public n(int r1) {
        this.tipsShowVoiceCode = false;
        this.tipsShowEnterTourist = false;
        this.tipsShowOtherMethods = false;
        this.codeVerifyFailTimesOfShowDialog = 1;
    }
}

package p00;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class a {

    @SerializedName("enable_live_audio")
    public boolean enableLiveAudio;

    @SerializedName("enable_live_screenshot")
    public boolean enableLiveScreenshot;

    @SerializedName("enable_live_third_party")
    public boolean enableLiveThirdParty;

    @SerializedName("toast")
    public C0258a mToast;

    /* JADX INFO: renamed from: p00.a$a, reason: collision with other inner class name */
    public static class C0258a {

        @SerializedName("new_anchor")
        public boolean mNewAnchor;

        public C0258a() {
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public a() {
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof a) == false) goto L12;
        a r5 = (a) r4;
        if (this.enableLiveAudio == r5.enableLiveAudio) goto L7;
        return false;
    L7:
        if (this.enableLiveThirdParty == r5.enableLiveThirdParty) goto L9;
        return false;
    L9:
        if (this.enableLiveScreenshot != r5.enableLiveScreenshot) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }
}

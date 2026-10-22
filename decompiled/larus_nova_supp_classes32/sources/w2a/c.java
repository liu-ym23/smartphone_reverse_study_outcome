package w2a;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003JC\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/larus/voice_setting/voice/mix/res/PreviewInfo;", NameKeys.UnloadStrategy_No_Strategy, "styleId", NameKeys.UnloadStrategy_No_Strategy, "text", LynxEventReporter.PROP_NAME_URL, "md5", "isMixedVoice", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getStyleId", "()Ljava/lang/String;", "getText", "getUrl", "getMd5", "()Z", "setMixedVoice", "(Z)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @Expose(deserialize = false, serialize = false)
    private boolean isMixedVoice;

    @SerializedName("md5")
    private final String md5;

    @SerializedName("style_id")
    private final String styleId;

    @SerializedName("text")
    private final String text;

    @SerializedName("audio_url")
    private final String url;

    public c() {
        this(null, null, null, null, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.styleId, r6.styleId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.md5, r6.md5) == true) goto L21;
        return false;
    L21:
        if (this.isMixedVoice == r6.isMixedVoice) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this.styleId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.text;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.url;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.md5;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        int r11 = (r9 + r1) * 31;
        if (this.isMixedVoice == false) goto L21;
        int r12 = 1231;
    L23:
        return r11 + r12;
    L21:
        r12 = 1237;
        goto L23
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
        return "PreviewInfo(styleId=" + this.styleId + ", text=" + this.text + ", url=" + this.url + ", md5=" + this.md5 + ", isMixedVoice=" + this.isMixedVoice + ')';
    }

    public final String a() {
        return this.md5;
    }

    public final String b() {
        return this.styleId;
    }

    public final String c() {
        return this.url;
    }

    public final boolean d() {
        return this.isMixedVoice;
    }

    public final void e(boolean r1) {
        this.isMixedVoice = r1;
    }

    public c(String r3, String r4, String r5, String r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r6 = NameKeys.UnloadStrategy_No_Strategy;
    L15:
        if ((r7 & 16) == 0) goto L17;
        boolean r8 = true;
    L18:
        this.styleId = r3;
        this.text = r4;
        this.url = r5;
        this.md5 = r6;
        this.isMixedVoice = r8;
        return;
    L17:
        r8 = false;
        goto L18
    }
}

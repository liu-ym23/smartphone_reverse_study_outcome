package com.bytedance.android.live.liveinteract.plantform.utils;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/utils/a;", "", "", "aiGuestAudio", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "aiGuestVideo", "b", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a {

    @SerializedName("ai_guest_audio")
    private final String aiGuestAudio;

    @SerializedName("ai_guest_video")
    private final String aiGuestVideo;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L10;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.aiGuestAudio, r4.aiGuestAudio) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.aiGuestVideo, r4.aiGuestVideo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.aiGuestAudio;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.aiGuestVideo;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AIGuestRtcConfig(aiGuestAudio=" + this.aiGuestAudio + ", aiGuestVideo=" + this.aiGuestVideo + ")";
    }

    public a() {
        Intrinsics.checkNotNullParameter("aigc_config", "aiGuestAudio");
        Intrinsics.checkNotNullParameter("aigc_config", "aiGuestVideo");
        this.aiGuestAudio = "aigc_config";
        this.aiGuestVideo = "aigc_config";
    }

    public final String a() {
        return this.aiGuestAudio;
    }

    public final String b() {
        return this.aiGuestVideo;
    }
}

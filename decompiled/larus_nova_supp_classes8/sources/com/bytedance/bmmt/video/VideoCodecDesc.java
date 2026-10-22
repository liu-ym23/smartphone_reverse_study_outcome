package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class VideoCodecDesc {
    public final BmmtVideoCodecProfile profile;
    public final BmmtVideoCodecStandard standard;

    public int GetProfileInt() {
        return this.profile.toInt();
    }

    public int GetStandardInt() {
        return this.standard.toInt();
    }

    public String getName() {
        return this.standard.mimeType();
    }

    public BmmtVideoCodecProfile getProfile() {
        return this.profile;
    }

    public BmmtVideoCodecStandard getStandard() {
        return this.standard;
    }

    public boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5 != this) goto L9;
        return true;
    L9:
        if ((r5 instanceof VideoCodecDesc) == true) goto L11;
        return false;
    L11:
        VideoCodecDesc r6 = (VideoCodecDesc) r5;
        if (this.standard == r6.standard) goto L14;
        return false;
    L14:
        if (this.profile != r6.profile) goto L18;
        return true;
    L18:
        return false;
    }

    public VideoCodecDesc(int r1, int r2) {
        this.standard = BmmtVideoCodecStandard.fromValue(r1);
        this.profile = BmmtVideoCodecProfile.fromValue(r2);
    }

    public VideoCodecDesc(BmmtVideoCodecStandard r1, BmmtVideoCodecProfile r2) {
        this.standard = r1;
        this.profile = r2;
    }
}

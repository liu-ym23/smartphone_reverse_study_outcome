package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003JQ\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/larus/bmhome/rc/FlowResourceMeta;", "", "fileMeta", "Lcom/larus/bmhome/rc/FileResourceMeta;", "imageMeta", "Lcom/larus/bmhome/rc/ImageResourceMeta;", "audioMeta", "Lcom/larus/bmhome/rc/AudioResourceMeta;", "videoMeta", "Lcom/larus/bmhome/rc/VideoResourceMeta;", "fingerprintMeta", "Lcom/larus/bmhome/rc/ResourceFingerprintMeta;", "targetMeta", "Lcom/larus/bmhome/rc/ResourceTargetMeta;", "<init>", "(Lcom/larus/bmhome/rc/FileResourceMeta;Lcom/larus/bmhome/rc/ImageResourceMeta;Lcom/larus/bmhome/rc/AudioResourceMeta;Lcom/larus/bmhome/rc/VideoResourceMeta;Lcom/larus/bmhome/rc/ResourceFingerprintMeta;Lcom/larus/bmhome/rc/ResourceTargetMeta;)V", "getFileMeta", "()Lcom/larus/bmhome/rc/FileResourceMeta;", "getImageMeta", "()Lcom/larus/bmhome/rc/ImageResourceMeta;", "getAudioMeta", "()Lcom/larus/bmhome/rc/AudioResourceMeta;", "getVideoMeta", "()Lcom/larus/bmhome/rc/VideoResourceMeta;", "getFingerprintMeta", "()Lcom/larus/bmhome/rc/ResourceFingerprintMeta;", "getTargetMeta", "()Lcom/larus/bmhome/rc/ResourceTargetMeta;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowResourceMeta {

    @SerializedName("audio_meta")
    private final AudioResourceMeta audioMeta;

    @SerializedName("file_meta")
    private final FileResourceMeta fileMeta;

    @SerializedName("fingerprint_meta")
    private final ResourceFingerprintMeta fingerprintMeta;

    @SerializedName("image_meta")
    private final ImageResourceMeta imageMeta;

    @SerializedName("target_meta")
    private final ResourceTargetMeta targetMeta;

    @SerializedName("video_meta")
    private final VideoResourceMeta videoMeta;

    public FlowResourceMeta() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ FlowResourceMeta copy$default(FlowResourceMeta r4, FileResourceMeta r5, ImageResourceMeta r6, AudioResourceMeta r7, VideoResourceMeta r8, ResourceFingerprintMeta r9, ResourceTargetMeta r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.fileMeta;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.imageMeta;
    L8:
        ImageResourceMeta r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.audioMeta;
    L11:
        AudioResourceMeta r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.videoMeta;
    L14:
        VideoResourceMeta r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.fingerprintMeta;
    L17:
        ResourceFingerprintMeta r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.targetMeta;
    L20:
        FileResourceMeta r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final FileResourceMeta component1() {
        return this.fileMeta;
    }

    public final ImageResourceMeta component2() {
        return this.imageMeta;
    }

    public final AudioResourceMeta component3() {
        return this.audioMeta;
    }

    public final VideoResourceMeta component4() {
        return this.videoMeta;
    }

    public final ResourceFingerprintMeta component5() {
        return this.fingerprintMeta;
    }

    public final ResourceTargetMeta component6() {
        return this.targetMeta;
    }

    public final FlowResourceMeta copy(FileResourceMeta r9, ImageResourceMeta r10, AudioResourceMeta r11, VideoResourceMeta r12, ResourceFingerprintMeta r13, ResourceTargetMeta r14) {
        return new FlowResourceMeta(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FlowResourceMeta) == true) goto L8;
        return false;
    L8:
        FlowResourceMeta r6 = (FlowResourceMeta) r5;
        if (Intrinsics.areEqual(this.fileMeta, r6.fileMeta) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageMeta, r6.imageMeta) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.audioMeta, r6.audioMeta) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.videoMeta, r6.videoMeta) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fingerprintMeta, r6.fingerprintMeta) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.targetMeta, r6.targetMeta) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        FileResourceMeta r0 = this.fileMeta;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ImageResourceMeta r4 = this.imageMeta;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        AudioResourceMeta r7 = this.audioMeta;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        VideoResourceMeta r10 = this.videoMeta;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        ResourceFingerprintMeta r13 = this.fingerprintMeta;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        ResourceTargetMeta r16 = this.targetMeta;
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

    public String toString() {
        return "FlowResourceMeta(fileMeta=" + this.fileMeta + ", imageMeta=" + this.imageMeta + ", audioMeta=" + this.audioMeta + ", videoMeta=" + this.videoMeta + ", fingerprintMeta=" + this.fingerprintMeta + ", targetMeta=" + this.targetMeta + ')';
    }

    public final AudioResourceMeta getAudioMeta() {
        return this.audioMeta;
    }

    public final FileResourceMeta getFileMeta() {
        return this.fileMeta;
    }

    public final ResourceFingerprintMeta getFingerprintMeta() {
        return this.fingerprintMeta;
    }

    public final ImageResourceMeta getImageMeta() {
        return this.imageMeta;
    }

    public final ResourceTargetMeta getTargetMeta() {
        return this.targetMeta;
    }

    public final VideoResourceMeta getVideoMeta() {
        return this.videoMeta;
    }

    public FlowResourceMeta(FileResourceMeta r1, ImageResourceMeta r2, AudioResourceMeta r3, VideoResourceMeta r4, ResourceFingerprintMeta r5, ResourceTargetMeta r6) {
        this.fileMeta = r1;
        this.imageMeta = r2;
        this.audioMeta = r3;
        this.videoMeta = r4;
        this.fingerprintMeta = r5;
        this.targetMeta = r6;
    }

    public /* synthetic */ FlowResourceMeta(FileResourceMeta r6, ImageResourceMeta r7, AudioResourceMeta r8, VideoResourceMeta r9, ResourceFingerprintMeta r10, ResourceTargetMeta r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        FileResourceMeta r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        ImageResourceMeta r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        AudioResourceMeta r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        VideoResourceMeta r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        ResourceFingerprintMeta r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        ResourceTargetMeta r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}

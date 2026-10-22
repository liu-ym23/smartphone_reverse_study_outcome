package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003J`\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020\u000bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001a¨\u0006)"}, d2 = {"Lcom/larus/platform/model/chat/UploadVideoEntityTransConf;", "", "enable", "", "transVideoWidth", "", "transVideoHeight", "transVideoFps", "transVideoBitrate", "", "transVideoCodec", "", "transVideoType", "<init>", "(ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getEnable", "()Z", "getTransVideoWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTransVideoHeight", "getTransVideoFps", "getTransVideoBitrate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTransVideoCodec", "()Ljava/lang/String;", "getTransVideoType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/platform/model/chat/UploadVideoEntityTransConf;", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class v0 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("trans_video_bitrate")
    private final Long transVideoBitrate;

    @SerializedName("trans_video_codec")
    private final String transVideoCodec;

    @SerializedName("trans_video_fps")
    private final Integer transVideoFps;

    @SerializedName("trans_video_height")
    private final Integer transVideoHeight;

    @SerializedName("trans_video_type")
    private final String transVideoType;

    @SerializedName("trans_video_width")
    private final Integer transVideoWidth;

    public v0() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof v0) == true) goto L8;
        return false;
    L8:
        v0 r6 = (v0) r5;
        if (this.enable == r6.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.transVideoWidth, r6.transVideoWidth) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.transVideoHeight, r6.transVideoHeight) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.transVideoFps, r6.transVideoFps) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.transVideoBitrate, r6.transVideoBitrate) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.transVideoCodec, r6.transVideoCodec) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.transVideoType, r6.transVideoType) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        Integer r2 = this.transVideoWidth;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        Integer r6 = this.transVideoHeight;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r5 + r7) * 31;
        Integer r9 = this.transVideoFps;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        Long r12 = this.transVideoBitrate;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        String r15 = this.transVideoCodec;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        String r18 = this.transVideoType;
        if (r18 == null) goto L31;
        r3 = r18.hashCode();
    L31:
        return r17 + r3;
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "UploadVideoEntityTransConf(enable=" + this.enable + ", transVideoWidth=" + this.transVideoWidth + ", transVideoHeight=" + this.transVideoHeight + ", transVideoFps=" + this.transVideoFps + ", transVideoBitrate=" + this.transVideoBitrate + ", transVideoCodec=" + this.transVideoCodec + ", transVideoType=" + this.transVideoType + ')';
    }

    public final boolean a() {
        return this.enable;
    }

    public final Long b() {
        return this.transVideoBitrate;
    }

    public final String c() {
        return this.transVideoCodec;
    }

    public final Integer d() {
        return this.transVideoFps;
    }

    public final Integer e() {
        return this.transVideoHeight;
    }

    public final String f() {
        return this.transVideoType;
    }

    public final Integer g() {
        return this.transVideoWidth;
    }

    public /* synthetic */ v0(int r9) {
        this(true, 720, 720, 30, 3145728L, "h265", "mp4");
    }

    public v0(boolean r1, Integer r2, Integer r3, Integer r4, Long r5, String r6, String r7) {
        this.enable = r1;
        this.transVideoWidth = r2;
        this.transVideoHeight = r3;
        this.transVideoFps = r4;
        this.transVideoBitrate = r5;
        this.transVideoCodec = r6;
        this.transVideoType = r7;
    }
}

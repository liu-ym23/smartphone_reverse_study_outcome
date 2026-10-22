package hq9;

import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.ImageObj;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 82\u00020\u0001:\u00018Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00101\u001a\u00020\u0010HÆ\u0003Jy\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\tHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR \u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00069"}, d2 = {"Lcom/larus/platform/model/UploadedFileInfo;", "", "fileName", "", "fileUri", "fileUrl", "fileSize", "", "fileType", "", "ccmType", "imageThumb", "Lcom/larus/im/bean/message/ImageObj;", "imageOri", "videoCover", "videoDuration", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIILcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;F)V", "getFileName", "()Ljava/lang/String;", "getFileUri", "getFileUrl", "getFileSize", "()J", "getFileType", "()I", "getCcmType", "getImageThumb", "()Lcom/larus/im/bean/message/ImageObj;", "setImageThumb", "(Lcom/larus/im/bean/message/ImageObj;)V", "getImageOri", "setImageOri", "getVideoCover", "setVideoCover", "getVideoDuration", "()F", "setVideoDuration", "(F)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class w4 {

    @SerializedName("ccm_type")
    private final int ccmType;

    @SerializedName("file_name")
    private final String fileName;

    @SerializedName("file_size")
    private final long fileSize;

    @SerializedName("file_type")
    private final int fileType;

    @SerializedName("file_uri")
    private final String fileUri;

    @SerializedName("file_url")
    private final String fileUrl;

    @SerializedName("image_ori")
    private ImageObj imageOri;

    @SerializedName("image_thumb")
    private ImageObj imageThumb;

    @SerializedName("video_cover")
    private ImageObj videoCover;

    @SerializedName("video_duration")
    private float videoDuration;

    public static final class a {
    }

    static {
    }

    public w4() {
        this(null, null, null, 0, 0, 0, null, null, 1023);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof w4) == true) goto L8;
        return false;
    L8:
        w4 r9 = (w4) r8;
        if (Intrinsics.areEqual(this.fileName, r9.fileName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fileUri, r9.fileUri) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fileUrl, r9.fileUrl) == true) goto L18;
        return false;
    L18:
        if (this.fileSize == r9.fileSize) goto L21;
        return false;
    L21:
        if (this.fileType == r9.fileType) goto L24;
        return false;
    L24:
        if (this.ccmType == r9.ccmType) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.imageThumb, r9.imageThumb) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.imageOri, r9.imageOri) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.videoCover, r9.videoCover) == true) goto L36;
        return false;
    L36:
        if (Float.compare(this.videoDuration, r9.videoDuration) == 0) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r0 = this.fileName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.fileUri;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.fileUrl;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        long r10 = this.fileSize;
        int r11 = (((((r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31) + this.fileType) * 31) + this.ccmType) * 31;
        ImageObj r12 = this.imageThumb;
        if (r12 != null) goto L17;
        int r13 = 0;
    L18:
        int r14 = (r11 + r13) * 31;
        ImageObj r15 = this.imageOri;
        if (r15 != null) goto L21;
        int r16 = 0;
    L22:
        int r17 = (r14 + r16) * 31;
        ImageObj r18 = this.videoCover;
        if (r18 == null) goto L27;
        r1 = r18.hashCode();
    L27:
        return ((r17 + r1) * 31) + Float.floatToIntBits(this.videoDuration);
    L21:
        r16 = r15.hashCode();
        goto L22
    L17:
        r13 = r12.hashCode();
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
        return "UploadedFileInfo(fileName=" + this.fileName + ", fileUri=" + this.fileUri + ", fileUrl=" + this.fileUrl + ", fileSize=" + this.fileSize + ", fileType=" + this.fileType + ", ccmType=" + this.ccmType + ", imageThumb=" + this.imageThumb + ", imageOri=" + this.imageOri + ", videoCover=" + this.videoCover + ", videoDuration=" + this.videoDuration + ')';
    }

    public final int a() {
        return this.ccmType;
    }

    public final String b() {
        return this.fileName;
    }

    public final long c() {
        return this.fileSize;
    }

    public final int d() {
        return this.fileType;
    }

    public final String e() {
        return this.fileUri;
    }

    public final String f() {
        return this.fileUrl;
    }

    public final ImageObj g() {
        return this.imageOri;
    }

    public final ImageObj h() {
        return this.imageThumb;
    }

    public final float i() {
        return this.videoDuration;
    }

    public /* synthetic */ w4(String r16, String r17, String r18, long r19, int r21, int r22, ImageObj r23, ImageObj r24, int r25) {
        if ((r25 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r25 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r25 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r25 & 8) == 0) goto L17;
        long r7 = 0;
    L19:
        if ((r25 & 16) == 0) goto L21;
        int r9 = 0;
    L23:
        if ((r25 & 32) == 0) goto L25;
        int r10 = 12;
    L27:
        if ((r25 & 64) == 0) goto L29;
        ImageObj r11 = null;
    L31:
        if ((r25 & 128) == 0) goto L33;
        ImageObj r12 = null;
    L34:
        this(r4, r5, r6, r7, r9, r10, r11, r12, null, 0.0f);
        return;
    L33:
        r12 = r24;
        goto L34
    L29:
        r11 = r23;
        goto L31
    L25:
        r10 = r22;
        goto L27
    L21:
        r9 = r21;
        goto L23
    L17:
        r7 = r19;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r5 = r17;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }

    public w4(String r1, String r2, String r3, long r4, int r6, int r7, ImageObj r8, ImageObj r9, ImageObj r10, float r11) {
        this.fileName = r1;
        this.fileUri = r2;
        this.fileUrl = r3;
        this.fileSize = r4;
        this.fileType = r6;
        this.ccmType = r7;
        this.imageThumb = r8;
        this.imageOri = r9;
        this.videoCover = r10;
        this.videoDuration = r11;
    }
}

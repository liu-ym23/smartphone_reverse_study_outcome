package mr9;

import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.Image;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00105\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00106\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0014HÆ\u0003J¶\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010<J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\rHÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b&\u0010$R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b'\u0010$R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006B"}, d2 = {"Lcom/larus/platform/model/upload/LocalVideoResourceMeta;", "", "fileName", "", "identifier", "durationMs", "", "fps", "", "sizeByte", "format", "codec", "height", "", "width", "bitrate", "colorSpace", "colorModel", "colorRange", "coverImage", "Lcom/larus/im/bean/message/Image;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/Image;)V", "getFileName", "()Ljava/lang/String;", "getIdentifier", "getDurationMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFps", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getSizeByte", "getFormat", "getCodec", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWidth", "getBitrate", "getColorSpace", "getColorModel", "getColorRange", "getCoverImage", "()Lcom/larus/im/bean/message/Image;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/Image;)Lcom/larus/platform/model/upload/LocalVideoResourceMeta;", "equals", "", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class e {
    public final transient Image a;

    @SerializedName("bitrate")
    private final Integer bitrate;

    @SerializedName("codec")
    private final String codec;

    @SerializedName("color_model")
    private final String colorModel;

    @SerializedName("color_range")
    private final String colorRange;

    @SerializedName("color_space")
    private final String colorSpace;

    @SerializedName("duration_ms")
    private final Long durationMs;

    @SerializedName("file_name")
    private final String fileName;

    @SerializedName("format")
    private final String format;

    @SerializedName("fps")
    private final Float fps;

    @SerializedName("height")
    private final Integer height;

    @SerializedName("identifier")
    private final String identifier;

    @SerializedName("size_byte")
    private final Long sizeByte;

    @SerializedName("width")
    private final Integer width;

    public e() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 16383);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.fileName, r6.fileName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.identifier, r6.identifier) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.durationMs, r6.durationMs) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fps, r6.fps) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sizeByte, r6.sizeByte) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.format, r6.format) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.codec, r6.codec) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.height, r6.height) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.width, r6.width) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.bitrate, r6.bitrate) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.colorSpace, r6.colorSpace) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.colorModel, r6.colorModel) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.colorRange, r6.colorRange) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        String r0 = this.fileName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.identifier;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.durationMs;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Float r10 = this.fps;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.sizeByte;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.format;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.codec;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.height;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.width;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.bitrate;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.colorSpace;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.colorModel;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.colorRange;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        Image r40 = this.a;
        if (r40 == null) goto L59;
        r1 = r40.hashCode();
    L59:
        return r39 + r1;
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
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
        return "LocalVideoResourceMeta(fileName=" + this.fileName + ", identifier=" + this.identifier + ", durationMs=" + this.durationMs + ", fps=" + this.fps + ", sizeByte=" + this.sizeByte + ", format=" + this.format + ", codec=" + this.codec + ", height=" + this.height + ", width=" + this.width + ", bitrate=" + this.bitrate + ", colorSpace=" + this.colorSpace + ", colorModel=" + this.colorModel + ", colorRange=" + this.colorRange + ", coverImage=" + this.a + ')';
    }

    public final Integer b() {
        return this.bitrate;
    }

    public final String c() {
        return this.codec;
    }

    public final Long d() {
        return this.durationMs;
    }

    public final String e() {
        return this.fileName;
    }

    public final String f() {
        return this.format;
    }

    public final Float g() {
        return this.fps;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final Integer h() {
        return this.height;
    }

    public final Long i() {
        return this.sizeByte;
    }

    public final Integer j() {
        return this.width;
    }

    public static e a(e r19, Long r20, Float r21, Long r22, String r23, String r24, Integer r25, Integer r26, Integer r27, int r28) {
        Image r3 = null;
        if ((r28 & 1) == 0) goto L5;
        String r5 = r19.fileName;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r6 = r19.identifier;
    L11:
        if ((r28 & 4) == 0) goto L13;
        Long r7 = r19.durationMs;
    L15:
        if ((r28 & 8) == 0) goto L17;
        Float r8 = r19.fps;
    L19:
        if ((r28 & 16) == 0) goto L21;
        Long r9 = r19.sizeByte;
    L23:
        if ((r28 & 32) == 0) goto L25;
        String r10 = r19.format;
    L27:
        if ((r28 & 64) == 0) goto L29;
        String r11 = r19.codec;
    L31:
        if ((r28 & 128) == 0) goto L33;
        Integer r12 = r19.height;
    L35:
        if ((r28 & 256) == 0) goto L37;
        Integer r13 = r19.width;
    L39:
        if ((r28 & 512) == 0) goto L41;
        Integer r14 = r19.bitrate;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        String r15 = r19.colorSpace;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        String r16 = r19.colorModel;
    L51:
        if ((r28 & 4096) == 0) goto L53;
        String r17 = r19.colorRange;
    L55:
        if ((r28 & 8192) == 0) goto L58;
        r3 = r19.a;
    L58:
        return new e(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r3);
    L53:
        r17 = null;
        goto L55
    L49:
        r16 = null;
        goto L51
    L45:
        r15 = null;
        goto L47
    L41:
        r14 = r27;
        goto L43
    L37:
        r13 = r26;
        goto L39
    L33:
        r12 = r25;
        goto L35
    L29:
        r11 = r24;
        goto L31
    L25:
        r10 = r23;
        goto L27
    L21:
        r9 = r22;
        goto L23
    L17:
        r8 = r21;
        goto L19
    L13:
        r7 = r20;
        goto L15
    L9:
        r6 = null;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public /* synthetic */ e(String r19, String r20, Long r21, Float r22, Long r23, String r24, String r25, Integer r26, Integer r27, Integer r28, String r29, Image r30, int r31) {
        if ((r31 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r31 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r31 & 4) == 0) goto L13;
        Long r6 = null;
    L15:
        if ((r31 & 8) == 0) goto L17;
        Float r7 = null;
    L19:
        if ((r31 & 16) == 0) goto L21;
        Long r8 = null;
    L23:
        if ((r31 & 32) == 0) goto L25;
        String r9 = null;
    L27:
        if ((r31 & 64) == 0) goto L29;
        String r10 = null;
    L31:
        if ((r31 & 128) == 0) goto L33;
        Integer r11 = null;
    L35:
        if ((r31 & 256) == 0) goto L37;
        Integer r12 = null;
    L39:
        if ((r31 & 512) == 0) goto L41;
        Integer r13 = null;
    L43:
        if ((r31 & 4096) == 0) goto L45;
        String r16 = null;
    L47:
        if ((r31 & 8192) == 0) goto L49;
        Image r17 = null;
    L50:
        this(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, null, null, r16, r17);
        return;
    L49:
        r17 = r30;
        goto L50
    L45:
        r16 = r29;
        goto L47
    L41:
        r13 = r28;
        goto L43
    L37:
        r12 = r27;
        goto L39
    L33:
        r11 = r26;
        goto L35
    L29:
        r10 = r25;
        goto L31
    L25:
        r9 = r24;
        goto L27
    L21:
        r8 = r23;
        goto L23
    L17:
        r7 = r22;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r5 = r20;
        goto L11
    L5:
        r4 = r19;
        goto L7
    }

    public e(String r1, String r2, Long r3, Float r4, Long r5, String r6, String r7, Integer r8, Integer r9, Integer r10, String r11, String r12, String r13, Image r14) {
        this.fileName = r1;
        this.identifier = r2;
        this.durationMs = r3;
        this.fps = r4;
        this.sizeByte = r5;
        this.format = r6;
        this.codec = r7;
        this.height = r8;
        this.width = r9;
        this.bitrate = r10;
        this.colorSpace = r11;
        this.colorModel = r12;
        this.colorRange = r13;
        this.a = r14;
    }
}

package com.larus.avlink.e.mock;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jd\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u000bHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/larus/avlink/e/mock/CameraImageInfoJson;", "", "imageUUID", "", "side", "dataSize", "format", "width", "height", "linkType", "dataBase64", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;IIIIILjava/lang/String;)V", "getImageUUID", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSide", "getDataSize", "()I", "getFormat", "getWidth", "getHeight", "getLinkType", "getDataBase64", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;IIIIILjava/lang/String;)Lcom/larus/avlink/e/mock/CameraImageInfoJson;", "equals", "", "other", "hashCode", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CameraImageInfoJson {
    public static final int $stable = 0;

    @SerializedName("dataBase64")
    private final String dataBase64;

    @SerializedName("dataSize")
    private final int dataSize;

    @SerializedName("format")
    private final int format;

    @SerializedName("height")
    private final int height;

    @SerializedName("imageUUID")
    private final Integer imageUUID;

    @SerializedName("linkType")
    private final int linkType;

    @SerializedName("side")
    private final Integer side;

    @SerializedName("width")
    private final int width;

    public CameraImageInfoJson() {
        this(null, null, 0, 0, 0, 0, 0, null, 255, null);
    }

    public static /* synthetic */ CameraImageInfoJson copy$default(CameraImageInfoJson r9, Integer r10, Integer r11, int r12, int r13, int r14, int r15, int r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        Integer r2 = r9.imageUUID;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Integer r3 = r9.side;
    L11:
        if ((r18 & 4) == 0) goto L13;
        int r4 = r9.dataSize;
    L15:
        if ((r18 & 8) == 0) goto L17;
        int r5 = r9.format;
    L19:
        if ((r18 & 16) == 0) goto L21;
        int r6 = r9.width;
    L23:
        if ((r18 & 32) == 0) goto L25;
        int r7 = r9.height;
    L27:
        if ((r18 & 64) == 0) goto L29;
        int r8 = r9.linkType;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.dataBase64;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final Integer component1() {
        return this.imageUUID;
    }

    public final Integer component2() {
        return this.side;
    }

    public final int component3() {
        return this.dataSize;
    }

    public final int component4() {
        return this.format;
    }

    public final int component5() {
        return this.width;
    }

    public final int component6() {
        return this.height;
    }

    public final int component7() {
        return this.linkType;
    }

    public final String component8() {
        return this.dataBase64;
    }

    public final CameraImageInfoJson copy(Integer r11, Integer r12, int r13, int r14, int r15, int r16, int r17, String r18) {
        return new CameraImageInfoJson(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CameraImageInfoJson) == true) goto L8;
        return false;
    L8:
        CameraImageInfoJson r6 = (CameraImageInfoJson) r5;
        if (Intrinsics.areEqual(this.imageUUID, r6.imageUUID) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.side, r6.side) == true) goto L15;
        return false;
    L15:
        if (this.dataSize == r6.dataSize) goto L18;
        return false;
    L18:
        if (this.format == r6.format) goto L21;
        return false;
    L21:
        if (this.width == r6.width) goto L24;
        return false;
    L24:
        if (this.height == r6.height) goto L27;
        return false;
    L27:
        if (this.linkType == r6.linkType) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.dataBase64, r6.dataBase64) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.imageUUID;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.side;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((((((((((r3 + r5) * 31) + this.dataSize) * 31) + this.format) * 31) + this.width) * 31) + this.height) * 31) + this.linkType) * 31;
        String r7 = this.dataBase64;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CameraImageInfoJson(imageUUID=" + this.imageUUID + ", side=" + this.side + ", dataSize=" + this.dataSize + ", format=" + this.format + ", width=" + this.width + ", height=" + this.height + ", linkType=" + this.linkType + ", dataBase64=" + this.dataBase64 + ')';
    }

    public final String getDataBase64() {
        return this.dataBase64;
    }

    public final int getDataSize() {
        return this.dataSize;
    }

    public final int getFormat() {
        return this.format;
    }

    public final int getHeight() {
        return this.height;
    }

    public final Integer getImageUUID() {
        return this.imageUUID;
    }

    public final int getLinkType() {
        return this.linkType;
    }

    public final Integer getSide() {
        return this.side;
    }

    public final int getWidth() {
        return this.width;
    }

    public CameraImageInfoJson(Integer r1, Integer r2, int r3, int r4, int r5, int r6, int r7, String r8) {
        this.imageUUID = r1;
        this.side = r2;
        this.dataSize = r3;
        this.format = r4;
        this.width = r5;
        this.height = r6;
        this.linkType = r7;
        this.dataBase64 = r8;
    }

    public /* synthetic */ CameraImageInfoJson(Integer r10, Integer r11, int r12, int r13, int r14, int r15, int r16, String r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        Integer r1 = -1;
    L6:
        int r3 = 0;
        if ((r18 & 2) == 0) goto L9;
        Integer r2 = 0;
    L11:
        if ((r18 & 4) == 0) goto L13;
        int r4 = 0;
    L15:
        if ((r18 & 8) == 0) goto L17;
        int r5 = 0;
    L19:
        if ((r18 & 16) == 0) goto L21;
        int r6 = 0;
    L23:
        if ((r18 & 32) == 0) goto L25;
        int r7 = 0;
    L27:
        if ((r18 & 64) != 0) goto L31;
        r3 = r16;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r0 = null;
    L34:
        this(r1, r2, r4, r5, r6, r7, r3, r0);
        return;
    L33:
        r0 = r17;
        goto L34
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L6
    }
}

package com.larus.bmhome.chat.layout.holder.image.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b*\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010$J\t\u00104\u001a\u00020\rHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010$J´\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\r2\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020\u0010HÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\f\u0010 R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0011\u0010\u0011\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010&R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010%\u001a\u0004\b(\u0010$¨\u0006>"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageItem;", "Ljava/io/Serializable;", "key", "", "requestId", "imageThumb", "Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;", "imageOrigin", "previewImage", "rawImage", "refImage", "feedback", "isPlaceHolderImg", "", "imageTips", "index", "", "isLoading", "taskId", "taskType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/Integer;)V", "getKey", "()Ljava/lang/String;", "getRequestId", "getImageThumb", "()Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;", "getImageOrigin", "getPreviewImage", "getRawImage", "getRefImage", "getFeedback", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getImageTips", "getIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Z", "getTaskId", "getTaskType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageEntity;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageItem;", "equals", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ImageItem implements Serializable {
    public final transient Integer a;
    public final transient boolean b;
    public final transient String c;
    public final transient Integer d;

    @SerializedName("feedback")
    private final String feedback;

    @SerializedName("image_ori")
    private final ImageEntity imageOrigin;

    @SerializedName("image_thumb")
    private final ImageEntity imageThumb;

    @SerializedName("tips")
    private final String imageTips;

    @SerializedName("placeholder_img")
    private final Boolean isPlaceHolderImg;

    @SerializedName("key")
    private final String key;

    @SerializedName("preview_img")
    private final ImageEntity previewImage;

    @SerializedName("raw_image")
    private final ImageEntity rawImage;

    @SerializedName("ref_image")
    private final ImageEntity refImage;

    @SerializedName("request_id")
    private final String requestId;

    public ImageItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, false, null, null, 16383, null);
    }

    public static /* synthetic */ ImageItem copy$default(ImageItem r15, String r16, String r17, ImageEntity r18, ImageEntity r19, ImageEntity r20, ImageEntity r21, ImageEntity r22, String r23, Boolean r24, String r25, Integer r26, boolean r27, String r28, Integer r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        String r2 = r15.key;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r3 = r15.requestId;
    L11:
        if ((r30 & 4) == 0) goto L13;
        ImageEntity r4 = r15.imageThumb;
    L15:
        if ((r30 & 8) == 0) goto L17;
        ImageEntity r5 = r15.imageOrigin;
    L19:
        if ((r30 & 16) == 0) goto L21;
        ImageEntity r6 = r15.previewImage;
    L23:
        if ((r30 & 32) == 0) goto L25;
        ImageEntity r7 = r15.rawImage;
    L27:
        if ((r30 & 64) == 0) goto L29;
        ImageEntity r8 = r15.refImage;
    L31:
        if ((r30 & 128) == 0) goto L33;
        String r9 = r15.feedback;
    L35:
        if ((r30 & 256) == 0) goto L37;
        Boolean r10 = r15.isPlaceHolderImg;
    L39:
        if ((r30 & 512) == 0) goto L41;
        String r11 = r15.imageTips;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        Integer r12 = r15.a;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        boolean r13 = r15.b;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        String r14 = r15.c;
    L55:
        if ((r30 & 8192) == 0) goto L57;
        Integer r1 = r15.d;
    L59:
        return r15.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r1);
    L57:
        r1 = r29;
        goto L59
    L53:
        r14 = r28;
        goto L55
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final String component1() {
        return this.key;
    }

    public final String component10() {
        return this.imageTips;
    }

    public final Integer component11() {
        return this.a;
    }

    public final boolean component12() {
        return this.b;
    }

    public final String component13() {
        return this.c;
    }

    public final Integer component14() {
        return this.d;
    }

    public final String component2() {
        return this.requestId;
    }

    public final ImageEntity component3() {
        return this.imageThumb;
    }

    public final ImageEntity component4() {
        return this.imageOrigin;
    }

    public final ImageEntity component5() {
        return this.previewImage;
    }

    public final ImageEntity component6() {
        return this.rawImage;
    }

    public final ImageEntity component7() {
        return this.refImage;
    }

    public final String component8() {
        return this.feedback;
    }

    public final Boolean component9() {
        return this.isPlaceHolderImg;
    }

    public final ImageItem copy(String r17, String r18, ImageEntity r19, ImageEntity r20, ImageEntity r21, ImageEntity r22, ImageEntity r23, String r24, Boolean r25, String r26, Integer r27, boolean r28, String r29, Integer r30) {
        return new ImageItem(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ImageItem) == true) goto L8;
        return false;
    L8:
        ImageItem r6 = (ImageItem) r5;
        if (Intrinsics.areEqual(this.key, r6.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.requestId, r6.requestId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageThumb, r6.imageThumb) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageOrigin, r6.imageOrigin) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.previewImage, r6.previewImage) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.rawImage, r6.rawImage) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.refImage, r6.refImage) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.feedback, r6.feedback) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.isPlaceHolderImg, r6.isPlaceHolderImg) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.imageTips, r6.imageTips) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L42;
        return false;
    L42:
        if (this.b == r6.b) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        String r0 = this.key;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.requestId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        ImageEntity r7 = this.imageThumb;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        ImageEntity r10 = this.imageOrigin;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        ImageEntity r13 = this.previewImage;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        ImageEntity r16 = this.rawImage;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        ImageEntity r19 = this.refImage;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.feedback;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.isPlaceHolderImg;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.imageTips;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.a;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        if (this.b == false) goto L49;
        int r34 = 1231;
    L50:
        int r35 = (r33 + r34) * 31;
        String r36 = this.c;
        if (r36 != null) goto L53;
        int r37 = 0;
    L54:
        int r38 = (r35 + r37) * 31;
        Integer r39 = this.d;
        if (r39 == null) goto L59;
        r1 = r39.hashCode();
    L59:
        return r38 + r1;
    L53:
        r37 = r36.hashCode();
        goto L54
    L49:
        r34 = 1237;
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

    public String toString() {
        return "ImageItem(key=" + this.key + ", requestId=" + this.requestId + ", imageThumb=" + this.imageThumb + ", imageOrigin=" + this.imageOrigin + ", previewImage=" + this.previewImage + ", rawImage=" + this.rawImage + ", refImage=" + this.refImage + ", feedback=" + this.feedback + ", isPlaceHolderImg=" + this.isPlaceHolderImg + ", imageTips=" + this.imageTips + ", index=" + this.a + ", isLoading=" + this.b + ", taskId=" + this.c + ", taskType=" + this.d + ')';
    }

    public final String getFeedback() {
        return this.feedback;
    }

    public final ImageEntity getImageOrigin() {
        return this.imageOrigin;
    }

    public final ImageEntity getImageThumb() {
        return this.imageThumb;
    }

    public final String getImageTips() {
        return this.imageTips;
    }

    public final Integer getIndex() {
        return this.a;
    }

    public final String getKey() {
        return this.key;
    }

    public final ImageEntity getPreviewImage() {
        return this.previewImage;
    }

    public final ImageEntity getRawImage() {
        return this.rawImage;
    }

    public final ImageEntity getRefImage() {
        return this.refImage;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getTaskId() {
        return this.c;
    }

    public final Integer getTaskType() {
        return this.d;
    }

    public final boolean isLoading() {
        return this.b;
    }

    public final Boolean isPlaceHolderImg() {
        return this.isPlaceHolderImg;
    }

    public ImageItem(String r1, String r2, ImageEntity r3, ImageEntity r4, ImageEntity r5, ImageEntity r6, ImageEntity r7, String r8, Boolean r9, String r10, Integer r11, boolean r12, String r13, Integer r14) {
        this.key = r1;
        this.requestId = r2;
        this.imageThumb = r3;
        this.imageOrigin = r4;
        this.previewImage = r5;
        this.rawImage = r6;
        this.refImage = r7;
        this.feedback = r8;
        this.isPlaceHolderImg = r9;
        this.imageTips = r10;
        this.a = r11;
        this.b = r12;
        this.c = r13;
        this.d = r14;
    }

    public /* synthetic */ ImageItem(String r16, String r17, ImageEntity r18, ImageEntity r19, ImageEntity r20, ImageEntity r21, ImageEntity r22, String r23, Boolean r24, String r25, Integer r26, boolean r27, String r28, Integer r29, int r30, DefaultConstructorMarker r31) {
        Integer r2 = null;
        if ((r30 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r30 & 4) == 0) goto L13;
        ImageEntity r4 = null;
    L15:
        if ((r30 & 8) == 0) goto L17;
        ImageEntity r5 = null;
    L19:
        if ((r30 & 16) == 0) goto L21;
        ImageEntity r6 = null;
    L23:
        if ((r30 & 32) == 0) goto L25;
        ImageEntity r7 = null;
    L27:
        if ((r30 & 64) == 0) goto L29;
        ImageEntity r8 = null;
    L31:
        if ((r30 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r30 & 256) == 0) goto L37;
        Boolean r10 = Boolean.FALSE;
    L39:
        if ((r30 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        Integer r12 = null;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        boolean r13 = false;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r30 & 8192) != 0) goto L58;
        r2 = r29;
    L58:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r2);
        return;
    L53:
        r14 = r28;
        goto L55
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }
}

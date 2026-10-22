package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u001d\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u001d\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0096\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\n\u0010\u0018R%\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$MediaPickerShowOptions;", "Lcom/bytedance/ee/util/io/NonProguard;", "maxSelectedCount", BuildConfig.FLAVOR, "sourceType", "Ljava/util/ArrayList;", BuildConfig.FLAVOR, "Lkotlin/collections/ArrayList;", "mediaType", "maxDuration", "isSaveToAlbum", BuildConfig.FLAVOR, "sizeType", "cameraDeviceX", "<init>", "(ILjava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/ArrayList;Ljava/lang/String;)V", "getMaxSelectedCount", "()I", "getSourceType", "()Ljava/util/ArrayList;", "getMediaType", "getMaxDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSizeType", "getCameraDeviceX", "()Ljava/lang/String;", "cameraDevice", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$CameraDevice;", "getCameraDevice", "()Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$CameraDevice;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILjava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/ArrayList;Ljava/lang/String;)Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$MediaPickerShowOptions;", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWidget$MediaPickerShowOptions implements NonProguard {
    private final String cameraDeviceX;
    private final Boolean isSaveToAlbum;
    private final Integer maxDuration;
    private final int maxSelectedCount;
    private final ArrayList<String> mediaType;
    private final ArrayList<String> sizeType;
    private final ArrayList<String> sourceType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IWidget$MediaPickerShowOptions copy$default(IWidget$MediaPickerShowOptions r5, int r6, ArrayList r7, ArrayList r8, Integer r9, Boolean r10, ArrayList r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.maxSelectedCount;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.sourceType;
    L8:
        ArrayList r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.mediaType;
    L11:
        ArrayList r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.maxDuration;
    L14:
        Integer r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.isSaveToAlbum;
    L17:
        Boolean r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.sizeType;
    L20:
        ArrayList r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.cameraDeviceX;
    L23:
        int r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final int component1() {
        return this.maxSelectedCount;
    }

    public final ArrayList<String> component2() {
        return this.sourceType;
    }

    public final ArrayList<String> component3() {
        return this.mediaType;
    }

    public final Integer component4() {
        return this.maxDuration;
    }

    public final Boolean component5() {
        return this.isSaveToAlbum;
    }

    public final ArrayList<String> component6() {
        return this.sizeType;
    }

    public final String component7() {
        return this.cameraDeviceX;
    }

    public final IWidget$MediaPickerShowOptions copy(int r10, ArrayList<String> r11, ArrayList<String> r12, Integer r13, Boolean r14, ArrayList<String> r15, @JSONField(name = "cameraDevice") String r16) {
        return new IWidget$MediaPickerShowOptions(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IWidget$MediaPickerShowOptions) == true) goto L8;
        return false;
    L8:
        IWidget$MediaPickerShowOptions r6 = (IWidget$MediaPickerShowOptions) r5;
        if (this.maxSelectedCount == r6.maxSelectedCount) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sourceType, r6.sourceType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.mediaType, r6.mediaType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxDuration, r6.maxDuration) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isSaveToAlbum, r6.isSaveToAlbum) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sizeType, r6.sizeType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.cameraDeviceX, r6.cameraDeviceX) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = this.maxSelectedCount * 31;
        ArrayList<String> r1 = this.sourceType;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        ArrayList<String> r5 = this.mediaType;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.maxDuration;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Boolean r11 = this.isSaveToAlbum;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        ArrayList<String> r14 = this.sizeType;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.cameraDeviceX;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return r16 + r2;
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "MediaPickerShowOptions(maxSelectedCount=" + this.maxSelectedCount + ", sourceType=" + this.sourceType + ", mediaType=" + this.mediaType + ", maxDuration=" + this.maxDuration + ", isSaveToAlbum=" + this.isSaveToAlbum + ", sizeType=" + this.sizeType + ", cameraDeviceX=" + this.cameraDeviceX + ')';
    }

    public final IWidget$CameraDevice getCameraDevice() {
        String r0 = this.cameraDeviceX;
        if (r0 == null) goto L16;
        IWidget$CameraDevice.Companion.getClass();
        Intrinsics.checkNotNullParameter(r0, "value");
        IWidget$CameraDevice[] r1 = IWidget$CameraDevice.values();
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L10;
        IWidget$CameraDevice r4 = r1[r3];
        if (Intrinsics.areEqual(r4.getValue(), r0) == true) goto L11;
        r3 = r3 + 1;
    L11:
        if (r4 != null) goto L14;
        r4 = IWidget$CameraDevice.Back;
    L14:
        if (r4 == null) goto L16;
        return r4;
    L10:
        r4 = null;
    L16:
        return IWidget$CameraDevice.Back;
    }

    public final String getCameraDeviceX() {
        return this.cameraDeviceX;
    }

    public final Integer getMaxDuration() {
        return this.maxDuration;
    }

    public final int getMaxSelectedCount() {
        return this.maxSelectedCount;
    }

    public final ArrayList<String> getMediaType() {
        return this.mediaType;
    }

    public final ArrayList<String> getSizeType() {
        return this.sizeType;
    }

    public final ArrayList<String> getSourceType() {
        return this.sourceType;
    }

    public final Boolean isSaveToAlbum() {
        return this.isSaveToAlbum;
    }

    public IWidget$MediaPickerShowOptions(int r1, ArrayList<String> r2, ArrayList<String> r3, Integer r4, Boolean r5, ArrayList<String> r6, @JSONField(name = "cameraDevice") String r7) {
        this.maxSelectedCount = r1;
        this.sourceType = r2;
        this.mediaType = r3;
        this.maxDuration = r4;
        this.isSaveToAlbum = r5;
        this.sizeType = r6;
        this.cameraDeviceX = r7;
    }

    public /* synthetic */ IWidget$MediaPickerShowOptions(int r10, ArrayList r11, ArrayList r12, Integer r13, Boolean r14, ArrayList r15, String r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 1) == 0) goto L5;
        int r2 = 9;
    L7:
        if ((r17 & 8) == 0) goto L9;
        Integer r5 = 60000;
    L11:
        if ((r17 & 16) == 0) goto L13;
        Boolean r6 = Boolean.FALSE;
    L15:
        if ((r17 & 64) == 0) goto L17;
        String r8 = null;
    L18:
        this(r2, r11, r12, r5, r6, r15, r8);
        return;
    L17:
        r8 = r16;
        goto L18
    L13:
        r6 = r14;
        goto L15
    L9:
        r5 = r13;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }
}

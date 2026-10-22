package com.larus.camera.api.params;

import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010%\u001a\u00020\fHÆ\u0003J\u0015\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000eHÆ\u0003Jn\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000eHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\tHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/larus/camera/api/params/CameraResultOutOpenParams;", "Ljava/io/Serializable;", "imgPath", "", "supportMultiImages", "", "markTipsRest", "disableCaptureDetect", "enterAnim", "", "exitAnim", "openPageTriggerTimeMs", "", "intentBooleanExtras", "", "<init>", "(Ljava/lang/String;ZZZLjava/lang/Integer;Ljava/lang/Integer;JLjava/util/Map;)V", "getImgPath", "()Ljava/lang/String;", "getSupportMultiImages", "()Z", "getMarkTipsRest", "getDisableCaptureDetect", "getEnterAnim", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExitAnim", "getOpenPageTriggerTimeMs", "()J", "getIntentBooleanExtras", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;ZZZLjava/lang/Integer;Ljava/lang/Integer;JLjava/util/Map;)Lcom/larus/camera/api/params/CameraResultOutOpenParams;", "equals", "other", "", "hashCode", "toString", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraResultOutOpenParams implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private final boolean disableCaptureDetect;
    private final Integer enterAnim;
    private final Integer exitAnim;
    private final String imgPath;
    private final Map<String, Boolean> intentBooleanExtras;
    private final boolean markTipsRest;
    private final long openPageTriggerTimeMs;
    private final boolean supportMultiImages;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CameraResultOutOpenParams copy$default(CameraResultOutOpenParams r10, String r11, boolean r12, boolean r13, boolean r14, Integer r15, Integer r16, long r17, Map r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.imgPath;
    L7:
        if ((r20 & 2) == 0) goto L9;
        boolean r3 = r10.supportMultiImages;
    L11:
        if ((r20 & 4) == 0) goto L13;
        boolean r4 = r10.markTipsRest;
    L15:
        if ((r20 & 8) == 0) goto L17;
        boolean r5 = r10.disableCaptureDetect;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Integer r6 = r10.enterAnim;
    L23:
        if ((r20 & 32) == 0) goto L25;
        Integer r7 = r10.exitAnim;
    L27:
        if ((r20 & 64) == 0) goto L29;
        long r8 = r10.openPageTriggerTimeMs;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Map r1 = r10.intentBooleanExtras;
    L35:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r19;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final String component1() {
        return this.imgPath;
    }

    public final boolean component2() {
        return this.supportMultiImages;
    }

    public final boolean component3() {
        return this.markTipsRest;
    }

    public final boolean component4() {
        return this.disableCaptureDetect;
    }

    public final Integer component5() {
        return this.enterAnim;
    }

    public final Integer component6() {
        return this.exitAnim;
    }

    public final long component7() {
        return this.openPageTriggerTimeMs;
    }

    public final Map<String, Boolean> component8() {
        return this.intentBooleanExtras;
    }

    public final CameraResultOutOpenParams copy(String r12, boolean r13, boolean r14, boolean r15, Integer r16, Integer r17, long r18, Map<String, Boolean> r20) {
        Intrinsics.checkNotNullParameter(r12, "imgPath");
        Intrinsics.checkNotNullParameter(r20, "intentBooleanExtras");
        return new CameraResultOutOpenParams(r12, r13, r14, r15, r16, r17, r18, r20);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof CameraResultOutOpenParams) == true) goto L8;
        return false;
    L8:
        CameraResultOutOpenParams r9 = (CameraResultOutOpenParams) r8;
        if (Intrinsics.areEqual(this.imgPath, r9.imgPath) == true) goto L12;
        return false;
    L12:
        if (this.supportMultiImages == r9.supportMultiImages) goto L15;
        return false;
    L15:
        if (this.markTipsRest == r9.markTipsRest) goto L18;
        return false;
    L18:
        if (this.disableCaptureDetect == r9.disableCaptureDetect) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.enterAnim, r9.enterAnim) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.exitAnim, r9.exitAnim) == true) goto L27;
        return false;
    L27:
        if (this.openPageTriggerTimeMs == r9.openPageTriggerTimeMs) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.intentBooleanExtras, r9.intentBooleanExtras) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = this.imgPath.hashCode() * 31;
        int r2 = 1231;
        if (this.supportMultiImages == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.markTipsRest == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.disableCaptureDetect == true) goto L14;
        r2 = 1237;
    L14:
        int r6 = (r5 + r2) * 31;
        Integer r7 = this.enterAnim;
        int r8 = 0;
        if (r7 != null) goto L17;
        int r9 = 0;
    L18:
        int r10 = (r6 + r9) * 31;
        Integer r11 = this.exitAnim;
        if (r11 == null) goto L22;
        r8 = r11.hashCode();
    L22:
        long r12 = this.openPageTriggerTimeMs;
        return ((((r10 + r8) * 31) + ((int) (r12 ^ (r12 >>> 32)))) * 31) + this.intentBooleanExtras.hashCode();
    L17:
        r9 = r7.hashCode();
        goto L18
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "CameraResultOutOpenParams(imgPath=" + this.imgPath + ", supportMultiImages=" + this.supportMultiImages + ", markTipsRest=" + this.markTipsRest + ", disableCaptureDetect=" + this.disableCaptureDetect + ", enterAnim=" + this.enterAnim + ", exitAnim=" + this.exitAnim + ", openPageTriggerTimeMs=" + this.openPageTriggerTimeMs + ", intentBooleanExtras=" + this.intentBooleanExtras + ')';
    }

    public final boolean getDisableCaptureDetect() {
        return this.disableCaptureDetect;
    }

    public final Integer getEnterAnim() {
        return this.enterAnim;
    }

    public final Integer getExitAnim() {
        return this.exitAnim;
    }

    public final String getImgPath() {
        return this.imgPath;
    }

    public final Map<String, Boolean> getIntentBooleanExtras() {
        return this.intentBooleanExtras;
    }

    public final boolean getMarkTipsRest() {
        return this.markTipsRest;
    }

    public final long getOpenPageTriggerTimeMs() {
        return this.openPageTriggerTimeMs;
    }

    public final boolean getSupportMultiImages() {
        return this.supportMultiImages;
    }

    public CameraResultOutOpenParams(String r2, boolean r3, boolean r4, boolean r5, Integer r6, Integer r7, long r8, Map<String, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r2, "imgPath");
        Intrinsics.checkNotNullParameter(r10, "intentBooleanExtras");
        this.imgPath = r2;
        this.supportMultiImages = r3;
        this.markTipsRest = r4;
        this.disableCaptureDetect = r5;
        this.enterAnim = r6;
        this.exitAnim = r7;
        this.openPageTriggerTimeMs = r8;
        this.intentBooleanExtras = r10;
    }

    public /* synthetic */ CameraResultOutOpenParams(String r14, boolean r15, boolean r16, boolean r17, Integer r18, Integer r19, long r20, Map r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 4) == 0) goto L5;
        boolean r6 = false;
    L7:
        if ((r23 & 8) == 0) goto L9;
        boolean r7 = false;
    L11:
        if ((r23 & 16) == 0) goto L13;
        Integer r8 = null;
    L15:
        if ((r23 & 32) == 0) goto L17;
        Integer r9 = null;
    L19:
        if ((r23 & 64) == 0) goto L21;
        long r10 = System.currentTimeMillis();
    L23:
        if ((r23 & 128) == 0) goto L25;
        Map r12 = MapsKt.emptyMap();
    L26:
        this(r14, r15, r6, r7, r8, r9, r10, r12);
        return;
    L25:
        r12 = r22;
        goto L26
    L21:
        r10 = r20;
        goto L23
    L17:
        r9 = r19;
        goto L19
    L13:
        r8 = r18;
        goto L15
    L9:
        r7 = r17;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }
}

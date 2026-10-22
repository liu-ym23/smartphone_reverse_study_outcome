package com.larus.platform.model.album;

import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00102\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u009c\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0005HÖ\u0001J\t\u0010<\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001bR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b!\u0010\u001bR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\"\u0010\u001bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b#\u0010\u001bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b$\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&¨\u0006="}, d2 = {"Lcom/larus/platform/model/album/CreationReferenceAlbumMediaRule;", "Ljava/io/Serializable;", "type", "Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;", "maxCount", "", "maxTotalDuration", "", "maxResolution", "", "minRatio", "maxRatio", "minSingleDuration", "maxSingleDuration", "maxFileSize", "maxCountDisplayText", "", "maxTotalDurationDisplayText", "maxResolutionDisplayText", "<init>", "(Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;", "getMaxCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxTotalDuration", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMaxResolution", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMinRatio", "getMaxRatio", "getMinSingleDuration", "getMaxSingleDuration", "getMaxFileSize", "getMaxCountDisplayText", "()Ljava/lang/String;", "getMaxTotalDurationDisplayText", "getMaxResolutionDisplayText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/platform/model/album/CreationReferenceAlbumMediaRule;", "equals", "", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationReferenceAlbumMediaRule implements Serializable {
    private final Integer maxCount;
    private final String maxCountDisplayText;
    private final Long maxFileSize;
    private final Double maxRatio;
    private final Long maxResolution;
    private final String maxResolutionDisplayText;
    private final Double maxSingleDuration;
    private final Double maxTotalDuration;
    private final String maxTotalDurationDisplayText;
    private final Double minRatio;
    private final Double minSingleDuration;
    private final CreationReferenceAlbumMediaType type;

    public static /* synthetic */ CreationReferenceAlbumMediaRule copy$default(CreationReferenceAlbumMediaRule r13, CreationReferenceAlbumMediaType r14, Integer r15, Double r16, Long r17, Double r18, Double r19, Double r20, Double r21, Long r22, String r23, String r24, String r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        CreationReferenceAlbumMediaType r2 = r13.type;
    L7:
        if ((r26 & 2) == 0) goto L9;
        Integer r3 = r13.maxCount;
    L11:
        if ((r26 & 4) == 0) goto L13;
        Double r4 = r13.maxTotalDuration;
    L15:
        if ((r26 & 8) == 0) goto L17;
        Long r5 = r13.maxResolution;
    L19:
        if ((r26 & 16) == 0) goto L21;
        Double r6 = r13.minRatio;
    L23:
        if ((r26 & 32) == 0) goto L25;
        Double r7 = r13.maxRatio;
    L27:
        if ((r26 & 64) == 0) goto L29;
        Double r8 = r13.minSingleDuration;
    L31:
        if ((r26 & 128) == 0) goto L33;
        Double r9 = r13.maxSingleDuration;
    L35:
        if ((r26 & 256) == 0) goto L37;
        Long r10 = r13.maxFileSize;
    L39:
        if ((r26 & 512) == 0) goto L41;
        String r11 = r13.maxCountDisplayText;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        String r12 = r13.maxTotalDurationDisplayText;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        String r1 = r13.maxResolutionDisplayText;
    L51:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r25;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final CreationReferenceAlbumMediaType component1() {
        return this.type;
    }

    public final String component10() {
        return this.maxCountDisplayText;
    }

    public final String component11() {
        return this.maxTotalDurationDisplayText;
    }

    public final String component12() {
        return this.maxResolutionDisplayText;
    }

    public final Integer component2() {
        return this.maxCount;
    }

    public final Double component3() {
        return this.maxTotalDuration;
    }

    public final Long component4() {
        return this.maxResolution;
    }

    public final Double component5() {
        return this.minRatio;
    }

    public final Double component6() {
        return this.maxRatio;
    }

    public final Double component7() {
        return this.minSingleDuration;
    }

    public final Double component8() {
        return this.maxSingleDuration;
    }

    public final Long component9() {
        return this.maxFileSize;
    }

    public final CreationReferenceAlbumMediaRule copy(CreationReferenceAlbumMediaType r15, Integer r16, Double r17, Long r18, Double r19, Double r20, Double r21, Double r22, Long r23, String r24, String r25, String r26) {
        Intrinsics.checkNotNullParameter(r15, "type");
        return new CreationReferenceAlbumMediaRule(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationReferenceAlbumMediaRule) == true) goto L8;
        return false;
    L8:
        CreationReferenceAlbumMediaRule r6 = (CreationReferenceAlbumMediaRule) r5;
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxCount, r6.maxCount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxTotalDuration, r6.maxTotalDuration) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxResolution, r6.maxResolution) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.minRatio, r6.minRatio) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.maxRatio, r6.maxRatio) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.minSingleDuration, r6.minSingleDuration) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.maxSingleDuration, r6.maxSingleDuration) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.maxFileSize, r6.maxFileSize) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.maxCountDisplayText, r6.maxCountDisplayText) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.maxTotalDurationDisplayText, r6.maxTotalDurationDisplayText) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.maxResolutionDisplayText, r6.maxResolutionDisplayText) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r0 = this.type.hashCode() * 31;
        Integer r1 = this.maxCount;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Double r5 = this.maxTotalDuration;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.maxResolution;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Double r11 = this.minRatio;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Double r14 = this.maxRatio;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Double r17 = this.minSingleDuration;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Double r20 = this.maxSingleDuration;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Long r23 = this.maxFileSize;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.maxCountDisplayText;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        String r29 = this.maxTotalDurationDisplayText;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        String r32 = this.maxResolutionDisplayText;
        if (r32 == null) goto L47;
        r2 = r32.hashCode();
    L47:
        return r31 + r2;
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
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
        return "CreationReferenceAlbumMediaRule(type=" + this.type + ", maxCount=" + this.maxCount + ", maxTotalDuration=" + this.maxTotalDuration + ", maxResolution=" + this.maxResolution + ", minRatio=" + this.minRatio + ", maxRatio=" + this.maxRatio + ", minSingleDuration=" + this.minSingleDuration + ", maxSingleDuration=" + this.maxSingleDuration + ", maxFileSize=" + this.maxFileSize + ", maxCountDisplayText=" + this.maxCountDisplayText + ", maxTotalDurationDisplayText=" + this.maxTotalDurationDisplayText + ", maxResolutionDisplayText=" + this.maxResolutionDisplayText + ')';
    }

    public final Integer getMaxCount() {
        return this.maxCount;
    }

    public final String getMaxCountDisplayText() {
        return this.maxCountDisplayText;
    }

    public final Long getMaxFileSize() {
        return this.maxFileSize;
    }

    public final Double getMaxRatio() {
        return this.maxRatio;
    }

    public final Long getMaxResolution() {
        return this.maxResolution;
    }

    public final String getMaxResolutionDisplayText() {
        return this.maxResolutionDisplayText;
    }

    public final Double getMaxSingleDuration() {
        return this.maxSingleDuration;
    }

    public final Double getMaxTotalDuration() {
        return this.maxTotalDuration;
    }

    public final String getMaxTotalDurationDisplayText() {
        return this.maxTotalDurationDisplayText;
    }

    public final Double getMinRatio() {
        return this.minRatio;
    }

    public final Double getMinSingleDuration() {
        return this.minSingleDuration;
    }

    public final CreationReferenceAlbumMediaType getType() {
        return this.type;
    }

    public CreationReferenceAlbumMediaRule(CreationReferenceAlbumMediaType r2, Integer r3, Double r4, Long r5, Double r6, Double r7, Double r8, Double r9, Long r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.type = r2;
        this.maxCount = r3;
        this.maxTotalDuration = r4;
        this.maxResolution = r5;
        this.minRatio = r6;
        this.maxRatio = r7;
        this.minSingleDuration = r8;
        this.maxSingleDuration = r9;
        this.maxFileSize = r10;
        this.maxCountDisplayText = r11;
        this.maxTotalDurationDisplayText = r12;
        this.maxResolutionDisplayText = r13;
    }

    public /* synthetic */ CreationReferenceAlbumMediaRule(CreationReferenceAlbumMediaType r17, Integer r18, Double r19, Long r20, Double r21, Double r22, Double r23, Double r24, Long r25, String r26, String r27, String r28, int r29, DefaultConstructorMarker r30) {
        if ((r29 & 512) == 0) goto L5;
        String r13 = null;
    L7:
        if ((r29 & 1024) == 0) goto L9;
        String r14 = null;
    L11:
        if ((r29 & 2048) == 0) goto L13;
        String r15 = null;
    L14:
        this(r17, r18, r19, r20, r21, r22, r23, r24, r25, r13, r14, r15);
        return;
    L13:
        r15 = r28;
        goto L14
    L9:
        r14 = r27;
        goto L11
    L5:
        r13 = r26;
        goto L7
    }
}

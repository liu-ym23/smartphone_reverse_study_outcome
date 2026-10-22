package com.larus.platform.model.album;

import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003JN\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\t\u0010%\u001a\u00020\nHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006&"}, d2 = {"Lcom/larus/platform/model/album/CreationReferenceAlbumMixedRule;", "Ljava/io/Serializable;", "subTypes", "", "Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;", "maxCount", "", "maxTotalDuration", "", "maxCountDisplayText", "", "maxTotalDurationDisplayText", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)V", "getSubTypes", "()Ljava/util/List;", "getMaxCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxTotalDuration", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMaxCountDisplayText", "()Ljava/lang/String;", "getMaxTotalDurationDisplayText", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/platform/model/album/CreationReferenceAlbumMixedRule;", "equals", "", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationReferenceAlbumMixedRule implements Serializable {
    private final Integer maxCount;
    private final String maxCountDisplayText;
    private final Double maxTotalDuration;
    private final String maxTotalDurationDisplayText;
    private final List<CreationReferenceAlbumMediaType> subTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreationReferenceAlbumMixedRule copy$default(CreationReferenceAlbumMixedRule r3, List r4, Integer r5, Double r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.subTypes;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.maxCount;
    L8:
        Integer r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.maxTotalDuration;
    L11:
        Double r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.maxCountDisplayText;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.maxTotalDurationDisplayText;
    L17:
        List r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final List<CreationReferenceAlbumMediaType> component1() {
        return this.subTypes;
    }

    public final Integer component2() {
        return this.maxCount;
    }

    public final Double component3() {
        return this.maxTotalDuration;
    }

    public final String component4() {
        return this.maxCountDisplayText;
    }

    public final String component5() {
        return this.maxTotalDurationDisplayText;
    }

    public final CreationReferenceAlbumMixedRule copy(List<? extends CreationReferenceAlbumMediaType> r8, Integer r9, Double r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "subTypes");
        return new CreationReferenceAlbumMixedRule(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationReferenceAlbumMixedRule) == true) goto L8;
        return false;
    L8:
        CreationReferenceAlbumMixedRule r6 = (CreationReferenceAlbumMixedRule) r5;
        if (Intrinsics.areEqual(this.subTypes, r6.subTypes) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxCount, r6.maxCount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxTotalDuration, r6.maxTotalDuration) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxCountDisplayText, r6.maxCountDisplayText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.maxTotalDurationDisplayText, r6.maxTotalDurationDisplayText) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.subTypes.hashCode() * 31;
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
        String r8 = this.maxCountDisplayText;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.maxTotalDurationDisplayText;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
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
        return "CreationReferenceAlbumMixedRule(subTypes=" + this.subTypes + ", maxCount=" + this.maxCount + ", maxTotalDuration=" + this.maxTotalDuration + ", maxCountDisplayText=" + this.maxCountDisplayText + ", maxTotalDurationDisplayText=" + this.maxTotalDurationDisplayText + ')';
    }

    public final Integer getMaxCount() {
        return this.maxCount;
    }

    public final String getMaxCountDisplayText() {
        return this.maxCountDisplayText;
    }

    public final Double getMaxTotalDuration() {
        return this.maxTotalDuration;
    }

    public final String getMaxTotalDurationDisplayText() {
        return this.maxTotalDurationDisplayText;
    }

    public final List<CreationReferenceAlbumMediaType> getSubTypes() {
        return this.subTypes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationReferenceAlbumMixedRule(List<? extends CreationReferenceAlbumMediaType> r2, Integer r3, Double r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "subTypes");
        this.subTypes = r2;
        this.maxCount = r3;
        this.maxTotalDuration = r4;
        this.maxCountDisplayText = r5;
        this.maxTotalDurationDisplayText = r6;
    }

    public /* synthetic */ CreationReferenceAlbumMixedRule(List r8, Integer r9, Double r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 8) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r13 & 16) == 0) goto L9;
        String r6 = null;
    L10:
        this(r8, r9, r10, r5, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }
}

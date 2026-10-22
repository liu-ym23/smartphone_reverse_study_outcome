package com.larus.platform.model.album;

import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001eJ\u001c\u0010\u001f\u001a\u0004\u0018\u00010\n2\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001eJ\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001aJ`\u0010)\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\fHÖ\u0001J\t\u00100\u001a\u00020\nHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u00061"}, d2 = {"Lcom/larus/platform/model/album/CreationReferenceAlbumConfig;", "Ljava/io/Serializable;", "mediaRules", "", "Lcom/larus/platform/model/album/CreationReferenceAlbumMediaRule;", "mixedRules", "Lcom/larus/platform/model/album/CreationReferenceAlbumMixedRule;", "existingAttachments", "Lcom/larus/platform/model/album/CreationReferenceAlbumAttachment;", "displayText", "", "additionalVideoCount", "", "additionalVideoDurationSeconds", "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ILjava/lang/Double;)V", "getMediaRules", "()Ljava/util/List;", "getMixedRules", "getExistingAttachments", "getDisplayText", "()Ljava/lang/String;", "getAdditionalVideoCount", "()I", "getAdditionalVideoDurationSeconds", "()Ljava/lang/Double;", "Ljava/lang/Double;", "ruleFor", "type", "Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;", "violationMessage", "violation", "Lcom/larus/platform/model/album/CreationReferenceAlbumViolation;", "candidateType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ILjava/lang/Double;)Lcom/larus/platform/model/album/CreationReferenceAlbumConfig;", "equals", "", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationReferenceAlbumConfig implements Serializable {
    private final int additionalVideoCount;
    private final Double additionalVideoDurationSeconds;
    private final String displayText;
    private final List<CreationReferenceAlbumAttachment> existingAttachments;
    private final List<CreationReferenceAlbumMediaRule> mediaRules;
    private final List<CreationReferenceAlbumMixedRule> mixedRules;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CreationReferenceAlbumViolation.values().length];
            r0[CreationReferenceAlbumViolation.TYPE_COUNT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[CreationReferenceAlbumViolation.MIXED_COUNT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[CreationReferenceAlbumViolation.TOTAL_DURATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[CreationReferenceAlbumViolation.MIXED_TOTAL_DURATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[CreationReferenceAlbumViolation.RESOLUTION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[CreationReferenceAlbumViolation.UNSUPPORTED_TYPE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[CreationReferenceAlbumViolation.METADATA_UNAVAILABLE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[CreationReferenceAlbumViolation.SINGLE_DURATION.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[CreationReferenceAlbumViolation.FILE_SIZE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[CreationReferenceAlbumViolation.RATIO.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            a = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreationReferenceAlbumConfig copy$default(CreationReferenceAlbumConfig r4, List r5, List r6, List r7, String r8, int r9, Double r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.mediaRules;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.mixedRules;
    L8:
        List r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.existingAttachments;
    L11:
        List r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.displayText;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.additionalVideoCount;
    L17:
        int r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.additionalVideoDurationSeconds;
    L20:
        List r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final List<CreationReferenceAlbumMediaRule> component1() {
        return this.mediaRules;
    }

    public final List<CreationReferenceAlbumMixedRule> component2() {
        return this.mixedRules;
    }

    public final List<CreationReferenceAlbumAttachment> component3() {
        return this.existingAttachments;
    }

    public final String component4() {
        return this.displayText;
    }

    public final int component5() {
        return this.additionalVideoCount;
    }

    public final Double component6() {
        return this.additionalVideoDurationSeconds;
    }

    public final CreationReferenceAlbumConfig copy(List<CreationReferenceAlbumMediaRule> r9, List<CreationReferenceAlbumMixedRule> r10, List<CreationReferenceAlbumAttachment> r11, String r12, int r13, Double r14) {
        Intrinsics.checkNotNullParameter(r9, "mediaRules");
        Intrinsics.checkNotNullParameter(r10, "mixedRules");
        Intrinsics.checkNotNullParameter(r11, "existingAttachments");
        return new CreationReferenceAlbumConfig(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationReferenceAlbumConfig) == true) goto L8;
        return false;
    L8:
        CreationReferenceAlbumConfig r6 = (CreationReferenceAlbumConfig) r5;
        if (Intrinsics.areEqual(this.mediaRules, r6.mediaRules) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mixedRules, r6.mixedRules) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.existingAttachments, r6.existingAttachments) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.displayText, r6.displayText) == true) goto L21;
        return false;
    L21:
        if (this.additionalVideoCount == r6.additionalVideoCount) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.additionalVideoDurationSeconds, r6.additionalVideoDurationSeconds) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.mediaRules.hashCode() * 31) + this.mixedRules.hashCode()) * 31) + this.existingAttachments.hashCode()) * 31;
        String r1 = this.displayText;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.additionalVideoCount) * 31;
        Double r5 = this.additionalVideoDurationSeconds;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationReferenceAlbumConfig(mediaRules=" + this.mediaRules + ", mixedRules=" + this.mixedRules + ", existingAttachments=" + this.existingAttachments + ", displayText=" + this.displayText + ", additionalVideoCount=" + this.additionalVideoCount + ", additionalVideoDurationSeconds=" + this.additionalVideoDurationSeconds + ')';
    }

    public final int getAdditionalVideoCount() {
        return this.additionalVideoCount;
    }

    public final Double getAdditionalVideoDurationSeconds() {
        return this.additionalVideoDurationSeconds;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final List<CreationReferenceAlbumAttachment> getExistingAttachments() {
        return this.existingAttachments;
    }

    public final List<CreationReferenceAlbumMediaRule> getMediaRules() {
        return this.mediaRules;
    }

    public final List<CreationReferenceAlbumMixedRule> getMixedRules() {
        return this.mixedRules;
    }

    public final CreationReferenceAlbumMediaRule ruleFor(CreationReferenceAlbumMediaType r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        Iterator<T> r0 = this.mediaRules.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((CreationReferenceAlbumMediaRule) r1).getType() != r4) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L13:
        return (CreationReferenceAlbumMediaRule) r1;
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L13
    }

    public final String violationMessage(CreationReferenceAlbumViolation r6, CreationReferenceAlbumMediaType r7) {
        Intrinsics.checkNotNullParameter(r6, "violation");
        if (r7 == null) goto L5;
        CreationReferenceAlbumMediaRule r1 = ruleFor(r7);
    L6:
        if (r7 == null) goto L15;
        Iterator<T> r2 = this.mixedRules.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        Object r3 = r2.next();
        if (((CreationReferenceAlbumMixedRule) r3).getSubTypes().contains(r7) == false) goto L9;
    L14:
        CreationReferenceAlbumMixedRule r4 = (CreationReferenceAlbumMixedRule) r3;
    L17:
        switch(a.a[r6.ordinal()]) {
            case 1: goto L29;
            case 2: goto L27;
            case 3: goto L25;
            case 4: goto L23;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L20;
            case 8: goto L20;
            case 9: goto L20;
            case 10: goto L20;
            default: goto L19;
        };
    L20:
        String r8 = null;
    L31:
        if (r8 != null) goto L33;
    L37:
        r8 = this.displayText;
        if (r8 != null) goto L40;
        return null;
    L40:
        if ((!StringsKt.isBlank(r8)) == true) goto L42;
        return null;
    L42:
        return r8;
    L33:
        if ((!StringsKt.isBlank(r8)) == true) goto L36;
        r8 = null;
    L36:
        if (r8 != null) goto L42;
    L21:
        if (r1 == null) goto L46;
        r8 = r1.getMaxResolutionDisplayText();
        goto L31
    L46:
        r8 = null;
        goto L31
    L23:
        if (r4 == null) goto L47;
        r8 = r4.getMaxTotalDurationDisplayText();
        goto L31
    L47:
        r8 = null;
        goto L31
    L25:
        if (r1 == null) goto L48;
        r8 = r1.getMaxTotalDurationDisplayText();
        goto L31
    L48:
        r8 = null;
        goto L31
    L27:
        if (r4 == null) goto L49;
        r8 = r4.getMaxCountDisplayText();
        goto L31
    L49:
        r8 = null;
        goto L31
    L29:
        if (r1 == null) goto L50;
        r8 = r1.getMaxCountDisplayText();
        goto L31
    L50:
        r8 = null;
        goto L31
    L19:
        throw new NoWhenBranchMatchedException();
    L13:
        r3 = null;
        goto L14
    L15:
        r4 = null;
        goto L17
    L5:
        r1 = null;
        goto L6
    }

    public static /* synthetic */ String violationMessage$default(CreationReferenceAlbumConfig r0, CreationReferenceAlbumViolation r1, CreationReferenceAlbumMediaType r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.violationMessage(r1, r2);
    }

    public CreationReferenceAlbumConfig(List<CreationReferenceAlbumMediaRule> r2, List<CreationReferenceAlbumMixedRule> r3, List<CreationReferenceAlbumAttachment> r4, String r5, int r6, Double r7) {
        Intrinsics.checkNotNullParameter(r2, "mediaRules");
        Intrinsics.checkNotNullParameter(r3, "mixedRules");
        Intrinsics.checkNotNullParameter(r4, "existingAttachments");
        this.mediaRules = r2;
        this.mixedRules = r3;
        this.existingAttachments = r4;
        this.displayText = r5;
        this.additionalVideoCount = r6;
        this.additionalVideoDurationSeconds = r7;
    }

    public /* synthetic */ CreationReferenceAlbumConfig(List r10, List r11, List r12, String r13, int r14, Double r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 8) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r16 & 16) == 0) goto L9;
        int r7 = 0;
    L11:
        if ((r16 & 32) == 0) goto L13;
        Double r8 = null;
    L14:
        this(r10, r11, r12, r6, r7, r8);
        return;
    L13:
        r8 = r15;
        goto L14
    L9:
        r7 = r14;
        goto L11
    L5:
        r6 = r13;
        goto L7
    }
}

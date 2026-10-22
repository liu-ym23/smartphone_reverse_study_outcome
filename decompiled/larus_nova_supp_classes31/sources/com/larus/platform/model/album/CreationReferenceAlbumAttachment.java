package com.larus.platform.model.album;

import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017JH\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/larus/platform/model/album/CreationReferenceAlbumAttachment;", "Ljava/io/Serializable;", "type", "Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;", "width", "", "height", "durationSeconds", "", "fileSize", "", "<init>", "(Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Long;)V", "getType", "()Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "getDurationSeconds", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getFileSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Long;)Lcom/larus/platform/model/album/CreationReferenceAlbumAttachment;", "equals", "", "other", "", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationReferenceAlbumAttachment implements Serializable {
    private final Double durationSeconds;
    private final Long fileSize;
    private final Integer height;
    private final CreationReferenceAlbumMediaType type;
    private final Integer width;

    public static /* synthetic */ CreationReferenceAlbumAttachment copy$default(CreationReferenceAlbumAttachment r3, CreationReferenceAlbumMediaType r4, Integer r5, Integer r6, Double r7, Long r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.type;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.width;
    L8:
        Integer r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.height;
    L11:
        Integer r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.durationSeconds;
    L14:
        Double r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.fileSize;
    L17:
        CreationReferenceAlbumMediaType r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final CreationReferenceAlbumMediaType component1() {
        return this.type;
    }

    public final Integer component2() {
        return this.width;
    }

    public final Integer component3() {
        return this.height;
    }

    public final Double component4() {
        return this.durationSeconds;
    }

    public final Long component5() {
        return this.fileSize;
    }

    public final CreationReferenceAlbumAttachment copy(CreationReferenceAlbumMediaType r8, Integer r9, Integer r10, Double r11, Long r12) {
        Intrinsics.checkNotNullParameter(r8, "type");
        return new CreationReferenceAlbumAttachment(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationReferenceAlbumAttachment) == true) goto L8;
        return false;
    L8:
        CreationReferenceAlbumAttachment r6 = (CreationReferenceAlbumAttachment) r5;
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.width, r6.width) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.height, r6.height) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.durationSeconds, r6.durationSeconds) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fileSize, r6.fileSize) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.type.hashCode() * 31;
        Integer r1 = this.width;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.height;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Double r8 = this.durationSeconds;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Long r11 = this.fileSize;
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
        return "CreationReferenceAlbumAttachment(type=" + this.type + ", width=" + this.width + ", height=" + this.height + ", durationSeconds=" + this.durationSeconds + ", fileSize=" + this.fileSize + ')';
    }

    public final Double getDurationSeconds() {
        return this.durationSeconds;
    }

    public final Long getFileSize() {
        return this.fileSize;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final CreationReferenceAlbumMediaType getType() {
        return this.type;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public CreationReferenceAlbumAttachment(CreationReferenceAlbumMediaType r2, Integer r3, Integer r4, Double r5, Long r6) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.type = r2;
        this.width = r3;
        this.height = r4;
        this.durationSeconds = r5;
        this.fileSize = r6;
    }
}

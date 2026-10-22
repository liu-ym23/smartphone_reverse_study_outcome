package com.larus.platform.model.preview;

import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BË\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010<\u001a\u0004\u0018\u00010\tJ\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020>J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u000fHÆ\u0003J\t\u0010L\u001a\u00020\u0014HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010N\u001a\u00020\u0018HÆ\u0003J\t\u0010O\u001a\u00020\u001aHÆ\u0003J\u0017\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001cHÆ\u0003JØ\u0001\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001cHÆ\u0001¢\u0006\u0002\u0010RJ\u0013\u0010S\u001a\u00020>2\b\u0010T\u001a\u0004\u0018\u00010UHÖ\u0003J\t\u0010V\u001a\u00020\u0018HÖ\u0001J\t\u0010W\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001f\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001c¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;¨\u0006X"}, d2 = {"Lcom/larus/platform/model/preview/AttachmentSnapshot;", "Ljava/io/Serializable;", "stableId", "", "source", "Lcom/larus/platform/model/preview/AttachmentSource;", "mediaType", "Lcom/larus/platform/model/preview/AttachmentMediaType;", "displayRef", "Lcom/larus/platform/model/preview/ResourceRef;", "thumbRef", "originRef", "fileName", "mimeType", "fileSize", "", "resourceId", "checksum", "durationMs", "uploadState", "Lcom/larus/platform/model/preview/AttachmentUploadState;", "editState", "Lcom/larus/platform/model/preview/AttachmentEditState;", "selectedOrder", "", "sendableState", "Lcom/larus/platform/model/preview/AttachmentSendableState;", "extra", "", "<init>", "(Ljava/lang/String;Lcom/larus/platform/model/preview/AttachmentSource;Lcom/larus/platform/model/preview/AttachmentMediaType;Lcom/larus/platform/model/preview/ResourceRef;Lcom/larus/platform/model/preview/ResourceRef;Lcom/larus/platform/model/preview/ResourceRef;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;JLcom/larus/platform/model/preview/AttachmentUploadState;Lcom/larus/platform/model/preview/AttachmentEditState;ILcom/larus/platform/model/preview/AttachmentSendableState;Ljava/util/Map;)V", "getStableId", "()Ljava/lang/String;", "getSource", "()Lcom/larus/platform/model/preview/AttachmentSource;", "getMediaType", "()Lcom/larus/platform/model/preview/AttachmentMediaType;", "getDisplayRef", "()Lcom/larus/platform/model/preview/ResourceRef;", "getThumbRef", "getOriginRef", "getFileName", "getMimeType", "getFileSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getResourceId", "getChecksum", "getDurationMs", "()J", "getUploadState", "()Lcom/larus/platform/model/preview/AttachmentUploadState;", "getEditState", "()Lcom/larus/platform/model/preview/AttachmentEditState;", "getSelectedOrder", "()I", "getSendableState", "()Lcom/larus/platform/model/preview/AttachmentSendableState;", "getExtra", "()Ljava/util/Map;", "effectiveRef", "isSendableNow", "", "canEnterSendPipeline", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Lcom/larus/platform/model/preview/AttachmentSource;Lcom/larus/platform/model/preview/AttachmentMediaType;Lcom/larus/platform/model/preview/ResourceRef;Lcom/larus/platform/model/preview/ResourceRef;Lcom/larus/platform/model/preview/ResourceRef;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;JLcom/larus/platform/model/preview/AttachmentUploadState;Lcom/larus/platform/model/preview/AttachmentEditState;ILcom/larus/platform/model/preview/AttachmentSendableState;Ljava/util/Map;)Lcom/larus/platform/model/preview/AttachmentSnapshot;", "equals", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AttachmentSnapshot implements Serializable {
    private final String checksum;
    private final ResourceRef displayRef;
    private final long durationMs;
    private final AttachmentEditState editState;
    private final Map<String, String> extra;
    private final String fileName;
    private final Long fileSize;
    private final AttachmentMediaType mediaType;
    private final String mimeType;
    private final ResourceRef originRef;
    private final String resourceId;
    private final int selectedOrder;
    private final AttachmentSendableState sendableState;
    private final AttachmentSource source;
    private final String stableId;
    private final ResourceRef thumbRef;
    private final AttachmentUploadState uploadState;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AttachmentSnapshot copy$default(AttachmentSnapshot r17, String r18, AttachmentSource r19, AttachmentMediaType r20, ResourceRef r21, ResourceRef r22, ResourceRef r23, String r24, String r25, Long r26, String r27, String r28, long r29, AttachmentUploadState r31, AttachmentEditState r32, int r33, AttachmentSendableState r34, Map r35, int r36, Object r37) {
        if ((r36 & 1) == 0) goto L5;
        String r2 = r17.stableId;
    L7:
        if ((r36 & 2) == 0) goto L9;
        AttachmentSource r3 = r17.source;
    L11:
        if ((r36 & 4) == 0) goto L13;
        AttachmentMediaType r4 = r17.mediaType;
    L15:
        if ((r36 & 8) == 0) goto L17;
        ResourceRef r5 = r17.displayRef;
    L19:
        if ((r36 & 16) == 0) goto L21;
        ResourceRef r6 = r17.thumbRef;
    L23:
        if ((r36 & 32) == 0) goto L25;
        ResourceRef r7 = r17.originRef;
    L27:
        if ((r36 & 64) == 0) goto L29;
        String r8 = r17.fileName;
    L31:
        if ((r36 & 128) == 0) goto L33;
        String r9 = r17.mimeType;
    L35:
        if ((r36 & 256) == 0) goto L37;
        Long r10 = r17.fileSize;
    L39:
        if ((r36 & 512) == 0) goto L41;
        String r11 = r17.resourceId;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        String r12 = r17.checksum;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        long r13 = r17.durationMs;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        AttachmentUploadState r15 = r17.uploadState;
    L54:
        AttachmentUploadState r38 = r15;
        if ((r36 & 8192) == 0) goto L57;
        AttachmentEditState r16 = r17.editState;
    L58:
        AttachmentEditState r39 = r16;
        if ((r36 & 16384) == 0) goto L61;
        int r110 = r17.selectedOrder;
    L62:
        int r310 = r110;
        if ((r36 & 32768) == 0) goto L65;
        AttachmentSendableState r111 = r17.sendableState;
    L67:
        if ((r36 & 65536) == 0) goto L69;
        Map r1 = r17.extra;
    L71:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r38, r39, r310, r111, r1);
    L69:
        r1 = r35;
        goto L71
    L65:
        r111 = r34;
        goto L67
    L61:
        r110 = r33;
        goto L62
    L57:
        r16 = r32;
        goto L58
    L53:
        r15 = r31;
        goto L54
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.stableId;
    }

    public final String component10() {
        return this.resourceId;
    }

    public final String component11() {
        return this.checksum;
    }

    public final long component12() {
        return this.durationMs;
    }

    public final AttachmentUploadState component13() {
        return this.uploadState;
    }

    public final AttachmentEditState component14() {
        return this.editState;
    }

    public final int component15() {
        return this.selectedOrder;
    }

    public final AttachmentSendableState component16() {
        return this.sendableState;
    }

    public final Map<String, String> component17() {
        return this.extra;
    }

    public final AttachmentSource component2() {
        return this.source;
    }

    public final AttachmentMediaType component3() {
        return this.mediaType;
    }

    public final ResourceRef component4() {
        return this.displayRef;
    }

    public final ResourceRef component5() {
        return this.thumbRef;
    }

    public final ResourceRef component6() {
        return this.originRef;
    }

    public final String component7() {
        return this.fileName;
    }

    public final String component8() {
        return this.mimeType;
    }

    public final Long component9() {
        return this.fileSize;
    }

    public final AttachmentSnapshot copy(String r22, AttachmentSource r23, AttachmentMediaType r24, ResourceRef r25, ResourceRef r26, ResourceRef r27, String r28, String r29, Long r30, String r31, String r32, long r33, AttachmentUploadState r35, AttachmentEditState r36, int r37, AttachmentSendableState r38, Map<String, String> r39) {
        Intrinsics.checkNotNullParameter(r22, "stableId");
        Intrinsics.checkNotNullParameter(r23, "source");
        Intrinsics.checkNotNullParameter(r24, "mediaType");
        Intrinsics.checkNotNullParameter(r35, "uploadState");
        Intrinsics.checkNotNullParameter(r38, "sendableState");
        Intrinsics.checkNotNullParameter(r39, "extra");
        return new AttachmentSnapshot(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r35, r36, r37, r38, r39);
    }

    public final ResourceRef effectiveRef() {
        ResourceRef[] r0 = new ResourceRef[3];
        AttachmentEditState r1 = this.editState;
        Object r2 = null;
        if (r1 == null) goto L5;
        ResourceRef r3 = r1.getEditedRef();
    L6:
        r0[0] = r3;
        r0[1] = this.originRef;
        r0[2] = this.displayRef;
        Iterator r4 = SequencesKt.filterNotNull(SequencesKt.sequenceOf(r0)).iterator();
    L8:
        if (r4.hasNext() == false) goto L24;
        Object r5 = r4.next();
        ResourceRef r6 = (ResourceRef) r5;
        if ((!StringsKt.isBlank(r6.getUri())) == true) goto L20;
        String r7 = r6.getRemoteKey();
        if (r7 != null) goto L14;
    L16:
        boolean r8 = false;
    L17:
        if (r8 == true) goto L20;
        boolean r9 = false;
    L21:
        if (r9 == false) goto L8;
        r2 = r5;
        goto L24
    L14:
        if ((!StringsKt.isBlank(r7)) != true) goto L16;
        r8 = true;
    L20:
        r9 = true;
    L24:
        return (ResourceRef) r2;
    L5:
        r3 = null;
        goto L6
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof AttachmentSnapshot) == true) goto L8;
        return false;
    L8:
        AttachmentSnapshot r9 = (AttachmentSnapshot) r8;
        if (Intrinsics.areEqual(this.stableId, r9.stableId) == true) goto L12;
        return false;
    L12:
        if (this.source == r9.source) goto L15;
        return false;
    L15:
        if (this.mediaType == r9.mediaType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.displayRef, r9.displayRef) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.thumbRef, r9.thumbRef) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.originRef, r9.originRef) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.fileName, r9.fileName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.mimeType, r9.mimeType) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.fileSize, r9.fileSize) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.resourceId, r9.resourceId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.checksum, r9.checksum) == true) goto L42;
        return false;
    L42:
        if (this.durationMs == r9.durationMs) goto L45;
        return false;
    L45:
        if (this.uploadState == r9.uploadState) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.editState, r9.editState) == true) goto L51;
        return false;
    L51:
        if (this.selectedOrder == r9.selectedOrder) goto L54;
        return false;
    L54:
        if (this.sendableState == r9.sendableState) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.extra, r9.extra) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.stableId.hashCode() * 31) + this.source.hashCode()) * 31) + this.mediaType.hashCode()) * 31;
        ResourceRef r1 = this.displayRef;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        ResourceRef r5 = this.thumbRef;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        ResourceRef r8 = this.originRef;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.fileName;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.mimeType;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Long r17 = this.fileSize;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.resourceId;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.checksum;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        long r25 = this.durationMs;
        int r26 = (((((r22 + r24) * 31) + ((int) (r25 ^ (r25 >>> 32)))) * 31) + this.uploadState.hashCode()) * 31;
        AttachmentEditState r27 = this.editState;
        if (r27 == null) goto L39;
        r2 = r27.hashCode();
    L39:
        return ((((((r26 + r2) * 31) + this.selectedOrder) * 31) + this.sendableState.hashCode()) * 31) + this.extra.hashCode();
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
        return "AttachmentSnapshot(stableId=" + this.stableId + ", source=" + this.source + ", mediaType=" + this.mediaType + ", displayRef=" + this.displayRef + ", thumbRef=" + this.thumbRef + ", originRef=" + this.originRef + ", fileName=" + this.fileName + ", mimeType=" + this.mimeType + ", fileSize=" + this.fileSize + ", resourceId=" + this.resourceId + ", checksum=" + this.checksum + ", durationMs=" + this.durationMs + ", uploadState=" + this.uploadState + ", editState=" + this.editState + ", selectedOrder=" + this.selectedOrder + ", sendableState=" + this.sendableState + ", extra=" + this.extra + ')';
    }

    public final boolean isSendableNow() {
        if (this.sendableState != AttachmentSendableState.SENDABLE) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean canEnterSendPipeline() {
        ResourceRef r0 = effectiveRef();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (this.sendableState != AttachmentSendableState.NOT_SENDABLE) goto L8;
        return false;
    L8:
        if (this.uploadState != AttachmentUploadState.UPLOADING) goto L10;
        return false;
    L10:
        if (r0.getKind() == ResourceRefKind.UPLOADING) goto L15;
        return true;
    L15:
        return false;
    }

    public final String getChecksum() {
        return this.checksum;
    }

    public final ResourceRef getDisplayRef() {
        return this.displayRef;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final AttachmentEditState getEditState() {
        return this.editState;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Long getFileSize() {
        return this.fileSize;
    }

    public final AttachmentMediaType getMediaType() {
        return this.mediaType;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final ResourceRef getOriginRef() {
        return this.originRef;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final int getSelectedOrder() {
        return this.selectedOrder;
    }

    public final AttachmentSendableState getSendableState() {
        return this.sendableState;
    }

    public final AttachmentSource getSource() {
        return this.source;
    }

    public final String getStableId() {
        return this.stableId;
    }

    public final ResourceRef getThumbRef() {
        return this.thumbRef;
    }

    public final AttachmentUploadState getUploadState() {
        return this.uploadState;
    }

    public AttachmentSnapshot(String r9, AttachmentSource r10, AttachmentMediaType r11, ResourceRef r12, ResourceRef r13, ResourceRef r14, String r15, String r16, Long r17, String r18, String r19, long r20, AttachmentUploadState r22, AttachmentEditState r23, int r24, AttachmentSendableState r25, Map<String, String> r26) {
        Intrinsics.checkNotNullParameter(r9, "stableId");
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "mediaType");
        Intrinsics.checkNotNullParameter(r22, "uploadState");
        Intrinsics.checkNotNullParameter(r25, "sendableState");
        Intrinsics.checkNotNullParameter(r26, "extra");
        this.stableId = r9;
        this.source = r10;
        this.mediaType = r11;
        this.displayRef = r12;
        this.thumbRef = r13;
        this.originRef = r14;
        this.fileName = r15;
        this.mimeType = r16;
        this.fileSize = r17;
        this.resourceId = r18;
        this.checksum = r19;
        this.durationMs = r20;
        this.uploadState = r22;
        this.editState = r23;
        this.selectedOrder = r24;
        this.sendableState = r25;
        this.extra = r26;
    }

    public /* synthetic */ AttachmentSnapshot(String r23, AttachmentSource r24, AttachmentMediaType r25, ResourceRef r26, ResourceRef r27, ResourceRef r28, String r29, String r30, Long r31, String r32, String r33, long r34, AttachmentUploadState r36, AttachmentEditState r37, int r38, AttachmentSendableState r39, Map r40, int r41, DefaultConstructorMarker r42) {
        if ((r41 & 8) == 0) goto L5;
        ResourceRef r7 = null;
    L7:
        if ((r41 & 16) == 0) goto L9;
        ResourceRef r8 = null;
    L11:
        if ((r41 & 32) == 0) goto L13;
        ResourceRef r9 = null;
    L15:
        if ((r41 & 64) == 0) goto L17;
        String r10 = null;
    L19:
        if ((r41 & 128) == 0) goto L21;
        String r11 = null;
    L23:
        if ((r41 & 256) == 0) goto L25;
        Long r12 = null;
    L27:
        if ((r41 & 512) == 0) goto L29;
        String r13 = null;
    L31:
        if ((r41 & 1024) == 0) goto L33;
        String r14 = null;
    L35:
        if ((r41 & 2048) == 0) goto L37;
        long r15 = 0;
    L39:
        if ((r41 & 4096) == 0) goto L41;
        AttachmentUploadState r17 = AttachmentUploadState.NOT_UPLOADED;
    L43:
        if ((r41 & 8192) == 0) goto L45;
        AttachmentEditState r18 = null;
    L47:
        if ((r41 & 16384) == 0) goto L49;
        int r19 = 0;
    L51:
        if ((32768 & r41) == 0) goto L53;
        AttachmentSendableState r20 = AttachmentSendableState.NEEDS_MATERIALIZE;
    L55:
        if ((r41 & 65536) == 0) goto L57;
        Map r21 = MapsKt.emptyMap();
    L58:
        this(r23, r24, r25, r7, r8, r9, r10, r11, r12, r13, r14, r15, r17, r18, r19, r20, r21);
        return;
    L57:
        r21 = r40;
        goto L58
    L53:
        r20 = r39;
        goto L55
    L49:
        r19 = r38;
        goto L51
    L45:
        r18 = r37;
        goto L47
    L41:
        r17 = r36;
        goto L43
    L37:
        r15 = r34;
        goto L39
    L33:
        r14 = r33;
        goto L35
    L29:
        r13 = r32;
        goto L31
    L25:
        r12 = r31;
        goto L27
    L21:
        r11 = r30;
        goto L23
    L17:
        r10 = r29;
        goto L19
    L13:
        r9 = r28;
        goto L15
    L9:
        r8 = r27;
        goto L11
    L5:
        r7 = r26;
        goto L7
    }
}

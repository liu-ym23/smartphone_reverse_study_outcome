package com.larus.platform.model.album;

import com.larus.platform.model.preview.AttachmentSnapshot;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003JI\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u000f¨\u0006\""}, d2 = {"Lcom/larus/platform/model/album/AlbumInputState;", "Ljava/io/Serializable;", "text", "", "attachments", "", "Lcom/larus/platform/model/preview/AttachmentSnapshot;", "sourceNodeId", "inputSnapshotId", "attachmentUris", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getText", "()Ljava/lang/String;", "getAttachments", "()Ljava/util/List;", "getSourceNodeId", "getInputSnapshotId", "getAttachmentUris$annotations", "()V", "getAttachmentUris", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AlbumInputState implements Serializable {
    private final List<String> attachmentUris;
    private final List<AttachmentSnapshot> attachments;
    private final String inputSnapshotId;
    private final String sourceNodeId;
    private final String text;

    public AlbumInputState() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlbumInputState copy$default(AlbumInputState r3, String r4, List r5, String r6, String r7, List r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.text;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.attachments;
    L8:
        List r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.sourceNodeId;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.inputSnapshotId;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.attachmentUris;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    @Deprecated(message = "Use attachments and inputSnapshotId")
    public static /* synthetic */ void getAttachmentUris$annotations() {
    }

    public final String component1() {
        return this.text;
    }

    public final List<AttachmentSnapshot> component2() {
        return this.attachments;
    }

    public final String component3() {
        return this.sourceNodeId;
    }

    public final String component4() {
        return this.inputSnapshotId;
    }

    public final List<String> component5() {
        return this.attachmentUris;
    }

    public final AlbumInputState copy(String r8, List<AttachmentSnapshot> r9, String r10, String r11, List<String> r12) {
        Intrinsics.checkNotNullParameter(r8, "text");
        Intrinsics.checkNotNullParameter(r9, "attachments");
        Intrinsics.checkNotNullParameter(r10, "sourceNodeId");
        Intrinsics.checkNotNullParameter(r12, "attachmentUris");
        return new AlbumInputState(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AlbumInputState) == true) goto L8;
        return false;
    L8:
        AlbumInputState r6 = (AlbumInputState) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.attachments, r6.attachments) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceNodeId, r6.sourceNodeId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.inputSnapshotId, r6.inputSnapshotId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.attachmentUris, r6.attachmentUris) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.text.hashCode() * 31) + this.attachments.hashCode()) * 31) + this.sourceNodeId.hashCode()) * 31;
        String r1 = this.inputSnapshotId;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.attachmentUris.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "AlbumInputState(text=" + this.text + ", attachments=" + this.attachments + ", sourceNodeId=" + this.sourceNodeId + ", inputSnapshotId=" + this.inputSnapshotId + ", attachmentUris=" + this.attachmentUris + ')';
    }

    public final List<String> getAttachmentUris() {
        return this.attachmentUris;
    }

    public final List<AttachmentSnapshot> getAttachments() {
        return this.attachments;
    }

    public final String getInputSnapshotId() {
        return this.inputSnapshotId;
    }

    public final String getSourceNodeId() {
        return this.sourceNodeId;
    }

    public final String getText() {
        return this.text;
    }

    public AlbumInputState(String r2, List<AttachmentSnapshot> r3, String r4, String r5, List<String> r6) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "attachments");
        Intrinsics.checkNotNullParameter(r4, "sourceNodeId");
        Intrinsics.checkNotNullParameter(r6, "attachmentUris");
        this.text = r2;
        this.attachments = r3;
        this.sourceNodeId = r4;
        this.inputSnapshotId = r5;
        this.attachmentUris = r6;
    }

    public /* synthetic */ AlbumInputState(String r4, List r5, String r6, String r7, List r8, int r9, DefaultConstructorMarker r10) {
        String r0 = "";
        if ((r9 & 1) == 0) goto L5;
        String r11 = "";
    L7:
        if ((r9 & 2) == 0) goto L9;
        r5 = CollectionsKt.emptyList();
    L9:
        List r1 = r5;
        if ((r9 & 4) != 0) goto L14;
        r0 = r6;
    L14:
        if ((r9 & 8) == 0) goto L16;
        r7 = null;
    L16:
        String r2 = r7;
        if ((r9 & 16) == 0) goto L19;
        r8 = CollectionsKt.emptyList();
    L19:
        String r12 = r11;
        String r13 = r0;
        this(r12, r1, r13, r2, r8);
        return;
    L5:
        r11 = r4;
        goto L7
    }
}

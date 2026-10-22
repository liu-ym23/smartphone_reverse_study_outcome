package com.larus.platform.model.preview;

import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/larus/platform/model/preview/InputDraftSnapshot;", "Ljava/io/Serializable;", "text", "", "attachments", "", "Lcom/larus/platform/model/preview/AttachmentSnapshot;", "sourceNodeId", "createdAt", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;J)V", "getText", "()Ljava/lang/String;", "getAttachments", "()Ljava/util/List;", "getSourceNodeId", "getCreatedAt", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class InputDraftSnapshot implements Serializable {
    private final List<AttachmentSnapshot> attachments;
    private final long createdAt;
    private final String sourceNodeId;
    private final String text;

    public InputDraftSnapshot() {
        this(null, null, null, 0, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InputDraftSnapshot copy$default(InputDraftSnapshot r3, String r4, List r5, String r6, long r7, int r9, Object r10) {
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
        r7 = r3.createdAt;
    L14:
        String r8 = r4;
        return r3.copy(r8, r11, r0, r7);
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

    public final long component4() {
        return this.createdAt;
    }

    public final InputDraftSnapshot copy(String r8, List<AttachmentSnapshot> r9, String r10, long r11) {
        Intrinsics.checkNotNullParameter(r8, "text");
        Intrinsics.checkNotNullParameter(r9, "attachments");
        Intrinsics.checkNotNullParameter(r10, "sourceNodeId");
        return new InputDraftSnapshot(r8, r9, r10, r11);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof InputDraftSnapshot) == true) goto L8;
        return false;
    L8:
        InputDraftSnapshot r9 = (InputDraftSnapshot) r8;
        if (Intrinsics.areEqual(this.text, r9.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.attachments, r9.attachments) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceNodeId, r9.sourceNodeId) == true) goto L18;
        return false;
    L18:
        if (this.createdAt == r9.createdAt) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.text.hashCode() * 31) + this.attachments.hashCode()) * 31) + this.sourceNodeId.hashCode()) * 31;
        long r1 = this.createdAt;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public String toString() {
        return "InputDraftSnapshot(text=" + this.text + ", attachments=" + this.attachments + ", sourceNodeId=" + this.sourceNodeId + ", createdAt=" + this.createdAt + ')';
    }

    public final List<AttachmentSnapshot> getAttachments() {
        return this.attachments;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getSourceNodeId() {
        return this.sourceNodeId;
    }

    public final String getText() {
        return this.text;
    }

    public InputDraftSnapshot(String r2, List<AttachmentSnapshot> r3, String r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "attachments");
        Intrinsics.checkNotNullParameter(r4, "sourceNodeId");
        this.text = r2;
        this.attachments = r3;
        this.sourceNodeId = r4;
        this.createdAt = r5;
    }

    public /* synthetic */ InputDraftSnapshot(String r3, List r4, String r5, long r6, int r8, DefaultConstructorMarker r9) {
        String r0 = "";
        if ((r8 & 1) == 0) goto L5;
        String r10 = "";
    L7:
        if ((r8 & 2) == 0) goto L9;
        r4 = CollectionsKt.emptyList();
    L9:
        List r1 = r4;
        if ((r8 & 4) != 0) goto L14;
        r0 = r5;
    L14:
        if ((r8 & 8) == 0) goto L16;
        r6 = System.currentTimeMillis();
    L16:
        long r7 = r6;
        this(r10, r1, r0, r7);
        return;
    L5:
        r10 = r3;
        goto L7
    }
}

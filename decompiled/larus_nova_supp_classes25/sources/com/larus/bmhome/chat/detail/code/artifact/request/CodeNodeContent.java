package com.larus.bmhome.chat.detail.code.artifact.request;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0019Jn\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\tHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u000b\u0010\u0019¨\u0006*"}, d2 = {"Lcom/larus/bmhome/chat/detail/code/artifact/request/CodeNodeContent;", "Ljava/io/Serializable;", "nodeId", "", "path", "language", "description", "content", "reviewStatus", "", "nodeType", "isEntry", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)V", "getNodeId", "()Ljava/lang/String;", "getPath", "getLanguage", "getDescription", "getContent", "getReviewStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNodeType", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/detail/code/artifact/request/CodeNodeContent;", "equals", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CodeNodeContent implements Serializable {

    @SerializedName("content")
    private final String content;

    @SerializedName("description")
    private final String description;

    @SerializedName("is_entry")
    private final Boolean isEntry;

    @SerializedName("language")
    private final String language;

    @SerializedName("node_id")
    private final String nodeId;

    @SerializedName("node_type")
    private final String nodeType;

    @SerializedName("path")
    private final String path;

    @SerializedName("review_status")
    private final Integer reviewStatus;

    public CodeNodeContent() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ CodeNodeContent copy$default(CodeNodeContent r9, String r10, String r11, String r12, String r13, String r14, Integer r15, String r16, Boolean r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.nodeId;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.path;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.language;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.description;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.content;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Integer r7 = r9.reviewStatus;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.nodeType;
    L31:
        if ((r18 & 128) == 0) goto L33;
        Boolean r1 = r9.isEntry;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.nodeId;
    }

    public final String component2() {
        return this.path;
    }

    public final String component3() {
        return this.language;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.content;
    }

    public final Integer component6() {
        return this.reviewStatus;
    }

    public final String component7() {
        return this.nodeType;
    }

    public final Boolean component8() {
        return this.isEntry;
    }

    public final CodeNodeContent copy(String r11, String r12, String r13, String r14, String r15, Integer r16, String r17, Boolean r18) {
        return new CodeNodeContent(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CodeNodeContent) == true) goto L8;
        return false;
    L8:
        CodeNodeContent r6 = (CodeNodeContent) r5;
        if (Intrinsics.areEqual(this.nodeId, r6.nodeId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.path, r6.path) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.language, r6.language) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.reviewStatus, r6.reviewStatus) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.nodeType, r6.nodeType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isEntry, r6.isEntry) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r0 = this.nodeId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.path;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.language;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.description;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.content;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.reviewStatus;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.nodeType;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.isEntry;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
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
        return "CodeNodeContent(nodeId=" + this.nodeId + ", path=" + this.path + ", language=" + this.language + ", description=" + this.description + ", content=" + this.content + ", reviewStatus=" + this.reviewStatus + ", nodeType=" + this.nodeType + ", isEntry=" + this.isEntry + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getNodeId() {
        return this.nodeId;
    }

    public final String getNodeType() {
        return this.nodeType;
    }

    public final String getPath() {
        return this.path;
    }

    public final Integer getReviewStatus() {
        return this.reviewStatus;
    }

    public final Boolean isEntry() {
        return this.isEntry;
    }

    public CodeNodeContent(String r1, String r2, String r3, String r4, String r5, Integer r6, String r7, Boolean r8) {
        this.nodeId = r1;
        this.path = r2;
        this.language = r3;
        this.description = r4;
        this.content = r5;
        this.reviewStatus = r6;
        this.nodeType = r7;
        this.isEntry = r8;
    }

    public /* synthetic */ CodeNodeContent(String r10, String r11, String r12, String r13, String r14, Integer r15, String r16, Boolean r17, int r18, DefaultConstructorMarker r19) {
        Boolean r2 = null;
        if ((r18 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}

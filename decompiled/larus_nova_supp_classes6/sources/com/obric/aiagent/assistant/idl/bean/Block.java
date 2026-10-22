package com.obric.aiagent.assistant.idl.bean;

import com.google.gson.annotations.SerializedName;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001)Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fHÆ\u0003Je\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fHÆ\u0001J\u0013\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0018R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001a¨\u0006*"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/Block;", "Ljava/io/Serializable;", "blockType", "", "blockId", "", "parentId", "content", "Lcom/obric/aiagent/assistant/idl/bean/BlockContent;", "isFinish", "", "appendFields", "", "metaInfo", "Lcom/obric/aiagent/assistant/idl/bean/BlockMetaInfo;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/obric/aiagent/assistant/idl/bean/BlockContent;ZLjava/util/List;Ljava/util/List;)V", "getBlockType", "()I", "getBlockId", "()Ljava/lang/String;", "getParentId", "getContent", "()Lcom/obric/aiagent/assistant/idl/bean/BlockContent;", "()Z", "getAppendFields", "()Ljava/util/List;", "getMetaInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class Block implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("append_fields")
    private final List<Integer> appendFields;

    @SerializedName("block_id")
    private final String blockId;

    @SerializedName("block_type")
    private final int blockType;

    @SerializedName("content")
    private final BlockContent content;

    @SerializedName("is_finish")
    private final boolean isFinish;

    @SerializedName("meta_info")
    private final List<BlockMetaInfo> metaInfo;

    @SerializedName("parent_id")
    private final String parentId;

    static {
        Companion = new a();
    }

    public Block() {
        this(0, null, null, null, false, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Block copy$default(Block r5, int r6, String r7, String r8, BlockContent r9, boolean r10, List r11, List r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.blockType;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.blockId;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.parentId;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.content;
    L14:
        BlockContent r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.isFinish;
    L17:
        boolean r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.appendFields;
    L20:
        List r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.metaInfo;
    L23:
        int r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final int component1() {
        return this.blockType;
    }

    public final String component2() {
        return this.blockId;
    }

    public final String component3() {
        return this.parentId;
    }

    public final BlockContent component4() {
        return this.content;
    }

    public final boolean component5() {
        return this.isFinish;
    }

    public final List<Integer> component6() {
        return this.appendFields;
    }

    public final List<BlockMetaInfo> component7() {
        return this.metaInfo;
    }

    public final Block copy(int r10, String r11, String r12, BlockContent r13, boolean r14, List<Integer> r15, List<BlockMetaInfo> r16) {
        return new Block(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Block) == true) goto L8;
        return false;
    L8:
        Block r6 = (Block) r5;
        if (this.blockType == r6.blockType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.blockId, r6.blockId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.parentId, r6.parentId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L21;
        return false;
    L21:
        if (this.isFinish == r6.isFinish) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.appendFields, r6.appendFields) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.metaInfo, r6.metaInfo) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = this.blockType * 31;
        String r1 = this.blockId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.parentId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        BlockContent r8 = this.content;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        if (this.isFinish == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (r10 + r11) * 31;
        List<Integer> r13 = this.appendFields;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        List<BlockMetaInfo> r16 = this.metaInfo;
        if (r16 == null) goto L27;
        r2 = r16.hashCode();
    L27:
        return r15 + r2;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = 1237;
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
        return "Block(blockType=" + this.blockType + ", blockId=" + this.blockId + ", parentId=" + this.parentId + ", content=" + this.content + ", isFinish=" + this.isFinish + ", appendFields=" + this.appendFields + ", metaInfo=" + this.metaInfo + ')';
    }

    public final List<Integer> getAppendFields() {
        return this.appendFields;
    }

    public final String getBlockId() {
        return this.blockId;
    }

    public final int getBlockType() {
        return this.blockType;
    }

    public final BlockContent getContent() {
        return this.content;
    }

    public final List<BlockMetaInfo> getMetaInfo() {
        return this.metaInfo;
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final boolean isFinish() {
        return this.isFinish;
    }

    public Block(int r1, String r2, String r3, BlockContent r4, boolean r5, List<Integer> r6, List<BlockMetaInfo> r7) {
        this.blockType = r1;
        this.blockId = r2;
        this.parentId = r3;
        this.content = r4;
        this.isFinish = r5;
        this.appendFields = r6;
        this.metaInfo = r7;
    }

    public /* synthetic */ Block(int r7, String r8, String r9, BlockContent r10, boolean r11, List r12, List r13, int r14, DefaultConstructorMarker r15) {
        boolean r0 = false;
        if ((r14 & 1) == 0) goto L5;
        int r16 = 0;
    L7:
        if ((r14 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        String r3 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        BlockContent r4 = null;
    L19:
        if ((r14 & 16) != 0) goto L23;
        r0 = r11;
    L23:
        if ((r14 & 32) == 0) goto L25;
        List r5 = null;
    L27:
        if ((r14 & 64) == 0) goto L29;
        List r17 = null;
    L30:
        this(r16, r2, r3, r4, r0, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L17:
        r4 = r10;
        goto L19
    L13:
        r3 = r9;
        goto L15
    L9:
        r2 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}

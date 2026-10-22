package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0012\u001a\u00020\tHÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003JH\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/canvas/service/bean/CanvasBlock;", "Ljava/io/Serializable;", "blockType", "", "blockId", "", "content", "Lcom/larus/canvas/service/bean/CanvasImageBlock;", "isFinish", "", "logId", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/canvas/service/bean/CanvasImageBlock;ZLjava/lang/String;)V", "Ljava/lang/Integer;", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/canvas/service/bean/CanvasImageBlock;ZLjava/lang/String;)Lcom/larus/canvas/service/bean/CanvasBlock;", "equals", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasBlock implements Serializable {

    @SerializedName("block_id")
    public final String blockId;

    @SerializedName("block_type")
    public final Integer blockType;

    @SerializedName("content")
    public final CanvasImageBlock content;

    @SerializedName("is_finish")
    public final boolean isFinish;
    public final transient String logId;

    public CanvasBlock() {
        this(null, null, null, false, null, 31, null);
    }

    public static /* synthetic */ CanvasBlock copy$default(CanvasBlock r3, Integer r4, String r5, CanvasImageBlock r6, boolean r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.blockType;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.blockId;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.content;
    L11:
        CanvasImageBlock r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.isFinish;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.logId;
    L17:
        Integer r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final Integer component1() {
        return this.blockType;
    }

    public final String component2() {
        return this.blockId;
    }

    public final CanvasImageBlock component3() {
        return this.content;
    }

    public final boolean component4() {
        return this.isFinish;
    }

    public final String component5() {
        return this.logId;
    }

    public final CanvasBlock copy(Integer r8, String r9, CanvasImageBlock r10, boolean r11, String r12) {
        return new CanvasBlock(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CanvasBlock) == true) goto L8;
        return false;
    L8:
        CanvasBlock r6 = (CanvasBlock) r5;
        if (Intrinsics.areEqual(this.blockType, r6.blockType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.blockId, r6.blockId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L18;
        return false;
    L18:
        if (this.isFinish == r6.isFinish) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.logId, r6.logId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.blockType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.blockId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        CanvasImageBlock r7 = this.content;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.isFinish == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        String r12 = this.logId;
        if (r12 == null) goto L23;
        r1 = r12.hashCode();
    L23:
        return r11 + r1;
    L17:
        r10 = 1237;
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
        return "CanvasBlock(blockType=" + this.blockType + ", blockId=" + this.blockId + ", content=" + this.content + ", isFinish=" + this.isFinish + ", logId=" + this.logId + ')';
    }

    public CanvasBlock(Integer r1, String r2, CanvasImageBlock r3, boolean r4, String r5) {
        this.blockType = r1;
        this.blockId = r2;
        this.content = r3;
        this.isFinish = r4;
        this.logId = r5;
    }

    public /* synthetic */ CanvasBlock(Integer r5, String r6, CanvasImageBlock r7, boolean r8, String r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        Integer r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        CanvasImageBlock r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        boolean r3 = false;
    L19:
        if ((r10 & 16) == 0) goto L21;
        String r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}

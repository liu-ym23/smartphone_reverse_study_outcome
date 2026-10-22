package com.larus.dora.impl.network;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0011\u001a\u00020\tHÆ\u0003J\t\u0010\u0012\u001a\u00020\tHÆ\u0003JG\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/dora/impl/network/DoraMessage;", "Ljava/io/Serializable;", "bizScene", "", "cmdId", "cmd", "cmdContent", "", "cmdIndex", "", "createTime", "<init>", "(IIILjava/lang/String;JJ)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraMessage implements Serializable {

    @SerializedName("biz_scene")
    public int bizScene;

    @SerializedName("cmd")
    public int cmd;

    @SerializedName("cmd_content")
    public String cmdContent;

    @SerializedName("cmd_id")
    public int cmdId;

    @SerializedName("cmd_index")
    public long cmdIndex;

    @SerializedName("create_time")
    public long createTime;

    public DoraMessage() {
        this(0, 0, 0, null, 0, 0, 63, null);
    }

    public static /* synthetic */ DoraMessage copy$default(DoraMessage r9, int r10, int r11, int r12, String r13, long r14, long r16, int r18, Object r110) {
        if ((r18 & 1) == 0) goto L5;
        int r1 = r9.bizScene;
    L7:
        if ((r18 & 2) == 0) goto L9;
        int r2 = r9.cmdId;
    L11:
        if ((r18 & 4) == 0) goto L13;
        int r3 = r9.cmd;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r4 = r9.cmdContent;
    L19:
        if ((r18 & 16) == 0) goto L21;
        long r5 = r9.cmdIndex;
    L23:
        if ((r18 & 32) == 0) goto L25;
        long r7 = r9.createTime;
    L27:
        return r9.copy(r1, r2, r3, r4, r5, r7);
    L25:
        r7 = r16;
        goto L27
    L21:
        r5 = r14;
        goto L23
    L17:
        r4 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final int component1() {
        return this.bizScene;
    }

    public final int component2() {
        return this.cmdId;
    }

    public final int component3() {
        return this.cmd;
    }

    public final String component4() {
        return this.cmdContent;
    }

    public final long component5() {
        return this.cmdIndex;
    }

    public final long component6() {
        return this.createTime;
    }

    public final DoraMessage copy(int r11, int r12, int r13, String r14, long r15, long r17) {
        return new DoraMessage(r11, r12, r13, r14, r15, r17);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DoraMessage) == true) goto L8;
        return false;
    L8:
        DoraMessage r9 = (DoraMessage) r8;
        if (this.bizScene == r9.bizScene) goto L12;
        return false;
    L12:
        if (this.cmdId == r9.cmdId) goto L15;
        return false;
    L15:
        if (this.cmd == r9.cmd) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cmdContent, r9.cmdContent) == true) goto L21;
        return false;
    L21:
        if (this.cmdIndex == r9.cmdIndex) goto L24;
        return false;
    L24:
        if (this.createTime == r9.createTime) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.bizScene * 31) + this.cmdId) * 31) + this.cmd) * 31;
        String r1 = this.cmdContent;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        long r4 = this.cmdIndex;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.createTime;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "DoraMessage(bizScene=" + this.bizScene + ", cmdId=" + this.cmdId + ", cmd=" + this.cmd + ", cmdContent=" + this.cmdContent + ", cmdIndex=" + this.cmdIndex + ", createTime=" + this.createTime + ')';
    }

    public DoraMessage(int r1, int r2, int r3, String r4, long r5, long r7) {
        this.bizScene = r1;
        this.cmdId = r2;
        this.cmd = r3;
        this.cmdContent = r4;
        this.cmdIndex = r5;
        this.createTime = r7;
    }

    public /* synthetic */ DoraMessage(int r6, int r7, int r8, String r9, long r10, long r12, int r14, DefaultConstructorMarker r15) {
        int r0 = 0;
        if ((r14 & 1) == 0) goto L5;
        int r16 = 0;
    L7:
        if ((r14 & 2) == 0) goto L9;
        int r1 = 0;
    L11:
        if ((r14 & 4) != 0) goto L15;
        r0 = r8;
    L15:
        if ((r14 & 8) == 0) goto L17;
        r9 = null;
    L17:
        String r2 = r9;
        if ((r14 & 16) == 0) goto L20;
        long r3 = -1;
    L22:
        if ((r14 & 32) == 0) goto L24;
        long r13 = -1;
    L25:
        this(r16, r1, r0, r2, r3, r13);
        return;
    L24:
        r13 = r12;
        goto L25
    L20:
        r3 = r10;
        goto L22
    L9:
        r1 = r7;
        goto L11
    L5:
        r16 = r6;
        goto L7
    }
}

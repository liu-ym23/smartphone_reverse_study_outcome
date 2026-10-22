package com.larus.bmhome.chat.resp;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.IMCmd;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000e\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0007HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R&\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/resp/CmdList;", "", "cmdList", "", "Lcom/larus/im/bean/IMCmd;", "Lcom/larus/bmhome/chat/resp/PushCmd;", "hasMore", "", "<init>", "(Ljava/util/List;Z)V", "getCmdList", "()Ljava/util/List;", "getHasMore", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CmdList {

    @SerializedName("cmd_list")
    private final List<IMCmd> cmdList;

    @SerializedName("has_more")
    private final boolean hasMore;

    public CmdList() {
        List r2 = null;
        this(r2, false, 3, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CmdList copy$default(CmdList r0, List r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.cmdList;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.hasMore;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<IMCmd> component1() {
        return this.cmdList;
    }

    public final boolean component2() {
        return this.hasMore;
    }

    public final CmdList copy(List<IMCmd> r2, boolean r3) {
        return new CmdList(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CmdList) == true) goto L8;
        return false;
    L8:
        CmdList r6 = (CmdList) r5;
        if (Intrinsics.areEqual(this.cmdList, r6.cmdList) == true) goto L12;
        return false;
    L12:
        if (this.hasMore == r6.hasMore) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<IMCmd> r0 = this.cmdList;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = r1 * 31;
        if (this.hasMore == false) goto L9;
        int r3 = 1231;
    L11:
        return r2 + r3;
    L9:
        r3 = 1237;
        goto L11
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CmdList(cmdList=" + this.cmdList + ", hasMore=" + this.hasMore + ')';
    }

    public final List<IMCmd> getCmdList() {
        return this.cmdList;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public CmdList(List<IMCmd> r1, boolean r2) {
        this.cmdList = r1;
        this.hasMore = r2;
    }

    public /* synthetic */ CmdList(List r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = false;
    L8:
        this(r1, r2);
    }
}

package com.larus.bmhome.chat.cotdetail.component;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/component/CotDetailListComponentState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "isStreaming", "", "isFromChunk", "threadMessageList", "", "Lcom/larus/im/bean/message/Message;", "<init>", "(ZZLjava/util/List;)V", "()Z", "getThreadMessageList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CotDetailListComponentState implements w1a.b {
    private final boolean isFromChunk;
    private final boolean isStreaming;
    private final List<Message> threadMessageList;

    public CotDetailListComponentState() {
        this(false, false, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CotDetailListComponentState copy$default(CotDetailListComponentState r0, boolean r1, boolean r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.isStreaming;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.isFromChunk;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.threadMessageList;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.isStreaming;
    }

    public final boolean component2() {
        return this.isFromChunk;
    }

    public final List<Message> component3() {
        return this.threadMessageList;
    }

    public final CotDetailListComponentState copy(boolean r2, boolean r3, List<Message> r4) {
        Intrinsics.checkNotNullParameter(r4, "threadMessageList");
        return new CotDetailListComponentState(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CotDetailListComponentState) == true) goto L8;
        return false;
    L8:
        CotDetailListComponentState r6 = (CotDetailListComponentState) r5;
        if (this.isStreaming == r6.isStreaming) goto L12;
        return false;
    L12:
        if (this.isFromChunk == r6.isFromChunk) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.threadMessageList, r6.threadMessageList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.isStreaming == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.isFromChunk == true) goto L11;
        r1 = 1237;
    L11:
        return ((r2 + r1) * 31) + this.threadMessageList.hashCode();
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "CotDetailListComponentState(isStreaming=" + this.isStreaming + ", isFromChunk=" + this.isFromChunk + ", threadMessageList=" + this.threadMessageList + ')';
    }

    public final List<Message> getThreadMessageList() {
        return this.threadMessageList;
    }

    public final boolean isFromChunk() {
        return this.isFromChunk;
    }

    public final boolean isStreaming() {
        return this.isStreaming;
    }

    public CotDetailListComponentState(boolean r2, boolean r3, List<Message> r4) {
        Intrinsics.checkNotNullParameter(r4, "threadMessageList");
        this.isStreaming = r2;
        this.isFromChunk = r3;
        this.threadMessageList = r4;
    }

    public /* synthetic */ CotDetailListComponentState(boolean r2, boolean r3, List r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = CollectionsKt.emptyList();
    L11:
        this(r2, r3, r4);
    }
}

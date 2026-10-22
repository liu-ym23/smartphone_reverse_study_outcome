package com.larus.avlink.record.page;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010)\u001a\u00020\u0012HÆ\u0003Ji\u0010*\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00063"}, d2 = {"Lcom/larus/avlink/record/page/RecordMinutesState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "historyList", "Lkotlin/Pair;", "Lcom/larus/avlink/record/page/Action;", "", "Lcom/larus/avlink/record/page/RecordMinutesItemData;", "deleteResult", "Lcom/larus/avlink/record/page/DeleteResult;", "uploadResult", "Lcom/larus/avlink/record/page/UploadResult;", "refreshResultTime", "", "pageState", "Lcom/larus/avlink/record/page/PageStatus;", "bottomState", "Lcom/larus/avlink/record/page/BottomStatus;", "syncState", "Lcom/larus/dora/api/offline/record/DoraOfflineRecordTransferProgress;", "<init>", "(Lkotlin/Pair;Lcom/larus/avlink/record/page/DeleteResult;Lcom/larus/avlink/record/page/UploadResult;JLcom/larus/avlink/record/page/PageStatus;Lcom/larus/avlink/record/page/BottomStatus;Lcom/larus/dora/api/offline/record/DoraOfflineRecordTransferProgress;)V", "getHistoryList", "()Lkotlin/Pair;", "getDeleteResult", "()Lcom/larus/avlink/record/page/DeleteResult;", "getUploadResult", "()Lcom/larus/avlink/record/page/UploadResult;", "getRefreshResultTime", "()J", "getPageState", "()Lcom/larus/avlink/record/page/PageStatus;", "getBottomState", "()Lcom/larus/avlink/record/page/BottomStatus;", "getSyncState", "()Lcom/larus/dora/api/offline/record/DoraOfflineRecordTransferProgress;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class RecordMinutesState implements w1a.b {
    public static final int $stable = 8;
    private final BottomStatus bottomState;
    private final c deleteResult;
    private final Pair<Action, List<i0>> historyList;
    private final PageStatus pageState;
    private final long refreshResultTime;
    private final com.larus.dora.api.offline.record.d syncState;
    private final o1 uploadResult;

    public RecordMinutesState() {
        this(null, null, null, 0, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecordMinutesState copy$default(RecordMinutesState r9, Pair r10, c r11, o1 r12, long r13, PageStatus r15, BottomStatus r16, com.larus.dora.api.offline.record.d r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        Pair r1 = r9.historyList;
    L7:
        if ((r18 & 2) == 0) goto L9;
        c r2 = r9.deleteResult;
    L11:
        if ((r18 & 4) == 0) goto L13;
        o1 r3 = r9.uploadResult;
    L15:
        if ((r18 & 8) == 0) goto L17;
        long r4 = r9.refreshResultTime;
    L19:
        if ((r18 & 16) == 0) goto L21;
        PageStatus r6 = r9.pageState;
    L23:
        if ((r18 & 32) == 0) goto L25;
        BottomStatus r7 = r9.bottomState;
    L27:
        if ((r18 & 64) == 0) goto L29;
        com.larus.dora.api.offline.record.d r8 = r9.syncState;
    L31:
        return r9.copy(r1, r2, r3, r4, r6, r7, r8);
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
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

    public final Pair<Action, List<i0>> component1() {
        return this.historyList;
    }

    public final c component2() {
        return this.deleteResult;
    }

    public final o1 component3() {
        return this.uploadResult;
    }

    public final long component4() {
        return this.refreshResultTime;
    }

    public final PageStatus component5() {
        return this.pageState;
    }

    public final BottomStatus component6() {
        return this.bottomState;
    }

    public final com.larus.dora.api.offline.record.d component7() {
        return this.syncState;
    }

    public final RecordMinutesState copy(Pair<? extends Action, ? extends List<i0>> r11, c r12, o1 r13, long r14, PageStatus r16, BottomStatus r17, com.larus.dora.api.offline.record.d r18) {
        Intrinsics.checkNotNullParameter(r11, "historyList");
        Intrinsics.checkNotNullParameter(r18, "syncState");
        return new RecordMinutesState(r11, r12, r13, r14, r16, r17, r18);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof RecordMinutesState) == true) goto L8;
        return false;
    L8:
        RecordMinutesState r9 = (RecordMinutesState) r8;
        if (Intrinsics.areEqual(this.historyList, r9.historyList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.deleteResult, r9.deleteResult) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.uploadResult, r9.uploadResult) == true) goto L18;
        return false;
    L18:
        if (this.refreshResultTime == r9.refreshResultTime) goto L21;
        return false;
    L21:
        if (this.pageState == r9.pageState) goto L24;
        return false;
    L24:
        if (this.bottomState == r9.bottomState) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.syncState, r9.syncState) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = this.historyList.hashCode() * 31;
        c r1 = this.deleteResult;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        o1 r5 = this.uploadResult;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        long r7 = this.refreshResultTime;
        int r8 = (((r4 + r6) * 31) + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        PageStatus r9 = this.pageState;
        if (r9 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r8 + r10) * 31;
        BottomStatus r12 = this.bottomState;
        if (r12 == null) goto L19;
        r2 = r12.hashCode();
    L19:
        return ((r11 + r2) * 31) + this.syncState.hashCode();
    L13:
        r10 = r9.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "RecordMinutesState(historyList=" + this.historyList + ", deleteResult=" + this.deleteResult + ", uploadResult=" + this.uploadResult + ", refreshResultTime=" + this.refreshResultTime + ", pageState=" + this.pageState + ", bottomState=" + this.bottomState + ", syncState=" + this.syncState + ')';
    }

    public final BottomStatus getBottomState() {
        return this.bottomState;
    }

    public final c getDeleteResult() {
        return this.deleteResult;
    }

    public final Pair<Action, List<i0>> getHistoryList() {
        return this.historyList;
    }

    public final PageStatus getPageState() {
        return this.pageState;
    }

    public final long getRefreshResultTime() {
        return this.refreshResultTime;
    }

    public final com.larus.dora.api.offline.record.d getSyncState() {
        return this.syncState;
    }

    public final o1 getUploadResult() {
        return this.uploadResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecordMinutesState(Pair<? extends Action, ? extends List<i0>> r2, c r3, o1 r4, long r5, PageStatus r7, BottomStatus r8, com.larus.dora.api.offline.record.d r9) {
        Intrinsics.checkNotNullParameter(r2, "historyList");
        Intrinsics.checkNotNullParameter(r9, "syncState");
        this.historyList = r2;
        this.deleteResult = r3;
        this.uploadResult = r4;
        this.refreshResultTime = r5;
        this.pageState = r7;
        this.bottomState = r8;
        this.syncState = r9;
    }

    public RecordMinutesState(Pair r9, c r10, o1 r11, long r12, PageStatus r14, BottomStatus r15, com.larus.dora.api.offline.record.d r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 1) == 0) goto L5;
        Pair r0 = new Pair(Action.UNKNOWN, CollectionsKt.emptyList());
    L6:
        o1 r2 = null;
        if ((r17 & 2) == 0) goto L9;
        c r1 = null;
    L11:
        if ((r17 & 4) != 0) goto L15;
        r2 = r11;
    L15:
        if ((r17 & 8) == 0) goto L17;
        long r3 = 0;
    L19:
        if ((r17 & 16) == 0) goto L21;
        PageStatus r5 = PageStatus.LOADING;
    L23:
        if ((r17 & 32) != 0) goto L25;
        BottomStatus r6 = r15;
    L30:
        if ((r17 & 64) == 0) goto L32;
        com.larus.dora.api.offline.record.d r7 = com.larus.dora.api.offline.record.d.i;
        com.larus.dora.api.offline.record.d r8 = com.larus.dora.api.offline.record.d.i;
    L33:
        this(r0, r1, r2, r3, r5, r6, r8);
        return;
    L32:
        r8 = r16;
        goto L33
    L25:
        if (ia8.e.a().isRecording() == false) goto L27;
        r6 = BottomStatus.RECORDING;
        goto L30
    L27:
        r6 = BottomStatus.END_RECORDING;
        goto L30
    L21:
        r5 = r14;
        goto L23
    L17:
        r3 = r12;
        goto L19
    L9:
        r1 = r10;
        goto L11
    L5:
        r0 = r9;
        goto L6
    }
}

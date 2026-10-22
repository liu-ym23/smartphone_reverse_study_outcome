package com.bytedance.android.live.room.api.messagewindow.list;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/list/RecordAction;", "", "OfferShowingRecord", "RemoveShowingRecord", "OfferPendingRecord", "PeekPendingRecord", "RemovePendingRecord", "RemoveFromRecords", "PollWaitingRecord", "OfferWaitingRecords", "RemoveWaitingRecord", "OfferTemporaryRecord", "RemoveTemporaryRecord", "ClearAllRecords", "LogRecords", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RecordAction extends Enum<RecordAction> {
    public static final RecordAction ClearAllRecords = null;
    public static final RecordAction LogRecords = null;
    public static final RecordAction OfferPendingRecord = null;
    public static final RecordAction OfferShowingRecord = null;
    public static final RecordAction OfferTemporaryRecord = null;
    public static final RecordAction OfferWaitingRecords = null;
    public static final RecordAction PeekPendingRecord = null;
    public static final RecordAction PollWaitingRecord = null;
    public static final RecordAction RemoveFromRecords = null;
    public static final RecordAction RemovePendingRecord = null;
    public static final RecordAction RemoveShowingRecord = null;
    public static final RecordAction RemoveTemporaryRecord = null;
    public static final RecordAction RemoveWaitingRecord = null;
    public static final /* synthetic */ RecordAction[] a = null;

    static {
        RecordAction r1 = new RecordAction("OfferShowingRecord", 0);
        OfferShowingRecord = r1;
        RecordAction r2 = new RecordAction("RemoveShowingRecord", 1);
        RemoveShowingRecord = r2;
        RecordAction r3 = new RecordAction("OfferPendingRecord", 2);
        OfferPendingRecord = r3;
        RecordAction r4 = new RecordAction("PeekPendingRecord", 3);
        PeekPendingRecord = r4;
        RecordAction r5 = new RecordAction("RemovePendingRecord", 4);
        RemovePendingRecord = r5;
        RecordAction r6 = new RecordAction("RemoveFromRecords", 5);
        RemoveFromRecords = r6;
        RecordAction r7 = new RecordAction("PollWaitingRecord", 6);
        PollWaitingRecord = r7;
        RecordAction r8 = new RecordAction("OfferWaitingRecords", 7);
        OfferWaitingRecords = r8;
        RecordAction r9 = new RecordAction("RemoveWaitingRecord", 8);
        RemoveWaitingRecord = r9;
        RecordAction r10 = new RecordAction("OfferTemporaryRecord", 9);
        OfferTemporaryRecord = r10;
        RecordAction r12 = new RecordAction("RemoveTemporaryRecord", 10);
        RemoveTemporaryRecord = r12;
        RecordAction r13 = new RecordAction("ClearAllRecords", 11);
        ClearAllRecords = r13;
        RecordAction r14 = new RecordAction("LogRecords", 12);
        LogRecords = r14;
        a = new RecordAction[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14};
    }

    public static RecordAction valueOf(String r1) {
        return (RecordAction) a.a(RecordAction.class, r1);
    }

    public static RecordAction[] values() {
        return (RecordAction[]) a.clone();
    }

    public RecordAction(String r1, int r2) {
        super(r1, r2);
    }
}

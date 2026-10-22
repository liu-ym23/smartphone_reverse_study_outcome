package com.bytedance.ai.monitor.timeline;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/monitor/timeline/CallFrom;", "", a.KEY_STATUS, "", "<init>", "(Ljava/lang/String;II)V", "getStatus", "()I", "FROM_WORKER", "FROM_WORKER_FALLBACK", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CallFrom extends Enum<CallFrom> {
    public static final CallFrom FROM_WORKER = null;
    public static final CallFrom FROM_WORKER_FALLBACK = null;
    public static final /* synthetic */ CallFrom[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int status;

    public static EnumEntries<CallFrom> getEntries() {
        return b;
    }

    static {
        CallFrom r0 = new CallFrom("FROM_WORKER", 0, 1);
        FROM_WORKER = r0;
        CallFrom r1 = new CallFrom("FROM_WORKER_FALLBACK", 1, 2);
        FROM_WORKER_FALLBACK = r1;
        CallFrom[] r10 = {r0, r1};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static CallFrom[] values() {
        return (CallFrom[]) a.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    public static CallFrom valueOf(String r1) {
        return (CallFrom) r27.a.a(CallFrom.class, r1);
    }

    public CallFrom(String r1, int r10, int r11) {
        super(r1, r10);
        this.status = r11;
    }
}

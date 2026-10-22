package com.obric.memorydata.sdk.service;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/sdk/service/BinderCode;", "", "<init>", "(Ljava/lang/String;I)V", "REALTIME_CONTEXT", "MEMORY", "ASSISTANT_STATE", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final enum BinderCode extends Enum<BinderCode> {
    public static final BinderCode ASSISTANT_STATE = null;
    public static final a Companion = null;
    public static final BinderCode MEMORY = null;
    public static final BinderCode REALTIME_CONTEXT = null;
    public static final /* synthetic */ BinderCode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BinderCode> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.memorydata.sdk.service.BinderCode$a] */
    static {
        BinderCode r0 = new BinderCode("REALTIME_CONTEXT", 0);
        REALTIME_CONTEXT = r0;
        BinderCode r1 = new BinderCode("MEMORY", 1);
        MEMORY = r1;
        BinderCode r3 = new BinderCode("ASSISTANT_STATE", 2);
        ASSISTANT_STATE = r3;
        BinderCode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static BinderCode[] values() {
        return (BinderCode[]) a.clone();
    }

    public static BinderCode valueOf(String r1) {
        return (BinderCode) r27.a.a(BinderCode.class, r1);
    }

    public BinderCode(String r1, int r2) {
        super(r1, r2);
    }
}

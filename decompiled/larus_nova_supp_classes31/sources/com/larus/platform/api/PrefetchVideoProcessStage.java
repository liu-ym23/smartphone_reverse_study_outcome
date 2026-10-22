package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/platform/api/PrefetchVideoProcessStage;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CMD_INIT", "CMD_PROCESS", "BIND_PROCESS", "REFRESH_PROCESS", "UN_CONSUMED_PROCESS", "EXPIRATION_PROCESS", "EXCEPTION", "FILTERED", "UNLIMITED_FLOW_PROCESS", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum PrefetchVideoProcessStage extends Enum<PrefetchVideoProcessStage> {
    public static final PrefetchVideoProcessStage BIND_PROCESS = null;
    public static final PrefetchVideoProcessStage CMD_INIT = null;
    public static final PrefetchVideoProcessStage CMD_PROCESS = null;
    public static final PrefetchVideoProcessStage EXCEPTION = null;
    public static final PrefetchVideoProcessStage EXPIRATION_PROCESS = null;
    public static final PrefetchVideoProcessStage FILTERED = null;
    public static final PrefetchVideoProcessStage REFRESH_PROCESS = null;
    public static final PrefetchVideoProcessStage UNLIMITED_FLOW_PROCESS = null;
    public static final PrefetchVideoProcessStage UN_CONSUMED_PROCESS = null;
    public static final /* synthetic */ PrefetchVideoProcessStage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<PrefetchVideoProcessStage> getEntries() {
        return b;
    }

    static {
        PrefetchVideoProcessStage r0 = new PrefetchVideoProcessStage("CMD_INIT", 0, "cache_init");
        CMD_INIT = r0;
        PrefetchVideoProcessStage r1 = new PrefetchVideoProcessStage("CMD_PROCESS", 1, "cmd_process");
        CMD_PROCESS = r1;
        PrefetchVideoProcessStage r2 = new PrefetchVideoProcessStage("BIND_PROCESS", 2, "bind_process");
        BIND_PROCESS = r2;
        PrefetchVideoProcessStage r4 = new PrefetchVideoProcessStage("REFRESH_PROCESS", 3, "refresh_process");
        REFRESH_PROCESS = r4;
        PrefetchVideoProcessStage r6 = new PrefetchVideoProcessStage("UN_CONSUMED_PROCESS", 4, "un_consumed_process");
        UN_CONSUMED_PROCESS = r6;
        PrefetchVideoProcessStage r8 = new PrefetchVideoProcessStage("EXPIRATION_PROCESS", 5, "expiration_process");
        EXPIRATION_PROCESS = r8;
        PrefetchVideoProcessStage r10 = new PrefetchVideoProcessStage("EXCEPTION", 6, "exception");
        EXCEPTION = r10;
        PrefetchVideoProcessStage r12 = new PrefetchVideoProcessStage("FILTERED", 7, "filtered");
        FILTERED = r12;
        PrefetchVideoProcessStage r14 = new PrefetchVideoProcessStage("UNLIMITED_FLOW_PROCESS", 8, "unlimited_flow_process");
        UNLIMITED_FLOW_PROCESS = r14;
        PrefetchVideoProcessStage[] r13 = {r0, r1, r2, r4, r6, r8, r10, r12, r14};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static PrefetchVideoProcessStage[] values() {
        return (PrefetchVideoProcessStage[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static PrefetchVideoProcessStage valueOf(String r1) {
        return (PrefetchVideoProcessStage) r27.a.a(PrefetchVideoProcessStage.class, r1);
    }

    public PrefetchVideoProcessStage(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}

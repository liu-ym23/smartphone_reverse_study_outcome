package com.larus.uaigc.helper;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/uaigc/helper/CreationLocalDetectState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DISABLED", "SUBMITTED", "FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
final enum CreationLocalDetectState extends Enum<CreationLocalDetectState> {
    public static final CreationLocalDetectState DISABLED = null;
    public static final CreationLocalDetectState FAILED = null;
    public static final CreationLocalDetectState SUBMITTED = null;
    public static final /* synthetic */ CreationLocalDetectState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<CreationLocalDetectState> getEntries() {
        return b;
    }

    static {
        CreationLocalDetectState r0 = new CreationLocalDetectState("DISABLED", 0, "disabled");
        DISABLED = r0;
        CreationLocalDetectState r1 = new CreationLocalDetectState("SUBMITTED", 1, "submitted");
        SUBMITTED = r1;
        CreationLocalDetectState r2 = new CreationLocalDetectState("FAILED", 2, "failed");
        FAILED = r2;
        CreationLocalDetectState[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static CreationLocalDetectState[] values() {
        return (CreationLocalDetectState[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CreationLocalDetectState valueOf(String r1) {
        return (CreationLocalDetectState) r27.a.a(CreationLocalDetectState.class, r1);
    }

    public CreationLocalDetectState(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}

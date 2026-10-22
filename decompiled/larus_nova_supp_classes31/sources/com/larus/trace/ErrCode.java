package com.larus.trace;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/trace/ErrCode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "InitSub", "PipoCallback", "GetUserSubInfo", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum ErrCode extends Enum<ErrCode> {
    public static final ErrCode GetUserSubInfo = null;
    public static final ErrCode InitSub = null;
    public static final ErrCode PipoCallback = null;
    public static final /* synthetic */ ErrCode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ErrCode> getEntries() {
        return b;
    }

    static {
        ErrCode r0 = new ErrCode("InitSub", 0, -1);
        InitSub = r0;
        ErrCode r1 = new ErrCode("PipoCallback", 1, -2);
        PipoCallback = r1;
        ErrCode r2 = new ErrCode("GetUserSubInfo", 2, -3);
        GetUserSubInfo = r2;
        ErrCode[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static ErrCode[] values() {
        return (ErrCode[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ErrCode valueOf(String r1) {
        return (ErrCode) a.a(ErrCode.class, r1);
    }

    public ErrCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

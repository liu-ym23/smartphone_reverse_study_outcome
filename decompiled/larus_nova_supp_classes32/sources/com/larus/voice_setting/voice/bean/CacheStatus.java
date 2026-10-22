package com.larus.voice_setting.voice.bean;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/voice_setting/voice/bean/CacheStatus;", NameKeys.UnloadStrategy_No_Strategy, "log", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;II)V", "getLog", "()I", "setLog", "(I)V", "EMPTY", "LOADING", "CACHED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CacheStatus extends Enum<CacheStatus> {
    public static final CacheStatus CACHED = null;
    public static final CacheStatus EMPTY = null;
    public static final CacheStatus LOADING = null;
    public static final /* synthetic */ CacheStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private int log;

    public static EnumEntries<CacheStatus> getEntries() {
        return b;
    }

    static {
        CacheStatus r0 = new CacheStatus("EMPTY", 0, 0);
        EMPTY = r0;
        CacheStatus r1 = new CacheStatus("LOADING", 1, 1);
        LOADING = r1;
        CacheStatus r3 = new CacheStatus("CACHED", 2, 2);
        CACHED = r3;
        CacheStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CacheStatus[] values() {
        return (CacheStatus[]) a.clone();
    }

    public final int getLog() {
        return this.log;
    }

    public static CacheStatus valueOf(String r1) {
        return (CacheStatus) a.a(CacheStatus.class, r1);
    }

    public final void setLog(int r1) {
        this.log = r1;
    }

    public CacheStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.log = r3;
    }
}

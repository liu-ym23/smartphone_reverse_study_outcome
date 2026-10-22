package com.obric.audio.continuous_talk;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/audio/continuous_talk/ContinuousTalkStatus;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "STOPPED", "RUNNING", "STOPPING", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContinuousTalkStatus extends Enum<ContinuousTalkStatus> {
    public static final ContinuousTalkStatus RUNNING = null;
    public static final ContinuousTalkStatus STOPPED = null;
    public static final ContinuousTalkStatus STOPPING = null;
    public static final /* synthetic */ ContinuousTalkStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ContinuousTalkStatus> getEntries() {
        return b;
    }

    static {
        ContinuousTalkStatus r0 = new ContinuousTalkStatus("STOPPED", 0);
        STOPPED = r0;
        ContinuousTalkStatus r1 = new ContinuousTalkStatus("RUNNING", 1);
        RUNNING = r1;
        ContinuousTalkStatus r3 = new ContinuousTalkStatus("STOPPING", 2);
        STOPPING = r3;
        ContinuousTalkStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ContinuousTalkStatus[] values() {
        return (ContinuousTalkStatus[]) a.clone();
    }

    public static ContinuousTalkStatus valueOf(String r1) {
        return (ContinuousTalkStatus) r27.a.a(ContinuousTalkStatus.class, r1);
    }

    public ContinuousTalkStatus(String r1, int r2) {
        super(r1, r2);
    }
}

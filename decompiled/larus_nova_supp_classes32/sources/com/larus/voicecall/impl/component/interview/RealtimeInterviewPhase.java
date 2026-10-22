package com.larus.voicecall.impl.component.interview;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/voicecall/impl/component/interview/RealtimeInterviewPhase;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "Initialized", "Preparing", "Planning", "Interviewing", "Error", "Ended", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RealtimeInterviewPhase extends Enum<RealtimeInterviewPhase> {
    public static final RealtimeInterviewPhase Ended = null;
    public static final RealtimeInterviewPhase Error = null;
    public static final RealtimeInterviewPhase Initialized = null;
    public static final RealtimeInterviewPhase Interviewing = null;
    public static final RealtimeInterviewPhase Planning = null;
    public static final RealtimeInterviewPhase Preparing = null;
    public static final /* synthetic */ RealtimeInterviewPhase[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RealtimeInterviewPhase> getEntries() {
        return b;
    }

    static {
        RealtimeInterviewPhase r0 = new RealtimeInterviewPhase("Initialized", 0);
        Initialized = r0;
        RealtimeInterviewPhase r1 = new RealtimeInterviewPhase("Preparing", 1);
        Preparing = r1;
        RealtimeInterviewPhase r3 = new RealtimeInterviewPhase("Planning", 2);
        Planning = r3;
        RealtimeInterviewPhase r5 = new RealtimeInterviewPhase("Interviewing", 3);
        Interviewing = r5;
        RealtimeInterviewPhase r7 = new RealtimeInterviewPhase("Error", 4);
        Error = r7;
        RealtimeInterviewPhase r9 = new RealtimeInterviewPhase("Ended", 5);
        Ended = r9;
        RealtimeInterviewPhase[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static RealtimeInterviewPhase[] values() {
        return (RealtimeInterviewPhase[]) a.clone();
    }

    public static RealtimeInterviewPhase valueOf(String r1) {
        return (RealtimeInterviewPhase) a.a(RealtimeInterviewPhase.class, r1);
    }

    public RealtimeInterviewPhase(String r1, int r2) {
        super(r1, r2);
    }
}

package com.larus.voicecall.impl.tracer;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/voicecall/impl/tracer/ReplyAudioPhase;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "BEGIN", "END", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReplyAudioPhase extends Enum<ReplyAudioPhase> {
    public static final ReplyAudioPhase BEGIN = null;
    public static final ReplyAudioPhase END = null;
    public static final /* synthetic */ ReplyAudioPhase[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ReplyAudioPhase> getEntries() {
        return b;
    }

    static {
        ReplyAudioPhase r0 = new ReplyAudioPhase("BEGIN", 0);
        BEGIN = r0;
        ReplyAudioPhase r1 = new ReplyAudioPhase("END", 1);
        END = r1;
        ReplyAudioPhase[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ReplyAudioPhase[] values() {
        return (ReplyAudioPhase[]) a.clone();
    }

    public static ReplyAudioPhase valueOf(String r1) {
        return (ReplyAudioPhase) r27.a.a(ReplyAudioPhase.class, r1);
    }

    public ReplyAudioPhase(String r1, int r2) {
        super(r1, r2);
    }
}

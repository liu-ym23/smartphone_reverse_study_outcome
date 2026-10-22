package com.larus.voicecall.impl.tracer;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/voicecall/impl/tracer/VoiceCallTraceReplyType;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "REPLY", "CHIME_IN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceCallTraceReplyType extends Enum<VoiceCallTraceReplyType> {
    public static final VoiceCallTraceReplyType CHIME_IN = null;
    public static final VoiceCallTraceReplyType REPLY = null;
    public static final /* synthetic */ VoiceCallTraceReplyType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<VoiceCallTraceReplyType> getEntries() {
        return b;
    }

    static {
        VoiceCallTraceReplyType r0 = new VoiceCallTraceReplyType("REPLY", 0);
        REPLY = r0;
        VoiceCallTraceReplyType r1 = new VoiceCallTraceReplyType("CHIME_IN", 1);
        CHIME_IN = r1;
        VoiceCallTraceReplyType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static VoiceCallTraceReplyType[] values() {
        return (VoiceCallTraceReplyType[]) a.clone();
    }

    public static VoiceCallTraceReplyType valueOf(String r1) {
        return (VoiceCallTraceReplyType) r27.a.a(VoiceCallTraceReplyType.class, r1);
    }

    public VoiceCallTraceReplyType(String r1, int r2) {
        super(r1, r2);
    }
}

package com.larus.voicecall.impl.tracer;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/larus/voicecall/impl/tracer/ReplyAudioEventType;", NameKeys.UnloadStrategy_No_Strategy, "kind", "Lcom/larus/voicecall/impl/tracer/VoiceCallTraceReplyType;", "phase", "Lcom/larus/voicecall/impl/tracer/ReplyAudioPhase;", "eventType", NameKeys.UnloadStrategy_No_Strategy, "what", "<init>", "(Ljava/lang/String;ILcom/larus/voicecall/impl/tracer/VoiceCallTraceReplyType;Lcom/larus/voicecall/impl/tracer/ReplyAudioPhase;Ljava/lang/String;Ljava/lang/String;)V", "getKind", "()Lcom/larus/voicecall/impl/tracer/VoiceCallTraceReplyType;", "getPhase", "()Lcom/larus/voicecall/impl/tracer/ReplyAudioPhase;", "getEventType", "()Ljava/lang/String;", "getWhat", "REPLY_BEGIN", "REPLY_END", "CHIME_IN_START", "CHIME_IN_END", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReplyAudioEventType extends Enum<ReplyAudioEventType> {
    public static final ReplyAudioEventType CHIME_IN_END = null;
    public static final ReplyAudioEventType CHIME_IN_START = null;
    public static final ReplyAudioEventType REPLY_BEGIN = null;
    public static final ReplyAudioEventType REPLY_END = null;
    public static final /* synthetic */ ReplyAudioEventType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String eventType;
    private final VoiceCallTraceReplyType kind;
    private final ReplyAudioPhase phase;
    private final String what;

    public static EnumEntries<ReplyAudioEventType> getEntries() {
        return b;
    }

    static {
        VoiceCallTraceReplyType r11 = VoiceCallTraceReplyType.REPLY;
        ReplyAudioPhase r16 = ReplyAudioPhase.BEGIN;
        ReplyAudioEventType r7 = new ReplyAudioEventType("REPLY_BEGIN", 0, r11, r16, "replyBegin", "reply.audio.begin");
        REPLY_BEGIN = r7;
        ReplyAudioPhase r21 = ReplyAudioPhase.END;
        ReplyAudioEventType r0 = new ReplyAudioEventType("REPLY_END", 1, r11, r21, "replyEnd", "reply.audio.end");
        REPLY_END = r0;
        VoiceCallTraceReplyType r20 = VoiceCallTraceReplyType.CHIME_IN;
        ReplyAudioEventType r1 = new ReplyAudioEventType("CHIME_IN_START", 2, r20, r16, "chimeInStart", "reply.audio.begin");
        CHIME_IN_START = r1;
        ReplyAudioEventType r2 = new ReplyAudioEventType("CHIME_IN_END", 3, r20, r21, "chimeInEnd", "reply.audio.end");
        CHIME_IN_END = r2;
        ReplyAudioEventType[] r3 = {r7, r0, r1, r2};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ReplyAudioEventType[] values() {
        return (ReplyAudioEventType[]) a.clone();
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final VoiceCallTraceReplyType getKind() {
        return this.kind;
    }

    public final ReplyAudioPhase getPhase() {
        return this.phase;
    }

    public final String getWhat() {
        return this.what;
    }

    public static ReplyAudioEventType valueOf(String r1) {
        return (ReplyAudioEventType) r27.a.a(ReplyAudioEventType.class, r1);
    }

    public ReplyAudioEventType(String r1, int r2, VoiceCallTraceReplyType r3, ReplyAudioPhase r4, String r5, String r6) {
        super(r1, r2);
        this.kind = r3;
        this.phase = r4;
        this.eventType = r5;
        this.what = r6;
    }
}

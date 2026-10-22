package com.larus.voicecall.impl.component.feedback;

import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/voicecall/impl/component/feedback/CallTypeTrace;", NameKeys.UnloadStrategy_No_Strategy, "callType", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getCallType", "()Ljava/lang/String;", "Video", "Audio", "Screen", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CallTypeTrace extends Enum<CallTypeTrace> {
    public static final CallTypeTrace Audio = null;
    public static final CallTypeTrace Screen = null;
    public static final CallTypeTrace Video = null;
    public static final /* synthetic */ CallTypeTrace[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String callType;

    public static EnumEntries<CallTypeTrace> getEntries() {
        return b;
    }

    static {
        CallTypeTrace r0 = new CallTypeTrace("Video", 0, LynxResourceModule.VIDEO_TYPE);
        Video = r0;
        CallTypeTrace r1 = new CallTypeTrace("Audio", 1, LynxResourceModule.AUDIO_TYPE);
        Audio = r1;
        CallTypeTrace r2 = new CallTypeTrace("Screen", 2, "screen");
        Screen = r2;
        CallTypeTrace[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static CallTypeTrace[] values() {
        return (CallTypeTrace[]) a.clone();
    }

    public final String getCallType() {
        return this.callType;
    }

    public static CallTypeTrace valueOf(String r1) {
        return (CallTypeTrace) r27.a.a(CallTypeTrace.class, r1);
    }

    public CallTypeTrace(String r1, int r2, String r3) {
        super(r1, r2);
        this.callType = r3;
    }
}

package com.obric.assistant.audio.service;

import com.mammon.audiosdk.session.type.RequestEvent;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/audio/service/ObricAssistantAudioVisualizerState;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "SpeechStarted", "Thinking", "QueryRejected", "TtsEnd", RequestEvent.FinishSession, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricAssistantAudioVisualizerState extends Enum<ObricAssistantAudioVisualizerState> {
    public static final ObricAssistantAudioVisualizerState FinishSession = null;
    public static final ObricAssistantAudioVisualizerState QueryRejected = null;
    public static final ObricAssistantAudioVisualizerState SpeechStarted = null;
    public static final ObricAssistantAudioVisualizerState Thinking = null;
    public static final ObricAssistantAudioVisualizerState TtsEnd = null;
    public static final /* synthetic */ ObricAssistantAudioVisualizerState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ObricAssistantAudioVisualizerState> getEntries() {
        return b;
    }

    static {
        ObricAssistantAudioVisualizerState r0 = new ObricAssistantAudioVisualizerState("SpeechStarted", 0);
        SpeechStarted = r0;
        ObricAssistantAudioVisualizerState r1 = new ObricAssistantAudioVisualizerState("Thinking", 1);
        Thinking = r1;
        ObricAssistantAudioVisualizerState r3 = new ObricAssistantAudioVisualizerState("QueryRejected", 2);
        QueryRejected = r3;
        ObricAssistantAudioVisualizerState r5 = new ObricAssistantAudioVisualizerState("TtsEnd", 3);
        TtsEnd = r5;
        ObricAssistantAudioVisualizerState r7 = new ObricAssistantAudioVisualizerState(RequestEvent.FinishSession, 4);
        FinishSession = r7;
        ObricAssistantAudioVisualizerState[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static ObricAssistantAudioVisualizerState[] values() {
        return (ObricAssistantAudioVisualizerState[]) a.clone();
    }

    public static ObricAssistantAudioVisualizerState valueOf(String r1) {
        return (ObricAssistantAudioVisualizerState) a.a(ObricAssistantAudioVisualizerState.class, r1);
    }

    public ObricAssistantAudioVisualizerState(String r1, int r2) {
        super(r1, r2);
    }
}

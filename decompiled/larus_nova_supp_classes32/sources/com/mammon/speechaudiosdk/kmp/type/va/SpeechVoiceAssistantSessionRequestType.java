package com.mammon.speechaudiosdk.kmp.type.va;

import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/type/va/SpeechVoiceAssistantSessionRequestType;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "ToModify", "MessageASR", "MessageTTS", "BidirectionalTTS", "Companion", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SpeechVoiceAssistantSessionRequestType extends Enum<SpeechVoiceAssistantSessionRequestType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SpeechVoiceAssistantSessionRequestType[] $VALUES = null;
    public static final SpeechVoiceAssistantSessionRequestType BidirectionalTTS = null;
    public static final Companion Companion = null;
    public static final SpeechVoiceAssistantSessionRequestType MessageASR = null;
    public static final SpeechVoiceAssistantSessionRequestType MessageTTS = null;
    public static final SpeechVoiceAssistantSessionRequestType ToModify = null;
    public static final SpeechVoiceAssistantSessionRequestType Unknown = null;
    private static final Map<Integer, SpeechVoiceAssistantSessionRequestType> map = null;
    private final int value;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/type/va/SpeechVoiceAssistantSessionRequestType$Companion;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "()V", "map", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "Lcom/mammon/speechaudiosdk/kmp/type/va/SpeechVoiceAssistantSessionRequestType;", "fromInt", "value", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final SpeechVoiceAssistantSessionRequestType fromInt(int r2) {
            SpeechVoiceAssistantSessionRequestType r3 = (SpeechVoiceAssistantSessionRequestType) SpeechVoiceAssistantSessionRequestType.access$getMap$cp().get(Integer.valueOf(r2));
            if (r3 == null) goto L5;
            return r3;
        L5:
            return SpeechVoiceAssistantSessionRequestType.Unknown;
        }
    }

    private static final /* synthetic */ SpeechVoiceAssistantSessionRequestType[] $values() {
        return new SpeechVoiceAssistantSessionRequestType[]{Unknown, ToModify, MessageASR, MessageTTS, BidirectionalTTS};
    }

    public static EnumEntries<SpeechVoiceAssistantSessionRequestType> getEntries() {
        return $ENTRIES;
    }

    static {
        int r3 = 0;
        Unknown = new SpeechVoiceAssistantSessionRequestType("Unknown", 0, -1);
        ToModify = new SpeechVoiceAssistantSessionRequestType("ToModify", 1, 0);
        MessageASR = new SpeechVoiceAssistantSessionRequestType("MessageASR", 2, 3);
        MessageTTS = new SpeechVoiceAssistantSessionRequestType("MessageTTS", 3, 4);
        BidirectionalTTS = new SpeechVoiceAssistantSessionRequestType("BidirectionalTTS", 4, 5);
        SpeechVoiceAssistantSessionRequestType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
        Companion = new Companion(null);
        SpeechVoiceAssistantSessionRequestType[] r1 = values();
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r1.length), 16));
        int r4 = r1.length;
    L3:
        if (r3 >= r4) goto L5;
        SpeechVoiceAssistantSessionRequestType r5 = r1[r3];
        r2.put(Integer.valueOf(r5.value), r5);
        r3 = r3 + 1;
        goto L3
    L5:
        map = r2;
    }

    public static SpeechVoiceAssistantSessionRequestType[] values() {
        return (SpeechVoiceAssistantSessionRequestType[]) $VALUES.clone();
    }

    public static final /* synthetic */ Map access$getMap$cp() {
        return map;
    }

    public final int getValue() {
        return this.value;
    }

    public static SpeechVoiceAssistantSessionRequestType valueOf(String r1) {
        return (SpeechVoiceAssistantSessionRequestType) a.a(SpeechVoiceAssistantSessionRequestType.class, r1);
    }

    private SpeechVoiceAssistantSessionRequestType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

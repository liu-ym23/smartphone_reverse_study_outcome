package com.obric.assistant.spi.audio;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/spi/audio/WakeupAudioCaptureTriggerType;", "", "<init>", "(Ljava/lang/String;I)V", "VOICE_WAKEUP", "BREATH_WAKEUP", "CLICK_TALK", "LONG_PRESS", "UNKNOWN", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WakeupAudioCaptureTriggerType extends Enum<WakeupAudioCaptureTriggerType> {
    public static final WakeupAudioCaptureTriggerType BREATH_WAKEUP = null;
    public static final WakeupAudioCaptureTriggerType CLICK_TALK = null;
    public static final WakeupAudioCaptureTriggerType LONG_PRESS = null;
    public static final WakeupAudioCaptureTriggerType UNKNOWN = null;
    public static final WakeupAudioCaptureTriggerType VOICE_WAKEUP = null;
    public static final /* synthetic */ WakeupAudioCaptureTriggerType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<WakeupAudioCaptureTriggerType> getEntries() {
        return b;
    }

    static {
        WakeupAudioCaptureTriggerType r0 = new WakeupAudioCaptureTriggerType("VOICE_WAKEUP", 0);
        VOICE_WAKEUP = r0;
        WakeupAudioCaptureTriggerType r1 = new WakeupAudioCaptureTriggerType("BREATH_WAKEUP", 1);
        BREATH_WAKEUP = r1;
        WakeupAudioCaptureTriggerType r3 = new WakeupAudioCaptureTriggerType("CLICK_TALK", 2);
        CLICK_TALK = r3;
        WakeupAudioCaptureTriggerType r5 = new WakeupAudioCaptureTriggerType("LONG_PRESS", 3);
        LONG_PRESS = r5;
        WakeupAudioCaptureTriggerType r7 = new WakeupAudioCaptureTriggerType("UNKNOWN", 4);
        UNKNOWN = r7;
        WakeupAudioCaptureTriggerType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static WakeupAudioCaptureTriggerType[] values() {
        return (WakeupAudioCaptureTriggerType[]) a.clone();
    }

    public static WakeupAudioCaptureTriggerType valueOf(String r1) {
        return (WakeupAudioCaptureTriggerType) r27.a.a(WakeupAudioCaptureTriggerType.class, r1);
    }

    public WakeupAudioCaptureTriggerType(String r1, int r2) {
        super(r1, r2);
    }
}

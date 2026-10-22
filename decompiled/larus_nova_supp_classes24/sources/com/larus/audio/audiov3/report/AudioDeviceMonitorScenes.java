package com.larus.audio.audiov3.report;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/audio/audiov3/report/AudioDeviceMonitorScenes;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ASR", "TTS", "ENTER_CALL", "CONNECT", "SWITCH", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AudioDeviceMonitorScenes extends Enum<AudioDeviceMonitorScenes> {
    public static final AudioDeviceMonitorScenes ASR = null;
    public static final AudioDeviceMonitorScenes CONNECT = null;
    public static final AudioDeviceMonitorScenes ENTER_CALL = null;
    public static final AudioDeviceMonitorScenes SWITCH = null;
    public static final AudioDeviceMonitorScenes TTS = null;
    public static final /* synthetic */ AudioDeviceMonitorScenes[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<AudioDeviceMonitorScenes> getEntries() {
        return b;
    }

    static {
        AudioDeviceMonitorScenes r0 = new AudioDeviceMonitorScenes("ASR", 0, "asr");
        ASR = r0;
        AudioDeviceMonitorScenes r1 = new AudioDeviceMonitorScenes("TTS", 1, "tts");
        TTS = r1;
        AudioDeviceMonitorScenes r2 = new AudioDeviceMonitorScenes("ENTER_CALL", 2, "enter_call");
        ENTER_CALL = r2;
        AudioDeviceMonitorScenes r4 = new AudioDeviceMonitorScenes("CONNECT", 3, "connect");
        CONNECT = r4;
        AudioDeviceMonitorScenes r6 = new AudioDeviceMonitorScenes("SWITCH", 4, "switch");
        SWITCH = r6;
        AudioDeviceMonitorScenes[] r8 = {r0, r1, r2, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static AudioDeviceMonitorScenes[] values() {
        return (AudioDeviceMonitorScenes[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AudioDeviceMonitorScenes valueOf(String r1) {
        return (AudioDeviceMonitorScenes) a.a(AudioDeviceMonitorScenes.class, r1);
    }

    public AudioDeviceMonitorScenes(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}

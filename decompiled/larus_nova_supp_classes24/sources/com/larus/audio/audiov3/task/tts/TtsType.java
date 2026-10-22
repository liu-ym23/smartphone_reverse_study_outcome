package com.larus.audio.audiov3.task.tts;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/audiov3/task/tts/TtsType;", "", "<init>", "(Ljava/lang/String;I)V", "TTS_BY_MSG_ID", "TTS_BY_TEXT", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TtsType extends Enum<TtsType> {
    public static final TtsType TTS_BY_MSG_ID = null;
    public static final TtsType TTS_BY_TEXT = null;
    public static final /* synthetic */ TtsType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TtsType> getEntries() {
        return b;
    }

    static {
        TtsType r0 = new TtsType("TTS_BY_MSG_ID", 0);
        TTS_BY_MSG_ID = r0;
        TtsType r1 = new TtsType("TTS_BY_TEXT", 1);
        TTS_BY_TEXT = r1;
        TtsType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static TtsType[] values() {
        return (TtsType[]) a.clone();
    }

    public static TtsType valueOf(String r1) {
        return (TtsType) a.a(TtsType.class, r1);
    }

    public TtsType(String r1, int r2) {
        super(r1, r2);
    }
}

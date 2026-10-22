package com.larus.audio.audiov3.task.tts;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/audio/audiov3/task/tts/TtsStopType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "PLAY_DONE", "USER_CANCEL", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TtsStopType extends Enum<TtsStopType> {
    public static final TtsStopType PLAY_DONE = null;
    public static final TtsStopType USER_CANCEL = null;
    public static final /* synthetic */ TtsStopType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<TtsStopType> getEntries() {
        return b;
    }

    static {
        TtsStopType r0 = new TtsStopType("PLAY_DONE", 0, "play_done");
        PLAY_DONE = r0;
        TtsStopType r1 = new TtsStopType("USER_CANCEL", 1, "user_cancel");
        USER_CANCEL = r1;
        TtsStopType[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static TtsStopType[] values() {
        return (TtsStopType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static TtsStopType valueOf(String r1) {
        return (TtsStopType) a.a(TtsStopType.class, r1);
    }

    public TtsStopType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}

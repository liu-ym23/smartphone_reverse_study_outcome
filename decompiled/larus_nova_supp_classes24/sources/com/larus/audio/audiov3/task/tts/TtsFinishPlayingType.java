package com.larus.audio.audiov3.task.tts;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/audio/audiov3/task/tts/TtsFinishPlayingType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "PLAY_DONE", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TtsFinishPlayingType extends Enum<TtsFinishPlayingType> {
    public static final TtsFinishPlayingType PLAY_DONE = null;
    public static final /* synthetic */ TtsFinishPlayingType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<TtsFinishPlayingType> getEntries() {
        return b;
    }

    static {
        TtsFinishPlayingType r0 = new TtsFinishPlayingType();
        PLAY_DONE = r0;
        TtsFinishPlayingType[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public TtsFinishPlayingType() {
        super("PLAY_DONE", 0);
        this.type = "play_done";
    }

    public static TtsFinishPlayingType[] values() {
        return (TtsFinishPlayingType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static TtsFinishPlayingType valueOf(String r1) {
        return (TtsFinishPlayingType) a.a(TtsFinishPlayingType.class, r1);
    }
}

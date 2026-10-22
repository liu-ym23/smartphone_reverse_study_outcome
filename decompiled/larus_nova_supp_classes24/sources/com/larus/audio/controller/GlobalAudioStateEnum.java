package com.larus.audio.controller;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/audio/controller/GlobalAudioStateEnum;", "", "num", "", "<init>", "(Ljava/lang/String;II)V", "getNum", "()I", "NONE", "STOPPED", "PAUSED", "PLAYING", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum GlobalAudioStateEnum extends Enum<GlobalAudioStateEnum> {
    public static final GlobalAudioStateEnum NONE = null;
    public static final GlobalAudioStateEnum PAUSED = null;
    public static final GlobalAudioStateEnum PLAYING = null;
    public static final GlobalAudioStateEnum STOPPED = null;
    public static final /* synthetic */ GlobalAudioStateEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int num;

    public static EnumEntries<GlobalAudioStateEnum> getEntries() {
        return b;
    }

    static {
        GlobalAudioStateEnum r0 = new GlobalAudioStateEnum("NONE", 0, 0);
        NONE = r0;
        GlobalAudioStateEnum r1 = new GlobalAudioStateEnum("STOPPED", 1, 1);
        STOPPED = r1;
        GlobalAudioStateEnum r3 = new GlobalAudioStateEnum("PAUSED", 2, 2);
        PAUSED = r3;
        GlobalAudioStateEnum r5 = new GlobalAudioStateEnum("PLAYING", 3, 3);
        PLAYING = r5;
        GlobalAudioStateEnum[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static GlobalAudioStateEnum[] values() {
        return (GlobalAudioStateEnum[]) a.clone();
    }

    public final int getNum() {
        return this.num;
    }

    public static GlobalAudioStateEnum valueOf(String r1) {
        return (GlobalAudioStateEnum) a.a(GlobalAudioStateEnum.class, r1);
    }

    public GlobalAudioStateEnum(String r1, int r2, int r3) {
        super(r1, r2);
        this.num = r3;
    }
}

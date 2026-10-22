package com.larus.audio.audiov3.task.asr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/audiov3/task/asr/AsrState;", "", "step", "", "<init>", "(Ljava/lang/String;II)V", "getStep", "()I", "ASR_IDLE", "ASR_STARTED", "ASR_STOP", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AsrState extends Enum<AsrState> {
    public static final AsrState ASR_IDLE = null;
    public static final AsrState ASR_STARTED = null;
    public static final AsrState ASR_STOP = null;
    public static final /* synthetic */ AsrState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int step;

    public static EnumEntries<AsrState> getEntries() {
        return b;
    }

    static {
        AsrState r0 = new AsrState("ASR_IDLE", 0, -1);
        ASR_IDLE = r0;
        AsrState r1 = new AsrState("ASR_STARTED", 1, 0);
        ASR_STARTED = r1;
        AsrState r2 = new AsrState("ASR_STOP", 2, 1);
        ASR_STOP = r2;
        AsrState[] r5 = {r0, r1, r2};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AsrState[] values() {
        return (AsrState[]) a.clone();
    }

    public final int getStep() {
        return this.step;
    }

    public static AsrState valueOf(String r1) {
        return (AsrState) a.a(AsrState.class, r1);
    }

    public AsrState(String r1, int r2, int r3) {
        super(r1, r2);
        this.step = r3;
    }
}

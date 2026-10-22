package com.larus.audio.audiov3.task.asr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/audio/audiov3/task/asr/AsrDataSourceState;", "", "<init>", "(Ljava/lang/String;I)V", "UNINITIALIZED", "INITIALIZED", "STARTED", "STOPPED", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AsrDataSourceState extends Enum<AsrDataSourceState> {
    public static final AsrDataSourceState INITIALIZED = null;
    public static final AsrDataSourceState STARTED = null;
    public static final AsrDataSourceState STOPPED = null;
    public static final AsrDataSourceState UNINITIALIZED = null;
    public static final /* synthetic */ AsrDataSourceState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AsrDataSourceState> getEntries() {
        return b;
    }

    static {
        AsrDataSourceState r0 = new AsrDataSourceState("UNINITIALIZED", 0);
        UNINITIALIZED = r0;
        AsrDataSourceState r1 = new AsrDataSourceState("INITIALIZED", 1);
        INITIALIZED = r1;
        AsrDataSourceState r3 = new AsrDataSourceState("STARTED", 2);
        STARTED = r3;
        AsrDataSourceState r5 = new AsrDataSourceState("STOPPED", 3);
        STOPPED = r5;
        AsrDataSourceState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static AsrDataSourceState[] values() {
        return (AsrDataSourceState[]) a.clone();
    }

    public static AsrDataSourceState valueOf(String r1) {
        return (AsrDataSourceState) a.a(AsrDataSourceState.class, r1);
    }

    public AsrDataSourceState(String r1, int r2) {
        super(r1, r2);
    }
}

package com.larus.audio.call.arch;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/call/arch/LifecycleStage;", "", "<init>", "(Ljava/lang/String;I)V", "START", "RETRY", "BEFORE_STOP", "STOP", "PAUSE", "RESUME", "RELEASE", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum LifecycleStage extends Enum<LifecycleStage> {
    public static final LifecycleStage BEFORE_STOP = null;
    public static final LifecycleStage PAUSE = null;
    public static final LifecycleStage RELEASE = null;
    public static final LifecycleStage RESUME = null;
    public static final LifecycleStage RETRY = null;
    public static final LifecycleStage START = null;
    public static final LifecycleStage STOP = null;
    public static final /* synthetic */ LifecycleStage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<LifecycleStage> getEntries() {
        return b;
    }

    static {
        LifecycleStage r0 = new LifecycleStage("START", 0);
        START = r0;
        LifecycleStage r1 = new LifecycleStage("RETRY", 1);
        RETRY = r1;
        LifecycleStage r3 = new LifecycleStage("BEFORE_STOP", 2);
        BEFORE_STOP = r3;
        LifecycleStage r5 = new LifecycleStage("STOP", 3);
        STOP = r5;
        LifecycleStage r7 = new LifecycleStage("PAUSE", 4);
        PAUSE = r7;
        LifecycleStage r9 = new LifecycleStage("RESUME", 5);
        RESUME = r9;
        LifecycleStage r11 = new LifecycleStage("RELEASE", 6);
        RELEASE = r11;
        LifecycleStage[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static LifecycleStage[] values() {
        return (LifecycleStage[]) a.clone();
    }

    public static LifecycleStage valueOf(String r1) {
        return (LifecycleStage) r27.a.a(LifecycleStage.class, r1);
    }

    public LifecycleStage(String r1, int r2) {
        super(r1, r2);
    }
}

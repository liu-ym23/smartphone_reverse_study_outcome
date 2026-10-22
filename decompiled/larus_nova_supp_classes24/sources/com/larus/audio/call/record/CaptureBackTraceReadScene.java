package com.larus.audio.call.record;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/call/record/CaptureBackTraceReadScene;", "", "<init>", "(Ljava/lang/String;I)V", "REALTIME_CALL", "CONTINUOUS_TALK", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum CaptureBackTraceReadScene extends Enum<CaptureBackTraceReadScene> {
    public static final CaptureBackTraceReadScene CONTINUOUS_TALK = null;
    public static final CaptureBackTraceReadScene REALTIME_CALL = null;
    public static final /* synthetic */ CaptureBackTraceReadScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CaptureBackTraceReadScene> getEntries() {
        return b;
    }

    static {
        CaptureBackTraceReadScene r0 = new CaptureBackTraceReadScene("REALTIME_CALL", 0);
        REALTIME_CALL = r0;
        CaptureBackTraceReadScene r1 = new CaptureBackTraceReadScene("CONTINUOUS_TALK", 1);
        CONTINUOUS_TALK = r1;
        CaptureBackTraceReadScene[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static CaptureBackTraceReadScene[] values() {
        return (CaptureBackTraceReadScene[]) a.clone();
    }

    public static CaptureBackTraceReadScene valueOf(String r1) {
        return (CaptureBackTraceReadScene) r27.a.a(CaptureBackTraceReadScene.class, r1);
    }

    public CaptureBackTraceReadScene(String r1, int r2) {
        super(r1, r2);
    }
}

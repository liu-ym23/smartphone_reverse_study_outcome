package com.larus.voicecall.impl.component.dialog;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/voicecall/impl/component/dialog/RealtimeDialogTriggerTime;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "ON_CALL_STARTED", "ON_COMMON_AUDIO_CONFIG", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RealtimeDialogTriggerTime extends Enum<RealtimeDialogTriggerTime> {
    public static final RealtimeDialogTriggerTime ON_CALL_STARTED = null;
    public static final RealtimeDialogTriggerTime ON_COMMON_AUDIO_CONFIG = null;
    public static final /* synthetic */ RealtimeDialogTriggerTime[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RealtimeDialogTriggerTime> getEntries() {
        return b;
    }

    static {
        RealtimeDialogTriggerTime r0 = new RealtimeDialogTriggerTime("ON_CALL_STARTED", 0);
        ON_CALL_STARTED = r0;
        RealtimeDialogTriggerTime r1 = new RealtimeDialogTriggerTime("ON_COMMON_AUDIO_CONFIG", 1);
        ON_COMMON_AUDIO_CONFIG = r1;
        RealtimeDialogTriggerTime[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static RealtimeDialogTriggerTime[] values() {
        return (RealtimeDialogTriggerTime[]) a.clone();
    }

    public static RealtimeDialogTriggerTime valueOf(String r1) {
        return (RealtimeDialogTriggerTime) a.a(RealtimeDialogTriggerTime.class, r1);
    }

    public RealtimeDialogTriggerTime(String r1, int r2) {
        super(r1, r2);
    }
}

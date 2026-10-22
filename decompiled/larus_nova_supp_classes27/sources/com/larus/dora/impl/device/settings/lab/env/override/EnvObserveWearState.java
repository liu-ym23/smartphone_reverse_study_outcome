package com.larus.dora.impl.device.settings.lab.env.override;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/env/override/EnvObserveWearState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "WORN", "UNWORN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EnvObserveWearState extends Enum<EnvObserveWearState> {
    public static final EnvObserveWearState UNKNOWN = null;
    public static final EnvObserveWearState UNWORN = null;
    public static final EnvObserveWearState WORN = null;
    public static final /* synthetic */ EnvObserveWearState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<EnvObserveWearState> getEntries() {
        return b;
    }

    static {
        EnvObserveWearState r0 = new EnvObserveWearState("UNKNOWN", 0);
        UNKNOWN = r0;
        EnvObserveWearState r1 = new EnvObserveWearState("WORN", 1);
        WORN = r1;
        EnvObserveWearState r3 = new EnvObserveWearState("UNWORN", 2);
        UNWORN = r3;
        EnvObserveWearState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static EnvObserveWearState[] values() {
        return (EnvObserveWearState[]) a.clone();
    }

    public static EnvObserveWearState valueOf(String r1) {
        return (EnvObserveWearState) a.a(EnvObserveWearState.class, r1);
    }

    public EnvObserveWearState(String r1, int r2) {
        super(r1, r2);
    }
}

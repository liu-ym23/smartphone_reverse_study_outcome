package com.larus.dora.impl.device.settings.lab.env.override;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/env/override/EnvObserveOverrideChangeReason;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVATED", "EXPIRED", "CONNECTION", "USER_SETTING", "UNWORN_TIMEOUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EnvObserveOverrideChangeReason extends Enum<EnvObserveOverrideChangeReason> {
    public static final EnvObserveOverrideChangeReason ACTIVATED = null;
    public static final EnvObserveOverrideChangeReason CONNECTION = null;
    public static final EnvObserveOverrideChangeReason EXPIRED = null;
    public static final EnvObserveOverrideChangeReason UNWORN_TIMEOUT = null;
    public static final EnvObserveOverrideChangeReason USER_SETTING = null;
    public static final /* synthetic */ EnvObserveOverrideChangeReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<EnvObserveOverrideChangeReason> getEntries() {
        return b;
    }

    static {
        EnvObserveOverrideChangeReason r0 = new EnvObserveOverrideChangeReason("ACTIVATED", 0);
        ACTIVATED = r0;
        EnvObserveOverrideChangeReason r1 = new EnvObserveOverrideChangeReason("EXPIRED", 1);
        EXPIRED = r1;
        EnvObserveOverrideChangeReason r3 = new EnvObserveOverrideChangeReason("CONNECTION", 2);
        CONNECTION = r3;
        EnvObserveOverrideChangeReason r5 = new EnvObserveOverrideChangeReason("USER_SETTING", 3);
        USER_SETTING = r5;
        EnvObserveOverrideChangeReason r7 = new EnvObserveOverrideChangeReason("UNWORN_TIMEOUT", 4);
        UNWORN_TIMEOUT = r7;
        EnvObserveOverrideChangeReason[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static EnvObserveOverrideChangeReason[] values() {
        return (EnvObserveOverrideChangeReason[]) a.clone();
    }

    public static EnvObserveOverrideChangeReason valueOf(String r1) {
        return (EnvObserveOverrideChangeReason) a.a(EnvObserveOverrideChangeReason.class, r1);
    }

    public EnvObserveOverrideChangeReason(String r1, int r2) {
        super(r1, r2);
    }
}

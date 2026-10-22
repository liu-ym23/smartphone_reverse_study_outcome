package com.obric.assistant.state.impl.v2.power;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/assistant/state/impl/v2/power/ObricPowerManager$ForceReleasePowerLockReason;", "", "<init>", "(Ljava/lang/String;I)V", "ON_TIMEOUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricPowerManager$ForceReleasePowerLockReason extends Enum<ObricPowerManager$ForceReleasePowerLockReason> {
    public static final ObricPowerManager$ForceReleasePowerLockReason ON_TIMEOUT = null;
    public static final /* synthetic */ ObricPowerManager$ForceReleasePowerLockReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ObricPowerManager$ForceReleasePowerLockReason> getEntries() {
        return b;
    }

    static {
        ObricPowerManager$ForceReleasePowerLockReason r0 = new ObricPowerManager$ForceReleasePowerLockReason();
        ON_TIMEOUT = r0;
        ObricPowerManager$ForceReleasePowerLockReason[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public ObricPowerManager$ForceReleasePowerLockReason() {
        super("ON_TIMEOUT", 0);
    }

    public static ObricPowerManager$ForceReleasePowerLockReason[] values() {
        return (ObricPowerManager$ForceReleasePowerLockReason[]) a.clone();
    }

    public static ObricPowerManager$ForceReleasePowerLockReason valueOf(String r1) {
        return (ObricPowerManager$ForceReleasePowerLockReason) a.a(ObricPowerManager$ForceReleasePowerLockReason.class, r1);
    }
}

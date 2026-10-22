package com.larus.dora.impl.device.settings.lab.env;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/env/EnvObserveSettingAction;", "", "<init>", "(Ljava/lang/String;I)V", "ENV_SWITCH", "TIMER_SWITCH", "START_TIME", "END_TIME", "CONFIG_REFRESH", "APP_FOREGROUND", "SCENE_CHANGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EnvObserveSettingAction extends Enum<EnvObserveSettingAction> {
    public static final EnvObserveSettingAction APP_FOREGROUND = null;
    public static final EnvObserveSettingAction CONFIG_REFRESH = null;
    public static final EnvObserveSettingAction END_TIME = null;
    public static final EnvObserveSettingAction ENV_SWITCH = null;
    public static final EnvObserveSettingAction SCENE_CHANGE = null;
    public static final EnvObserveSettingAction START_TIME = null;
    public static final EnvObserveSettingAction TIMER_SWITCH = null;
    public static final /* synthetic */ EnvObserveSettingAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<EnvObserveSettingAction> getEntries() {
        return b;
    }

    static {
        EnvObserveSettingAction r0 = new EnvObserveSettingAction("ENV_SWITCH", 0);
        ENV_SWITCH = r0;
        EnvObserveSettingAction r1 = new EnvObserveSettingAction("TIMER_SWITCH", 1);
        TIMER_SWITCH = r1;
        EnvObserveSettingAction r3 = new EnvObserveSettingAction("START_TIME", 2);
        START_TIME = r3;
        EnvObserveSettingAction r5 = new EnvObserveSettingAction("END_TIME", 3);
        END_TIME = r5;
        EnvObserveSettingAction r7 = new EnvObserveSettingAction("CONFIG_REFRESH", 4);
        CONFIG_REFRESH = r7;
        EnvObserveSettingAction r9 = new EnvObserveSettingAction("APP_FOREGROUND", 5);
        APP_FOREGROUND = r9;
        EnvObserveSettingAction r11 = new EnvObserveSettingAction("SCENE_CHANGE", 6);
        SCENE_CHANGE = r11;
        EnvObserveSettingAction[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static EnvObserveSettingAction[] values() {
        return (EnvObserveSettingAction[]) a.clone();
    }

    public static EnvObserveSettingAction valueOf(String r1) {
        return (EnvObserveSettingAction) a.a(EnvObserveSettingAction.class, r1);
    }

    public EnvObserveSettingAction(String r1, int r2) {
        super(r1, r2);
    }
}

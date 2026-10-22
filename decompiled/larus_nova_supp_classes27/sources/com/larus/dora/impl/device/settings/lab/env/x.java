package com.larus.dora.impl.device.settings.lab.env;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class x {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[EnvObserveSettingAction.values().length];
            r0[EnvObserveSettingAction.ENV_SWITCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[EnvObserveSettingAction.TIMER_SWITCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[EnvObserveSettingAction.START_TIME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[EnvObserveSettingAction.END_TIME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[EnvObserveSettingAction.CONFIG_REFRESH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[EnvObserveSettingAction.APP_FOREGROUND.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[EnvObserveSettingAction.SCENE_CHANGE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    static {
    }
}

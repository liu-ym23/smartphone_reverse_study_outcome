package com.larus.dora.api.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface VUIWakeMode {
    public static final int COMPANION_BY_GESTURE = 7;
    public static final int COMPANION_BY_INITIATIVE = 6;
    public static final int EXPLORE = 5;
    public static final int INVALID = 0;
    public static final int KEY = 3;
    public static final int ONBOARDING = 4;
    public static final int RADIO = 2;
    public static final int SILENT_LAUNCH = 18;
    public static final int SIMUL_INTERPRET_GUI = 8;
    public static final int SIMUL_INTERPRET_TOUCH = 10;
    public static final int SIMUL_INTERPRET_VUI = 9;
    public static final int VOICE = 1;
}

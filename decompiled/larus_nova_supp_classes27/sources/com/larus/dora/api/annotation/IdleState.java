package com.larus.dora.api.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface IdleState {
    public static final int A2DP = 1;
    public static final int HFP = 2;
    public static final int IDLE = 0;
    public static final int TTS = 4;
}

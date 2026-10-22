package com.larus.dora.api.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface AncSetResult {
    public static final int ACK_SET_FAILED = 2;
    public static final int ALREADY_CURRENT_MODE = 3;
    public static final int COMMAND_TRANSMIT_FAILED = 1;
    public static final int SUCCESS = 0;
}

package com.larus.dora.api.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface FlowImageResult {
    public static final int LED_BLOCKED = 10;
    public static final int ROLE_SWITCH_FAIL = 2;
    public static final int ROLE_SWITCH_TIMEOUT = 8;
    public static final int SUCCESS = 1;
    public static final int TRANS_TIMEOUT = 9;
}

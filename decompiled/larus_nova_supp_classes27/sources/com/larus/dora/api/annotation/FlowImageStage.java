package com.larus.dora.api.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface FlowImageStage {
    public static final int IMAGE_START = 1;
    public static final int TRANS_FINISH = 3;
    public static final int TRANS_START = 2;
}

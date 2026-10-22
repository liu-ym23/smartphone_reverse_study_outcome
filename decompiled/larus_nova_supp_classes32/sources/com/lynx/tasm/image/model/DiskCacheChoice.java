package com.lynx.tasm.image.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface DiskCacheChoice {
    public static final int CUSTOM_DISK = 2;
    public static final int DEFAULT_DISK = 0;
    public static final int SMALL_DISK = 1;
}

package com.ss.android.lark.contact.base.entity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ContactOp {
    public static final int OPERATION_ADD = 1;
    public static final int OPERATION_DELETE = 2;
    public static final int OPERATION_UNKNOWN = 0;
    public static final int OPERATION_UPDATE = 3;
}

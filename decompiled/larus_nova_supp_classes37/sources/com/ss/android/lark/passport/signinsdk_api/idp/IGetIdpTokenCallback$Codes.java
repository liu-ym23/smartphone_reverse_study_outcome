package com.ss.android.lark.passport.signinsdk_api.idp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface IGetIdpTokenCallback$Codes {
    public static final int INVALID = 3;
    public static final int REFRESH_FAILED = 2;
    public static final int REFRESH_SUCCESS = 1;
    public static final int VALID = 0;
}

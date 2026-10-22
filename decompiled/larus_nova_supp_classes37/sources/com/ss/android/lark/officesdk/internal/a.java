package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.officesdk.api.IUserManager;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime;
import com.ss.android.lark.officesdk.api.init.OfficeSDKInitConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a {
    void a(OfficeSDKInitConfig r1);

    void b(IOfficeSDKRuntime r1);

    IUserManager getUserManager();
}

package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import android.app.Activity;
import android.app.Application;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e implements ntb.e {
    public e() {
    }

    @Override // ntb.e
    public final Activity getTopActivity() {
        return AppLifecycle.a.a.f();
    }

    @Override // ntb.e
    public final Application getApplication() {
        return LarkContext.getApplication();
    }
}

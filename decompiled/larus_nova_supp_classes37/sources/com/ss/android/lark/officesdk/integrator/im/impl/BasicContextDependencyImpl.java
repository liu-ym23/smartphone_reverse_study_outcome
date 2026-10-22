package com.ss.android.lark.officesdk.integrator.im.impl;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@ClaymoreImpl(pmb.a.class)
public class BasicContextDependencyImpl implements pmb.a {
    public BasicContextDependencyImpl() {
    }

    public Context getContext() {
        return LarkContext.getApplication();
    }

    public boolean isUsPackage() {
        return LarkAppContext.inst().buildConfig().isUsPackage();
    }
}

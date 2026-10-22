package com.ss.android.lark.integrator.ccm.dependency.di;

import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.image.ImageModule;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class w implements com.bytedance.ee.bear.lark.dependency.o {
    public w() {
    }

    public final void a(wb5.e r9, final UIGetDataCallback r10) {
        new ImageModule().b(r9.getContext(), r9.b, r9.c, true, r9.d, r9.e, new ImageDependencyImpl$1(this, r10));
    }
}

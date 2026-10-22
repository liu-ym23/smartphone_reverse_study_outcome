package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    TextInputLayout f4166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Context f4167b;
    CheckableImageButton c;
    final int d;

    d(TextInputLayout r4, int r5) {
        this.f4166a = r4;
        this.f4167b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.c = r4.getEndIconView();
        this.d = r5;
    }

    abstract void a();

    void a(boolean r1) {
    }

    boolean a(int r1) {
        return true;
    }

    boolean b() {
        return false;
    }
}

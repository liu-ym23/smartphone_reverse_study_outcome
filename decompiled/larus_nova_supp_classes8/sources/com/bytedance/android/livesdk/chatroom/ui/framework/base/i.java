package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class i {
    public a a;

    public i() {
    }

    public void f() {
    }

    public void g(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
    }

    public void h() {
    }

    public void i(Dialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
    }

    public void l() {
    }

    public void m() {
    }

    public void n() {
    }

    public void o() {
    }

    public void onDestroy() {
    }

    public void p() {
    }

    public void q() {
    }

    public void r(View r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    public final a getContext() {
        a r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L5:
        return r0;
    }
}

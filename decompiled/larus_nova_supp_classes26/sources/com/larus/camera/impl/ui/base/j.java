package com.larus.camera.impl.ui.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.utils.w0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class j extends com.larus.camera.impl.ui.arch.b {
    public j() {
        com.larus.camera.impl.ui.arch.c r0 = com.larus.camera.impl.ui.arch.c.a;
        super(80, com.larus.camera.impl.ui.arch.c.c);
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r2) {
        CameraContainer.b r3 = super.f(r2);
        ((FrameLayout.LayoutParams) r3).width = -1;
        ((FrameLayout.LayoutParams) r3).height = -1;
        return r3;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return r3.inflate(2131562908, r4, false);
    }

    public final void p(int r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        View r0 = h(2131377773);
        ImageView r1 = (ImageView) r0;
        w0.e(r1, r3);
        r1.setBackgroundColor(0);
        r4.invoke(r0);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.camera.impl.ui.base.h, java.lang.Object] */
    public static void q(j r2, int r3, int r4) {
        ?? r0 = new h();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "config");
        View r5 = r2.h(2131377775);
        FrameLayout r1 = (FrameLayout) r5;
        w0.e(r1, r3);
        r1.setBackgroundColor(r4);
        r0.invoke(r5);
    }
}

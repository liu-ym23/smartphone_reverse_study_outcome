package com.larus.camera.impl.ui.component.capture.scan;

import android.view.ViewGroup;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.component.capture.CaptureTitleComponent;
import com.larus.utils.i0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h extends CaptureTitleComponent {
    public final List<String> n;

    public h() {
        List<String> r0 = fx8.a.a;
        this.n = fx8.a.b;
    }

    @Override // com.larus.camera.impl.ui.component.capture.CaptureTitleComponent, com.larus.camera.impl.ui.arch.b
    public final void m() {
        super.m();
        q(new g());
    }

    @Override // com.larus.camera.impl.ui.component.capture.CaptureTitleComponent, com.larus.camera.impl.ui.component.capture.a
    public final List<String> d() {
        return this.n;
    }

    @Override // com.larus.camera.impl.ui.base.k, com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r2) {
        CameraContainer.b r3 = super.f(r2);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        i0.a.getClass();
        ((ViewGroup.MarginLayoutParams) r3).topMargin = i0.g();
        return r3;
    }
}

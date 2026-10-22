package com.larus.camera.impl.ui.component.result.inputtable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.arch.c;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ResultInputtableControlComponent extends com.larus.camera.impl.ui.arch.b {
    public ResultInputControlBinder m;

    public static final class a {
    }

    static {
    }

    public ResultInputtableControlComponent() {
        c r0 = c.a;
        super(80, c.c);
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        CameraResultViewModel r0 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        ResultInputControlBinder r1 = this.m;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("inputBinder");
        r1 = null;
    L8:
        final i1<Boolean> r2 = r0.isInCropMode();
        r1.b(new ResultInputtableControlComponent$onViewCreated$$inlined$map$1(r2));
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void n() {
        ResultInputControlBinder r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputBinder");
        r0 = null;
    L5:
        CameraResultViewModel r1 = (CameraResultViewModel) r0.c.invoke();
        if (r1 == null) goto L9;
        r1.enableFreeInputMode(false);
        return;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r3) {
        ResultInputControlBinder r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputBinder");
        r0 = null;
    L5:
        CameraContainer.b r4 = super.f(r3);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "layoutParams");
        return r0.d().d(r4);
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        Intrinsics.checkNotNullParameter(r6, "parent");
        ResultInputControlBinder r0 = new ResultInputControlBinder(r6.getContext(), k(), new b(this));
        this.m = r0;
        return r0.c(r5, r6, r6);
    }
}

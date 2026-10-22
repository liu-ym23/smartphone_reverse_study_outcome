package com.larus.camera.impl.ui.component.result.general;

import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class ResultControlComponent extends com.larus.camera.impl.ui.base.j {
    public static final /* synthetic */ int n = 0;
    public final ResultConfirmControlStyle m;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        CameraResultViewModel r0 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        new f(j(), getContext(), k(), r(), new g(this)).a();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.isInCropMode(), new ResultControlComponent$onViewCreated$2(this, null)), k());
    }

    public ResultControlComponent() {
        this.m = ResultConfirmControlStyle.GENERAL;
    }

    public ResultConfirmControlStyle r() {
        return this.m;
    }
}

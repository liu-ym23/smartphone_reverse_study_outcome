package com.larus.camera.impl.ui.component.result.edu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.larus.camera.impl.ui.component.result.general.ResultPreviewComponent;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.camera.impl.utils.u;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import nx8.i;
import nx8.l;
import nx8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class EduHomeworkResultPreviewComponent extends ResultPreviewComponent {
    public static final /* synthetic */ int B = 0;
    public m A;

    @Override // com.larus.camera.impl.ui.component.result.general.ResultPreviewComponent, com.larus.camera.impl.ui.arch.b
    public final void m() {
        super.m();
        CameraResultViewModel r2 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r2 != null) goto L5;
        return;
    L5:
        m r0 = this.A;
        if (r0 == null) goto L8;
        r2.updateEduImageAbility(r0);
    L8:
        String r4 = r2.getParamAlbumUrl();
        int r5 = r2.getParamOrientation();
        BuildersKt.launch$default(k(), null, null, new EduHomeworkResultPreviewComponent$onViewCreated$2(r2, this, r4, r5, null), 3, null);
    }

    @Override // com.larus.camera.impl.ui.component.result.general.ResultPreviewComponent, com.larus.camera.impl.ui.arch.b
    public final void n() {
        super.n();
        m r0 = this.A;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public EduHomeworkResultPreviewComponent() {
    }

    @Override // com.larus.camera.impl.ui.component.result.general.ResultPreviewComponent, com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        View r6 = super.g(r4, r5);
        u.a();
        com.larus.camera.impl.edulibs.camera.a r0 = com.larus.camera.impl.edulibs.camera.a.a;
        this.A = l.a(r4.getContext(), i.c.d, null, 12);
        return r6;
    }
}

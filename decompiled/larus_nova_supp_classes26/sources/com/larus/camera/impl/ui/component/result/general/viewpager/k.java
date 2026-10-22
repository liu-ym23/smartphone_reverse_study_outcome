package com.larus.camera.impl.ui.component.result.general.viewpager;

import com.larus.bmhome.view.markableview.MarkableImageView;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k implements MarkableImageView.b {
    public final /* synthetic */ MarkableImageFragment a;
    public final /* synthetic */ MarkableImageView b;

    @Override // com.larus.bmhome.view.markableview.MarkableImageView.b
    public final void a() {
        this.a.T90().updateCurrentMarkedMaskBitmap(this.b.getPathBitmap());
    }

    @Override // com.larus.bmhome.view.markableview.MarkableImageView.b
    public final void b() {
        this.a.T90().updateCurrentMarkedMaskBitmap(this.b.getPathBitmap());
        CameraResultViewModel.clickButton$default(this.a.T90(), "mark", "camera_confirm", null, 4, null);
    }

    @Override // com.larus.bmhome.view.markableview.MarkableImageView.b
    public final void c() {
        this.a.T90().updateCurrentMarkedMaskBitmap(this.b.getPathBitmap());
    }

    public k(MarkableImageFragment r1, MarkableImageView r2) {
        this.a = r1;
        this.b = r2;
    }
}

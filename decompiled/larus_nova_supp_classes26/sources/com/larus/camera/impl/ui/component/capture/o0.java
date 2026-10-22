package com.larus.camera.impl.ui.component.capture;

import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o0 extends com.larus.camera.impl.widget.q {
    public final /* synthetic */ CaptureControlComponent a;

    @Override // com.larus.camera.impl.widget.q, com.larus.camera.impl.widget.p
    public final void a() {
        CameraCaptureViewModel r0 = (CameraCaptureViewModel) com.larus.camera.impl.ui.arch.b.e(this.a).a();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.tryChangeAlbumThumbListState(true);
        r0.clickCameraButtonOnCapturePage("above_album_icon_arrow", "drag_open_album");
        r0.clickUploadEntrance("camera_album_thumbnail_click", "camera_album_thumbnail_click");
    }

    public o0(CaptureControlComponent r1) {
        this.a = r1;
    }
}

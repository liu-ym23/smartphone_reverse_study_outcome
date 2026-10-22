package com.larus.camera.impl.utils.album;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.utils.CameraData;
import com.larus.platform.api.a0;
import com.larus.platform.api.b0;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.service.k2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l implements b0 {
    public final /* synthetic */ CameraCaptureViewModel a;
    public final /* synthetic */ Function0<Unit> b;
    public final /* synthetic */ Context c;

    public final void a(int r1) {
    }

    public final void c() {
    }

    public final void b() {
        this.b.invoke();
    }

    public final boolean d() {
        return !this.a.isCurrentInRecording();
    }

    public final void f() {
        if (this.a.shouldReturnToExistingAlbum() == false) goto L6;
        this.a.openAlbum(this.c);
        return;
    L6:
        this.a.clickCameraButtonOnCapturePage("camera_bottom_arrow", "drag_open_album");
        this.a.clickUploadEntrance("camera_slide_album_click", "camera_slide_album_click");
    }

    public final void onPageShow() {
        WeakReference<a0> r1 = m.a;
        CameraCaptureViewModel r2 = this.a;
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        CameraData r3 = r2.getCameraData();
        if (r3.getEnableCameraAlbumQuickInput() == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L21;
        List<AttachmentSnapshot> r5 = e.b();
        if (((ArrayList) r5).isEmpty() == true) goto L21;
        Fragment r6 = r2.getCurrentFragment();
        if (r6 == null) goto L21;
        FragmentManager r7 = r6.getChildFragmentManager();
        if (r7 == null) goto L21;
        a0 r8 = m.a(r7);
        if (r8 == null) goto L21;
        r8.RU(r5);
    L21:
        this.a.leaveCapturePage("camera_slide_album_click");
        this.a.enterPage("album", "camera_slide_album_click", "camera");
        ICameraEventExt r9 = this.a.getCameraData().getEventExt();
        k2 r10 = k2.a;
        if (r9 == null) goto L27;
        String r11 = r9.getBotId();
        if (r11 == null) goto L27;
        String r12 = r11;
    L28:
        if (r9 == null) goto L33;
        String r13 = r9.getConversationId();
        if (r13 == null) goto L33;
        String r14 = r13;
    L34:
        if (r9 == null) goto L38;
        Integer r15 = r9.getBotConversationType();
        if (r15 == null) goto L38;
        int r16 = r15.intValue();
    L39:
        if (r9 == null) goto L44;
        String r17 = r9.getChatType();
        if (r17 == null) goto L44;
        String r18 = r17;
    L46:
        if (r9 == null) goto L48;
        String r19 = r9.referenceFromType();
    L49:
        if (r9 == null) goto L51;
        String r110 = r9.referenceMessageId();
    L52:
        r10.p(new kq9.e(r12, r14, r16, r18, "camera", "camera_slide_album_click", r19, r110, null, null, null, null, 3840));
        return;
    L51:
        r110 = null;
        goto L52
    L48:
        r19 = null;
    L44:
        r18 = "";
    L38:
        r16 = 0;
    L33:
        r14 = "";
    L27:
        r12 = "";
        goto L28
    L5:
        if (m.b(r3) == true) goto L7;
        r4 = true;
        goto L8
    }

    public final void e(int r2) {
        this.a.updatePhotoPickerPageSlideOffset(r2);
    }

    public l(CameraCaptureViewModel r1, com.larus.camera.impl.ui.fragment.a r2, FragmentActivity r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

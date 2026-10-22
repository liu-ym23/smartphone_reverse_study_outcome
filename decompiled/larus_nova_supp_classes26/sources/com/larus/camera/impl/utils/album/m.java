package com.larus.camera.impl.utils.album;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.utils.CameraData;
import com.larus.platform.api.a0;
import com.larus.platform.model.MediaPickerUIMode;
import com.larus.platform.model.album.AlbumInputState;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.platform.model.preview.MediaEntry;
import com.larus.platform.service.k2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import hq9.b0;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m {
    public static WeakReference<a0> a;
    public static boolean b;
    public static boolean c;

    static {
    }

    public static a0 a(FragmentManager r2) {
        WeakReference<a0> r0 = a;
        if (r0 == null) goto L5;
        a0 r1 = r0.get();
    L6:
        if (r1 == null) goto L11;
        WeakReference<a0> r3 = a;
        if (r3 != null) goto L10;
        return null;
    L10:
        return r3.get();
    L11:
        a0 r4 = r2.findFragmentByTag("camera_bottom_album_fragment");
        if (r4 != null) goto L14;
    L17:
        return null;
    L14:
        if ((r4 instanceof a0) == false) goto L17;
        a = new WeakReference(r4);
        return r4;
    L5:
        r1 = null;
        goto L6
    }

    public static boolean b(CameraData r3) {
        String r0 = r3.getAlbumInputSnapshotId();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L13;
        dr9.g r2 = dr9.g.a;
        if (dr9.g.d(r3.getAlbumInputSnapshotId()) != null) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static void c(final FragmentActivity r33, final CameraCaptureViewModel r34, com.larus.camera.impl.ui.fragment.a r35) {
        Intrinsics.checkNotNullParameter(r33, "context");
        Intrinsics.checkNotNullParameter(r34, "viewModel");
        Intrinsics.checkNotNullParameter(r35, "onPageSlideWithoutPermission");
        Fragment r3 = r34.getCurrentFragment();
        if (r3 == null) goto L74;
        final FragmentManager r4 = r3.getChildFragmentManager();
        if (r4 == null) goto L75;
        Fragment r5 = r4.findFragmentByTag("camera_bottom_album_fragment");
        FragmentTransaction r6 = r4.beginTransaction();
        if (r5 == null) goto L10;
        r6.remove(r5);
        FLogger.a.i("ShowBottomPhotoPickerPageManager", "showPage remove existing BottomPhotoPickerFragment=" + r5.hashCode());
    L10:
        final Ref.LongRef r7 = new Ref.LongRef();
        CameraData r8 = r34.getCameraData();
        boolean r10 = true;
        int r11 = 0;
        if (r8.getEnableCameraAlbumQuickInput() == true) goto L13;
    L15:
        boolean r9 = false;
    L16:
        c = r34.isSupportMultiPick();
        int r12 = r34.getBottomAlbumMaxCount();
        k2 r13 = k2.a;
        AlbumSettingConfig.a r14 = new AlbumSettingConfig.a();
        r14.g = Integer.valueOf(ContextCompat.getColor(r33, 2131103292));
        r14.i = zx8.b.b();
        r14.d = r12;
        if (c == true) goto L19;
    L21:
        boolean r15 = false;
    L22:
        r14.c = r15;
        r14.x = r34.getCameraData().getAlbumSupportOriginalImage();
        r14.k = r9;
        if (r9 == true) goto L25;
        AlbumInputState r16 = null;
    L28:
        r14.b(r16);
        String r17 = r34.returnExistingAlbumNodeId();
        if (r17 != null) goto L31;
        r17 = "";
    L31:
        r14.b = r17;
        CameraData r18 = r34.getCameraData();
        if (r18.getEnableCameraAlbumUnifiedPreview() == true) goto L34;
    L36:
        boolean r19 = false;
    L37:
        r14.m = r19;
        r14.o = Boolean.valueOf(r34.getCameraData().getUseUnifiedMediaCanvas());
        if (r34.getCameraData().getMobilePreviewHostEnabled() == true) goto L40;
    L42:
        r10 = false;
    L43:
        r14.n = r10;
        r14.c(MediaEntry.CAMERA_ALBUM);
        r14.q = r9;
        AlbumSettingConfig r110 = r14.a();
        ICameraEventExt r20 = r34.getCameraData().getEventExt();
        if (r20 == null) goto L46;
        String r21 = r20.getBotId();
    L47:
        ICameraEventExt r22 = r34.getCameraData().getEventExt();
        if (r22 == null) goto L50;
        String r23 = r22.getConversationId();
    L51:
        ICameraEventExt r24 = r34.getCameraData().getEventExt();
        if (r24 == null) goto L56;
        Integer r25 = r24.getBotConversationType();
        if (r25 == null) goto L56;
        int r26 = r25.intValue();
    L57:
        ICameraEventExt r27 = r34.getCameraData().getEventExt();
        if (r27 == null) goto L60;
        String r28 = r27.getChatType();
    L61:
        kq9.e r29 = new kq9.e(r21, r23, r26, r28, "camera", "camera_slide_album_click", null, null, null, null, null, null, 4032);
        l r30 = new l(r34, r35, r33);
        a0 r0 = r13.f(new b0(new g(r34, r33, r4), r110, "album_display", new h(), 0, r29, new i(), new j(r7, r34, r33), MediaPickerUIMode.INVISIBLE_BOTTOM_SHEET, r30, 122885));
        if (r0 == null) goto L68;
        Fragment r1 = r0.od();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "camera_bottom_album_fragment", 0) == true) goto L67;
        r6.add(r1, "camera_bottom_album_fragment");
    L67:
        a0 r31 = r0;
    L69:
        a = new WeakReference(r31);
        FLogger r2 = FLogger.a;
        StringBuilder r32 = new StringBuilder("showPage add&show BottomPhotoPickerFragment=");
        WeakReference<a0> r36 = a;
        if (r36 == null) goto L72;
        r11 = r36.hashCode();
    L72:
        r32.append(r11);
        r2.i("ShowBottomPhotoPickerPageManager", r32.toString());
        r6.commitNowAllowingStateLoss();
        return;
    L68:
        r31 = null;
        goto L69
    L60:
        r28 = null;
    L56:
        r26 = 0;
        goto L57
    L50:
        r23 = null;
        goto L51
    L46:
        r21 = null;
        goto L47
    L40:
        if (b(r34.getCameraData()) == true) goto L42;
    L34:
        if (b(r18) == true) goto L36;
        r19 = true;
        goto L37
    L25:
        r16 = e.a(r34.getCameraData());
        if (r16 != null) goto L28;
        FLogger.a.e("ShowBottomPhotoPickerPageManager", "cameraAlbumInputState rejected unavailable snapshot");
        goto L28
    L19:
        if (r12 == (-1)) goto L21;
        r15 = true;
        goto L22
    L13:
        if (b(r8) == true) goto L15;
        r9 = true;
        goto L16
    L75:
        return;
    }
}

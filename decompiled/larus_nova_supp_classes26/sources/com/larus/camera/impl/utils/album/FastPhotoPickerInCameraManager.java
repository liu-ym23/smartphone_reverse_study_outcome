package com.larus.camera.impl.utils.album;

import android.content.Context;
import com.larus.camera.contract.CameraServiceDiffContract;
import com.larus.home.impl.sdk.c1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.g3;
import com.larus.platform.model.album.FastSendFromCameraScene;
import com.larus.platform.service.k2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kq9.o;
import kq9.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class FastPhotoPickerInCameraManager {
    public static final FastPhotoPickerInCameraManager a = null;
    public static final Lazy b = null;
    public static boolean c;

    public FastPhotoPickerInCameraManager() {
    }

    static {
        a = new FastPhotoPickerInCameraManager();
        b = LazyKt.lazy(new f());
    }

    public static q a() {
        return (q) b.getValue();
    }

    public static boolean c(String r7) {
        Intrinsics.checkNotNullParameter(r7, "conversationId");
        CameraServiceDiffContract r0 = CameraServiceDiffContract.b;
        Boolean r1 = r0.isHideSlideAlbumEntrance();
        Boolean r2 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r2) == false) goto L5;
        return false;
    L5:
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L10;
        r3.S();
        if (c1.a.a() != true) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        return false;
    L13:
        FLogger.a.i("FastSendImageInCameraManager", "isFastSendInCameraBottom conversationId=" + r7 + " bottomScene=" + a().b);
        if (Intrinsics.areEqual(r0.isHideSlideAlbumEntrance(), r2) == false) goto L16;
        return false;
    L16:
        int r5 = a().b;
        if (r5 != FastSendFromCameraScene.DEFAULT.getScene()) goto L20;
        return false;
    L20:
        if (r5 != FastSendFromCameraScene.MAIN_BOT.getScene()) goto L24;
        return com.larus.bmhome.utils.i.g(r7);
    L24:
        if (r5 != FastSendFromCameraScene.OTHER_BOT.getScene()) goto L28;
        return !com.larus.bmhome.utils.i.g(r7);
    L28:
        if (r5 != FastSendFromCameraScene.ALL.getScene()) goto L30;
        return true;
    L30:
        return false;
    L10:
        r4 = false;
        goto L11
    }

    public final Object b(Context r7, String r8, String r9, Continuation<? super Boolean> r10) {
        if ((r10 instanceof FastPhotoPickerInCameraManager$isFromAlbumThumb$1) == false) goto L7;
        FastPhotoPickerInCameraManager$isFromAlbumThumb$1 r0 = (FastPhotoPickerInCameraManager$isFromAlbumThumb$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L31:
        if (((Boolean) r11).booleanValue() == true) goto L34;
        FLogger.a.i("FastSendImageInCameraManager", "isFromAlbumThumb no images");
        return Boxing.boxBoolean(false);
    L34:
        o r12 = a().c;
        if (r12 == null) goto L37;
        int r13 = r12.c;
    L38:
        if (r13 > 0) goto L41;
        FLogger.a.i("FastSendImageInCameraManager", "isFromAlbumThumb showCount 0");
        return Boxing.boxBoolean(false);
    L41:
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("isFastSendFromAlbumThumb conversationId=");
        r15.append(r8);
        r15.append(" scene=");
        Integer r4 = null;
        if (r12 == null) goto L44;
        Integer r5 = Boxing.boxInt(r12.a);
    L45:
        r15.append(r5);
        r14.i("FastSendImageInCameraManager", r15.toString());
        if (r12 == null) goto L48;
        r4 = Boxing.boxInt(r12.a);
    L48:
        int r16 = FastSendFromCameraScene.DEFAULT.getScene();
        if (r4 != null) goto L52;
    L55:
        int r17 = FastSendFromCameraScene.MAIN_BOT.getScene();
        if (r4 != null) goto L59;
    L62:
        int r18 = FastSendFromCameraScene.OTHER_BOT.getScene();
        if (r4 != null) goto L66;
    L69:
        int r19 = FastSendFromCameraScene.ALL.getScene();
        if (r4 == null) goto L77;
        if (r4.intValue() != r19) goto L77;
        return Boxing.boxBoolean(true);
    L77:
        return Boxing.boxBoolean(false);
    L66:
        if (r4.intValue() != r18) goto L69;
        return Boxing.boxBoolean(!com.larus.bmhome.utils.i.g(r8));
    L59:
        if (r4.intValue() != r17) goto L62;
        return Boxing.boxBoolean(com.larus.bmhome.utils.i.g(r8));
    L52:
        if (r4.intValue() != r16) goto L55;
        return Boxing.boxBoolean(false);
    L44:
        r5 = null;
        goto L45
    L37:
        r13 = 0;
        goto L38
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        if (Intrinsics.areEqual(r9, "chat_action_bar") == false) goto L18;
        FLogger.a.i("FastSendImageInCameraManager", "isFromAlbumThumb click action_bar");
        return Boxing.boxBoolean(false);
    L18:
        k2 r20 = k2.a;
        if (g3.a.e() == false) goto L21;
    L23:
        boolean r21 = false;
    L24:
        if (r21 == true) goto L27;
        FLogger.a.i("FastSendImageInCameraManager", "isFromAlbumThumb no permission");
        return Boxing.boxBoolean(false);
    L27:
        AlbumThumbListManager r22 = AlbumThumbListManager.a;
        r0.L$0 = r8;
        r0.label = 1;
        r11 = r22.b(r7, r0);
        if (r11 != r2) goto L31;
        return r2;
    L21:
        if (g3.a.d() == false) goto L23;
        r21 = true;
    L7:
        r0 = new FastPhotoPickerInCameraManager$isFromAlbumThumb$1(this, r10);
        goto L8
    }
}

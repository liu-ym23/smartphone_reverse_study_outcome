package com.larus.camera.impl.starter;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.InputParamExtra;
import com.larus.camera.impl.ui.activity.CameraCaptureActivity;
import com.larus.camera.impl.ui.activity.CameraCaptureNestedActivity;
import com.larus.utils.logger.FLogger;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ CameraStarter a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ Fragment c;
    public final /* synthetic */ Fragment d;

    public /* synthetic */ n(CameraStarter r1, FragmentActivity r2, Fragment r3, Fragment r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraStarter r0 = this.a;
        FragmentActivity r1 = this.b;
        Fragment r2 = this.c;
        Fragment r3 = this.d;
        CameraStarter.Companion r4 = CameraStarter.h;
        r0.getClass();
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L48
        Bundle r8 = r0.getArguments();     // Catch: Throwable -> L48
        if (r8 == null) goto L6;
        Serializable r9 = r8.getSerializable("STARTER_INPUT_PARAM");     // Catch: Throwable -> L48
    L8:
        if ((r9 instanceof InputParam) == false) goto L10;
        InputParam r10 = (InputParam) r9;     // Catch: Throwable -> L48
    L11:
        Bundle r11 = r0.getArguments();     // Catch: Throwable -> L48
        if (r11 == null) goto L15;
        String r12 = r11.getString("SUGGESTION_PREFIX");     // Catch: Throwable -> L48
    L16:
        Bundle r13 = r0.getArguments();     // Catch: Throwable -> L48
        if (r13 == null) goto L20;
        boolean r14 = r13.getBoolean("SHOW_BOTTOM_ALBUM");     // Catch: Throwable -> L48
    L21:
        FLogger.a.i("CameraStarter", "startCamera, param:" + r10 + ", suggestionPrefix:" + r12 + ", showBottomAlbum:" + r14);     // Catch: Throwable -> L48
        if (r10 == null) goto L26;
        InputParamExtra r5 = r10.getExtra();     // Catch: Throwable -> L48
        if (r5 == null) goto L26;
        String r6 = (String) r5.get("EXTRA_FORCE_NEW_CAPTURE_ACTIVITY");     // Catch: Throwable -> L48
    L27:
        boolean r15 = Intrinsics.areEqual(r6, "true");     // Catch: Throwable -> L48
        if (r15 == false) goto L30;
        Class<CameraCaptureNestedActivity> r16 = CameraCaptureNestedActivity.class;
    L31:
        Intent r17 = new Intent(r1, r16);     // Catch: Throwable -> L48
        r17.putExtra("CAMERA_INPUT_PARAM", r10);     // Catch: Throwable -> L48
        if (r12 == null) goto L34;
        r17.putExtra("SUGGESTION_PREFIX", r12);     // Catch: Throwable -> L48
    L34:
        r17.putExtra("SHOW_BOTTOM_ALBUM", r14);     // Catch: Throwable -> L48
        if (r15 == false) goto L37;
        r17.putExtra("EXTRA_LAUNCHED_FROM_RESULT", true);     // Catch: Throwable -> L48
    L37:
        r17.setFlags(r17.getFlags() & (-33554433));     // Catch: Throwable -> L48
        if (r2 == null) goto L40;
        r0.f = new WeakReference(r2);     // Catch: Throwable -> L48
    L40:
        if (r3 == null) goto L42;
        r0.g = new WeakReference(r3);     // Catch: Throwable -> L48
    L42:
        ActivityResultLauncher<Intent> r18 = r0.e;     // Catch: Throwable -> L48
        if (r18 == null) goto L45;
        r18.launch(r17);     // Catch: Throwable -> L48
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L48
    L46:
        Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L48
    L50:
        Throwable r21 = Result.exceptionOrNull-impl(r20);
        if (r21 == null) goto L56;
        FLogger.a.e("CameraStarter", "startCamera error", r21);
        r0.S90(null);
        return;
    L56:
        return;
    L45:
        r19 = null;
        goto L46
    L30:
        r16 = CameraCaptureActivity.class;
    L26:
        r6 = null;
        goto L27
    L20:
        r14 = false;
        goto L21
    L15:
        r12 = null;
        goto L16
    L10:
        r10 = null;
        goto L11
    L6:
        r9 = null;
    L48:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    }
}

package com.bytedance.bpea.entry.api.camera;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import f06.c;
import fna.g;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class Camera2Entry$Companion$openCamera$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CameraDevice.StateCallback $callback;
    final /* synthetic */ String $cameraId;
    final /* synthetic */ Executor $executor;
    final /* synthetic */ CameraManager $this_openCamera;

    public Camera2Entry$Companion$openCamera$2(CameraManager r1, String r2, Executor r3, CameraDevice.StateCallback r4) {
        this.$this_openCamera = r1;
        this.$cameraId = r2;
        this.$executor = r3;
        this.$callback = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1563invoke() {
        INVOKEVIRTUAL_com_bytedance_bpea_entry_api_camera_Camera2Entry$Companion$openCamera$2_com_obric_performance_power_monitor_camera_CameraLancet_openCamera(this.$this_openCamera, this.$cameraId, this.$executor, this.$callback);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1563invoke();
        return Unit.INSTANCE;
    }

    public static void INVOKEVIRTUAL_com_bytedance_bpea_entry_api_camera_Camera2Entry$Companion$openCamera$2_com_obric_performance_power_monitor_camera_CameraLancet_openCamera(CameraManager r1, String r2, Executor r3, CameraDevice.StateCallback r4) throws CameraAccessException {
        if (g.d() == true) goto L6;
        a(r1, r2, r3, r4);
        return;
    L6:
        a(r1, r2, r3, r4);
        jna.a.b(r2);
    }

    public static void a(CameraManager r11, String r12, Executor r13, CameraDevice.StateCallback r14) throws CameraAccessException {
        c r8 = new c();
        Object[] r9 = {r12, r13, r14};
        f06.b r10 = new f06.b();
        if (r8.b(100206, "android/hardware/camera2/CameraManager", "openCamera", r11, r9, "void", r10).a == false) goto L6;
        r8.a(100206, "android/hardware/camera2/CameraManager", "openCamera", r11, r9, null, r10, false);
        return;
    L6:
        r11.openCamera(r12, r13, r14);
        r8.a(100206, "android/hardware/camera2/CameraManager", "openCamera", r11, r9, null, r10, true);
    }
}

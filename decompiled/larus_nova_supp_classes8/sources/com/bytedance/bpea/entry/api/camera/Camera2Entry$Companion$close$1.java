package com.bytedance.bpea.entry.api.camera;

import android.hardware.camera2.CameraDevice;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import f06.c;
import fna.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class Camera2Entry$Companion$close$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CameraDevice $this_close;

    public Camera2Entry$Companion$close$1(CameraDevice r1) {
        this.$this_close = r1;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1561invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1561invoke() {
        INVOKEVIRTUAL_com_bytedance_bpea_entry_api_camera_Camera2Entry$Companion$close$1_com_obric_performance_power_monitor_camera_CameraLancet_close(this.$this_close);
    }

    public static void INVOKEVIRTUAL_com_bytedance_bpea_entry_api_camera_Camera2Entry$Companion$close$1_com_obric_performance_power_monitor_camera_CameraLancet_close(CameraDevice r1) {
        if (g.d() == true) goto L6;
        a(r1);
        return;
    L6:
        a(r1);
        if ((r1 instanceof CameraDevice) == false) goto L10;
        jna.a.a(r1.getId());
        return;
    }

    public static void a(CameraDevice r12) {
        c r8 = new c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        if (r8.b(100201, "android/hardware/camera2/CameraDevice", "close", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100201, "android/hardware/camera2/CameraDevice", "close", r12, r9, null, r10, false);
        return;
    L6:
        r12.close();
        r8.a(100201, "android/hardware/camera2/CameraDevice", "close", r12, r9, null, r10, true);
    }
}

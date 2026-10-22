package com.larus.platform.service;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.c4;
import com.larus.platform.model.camera.ve.VeCameraInputParam;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o3 implements c4 {
    public static final o3 b = null;

    static {
        b = new o3();
    }

    public o3() {
    }

    public final void c() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L6;
        r0.n();
        i2a.b.b.c();
        return;
    }

    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "identifier");
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L6;
        r0.n();
        i2a.b.b.b(r3);
        return;
    }

    public final Map<String, String> e(String r3) {
        Intrinsics.checkNotNullParameter(r3, "srcPath");
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L5;
        r0.n();
        return i2a.b.b.f(r3);
    L5:
        return null;
    }

    @Override // com.larus.platform.api.c4
    public final void a(Integer r3, long r4) {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L6;
        r0.n();
        i2a.b.b.a(r3, r4);
        return;
    }

    public final pq9.j d(FragmentActivity r3, VeCameraInputParam r4) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "param");
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L5;
        r0.n();
        return i2a.b.b.d(r3, r4);
    L5:
        return null;
    }

    public final void f(Bitmap r3, CameraCaptureViewModel.f r4) {
        Intrinsics.checkNotNullParameter(r3, "bitmap");
        Intrinsics.checkNotNullParameter(r4, "callback");
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L6;
        r0.n();
        i2a.b.b.g(r3, r4);
        return;
    }

    public final void h(Uri r3, com.larus.camera.impl.ui.component.capture.scan.d r4) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        Intrinsics.checkNotNullParameter(r4, "onSuccess");
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L6;
        r0.n();
        i2a.b.b.i(r3, r4);
        return;
    }

    public final String g(Bitmap r3, int r4, pq9.h r5) {
        Intrinsics.checkNotNullParameter(r3, "bitmap");
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L5;
        r0.n();
        return i2a.b.b.h(r3, r4, r5);
    L5:
        return null;
    }

    public final boolean i(String r3, String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r3, "srcPath");
        Intrinsics.checkNotNullParameter(r4, "dstPath");
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L5;
        r0.n();
        return i2a.b.b.j(r3, r4, r5);
    L5:
        return false;
    }

    public final boolean j(String r8, String r9, String r10, pq9.l r11, com.larus.bmhome.upload.k r12) {
        Intrinsics.checkNotNullParameter(r8, "identifier");
        Intrinsics.checkNotNullParameter(r9, "videoPath");
        Intrinsics.checkNotNullParameter(r10, "outPath");
        Intrinsics.checkNotNullParameter(r11, "transcodeParam");
        Intrinsics.checkNotNullParameter(r12, "callback");
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L5;
        r0.n();
        return i2a.b.b.k(r8, r9, r10, r11, r12);
    L5:
        return false;
    }
}

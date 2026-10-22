package rx8;

import com.larus.camera.impl.ui.component.capture.CaptureControlComponent;
import com.larus.camera.impl.ui.component.capture.CaptureSurfaceComponent;
import com.larus.camera.impl.ui.component.capture.CaptureTabComponent;
import com.larus.camera.impl.ui.component.capture.CaptureTitleComponent;
import com.larus.camera.impl.ui.component.capture.edu.EduCaptureControlComponent;
import com.larus.camera.impl.ui.component.capture.edu.EduCaptureTipComponent;
import com.larus.camera.impl.ui.component.capture.edu.c0;
import com.larus.camera.impl.ui.component.capture.health.MedicalCaptureControlComponent;
import com.larus.camera.impl.ui.component.capture.scan.ScanCaptureQrCodeAlbumComponent;
import com.larus.camera.impl.ui.component.capture.scan.ScanCaptureTipComponent;
import com.larus.camera.impl.ui.component.capture.scan.h;
import com.larus.camera.impl.ui.component.generalonly.AlbumThumbListComponent;
import com.larus.camera.impl.ui.component.generalonly.q;
import com.larus.camera.impl.ui.component.result.edu.EduHomeworkResultPreviewComponent;
import com.larus.camera.impl.ui.component.result.edu.EduResultPreviewComponent;
import com.larus.camera.impl.ui.component.result.general.ResultConfirmControlStyle;
import com.larus.camera.impl.ui.component.result.general.ResultControlComponent;
import com.larus.camera.impl.ui.component.result.general.ResultCropComponent;
import com.larus.camera.impl.ui.component.result.general.ResultDetectComponent;
import com.larus.camera.impl.ui.component.result.general.ResultPreviewComponent;
import com.larus.camera.impl.ui.component.result.general.ResultSuggestedActionComponent;
import com.larus.camera.impl.ui.component.result.general.ResultTipsComponent;
import com.larus.camera.impl.ui.component.result.general.ResultTitleComponent;
import com.larus.camera.impl.ui.component.result.general.p;
import com.larus.camera.impl.utils.CameraData;
import com.larus.camera.impl.utils.k;
import com.larus.camera.impl.utils.w;
import com.larus.common.apphost.AppHost;
import com.larus.platform.exp.LarkSocialExp;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tx8.d;
import yx8.b;
import yx8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static List a(String r1) {
        if (CollectionsKt.contains(fx8.a.e, r1) == false) goto L8;
        ArrayList r2 = new ArrayList();
        r2.add(new CaptureTabComponent());
        r2.add(new c0());
        r2.add(new CaptureSurfaceComponent());
        r2.add(new EduCaptureControlComponent());
        if (k.a() == true) goto L19;
        r2.add(new EduCaptureTipComponent());
        return r2;
    L19:
        return r2;
    L8:
        if (CollectionsKt.contains(fx8.a.b, r1) == false) goto L15;
        ArrayList r3 = new ArrayList();
        r3.add(new CaptureTabComponent());
        r3.add(new CaptureSurfaceComponent());
        r3.add(new h());
        r3.add(new ScanCaptureTipComponent());
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.e() == true) goto L12;
        return r3;
    L12:
        if (AppHost.a.isOversea() == true) goto L22;
        r3.add(new ScanCaptureQrCodeAlbumComponent());
        return r3;
    L22:
        return r3;
    L15:
        if (CollectionsKt.contains(fx8.a.c, r1) == false) goto L17;
        ArrayList r4 = new ArrayList();
        r4.add(new CaptureTabComponent());
        r4.add(new CaptureTitleComponent());
        r4.add(new CaptureSurfaceComponent());
        r4.add(new MedicalCaptureControlComponent());
        return r4;
    L17:
        ArrayList r5 = new ArrayList();
        r5.add(new CaptureTabComponent());
        r5.add(new CaptureTitleComponent());
        r5.add(new CaptureSurfaceComponent());
        r5.add(new CaptureControlComponent());
        r5.add(new q());
        r5.add(new AlbumThumbListComponent());
        return r5;
    }

    public static List d(CameraData r2, boolean r3) {
        ArrayList r0 = new ArrayList();
        yx8.a r1 = c.a;
        r0.addAll(c.a(b.a.a));
        r0.add(new ResultPreviewComponent());
        if (r3 == false) goto L6;
        r0.add(new ResultCropComponent());
    L6:
        if (r2.getEnableResultMarkedTips() == false) goto L8;
        r0.add(new p());
    L8:
        return r0;
    }

    public static List c(CameraData r3, boolean r4, boolean r5) {
        ArrayList r0 = new ArrayList();
        if (w.a() == false) goto L5;
        b r1 = new b.c(0);
    L6:
        yx8.a r2 = c.a;
        r0.addAll(c.a(r1));
        r0.add(new ResultPreviewComponent());
        if (r5 == false) goto L10;
        r0.add(new ResultCropComponent());
    L10:
        if (r3.getEnableResultSuggestedAction() == false) goto L12;
        r0.add(new ResultSuggestedActionComponent());
    L12:
        if (r4 == false) goto L14;
        r0.add(new ResultTipsComponent());
    L14:
        r0.add(new ResultDetectComponent());
        if (r3.getEnableResultMarkedTips() == false) goto L17;
        r0.add(new p());
    L17:
        return r0;
    L5:
        r1 = b.a.a;
        goto L6
    }

    public static List b(CameraData r5, boolean r6, String r7, boolean r8) {
        if (r6 == true) goto L5;
        boolean r9 = w.a();
        boolean r10 = Intrinsics.areEqual(r7, "CAPTURE_MODE_EDU_HOMEWORK_PHOTO");
        ArrayList r3 = new ArrayList();
        if (r9 == false) goto L9;
        yx8.a r0 = c.a;
        r3.addAll(c.a(new b.c(ResultConfirmControlStyle.EDU)));
    L12:
        if (r10 == false) goto L15;
        if (r9 == true) goto L15;
        d r11 = new EduHomeworkResultPreviewComponent();
    L16:
        r3.add(r11);
        if (r10 == false) goto L20;
        if (r8 == false) goto L20;
        r3.add(new ResultCropComponent());
    L20:
        if (r10 == true) goto L24;
        if (w.a() == true) goto L24;
    L26:
        return r3;
    L24:
        if (r5.getEnableResultSuggestedAction() == false) goto L26;
        r3.add(new ResultSuggestedActionComponent());
    L15:
        r11 = new EduResultPreviewComponent();
        goto L16
    L9:
        if (r10 == false) goto L11;
        yx8.a r1 = c.a;
        r3.addAll(c.a(b.a.a));
        goto L12
    L11:
        r3.addAll(CollectionsKt.listOf(new com.larus.camera.impl.ui.arch.b[]{new ResultTitleComponent(), new com.larus.camera.impl.ui.component.result.edu.a()}));
        goto L12
    L5:
        return CollectionsKt.listOf(new com.larus.camera.impl.ui.arch.b[]{new ResultTitleComponent(), new ResultControlComponent(), new ResultPreviewComponent()});
    }
}

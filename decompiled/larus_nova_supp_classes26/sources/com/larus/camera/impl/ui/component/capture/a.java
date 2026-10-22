package com.larus.camera.impl.ui.component.capture;

import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.capture.a$a, reason: collision with other inner class name */
    public static final class C0081a {
        public static boolean a(a r0, CameraCaptureViewModel r1) {
            List<String> r2 = r0.d();
            if (r1 == null) goto L5;
            String r3 = r1.getCurrentCaptureMode();
        L7:
            return CollectionsKt.contains(r2, r3);
        L5:
            r3 = null;
            goto L7
        }

        public static boolean b(a r1, String r2) {
            Intrinsics.checkNotNullParameter(r2, "captureMode");
            return r1.d().contains(r2);
        }
    }

    List<String> d();
}

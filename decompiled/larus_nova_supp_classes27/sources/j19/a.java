package j19;

import com.larus.common_ui.photoviewer.ZoomableControllerImp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements l {
    public final ZoomableControllerImp a;

    public a(ZoomableControllerImp r2) {
        Intrinsics.checkNotNullParameter(r2, "zc");
        this.a = r2;
    }

    @Override // j19.l
    public final float nextFactor(float r5) {
        ZoomableControllerImp r0 = this.a;
        float r1 = r0.g;
        if (r1 != 0.0f) goto L5;
        r1 = r0.h;
    L5:
        float r2 = r0.f;
        if (r5 >= ((r1 + r2) / 2)) goto L9;
        return r1;
    L9:
        return r2;
    }
}

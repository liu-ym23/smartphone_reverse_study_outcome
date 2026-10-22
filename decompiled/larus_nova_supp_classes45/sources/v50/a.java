package v50;

import android.content.Context;
import android.opengl.GLSurfaceView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static /* synthetic */ void b(GLSurfaceView r1, Context r2, j50.a r3) {
        a(r1, r2, r3, new com.bytedance.android.live.core.gl.primitive.a());
    }

    public static final void a(GLSurfaceView r11, Context r12, j50.a r13, com.bytedance.android.live.core.gl.primitive.a r14) {
        Intrinsics.checkNotNullParameter(r11, "$this$initSurfaceTransparent");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "scene");
        Intrinsics.checkNotNullParameter(r14, "backgroundColor");
        Intrinsics.checkNotNullParameter(r11, "$this$isInitialized");
        Object r3 = r11.getTag(2131375665);
        if ((r3 instanceof Boolean) == true) goto L5;
        r3 = null;
    L5:
        Boolean r4 = (Boolean) r3;
        if (r4 == null) goto L8;
        boolean r5 = r4.booleanValue();
    L9:
        if (r5 == false) goto L11;
        return;
    L11:
        r11.setEGLContextClientVersion(3);
        r11.setZOrderOnTop(true);
        r11.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        r11.getHolder().setFormat(1);
        k50.a r6 = new k50.a(r12, r14);
        Intrinsics.checkNotNullParameter(r13, "scene");
        r6.a = r13;
        r13.f(r6.b);
        r11.setRenderer(r6);
        Intrinsics.checkNotNullParameter(r11, "$this$isInitialized");
        r11.setTag(2131375665, Boolean.TRUE);
        return;
    L8:
        r5 = false;
        goto L9
    }
}

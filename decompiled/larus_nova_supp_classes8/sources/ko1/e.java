package ko1;

import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.ui.x6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements ScaleGestureDetector.OnScaleGestureListener {
    public float a;
    public float b;
    public boolean c;
    public final float d;
    public final float e;
    public boolean f;
    public boolean g;
    public final View h;
    public final ViewGroup i;
    public final com.bytedance.android.live.platformplayer.layout.c j;

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScaleBegin(ScaleGestureDetector r2) {
        Intrinsics.checkNotNullParameter(r2, "detector");
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector r6) {
        Intrinsics.checkNotNullParameter(r6, "detector");
        if (this.f == false) goto L7;
        if (r6.getScaleFactor() <= 1) goto L7;
    L11:
        if (this.f == false) goto L14;
        r6.getScaleFactor();
    L14:
        if (this.g == false) goto L16;
        r6.getScaleFactor();
    L16:
        return true;
    L7:
        if (this.g == true) goto L9;
    L17:
        this.a = this.b * r6.getScaleFactor();
        float r7 = x6.a();
        float r0 = this.a;
        float r2 = this.d * r7;
        boolean r3 = false;
        if (r0 <= r2) goto L20;
        this.a = r2;
        this.f = true;
        this.g = false;
    L23:
        r3 = true;
    L34:
        if (x6.a != 1) goto L31;
        float r8 = x6.a();     // Catch: Exception -> L33
        if (x6.b == false) goto L30;
        a(Float.valueOf(this.a), Float.valueOf(this.a / r8));     // Catch: Exception -> L33
        goto L32
    L30:
        a(Float.valueOf(this.a / r8), Float.valueOf(this.a));     // Catch: Exception -> L33
        goto L32
    L31:
        a(Float.valueOf(this.a), Float.valueOf(this.a));     // Catch: Exception -> L33
    L32:
        return r3;
    L20:
        float r4 = this.e * r7;
        if (r0 >= r4) goto L24;
        this.a = r4;
        this.f = false;
        this.g = true;
        goto L23
    L24:
        this.f = false;
        this.g = false;
        goto L34
    L9:
        if (r6.getScaleFactor() >= 1) goto L17;
        goto L17
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final void onScaleEnd(ScaleGestureDetector r2) {
        Intrinsics.checkNotNullParameter(r2, "detector");
        this.b = this.a;
    }

    public final void a(Float r3, Float r4) {
        if (r3 == null) goto L4;
        float r0 = r3.floatValue();
        this.h.setScaleX(r0);
    L4:
        if (r4 == null) goto L6;
        float r1 = r4.floatValue();
        this.h.setScaleY(r1);
    L6:
        com.bytedance.android.live.platformplayer.layout.c r2 = this.j;
        if (r2 == null) goto L13;
        if (r3 == null) goto L10;
        r2.setScaleX(r3.floatValue());
    L10:
        if (r4 == null) goto L14;
        r2.setScaleY(r4.floatValue());
        return;
    L14:
        return;
    }

    public e(View r2, ViewGroup r3, com.bytedance.android.live.platformplayer.layout.c r4) {
        Intrinsics.checkNotNullParameter(r2, "targetView");
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.a = 1.0f;
        this.b = 1.0f;
        this.d = 5.0f;
        this.e = 1.0f;
        this.g = true;
    }
}

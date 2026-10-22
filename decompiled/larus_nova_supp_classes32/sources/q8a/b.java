package q8a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewParent;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends com.lynx.tasm.behavior.ui.view.a {
    public boolean a;

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        x6a.d.k(this, r1);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, r1);
    }

    public final boolean getHandleGesture() {
        return this.a;
    }

    public b(Context r2) {
        new LinkedHashMap();
        super(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        if (r3.getActionMasked() != 0) goto L10;
        if (this.a == false) goto L10;
        ViewParent r0 = getParent();
        if (r0 == null) goto L10;
        r0.requestDisallowInterceptTouchEvent(true);
    L10:
        return super.dispatchTouchEvent(r3);
    }

    public final void setHandleGesture(boolean r1) {
        this.a = r1;
    }
}

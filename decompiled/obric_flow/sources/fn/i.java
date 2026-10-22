package fn;

import android.view.Choreographer;
import android.widget.FrameLayout;
import com.lynx.react.bridge.Callback;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;
import com.lynx.tasm.utils.j;
import com.obric.oui.material.n;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16960c;
    public Object d;
    public Object e;
    public final Object f;

    public i(UIListContainer r5, Callback r10) {
        this.f = r5;
        this.e = r10;
        this.f16958a = false;
        this.f16959b = 0;
        this.f16960c = true;
        this.d = null;
    }

    public void a() {
        if (((c7.e) this.d) == null) goto L6;
        Choreographer.getInstance().removeFrameCallback((c7.e) this.d);
        this.d = null;
        return;
    }

    public void b(FrameLayout r5, com.obric.oui.material.c r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "maskView");
        Intrinsics.checkNotNullParameter(r10, "maskMaterialConfig");
        xq.a r12 = r10.g;
        Intrinsics.checkNotNull(r12);
        if (r12.f23207a <= 0.0f) goto L5;
        n.o(r5, r10, r11);
    L6:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        n.r(r5, r5);
        return;
    L5:
        n.p(0, r5);
        goto L6
    }

    public void c() {
        if (this.f16958a == false) goto L10;
        boolean r5 = this.f16960c;
        if (r5 == true) goto L11;
        if (r5 == true) goto L12;
        ts.a r10 = new ts.a(this, 0);
        ((FrameLayout) this.d).post(r10);
        return;
    L12:
        return;
    L11:
        return;
    }

    public void d(boolean r5, final Function1 r10) {
        Intrinsics.checkNotNullParameter(r10, "updateLayout");
        if (r5 == false) goto L6;
        FrameLayout r11 = (FrameLayout) this.d;
        r10.invoke(j.r(r11, null));
        r11.setOnApplyWindowInsetsListener(new ts.b(this, r10));
        return;
    }

    public i(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "targetView");
        this.d = r5;
        this.f16959b = 1;
        this.f = new bf.b(this, 5);
    }
}

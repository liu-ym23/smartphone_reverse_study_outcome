package j9;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;
import k0.j;

/* JADX INFO: loaded from: classes.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f8748a;

    public a(SwipeDismissBehavior r8) {
        this.f8748a = r8;
    }

    @Override // k0.j
    public final boolean a(View r8) {
        SwipeDismissBehavior r10 = this.f8748a;
        boolean r11 = false;
        if (r10.y(r8) == false) goto L19;
        WeakHashMap<View, h0> r12 = w.f8437a;
        if (w.e.d(r8) != 1) goto L7;
        boolean r13 = true;
    L8:
        int r14 = r10.f4355d;
        if (r14 != 0) goto L11;
        if (r13 == false) goto L11;
    L13:
        r11 = true;
    L14:
        int r15 = r8.getWidth();
        if (r11 == false) goto L17;
        r15 = -r15;
    L17:
        r8.offsetLeftAndRight(r15);
        r8.setAlpha(0.0f);
        return true;
    L11:
        if (r14 != 1) goto L14;
        if (r13 == true) goto L14;
    L7:
        r13 = false;
        goto L8
    L19:
        return false;
    }
}

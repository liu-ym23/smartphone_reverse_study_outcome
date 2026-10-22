package r69;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class a extends u19.a<Toast> {
    public abstract ConstraintLayout a(Context r1);

    @Override // u19.a
    public final boolean getSupportLottie() {
        return false;
    }

    @Override // u19.f
    public final void setDuration(int r1) {
    }

    @Override // u19.a, u19.f
    public final void dismiss() {
        super.dismiss();
        Toast r0 = getInstance();
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        setInstance(null);
    }

    public a() {
    }

    @Override // u19.a, u19.f
    public final void show(Fragment r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "fragment");
        Context r2 = r9.getContext();
        if (r2 != null) goto L5;
        return;
    L5:
        super.show(r9, r10);
        Toast r11 = getInstance();
        if (r11 == null) goto L8;
        r11.cancel();
    L8:
        setInstance(null);
        ((Toast) u19.a.ensureInstance$default(this, r2, null, -1, false, 8, null)).show();
    }

    @Override // u19.a
    public final void show(Activity r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        super.show(r8, r9);
        Toast r10 = getInstance();
        if (r10 == null) goto L5;
        r10.cancel();
    L5:
        setInstance(null);
        ((Toast) u19.a.ensureInstance$default(this, r8, null, -1, false, 8, null)).show();
    }

    @Override // u19.a, u19.f
    public final void show(Context r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super.show(r8, r9);
        Toast r10 = getInstance();
        if (r10 == null) goto L5;
        r10.cancel();
    L5:
        setInstance(null);
        ((Toast) u19.a.ensureInstance$default(this, r8, null, -1, false, 8, null)).show();
    }

    @Override // u19.a
    public final Toast newInstance(Context r3, LifecycleOwner r4, int r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Toast r7 = new Toast(r3);
        r7.setView(a(r3));
        r7.setDuration(0);
        r7.setGravity(49, 0, r3.getResources().getDimensionPixelSize(v19.c.b(2130971541, r3, 2131167451)));
        return r7;
    }
}

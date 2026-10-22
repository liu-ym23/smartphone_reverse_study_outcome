package u19;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i extends u19.a<Toast> {
    public int a;
    public final Handler b;
    public h c;

    public static final class a {
    }

    static {
    }

    @Override // u19.a
    public final boolean getSupportLottie() {
        return false;
    }

    @Override // u19.a, u19.f
    public final void dismiss() {
        h r0 = this.c;
        if (r0 == null) goto L5;
        this.b.removeCallbacks(r0);
    L5:
        this.c = null;
        super.dismiss();
        Toast r1 = getInstance();
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        setInstance(null);
    }

    public i() {
        this.a = 1;
        this.b = new Handler(Looper.getMainLooper());
    }

    @Override // u19.a
    public final int getDisplayDuration() {
        return this.a;
    }

    @Override // u19.a
    public final void setDisplayDuration(int r1) {
        this.a = r1;
    }

    @Override // u19.f
    public final void setDuration(int r7) {
        long r0 = r7;
        if (0 <= r0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        this.a = 0;
        return;
    L10:
        this.a = 1;
        return;
    L5:
        if (r0 >= 1501) goto L7;
        r1 = true;
        goto L8
    }

    @Override // u19.a, u19.f
    public final void show(Fragment r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Context r0 = r2.getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        super.show(r2, r3);
        showInternal(r0, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Runnable, u19.h] */
    public final void showInternal(Context r3, boolean r4) {
        h r0 = this.c;
        if (r0 == null) goto L5;
        this.b.removeCallbacks(r0);
    L5:
        this.c = null;
        Toast r1 = getInstance();
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        setInstance(null);
        final Toast r5 = ensureInstance(r3, null, -1, r4);
        r5.show();
        if (this.a != 1) goto L11;
        long r2 = 3500;
    L12:
        ?? r6 = new h(this, r5);
        this.c = r6;
        this.b.postDelayed(r6, r2);
        return;
    L11:
        r2 = 2000;
        goto L12
    }

    @Override // u19.a
    public final void show(Activity r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        super.show(r2, r3);
        showInternal(r2, r3);
    }

    @Override // u19.a, u19.f
    public final void show(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.show(r2, r3);
        showInternal(r2, r3);
    }

    @Override // u19.a
    public final Toast newInstance(Context r1, LifecycleOwner r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Context r5 = r1.getApplicationContext();
        if (r5 == null) goto L6;
        r1 = r5;
    L6:
        Toast r6 = new Toast(r1);
        r6.setView(buildLayout(r1, r4));
        r6.setDuration(this.a);
        r6.setGravity(55, 0, 0);
        return r6;
    }
}

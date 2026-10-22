package v3;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import c4.m;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import he.i;
import java.util.HashSet;
import r4.j;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f12707b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f12708m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HashSet<Integer> f12709n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final r3.c f12710o;

    public a(r3.c r8) {
        this.f12706a = 0;
        this.f12709n = new HashSet(8);
        this.f12710o = r8;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r8, Bundle r10) {
        this.f12709n.add(Integer.valueOf(r8.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r8) {
        this.f12709n.remove(Integer.valueOf(r8.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r8) {
        r3.c r10 = this.f12710o;
        r10.K.getClass();
        long r11 = System.currentTimeMillis();
        m r12 = r10.H;
        Object[] r13 = new Object[1];
        if (r8 == null) goto L5;
        String r14 = r8.getClass().getName();
    L6:
        r13[0] = r14;
        r12.e("onActivityPaused:{}", r13);
        j r15 = this.f12707b;
        if (r15 == null) goto L13;
        this.f12708m = r15.J;
        j r16 = (j) r15.a();
        r16.l(r11);
        long r17 = r11 - r15.f11450b;
        if (r17 > 0) goto L11;
        r17 = 1000;
    L11:
        r16.H = r17;
        r10.l(r16);
        this.f12707b = null;
        return;
    L13:
        return;
    L5:
        r14 = "";
        goto L6
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r10) {
        String r8 = r10.getClass().getName();
        int r11 = r10.hashCode();
        r3.c r12 = this.f12710o;
        r12.K.getClass();
        i.f(r8 + "___" + r11, "id");
        long r13 = System.currentTimeMillis();
        r12.H.e("onActivityResumed: {}", new Object[]{r8});
        String r14 = this.f12708m;
        j r15 = new j();
        if (TextUtils.isEmpty("") == true) goto L5;
        r8 = r8.concat(BdimCategoryConstants.SEPARATOR_COLON);
    L5:
        r15.J = r8;
        r15.l(r13);
        r15.H = -1;
        if (r14 != null) goto L9;
        r14 = "";
    L9:
        r15.I = r14;
        r12.l(r15);
        this.f12707b = r15;
        r15.K = !this.f12709n.remove(Integer.valueOf(r11)) ? 1 : 0;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r8, Bundle r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r8) {
        this.f12706a++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r8) {
        if (this.f12708m == null) goto L8;
        int r10 = this.f12706a - 1;
        this.f12706a = r10;
        if (r10 > 0) goto L9;
        this.f12708m = null;
        return;
    L9:
        return;
    }
}

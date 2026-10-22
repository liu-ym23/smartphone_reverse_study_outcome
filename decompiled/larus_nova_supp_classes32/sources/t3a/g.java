package t3a;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g {
    public static final Lazy<g> j = null;
    public ViewGroup a;
    public View b;
    public boolean c;
    public t3a.b d;
    public i e;
    public ViewGroup f;
    public ViewGroup.LayoutParams g;
    public int h;
    public Function0<Unit> i;

    public static final class a {
    }

    public static final class b implements t3a.b.a {
        public final /* synthetic */ e a;
        public final /* synthetic */ g b;

        @Override // t3a.b.a
        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
        }

        @Override // t3a.b.a
        public final void onLongClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
        }

        @Override // t3a.b.a
        public final void onClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            if (this.a.f == false) goto L8;
            Function0<Unit> r3 = this.b.i;
            if (r3 == null) goto L9;
            r3.invoke();
            return;
        L9:
            return;
        }

        public b(e r1, g r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public g() {
    }

    static {
        j = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new f());
    }

    public final void a() {
        i r0 = this.e;
        if (r0 == null) goto L5;
        AppHost.a.getApplication().unregisterActivityLifecycleCallbacks(r0);
        this.e = null;
        FLogger.a.d("RealtimeVideoGlobalFloatWindow", "activity lifecycle callback unregistered");
    L5:
        this.d = null;
        this.a = null;
        this.b = null;
        this.f = null;
        this.g = null;
        this.i = null;
    }

    public final void b() {
        View r0 = this.b;
        if (r0 == null) goto L16;
        ViewGroup r1 = this.a;
        if (r1 == null) goto L7;
        r1.removeView(r0);
    L7:
        ViewGroup r2 = this.f;
        if (r2 != null) goto L10;
    L14:
        r0.setVisibility(this.h);
        return;
    L10:
        if (Intrinsics.areEqual(r0.getParent(), r2) == true) goto L14;
        ViewGroup.LayoutParams r3 = this.g;
        if (r3 == null) goto L14;
        r2.addView(r0, r3);
        goto L14
    }

    public final boolean c(View r8, e r9) {
        Intrinsics.checkNotNullParameter(r8, "videoView");
        Intrinsics.checkNotNullParameter(r9, "config");
        if (this.c == false) goto L30;
        FLogger.a.w("RealtimeVideoGlobalFloatWindow", "float window is showing");
        return false;
    L30:
        FLogger r0 = FLogger.a;     // Catch: Exception -> L27
        r0.i("RealtimeVideoGlobalFloatWindow", "start to show global float window");     // Catch: Exception -> L27
        this.b = r8;     // Catch: Exception -> L27
        ViewParent r3 = r8.getParent();     // Catch: Exception -> L27
        if ((r3 instanceof ViewGroup) == false) goto L9;
        ViewGroup r4 = (ViewGroup) r3;     // Catch: Exception -> L27
    L10:
        this.f = r4;     // Catch: Exception -> L27
        this.g = r8.getLayoutParams();     // Catch: Exception -> L27
        this.h = r8.getVisibility();     // Catch: Exception -> L27
        ViewGroup r5 = this.f;     // Catch: Exception -> L27
        if (r5 == null) goto L13;
        r5.removeView(r8);     // Catch: Exception -> L27
    L13:
        FrameLayout r6 = new FrameLayout(r8.getContext());     // Catch: Exception -> L27
        r6.setLayoutParams(new FrameLayout.LayoutParams(r9.a, r9.b));     // Catch: Exception -> L27
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-1, -2);     // Catch: Exception -> L27
        r6.setOutlineProvider(new h());     // Catch: Exception -> L27
        r6.setClipToOutline(true);     // Catch: Exception -> L27
        r6.addView(r8, r7);     // Catch: Exception -> L27
        this.a = r6;     // Catch: Exception -> L27
        this.c = true;     // Catch: Exception -> L27
        if (this.d != null) goto L17;
        t3a.b r10 = new t3a.b(r6.getContext(), r6, r9);     // Catch: Exception -> L27
        this.d = r10;     // Catch: Exception -> L27
        b r11 = new b(r9, this);     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter(r11, "listener");     // Catch: Exception -> L27
        r10.z = r11;     // Catch: Exception -> L27
    L17:
        if (this.e != null) goto L20;
        this.e = new i(this);     // Catch: Exception -> L27
        Application r12 = AppHost.a.getApplication();     // Catch: Exception -> L27
        i r13 = this.e;     // Catch: Exception -> L27
        Intrinsics.checkNotNull(r13);     // Catch: Exception -> L27
        r12.registerActivityLifecycleCallbacks(r13);     // Catch: Exception -> L27
        r0.d("RealtimeVideoGlobalFloatWindow", "activity lifecycle callback registered");     // Catch: Exception -> L27
    L20:
        Activity r14 = AppHost.a.a().getCurrentActivity();     // Catch: Exception -> L27
        if (r14 == null) goto L25;
        t3a.b r15 = this.d;     // Catch: Exception -> L27
        if (r15 == null) goto L25;
        r15.a(r14);     // Catch: Exception -> L27
    L25:
        r0.i("RealtimeVideoGlobalFloatWindow", "show global float window success");     // Catch: Exception -> L27
        return true;
    L9:
        r4 = null;
    L27:
        e = move-exception;
        FLogger.a.e("RealtimeVideoGlobalFloatWindow", "show global float window error: " + e.getMessage(), e);
        b();
        a();
        return false;
    }
}

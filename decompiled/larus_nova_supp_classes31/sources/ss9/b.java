package ss9;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.larus.platform.api.s1;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.search.api.IBrowserService;
import com.larus.search.api.event.HybridEventParams;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements s1 {
    public static final b a = null;
    public static final Lazy b = null;

    public b() {
    }

    public final boolean g(Activity r1) {
        return false;
    }

    public final String h() {
        return null;
    }

    static {
        a = new b();
        b = LazyKt.lazy(new a());
    }

    public final ts9.a f() {
        return new ts9.a(0);
    }

    public final IBrowserService j() {
        return (IBrowserService) b.getValue();
    }

    public final AbsWebFragment c() {
        IBrowserService r0 = j();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    public final void b(ts9.a r2) {
        Intrinsics.checkNotNullParameter(r2, "searchModel");
        IBrowserService r0 = j();
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public final void i(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter("feedback_doubao_apps", "source");
        IBrowserService r0 = j();
        if (r0 == null) goto L6;
        r0.j(r3, "feedback_doubao_apps");
        return;
    }

    public final void a(AppletAppActivity r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter("feedback_doubao_apps", "source");
        i(r2);
    }

    public final void d(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        IBrowserService r0 = j();
        if (r0 == null) goto L6;
        r0.d(r2, r3);
        return;
    }

    public final Object o(String r2, Continuation<? super String> r3) {
        IBrowserService r0 = j();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.o(r2, r3);
    }

    public final void e(Context r2, Bundle r3, HybridEventParams r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        IBrowserService r0 = j();
        if (r0 == null) goto L6;
        r0.e(r2, r3, r4);
        return;
    }
}

package kd8;

import android.view.MotionEvent;
import android.view.View;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.g;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements View.OnTouchListener {
    public final Function0<View.OnTouchListener> a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends View.OnTouchListener> r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r4, MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r4, "v");
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L5;
        r0.a0();
        g r1 = g.a;
    L6:
        Function0<View.OnTouchListener> r2 = this.a;
        if (r2 == null) goto L12;
        View.OnTouchListener r3 = (View.OnTouchListener) r2.invoke();
        if (r3 == null) goto L12;
        return r3.onTouch(r4, r5);
    L12:
        if (r5 != null) goto L14;
    L16:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L21;
        if (r1 == null) goto L20;
        r1.a();
    L20:
        s.a.g(AppHost.a.getApplication(), 2131900810, false);
    L21:
        return true;
    L14:
        if (r5.getActionMasked() != 0) goto L16;
        r6 = true;
        goto L17
    L5:
        r1 = null;
        goto L6
    }
}

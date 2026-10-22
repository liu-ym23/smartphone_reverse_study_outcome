package zh0;

import android.os.Build;
import android.view.ViewGroup;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.radio.impl.RadioWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m0 implements Runnable {
    public final /* synthetic */ RadioWidget a;

    public final void a() {
        if (jc1.k.f(IInteractService.class) != null) goto L5;
        return;
    L5:
        if (((IInteractService) jc1.k.f(IInteractService.class)).dynamicService(((Widget) this.a).dataCenter) == null) goto L35;
        ih0.c r0 = ((IInteractService) jc1.k.f(IInteractService.class)).dynamicService(((Widget) this.a).dataCenter).Z9();
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.S0() == null) goto L36;
        ViewGroup r1 = (ViewGroup) r0.S0().getParent();
        if (r1 != null) goto L15;
    L17:
        if (r1 == null) goto L19;
        r1.removeView(r0.S0());
    L19:
        ViewGroup r3 = ((Widget) this.a).containerView;
        if (r3 == null) goto L22;
        ViewGroup r4 = (ViewGroup) ((ViewGroup) r3.getParent()).findViewById(2131380433);
    L24:
        if (r4 == null) goto L26;
        r4.setVisibility(0);
        r4.addView(r0.S0(), 0);
    L26:
        if (r1 != null) goto L28;
        return;
    L28:
        if (Build.VERSION.SDK_INT < 29) goto L34;
        r1.suppressLayout(false);
        return;
    L34:
        return;
    L22:
        r4 = null;
        goto L24
    L15:
        if (Build.VERSION.SDK_INT < 29) goto L17;
        r1.suppressLayout(true);
        goto L17
    L36:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public m0(RadioWidget r1) {
        this.a = r1;
    }
}

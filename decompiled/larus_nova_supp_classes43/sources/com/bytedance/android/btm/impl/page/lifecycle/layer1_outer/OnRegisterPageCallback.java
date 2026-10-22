package com.bytedance.android.btm.impl.page.lifecycle.layer1_outer;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.PageProp;
import com.bytedance.android.btm.api.e;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g$a;
import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.lifecycle.layer2.FilterDispatcher;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.f;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class OnRegisterPageCallback {
    static {
    }

    public static void a(final e r10) {
        if (r10.a.get() != null) goto L5;
        ALogger.e(ALogger.d, "OnRegisterPageCallback_onRegisterPage", OnRegisterPageCallback$onRegisterPage$1.INSTANCE);
    L5:
        Object r0 = r10.a.get();
        if (r0 == null) goto L10;
        final String r1 = r0.getClass().getCanonicalName();
        if (r1 == null) goto L10;
    L11:
        Object r11 = r10.a.get();
        if (r11 == null) goto L53;
        ALogger.e(ALogger.d, "OnRegisterPageCallback_onRegisterPage", new OnRegisterPageCallback$onRegisterPage$$inlined$let$lambda$1(r1, r10));
        if ((r11 instanceof Dialog) == false) goto L25;
        Window r12 = ((Dialog) r11).getWindow();
        if (r12 == null) goto L27;
        View r13 = r12.getDecorView();
        if (c.e == false) goto L22;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r14 = ThreadMethodProxy.currentThread();
        if (r14 == c.a) goto L22;
        c.a(r14, "getDecorView");
    L22:
        if (r13 == null) goto L27;
        BtmPageRecorder.p.put(new f(r13), new f(r11));
    L27:
        String r15 = BtmPageRecorder.a;
        PageInfoStack r16 = BtmPageRecorder.k(r10.a.get());
        if (r16 == null) goto L30;
        final BtmPageLifecycle.State r17 = r16.getNativeState();
    L31:
        if (r17 != null) goto L33;
    L37:
        String r18 = FilterDispatcher.a;
        FilterDispatcher.b(r11, new PageProp(r10.b, r10.c, r10.d, r10.e, r10.f));
        boolean r19 = true;
        if (BtmSetting.d.c().b().D() == 1) goto L40;
        NativeStateWriter.b(r11);
        return;
    L40:
        if ((r11 instanceof Fragment) == false) goto L43;
        r19 = ((Fragment) r11).isResumed();
    L48:
        if (r19 == false) goto L50;
        NativeStateWriter.e(r11);
        return;
    L50:
        NativeStateWriter.b(r11);
        return;
    L43:
        if ((r11 instanceof AppCompatActivity) == true) goto L45;
    L47:
        r19 = false;
        goto L48
    L45:
        if (((AppCompatActivity) r11).getLifecycle().getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L47;
    L33:
        if (r17 == BtmPageLifecycle.State.INITIALIZED) goto L37;
        if (r17 == BtmPageLifecycle.State.CREATED) goto L37;
        g$a.a(BtmMonitor.c, 2016, null, null, new OnRegisterPageCallback$onRegisterPage$$inlined$let$lambda$2(r17, r1, r10), 30);
        goto L37
    L30:
        r17 = null;
        goto L31
    L25:
        if ((r11 instanceof View) == false) goto L27;
        List<f<View>> r20 = BtmPageRecorder.q;
        ArrayList r21 = (ArrayList) r20;
        r21.add(new f(r11));
        goto L27
    L53:
        return;
    L10:
        r1 = "null";
        goto L11
    }

    public static void b(e r10) {
        if (r10.a.get() != null) goto L5;
        ALogger.e(ALogger.d, "OnRegisterPageCallback_onUnregisterPage", OnRegisterPageCallback$onUnregisterPage$1.INSTANCE);
    L5:
        final String r0 = e.class.getName();
        Object r11 = r10.a.get();
        if (r11 == null) goto L12;
        ALogger.e(ALogger.d, "OnRegisterPageCallback_onUnregisterPage", new OnRegisterPageCallback$onUnregisterPage$$inlined$let$lambda$1(r0));
        if ((r11 instanceof View) == false) goto L10;
        List<f<View>> r1 = BtmPageRecorder.q;
        ArrayList r12 = (ArrayList) r1;
        r12.remove(new f(r11));
    L10:
        PageInfoStack r13 = BtmPageRecorder.d.remove(new f(r11));
        return;
    }
}

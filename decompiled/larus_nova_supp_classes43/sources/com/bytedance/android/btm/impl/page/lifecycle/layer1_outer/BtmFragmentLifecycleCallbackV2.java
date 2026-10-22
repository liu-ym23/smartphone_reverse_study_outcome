package com.bytedance.android.btm.impl.page.lifecycle.layer1_outer;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.btm.api.PageProp;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.lifecycle.PauseFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.layer2.FragmentFilter;
import com.bytedance.android.btm.impl.page.lifecycle.layer3.BtmPageLifecycleCallbackV2;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.page.unknown.UnknownDialogFragmentCallback;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/btm/impl/page/lifecycle/layer1_outer/BtmFragmentLifecycleCallbackV2;", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "<init>", "()V", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class BtmFragmentLifecycleCallbackV2 extends FragmentManager.FragmentLifecycleCallbacks {
    public static final BtmFragmentLifecycleCallbackV2 a = null;

    static {
        a = new BtmFragmentLifecycleCallbackV2();
    }

    private BtmFragmentLifecycleCallbackV2() {
    }

    public final void onFragmentDestroyed(FragmentManager r10, Fragment r11) {
        final String r12 = r11.getClass().getName();
        ALogger.e(ALogger.d, "BtmFragmentLifecycleCallbackV2_onFragmentDestroyed", new C02261(r12));
        NativeStateWriter.c(r11);
        FragmentFilter.o.j(r11);
    }

    public final void onFragmentPaused(FragmentManager r10, Fragment r11) {
        final String r0 = r11.getClass().getName();
        ALogger.e(ALogger.d, "BtmFragmentLifecycleCallbackV2_onFragmentPaused", new C02271(r0));
        NativeStateWriter.d(r11);
        String r1 = BtmPageRecorder.a;
        PageInfoStack r12 = BtmPageRecorder.k(r11);
        if (r12 == null) goto L10;
        PageProp r13 = r12.getPageProp();
        if (r13 == null) goto L10;
        if (r13.getAuto() != true) goto L10;
        FragmentFilter.o.d(r11, PauseFuncOrigin.System);
    L10:
        if ((r11 instanceof DialogFragment) == false) goto L13;
        UnknownDialogFragmentCallback.b.onFragmentPaused(r10, r11);
        return;
    }

    public final void onFragmentResumed(FragmentManager r10, Fragment r11) {
        final String r0 = r11.getClass().getName();
        ALogger.e(ALogger.d, "BtmFragmentLifecycleCallbackV2_onFragmentResumed", new C02291(r0));
        NativeStateWriter.e(r11);
        String r1 = BtmPageRecorder.a;
        PageInfoStack r12 = BtmPageRecorder.k(r11);
        if (r12 == null) goto L10;
        PageProp r13 = r12.getPageProp();
        if (r13 == null) goto L10;
        if (r13.getAuto() != true) goto L10;
        FragmentFilter.o.e(r11, ResumeFuncOrigin.System);
    L10:
        if ((r11 instanceof DialogFragment) == false) goto L13;
        UnknownDialogFragmentCallback.b.onFragmentResumed(r10, r11);
        return;
    }

    public final void onFragmentViewDestroyed(FragmentManager r10, Fragment r11) {
        final String r12 = r11.getClass().getName();
        ALogger.e(ALogger.d, "BtmFragmentLifecycleCallbackV2_onFragmentViewDestroyed", new C02321(r12));
        FragmentFilter.o.getClass();
        FragmentFilter.m(r11);
    }

    public final void onFragmentActivityCreated(FragmentManager r1, Fragment r10, Bundle r11) {
        FragmentFilter.o.getClass();
        FragmentFilter.k(r10);
    }

    public final void onFragmentCreated(FragmentManager r10, Fragment r11, final Bundle r12) {
        final String r0 = r11.getClass().getName();
        ALogger.e(ALogger.d, "BtmFragmentLifecycleCallbackV2_onFragmentCreated", new AnonymousClass1(r0, r12));
        NativeStateWriter.b(r11);
        b.a(r11, r12);
        if ((r11 instanceof DialogFragment) == false) goto L6;
        UnknownDialogFragmentCallback.b.onFragmentCreated(r10, r11, r12);
        return;
    }

    public final void onFragmentPreCreated(FragmentManager r10, Fragment r11, final Bundle r12) {
        final String r13 = r11.getClass().getName();
        ALogger.e(ALogger.d, "BtmFragmentLifecycleCallbackV2_onFragmentPreCreated", new C02281(r13, r12));
        FragmentFilter.o.getClass();
        FragmentFilter.i(r11, r12, null);
        NativeStateWriter.b(r11);
    }

    public final void onFragmentSaveInstanceState(FragmentManager r10, Fragment r11, Bundle r12) {
        final String r13 = r11.getClass().getName();
        ALogger.e(ALogger.d, "BtmFragmentLifecycleCallbackV2_onFragmentSaveInstanceState", new C02301(r13));
        FragmentFilter.o.getClass();
        if (BtmPageRecorder.k(r11) == null) goto L6;
        BtmPageLifecycleCallbackV2.f(r11, r12);
        return;
    }

    public final void onFragmentViewCreated(FragmentManager r1, Fragment r10, View r11, final Bundle r12) {
        final String r13 = r10.getClass().getName();
        ALogger.e(ALogger.d, "BtmFragmentLifecycleCallbackV2_onFragmentViewCreated", new C02311(r13, r12));
    }
}

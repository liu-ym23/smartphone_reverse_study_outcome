package com.bytedance.android.btm.impl.page.unknown;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.HybridContainerFinder;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/btm/impl/page/unknown/UnknownDialogFragmentCallback;", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "<init>", "()V", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class UnknownDialogFragmentCallback extends FragmentManager.FragmentLifecycleCallbacks {
    public static final WeakHashMap<Fragment, a> a = null;
    public static final UnknownDialogFragmentCallback b = null;

    static {
        b = new UnknownDialogFragmentCallback();
        a = new WeakHashMap();
    }

    private UnknownDialogFragmentCallback() {
    }

    public static void a(Fragment r10, final a r11) {
        final UnknownPageInfo r0 = b.c(r10);
        if (r11.c == false) goto L5;
        b.a(r10);
    L5:
        ALogger.l(ALogger.d, "UnknownDialogFragment_Paused", new UnknownDialogFragmentCallback$onUnknownPaused$1(r11, r0));
        UnionBufferBtm r12 = UnionBufferQueue.a;
        UnionBufferQueue.b(r0, r0.getBufferBtm());
    }

    public final void onFragmentPaused(FragmentManager r10, Fragment r11) {
        if (BtmSetting.d.c().c().K() == 1) goto L5;
        return;
    L5:
        WeakHashMap<Fragment, a> r12 = a;
        a r0 = r12.get(r11);
        if (r0 == null) goto L19;
        Boolean r1 = r0.b;
        Boolean r13 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r13) == false) goto L11;
        a(r11, r0);
        return;
    L11:
        if (r0.c == false) goto L21;
        String r14 = BtmPageRecorder.a;
        if (BtmPageRecorder.a(r11) == false) goto L16;
        r12.remove(r11);
        return;
    L16:
        if ((SystemClock.elapsedRealtime() - r0.a) <= 5000) goto L23;
        r0.b = r13;
        a(r11, r0);
        return;
    L23:
        return;
    L21:
        return;
    }

    public final void onFragmentResumed(FragmentManager r10, Fragment r11) {
        if (BtmSetting.d.c().c().K() == 1) goto L5;
        return;
    L5:
        a r12 = a.get(r11);
        if (r12 == null) goto L14;
        Boolean r0 = r12.b;
        if (r0 != null) goto L11;
        r12.a = SystemClock.elapsedRealtime();
        return;
    L11:
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L16;
        b.a(r11);
        return;
    L16:
        return;
    }

    public final void onFragmentCreated(FragmentManager r1, Fragment r10, Bundle r11) {
        if (BtmSetting.d.c().c().K() == 1) goto L5;
        return;
    L5:
        String r12 = BtmPageRecorder.a;
        if (BtmPageRecorder.a(r10) == true) goto L11;
        String r13 = HybridContainerFinder.a;
        if (HybridContainerFinder.b(r10) == false) goto L12;
        a.put(r10, new a());
        return;
    L12:
        return;
    }
}

package com.ss.android.lark.officesdk.minutes.ui.service;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmPanelProviderHelper {
    public static final Handler a = null;

    public static final class a implements Runnable {
        public final /* synthetic */ Function0 a;

        public a(Function0 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public MmPanelProviderHelper() {
    }

    static {
        a = new Handler(Looper.getMainLooper());
    }

    public static void e(Function0 r2) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.invoke();
        return;
    L5:
        a.post(new a(r2));
    }

    public static void c(final FragmentManager r1, final Collection r2) {
        Intrinsics.checkNotNullParameter(r1, "fragmentManager");
        Intrinsics.checkNotNullParameter(r2, "tags");
        e(new MmPanelProviderHelper$dismissAllPanels$1(r2, r1));
    }

    public static void d(final FragmentManager r1, final String r2) {
        Intrinsics.checkNotNullParameter(r1, "fragmentManager");
        Intrinsics.checkNotNullParameter(r2, "tag");
        e(new MmPanelProviderHelper$dismissPanel$1(r1, r2));
    }

    public static final void a(FragmentManager r7, Fragment r8, String r9) {
        if ((r8 instanceof DialogFragment) == false) goto L11;
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "dismissContentFragment", "dismissContentFragment dialog: tag=" + r9 + ", fm=" + r7.hashCode(), null, 8);
        ((DialogFragment) r8).dismissAllowingStateLoss();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r10 = DialogFragmentLancet.sLastShowStack;
        if (r10 == null) goto L15;
        com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L15:
        return;
    L11:
        int r1 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "dismissContentFragment", "dismissContentFragment remove: tag=" + r9 + ", fm=" + r7.hashCode(), null, 8);
        r7.beginTransaction().remove(r8).commitAllowingStateLoss();
    }

    public static final boolean b(FragmentManager r7, Fragment r8, String r9) {
        if (r7.isStateSaved() == false) goto L6;
        int r10 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "showContentFragment", "showContentFragment " + r9 + ", fragment state saved, skip show", null, 8);
        return false;
    L6:
        if ((r8 instanceof DialogFragment) == false) goto L12;
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "showContentFragment", "showContentFragment dialog: tag=" + r9 + ", fm=" + r7.hashCode(), null, 8);
        DialogFragment r11 = (DialogFragment) r8;
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r11, r9, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r11, r1) == false) goto L20;
    L17:
        return true;
    L20:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L11:
        r11.show(r7, r9);
        goto L17
    L12:
        int r2 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "showContentFragment", "showContentFragment add: tag=" + r9 + ", fm=" + r7.hashCode(), null, 8);
        FragmentTransaction r12 = r7.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r12, r8, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r9, 2131380181) == true) goto L16;
        r12 = r12.add(2131380181, r8, r9);
    L16:
        r12.commitAllowingStateLoss();
        goto L17
    }

    public static void f(final FragmentManager r1, final rub.d r2, final Function2 r3) {
        Intrinsics.checkNotNullParameter(r1, "fragmentManager");
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "fragmentFactory");
        e(new MmPanelProviderHelper$showPanel$1(r2, r3, r1));
    }
}

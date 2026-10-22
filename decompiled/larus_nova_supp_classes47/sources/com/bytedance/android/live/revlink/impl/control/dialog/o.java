package com.bytedance.android.live.revlink.impl.control.dialog;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.utils.s1;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ RevLinkDialog a;
    public final /* synthetic */ RevInteractDialogFragmentBaseContract$View b;

    public /* synthetic */ o(RevLinkDialog r1, RevInteractDialogFragmentBaseContract$View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final RevLinkDialog r0 = this.a;
        RevInteractDialogFragmentBaseContract$View r1 = this.b;
        int r2 = RevLinkDialog.x;
        r0.U90();
        FragmentManager r3 = r0.getChildFragmentManager();
        FragmentTransaction r4 = r3.beginTransaction();
        if (r0.o.empty() == true) goto L6;
        r4.setCustomAnimations(2130772693, 2130772694, 2130772693, 2130772694);
    L6:
        if (r1 == null) goto L12;
        r0.V90(r1);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r4, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131373275) == true) goto L11;
        r4.add(2131373275, r1);
    L11:
        r4.addToBackStack("link_dialog");
        r0.o.add(r1);
    L16:
        r4.commitAllowingStateLoss();
        if (r1 == null) goto L19;
    L24:
        int r5 = s1.f(r1.U90());
        final ViewGroup.LayoutParams r6 = r0.g.getLayoutParams();
        if (r0.o.empty() == false) goto L27;
    L36:
        r6.height = r5;
        r0.g.setLayoutParams(r6);
    L37:
        r0.g.setLayoutParams(r6);
        return;
    L27:
        if (com.bytedance.android.live.revlink.impl.perf.f.a() == true) goto L36;
        int r7 = r6.height;
        ValueAnimator r8 = r0.q;
        if (r8 == null) goto L32;
        r8.removeAllUpdateListeners();
        r0.q.removeAllListeners();
        r0.q.cancel();
    L32:
        if (r7 > 0) goto L34;
        r7 = 0;
    L34:
        if (r7 == r5) goto L37;
        ValueAnimator r9 = ValueAnimator.ofInt(new int[]{r7, r5});
        r0.q = r9;
        r9.addUpdateListener(new p(r0, r6));
        r0.q.setDuration(300).start();
        goto L37
    L19:
        if (r0.o.isEmpty() == true) goto L39;
        r1 = r0.o.peek();
        if (r1 != null) goto L24;
        return;
    L39:
        return;
    L12:
        r3.popBackStack();
        Fragment r10 = r3.findFragmentById(2131373275);
        if (r10 == null) goto L15;
        r4.remove(r10);
    L15:
        r0.o.pop();
        r0.V90(r1);
        goto L16
    }
}

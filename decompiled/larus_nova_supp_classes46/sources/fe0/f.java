package fe0;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.LinkDialog;
import com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ LinkDialog a;
    public final /* synthetic */ InteractDialogFragmentBaseContract$View b;

    public /* synthetic */ f(LinkDialog r1, InteractDialogFragmentBaseContract$View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final LinkDialog r0 = this.a;
        InteractDialogFragmentBaseContract$View r1 = this.b;
        int r2 = LinkDialog.v;
        r0.T90();
        FragmentManager r3 = r0.getChildFragmentManager();
        FragmentTransaction r4 = r3.beginTransaction();
        if (r0.n.empty() == true) goto L6;
        r4.setCustomAnimations(2130772693, 2130772694, 2130772693, 2130772694);
    L6:
        if (r1 == null) goto L12;
        r0.U90(r1);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r4, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131373275) == true) goto L11;
        r4.add(2131373275, r1);
    L11:
        r4.addToBackStack("link_dialog");
        r0.n.add(r1);
    L16:
        r4.commitAllowingStateLoss();
        if (r1 == null) goto L19;
    L24:
        int r5 = s1.f(r1.T90());
        final ViewGroup.LayoutParams r6 = r0.f.getLayoutParams();
        if (r0.n.empty() == true) goto L33;
        int r7 = r6.height;
        ValueAnimator r8 = r0.p;
        if (r8 == null) goto L30;
        r8.removeAllUpdateListeners();
        r0.p.removeAllListeners();
        r0.p.cancel();
    L30:
        if (r7 > 0) goto L32;
        r7 = 0;
    L32:
        ValueAnimator r9 = ValueAnimator.ofInt(new int[]{r7, r5});
        r0.p = r9;
        r9.addUpdateListener(new g(r0, r6));
        r0.p.setDuration(300).start();
    L34:
        r0.f.setLayoutParams(r6);
        return;
    L33:
        r6.height = r5;
        r0.f.setLayoutParams(r6);
        goto L34
    L19:
        if (r0.n.isEmpty() == true) goto L36;
        r1 = r0.n.peek();
        if (r1 != null) goto L24;
        return;
    L36:
        return;
    L12:
        r3.popBackStack();
        Fragment r10 = r3.findFragmentById(2131373275);
        if (r10 == null) goto L15;
        r4.remove(r10);
    L15:
        r0.n.pop();
        r0.U90(r1);
        goto L16
    }
}

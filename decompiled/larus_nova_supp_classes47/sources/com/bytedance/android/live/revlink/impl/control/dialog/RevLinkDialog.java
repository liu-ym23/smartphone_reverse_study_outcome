package com.bytedance.android.live.revlink.impl.control.dialog;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorInteractContainerFragment;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPKBeInviteFragment;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkPrecisionMatchInviteFragment;
import com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkPrecisionMatchDataContext;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class RevLinkDialog extends LinkCommonDialogFragment implements r {
    public static final /* synthetic */ int x = 0;
    public int e;
    public RevInteractDialogFragmentBaseContract$View f;
    public ViewGroup g;
    public ViewGroup h;
    public ViewGroup i;
    public TextView j;
    public h k;
    public DataCenter l;
    public LifecycleOwner m;
    public final List<Runnable> n;
    public final Stack<RevInteractDialogFragmentBaseContract$View> o;
    public a p;
    public ValueAnimator q;
    public View r;
    public View s;
    public View t;
    public boolean u;
    public InteractPKBeInviteFragment v;
    public Animation w;

    public static final class a {
        public final DataCenter a;
        public final LifecycleOwner b;
        public IBaseUser c;
        public IRoom d;
        public String e;
        public i6 f;
        public int g;
        public boolean h;
        public PkPrecisionMatchDataContext i;

        public final RevLinkDialog a() {
            RevLinkDialog r0 = new RevLinkDialog();
            r0.p = this;
            r0.m = this.b;
            r0.l = this.a;
            return r0;
        }

        public final RevLinkDialog b(int r3) {
            RevLinkDialog r0 = new RevLinkDialog();
            r0.p = this;
            r0.m = this.b;
            r0.l = this.a;
            r0.e = r3;
            return r0;
        }

        public a(DataCenter r2, LifecycleOwner r3) {
            this.h = false;
            this.a = r2;
            this.b = r3;
        }
    }

    public final RevInteractDialogFragmentBaseContract$View T90() {
        if (this.o.empty() == false) goto L6;
        return null;
    L6:
        return this.o.peek();
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.r
    public final IRoom getCurrentRoom() {
        yz0.k r0 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L5;
        IRoom r1 = r0.getRoom();
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return vh7.f.c(IRoom.class);
    L5:
        r1 = null;
        goto L6
    }

    public final boolean onBackPressed() {
        if (this.o.isEmpty() == false) goto L5;
        return false;
    L5:
        if (this.o.peek().V90() == null) goto L9;
        this.o.peek().V90().performClick();
        return true;
    L9:
        if (this.o.size() == 1) goto L11;
        return false;
    L11:
        if (this.u == true) goto L13;
    L26:
        return true;
    L13:
        if (this.e != 1) goto L29;
        InteractPKBeInviteFragment r0 = this.v;
        if (r0 == null) goto L29;
        IBaseUser r8 = r0.m;
        if (r8 == null) goto L19;
        ((x31.f) r0.f).g(2, r0.n, r0.o, r8);
    L19:
        ((x31.f) r0.f).f();
    L29:
        dismiss();     // Catch: Exception -> L22
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L26;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L26
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.r
    public final int s9() {
        return this.o.size();
    }

    public RevLinkDialog() {
        this.e = 0;
        this.n = new ArrayList();
        this.o = new Stack();
        this.u = true;
    }

    public final void U90() {
        Dialog r0 = getDialog();
        Context r1 = getContext();
        if (r0 == null) goto L15;
        if (r1 == null) goto L18;
        View r2 = getDialog().getCurrentFocus();
        if (r2 != null) goto L9;
        return;
    L9:
        InputMethodManager r3 = (InputMethodManager) r1.getSystemService("input_method");
        if (r3 != null) goto L12;
        return;
    L12:
        if (r3.isActive() == false) goto L17;
        r3.hideSoftInputFromWindow(r2.getWindowToken(), 0);
        return;
    L17:
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.r
    public final void dismiss() {
        U90();
        super.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L12;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.k.a.clear();
    }

    public final void onDestroyView() {
        FragmentManager r0 = getFragmentManager();
        if (r0 != null) goto L6;
    L23:
        ViewGroup r1 = this.h;
        if (r1 == null) goto L26;
        r1.removeAllViews();
    L26:
        ViewGroup r2 = this.i;
        if (r2 == null) goto L29;
        r2.removeAllViews();
    L29:
        super.onDestroyView();
        ValueAnimator r3 = this.q;
        if (r3 == null) goto L32;
        r3.cancel();
    L32:
        this.o.removeAllElements();
        return;
    L6:
        if (r0.findFragmentByTag("random_pk_check_fragment") == null) goto L15;
        r0.findFragmentByTag("random_pk_check_fragment").dismiss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L15;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L15:
        if (r0.findFragmentByTag("randon_pk_attention_fragment") == null) goto L23;
        r0.findFragmentByTag("randon_pk_attention_fragment").dismiss();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L23;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L23
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (Lists.isEmpty(this.n) == true) goto L8;
        Iterator r0 = ((ArrayList) this.n).iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        ((Runnable) r0.next()).run();
    L8:
        ((ArrayList) this.n).clear();
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.r
    public final void so() {
        if ((T90() instanceof AnchorInteractContainerFragment) == true) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r0 = this.r.findViewById(2131388843).getLayoutParams();
        r0.height = s1.f(106.0f);
        this.r.findViewById(2131388843).setBackgroundColor(0);
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.r
    public final void v0() {
        if (getDialog() != null) goto L5;
        return;
    L5:
        if (this.o.isEmpty() == true) goto L10;
        this.u = true;
        S90(new m(this));
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.r
    public final LifecycleOwner getLifecycleOwner() {
        return this.m;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.r
    public final void F4(final boolean r2) {
        this.u = r2;
        setCancelable(r2);
        setBottomSheetSlideProcessor(new i(r2));
    }

    public final void S90(Runnable r2) {
        if (isResumed() == false) goto L5;
        r2.run();
        return;
    L5:
        ((ArrayList) this.n).add(r2);
    }

    public final void V90(Fragment r2) {
        if (r2 == null) goto L9;
        if (this.o.empty() == false) goto L6;
        return;
    L6:
        if (this.o.peek().getView() == null) goto L15;
        this.o.peek().getView().setVisibility(8);
        return;
    L15:
        return;
    L9:
        if (this.o.empty() == false) goto L11;
        return;
    L11:
        if (this.o.peek().getView() == null) goto L18;
        this.o.peek().getView().setVisibility(0);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.k = new h();
        AnimationUtils.loadAnimation(getContext(), 2130772675);
        this.w = AnimationUtils.loadAnimation(getContext(), 2130772676);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.r
    public final void zD(final RevInteractDialogFragmentBaseContract$View r2) {
        if (getDialog() == null) goto L8;
        if (r2 == null) goto L9;
        this.u = true;
        S90(new n(this, r2));
        return;
    L9:
        return;
    }

    public final void onViewCreated(View r7, Bundle r8) {
        super.onViewCreated(r7, r8);
        getChildFragmentManager().addOnBackStackChangedListener(new j(this));
        if (this.o.empty() == false) goto L36;
        RevInteractDialogFragmentBaseContract$View r9 = this.f;
        if (r9 == null) goto L7;
        zD(r9);
        goto L36
    L7:
        int r10 = this.e;
        if (r10 == 1) goto L20;
        if (r10 != 10) goto L12;
        DataCenter r1 = this.l;
        a r12 = this.p;
        int r2 = r12.g;
        boolean r4 = r12.h;
        int r13 = AnchorInteractContainerFragment.S;
        zD(AnchorInteractContainerFragment.Companion.a(this, r1, r2, "", r4, ""));
        this.p.h = false;
        goto L36
    L12:
        if (r10 != 12) goto L14;
        int r14 = InteractPkPrecisionMatchInviteFragment.x;
        zD(InteractPkPrecisionMatchInviteFragment.a.a(this, this.l, 1, this.p.i));
        goto L36
    L14:
        if (r10 != 13) goto L36;
        int r15 = InteractPkPrecisionMatchInviteFragment.x;
        zD(InteractPkPrecisionMatchInviteFragment.a.a(this, this.l, 2, null));
        goto L36
    L20:
        if (TextUtils.isEmpty(this.p.e) == true) goto L22;
        a r16 = this.p;
        r16.e = getString(2131919361);
    L22:
        i6 r17 = this.p.f;
        if (r17 == null) goto L36;
        if (j6.a(r17) == null) goto L36;
        if (j6.a(this.p.f).getInviteRoom() == null) goto L36;
        i6 r18 = this.p.f;
        InteractPKBeInviteFragment.T.getClass();
        Intrinsics.checkNotNullParameter(this, "view");
        Intrinsics.checkNotNullParameter(r18, "linkerMessage");
        InteractPKBeInviteFragment r0 = new InteractPKBeInviteFragment();
        r0.f = new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.d(r0, j6.a(r18));
        r0.d = this;
        r0.l = getCurrentRoom().getOwner();
        r0.o = getCurrentRoom().getId();
        r0.P = r18;
        if (r18 == null) goto L35;
        IBattleLinkerInviteMessageExtra r3 = j6.a(r18);
        Intrinsics.checkNotNull(r3);
        if (r3.getInviteRoom() == null) goto L34;
        IRoom r5 = r3.getInviteRoom();
        Intrinsics.checkNotNull(r5);
        r0.m = r5.getOwner();
    L34:
        r0.n = r18.getLinkerId();
        r0.v = r3.getInviteRoom();
        r0.u = r3.getTips();
        r0.w = (int) r3.getInviteType();
        r0.x = r3.getExtra();
        r0.y = r3.getTagList();
        r0.L = r3;
    L35:
        this.v = r0;
        zD(r0);
    L36:
        String r19 = getString(2131919437);
        KProperty[] r6 = l51.a.a;
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        l51.a.H.setValue(null, l51.a.a[33], r19);
        setBottomSheetSlideProcessor(new k());
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = LayoutInflater.from(getContext()).inflate(2131566084, r3, false);
        this.r = r5;
        this.j = (TextView) r5.findViewById(2131391606);
        this.h = (ViewGroup) this.r.findViewById(2131377533);
        this.i = (ViewGroup) this.r.findViewById(2131377602);
        this.g = (ViewGroup) this.r.findViewById(2131373275);
        this.s = this.r.findViewById(2131392587);
        View r6 = this.r.findViewById(2131381758);
        this.t = r6;
        r6.setAlpha(0.0f);
        this.t.setOnClickListener(new l(this));
        return this.r;
    }
}

package com.bytedance.android.live.livepkaudience.dialog;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class RevLinkDialog extends LiveDialogFragment implements k0 {
    public static final /* synthetic */ int u = 0;
    public int d;
    public ViewGroup e;
    public ViewGroup f;
    public ViewGroup g;
    public TextView h;
    public c0 i;
    public DataCenter j;
    public LifecycleOwner k;
    public final List<Runnable> l;
    public final Stack<RevInteractDialogFragmentBaseContract$View> m;
    public a n;
    public ValueAnimator o;
    public View p;
    public View q;
    public View r;
    public boolean s;
    public Animation t;

    public static final class a {
        public final DataCenter a;
        public final LifecycleOwner b;
        public Room c;
        public int d;
        public int e;
        public boolean f;
        public String g;

        public a(DataCenter r1, LifecycleOwner r2) {
            this.a = r1;
            this.b = r2;
        }

        public final RevLinkDialog a(String r2, int r3, Room r4, boolean r5) {
            this.d = 0;
            this.g = r2;
            this.e = r3;
            this.c = r4;
            this.f = r5;
            RevLinkDialog r6 = new RevLinkDialog();
            r6.n = this;
            r6.k = this.b;
            r6.j = this.a;
            r6.d = 16;
            return r6;
        }
    }

    public final boolean onBackPressed() {
        if (this.m.isEmpty() == true) goto L15;
        this.m.peek().getClass();
        if (this.m.size() == 1) goto L7;
        return false;
    L7:
        if (this.s == true) goto L17;
    L14:
        return true;
    L17:
        dismiss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L14;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L14
    L15:
        return false;
    }

    public RevLinkDialog() {
        this.d = 0;
        this.l = new ArrayList();
        this.m = new Stack();
        this.s = true;
    }

    public final void S90() {
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

    @Override // com.bytedance.android.live.livepkaudience.dialog.k0
    public final void dismiss() {
        S90();
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
        this.i.a.clear();
    }

    public final void onDestroyView() {
        getFragmentManager();
        ViewGroup r0 = this.f;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        ViewGroup r1 = this.g;
        if (r1 == null) goto L8;
        r1.removeAllViews();
    L8:
        super.onDestroyView();
        ValueAnimator r2 = this.o;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        this.m.removeAllElements();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (Lists.isEmpty(this.l) == true) goto L8;
        Iterator r0 = ((ArrayList) this.l).iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        ((Runnable) r0.next()).run();
    L8:
        ((ArrayList) this.l).clear();
    }

    public final void T90(Fragment r2) {
        if (r2 == null) goto L9;
        if (this.m.empty() == false) goto L6;
        return;
    L6:
        if (this.m.peek().getView() == null) goto L15;
        this.m.peek().getView().setVisibility(8);
        return;
    L15:
        return;
    L9:
        if (this.m.empty() == false) goto L11;
        return;
    L11:
        if (this.m.peek().getView() == null) goto L18;
        this.m.peek().getView().setVisibility(0);
        return;
    }

    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        Window r6 = getDialog().getWindow();
        if (r6 == null) goto L11;
        View r0 = r6.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L9:
        r0.setPadding(0, 0, 0, 0);
        r6.setLayout(-1, -1);
        r6.setGravity(80);
        r6.setBackgroundDrawable(new ColorDrawable(0));
        r6.setSoftInputMode(48);
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954719);
        this.i = new c0();
        AnimationUtils.loadAnimation(getContext(), 2130772675);
        this.t = AnimationUtils.loadAnimation(getContext(), 2130772676);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        super.onViewCreated(r6, r7);
        getChildFragmentManager().addOnBackStackChangedListener(new d0(this));
        if (this.m.empty() == true) goto L5;
    L13:
        com.bytedance.android.livesdk.sharedpref.e r8 = com.bytedance.android.livesdk.sharedpref.b.T;
        String r9 = getString(2131919437);
        r8.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r8, r9);
        setBottomSheetSlideProcessor(new e0());
        return;
    L5:
        if (this.d != 16) goto L13;
        DataCenter r10 = this.j;
        a r11 = this.n;
        int r0 = r11.d;
        String r1 = r11.g;
        int r2 = r11.e;
        Room r3 = r11.c;
        boolean r12 = r11.f;
        int r4 = PkAdminInviteFragment.w;
        Intrinsics.checkNotNullParameter(this, "dialog");
        Intrinsics.checkNotNullParameter(r10, "dataCenter");
        Intrinsics.checkNotNullParameter(r1, "requestPage");
        final PkAdminInviteFragment r5 = new PkAdminInviteFragment();
        r5.d = this;
        r5.o = r10;
        r5.p = r0;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r5.q = r1;
        r5.r = r2;
        r5.s = r3;
        r5.t = r12;
        r5.k = ((Boolean) r10.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        if (getDialog() == null) goto L13;
        this.s = true;
        Runnable r13 = new g0(this, r5);
        if (isResumed() == false) goto L12;
        r13.run();
        goto L13
    L12:
        ((ArrayList) this.l).add(r13);
        goto L13
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = LayoutInflater.from(getContext()).inflate(2131566077, r3, false);
        this.p = r5;
        this.h = (TextView) r5.findViewById(2131391606);
        this.f = (ViewGroup) this.p.findViewById(2131377533);
        this.g = (ViewGroup) this.p.findViewById(2131377602);
        this.e = (ViewGroup) this.p.findViewById(2131373275);
        this.q = this.p.findViewById(2131392587);
        View r6 = this.p.findViewById(2131381758);
        this.r = r6;
        r6.setAlpha(0.0f);
        this.r.setOnClickListener(new f0(this));
        return this.p;
    }
}

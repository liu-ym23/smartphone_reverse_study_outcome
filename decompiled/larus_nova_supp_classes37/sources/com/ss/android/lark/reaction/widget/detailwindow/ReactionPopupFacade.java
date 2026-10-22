package com.ss.android.lark.reaction.widget.detailwindow;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.reaction.widget.detailwindow.bean.ReactionDetailViewModel;
import com.ss.android.lark.reaction.widget.detailwindow.pager.ReactionListFragment;
import com.ss.android.lark.reaction.widget.detailwindow.scroller.ScrollableLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n2c.e;
import n2c.f;
import n2c.h;
import n2c.i;
import n2c.j;
import n2c.k;
import n2c.l;
import n2c.o;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class ReactionPopupFacade extends DialogFragment {
    public static final /* synthetic */ int j = 0;
    public View d;
    public n2c.d e;
    public c f;
    public d g;
    public final a h;
    public DialogInterface.OnDismissListener i;

    public class a implements com.ss.android.lark.reaction.widget.detailwindow.a.g {
        public final /* synthetic */ ReactionPopupFacade a;

        public final void a() {
            ReactionPopupFacade r0 = this.a;
            int r1 = ReactionPopupFacade.j;
            r0.getClass();
        }

        public a(ReactionPopupFacade r1) {
            this.a = r1;
        }

        public final void b(String r2) {
            c r0 = this.a.f;
            if (r0 == null) goto L6;
            r0.a(r2);
            return;
        }
    }

    public interface b {
    }

    public interface c {
        void a(String r1);
    }

    public interface d {
        void a(int r1);
    }

    public final void onDestroyView() {
        n2c.d r0 = this.e;
        if (r0 == null) goto L5;
        r0.a.getClass();
        r0.b.getClass();
    L5:
        super.onDestroyView();
    }

    public ReactionPopupFacade() {
        this.h = new a(this);
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        r1.setLayout(-1, -1);
        r1.setBackgroundDrawable(new ColorDrawable(0));
        return;
    L9:
        return;
    }

    public final void T90(List<ReactionDetailViewModel> r5) {
        n2c.d r0 = this.e;
        if (r0 == null) goto L17;
        n2c.c r1 = (n2c.c) r0.a;
        r1.getClass();
        if (r5 == null) goto L7;
        r1.a = new ArrayList(r5);
    L7:
        List<o2c.a> r6 = ((n2c.c) r0.a).a();
        n2c.b r2 = r0.b;
        String r3 = ((n2c.c) r0.a).b;
        final com.ss.android.lark.reaction.widget.detailwindow.a r4 = (com.ss.android.lark.reaction.widget.detailwindow.a) r2;
        r4.o = r6;
        Iterator r7 = ((ArrayList) r6).iterator();
    L9:
        if (r7.hasNext() == false) goto L11;
        ReactionListFragment r8 = ((o2c.a) r7.next()).a;
        r8.h = r4.t;
        r8.i = r4.u;
        goto L9
    L11:
        r4.p = r3;
        if (r4.h.getAdapter() == null) goto L14;
        r4.h.getAdapter().notifyDataSetChanged();
    L14:
        ((xuc.a) r4.s).a.notifyChanged();
        r4.h.post(new l(r4));
        return;
    }

    public final void U90(FragmentManager r3) {
        int r0 = DesktopUtil.a;
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, "ReactionPopupFacade", r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r1) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        show(r3, "ReactionPopupFacade");
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131953377);
    }

    public final void onDismiss(DialogInterface r2) {
        DialogInterface.OnDismissListener r0 = this.i;     // Catch: Throwable -> L8
        if (r0 == null) goto L5;
        r0.onDismiss(r2);     // Catch: Throwable -> L8
    L5:
        super.onDismiss(r2);     // Catch: Throwable -> L8
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L8:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        final com.ss.android.lark.reaction.widget.detailwindow.a r6 = new com.ss.android.lark.reaction.widget.detailwindow.a(this.h, getContext(), this);
        n2c.c r7 = new n2c.c(getArguments());
        this.e = new n2c.d(r7, r6);
        a r0 = (a) r6.l;
        r6.a = (ScrollableLayout) r0.a.d.findViewById(2131385250);
        r6.b = r0.a.d.findViewById(2131383755);
        r6.c = (ViewGroup) r0.a.d.findViewById(2131383748);
        r6.d = (ViewGroup) r0.a.d.findViewById(2131383751);
        r6.e = r0.a.d.findViewById(2131383750);
        r6.f = (ViewGroup) r0.a.d.findViewById(2131383744);
        r6.g = r0.a.d.findViewById(2131383747);
        r6.h = r0.a.d.findViewById(2131383752);
        r6.i = r0.a.d.findViewById(2131383745);
        r6.j = (ViewGroup) r0.a.d.findViewById(2131383749);
        r6.k = r0.a.d.findViewById(2131383746);
        int r1 = DesktopUtil.a;
        r6.j.setVisibility(8);
        r6.d.setVisibility(0);
        r6.a.getViewTreeObserver().addOnGlobalLayoutListener(new com.ss.android.lark.reaction.widget.detailwindow.c(r6));
        r6.a.setDraggableView(r6.d);
        r6.a.setCanScrollVerticallyDelegate(new h(r6));
        r6.a.setOnFlingOverListener(new i(r6));
        ScrollableLayout r2 = r6.a;
        com.ss.android.lark.reaction.widget.detailwindow.scroller.i r3 = new j(r6);
        ((ArrayList) r2.b).add(r3);
        r6.b.setOnClickListener(new k(r6));
        r6.i.setOnClickListener(new e(r6));
        r6.h.addOnPageChangeListener(new com.ss.android.lark.reaction.widget.detailwindow.b(r6));
        List<o2c.a> r8 = r7.a();
        String r9 = r7.b;
        r6.o = r8;
        Iterator r10 = ((ArrayList) r8).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ReactionListFragment r11 = ((o2c.a) r10.next()).a;
        r11.h = r6.t;
        r11.i = r6.u;
        goto L4
    L6:
        r6.p = r9;
        r6.h.setAdapter(new o(r6, r6.n.getChildFragmentManager()));
        wuc.a r12 = new wuc.a(r6.m);
        r12.setAdapter(r6.s);
        r6.g.setNavigator(r12);
        MagicIndicator r13 = r6.g;
        r6.h.addOnPageChangeListener(new tuc.c(r13));
        r6.h.post(new f(r6));
    }

    public static ReactionPopupFacade S90(List<ReactionDetailViewModel> r3, String r4, boolean r5) {
        ReactionPopupFacade r0 = new ReactionPopupFacade();
        Bundle r1 = new Bundle();
        r1.putSerializable("reaction_info_list", new ArrayList(r3));
        r1.putString("reaction_opened_type", r4);
        r1.putBoolean("key_need_loading", r5);
        r0.setArguments(r1);
        return r0;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131563389, r3, false);
        this.d = r5;
        return r5;
    }
}

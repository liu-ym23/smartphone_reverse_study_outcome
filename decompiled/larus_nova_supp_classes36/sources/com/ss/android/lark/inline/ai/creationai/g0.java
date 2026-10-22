package com.ss.android.lark.inline.ai.creationai;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.inline.ai.api.creationai.DragBar;
import com.ss.android.lark.inline.ai.api.creationai.Header;
import com.ss.android.lark.inline.ai.api.creationai.ItemContainer;
import com.ss.android.lark.inline.ai.api.creationai.MenuItem;
import com.ss.android.lark.inline.ai.api.creationai.StatusInfo;
import com.ss.android.lark.inline.ai.api.creationai.SubPanelInfo;
import com.ss.android.lark.inline.ai.api.creationai.Title;
import com.ss.android.lark.inline.ai.creationai.operates.ButtonGroupsRecyclerView;
import com.ss.android.lark.inline.ai.creationai.quickPrompt.QuickPromptRecyclerView;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g0 {
    public static final /* synthetic */ int t = 0;
    public final vlb.a a;
    public final vlb.b b;
    public final String c;
    public final FragmentActivity d;
    public final QuickPromptRecyclerView e;
    public final ViewGroup f;
    public final ConstraintLayout g;
    public final CreationAIDragView h;
    public final View i;
    public final ButtonGroupsRecyclerView j;
    public final ButtonGroupsRecyclerView k;
    public final TextView l;
    public final ViewGroup m;
    public final ViewGroup n;
    public boolean o;
    public int p;
    public long q;
    public Function1<? super Boolean, Unit> r;
    public c s;

    public static final class a implements CreationAIDragView.d {
        public final /* synthetic */ g0 a;

        @Override // com.ss.android.lark.inline.ai.creationai.CreationAIDragView.d
        public final void a(int r1) {
        }

        @Override // com.ss.android.lark.inline.ai.creationai.CreationAIDragView.d
        public final void b(boolean r1) {
        }

        @Override // com.ss.android.lark.inline.ai.creationai.CreationAIDragView.d
        public final void c() {
            Intrinsics.checkNotNullParameter("swipe_down", "closeType");
        }

        @Override // com.ss.android.lark.inline.ai.creationai.CreationAIDragView.d
        public final void d() {
            g0 r0 = this.a;
            Function1<? super Boolean, Unit> r1 = r0.r;
            if (r1 != null) goto L5;
            g0.c(r0, 3);
            return;
        L5:
            r1.invoke(Boolean.TRUE);
        }

        @Override // com.ss.android.lark.inline.ai.creationai.CreationAIDragView.d
        public final void onClose() {
            Intrinsics.checkNotNullParameter("swipe_down", "closeType");
            Log.i("SubPanelController", "onClose, closeType = swipe_down");
            g0.c(this.a, 3);
            Function1<? super Boolean, Unit> r0 = this.a.r;
            if (r0 == null) goto L6;
            r0.invoke(Boolean.FALSE);
            return;
        }

        public a(g0 r1) {
            this.a = r1;
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {
        public final /* synthetic */ SubPanelInfo a;
        public final /* synthetic */ g0 b;
        public final /* synthetic */ boolean c;

        public c(SubPanelInfo r1, g0 r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SubPanelInfo r0 = this.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            this.b.e(r0, this.c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public final FragmentActivity getActivity() {
        return this.d;
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void b(SubPanelInfo r10) {
        String r0 = null;
        if (r10 == null) goto L5;
        Header r1 = r10.getHeader();
    L6:
        boolean r2 = true;
        boolean r3 = false;
        if (r1 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        ViewGroup r5 = this.m;
        int r6 = 8;
        if (r4 == false) goto L15;
        int r7 = 0;
    L16:
        r5.setVisibility(r7);
        if (r4 == false) goto L60;
        if (r1 == null) goto L25;
        ItemContainer r8 = r1.getLeftItem();
        if (r8 == null) goto L25;
        if (r8.getShow() != true) goto L25;
        boolean r9 = true;
    L26:
        if (r9 == false) goto L32;
        this.j.setVisibility(0);
        ButtonGroupsRecyclerView r11 = this.j;
        ItemContainer r12 = r1.getLeftItem();
        if (r12 == null) goto L30;
        ArrayList<MenuItem> r13 = r12.getData();
    L31:
        r11.setData(r13);
    L33:
        if (r1 == null) goto L39;
        ItemContainer r14 = r1.getRightItem();
        if (r14 == null) goto L39;
        if (r14.getShow() != true) goto L39;
        boolean r15 = true;
    L40:
        if (r15 == false) goto L46;
        this.k.setVisibility(0);
        ButtonGroupsRecyclerView r16 = this.k;
        ItemContainer r17 = r1.getRightItem();
        if (r17 == null) goto L44;
        ArrayList<MenuItem> r18 = r17.getData();
    L45:
        r16.setData(r18);
    L47:
        if (r1 == null) goto L53;
        Title r19 = r1.getTitle();
        if (r19 == null) goto L53;
        if (r19.getShow() != true) goto L53;
        boolean r20 = true;
    L54:
        if (r20 == false) goto L59;
        this.l.setVisibility(0);
        TextView r21 = this.l;
        Title r22 = r1.getTitle();
        if (r22 == null) goto L58;
        r0 = r22.getText();
    L58:
        r21.setText(r0);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(new h0(this));
        goto L60
    L59:
        this.l.setVisibility(8);
    L53:
        r20 = false;
        goto L54
    L44:
        r18 = null;
        goto L45
    L46:
        this.k.setVisibility(8);
    L39:
        r15 = false;
        goto L40
    L30:
        r13 = null;
        goto L31
    L32:
        this.j.setVisibility(8);
    L25:
        r9 = false;
    L60:
        if (r10 == null) goto L93;
        StatusInfo r23 = r10.getStatus();
        if (r23 == null) goto L93;
        String r24 = r23.getStatus();
        if (r24 == null) goto L93;
        int r25 = r24.hashCode();
        if (r25 == (-1867169789)) goto L85;
        if (r25 == 96784904) goto L81;
        if (r25 != 336650556) goto L93;
        if (r24.equals("loading") == false) goto L93;
        this.n.setVisibility(0);
        this.n.findViewById(2131368225).setVisibility(0);
        this.n.findViewById(2131368223).setVisibility(8);
        if (r23.getText() == null) goto L79;
        ((TextView) this.g.findViewById(2131368228)).setText(r23.getText());
    L79:
        this.e.setVisibility(8);
        goto L93
    L81:
        if (r24.equals("error") == false) goto L93;
        this.n.setVisibility(0);
        this.n.findViewById(2131368225).setVisibility(8);
        this.n.findViewById(2131368223).setVisibility(0);
        this.e.setVisibility(8);
        goto L93
    L85:
        if (r24.equals("success") == false) goto L93;
        ArrayList<MenuItem> r26 = r10.getData();
        if (r26 != null) goto L90;
    L92:
        this.n.setVisibility(0);
        this.n.findViewById(2131368225).setVisibility(8);
        UDEmptyState r27 = this.n.findViewById(2131368223);
        r27.setVisibility(0);
        r27.setImageRes(2131238151);
        r27.setDesc(r23.getText());
        this.e.setVisibility(8);
        goto L93
    L90:
        if (r26.size() <= 0) goto L92;
        this.n.setVisibility(8);
        this.e.setVisibility(0);
    L93:
        if (r10 == null) goto L97;
        ArrayList<MenuItem> r28 = r10.getData();
        if (r28 == null) goto L97;
        this.e.setData(r28);
        this.e.setOnPromptClickListener(new i0(this));
    L97:
        if (r10 == null) goto L103;
        DragBar r29 = r10.getDragBar();
        if (r29 == null) goto L103;
        if (r29.getShow() != true) goto L103;
    L104:
        ViewGroup r30 = this.f;
        if (r2 == false) goto L107;
        r6 = 0;
    L107:
        r30.setVisibility(r6);
        CreationAIDragView r31 = this.h;
        if (r10 == null) goto L112;
        DragBar r110 = r10.getDragBar();
        if (r110 == null) goto L112;
        r3 = r110.getDoubleConfirm();
    L112:
        r31.B = r3;
        vlb.a r111 = this.a;
        if (r111.b == null) goto L115;
        return;
    L115:
        if (com.ss.android.lark.utils.m0.b(r111.getActivity()) == false) goto L122;
        ConstraintLayout r112 = this.g;
        ViewGroup.LayoutParams r32 = r112.getLayoutParams();
        if (r32 == null) goto L120;
        ViewGroup.MarginLayoutParams r33 = (ViewGroup.MarginLayoutParams) r32;
        r33.bottomMargin = com.ss.android.lark.utils.m0.a(this.a.getActivity());
        r112.setLayoutParams(r33);
        return;
    L120:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L122:
        return;
    L103:
        r2 = false;
        goto L104
    L15:
        r7 = 8;
        goto L16
    L9:
        if (r1.getShow() != true) goto L11;
        r4 = true;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public static void c(final g0 r4, int r5) {
        boolean r1 = false;
        if ((r5 & 1) == 0) goto L5;
        boolean r6 = true;
    L7:
        if (r4.g.getParent() == null) goto L9;
        r1 = true;
    L9:
        if (r1 == true) goto L11;
        return;
    L11:
        if (r4.o == true) goto L26;
        c r2 = r4.s;
        if (r2 == null) goto L19;
        vlb.a r3 = r4.a;
        View r7 = r3.b;
        if (r7 != null) goto L18;
        r7 = a(r3.getActivity().getWindow());
    L18:
        Intrinsics.checkNotNull(r7);
        r7.removeCallbacks(r2);
    L19:
        r4.o = true;
        if (Intrinsics.areEqual(r4.c, "model_setting_panel") == false) goto L22;
        r4.b.q("closeModelSetting");
    L23:
        final Function0 r8 = null;
        r4.h.h(r6, new SubPanelController$hide$2(r4, r8));
        return;
    L22:
        r4.b.q("closeHistory");
        goto L23
    L26:
        return;
    L5:
        r6 = false;
        goto L7
    }

    public final void d(SubPanelInfo r8, boolean r9) {
        if (this.g.getParent() == null) goto L5;
        b(r8);
        return;
    L5:
        int r0 = d0.b;
        long r1 = System.currentTimeMillis();
        if (d0.a != 0) goto L9;
        d0.a = r1;
    L9:
        if (this.a.c.isKeyboardShowing() == false) goto L18;
        rcb.c.c(this.a.getActivity());
        vlb.a r2 = this.a;
        View r3 = r2.b;
        if (r3 != null) goto L14;
        r3 = a(r2.getActivity().getWindow());
    L14:
        Intrinsics.checkNotNull(r3);
        Runnable r4 = this.s;
        if (r4 == null) goto L17;
        r3.removeCallbacks(r4);
    L17:
        c r5 = new c(r8, this, r9);
        this.s = r5;
        r3.postDelayed(r5, 140);
        return;
    L18:
        e(r8, r9);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void e(SubPanelInfo r4, boolean r5) {
        vlb.a r1 = this.a;     // Catch: Exception -> L12
        Object r2 = r1.b;     // Catch: Exception -> L12
        if (r2 != null) goto L7;
        r2 = a(r1.getActivity().getWindow());     // Catch: Exception -> L12
    L7:
        Intrinsics.checkNotNull(r2);     // Catch: Exception -> L12
        if ((r2 instanceof ViewGroup) == false) goto L10;
        ((ViewGroup) r2).addView(this.g);     // Catch: Exception -> L12
    L14:
        b(r4);
        this.h.r(null, null);
        CreationAIDragView r6 = this.h;
        r6.U = r5;
        r6.p(this.e);
        return;
    L10:
        Log.e("SubPanelController", "containerView is not ViewGroup!");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        Log.e("SubPanelController", "addToContainer error", e);
        goto L14
    }

    public g0(vlb.a r21, vlb.b r22, String r23) {
        Intrinsics.checkNotNullParameter(r21, "config");
        Intrinsics.checkNotNullParameter(r22, "callback");
        Intrinsics.checkNotNullParameter(r23, "tag");
        this.a = r21;
        this.b = r22;
        this.c = r23;
        this.d = r21.getActivity();
        LifecycleOwnerKt.getLifecycleScope(r21.getActivity());
        ConstraintLayout r2 = LayoutInflater.from(r21.getActivity()).inflate(2131559970, null, false);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout r7 = r2;
        this.g = r7;
        ConstraintLayout r3 = r7.findViewById(2131368266);
        View r4 = r7.findViewById(2131368263);
        this.i = r4;
        int r5 = com.ss.android.lark.inline.ai.utils.e.a;
        r4.setBackground(com.ss.android.lark.inline.ai.utils.e.b(r21.getActivity()));
        ViewGroup r6 = (ViewGroup) r3.findViewById(2131368241);
        this.f = r6;
        this.l = (TextView) r3.findViewById(2131368249);
        ButtonGroupsRecyclerView r15 = (ButtonGroupsRecyclerView) r3.findViewById(2131368247);
        this.j = r15;
        ButtonGroupsRecyclerView r14 = (ButtonGroupsRecyclerView) r3.findViewById(2131368248);
        this.k = r14;
        ViewGroup r13 = (ViewGroup) r3.findViewById(2131368246);
        this.m = r13;
        this.e = (QuickPromptRecyclerView) r3.findViewById(2131384936);
        this.n = (ViewGroup) r3.findViewById(2131368226);
        CreationAIDragView r12 = new CreationAIDragView(r21.getActivity(), r7, r3, r21.c, new a(this), r21.d, r21.e, r21.f, Intrinsics.areEqual(r23, "model_setting_panel"), r21.h);
        this.h = r12;
        Intrinsics.checkNotNullParameter(r6, "dragView");
        r6.setOnTouchListener(new CreationAIDragView.c(r12));
        r3.setOnClickListener(j0.a);
        r13.setOnClickListener(new k0(this));
        r15.setOnOperateClickListener(new l0(this));
        r14.setOnOperateClickListener(new m0(this));
    }
}

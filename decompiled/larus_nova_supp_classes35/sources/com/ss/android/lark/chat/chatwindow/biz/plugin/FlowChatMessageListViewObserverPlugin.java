package com.ss.android.lark.chat.chatwindow.biz.plugin;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.keyboard.event.ImeState;
import com.ss.android.lark.keyboard.ime.ExtensionImeKt;
import com.ss.android.lark.keyboard.ime.ImeStateDetail;
import com.ss.android.lark.keyboard.ime.ImeWrapper;
import com.ss.android.lark.keyboard.ime.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v99.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FlowChatMessageListViewObserverPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {
    public View g;
    public View h;
    public com.ss.android.lark.keyboard.ime.a i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public Integer n;
    public Integer o;
    public Pair<Integer, Integer> p;
    public final Function2<Integer, Integer, Unit> q;
    public final Lazy r;
    public final c s;
    public final d t;
    public final f u;
    public final e v;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ImeStateDetail.values().length];
            r0[ImeStateDetail.Enter.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ImeStateDetail.Show.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ FlowChatMessageListViewObserverPlugin a;

        public b(FlowChatMessageListViewObserverPlugin r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.J(null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements com.ss.android.lark.keyboard.ime.e {
        public final /* synthetic */ FlowChatMessageListViewObserverPlugin a;

        public final void J() {
            this.a.J(null);
        }

        public c(FlowChatMessageListViewObserverPlugin r1) {
            this.a = r1;
        }

        public final void a(int r2) {
            this.a.J(Integer.valueOf(r2));
        }

        public final void n(int r9, int r10, long r11, Interpolator r13) {
            Intrinsics.checkNotNullParameter(r13, "interpolator");
            FlowChatMessageListViewObserverPlugin r0 = this.a;
            if (r0.j == false) goto L17;
            r0.l = r9;
            r0.m = r10;
            r0.getClass();
            eya.b r1 = this.a.I();
            if (r1 == null) goto L9;
            s.a r2 = r1.b7();
            if (r2 == null) goto L9;
            r2.b(this.a.k, r9, r10, r11, r13);
        L9:
            eya.b r3 = this.a.I();
            if (r3 == null) goto L14;
            s.b r4 = r3.a7();
            if (r4 == null) goto L14;
            r4.b(this.a.k, r9, r10, r11, r13);
        L14:
            eya.b r12 = this.a.I();
            if (r12 == null) goto L17;
            boolean r14 = this.a.k;
            r12.e7(r13);
        L17:
            this.a.J(Integer.valueOf(r10));
        }

        public final void K(int r7, int r8, int r9, float r10, float r11) {
            if (this.a.j == false) goto L13;
            Intrinsics.checkNotNullParameter(ImeWrapper.B, "<this>");
            if (r7 != 2) goto L16;
            eya.b r12 = this.a.I();
            if (r12 == null) goto L14;
            s.b r0 = r12.a7();
            if (r0 == null) goto L15;
            r0.c(this.a.k, r8, r9, r10, r11);
            return;
        L15:
            return;
        L14:
            return;
        L16:
            return;
        }

        public final void g(int r7, int r8, int r9, int r10, float r11) {
            if (this.a.j == false) goto L13;
            Intrinsics.checkNotNullParameter(ImeWrapper.B, "<this>");
            if (r7 != 2) goto L16;
            eya.b r12 = this.a.I();
            if (r12 == null) goto L14;
            s.a r0 = r12.b7();
            if (r0 == null) goto L15;
            r0.c(this.a.k, r8, r9, r10, r11);
            return;
        L15:
            return;
        L14:
            return;
        L16:
            return;
        }
    }

    public static final class d implements i {
        public final /* synthetic */ FlowChatMessageListViewObserverPlugin a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ImeStateDetail.values().length];
                r0[ImeStateDetail.Enter.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[ImeStateDetail.Exit.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[ImeStateDetail.Show.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[ImeStateDetail.Hide.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        public d(FlowChatMessageListViewObserverPlugin r1) {
            this.a = r1;
        }

        public final void u(ImeState r2, ImeState r3) {
            Intrinsics.checkNotNullParameter(r2, "from");
            Intrinsics.checkNotNullParameter(r3, "to");
        }

        public final void B(ImeStateDetail r6, ImeStateDetail r7, int r8) {
            Intrinsics.checkNotNullParameter(r6, "from");
            Intrinsics.checkNotNullParameter(r7, "to");
            Intrinsics.checkNotNullParameter(ImeWrapper.B, "<this>");
            if (r8 == 2) goto L5;
            return;
        L5:
            int r9 = a.a[r7.ordinal()];
            if (r9 == 1) goto L50;
            boolean r2 = false;
            if (r9 != 2) goto L10;
            FlowChatMessageListViewObserverPlugin r10 = this.a;
            r10.p = null;
            r10.j = true;
            r10.k = false;
            return;
        L10:
            if (r9 != 3) goto L12;
        L16:
            FlowChatMessageListViewObserverPlugin r11 = this.a;
            if (r11.j == false) goto L38;
            r11.j = false;
            if (r6 != ImeStateDetail.Enter) goto L23;
            if (r7 != ImeStateDetail.Show) goto L23;
        L27:
            eya.b r12 = r11.I();
            if (r12 == null) goto L32;
            s.a r13 = r12.b7();
            if (r13 == null) goto L32;
            FlowChatMessageListViewObserverPlugin r14 = this.a;
            r13.a(r14.k, r14.l, r14.m, r2);
        L32:
            eya.b r15 = this.a.I();
            if (r15 == null) goto L38;
            s.b r16 = r15.a7();
            if (r16 == null) goto L38;
            FlowChatMessageListViewObserverPlugin r17 = this.a;
            r16.a(r17.k, r17.l, r17.m, r2);
        L23:
            if (r6 == ImeStateDetail.Exit) goto L25;
        L26:
            r2 = true;
            goto L27
        L25:
            if (r7 == ImeStateDetail.Hide) goto L27;
        L38:
            if (r7 != ImeStateDetail.Show) goto L43;
            FlowChatMessageListViewObserverPlugin r18 = this.a;
            Pair<Integer, Integer> r19 = r18.p;
            if (r19 == null) goto L42;
            FlowChatMessageListViewObserverPlugin.F(r18, ((Number) r19.component1()).intValue(), ((Number) r19.component2()).intValue());
        L42:
            this.a.p = null;
            return;
        L43:
            FlowChatMessageListViewObserverPlugin r20 = this.a;
            r20.p = null;
            Integer r21 = r20.o;
            if (r21 == null) goto L48;
            int r22 = r21.intValue();
            com.ss.android.lark.keyboard.ime.a r23 = r20.i;
            if (r23 == null) goto L48;
            r23.u(r22, true);
        L48:
            this.a.o = null;
            return;
        L12:
            if (r9 == 4) goto L16;
            throw new NoWhenBranchMatchedException();
        L50:
            FlowChatMessageListViewObserverPlugin r24 = this.a;
            r24.j = true;
            r24.k = true;
        }
    }

    public static final class e implements ChatWindowKeyboard.a {
        public final /* synthetic */ FlowChatMessageListViewObserverPlugin a;

        public final void a() {
        }

        public final void d() {
        }

        public final void f() {
        }

        public e(FlowChatMessageListViewObserverPlugin r1) {
            this.a = r1;
        }

        public final void g(com.ss.android.lark.keyboard.b r2) {
            Intrinsics.checkNotNullParameter(r2, "keyboard");
            this.a.G(r2.z());
        }
    }

    public static final class f implements View.OnLayoutChangeListener {
        public final /* synthetic */ FlowChatMessageListViewObserverPlugin a;

        public f(FlowChatMessageListViewObserverPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            this.a.J(null);
        }
    }

    public final eya.b I() {
        return (eya.b) this.r.getValue();
    }

    public FlowChatMessageListViewObserverPlugin() {
        this.q = new FlowChatMessageListViewObserverPlugin$bottomMenuHeightCallback$1(this);
        this.r = LazyKt.lazy(new FlowChatMessageListViewObserverPlugin$plusExtension$2(this));
        this.s = new c(this);
        this.t = new d(this);
        this.u = new f(this);
        this.v = new e(this);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void D() {
        eya.b r0 = I();
        if (r0 == null) goto L5;
        r0.f7(null);
    L5:
        this.p = null;
        this.o = null;
        View r1 = this.h;
        if (r1 == null) goto L8;
        r1.removeOnLayoutChangeListener(this.u);
    L8:
        this.h = null;
        this.g = null;
        com.ss.android.lark.keyboard.ime.a r2 = this.i;
        if (r2 == null) goto L11;
        r2.H(this.s);
    L11:
        ImeWrapper r3 = this.i;
        if ((r3 instanceof ImeWrapper) == false) goto L14;
        ImeWrapper r4 = r3;
    L15:
        if (r4 == null) goto L17;
        ExtensionImeKt.b(r4, this.t);
    L17:
        this.i = null;
        super.D();
        return;
    L14:
        r4 = null;
        goto L15
    }

    public final void G(com.ss.android.lark.keyboard.ime.a r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r4, this.i) == true) goto L27;
        com.ss.android.lark.keyboard.ime.a r0 = this.i;
        if (r0 == null) goto L9;
        r0.H(this.s);
    L9:
        ImeWrapper r1 = this.i;
        if ((r1 instanceof ImeWrapper) == false) goto L12;
        ImeWrapper r2 = r1;
    L13:
        if (r2 == null) goto L15;
        ExtensionImeKt.b(r2, this.t);
    L15:
        this.i = r4;
        eya.b r5 = I();
        if (r5 == null) goto L18;
        r5.f7(this.q);
    L18:
        com.ss.android.lark.keyboard.ime.a r6 = this.i;
        if (r6 == null) goto L21;
        r6.l(this.s);
    L21:
        com.ss.android.lark.keyboard.ime.a r7 = this.i;
        if (r7 == null) goto L24;
        ExtensionImeKt.a(r7, this.t);
    L24:
        J(null);
        return;
    L12:
        r2 = null;
        goto L13
    }

    public final View H(View r6) {
        if (r6 != null) goto L20;
        return null;
    L20:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        Object r3 = Result.constructor-impl(r6.findViewWithTag("flow_chat_message_list_view_observer"));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r3) == false) goto L12;
        r3 = null;
    L12:
        View r4 = (View) r3;
        if (r4 == null) goto L15;
        return r4;
    L15:
        int r0 = r6.getResources().getIdentifier("flow_chat_message_list_view_observer", "id", getContext().getPackageName());
        if (r0 != 0) goto L19;
        return null;
    L19:
        return r6.findViewById(r0);
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final void J(Integer r8) {
        if (this.e == false) goto L5;
        return;
    L5:
        View r0 = this.h;
        if (r0 != null) goto L10;
        r0 = B().getView();
        if (r0 != null) goto L10;
        return;
    L10:
        View r1 = this.g;
        if (r1 != null) goto L15;
        r1 = H(r0);
        this.g = r1;
        if (r1 != null) goto L15;
        return;
    L15:
        int r2 = (r0.getHeight() - r0.getPaddingTop()) - r0.getPaddingBottom();
        ViewGroup.LayoutParams r3 = r0.getLayoutParams();
        Integer r5 = null;
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
    L20:
        if (r4 == null) goto L22;
        int r6 = r4.topMargin;
    L23:
        int r7 = r2 - r6;
        ViewGroup.LayoutParams r9 = r0.getLayoutParams();
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
    L27:
        if (r10 == null) goto L29;
        int r11 = r10.bottomMargin;
    L30:
        int r12 = r7 - r11;
        if (r12 > 0) goto L33;
        return;
    L33:
        com.ss.android.lark.keyboard.ime.a r13 = this.i;
        if (r8 == null) goto L36;
        int r14 = r8.intValue();
    L41:
        boolean r15 = true;
        if (r13 != null) goto L44;
    L46:
        boolean r16 = false;
    L47:
        if (r16 == true) goto L57;
        if (r13 != null) goto L50;
    L52:
        boolean r17 = false;
    L53:
        if (r17 == true) goto L57;
        if (r14 > 0) goto L57;
        boolean r18 = false;
    L58:
        if (r18 == false) goto L60;
        int r19 = r14;
    L61:
        if (r13 != null) goto L63;
    L65:
        r15 = false;
    L66:
        if (r15 == false) goto L70;
        Integer r20 = this.o;
        if (r20 == null) goto L70;
        r19 = r20.intValue();
    L70:
        Integer r21 = this.n;
        if (r21 != null) goto L74;
    L75:
        this.n = Integer.valueOf(r19);
        eya.b r22 = I();
        if (r22 == null) goto L78;
        r22.S2(r19);
    L78:
        if (r18 == false) goto L80;
        r12 = RangesKt.coerceAtLeast(r12 - r14, 0);
    L80:
        ViewGroup.LayoutParams r23 = r1.getLayoutParams();
        if (r23 != null) goto L84;
        return;
    L84:
        if (r23.height != r12) goto L86;
        return;
    L86:
        r23.height = r12;
        r1.setLayoutParams(r23);
        r1.requestLayout();
        return;
    L74:
        if (r21.intValue() == r19) goto L78;
    L63:
        if (r13.B() != true) goto L65;
    L60:
        r19 = 0;
        goto L61
    L50:
        if (r13.B() != true) goto L52;
        r17 = true;
    L57:
        r18 = true;
        goto L58
    L44:
        if (r13.y() != true) goto L46;
        r16 = true;
        goto L47
    L36:
        if (r13 == null) goto L38;
        r5 = Integer.valueOf(r13.height());
    L38:
        if (r5 == null) goto L40;
        r14 = r5.intValue();
        goto L41
    L40:
        r14 = 0;
        goto L41
    L29:
        r11 = 0;
        goto L30
    L26:
        r10 = null;
        goto L27
    L22:
        r6 = 0;
        goto L23
    L18:
        r4 = null;
        goto L20
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void z(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, i7b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatApp");
        Intrinsics.checkNotNullParameter(r3, "initData");
        View r4 = B().getView();
        this.h = r4;
        if (r4 == null) goto L5;
        r4.addOnLayoutChangeListener(this.u);
    L5:
        this.g = H(this.h);
        ChatWindowKeyboard r5 = r2.n();
        if (r5 == null) goto L8;
        r5.m7(this.v);
    L8:
        if (r5 == null) goto L12;
        com.ss.android.lark.keyboard.b r6 = r5.n();
        if (r6 == null) goto L12;
        G(r6.z());
    L12:
        View r7 = this.h;
        if (r7 == null) goto L16;
        r7.post(new b(this));
        return;
    }

    public static final void F(FlowChatMessageListViewObserverPlugin r4, int r5, int r6) {
        if (r4.e == true) goto L24;
        if (r5 <= 0) goto L25;
        if (r6 <= 0) goto L28;
        com.ss.android.lark.keyboard.ime.a r0 = r4.i;
        if (r0 == null) goto L29;
        ImeStateDetail r1 = r0.getPanelState().b();
        int r2 = a.a[r1.ordinal()];
        boolean r3 = true;
        if (r2 != 1) goto L13;
        r4.p = TuplesKt.to(Integer.valueOf(r5), Integer.valueOf(r6));
        return;
    L13:
        if (r2 != 2) goto L30;
        r4.o = Integer.valueOf(r6);
        if (r5 >= r6) goto L19;
        r3 = false;
    L19:
        r0.u(r5, r3);
        if (r5 < r6) goto L26;
        r4.o = null;
        return;
    L26:
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L25:
        return;
    }
}

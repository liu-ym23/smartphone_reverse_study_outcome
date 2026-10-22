package com.obric.assistant.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.widget.TextView;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.AutoEndConversationScene;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.impl.activityresult.ActivityProxyRequestStoreKt;
import com.obric.assistant.state.api.multitask.IObricTaskFlowActiveStateService;
import com.obric.assistant.state.api.multitask.producer.ObricInteractionStateProducerDelegate;
import com.obric.assistant.state.api.multitask.state.ObricInteractionStateType;
import com.obric.assistant.state.api.v2.core.IObricStateDispatcherService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class p {
    public final va8.l a;
    public final s b;
    public final Function0<Boolean> c;
    public final Function0<TextView> d;
    public final String e;
    public final r f;
    public final Handler g;
    public KeepScreenOnDelegate h;
    public volatile boolean i;
    public long j;
    public long k;
    public zga.e l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public h q;
    public Runnable r;
    public i s;
    public oba.b t;
    public TextView u;
    public final b v;

    public static final class a {
    }

    public static final class b implements TextWatcher {
        public final /* synthetic */ p a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public b(p r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r4) {
            p r0 = this.a;
            ObricInteractionStateType r1 = ObricInteractionStateType.INPUT_TEXT_ACTIVE;
            if (r4 != null) goto L5;
        L8:
            boolean r5 = true;
        L9:
            p.u(r0, r1, !r5);
            return;
        L5:
            if (r4.length() == 0) goto L8;
            r5 = false;
            goto L9
        }
    }

    static {
    }

    public final void e() {
        this.n = false;
        TextView r0 = this.u;
        if (r0 == null) goto L5;
        r0.removeTextChangedListener(this.v);
    L5:
        this.u = null;
        A();
        b("destroy");
        this.g.removeCallbacksAndMessages(null);
        ObricInteractionStateProducerDelegate.b.a(this.e);
        FLogger.a.i("AutoDismissDelegate", "destroyed, ownerId=" + this.e);
    }

    public final void A() {
        this.j++;
        zga.e r0 = this.l;
        this.l = null;
        boolean r2 = false;
        this.m = false;
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("keep-screen delegate destroyed, ownerId=");
        r4.append(this.e);
        r4.append(", existed=");
        if (this.h == null) goto L5;
        boolean r5 = true;
    L6:
        r4.append(r5);
        r3.i("AutoDismissDelegate", r4.toString());
        KeepScreenOnDelegate r6 = this.h;
        if (r6 == null) goto L9;
        r6.e();
    L9:
        this.h = null;
        if (r0 != null) goto L23;
    L18:
        FLogger r1 = FLogger.a;
        StringBuilder r7 = new StringBuilder("active-state observer unregistered, ownerId=");
        r7.append(this.e);
        r7.append(", hadObserver=");
        if (r0 == null) goto L21;
        r2 = true;
    L21:
        r7.append(r2);
        r1.i("AutoDismissDelegate", r7.toString());
        return;
    L23:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L13
        Lazy r9 = zga.g.a;     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r0, "observer");     // Catch: Throwable -> L13
        ((IObricTaskFlowActiveStateService) zga.g.a.getValue()).a(r0);     // Catch: Throwable -> L13
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L18;
        FLogger.a.e("AutoDismissDelegate", "active-state observer unregistration failed, ownerId=" + this.e, r11);
    L13:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L5:
        r5 = false;
        goto L6
    }

    public final void a() {
        oba.b r0 = this.t;
        Unit r1 = null;
        this.t = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.cancel();     // Catch: Throwable -> L8
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Object r3 = Result.constructor-impl(r1);     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L16;
        FLogger.a.e("AutoDismissDelegate", "cancel attention check failed, ownerId=" + this.e, r4);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final void m() {
        FLogger.a.i("AutoDismissDelegate", "onPagePause");
        v(new com.obric.assistant.util.b(this));
    }

    public final void n() {
        FLogger.a.i("AutoDismissDelegate", "onPageResume");
        v(new g(this));
    }

    @AutoEndConversationScene
    public static int d() {
        return !IKeyguardStateKt.getKeyguardState().isKeyguardLocked() ? 1 : 0;
    }

    public final void y() {
        long r0 = c(d());
        if (r0 != (-1)) goto L7;
        b("initial follow system lock time");
        this.p = false;
        return;
    L7:
        if (r0 != 3500) goto L9;
        r0 = 8000;
    L9:
        w(r0, true, "initial schedule");
    }

    public static long c(@AutoEndConversationScene int r7) {
        if (r7 != 0) goto L4;
        long r0 = ActivityProxyRequestStoreKt.PROXY_CREATE_TIMEOUT_MS;
    L5:
        Long r8 = Long.valueOf(com.obric.assistant.t1.a.M1(r7));
        long r2 = r8.longValue();
        if (r2 != (-1)) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L15;
        r8 = null;
    L15:
        if (r8 != null) goto L17;
        return r0;
    L17:
        return r8.longValue();
    L8:
        if (r2 >= 0) goto L11;
        r3 = false;
        goto L12
    L4:
        r0 = 20000;
        goto L5
    }

    public static boolean h(ObricFloatChatPageState r1) {
        ObricFloatChatPageData.Companion.getClass();
        if ((r1 instanceof vda.a) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r1 instanceof vda.e) == true) goto L8;
        return false;
    }

    public final void b(String r5) {
        i r0 = this.s;
        if (r0 == null) goto L5;
        this.g.removeCallbacks(r0);
    L5:
        this.s = null;
        Runnable r1 = this.r;
        if (r1 == null) goto L8;
        this.g.removeCallbacks(r1);
    L8:
        this.r = null;
        h r2 = this.q;
        if (r2 == null) goto L11;
        this.g.removeCallbacks(r2);
    L11:
        this.q = null;
        a();
        this.k++;
        Object r3 = t.a;
        t.a(this.e);
        FLogger.a.i("AutoDismissDelegate", "dismiss canceled, ownerId=" + this.e + ", reason=" + r5);
    }

    public final KeepScreenOnDelegate f(boolean r4) {
        if (((Boolean) this.c.invoke()).booleanValue() == true) goto L9;
        FLogger.a.i("AutoDismissDelegate", "keep-screen delegate unavailable for non-window host, ownerId=" + this.e);
        KeepScreenOnDelegate r5 = this.h;
        if (r5 == null) goto L7;
        r5.e();
    L7:
        this.h = null;
        return null;
    L9:
        KeepScreenOnDelegate r0 = this.h;
        if (r0 != null) goto L15;
        if (r4 == false) goto L15;
        FLogger.a.i("AutoDismissDelegate", "keep-screen delegate created, ownerId=" + this.e);
        KeepScreenOnDelegate r6 = new KeepScreenOnDelegate(this.a, this.c, this.d);
        this.h = r6;
        return r6;
    L15:
        return r0;
    }

    public final void i(int r4) {
        FLogger.a.i("AutoDismissDelegate", "onActionBarScrollStateChanged state:" + r4);
        if (r4 != 0) goto L5;
        u(this, ObricInteractionStateType.ACTION_BAR_SCROLLING, false);
        return;
    L5:
        if (r4 != 1) goto L11;
        u(this, ObricInteractionStateType.ACTION_BAR_SCROLLING, true);
        return;
    }

    public final void l(boolean r4) {
        FLogger.a.i("AutoDismissDelegate", "onMessageModifyPanelVisibleChange visible:" + r4);
        u(this, ObricInteractionStateType.MESSAGE_MODIFY_VISIBLE, r4);
    }

    public final void o(final ObricFloatChatPageState r4) {
        Intrinsics.checkNotNullParameter(r4, "pageState");
        FLogger.a.i("AutoDismissDelegate", "onPageStateChange pageState:" + r4);
        v(new f(this, r4));
    }

    public final void p(boolean r4) {
        FLogger.a.i("AutoDismissDelegate", "onPopupOrDialogShow show:" + r4);
        u(this, ObricInteractionStateType.POPUP_OR_DIALOG_VISIBLE, r4);
    }

    public final void q(boolean r4) {
        FLogger.a.i("AutoDismissDelegate", "onScrollStateChange isScrolling:" + r4);
        u(this, ObricInteractionStateType.MESSAGE_LIST_SCROLLING, r4);
    }

    public final void r(boolean r4) {
        FLogger.a.i("AutoDismissDelegate", "onSecondaryMenuVisibleChange visible:" + r4);
        u(this, ObricInteractionStateType.SECONDARY_MENU_VISIBLE, r4);
    }

    public final void s(boolean r4) {
        FLogger.a.i("AutoDismissDelegate", "onTaskSkillPanelVisibleChanged visible:" + r4);
        u(this, ObricInteractionStateType.TASK_SKILL_PANEL_VISIBLE, r4);
    }

    public final void t(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        FLogger.a.i("AutoDismissDelegate", "onTouchIntercept event:" + r4);
        v(new l(this));
    }

    public final void v(final Function0<Unit> r3) {
        if (this.i == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L8;
        r3.invoke();
        return;
    L8:
        this.g.post(new k(this, r3));
    }

    public final void x(String r6) {
        long r0 = c(d());
        if (r0 != (-1)) goto L6;
        b("follow system lock time:" + r6);
        return;
    L6:
        w(r0, false, r6);
    }

    public final boolean z(String r6) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Lazy r1 = zga.g.a;     // Catch: Throwable -> L4
        r r2 = this.f;     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(r2, "filter");     // Catch: Throwable -> L4
        Object r3 = Result.constructor-impl(Boolean.valueOf(((IObricTaskFlowActiveStateService) zga.g.a.getValue()).b(r2)));     // Catch: Throwable -> L4
    L6:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L10;
        FLogger.a.e("AutoDismissDelegate", "active state check failed " + r6 + ", ownerId=" + this.e, r4);
        r3 = Boolean.TRUE;
    L10:
        boolean r5 = ((Boolean) r3).booleanValue();
        FLogger.a.i("AutoDismissDelegate", "active state checked, ownerId=" + this.e + ", active=" + r5 + ", reason=" + r6);
        return r5;
    L4:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final boolean g(long r4, zga.e r6) {
        if (this.i == false) goto L5;
    L13:
        return false;
    L5:
        if (r4 != this.k) goto L13;
        if (this.l != r6) goto L13;
        if (this.n == false) goto L13;
        if (h(this.b.getPageState()) == false) goto L13;
        return true;
    }

    public final void j(int r4, boolean r5) {
        FLogger r0 = FLogger.a;
        r0.i("AutoDismissDelegate", "onBottomPanelVisibleChanged type:" + r4 + " visible:" + r5);
        if (r4 != 0) goto L5;
        ObricInteractionStateType r6 = ObricInteractionStateType.INSTRUCTION_PANEL_VISIBLE;
    L16:
        u(this, r6, r5);
        return;
    L5:
        if (r4 != 1) goto L7;
        r6 = ObricInteractionStateType.KEYBOARD_VISIBLE;
        goto L16
    L7:
        if (r4 != 2) goto L9;
        r6 = ObricInteractionStateType.ATTACHMENT_PANEL_VISIBLE;
        goto L16
    L9:
        if (r4 == 3) goto L12;
        r0.w("AutoDismissDelegate", "ignore unknown bottom panel type:" + r4);
        return;
    L12:
        r6 = ObricInteractionStateType.BOTTOM_MENU_VISIBLE;
        goto L16
    }

    public final void k(boolean r4, boolean r5) {
        FLogger.a.i("AutoDismissDelegate", "onInputReplyPanelVisibleChange visible:" + r4 + " inVisibleState:" + r5);
        u(this, ObricInteractionStateType.INPUT_REPLY_VISIBLE, r4);
    }

    public static void u(p r3, ObricInteractionStateType r4, boolean r5) {
        Map<String, ? extends Object> r0 = MapsKt.emptyMap();
        if (r3.i == true) goto L10;
        if (r5 == false) goto L7;
        ObricInteractionStateProducerDelegate.b.b(r3.e, r4, r0);
    L8:
        FLogger.a.i("AutoDismissDelegate", "interaction forwarded, ownerId=" + r3.e + ",type=" + r4 + ",active=" + r5);
        return;
    L7:
        ObricInteractionStateProducerDelegate.b.c(r3.e, r4, r0);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v26, types: [com.obric.assistant.util.i, java.lang.Runnable] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.obric.assistant.util.h, java.lang.Runnable] */
    public final void w(final long r20, final boolean r22, String r23) {
        b("reschedule:" + r23);
        String r1 = "before schedule:" + r23;
        boolean r2 = h(this.b.getPageState());
        if (this.i == false) goto L5;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L15;
        Boolean r4 = Boolean.valueOf(z(r1));
    L16:
        if (r3 == true) goto L18;
    L20:
        boolean r5 = false;
    L21:
        FLogger r15 = FLogger.a;
        StringBuilder r6 = new StringBuilder("dismiss scheduling checked, ownerId=");
        r6.append(this.e);
        r6.append(", allowed=");
        r6.append(r5);
        r6.append(", reason=");
        r6.append(r1);
        r6.append(", destroyed=");
        r6.append(this.i);
        r6.append(", pageResumed=");
        r6.append(this.n);
        r6.append(", pageEligible=");
        r6.append(this.o);
        r6.append(", currentPageEligible=");
        r6.append(r2);
        r6.append(", observerRegistered=");
        if (this.l == null) goto L24;
        boolean r7 = true;
    L25:
        r6.append(r7);
        r6.append(", active=");
        r6.append(r4);
        r15.i("AutoDismissDelegate", r6.toString());
        if (r5 == true) goto L28;
        return;
    L28:
        this.p = false;
        final long r8 = this.k + 1;
        this.k = r8;
        final zga.e r9 = this.l;
        final int r10 = d();
        ?? r11 = new h(this, r8, r9, r10, r20, r22);
        this.q = r11;
        Object r12 = t.a;
        String r13 = this.e;
        Intrinsics.checkNotNullParameter(r13, "ownerId");
        Object r14 = t.a;
        monitor-enter(r14);
        Set<String> r16 = t.b;     // Catch: Throwable -> L42
        boolean r17 = r16.isEmpty();     // Catch: Throwable -> L42
        if (r16.add(r13) == false) goto L34;
        if (r17 == false) goto L34;
        boolean r18 = true;
    L35:
        monitor-exit(r14);
        if (r18 == false) goto L40;
        IObricStateDispatcherService r19 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);
        if (r19 == null) goto L40;
        r19.l();
    L40:
        this.g.postDelayed(r11, r20);
        q r21 = new q(r8, this, SystemClock.uptimeMillis() + r20, r22, r23);
        this.r = r21;
        this.g.postDelayed(r21, 1000);
        ?? r24 = new i(this, r8, r9);
        this.s = r24;
        this.g.postDelayed(r24, RangesKt.coerceAtLeast(r20 - 3000, 0));
        r15.i("AutoDismissDelegate", "dismiss cycle scheduled, ownerId=" + this.e + ", delayMs=" + r20 + ", initial=" + r22 + ", reason=" + r23);
        return;
    L34:
        r18 = false;
    L42:
        th = move-exception;
        throw th;
    L24:
        r7 = false;
        goto L25
    L18:
        if (Intrinsics.areEqual(r4, Boolean.FALSE) == false) goto L20;
        r5 = true;
        goto L21
    L15:
        r4 = null;
        goto L16
    L5:
        if (this.n == false) goto L12;
        if (this.l == null) goto L12;
        if (this.o == false) goto L12;
        if (r2 == false) goto L12;
        r3 = true;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.obric.assistant.util.r] */
    public p(va8.l r2, s r3, Function0<Boolean> r4, Function0<? extends TextView> r5) {
        Intrinsics.checkNotNullParameter(r3, "pageStateCallback");
        Intrinsics.checkNotNullParameter(r4, "isWindowHostProvider");
        Intrinsics.checkNotNullParameter(r5, "inputTextViewProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        final String r6 = UUID.randomUUID().toString();
        this.e = r6;
        Intrinsics.checkNotNullParameter(r6, "ownerId");
        this.f = new r(r6);
        this.g = new Handler(Looper.getMainLooper());
        this.p = true;
        this.v = new b(this);
    }
}

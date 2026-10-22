package com.obric.assistant.util;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ability.PageStateChangedReason;
import com.obric.assistant.component.ObricChatPageStateComponent;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j0 {
    public static final /* synthetic */ int x = 0;
    public final va8.l a;
    public final hca.d b;
    public final va8.c c;
    public final p d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public int i;
    public boolean j;
    public boolean k;
    public long l;
    public long m;
    public boolean n;
    public n1 o;
    public Integer p;
    public Integer q;
    public long r;
    public MessageListHeightDecoration s;
    public final Handler t;
    public final Lazy u;
    public int v;
    public boolean w;

    public static final class a {
    }

    static {
    }

    public final void i(int r2) {
        this.d.i(r2);
    }

    public final void j(int r2, boolean r3) {
        this.d.j(r2, r3);
    }

    public final void k(boolean r2, boolean r3) {
        this.d.k(r2, r3);
    }

    public final void l(boolean r2) {
        this.d.l(r2);
    }

    public final void m() {
        this.d.m();
    }

    public final void n() {
        this.d.n();
    }

    public final void o(boolean r2) {
        this.d.p(r2);
    }

    public final void q(boolean r2) {
        this.d.r(r2);
    }

    public final void t(boolean r2) {
        this.d.s(r2);
    }

    public final void u(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.d.t(r2);
    }

    public final b1 d() {
        this.d.getClass();
        return new b1();
    }

    public final FrameLayout e() {
        return (FrameLayout) this.f.getValue();
    }

    public final RecyclerView f() {
        return (RecyclerView) this.e.getValue();
    }

    public final ObricFloatChatPageState g() {
        return this.b.getPageState();
    }

    public final void h() {
        FLogger.a.i("AutoIncreaseUtils", "interruptMoveAction");
        this.k = true;
    }

    public final void p() {
        FLogger.a.i("AutoIncreaseUtils", "onReceiveAutoIncreaseMsg, pageState is " + g());
        com.larus.utils.t0.e(new f0(this));
    }

    public final a1 s() {
        this.d.getClass();
        return new a1();
    }

    public final z0 v() {
        this.d.getClass();
        return new z0();
    }

    public final void x() {
        FLogger.a.i("AutoIncreaseUtils", "tryAddLastItemHeightItemDecoration, layoutListener is " + this.o + ", messageList is " + f());
        if (this.o != null) goto L6;
        this.o = new n1(new u(this), new a0(this), new b0(this), null, 24);
    L6:
        if (this.s != null) goto L19;
        this.s = new MessageListHeightDecoration(new c0(this), null, 6);
        RecyclerView r0 = f();
        if (r0 == null) goto L19;
        int r1 = r0.getItemDecorationCount();
        boolean r2 = false;
        int r3 = 0;
    L10:
        if (r3 >= r1) goto L15;
        if (Intrinsics.areEqual(r0.getItemDecorationAt(r3), this.s) == true) goto L13;
        r3 = r3 + 1;
        goto L10
    L13:
        r2 = true;
    L15:
        if (r2 == true) goto L19;
        MessageListHeightDecoration r4 = this.s;
        if (r4 == null) goto L19;
        r0.addItemDecoration(r4);
    L19:
        n1 r5 = this.o;
        if (r5 == null) goto L30;
        RecyclerView r6 = f();
        if (r6 == null) goto L24;
        r6.removeOnLayoutChangeListener(r5);
    L24:
        RecyclerView r7 = f();
        if (r7 == null) goto L31;
        r7.addOnLayoutChangeListener(r5);
        return;
    L31:
        return;
    }

    public final void c(String r7) {
        if (this.q == null) goto L5;
    L6:
        FLogger.a.i("AutoIncreaseUtils", "clearPendingAutoIncreaseTopEmptyHeight, reason = " + r7 + ", pendingAutoIncreaseTopEmptyHeight = " + this.q + ", pendingAutoIncreaseMsgCreateTime = " + this.r);
    L7:
        this.q = null;
        this.r = Long.MAX_VALUE;
        return;
    L5:
        if (this.r == Long.MAX_VALUE) goto L7;
        goto L6
    }

    public final void r(final Message r7) {
        FLogger r0 = FLogger.a;
        r0.i("AutoIncreaseUtils", "onSendMessage, message is " + r7);
        if (r7 != null) goto L5;
    L8:
        if (r7 == null) goto L10;
        xg9.b.a().storeLong("last_msg_create_time", r7.getCreateTime());
        r0.i("AutoIncreaseUtils", "onSendMessage store createTime, createTime = " + r7.getCreateTime());
    L10:
        com.larus.utils.t0.e(new d0(this, r7));
        return;
    L5:
        if (com.larus.bmhome.chat.bean.d.T(r7) == false) goto L8;
        r0.i("AutoIncreaseUtils", "onSendMessage, empty message");
    }

    public final void w(String r4) {
        Intrinsics.checkNotNullParameter(r4, WindowEvent.Params.REASON);
        FLogger.a.i("AutoIncreaseUtils", "resetFirstMsgCreateTime, reason = ".concat(r4));
        this.l = Long.MAX_VALUE;
        c("resetFirstMsgCreateTime:".concat(r4));
    }

    public j0(va8.l r5, ObricChatPageStateComponent r6, final va8.c r7) {
        Intrinsics.checkNotNullParameter(r6, "callback");
        p r0 = new p(r5, new n(r6), new g0(), new h0(r7));
        Intrinsics.checkNotNullParameter(r6, "pageStateCallback");
        Intrinsics.checkNotNullParameter(r0, "autoDismissDelegate");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r0;
        this.e = LazyKt.lazy(new i0(this));
        this.f = LazyKt.lazy(new v(this));
        this.g = LazyKt.lazy(new w(this));
        this.h = LazyKt.lazy(new x(this));
        this.j = true;
        this.l = Long.MAX_VALUE;
        this.m = Long.MAX_VALUE;
        this.r = Long.MAX_VALUE;
        this.t = new Handler(Looper.getMainLooper());
        this.u = LazyKt.lazy(new y());
        RecyclerView r8 = f();
        if (r8 == null) goto L6;
        r8.addOnScrollListener(new AutoIncreaseUtils$3(this));
        return;
    }

    public static final void a(j0 r4, float r5, float r6, boolean r7) {
        r4.getClass();
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r1 = r4.g();
        r0.getClass();
        if ((r1 instanceof vda.f) == false) goto L6;
        return;
    L6:
        if ((r4.g() instanceof vda.c) == true) goto L8;
        r4.b.o2(r4.i);
    L8:
        boolean r2 = true;
        if (r7 == true) goto L11;
        int r8 = (int) r5;
        r4.b.o2(r4.i + r8);
        int r9 = -m2.c;
        int r10 = m2.d;
        if (r9 > r8) goto L53;
        if (r8 > r10) goto L53;
    L54:
        if (r2 == false) goto L56;
    L60:
        r4.j = r2;
        return;
    L56:
        if (r4.j == false) goto L60;
        if (r8 < r9) goto L60;
        if (r8 <= r10) goto L60;
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_SOFT);
    L53:
        r2 = false;
        goto L54
    L11:
        if (r6 >= (-1500.0f)) goto L16;
        if (r5 >= 0.0f) goto L16;
        r4.b.T7(Float.valueOf(r6), true, "");
        return;
    L16:
        if (r6 <= 1500.0f) goto L21;
        if (r5 <= 0.0f) goto L21;
        r4.b.T8(r6, false);
        return;
    L21:
        if (r5 <= 0.0f) goto L31;
        if (r5 >= m2.d) goto L29;
        Integer r11 = r4.p;
        if (r11 == null) goto L27;
        int r12 = r11.intValue();
    L28:
        b(r4, false, r12, false, 5);
    L48:
        r4.p = null;
        return;
    L27:
        r12 = r4.i;
        goto L28
    L29:
        r4.b.T8(r6, false);
        goto L48
    L31:
        if (Math.abs(r5) >= m2.c) goto L38;
        Integer r13 = r4.p;
        if (r13 == null) goto L35;
        int r14 = r13.intValue();
    L36:
        b(r4, false, r14, false, 5);
        goto L48
    L35:
        r14 = r4.i;
        goto L36
    L38:
        if (r4.g().getHeight() > m2.b) goto L40;
    L47:
        r4.b.T7(Float.valueOf(r6), true, "");
        goto L48
    L40:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L47;
        Integer r15 = r4.p;
        if (r15 == null) goto L45;
        int r16 = r15.intValue();
    L46:
        b(r4, false, r16, true, 1);
        goto L48
    L45:
        r16 = r4.i;
        goto L46
    }

    public static void b(j0 r7, boolean r8, int r9, boolean r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        boolean r1 = true;
    L7:
        if ((r11 & 4) == 0) goto L9;
        boolean r4 = false;
    L10:
        r7.b.i2(r1, r9, null, r4, false, PageStateChangedReason.OTHER);
        return;
    L9:
        r4 = r10;
        goto L10
    L5:
        r1 = r8;
        goto L7
    }
}

package yha;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.task.ObricTaskStatusManager;
import com.obric.assistant.util.MessageListHeightDecoration;
import com.obric.assistant.util.a1;
import com.obric.assistant.util.b1;
import com.obric.assistant.util.n1;
import com.obric.assistant.util.u0;
import com.obric.assistant.util.z0;
import com.obric.assistant.window.animation.ObricPageAutoIncreaseHelper$4;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class t {
    public final va8.l a;
    public final laa.d b;
    public final com.obric.assistant.util.p c;
    public long d;
    public long e;
    public n1 f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public Integer k;
    public Integer l;
    public long m;
    public final Handler n;
    public MessageListHeightDecoration o;
    public int p;
    public boolean q;
    public long r;
    public boolean s;
    public final u t;
    public final v u;

    public static final class a {
    }

    static {
    }

    public final void h(int r2) {
        this.c.i(r2);
    }

    public final void i(int r2, boolean r3) {
        this.c.j(r2, r3);
    }

    public final void k(boolean r2, boolean r3) {
        this.c.k(r2, r3);
    }

    public final void l(boolean r2) {
        this.c.l(r2);
    }

    public final void m() {
        this.c.m();
    }

    public final void n() {
        this.c.n();
    }

    public final void o(boolean r2) {
        this.c.p(r2);
    }

    public final void p(boolean r2) {
        this.c.r(r2);
    }

    public final void s(boolean r2) {
        this.c.s(r2);
    }

    public final void t(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.c.t(r2);
    }

    public final b1 c() {
        this.c.getClass();
        return new b1();
    }

    public final FrameLayout d() {
        return (FrameLayout) this.h.getValue();
    }

    public final int e() {
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        laa.d r1 = this.b;
        if (r1 == null) goto L5;
        ObricFloatChatPageState r2 = r1.getPageState();
    L6:
        r0.getClass();
        if ((r2 instanceof vda.f) == false) goto L10;
        int r3 = aia.f.a;
        return c7.b(4);
    L10:
        return i5.J();
    L5:
        r2 = null;
        goto L6
    }

    public final RecyclerView f() {
        return (RecyclerView) this.g.getValue();
    }

    public final void j() {
        FLogger r0 = FLogger.a;
        r0.i("ObricPageAutoIncreaseHelper", "onDestroy");
        this.n.removeCallbacksAndMessages(null);
        b("onDestroy");
        IAssistantChatWindow r1 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r1 == null) goto L5;
        r1.removeWindowAnimationListener(this.t);
    L5:
        IAssistantChatWindow r2 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r2 == null) goto L8;
        r2.removeWindowLifecycleListener(this.u);
    L8:
        final com.obric.assistant.util.p r3 = this.c;
        r3.getClass();
        r0.i("AutoDismissDelegate", "onDestroy destroyed:" + r3.i);
        if (r3.i == true) goto L17;
        r3.i = true;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L14;
        r3.e();
        return;
    L14:
        r3.g.post(new com.obric.assistant.util.e(r3));
        return;
    }

    public final a1 r() {
        this.c.getClass();
        return new a1();
    }

    public final z0 u() {
        this.c.getClass();
        return new z0();
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [yha.g] */
    /* JADX WARN: Type inference failed for: r5v1, types: [yha.r] */
    public final void w() {
        FLogger.a.i("ObricPageAutoIncreaseHelper", "tryAddLastItemHeightItemDecoration, layoutListener is " + this.f + ", messageList is " + f());
        if (this.f != null) goto L6;
        this.f = new n1(new o(this), new p(this), new q(this), new r(this), 8);
    L6:
        if (this.o != null) goto L19;
        this.o = new MessageListHeightDecoration(new s(this), new g(this), 2);
        RecyclerView r0 = f();
        if (r0 == null) goto L19;
        int r1 = r0.getItemDecorationCount();
        boolean r2 = false;
        int r3 = 0;
    L10:
        if (r3 >= r1) goto L15;
        if (Intrinsics.areEqual(r0.getItemDecorationAt(r3), this.o) == true) goto L13;
        r3 = r3 + 1;
        goto L10
    L13:
        r2 = true;
    L15:
        if (r2 == true) goto L19;
        MessageListHeightDecoration r4 = this.o;
        if (r4 == null) goto L19;
        r0.addItemDecoration(r4);
    L19:
        n1 r5 = this.f;
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

    public final void a(String r7) {
        if (this.l == null) goto L5;
    L6:
        FLogger.a.i("ObricPageAutoIncreaseHelper", "clearPendingAutoIncreaseTopEmptyHeight, reason = " + r7 + ", pendingAutoIncreaseTopEmptyHeight = " + this.l + ", pendingAutoIncreaseMsgCreateTime = " + this.m);
    L7:
        this.l = null;
        this.m = Long.MAX_VALUE;
        b(r7);
        return;
    L5:
        if (this.m == Long.MAX_VALUE) goto L7;
        goto L6
    }

    public final void b(String r7) {
        if (this.r == Long.MAX_VALUE) goto L5;
        FLogger.a.i("ObricPageAutoIncreaseHelper", "clearPendingRefreshOnWindowOpen, reason = " + r7 + ", msgCreateTime = " + this.r);
    L5:
        this.r = Long.MAX_VALUE;
    }

    public final void g(Message r7) {
        long r0 = this.d;
        IAssistantChatWindow r2 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r2 == null) goto L15;
        boolean r3 = r2.isShowing();
        if (r0 != Long.MAX_VALUE) goto L7;
        return;
    L7:
        if (r7.getCreateTime() < r0) goto L17;
        if (r3 == false) goto L11;
        return;
    L11:
        if (this.r == r0) goto L13;
        FLogger.a.i("ObricPageAutoIncreaseHelper", "markPendingRefreshOnWindowOpen, msgCreateTime = " + r0);
    L13:
        this.r = r0;
        return;
    L17:
        return;
    }

    public final void q(final Message r6) {
        FLogger r0 = FLogger.a;
        r0.i("ObricPageAutoIncreaseHelper", "onSendMessage, message is " + r6);
        ObricTaskStatusManager.a.getClass();
        String r1 = ObricTaskStatusManager.b();
        laa.d r3 = this.b;
        if (r3 == null) goto L7;
        boolean r4 = true;
        if (r3.aF() != true) goto L7;
    L8:
        if (r1 != null) goto L10;
    L14:
        if (r6 == null) goto L20;
        if (com.larus.bmhome.chat.bean.d.T(r6) == false) goto L20;
        r0.i("ObricPageAutoIncreaseHelper", "onSendMessage, empty message");
        return;
    L20:
        if (VoiceCallServiceDelegate.a.e() == false) goto L23;
        r0.i("ObricPageAutoIncreaseHelper", "onSendMessage, realtime call mode, return");
        return;
    L23:
        laa.d r2 = this.b;
        if (r2 == null) goto L26;
        ObricFloatChatPageState r5 = r2.getPageState();
    L27:
        ObricFloatChatPageData.Companion.getClass();
        if ((r5 instanceof vda.f) == false) goto L31;
        r0.i("ObricPageAutoIncreaseHelper", "landscape: " + r5 + ", return");
        return;
    L31:
        t0.e(new h(this, r6));
        return;
    L26:
        r5 = null;
        goto L27
    L10:
        if (Intrinsics.areEqual(r1, "start_complex_task") == true) goto L14;
        if (r4 == false) goto L14;
        r0.i("ObricPageAutoIncreaseHelper", "onSendMessage skip auto increase for complex task reply panel, openPanelType: " + r1 + ", isChatWindow: " + r4);
        return;
    L7:
        r4 = false;
        goto L8
    }

    public final void v(String r4) {
        Intrinsics.checkNotNullParameter(r4, WindowEvent.Params.REASON);
        FLogger.a.i("ObricPageAutoIncreaseHelper", "resetFirstMsgCreateTime, reason = ".concat(r4));
        this.d = Long.MAX_VALUE;
        a("resetFirstMsgCreateTime:".concat(r4));
    }

    public t(va8.l r3, laa.d r4, com.obric.assistant.window.d r5, com.obric.assistant.window.o r6) {
        Intrinsics.checkNotNullParameter(r5, "isWindowHostProvider");
        Intrinsics.checkNotNullParameter(r6, "inputTextViewProvider");
        if (r4 != null) goto L5;
        com.obric.assistant.util.s r1 = null;
    L6:
        if (r1 != null) goto L8;
        r1 = new u0();
    L8:
        com.obric.assistant.util.p r0 = new com.obric.assistant.util.p(r3, r1, r5, r6);
        Intrinsics.checkNotNullParameter(r0, "autoDismissDelegate");
        this.a = r3;
        this.b = r4;
        this.c = r0;
        this.d = Long.MAX_VALUE;
        this.e = Long.MAX_VALUE;
        this.g = LazyKt.lazy(new k(this));
        this.h = LazyKt.lazy(new l(this));
        this.i = LazyKt.lazy(new m(this));
        this.j = LazyKt.lazy(new n(this));
        this.m = Long.MAX_VALUE;
        this.n = new Handler(Looper.getMainLooper());
        this.r = Long.MAX_VALUE;
        u r7 = new u(this);
        this.t = r7;
        v r8 = new v(this);
        this.u = r8;
        FLogger.a.i("ObricPageAutoIncreaseHelper", "init");
        IAssistantChatWindow r9 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r9 == null) goto L11;
        r9.addWindowAnimationListener(r7);
    L11:
        IAssistantChatWindow r10 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r10 == null) goto L14;
        r10.addWindowLifecycleListener(r8);
    L14:
        RecyclerView r11 = f();
        if (r11 == null) goto L18;
        r11.addOnScrollListener(new ObricPageAutoIncreaseHelper$4(this));
        return;
    L18:
        return;
    L5:
        r1 = new com.obric.assistant.util.o(r4);
        goto L6
    }
}

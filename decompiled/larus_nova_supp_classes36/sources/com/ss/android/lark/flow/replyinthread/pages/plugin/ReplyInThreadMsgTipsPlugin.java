package com.ss.android.lark.flow.replyinthread.pages.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.RelativeLayout;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ReplyInThreadMsgTipsPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {
    public wgb.e g;
    public wgb.e h;
    public Chat i;
    public wgb.b<y6b.c<?>> j;
    public final Lazy k;
    public boolean l;
    public final com.larksuite.framework.callback.c m;
    public IMessageListComponent n;
    public IKeyboardComponent o;
    public IBannerComponent p;
    public ITitlebarComponent q;
    public int r;
    public int s;
    public zhb.a t;

    public static final class a {
    }

    public static final class b implements IMessageListComponent.a {
        public final /* synthetic */ ReplyInThreadMsgTipsPlugin a;
        public final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c b;

        public final /* synthetic */ void A9() {
        }

        public final void B9(ChatChatter r2) {
            Intrinsics.checkNotNullParameter(r2, "chatChatter");
        }

        public final void e(BasePageStore r2) {
            Intrinsics.checkNotNullParameter(r2, "store");
        }

        public final void w9(ThreadTopic r2) {
            Intrinsics.checkNotNullParameter(r2, "threadTopic");
        }

        public final /* synthetic */ void x9() {
        }

        public final void y9() {
            final ReplyInThreadMsgTipsPlugin r0 = this.a;
            IMessageListComponent r1 = r0.n;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2 = this.b;
            wgb.b<y6b.c<?>> r3 = r0.j;
            if (r3 == null) goto L7;
            boolean r4 = true;
            if (r3.d() != true) goto L7;
        L9:
            if (r4 == false) goto L11;
            Log.e("ReplyInThreadMsgTipsPlugin", "message tip is valid when init");
            return;
        L11:
            zhb.a r5 = r0.t;
            Chat r6 = null;
            if (r5 == null) goto L14;
            ThreadTopic r7 = r5.N1();
        L15:
            if (r7 != null) goto L17;
            Log.e("ReplyInThreadMsgTipsPlugin", "threadTopic is valid when init");
            return;
        L17:
            com.ss.android.lark.flow.replyinthread.pages.plugin.h r8 = new com.ss.android.lark.flow.replyinthread.pages.plugin.h(new i(r7), new j(r0), new k(r0));
            if (r1 == null) goto L61;
            RelativeLayout r9 = r1.UI();
            Log.i("ReplyInThreadMsgTipsPlugin", "init message tips view");
            if (r9 == null) goto L41;
            Context r10 = r9.getContext();
            if (r10 == null) goto L25;
            dwa.j r11 = dwa.j.d(r10);
            String r12 = Reflection.getOrCreateKotlinClass(wgb.e.class).getQualifiedName();
            r11.getClass();
            dwa.b.c(r12);
        L25:
            r0.g = new wgb.e(r9.getContext());
            RelativeLayout.LayoutParams r13 = new RelativeLayout.LayoutParams(-2, -2);
            r13.addRule(14);
            r13.addRule(10);
            wgb.e r14 = r0.g;
            if (r14 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageTopTip");
            r14 = null;
        L28:
            r9.addView(r14, r13);
            wgb.e r15 = r0.g;
            if (r15 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageTopTip");
            r15 = null;
        L31:
            r15.setVisibility(8);
            Context r16 = r9.getContext();
            if (r16 == null) goto L34;
            dwa.j r17 = dwa.j.d(r16);
            String r18 = Reflection.getOrCreateKotlinClass(wgb.e.class).getQualifiedName();
            r17.getClass();
            dwa.b.c(r18);
        L34:
            r0.h = new wgb.e(r9.getContext());
            RelativeLayout.LayoutParams r19 = new RelativeLayout.LayoutParams(-2, -2);
            r19.addRule(14);
            r19.addRule(8, 2131365579);
            wgb.e r20 = r0.h;
            if (r20 != null) goto L37;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageBottomTip");
            r20 = null;
        L37:
            r9.addView(r20, r19);
            wgb.e r21 = r0.h;
            if (r21 != null) goto L40;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageBottomTip");
            r21 = null;
        L40:
            r21.setVisibility(8);
        L41:
            Context r22 = r2.getContext();
            wgb.e r23 = r0.g;
            if (r23 != null) goto L44;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageTopTip");
            r23 = null;
        L44:
            wgb.e r24 = r0.h;
            if (r24 != null) goto L47;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageBottomTip");
            r24 = null;
        L47:
            wgb.b<y6b.c<?>> r25 = new wgb.b(r22, r8, r23, r24);
            r0.j = r25;
            r25.k(new com.ss.android.lark.flow.replyinthread.pages.plugin.b(r1, r0));
            r1.Vk(new com.ss.android.lark.flow.replyinthread.pages.plugin.c(r0));
            r1.eM(new com.ss.android.lark.flow.replyinthread.pages.plugin.d(r0, r1));
            r1.jX(new com.ss.android.lark.flow.replyinthread.pages.plugin.f(r0));
            r1.df(new com.ss.android.lark.flow.replyinthread.pages.plugin.g(r0));
            wgb.b<y6b.c<?>> r26 = r0.j;
            if (r26 == null) goto L50;
            r26.j();
        L50:
            wgb.b<y6b.c<?>> r27 = r0.j;
            if (r27 == null) goto L53;
            r27.g();
        L53:
            Chat r28 = r0.i;
            if (r28 != null) goto L56;
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentChat");
        L57:
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new l(r6.getId(), r0, new UIGetDataCallback(new ReplyInThreadMsgTipsPlugin$pullUnReadAtMessage$callback$1(r0))));
            return;
        L56:
            r6 = r28;
            goto L57
        L61:
            return;
        L14:
            r7 = null;
        L7:
            r4 = false;
            goto L9
        }

        public final void z9(Chat r2) {
            Intrinsics.checkNotNullParameter(r2, "chat");
            Intrinsics.checkNotNullParameter(r2, "chat");
            ReplyInThreadMsgTipsPlugin r0 = this.a;
            r0.i = r2;
            wgb.b<y6b.c<?>> r3 = r0.j;
            if (r3 == null) goto L6;
            int r1 = wgb.b.l;
            r3.m(false);
            return;
        }

        public b(ReplyInThreadMsgTipsPlugin r1, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, i7b.a r3) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements ChatWindowKeyboard.a {
        public final /* synthetic */ ReplyInThreadMsgTipsPlugin a;

        public static final class a implements Runnable {
            public final /* synthetic */ ReplyInThreadMsgTipsPlugin a;

            public a(ReplyInThreadMsgTipsPlugin r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                wgb.b<y6b.c<?>> r0 = this.a.j;     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                int r1 = wgb.b.l;     // Catch: Throwable -> L6
                r0.n(false);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public final void a() {
        }

        public final void d() {
            wgb.b<y6b.c<?>> r0 = this.a.j;
            if (r0 == null) goto L6;
            int r1 = wgb.b.l;
            r0.f(false);
            return;
        }

        public final void f() {
            UICallbackExecutor.executeDelayed(new a(this.a), 200);
        }

        public c(ReplyInThreadMsgTipsPlugin r1) {
            this.a = r1;
        }

        public final void g(com.ss.android.lark.keyboard.b r2) {
            Intrinsics.checkNotNullParameter(r2, "keyboard");
        }
    }

    public static final class d implements IBannerComponent.a {
        public final /* synthetic */ ReplyInThreadMsgTipsPlugin a;

        public final void c() {
            ReplyInThreadMsgTipsPlugin r0 = this.a;
            r0.s = 0;
            wgb.b<y6b.c<?>> r1 = r0.j;
            if (r1 == null) goto L6;
            r1.o();
            return;
        }

        public d(ReplyInThreadMsgTipsPlugin r1) {
            this.a = r1;
        }

        public final void a(int r2) {
            ReplyInThreadMsgTipsPlugin r0 = this.a;
            r0.s = r2;
            wgb.b<y6b.c<?>> r3 = r0.j;
            if (r3 == null) goto L6;
            r3.o();
            return;
        }

        public final void b(int r2) {
            ReplyInThreadMsgTipsPlugin r0 = this.a;
            r0.s = r2;
            wgb.b<y6b.c<?>> r3 = r0.j;
            if (r3 == null) goto L6;
            r3.o();
            return;
        }
    }

    public static final class e implements ITitlebarComponent.b {
        public e() {
        }
    }

    public static final class f implements ITitlebarComponent.f {
        public f() {
        }
    }

    public static final class g implements ITitlebarComponent.e {
        public g() {
        }
    }

    public static final class h implements ITitlebarComponent.a {
        public h() {
        }
    }

    static {
    }

    public ReplyInThreadMsgTipsPlugin() {
        this.k = LazyKt.lazy(ReplyInThreadMsgTipsPlugin$mBadgeProvider$2.INSTANCE);
        this.m = new com.larksuite.framework.callback.c(new Handler(Looper.getMainLooper()));
    }

    public final void D() {
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.D();
        this.m.d();
    }

    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r3, i7b.a r4) {
        Intrinsics.checkNotNullParameter(r3, "chatApp");
        Intrinsics.checkNotNullParameter(r4, "initData");
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.C(r3, r4);
        this.i = r4.f;
        w4b.c.e r0 = ChatCoreModule.a().getMultiTaskDependency();
        B();
        r0.a();
        zhb.a r1 = r3.getFragment();
        if ((r1 instanceof zhb.a) == false) goto L5;
        zhb.a r2 = r1;
    L6:
        this.t = r2;
        this.n = r3.a(IMessageListComponent.class);
        this.o = r3.a(IKeyboardComponent.class);
        this.p = r3.a(IBannerComponent.class);
        this.q = r3.a(ITitlebarComponent.class);
        IMessageListComponent r5 = this.n;
        if (r5 == null) goto L9;
        r5.m(new b(this, r3, r4));
    L9:
        IKeyboardComponent r6 = this.o;
        if (r6 == null) goto L12;
        r6.m(new c(this));
    L12:
        IBannerComponent r7 = this.p;
        if (r7 == null) goto L15;
        r7.jx(new d(this));
    L15:
        ITitlebarComponent r8 = this.q;
        if (r8 == null) goto L18;
        r8.kq(new e());
    L18:
        ITitlebarComponent r9 = this.q;
        if (r9 == null) goto L21;
        r9.sm(new f());
    L21:
        ITitlebarComponent r10 = this.q;
        if (r10 == null) goto L24;
        r10.pR(new g());
    L24:
        ITitlebarComponent r11 = this.q;
        if (r11 == null) goto L27;
        r11.OY(new h());
    L27:
        ITitlebarComponent r12 = this.q;
        if (r12 == null) goto L30;
        int r13 = r12.w3();
    L31:
        this.r = r13;
        return;
    L30:
        r13 = 0;
        goto L31
    L5:
        r2 = null;
        goto L6
    }
}

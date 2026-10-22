package com.ss.android.lark.flow.threadwindow.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.RelativeLayout;
import com.larksuite.framework.callback.UICallbackExecutor;
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
import dwa.j;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowThreadWindowMsgTipsPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {
    public wgb.e g;
    public wgb.e h;
    public Chat i;
    public wgb.b<y6b.c<?>> j;
    public boolean k;
    public final Lazy l;
    public final com.larksuite.framework.callback.c m;
    public IMessageListComponent n;
    public IKeyboardComponent o;
    public IBannerComponent p;
    public ITitlebarComponent q;

    public static final class a {
    }

    public static final class b implements IMessageListComponent.a {
        public final /* synthetic */ FlowThreadWindowMsgTipsPlugin a;
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
            FlowThreadWindowMsgTipsPlugin r0 = this.a;
            IMessageListComponent r1 = r0.n;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2 = this.b;
            wgb.b<y6b.c<?>> r3 = r0.j;
            if (r3 == null) goto L7;
            boolean r4 = true;
            if (r3.d() != true) goto L7;
        L9:
            if (r4 == false) goto L11;
            Log.e("FlowThreadWindowMsgTipsPlugin", "message tip is valid when init");
            return;
        L11:
            r7b.d r5 = new r7b.d(new com.ss.android.lark.flow.threadwindow.plugin.g(r0));
            if (r1 == null) goto L53;
            RelativeLayout r6 = r1.UI();
            Log.i("FlowThreadWindowMsgTipsPlugin", "init message tips view");
            wgb.e r7 = null;
            if (r6 == null) goto L35;
            Context r8 = r6.getContext();
            if (r8 == null) goto L19;
            j r9 = j.d(r8);
            String r10 = Reflection.getOrCreateKotlinClass(wgb.e.class).getQualifiedName();
            r9.getClass();
            dwa.b.c(r10);
        L19:
            r0.g = new wgb.e(r6.getContext());
            RelativeLayout.LayoutParams r11 = new RelativeLayout.LayoutParams(-2, -2);
            r11.addRule(14);
            r11.addRule(10);
            wgb.e r12 = r0.g;
            if (r12 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageTopTip");
            r12 = null;
        L22:
            r6.addView(r12, r11);
            wgb.e r13 = r0.g;
            if (r13 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageTopTip");
            r13 = null;
        L25:
            r13.setVisibility(8);
            Context r14 = r6.getContext();
            if (r14 == null) goto L28;
            j r15 = j.d(r14);
            String r16 = Reflection.getOrCreateKotlinClass(wgb.e.class).getQualifiedName();
            r15.getClass();
            dwa.b.c(r16);
        L28:
            r0.h = new wgb.e(r6.getContext());
            RelativeLayout.LayoutParams r17 = new RelativeLayout.LayoutParams(-2, -2);
            r17.addRule(14);
            r17.addRule(8, 2131365579);
            wgb.e r18 = r0.h;
            if (r18 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageBottomTip");
            r18 = null;
        L31:
            r6.addView(r18, r17);
            wgb.e r19 = r0.h;
            if (r19 != null) goto L34;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageBottomTip");
            r19 = null;
        L34:
            r19.setVisibility(8);
        L35:
            Context r20 = r2.getContext();
            wgb.e r21 = r0.g;
            if (r21 != null) goto L38;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageTopTip");
            r21 = null;
        L38:
            wgb.e r22 = r0.h;
            if (r22 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageBottomTip");
        L42:
            wgb.b<y6b.c<?>> r23 = new wgb.b(r20, r5, r21, r7);
            r0.j = r23;
            r23.k(new com.ss.android.lark.flow.threadwindow.plugin.a(r1, r0));
            r1.Vk(new com.ss.android.lark.flow.threadwindow.plugin.b(r0));
            r1.eM(new com.ss.android.lark.flow.threadwindow.plugin.c(r0, r1));
            r1.jX(new com.ss.android.lark.flow.threadwindow.plugin.e(r0));
            r1.df(new com.ss.android.lark.flow.threadwindow.plugin.f(r0));
            wgb.b<y6b.c<?>> r24 = r0.j;
            if (r24 == null) goto L45;
            r24.j();
        L45:
            wgb.b<y6b.c<?>> r25 = r0.j;
            if (r25 == null) goto L48;
            r25.g();
        L48:
            wgb.b<y6b.c<?>> r26 = r0.j;
            if (r26 == null) goto L54;
            r26.h(CollectionsKt.emptyList());
            return;
        L54:
            return;
        L41:
            r7 = r22;
            goto L42
        L53:
            return;
        L7:
            r4 = false;
            goto L9
        }

        public final void z9(Chat r2) {
            Intrinsics.checkNotNullParameter(r2, "chat");
            Intrinsics.checkNotNullParameter(r2, "chat");
            FlowThreadWindowMsgTipsPlugin r0 = this.a;
            r0.i = r2;
            wgb.b<y6b.c<?>> r3 = r0.j;
            if (r3 == null) goto L6;
            int r1 = wgb.b.l;
            r3.m(false);
            return;
        }

        public b(FlowThreadWindowMsgTipsPlugin r1, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, i7b.a r3) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements ChatWindowKeyboard.a {
        public final /* synthetic */ FlowThreadWindowMsgTipsPlugin a;

        public static final class a implements Runnable {
            public final /* synthetic */ FlowThreadWindowMsgTipsPlugin a;

            public a(FlowThreadWindowMsgTipsPlugin r1) {
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

        public c(FlowThreadWindowMsgTipsPlugin r1) {
            this.a = r1;
        }

        public final void g(com.ss.android.lark.keyboard.b r2) {
            Intrinsics.checkNotNullParameter(r2, "keyboard");
        }
    }

    public static final class d implements IBannerComponent.a {
        public final /* synthetic */ FlowThreadWindowMsgTipsPlugin a;

        public final void c() {
            this.a.getClass();
            wgb.b<y6b.c<?>> r0 = this.a.j;
            if (r0 == null) goto L6;
            r0.o();
            return;
        }

        public d(FlowThreadWindowMsgTipsPlugin r1) {
            this.a = r1;
        }

        public final void a(int r1) {
            this.a.getClass();
            wgb.b<y6b.c<?>> r2 = this.a.j;
            if (r2 == null) goto L6;
            r2.o();
            return;
        }

        public final void b(int r1) {
            this.a.getClass();
            wgb.b<y6b.c<?>> r2 = this.a.j;
            if (r2 == null) goto L6;
            r2.o();
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

    public FlowThreadWindowMsgTipsPlugin() {
        this.l = LazyKt.lazy(FlowThreadWindowMsgTipsPlugin$mBadgeProvider$2.INSTANCE);
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
        this.n = r3.a(IMessageListComponent.class);
        this.o = r3.a(IKeyboardComponent.class);
        this.p = r3.a(IBannerComponent.class);
        this.q = r3.a(ITitlebarComponent.class);
        IMessageListComponent r1 = this.n;
        if (r1 == null) goto L5;
        r1.m(new b(this, r3, r4));
    L5:
        IKeyboardComponent r5 = this.o;
        if (r5 == null) goto L8;
        r5.m(new c(this));
    L8:
        IBannerComponent r6 = this.p;
        if (r6 == null) goto L11;
        r6.jx(new d(this));
    L11:
        ITitlebarComponent r7 = this.q;
        if (r7 == null) goto L14;
        r7.kq(new e());
    L14:
        ITitlebarComponent r8 = this.q;
        if (r8 == null) goto L17;
        r8.sm(new f());
    L17:
        ITitlebarComponent r9 = this.q;
        if (r9 == null) goto L20;
        r9.pR(new g());
    L20:
        ITitlebarComponent r10 = this.q;
        if (r10 == null) goto L23;
        r10.OY(new h());
    L23:
        ITitlebarComponent r11 = this.q;
        if (r11 == null) goto L27;
        r11.w3();
        return;
    }
}

package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.utils.MorePanelBubbleAlog;
import com.bytedance.android.livesdk.config.c11;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.a {
    public final CompositeDisposable b;
    public final C0061b c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business.b$b, reason: collision with other inner class name */
    public static final class C0061b implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i {
        public final ToolbarButton a;
        public final pp1.c b;
        public final a c;
        public final /* synthetic */ BubbleEnv d;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business.b$b$a */
        public static final class a implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a {
            public final /* synthetic */ C0061b a;

            @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a
            public final void a(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i r2) {
                Intrinsics.checkNotNullParameter(r2, "bubble");
            }

            @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a
            public final void b(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i r2) {
                Intrinsics.checkNotNullParameter(r2, "bubble");
            }

            public a(C0061b r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a
            public final void c(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i r2) {
                Intrinsics.checkNotNullParameter(r2, "bubble");
                com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b r3 = this.a.d.a().query(r2.getId());
                if (r3 == null) goto L6;
                r3.h();
                this.a.d.a().f(r3);
                return;
            }
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final int getId() {
            return BubbleId.LiveAdmin;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final ToolbarButton a() {
            return this.a;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a getCallback() {
            return this.c;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final pp1.c getView() {
            return this.b;
        }

        public C0061b(BubbleEnv r1) {
            this.d = r1;
            this.a = ToolbarButton.MANAGE;
            int r2 = pp1.c.o;
            this.b = pp1.c.a.a("管理员功能可在这里查看");
            this.c = new a(this);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            if (((UserAttr) r1).isAdmin() == false) goto L5;
            this.a.b();
        L5:
            this.a.b.clear();
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final boolean S8() {
        if (c11.a.getValue().booleanValue() == true) goto L5;
        return false;
    L5:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g r0 = this.a.a();
        this.c.getClass();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b r1 = r0.query(BubbleId.LiveAdmin);
        if (r1 != null) goto L8;
    L11:
        return true;
    L8:
        if (r1.g() != true) goto L11;
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r2 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r2.d("LiveAdminBubbleLoader");
        r2.c("管理员功能气泡已经展示过了，不予再展示");
        MorePanelBubbleAlog.a(r2.b());
        return false;
    }

    public final void b() {
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g r0 = this.a.a();
        this.c.getClass();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b r1 = r0.query(BubbleId.LiveAdmin);
        if (r1 != null) goto L5;
    L6:
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r2 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r2.d("LiveAdminBubbleLoader");
        r2.c("展示管理员功能引导气泡");
        MorePanelBubbleAlog.a(r2.b());
        a();
        return;
    L5:
        if (r1.g() != true) goto L6;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final void onLoad() {
        com.bytedance.android.livesdk.user.e r0 = jc1.k.n(IMiddlewareUserService.class).user();
        if (r0.isAdmin() == false) goto L5;
        b();
        return;
    L5:
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r1 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r1.d("LiveAdminBubbleLoader");
        r1.c("进房检测到当前用户非管理员，监听身份变化消息");
        MorePanelBubbleAlog.a(r1.b());
        RxUtilKt.c(r0.u().subscribe(new c(this)), this.b);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final void onUnload() {
        this.b.clear();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i T8() {
        return this.c;
    }

    public b(BubbleEnv r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
        this.b = new CompositeDisposable();
        this.c = new C0061b(r2);
    }
}

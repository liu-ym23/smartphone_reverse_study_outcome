package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.interactivity.api.settings.config.x;
import kotlin.jvm.internal.Intrinsics;
import r52.c3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.a {
    public final x b;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business.a$a, reason: collision with other inner class name */
    public static final class C0059a implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i {
        public final ToolbarButton a;
        public final pp1.c b;
        public final C0060a c;
        public final /* synthetic */ a d;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business.a$a$a, reason: collision with other inner class name */
        public static final class C0060a implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a {
            public final /* synthetic */ C0059a a;

            @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a
            public final void a(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i r2) {
                Intrinsics.checkNotNullParameter(r2, "bubble");
            }

            @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a
            public final void c(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i r2) {
                Intrinsics.checkNotNullParameter(r2, "bubble");
            }

            public C0060a(C0059a r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a
            public final void b(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i r2) {
                Intrinsics.checkNotNullParameter(r2, "bubble");
                com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b r3 = this.a.d.a.a().query(r2.getId());
                if (r3 == null) goto L6;
                r3.h();
                this.a.d.a.a().f(r3);
                return;
            }
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final int getId() {
            return BubbleId.AudiencePublicScreenConfig;
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

        public C0059a(a r2) {
            this.d = r2;
            this.a = ToolbarButton.AUDIENCE_PUBLIC_SCREEN_CONFIG;
            int r3 = pp1.c.o;
            Intrinsics.checkNotNullParameter("评论区文字和高度支持设置啦", "content");
            pp1.c.a.C0410a r4 = new pp1.c.a.C0410a("评论区文字和高度支持设置啦");
            r4.b = 5;
            this.b = r4.a();
            this.c = new C0060a(this);
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final void onUnload() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final boolean S8() {
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b r0 = this.a.a().query(BubbleId.AudiencePublicScreenConfig);
        if (r0 != null) goto L5;
    L6:
        x r1 = this.b;
        if (r1.enable == true) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == true) goto L14;
        return false;
    L14:
        if (z.e(this.a.c, true) == true) goto L29;
        IMiddlewareUserService r3 = jc1.k.f(IMiddlewareUserService.class);
        if (r3 == null) goto L22;
        com.bytedance.android.livesdk.user.e r4 = r3.user();
        if (r4 == null) goto L22;
        IBaseUser r5 = r4.b();
        if (r5 == null) goto L22;
        int r6 = r5.getAgeRange();
    L24:
        if (r6 < 4) goto L30;
        return true;
    L30:
        return false;
    L22:
        r6 = -1;
        goto L24
    L29:
        return false;
    L9:
        if (r1.settingEntryPos != 1) goto L11;
        r2 = true;
        goto L12
    L5:
        if (r0.g() != true) goto L6;
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i T8() {
        return new C0059a(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final void onLoad() {
        a();
    }

    public a(BubbleEnv r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
        this.b = (x) c3.a.getValue();
    }
}

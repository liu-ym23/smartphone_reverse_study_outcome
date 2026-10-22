package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.utils.MorePanelBubbleAlog;
import com.bytedance.android.livesdk.config.c11;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/bubble/business/AdminPrivilegeBubbleLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/bubble/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdminPrivilegeBubbleLoader extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.a implements Observer<KVData> {
    public ToolbarButton b;
    public final b c;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i {
        public final pp1.c a;
        public final a b;
        public final /* synthetic */ AdminPrivilegeBubbleLoader c;
        public final /* synthetic */ BubbleEnv d;

        public static final class a implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a {
            public final /* synthetic */ b a;

            @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a
            public final void a(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i r2) {
                Intrinsics.checkNotNullParameter(r2, "bubble");
            }

            @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a
            public final void b(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i r2) {
                Intrinsics.checkNotNullParameter(r2, "bubble");
            }

            public a(b r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a
            public final void c(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i r2) {
                Intrinsics.checkNotNullParameter(r2, "bubble");
                com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g r3 = this.a.d.a();
                this.a.getClass();
                com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b r4 = r3.query(BubbleId.AdminPrivilege);
                if (r4 == null) goto L6;
                r4.h();
                this.a.d.a().f(r4);
                return;
            }
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final int getId() {
            return BubbleId.AdminPrivilege;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final ToolbarButton a() {
            return this.c.b;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a getCallback() {
            return this.b;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final pp1.c getView() {
            return this.a;
        }

        public b(AdminPrivilegeBubbleLoader r1, BubbleEnv r2) {
            this.c = r1;
            this.d = r2;
            int r3 = pp1.c.o;
            this.a = pp1.c.a.a("新获得的管理员权限可在这里查看");
            this.b = new a(this);
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
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b r1 = r0.query(BubbleId.AdminPrivilege);
        if (r1 != null) goto L8;
    L11:
        return true;
    L8:
        if (r1.g() != true) goto L11;
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r2 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r2.d("AdminPrivilegeBubbleLoader");
        r2.c("管理员权限气泡已经展示过了，不予再展示");
        MorePanelBubbleAlog.a(r2.b());
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final void onLoad() {
        DataCenter r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.observe("cmd_show_admin_bubble_in_more", this);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final void onUnload() {
        DataCenter r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.removeObserver(this);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i T8() {
        return this.c;
    }

    public AdminPrivilegeBubbleLoader(BubbleEnv r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
        this.b = ToolbarButton.MANAGE;
        this.c = new b(this, r2);
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        Object r0 = null;
        if (r6 == null) goto L5;
        String r1 = r6.getKey();
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.hashCode() == (-651182679)) goto L12;
        return;
    L12:
        if (r1.equals("cmd_show_admin_bubble_in_more") == false) goto L27;
        Object r7 = r6.getData();
        if ((r7 instanceof ToolbarButton) == false) goto L17;
        r0 = r7;
    L17:
        ToolbarButton r2 = (ToolbarButton) r0;
        if (r2 == null) goto L28;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g r8 = this.a.a();
        this.c.getClass();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b r9 = r8.query(BubbleId.AdminPrivilege);
        if (r9 != null) goto L22;
    L25:
        this.b = r2;
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r10 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r10.d("AdminPrivilegeBubbleLoader");
        r10.c("展示管理员权利气泡，关联的按钮为 【" + r2.name() + "】");
        MorePanelBubbleAlog.a(r10.b());
        a();
        return;
    L22:
        if (r9.g() != true) goto L25;
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r11 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r11.d("AdminPrivilegeBubbleLoader");
        r11.c("无法展示管理员权利气泡（受频控限制），关联的按钮为 【" + r2.name() + "】");
        MorePanelBubbleAlog.a(r11.b());
        return;
    L28:
        return;
    L27:
        return;
    L5:
        r1 = null;
        goto L6
    }
}

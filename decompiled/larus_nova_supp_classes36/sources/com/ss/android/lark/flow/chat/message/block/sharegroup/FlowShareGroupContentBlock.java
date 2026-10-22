package com.ss.android.lark.flow.chat.message.block.sharegroup;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.base.view.vo.message.ShareGroupChatContentVO;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ShareGroupChatContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.statistics.message.MessageHitPoint;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;
import w4b.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowShareGroupContentBlock extends ShareGroupChatContentBlock {

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ShareGroupChatContentBlock.b a;

        public b(ShareGroupChatContentBlock.b r1) {
            this.a = r1;
        }

        public final void a() {
            float r0 = Layout.getDesiredWidth(this.a.f.getText().toString(), 0, this.a.f.getText().length(), this.a.f.getPaint());
            float r1 = UIUtils.dp2px(this.a.a.getContext(), 26.0f);
            ShareGroupChatContentBlock.b r2 = this.a;
            r2.e.setMaxWidth((int) ((r2.a.getWidth() - r0) - r1));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ FlowShareGroupContentBlock a;
        public final /* synthetic */ y6b.a<?> b;

        public c(FlowShareGroupContentBlock r1, y6b.a<?> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            g r5 = ChatCoreModule.a().getChatDependency();
            m2b.a r0 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this.a).c;
            y6b.a<?> r1 = this.b;
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.AbsMessageVO<com.ss.android.lark.chat.base.view.vo.message.ShareGroupChatContentVO>");
            r5.k(r0, r1);
        }
    }

    public static final class d implements View.OnLongClickListener {
        public final /* synthetic */ m<y6b.a<?>> a;
        public final /* synthetic */ FlowShareGroupContentBlock b;
        public final /* synthetic */ y6b.a<?> c;

        public d(m<y6b.a<?>> r1, FlowShareGroupContentBlock r2, y6b.a<?> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r3) {
            e6b.b r4 = this.a;
            if ((r4 instanceof e6b.b) == false) goto L5;
            e6b.b r5 = r4;
        L6:
            if (r5 != null) goto L10;
            return false;
        L10:
            return r5.e(this.b, this.c);
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
    }

    public FlowShareGroupContentBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
    }

    public void update(m<y6b.a<?>> r24, q<y6b.a<?>> r25, y6b.a<?> r26) {
        Intrinsics.checkNotNullParameter(r24, "cell");
        Intrinsics.checkNotNullParameter(r25, "layout");
        Intrinsics.checkNotNullParameter(r26, "data");
        ShareGroupChatContentBlock.b r2 = r25.c(((ShareGroupChatContentBlock) this).g, IMMessageKeys.Slots.CONTENT, FlowShareGroupContentBlock$update$blockView$1.INSTANCE);
        ShareGroupChatContentVO r4 = r26.b();
        if ((r4 instanceof ShareGroupChatContentVO) == false) goto L5;
        ShareGroupChatContentVO r5 = r4;
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        Chat r6 = (Chat) r5.b.getValue();
        if (r6 != null) goto L11;
        return;
    L11:
        r2.h.getLayoutParams().width = -1;
        r2.h.setBackground(null);
        String r10 = r6.getAvatarKey();
        String r11 = r6.getEntityId();
        if (r6.isSecret() == false) goto L16;
        Scene r7 = Scene.SecretChat;
    L19:
        com.ss.android.lark.chat.utils.g.e(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).a.getContext(), r2.b, r10, r11, UIHelper.dp2px(40.0f), UIHelper.dp2px(40.0f), r7);
        String r8 = r6.getDescription();
        boolean r12 = true;
        if (TextUtils.isEmpty(r8) == false) goto L22;
        r2.c.setMaxLines(2);
        r2.d.setVisibility(8);
    L23:
        r2.a.post(new b(r2));
        h(r2, r6);
        final Message r9 = new Message();
        r9.setType(r26.getType());
        r9.setMessageContent(((v5b.a) r5).a);
        r9.setId(r26.getId());
        IChatService r13 = w.a(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c).j0();
        Context r14 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).a.getContext();
        UDButton r15 = r2.e;
        TextView r16 = r2.f;
        final c r17 = new c(this, r26);
        ShareGroupChatContent r18 = r9.getContent();
        r18.getExpireTime();
        String r20 = r18.getJoinToken();
        final Chat r19 = r18.getChat();
        boolean r110 = r13.checkLoginUserExistedInLocalChat(r19);
        if (r18.getJoinChatErrState() != null) goto L26;
        ShareGroupChatContent.GroupState r111 = ShareGroupChatContent.GroupState.CAN_JOIN_DIRECTLY;
    L27:
        if (r110 == false) goto L31;
        MessageHitPoint.b(r19, true);
        ShareGroupChatContent.GroupState r112 = ShareGroupChatContent.GroupState.ALREADY_IN_GROUP;
        r15.setOnClickListener(new com.ss.android.lark.flow.chat.message.block.sharegroup.b(r19, r9, r14, r17));
    L29:
        ShareGroupChatContent.GroupState r113 = r112;
    L48:
        e.b(r113, r15, r16);
        com.ss.android.lark.share_group.q.a(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).a.getContext(), r13, r2.g, r9);
        d r21 = new d(r24, this, r26);
        r2.g.setOnLongClickListener(r21);
        r2.h.setOnLongClickListener(r21);
        r2.h.setBackground(null);
        r2.h.setPadding(0, 0, 0, 0);
        return;
    L31:
        if (r111 == ShareGroupChatContent.GroupState.CAN_JOIN_DIRECTLY) goto L33;
        r15.setOnClickListener(new com.ss.android.lark.flow.chat.message.block.sharegroup.a(r19, r9, r17));
    L47:
        r113 = r111;
        goto L48
    L33:
        ShareGroupChatContent r114 = r9.getContent();
        if (r114 != null) goto L36;
    L44:
        if (r12 == false) goto L46;
        r112 = ShareGroupChatContent.GroupState.SHARE_EXPIRED;
        r15.setOnClickListener(new com.ss.android.lark.flow.chat.message.block.sharegroup.c(r19, r9, r17));
        goto L29
    L46:
        r15.setOnClickListener(new com.ss.android.lark.flow.chat.message.block.sharegroup.d(r17, r14, r19, r13, r15, r16, r18, r9, r20));
        goto L47
    L36:
        if (r114.getChat() == null) goto L44;
        long r115 = r114.getExpireTime();
        if (TextUtils.isEmpty(r114.getJoinToken()) == true) goto L44;
        if ((r115 * 1000) <= System.currentTimeMillis()) goto L44;
        r12 = false;
        goto L44
    L26:
        r111 = r18.getJoinChatErrState();
        goto L27
    L22:
        r2.c.setMaxLines(1);
        r2.d.setVisibility(0);
        r2.d.setText(r8);
        goto L23
    L16:
        if (r6.isThread() == false) goto L18;
        r7 = Scene.Thread;
        goto L19
    L18:
        r7 = Scene.Chat;
        goto L19
    L5:
        r5 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }
}

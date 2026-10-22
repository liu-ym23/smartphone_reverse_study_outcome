package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.base.view.vo.message.ShareGroupChatContentVO;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.preview.components.view.TailDrawableTextView;
import com.ss.android.lark.statistics.message.MessageHitPoint;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ShareGroupChatContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {
    public static final int h = 0;
    public final IMMessageKeys$Blocks g;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<View> {
        public final View a;
        public final ImageView b;
        public final TailDrawableTextView c;
        public final TextView d;
        public final UDButton e;
        public final TextView f;
        public final View g;
        public final View h;

        public final View getView() {
            return this.a;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [android.widget.TextView, com.ss.android.lark.chat.preview.components.view.TailDrawableTextView] */
        public b(View r7) {
            Intrinsics.checkNotNullParameter(r7, "view");
            this.a = r7;
            ImageView r0 = (ImageView) r7.findViewById(2131376028);
            this.b = r0;
            ?? r1 = (TailDrawableTextView) r7.findViewById(2131390710);
            this.c = r1;
            TextView r2 = (TextView) r7.findViewById(2131390709);
            this.d = r2;
            UDButton r3 = r7.findViewById(2131364599);
            this.e = r3;
            TextView r4 = (TextView) r7.findViewById(2131373932);
            this.f = r4;
            this.g = r7.findViewById(2131389196);
            this.h = r7.findViewById(2131373934);
            zz7.a.a(r0, 40);
            zz7.a.d(r1, LarkFont.HEADLINE);
            zz7.a.d(r2, LarkFont.CAPTION0);
            LarkFont r8 = LarkFont.BODY1;
            zz7.a.d(r3, r8);
            zz7.a.d(r4, r8);
            ViewGroup.LayoutParams r9 = r3.getLayoutParams();
            r9.height = zz7.b.g(r3.getContext(), 28);
            r3.setLayoutParams(r9);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void a() {
            float r0 = Layout.getDesiredWidth(this.a.f.getText().toString(), 0, this.a.f.getText().length(), this.a.f.getPaint());
            float r1 = UIUtils.dp2px(this.a.a.getContext(), 26.0f);
            b r2 = this.a;
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

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ShareGroupChatContentBlock a;
        public final /* synthetic */ y6b.a<?> b;

        public d(ShareGroupChatContentBlock r1, y6b.a<?> r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            w4b.g r5 = ChatCoreModule.a().getChatDependency();
            m2b.a r0 = this.a.c;
            y6b.a<?> r1 = this.b;
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.AbsMessageVO<com.ss.android.lark.chat.base.view.vo.message.ShareGroupChatContentVO>");
            r5.k(r0, r1);
        }
    }

    public static final class e implements View.OnLongClickListener {
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<?>> a;
        public final /* synthetic */ ShareGroupChatContentBlock b;
        public final /* synthetic */ y6b.a<?> c;

        public e(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, ShareGroupChatContentBlock r2, y6b.a<?> r3) {
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
        h = UIHelper.dp2px(8.0f);
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public ShareGroupChatContentBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.SHARE_GROUP_CHAT_CONTENT;
    }

    /* JADX WARN: Type inference failed for: r12v1, types: [android.widget.TextView, com.ss.android.lark.chat.preview.components.view.TailDrawableTextView] */
    public final void h(b r12, Chat r13) {
        Intrinsics.checkNotNullParameter(r12, "blockView");
        Intrinsics.checkNotNullParameter(r13, "chat");
        String r1 = StringsKt.trim(r13.getName()).toString();
        ?? r14 = r12.c;
        r14.setTailContent("…");
        Context r4 = r14.getContext();
        Intrinsics.checkNotNullParameter(r13, "chat");
        int r0 = LarkNameTag.d;
        LarkNameTag.d r2 = LarkNameTag.f.a(this.a.getContext());
        if (r13.isCrossWithKa() == false) goto L5;
        ((LarkNameTag.c) r2).f = true;
        com.larksuite.component.ui.tag.d r15 = r2.f().b();
    L13:
        if (r15 == null) goto L15;
        ncc.g r3 = new ncc.g();
        r3.a(r1);
        Intrinsics.checkNotNull(r4);
        int r5 = r15.getIntrinsicWidth();
        int r6 = r15.getIntrinsicHeight();
        int r7 = h;
        r3.b("$", new com.ss.android.lark.chat.preview.components.view.a(r4, r5, r6, r7, r15, null), 33);
        r14.d = r15;
        r14.e = r7;
        r14.f = 0;
        r14.g = false;
        r14.setText(r3);
        return;
    L15:
        r14.d = null;
        r14.e = 0;
        r14.f = 0;
        r14.g = false;
        r14.setText(r1);
        return;
    L5:
        Context r8 = this.a.getContext();
        Intrinsics.checkNotNullParameter(r8, "context");
        LarkNameTag.e r9 = new LarkNameTag.e(r8);
        TagData r10 = r13.getTagData();
        if (r10 == null) goto L11;
        TagData.Companion.getClass();
        List r16 = TagData.a.b(r10);
        if (CollectionUtils.isEmpty(r16) == false) goto L10;
        r9.g(r16);
    L12:
        r15 = r9.f().b();
        goto L13
    L10:
        r9.g(((ArrayList) r16).subList(0, 1));
        goto L12
    L11:
        ((LarkNameTag.c) r9).e = r13.isCrossTenant();
        goto L12
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r24, com.ss.android.lark.blueprint.q<y6b.a<?>> r25, y6b.a<?> r26) {
        Intrinsics.checkNotNullParameter(r24, "cell");
        Intrinsics.checkNotNullParameter(r25, "layout");
        Intrinsics.checkNotNullParameter(r26, Keys.API_RETURN_KEY_DATA);
        b r2 = (b) r25.c(this.g, IMMessageKeys$Slots.CONTENT, ShareGroupChatContentBlock$update$blockView$1.INSTANCE);
        Object r4 = r26.b();
        if ((r4 instanceof ShareGroupChatContentVO) == false) goto L5;
        ShareGroupChatContentVO r5 = (ShareGroupChatContentVO) r4;
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
        com.ss.android.lark.chat.utils.g.e(this.a.getContext(), r2.b, r10, r11, UIHelper.dp2px(40.0f), UIHelper.dp2px(40.0f), r7);
        String r8 = r6.getDescription();
        boolean r12 = true;
        if (TextUtils.isEmpty(r8) == false) goto L22;
        r2.c.setMaxLines(2);
        r2.d.setVisibility(8);
    L23:
        r2.a.post(new c(r2));
        h(r2, r6);
        Message r9 = new Message();
        r9.setType(r26.getType());
        r9.setMessageContent(r5.a);
        r9.setId(r26.getId());
        IChatService r13 = com.ss.android.lark.chat.chatwindow.chat.v2.push.w.a(this.c).j0();
        Context r14 = this.a.getContext();
        UDButton r15 = r2.e;
        TextView r16 = r2.f;
        d r17 = new d(this, r26);
        ShareGroupChatContent r18 = (ShareGroupChatContent) r9.getContent();
        r18.getExpireTime();
        String r20 = r18.getJoinToken();
        Chat r19 = r18.getChat();
        boolean r110 = r13.checkLoginUserExistedInLocalChat(r19);
        if (r18.getJoinChatErrState() != null) goto L26;
        ShareGroupChatContent.GroupState r111 = ShareGroupChatContent.GroupState.CAN_JOIN_DIRECTLY;
    L27:
        if (r110 == false) goto L31;
        MessageHitPoint.b(r19, true);
        ShareGroupChatContent.GroupState r112 = ShareGroupChatContent.GroupState.ALREADY_IN_GROUP;
        r15.setOnClickListener(new com.ss.android.lark.share_group.n(r19, r9, r14, r17));
    L29:
        ShareGroupChatContent.GroupState r113 = r112;
    L48:
        com.ss.android.lark.share_group.q.c(r113, r15, r16);
        com.ss.android.lark.share_group.q.a(this.a.getContext(), r13, r2.g, r9);
        e r21 = new e(r24, this, r26);
        r2.g.setOnLongClickListener(r21);
        r2.h.setOnLongClickListener(r21);
        r2.h.setBackground(null);
        r2.h.setPadding(0, 0, 0, 0);
        return;
    L31:
        if (r111 == ShareGroupChatContent.GroupState.CAN_JOIN_DIRECTLY) goto L33;
        r15.setOnClickListener(new com.ss.android.lark.share_group.k(r19, r9, r17));
    L47:
        r113 = r111;
        goto L48
    L33:
        ShareGroupChatContent r114 = (ShareGroupChatContent) r9.getContent();
        if (r114 != null) goto L36;
    L44:
        if (r12 == false) goto L46;
        r112 = ShareGroupChatContent.GroupState.SHARE_EXPIRED;
        r15.setOnClickListener(new com.ss.android.lark.share_group.o(r19, r9, r17));
        goto L29
    L46:
        r15.setOnClickListener(new com.ss.android.lark.share_group.p(r17, r14, r19, r13, r15, r16, r18, r9, r20));
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

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2, y6b.a<?> r3) {
        update2(r1, r2, r3);
    }
}

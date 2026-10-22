package com.ss.android.lark.flow.chat.message.block;

import android.content.Context;
import android.view.View;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.content.ProfileContent;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.chat.databinding.FlowChatMessageV2BlockProfileBinding;
import com.ss.android.lark.flow.chat.message.profile.FlowProfileContentVO;
import com.ss.android.lark.inv.export.router.InvRouter$InviteExternalPage$Param$From;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import egb.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowProfileContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<FlowProfileContentVO>, Object> {
    public final IMMessageKeys.Blocks g;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ProfileContent a;
        public final /* synthetic */ FlowProfileContentBlock b;
        public final /* synthetic */ y6b.a<FlowProfileContentVO> c;

        public a(ProfileContent r1, FlowProfileContentBlock r2, y6b.a<FlowProfileContentVO> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            String r8 = this.a.getId();
            if (r8 != null) goto L5;
            return;
        L5:
            int r0 = FlowChatModule.d;
            g r1 = FlowChatModule.a.a().a().getProfileDependency();
            Context r2 = this.b.getContext();
            this.a.getChatterType();
            Chat r3 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this.b).c.getChat();
            if (r3 == null) goto L8;
            String r4 = r3.getId();
        L9:
            ContactSource.a r5 = new ContactSource.a();
            r5.b = 7;
            ((FlowProfileContentVO) this.c.b()).getClass();
            r5.a = null;
            r5.d = (String) ((FlowProfileContentVO) this.c.b()).b.getValue();
            r1.a(r2, r8, r4, new ContactSource(r5));
            ChatHitPointNew.f(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this.b).c.getChat(), InvRouter$InviteExternalPage$Param$From.PROFILE, ChatHitPointNew.c(InvRouter$InviteExternalPage$Param$From.PROFILE), ChatHitPointNew.b(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this.b).c, this.c, null, null, null));
            return;
        L8:
            r4 = null;
            goto L9
        }
    }

    public final j getKey() {
        return this.g;
    }

    public FlowProfileContentBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys.Blocks.FLOW_PROFILE_CONTENT;
    }

    public void update(m<y6b.a<FlowProfileContentVO>> r5, q<y6b.a<FlowProfileContentVO>> r6, y6b.a<FlowProfileContentVO> r7) {
        Intrinsics.checkNotNullParameter(r5, "cell");
        Intrinsics.checkNotNullParameter(r6, "layout");
        Intrinsics.checkNotNullParameter(r7, "data");
        FlowChatMessageV2BlockProfileBinding r8 = (FlowChatMessageV2BlockProfileBinding) r6.c(this.g, IMMessageKeys.Slots.CONTENT, FlowProfileContentBlock$update$blockView$1.INSTANCE).a;
        ProfileContent r0 = ((v5b.a) ((FlowProfileContentVO) r7.b())).a;
        i3b.c.b(r8.e, ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).a, 14.0f);
        i3b.c.b(r8.c, ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).a, 14.0f);
        i3b.c.a(r8.b, ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).a, 36.0f);
        r8.e.setText(r0.getDisplayName());
        LarkAvatarView r1 = r8.b;
        uz7.a.a r2 = new uz7.a.a();
        r2.k = r0.getId();
        r2.b(r0.getAvatarKey());
        r2.f(r0.getId());
        r2.a(true);
        r2.h(AvatarModel.Size.MIDDLE);
        r2.c(Biz.Messenger);
        r2.g(Scene.Chat);
        r1.j(new uz7.a(r2));
        r8.a.setOnClickListener(new a(r0, this, r7));
        f(r8.a, r5, r7);
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }
}

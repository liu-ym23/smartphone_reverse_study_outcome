package com.ss.android.lark.flow.chat.message.block;

import android.view.View;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.base.view.vo.message.ShareGroupChatContentVO;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.chat.utils.g;
import com.ss.android.lark.flow.chat.databinding.FlowChatMessageV2BlockShareGroupBinding;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;
import mya.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowShareGroupContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<ShareGroupChatContentVO>, Object> {

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ FlowShareGroupContentBlock a;
        public final /* synthetic */ y6b.a<ShareGroupChatContentVO> b;

        public a(FlowShareGroupContentBlock r1, y6b.a<ShareGroupChatContentVO> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            u r4 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this.a).c.j5().b(u.class);
            if (r4 == null) goto L5;
            r4.g(this.b);
        L5:
            ChatCoreModule.a().getChatDependency().k(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this.a).c, this.b);
        }
    }

    public final j getKey() {
        return null;
    }

    public void update(m<y6b.a<ShareGroupChatContentVO>> r9, q<y6b.a<ShareGroupChatContentVO>> r10, y6b.a<ShareGroupChatContentVO> r11) {
        Intrinsics.checkNotNullParameter(r9, "cell");
        Intrinsics.checkNotNullParameter(r10, "layout");
        Intrinsics.checkNotNullParameter(r11, "data");
        ShareGroupChatContentVO r2 = null;
        FlowChatMessageV2BlockShareGroupBinding r12 = (FlowChatMessageV2BlockShareGroupBinding) r10.c(null, IMMessageKeys.Slots.CONTENT, new FlowShareGroupContentBlock$update$blockView$1(this)).a;
        r12.c.setText(UIUtils.getString(getContext(), 2131890104));
        TextView r0 = r12.d;
        Chat r1 = (Chat) r11.b().b.getValue();
        if (r1 == null) goto L7;
        String r3 = r1.getName();
        if (r3 == null) goto L7;
    L8:
        r0.setText(r3);
        v5b.a r4 = r11.b();
        if ((r4 instanceof ShareGroupChatContentVO) == false) goto L11;
        r2 = (ShareGroupChatContentVO) r4;
    L11:
        if (r2 != null) goto L13;
        return;
    L13:
        Chat r5 = (Chat) r2.b.getValue();
        if (r5 != null) goto L16;
        return;
    L16:
        String r6 = r5.getAvatarKey();
        String r7 = r5.getEntityId();
        g.e(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).a.getContext(), r12.b, r6, r7, UIHelper.dp2px(56.0f), UIHelper.dp2px(56.0f), Scene.Chat);
        r12.a.setOnClickListener(new a(this, r11));
        f(r12.a, r9, r11);
        return;
    L7:
        r3 = "";
        goto L8
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }
}

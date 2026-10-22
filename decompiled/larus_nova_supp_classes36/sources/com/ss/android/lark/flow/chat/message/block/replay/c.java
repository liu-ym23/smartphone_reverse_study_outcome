package com.ss.android.lark.flow.chat.message.block.replay;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.d;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ReplyBlock;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.UIHelper;
import h7b.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends d {
    public final m2b.a e;
    public final com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.c.a f;
    public final Lazy g;

    public final com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.c.a d() {
        return this.f;
    }

    public final m2b.a e() {
        return this.e;
    }

    public c(m2b.a r2, FlowReplyBlock$replyBlockRender$2.a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r3, "callbackHub");
        super(r2, r3);
        this.e = r2;
        this.f = r3;
        this.g = LazyKt.lazy(FlowMessageReplyContentRender$openFeishuGalleryPreviewDependency$2.INSTANCE);
    }

    public final void f(ReplyBlock.a r11, y6b.c r12, y6b.c r13) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "replyMessageVO");
        Intrinsics.checkNotNullParameter(r13, "item");
        LKUIRoundableLayout r0 = r11.g;
        boolean r1 = r13.i;
        int r2 = p3b.a.W;
        if (r1 == false) goto L5;
        int r3 = v4b.a.h;
    L6:
        r0.setBorderColor(r3);
        ViewGroup.LayoutParams r4 = r11.f.getLayoutParams();
        int r5 = r4.width;
        if (r5 <= 0) goto L11;
        int r6 = r4.height;
        if (r6 <= 0) goto L11;
        int r7 = Math.min(r5, r6);
    L13:
        if (r4.width == r7) goto L15;
    L16:
        r4.width = r7;
        r4.height = r7;
        r11.f.setLayoutParams(r4);
    L17:
        ValidateResult r8 = MessagePermissionUtil.b();
        boolean r9 = MessagePermissionUtil.f(r12, this.e.getChat(), r8);
        ValidateIMFileResult r10 = r12.F;
        if (r10 == null) goto L20;
        IMFileResult r14 = r10.getResultType();
    L21:
        MessagePermissionUtil.ReceiveAuthorizationState r15 = MessagePermissionUtil.h(r14);
        r11.f.setOnClickListener(new a(r12, this, r15, r9, r8));
        r11.f.setOnLongClickListener(new b(this, r11, r13));
        ResourceCleanScene r16 = lpc.a.b(r12);
        if (r16 == null) goto L26;
        boolean r17 = true;
        if (r16.isCSAMDelete() != true) goto L26;
    L27:
        if (r17 == false) goto L29;
        g(r11);
        return;
    L29:
        if (r9 == true) goto L31;
    L33:
        g(r11);
        return;
    L31:
        if (MessagePermissionUtil.g(r15) == true) goto L33;
        FragmentActivity r18 = this.e.getContext();
        ImageView r19 = r11.f;
        ImageContentVO r110 = r12.o;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.ImageContentVO");
        i.e(r18, r19, r110);
        return;
    L26:
        r17 = false;
        goto L27
    L20:
        r14 = null;
        goto L21
    L15:
        if (r4.height == r7) goto L17;
    L11:
        r7 = UIHelper.dp2px(40.0f);
        goto L13
    L5:
        r3 = v4b.a.G;
        goto L6
    }
}

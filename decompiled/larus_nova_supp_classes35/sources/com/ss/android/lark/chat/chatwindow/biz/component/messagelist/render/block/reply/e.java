package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ReplyBlock;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chat.utils.v0;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.chatwindow.view.photopreview.OperateListenerImpl;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.widget.cleanresource.ResourceType;
import com.ss.android.lark.widget.photo.preview.k;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ y6b.c<?> a;
    public final /* synthetic */ d b;
    public final /* synthetic */ MessagePermissionUtil.ReceiveAuthorizationState c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ ValidateResult e;
    public final /* synthetic */ b f;

    public e(y6b.c r1, d r2, MessagePermissionUtil.ReceiveAuthorizationState r3, boolean r4, ValidateResult r5, ReplyBlock.a r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        T r0 = this.a.o;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.ImageContentVO");
        ImageContentVO r1 = (ImageContentVO) r0;
        String r2 = null;
        if (((ImageContent) r1.a).resourceIsCleaned() == false) goto L10;
        FragmentActivity r12 = this.b.e().getContext();
        ResourceType r3 = ResourceType.IMAGE;
        ResourceCleanScene r4 = lpc.a.b(this.a);
        y6b.b r5 = this.a.t;
        if (r5 == null) goto L7;
        r2 = r5.w;
    L7:
        acc.a.f(r12, new acc.d(r3, r4, acc.a.d(r2)));
        return;
    L10:
        if (MessagePermissionUtil.g(this.c) == false) goto L22;
        MessagePermissionUtil.ReceiveAuthorizationState r13 = this.c;
        if (r13 != MessagePermissionUtil.ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE) goto L15;
        MessagePermissionUtil.m(this.b.e().getContext());
        return;
    L15:
        if (r13 != MessagePermissionUtil.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L33;
        AuthorizationServiceV2 r14 = owa.a.c();
        ValidateIMFileResult r6 = this.a.F;
        if (r6 == null) goto L19;
        r2 = r6.getValidateResult();
    L19:
        r14.d(r2, MessagePermissionUtil.a());
        return;
    L33:
        return;
    L22:
        if (this.d == true) goto L25;
        MessagePermissionUtil.n(this.b.e().getContext(), 2131891410, this.e);
        return;
    L25:
        PhotoItem r7 = v0.g(r1, this.a.c);
        if (r7 == null) goto L34;
        r7.setThumbnail(v0.h(r11));
        boolean r15 = ChatCoreModule.a().getFeatureGatingDependency().isEnable("translate.message.image.viewer.enable");
        ArrayList r8 = new ArrayList();
        r8.add(r7);
        Chat r9 = this.b.e().getChat();
        if (r9 != null) goto L30;
        return;
    L30:
        boolean r10 = y0.d(r9);
        boolean r16 = y0.a(r9);
        boolean r17 = y0.e(r9);
        boolean r18 = y0.b(r9);
        boolean r19 = y0.c(r9);
        int r20 = k.a;
        k.c r21 = k.a.a(r8, 0, this.f.b());
        r21.c(7414);
        r21.d(false);
        r21.i(true);
        r21.o(r15);
        r21.l(r18);
        r21.g(r16);
        r21.h(r19);
        r21.m(r10);
        r21.e(!r17);
        r21.a.putBoolean("is_secret", false);
        r21.p(true);
        r21.f(new OperateListenerImpl(r9));
        r21.q(Biz.Messenger, Scene.Chat, 0);
        r21.r(ContextsKt.requireActivity(this.b.e().getContext()));
        int r110 = w5c.a.a;
        w5c.a.a(this.b.e().getChatId(), r7.getImageKey());
        return;
    }
}

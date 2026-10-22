package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply;

import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
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
    public final /* synthetic */ y6b.c<?> f;
    public final /* synthetic */ ImageView g;

    public e(y6b.c<?> r1, d r2, MessagePermissionUtil.ReceiveAuthorizationState r3, boolean r4, ValidateResult r5, y6b.c<?> r6, ImageView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        T r12 = this.a.o;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.ImageContentVO");
        ImageContentVO r13 = (ImageContentVO) r12;
        String r1 = null;
        if (((ImageContent) r13.a).resourceIsCleaned() == false) goto L9;
        FragmentActivity r14 = this.b.b.getContext();
        ResourceType r2 = ResourceType.IMAGE;
        ResourceCleanScene r3 = lpc.a.b(this.a);
        y6b.b r4 = this.a.t;
        if (r4 == null) goto L7;
        r1 = r4.w;
    L7:
        acc.a.f(r14, new acc.d(r2, r3, acc.a.d(r1)));
        return;
    L9:
        ValidateIMFileResult r0 = this.a.F;
        if (r0 == null) goto L13;
        r1 = r0.getValidateResult();
    L13:
        if (MessagePermissionUtil.g(this.c) == false) goto L22;
        MessagePermissionUtil.ReceiveAuthorizationState r15 = this.c;
        if (r15 != MessagePermissionUtil.ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE) goto L18;
        MessagePermissionUtil.m(this.b.b.getContext());
    L20:
        owa.a.c().a(r1, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
        return;
    L18:
        if (r15 != MessagePermissionUtil.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L20;
        owa.a.c().d(r1, MessagePermissionUtil.a());
        goto L20
    L22:
        owa.a.c().a(r1, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
        if (this.d == true) goto L26;
        MessagePermissionUtil.n(this.b.b.getContext(), 2131891410, this.e);
        owa.a.c().a(this.e, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        return;
    L26:
        owa.a.c().a(this.e, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        PhotoItem r16 = v0.g(r13, this.f.c);
        if (r16 == null) goto L33;
        r16.setThumbnail(v0.h(this.g));
        boolean r5 = ChatCoreModule.a().getFeatureGatingDependency().isEnable("translate.message.image.viewer.enable");
        ArrayList r6 = new ArrayList();
        r6.add(r16);
        Chat r7 = this.b.b.getChat();
        if (r7 != null) goto L31;
        return;
    L31:
        boolean r8 = y0.d(r7);
        boolean r9 = y0.a(r7);
        boolean r10 = y0.e(r7);
        boolean r17 = y0.c(r7);
        boolean r18 = y0.b(r7);
        int r19 = k.a;
        k.c r20 = k.a.a(r6, 0, this.g);
        r20.c(7414);
        r20.d(true);
        r20.i(true);
        r20.o(r5);
        r20.l(r18);
        r20.h(r17);
        r20.m(r8);
        r20.g(r9);
        r20.e(!r10);
        r20.a.putBoolean("is_secret", false);
        r20.p(true);
        r20.f(new OperateListenerImpl(r7));
        r20.q(Biz.Messenger, Scene.Chat, 0);
        r20.r(ContextsKt.requireActivity(this.b.b.getContext()));
        int r21 = w5c.a.a;
        w5c.a.a(this.f.e, r16.getImageKey());
        return;
    }
}

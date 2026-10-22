package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.widget.cleanresource.ResourceType;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n extends OnSingleClickListener {
    public final /* synthetic */ ImageContentBlock a;
    public final /* synthetic */ ImageContentBlock.b b;
    public final /* synthetic */ y6b.a<ImageContentVO> c;

    public final void onSingleClick(View r21) {
        Intrinsics.checkNotNullParameter(r21, "v");
        ImageContentBlock r1 = this.a;
        ImageContentBlock.b r2 = this.b;
        y6b.a<ImageContentVO> r11 = this.c;
        b3b.f r3 = r1.d;
        String r5 = null;
        if ((r3 instanceof b3b.i) == false) goto L5;
        b3b.i r12 = r3;
    L7:
        if (((ImageContent) r11.b().a).resourceIsCleaned() == false) goto L12;
        FragmentActivity r4 = r1.c.getContext();
        ResourceType r6 = ResourceType.IMAGE;
        ResourceCleanScene r7 = lpc.a.b(r11);
        y6b.b r8 = r11.a();
        if (r8 == null) goto L11;
        r5 = r8.w;
    L11:
        acc.a.f(r4, new acc.d(r6, r7, acc.a.d(r5)));
        return;
    L12:
        ValidateIMFileResult r9 = r11.N();
        if (r9 == null) goto L15;
        ValidateResult r10 = r9.getValidateResult();
    L16:
        ValidateIMFileResult r13 = r11.N();
        if (r13 == null) goto L19;
        IMFileResult r14 = r13.getResultType();
    L20:
        MessagePermissionUtil.ReceiveAuthorizationState r15 = MessagePermissionUtil.h(r14);
        if (MessagePermissionUtil.g(r15) == true) goto L23;
        owa.a.c().a(r10, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
        mya.q r16 = r1.c.j5().b(mya.q.class);
        ValidateResult r17 = MessagePermissionUtil.b();
        if (MessagePermissionUtil.f(r11, r1.c.getChat(), r17) == true) goto L32;
        MessagePermissionUtil.n(r1.getContext(), 2131891410, r17);
        owa.a.c().a(r17, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
    L50:
        ChatCoreModule.a().getChatDependency().w(r1.c, r11);
        return;
    L32:
        if (r16 != null) goto L34;
        if (r12 == null) goto L50;
    L34:
        owa.a.c().a(r17, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        ImageContentVO r18 = ImageContentBlock.h(r11);
        if (r18.n != null) goto L43;
        MessageIdentity r19 = new MessageIdentity(r11.getId(), r11.getChatId());
        r19.setSenderId(r11.g());
        y6b.b r20 = r11.a();
        if (r20 == null) goto L39;
        r5 = r20.w;
    L39:
        r19.setSenderTenantId(r5);
        ArrayList<String> r22 = ((ImageContent) r18.a).getRiskObjectKeys();
        if (r22 == null) goto L42;
        r19.setRiskObjectKeys(r22);
    L42:
        r18.n = r19;
    L43:
        PhotoItem r110 = com.ss.android.lark.chat.utils.v0.g(r18, r11.getId());
        if (r110 == null) goto L50;
        boolean r23 = r18.e();
        r110.getTranslateProperty().setTranslated(r23);
        r110.setThumbnail(com.ss.android.lark.chat.utils.v0.h(r2.d));
        if (r16 == null) goto L48;
        r16.b(r1.c, r2.d, null, r11, null, r23, 1);
        goto L50
    L48:
        if (r12 == null) goto L50;
        r12.s(r2.d, null, r110, false, r23, 1, r11.J());
        goto L50
    L23:
        if (r15 != MessagePermissionUtil.ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE) goto L26;
        MessagePermissionUtil.m(r1.getContext());
    L28:
        owa.a.c().a(r10, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
        goto L50
    L26:
        if (r15 != MessagePermissionUtil.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L28;
        owa.a.c().d(r10, MessagePermissionUtil.a());
        goto L28
    L19:
        r14 = null;
        goto L20
    L15:
        r10 = null;
        goto L16
    L5:
        r12 = null;
        goto L7
    }

    public n(ImageContentBlock r1, ImageContentBlock.b r2, y6b.a<ImageContentVO> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

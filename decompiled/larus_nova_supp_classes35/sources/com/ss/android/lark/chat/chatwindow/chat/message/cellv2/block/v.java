package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.base.view.vo.message.MediaContentVO;
import com.ss.android.lark.chat.chatwindow.chat.model.preload.v2.MediaResourceLoadTask;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.widget.cleanresource.ResourceType;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class v extends OnSingleClickListener {
    public final /* synthetic */ MediaContentBlock a;
    public final /* synthetic */ MediaContentBlock.b b;
    public final /* synthetic */ y6b.a<MediaContentVO> c;

    public final void onSingleClick(View r21) {
        Intrinsics.checkNotNullParameter(r21, "v");
        final MediaContentBlock r1 = this.a;
        final MediaContentBlock.b r8 = this.b;
        y6b.a<MediaContentVO> r10 = this.c;
        r1.getClass();
        Message.FileDeletedStatus r2 = r10.b().q;
        if (r2 != Message.FileDeletedStatus.RECOVERABLE) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (((MediaContent) r10.b().a).resourceIsCleaned() == true) goto L51;
        if (r3 == true) goto L51;
        ValidateIMFileResult r4 = r10.N();
        IMFileResult r5 = null;
        if (r4 == null) goto L16;
        ValidateResult r6 = r4.getValidateResult();
    L17:
        ValidateIMFileResult r7 = r10.N();
        if (r7 == null) goto L20;
        r5 = r7.getResultType();
    L20:
        MessagePermissionUtil.ReceiveAuthorizationState r9 = MessagePermissionUtil.h(r5);
        if (MessagePermissionUtil.g(r9) == true) goto L23;
        owa.a.c().a(r6, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
        ValidateResult r11 = MessagePermissionUtil.b();
        if (MessagePermissionUtil.f(r10, r1.c.getChat(), r11) == true) goto L32;
        MessagePermissionUtil.n(r1.getContext(), 2131891413, r11);
        owa.a.c().a(r11, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        return;
    L32:
        owa.a.c().a(r11, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        boolean r12 = e1c.d.m;
        e1c.d.b.a.n(MediaResourceLoadTask.class, r10.getId());
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("im.file.delete.by.script.toast") == false) goto L50;
        i3b.d r13 = (i3b.d) r1.a.c.a(i3b.d.class);
        if (r13 == null) goto L41;
        m2b.a r14 = r13.a();
        if (r14 == null) goto L41;
        com.ss.android.lark.biz.im.api.message.params.j r15 = r14.d0(com.ss.android.lark.biz.im.api.message.params.j.class);
        if (r15 == null) goto L41;
        boolean r16 = r15.f;
    L42:
        r1.k = !r16;
        MediaContentVO r17 = r10.b();
        final com.ss.android.lark.compose.foundation.toast.g r18 = x08.a.a(r1.c.getContext(), 2131891535);
        final s r19 = new s(r1, r18);
        final p r20 = new p(r18);
        final r r22 = new r(r1);
        final q r23 = new q(r1, r8, r10);
        IGetDataCallback<Message.FileDeletedStatus> r110 = new MediaContentBlock$checkFileStateBeforeOpen$callback$1(r18, r1, r19, r20, r22, r8, r23);
        com.larksuite.framework.callback.c r24 = r1.i;
        if (r24 == null) goto L45;
        r24.d();
        r24.b(r19, 500);
    L45:
        w4b.j r111 = ChatCoreModule.a().getDownloadDependency();
        String r112 = r10.getId();
        String r25 = r17.n;
        Message.SourceType r26 = r17.o;
        if (r26 == null) goto L48;
        int r113 = r26.getNumber();
    L49:
        r111.c(r112, r25, r113, (String) r17.b.getValue(), r110);
        return;
    L48:
        r113 = 0;
    L41:
        r16 = false;
        goto L42
    L50:
        com.ss.android.lark.chat.utils.d0.b(r1.c.getContext(), r8.b, r10, (b3b.j) r1.j.getValue(), r1.c.j5());
        ChatCoreModule.a().getChatDependency().s(r1.c, r10);
        return;
    L23:
        if (r9 != MessagePermissionUtil.ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE) goto L26;
        MessagePermissionUtil.m(r1.c.getContext());
    L28:
        owa.a.c().a(r6, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
        return;
    L26:
        if (r9 != MessagePermissionUtil.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L28;
        owa.a.c().d(r6, MessagePermissionUtil.a());
        goto L28
    L16:
        r6 = null;
    L51:
        y6b.b r27 = r10.a();
        if (r27 == null) goto L55;
        String r28 = r27.w;
        if (r28 == null) goto L55;
    L56:
        acc.a.f(r1.getContext(), new acc.d(ResourceType.VIDEO, lpc.a.b(r10), acc.a.d(r28)));
        return;
    L55:
        r28 = BuildConfig.FLAVOR;
        goto L56
    L5:
        if (r2 == Message.FileDeletedStatus.UNRECOVERABLE) goto L8;
        r3 = false;
        goto L10
    }

    public v(MediaContentBlock r1, MediaContentBlock.b r2, y6b.a<MediaContentVO> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.biz.im.api.ImageHistoryResponse;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.name.ChatNameRenderer$doHideTranslate$1;
import com.ss.android.lark.chat.name.ChatNameRenderer$doTranslate$1;
import com.ss.android.lark.dto.group.GroupRecallEntity;
import com.ss.android.lark.integrator.im.impl.IIMApiImpl;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o0 extends c0c.b implements IChatService {
    public final /* synthetic */ IChatService b;
    public final com.ss.android.lark.passportc.internal.v c;
    public final com.ss.android.lark.passportc.convention.b<IChatService> d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void Ac(String r2, UIGetDataCallback r3) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        this.b.Ac(r2, r3);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void Dc(String r2, Iterable r3, Iterable r4, IGetDataCallback r5) {
        this.b.Dc(r2, r3, r4, r5);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final com.ss.android.lark.chat.entity.chat.b I0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        return this.b.I0(r2);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void L9(String r2, String r3, IIMApiImpl.peakFeedCard.1 r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.b.L9(r2, r3, r4);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final ccb.d M2(String r2, String r3, String r4, boolean r5) {
        return this.b.M2(r2, r3, r4, r5);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final ImageHistoryResponse Ne(String r2, String r3, ImageHistoryResponse.Direction r4, int r5) {
        return this.b.Ne(r2, r3, r4, r5);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void U6(String r2, IGetDataCallback<Boolean> r3) {
        this.b.U6(r2, r3);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final boolean checkLoginUserExistedInLocalChat(Chat r2) {
        return this.b.checkLoginUserExistedInLocalChat(r2);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void f2(List<GroupRecallEntity> r2, String r3, IGetDataCallback<List<GroupRecallEntity>> r4) {
        this.b.f2(r2, r3, r4);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final Chat getChatById(String r2) {
        return this.b.getChatById(r2);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final Chat getLocalChat(String r2) {
        return this.b.getLocalChat(r2);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final Chat getP2pChatByChatterId(String r2) {
        return this.b.getP2pChatByChatterId(r2);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void getP2pChatCreatedByChatterId(String r2, IGetDataCallback<Chat> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b.getP2pChatCreatedByChatterId(r2, r3);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void h3(String r2, String r3, boolean r4, ChatNameRenderer$doTranslate$1 r5) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        this.b.h3(r2, r3, r4, r5);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void t8(String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        this.b.t8(r2, r3, r4);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void t9(String r2, String r3, UIGetDataCallback r4) {
        this.b.t9(r2, r3, r4);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void u2(List<String> r2, List<String> r3, SubscribeChatEventRequest.SubscriptionKey r4) {
        this.b.u2(r2, r3, r4);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void y3(String r2, ChatNameRenderer$doHideTranslate$1 r3) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        this.b.y3(r2, r3);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final ImageHistoryResponse ze(String r2, String r3, ImageHistoryResponse.Direction r4) {
        return this.b.ze(r2, r3, r4);
    }

    public o0(com.ss.android.lark.passportc.api.j r4, com.ss.android.lark.passportc.internal.v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<IChatService> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), IChatService.class), IChatService.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (IChatService) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r2, f0c.g r3) {
        Log.i("ChatServiceProxy", "preparing IChatService");
        com.ss.android.lark.passportc.internal.v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        IChatService r6 = (IChatService) e0c.k.b(r4.c(r5), IChatService.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}

package com.ss.android.lark.im.sdk.usercontainer;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.integrator.im.impl.ChatApiImpl$selectMessagesFromChat$1;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends c0c.b implements ImSdkChatService {
    public final /* synthetic */ ImSdkChatService b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<ImSdkChatService> d;

    /* JADX INFO: renamed from: com.ss.android.lark.im.sdk.usercontainer.a$a, reason: collision with other inner class name */
    public static final class C0089a {
    }

    static {
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat B2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        return this.b.B2(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final void C2(List<String> r2, IGetDataCallback<Map<String, Chat>> r3) {
        Intrinsics.checkNotNullParameter(r2, "chatterIds");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b.C2(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final com.ss.android.lark.chat.entity.chat.b I0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        return this.b.I0(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat P6(String r2, ImSdkChatService.Source r3) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "source");
        return this.b.P6(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final void X5(String r2, ImSdkChatService.a r3, IGetDataCallback<Chat> r4) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.b.X5(r2, r3, r4);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final void Y6(List<String> r2, String r3, IGetDataCallback<Map<String, Boolean>> r4) {
        Intrinsics.checkNotNullParameter(r2, "chatterIds");
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.b.Y6(r2, r3, r4);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat getLocalChat(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        return this.b.getLocalChat(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final String getOtherP2PChatterId(Chat r2) {
        Intrinsics.checkNotNullParameter(r2, "chat");
        return this.b.getOtherP2PChatterId(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final com.ss.android.lark.chat.entity.chat.a nd(String r2) {
        return this.b.nd(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final void uc(List r2, ChatApiImpl$selectMessagesFromChat$1 r3) {
        Intrinsics.checkNotNullParameter(r2, "chatIds");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b.uc(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat we(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        return this.b.we(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat xc(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        return this.b.xc(r2);
    }

    public a(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<ImSdkChatService> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), ImSdkChatService.class), ImSdkChatService.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (ImSdkChatService) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r2, g r3) {
        Log.i("ImSdkChatServiceProxy", "preparing ImSdkChatService");
        v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        ImSdkChatService r6 = (ImSdkChatService) k.b(r4.c(r5), ImSdkChatService.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}

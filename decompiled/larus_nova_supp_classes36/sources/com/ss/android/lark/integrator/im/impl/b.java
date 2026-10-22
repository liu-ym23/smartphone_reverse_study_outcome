package com.ss.android.lark.integrator.im.impl;

import android.app.Activity;
import com.bytedance.lark.pb.basic.v1.CardContent;
import com.larksuite.framework.utils.y;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.compose.chatsetting.bridge.SelectChatMessagesBridge;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.integrator.im.extension.ExtensionManager;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements com.ss.android.lark.biz.im.api.d {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void e() {
    }

    public final BasicDialogContentConfig b() {
        return new BasicDialogContentConfig();
    }

    public final List<gya.a<Content>> d() {
        CopyOnWriteArrayList<gya.a<? extends Content>> r0 = ExtensionManager.a().c;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.collections.List<com.ss.android.lark.biz.im.api.extension.parser.MessageParser<com.ss.android.lark.chat.export.entity.message.Content>>");
        return r0;
    }

    public final gya.a<Content> a(MessageType r2) {
        Intrinsics.checkNotNullParameter(r2, "messageType");
        return ExtensionManager.b(r2);
    }

    public final CardContent c(com.ss.android.lark.chat.entity.message.content.CardContent r4) {
        Intrinsics.checkNotNullParameter(r4, "cardContent");
        new com.ss.android.lark.message.card.b();
        return new CardContent.Builder().type(CardContent.Type.fromValue(r4.getType().getNumber())).extra(CardContent.ExtraType.fromValue(r4.getExtraType().getNumber())).richtext(com.ss.android.lark.message.card.b.a().parsePbFromRichText(r4.getRichText())).actions(y.b(r4.getActions(), new com.ss.android.lark.message.card.parser.c())).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.ss.android.lark.integrator.im.impl.ChatApiImpl$selectMessagesFromChat$1] */
    public final void f(final Activity r4, final String r5, final Map r6, final SelectChatMessagesBridge.SelectChatMessagesBridgeHandler.handle.messageSelectCallback.1 r7) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "chatId");
        Intrinsics.checkNotNullParameter(r7, "callback");
        ImSdkService.b().uc(CollectionsKt.listOf(r5), new ChatApiImpl$selectMessagesFromChat$1(r4, r5, r6, r7));
    }
}

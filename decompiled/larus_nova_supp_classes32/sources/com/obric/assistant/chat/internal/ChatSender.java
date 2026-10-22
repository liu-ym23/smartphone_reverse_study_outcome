package com.obric.assistant.chat.internal;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.messenger.stub.MessageIDLStub$notifySemanticUserEditEventWithIdentifier$1;
import com.obric.assistant.chat.api.c;
import com.obric.assistant.upload.Scene;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ChatSender implements c {
    public static final /* synthetic */ int c = 0;
    public final e a;
    public final CoroutineScope b;

    public static final class a {
    }

    static {
    }

    public ChatSender(e r2, BotModel r3) {
        Intrinsics.checkNotNullParameter(r2, "con");
        Intrinsics.checkNotNullParameter(r3, "bot");
        this.a = r2;
        this.b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public final void b(String r13, boolean r14, Map<String, String> r15, String r16) {
        Intrinsics.checkNotNullParameter(r13, "messageId");
        Intrinsics.checkNotNullParameter(r16, "scene");
        FLogger.a.i("Obric_ChatSender", "hideAndReSendMessage: called, questionId = " + r13 + ", extras = " + r15 + ", scene = " + r16);
        BuildersKt.launch$default(this.b, null, null, new ChatSender$hideAndReSendMessage$1(r13, r14, this, r16, r15, null), 3, null);
    }

    public final void c(String r18, Map r19, String r20, MessageIDLStub$notifySemanticUserEditEventWithIdentifier$1.a r21, String r22) {
        Intrinsics.checkNotNullParameter(r18, "text");
        Intrinsics.checkNotNullParameter("bot_chat", "textScene");
        Intrinsics.checkNotNullParameter("obric_semantic", "fromScene");
        Intrinsics.checkNotNullParameter(r19, "ext");
        Intrinsics.checkNotNullParameter(r20, "identifier");
        BuildersKt.launch$default(this.b, null, null, new ChatSender$sendSingleImageWithText$1(r22, r20, this, r18, "bot_chat", "obric_semantic", r19, r21, null), 3, null);
    }

    @Override // com.obric.assistant.chat.api.c
    public final void a(String r17, String r18, Map r19, PolarisFileWrapper r20, Scene r21, IIMCallback r22, String r23) {
        Intrinsics.checkNotNullParameter(r17, "text");
        Intrinsics.checkNotNullParameter("bot_chat", "textScene");
        Intrinsics.checkNotNullParameter(r18, "fromScene");
        Intrinsics.checkNotNullParameter(r19, "ext");
        Intrinsics.checkNotNullParameter(r20, "destFile");
        Intrinsics.checkNotNullParameter(r21, "uploadScene");
        BuildersKt.launch$default(this.b, null, null, new ChatSender$sendSingleImageWithText$2(r23, this, r17, "bot_chat", r18, r19, r22, r20, r21, null), 3, null);
    }
}

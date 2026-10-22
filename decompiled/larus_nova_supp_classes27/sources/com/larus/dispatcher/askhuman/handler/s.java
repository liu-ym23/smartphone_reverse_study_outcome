package com.larus.dispatcher.askhuman.handler;

import androidx.fragment.app.FragmentActivity;
import com.larus.dispatcher.api.ToolContent;
import com.larus.dispatcher.api.ToolResult;
import com.larus.dispatcher.api.UploadToolCallRequest;
import com.larus.im.bean.message.block.ActionType;
import com.larus.im.internal.jni.bean.DispatchCommand;
import com.larus.im.internal.jni.bean.DispatchCommandBody;
import com.larus.im.internal.jni.bean.DispatchCommandPayload;
import com.larus.im.internal.jni.bean.InteractionRequestActionPayload;
import com.larus.im.internal.jni.bean.RequestActionResult;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s implements IQuickReplyClickInterceptor {
    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final String c() {
        return "interaction.request_action";
    }

    public s() {
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final boolean e(k r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptorContext");
        Integer r3 = r2.b.getActionType();
        int r0 = ActionType.CUA_REQUEST_ACTION_SKIP.getValue();
        if (r3 != null) goto L6;
    L8:
        return false;
    L6:
        if (r3.intValue() != r0) goto L8;
        return true;
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final void f(String r1) {
        IQuickReplyClickInterceptor.DefaultImpls.a(r1);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final p g(o r34) {
        Intrinsics.checkNotNullParameter(r34, "interceptorContext");
        if (r34.b.a() == false) goto L6;
        String r2 = r34.e;
        DispatchCommand r5 = DispatchCommand.INTERACTION_REQUEST_ACTION_HANDLE;
        String r6 = UUID.randomUUID().toString();
        t r8 = r34.d;
        return new p(true, IQuickReplyClickInterceptor.DefaultImpls.c(this, r34, r2, new DispatchCommandPayload(r5, r6, new DispatchCommandBody(null, null, null, null, new InteractionRequestActionPayload(r8.a, r8.b, new RequestActionResult(true)), null, null, null, null, null, null, null, null, null, 16367, null), null, r34.f, null, 0, null, null, 488, null)));
    L6:
        t r3 = r34.d;
        IQuickReplyClickInterceptor.DefaultImpls.f(this, r34, new UploadToolCallRequest(r3.b, new ToolResult(r3.a, "interaction.ask", CollectionsKt.listOf(new ToolContent("text", r34.a.getText())), null, 8, null)));
        return new p(true, true);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final void a(o r1, Function1<? super Continuation<? super dm9.a<Unit>>, ? extends Object> r2) {
        IQuickReplyClickInterceptor.DefaultImpls.e(r1, r2);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final p b(o r1, boolean r2) {
        return IQuickReplyClickInterceptor.DefaultImpls.b(r1, r2);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final boolean d(FragmentActivity r1, String r2, Integer r3, String r4, String r5, String r6) {
        return IQuickReplyClickInterceptor.DefaultImpls.d(this, r1, r2, r3, r4, r5, r6);
    }
}

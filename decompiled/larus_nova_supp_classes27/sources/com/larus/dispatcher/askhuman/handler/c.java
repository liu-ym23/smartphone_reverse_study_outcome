package com.larus.dispatcher.askhuman.handler;

import androidx.fragment.app.FragmentActivity;
import com.larus.im.bean.message.block.ActionType;
import com.larus.im.internal.jni.bean.AskHumanResultAuthorizeFolder;
import com.larus.im.internal.jni.bean.DispatchCommand;
import com.larus.im.internal.jni.bean.DispatchCommandBody;
import com.larus.im.internal.jni.bean.DispatchCommandPayload;
import com.larus.im.internal.jni.bean.InteractionAuthorizeFolderResultPayload;
import java.util.List;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements IQuickReplyClickInterceptor {
    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final String c() {
        return "interaction.authorize_folder";
    }

    public c() {
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final boolean e(k r3) {
        Intrinsics.checkNotNullParameter(r3, "interceptorContext");
        Integer r0 = r3.b.getActionType();
        int r1 = ActionType.CUA_AUTHORIZE_FOLDER_ALLOW.getValue();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.intValue() == r1) goto L8;
        return false;
    L8:
        return r3.e.a();
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final void f(String r1) {
        IQuickReplyClickInterceptor.DefaultImpls.a(r1);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final p g(o r33) {
        Intrinsics.checkNotNullParameter(r33, "interceptorContext");
        String r1 = r33.e;
        DispatchCommand r3 = DispatchCommand.INTERACTION_AUTHORIZE_FOLDER_HANDLE;
        String r4 = UUID.randomUUID().toString();
        t r6 = r33.d;
        String r7 = r6.a;
        String r8 = r6.b;
        List<String> r9 = r33.d.d;
        if (r9 != null) goto L6;
        r9 = CollectionsKt.emptyList();
    L6:
        return new p(true, IQuickReplyClickInterceptor.DefaultImpls.c(this, r33, r1, new DispatchCommandPayload(r3, r4, new DispatchCommandBody(null, null, null, null, null, null, new InteractionAuthorizeFolderResultPayload(r7, r8, new AskHumanResultAuthorizeFolder(r9, false)), null, null, null, null, null, null, null, 16319, null), null, r33.f, null, 0, null, null, 488, null)));
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

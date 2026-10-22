package com.larus.bmhome.clarification;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.jni.bean.DispatchCommandPayload;
import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c2 implements IIMCallback<OmniDispatchCommandResponse> {
    public final /* synthetic */ DispatchCommandPayload a;
    public final /* synthetic */ wc9.e b;
    public final /* synthetic */ kotlinx.coroutines.i<h2> c;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public final void onFailure(IIMError r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        Intrinsics.checkNotNullParameter(r5, "error");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("pc dispatch failed, command=");
        r1.append(this.a.command);
        r1.append(", conversationId=");
        wc9.e r2 = this.b;
        if (r2 == null) goto L5;
        String r3 = r2.a;
    L6:
        r1.append(r3);
        r1.append(", errorCode=");
        r1.append(r5.getCode());
        r1.append(", errorMsg=");
        r1.append(r5.getTips());
        r0.e("ClarificationSubmitter", r1.toString(), r5.getException());
        if (this.c.isActive() == false) goto L10;
        kotlinx.coroutines.i<h2> r4 = this.c;
        Result.Companion r6 = Result.Companion;
        r4.resumeWith(Result.constructor-impl(new h2.a("pc_dispatch_error:" + r5.getCode() + ':' + r5.getTips())));
        return;
    L10:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void onSuccess(Object r3) {
        Intrinsics.checkNotNullParameter((OmniDispatchCommandResponse) r3, "result");
        FLogger r4 = FLogger.a;
        StringBuilder r0 = new StringBuilder("pc dispatch success, command=");
        r0.append(this.a.command);
        r0.append(", conversationId=");
        wc9.e r1 = this.b;
        if (r1 == null) goto L5;
        String r2 = r1.a;
    L6:
        r0.append(r2);
        r4.i("ClarificationSubmitter", r0.toString());
        if (this.c.isActive() == false) goto L10;
        kotlinx.coroutines.i<h2> r5 = this.c;
        Result.Companion r6 = Result.Companion;
        r5.resumeWith(Result.constructor-impl(h2.c.a));
        return;
    L10:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public c2(DispatchCommandPayload r1, wc9.e r2, kotlinx.coroutines.j r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

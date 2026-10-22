package com.larus.chat.job.impl.page;

import com.larus.im.bean.job.AIJobChainResult;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x implements IIMCallback<AIJobChainResult> {
    public final /* synthetic */ String a;
    public final /* synthetic */ ChatJobListLoader b;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("mutateJob empty response sync failed action=");
        r1.append(this.a);
        r1.append(' ');
        int r2 = ChatJobListLoader.t;
        r1.append(ChatJobListLoader.a.d(r4));
        r0.e("ChatJobListLoader", r1.toString());
        gz8.h.b(r4);
        ChatJobListLoader.g(this.b, "emptyMutationFailed:" + this.a, 14);
    }

    public final void onSuccess(Object r4) {
        AIJobChainResult r5 = (AIJobChainResult) r4;
        Intrinsics.checkNotNullParameter(r5, "result");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("mutateJob empty response sync success action=");
        r1.append(this.a);
        r1.append(" fetched=");
        r1.append(r5.getFetchedCount());
        r1.append(" changed=");
        int r2 = ChatJobListLoader.t;
        r1.append(ChatJobListLoader.a.a(r5.getChangedJobIds()));
        r1.append(" cursorBlank=");
        r1.append(StringsKt.isBlank(r5.getCursor()));
        r0.i("ChatJobListLoader", r1.toString());
        ChatJobListLoader.g(this.b, "emptyMutation:" + this.a, 14);
    }

    public x(String r1, ChatJobListLoader r2) {
        this.a = r1;
        this.b = r2;
    }
}

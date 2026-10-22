package com.larus.bmhome.social.userchat.model;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements IIMCallback<wc9.e> {
    public final /* synthetic */ ChatConversationRequestModel a;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public f(ChatConversationRequestModel r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r46) {
        Intrinsics.checkNotNullParameter(r46, "error");
        Intrinsics.checkNotNullParameter(r46, "error");
        FLogger.a.i(this.a.q, "initConversationInfo onFail， " + r46.getCode());
        int r1 = r46.getCode();
        if (r1 != 712012004) goto L5;
        wc9.e r2 = new wc9.e(this.a.a, null, null, null, null, null, null, null, false, 2, null, null, null, null, null, null, null, null, null, 1, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 0, -524802, 63);
    L9:
        ChatConversationRequestModel.a(this.a, r2);
        return;
    L5:
        if (r1 == 712013001) goto L7;
        r2 = null;
        goto L9
    L7:
        r2 = new wc9.e(this.a.a, null, null, null, null, null, null, null, false, 2, null, null, null, null, null, null, null, null, null, 2, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 0, -524802, 63);
        goto L9
    }

    public final void onSuccess(Object r2) {
        ChatConversationRequestModel r0 = this.a;
        ChatConversationRequestModel.a(r0, (wc9.e) r2);
    }
}

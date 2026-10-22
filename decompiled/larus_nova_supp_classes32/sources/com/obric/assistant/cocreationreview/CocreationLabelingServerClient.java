package com.obric.assistant.cocreationreview;

import com.larus.platform.service.AccountService;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class CocreationLabelingServerClient {
    public CocreationLabelingServerClient() {
    }

    public static final String a(CocreationLabelingServerClient r1) {
        r1.getClass();
        String r2 = AccountService.a.getXTTToken();
        if (r2 != null) goto L5;
    L7:
        return null;
    L5:
        if ((!StringsKt.isBlank(r2)) == false) goto L7;
        return r2;
    }

    public final Object b(CocreationUserFeedbackRequest r4, Continuation<? super dm9.a<? extends Object>> r5) {
        CocreationLabelingServerApi.a r0 = CocreationLabelingServerApi.a;
        CocreationLabelingServerClient$submitUserFeedback$2 r1 = new CocreationLabelingServerClient$submitUserFeedback$2(this, r4, null);
        r0.getClass();
        return CocreationLabelingServerApi.a.a(r1, r5);
    }
}

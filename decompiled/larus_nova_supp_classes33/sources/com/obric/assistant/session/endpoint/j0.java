package com.obric.assistant.session.endpoint;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j0 {
    public static final AiKeyActivationStartResult a(boolean r0) {
        if (r0 == true) goto L5;
        return AiKeyActivationStartResult.FAILED;
    L5:
        return AiKeyActivationStartResult.DEFERRED;
    }
}

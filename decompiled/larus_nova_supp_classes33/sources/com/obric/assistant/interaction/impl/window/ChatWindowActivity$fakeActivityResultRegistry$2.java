package com.obric.assistant.interaction.impl.window;

import com.obric.assistant.interaction.api.service.ActivityProxyListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ChatWindowActivity$fakeActivityResultRegistry$2 extends FunctionReferenceImpl implements Function1<ActivityProxyListener, Boolean> {
    public ChatWindowActivity$fakeActivityResultRegistry$2(Object r8) {
        super(1, r8, ChatWindowActivity.class, "startProxyActivity", "startProxyActivity(Lcom/obric/assistant/interaction/api/service/ActivityProxyListener;)Z", 0);
    }

    public final Boolean invoke(ActivityProxyListener r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return Boolean.valueOf(ChatWindowActivity.access$startProxyActivity((ChatWindowActivity) ((CallableReference) this).receiver, r2));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((ActivityProxyListener) r1);
    }
}

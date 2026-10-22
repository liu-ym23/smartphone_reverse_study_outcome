package com.obric.assistant.session;

import android.content.Context;
import com.obric.assistant.activation.presentation.contract.session.VoiceInteractionProxySessionFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/assistant/session/ObricVoiceInteractionProxySessionFactory;", "Lcom/obric/assistant/activation/presentation/contract/session/VoiceInteractionProxySessionFactory;", "<init>", "()V", "create", "Lcom/obric/assistant/activation/presentation/contract/session/VoiceInteractionProxySession;", "context", "Landroid/content/Context;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricVoiceInteractionProxySessionFactory implements VoiceInteractionProxySessionFactory {
    public ObricVoiceInteractionProxySessionFactory() {
    }

    public final AiIslandVoiceInteractionSession create(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new AiIslandVoiceInteractionSession(r2);
    }
}

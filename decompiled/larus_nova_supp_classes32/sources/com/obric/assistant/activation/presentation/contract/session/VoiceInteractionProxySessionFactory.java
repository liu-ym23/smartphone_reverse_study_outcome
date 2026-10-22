package com.obric.assistant.activation.presentation.contract.session;

import android.content.Context;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.session.AiIslandVoiceInteractionSession;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/activation/presentation/contract/session/VoiceInteractionProxySessionFactory;", NameKeys.UnloadStrategy_No_Strategy, "create", "Lcom/obric/assistant/activation/presentation/contract/session/VoiceInteractionProxySession;", "context", "Landroid/content/Context;", "contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface VoiceInteractionProxySessionFactory {
    AiIslandVoiceInteractionSession create(Context r1);
}

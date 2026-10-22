package com.obric.assistant.interaction.api.service;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/assistant/interaction/api/service/IInteractionStateService$Companion;", "", "<init>", "()V", "WAKE_UP_SOURCE_OTHER", "", "WAKE_UP_SOURCE_UNKNOWN", "WAKE_UP_SOURCE_DORA_VOICE_WAKEUP", "WAKE_UP_SOURCE_DORA_KEY_UP", "WAKE_UP_SOURCE_BLUETOOTH", IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC, "WAKEUP_SOURCE_VOICE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IInteractionStateService$Companion {
    static final /* synthetic */ IInteractionStateService$Companion $$INSTANCE = null;
    public static final String WAKEUP_SOURCE_AUTO_MIC = "WAKEUP_SOURCE_AUTO_MIC";
    public static final String WAKEUP_SOURCE_VOICE = "WAKEUP_SOURCE_VOICE_ASSIST";
    public static final String WAKE_UP_SOURCE_BLUETOOTH = "WAKEUP_SOURCE_BLUETOOTH";
    public static final String WAKE_UP_SOURCE_DORA_KEY_UP = "WAKEUP_SOURCE_DORA_KEY_UP";
    public static final String WAKE_UP_SOURCE_DORA_VOICE_WAKEUP = "WAKEUP_SOURCE_DORA_VOICE_WAKEUP";
    public static final String WAKE_UP_SOURCE_OTHER = "other";
    public static final String WAKE_UP_SOURCE_UNKNOWN = "WAKEUP_SOURCE_UNKNOWN";

    static {
        $$INSTANCE = new IInteractionStateService$Companion();
    }

    private IInteractionStateService$Companion() {
    }
}

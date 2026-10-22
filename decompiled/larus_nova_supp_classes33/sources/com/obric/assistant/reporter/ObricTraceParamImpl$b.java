package com.obric.assistant.reporter;

import com.obric.assistant.interaction.base.model.AssistantActivityExpandState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public /* synthetic */ class ObricTraceParamImpl$b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[AssistantActivityExpandState.values().length];
        r0[AssistantActivityExpandState.FULL_SCREEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r0[AssistantActivityExpandState.HALF_WINDOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r0[AssistantActivityExpandState.CHAT_WINDOW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r0[AssistantActivityExpandState.INVISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        a = r0;
    }
}

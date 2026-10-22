package com.obric.assistant.interaction.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/interaction/api/IScreenState;", "", "getScreenState", "", "isScreenOn", "", "registerScreenStateChangedListener", "", "listener", "Lcom/obric/assistant/interaction/api/OnScreenStateChangedListener;", "unregisterScreenStateChangedListener", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IScreenState {
    int getScreenState();

    boolean isScreenOn();

    void registerScreenStateChangedListener(OnScreenStateChangedListener r1);

    void unregisterScreenStateChangedListener(OnScreenStateChangedListener r1);
}

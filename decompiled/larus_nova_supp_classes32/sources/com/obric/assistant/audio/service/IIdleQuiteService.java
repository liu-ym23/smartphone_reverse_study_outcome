package com.obric.assistant.audio.service;

import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.component.clicktalk.ChatClickTalkComponent;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rH&¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/audio/service/IIdleQuiteService;", NameKeys.UnloadStrategy_No_Strategy, "addObserver", NameKeys.UnloadStrategy_No_Strategy, "observer", "Lcom/obric/assistant/audio/service/IdleTimeoutObserver;", "removeObserver", "stop", "botId", NameKeys.UnloadStrategy_No_Strategy, "reason", "start", "args", NameKeys.UnloadStrategy_No_Strategy, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IIdleQuiteService {
    void a(String r1, String r2);

    void b(ChatClickTalkComponent.e r1);

    void c(ChatClickTalkComponent.e r1);

    void d(String r1, Map<String, ? extends Object> r2);
}

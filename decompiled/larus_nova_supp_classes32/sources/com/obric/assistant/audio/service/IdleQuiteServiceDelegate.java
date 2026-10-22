package com.obric.assistant.audio.service;

import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.component.clicktalk.ChatClickTalkComponent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J'\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0096\u0001J\u0019\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0096\u0001¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/audio/service/IdleQuiteServiceDelegate;", "Lcom/obric/assistant/audio/service/IIdleQuiteService;", "<init>", "()V", "addObserver", NameKeys.UnloadStrategy_No_Strategy, "observer", "Lcom/obric/assistant/audio/service/IdleTimeoutObserver;", "removeObserver", "start", "botId", NameKeys.UnloadStrategy_No_Strategy, "args", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "stop", "reason", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IdleQuiteServiceDelegate implements IIdleQuiteService {
    public static final IdleQuiteServiceDelegate b = null;
    public final /* synthetic */ IIdleQuiteService a;

    static {
        b = new IdleQuiteServiceDelegate();
    }

    @Override // com.obric.assistant.audio.service.IIdleQuiteService
    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        Intrinsics.checkNotNullParameter("closeClickTalk", "reason");
        this.a.a(r2, "closeClickTalk");
    }

    @Override // com.obric.assistant.audio.service.IIdleQuiteService
    public final void b(ChatClickTalkComponent.e r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.a.b(r2);
    }

    @Override // com.obric.assistant.audio.service.IIdleQuiteService
    public final void c(ChatClickTalkComponent.e r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.a.c(r2);
    }

    @Override // com.obric.assistant.audio.service.IIdleQuiteService
    public final void d(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        this.a.d(r2, r3);
    }

    private IdleQuiteServiceDelegate() {
        this.a = (IIdleQuiteService) ServiceManager.get().getService(IIdleQuiteService.class);
    }
}

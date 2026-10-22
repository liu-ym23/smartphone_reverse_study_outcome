package com.obric.assistant.utils;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001¨\u0006\n"}, d2 = {"Lcom/obric/assistant/utils/ObricShowArgServiceDelegate;", "Lcom/obric/assistant/utils/IObricShowArgService;", "<init>", "()V", "isAssistantRequestFromAIKey", "", "setWakeupSource", "", "source", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricShowArgServiceDelegate implements IObricShowArgService {
    public static final ObricShowArgServiceDelegate b = null;
    public final /* synthetic */ IObricShowArgService a;

    static {
        b = new ObricShowArgServiceDelegate();
    }

    @Override // com.obric.assistant.utils.IObricShowArgService
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        this.a.a(r2);
    }

    @Override // com.obric.assistant.utils.IObricShowArgService
    public final boolean isAssistantRequestFromAIKey() {
        return this.a.isAssistantRequestFromAIKey();
    }

    private ObricShowArgServiceDelegate() {
        this.a = (IObricShowArgService) ServiceManager.get().getService(IObricShowArgService.class);
    }
}

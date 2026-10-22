package com.larus.extension.summary_card.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/larus/extension/summary_card/api/SummaryCardConfigDelegate;", "Lcom/larus/extension/summary_card/api/ISummaryCardConfig;", "<init>", "()V", "convertToRealMessageAfterSendingMessage", "", "enabled", "showFallbackSummary", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SummaryCardConfigDelegate implements ISummaryCardConfig {
    public static final SummaryCardConfigDelegate b = null;
    public final /* synthetic */ ISummaryCardConfig a;

    static {
        b = new SummaryCardConfigDelegate();
    }

    @Override // com.larus.extension.summary_card.api.ISummaryCardConfig
    public final boolean a() {
        return this.a.a();
    }

    @Override // com.larus.extension.summary_card.api.ISummaryCardConfig
    public final boolean enabled() {
        return this.a.enabled();
    }

    private SummaryCardConfigDelegate() {
        ISummaryCardConfig r0 = (ISummaryCardConfig) ServiceManager.get().getService(ISummaryCardConfig.class);
        if (r0 != null) goto L5;
        r0 = new SummaryCardConfigNoop();
    L5:
        this.a = r0;
    }
}

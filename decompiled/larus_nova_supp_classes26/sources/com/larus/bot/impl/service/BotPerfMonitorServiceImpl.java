package com.larus.bot.impl.service;

import com.larus.bot.api.IBotPerfMonitorService;
import com.larus.ugc.perf.impl.c;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J)\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\r\"\u00020\u0007H\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/bot/impl/service/BotPerfMonitorServiceImpl;", "Lcom/larus/bot/api/IBotPerfMonitorService;", "<init>", "()V", "start", "", "trackerKey", "", "eventName", "end", "param", "key", "keyValues", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotPerfMonitorServiceImpl implements IBotPerfMonitorService {
    public BotPerfMonitorServiceImpl() {
    }

    @Override // com.larus.bot.api.IBotPerfMonitorService
    public final void a(String... r3) {
        Intrinsics.checkNotNullParameter("profile_upload_avatar", "key");
        Intrinsics.checkNotNullParameter(r3, "keyValues");
        c.c("profile_upload_avatar", (String[]) Arrays.copyOf(r3, r3.length));
    }

    @Override // com.larus.bot.api.IBotPerfMonitorService
    public final void end(String r2) {
        Intrinsics.checkNotNullParameter(r2, "trackerKey");
        c.a(r2);
    }

    @Override // com.larus.bot.api.IBotPerfMonitorService
    public final void start(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "trackerKey");
        Intrinsics.checkNotNullParameter(r3, "eventName");
        c.g(r2, r3);
    }
}

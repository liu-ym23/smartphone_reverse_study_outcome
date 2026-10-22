package com.larus.bmhome.bot;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001¢\u0006\u0002\u0010\nJ\u0019\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0001¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/bot/BotStatusCacheDelegate;", "Lcom/larus/bmhome/bot/IBotStatusCacheService;", "<init>", "()V", "clear", "", "getChatOnly", "", "botId", "", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getStatus", "setChatOnly", "chatOnly", "setStatus", "status", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BotStatusCacheDelegate implements IBotStatusCacheService {
    public static final BotStatusCacheDelegate b = null;
    public final /* synthetic */ IBotStatusCacheService a;

    static {
        b = new BotStatusCacheDelegate();
    }

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final void a(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        this.a.a(r2, r3);
    }

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final Boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        return this.a.b(r2);
    }

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final Boolean c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        return this.a.c(r2);
    }

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final void clear() {
        this.a.clear();
    }

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final void d(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        this.a.d(r2, r3);
    }

    private BotStatusCacheDelegate() {
        IBotStatusCacheService r0 = (IBotStatusCacheService) ServiceManager.get().getService(IBotStatusCacheService.class);
        if (r0 != null) goto L5;
        r0 = new BotStatusCacheServiceNoop();
    L5:
        this.a = r0;
    }
}

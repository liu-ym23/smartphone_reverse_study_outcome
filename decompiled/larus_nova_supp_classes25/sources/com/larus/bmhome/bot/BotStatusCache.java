package com.larus.bmhome.bot;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0017\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u0012\u001a\u00020\nH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/bot/BotStatusCache;", "Lcom/larus/bmhome/bot/IBotStatusCacheService;", "<init>", "()V", "map", "", "", "", "chatOnlyMap", "setStatus", "", "botId", "status", "getStatus", "(Ljava/lang/String;)Ljava/lang/Boolean;", "setChatOnly", "chatOnly", "getChatOnly", "clear", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BotStatusCache implements IBotStatusCacheService {
    public final Map<String, Boolean> a;
    public final Map<String, Boolean> b;

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final void clear() {
        ((LinkedHashMap) this.a).clear();
        ((LinkedHashMap) this.b).clear();
    }

    public BotStatusCache() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
    }

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final Boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        return (Boolean) ((LinkedHashMap) this.b).get(r2);
    }

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final Boolean c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        return (Boolean) ((LinkedHashMap) this.a).get(r2);
    }

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final void a(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        Boolean r4 = Boolean.valueOf(r3);
        this.a.put(r2, r4);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final void d(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        Boolean r4 = Boolean.valueOf(r3);
        this.b.put(r2, r4);
        return;
    L5:
        r0 = false;
        goto L6
    }
}

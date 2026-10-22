package com.larus.bmhome.chat.model.repo;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.service.BotChangeType;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z1 implements com.larus.im.service.y {
    public final /* synthetic */ MainBotModelStore a;
    public final /* synthetic */ String b;
    public final /* synthetic */ CoroutineScope c;

    public final void a(List<BotModel> r10, BotChangeType r11) {
        Intrinsics.checkNotNullParameter(r10, "changedBots");
        Intrinsics.checkNotNullParameter(r11, "changeType");
        String r0 = this.b;
        Iterator<T> r12 = r10.iterator();
    L3:
        BotModel r2 = null;
        if (r12.hasNext() == false) goto L8;
        Object r1 = r12.next();
        if (Intrinsics.areEqual(((BotModel) r1).getBotId(), r0) == false) goto L3;
    L9:
        BotModel r3 = (BotModel) r1;
        if (r3 != null) goto L12;
        return;
    L12:
        MainBotModelStore r13 = this.a;
        Object r4 = r13.a;
        CoroutineScope r5 = this.c;
        String r6 = this.b;
        monitor-enter(r4);
    L25:
        th = move-exception;
        throw th;
    L15:
        if (r5 == r13.b) goto L18;
        monitor-exit(r4);
        return;
    L18:
        r13.e++;     // Catch: Throwable -> L25
        if (r11 == BotChangeType.DELETE) goto L22;
        r2 = r3;
    L22:
        r13.f = r2;     // Catch: Throwable -> L25
        FLogger.a.i("MainBotModelStore", "bot changed, botId=" + r6 + ", type=" + r11 + ", version=" + r13.e);     // Catch: Throwable -> L25
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r4);
        return;
    L8:
        r1 = null;
        goto L9
    }

    public z1(MainBotModelStore r1, String r2, CoroutineScope r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

package com.obric.assistant.omni;

import com.larus.im.d;
import com.obric.assistant.spi.message.IObricAppreciablePoint;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/omni/ObricAppreciablePoint;", "Lcom/obric/assistant/spi/message/IObricAppreciablePoint;", "<init>", "()V", "onStartSendMsg", "", "localSendMsgId", "", "onSendAck", "localMsgId", "msgId", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAppreciablePoint implements IObricAppreciablePoint {
    public ObricAppreciablePoint() {
    }

    @Override // com.obric.assistant.spi.message.IObricAppreciablePoint
    public final void b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "localSendMsgId");
        b r0 = b.a;
        Intrinsics.checkNotNullParameter(r6, "localMsgId");
        if (b.c() == false) goto L25;
        if (b.c == true) goto L10;
        b.c = true;     // Catch: Exception -> L19
        d.e().registerOnGlobalMessageObserver(b.h);     // Catch: Exception -> L18
    L10:
        monitor-enter(r0);     // Catch: Exception -> L19
        b.d.put(r6, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L14
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Exception -> L19
        b.b("onSendStart localMsgId=" + r6);     // Catch: Exception -> L19
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Exception -> L19
    L26:
        return;
    }

    @Override // com.obric.assistant.spi.message.IObricAppreciablePoint
    public final void a(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "localMsgId");
        Intrinsics.checkNotNullParameter(r9, "msgId");
        b r0 = b.a;
        Intrinsics.checkNotNullParameter(r8, "localMsgId");
        Intrinsics.checkNotNullParameter(r9, "msgId");
        if (b.c() == false) goto L20;
        monitor-enter(r0);     // Catch: Exception -> L16
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L12
        b.e.put(r8, r9);     // Catch: Throwable -> L12
        OmniTaskMessageLifecycleTrace$lruMap$1 r4 = b.d;     // Catch: Throwable -> L12
        Long r5 = (Long) r4.get(r8);     // Catch: Throwable -> L12
        if (r5 == null) goto L9;
        r4.put(r9, Long.valueOf(r5.longValue()));     // Catch: Throwable -> L12
    L9:
        b.f.put(r9, Long.valueOf(r2));     // Catch: Throwable -> L12
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Exception -> L16
        b.b("onSendAck localMsgId=" + r8 + " msgId=" + r9);     // Catch: Exception -> L16
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Exception -> L16
    L21:
        return;
    }
}

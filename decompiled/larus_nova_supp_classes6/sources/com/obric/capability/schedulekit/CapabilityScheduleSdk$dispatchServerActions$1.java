package com.obric.capability.schedulekit;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
final class CapabilityScheduleSdk$dispatchServerActions$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $payload;
    final /* synthetic */ boolean $replyForServer;

    public CapabilityScheduleSdk$dispatchServerActions$1(String r1, boolean r2) {
        this.$payload = r1;
        this.$replyForServer = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m12invoke() {
        via.b r0 = via.b.a;
        CoroutineScope r1 = b.a;
        r0.a("CapabilityScheduleSdk");
        b.a();
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m12invoke();
        return Unit.INSTANCE;
    }
}

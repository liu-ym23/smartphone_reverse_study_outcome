package com.obric.livecard.api;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class IslandTaskHandler$makeTask$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ boolean $markAlive;
    final /* synthetic */ boolean $markDead;
    final /* synthetic */ Long $sessionId;
    final /* synthetic */ String $stackTrace;
    final /* synthetic */ IslandTaskHandler this$0;

    public IslandTaskHandler$makeTask$1(Long r1, boolean r2, IslandTaskHandler r3, boolean r4, Function1<? super Continuation<? super Unit>, ? extends Object> r5, String r6) {
        this.$sessionId = r1;
        this.$markAlive = r2;
        this.this$0 = r3;
        this.$markDead = r4;
        this.$block = r5;
        this.$stackTrace = r6;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m17invoke() {
        Long r0 = this.$sessionId;
        if (r0 != null) goto L5;
    L12:
        IslandTaskHandler.access$getBlockRunner$p(this.this$0).invoke(this.$block, this.$stackTrace);
        return;
    L5:
        if (r0.longValue() <= 0) goto L12;
        if (this.$markAlive == false) goto L10;
        IslandTaskHandler.access$getAliveSession$p(this.this$0).add(this.$sessionId);
    L10:
        if (this.$markDead == false) goto L12;
        IslandTaskHandler.access$getAliveSession$p(this.this$0).remove(this.$sessionId);
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m17invoke();
        return Unit.INSTANCE;
    }
}

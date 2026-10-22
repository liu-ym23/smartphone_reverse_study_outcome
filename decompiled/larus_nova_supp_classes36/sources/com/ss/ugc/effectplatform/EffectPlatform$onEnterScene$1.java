package com.ss.ugc.effectplatform;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.task.algorithm.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
public final class EffectPlatform$onEnterScene$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $scene;
    final /* synthetic */ EffectPlatform this$0;

    public EffectPlatform$onEnterScene$1(EffectPlatform r1, String r2) {
        this.this$0 = r1;
        this.$scene = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1525invoke() {
        Pair[] r1 = new Pair[3];
        r1[0] = TuplesKt.to("scene", this.$scene);
        a r4 = a.d;
        String r5 = this.$scene;
        monitor-enter(r4);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (a.c == true) goto L9;
        String r6 = "null";
        monitor-exit(r4);
    L11:
        r1[1] = TuplesKt.to("block", r6);
        r1[2] = TuplesKt.to("block_list", r4.b(this.$scene));
        Map r2 = MapsKt.mapOf(r1);
        Logger.INSTANCE.w("JKL", "[Mob][EnterScene][" + r2 + ']');
        klc.a r3 = (klc.a) this.this$0.getEffectConfig().v.a;
        if (r3 == null) goto L28;
        EffectConfig r7 = this.this$0.getEffectConfig();
        Pair[] r0 = new Pair[3];
        String r8 = r7.m;
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        r0[0] = TuplesKt.to("app_id", r8);
        String r9 = r7.a;
        if (r9 != null) goto L21;
        r9 = "";
    L21:
        r0[1] = TuplesKt.to("access_key", r9);
        r0[2] = TuplesKt.to("connect_type", "");
        Map r10 = MapsKt.mutableMapOf(r0);
        r10.putAll(r2);
        r3.monitorStatusRate("ep_business_downloading_flow", 0, r10);
        return;
    L28:
        return;
    L9:
        r6 = a.a.b("None", r5);     // Catch: Throwable -> L23
        monitor-exit(r4);
        goto L11
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1525invoke();
        return Unit.INSTANCE;
    }
}

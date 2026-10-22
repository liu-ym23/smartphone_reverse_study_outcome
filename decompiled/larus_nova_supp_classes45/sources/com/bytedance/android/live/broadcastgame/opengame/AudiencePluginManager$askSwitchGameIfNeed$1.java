package com.bytedance.android.live.broadcastgame.opengame;

import com.bytedance.android.live.broadcastgame.opengame.message.f0;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"startGame", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class AudiencePluginManager$askSwitchGameIfNeed$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ f0 $entrance;
    final /* synthetic */ String $launchFrom;
    final /* synthetic */ AudiencePluginManager this$0;

    public AudiencePluginManager$askSwitchGameIfNeed$1(AudiencePluginManager r1, f0 r2, String r3) {
        this.this$0 = r1;
        this.$entrance = r2;
        this.$launchFrom = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m164invoke() {
        AudiencePluginManager r0 = this.this$0;
        int r1 = AudiencePluginManager.z;
        r0.x("user switch");
        this.this$0.w(this.$entrance);
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r2 = this.this$0.a;
        if (r2 == null) goto L11;
        t r3 = r2.getPluginInfo();
        if (r3 == null) goto L11;
        if (this.$entrance.u != 3) goto L9;
        boolean r4 = true;
    L10:
        r3.d = r4;
        goto L11
    L9:
        r4 = false;
    L11:
        AudiencePluginManager r5 = this.this$0;
        String r6 = this.$entrance.a;
        String r7 = this.$launchFrom;
        if (r7 != null) goto L14;
        r7 = "";
    L14:
        r5.d(r6, MapsKt.mapOf(TuplesKt.to("location", r7)));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m164invoke();
        return Unit.INSTANCE;
    }
}

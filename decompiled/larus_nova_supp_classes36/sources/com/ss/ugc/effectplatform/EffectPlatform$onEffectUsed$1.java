package com.ss.ugc.effectplatform;

import b0.a;
import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.ugc.effectplatform.model.Effect;
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
public final class EffectPlatform$onEffectUsed$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Effect $effect;
    final /* synthetic */ String $scene;
    final /* synthetic */ boolean $suc;
    final /* synthetic */ EffectPlatform this$0;

    public EffectPlatform$onEffectUsed$1(EffectPlatform r1, Effect r2, String r3, boolean r4) {
        this.this$0 = r1;
        this.$effect = r2;
        this.$scene = r3;
        this.$suc = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1524invoke() {
        int r0 = a.a;
        long r1 = System.currentTimeMillis();
        String r2 = FileManager.a;
        long r3 = (r1 - new PolarisFileWrapper(this.$effect.getUnzipPath()).lastModified()) / 86400000;
        Pair[] r4 = new Pair[5];
        r4[0] = TuplesKt.to("effect_id", this.$effect.getEffect_id());
        r4[1] = TuplesKt.to("panel", this.$effect.getPanel());
        String r5 = com.ss.ugc.effectplatform.model.b.a(this.$effect);
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        r4[2] = TuplesKt.to("md5", r5);
        r4[3] = TuplesKt.to("create_date_diff", Long.valueOf(r3));
        r4[4] = TuplesKt.to("scene", this.$scene);
        Map r6 = MapsKt.mapOf(r4);
        Logger.INSTANCE.w("JKL", "[Mob][EffectUsed][" + r6 + ']');
        klc.a r7 = (klc.a) this.this$0.getEffectConfig().v.a;
        if (r7 == null) goto L18;
        boolean r8 = this.$suc;
        EffectConfig r9 = this.this$0.getEffectConfig();
        Pair[] r10 = new Pair[3];
        String r11 = r9.m;
        if (r11 != null) goto L12;
        r11 = "";
    L12:
        r10[0] = TuplesKt.to("app_id", r11);
        String r12 = r9.a;
        if (r12 != null) goto L16;
        r12 = "";
    L16:
        r10[1] = TuplesKt.to("access_key", r12);
        r10[2] = TuplesKt.to("connect_type", "");
        Map r13 = MapsKt.mutableMapOf(r10);
        r13.putAll(r6);
        r7.monitorStatusRate("ep_effect_apply_message", !r8 ? 1 : 0, r13);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1524invoke();
        return Unit.INSTANCE;
    }
}

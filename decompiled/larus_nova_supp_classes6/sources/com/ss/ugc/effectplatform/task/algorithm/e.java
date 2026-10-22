package com.ss.ugc.effectplatform.task.algorithm;

import bytekn.foundation.logger.Logger;
import com.obric.capabilitykit.entity.meta.MetaType;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.extension.c;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.algorithm.SingleAlgorithmModelResponse;
import com.ss.ugc.effectplatform.task.BaseTask;
import com.ss.ugc.effectplatform.util.g;
import com.ss.ugc.effectplatform.util.m;
import dlc.a;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class e extends BaseTask {
    public final EffectConfig g;
    public final String h;
    public final int i;
    public final String j;

    public final void b() {
    }

    public final SingleAlgorithmModelResponse g() {
        Pair[] r0 = new Pair[5];
        String r2 = this.g.b;
        String r3 = "";
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        boolean r4 = false;
        r0[0] = TuplesKt.to("sdk_version", r2);
        String r5 = this.g.g;
        if (r5 == null) goto L9;
        r3 = r5;
    L9:
        r0[1] = TuplesKt.to("device_type", r3);
        r0[2] = TuplesKt.to("device_platform", "android");
        EffectConfig.ModelFileEnv r6 = this.g.J;
        if (r6 == null) goto L12;
        Integer r7 = Integer.valueOf(r6.ordinal());
    L13:
        r0[3] = TuplesKt.to("status", String.valueOf(r7));
        r0[4] = TuplesKt.to("name", this.h);
        Map r1 = MapsKt.mutableMapOf(r0);
        int r8 = this.i;
        if (r8 <= 0) goto L17;
        r1.put("busi_id", String.valueOf(r8));
    L17:
        if (this.g.V == false) goto L19;
        String r9 = "1";
    L20:
        r1.put("model_mapping", r9);
        int r10 = g.a;
        r1.putAll(g.b(this.g, 4));
        String r11 = this.j;
        if (r11 != null) goto L23;
    L28:
        String r12 = this.g.E;
        int r13 = m.a;
        NetRequest r14 = new NetRequest(m.a(r1, r12 + "/model/api/model"), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
        INetworkClient r15 = (INetworkClient) this.g.u.a;
        if (r15 != null) goto L49;
        f(new ExceptionResult(MetaType.TEXT));
        return null;
    L49:
        String r16 = c.a(r15.fetchFromNetwork(r14).getBodyStream());     // Catch: Exception -> L46
        if (r16.length() != 0) goto L35;
        r4 = true;
    L35:
        if (r4 == false) goto L38;
        f(new ExceptionResult(10002));     // Catch: Exception -> L46
        return null;
    L38:
        a r17 = this.g.t;     // Catch: Exception -> L46
        if (r17 == null) goto L41;
        SingleAlgorithmModelResponse r18 = (SingleAlgorithmModelResponse) r17.a.convertJsonToObj(r16, SingleAlgorithmModelResponse.class);     // Catch: Exception -> L46
    L42:
        if (r18 != null) goto L45;
        f(new ExceptionResult(MetaType.IDENTIFY_CARD_NUMBER));     // Catch: Exception -> L46
        return null;
    L45:
        return r18;
    L41:
        r18 = null;
    L46:
        e = move-exception;
        Logger.INSTANCE.e("FetchModelInfoByNameTask", "fetch single model info failed!", e);
        f(new ExceptionResult(e));
        return null;
    L23:
        if ((!StringsKt.isBlank(r11)) == true) goto L26;
        r11 = null;
    L26:
        if (r11 == null) goto L28;
        r1.put("big_version", r11);
        goto L28
    L19:
        r9 = "0";
        goto L20
    L12:
        r7 = null;
        goto L13
    }

    public final void a() {
        g();
    }

    public final void f(ExceptionResult r7) {
        Logger.e$default(Logger.INSTANCE, "FetchModelInfoByNameTask", "fetch single model info failed!, " + r7.getMsg(), null, 4, null);
    }

    public e(EffectConfig r3, String r4, int r5) {
        super(null, r3.N);
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = null;
    }
}

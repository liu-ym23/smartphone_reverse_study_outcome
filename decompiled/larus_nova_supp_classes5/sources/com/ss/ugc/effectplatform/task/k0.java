package com.ss.ugc.effectplatform.task;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.algorithm.d;
import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.ss.ugc.effectplatform.extension.c;
import com.ss.ugc.effectplatform.model.TagInfo;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import com.ss.ugc.effectplatform.model.h;
import com.ss.ugc.effectplatform.model.net.DownloadableModelResponse;
import com.ss.ugc.effectplatform.util.g;
import com.ss.ugc.effectplatform.util.m;
import com.ss.ugc.effectplatform.util.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k0 extends BaseTask {
    public final c0.a g;
    public final EffectConfig h;
    public final d i;
    public final int j;
    public final a k;

    public interface a {
        void a(h r1);

        void onFail(Exception r1);
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void b() {
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void a() {
        b0.a.a();
    L42:
        e = move-exception;
        this.h.getClass();     // Catch: Throwable -> L40
        a r1 = this.k;     // Catch: Throwable -> L40
        if (r1 == null) goto L56;
        r1.onFail(e);     // Catch: Throwable -> L40
        return;
    L56:
        return;
    L4:
        if (this.b == false) goto L6;
        return;
    L6:
        NetRequest r2 = f();     // Catch: Throwable -> L40 Exception -> L42
        INetworkClient r3 = (INetworkClient) this.h.u.a;     // Catch: Throwable -> L40 Exception -> L42
        String r4 = null;
        if (r3 == null) goto L9;
        NetResponse r5 = r3.fetchFromNetwork(r2);     // Catch: Throwable -> L40 Exception -> L42
    L10:
        if (r5 == null) goto L14;
        ByteReadStream r6 = r5.getBodyStream();     // Catch: Throwable -> L40 Exception -> L42
        if (r6 == null) goto L14;
        String r7 = c.a(r6);     // Catch: Throwable -> L40 Exception -> L42
    L15:
        if (r7 != null) goto L17;
        a r0 = this.k;     // Catch: Throwable -> L40 Exception -> L42
        if (r0 == null) goto L55;
        StringBuilder r8 = new StringBuilder("responseString return null when convertToString, errorMsg: ");     // Catch: Throwable -> L40 Exception -> L42
        if (r5 == null) goto L38;
        r4 = r5.getErrorMsg();     // Catch: Throwable -> L40 Exception -> L42
    L38:
        r8.append(r4);     // Catch: Throwable -> L40 Exception -> L42
        r0.onFail(new RuntimeException(r8.toString()));     // Catch: Throwable -> L40 Exception -> L42
        return;
    L55:
        return;
    L17:
        if (r.b(r7) == true) goto L27;
        h r9 = g(r7);     // Catch: Throwable -> L40 Exception -> L42
        if (r9 == null) goto L24;
        a r10 = this.k;     // Catch: Throwable -> L40 Exception -> L42
        if (r10 == null) goto L23;
        r10.a(r9);     // Catch: Throwable -> L40 Exception -> L42
    L23:
        this.h.getClass();     // Catch: Throwable -> L40 Exception -> L42
        return;
    L24:
        a r11 = this.k;     // Catch: Throwable -> L40 Exception -> L42
        if (r11 == null) goto L51;
        r11.onFail(new RuntimeException("result return null when parseResponse"));     // Catch: Throwable -> L40 Exception -> L42
        return;
    L51:
        return;
    L27:
        a r12 = this.k;     // Catch: Throwable -> L40 Exception -> L42
        if (r12 == null) goto L53;
        StringBuilder r13 = new StringBuilder("responseString is empty when convertToString, errorMsg: ");     // Catch: Throwable -> L40 Exception -> L42
        if (r5 == null) goto L32;
        r4 = r5.getErrorMsg();     // Catch: Throwable -> L40 Exception -> L42
    L32:
        r13.append(r4);     // Catch: Throwable -> L40 Exception -> L42
        r12.onFail(new RuntimeException(r13.toString()));     // Catch: Throwable -> L40 Exception -> L42
        return;
    L53:
        return;
    L14:
        r7 = null;
        goto L15
    L9:
        r5 = null;
    L40:
        th = move-exception;
        throw th;
    }

    public final NetRequest f() {
        HashMap r0 = new HashMap();
        String r1 = this.h.b;
        String r2 = "";
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        r0.put(EffectConfiguration.KEY_SDK_VERSION, r1);
        String r3 = this.h.g;
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        r0.put(EffectConfiguration.KEY_DEVICE_TYPE, r2);
        if (this.h.V == false) goto L12;
        String r4 = "1";
    L13:
        r0.put("model_mapping", r4);
        EffectConfig.ModelFileEnv r5 = this.h.J;
        if (r5 != null) goto L17;
        r5 = EffectConfig.ModelFileEnv.ONLINE;
    L17:
        r0.put("status", String.valueOf(r5.ordinal()));
        int r6 = this.j;
        if (r6 <= 0) goto L48;
        r0.put("busi_id", String.valueOf(r6));
    L48:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L22
        Object r8 = Result.constructor-impl(this.i.f("model/effect_local_config.json"));     // Catch: Throwable -> L22
    L24:
        Object r9 = null;
        if (Result.isFailure-impl(r8) == false) goto L27;
        r8 = null;
    L27:
        String r10 = (String) r8;
        if (r10 != null) goto L46;
    L44:
        int r11 = g.a;
        r0.putAll(g.b(this.h, 4));
        int r12 = m.a;
        return new NetRequest(m.a(r0, Intrinsics.stringPlus(this.h.E, "/model/api/arithmetics")), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    L46:
        dlc.a r13 = this.h.t;     // Catch: Throwable -> L35
        if (r13 == null) goto L32;
        TagInfo r14 = (TagInfo) r13.a.convertJsonToObj(r10, TagInfo.class);     // Catch: Throwable -> L35
    L33:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L35
    L38:
        if (Result.isFailure-impl(r15) == true) goto L41;
        r9 = r15;
    L41:
        TagInfo r16 = (TagInfo) r9;
        if (r16 == null) goto L44;
        r0.put("tag", r16.getTag());
        goto L44
    L32:
        r14 = null;
    L35:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L22:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L12:
        r4 = "0";
        goto L13
    }

    public final h g(String r6) {
        dlc.a r0 = this.h.t;
        if (r0 == null) goto L5;
        DownloadableModelResponse r7 = (DownloadableModelResponse) r0.a.convertJsonToObj(r6, DownloadableModelResponse.class);
    L6:
        if (r7 == null) goto L30;
        bytekn.foundation.utils.d r1 = new bytekn.foundation.utils.d();
        int r2 = r7.getStatus_code();
        if (r2 != 0) goto L29;
        DownloadableModelResponse.Data r8 = r7.getData();
        if (r8 == null) goto L27;
        Map<String, List<ModelInfo>> r9 = r8.getArithmetics();
        if (r9 == null) goto L27;
        Iterator<Map.Entry<String, List<ModelInfo>>> r3 = r9.entrySet().iterator();
    L15:
        if (r3.hasNext() == false) goto L25;
        Map.Entry<String, List<ModelInfo>> r4 = r3.next();
        String r5 = r4.getKey();
        List<ModelInfo> r10 = r4.getValue();
        List<ModelInfo> r11 = r9.get(r5);
        if (r11 == null) goto L23;
        Iterator<ModelInfo> r12 = r11.iterator();
    L20:
        if (r12.hasNext() == false) goto L15;
        r1.a(r5, r12.next());
        goto L20
    L23:
        throw new IllegalStateException("modelInfo list is null".toString());
    L25:
        return new h(r1);
    L27:
        throw new IllegalStateException("status_code == 0 but data == null, indicates there may be an internal server error");
    L29:
        throw new IllegalStateException("status code == " + r2 + " , indicates there is no model config from server, sdk version is " + this.h.b);
    L30:
        return null;
    L5:
        r7 = null;
        goto L6
    }

    public k0(EffectConfig r2, d r3, int r4, x0.b r5) {
        super(null, null);
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.g = new c0.a(false);
    }
}

package com.ss.ugc.effectplatform.task;

import a0.b;
import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.ss.ugc.effectplatform.cache.j;
import com.ss.ugc.effectplatform.extension.c;
import com.ss.ugc.effectplatform.model.CheckUpdateVersionModel;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.e;
import com.ss.ugc.effectplatform.model.net.EffectCheckUpdateResponse;
import com.ss.ugc.effectplatform.util.f;
import com.ss.ugc.effectplatform.util.g;
import com.ss.ugc.effectplatform.util.m;
import com.ss.ugc.effectplatform.util.r;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class o extends BaseNetworkTask<Boolean, EffectCheckUpdateResponse> {
    public final b<String> n;
    public final EffectConfig o;
    public final String p;
    public final String q;
    public final int r;
    public final Map<String, String> s;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask, com.ss.ugc.effectplatform.task.BaseTask
    public final void a() {
        int r0 = this.r;
        boolean r2 = true;
        if (r0 == 0) goto L13;
        if (r0 != 1) goto L6;
        int r1 = f.a;
        String r3 = f.d(this.p, this.q);
    L14:
        j r4 = (j) this.o.A.a;
        if (r4 == null) goto L17;
        String r5 = r4.queryToValue(r3);
    L18:
        if (r5 != null) goto L54;
    L29:
        r2 = false;
    L30:
        if (r2 == true) goto L32;
        l(0, 0, 0, new EffectCheckUpdateResponse(true, null, 0, 6, null));
        return;
    L32:
        if (this.b == false) goto L53;
        return;
    L53:
        NetRequest r6 = f();     // Catch: Exception -> L49
        INetworkClient r7 = (INetworkClient) this.o.u.a;     // Catch: Exception -> L49
        if (r7 == null) goto L37;
        NetResponse r8 = r7.fetchFromNetwork(r6);     // Catch: Exception -> L49
    L38:
        if (r8 == null) goto L47;
        String r9 = c.a(r8.getBodyStream());     // Catch: Exception -> L49
        if (r.b(r9) == true) goto L47;
        dlc.a r10 = this.o.t;     // Catch: Exception -> L49
        if (r10 == null) goto L47;
        EffectCheckUpdateResponse r11 = (EffectCheckUpdateResponse) r10.a.convertJsonToObj(r9, EffectCheckUpdateResponse.class);     // Catch: Exception -> L49
        if (r11 == null) goto L47;
        l(0, 0, 0, r11);     // Catch: Exception -> L49
        return;
    L47:
        k(null, null, new ExceptionResult(10002));     // Catch: Exception -> L49
        return;
    L37:
        r8 = null;
    L49:
        e = move-exception;
        k(null, null, new ExceptionResult(e));
        Logger.e$default(Logger.INSTANCE, "CheckUpdateTask", "checkUpdate Failed: " + e, null, 4, null);
        return;
    L54:
        dlc.a r12 = this.o.t;     // Catch: Exception -> L24
        if (r12 == null) goto L26;
        CheckUpdateVersionModel r13 = (CheckUpdateVersionModel) r12.a.convertJsonToObj(r5, CheckUpdateVersionModel.class);     // Catch: Exception -> L24
    L27:
        if (r13 == null) goto L29;
        this.n.a = r13.getVersion();
    L26:
        r13 = null;
    L24:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "CheckUpdateTask", "Json Parse Exception: " + e, null, 4, null);
        goto L26
    L17:
        r5 = null;
        goto L18
    L6:
        if (r0 != 2) goto L8;
        int r14 = f.a;
        r3 = f.j(this.p);
        goto L14
    L8:
        if (r0 == 3) goto L10;
        r3 = "effect_version" + this.p;
        goto L14
    L10:
        int r15 = f.a;
        r3 = this.p + FileManager.a + "info_sticker_version";
        goto L14
    L13:
        r3 = "effect_version" + this.p;
        goto L14
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final NetRequest f() {
        String r0 = "";
        if (r.b("") == false) goto L5;
        String r1 = EffectConfiguration.KEY_VERSION;
    L6:
        int r3 = mlc.b.a;
        mlc.a r2 = mlc.b.a(r1, this.o.G);
        boolean r4 = !Intrinsics.areEqual(r2.getString(EffectConfiguration.KEY_APP_VERSION, ""), this.o.c);
        if (r4 == false) goto L13;
        String r6 = this.o.c;
        if (r6 != null) goto L12;
        r6 = "";
    L12:
        r2.putString(EffectConfiguration.KEY_APP_VERSION, r6);
    L13:
        int r5 = g.a;
        HashMap r7 = g.b(this.o, 6);
        String r8 = this.p;
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        r7.put(EffectConfiguration.KEY_PANEL, r8);
        int r9 = this.r;
        if (r9 == 0) goto L31;
        if (r9 != 1) goto L21;
        String r10 = this.q;
        if (r10 != null) goto L30;
        r10 = "";
    L30:
        r7.put(EffectConfiguration.KEY_CATEGORY, r10);
        String r11 = "/category/check";
    L32:
        if (r4 == false) goto L34;
        r7.put(EffectConfiguration.KEY_VERSION, "");
    L38:
        Map<String, String> r12 = this.s;
        if (r12 == null) goto L41;
        r7.putAll(r12);
    L41:
        String r13 = this.o.C;
        if (r13 == null) goto L44;
        r7.put(EffectConfiguration.KEY_TEST_STATUS, r13);
    L44:
        int r14 = m.a;
        StringBuilder r15 = new StringBuilder();
        r15.append(this.o.E);
        this.o.getClass();
        r15.append("/effect/api");
        r15.append(r11);
        return new NetRequest(m.a(r7, r15.toString()), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    L34:
        String r16 = (String) this.n.a;
        if (r16 == null) goto L37;
        r0 = r16;
    L37:
        r7.put(EffectConfiguration.KEY_VERSION, r0);
        goto L38
    L21:
        if (r9 == 2) goto L31;
        if (r9 != 3) goto L31;
        r11 = "/sticker/checkUpdate";
    L31:
        r11 = "/panel/check";
        goto L32
    L5:
        r1 = "" + FileManager.a + EffectConfiguration.KEY_VERSION;
        goto L6
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final e p(dlc.a r2, String r3) {
        return (EffectCheckUpdateResponse) r2.a.convertJsonToObj(r3, EffectCheckUpdateResponse.class);
    }

    public o(EffectConfig r8, String r9, String r10, String r11, int r12, Map<String, String> r13) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r9, r8.P);
        this.o = r8;
        this.p = r10;
        this.q = r11;
        this.r = r12;
        this.s = r13;
        this.n = new b(null);
    }
}

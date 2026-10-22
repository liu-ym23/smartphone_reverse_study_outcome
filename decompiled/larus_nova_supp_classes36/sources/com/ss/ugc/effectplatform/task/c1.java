package com.ss.ugc.effectplatform.task;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.LocalPreloadResource;
import com.ss.ugc.effectplatform.model.net.PreloadResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c1 extends BaseNetworkTask<PreloadResponse, PreloadResponse> {
    public final EffectConfig n;
    public final int o;
    public final String p;
    public final Map<String, Object> q;

    public static final class a {
    }

    static {
    }

    public final int h() {
        return 10002;
    }

    public final NetRequest f() {
        HashMap r5 = new HashMap();
        r5.put("busi_id", Integer.valueOf(this.o));
        r5.put("busi_key", this.p);
        r5.put("ck_resource_sdk_version", "1.2.0");
        Map<String, Object> r0 = this.q;
        if (r0 == null) goto L10;
        Iterator<Map.Entry<String, Object>> r1 = r0.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<String, Object> r2 = r1.next();
        Object r3 = r2.getValue();
        if (r3 == null) goto L6;
        r5.put(r2.getKey(), r3);
    L10:
        com.ss.ugc.effectplatform.preload.b.a r4 = com.ss.ugc.effectplatform.preload.b.d;
        Object r6 = this.n.G;
        r4.getClass();
        com.ss.ugc.effectplatform.preload.b r7 = com.ss.ugc.effectplatform.preload.b.a.a(r6);
        if (r7 == null) goto L13;
        List<com.ss.ugc.effectplatform.preload.c> r8 = r7.f();
    L14:
        LinkedHashSet r9 = new LinkedHashSet();
        ArrayList r10 = new ArrayList();
        ArrayList r11 = new ArrayList();
        if (r8 == null) goto L26;
        Iterator<T> r12 = r8.iterator();
    L18:
        if (r12.hasNext() == false) goto L26;
        com.ss.ugc.effectplatform.preload.c r13 = (com.ss.ugc.effectplatform.preload.c) r12.next();
        StringBuilder r14 = new StringBuilder();
        r14.append(this.n.j);
        String r15 = FileManager.a;
        r14.append(FileManager.a);
        r14.append(r13.a);
        if (FileManager.d(r14.toString()) == true) goto L21;
        Logger.INSTANCE.w("JKL", "[预加载][配置请求][文件丢失][" + r13.a + ']');
        r11.add(r13.a);
        goto L18
    L21:
        com.ss.ugc.effectplatform.preload.c.a r16 = com.ss.ugc.effectplatform.preload.c.h;
        String r17 = r13.f;
        r16.getClass();
        String[] r18 = com.ss.ugc.effectplatform.preload.c.a.a(r17);
        int r19 = r18.length;
        int r110 = 0;
    L22:
        if (r110 >= r19) goto L24;
        r9.add(r18[r110]);
        r110 = r110 + 1;
        goto L22
    L24:
        r10.add(new LocalPreloadResource(r13.b, r13.c));
    L26:
        Iterator r20 = r11.iterator();
    L28:
        if (r20.hasNext() == false) goto L32;
        String r21 = (String) r20.next();
        com.ss.ugc.effectplatform.preload.b.a r22 = com.ss.ugc.effectplatform.preload.b.d;
        Object r23 = this.n.G;
        r22.getClass();
        com.ss.ugc.effectplatform.preload.b r24 = com.ss.ugc.effectplatform.preload.b.a.a(r23);
        if (r24 == null) goto L28;
        r24.c(r21);
        goto L28
    L32:
        Object[] r25 = r9.toArray(new String[0]);
        if (r25 == null) goto L45;
        String[] r26 = (String[]) r25;
        Logger r27 = Logger.INSTANCE;
        r27.d("JKL", "[预加载][配置请求][本地BusinessKey][" + com.ss.ugc.effectplatform.util.s.a(r26) + ']');
        r5.put("local_busi_key_list", r26);
        r27.d("JKL", "[预加载][配置请求][本地ResourceList][" + r10 + ']');
        Object[] r28 = r10.toArray(new LocalPreloadResource[0]);
        if (r28 == null) goto L43;
        r5.put("local_preload_resource_list", r28);
        int r29 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r30 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        if (this.n.V == false) goto L39;
        String r31 = Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL;
    L40:
        r30.put("model_mapping", r31);
        r5.put("base_info", r30);
        HashMap r32 = new HashMap();
        r32.put(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/json");
        return new NetRequest(Intrinsics.stringPlus(this.n.E, "/model/api/resource/preload"), null, HTTPMethod.POST, r32, r5, "application/json", false, null, 194, null);
    L39:
        r31 = "0";
        goto L40
    L43:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L45:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L13:
        r8 = null;
        goto L14
    }

    public final int i() {
        return this.n.q;
    }

    public final String g(String r4) {
        Logger.INSTANCE.d("JKL", "[预加载][配置请求][数据返回]: ".concat(r4));
        return r4;
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (PreloadResponse) r2.a.convertJsonToObj(r3, PreloadResponse.class);
    }

    public final void k(String r8, String r9, ExceptionResult r10) {
        Logger r6 = Logger.INSTANCE;
        Logger.e$default(r6, "EffectPreloadTask", "Failed: " + r10, null, 4, null);
        r10.setTrackParams(r8, this.n.E, r9);
        super.k(r8, r9, r10);
        Logger.e$default(r6, "JKL", "[预加载][配置请求][失败][" + r10 + ']', null, 4, null);
    }

    public final void l(long r9, long r11, long r13, com.ss.ugc.effectplatform.model.e r15) {
        super.l(r9, r11, r13, (PreloadResponse) r15);
        Logger.INSTANCE.d("JKL", "[预加载][配置请求][成功]");
    }

    public c1(EffectConfig r8, int r9, String r10, Map<String, ? extends Object> r11, String r12) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r12, r8.P);
        this.n = r8;
        this.o = r9;
        this.p = r10;
        this.q = r11;
    }
}

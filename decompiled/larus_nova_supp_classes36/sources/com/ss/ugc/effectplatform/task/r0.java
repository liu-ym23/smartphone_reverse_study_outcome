package com.ss.ugc.effectplatform.task;

import bytekn.foundation.io.file.FileManager;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.listener.IDownloadProviderEffectListListener;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.GifProviderEffectModel;
import com.ss.ugc.effectplatform.model.ProviderEffect;
import com.ss.ugc.effectplatform.model.ProviderEffectModel;
import com.ss.ugc.effectplatform.model.net.GifProviderEffectListResponse;
import com.ss.ugc.effectplatform.util.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class r0 extends BaseNetworkTask<GifProviderEffectModel, GifProviderEffectListResponse> {
    public final EffectConfig n;
    public final String o;
    public final String p;
    public final String q;
    public final Map<String, String> r;
    public final boolean s;

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        r1.put("gif_id", this.p);
        String r2 = this.q;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        r1.put("giphy_type", this.q);
    L11:
        Map<String, String> r4 = this.r;
        if (r4 == null) goto L14;
        r1.putAll(r4);
    L14:
        int r5 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r6 = new StringBuilder();
        r6.append(this.n.E);
        this.n.getClass();
        r6.append("/effect/api/stickers/list");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r6.toString()), null, null, null, null, null, false, null, 254, null);
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r3 = false;
        goto L9
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (GifProviderEffectListResponse) r2.a.convertJsonToObj(r3, GifProviderEffectListResponse.class);
    }

    public final void k(String r2, String r3, ExceptionResult r4) {
        r4.setTrackParams(null, null, null);
        super.k(r2, r3, r4);
    }

    public final void l(long r9, long r11, long r13, com.ss.ugc.effectplatform.model.e r15) {
        final GifProviderEffectListResponse r7 = (GifProviderEffectListResponse) r15;
        GifProviderEffectModel r16 = r7.getData();
        if (r16 == null) goto L7;
        ProviderEffectModel r17 = r16.getGifs();
        if (r17 == null) goto L7;
        List<ProviderEffect> r18 = r17.getSticker_list();
    L8:
        List<ProviderEffect> r0 = r18;
        boolean r1 = false;
        if (r0 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L21;
        Iterator<ProviderEffect> r4 = r18.iterator();
    L18:
        if (r4.hasNext() == false) goto L21;
        ProviderEffect r5 = r4.next();
        r5.setPath(this.n.i + FileManager.a + r5.getId() + ".gif");
    L21:
        if (this.s == false) goto L37;
        if (r0 != null) goto L24;
    L25:
        r1 = true;
    L26:
        if (r1 == true) goto L37;
        final IEffectPlatformBaseListener r10 = this.n.N.a(this.o);
        if ((r10 instanceof IDownloadProviderEffectListListener) == false) goto L31;
        e(new FetchProviderEffectByGiphyIdsTask$onSuccess$1(r10, r7));
    L31:
        q0 r12 = new q0(this, r7, r18);
        Iterator<ProviderEffect> r14 = r18.iterator();
    L33:
        if (r14.hasNext() == false) goto L45;
        ProviderEffect r19 = r14.next();
        String r110 = q.a();
        this.n.N.b(r110, r12);
        EffectConfig r111 = this.n;
        q1 r112 = r111.D;
        if (r112 == null) goto L33;
        r112.a(new DownloadProviderEffectTask(r111, r19, r110));
        goto L33
    L45:
        return;
    L24:
        if (r0.isEmpty() == false) goto L26;
    L37:
        super.l(r9, r11, r13, r7);
        return;
    L11:
        if (r0.isEmpty() == true) goto L14;
        r3 = false;
    L7:
        r18 = null;
        goto L8
    }

    public r0(EffectConfig r8, String r9, String r10, String r11, Map<String, String> r12, boolean r13) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r9, r8.P);
        this.n = r8;
        this.o = r9;
        this.p = r10;
        this.q = r11;
        this.r = r12;
        this.s = r13;
    }
}

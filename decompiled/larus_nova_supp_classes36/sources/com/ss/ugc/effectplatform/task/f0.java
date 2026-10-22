package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.EffectQRCode;
import com.ss.ugc.effectplatform.model.PlatformEffect;
import com.ss.ugc.effectplatform.model.net.ScanQRCodeResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f0 extends BaseNetworkTask<ScanQRCodeResponse.DataNode, ScanQRCodeResponse> {
    public final EffectConfig n;
    public final EffectQRCode o;
    public final String p;

    public static final class a {
        public final String a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((a) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "SecId(SecId=" + this.a + ")";
        }

        public a() {
            this.a = null;
        }
    }

    public final NetRequest f() {
        HashMap r0 = new HashMap();
        String r1 = this.n.b;
        if (r1 == null) goto L5;
        r0.put("sdk_version", r1);
    L5:
        dlc.a r2 = this.n.t;
        if (r2 == null) goto L8;
        String r3 = this.o.getQrCodeText();
        a r4 = (a) r2.a.convertJsonToObj(r3, a.class);
    L9:
        if (r4 == null) goto L17;
        String r5 = r4.a;
        if (r5 == null) goto L17;
        int r6 = bytekn.foundation.utils.e.a;
        String r7 = URLEncoder.encode(r5);
        if (r7 != null) goto L16;
        r7 = "";
    L16:
        r0.put("sec_id", r7);
    L17:
        String r8 = this.n.m;
        if (r8 == null) goto L20;
        r0.put("aid", r8);
    L20:
        int r9 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r10 = new StringBuilder();
        r10.append(this.n.E);
        this.n.getClass();
        r10.append("/effect/api/tidyEffect/secId");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r0, r10.toString()), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    L8:
        r4 = null;
        goto L9
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (ScanQRCodeResponse) r2.a.convertJsonToObj(r3, ScanQRCodeResponse.class);
    }

    public f0(EffectConfig r8, EffectQRCode r9, String r10) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r10, r8.P);
        this.n = r8;
        this.o = r9;
        this.p = r10;
    }

    public final void l(long r7, long r9, long r11, com.ss.ugc.effectplatform.model.e r13) {
        ScanQRCodeResponse.DataNode r8 = ((ScanQRCodeResponse) r13).getData();
        if (r8 == null) goto L11;
        PlatformEffect r10 = r8.getEffect();
        if (r10 == null) goto L7;
        final Effect r12 = r10.toEffect(r8.getUrl_prefix());
    L8:
        if (r12 == null) goto L12;
        r12.setId(StringsKt.replace$default(StringsKt.replace$default(r12.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
        com.ss.ugc.effectplatform.util.h r14 = com.ss.ugc.effectplatform.util.h.a;
        String r15 = this.n.i;
        List r16 = CollectionsKt.listOf(r12);
        r14.getClass();
        com.ss.ugc.effectplatform.util.h.e(r15, r16);
        e(new FetchEffectInfoByQRCodeTask$onSuccess$$inlined$apply$lambda$1(r12, this, r12));
        return;
    L12:
        return;
    L7:
        r12 = null;
        goto L8
    }
}

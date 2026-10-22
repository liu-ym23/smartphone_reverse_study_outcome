package com.ss.ugc.effectplatform.task;

import bytekn.foundation.io.file.FileManager;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.ProviderEffect;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DownloadProviderEffectTask extends BaseTask {
    public final EffectConfig g;
    public final ProviderEffect h;
    public final String i;

    /* JADX INFO: Removed unreachable split cross block B:35:0x00a1 */
    public final void a() {
        int r0 = this.g.q;
        com.ss.ugc.effectplatform.util.h r1 = com.ss.ugc.effectplatform.util.h.a;
        ProviderEffect r2 = this.h;
        r1.getClass();
        String r3 = com.ss.ugc.effectplatform.util.h.b(r2);
        String r4 = null;
        int r5 = 0;
        String r6 = null;
    L3:
        if (r5 >= r0) goto L47;
        if (((BaseTask) this).b == true) goto L48;
        int r7 = com.ss.ugc.effectplatform.util.r.a;     // Catch: Exception -> L21
        if (com.ss.ugc.effectplatform.util.r.b(this.h.getPath()) == false) goto L36;
        this.h.setPath(this.g.i + FileManager.a + this.h.getId() + ".gif");     // Catch: Exception -> L21
    L36:
        final ExceptionResult r8 = f(r3, this.h.getPath());     // Catch: Exception -> L13
        if (r8 == null) goto L12;
        if (r5 == (r0 - 1)) goto L17;
        r6 = r3;
    L31:
        r5 = r5 + 1;
        goto L3
    L17:
        e(new DownloadProviderEffectTask$onFail$1(this, r8));     // Catch: Exception -> L13
        return;
    L12:
        final ProviderEffect r9 = this.h;     // Catch: Exception -> L13
        e(new DownloadProviderEffectTask$onSuccess$1(this, r9));     // Catch: Exception -> L13
        return;
    L13:
        Exception e = e;
        String r10 = r3;
    L24:
        if (r5 == (r0 - 1)) goto L25;
        r6 = r10;
        goto L31
    L25:
        final ExceptionResult r11 = new ExceptionResult(e);
        if (r10 == null) goto L29;
        r4 = bytekn.foundation.utils.e.a(r10);
    L29:
        r11.setTrackParams(r10, "", r4);
        e(new DownloadProviderEffectTask$onFail$1(this, r11));
        return;
    L21:
        e = move-exception;
        r10 = r6;
        e = e;
        goto L24
    L48:
        return;
    }

    public final void b() {
        e(new DownloadProviderEffectTask$onCancel$1(this));
    }

    public final ExceptionResult f(String r13, String r14) {
        if (r14 == null) goto L16;
        NetRequest r11 = new NetRequest(r13, null, HTTPMethod.GET, null, null, null, false, null, 250, null);
        INetworkClient r15 = (INetworkClient) this.g.u.a;
        if (r15 == null) goto L6;
        NetResponse r16 = r15.fetchFromNetwork(r11);
    L7:
        if (r16 == null) goto L14;
        if (r16.getStatusCode() != 200) goto L14;
        com.ss.ugc.effectplatform.download.d r1 = new com.ss.ugc.effectplatform.download.d(r16.getBodyStream());
        String r2 = FileManager.a;
        bytekn.foundation.io.file.e r17 = FileManager.l(r14, false);
        com.ss.ugc.effectplatform.util.i r3 = com.ss.ugc.effectplatform.util.i.a;
        com.ss.ugc.effectplatform.util.i.b(r1, r17, r16.getContentLength(), new DownloadProviderEffectTask$download$1(this));
        return null;
    L14:
        return new ExceptionResult(400);
    L6:
        r16 = null;
        goto L7
    L16:
        return new ExceptionResult(10014);
    }

    public DownloadProviderEffectTask(EffectConfig r2, ProviderEffect r3, String r4) {
        super(r4, null);
        this.g = r2;
        this.h = r3;
        this.i = r4;
    }
}

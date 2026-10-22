package com.ss.ugc.effectplatform.task;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.util.Iterator;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class x extends BaseTask {
    public final EffectConfig g;
    public final com.ss.ugc.effectplatform.model.i h;
    public final String i;
    public final String j;

    public static final class a {
    }

    static {
    }

    public final void b() {
    }

    public final void a() {
        com.ss.ugc.effectplatform.model.i r0 = this.h;
        String r4 = r0.b;
        if (r4 != null) goto L6;
        final ExceptionResult r1 = new ExceptionResult(10015);
        e(new DownloadResourceTask$onFail$1(this, r1));
        return;
    L6:
        Iterator<String> r5 = r0.a.iterator();
        Object r6 = null;
        Exception e = null;
    L8:
        if (r5.hasNext() == false) goto L54;
        String r2 = r5.next();
        if (((BaseTask) this).b == true) goto L11;
        if (StringsKt.isBlank(r2) == false) goto L15;
        String r15 = r4;
    L60:
        Logger r3 = Logger.INSTANCE;     // Catch: Exception -> L50
        r3.d("DownloadResourceTask", "download " + r15 + " start!");     // Catch: Exception -> L50
        String r20 = r15;
        NetRequest r14 = new NetRequest(r15, null, HTTPMethod.GET, null, null, null, false, null, 250, null);     // Catch: Exception -> L48
        INetworkClient r7 = (INetworkClient) this.g.u.a;     // Catch: Exception -> L48
        if (r7 == null) goto L25;
        NetResponse r8 = r7.fetchFromNetwork(r14);     // Catch: Exception -> L48
    L26:
        if (r8 != null) goto L28;
    L34:
        StringBuilder r9 = new StringBuilder();     // Catch: Exception -> L48
        r9.append("download ");     // Catch: Exception -> L48
        String r13 = r20;
        r9.append(r13);     // Catch: Exception -> L46
        r9.append(" failed! errorMsg: ");     // Catch: Exception -> L46
        if (r8 == null) goto L39;
        String r10 = r8.getErrorMsg();     // Catch: Exception -> L46
    L40:
        r9.append(r10);     // Catch: Exception -> L46
        r9.append(". retrying");     // Catch: Exception -> L46
        Logger.e$default(r3, "DownloadResourceTask", r9.toString(), null, 4, null);     // Catch: Exception -> L46
        if (r8 == null) goto L43;
        String r11 = r8.getErrorMsg();     // Catch: Exception -> L46
    L44:
        e = new RuntimeException(r11);     // Catch: Exception -> L46
    L53:
        r6 = null;
        goto L8
    L43:
        r11 = null;
        goto L44
    L39:
        r10 = null;
    L46:
        e = e;
    L52:
        Logger.INSTANCE.e("DownloadResourceTask", "download " + r13 + " failed!", e);
        goto L53
    L28:
        if (r8.getStatusCode() != 200) goto L34;
        String r12 = FileManager.a;     // Catch: Exception -> L48
        if (FileManager.d(this.i) == false) goto L32;
        FileManager.o(this.i);     // Catch: Exception -> L48
    L32:
        new PolarisFileWrapper(this.i).getAbsoluteFile().createNewFile();     // Catch: Exception -> L48
        com.ss.ugc.effectplatform.util.i r16 = com.ss.ugc.effectplatform.util.i.a;     // Catch: Exception -> L48
        com.ss.ugc.effectplatform.util.i.i(this.i, new com.ss.ugc.effectplatform.download.d(r8.getBodyStream()));     // Catch: Exception -> L48
        e(new DownloadResourceTask$onSuccess$1(this));     // Catch: Exception -> L48
        return;
    L25:
        r8 = null;
    L48:
        e = e;
        r13 = r20;
    L50:
        e = e;
        r13 = r15;
        goto L52
    L15:
        StringBuilder r17 = new StringBuilder();
        if (StringsKt.endsWith$default(r2, "/", false, 2, r6) == true) goto L19;
        r2 = r2 + '/';
    L19:
        r17.append(r2);
        r17.append(r4);
        r15 = r17.toString();
        goto L60
    L11:
        return;
    L54:
        if (e == null) goto L56;
        final ExceptionResult r18 = new ExceptionResult(e);
        e(new DownloadResourceTask$onFail$1(this, r18));
        return;
    L56:
        final ExceptionResult r19 = new ExceptionResult(10002);
        e(new DownloadResourceTask$onFail$1(this, r19));
    }

    public x(EffectConfig r2, com.ss.ugc.effectplatform.model.i r3, String r4, String r5) {
        super(r5, null);
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
    }
}

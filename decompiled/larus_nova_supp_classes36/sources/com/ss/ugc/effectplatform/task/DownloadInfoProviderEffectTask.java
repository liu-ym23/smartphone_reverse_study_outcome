package com.ss.ugc.effectplatform.task;

import bytekn.foundation.io.file.FileManager;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.ss.ugc.effectplatform.exception.NetException;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.ProviderEffect;
import java.util.ArrayList;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DownloadInfoProviderEffectTask extends BaseTask {
    public static final c0.e j = null;
    public static final z.b<String, ArrayList<hlc.b>> k = null;
    public final EffectConfig g;
    public final ProviderEffect h;
    public final String i;

    public static final class a {
    }

    static {
        j = new c0.e();
        k = new z.b(false);
    }

    public final void a() {
        com.ss.ugc.effectplatform.util.h r0 = com.ss.ugc.effectplatform.util.h.a;
        ProviderEffect r1 = this.h;
        r0.getClass();
        String r2 = com.ss.ugc.effectplatform.util.h.b(r1);
        if (StringsKt.isBlank(r2) == false) goto L7;
        final ExceptionResult r3 = new ExceptionResult(10015);
        e(new DownloadInfoProviderEffectTask$onFail$1(this, r3));
        return;
    L7:
        if (StringsKt.isBlank(this.h.getId()) == false) goto L10;
        final ExceptionResult r4 = new ExceptionResult(10014);
        e(new DownloadInfoProviderEffectTask$onFail$1(this, r4));
        return;
    L10:
        IEffectPlatformBaseListener r5 = this.g.N.a(this.i);
        if (r5 == null) goto L48;
        hlc.b r6 = (hlc.b) r5;
        c0.e r7 = j;
        r7.a();
        z.b<String, ArrayList<hlc.b>> r8 = k;     // Catch: Throwable -> L44
        if (r8.containsKey(this.h.getId()) == false) goto L21;
        ArrayList r9 = (ArrayList) r8.get(this.h.getId());     // Catch: Throwable -> L44
        if (r9 == null) goto L18;
        r9.add(r6);     // Catch: Throwable -> L44
    L18:
        this.g.N.c(this.i);     // Catch: Throwable -> L44
        r7.b();
        return;
    L21:
        r8.put(this.h.getId(), new ArrayList());     // Catch: Throwable -> L44
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L44
        r7.b();
        int r11 = com.ss.ugc.effectplatform.util.r.a;
        if (com.ss.ugc.effectplatform.util.r.b(this.h.getPath()) == false) goto L49;
        int r12 = StringsKt.lastIndexOf$default(r2, "/", 0, false, 6, null);
        int r13 = StringsKt.lastIndexOf$default(r2, ".", 0, false, 6, null);
        int r14 = StringsKt.lastIndexOf$default(r2, "?", 0, false, 6, null);
        if (1 > r12) goto L31;
        if (r13 <= r12) goto L31;
        if (r13 < r14) goto L30;
        r14 = r2.length();
    L30:
        String r15 = r2.substring(r13, r14);
    L32:
        this.h.setPath(this.g.i + FileManager.a + this.h.getId() + "_" + r2.hashCode() + r15);
    L31:
        r15 = "";
    L49:
        String r16 = this.h.getPath();     // Catch: Exception -> L41
        if (r16 != null) goto L36;
        Intrinsics.throwNpe();     // Catch: Exception -> L41
    L36:
        final ProviderEffect r17 = f(r2, r16);     // Catch: Exception -> L41
        if (r17 == null) goto L39;
        e(new DownloadInfoProviderEffectTask$onSuccess$1(this, r17));
        return;
    L39:
        final ExceptionResult r18 = new ExceptionResult(10002);
        e(new DownloadInfoProviderEffectTask$onFail$1(this, r18));
        return;
    L41:
        e = move-exception;
        final ExceptionResult r19 = new ExceptionResult(e);
        e(new DownloadInfoProviderEffectTask$onFail$1(this, r19));
        return;
    L44:
        th = move-exception;
        r7.b();
        throw th;
    L48:
        throw new TypeCastException("null cannot be cast to non-null type com.ss.ugc.effectplatform.listener.IDownloadProviderEffectProgressListener");
    }

    public final void b() {
        e(new DownloadInfoProviderEffectTask$onCancel$1(this));
    }

    public final ProviderEffect f(final String r21, final String r22) {
        String r0 = FileManager.a;
        if (FileManager.d(this.g.i) == true) goto L5;
        FileManager.i(this.g.i);
    L5:
        com.ss.ugc.effectplatform.util.i r1 = com.ss.ugc.effectplatform.util.i.a;
        final String r8 = com.ss.ugc.effectplatform.util.i.a(r22);
        NetResponse r2 = null;
        if (r8 != null) goto L8;
        return null;
    L8:
        if (FileManager.d(r8) == false) goto L10;
        FileManager.o(r8);
    L10:
        NetRequest r3 = new NetRequest(r21, null, HTTPMethod.GET, null, null, null, false, null, 186, null);
        INetworkClient r4 = (INetworkClient) this.g.u.a;
        if (r4 == null) goto L13;
        r2 = r4.fetchFromNetwork(r3);
    L13:
        final NetResponse r5 = r2;
        if (r5 == null) goto L18;
        final com.ss.ugc.effectplatform.download.d r9 = new com.ss.ugc.effectplatform.download.d(r5.getBodyStream());
        com.ss.ugc.effectplatform.util.i.b(r9, FileManager.l(r8, false), r5.getContentLength(), new DownloadInfoProviderEffectTask$download$$inlined$apply$lambda$1(r9, r5, this, r21, r8, r22));
        r9.close();
        com.ss.ugc.effectplatform.util.i.h(r8, r22, false);
        return this.h;
    L18:
        throw new NetException(-2, "net response returned empty response!");
    }

    public DownloadInfoProviderEffectTask(EffectConfig r2, ProviderEffect r3, String r4) {
        super(r4, null);
        this.g = r2;
        this.h = r3;
        this.i = r4;
    }
}

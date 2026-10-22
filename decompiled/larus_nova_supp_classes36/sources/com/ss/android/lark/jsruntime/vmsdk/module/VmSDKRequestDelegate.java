package com.ss.android.lark.jsruntime.vmsdk.module;

import com.bytedance.ee.bear.thread.BearExecutors;
import com.bytedance.vmsdk.net.Request;
import com.bytedance.vmsdk.worker.JsWorker;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.jsruntime.vmsdk.g;
import com.ss.android.lark.jsruntime.vmsdk.h;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lr5.f;
import okhttp3.Call;
import okhttp3.Dispatcher;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import sa5.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/jsruntime/vmsdk/module/VmSDKRequestDelegate;", "Lcom/bytedance/vmsdk/worker/IWorkerDelegate;", "<init>", "()V", "loadAsync", "Lcom/bytedance/vmsdk/net/IReleasable;", "request", "Lcom/bytedance/vmsdk/net/Request;", "resolve", "Lcom/bytedance/vmsdk/net/INetCallback;", "Lcom/bytedance/vmsdk/net/Response;", "reject", "", "fetchWithUrlSync", "", "url", "Companion", "jsruntime_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class VmSDKRequestDelegate implements yp7.b {

    public static final class a {
    }

    static {
    }

    public VmSDKRequestDelegate() {
    }

    public final String a(String r1) {
        return "";
    }

    public final com.bytedance.vmsdk.net.b b(Request r12, JsWorker.b r13, JsWorker.c r14) {
        rnb.c.c("VmSDKRequestDelegate", "loadAsync() called with:netDelegate:" + g.a + " request = " + r12 + ", resolve = " + r13 + ", reject = " + r14);
        xx4.b r0 = g.a;
        xx4.d r3 = null;
        if (r0 == null) goto L52;
        h r4 = new h(r12.getUrl(), r12.getMethod(), r12.getHeaders(), r12.getBody());
        d r15 = new d(r13);
        e r16 = new e(r14);
        xx4.b r1 = r0;
        Intrinsics.checkNotNullParameter(r15, "resolve");
        Intrinsics.checkNotNullParameter(r16, "reject");
        InputStream r17 = r4.d;
        if (r17 != null) goto L53;
        byte[] r5 = null;
    L14:
        CloseableKt.closeFinally(r17, null);
        StringBuilder r18 = new StringBuilder("loadAsync() called with: url:");
        r18.append(du5.b.k(r4.a));
        r18.append(" body:");
        if (r5 == null) goto L17;
        int r6 = r5.length;
    L18:
        r18.append(r6);
        r18.append(" header:");
        Map<String, String> r7 = r4.c;
        if (r7 == null) goto L21;
        Boolean r8 = Boolean.valueOf(r7.isEmpty());
    L22:
        r18.append(r8);
        r18.append(", resolve = ");
        r18.append(r15);
        r18.append(", reject = ");
        r18.append(r16);
        tt5.a.h("JSRuntimeRequestDelegate", r18.toString());
        URL r19 = new URL(r4.a);     // Catch: Exception -> L49
        l r2 = new l(new sa5.h());     // Catch: Exception -> L49
        lr5.a r9 = lr5.b.b().b();     // Catch: Exception -> L49
        TimeUnit r10 = TimeUnit.SECONDS;     // Catch: Exception -> L49
        r9.a.writeTimeout(10, r10);     // Catch: Exception -> L49
        r9.a.readTimeout(10, r10);     // Catch: Exception -> L49
        r9.a.dispatcher(new Dispatcher(BearExecutors.d()));     // Catch: Exception -> L49
        r9.a.cookieJar(r2);     // Catch: Exception -> L49
        f r11 = r9.a();     // Catch: Exception -> L49
        okhttp3.Request.Builder r110 = new okhttp3.Request.Builder().url(r19);     // Catch: Exception -> L49
        Iterator<Map.Entry<String, String>> r20 = r4.c.entrySet().iterator();     // Catch: Exception -> L49
    L25:
        if (r20.hasNext() == false) goto L27;
        Map.Entry<String, String> r21 = r20.next();     // Catch: Exception -> L49
        r110.addHeader(r21.getKey(), r21.getValue());     // Catch: Exception -> L49
        goto L25
    L27:
        boolean r22 = true;
        if (StringsKt.equals("POST", r4.b, true) == true) goto L30;
        r110.get();     // Catch: Exception -> L49
    L47:
        Call r111 = r11.newCall(r110.build());     // Catch: Exception -> L49
        r111.enqueue(new xx4.c(r4, r15, r1, r16));     // Catch: Exception -> L49
        r3 = new xx4.d(r111);     // Catch: Exception -> L49
        goto L52
    L30:
        if (r4.d == null) goto L32;
        byte[] r23 = ByteStreamsKt.readBytes(new ByteArrayInputStream(r5));     // Catch: Exception -> L49
    L34:
        if (r4.d != null) goto L36;
    L41:
        String r24 = r4.c.get("content-type");     // Catch: Exception -> L49
        if (r24 == null) goto L44;
        MediaType r25 = MediaType.parse(r24);     // Catch: Exception -> L49
    L45:
        r110.post(RequestBody.create(r25, r23));     // Catch: Exception -> L49
        goto L47
    L44:
        r25 = null;
        goto L45
    L36:
        if (r23.length == 0) goto L39;
        r22 = false;
    L39:
        if (r22 == false) goto L41;
        tt5.a.k("JSRuntimeRequestDelegate", "loadAsync: Error:request body is empty");     // Catch: Exception -> L49
        goto L41
    L32:
        r23 = new byte[0];     // Catch: Exception -> L49
    L49:
        e = move-exception;
        tt5.a.d("JSRuntimeRequestDelegate", "fetch failed url:" + du5.b.k(r4.a) + ", reason is :" + e);
        r16.a(e);
        goto L52
    L21:
        r8 = null;
        goto L22
    L17:
        r6 = -1;
        goto L18
    L53:
        r5 = ByteStreamsKt.readBytes(r17);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);
        throw th;
    L52:
        return new c(r3);
    }
}

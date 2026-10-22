package id;

import com.bytedance.android.chunkstreamprediction.network.h;
import com.bytedance.android.chunkstreamprediction.network.j;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements com.bytedance.android.chunkstreamprediction.network.b.InterfaceC0111b<Object> {
    public final /* synthetic */ com.bytedance.android.chunkstreamprediction.network.c a;
    public final /* synthetic */ e b;
    public final /* synthetic */ String c;
    public final /* synthetic */ c d;

    @Override // com.bytedance.android.chunkstreamprediction.network.b.InterfaceC0111b
    public void call(com.bytedance.android.chunkstreamprediction.network.b<Object> r13, com.bytedance.android.chunkstreamprediction.network.a<Object> r14) {
        com.bytedance.android.chunkstreamprediction.network.c r0 = this.a;
        r0.b = System.currentTimeMillis();
        r13.a.getClass();
        h r1 = this.d.c;
        if (r1 == null) goto L49;
        r1.b();
    L49:
        com.bytedance.android.chunkstreamprediction.network.c.a r10 = new com.bytedance.android.chunkstreamprediction.network.c.a();     // Catch: Throwable -> L30
        r10.a = System.currentTimeMillis();     // Catch: Throwable -> L30
        d r11 = this.b.b();     // Catch: Throwable -> L30
        r10.b = System.currentTimeMillis();     // Catch: Throwable -> L30
        if (r11.a == 0) goto L7;
        InputStreamReader r12 = new InputStreamReader(r11, this.c);     // Catch: Throwable -> L30
        JsonReader r15 = this.d.a.newJsonReader(r12);     // Catch: Throwable -> L30
        Object r16 = this.d.b.read(r15);     // Catch: Throwable -> L30
        r12.close();     // Catch: Throwable -> L30
        this.b.a();     // Catch: Throwable -> L30
        long r17 = System.currentTimeMillis();     // Catch: Throwable -> L30
        r10.d = r17;     // Catch: Throwable -> L30
        r10.c = r10.b + (r11.d / 1000000);     // Catch: Throwable -> L30
        r10.f = r17;     // Catch: Throwable -> L30
        r10.g = r11.a;     // Catch: Throwable -> L30
        com.bytedance.android.chunkstreamprediction.network.c r18 = this.a;     // Catch: Throwable -> L30
        monitor-enter(r18);     // Catch: Throwable -> L30
        ((ArrayList) r18.a).add(r10);     // Catch: Throwable -> L27
        monitor-exit(r18);     // Catch: Throwable -> L30
        j r19 = r13.a;     // Catch: Throwable -> L30
        r10.toString();     // Catch: Throwable -> L30
        r19.getClass();     // Catch: Throwable -> L30
        if ((r16 instanceof com.bytedance.android.chunkstreamprediction.network.d) == false) goto L26;
        ((com.bytedance.android.chunkstreamprediction.network.d) r16).setChunkReadingReport(this.a);     // Catch: Throwable -> L30
    L26:
        r14.onNext(r16);     // Catch: Throwable -> L30
        r10.e = System.currentTimeMillis();     // Catch: Throwable -> L30
        goto L49
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L7:
        this.b.a();     // Catch: Throwable -> L30
        if (this.b.a.read() != (-1)) goto L18;
        r13.a.getClass();     // Catch: Throwable -> L30
        r14.onComplete();     // Catch: Throwable -> L30
        StreamParser.safeClose(this.b.a);     // Catch: Throwable -> L14
        h r110 = this.d.c;     // Catch: Throwable -> L14
        if (r110 == null) goto L62;
        r110.a();     // Catch: Throwable -> L14
        return;
    L62:
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L18:
        throw new IOException("Not EOF");     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        r14.onFailed(th);     // Catch: Throwable -> L39
        StreamParser.safeClose(this.b.a);     // Catch: Throwable -> L36
        h r111 = this.d.c;     // Catch: Throwable -> L36
        if (r111 == null) goto L64;
        r111.a();     // Catch: Throwable -> L36
        return;
    L64:
        return;
    L36:
        th = move-exception;
        th.printStackTrace();
        return;
    L39:
        th = move-exception;
        StreamParser.safeClose(this.b.a);     // Catch: Throwable -> L44
        if (this.d.c == null) goto L46;
        this.d.c.a();     // Catch: Throwable -> L44
    L46:
        throw th;
    L44:
        th = move-exception;
        th.printStackTrace();
        goto L46
    }

    public b(c r1, com.bytedance.android.chunkstreamprediction.network.c r10, e r11, String r12) {
        this.d = r1;
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}

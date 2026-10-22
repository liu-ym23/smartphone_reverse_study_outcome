package androidx.room;

import com.bytedance.applog.compress.CompressManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class h implements r3.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f2620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f2621b;

    public h(r r8) {
        he.i.f(r8, "database");
        this.f2620a = r8;
        Set r10 = Collections.newSetFromMap(new IdentityHashMap());
        he.i.e(r10, "newSetFromMap(IdentityHashMap())");
        this.f2621b = r10;
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [byte[], java.io.Serializable] */
    public final r3.e a(byte[] r8) {
        r3.e r10 = new r3.e();
        w3.a r11 = new w3.a();
        r10.f11423c = ((CompressManager) this.f2621b).compress(r8, ((d4.c) this.f2620a).f6761e.getInt("content_encode_method", 0), r11);
        r10.f11422b = r11.f12974c;
        HashMap r12 = new HashMap(4);
        int r13 = r11.f12974c;
        if (r13 != 0) goto L6;
        String r14 = "gzip";
        r12.put("log-encode-type", "gzip");
        String r15 = "Content-Encoding";
    L14:
        r12.put(r15, r14);
        String r16 = "application/octet-stream;tt-data=b";
    L15:
        r12.put("Content-Type", r16);
    L16:
        r10.f11424d = r12;
        return r10;
    L6:
        if (r13 != 1) goto L8;
    L13:
        r12.put("log-encode-type", "zstd");
        r14 = String.valueOf(0);
        r15 = "log-encode-token";
        goto L14
    L8:
        if (r13 == 2) goto L13;
        if (r13 != (-1)) goto L16;
        r16 = "application/json;charset=utf-8";
        goto L15
    }

    public h(r3.c r8, d4.c r10) {
        this.f2620a = r10;
        this.f2621b = new CompressManager(r8.f11402j, r8.H);
    }
}

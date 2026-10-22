package b3;

import com.bytedance.retrofit2.f;
import com.google.gson.d;
import com.google.gson.q;
import java.io.IOException;
import java.io.InputStreamReader;
import r4.e;

/* JADX INFO: loaded from: classes.dex */
final class c<T> implements f<e, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q<T> f523b;

    c(d r10, q<T> r11) {
        this.f522a = r10;
        this.f523b = r11;
    }

    public T a(e r10) {
        String r11 = "UTF-8";
        if (r10.a() == null) goto L5;
        r11 = r4.b.a(r10.a(), "UTF-8");
    L5:
        InputStreamReader r12 = new InputStreamReader(r10.c(), r11);
        i6.a r13 = this.f522a.q(r12);
        T r14 = this.f523b.b(r13);     // Catch: Throwable -> L9
        r12.close();     // Catch: IOException -> L12
    L8:
        return r14;
    L9:
        th = move-exception;
        r12.close();     // Catch: IOException -> L13
    L11:
        throw th;
    }

    @Override // com.bytedance.retrofit2.f
    public /* bridge */ /* synthetic */ Object convert(e r10) {
        return a(r10);
    }
}

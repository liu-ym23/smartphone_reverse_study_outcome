package b3;

import com.bytedance.retrofit2.f;
import com.google.gson.d;
import com.google.gson.q;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
final class b<T> implements f<T, r4.f> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Charset f519c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q<T> f521b;

    static {
        f519c = Charset.forName("UTF-8");
    }

    b(d r10, q<T> r11) {
        this.f520a = r10;
        this.f521b = r11;
    }

    public r4.f a(T r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(1024);
        OutputStreamWriter r12 = new OutputStreamWriter(r11, f519c);
        com.google.gson.stream.a r13 = this.f520a.r(r12);
        this.f521b.d(r13, r10);
        r13.close();
        return new com.bytedance.retrofit2.mime.c("application/json; charset=UTF-8", r11.toByteArray(), new String[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.retrofit2.f
    public /* bridge */ /* synthetic */ r4.f convert(Object r10) {
        return a(r10);
    }
}

package j7;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedOutput;
import ha.c0;
import ha.j;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class b<T> implements Converter<T, TypedOutput> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f8739c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f8740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<T> f8741b;

    static {
        f8739c = Charset.forName("UTF-8");
    }

    public b(j r8, c0<T> r10) {
        this.f8740a = r8;
        this.f8741b = r10;
    }

    @Override // com.bytedance.retrofit2.Converter
    public final TypedOutput convert(Object r8) {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream(1024);
        OutputStreamWriter r11 = new OutputStreamWriter(r10, f8739c);
        pa.c r12 = this.f8740a.h(r11);
        this.f8741b.b(r12, r8);
        r12.close();
        return new TypedByteArray("application/json; charset=UTF-8", r10.toByteArray(), new String[0]);
    }
}

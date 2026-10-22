package j7;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedInput;
import ha.c0;
import ha.j;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public final class c<T> implements Converter<TypedInput, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f8742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<T> f8743b;

    public c(j r8, c0<T> r10) {
        this.f8742a = r8;
        this.f8743b = r10;
    }

    @Override // com.bytedance.retrofit2.Converter
    public final Object convert(TypedInput r8) {
        TypedInput r10 = r8;
        String r11 = "UTF-8";
        if (r10.mimeType() == null) goto L5;
        r11 = MimeUtil.parseCharset(r10.mimeType(), "UTF-8");
    L5:
        InputStreamReader r12 = new InputStreamReader(r10.in(), r11);
        j r13 = this.f8742a;
        r13.getClass();
        pa.a r14 = new pa.a(r12);
        r14.f9952b = r13.f7981k;
        T r15 = this.f8743b.a(r14);     // Catch: Throwable -> L9
        r12.close();     // Catch: IOException -> L12
    L8:
        return r15;
    L9:
        th = move-exception;
        r12.close();     // Catch: IOException -> L13
    L11:
        throw th;
    }
}

package h64;

import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements TypedOutput {
    public final q64.d a;

    public final String md5Stub() {
        return null;
    }

    public final String fileName() {
        return this.a.b();
    }

    public final long length() {
        return this.a.c();
    }

    public final String mimeType() {
        return this.a.a();
    }

    public d(q64.d r2) {
        Intrinsics.checkNotNullParameter(r2, "requestBody");
        this.a = r2;
    }

    public final void writeTo(OutputStream r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "out");
        this.a.d(r2);
    }
}

package okhttp3;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k$a {
    public final ByteString a;
    public MediaType b;
    public final List<k.b> c;

    public final k d() {
        if (((ArrayList) this.c).isEmpty() == true) goto L7;
        return new k(this.a, this.b, this.c);
    L7:
        throw new IllegalStateException("Multipart body must have at least one part.");
    }

    public k$a() {
        String r0 = UUID.randomUUID().toString();
        this.b = k.e;
        this.c = new ArrayList();
        this.a = ByteString.encodeUtf8(r0);
    }

    public final void c(k.b r2) {
        if (r2 == null) goto L6;
        ((ArrayList) this.c).add(r2);
        return;
    L6:
        throw new NullPointerException("part == null");
    }

    public final void e(MediaType r4) {
        if (r4 == null) goto L10;
        if (r4.type().equals("multipart") == false) goto L8;
        this.b = r4;
        return;
    L8:
        throw new IllegalArgumentException("multipart != " + r4);
    L10:
        throw new NullPointerException("type == null");
    }

    public final void a(String r2, String r3) {
        c(k.b.b(r2, null, RequestBody.create(null, r3)));
    }

    public final void b(String r1, @Nullable String r2, RequestBody r3) {
        c(k.b.b(r1, r2, r3));
    }
}

package we;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {

    public static class a extends z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f13350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jf.g f13351b;

        public a(t r8, jf.g r10) {
            this.f13350a = r8;
            this.f13351b = r10;
        }

        @Override // we.z
        public final long contentLength() {
            return this.f13351b.l();
        }

        @Override // we.z
        @Nullable
        public final t contentType() {
            return this.f13350a;
        }

        @Override // we.z
        public final void writeTo(jf.e r8) {
            r8.s(this.f13351b);
        }
    }

    public static class b extends z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f13352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f13353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ byte[] f13354c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f13355d;

        public b(t r8, byte[] r10, int r11, int r12) {
            this.f13352a = r8;
            this.f13353b = r11;
            this.f13354c = r10;
            this.f13355d = r12;
        }

        @Override // we.z
        public final long contentLength() {
            return this.f13353b;
        }

        @Override // we.z
        @Nullable
        public final t contentType() {
            return this.f13352a;
        }

        @Override // we.z
        public final void writeTo(jf.e r8) {
            r8.l0(this.f13355d, this.f13353b, this.f13354c);
        }
    }

    public static class c extends z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f13356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ File f13357b;

        public c(t r8, File r10) {
            this.f13356a = r8;
            this.f13357b = r10;
        }

        @Override // we.z
        public final long contentLength() {
            return this.f13357b.length();
        }

        @Override // we.z
        @Nullable
        public final t contentType() {
            return this.f13356a;
        }

        @Override // we.z
        public final void writeTo(jf.e r8) {
            jf.n r10 = null;
            File r11 = this.f13357b;     // Catch: Throwable -> L13
            Logger r12 = jf.p.f8861a;     // Catch: Throwable -> L13
            if (r11 == null) goto L12;
            jf.n r13 = new jf.n(new FileInputStream(r11), new jf.x());     // Catch: Throwable -> L13
            r8.X(r13);     // Catch: Throwable -> L9
            xe.c.f(r13);
            return;
        L9:
            th = th;
            r10 = r13;
        L14:
            xe.c.f(r10);
            throw th;
        L12:
            throw new IllegalArgumentException("file == null");     // Catch: Throwable -> L13
        L13:
            th = th;
            goto L14
        }
    }

    public z() {
    }

    public static z create(@Nullable t r8, File r10) {
        if (r10 == null) goto L6;
        return new c(r8, r10);
    L6:
        throw new NullPointerException("file == null");
    }

    public long contentLength() {
        return -1;
    }

    @Nullable
    public abstract t contentType();

    public abstract void writeTo(jf.e r8);

    public static z create(@Nullable t r8, String r10) {
        Charset r11 = xe.c.f13888i;
        if (r8 == null) goto L13;
        String r12 = r8.f13262c;     // Catch: IllegalArgumentException -> L14
        if (r12 == null) goto L8;
        Charset r13 = Charset.forName(r12);     // Catch: IllegalArgumentException -> L14
    L9:
        if (r13 != null) goto L11;
        r8 = t.b(r8 + "; charset=utf-8");
        goto L13
    L11:
        r11 = r13;
    L8:
        r13 = null;
    L13:
        return create(r8, r10.getBytes(r11));
    }

    public static z create(@Nullable t r8, jf.g r10) {
        return new a(r8, r10);
    }

    public static z create(@Nullable t r8, byte[] r10) {
        return create(r8, r10, 0, r10.length);
    }

    public static z create(@Nullable t r8, byte[] r10, int r11, int r12) {
        if (r10 == null) goto L6;
        xe.c.e(r10.length, r11, r12);
        return new b(r8, r10, r12, r11);
    L6:
        throw new NullPointerException("content == null");
    }
}

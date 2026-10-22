package dlb;

import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.image.entity.LoadParams;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends dlb.b {
    public final dlb.b a;

    /* JADX INFO: renamed from: dlb.a$a, reason: collision with other inner class name */
    public static final class RunnableC0251a implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ List<com.ss.android.lark.image.uploader.entity.b> b;
        public final /* synthetic */ com.ss.android.lark.image.uploader.entity.c c;

        public RunnableC0251a(a r1, List<com.ss.android.lark.image.uploader.entity.b> r2, com.ss.android.lark.image.uploader.entity.c r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.a(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ List<com.ss.android.lark.image.uploader.entity.b> b;

        public b(a r1, List<com.ss.android.lark.image.uploader.entity.b> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.b(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.d();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.e();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ List<com.ss.android.lark.image.uploader.entity.b> b;

        public f(a r1, List<com.ss.android.lark.image.uploader.entity.b> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.f(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ a a;

        public g(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.g();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ a a;

        public h(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.h();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public i(a r1, int r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.i(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class j implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ com.ss.android.lark.image.uploader.entity.b c;
        public final /* synthetic */ long d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;

        public j(a r1, int r2, com.ss.android.lark.image.uploader.entity.b r3, long r4, int r6, int r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
            this.f = r7;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.j(this.b, this.c, this.d, this.e, this.f);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class k implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ com.ss.android.lark.image.uploader.entity.b b;
        public final /* synthetic */ com.ss.android.lark.image.uploader.entity.c c;

        public k(a r1, com.ss.android.lark.image.uploader.entity.b r2, com.ss.android.lark.image.uploader.entity.c r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.k(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // dlb.b
    public final void c() {
        UICallbackExecutor.execute(new c(this));
    }

    @Override // dlb.b
    public final void d() {
        UICallbackExecutor.execute(new d(this));
    }

    @Override // dlb.b
    public final void e() {
        UICallbackExecutor.execute(new e(this));
    }

    @Override // dlb.b
    public final void g() {
        UICallbackExecutor.execute(new g(this));
    }

    @Override // dlb.b
    public final void h() {
        UICallbackExecutor.execute(new h(this));
    }

    public a(dlb.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a = r2;
    }

    @Override // dlb.b
    public final void b(List<com.ss.android.lark.image.uploader.entity.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "imageList");
        UICallbackExecutor.execute(new b(this, r2));
    }

    @Override // dlb.b
    public final void f(List<com.ss.android.lark.image.uploader.entity.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "imageList");
        UICallbackExecutor.execute(new f(this, r2));
    }

    @Override // dlb.b
    public final void a(List<com.ss.android.lark.image.uploader.entity.b> r2, com.ss.android.lark.image.uploader.entity.c r3) {
        Intrinsics.checkNotNullParameter(r2, "imageList");
        Intrinsics.checkNotNullParameter(r3, "result");
        UICallbackExecutor.execute(new RunnableC0251a(this, r2, r3));
    }

    @Override // dlb.b
    public final void i(int r2, String r3) {
        UICallbackExecutor.execute(new i(this, r2, r3));
    }

    @Override // dlb.b
    public final void k(com.ss.android.lark.image.uploader.entity.b r2, com.ss.android.lark.image.uploader.entity.c r3) {
        Intrinsics.checkNotNullParameter(r2, LoadParams.ImageFormat.IMAGE);
        UICallbackExecutor.execute(new k(this, r2, r3));
    }

    @Override // dlb.b
    public final void j(int r10, com.ss.android.lark.image.uploader.entity.b r11, long r12, int r14, int r15) {
        UICallbackExecutor.execute(new j(this, r10, r11, r12, r14, r15));
    }
}

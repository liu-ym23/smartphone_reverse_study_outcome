package okhttp3.internal.cache;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.NetConst;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Protocol;
import okhttp3.a0;
import okhttp3.e;
import okhttp3.q;
import okhttp3.r;
import okhttp3.t;
import okhttp3.x;
import okhttp3.z;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0259a f11732b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final okhttp3.c f11733a;

    /* JADX INFO: renamed from: okhttp3.internal.cache.a$a, reason: collision with other inner class name */
    public static final class C0259a {
        private C0259a() {
        }

        public /* synthetic */ C0259a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ r a(C0259a r10, r r11, r r12) {
            return r10.c(r11, r12);
        }

        public static final /* synthetic */ z b(C0259a r10, z r11) {
            return r10.f(r11);
        }

        private final r c(r r10, r r11) {
            r.a r12 = new r.a();
            int r13 = r10.size();
            int r14 = 0;
            int r15 = 0;
        L3:
            if (r15 >= r13) goto L17;
            String r16 = r10.c(r15);
            String r17 = r10.i(r15);
            if (StringsKt.equals("Warning", r16, true) == false) goto L10;
            if (StringsKt.startsWith$default(r17, NetConst.ENCRYPT_VERISON_CODE, false, 2, null) == false) goto L10;
        L16:
            r15 = r15 + 1;
        L10:
            if (d(r16) == false) goto L12;
        L15:
            r12.c(r16, r17);
            goto L16
        L12:
            if (e(r16) == false) goto L15;
            if (r11.b(r16) != null) goto L16;
        L17:
            int r18 = r11.size();
        L18:
            if (r14 >= r18) goto L26;
            String r19 = r11.c(r14);
            if (d(r19) == true) goto L24;
            if (e(r19) == false) goto L24;
            r12.c(r19, r11.i(r14));
        L24:
            r14 = r14 + 1;
            goto L18
        L26:
            return r12.e();
        }

        private final boolean d(String r10) {
            if (StringsKt.equals("Content-Length", r10, true) == false) goto L5;
            return true;
        L5:
            if (StringsKt.equals(NetConst.KEY_CONTENT_ENCODING, r10, true) == false) goto L7;
            return true;
        L7:
            if (StringsKt.equals(NetConst.KEY_CONTENT_TYPE, r10, true) == true) goto L13;
            return false;
        L13:
            return true;
        }

        private final boolean e(String r10) {
            if (StringsKt.equals("Connection", r10, true) == false) goto L5;
        L19:
            return false;
        L5:
            if (StringsKt.equals("Keep-Alive", r10, true) == true) goto L19;
            if (StringsKt.equals("Proxy-Authenticate", r10, true) == true) goto L19;
            if (StringsKt.equals("Proxy-Authorization", r10, true) == true) goto L19;
            if (StringsKt.equals("TE", r10, true) == true) goto L19;
            if (StringsKt.equals("Trailers", r10, true) == true) goto L19;
            if (StringsKt.equals("Transfer-Encoding", r10, true) == true) goto L19;
            if (StringsKt.equals("Upgrade", r10, true) == true) goto L19;
            return true;
        }

        private final z f(z r10) {
            if (r10 == null) goto L5;
            a0 r11 = r10.a();
        L6:
            if (r11 != null) goto L8;
            return r10;
        L8:
            return r10.F().b(null).c();
        L5:
            r11 = null;
            goto L6
        }
    }

    static {
        f11732b = new C0259a(null);
    }

    public a(okhttp3.c r10) {
    }

    @Override // okhttp3.t
    public z a(t.a r10) {
        Intrinsics.checkNotNullParameter(r10, "chain");
        e r11 = r10.call();
        b r12 = new b.C0260b(System.currentTimeMillis(), r10.a(), null).b();
        x r13 = r12.b();
        z r14 = r12.a();
        if ((r11 instanceof okhttp3.internal.connection.e) == false) goto L5;
        okhttp3.internal.connection.e r15 = (okhttp3.internal.connection.e) r11;
    L6:
        if (r15 == null) goto L9;
        q r16 = r15.n();
        if (r16 == null) goto L9;
    L10:
        if (r13 != null) goto L14;
        if (r14 != null) goto L14;
        z r17 = new z.a().r(r10.a()).p(Protocol.HTTP_1_1).g(TypedValues.PositionType.TYPE_PERCENT_HEIGHT).m("Unsatisfiable Request (only-if-cached)").b(hc.e.f9279c).s(-1).q(System.currentTimeMillis()).c();
        r16.D(r11, r17);
        return r17;
    L14:
        if (r13 != null) goto L17;
        Intrinsics.checkNotNull(r14);
        z r18 = r14.F().d(C0259a.b(f11732b, r14)).c();
        r16.b(r11, r18);
        return r18;
    L17:
        if (r14 == null) goto L36;
        r16.a(r11, r14);
    L36:
        z r19 = r10.b(r13);     // Catch: Throwable -> L34
        if (r14 == null) goto L32;
        boolean r20 = false;
        if (r19 != null) goto L24;
    L26:
        if (r20 == true) goto L30;
        a0 r21 = r14.a();
        if (r21 == null) goto L32;
        hc.e.m(r21);
        goto L32
    L30:
        z.a r22 = r14.F();
        C0259a r23 = f11732b;
        r22.k(C0259a.a(r23, r14.v(), r19.v())).s(r19.M()).q(r19.J()).d(C0259a.b(r23, r14)).n(C0259a.b(r23, r19)).c();
        a0 r24 = r19.a();
        Intrinsics.checkNotNull(r24);
        r24.close();
        Intrinsics.checkNotNull(this.f11733a);
        throw null;
    L24:
        if (r19.k() != 304) goto L26;
        r20 = true;
    L32:
        Intrinsics.checkNotNull(r19);
        z.a r25 = r19.F();
        C0259a r26 = f11732b;
        return r25.d(C0259a.b(r26, r14)).n(C0259a.b(r26, r19)).c();
    L34:
        th = move-exception;
        throw th;
    L9:
        r16 = q.f12021a;
        goto L10
    L5:
        r15 = null;
        goto L6
    }
}

package okhttp3;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Typography;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends y {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f12052g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public static final u f12053h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @JvmField
    public static final u f12054i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final byte[] f12055j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final byte[] f12056k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final byte[] f12057l = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ByteString f12058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u f12059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<c> f12060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final u f12061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f12062f;

    @SourceDebugExtension({"SMAP\nMultipartBody.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultipartBody.kt\nokhttp3/MultipartBody$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,345:1\n1#2:346\n*E\n"})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteString f12063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private u f12064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<c> f12065c;

        /* JADX WARN: Multi-variable type inference failed */
        @JvmOverloads
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @JvmOverloads
        public a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "boundary");
            this.f12063a = ByteString.Companion.d(r10);
            this.f12064b = v.f12053h;
            this.f12065c = new ArrayList();
        }

        public /* synthetic */ a(String r10, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 1) == 0) goto L5;
            r10 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(r10, "randomUUID().toString()");
        L5:
            this(r10);
        }

        public final a a(String r10, String r11, y r12) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r12, "body");
            c(c.f12066c.b(r10, r11, r12));
            return this;
        }

        public final a b(r r10, y r11) {
            Intrinsics.checkNotNullParameter(r11, "body");
            c(c.f12066c.a(r10, r11));
            return this;
        }

        public final a c(c r10) {
            Intrinsics.checkNotNullParameter(r10, "part");
            this.f12065c.add(r10);
            return this;
        }

        public final v d() {
            if ((!this.f12065c.isEmpty()) == false) goto L7;
            return new v(this.f12063a, this.f12064b, hc.e.T(this.f12065c));
        L7:
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }

        public final a e(u r10) {
            Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
            if (Intrinsics.areEqual(r10.h(), "multipart") == false) goto L7;
            this.f12064b = r10;
            return this;
        L7:
            throw new IllegalArgumentException(("multipart != " + r10).toString());
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public final void a(StringBuilder r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Intrinsics.checkNotNullParameter(r11, "key");
            r10.append(Typography.quote);
            int r12 = r11.length();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L15;
            char r14 = r11.charAt(r13);
            if (r14 != '\n') goto L9;
            String r15 = "%0A";
        L7:
            r10.append(r15);
        L14:
            r13 = r13 + 1;
            goto L3
        L9:
            if (r14 != '\r') goto L11;
            r15 = "%0D";
            goto L7
        L11:
            if (r14 != '\"') goto L13;
            r15 = "%22";
            goto L7
        L13:
            r10.append(r14);
            goto L14
        L15:
            r10.append(Typography.quote);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f12066c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r f12067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final y f12068b;

        @SourceDebugExtension({"SMAP\nMultipartBody.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultipartBody.kt\nokhttp3/MultipartBody$Part$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,345:1\n1#2:346\n*E\n"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r10) {
                this();
            }

            @JvmStatic
            public final c a(r r10, y r11) {
                Intrinsics.checkNotNullParameter(r11, "body");
                DefaultConstructorMarker r12 = null;
                if (r10 == null) goto L5;
                String r13 = r10.b(NetConst.KEY_CONTENT_TYPE);
            L6:
                boolean r14 = true;
                if (r13 != null) goto L9;
                boolean r15 = true;
            L10:
                if (r15 == false) goto L23;
                if (r10 == null) goto L13;
                String r16 = r10.b("Content-Length");
            L14:
                if (r16 == null) goto L17;
                r14 = false;
            L17:
                if (r14 == false) goto L21;
                return new c(r10, r11, r12);
            L21:
                throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
            L13:
                r16 = null;
                goto L14
            L23:
                throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
            L9:
                r15 = false;
                goto L10
            L5:
                r13 = null;
                goto L6
            }

            @JvmStatic
            public final c b(String r10, String r11, y r12) {
                Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
                Intrinsics.checkNotNullParameter(r12, "body");
                StringBuilder r13 = new StringBuilder();
                r13.append("form-data; name=");
                b r14 = v.f12052g;
                r14.a(r13, r10);
                if (r11 == null) goto L5;
                r13.append("; filename=");
                r14.a(r13, r11);
            L5:
                String r15 = r13.toString();
                Intrinsics.checkNotNullExpressionValue(r15, "StringBuilder().apply(builderAction).toString()");
                return a(new r.a().d("Content-Disposition", r15).e(), r12);
            }
        }

        static {
            f12066c = new a(null);
        }

        private c(r r10, y r11) {
            this.f12067a = r10;
            this.f12068b = r11;
        }

        public /* synthetic */ c(r r10, y r11, DefaultConstructorMarker r12) {
            this(r10, r11);
        }

        @JvmName(name = "body")
        public final y a() {
            return this.f12068b;
        }

        @JvmName(name = "headers")
        public final r b() {
            return this.f12067a;
        }
    }

    static {
        f12052g = new b(null);
        u.a r10 = u.f12046d;
        f12053h = r10.a("multipart/mixed");
        r10.a("multipart/alternative");
        r10.a("multipart/digest");
        r10.a("multipart/parallel");
        f12054i = r10.a("multipart/form-data");
        f12055j = new byte[]{58, 32};
        f12056k = new byte[]{13, 10};
        f12057l = new byte[]{45, 45};
    }

    public v(ByteString r10, u r11, List<c> r12) {
        Intrinsics.checkNotNullParameter(r10, "boundaryByteString");
        Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r12, "parts");
        this.f12058b = r10;
        this.f12059c = r11;
        this.f12060d = r12;
        this.f12061e = u.f12046d.a(r11 + "; boundary=" + h());
        this.f12062f = -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long i(okio.e r13, boolean r14) {
        if (r14 == false) goto L4;
        r13 = new okio.d();
        okio.d r10 = r13;
    L5:
        int r11 = this.f12060d.size();
        long r12 = 0;
        int r15 = 0;
    L6:
        if (r15 >= r11) goto L26;
        c r16 = this.f12060d.get(r15);
        r r17 = r16.b();
        y r18 = r16.a();
        Intrinsics.checkNotNull(r13);
        r13.write(f12057l);
        r13.O(this.f12058b);
        r13.write(f12056k);
        if (r17 == null) goto L12;
        int r19 = r17.size();
        int r20 = 0;
    L10:
        if (r20 >= r19) goto L12;
        r13.t(r17.c(r20)).write(f12055j).t(r17.i(r20)).write(f12056k);
        r20 = r20 + 1;
    L12:
        u r21 = r18.b();
        if (r21 == null) goto L15;
        r13.t("Content-Type: ").t(r21.toString()).write(f12056k);
    L15:
        long r22 = r18.a();
        if (r22 == (-1)) goto L18;
        r13.t("Content-Length: ").W(r22).write(f12056k);
    L21:
        byte[] r23 = f12056k;
        r13.write(r23);
        if (r14 == false) goto L24;
        r12 = r12 + r22;
    L25:
        r13.write(r23);
        r15 = r15 + 1;
        goto L6
    L24:
        r18.g(r13);
        goto L25
    L18:
        if (r14 == false) goto L21;
        Intrinsics.checkNotNull(r10);
        r10.f();
        return -1;
    L26:
        Intrinsics.checkNotNull(r13);
        byte[] r24 = f12057l;
        r13.write(r24);
        r13.O(this.f12058b);
        r13.write(r24);
        r13.write(f12056k);
        if (r14 == false) goto L35;
        Intrinsics.checkNotNull(r10);
        long r25 = r12 + r10.M();
        r10.f();
        return r25;
    L35:
        return r12;
    L4:
        r10 = 0;
        goto L5
    }

    @Override // okhttp3.y
    public long a() {
        long r10 = this.f12062f;
        if (r10 != (-1)) goto L6;
        long r11 = i(null, true);
        this.f12062f = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // okhttp3.y
    public u b() {
        return this.f12061e;
    }

    @Override // okhttp3.y
    public void g(okio.e r10) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        i(r10, false);
    }

    @JvmName(name = "boundary")
    public final String h() {
        return this.f12058b.utf8();
    }
}

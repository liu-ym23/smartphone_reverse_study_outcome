package we;

import com.sdk.bwdl.StateMachine.BWDLDataStructure;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends z {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final t f13263e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final t f13264f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f13265g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f13266h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f13267i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jf.g f13268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f13269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f13270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f13271d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final jf.g f13272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public t f13273b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList f13274c;

        public a() {
            String r8 = UUID.randomUUID().toString();
            this.f13273b = u.f13263e;
            this.f13274c = new ArrayList();
            this.f13272a = jf.g.d(r8);
        }

        public final void a(b r8) {
            if (r8 == null) goto L6;
            this.f13274c.add(r8);
            return;
        L6:
            throw new NullPointerException("part == null");
        }

        public final u b() {
            ArrayList r8 = this.f13274c;
            if (r8.isEmpty() == true) goto L7;
            return new u(this.f13272a, this.f13273b, r8);
        L7:
            throw new IllegalStateException("Multipart body must have at least one part.");
        }

        public final void c(t r8) {
            if (r8 == null) goto L10;
            if (r8.f13261b.equals("multipart") == false) goto L8;
            this.f13273b = r8;
            return;
        L8:
            throw new IllegalArgumentException("multipart != " + r8);
        L10:
            throw new NullPointerException("type == null");
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final q f13275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z f13276b;

        public b(@Nullable q r8, z r10) {
            this.f13275a = r8;
            this.f13276b = r10;
        }

        public static b a(@Nullable q r8, z r10) {
            if (r10 == null) goto L18;
            if (r8 != null) goto L5;
        L9:
            if (r8 == null) goto L16;
            if (r8.d("Content-Length") == null) goto L16;
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        L16:
            return new b(r8, r10);
        L5:
            if (r8.d("Content-Type") == null) goto L9;
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        L18:
            throw new NullPointerException("body == null");
        }
    }

    static {
        f13263e = t.a("multipart/mixed");
        t.a("multipart/alternative");
        t.a("multipart/digest");
        t.a("multipart/parallel");
        f13264f = t.a("multipart/form-data");
        f13265g = new byte[]{58, BWDLDataStructure.DataLinkParamStructure.BT_SPP};
        f13266h = new byte[]{13, 10};
        f13267i = new byte[]{45, 45};
    }

    public u(jf.g r8, t r10, ArrayList r11) {
        this.f13271d = -1;
        this.f13268a = r8;
        this.f13269b = t.a(r10 + "; boundary=" + r8.p());
        this.f13270c = xe.c.p(r11);
    }

    public static void a(String r8, StringBuilder r10) {
        r10.append('\"');
        int r11 = r8.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L15;
        char r13 = r8.charAt(r12);
        if (r13 != '\n') goto L7;
        String r14 = "%0A";
    L13:
        r10.append(r14);
    L14:
        r12 = r12 + 1;
        goto L3
    L7:
        if (r13 == '\r') goto L11;
        if (r13 == '\"') goto L10;
        r10.append(r13);
        goto L14
    L10:
        r14 = "%22";
        goto L13
    L11:
        r14 = "%0D";
        goto L13
    L15:
        r10.append('\"');
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long b(@Nullable jf.e r17, boolean r18) {
        if (r18 == false) goto L5;
        jf.e r8 = new jf.d();
        jf.d r10 = r8;
    L6:
        List<b> r11 = this.f13270c;
        int r12 = r11.size();
        long r13 = 0;
        int r14 = 0;
    L7:
        jf.g r15 = this.f13268a;
        byte[] r16 = f13267i;
        byte[] r19 = f13266h;
        if (r14 >= r12) goto L28;
        b r110 = r11.get(r14);
        q r111 = r110.f13275a;
        r8.write(r16);
        r8.s(r15);
        r8.write(r19);
        if (r111 == null) goto L14;
        int r20 = r111.f13238a.length / 2;
        int r112 = 0;
    L12:
        if (r112 >= r20) goto L14;
        r8.p(r111.e(r112)).write(f13265g).p(r111.j(r112)).write(r19);
        r112 = r112 + 1;
    L14:
        z r21 = r110.f13276b;
        t r113 = r21.contentType();
        if (r113 == null) goto L17;
        r8.p("Content-Type: ").p(r113.f13260a).write(r19);
    L17:
        long r114 = r21.contentLength();
        if (r114 == (-1)) goto L20;
        r8.p("Content-Length: ").N(r114).write(r19);
    L23:
        r8.write(r19);
        if (r18 == false) goto L26;
        r13 = r13 + r114;
    L27:
        r8.write(r19);
        r14 = r14 + 1;
        goto L7
    L26:
        r21.writeTo(r8);
        goto L27
    L20:
        if (r18 == false) goto L23;
        r10.a();
        return -1;
    L28:
        r8.write(r16);
        r8.s(r15);
        r8.write(r16);
        r8.write(r19);
        if (r18 == false) goto L37;
        long r22 = r13 + r10.f8830b;
        r10.a();
        return r22;
    L37:
        return r13;
    L5:
        r10 = 0;
        r8 = r17;
        goto L6
    }

    @Override // we.z
    public final long contentLength() {
        long r8 = this.f13271d;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        long r10 = b(null, true);
        this.f13271d = r10;
        return r10;
    }

    @Override // we.z
    public final t contentType() {
        return this.f13269b;
    }

    @Override // we.z
    public final void writeTo(jf.e r8) {
        b(r8, false);
    }
}

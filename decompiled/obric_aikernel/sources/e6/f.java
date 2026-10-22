package e6;

import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends i6.a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final Object f8647y = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Object[] f8648u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f8649v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String[] f8650w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int[] f8651x;

    class a extends Reader {
        a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] r10, int r11, int r12) {
            throw new AssertionError();
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8652a = null;

        static {
            int[] r10 = new int[JsonToken.values().length];
            f8652a = r10;
            r10[JsonToken.NAME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f8652a[JsonToken.END_ARRAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f8652a[JsonToken.END_OBJECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f8652a[JsonToken.END_DOCUMENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        new a();
        f8647y = new Object();
    }

    private String B() {
        return " at path " + getPath();
    }

    private void k0(JsonToken r10) {
        if (Q() != r10) goto L6;
        return;
    L6:
        throw new IllegalStateException("Expected " + r10 + " but was " + Q() + B());
    }

    private String m0(boolean r10) {
        k0(JsonToken.NAME);
        Map.Entry r11 = (Map.Entry) ((Iterator) n0()).next();
        String r12 = (String) r11.getKey();
        String[] r13 = this.f8650w;
        int r14 = this.f8649v - 1;
        if (r10 == false) goto L5;
        String r15 = "<skipped>";
    L6:
        r13[r14] = r15;
        q0(r11.getValue());
        return r12;
    L5:
        r15 = r12;
        goto L6
    }

    private Object n0() {
        return this.f8648u[this.f8649v - 1];
    }

    private Object o0() {
        Object[] r10 = this.f8648u;
        int r11 = this.f8649v - 1;
        this.f8649v = r11;
        Object r12 = r10[r11];
        r10[r11] = null;
        return r12;
    }

    private void q0(Object r10) {
        int r11 = this.f8649v;
        Object[] r12 = this.f8648u;
        if (r11 != r12.length) goto L5;
        int r13 = r11 * 2;
        this.f8648u = Arrays.copyOf(r12, r13);
        this.f8651x = Arrays.copyOf(this.f8651x, r13);
        this.f8650w = (String[]) Arrays.copyOf(this.f8650w, r13);
    L5:
        Object[] r14 = this.f8648u;
        int r15 = this.f8649v;
        this.f8649v = r15 + 1;
        r14[r15] = r10;
    }

    private String r(boolean r10) {
        StringBuilder r11 = new StringBuilder();
        r11.append(Typography.dollar);
        int r12 = 0;
    L3:
        int r13 = this.f8649v;
        if (r12 >= r13) goto L31;
        Object[] r14 = this.f8648u;
        if ((r14[r12] instanceof com.google.gson.f) == false) goto L21;
        r12 = r12 + 1;
        if (r12 >= r13) goto L29;
        if ((r14[r12] instanceof Iterator) == false) goto L29;
        int r15 = this.f8651x[r12];
        if (r10 == false) goto L19;
        if (r15 <= 0) goto L19;
        if (r12 != (r13 - 1)) goto L17;
    L18:
        r15 = r15 - 1;
        goto L19
    L17:
        if (r12 == (r13 - 2)) goto L18;
    L19:
        r11.append('[');
        r11.append(r15);
        r11.append(']');
    L29:
        r12 = r12 + 1;
        goto L3
    L21:
        if ((r14[r12] instanceof com.google.gson.k) == false) goto L29;
        r12 = r12 + 1;
        if (r12 >= r13) goto L29;
        if ((r14[r12] instanceof Iterator) == false) goto L29;
        r11.append('.');
        String[] r16 = this.f8650w;
        if (r16[r12] == null) goto L29;
        r11.append(r16[r12]);
        goto L29
    L31:
        return r11.toString();
    }

    @Override // i6.a
    public boolean C() {
        k0(JsonToken.BOOLEAN);
        boolean r10 = ((com.google.gson.m) o0()).a();
        int r11 = this.f8649v;
        if (r11 <= 0) goto L5;
        int[] r12 = this.f8651x;
        int r13 = r11 - 1;
        r12[r13] = r12[r13] + 1;
    L5:
        return r10;
    }

    @Override // i6.a
    public double D() {
        JsonToken r10 = Q();
        JsonToken r11 = JsonToken.NUMBER;
        if (r10 != r11) goto L5;
    L9:
        double r12 = ((com.google.gson.m) n0()).b();
        if (v() == false) goto L12;
    L18:
        o0();
        int r13 = this.f8649v;
        if (r13 <= 0) goto L21;
        int[] r14 = this.f8651x;
        int r15 = r13 - 1;
        r14[r15] = r14[r15] + 1;
    L21:
        return r12;
    L12:
        if (Double.isNaN(r12) == true) goto L17;
        if (Double.isInfinite(r12) == false) goto L18;
    L17:
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + r12);
    L5:
        if (r10 == JsonToken.STRING) goto L9;
        throw new IllegalStateException("Expected " + r11 + " but was " + r10 + B());
    }

    @Override // i6.a
    public int F() {
        JsonToken r10 = Q();
        JsonToken r11 = JsonToken.NUMBER;
        if (r10 != r11) goto L5;
    L9:
        int r12 = ((com.google.gson.m) n0()).c();
        o0();
        int r13 = this.f8649v;
        if (r13 <= 0) goto L12;
        int[] r14 = this.f8651x;
        int r15 = r13 - 1;
        r14[r15] = r14[r15] + 1;
    L12:
        return r12;
    L5:
        if (r10 == JsonToken.STRING) goto L9;
        throw new IllegalStateException("Expected " + r11 + " but was " + r10 + B());
    }

    @Override // i6.a
    public long G() {
        JsonToken r10 = Q();
        JsonToken r11 = JsonToken.NUMBER;
        if (r10 != r11) goto L5;
    L9:
        long r12 = ((com.google.gson.m) n0()).g();
        o0();
        int r13 = this.f8649v;
        if (r13 <= 0) goto L12;
        int[] r14 = this.f8651x;
        int r15 = r13 - 1;
        r14[r15] = r14[r15] + 1;
    L12:
        return r12;
    L5:
        if (r10 == JsonToken.STRING) goto L9;
        throw new IllegalStateException("Expected " + r11 + " but was " + r10 + B());
    }

    @Override // i6.a
    public String I() {
        return m0(false);
    }

    @Override // i6.a
    public void K() {
        k0(JsonToken.NULL);
        o0();
        int r10 = this.f8649v;
        if (r10 <= 0) goto L6;
        int[] r11 = this.f8651x;
        int r12 = r10 - 1;
        r11[r12] = r11[r12] + 1;
        return;
    }

    @Override // i6.a
    public String N() {
        JsonToken r10 = Q();
        JsonToken r11 = JsonToken.STRING;
        if (r10 != r11) goto L5;
    L9:
        String r12 = ((com.google.gson.m) o0()).h();
        int r13 = this.f8649v;
        if (r13 <= 0) goto L12;
        int[] r14 = this.f8651x;
        int r15 = r13 - 1;
        r14[r15] = r14[r15] + 1;
    L12:
        return r12;
    L5:
        if (r10 == JsonToken.NUMBER) goto L9;
        throw new IllegalStateException("Expected " + r11 + " but was " + r10 + B());
    }

    @Override // i6.a
    public JsonToken Q() {
        if (this.f8649v == 0) goto L5;
        Object r10 = n0();
        if ((r10 instanceof Iterator) == false) goto L20;
        boolean r11 = this.f8648u[this.f8649v - 2] instanceof com.google.gson.k;
        Iterator r12 = (Iterator) r10;
        if (r12.hasNext() == false) goto L15;
        if (r11 == true) goto L12;
        q0(r12.next());
        return Q();
    L12:
        return JsonToken.NAME;
    L15:
        if (r11 == false) goto L18;
        return JsonToken.END_OBJECT;
    L18:
        return JsonToken.END_ARRAY;
    L20:
        if ((r10 instanceof com.google.gson.k) == false) goto L24;
        return JsonToken.BEGIN_OBJECT;
    L24:
        if ((r10 instanceof com.google.gson.f) == false) goto L28;
        return JsonToken.BEGIN_ARRAY;
    L28:
        if ((r10 instanceof com.google.gson.m) == false) goto L44;
        com.google.gson.m r13 = (com.google.gson.m) r10;
        if (r13.q() == false) goto L34;
        return JsonToken.STRING;
    L34:
        if (r13.n() == false) goto L38;
        return JsonToken.BOOLEAN;
    L38:
        if (r13.p() == false) goto L42;
        return JsonToken.NUMBER;
    L42:
        throw new AssertionError();
    L44:
        if ((r10 instanceof com.google.gson.j) == false) goto L48;
        return JsonToken.NULL;
    L48:
        if (r10 != f8647y) goto L52;
        throw new IllegalStateException("JsonReader is closed");
    L52:
        throw new MalformedJsonException("Custom JsonElement subclass " + r10.getClass().getName() + " is not supported");
    L5:
        return JsonToken.END_DOCUMENT;
    }

    @Override // i6.a
    public void a() {
        k0(JsonToken.BEGIN_ARRAY);
        q0(((com.google.gson.f) n0()).iterator());
        this.f8651x[this.f8649v - 1] = 0;
    }

    @Override // i6.a
    public void c() {
        k0(JsonToken.BEGIN_OBJECT);
        q0(((com.google.gson.k) n0()).r().iterator());
    }

    @Override // i6.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f8648u = new Object[]{f8647y};
        this.f8649v = 1;
    }

    @Override // i6.a
    public String getPath() {
        return r(false);
    }

    @Override // i6.a
    public void i0() {
        JsonToken r10 = Q();
        int r11 = b.f8652a[r10.ordinal()];
        if (r11 != 1) goto L5;
        m0(true);
        return;
    L5:
        if (r11 != 2) goto L7;
        l();
        return;
    L7:
        if (r11 != 3) goto L9;
        o();
        return;
    L9:
        if (r11 == 4) goto L17;
        o0();
        int r12 = this.f8649v;
        if (r12 <= 0) goto L18;
        int[] r13 = this.f8651x;
        int r14 = r12 - 1;
        r13[r14] = r13[r14] + 1;
        return;
    L18:
        return;
    }

    @Override // i6.a
    public void l() {
        k0(JsonToken.END_ARRAY);
        o0();
        o0();
        int r10 = this.f8649v;
        if (r10 <= 0) goto L6;
        int[] r11 = this.f8651x;
        int r12 = r10 - 1;
        r11[r12] = r11[r12] + 1;
        return;
    }

    com.google.gson.i l0() {
        JsonToken r10 = Q();
        if (r10 == JsonToken.NAME) goto L13;
        if (r10 == JsonToken.END_ARRAY) goto L13;
        if (r10 == JsonToken.END_OBJECT) goto L13;
        if (r10 == JsonToken.END_DOCUMENT) goto L13;
        com.google.gson.i r11 = (com.google.gson.i) n0();
        i0();
        return r11;
    L13:
        throw new IllegalStateException("Unexpected " + r10 + " when reading a JsonElement.");
    }

    @Override // i6.a
    public void o() {
        k0(JsonToken.END_OBJECT);
        this.f8650w[this.f8649v - 1] = null;
        o0();
        o0();
        int r10 = this.f8649v;
        if (r10 <= 0) goto L6;
        int[] r11 = this.f8651x;
        int r12 = r10 - 1;
        r11[r12] = r11[r12] + 1;
        return;
    }

    public void p0() {
        k0(JsonToken.NAME);
        Map.Entry r10 = (Map.Entry) ((Iterator) n0()).next();
        q0(r10.getValue());
        q0(new com.google.gson.m((String) r10.getKey()));
    }

    @Override // i6.a
    public String s() {
        return r(true);
    }

    @Override // i6.a
    public String toString() {
        return f.class.getSimpleName() + B();
    }

    @Override // i6.a
    public boolean u() {
        JsonToken r10 = Q();
        if (r10 != JsonToken.END_OBJECT) goto L5;
    L9:
        return false;
    L5:
        if (r10 == JsonToken.END_ARRAY) goto L9;
        if (r10 == JsonToken.END_DOCUMENT) goto L9;
        return true;
    }
}

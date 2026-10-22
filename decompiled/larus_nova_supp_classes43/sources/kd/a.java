package kd;

import com.bytedance.android.common.sonic.SonicJsonParser;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends JsonReader {
    public static final C0176a o = null;
    public final JsonToken[] a;
    public byte[] b;
    public long[] c;
    public double[] d;
    public String[][] e;
    public int[] f;
    public int g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public final int l;
    public String m;
    public final AtomicBoolean n;

    /* JADX INFO: renamed from: kd.a$a, reason: collision with other inner class name */
    public class C0176a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            throw new AssertionError();
        }

        public C0176a() {
        }

        @Override // java.io.Reader
        public final int read(char[] r1, int r10, int r11) throws IOException {
            throw new AssertionError();
        }
    }

    public class b extends JsonReaderInternalAccess {
        public final JsonReaderInternalAccess a;

        public b() {
            this.a = JsonReaderInternalAccess.INSTANCE;
        }

        public final void promoteNameToValue(JsonReader r10) throws IOException {
            if ((r10 instanceof a) == false) goto L10;
            a r11 = (a) r10;
            r11.b();
            r11.b[r11.g] = 5;     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw new IllegalStateException("json: [" + r11.m + "]", th);
        L10:
            this.a.promoteNameToValue(r10);
        }
    }

    public final void close() throws IOException {
    }

    public final String getPath() {
        return "";
    }

    static {
        o = new C0176a();
        JsonReaderInternalAccess.INSTANCE = new b();
    }

    public final void b() throws IOException {
        boolean r1 = false;
        if (this.n.compareAndSet(false, true) == false) goto L21;
        int r0 = this.l;
        if (r0 == 1) goto L22;
        if (r0 == 2) goto L20;
        return;
    L20:
        throw null;
    L22:
        Object[] r10 = SonicJsonParser.processTokens(this.m, false);     // Catch: Throwable -> L14
        byte[] r11 = (byte[]) r10[0];     // Catch: Throwable -> L14
        this.b = r11;     // Catch: Throwable -> L14
        this.c = (long[]) r10[1];     // Catch: Throwable -> L14
        this.d = (double[]) r10[2];     // Catch: Throwable -> L14
        this.e = (String[][]) r10[3];     // Catch: Throwable -> L14
        this.f = (int[]) r10[4];     // Catch: Throwable -> L14
        this.g = 0;     // Catch: Throwable -> L14
        this.h = 0;     // Catch: Throwable -> L14
        this.i = 0;     // Catch: Throwable -> L14
        this.j = 0;     // Catch: Throwable -> L14
        if (r11.length == 1) goto L10;
    L12:
        this.k = r1;     // Catch: Throwable -> L14
        return;
    L10:
        if (r11[0] != 11) goto L12;
        r1 = true;
    L14:
        th = move-exception;
        throw new IllegalStateException("json: [" + this.m + "]", th);
    }

    public final String nextString() throws IOException {
        b();
        byte[] r1 = this.b;     // Catch: Throwable -> L20
        int r10 = this.g;     // Catch: Throwable -> L20
        this.g = r10 + 1;     // Catch: Throwable -> L20
        byte r11 = r1[r10];     // Catch: Throwable -> L20
        if (r11 != 4) goto L6;
    L18:
        int[] r0 = this.f;     // Catch: Throwable -> L20
        int r12 = this.j;     // Catch: Throwable -> L20
        this.j = r12 + 1;     // Catch: Throwable -> L20
        return c(r0[r12]);
    L6:
        if (r11 == 5) goto L18;
        if (r11 != 6) goto L13;
        long[] r13 = this.c;     // Catch: Throwable -> L20
        int r14 = this.h;     // Catch: Throwable -> L20
        this.h = r14 + 1;     // Catch: Throwable -> L20
        return Long.toString(r13[r14]);
    L13:
        if (r11 != 7) goto L17;
        double[] r15 = this.d;     // Catch: Throwable -> L20
        int r16 = this.i;     // Catch: Throwable -> L20
        this.i = r16 + 1;     // Catch: Throwable -> L20
        return Double.toString(r15[r16]);
    L17:
        throw new IllegalStateException("Expected a string but was " + this.a[this.b[this.g]]);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw new IllegalStateException("json: [" + this.m + "]", th);
    }

    public final void beginArray() throws IOException {
        b();
        a(JsonToken.BEGIN_ARRAY);
        this.g++;
    }

    public final void beginObject() throws IOException {
        b();
        a(JsonToken.BEGIN_OBJECT);
        this.g++;
    }

    public final void endArray() throws IOException {
        b();
        a(JsonToken.END_ARRAY);
        this.g++;
    }

    public final void endObject() throws IOException {
        b();
        a(JsonToken.END_OBJECT);
        this.g++;
    }

    public final boolean hasNext() throws IOException {
        b();
        byte r0 = this.b[this.g];     // Catch: Throwable -> L11
        if (r0 != 1) goto L7;
    L9:
        return false;
    L7:
        if (r0 == 3) goto L9;
        return true;
    L11:
        th = move-exception;
        throw new IllegalStateException("json: [" + this.m + "]", th);
    }

    public final boolean nextBoolean() throws IOException {
        b();
        a(JsonToken.BOOLEAN);
        byte[] r0 = this.b;     // Catch: Throwable -> L31
        int r1 = this.g;     // Catch: Throwable -> L31
        this.g = r1 + 1;     // Catch: Throwable -> L31
        byte r10 = r0[r1];     // Catch: Throwable -> L31
        if (r10 != 8) goto L7;
        return true;
    L7:
        if (r10 != 9) goto L10;
        return false;
    L10:
        if (r10 != 6) goto L17;
        long[] r11 = this.c;     // Catch: Throwable -> L31
        int r12 = this.h;     // Catch: Throwable -> L31
        this.h = r12 + 1;     // Catch: Throwable -> L31
        if (r11[r12] != 0) goto L35;
        return false;
    L35:
        return true;
    L17:
        if (r10 != 4) goto L19;
    L29:
        int[] r13 = this.f;     // Catch: Throwable -> L31
        int r14 = this.j;     // Catch: Throwable -> L31
        this.j = r14 + 1;     // Catch: Throwable -> L31
        return c(r13[r14]).toLowerCase().equals("true");
    L19:
        if (r10 == 5) goto L29;
        if (r10 != 7) goto L28;
        double[] r15 = this.d;     // Catch: Throwable -> L31
        int r16 = this.i;     // Catch: Throwable -> L31
        this.i = r16 + 1;     // Catch: Throwable -> L31
        if (r15[r16] != 0.0d) goto L36;
        return false;
    L36:
        return true;
    L28:
        return false;
    L31:
        th = move-exception;
        throw new IllegalStateException("json: [" + this.m + "]", th);
    }

    public final double nextDouble() throws IOException {
        b();
        byte[] r0 = this.b;
        int r1 = this.g;
        this.g = r1 + 1;
        byte r10 = r0[r1];
        if (r10 != 7) goto L7;
        double[] r11 = this.d;
        int r12 = this.i;
        this.i = r12 + 1;
        return r11[r12];
    L7:
        if (r10 != 6) goto L11;
        long[] r13 = this.c;
        int r14 = this.h;
        this.h = r14 + 1;
        return r13[r14];
    L11:
        if (r10 != 5) goto L13;
    L21:
        int[] r15 = this.f;
        int r16 = this.j;
        this.j = r16 + 1;
        return CastDoubleProtector.parseDouble(c(r15[r16]));
    L13:
        if (r10 == 4) goto L21;
        if (r10 != 8) goto L20;
        throw new IllegalStateException("Expected a double but was true");
    L20:
        throw new IllegalStateException("Expected a double but was false");
    }

    public final int nextInt() throws IOException {
        b();
        byte[] r0 = this.b;
        int r1 = this.g;
        this.g = r1 + 1;
        byte r10 = r0[r1];
        if (r10 != 6) goto L10;
        long[] r11 = this.c;
        int r12 = this.h;
        this.h = r12 + 1;
        long r13 = r11[r12];
        int r14 = (int) r13;
        if (r14 != r13) goto L8;
        return r14;
    L8:
        throw new NumberFormatException("Expected an int but was " + r13);
    L10:
        if (r10 != 5) goto L12;
    L27:
        int[] r15 = this.f;
        int r16 = this.j;
        this.j = r16 + 1;
        String r17 = c(r15[r16]);
        return CastIntegerProtector.parseInt(r17);
    L31:
        throw new NumberFormatException("Expected an int but was " + r17);
    L12:
        if (r10 == 4) goto L27;
        if (r10 != 7) goto L22;
        double[] r18 = this.d;
        int r19 = this.i;
        this.i = r19 + 1;
        double r20 = r18[r19];
        int r21 = (int) r20;
        if (r21 != r20) goto L20;
        return r21;
    L20:
        throw new NumberFormatException("Expected an int but was " + r20);
    L22:
        if (r10 != 8) goto L26;
        throw new IllegalStateException("Expected an int but was true");
    L26:
        throw new IllegalStateException("Expected an int but was false");
    }

    public final long nextLong() throws IOException {
        b();
        byte[] r0 = this.b;
        int r1 = this.g;
        this.g = r1 + 1;
        byte r10 = r0[r1];
        if (r10 != 6) goto L7;
        long[] r11 = this.c;
        int r12 = this.h;
        this.h = r12 + 1;
        return r11[r12];
    L7:
        if (r10 != 5) goto L9;
    L24:
        int[] r13 = this.f;
        int r14 = this.j;
        this.j = r14 + 1;
        String r15 = c(r13[r14]);
        return CastLongProtector.parseLong(r15);
    L28:
        throw new NumberFormatException("Expected a long but was " + r15);
    L9:
        if (r10 == 4) goto L24;
        if (r10 != 7) goto L19;
        double[] r16 = this.d;
        int r17 = this.i;
        this.i = r17 + 1;
        double r18 = r16[r17];
        long r19 = (long) r18;
        if (r19 != r18) goto L17;
        return r19;
    L17:
        throw new NumberFormatException("Expected a long but was " + r18);
    L19:
        if (r10 != 8) goto L23;
        throw new IllegalStateException("Expected an long but was true");
    L23:
        throw new IllegalStateException("Expected an long but was false");
    }

    public final String nextName() throws IOException {
        b();
        return nextString();
    }

    public final void nextNull() throws IOException {
        b();
        this.g++;
    }

    public final JsonToken peek() throws IOException {
        b();
    L9:
        th = move-exception;
        throw new IllegalStateException("json: [" + this.m + "]", th);
    L4:
        if (this.k == true) goto L8;
        return this.a[this.b[this.g]];
    L8:
        throw new EOFException();     // Catch: Throwable -> L9
    }

    public final void skipValue() throws IOException {
        b();
        int r0 = 0;
    L33:
        byte[] r1 = this.b;     // Catch: Throwable -> L30
        int r10 = this.g;     // Catch: Throwable -> L30
        this.g = r10 + 1;     // Catch: Throwable -> L30
        byte r11 = r1[r10];     // Catch: Throwable -> L30
        if (r11 != 0) goto L6;
    L27:
        r0 = r0 + 1;
    L28:
        if (r0 > 0) goto L33;
        return;
    L6:
        if (r11 == 2) goto L27;
        if (r11 != 1) goto L11;
    L26:
        r0 = r0 - 1;
        goto L28
    L11:
        if (r11 == 3) goto L26;
        if (r11 != 4) goto L16;
    L24:
        this.j++;     // Catch: Throwable -> L30
        goto L28
    L16:
        if (r11 == 5) goto L24;
        if (r11 != 6) goto L22;
        this.h++;     // Catch: Throwable -> L30
        goto L28
    L22:
        if (r11 != 7) goto L28;
        this.i++;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw new IllegalStateException("json: [" + this.m + "]", th);
    }

    public a(String r10) {
        super(o);
        JsonToken r1 = JsonToken.NUMBER;
        JsonToken r11 = JsonToken.BOOLEAN;
        this.a = new JsonToken[]{JsonToken.BEGIN_ARRAY, JsonToken.END_ARRAY, JsonToken.BEGIN_OBJECT, JsonToken.END_OBJECT, JsonToken.NAME, JsonToken.STRING, r1, r1, r11, r11, JsonToken.NULL, JsonToken.END_DOCUMENT};
        this.m = null;
        this.n = new AtomicBoolean(false);
        this.m = r10;
        this.l = 1;
    }

    public final void a(JsonToken r10) {
        if (r10 != this.a[this.b[this.g]]) goto L6;
        return;
    L6:
        throw new IllegalStateException("type can not match " + r10);
    }

    public final String c(int r10) {
        return this.e[32 - Integer.numberOfLeadingZeros(r10)][r10 ^ Integer.highestOneBit(r10)];
    L4:
        th = move-exception;
        throw new IllegalStateException("json: [" + this.m + "]", th);
    }
}

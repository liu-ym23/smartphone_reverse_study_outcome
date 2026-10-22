package e6;

import com.google.gson.ToNumberPolicy;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends q<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final r f8668c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.d f8669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p f8670b;

    class a implements r {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ p f8671c;

        a(p r10) {
            this.f8671c = r10;
        }

        @Override // com.google.gson.r
        public <T> q<T> b(com.google.gson.d r10, TypeToken<T> r11) {
            a r12 = null;
            if (r11.getRawType() == Object.class) goto L5;
            return null;
        L5:
            return new j(r10, this.f8671c, r12);
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8672a = null;

        static {
            int[] r10 = new int[JsonToken.values().length];
            f8672a = r10;
            r10[JsonToken.BEGIN_ARRAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f8672a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f8672a[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f8672a[JsonToken.NUMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f8672a[JsonToken.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f8672a[JsonToken.NULL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        f8668c = f(ToNumberPolicy.DOUBLE);
    }

    private j(com.google.gson.d r10, p r11) {
        this.f8669a = r10;
        this.f8670b = r11;
    }

    /* synthetic */ j(com.google.gson.d r10, p r11, a r12) {
        this(r10, r11);
    }

    public static r e(p r10) {
        if (r10 != ToNumberPolicy.DOUBLE) goto L7;
        return f8668c;
    L7:
        return f(r10);
    }

    private static r f(p r10) {
        return new a(r10);
    }

    private Object g(i6.a r10, JsonToken r11) {
        int r12 = b.f8672a[r11.ordinal()];
        if (r12 == 3) goto L19;
        if (r12 == 4) goto L17;
        if (r12 == 5) goto L15;
        if (r12 != 6) goto L13;
        r10.K();
        return null;
    L13:
        throw new IllegalStateException("Unexpected token: " + r11);
    L15:
        return Boolean.valueOf(r10.C());
    L17:
        return this.f8670b.readNumber(r10);
    L19:
        return r10.N();
    }

    private Object h(i6.a r10, JsonToken r11) {
        int r12 = b.f8672a[r11.ordinal()];
        if (r12 != 1) goto L5;
        r10.a();
        return new ArrayList();
    L5:
        if (r12 == 2) goto L8;
        return null;
    L8:
        r10.c();
        return new LinkedTreeMap();
    }

    @Override // com.google.gson.q
    public Object b(i6.a r10) {
        JsonToken r11 = r10.Q();
        Object r12 = h(r10, r11);
        if (r12 == null) goto L5;
        ArrayDeque r13 = new ArrayDeque();
    L8:
        if (r10.u() == true) goto L9;
        if ((r12 instanceof List) == false) goto L27;
        r10.l();
    L29:
        if (r13.isEmpty() == true) goto L30;
        r12 = r13.removeLast();
        goto L8
    L30:
        return r12;
    L27:
        r10.o();
        goto L29
    L9:
        String r14 = null;
        if ((r12 instanceof Map) == false) goto L12;
        r14 = r10.I();
    L12:
        JsonToken r15 = r10.Q();
        Object r16 = h(r10, r15);
        if (r16 == null) goto L15;
        boolean r17 = true;
    L16:
        if (r16 != null) goto L19;
        r16 = g(r10, r15);
    L19:
        if ((r12 instanceof List) == false) goto L21;
        ((List) r12).add(r16);
    L22:
        if (r17 == false) goto L8;
        r13.addLast(r12);
        r12 = r16;
        goto L8
    L21:
        ((Map) r12).put(r14, r16);
        goto L22
    L15:
        r17 = false;
        goto L16
    L5:
        return g(r10, r11);
    }

    @Override // com.google.gson.q
    public void d(com.google.gson.stream.a r10, Object r11) {
        if (r11 != null) goto L5;
        r10.B();
        return;
    L5:
        q r12 = this.f8669a.n(r11.getClass());
        if ((r12 instanceof j) == false) goto L9;
        r10.i();
        r10.o();
        return;
    L9:
        r12.d(r10, r11);
    }
}

package e6;

import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends q<Number> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final r f8664b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f8665a;

    class a implements r {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i f8666c;

        a(i r10) {
            this.f8666c = r10;
        }

        @Override // com.google.gson.r
        public <T> q<T> b(com.google.gson.d r10, TypeToken<T> r11) {
            if (r11.getRawType() == Number.class) goto L7;
            return null;
        L7:
            return this.f8666c;
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8667a = null;

        static {
            int[] r10 = new int[JsonToken.values().length];
            f8667a = r10;
            r10[JsonToken.NULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f8667a[JsonToken.NUMBER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f8667a[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f8664b = f(ToNumberPolicy.LAZILY_PARSED_NUMBER);
    }

    private i(p r10) {
        this.f8665a = r10;
    }

    public static r e(p r10) {
        if (r10 != ToNumberPolicy.LAZILY_PARSED_NUMBER) goto L7;
        return f8664b;
    L7:
        return f(r10);
    }

    private static r f(p r10) {
        return new a(new i(r10));
    }

    @Override // com.google.gson.q
    public /* bridge */ /* synthetic */ Number b(i6.a r10) {
        return g(r10);
    }

    @Override // com.google.gson.q
    public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Number r11) {
        h(r10, r11);
    }

    public Number g(i6.a r10) {
        JsonToken r11 = r10.Q();
        int r12 = b.f8667a[r11.ordinal()];
        if (r12 != 1) goto L5;
        r10.K();
        return null;
    L5:
        if (r12 == 2) goto L12;
        if (r12 == 3) goto L12;
        throw new JsonSyntaxException("Expecting number, got: " + r11 + "; at path " + r10.getPath());
    L12:
        return this.f8665a.readNumber(r10);
    }

    public void h(com.google.gson.stream.a r10, Number r11) {
        r10.X(r11);
    }
}

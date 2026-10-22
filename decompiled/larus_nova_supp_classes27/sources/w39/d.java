package w39;

import com.google.gson.Gson;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d implements w39.a {
    public static final Lazy<d> b = null;
    public final Lazy a;

    public static final class a {
        public static d a() {
            return (d) d.b.getValue();
        }
    }

    static {
        b = LazyKt.lazy(new b());
    }

    public d() {
        this.a = LazyKt.lazy(new c());
    }

    @Override // w39.a
    public final <T> T a(byte[] r4, Type r5) {
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r5, "typeOfT");
        return (T) ((Gson) this.a.getValue()).fromJson(new InputStreamReader(new ByteArrayInputStream(r4)), r5);
    L5:
        e = move-exception;
        g49.d.c("DoraRequestGsonConvertor", "Failed to convert data to Type " + r5, e);
        return null;
    }
}

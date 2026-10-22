package h4a;

import com.bytedance.retrofit2.Retrofit;
import com.ivy.ivykit.api.bridge.inject.IvyIRetrofit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f implements hx7.d {

    public final class a implements IvyIRetrofit {
        public final Retrofit a;

        public a(Retrofit r2) {
            Intrinsics.checkNotNullParameter(r2, "retrofit");
            this.a = r2;
        }

        public final <T> T create(Class<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "service");
            return (T) this.a.create(r2);
        }
    }

    public f() {
    }

    public final void getAPIParams() {
    }

    public final a createRetrofit(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "baseUrl");
        return new a(k4a.c.a(r2, r3));
    }
}

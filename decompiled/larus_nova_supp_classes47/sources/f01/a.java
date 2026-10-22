package f01;

import com.bytedance.android.scope.o;
import com.bytedance.revenue.platform.api.core.JsonOrBytesJvm;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import e01.e;
import e01.f;
import e01.h;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements o, h {
    public final d01.a a;

    /* JADX INFO: renamed from: f01.a$a, reason: collision with other inner class name */
    public static final class C0235a<T, R> implements Function {
        public static final C0235a a = null;

        static {
            a = new C0235a();
        }

        public C0235a() {
        }

        public final Object apply(Object r5) {
            JsonElement r6 = (JsonElement) r5;
            Intrinsics.checkNotNullParameter(r6, "jsonElement");
            Class r0 = f.class.getAnnotation(JsonAdapter.class).value();
            ConcurrentHashMap r1 = vh7.b.a;
            Object r2 = r1.get(r0);
            if (r2 != null) goto L12;
            r2 = r0.getConstructor(new Class[0]);
            if (r2 == null) goto L11;
            Object r3 = r1.putIfAbsent(r0, r2);
            if (r3 == null) goto L12;
            r2 = r3;
            goto L12
        L11:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
        L12:
            Object r4 = ((SerializableObjectJsonAdapterBase) ((Constructor) r2).newInstance(new Object[0])).createInstance();
            if (r4 == null) goto L17;
            f r7 = (f) r4;
            r7.Y4(new JsonOrBytesJvm(r6));
            return r7;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.platform.stream.api.aio.AioObserveSeiFieldResponse");
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public a(d01.a r2) {
        Intrinsics.checkNotNullParameter(r2, "seiService");
        this.a = r2;
    }

    @Override // e01.h
    public final Observable<f> observeSeiField(e r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        String r3 = r2.getKey();
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        Observable<JsonObject> r4 = this.a.ri();
    L13:
        return r4.map(C0235a.a);
    L11:
        r4 = this.a.o6(r3);
        goto L13
    L5:
        if (r3.length() == 0) goto L8;
        r0 = false;
        goto L9
    }
}

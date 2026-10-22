package jz0;

import com.bytedance.keva.Keva;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements iz0.a {
    public final Keva a;

    public static final class a<V> implements Callable {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public final Map<String, ?> call() {
            return this.a.a.getAll();
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    @Override // iz0.a
    public final Completable clear() {
        this.a.clear();
        return Completable.complete();
    }

    @Override // iz0.a
    public final Single<Map<String, ?>> getAll() {
        return Single.fromCallable(new a(this));
    }

    @Override // iz0.a
    public final Single getString() {
        Intrinsics.checkNotNullParameter("__version__", "key");
        Intrinsics.checkNotNullParameter("", "defValue");
        return Single.fromCallable(new c(this));
    }

    public b(Keva r2) {
        Intrinsics.checkNotNullParameter(r2, "kevaImpl");
        this.a = r2;
    }

    @Override // iz0.a
    public final Completable c(Map<String, ?> r6) {
        Intrinsics.checkNotNullParameter(r6, "value");
        Intrinsics.checkNotNullParameter(r6, "value");
        Iterator<Map.Entry<String, ?>> r7 = r6.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L55;
        Map.Entry<String, ?> r0 = r7.next();
        Object r1 = r0.getValue();
        if ((r1 instanceof Boolean) == true) goto L7;
        if ((r1 instanceof String) == true) goto L14;
        if ((r1 instanceof byte[]) == true) goto L21;
        if ((r1 instanceof Integer) == true) goto L28;
        if ((r1 instanceof Long) == true) goto L35;
        if ((r1 instanceof Float) == true) goto L42;
        if ((r1 instanceof Double) == false) goto L4;
        Keva r2 = this.a;
        String r3 = r0.getKey();
        Object r4 = r0.getValue();
        if (r4 == null) goto L53;
        r2.storeDouble(r3, ((Double) r4).doubleValue());
        goto L4
    L53:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L42:
        Keva r5 = this.a;
        String r8 = r0.getKey();
        Object r9 = r0.getValue();
        if (r9 == null) goto L46;
        r5.storeFloat(r8, ((Float) r9).floatValue());
        goto L4
    L46:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L35:
        Keva r10 = this.a;
        String r12 = r0.getKey();
        Object r13 = r0.getValue();
        if (r13 == null) goto L39;
        r10.storeLong(r12, ((Long) r13).longValue());
        goto L4
    L39:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L28:
        Keva r14 = this.a;
        String r15 = r0.getKey();
        Object r16 = r0.getValue();
        if (r16 == null) goto L32;
        r14.storeInt(r15, ((Integer) r16).intValue());
        goto L4
    L32:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L21:
        Keva r17 = this.a;
        String r18 = r0.getKey();
        Object r19 = r0.getValue();
        if (r19 == null) goto L25;
        r17.storeBytes(r18, (byte[]) r19);
        goto L4
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
    L14:
        Keva r20 = this.a;
        String r22 = r0.getKey();
        Object r23 = r0.getValue();
        if (r23 == null) goto L18;
        r20.storeString(r22, (String) r23);
        goto L4
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L7:
        Keva r24 = this.a;
        String r25 = r0.getKey();
        Object r26 = r0.getValue();
        if (r26 == null) goto L11;
        r24.storeBoolean(r25, ((Boolean) r26).booleanValue());
        goto L4
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L55:
        return Completable.complete();
    }

    @Override // iz0.a
    public final Completable f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r3, "key");
        this.a.storeBoolean(r3, true);
        return Completable.complete();
    }

    @Override // iz0.a
    public final Completable g(String r3) {
        Intrinsics.checkNotNullParameter("__version__", "key");
        a("__version__", r3);
        return Completable.complete();
    }

    @Override // iz0.a
    public final boolean h(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.a.getBoolean(r3, false);
    }

    @Override // iz0.a
    public final void i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.a.erase(r2);
    }

    @Override // iz0.a
    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.a.storeString(r2, r3);
    }

    @Override // iz0.a
    public final void b(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.a.storeLong(r2, r3);
    }

    @Override // iz0.a
    public final String d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "defValue");
        return this.a.getString(r2, r3);
    }

    @Override // iz0.a
    public final long e(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.a.getLong(r2, r3);
    }
}

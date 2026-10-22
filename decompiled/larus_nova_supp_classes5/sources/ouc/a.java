package ouc;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import juc.y;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import kotlinx.serialization.json.internal.WriteMode;
import kotlinx.serialization.json.internal.a0;
import kotlinx.serialization.json.internal.j0;
import kotlinx.serialization.json.internal.m0;
import kotlinx.serialization.json.internal.n0;
import kotlinx.serialization.json.internal.r0;
import kotlinx.serialization.modules.d;
import kotlinx.serialization.modules.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class a implements y {
    public static final C0027a d = null;
    public final f a;
    public final d b;
    public final kotlinx.serialization.json.internal.p c;

    /* JADX INFO: renamed from: ouc.a$a, reason: collision with other inner class name */
    public static final class C0027a extends a {
        public C0027a() {
            super(new f(false, false, false, false, false, true, "    ", false, false, EffectConfiguration.KEY_TYPE, false, true, false, false, false, ClassDiscriminatorMode.POLYMORPHIC), i.a);
        }
    }

    static {
        d = new C0027a();
    }

    @Override // juc.m
    public final d getSerializersModule() {
        return this.b;
    }

    public final i e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "string");
        return (i) c(r.a, r2);
    }

    public a(f r1, d r2) {
        this.a = r1;
        this.b = r2;
        this.c = new kotlinx.serialization.json.internal.p();
    }

    @Override // juc.y
    public final <T> String a(juc.n<? super T> r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "serializer");
        kotlinx.serialization.json.internal.z r0 = new kotlinx.serialization.json.internal.z();
        kotlinx.serialization.json.internal.y.a(this, r0, r2, r3);     // Catch: Throwable -> L6
        String r4 = r0.toString();     // Catch: Throwable -> L6
        r0.e();
        return r4;
    L6:
        th = move-exception;
        r0.e();
        throw th;
    }

    public final <T> T b(juc.c<? extends T> r4, i r5) {
        Intrinsics.checkNotNullParameter(r4, "deserializer");
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(this, "json");
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(r4, "deserializer");
        String r1 = null;
        if ((r5 instanceof d0) == false) goto L6;
        muc.e r0 = new a0(this, (d0) r5, r1, 12);
    L17:
        return (T) r0.decodeSerializableValue(r4);
    L6:
        if ((r5 instanceof b) == false) goto L9;
        r0 = new kotlinx.serialization.json.internal.c0(this, (b) r5);
        goto L17
    L9:
        if ((r5 instanceof x) == false) goto L11;
    L15:
        r0 = new kotlinx.serialization.json.internal.w(this, (g0) r5, null);
        goto L17
    L11:
        if (Intrinsics.areEqual(r5, a0.INSTANCE) == true) goto L15;
        throw new NoWhenBranchMatchedException();
    }

    public final <T> T c(juc.c<? extends T> r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "deserializer");
        Intrinsics.checkNotNullParameter(r9, "string");
        Intrinsics.checkNotNullParameter(this, "json");
        Intrinsics.checkNotNullParameter(r9, "source");
        if (this.a.o == true) goto L5;
        m0 r0 = new m0(r9);
    L6:
        T r10 = (T) new j0(this, WriteMode.OBJ, r0, r8.getDescriptor(), null).decodeSerializableValue(r8);
        if (r0.e() != 10) goto L9;
        return r10;
    L9:
        kotlinx.serialization.json.internal.a.m(r0, "Expected EOF after parsing, but had " + r0.e.charAt(r0.a - 1) + " instead", 0, null, 6);
        throw null;
    L5:
        r0 = new n0(r9);
        goto L6
    }

    public final <T> i d(juc.n<? super T> r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "serializer");
        return r0.a(this, r3, r2);
    }
}

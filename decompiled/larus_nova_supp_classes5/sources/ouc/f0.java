package ouc;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.annotation.Annotation;
import java.util.List;
import juc.d;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.ExperimentalSerializationApi;
import nuc.v2;
import nuc.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f0 implements d<d0> {
    public static final f0 a = null;
    public static final a b = null;

    public static final class a implements luc.f {
        public static final a b = null;
        public static final String c = null;
        public final /* synthetic */ z0 a;

        @Override // luc.f
        public final boolean a() {
            this.a.getClass();
            return false;
        }

        @Override // luc.f
        @ExperimentalSerializationApi
        public final List<Annotation> e(int r2) {
            return this.a.e(r2);
        }

        @Override // luc.f
        @ExperimentalSerializationApi
        public final int g(String r2) {
            Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
            return this.a.g(r2);
        }

        @Override // luc.f
        @ExperimentalSerializationApi
        public final luc.f h(int r2) {
            return this.a.h(r2);
        }

        @Override // luc.f
        @ExperimentalSerializationApi
        public final boolean i(int r2) {
            this.a.i(r2);
            return false;
        }

        @Override // luc.f
        public final boolean isInline() {
            this.a.getClass();
            return false;
        }

        static {
            b = new a();
            c = "kotlinx.serialization.json.JsonObject";
        }

        @Override // luc.f
        public final int d() {
            return this.a.d;
        }

        @Override // luc.f
        public final List<Annotation> getAnnotations() {
            this.a.getClass();
            return CollectionsKt.emptyList();
        }

        @Override // luc.f
        public final luc.o getKind() {
            this.a.getClass();
            return luc.p.c.a;
        }

        public a() {
            kuc.a.f(StringCompanionObject.INSTANCE);
            this.a = kuc.a.c(v2.a, r.a).c;
        }

        @Override // luc.f
        public final String f() {
            return c;
        }

        @Override // luc.f
        @ExperimentalSerializationApi
        public final String b(int r2) {
            this.a.getClass();
            return String.valueOf(r2);
        }
    }

    public f0() {
    }

    static {
        a = new f0();
        b = a.b;
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r4) {
        Intrinsics.checkNotNullParameter(r4, "decoder");
        t.a(r4);
        kuc.a.f(StringCompanionObject.INSTANCE);
        return new d0(kuc.a.c(v2.a, r.a).deserialize(r4));
    }

    @Override // juc.n
    public final void serialize(muc.f r3, Object r4) {
        d0 r5 = (d0) r4;
        Intrinsics.checkNotNullParameter(r3, "encoder");
        Intrinsics.checkNotNullParameter(r5, "value");
        t.b(r3);
        kuc.a.f(StringCompanionObject.INSTANCE);
        kuc.a.c(v2.a, r.a).serialize(r3, r5);
    }
}

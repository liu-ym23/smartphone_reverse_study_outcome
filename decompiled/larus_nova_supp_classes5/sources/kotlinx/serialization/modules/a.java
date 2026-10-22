package kotlinx.serialization.modules;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: kotlinx.serialization.modules.a$a, reason: collision with other inner class name */
    public static final class C0024a extends a {
        public final juc.d<?> a;

        public final int hashCode() {
            return this.a.hashCode();
        }

        public C0024a(juc.d<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "serializer");
            this.a = r2;
        }

        @Override // kotlinx.serialization.modules.a
        public final juc.d<?> a(List<? extends juc.d<?>> r2) {
            Intrinsics.checkNotNullParameter(r2, "typeArgumentsSerializers");
            return this.a;
        }

        public final boolean equals(Object r2) {
            if ((r2 instanceof C0024a) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(((C0024a) r2).a, this.a) == false) goto L7;
            return true;
        }
    }

    public static final class b extends a {
        public final Function1<List<? extends juc.d<?>>, juc.d<?>> a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super List<? extends juc.d<?>>, ? extends juc.d<?>> r2) {
            Intrinsics.checkNotNullParameter(r2, "provider");
            this.a = r2;
        }

        @Override // kotlinx.serialization.modules.a
        public final juc.d<?> a(List<? extends juc.d<?>> r2) {
            Intrinsics.checkNotNullParameter(r2, "typeArgumentsSerializers");
            return (juc.d) this.a.invoke(r2);
        }
    }

    public a() {
    }

    public abstract juc.d<?> a(List<? extends juc.d<?>> r1);
}

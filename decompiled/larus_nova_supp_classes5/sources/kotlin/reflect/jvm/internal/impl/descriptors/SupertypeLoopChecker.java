package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface SupertypeLoopChecker {

    public static final class EMPTY implements SupertypeLoopChecker {
        public static final EMPTY INSTANCE = null;

        static {
            INSTANCE = new EMPTY();
        }

        private EMPTY() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker
        public Collection<KotlinType> findLoopsInSupertypesAndDisconnect(TypeConstructor r2, Collection<? extends KotlinType> r3, Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> r4, Function1<? super KotlinType, Unit> r5) {
            Intrinsics.checkNotNullParameter(r2, "currentTypeConstructor");
            Intrinsics.checkNotNullParameter(r3, "superTypes");
            Intrinsics.checkNotNullParameter(r4, "neighbors");
            Intrinsics.checkNotNullParameter(r5, "reportLoop");
            return r3;
        }
    }

    Collection<KotlinType> findLoopsInSupertypesAndDisconnect(TypeConstructor r1, Collection<? extends KotlinType> r2, Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> r3, Function1<? super KotlinType, Unit> r4);
}

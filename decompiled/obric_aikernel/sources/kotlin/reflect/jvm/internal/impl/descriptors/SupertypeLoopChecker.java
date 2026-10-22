package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: loaded from: classes3.dex */
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
        public Collection<KotlinType> findLoopsInSupertypesAndDisconnect(TypeConstructor r10, Collection<? extends KotlinType> r11, Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> r12, Function1<? super KotlinType, Unit> r13) {
            Intrinsics.checkNotNullParameter(r10, "currentTypeConstructor");
            Intrinsics.checkNotNullParameter(r11, "superTypes");
            Intrinsics.checkNotNullParameter(r12, "neighbors");
            Intrinsics.checkNotNullParameter(r13, "reportLoop");
            return r11;
        }
    }

    Collection<KotlinType> findLoopsInSupertypesAndDisconnect(TypeConstructor r10, Collection<? extends KotlinType> r11, Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> r12, Function1<? super KotlinType, Unit> r13);
}

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
        public Collection<KotlinType> findLoopsInSupertypesAndDisconnect(TypeConstructor r5, Collection<? extends KotlinType> r10, Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> r11, Function1<? super KotlinType, Unit> r12) {
            Intrinsics.checkNotNullParameter(r5, "currentTypeConstructor");
            Intrinsics.checkNotNullParameter(r10, "superTypes");
            Intrinsics.checkNotNullParameter(r11, "neighbors");
            Intrinsics.checkNotNullParameter(r12, "reportLoop");
            return r10;
        }
    }

    Collection<KotlinType> findLoopsInSupertypesAndDisconnect(TypeConstructor r5, Collection<? extends KotlinType> r10, Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> r11, Function1<? super KotlinType, Unit> r12);
}

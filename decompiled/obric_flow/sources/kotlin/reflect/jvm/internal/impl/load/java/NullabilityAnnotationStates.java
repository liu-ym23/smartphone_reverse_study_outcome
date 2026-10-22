package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.collections.MapsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public interface NullabilityAnnotationStates<T> {
    public static final Companion Companion = null;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final NullabilityAnnotationStates EMPTY = null;

        static {
            $$INSTANCE = new Companion();
            EMPTY = new NullabilityAnnotationStatesImpl(MapsKt.emptyMap());
        }

        private Companion() {
        }

        public final NullabilityAnnotationStates getEMPTY() {
            return EMPTY;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    T get(FqName r5);
}

package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;

/* JADX INFO: loaded from: classes3.dex */
public interface ContractDeserializer {
    public static final Companion Companion = null;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final ContractDeserializer DEFAULT = null;

        static {
            $$INSTANCE = new Companion();
            DEFAULT = new ContractDeserializer$Companion$DEFAULT$1();
        }

        private Companion() {
        }

        public final ContractDeserializer getDEFAULT() {
            return DEFAULT;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    Pair<CallableDescriptor.UserDataKey<?>, Object> deserializeContractFromFunction(ProtoBuf.Function r10, FunctionDescriptor r11, TypeTable r12, TypeDeserializer r13);
}

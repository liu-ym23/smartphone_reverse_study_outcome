package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public interface ExternalOverridabilityCondition {

    public static final enum Contract extends Enum<Contract> {
        private static final /* synthetic */ Contract[] $VALUES = null;
        public static final Contract BOTH = null;
        public static final Contract CONFLICTS_ONLY = null;
        public static final Contract SUCCESS_ONLY = null;

        static {
            Contract r10 = new Contract("CONFLICTS_ONLY", 0);
            CONFLICTS_ONLY = r10;
            Contract r11 = new Contract("SUCCESS_ONLY", 1);
            SUCCESS_ONLY = r11;
            Contract r12 = new Contract("BOTH", 2);
            BOTH = r12;
            $VALUES = new Contract[]{r10, r11, r12};
        }

        private Contract(String r10, int r11) {
            super(r10, r11);
        }

        public static Contract valueOf(String r10) {
            return (Contract) Enum.valueOf(Contract.class, r10);
        }

        public static Contract[] values() {
            return (Contract[]) $VALUES.clone();
        }
    }

    public static final enum Result extends Enum<Result> {
        private static final /* synthetic */ Result[] $VALUES = null;
        public static final Result CONFLICT = null;
        public static final Result INCOMPATIBLE = null;
        public static final Result OVERRIDABLE = null;
        public static final Result UNKNOWN = null;

        static {
            Result r10 = new Result("OVERRIDABLE", 0);
            OVERRIDABLE = r10;
            Result r11 = new Result("CONFLICT", 1);
            CONFLICT = r11;
            Result r12 = new Result("INCOMPATIBLE", 2);
            INCOMPATIBLE = r12;
            Result r13 = new Result("UNKNOWN", 3);
            UNKNOWN = r13;
            $VALUES = new Result[]{r10, r11, r12, r13};
        }

        private Result(String r10, int r11) {
            super(r10, r11);
        }

        public static Result valueOf(String r10) {
            return (Result) Enum.valueOf(Result.class, r10);
        }

        public static Result[] values() {
            return (Result[]) $VALUES.clone();
        }
    }

    Contract getContract();

    Result isOverridable(CallableDescriptor r10, CallableDescriptor r11, ClassDescriptor r12);
}

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
            Contract r5 = new Contract("CONFLICTS_ONLY", 0);
            CONFLICTS_ONLY = r5;
            Contract r10 = new Contract("SUCCESS_ONLY", 1);
            SUCCESS_ONLY = r10;
            Contract r11 = new Contract("BOTH", 2);
            BOTH = r11;
            $VALUES = new Contract[]{r5, r10, r11};
        }

        private Contract(String r5, int r10) {
            super(r5, r10);
        }

        public static Contract valueOf(String r5) {
            return (Contract) Enum.valueOf(Contract.class, r5);
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
            Result r5 = new Result("OVERRIDABLE", 0);
            OVERRIDABLE = r5;
            Result r10 = new Result("CONFLICT", 1);
            CONFLICT = r10;
            Result r11 = new Result("INCOMPATIBLE", 2);
            INCOMPATIBLE = r11;
            Result r12 = new Result("UNKNOWN", 3);
            UNKNOWN = r12;
            $VALUES = new Result[]{r5, r10, r11, r12};
        }

        private Result(String r5, int r10) {
            super(r5, r10);
        }

        public static Result valueOf(String r5) {
            return (Result) Enum.valueOf(Result.class, r5);
        }

        public static Result[] values() {
            return (Result[]) $VALUES.clone();
        }
    }

    Contract getContract();

    Result isOverridable(CallableDescriptor r5, CallableDescriptor r10, ClassDescriptor r11);
}

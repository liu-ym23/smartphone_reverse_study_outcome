package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface ExternalOverridabilityCondition {

    public static final enum Result extends Enum<Result> {
        private static final /* synthetic */ Result[] $VALUES = null;
        public static final Result INCOMPATIBLE = null;
        public static final Result OVERRIDABLE = null;
        public static final Result UNKNOWN = null;

        static {
            Result r0 = new Result("OVERRIDABLE", 0);
            OVERRIDABLE = r0;
            Result r1 = new Result("INCOMPATIBLE", 1);
            INCOMPATIBLE = r1;
            Result r3 = new Result("UNKNOWN", 2);
            UNKNOWN = r3;
            $VALUES = new Result[]{r0, r1, r3};
        }

        public static Result[] values() {
            return (Result[]) $VALUES.clone();
        }

        public static Result valueOf(String r1) {
            return (Result) a.a(Result.class, r1);
        }

        private Result(String r1, int r2) {
            super(r1, r2);
        }
    }

    Contract getContract();

    Result isOverridable(CallableDescriptor r1, CallableDescriptor r2, ClassDescriptor r3);
}

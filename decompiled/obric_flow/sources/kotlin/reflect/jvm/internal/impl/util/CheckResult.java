package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CheckResult {
    private final boolean isSuccess;

    public static final class IllegalFunctionName extends CheckResult {
        public static final IllegalFunctionName INSTANCE = null;

        static {
            INSTANCE = new IllegalFunctionName();
        }

        private IllegalFunctionName() {
            super(false, null);
        }
    }

    public static final class IllegalSignature extends CheckResult {
        private final String error;

        public IllegalSignature(String r5) {
            Intrinsics.checkNotNullParameter(r5, "error");
            super(false, null);
            this.error = r5;
        }
    }

    public static final class SuccessCheck extends CheckResult {
        public static final SuccessCheck INSTANCE = null;

        static {
            INSTANCE = new SuccessCheck();
        }

        private SuccessCheck() {
            super(true, null);
        }
    }

    public /* synthetic */ CheckResult(boolean r5, DefaultConstructorMarker r10) {
        this(r5);
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    private CheckResult(boolean r5) {
        this.isSuccess = r5;
    }
}

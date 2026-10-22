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

        public IllegalSignature(String r10) {
            Intrinsics.checkNotNullParameter(r10, "error");
            super(false, null);
            this.error = r10;
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

    private CheckResult(boolean r10) {
        this.isSuccess = r10;
    }

    public /* synthetic */ CheckResult(boolean r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }
}

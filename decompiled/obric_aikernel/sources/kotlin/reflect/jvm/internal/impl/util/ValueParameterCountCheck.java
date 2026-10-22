package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ValueParameterCountCheck implements Check {
    private final String description;

    public static final class AtLeast extends ValueParameterCountCheck {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final int f10223n;

        public AtLeast(int r10) {
            StringBuilder r11 = new StringBuilder();
            r11.append("must have at least ");
            r11.append(r10);
            r11.append(" value parameter");
            if (r10 <= 1) goto L5;
            String r12 = "s";
        L6:
            r11.append(r12);
            super(r11.toString(), null);
            this.f10223n = r10;
            return;
        L5:
            r12 = "";
            goto L6
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor r10) {
            Intrinsics.checkNotNullParameter(r10, "functionDescriptor");
            if (r10.getValueParameters().size() < this.f10223n) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class Equals extends ValueParameterCountCheck {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final int f10224n;

        public Equals(int r10) {
            super("must have exactly " + r10 + " value parameters", null);
            this.f10224n = r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor r10) {
            Intrinsics.checkNotNullParameter(r10, "functionDescriptor");
            if (r10.getValueParameters().size() != this.f10224n) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class NoValueParameters extends ValueParameterCountCheck {
        public static final NoValueParameters INSTANCE = null;

        static {
            INSTANCE = new NoValueParameters();
        }

        private NoValueParameters() {
            super("must have no value parameters", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor r10) {
            Intrinsics.checkNotNullParameter(r10, "functionDescriptor");
            return r10.getValueParameters().isEmpty();
        }
    }

    public static final class SingleValueParameter extends ValueParameterCountCheck {
        public static final SingleValueParameter INSTANCE = null;

        static {
            INSTANCE = new SingleValueParameter();
        }

        private SingleValueParameter() {
            super("must have a single value parameter", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor r10) {
            Intrinsics.checkNotNullParameter(r10, "functionDescriptor");
            if (r10.getValueParameters().size() == 1) goto L7;
            return false;
        L7:
            return true;
        }
    }

    private ValueParameterCountCheck(String r10) {
        this.description = r10;
    }

    public /* synthetic */ ValueParameterCountCheck(String r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return this.description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor r10) {
        return Check.DefaultImpls.invoke(this, r10);
    }
}

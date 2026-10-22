package kotlin.reflect.jvm.internal.impl.util;

import ai.j0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ValueParameterCountCheck implements Check {
    private final String description;

    public static final class AtLeast extends ValueParameterCountCheck {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final int f18761n;

        public AtLeast(int r5) {
            StringBuilder r10 = j0.s(r5, "must have at least ", " value parameter");
            if (r5 <= 1) goto L5;
            String r11 = "s";
        L6:
            r10.append(r11);
            super(r10.toString(), null);
            this.f18761n = r5;
            return;
        L5:
            r11 = "";
            goto L6
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor r5) {
            Intrinsics.checkNotNullParameter(r5, "functionDescriptor");
            if (r5.getValueParameters().size() < this.f18761n) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class Equals extends ValueParameterCountCheck {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final int f18762n;

        public Equals(int r5) {
            super(j0.h(r5, "must have exactly ", " value parameters"), null);
            this.f18762n = r5;
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor r5) {
            Intrinsics.checkNotNullParameter(r5, "functionDescriptor");
            if (r5.getValueParameters().size() != this.f18762n) goto L5;
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
        public boolean check(FunctionDescriptor r5) {
            Intrinsics.checkNotNullParameter(r5, "functionDescriptor");
            return r5.getValueParameters().isEmpty();
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
        public boolean check(FunctionDescriptor r5) {
            Intrinsics.checkNotNullParameter(r5, "functionDescriptor");
            if (r5.getValueParameters().size() == 1) goto L7;
            return false;
        L7:
            return true;
        }
    }

    public /* synthetic */ ValueParameterCountCheck(String r5, DefaultConstructorMarker r10) {
        this(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return this.description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor r5) {
        return Check.DefaultImpls.invoke(this, r5);
    }

    private ValueParameterCountCheck(String r5) {
        this.description = r5;
    }
}

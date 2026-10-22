package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MemberKindCheck implements Check {
    private final String description;

    public static final class Member extends MemberKindCheck {
        public static final Member INSTANCE = null;

        static {
            INSTANCE = new Member();
        }

        private Member() {
            super("must be a member function", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor r5) {
            Intrinsics.checkNotNullParameter(r5, "functionDescriptor");
            if (r5.getDispatchReceiverParameter() == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class MemberOrExtension extends MemberKindCheck {
        public static final MemberOrExtension INSTANCE = null;

        static {
            INSTANCE = new MemberOrExtension();
        }

        private MemberOrExtension() {
            super("must be a member or an extension function", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor r5) {
            Intrinsics.checkNotNullParameter(r5, "functionDescriptor");
            if (r5.getDispatchReceiverParameter() == null) goto L5;
        L8:
            return true;
        L5:
            if (r5.getExtensionReceiverParameter() != null) goto L8;
            return false;
        }
    }

    public /* synthetic */ MemberKindCheck(String r5, DefaultConstructorMarker r10) {
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

    private MemberKindCheck(String r5) {
        this.description = r5;
    }
}

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
        public boolean check(FunctionDescriptor r10) {
            Intrinsics.checkNotNullParameter(r10, "functionDescriptor");
            if (r10.getDispatchReceiverParameter() == null) goto L5;
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
        public boolean check(FunctionDescriptor r10) {
            Intrinsics.checkNotNullParameter(r10, "functionDescriptor");
            if (r10.getDispatchReceiverParameter() == null) goto L5;
        L8:
            return true;
        L5:
            if (r10.getExtensionReceiverParameter() != null) goto L8;
            return false;
        }
    }

    private MemberKindCheck(String r10) {
        this.description = r10;
    }

    public /* synthetic */ MemberKindCheck(String r10, DefaultConstructorMarker r11) {
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

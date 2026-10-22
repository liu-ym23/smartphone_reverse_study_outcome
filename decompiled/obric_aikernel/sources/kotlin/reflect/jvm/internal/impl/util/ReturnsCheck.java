package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReturnsCheck implements Check {
    private final String description;
    private final String name;
    private final Function1<KotlinBuiltIns, KotlinType> type;

    public static final class ReturnsBoolean extends ReturnsCheck {
        public static final ReturnsBoolean INSTANCE = null;

        static {
            INSTANCE = new ReturnsBoolean();
        }

        private ReturnsBoolean() {
            String r10 = "Boolean";
            super(r10, AnonymousClass1.INSTANCE, null);
        }
    }

    public static final class ReturnsInt extends ReturnsCheck {
        public static final ReturnsInt INSTANCE = null;

        static {
            INSTANCE = new ReturnsInt();
        }

        private ReturnsInt() {
            String r10 = "Int";
            super(r10, AnonymousClass1.INSTANCE, null);
        }
    }

    public static final class ReturnsUnit extends ReturnsCheck {
        public static final ReturnsUnit INSTANCE = null;

        static {
            INSTANCE = new ReturnsUnit();
        }

        private ReturnsUnit() {
            String r10 = "Unit";
            super(r10, AnonymousClass1.INSTANCE, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ReturnsCheck(String r10, Function1<? super KotlinBuiltIns, ? extends KotlinType> r11) {
        this.name = r10;
        this.type = r11;
        this.description = "must return " + r10;
    }

    public /* synthetic */ ReturnsCheck(String r10, Function1 r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(FunctionDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "functionDescriptor");
        return Intrinsics.areEqual(r10.getReturnType(), this.type.invoke(DescriptorUtilsKt.getBuiltIns(r10)));
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

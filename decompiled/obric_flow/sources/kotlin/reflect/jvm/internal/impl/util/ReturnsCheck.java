package kotlin.reflect.jvm.internal.impl.util;

import ai.j0;
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
            String r5 = "Boolean";
            super(r5, AnonymousClass1.INSTANCE, null);
        }
    }

    public static final class ReturnsInt extends ReturnsCheck {
        public static final ReturnsInt INSTANCE = null;

        static {
            INSTANCE = new ReturnsInt();
        }

        private ReturnsInt() {
            String r5 = "Int";
            super(r5, AnonymousClass1.INSTANCE, null);
        }
    }

    public static final class ReturnsUnit extends ReturnsCheck {
        public static final ReturnsUnit INSTANCE = null;

        static {
            INSTANCE = new ReturnsUnit();
        }

        private ReturnsUnit() {
            String r5 = "Unit";
            super(r5, AnonymousClass1.INSTANCE, null);
        }
    }

    public /* synthetic */ ReturnsCheck(String r5, Function1 r10, DefaultConstructorMarker r11) {
        this(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(FunctionDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "functionDescriptor");
        return Intrinsics.areEqual(r5.getReturnType(), this.type.invoke(DescriptorUtilsKt.getBuiltIns(r5)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return this.description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor r5) {
        return Check.DefaultImpls.invoke(this, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ReturnsCheck(String r5, Function1<? super KotlinBuiltIns, ? extends KotlinType> r10) {
        this.name = r5;
        this.type = r10;
        this.description = j0.C("must return ", r5);
    }
}

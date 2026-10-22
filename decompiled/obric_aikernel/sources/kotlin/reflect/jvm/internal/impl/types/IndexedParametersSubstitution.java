package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public final class IndexedParametersSubstitution extends TypeSubstitution {
    private final boolean approximateContravariantCapturedTypes;
    private final TypeProjection[] arguments;
    private final TypeParameterDescriptor[] parameters;

    public IndexedParametersSubstitution(List<? extends TypeParameterDescriptor> r10, List<? extends TypeProjection> r11) {
        Intrinsics.checkNotNullParameter(r10, "parameters");
        Intrinsics.checkNotNullParameter(r11, "argumentsList");
        Object[] r12 = r10.toArray(new TypeParameterDescriptor[0]);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        TypeParameterDescriptor[] r13 = (TypeParameterDescriptor[]) r12;
        Object[] r14 = r11.toArray(new TypeProjection[0]);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this(r13, (TypeProjection[]) r14, false, 4, null);
    }

    public IndexedParametersSubstitution(TypeParameterDescriptor[] r10, TypeProjection[] r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "parameters");
        Intrinsics.checkNotNullParameter(r11, "arguments");
        this.parameters = r10;
        this.arguments = r11;
        this.approximateContravariantCapturedTypes = r12;
        int r13 = r10.length;
        int r14 = r11.length;
    }

    public /* synthetic */ IndexedParametersSubstitution(TypeParameterDescriptor[] r10, TypeProjection[] r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = false;
    L5:
        this(r10, r11, r12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateContravariantCapturedTypes() {
        return this.approximateContravariantCapturedTypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public TypeProjection mo1328get(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        ClassifierDescriptor r11 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if ((r11 instanceof TypeParameterDescriptor) == false) goto L5;
        TypeParameterDescriptor r12 = (TypeParameterDescriptor) r11;
    L6:
        if (r12 != null) goto L8;
        return null;
    L8:
        int r13 = r12.getIndex();
        TypeParameterDescriptor[] r14 = this.parameters;
        if (r13 < r14.length) goto L11;
    L14:
        return null;
    L11:
        if (Intrinsics.areEqual(r14[r13].getTypeConstructor(), r12.getTypeConstructor()) == false) goto L14;
        return this.arguments[r13];
    L5:
        r12 = null;
        goto L6
    }

    public final TypeProjection[] getArguments() {
        return this.arguments;
    }

    public final TypeParameterDescriptor[] getParameters() {
        return this.parameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        if (this.arguments.length != 0) goto L5;
        return true;
    L5:
        return false;
    }
}

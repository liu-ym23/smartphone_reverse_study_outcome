package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.StubTypeMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class StubTypeForBuilderInference extends AbstractStubType implements StubTypeMarker {
    private final TypeConstructor constructor;
    private final MemberScope memberScope;

    public StubTypeForBuilderInference(NewTypeVariableConstructor r10, boolean r11, TypeConstructor r12) {
        Intrinsics.checkNotNullParameter(r10, "originalTypeVariable");
        Intrinsics.checkNotNullParameter(r12, "constructor");
        super(r10, r11);
        this.constructor = r12;
        this.memberScope = r10.getBuiltIns().getAnyType().getMemberScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractStubType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractStubType
    public AbstractStubType materialize(boolean r10) {
        return new StubTypeForBuilderInference(getOriginalTypeVariable(), r10, getConstructor());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("Stub (BI): ");
        r10.append(getOriginalTypeVariable());
        if (isMarkedNullable() == false) goto L5;
        String r11 = "?";
    L6:
        r10.append(r11);
        return r10.toString();
    L5:
        r11 = "";
        goto L6
    }
}

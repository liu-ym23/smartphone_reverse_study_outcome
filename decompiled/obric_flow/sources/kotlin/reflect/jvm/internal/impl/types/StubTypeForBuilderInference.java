package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.StubTypeMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class StubTypeForBuilderInference extends AbstractStubType implements StubTypeMarker {
    private final TypeConstructor constructor;
    private final MemberScope memberScope;

    public StubTypeForBuilderInference(NewTypeVariableConstructor r5, boolean r10, TypeConstructor r11) {
        Intrinsics.checkNotNullParameter(r5, "originalTypeVariable");
        Intrinsics.checkNotNullParameter(r11, "constructor");
        super(r5, r10);
        this.constructor = r11;
        this.memberScope = r5.getBuiltIns().getAnyType().getMemberScope();
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
    public AbstractStubType materialize(boolean r5) {
        return new StubTypeForBuilderInference(getOriginalTypeVariable(), r5, getConstructor());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    public String toString() {
        StringBuilder r5 = new StringBuilder("Stub (BI): ");
        r5.append(getOriginalTypeVariable());
        if (isMarkedNullable() == false) goto L5;
        String r10 = "?";
    L6:
        r5.append(r10);
        return r5.toString();
    L5:
        r10 = "";
        goto L6
    }
}

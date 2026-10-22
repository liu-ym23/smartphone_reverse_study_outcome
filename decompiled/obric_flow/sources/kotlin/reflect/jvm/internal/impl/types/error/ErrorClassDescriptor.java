package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes3.dex */
public final class ErrorClassDescriptor extends ClassDescriptorImpl {
    public ErrorClassDescriptor(Name r13) {
        Intrinsics.checkNotNullParameter(r13, "name");
        ErrorUtils r5 = ErrorUtils.INSTANCE;
        ModuleDescriptor r10 = r5.getErrorModule();
        Modality r11 = Modality.OPEN;
        ClassKind r12 = ClassKind.CLASS;
        List r14 = CollectionsKt.emptyList();
        SourceElement r15 = SourceElement.NO_SOURCE;
        super(r10, r13, r11, r12, r14, r15, false, LockBasedStorageManager.NO_LOCKS);
        ClassConstructorDescriptorImpl r16 = ClassConstructorDescriptorImpl.create(this, Annotations.Companion.getEMPTY(), true, r15);
        r16.initialize(CollectionsKt.emptyList(), DescriptorVisibilities.INTERNAL);
        MemberScope r17 = ErrorUtils.createErrorScope(ErrorScopeKind.SCOPE_FOR_ERROR_CLASS, new String[]{r16.getName().toString(), ""});
        ErrorTypeKind r18 = ErrorTypeKind.ERROR_CLASS;
        ErrorTypeConstructor r19 = r5.createErrorTypeConstructor(r18, new String[0]);
        List r20 = null;
        r16.setReturnType(new ErrorType(r19, r17, r18, r20, false, new String[0], 24, null));
        initialize(r17, SetsKt.setOf(r16), r16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public MemberScope getMemberScope(TypeSubstitution r5, KotlinTypeRefiner r10) {
        Intrinsics.checkNotNullParameter(r5, "typeSubstitution");
        Intrinsics.checkNotNullParameter(r10, "kotlinTypeRefiner");
        return ErrorUtils.createErrorScope(ErrorScopeKind.SCOPE_FOR_ERROR_CLASS, new String[]{getName().toString(), r5.toString()});
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public ClassDescriptor substitute(TypeSubstitutor r5) {
        Intrinsics.checkNotNullParameter(r5, "substitutor");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl
    public String toString() {
        return getName().asString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r5) {
        return substitute(r5);
    }
}

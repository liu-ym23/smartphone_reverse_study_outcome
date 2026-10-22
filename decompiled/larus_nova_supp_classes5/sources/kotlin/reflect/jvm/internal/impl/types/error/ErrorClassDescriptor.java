package kotlin.reflect.jvm.internal.impl.types.error;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ErrorClassDescriptor extends ClassDescriptorImpl {
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public ClassDescriptor substitute(TypeSubstitutor r2) {
        Intrinsics.checkNotNullParameter(r2, "substitutor");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl
    public String toString() {
        return getName().asString();
    }

    public ErrorClassDescriptor(Name r21) {
        Intrinsics.checkNotNullParameter(r21, DBDefinition.NAME);
        ErrorUtils r10 = ErrorUtils.INSTANCE;
        ModuleDescriptor r1 = r10.getErrorModule();
        Modality r3 = Modality.OPEN;
        ClassKind r4 = ClassKind.CLASS;
        List r5 = CollectionsKt.emptyList();
        SourceElement r11 = SourceElement.NO_SOURCE;
        super(r1, r21, r3, r4, r5, r11, false, LockBasedStorageManager.NO_LOCKS);
        ClassConstructorDescriptorImpl r0 = ClassConstructorDescriptorImpl.create(this, Annotations.Companion.getEMPTY(), true, r11);
        r0.initialize(CollectionsKt.emptyList(), DescriptorVisibilities.INTERNAL);
        MemberScope r2 = ErrorUtils.createErrorScope(ErrorScopeKind.SCOPE_FOR_ERROR_CLASS, new String[]{r0.getName().toString(), ""});
        ErrorTypeKind r14 = ErrorTypeKind.ERROR_CLASS;
        r0.setReturnType(new ErrorType(r10.createErrorTypeConstructor(r14, new String[0]), r2, r14, null, false, new String[0], 24, null));
        initialize(r2, SetsKt.setOf(r0), r0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public MemberScope getMemberScope(TypeSubstitution r4, KotlinTypeRefiner r5) {
        Intrinsics.checkNotNullParameter(r4, "typeSubstitution");
        Intrinsics.checkNotNullParameter(r5, "kotlinTypeRefiner");
        return ErrorUtils.createErrorScope(ErrorScopeKind.SCOPE_FOR_ERROR_CLASS, new String[]{getName().toString(), r4.toString()});
    }
}

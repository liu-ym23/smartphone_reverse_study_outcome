package kotlin.reflect.jvm.internal.impl.types.error;

import com.bytedance.crash.tracker.ActivityLifecycle;
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
    public ErrorClassDescriptor(Name r21) {
        Intrinsics.checkNotNullParameter(r21, ActivityLifecycle.NAME);
        ErrorUtils r10 = ErrorUtils.INSTANCE;
        ModuleDescriptor r11 = r10.getErrorModule();
        Modality r12 = Modality.OPEN;
        ClassKind r13 = ClassKind.CLASS;
        List r14 = CollectionsKt.emptyList();
        SourceElement r15 = SourceElement.NO_SOURCE;
        super(r11, r21, r12, r13, r14, r15, false, LockBasedStorageManager.NO_LOCKS);
        ClassConstructorDescriptorImpl r16 = ClassConstructorDescriptorImpl.create(this, Annotations.Companion.getEMPTY(), true, r15);
        r16.initialize(CollectionsKt.emptyList(), DescriptorVisibilities.INTERNAL);
        Intrinsics.checkNotNullExpressionValue(r16, "create(this, Annotations…          )\n            }");
        ErrorScopeKind r17 = ErrorScopeKind.SCOPE_FOR_ERROR_CLASS;
        String r18 = r16.getName().toString();
        Intrinsics.checkNotNullExpressionValue(r18, "errorConstructor.name.toString()");
        MemberScope r19 = ErrorUtils.createErrorScope(r17, new String[]{r18, ""});
        ErrorTypeKind r110 = ErrorTypeKind.ERROR_CLASS;
        r16.setReturnType(new ErrorType(r10.createErrorTypeConstructor(r110, new String[0]), r19, r110, null, false, new String[0], 24, null));
        initialize(r19, SetsKt.setOf(r16), r16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public MemberScope getMemberScope(TypeSubstitution r10, KotlinTypeRefiner r11) {
        Intrinsics.checkNotNullParameter(r10, "typeSubstitution");
        Intrinsics.checkNotNullParameter(r11, "kotlinTypeRefiner");
        ErrorScopeKind r12 = ErrorScopeKind.SCOPE_FOR_ERROR_CLASS;
        String r13 = getName().toString();
        Intrinsics.checkNotNullExpressionValue(r13, "name.toString()");
        return ErrorUtils.createErrorScope(r12, new String[]{r13, r10.toString()});
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public ClassDescriptor substitute(TypeSubstitutor r10) {
        Intrinsics.checkNotNullParameter(r10, "substitutor");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r10) {
        return substitute(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl
    public String toString() {
        String r10 = getName().asString();
        Intrinsics.checkNotNullExpressionValue(r10, "name.asString()");
        return r10;
    }
}

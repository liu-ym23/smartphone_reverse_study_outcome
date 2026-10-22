package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class ValueParameterDescriptorImpl extends VariableDescriptorImpl implements ValueParameterDescriptor {
    public static final Companion Companion = null;
    private final boolean declaresDefaultValue;
    private final int index;
    private final boolean isCrossinline;
    private final boolean isNoinline;
    private final ValueParameterDescriptor original;
    private final KotlinType varargElementType;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final ValueParameterDescriptorImpl createWithDestructuringDeclarations(CallableDescriptor r15, ValueParameterDescriptor r16, int r17, Annotations r18, Name r19, KotlinType r20, boolean r21, boolean r22, boolean r23, KotlinType r24, SourceElement r25, Function0<? extends List<? extends VariableDescriptor>> r26) {
            Intrinsics.checkNotNullParameter(r15, "containingDeclaration");
            Intrinsics.checkNotNullParameter(r18, "annotations");
            Intrinsics.checkNotNullParameter(r19, DBDefinition.NAME);
            Intrinsics.checkNotNullParameter(r20, "outType");
            Intrinsics.checkNotNullParameter(r25, "source");
            if (r26 != null) goto L6;
            return new ValueParameterDescriptorImpl(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
        L6:
            return new WithDestructuringDeclaration(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        }
    }

    public static final class WithDestructuringDeclaration extends ValueParameterDescriptorImpl {
        private final Lazy destructuringVariables$delegate;

        public static /* synthetic */ List accessor$ValueParameterDescriptorImpl$WithDestructuringDeclaration$lambda0(WithDestructuringDeclaration r0) {
            return copy$lambda$0(r0);
        }

        public final List<VariableDescriptor> getDestructuringVariables() {
            return (List) this.destructuringVariables$delegate.getValue();
        }

        private static final List copy$lambda$0(WithDestructuringDeclaration r1) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            return r1.getDestructuringVariables();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
        public ValueParameterDescriptor copy(CallableDescriptor r16, Name r17, int r18) {
            Intrinsics.checkNotNullParameter(r16, "newOwner");
            Intrinsics.checkNotNullParameter(r17, "newName");
            return new WithDestructuringDeclaration(r16, null, r18, getAnnotations(), r17, getType(), declaresDefaultValue(), isCrossinline(), isNoinline(), getVarargElementType(), SourceElement.NO_SOURCE, new ValueParameterDescriptorImpl$WithDestructuringDeclaration$.Lambda.0(this));
        }

        public WithDestructuringDeclaration(CallableDescriptor r2, ValueParameterDescriptor r3, int r4, Annotations r5, Name r6, KotlinType r7, boolean r8, boolean r9, boolean r10, KotlinType r11, SourceElement r12, Function0<? extends List<? extends VariableDescriptor>> r13) {
            Intrinsics.checkNotNullParameter(r2, "containingDeclaration");
            Intrinsics.checkNotNullParameter(r5, "annotations");
            Intrinsics.checkNotNullParameter(r6, DBDefinition.NAME);
            Intrinsics.checkNotNullParameter(r7, "outType");
            Intrinsics.checkNotNullParameter(r12, "source");
            Intrinsics.checkNotNullParameter(r13, "destructuringVariables");
            super(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
            this.destructuringVariables$delegate = LazyKt.lazy(r13);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final ValueParameterDescriptorImpl createWithDestructuringDeclarations(CallableDescriptor r13, ValueParameterDescriptor r14, int r15, Annotations r16, Name r17, KotlinType r18, boolean r19, boolean r20, boolean r21, KotlinType r22, SourceElement r23, Function0<? extends List<? extends VariableDescriptor>> r24) {
        return Companion.createWithDestructuringDeclarations(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public Void getCompileTimeInitializer() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isVar() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean declaresDefaultValue() {
        if (this.declaresDefaultValue == false) goto L7;
        CallableDescriptor r0 = getContainingDeclaration();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
        if (((CallableMemberDescriptor) r0).getKind().isReal() == false) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public ValueParameterDescriptor getOriginal() {
        ValueParameterDescriptor r0 = this.original;
        if (r0 != this) goto L6;
        return this;
    L6:
        return r0.getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    /* JADX INFO: renamed from: getCompileTimeInitializer, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ ConstantValue mo377getCompileTimeInitializer() {
        return getCompileTimeInitializer();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public CallableDescriptor getContainingDeclaration() {
        DeclarationDescriptor r0 = super.getContainingDeclaration();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        return (CallableDescriptor) r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public Collection<ValueParameterDescriptor> getOverriddenDescriptors() {
        Collection<? extends CallableDescriptor> r0 = getContainingDeclaration().getOverriddenDescriptors();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add((ValueParameterDescriptor) ListProtector.get(((CallableDescriptor) r2.next()).getValueParameters(), getIndex()));
        goto L4
    L6:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isLateInit() {
        return ValueParameterDescriptor.DefaultImpls.isLateInit(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public int getIndex() {
        return this.index;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public KotlinType getVarargElementType() {
        return this.varargElementType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public DescriptorVisibility getVisibility() {
        return DescriptorVisibilities.LOCAL;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean isCrossinline() {
        return this.isCrossinline;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean isNoinline() {
        return this.isNoinline;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ VariableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public ValueParameterDescriptor substitute(TypeSubstitutor r2) {
        Intrinsics.checkNotNullParameter(r2, "substitutor");
        if (r2.isEmpty() == false) goto L6;
        return this;
    L6:
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ VariableDescriptor substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r2, D r3) {
        Intrinsics.checkNotNullParameter(r2, "visitor");
        return r2.visitValueParameterDescriptor(this, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public ValueParameterDescriptor copy(CallableDescriptor r14, Name r15, int r16) {
        Intrinsics.checkNotNullParameter(r14, "newOwner");
        Intrinsics.checkNotNullParameter(r15, "newName");
        return new ValueParameterDescriptorImpl(r14, null, r16, getAnnotations(), r15, getType(), declaresDefaultValue(), isCrossinline(), isNoinline(), getVarargElementType(), SourceElement.NO_SOURCE);
    }

    public ValueParameterDescriptorImpl(CallableDescriptor r8, ValueParameterDescriptor r9, int r10, Annotations r11, Name r12, KotlinType r13, boolean r14, boolean r15, boolean r16, KotlinType r17, SourceElement r18) {
        Intrinsics.checkNotNullParameter(r8, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r11, "annotations");
        Intrinsics.checkNotNullParameter(r12, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r13, "outType");
        Intrinsics.checkNotNullParameter(r18, "source");
        super(r8, r11, r12, r13, r18);
        this.index = r10;
        this.declaresDefaultValue = r14;
        this.isCrossinline = r15;
        this.isNoinline = r16;
        this.varargElementType = r17;
        if (r9 != null) goto L5;
        ValueParameterDescriptor r0 = this;
    L6:
        this.original = r0;
        return;
    L5:
        r0 = r9;
        goto L6
    }
}

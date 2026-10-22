package kotlin.reflect.jvm.internal.impl.descriptors.impl;

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
import kotlin.jvm.internal.SourceDebugExtension;
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

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nValueParameterDescriptorImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValueParameterDescriptorImpl.kt\norg/jetbrains/kotlin/descriptors/impl/ValueParameterDescriptorImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,134:1\n1549#2:135\n1620#2,3:136\n*S KotlinDebug\n*F\n+ 1 ValueParameterDescriptorImpl.kt\norg/jetbrains/kotlin/descriptors/impl/ValueParameterDescriptorImpl\n*L\n129#1:135\n129#1:136,3\n*E\n"})
public class ValueParameterDescriptorImpl extends VariableDescriptorImpl implements ValueParameterDescriptor {
    public static final Companion Companion = null;
    private final boolean declaresDefaultValue;
    private final int index;
    private final boolean isCrossinline;
    private final boolean isNoinline;
    private final ValueParameterDescriptor original;
    private final KotlinType varargElementType;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @JvmStatic
        public final ValueParameterDescriptorImpl createWithDestructuringDeclarations(CallableDescriptor r15, ValueParameterDescriptor r16, int r17, Annotations r18, Name r19, KotlinType r20, boolean r21, boolean r22, boolean r23, KotlinType r24, SourceElement r25, Function0<? extends List<? extends VariableDescriptor>> r26) {
            Intrinsics.checkNotNullParameter(r15, "containingDeclaration");
            Intrinsics.checkNotNullParameter(r18, "annotations");
            Intrinsics.checkNotNullParameter(r19, "name");
            Intrinsics.checkNotNullParameter(r20, "outType");
            Intrinsics.checkNotNullParameter(r25, "source");
            if (r26 != null) goto L6;
            return new ValueParameterDescriptorImpl(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
        L6:
            return new WithDestructuringDeclaration(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        }

        private Companion() {
        }
    }

    public static final class WithDestructuringDeclaration extends ValueParameterDescriptorImpl {
        private final Lazy destructuringVariables$delegate;

        public WithDestructuringDeclaration(CallableDescriptor r5, ValueParameterDescriptor r10, int r11, Annotations r12, Name r13, KotlinType r14, boolean r15, boolean r16, boolean r17, KotlinType r18, SourceElement r19, Function0<? extends List<? extends VariableDescriptor>> r110) {
            Intrinsics.checkNotNullParameter(r5, "containingDeclaration");
            Intrinsics.checkNotNullParameter(r12, "annotations");
            Intrinsics.checkNotNullParameter(r13, "name");
            Intrinsics.checkNotNullParameter(r14, "outType");
            Intrinsics.checkNotNullParameter(r19, "source");
            Intrinsics.checkNotNullParameter(r110, "destructuringVariables");
            super(r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
            this.destructuringVariables$delegate = LazyKt.lazy(r110);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
        public ValueParameterDescriptor copy(CallableDescriptor r15, Name r16, int r17) {
            Intrinsics.checkNotNullParameter(r15, "newOwner");
            Intrinsics.checkNotNullParameter(r16, "newName");
            return new WithDestructuringDeclaration(r15, null, r17, getAnnotations(), r16, getType(), declaresDefaultValue(), isCrossinline(), isNoinline(), getVarargElementType(), SourceElement.NO_SOURCE, new ValueParameterDescriptorImpl$WithDestructuringDeclaration$copy$1(this));
        }

        public final List<VariableDescriptor> getDestructuringVariables() {
            return (List) this.destructuringVariables$delegate.getValue();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ValueParameterDescriptorImpl(CallableDescriptor r10, ValueParameterDescriptor r11, int r12, Annotations r13, Name r14, KotlinType r15, boolean r16, boolean r17, boolean r18, KotlinType r19, SourceElement r110) {
        Intrinsics.checkNotNullParameter(r10, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r13, "annotations");
        Intrinsics.checkNotNullParameter(r14, "name");
        Intrinsics.checkNotNullParameter(r15, "outType");
        Intrinsics.checkNotNullParameter(r110, "source");
        super(r10, r13, r14, r15, r110);
        this.index = r12;
        this.declaresDefaultValue = r16;
        this.isCrossinline = r17;
        this.isNoinline = r18;
        this.varargElementType = r19;
        if (r11 != null) goto L5;
        ValueParameterDescriptor r5 = this;
    L6:
        this.original = r5;
        return;
    L5:
        r5 = r11;
        goto L6
    }

    @JvmStatic
    public static final ValueParameterDescriptorImpl createWithDestructuringDeclarations(CallableDescriptor r13, ValueParameterDescriptor r14, int r15, Annotations r16, Name r17, KotlinType r18, boolean r19, boolean r20, boolean r21, KotlinType r22, SourceElement r23, Function0<? extends List<? extends VariableDescriptor>> r24) {
        return Companion.createWithDestructuringDeclarations(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r5, D r10) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        return r5.visitValueParameterDescriptor(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public ValueParameterDescriptor copy(CallableDescriptor r14, Name r15, int r16) {
        Intrinsics.checkNotNullParameter(r14, "newOwner");
        Intrinsics.checkNotNullParameter(r15, "newName");
        return new ValueParameterDescriptorImpl(r14, null, r16, getAnnotations(), r15, getType(), declaresDefaultValue(), isCrossinline(), isNoinline(), getVarargElementType(), SourceElement.NO_SOURCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean declaresDefaultValue() {
        if (this.declaresDefaultValue == false) goto L7;
        CallableDescriptor r5 = getContainingDeclaration();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
        if (((CallableMemberDescriptor) r5).getKind().isReal() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public Void getCompileTimeInitializer() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public int getIndex() {
        return this.index;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public Collection<ValueParameterDescriptor> getOverriddenDescriptors() {
        Collection<? extends CallableDescriptor> r5 = getContainingDeclaration().getOverriddenDescriptors();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(((CallableDescriptor) r11.next()).getValueParameters().get(getIndex()));
        goto L4
    L6:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public KotlinType getVarargElementType() {
        return this.varargElementType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        return DescriptorVisibilities.LOCAL;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean isCrossinline() {
        return this.isCrossinline;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isLateInit() {
        return ValueParameterDescriptor.DefaultImpls.isLateInit(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean isNoinline() {
        return this.isNoinline;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isVar() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r5) {
        return substitute(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    /* JADX INFO: renamed from: getCompileTimeInitializer, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ ConstantValue mo1398getCompileTimeInitializer() {
        return (ConstantValue) getCompileTimeInitializer();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public CallableDescriptor getContainingDeclaration() {
        DeclarationDescriptor r5 = super.getContainingDeclaration();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        return (CallableDescriptor) r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ VariableDescriptor substitute(TypeSubstitutor r5) {
        return substitute(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public ValueParameterDescriptor substitute(TypeSubstitutor r5) {
        Intrinsics.checkNotNullParameter(r5, "substitutor");
        if (r5.isEmpty() == false) goto L6;
        return this;
    L6:
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ VariableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public ValueParameterDescriptor getOriginal() {
        ValueParameterDescriptor r5 = this.original;
        if (r5 != this) goto L6;
        return this;
    L6:
        return r5.getOriginal();
    }
}

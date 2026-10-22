package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;

/* JADX INFO: loaded from: classes3.dex */
public final class FunctionInvokeDescriptor extends SimpleFunctionDescriptorImpl {
    public static final Factory Factory = null;

    public static final class Factory {
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker r10) {
            this();
        }

        private final ValueParameterDescriptor createValueParameter(FunctionInvokeDescriptor r15, int r16, TypeParameterDescriptor r17) {
            String r10 = r17.getName().asString();
            Intrinsics.checkNotNullExpressionValue(r10, "typeParameter.name.asString()");
            if (Intrinsics.areEqual(r10, "T") == false) goto L6;
            String r11 = "instance";
        L9:
            Annotations r12 = Annotations.Companion.getEMPTY();
            Name r13 = Name.identifier(r11);
            Intrinsics.checkNotNullExpressionValue(r13, "identifier(name)");
            SimpleType r14 = r17.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(r14, "typeParameter.defaultType");
            SourceElement r18 = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(r18, "NO_SOURCE");
            return new ValueParameterDescriptorImpl(r15, null, r16, r12, r13, r14, false, false, false, null, r18);
        L6:
            if (Intrinsics.areEqual(r10, "E") == false) goto L8;
            r11 = "receiver";
            goto L9
        L8:
            r11 = r10.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            goto L9
        }

        public final FunctionInvokeDescriptor create(FunctionClassDescriptor r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r12, "functionClass");
            List<TypeParameterDescriptor> r11 = r12.getDeclaredTypeParameters();
            FunctionInvokeDescriptor r10 = new FunctionInvokeDescriptor(r12, null, CallableMemberDescriptor.Kind.DECLARATION, r13, null);
            ReceiverParameterDescriptor r14 = r12.getThisAsReceiverParameter();
            List<ReceiverParameterDescriptor> r15 = CollectionsKt.emptyList();
            List<? extends TypeParameterDescriptor> r16 = CollectionsKt.emptyList();
            ArrayList r17 = new ArrayList();
            Iterator<T> r18 = r11.iterator();
        L4:
            if (r18.hasNext() == false) goto L12;
            Object r19 = r18.next();
            if (((TypeParameterDescriptor) r19).getVariance() != Variance.IN_VARIANCE) goto L8;
            boolean r20 = true;
        L9:
            if (r20 == false) goto L12;
            r17.add(r19);
            goto L4
        L8:
            r20 = false;
        L12:
            Iterable r110 = CollectionsKt.withIndex(r17);
            ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
            Iterator r111 = r110.iterator();
        L14:
            if (r111.hasNext() == false) goto L16;
            IndexedValue r112 = (IndexedValue) r111.next();
            r21.add(FunctionInvokeDescriptor.Factory.createValueParameter(r10, r112.getIndex(), (TypeParameterDescriptor) r112.getValue()));
            goto L14
        L16:
            r10.initialize(null, r14, r15, r16, r21, ((TypeParameterDescriptor) CollectionsKt.last(r11)).getDefaultType(), Modality.ABSTRACT, DescriptorVisibilities.PUBLIC);
            r10.setHasSynthesizedParameterNames(true);
            return r10;
        }
    }

    static {
        Factory = new Factory(null);
    }

    private FunctionInvokeDescriptor(DeclarationDescriptor r10, FunctionInvokeDescriptor r11, CallableMemberDescriptor.Kind r12, boolean r13) {
        super(r10, r11, Annotations.Companion.getEMPTY(), OperatorNameConventions.INVOKE, r12, SourceElement.NO_SOURCE);
        setOperator(true);
        setSuspend(r13);
        setHasStableParameterNames(false);
    }

    public /* synthetic */ FunctionInvokeDescriptor(DeclarationDescriptor r10, FunctionInvokeDescriptor r11, CallableMemberDescriptor.Kind r12, boolean r13, DefaultConstructorMarker r14) {
        this(r10, r11, r12, r13);
    }

    private final FunctionDescriptor replaceParameterNames(List<Name> r10) {
        int r11 = getValueParameters().size() - r10.size();
        boolean r12 = true;
        if (r11 != 0) goto L17;
        List<ValueParameterDescriptor> r13 = getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r13, "valueParameters");
        List r14 = CollectionsKt.zip(r10, r13);
        if ((r14 instanceof Collection) == true) goto L7;
    L9:
        Iterator r15 = r14.iterator();
    L11:
        if (r15.hasNext() == false) goto L8;
        Pair r16 = (Pair) r15.next();
        if (Intrinsics.areEqual((Name) r16.component1(), ((ValueParameterDescriptor) r16.component2()).getName()) == true) goto L11;
        boolean r17 = false;
    L15:
        if (r17 == false) goto L17;
        return this;
    L8:
        r17 = true;
        goto L15
    L7:
        if (r14.isEmpty() == false) goto L9;
    L17:
        List<ValueParameterDescriptor> r18 = getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r18, "valueParameters");
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator<T> r20 = r18.iterator();
    L19:
        if (r20.hasNext() == false) goto L26;
        ValueParameterDescriptor r21 = (ValueParameterDescriptor) r20.next();
        Name r22 = r21.getName();
        Intrinsics.checkNotNullExpressionValue(r22, "it.name");
        int r23 = r21.getIndex();
        int r24 = r23 - r11;
        if (r24 < 0) goto L25;
        Name r25 = r10.get(r24);
        if (r25 == null) goto L25;
        r22 = r25;
    L25:
        r19.add(r21.copy(this, r22, r23));
        goto L19
    L26:
        FunctionDescriptorImpl.CopyConfiguration r26 = newCopyBuilder(TypeSubstitutor.EMPTY);
        if (r10.isEmpty() == false) goto L29;
    L28:
        r12 = false;
    L37:
        FunctionDescriptorImpl.CopyConfiguration r110 = r26.setHasSynthesizedParameterNames(r12).setValueParameters(r19).setOriginal(getOriginal());
        Intrinsics.checkNotNullExpressionValue(r110, "newCopyBuilder(TypeSubst…   .setOriginal(original)");
        FunctionDescriptor r27 = super.doSubstitute(r110);
        Intrinsics.checkNotNull(r27);
        return r27;
    L29:
        Iterator<T> r111 = r10.iterator();
    L31:
        if (r111.hasNext() == false) goto L28;
        if (((Name) r111.next()) != null) goto L35;
        boolean r28 = true;
    L36:
        if (r28 == false) goto L31;
    L35:
        r28 = false;
        goto L36
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r10, FunctionDescriptor r11, CallableMemberDescriptor.Kind r12, Name r13, Annotations r14, SourceElement r15) {
        Intrinsics.checkNotNullParameter(r10, "newOwner");
        Intrinsics.checkNotNullParameter(r12, "kind");
        Intrinsics.checkNotNullParameter(r14, "annotations");
        Intrinsics.checkNotNullParameter(r15, "source");
        return new FunctionInvokeDescriptor(r10, (FunctionInvokeDescriptor) r11, r12, isSuspend());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected FunctionDescriptor doSubstitute(FunctionDescriptorImpl.CopyConfiguration r10) {
        Intrinsics.checkNotNullParameter(r10, "configuration");
        FunctionInvokeDescriptor r11 = (FunctionInvokeDescriptor) super.doSubstitute(r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        List<ValueParameterDescriptor> r12 = r11.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r12, "substituted.valueParameters");
        boolean r13 = false;
        if ((r12 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r14 = r12.iterator();
    L13:
        if (r14.hasNext() == false) goto L10;
        KotlinType r15 = ((ValueParameterDescriptor) r14.next()).getType();
        Intrinsics.checkNotNullExpressionValue(r15, "it.type");
        if (FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(r15) == null) goto L17;
        boolean r16 = true;
    L18:
        if (r16 == false) goto L13;
    L19:
        if (r13 == false) goto L21;
        return r11;
    L21:
        List<ValueParameterDescriptor> r17 = r11.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r17, "substituted.valueParameters");
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<T> r19 = r17.iterator();
    L23:
        if (r19.hasNext() == false) goto L26;
        KotlinType r20 = ((ValueParameterDescriptor) r19.next()).getType();
        Intrinsics.checkNotNullExpressionValue(r20, "it.type");
        r18.add(FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(r20));
        goto L23
    L26:
        return r11.replaceParameterNames(r18);
    L17:
        r16 = false;
    L10:
        r13 = true;
        goto L19
    L9:
        if (r12.isEmpty() == false) goto L11;
        goto L10
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }
}

package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class PropertyDescriptorImpl extends VariableDescriptorWithInitializerImpl implements PropertyDescriptor {
    private FieldDescriptor backingField;
    private List<ReceiverParameterDescriptor> contextReceiverParameters;
    private FieldDescriptor delegateField;
    private ReceiverParameterDescriptor dispatchReceiverParameter;
    private ReceiverParameterDescriptor extensionReceiverParameter;
    private PropertyGetterDescriptorImpl getter;
    private final boolean isActual;
    private final boolean isConst;
    private final boolean isDelegated;
    private final boolean isExpect;
    private final boolean isExternal;
    private final CallableMemberDescriptor.Kind kind;
    private final boolean lateInit;
    private final Modality modality;
    private final PropertyDescriptor original;
    private Collection<? extends PropertyDescriptor> overriddenProperties;
    private PropertySetterDescriptor setter;
    private boolean setterProjectedOut;
    private List<TypeParameterDescriptor> typeParameters;
    private DescriptorVisibility visibility;

    private static /* synthetic */ void $$$reportNull$$$0(int r11) {
        if (r11 == 28) goto L10;
        if (r11 == 38) goto L10;
        if (r11 == 39) goto L10;
        if (r11 == 41) goto L10;
        if (r11 == 42) goto L10;
        switch(r11) {
            case 21: goto L10;
            case 22: goto L10;
            case 23: goto L10;
            case 24: goto L10;
            case 25: goto L10;
            case 26: goto L10;
            default: goto L9;
        };
    L9:
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L12:
        if (r11 == 28) goto L19;
        if (r11 == 38) goto L19;
        if (r11 == 39) goto L19;
        if (r11 == 41) goto L19;
        if (r11 == 42) goto L19;
        switch(r11) {
            case 21: goto L19;
            case 22: goto L19;
            case 23: goto L19;
            case 24: goto L19;
            case 25: goto L19;
            case 26: goto L19;
            default: goto L18;
        };
    L18:
        int r7 = 3;
    L20:
        Object[] r8 = new Object[r7];
        switch(r11) {
            case 1: goto L42;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L38;
            case 6: goto L37;
            case 7: goto L22;
            case 8: goto L42;
            case 9: goto L41;
            case 10: goto L40;
            case 11: goto L39;
            case 12: goto L38;
            case 13: goto L37;
            case 14: goto L36;
            case 15: goto L35;
            case 16: goto L34;
            case 17: goto L35;
            case 18: goto L34;
            case 19: goto L33;
            case 20: goto L40;
            case 21: goto L32;
            case 22: goto L32;
            case 23: goto L32;
            case 24: goto L32;
            case 25: goto L32;
            case 26: goto L32;
            case 27: goto L31;
            case 28: goto L32;
            case 29: goto L30;
            case 30: goto L29;
            case 31: goto L28;
            case 32: goto L27;
            case 33: goto L26;
            case 34: goto L25;
            case 35: goto L38;
            case 36: goto L24;
            case 37: goto L37;
            case 38: goto L32;
            case 39: goto L32;
            case 40: goto L23;
            case 41: goto L32;
            case 42: goto L32;
            default: goto L22;
        };
    L22:
        r8[0] = "containingDeclaration";
    L44:
        if (r11 == 28) goto L61;
        if (r11 == 38) goto L60;
        if (r11 == 39) goto L59;
        if (r11 == 41) goto L58;
        if (r11 == 42) goto L57;
        switch(r11) {
            case 21: goto L56;
            case 22: goto L55;
            case 23: goto L54;
            case 24: goto L53;
            case 25: goto L52;
            case 26: goto L51;
            default: goto L50;
        };
    L50:
        r8[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
    L62:
        switch(r11) {
            case 7: goto L72;
            case 8: goto L72;
            case 9: goto L72;
            case 10: goto L72;
            case 11: goto L72;
            case 12: goto L72;
            case 13: goto L72;
            case 14: goto L71;
            case 15: goto L70;
            case 16: goto L70;
            case 17: goto L70;
            case 18: goto L70;
            case 19: goto L70;
            case 20: goto L69;
            case 21: goto L73;
            case 22: goto L73;
            case 23: goto L73;
            case 24: goto L73;
            case 25: goto L73;
            case 26: goto L73;
            case 27: goto L68;
            case 28: goto L73;
            case 29: goto L67;
            case 30: goto L66;
            case 31: goto L66;
            case 32: goto L65;
            case 33: goto L65;
            case 34: goto L65;
            case 35: goto L65;
            case 36: goto L65;
            case 37: goto L65;
            case 38: goto L73;
            case 39: goto L73;
            case 40: goto L64;
            case 41: goto L73;
            case 42: goto L73;
            default: goto L63;
        };
    L63:
        r8[2] = "<init>";
        goto L73
    L64:
        r8[2] = "setOverriddenDescriptors";
        goto L73
    L65:
        r8[2] = "createSubstitutedCopy";
        goto L73
    L66:
        r8[2] = "getSubstitutedInitialSignatureDescriptor";
        goto L73
    L67:
        r8[2] = "doSubstitute";
        goto L73
    L68:
        r8[2] = "substitute";
        goto L73
    L69:
        r8[2] = "setVisibility";
        goto L73
    L70:
        r8[2] = "setType";
        goto L73
    L71:
        r8[2] = "setInType";
        goto L73
    L72:
        r8[2] = "create";
    L73:
        String r6 = String.format(r5, r8);
        if (r11 == 28) goto L82;
        if (r11 == 38) goto L82;
        if (r11 == 39) goto L82;
        if (r11 == 41) goto L82;
        if (r11 == 42) goto L82;
        switch(r11) {
            case 21: goto L82;
            case 22: goto L82;
            case 23: goto L82;
            case 24: goto L82;
            case 25: goto L82;
            case 26: goto L82;
            default: goto L83;
        };
    L83:
        throw new IllegalArgumentException(r6);
    L82:
        throw new IllegalStateException(r6);
    L51:
        r8[1] = "getAccessors";
        goto L62
    L52:
        r8[1] = "getVisibility";
        goto L62
    L53:
        r8[1] = "getModality";
        goto L62
    L54:
        r8[1] = "getReturnType";
        goto L62
    L55:
        r8[1] = "getContextReceiverParameters";
        goto L62
    L56:
        r8[1] = "getTypeParameters";
        goto L62
    L57:
        r8[1] = "copy";
        goto L62
    L58:
        r8[1] = "getOverriddenDescriptors";
        goto L62
    L59:
        r8[1] = "getKind";
        goto L62
    L60:
        r8[1] = "getOriginal";
        goto L62
    L61:
        r8[1] = "getSourceToUseForCopy";
        goto L62
    L23:
        r8[0] = "overriddenDescriptors";
        goto L44
    L24:
        r8[0] = "newName";
        goto L44
    L25:
        r8[0] = "newVisibility";
        goto L44
    L26:
        r8[0] = "newModality";
        goto L44
    L27:
        r8[0] = "newOwner";
        goto L44
    L28:
        r8[0] = "accessorDescriptor";
        goto L44
    L29:
        r8[0] = "substitutor";
        goto L44
    L30:
        r8[0] = "copyConfiguration";
        goto L44
    L31:
        r8[0] = "originalSubstitutor";
        goto L44
    L32:
        r8[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
        goto L44
    L33:
        r8[0] = "contextReceiverParameters";
        goto L44
    L34:
        r8[0] = "typeParameters";
        goto L44
    L35:
        r8[0] = "outType";
        goto L44
    L36:
        r8[0] = "inType";
        goto L44
    L37:
        r8[0] = "source";
        goto L44
    L38:
        r8[0] = "kind";
        goto L44
    L39:
        r8[0] = DBDefinition.NAME;
        goto L44
    L40:
        r8[0] = "visibility";
        goto L44
    L41:
        r8[0] = "modality";
        goto L44
    L42:
        r8[0] = "annotations";
    L19:
        r7 = 2;
    L10:
        r5 = "@NotNull method %s.%s must not return null";
        goto L12
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> r1) {
        return null;
    }

    public void setInType(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(14);
        return;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public List<PropertyAccessorDescriptor> getAccessors() {
        ArrayList r0 = new ArrayList(2);
        PropertyGetterDescriptorImpl r1 = this.getter;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        PropertySetterDescriptor r2 = this.setter;
        if (r2 == null) goto L8;
        r0.add(r2);
    L8:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> r0 = this.contextReceiverParameters;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(22);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind r0 = this.kind;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(39);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        Modality r0 = this.modality;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(24);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public PropertyDescriptor getOriginal() {
        PropertyDescriptor r0 = this.original;
        if (r0 != this) goto L5;
        PropertyDescriptor r1 = this;
    L6:
        if (r1 != null) goto L8;
        $$$reportNull$$$0(38);
    L8:
        return r1;
    L5:
        r1 = r0.getOriginal();
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public Collection<? extends PropertyDescriptor> getOverriddenDescriptors() {
        Collection<? extends PropertyDescriptor> r0 = this.overriddenProperties;
        if (r0 != null) goto L6;
        r0 = Collections.emptyList();
    L6:
        if (r0 != null) goto L8;
        $$$reportNull$$$0(41);
    L8:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> r0 = this.typeParameters;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility r0 = this.visibility;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(25);
    L5:
        return r0;
    }

    public CopyConfiguration newCopyBuilder() {
        return new CopyConfiguration(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public /* bridge */ /* synthetic */ PropertyGetterDescriptor getGetter() {
        return getGetter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public KotlinType getReturnType() {
        KotlinType r0 = getType();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(23);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public FieldDescriptor getBackingField() {
        return this.backingField;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public FieldDescriptor getDelegateField() {
        return this.delegateField;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.dispatchReceiverParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.extensionReceiverParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public PropertySetterDescriptor getSetter() {
        return this.setter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.isActual;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isConst() {
        return this.isConst;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptorWithAccessors
    public boolean isDelegated() {
        return this.isDelegated;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.isExpect;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return this.isExternal;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isLateInit() {
        return this.lateInit;
    }

    public boolean isSetterProjectedOut() {
        return this.setterProjectedOut;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public PropertyGetterDescriptorImpl getGetter() {
        return this.getter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
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

    public static /* synthetic */ ReceiverParameterDescriptor access$000(PropertyDescriptorImpl r0) {
        return r0.dispatchReceiverParameter;
    }

    public PropertyDescriptor doSubstitute(CopyConfiguration r21) {
        if (r21 != null) goto L5;
        $$$reportNull$$$0(29);
    L5:
        PropertyDescriptorImpl r0 = createSubstitutedCopy(CopyConfiguration.access$100(r21), CopyConfiguration.access$200(r21), CopyConfiguration.access$300(r21), CopyConfiguration.access$400(r21), CopyConfiguration.access$500(r21), CopyConfiguration.access$600(r21), getSourceToUseForCopy(CopyConfiguration.access$700(r21), CopyConfiguration.access$400(r21)));
        if (CopyConfiguration.access$800(r21) != null) goto L8;
        List<TypeParameterDescriptor> r1 = getTypeParameters();
    L9:
        ArrayList r11 = new ArrayList(r1.size());
        TypeSubstitutor r2 = DescriptorSubstitutor.substituteTypeParameters(r1, CopyConfiguration.access$900(r21), r0, r11);
        KotlinType r3 = CopyConfiguration.access$1000(r21);
        KotlinType r10 = r2.substitute(r3, Variance.OUT_VARIANCE);
        FieldDescriptorImpl r4 = null;
        if (r10 != null) goto L12;
        return null;
    L12:
        KotlinType r5 = r2.substitute(r3, Variance.IN_VARIANCE);
        if (r5 == null) goto L15;
        r0.setInType(r5);
    L15:
        ReceiverParameterDescriptor r6 = CopyConfiguration.access$1100(r21);
        if (r6 == null) goto L21;
        ReceiverParameterDescriptor r7 = r6.substitute(r2);
        if (r7 != null) goto L20;
        return null;
    L20:
        ReceiverParameterDescriptor r12 = r7;
    L22:
        ReceiverParameterDescriptor r8 = this.extensionReceiverParameter;
        if (r8 == null) goto L25;
        ReceiverParameterDescriptor r13 = substituteParameterDescriptor(r2, r0, r8);
    L26:
        ArrayList r14 = new ArrayList();
        Iterator<ReceiverParameterDescriptor> r9 = this.contextReceiverParameters.iterator();
    L28:
        if (r9.hasNext() == false) goto L32;
        ReceiverParameterDescriptor r15 = substituteContextParameterDescriptor(r2, r0, r9.next());
        if (r15 == null) goto L28;
        r14.add(r15);
        goto L28
    L32:
        r0.setType(r10, r11, r12, r13, r14);
        if (this.getter != null) goto L35;
        PropertyGetterDescriptorImpl r16 = null;
    L36:
        if (r16 == null) goto L43;
        KotlinType r17 = this.getter.getReturnType();
        r16.setInitialSignatureDescriptor(getSubstitutedInitialSignatureDescriptor(r2, this.getter));
        if (r17 == null) goto L40;
        KotlinType r18 = r2.substitute(r17, Variance.OUT_VARIANCE);
    L41:
        r16.initialize(r18);
        goto L43
    L40:
        r18 = null;
    L43:
        if (this.setter != null) goto L45;
        PropertySetterDescriptor r19 = null;
    L46:
        if (r19 == null) goto L55;
        List<ValueParameterDescriptor> r20 = FunctionDescriptorImpl.getSubstitutedValueParameters(r19, this.setter.getValueParameters(), r2, false, false, null);
        if (r20 != null) goto L51;
        r0.setSetterProjectedOut(true);
        r20 = Collections.singletonList(PropertySetterDescriptorImpl.createSetterParameter(r19, DescriptorUtilsKt.getBuiltIns(CopyConfiguration.access$100(r21)).getNothingType(), ((ValueParameterDescriptor) ListProtector.get(this.setter.getValueParameters(), 0)).getAnnotations()));
    L51:
        if (r20.size() != 1) goto L54;
        r19.setInitialSignatureDescriptor(getSubstitutedInitialSignatureDescriptor(r2, this.setter));
        r19.initialize((ValueParameterDescriptor) ListProtector.get(r20, 0));
        goto L55
    L54:
        throw new IllegalStateException();
    L55:
        FieldDescriptor r22 = this.backingField;
        if (r22 != null) goto L58;
        FieldDescriptorImpl r23 = null;
    L59:
        FieldDescriptor r24 = this.delegateField;
        if (r24 == null) goto L63;
        r4 = new FieldDescriptorImpl(r24.getAnnotations(), r0);
    L63:
        r0.initialize(r16, r19, r23, r4);
        if (CopyConfiguration.access$1200(r21) == false) goto L71;
        SmartSet r25 = SmartSet.create();
        Iterator<? extends PropertyDescriptor> r26 = getOverriddenDescriptors().iterator();
    L67:
        if (r26.hasNext() == false) goto L69;
        r25.add(r26.next().substitute(r2));
        goto L67
    L69:
        r0.setOverriddenDescriptors(r25);
    L71:
        if (isConst() == false) goto L75;
        Function0<NullableLazyValue<ConstantValue<?>>> r27 = this.compileTimeInitializerFactory;
        if (r27 == null) goto L75;
        r0.setCompileTimeInitializer(this.compileTimeInitializer, r27);
    L75:
        return r0;
    L58:
        r23 = new FieldDescriptorImpl(r22.getAnnotations(), r0);
        goto L59
    L45:
        r19 = new PropertySetterDescriptorImpl(r0, this.setter.getAnnotations(), CopyConfiguration.access$200(r21), normalizeVisibility(this.setter.getVisibility(), CopyConfiguration.access$500(r21)), this.setter.isDefault(), this.setter.isExternal(), this.setter.isInline(), CopyConfiguration.access$500(r21), r21.getOriginalSetter(), SourceElement.NO_SOURCE);
        goto L46
    L35:
        r16 = new PropertyGetterDescriptorImpl(r0, this.getter.getAnnotations(), CopyConfiguration.access$200(r21), normalizeVisibility(this.getter.getVisibility(), CopyConfiguration.access$500(r21)), this.getter.isDefault(), this.getter.isExternal(), this.getter.isInline(), CopyConfiguration.access$500(r21), r21.getOriginalGetter(), SourceElement.NO_SOURCE);
        goto L36
    L25:
        r13 = null;
        goto L26
    L21:
        r12 = null;
        goto L22
    L8:
        r1 = CopyConfiguration.access$800(r21);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> r2) {
        if (r2 != 0) goto L4;
        $$$reportNull$$$0(40);
    L4:
        this.overriddenProperties = r2;
    }

    public void setSetterProjectedOut(boolean r1) {
        this.setterProjectedOut = r1;
    }

    public void setVisibility(DescriptorVisibility r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(20);
    L4:
        this.visibility = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public PropertyDescriptor substitute(TypeSubstitutor r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(27);
    L5:
        if (r2.isEmpty() == false) goto L8;
        return this;
    L8:
        return newCopyBuilder().setSubstitution(r2.getSubstitution()).setOriginal(getOriginal()).build();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ VariableDescriptor substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    private SourceElement getSourceToUseForCopy(boolean r1, PropertyDescriptor r2) {
        if (r1 == false) goto L7;
        if (r2 != null) goto L6;
        r2 = getOriginal();
    L6:
        SourceElement r3 = r2.getSource();
    L8:
        if (r3 != null) goto L10;
        $$$reportNull$$$0(28);
    L10:
        return r3;
    L7:
        r3 = SourceElement.NO_SOURCE;
        goto L8
    }

    private static FunctionDescriptor getSubstitutedInitialSignatureDescriptor(TypeSubstitutor r1, PropertyAccessorDescriptor r2) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(30);
    L4:
        if (r2 != null) goto L7;
        $$$reportNull$$$0(31);
    L7:
        if (r2.getInitialSignatureDescriptor() != null) goto L11;
        return null;
    L11:
        return r2.getInitialSignatureDescriptor().substitute(r1);
    }

    private static DescriptorVisibility normalizeVisibility(DescriptorVisibility r1, CallableMemberDescriptor.Kind r2) {
        if (r2 == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) goto L5;
        return r1;
    L5:
        if (DescriptorVisibilities.isPrivate(r1.normalize()) == true) goto L7;
        return r1;
    L7:
        return DescriptorVisibilities.INVISIBLE_FAKE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r1, D r2) {
        return r1.visitPropertyDescriptor(this, r2);
    }

    public void initialize(PropertyGetterDescriptorImpl r2, PropertySetterDescriptor r3) {
        initialize(r2, r3, null, null);
    }

    private static ReceiverParameterDescriptor substituteContextParameterDescriptor(TypeSubstitutor r4, PropertyDescriptor r5, ReceiverParameterDescriptor r6) {
        KotlinType r7 = r4.substitute(r6.getType(), Variance.IN_VARIANCE);
        if (r7 != null) goto L7;
        return null;
    L7:
        return new ReceiverParameterDescriptorImpl(r5, new ContextReceiver(r5, r7, r6.getValue().getCustomLabelName(), r6.getValue()), r6.getAnnotations());
    }

    private static ReceiverParameterDescriptor substituteParameterDescriptor(TypeSubstitutor r3, PropertyDescriptor r4, ReceiverParameterDescriptor r5) {
        KotlinType r6 = r3.substitute(r5.getType(), Variance.IN_VARIANCE);
        if (r6 != null) goto L7;
        return null;
    L7:
        return new ReceiverParameterDescriptorImpl(r4, new ExtensionReceiver(r4, r6, r5.getValue()), r5.getAnnotations());
    }

    public void initialize(PropertyGetterDescriptorImpl r1, PropertySetterDescriptor r2, FieldDescriptor r3, FieldDescriptor r4) {
        this.getter = r1;
        this.setter = r2;
        this.backingField = r3;
        this.delegateField = r4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public PropertyDescriptor copy(DeclarationDescriptor r2, Modality r3, DescriptorVisibility r4, CallableMemberDescriptor.Kind r5, boolean r6) {
        PropertyDescriptor r7 = newCopyBuilder().setOwner(r2).setOriginal(null).setModality(r3).setVisibility(r4).setKind(r5).setCopyOverrides(r6).build();
        if (r7 != null) goto L5;
        $$$reportNull$$$0(42);
    L5:
        return r7;
    }

    public void setType(KotlinType r2, List<? extends TypeParameterDescriptor> r3, ReceiverParameterDescriptor r4, ReceiverParameterDescriptor r5, List<ReceiverParameterDescriptor> r6) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(17);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(18);
    L6:
        if (r6 != null) goto L8;
        $$$reportNull$$$0(19);
    L8:
        setOutType(r2);
        this.typeParameters = new ArrayList(r3);
        this.extensionReceiverParameter = r5;
        this.dispatchReceiverParameter = r4;
        this.contextReceiverParameters = r6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor r1, Modality r2, DescriptorVisibility r3, CallableMemberDescriptor.Kind r4, boolean r5) {
        return copy(r1, r2, r3, r4, r5);
    }

    public PropertyDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r18, Modality r19, DescriptorVisibility r20, PropertyDescriptor r21, CallableMemberDescriptor.Kind r22, Name r23, SourceElement r24) {
        if (r18 != null) goto L4;
        $$$reportNull$$$0(32);
    L4:
        if (r19 != null) goto L6;
        $$$reportNull$$$0(33);
    L6:
        if (r20 != null) goto L8;
        $$$reportNull$$$0(34);
    L8:
        if (r22 != null) goto L10;
        $$$reportNull$$$0(35);
    L10:
        if (r23 != null) goto L12;
        $$$reportNull$$$0(36);
    L12:
        if (r24 != null) goto L15;
        $$$reportNull$$$0(37);
    L15:
        return new PropertyDescriptorImpl(r18, r21, getAnnotations(), r19, r20, isVar(), r23, r22, r24, isLateInit(), isConst(), isExpect(), isActual(), isExternal(), isDelegated());
    }

    public static PropertyDescriptorImpl create(DeclarationDescriptor r17, Annotations r18, Modality r19, DescriptorVisibility r20, boolean r21, Name r22, CallableMemberDescriptor.Kind r23, SourceElement r24, boolean r25, boolean r26, boolean r27, boolean r28, boolean r29, boolean r30) {
        if (r17 != null) goto L4;
        $$$reportNull$$$0(7);
    L4:
        if (r18 != null) goto L6;
        $$$reportNull$$$0(8);
    L6:
        if (r19 != null) goto L8;
        $$$reportNull$$$0(9);
    L8:
        if (r20 != null) goto L10;
        $$$reportNull$$$0(10);
    L10:
        if (r22 != null) goto L12;
        $$$reportNull$$$0(11);
    L12:
        if (r23 != null) goto L14;
        $$$reportNull$$$0(12);
    L14:
        if (r24 != null) goto L17;
        $$$reportNull$$$0(13);
    L17:
        return new PropertyDescriptorImpl(r17, null, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    }

    public PropertyDescriptorImpl(DeclarationDescriptor r12, PropertyDescriptor r13, Annotations r14, Modality r15, DescriptorVisibility r16, boolean r17, Name r18, CallableMemberDescriptor.Kind r19, SourceElement r20, boolean r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26) {
        if (r12 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        if (r14 != null) goto L7;
        $$$reportNull$$$0(1);
    L7:
        if (r15 != null) goto L9;
        $$$reportNull$$$0(2);
    L9:
        if (r16 != null) goto L11;
        $$$reportNull$$$0(3);
    L11:
        if (r18 != null) goto L13;
        $$$reportNull$$$0(4);
    L13:
        if (r19 != null) goto L15;
        $$$reportNull$$$0(5);
    L15:
        if (r20 != null) goto L17;
        $$$reportNull$$$0(6);
    L17:
        super(r12, r14, r18, null, r17, r20);
        this.overriddenProperties = null;
        this.contextReceiverParameters = Collections.emptyList();
        this.modality = r15;
        this.visibility = r16;
        if (r13 != null) goto L20;
        PropertyDescriptor r0 = this;
    L21:
        this.original = r0;
        this.kind = r19;
        this.lateInit = r21;
        this.isConst = r22;
        this.isExpect = r23;
        this.isActual = r24;
        this.isExternal = r25;
        this.isDelegated = r26;
        return;
    L20:
        r0 = r13;
        goto L21
    }
}

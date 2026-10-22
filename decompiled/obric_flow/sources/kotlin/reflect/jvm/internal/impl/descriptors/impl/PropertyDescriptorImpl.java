package kotlin.reflect.jvm.internal.impl.descriptors.impl;

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
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: loaded from: classes3.dex */
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

    public class CopyConfiguration {
        private boolean copyOverrides;
        private ReceiverParameterDescriptor dispatchReceiverParameter;
        private CallableMemberDescriptor.Kind kind;
        private Modality modality;
        private Name name;
        private List<TypeParameterDescriptor> newTypeParameters;
        private PropertyDescriptor original;
        private DeclarationDescriptor owner;
        private boolean preserveSourceElement;
        private KotlinType returnType;
        private TypeSubstitution substitution;
        final /* synthetic */ PropertyDescriptorImpl this$0;
        private DescriptorVisibility visibility;

        private static /* synthetic */ void $$$reportNull$$$0(int r24) {
            if (r24 == 1) goto L16;
            if (r24 == 2) goto L16;
            if (r24 == 3) goto L16;
            if (r24 == 5) goto L16;
            if (r24 == 7) goto L16;
            if (r24 == 9) goto L16;
            if (r24 == 11) goto L16;
            if (r24 == 19) goto L16;
            if (r24 == 13) goto L16;
            if (r24 == 14) goto L16;
            if (r24 == 16) goto L16;
            if (r24 == 17) goto L16;
            String r13 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L17:
            if (r24 == 1) goto L30;
            if (r24 == 2) goto L30;
            if (r24 == 3) goto L30;
            if (r24 == 5) goto L30;
            if (r24 == 7) goto L30;
            if (r24 == 9) goto L30;
            if (r24 == 11) goto L30;
            if (r24 == 19) goto L30;
            if (r24 == 13) goto L30;
            if (r24 == 14) goto L30;
            if (r24 == 16) goto L30;
            if (r24 == 17) goto L30;
            int r14 = 3;
        L31:
            Object[] r15 = new Object[r14];
            switch(r24) {
                case 1: goto L41;
                case 2: goto L41;
                case 3: goto L41;
                case 4: goto L40;
                case 5: goto L41;
                case 6: goto L39;
                case 7: goto L41;
                case 8: goto L38;
                case 9: goto L41;
                case 10: goto L37;
                case 11: goto L41;
                case 12: goto L36;
                case 13: goto L41;
                case 14: goto L41;
                case 15: goto L35;
                case 16: goto L41;
                case 17: goto L41;
                case 18: goto L34;
                case 19: goto L41;
                default: goto L33;
            };
        L33:
            r15[0] = "owner";
        L43:
            if (r24 == 1) goto L67;
            if (r24 == 2) goto L66;
            if (r24 == 3) goto L65;
            if (r24 == 5) goto L64;
            if (r24 == 7) goto L63;
            if (r24 == 9) goto L62;
            if (r24 == 11) goto L61;
            if (r24 == 19) goto L60;
            if (r24 == 13) goto L59;
            if (r24 == 14) goto L58;
            if (r24 == 16) goto L57;
            if (r24 == 17) goto L56;
            r15[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
        L68:
            switch(r24) {
                case 1: goto L77;
                case 2: goto L77;
                case 3: goto L77;
                case 4: goto L76;
                case 5: goto L77;
                case 6: goto L75;
                case 7: goto L77;
                case 8: goto L74;
                case 9: goto L77;
                case 10: goto L73;
                case 11: goto L77;
                case 12: goto L72;
                case 13: goto L77;
                case 14: goto L77;
                case 15: goto L71;
                case 16: goto L77;
                case 17: goto L77;
                case 18: goto L70;
                case 19: goto L77;
                default: goto L69;
            };
        L69:
            r15[2] = "setOwner";
            goto L77
        L70:
            r15[2] = "setName";
            goto L77
        L71:
            r15[2] = "setSubstitution";
            goto L77
        L72:
            r15[2] = "setTypeParameters";
            goto L77
        L73:
            r15[2] = "setKind";
            goto L77
        L74:
            r15[2] = "setVisibility";
            goto L77
        L75:
            r15[2] = "setModality";
            goto L77
        L76:
            r15[2] = "setReturnType";
        L77:
            String r16 = String.format(r13, r15);
            if (r24 == 1) goto L92;
            if (r24 == 2) goto L92;
            if (r24 == 3) goto L92;
            if (r24 == 5) goto L92;
            if (r24 == 7) goto L92;
            if (r24 == 9) goto L92;
            if (r24 == 11) goto L92;
            if (r24 == 19) goto L92;
            if (r24 == 13) goto L92;
            if (r24 == 14) goto L92;
            if (r24 == 16) goto L92;
            if (r24 == 17) goto L92;
            throw new IllegalArgumentException(r16);
        L92:
            throw new IllegalStateException(r16);
        L56:
            r15[1] = "setCopyOverrides";
            goto L68
        L57:
            r15[1] = "setSubstitution";
            goto L68
        L58:
            r15[1] = "setDispatchReceiverParameter";
            goto L68
        L59:
            r15[1] = "setTypeParameters";
            goto L68
        L60:
            r15[1] = "setName";
            goto L68
        L61:
            r15[1] = "setKind";
            goto L68
        L62:
            r15[1] = "setVisibility";
            goto L68
        L63:
            r15[1] = "setModality";
            goto L68
        L64:
            r15[1] = "setReturnType";
            goto L68
        L65:
            r15[1] = "setPreserveSourceElement";
            goto L68
        L66:
            r15[1] = "setOriginal";
            goto L68
        L67:
            r15[1] = "setOwner";
            goto L68
        L34:
            r15[0] = "name";
            goto L43
        L35:
            r15[0] = "substitution";
            goto L43
        L36:
            r15[0] = "typeParameters";
            goto L43
        L37:
            r15[0] = "kind";
            goto L43
        L38:
            r15[0] = "visibility";
            goto L43
        L39:
            r15[0] = "modality";
            goto L43
        L40:
            r15[0] = "type";
            goto L43
        L41:
            r15[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
        L30:
            r14 = 2;
        L16:
            r13 = "@NotNull method %s.%s must not return null";
            goto L17
        }

        public CopyConfiguration(PropertyDescriptorImpl r5) {
            this.this$0 = r5;
            this.owner = r5.getContainingDeclaration();
            this.modality = r5.getModality();
            this.visibility = r5.getVisibility();
            this.original = null;
            this.preserveSourceElement = false;
            this.kind = r5.getKind();
            this.substitution = TypeSubstitution.EMPTY;
            this.copyOverrides = true;
            this.dispatchReceiverParameter = PropertyDescriptorImpl.access$000(r5);
            this.newTypeParameters = null;
            this.name = r5.getName();
            this.returnType = r5.getType();
        }

        public static /* synthetic */ DeclarationDescriptor access$100(CopyConfiguration r5) {
            return r5.owner;
        }

        public static /* synthetic */ KotlinType access$1000(CopyConfiguration r5) {
            return r5.returnType;
        }

        public static /* synthetic */ ReceiverParameterDescriptor access$1100(CopyConfiguration r5) {
            return r5.dispatchReceiverParameter;
        }

        public static /* synthetic */ boolean access$1200(CopyConfiguration r5) {
            return r5.copyOverrides;
        }

        public static /* synthetic */ Modality access$200(CopyConfiguration r5) {
            return r5.modality;
        }

        public static /* synthetic */ DescriptorVisibility access$300(CopyConfiguration r5) {
            return r5.visibility;
        }

        public static /* synthetic */ PropertyDescriptor access$400(CopyConfiguration r5) {
            return r5.original;
        }

        public static /* synthetic */ CallableMemberDescriptor.Kind access$500(CopyConfiguration r5) {
            return r5.kind;
        }

        public static /* synthetic */ Name access$600(CopyConfiguration r5) {
            return r5.name;
        }

        public static /* synthetic */ boolean access$700(CopyConfiguration r5) {
            return r5.preserveSourceElement;
        }

        public static /* synthetic */ List access$800(CopyConfiguration r5) {
            return r5.newTypeParameters;
        }

        public static /* synthetic */ TypeSubstitution access$900(CopyConfiguration r5) {
            return r5.substitution;
        }

        public PropertyDescriptor build() {
            return this.this$0.doSubstitute(this);
        }

        public PropertyGetterDescriptor getOriginalGetter() {
            PropertyDescriptor r5 = this.original;
            if (r5 != null) goto L7;
            return null;
        L7:
            return r5.getGetter();
        }

        public PropertySetterDescriptor getOriginalSetter() {
            PropertyDescriptor r5 = this.original;
            if (r5 != null) goto L7;
            return null;
        L7:
            return r5.getSetter();
        }

        public CopyConfiguration setCopyOverrides(boolean r5) {
            this.copyOverrides = r5;
            return this;
        }

        public CopyConfiguration setKind(CallableMemberDescriptor.Kind r5) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(10);
        L4:
            this.kind = r5;
            return this;
        }

        public CopyConfiguration setModality(Modality r5) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(6);
        L4:
            this.modality = r5;
            return this;
        }

        public CopyConfiguration setOriginal(CallableMemberDescriptor r5) {
            this.original = (PropertyDescriptor) r5;
            return this;
        }

        public CopyConfiguration setOwner(DeclarationDescriptor r5) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.owner = r5;
            return this;
        }

        public CopyConfiguration setSubstitution(TypeSubstitution r5) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(15);
        L4:
            this.substitution = r5;
            return this;
        }

        public CopyConfiguration setVisibility(DescriptorVisibility r5) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(8);
        L4:
            this.visibility = r5;
            return this;
        }
    }

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
        if (r11 == 38) goto L83;
        if (r11 == 39) goto L84;
        if (r11 == 41) goto L85;
        if (r11 == 42) goto L86;
        switch(r11) {
            case 21: goto L87;
            case 22: goto L87;
            case 23: goto L87;
            case 24: goto L87;
            case 25: goto L87;
            case 26: goto L87;
            default: goto L18;
        };
    L18:
        int r10 = 3;
    L20:
        Object[] r12 = new Object[r10];
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
        r12[0] = "containingDeclaration";
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
        r12[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
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
        r12[2] = "<init>";
        goto L73
    L64:
        r12[2] = "setOverriddenDescriptors";
        goto L73
    L65:
        r12[2] = "createSubstitutedCopy";
        goto L73
    L66:
        r12[2] = "getSubstitutedInitialSignatureDescriptor";
        goto L73
    L67:
        r12[2] = "doSubstitute";
        goto L73
    L68:
        r12[2] = "substitute";
        goto L73
    L69:
        r12[2] = "setVisibility";
        goto L73
    L70:
        r12[2] = "setType";
        goto L73
    L71:
        r12[2] = "setInType";
        goto L73
    L72:
        r12[2] = "create";
    L73:
        String r13 = String.format(r5, r12);
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
            default: goto L88;
        };
    L88:
        throw new IllegalArgumentException(r13);
    L82:
        throw new IllegalStateException(r13);
    L51:
        r12[1] = "getAccessors";
        goto L62
    L52:
        r12[1] = "getVisibility";
        goto L62
    L53:
        r12[1] = "getModality";
        goto L62
    L54:
        r12[1] = "getReturnType";
        goto L62
    L55:
        r12[1] = "getContextReceiverParameters";
        goto L62
    L56:
        r12[1] = "getTypeParameters";
        goto L62
    L57:
        r12[1] = "copy";
        goto L62
    L58:
        r12[1] = "getOverriddenDescriptors";
        goto L62
    L59:
        r12[1] = "getKind";
        goto L62
    L60:
        r12[1] = "getOriginal";
        goto L62
    L61:
        r12[1] = "getSourceToUseForCopy";
        goto L62
    L23:
        r12[0] = "overriddenDescriptors";
        goto L44
    L24:
        r12[0] = "newName";
        goto L44
    L25:
        r12[0] = "newVisibility";
        goto L44
    L26:
        r12[0] = "newModality";
        goto L44
    L27:
        r12[0] = "newOwner";
        goto L44
    L28:
        r12[0] = "accessorDescriptor";
        goto L44
    L29:
        r12[0] = "substitutor";
        goto L44
    L30:
        r12[0] = "copyConfiguration";
        goto L44
    L31:
        r12[0] = "originalSubstitutor";
        goto L44
    L32:
        r12[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
        goto L44
    L33:
        r12[0] = "contextReceiverParameters";
        goto L44
    L34:
        r12[0] = "typeParameters";
        goto L44
    L35:
        r12[0] = "outType";
        goto L44
    L36:
        r12[0] = "inType";
        goto L44
    L37:
        r12[0] = "source";
        goto L44
    L38:
        r12[0] = "kind";
        goto L44
    L39:
        r12[0] = "name";
        goto L44
    L40:
        r12[0] = "visibility";
        goto L44
    L41:
        r12[0] = "modality";
        goto L44
    L42:
        r12[0] = "annotations";
        goto L44
    L87:
        r10 = 2;
        goto L20
    L86:
        r10 = 2;
        goto L20
    L85:
        r10 = 2;
        goto L20
    L84:
        r10 = 2;
        goto L20
    L83:
        r10 = 2;
        goto L20
    L19:
        r10 = 2;
    L10:
        r5 = "@NotNull method %s.%s must not return null";
        goto L12
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
        PropertyDescriptor r5 = this;
    L21:
        this.original = r5;
        this.kind = r19;
        this.lateInit = r21;
        this.isConst = r22;
        this.isExpect = r23;
        this.isActual = r24;
        this.isExternal = r25;
        this.isDelegated = r26;
        return;
    L20:
        r5 = r13;
        goto L21
    }

    public static /* synthetic */ ReceiverParameterDescriptor access$000(PropertyDescriptorImpl r5) {
        return r5.dispatchReceiverParameter;
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

    private SourceElement getSourceToUseForCopy(boolean r5, PropertyDescriptor r10) {
        if (r5 == false) goto L7;
        if (r10 != null) goto L6;
        r10 = getOriginal();
    L6:
        SourceElement r11 = r10.getSource();
    L8:
        if (r11 != null) goto L10;
        $$$reportNull$$$0(28);
    L10:
        return r11;
    L7:
        r11 = SourceElement.NO_SOURCE;
        goto L8
    }

    private static FunctionDescriptor getSubstitutedInitialSignatureDescriptor(TypeSubstitutor r5, PropertyAccessorDescriptor r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(30);
    L4:
        if (r10 != null) goto L7;
        $$$reportNull$$$0(31);
    L7:
        if (r10.getInitialSignatureDescriptor() != null) goto L11;
        return null;
    L11:
        return r10.getInitialSignatureDescriptor().substitute(r5);
    }

    private static DescriptorVisibility normalizeVisibility(DescriptorVisibility r5, CallableMemberDescriptor.Kind r10) {
        if (r10 == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) goto L5;
        return r5;
    L5:
        if (DescriptorVisibilities.isPrivate(r5.normalize()) == true) goto L7;
        return r5;
    L7:
        return DescriptorVisibilities.INVISIBLE_FAKE;
    }

    private static ReceiverParameterDescriptor substituteContextParameterDescriptor(TypeSubstitutor r5, PropertyDescriptor r10, ReceiverParameterDescriptor r11) {
        KotlinType r12 = r5.substitute(r11.getType(), Variance.IN_VARIANCE);
        if (r12 != null) goto L7;
        return null;
    L7:
        return new ReceiverParameterDescriptorImpl(r10, new ContextReceiver(r10, r12, ((ImplicitContextReceiver) r11.getValue()).getCustomLabelName(), r11.getValue()), r11.getAnnotations());
    }

    private static ReceiverParameterDescriptor substituteParameterDescriptor(TypeSubstitutor r5, PropertyDescriptor r10, ReceiverParameterDescriptor r11) {
        KotlinType r12 = r5.substitute(r11.getType(), Variance.IN_VARIANCE);
        if (r12 != null) goto L7;
        return null;
    L7:
        return new ReceiverParameterDescriptorImpl(r10, new ExtensionReceiver(r10, r12, r11.getValue()), r11.getAnnotations());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r5, D r10) {
        return r5.visitPropertyDescriptor(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor r5, Modality r10, DescriptorVisibility r11, CallableMemberDescriptor.Kind r12, boolean r13) {
        return copy(r5, r10, r11, r12, r13);
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

    public PropertyDescriptor doSubstitute(CopyConfiguration r21) {
        if (r21 != null) goto L5;
        $$$reportNull$$$0(29);
    L5:
        PropertyDescriptorImpl r5 = createSubstitutedCopy(CopyConfiguration.access$100(r21), CopyConfiguration.access$200(r21), CopyConfiguration.access$300(r21), CopyConfiguration.access$400(r21), CopyConfiguration.access$500(r21), CopyConfiguration.access$600(r21), getSourceToUseForCopy(CopyConfiguration.access$700(r21), CopyConfiguration.access$400(r21)));
        if (CopyConfiguration.access$800(r21) != null) goto L8;
        List<TypeParameterDescriptor> r10 = getTypeParameters();
    L9:
        ArrayList r11 = new ArrayList(r10.size());
        TypeSubstitutor r12 = DescriptorSubstitutor.substituteTypeParameters(r10, CopyConfiguration.access$900(r21), r5, r11);
        KotlinType r13 = CopyConfiguration.access$1000(r21);
        KotlinType r14 = r12.substitute(r13, Variance.OUT_VARIANCE);
        FieldDescriptorImpl r15 = null;
        if (r14 != null) goto L12;
        return null;
    L12:
        KotlinType r16 = r12.substitute(r13, Variance.IN_VARIANCE);
        if (r16 == null) goto L15;
        r5.setInType(r16);
    L15:
        ReceiverParameterDescriptor r17 = CopyConfiguration.access$1100(r21);
        if (r17 == null) goto L21;
        ReceiverParameterDescriptor r18 = r17.substitute(r12);
        if (r18 != null) goto L20;
        return null;
    L20:
        ReceiverParameterDescriptor r19 = r18;
    L22:
        ReceiverParameterDescriptor r20 = this.extensionReceiverParameter;
        if (r20 == null) goto L25;
        ReceiverParameterDescriptor r110 = substituteParameterDescriptor(r12, r5, r20);
    L26:
        ArrayList r111 = new ArrayList();
        Iterator<ReceiverParameterDescriptor> r22 = this.contextReceiverParameters.iterator();
    L28:
        if (r22.hasNext() == false) goto L32;
        ReceiverParameterDescriptor r23 = substituteContextParameterDescriptor(r12, r5, r22.next());
        if (r23 == null) goto L28;
        r111.add(r23);
        goto L28
    L32:
        r5.setType(r14, r11, r19, r110, r111);
        PropertyGetterDescriptorImpl r24 = this.getter;
        if (r24 != null) goto L35;
        PropertyGetterDescriptorImpl r25 = null;
    L36:
        if (r25 == null) goto L42;
        KotlinType r26 = this.getter.getReturnType();
        r25.setInitialSignatureDescriptor(getSubstitutedInitialSignatureDescriptor(r12, this.getter));
        if (r26 == null) goto L40;
        KotlinType r27 = r12.substitute(r26, Variance.OUT_VARIANCE);
    L41:
        r25.initialize(r27);
        goto L42
    L40:
        r27 = null;
    L42:
        PropertySetterDescriptor r28 = this.setter;
        if (r28 != null) goto L45;
        PropertySetterDescriptorImpl r29 = null;
    L46:
        if (r29 == null) goto L55;
        List<ValueParameterDescriptor> r30 = FunctionDescriptorImpl.getSubstitutedValueParameters(r29, this.setter.getValueParameters(), r12, false, false, null);
        if (r30 != null) goto L51;
        r5.setSetterProjectedOut(true);
        r30 = Collections.singletonList(PropertySetterDescriptorImpl.createSetterParameter(r29, DescriptorUtilsKt.getBuiltIns(CopyConfiguration.access$100(r21)).getNothingType(), this.setter.getValueParameters().get(0).getAnnotations()));
    L51:
        if (r30.size() != 1) goto L54;
        r29.setInitialSignatureDescriptor(getSubstitutedInitialSignatureDescriptor(r12, this.setter));
        r29.initialize(r30.get(0));
        goto L55
    L54:
        throw new IllegalStateException();
    L55:
        FieldDescriptor r31 = this.backingField;
        if (r31 != null) goto L58;
        FieldDescriptorImpl r32 = null;
    L59:
        FieldDescriptor r33 = this.delegateField;
        if (r33 == null) goto L63;
        r15 = new FieldDescriptorImpl(r33.getAnnotations(), r5);
    L63:
        r5.initialize(r25, r29, r32, r15);
        if (CopyConfiguration.access$1200(r21) == false) goto L71;
        SmartSet r34 = SmartSet.create();
        Iterator<? extends PropertyDescriptor> r35 = getOverriddenDescriptors().iterator();
    L67:
        if (r35.hasNext() == false) goto L69;
        r34.add(r35.next().substitute(r12));
        goto L67
    L69:
        r5.setOverriddenDescriptors(r34);
    L71:
        if (isConst() == false) goto L75;
        Function0<NullableLazyValue<ConstantValue<?>>> r36 = this.compileTimeInitializerFactory;
        if (r36 == null) goto L75;
        r5.setCompileTimeInitializer(this.compileTimeInitializer, r36);
    L75:
        return r5;
    L58:
        r32 = new FieldDescriptorImpl(r31.getAnnotations(), r5);
        goto L59
    L45:
        r29 = new PropertySetterDescriptorImpl(r5, r28.getAnnotations(), CopyConfiguration.access$200(r21), normalizeVisibility(this.setter.getVisibility(), CopyConfiguration.access$500(r21)), this.setter.isDefault(), this.setter.isExternal(), this.setter.isInline(), CopyConfiguration.access$500(r21), r21.getOriginalSetter(), SourceElement.NO_SOURCE);
        goto L46
    L35:
        r25 = new PropertyGetterDescriptorImpl(r5, r24.getAnnotations(), CopyConfiguration.access$200(r21), normalizeVisibility(this.getter.getVisibility(), CopyConfiguration.access$500(r21)), this.getter.isDefault(), this.getter.isExternal(), this.getter.isInline(), CopyConfiguration.access$500(r21), r21.getOriginalGetter(), SourceElement.NO_SOURCE);
        goto L36
    L25:
        r110 = null;
        goto L26
    L21:
        r19 = null;
        goto L22
    L8:
        r10 = CopyConfiguration.access$800(r21);
        goto L9
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public List<PropertyAccessorDescriptor> getAccessors() {
        ArrayList r5 = new ArrayList(2);
        PropertyGetterDescriptorImpl r10 = this.getter;
        if (r10 == null) goto L5;
        r5.add(r10);
    L5:
        PropertySetterDescriptor r11 = this.setter;
        if (r11 == null) goto L8;
        r5.add(r11);
    L8:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public FieldDescriptor getBackingField() {
        return this.backingField;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> r5 = this.contextReceiverParameters;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(22);
    L5:
        return r5;
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
    public /* bridge */ /* synthetic */ PropertyGetterDescriptor getGetter() {
        return getGetter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind r5 = this.kind;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(39);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        Modality r5 = this.modality;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(24);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public Collection<? extends PropertyDescriptor> getOverriddenDescriptors() {
        Collection<? extends PropertyDescriptor> r5 = this.overriddenProperties;
        if (r5 != null) goto L6;
        r5 = Collections.emptyList();
    L6:
        if (r5 != null) goto L8;
        $$$reportNull$$$0(41);
    L8:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public KotlinType getReturnType() {
        KotlinType r5 = getType();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(23);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public PropertySetterDescriptor getSetter() {
        return this.setter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> r5 = this.typeParameters;
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalStateException("typeParameters == null for " + toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> r5) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility r5 = this.visibility;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(25);
    L5:
        return r5;
    }

    public void initialize(PropertyGetterDescriptorImpl r5, PropertySetterDescriptor r10) {
        initialize(r5, r10, null, null);
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

    public CopyConfiguration newCopyBuilder() {
        return new CopyConfiguration(this);
    }

    public void setInType(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(14);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> r5) {
        if (r5 != 0) goto L4;
        $$$reportNull$$$0(40);
    L4:
        this.overriddenProperties = r5;
    }

    public void setSetterProjectedOut(boolean r5) {
        this.setterProjectedOut = r5;
    }

    public void setType(KotlinType r5, List<? extends TypeParameterDescriptor> r10, ReceiverParameterDescriptor r11, ReceiverParameterDescriptor r12, List<ReceiverParameterDescriptor> r13) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(17);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(18);
    L6:
        if (r13 != null) goto L8;
        $$$reportNull$$$0(19);
    L8:
        setOutType(r5);
        this.typeParameters = new ArrayList(r10);
        this.extensionReceiverParameter = r12;
        this.dispatchReceiverParameter = r11;
        this.contextReceiverParameters = r13;
    }

    public void setVisibility(DescriptorVisibility r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(20);
    L4:
        this.visibility = r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r5) {
        return substitute(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public PropertyDescriptor copy(DeclarationDescriptor r5, Modality r10, DescriptorVisibility r11, CallableMemberDescriptor.Kind r12, boolean r13) {
        PropertyDescriptor r14 = newCopyBuilder().setOwner(r5).setOriginal(null).setModality(r10).setVisibility(r11).setKind(r12).setCopyOverrides(r13).build();
        if (r14 != null) goto L5;
        $$$reportNull$$$0(42);
    L5:
        return r14;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public PropertyGetterDescriptorImpl getGetter() {
        return this.getter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
        return getOriginal();
    }

    public void initialize(PropertyGetterDescriptorImpl r5, PropertySetterDescriptor r10, FieldDescriptor r11, FieldDescriptor r12) {
        this.getter = r5;
        this.setter = r10;
        this.backingField = r11;
        this.delegateField = r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ VariableDescriptor substitute(TypeSubstitutor r5) {
        return substitute(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public PropertyDescriptor substitute(TypeSubstitutor r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(27);
    L5:
        if (r5.isEmpty() == false) goto L8;
        return this;
    L8:
        return newCopyBuilder().setSubstitution(r5.getSubstitution()).setOriginal(getOriginal()).build();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ VariableDescriptor getOriginal() {
        return getOriginal();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public PropertyDescriptor getOriginal() {
        PropertyDescriptor r5 = this.original;
        ?? r10 = this;
        if (r5 == this) goto L6;
        r10 = r5.getOriginal();
    L6:
        if (r10 != 0) goto L8;
        $$$reportNull$$$0(38);
    L8:
        return r10;
    }
}

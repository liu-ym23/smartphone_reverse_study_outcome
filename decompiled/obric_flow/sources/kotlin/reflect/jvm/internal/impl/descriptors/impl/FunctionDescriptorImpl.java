package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FunctionDescriptorImpl extends DeclarationDescriptorNonRootImpl implements FunctionDescriptor {
    private List<ReceiverParameterDescriptor> contextReceiverParameters;
    private ReceiverParameterDescriptor dispatchReceiverParameter;
    private ReceiverParameterDescriptor extensionReceiverParameter;
    private boolean hasStableParameterNames;
    private boolean hasSynthesizedParameterNames;
    private FunctionDescriptor initialSignatureDescriptor;
    private boolean isActual;
    private boolean isExpect;
    private boolean isExternal;
    private boolean isHiddenForResolutionEverywhereBesideSupercalls;
    private boolean isHiddenToOvercomeSignatureClash;
    private boolean isInfix;
    private boolean isInline;
    private boolean isOperator;
    private boolean isSuspend;
    private boolean isTailrec;
    private final CallableMemberDescriptor.Kind kind;
    private volatile Function0<Collection<FunctionDescriptor>> lazyOverriddenFunctionsTask;
    private Modality modality;
    private final FunctionDescriptor original;
    private Collection<? extends FunctionDescriptor> overriddenFunctions;
    private List<TypeParameterDescriptor> typeParameters;
    private KotlinType unsubstitutedReturnType;
    private List<ValueParameterDescriptor> unsubstitutedValueParameters;
    protected Map<CallableDescriptor.UserDataKey<?>, Object> userDataMap;
    private DescriptorVisibility visibility;

    public class CopyConfiguration implements FunctionDescriptor.CopyBuilder<FunctionDescriptor> {
        private Annotations additionalAnnotations;
        protected boolean copyOverrides;
        protected ReceiverParameterDescriptor dispatchReceiverParameter;
        protected boolean dropOriginalInContainingParts;
        private boolean isHiddenForResolutionEverywhereBesideSupercalls;
        private boolean isHiddenToOvercomeSignatureClash;
        protected boolean justForTypeSubstitution;
        protected CallableMemberDescriptor.Kind kind;
        protected Name name;
        protected List<ReceiverParameterDescriptor> newContextReceiverParameters;
        protected ReceiverParameterDescriptor newExtensionReceiverParameter;
        private Boolean newHasSynthesizedParameterNames;
        protected Modality newModality;
        protected DeclarationDescriptor newOwner;
        protected KotlinType newReturnType;
        private List<TypeParameterDescriptor> newTypeParameters;
        protected List<ValueParameterDescriptor> newValueParameterDescriptors;
        protected DescriptorVisibility newVisibility;
        protected FunctionDescriptor original;
        protected boolean preserveSourceElement;
        protected boolean signatureChange;
        protected TypeSubstitution substitution;
        final /* synthetic */ FunctionDescriptorImpl this$0;
        private Map<CallableDescriptor.UserDataKey<?>, Object> userDataMap;

        private static /* synthetic */ void $$$reportNull$$$0(int r17) {
            switch(r17) {
                case 9: goto L4;
                case 10: goto L3;
                case 11: goto L4;
                case 12: goto L3;
                case 13: goto L4;
                case 14: goto L3;
                case 15: goto L4;
                case 16: goto L4;
                case 17: goto L3;
                case 18: goto L4;
                case 19: goto L3;
                case 20: goto L4;
                case 21: goto L3;
                case 22: goto L4;
                case 23: goto L3;
                case 24: goto L4;
                case 25: goto L3;
                case 26: goto L4;
                case 27: goto L4;
                case 28: goto L4;
                case 29: goto L4;
                case 30: goto L4;
                case 31: goto L4;
                case 32: goto L4;
                case 33: goto L4;
                case 34: goto L4;
                case 35: goto L3;
                case 36: goto L4;
                case 37: goto L3;
                case 38: goto L4;
                case 39: goto L3;
                case 40: goto L4;
                case 41: goto L4;
                case 42: goto L4;
                default: goto L3;
            };
        L3:
            String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L6:
            switch(r17) {
                case 9: goto L8;
                case 10: goto L7;
                case 11: goto L8;
                case 12: goto L7;
                case 13: goto L8;
                case 14: goto L7;
                case 15: goto L8;
                case 16: goto L8;
                case 17: goto L7;
                case 18: goto L8;
                case 19: goto L7;
                case 20: goto L8;
                case 21: goto L7;
                case 22: goto L8;
                case 23: goto L7;
                case 24: goto L8;
                case 25: goto L7;
                case 26: goto L8;
                case 27: goto L8;
                case 28: goto L8;
                case 29: goto L8;
                case 30: goto L8;
                case 31: goto L8;
                case 32: goto L8;
                case 33: goto L8;
                case 34: goto L8;
                case 35: goto L7;
                case 36: goto L8;
                case 37: goto L7;
                case 38: goto L8;
                case 39: goto L7;
                case 40: goto L8;
                case 41: goto L8;
                case 42: goto L8;
                default: goto L7;
            };
        L7:
            int r10 = 3;
        L9:
            Object[] r11 = new Object[r10];
            switch(r17) {
                case 1: goto L28;
                case 2: goto L27;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L24;
                case 6: goto L23;
                case 7: goto L22;
                case 8: goto L21;
                case 9: goto L20;
                case 10: goto L19;
                case 11: goto L20;
                case 12: goto L18;
                case 13: goto L20;
                case 14: goto L25;
                case 15: goto L20;
                case 16: goto L20;
                case 17: goto L17;
                case 18: goto L20;
                case 19: goto L16;
                case 20: goto L20;
                case 21: goto L16;
                case 22: goto L20;
                case 23: goto L15;
                case 24: goto L20;
                case 25: goto L14;
                case 26: goto L20;
                case 27: goto L20;
                case 28: goto L20;
                case 29: goto L20;
                case 30: goto L20;
                case 31: goto L20;
                case 32: goto L20;
                case 33: goto L20;
                case 34: goto L20;
                case 35: goto L13;
                case 36: goto L20;
                case 37: goto L11;
                case 38: goto L20;
                case 39: goto L12;
                case 40: goto L20;
                case 41: goto L20;
                case 42: goto L20;
                default: goto L11;
            };
        L11:
            r11[0] = "substitution";
        L30:
            switch(r17) {
                case 9: goto L54;
                case 10: goto L31;
                case 11: goto L53;
                case 12: goto L31;
                case 13: goto L52;
                case 14: goto L31;
                case 15: goto L51;
                case 16: goto L50;
                case 17: goto L31;
                case 18: goto L49;
                case 19: goto L31;
                case 20: goto L48;
                case 21: goto L31;
                case 22: goto L47;
                case 23: goto L31;
                case 24: goto L46;
                case 25: goto L31;
                case 26: goto L45;
                case 27: goto L44;
                case 28: goto L43;
                case 29: goto L42;
                case 30: goto L41;
                case 31: goto L40;
                case 32: goto L39;
                case 33: goto L38;
                case 34: goto L37;
                case 35: goto L31;
                case 36: goto L36;
                case 37: goto L31;
                case 38: goto L35;
                case 39: goto L31;
                case 40: goto L34;
                case 41: goto L33;
                case 42: goto L32;
                default: goto L31;
            };
        L31:
            r11[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
        L55:
            switch(r17) {
                case 8: goto L68;
                case 9: goto L69;
                case 10: goto L67;
                case 11: goto L69;
                case 12: goto L66;
                case 13: goto L69;
                case 14: goto L65;
                case 15: goto L69;
                case 16: goto L69;
                case 17: goto L64;
                case 18: goto L69;
                case 19: goto L63;
                case 20: goto L69;
                case 21: goto L62;
                case 22: goto L69;
                case 23: goto L61;
                case 24: goto L69;
                case 25: goto L60;
                case 26: goto L69;
                case 27: goto L69;
                case 28: goto L69;
                case 29: goto L69;
                case 30: goto L69;
                case 31: goto L69;
                case 32: goto L69;
                case 33: goto L69;
                case 34: goto L69;
                case 35: goto L59;
                case 36: goto L69;
                case 37: goto L58;
                case 38: goto L69;
                case 39: goto L57;
                case 40: goto L69;
                case 41: goto L69;
                case 42: goto L69;
                default: goto L56;
            };
        L56:
            r11[2] = "<init>";
            goto L69
        L57:
            r11[2] = "putUserData";
            goto L69
        L58:
            r11[2] = "setSubstitution";
            goto L69
        L59:
            r11[2] = "setAdditionalAnnotations";
            goto L69
        L60:
            r11[2] = "setContextReceiverParameters";
            goto L69
        L61:
            r11[2] = "setReturnType";
            goto L69
        L62:
            r11[2] = "setTypeParameters";
            goto L69
        L63:
            r11[2] = "setValueParameters";
            goto L69
        L64:
            r11[2] = "setName";
            goto L69
        L65:
            r11[2] = "setKind";
            goto L69
        L66:
            r11[2] = "setVisibility";
            goto L69
        L67:
            r11[2] = "setModality";
            goto L69
        L68:
            r11[2] = "setOwner";
        L69:
            String r12 = String.format(r5, r11);
            switch(r17) {
                case 9: goto L73;
                case 10: goto L74;
                case 11: goto L73;
                case 12: goto L74;
                case 13: goto L73;
                case 14: goto L74;
                case 15: goto L73;
                case 16: goto L73;
                case 17: goto L74;
                case 18: goto L73;
                case 19: goto L74;
                case 20: goto L73;
                case 21: goto L74;
                case 22: goto L73;
                case 23: goto L74;
                case 24: goto L73;
                case 25: goto L74;
                case 26: goto L73;
                case 27: goto L73;
                case 28: goto L73;
                case 29: goto L73;
                case 30: goto L73;
                case 31: goto L73;
                case 32: goto L73;
                case 33: goto L73;
                case 34: goto L73;
                case 35: goto L74;
                case 36: goto L73;
                case 37: goto L74;
                case 38: goto L73;
                case 39: goto L74;
                case 40: goto L73;
                case 41: goto L73;
                case 42: goto L73;
                default: goto L74;
            };
        L74:
            throw new IllegalArgumentException(r12);
        L73:
            throw new IllegalStateException(r12);
        L32:
            r11[1] = "setJustForTypeSubstitution";
            goto L55
        L33:
            r11[1] = "getSubstitution";
            goto L55
        L34:
            r11[1] = "putUserData";
            goto L55
        L35:
            r11[1] = "setSubstitution";
            goto L55
        L36:
            r11[1] = "setAdditionalAnnotations";
            goto L55
        L37:
            r11[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
            goto L55
        L38:
            r11[1] = "setHiddenToOvercomeSignatureClash";
            goto L55
        L39:
            r11[1] = "setDropOriginalInContainingParts";
            goto L55
        L40:
            r11[1] = "setPreserveSourceElement";
            goto L55
        L41:
            r11[1] = "setSignatureChange";
            goto L55
        L42:
            r11[1] = "setOriginal";
            goto L55
        L43:
            r11[1] = "setDispatchReceiverParameter";
            goto L55
        L44:
            r11[1] = "setExtensionReceiverParameter";
            goto L55
        L45:
            r11[1] = "setContextReceiverParameters";
            goto L55
        L46:
            r11[1] = "setReturnType";
            goto L55
        L47:
            r11[1] = "setTypeParameters";
            goto L55
        L48:
            r11[1] = "setValueParameters";
            goto L55
        L49:
            r11[1] = "setName";
            goto L55
        L50:
            r11[1] = "setCopyOverrides";
            goto L55
        L51:
            r11[1] = "setKind";
            goto L55
        L52:
            r11[1] = "setVisibility";
            goto L55
        L53:
            r11[1] = "setModality";
            goto L55
        L54:
            r11[1] = "setOwner";
            goto L55
        L12:
            r11[0] = "userDataKey";
            goto L30
        L13:
            r11[0] = "additionalAnnotations";
            goto L30
        L14:
            r11[0] = "contextReceiverParameters";
            goto L30
        L15:
            r11[0] = "type";
            goto L30
        L16:
            r11[0] = "parameters";
            goto L30
        L17:
            r11[0] = "name";
            goto L30
        L18:
            r11[0] = "visibility";
            goto L30
        L19:
            r11[0] = "modality";
            goto L30
        L20:
            r11[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
            goto L30
        L21:
            r11[0] = "owner";
            goto L30
        L22:
            r11[0] = "newReturnType";
            goto L30
        L23:
            r11[0] = "newContextReceiverParameters";
            goto L30
        L24:
            r11[0] = "newValueParameterDescriptors";
            goto L30
        L25:
            r11[0] = "kind";
            goto L30
        L26:
            r11[0] = "newVisibility";
            goto L30
        L27:
            r11[0] = "newModality";
            goto L30
        L28:
            r11[0] = "newOwner";
            goto L30
        L8:
            r10 = 2;
            goto L9
        L4:
            r5 = "@NotNull method %s.%s must not return null";
            goto L6
        }

        public CopyConfiguration(FunctionDescriptorImpl r5, TypeSubstitution r10, DeclarationDescriptor r11, Modality r12, DescriptorVisibility r13, CallableMemberDescriptor.Kind r14, List<ValueParameterDescriptor> r15, List<ReceiverParameterDescriptor> r16, ReceiverParameterDescriptor r17, KotlinType r18, Name r19) {
            if (r10 != null) goto L6;
            $$$reportNull$$$0(0);
        L6:
            if (r11 != null) goto L8;
            $$$reportNull$$$0(1);
        L8:
            if (r12 != null) goto L10;
            $$$reportNull$$$0(2);
        L10:
            if (r13 != null) goto L12;
            $$$reportNull$$$0(3);
        L12:
            if (r14 != null) goto L14;
            $$$reportNull$$$0(4);
        L14:
            if (r15 != null) goto L16;
            $$$reportNull$$$0(5);
        L16:
            if (r16 != null) goto L18;
            $$$reportNull$$$0(6);
        L18:
            if (r18 != null) goto L20;
            $$$reportNull$$$0(7);
        L20:
            this.this$0 = r5;
            this.original = null;
            this.dispatchReceiverParameter = FunctionDescriptorImpl.access$000(r5);
            this.copyOverrides = true;
            this.signatureChange = false;
            this.preserveSourceElement = false;
            this.dropOriginalInContainingParts = false;
            this.isHiddenToOvercomeSignatureClash = r5.isHiddenToOvercomeSignatureClash();
            this.newTypeParameters = null;
            this.additionalAnnotations = null;
            this.isHiddenForResolutionEverywhereBesideSupercalls = r5.isHiddenForResolutionEverywhereBesideSupercalls();
            this.userDataMap = new LinkedHashMap();
            this.newHasSynthesizedParameterNames = null;
            this.justForTypeSubstitution = false;
            this.substitution = r10;
            this.newOwner = r11;
            this.newModality = r12;
            this.newVisibility = r13;
            this.kind = r14;
            this.newValueParameterDescriptors = r15;
            this.newContextReceiverParameters = r16;
            this.newExtensionReceiverParameter = r17;
            this.newReturnType = r18;
            this.name = r19;
        }

        public static /* synthetic */ Annotations access$100(CopyConfiguration r5) {
            return r5.additionalAnnotations;
        }

        public static /* synthetic */ List access$200(CopyConfiguration r5) {
            return r5.newTypeParameters;
        }

        public static /* synthetic */ boolean access$300(CopyConfiguration r5) {
            return r5.isHiddenToOvercomeSignatureClash;
        }

        public static /* synthetic */ boolean access$400(CopyConfiguration r5) {
            return r5.isHiddenForResolutionEverywhereBesideSupercalls;
        }

        public static /* synthetic */ Boolean access$500(CopyConfiguration r5) {
            return r5.newHasSynthesizedParameterNames;
        }

        public static /* synthetic */ Map access$600(CopyConfiguration r5) {
            return r5.userDataMap;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor build() {
            return this.this$0.doSubstitute(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public <V> FunctionDescriptor.CopyBuilder<FunctionDescriptor> putUserData(CallableDescriptor.UserDataKey<V> r5, V r10) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(39);
        L4:
            this.userDataMap.put(r5, r10);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setAdditionalAnnotations(Annotations r5) {
            return setAdditionalAnnotations(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setCopyOverrides(boolean r5) {
            return setCopyOverrides(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setDispatchReceiverParameter(ReceiverParameterDescriptor r5) {
            return setDispatchReceiverParameter(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setDropOriginalInContainingParts() {
            return setDropOriginalInContainingParts();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setExtensionReceiverParameter(ReceiverParameterDescriptor r5) {
            return setExtensionReceiverParameter(r5);
        }

        public CopyConfiguration setHasSynthesizedParameterNames(boolean r5) {
            this.newHasSynthesizedParameterNames = Boolean.valueOf(r5);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setHiddenForResolutionEverywhereBesideSupercalls() {
            return setHiddenForResolutionEverywhereBesideSupercalls();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setHiddenToOvercomeSignatureClash() {
            return setHiddenToOvercomeSignatureClash();
        }

        public CopyConfiguration setJustForTypeSubstitution(boolean r5) {
            this.justForTypeSubstitution = r5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setKind(CallableMemberDescriptor.Kind r5) {
            return setKind(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setModality(Modality r5) {
            return setModality(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setName(Name r5) {
            return setName(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setOriginal(CallableMemberDescriptor r5) {
            return setOriginal(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setOwner(DeclarationDescriptor r5) {
            return setOwner(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setPreserveSourceElement() {
            return setPreserveSourceElement();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setReturnType(KotlinType r5) {
            return setReturnType(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setSignatureChange() {
            return setSignatureChange();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setSubstitution(TypeSubstitution r5) {
            return setSubstitution(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setTypeParameters(List r5) {
            return setTypeParameters(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setValueParameters(List r5) {
            return setValueParameters(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setVisibility(DescriptorVisibility r5) {
            return setVisibility(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setAdditionalAnnotations(Annotations r5) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(35);
        L4:
            this.additionalAnnotations = r5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setCopyOverrides(boolean r5) {
            this.copyOverrides = r5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setDispatchReceiverParameter(ReceiverParameterDescriptor r5) {
            this.dispatchReceiverParameter = r5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setDropOriginalInContainingParts() {
            this.dropOriginalInContainingParts = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setExtensionReceiverParameter(ReceiverParameterDescriptor r5) {
            this.newExtensionReceiverParameter = r5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setHiddenForResolutionEverywhereBesideSupercalls() {
            this.isHiddenForResolutionEverywhereBesideSupercalls = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setHiddenToOvercomeSignatureClash() {
            this.isHiddenToOvercomeSignatureClash = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setKind(CallableMemberDescriptor.Kind r5) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(14);
        L4:
            this.kind = r5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setModality(Modality r5) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(10);
        L4:
            this.newModality = r5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setName(Name r5) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(17);
        L4:
            this.name = r5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setOriginal(CallableMemberDescriptor r5) {
            this.original = (FunctionDescriptor) r5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setOwner(DeclarationDescriptor r5) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(8);
        L4:
            this.newOwner = r5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setPreserveSourceElement() {
            this.preserveSourceElement = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setReturnType(KotlinType r5) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(23);
        L4:
            this.newReturnType = r5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setSignatureChange() {
            this.signatureChange = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setSubstitution(TypeSubstitution r5) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(37);
        L4:
            this.substitution = r5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setTypeParameters(List<TypeParameterDescriptor> r5) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(21);
        L4:
            this.newTypeParameters = r5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setValueParameters(List<ValueParameterDescriptor> r5) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(19);
        L4:
            this.newValueParameterDescriptors = r5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setVisibility(DescriptorVisibility r5) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(12);
        L4:
            this.newVisibility = r5;
            return this;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        switch(r10) {
            case 9: goto L4;
            case 10: goto L3;
            case 11: goto L3;
            case 12: goto L3;
            case 13: goto L4;
            case 14: goto L4;
            case 15: goto L4;
            case 16: goto L4;
            case 17: goto L3;
            case 18: goto L4;
            case 19: goto L4;
            case 20: goto L4;
            case 21: goto L4;
            case 22: goto L3;
            case 23: goto L4;
            case 24: goto L3;
            case 25: goto L3;
            case 26: goto L4;
            case 27: goto L4;
            default: goto L3;
        };
    L3:
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r10) {
            case 9: goto L8;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L7;
            case 13: goto L8;
            case 14: goto L8;
            case 15: goto L8;
            case 16: goto L8;
            case 17: goto L7;
            case 18: goto L8;
            case 19: goto L8;
            case 20: goto L8;
            case 21: goto L8;
            case 22: goto L7;
            case 23: goto L8;
            case 24: goto L7;
            case 25: goto L7;
            case 26: goto L8;
            case 27: goto L8;
            default: goto L7;
        };
    L7:
        int r11 = 3;
    L9:
        Object[] r12 = new Object[r11];
        switch(r10) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L19;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L18;
            case 14: goto L18;
            case 15: goto L18;
            case 16: goto L18;
            case 17: goto L15;
            case 18: goto L18;
            case 19: goto L18;
            case 20: goto L18;
            case 21: goto L18;
            case 22: goto L14;
            case 23: goto L18;
            case 24: goto L13;
            case 25: goto L12;
            case 26: goto L18;
            case 27: goto L18;
            case 28: goto L20;
            case 29: goto L13;
            case 30: goto L20;
            case 31: goto L13;
            default: goto L11;
        };
    L11:
        r12[0] = "containingDeclaration";
    L28:
        switch(r10) {
            case 9: goto L41;
            case 10: goto L29;
            case 11: goto L29;
            case 12: goto L29;
            case 13: goto L40;
            case 14: goto L39;
            case 15: goto L38;
            case 16: goto L37;
            case 17: goto L29;
            case 18: goto L36;
            case 19: goto L35;
            case 20: goto L34;
            case 21: goto L33;
            case 22: goto L29;
            case 23: goto L32;
            case 24: goto L29;
            case 25: goto L29;
            case 26: goto L31;
            case 27: goto L30;
            default: goto L29;
        };
    L29:
        r12[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
    L42:
        switch(r10) {
            case 5: goto L52;
            case 6: goto L52;
            case 7: goto L52;
            case 8: goto L52;
            case 9: goto L53;
            case 10: goto L51;
            case 11: goto L50;
            case 12: goto L49;
            case 13: goto L53;
            case 14: goto L53;
            case 15: goto L53;
            case 16: goto L53;
            case 17: goto L48;
            case 18: goto L53;
            case 19: goto L53;
            case 20: goto L53;
            case 21: goto L53;
            case 22: goto L47;
            case 23: goto L53;
            case 24: goto L46;
            case 25: goto L45;
            case 26: goto L53;
            case 27: goto L53;
            case 28: goto L44;
            case 29: goto L44;
            case 30: goto L44;
            case 31: goto L44;
            default: goto L43;
        };
    L43:
        r12[2] = "<init>";
        goto L53
    L44:
        r12[2] = "getSubstitutedValueParameters";
        goto L53
    L45:
        r12[2] = "doSubstitute";
        goto L53
    L46:
        r12[2] = "newCopyBuilder";
        goto L53
    L47:
        r12[2] = "substitute";
        goto L53
    L48:
        r12[2] = "setOverriddenDescriptors";
        goto L53
    L49:
        r12[2] = "setExtensionReceiverParameter";
        goto L53
    L50:
        r12[2] = "setReturnType";
        goto L53
    L51:
        r12[2] = "setVisibility";
        goto L53
    L52:
        r12[2] = "initialize";
    L53:
        String r13 = String.format(r5, r12);
        switch(r10) {
            case 9: goto L57;
            case 10: goto L58;
            case 11: goto L58;
            case 12: goto L58;
            case 13: goto L57;
            case 14: goto L57;
            case 15: goto L57;
            case 16: goto L57;
            case 17: goto L58;
            case 18: goto L57;
            case 19: goto L57;
            case 20: goto L57;
            case 21: goto L57;
            case 22: goto L58;
            case 23: goto L57;
            case 24: goto L58;
            case 25: goto L58;
            case 26: goto L57;
            case 27: goto L57;
            default: goto L58;
        };
    L58:
        throw new IllegalArgumentException(r13);
    L57:
        throw new IllegalStateException(r13);
    L30:
        r12[1] = "getSourceToUseForCopy";
        goto L42
    L31:
        r12[1] = "copy";
        goto L42
    L32:
        r12[1] = "newCopyBuilder";
        goto L42
    L33:
        r12[1] = "getKind";
        goto L42
    L34:
        r12[1] = "getOriginal";
        goto L42
    L35:
        r12[1] = "getValueParameters";
        goto L42
    L36:
        r12[1] = "getTypeParameters";
        goto L42
    L37:
        r12[1] = "getVisibility";
        goto L42
    L38:
        r12[1] = "getModality";
        goto L42
    L39:
        r12[1] = "getOverriddenDescriptors";
        goto L42
    L40:
        r12[1] = "getContextReceiverParameters";
        goto L42
    L41:
        r12[1] = "initialize";
        goto L42
    L12:
        r12[0] = "configuration";
        goto L28
    L13:
        r12[0] = "substitutor";
        goto L28
    L14:
        r12[0] = "originalSubstitutor";
        goto L28
    L15:
        r12[0] = "overriddenDescriptors";
        goto L28
    L16:
        r12[0] = "extensionReceiverParameter";
        goto L28
    L17:
        r12[0] = "unsubstitutedReturnType";
        goto L28
    L18:
        r12[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
        goto L28
    L19:
        r12[0] = "visibility";
        goto L28
    L20:
        r12[0] = "unsubstitutedValueParameters";
        goto L28
    L21:
        r12[0] = "typeParameters";
        goto L28
    L22:
        r12[0] = "contextReceiverParameters";
        goto L28
    L23:
        r12[0] = "source";
        goto L28
    L24:
        r12[0] = "kind";
        goto L28
    L25:
        r12[0] = "name";
        goto L28
    L26:
        r12[0] = "annotations";
        goto L28
    L8:
        r11 = 2;
        goto L9
    L4:
        r5 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    public FunctionDescriptorImpl(DeclarationDescriptor r5, FunctionDescriptor r10, Annotations r11, Name r12, CallableMemberDescriptor.Kind r13, SourceElement r14) {
        if (r5 != null) goto L6;
        $$$reportNull$$$0(0);
    L6:
        if (r11 != null) goto L8;
        $$$reportNull$$$0(1);
    L8:
        if (r12 != null) goto L10;
        $$$reportNull$$$0(2);
    L10:
        if (r13 != null) goto L12;
        $$$reportNull$$$0(3);
    L12:
        if (r14 != null) goto L14;
        $$$reportNull$$$0(4);
    L14:
        super(r5, r11, r12, r14);
        this.visibility = DescriptorVisibilities.UNKNOWN;
        this.isOperator = false;
        this.isInfix = false;
        this.isExternal = false;
        this.isInline = false;
        this.isTailrec = false;
        this.isExpect = false;
        this.isActual = false;
        this.isHiddenToOvercomeSignatureClash = false;
        this.isHiddenForResolutionEverywhereBesideSupercalls = false;
        this.isSuspend = false;
        this.hasStableParameterNames = true;
        this.hasSynthesizedParameterNames = false;
        this.overriddenFunctions = null;
        this.lazyOverriddenFunctionsTask = null;
        this.initialSignatureDescriptor = null;
        this.userDataMap = null;
        if (r10 != null) goto L17;
        r10 = this;
    L17:
        this.original = r10;
        this.kind = r13;
    }

    public static /* synthetic */ ReceiverParameterDescriptor access$000(FunctionDescriptorImpl r5) {
        return r5.dispatchReceiverParameter;
    }

    private SourceElement getSourceToUseForCopy(boolean r5, FunctionDescriptor r10) {
        if (r5 == false) goto L7;
        if (r10 != null) goto L6;
        r10 = getOriginal();
    L6:
        SourceElement r11 = r10.getSource();
    L8:
        if (r11 != null) goto L10;
        $$$reportNull$$$0(27);
    L10:
        return r11;
    L7:
        r11 = SourceElement.NO_SOURCE;
        goto L8
    }

    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor r10, List<ValueParameterDescriptor> r11, TypeSubstitutor r12) {
        if (r11 != null) goto L4;
        $$$reportNull$$$0(28);
    L4:
        if (r12 != null) goto L7;
        $$$reportNull$$$0(29);
    L7:
        return getSubstitutedValueParameters(r10, r11, r12, false, false, null);
    }

    private void performOverriddenLazyCalculationIfNeeded() {
        Function0<Collection<FunctionDescriptor>> r5 = this.lazyOverriddenFunctionsTask;
        if (r5 == null) goto L6;
        this.overriddenFunctions = r5.invoke();
        this.lazyOverriddenFunctionsTask = null;
        return;
    }

    private void setHiddenForResolutionEverywhereBesideSupercalls(boolean r5) {
        this.isHiddenForResolutionEverywhereBesideSupercalls = r5;
    }

    private void setHiddenToOvercomeSignatureClash(boolean r5) {
        this.isHiddenToOvercomeSignatureClash = r5;
    }

    private void setInitialSignatureDescriptor(FunctionDescriptor r5) {
        this.initialSignatureDescriptor = r5;
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r5, D r10) {
        return r5.visitFunctionDescriptor(this, r10);
    }

    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor r5, Modality r10, DescriptorVisibility r11, CallableMemberDescriptor.Kind r12, boolean r13) {
        return copy(r5, r10, r11, r12, r13);
    }

    public abstract FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r5, FunctionDescriptor r10, CallableMemberDescriptor.Kind r11, Name r12, Annotations r13, SourceElement r14);

    public FunctionDescriptor doSubstitute(CopyConfiguration r21) {
        if (r21 != null) goto L5;
        $$$reportNull$$$0(25);
    L5:
        boolean[] r10 = new boolean[1];
        if (CopyConfiguration.access$100(r21) == null) goto L9;
        Annotations r5 = AnnotationsKt.composeAnnotations(getAnnotations(), CopyConfiguration.access$100(r21));
    L8:
        Annotations r11 = r5;
        DeclarationDescriptor r12 = r21.newOwner;
        FunctionDescriptor r13 = r21.original;
        FunctionDescriptorImpl r14 = createSubstitutedCopy(r12, r13, r21.kind, r21.name, r11, getSourceToUseForCopy(r21.preserveSourceElement, r13));
        if (CopyConfiguration.access$200(r21) != null) goto L13;
        List<TypeParameterDescriptor> r15 = getTypeParameters();
    L14:
        r10[0] = r10[0] | (!r15.isEmpty());
        ArrayList r16 = new ArrayList(r15.size());
        final TypeSubstitutor r17 = DescriptorSubstitutor.substituteTypeParameters(r15, r21.substitution, r14, r16, r10);
        if (r17 != null) goto L17;
        return null;
    L17:
        ArrayList r18 = new ArrayList();
        if (r21.newContextReceiverParameters.isEmpty() == true) goto L30;
        Iterator<ReceiverParameterDescriptor> r19 = r21.newContextReceiverParameters.iterator();
        int r20 = 0;
    L21:
        if (r19.hasNext() == false) goto L30;
        ReceiverParameterDescriptor r22 = r19.next();
        KotlinType r23 = r17.substitute(r22.getType(), Variance.IN_VARIANCE);
        if (r23 == null) goto L24;
        int r110 = r20 + 1;
        r18.add(DescriptorFactory.createContextReceiverParameterForCallable(r14, r23, ((ImplicitContextReceiver) r22.getValue()).getCustomLabelName(), r22.getAnnotations(), r20));
        boolean r24 = r10[0];
        if (r23 == r22.getType()) goto L28;
        boolean r25 = true;
    L29:
        r10[0] = r24 | r25;
        r20 = r110;
        goto L21
    L28:
        r25 = false;
        goto L29
    L24:
        return null;
    L30:
        ReceiverParameterDescriptor r26 = r21.newExtensionReceiverParameter;
        if (r26 == null) goto L40;
        KotlinType r27 = r17.substitute(r26.getType(), Variance.IN_VARIANCE);
        if (r27 != null) goto L35;
        return null;
    L35:
        ReceiverParameterDescriptorImpl r28 = new ReceiverParameterDescriptorImpl(r14, new ExtensionReceiver(r14, r27, r21.newExtensionReceiverParameter.getValue()), r21.newExtensionReceiverParameter.getAnnotations());
        boolean r29 = r10[0];
        if (r27 == r21.newExtensionReceiverParameter.getType()) goto L38;
        boolean r30 = true;
    L39:
        r10[0] = r30 | r29;
        ReceiverParameterDescriptorImpl r111 = r28;
    L41:
        ReceiverParameterDescriptor r31 = r21.dispatchReceiverParameter;
        if (r31 == null) goto L51;
        ReceiverParameterDescriptor r32 = r31.substitute(r17);
        if (r32 != null) goto L46;
        return null;
    L46:
        boolean r33 = r10[0];
        if (r32 == r21.dispatchReceiverParameter) goto L49;
        boolean r34 = true;
    L50:
        r10[0] = r33 | r34;
        ReceiverParameterDescriptor r112 = r32;
    L52:
        List<ValueParameterDescriptor> r35 = getSubstitutedValueParameters(r14, r21.newValueParameterDescriptors, r17, r21.dropOriginalInContainingParts, r21.preserveSourceElement, r10);
        if (r35 != null) goto L55;
        return null;
    L55:
        KotlinType r36 = r17.substitute(r21.newReturnType, Variance.OUT_VARIANCE);
        if (r36 != null) goto L58;
        return null;
    L58:
        boolean r37 = r10[0];
        if (r36 == r21.newReturnType) goto L61;
        boolean r38 = true;
    L62:
        boolean r39 = r37 | r38;
        r10[0] = r39;
        if (r39 == false) goto L65;
    L67:
        r14.initialize(r111, r112, r18, r16, r35, r36, r21.newModality, r21.newVisibility);
        r14.setOperator(this.isOperator);
        r14.setInfix(this.isInfix);
        r14.setExternal(this.isExternal);
        r14.setInline(this.isInline);
        r14.setTailrec(this.isTailrec);
        r14.setSuspend(this.isSuspend);
        r14.setExpect(this.isExpect);
        r14.setActual(this.isActual);
        r14.setHasStableParameterNames(this.hasStableParameterNames);
        r14.setHiddenToOvercomeSignatureClash(CopyConfiguration.access$300(r21));
        r14.setHiddenForResolutionEverywhereBesideSupercalls(CopyConfiguration.access$400(r21));
        if (CopyConfiguration.access$500(r21) == null) goto L70;
        boolean r40 = CopyConfiguration.access$500(r21).booleanValue();
    L71:
        r14.setHasSynthesizedParameterNames(r40);
        if (CopyConfiguration.access$600(r21).isEmpty() == true) goto L74;
    L75:
        Map<CallableDescriptor.UserDataKey<?>, Object> r41 = CopyConfiguration.access$600(r21);
        Map<CallableDescriptor.UserDataKey<?>, Object> r42 = this.userDataMap;
        if (r42 == null) goto L84;
        Iterator<Map.Entry<CallableDescriptor.UserDataKey<?>, Object>> r43 = r42.entrySet().iterator();
    L79:
        if (r43.hasNext() == false) goto L84;
        Map.Entry<CallableDescriptor.UserDataKey<?>, Object> r44 = r43.next();
        if (r41.containsKey(r44.getKey()) == true) goto L79;
        r41.put(r44.getKey(), r44.getValue());
    L84:
        if (r41.size() != 1) goto L86;
        r14.userDataMap = Collections.singletonMap(r41.keySet().iterator().next(), r41.values().iterator().next());
    L88:
        if (r21.signatureChange == true) goto L92;
        if (getInitialSignatureDescriptor() != null) goto L92;
    L97:
        if (r21.copyOverrides == true) goto L99;
    L107:
        return r14;
    L99:
        if (getOriginal().getOverriddenDescriptors().isEmpty() == true) goto L107;
        if (r21.substitution.isEmpty() == false) goto L106;
        Function0<Collection<FunctionDescriptor>> r45 = this.lazyOverriddenFunctionsTask;
        if (r45 == null) goto L105;
        r14.lazyOverriddenFunctionsTask = r45;
        goto L107
    L105:
        r14.setOverriddenDescriptors(getOverriddenDescriptors());
        goto L107
    L106:
        r14.lazyOverriddenFunctionsTask = new AnonymousClass1(this, r17);
    L92:
        if (getInitialSignatureDescriptor() == null) goto L94;
        FunctionDescriptor r46 = getInitialSignatureDescriptor();
    L95:
        r14.setInitialSignatureDescriptor(r46.substitute(r17));
        goto L97
    L94:
        r46 = this;
        goto L95
    L86:
        r14.userDataMap = r41;
        goto L88
    L74:
        if (this.userDataMap == null) goto L88;
    L70:
        r40 = this.hasSynthesizedParameterNames;
        goto L71
    L65:
        if (r21.justForTypeSubstitution == false) goto L67;
        return this;
    L61:
        r38 = false;
        goto L62
    L49:
        r34 = false;
        goto L50
    L51:
        r112 = null;
        goto L52
    L38:
        r30 = false;
        goto L39
    L40:
        r111 = null;
        goto L41
    L13:
        r15 = CopyConfiguration.access$200(r21);
        goto L14
    L9:
        r5 = getAnnotations();
        goto L8
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> r5 = this.contextReceiverParameters;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(13);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.dispatchReceiverParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.extensionReceiverParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.initialSignatureDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind r5 = this.kind;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(21);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        Modality r5 = this.modality;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(15);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        performOverriddenLazyCalculationIfNeeded();
        Collection<? extends FunctionDescriptor> r5 = this.overriddenFunctions;
        if (r5 != null) goto L6;
        r5 = Collections.emptyList();
    L6:
        if (r5 != null) goto L8;
        $$$reportNull$$$0(14);
    L8:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public KotlinType getReturnType() {
        return this.unsubstitutedReturnType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> r5 = this.typeParameters;
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> r5) {
        Map<CallableDescriptor.UserDataKey<?>, Object> r10 = this.userDataMap;
        if (r10 != null) goto L7;
        return null;
    L7:
        return (V) r10.get(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> r5 = this.unsubstitutedValueParameters;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(19);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility r5 = this.visibility;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(16);
    L5:
        return r5;
    }

    public boolean hasStableParameterNames() {
        return this.hasStableParameterNames;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.hasSynthesizedParameterNames;
    }

    public FunctionDescriptorImpl initialize(ReceiverParameterDescriptor r5, ReceiverParameterDescriptor r10, List<ReceiverParameterDescriptor> r11, List<? extends TypeParameterDescriptor> r12, List<ValueParameterDescriptor> r13, KotlinType r14, Modality r15, DescriptorVisibility r16) {
        if (r11 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        if (r12 != null) goto L6;
        $$$reportNull$$$0(6);
    L6:
        if (r13 != null) goto L8;
        $$$reportNull$$$0(7);
    L8:
        if (r16 != null) goto L10;
        $$$reportNull$$$0(8);
    L10:
        this.typeParameters = CollectionsKt.toList(r12);
        this.unsubstitutedValueParameters = CollectionsKt.toList(r13);
        this.unsubstitutedReturnType = r14;
        this.modality = r15;
        this.visibility = r16;
        this.extensionReceiverParameter = r5;
        this.dispatchReceiverParameter = r10;
        this.contextReceiverParameters = r11;
        int r17 = 0;
        int r18 = 0;
    L12:
        if (r18 >= r12.size()) goto L19;
        TypeParameterDescriptor r19 = r12.get(r18);
        if (r19.getIndex() != r18) goto L17;
        r18 = r18 + 1;
        goto L12
    L17:
        throw new IllegalStateException(r19 + " index is " + r19.getIndex() + " but position is " + r18);
    L19:
        if (r17 >= r13.size()) goto L25;
        ValueParameterDescriptor r20 = r13.get(r17);
        if (r20.getIndex() != r17) goto L24;
        r17 = r17 + 1;
        goto L19
    L24:
        throw new IllegalStateException(r20 + "index is " + r20.getIndex() + " but position is " + r17);
    L25:
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.isActual;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.isExpect;
    }

    public boolean isExternal() {
        return this.isExternal;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return this.isHiddenForResolutionEverywhereBesideSupercalls;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenToOvercomeSignatureClash() {
        return this.isHiddenToOvercomeSignatureClash;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInfix() {
        if (this.isInfix == false) goto L5;
        return true;
    L5:
        Iterator<? extends FunctionDescriptor> r5 = getOriginal().getOverriddenDescriptors().iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        if (r5.next().isInfix() == false) goto L7;
        return true;
    L11:
        return false;
    }

    public boolean isInline() {
        return this.isInline;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isOperator() {
        if (this.isOperator == false) goto L5;
        return true;
    L5:
        Iterator<? extends FunctionDescriptor> r5 = getOriginal().getOverriddenDescriptors().iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        if (r5.next().isOperator() == false) goto L7;
        return true;
    L11:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isSuspend() {
        return this.isSuspend;
    }

    public boolean isTailrec() {
        return this.isTailrec;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder() {
        CopyConfiguration r5 = newCopyBuilder(TypeSubstitutor.EMPTY);
        if (r5 != null) goto L5;
        $$$reportNull$$$0(23);
    L5:
        return r5;
    }

    public <V> void putInUserDataMap(CallableDescriptor.UserDataKey<V> r5, Object r10) {
        if (this.userDataMap != null) goto L5;
        this.userDataMap = new LinkedHashMap();
    L5:
        this.userDataMap.put(r5, r10);
    }

    public void setActual(boolean r5) {
        this.isActual = r5;
    }

    public void setExpect(boolean r5) {
        this.isExpect = r5;
    }

    public void setExternal(boolean r5) {
        this.isExternal = r5;
    }

    public void setHasStableParameterNames(boolean r5) {
        this.hasStableParameterNames = r5;
    }

    public void setHasSynthesizedParameterNames(boolean r5) {
        this.hasSynthesizedParameterNames = r5;
    }

    public void setInfix(boolean r5) {
        this.isInfix = r5;
    }

    public void setInline(boolean r5) {
        this.isInline = r5;
    }

    public void setOperator(boolean r5) {
        this.isOperator = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> r5) {
        if (r5 != 0) goto L4;
        $$$reportNull$$$0(17);
    L4:
        this.overriddenFunctions = r5;
        Iterator r10 = r5.iterator();
    L6:
        if (r10.hasNext() == false) goto L14;
        if (((FunctionDescriptor) r10.next()).isHiddenForResolutionEverywhereBesideSupercalls() == false) goto L6;
        this.isHiddenForResolutionEverywhereBesideSupercalls = true;
        return;
    }

    public void setReturnType(KotlinType r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(11);
    L4:
        this.unsubstitutedReturnType = r5;
    }

    public void setSuspend(boolean r5) {
        this.isSuspend = r5;
    }

    public void setTailrec(boolean r5) {
        this.isTailrec = r5;
    }

    public void setVisibility(DescriptorVisibility r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(10);
    L4:
        this.visibility = r5;
    }

    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r5) {
        return substitute(r5);
    }

    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor r18, List<ValueParameterDescriptor> r19, TypeSubstitutor r20, boolean r21, boolean r22, boolean[] r23) {
        if (r19 != null) goto L5;
        $$$reportNull$$$0(30);
    L5:
        if (r20 != null) goto L7;
        $$$reportNull$$$0(31);
    L7:
        ArrayList r5 = new ArrayList(r19.size());
        Iterator<ValueParameterDescriptor> r10 = r19.iterator();
    L9:
        if (r10.hasNext() == false) goto L34;
        ValueParameterDescriptor r11 = r10.next();
        KotlinType r12 = r11.getType();
        Variance r13 = Variance.IN_VARIANCE;
        KotlinType r14 = r20.substitute(r12, r13);
        KotlinType r15 = r11.getVarargElementType();
        if (r15 != null) goto L13;
        KotlinType r16 = null;
    L14:
        if (r14 == null) goto L15;
        if (r14 != r11.getType()) goto L19;
        if (r15 != r16) goto L19;
    L22:
        if ((r11 instanceof ValueParameterDescriptorImpl.WithDestructuringDeclaration) == false) goto L24;
        final List<VariableDescriptor> r17 = ((ValueParameterDescriptorImpl.WithDestructuringDeclaration) r11).getDestructuringVariables();
        Function0<List<VariableDescriptor>> r110 = new AnonymousClass2(r17);
    L25:
        if (r21 == false) goto L27;
        ValueParameterDescriptor r24 = null;
    L28:
        int r25 = r11.getIndex();
        Annotations r26 = r11.getAnnotations();
        Name r111 = r11.getName();
        boolean r112 = r11.declaresDefaultValue();
        boolean r113 = r11.isCrossinline();
        boolean r114 = r11.isNoinline();
        if (r22 == false) goto L32;
        SourceElement r27 = r11.getSource();
    L33:
        r5.add(ValueParameterDescriptorImpl.createWithDestructuringDeclarations(r18, r24, r25, r26, r111, r14, r112, r113, r114, r16, r27, r110));
        goto L9
    L32:
        r27 = SourceElement.NO_SOURCE;
        goto L33
    L27:
        r24 = r11;
        goto L28
    L24:
        r110 = null;
    L19:
        if (r23 == null) goto L22;
        r23[0] = true;
        goto L22
    L15:
        return null;
    L13:
        r16 = r20.substitute(r15, r13);
        goto L14
    L34:
        return r5;
    }

    public FunctionDescriptor copy(DeclarationDescriptor r5, Modality r10, DescriptorVisibility r11, CallableMemberDescriptor.Kind r12, boolean r13) {
        FunctionDescriptor r14 = newCopyBuilder().setOwner(r5).setModality(r10).setVisibility(r11).setKind(r12).setCopyOverrides(r13).build();
        if (r14 != null) goto L5;
        $$$reportNull$$$0(26);
    L5:
        return r14;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
        return getOriginal();
    }

    public CopyConfiguration newCopyBuilder(TypeSubstitutor r14) {
        if (r14 != null) goto L5;
        $$$reportNull$$$0(24);
    L5:
        return new CopyConfiguration(this, r14.getSubstitution(), getContainingDeclaration(), getModality(), getVisibility(), getKind(), getValueParameters(), getContextReceiverParameters(), getExtensionReceiverParameter(), getReturnType(), null);
    }

    public FunctionDescriptor substitute(TypeSubstitutor r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(22);
    L5:
        if (r5.isEmpty() == false) goto L8;
        return this;
    L8:
        return newCopyBuilder(r5).setOriginal(getOriginal()).setPreserveSourceElement().setJustForTypeSubstitution(true).build();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public FunctionDescriptor getOriginal() {
        FunctionDescriptor r5 = this.original;
        ?? r10 = this;
        if (r5 == this) goto L6;
        r10 = r5.getOriginal();
    L6:
        if (r10 != 0) goto L8;
        $$$reportNull$$$0(20);
    L8:
        return r10;
    }
}

package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
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
            String r10 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
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
            int r11 = 3;
        L9:
            Object[] r12 = new Object[r11];
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
            r12[0] = "substitution";
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
            r12[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
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
            r12[2] = "<init>";
            goto L69
        L57:
            r12[2] = "putUserData";
            goto L69
        L58:
            r12[2] = "setSubstitution";
            goto L69
        L59:
            r12[2] = "setAdditionalAnnotations";
            goto L69
        L60:
            r12[2] = "setContextReceiverParameters";
            goto L69
        L61:
            r12[2] = "setReturnType";
            goto L69
        L62:
            r12[2] = "setTypeParameters";
            goto L69
        L63:
            r12[2] = "setValueParameters";
            goto L69
        L64:
            r12[2] = "setName";
            goto L69
        L65:
            r12[2] = "setKind";
            goto L69
        L66:
            r12[2] = "setVisibility";
            goto L69
        L67:
            r12[2] = "setModality";
            goto L69
        L68:
            r12[2] = "setOwner";
        L69:
            String r13 = String.format(r10, r12);
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
            throw new IllegalArgumentException(r13);
        L73:
            throw new IllegalStateException(r13);
        L32:
            r12[1] = "setJustForTypeSubstitution";
            goto L55
        L33:
            r12[1] = "getSubstitution";
            goto L55
        L34:
            r12[1] = "putUserData";
            goto L55
        L35:
            r12[1] = "setSubstitution";
            goto L55
        L36:
            r12[1] = "setAdditionalAnnotations";
            goto L55
        L37:
            r12[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
            goto L55
        L38:
            r12[1] = "setHiddenToOvercomeSignatureClash";
            goto L55
        L39:
            r12[1] = "setDropOriginalInContainingParts";
            goto L55
        L40:
            r12[1] = "setPreserveSourceElement";
            goto L55
        L41:
            r12[1] = "setSignatureChange";
            goto L55
        L42:
            r12[1] = "setOriginal";
            goto L55
        L43:
            r12[1] = "setDispatchReceiverParameter";
            goto L55
        L44:
            r12[1] = "setExtensionReceiverParameter";
            goto L55
        L45:
            r12[1] = "setContextReceiverParameters";
            goto L55
        L46:
            r12[1] = "setReturnType";
            goto L55
        L47:
            r12[1] = "setTypeParameters";
            goto L55
        L48:
            r12[1] = "setValueParameters";
            goto L55
        L49:
            r12[1] = "setName";
            goto L55
        L50:
            r12[1] = "setCopyOverrides";
            goto L55
        L51:
            r12[1] = "setKind";
            goto L55
        L52:
            r12[1] = "setVisibility";
            goto L55
        L53:
            r12[1] = "setModality";
            goto L55
        L54:
            r12[1] = "setOwner";
            goto L55
        L12:
            r12[0] = "userDataKey";
            goto L30
        L13:
            r12[0] = "additionalAnnotations";
            goto L30
        L14:
            r12[0] = "contextReceiverParameters";
            goto L30
        L15:
            r12[0] = WsConstants.KEY_CONNECTION_TYPE;
            goto L30
        L16:
            r12[0] = "parameters";
            goto L30
        L17:
            r12[0] = ActivityLifecycle.NAME;
            goto L30
        L18:
            r12[0] = "visibility";
            goto L30
        L19:
            r12[0] = "modality";
            goto L30
        L20:
            r12[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
            goto L30
        L21:
            r12[0] = "owner";
            goto L30
        L22:
            r12[0] = "newReturnType";
            goto L30
        L23:
            r12[0] = "newContextReceiverParameters";
            goto L30
        L24:
            r12[0] = "newValueParameterDescriptors";
            goto L30
        L25:
            r12[0] = "kind";
            goto L30
        L26:
            r12[0] = "newVisibility";
            goto L30
        L27:
            r12[0] = "newModality";
            goto L30
        L28:
            r12[0] = "newOwner";
            goto L30
        L8:
            r11 = 2;
            goto L9
        L4:
            r10 = "@NotNull method %s.%s must not return null";
            goto L6
        }

        public CopyConfiguration(FunctionDescriptorImpl r10, TypeSubstitution r11, DeclarationDescriptor r12, Modality r13, DescriptorVisibility r14, CallableMemberDescriptor.Kind r15, List<ValueParameterDescriptor> r16, List<ReceiverParameterDescriptor> r17, ReceiverParameterDescriptor r18, KotlinType r19, Name r110) {
            if (r11 != null) goto L6;
            $$$reportNull$$$0(0);
        L6:
            if (r12 != null) goto L8;
            $$$reportNull$$$0(1);
        L8:
            if (r13 != null) goto L10;
            $$$reportNull$$$0(2);
        L10:
            if (r14 != null) goto L12;
            $$$reportNull$$$0(3);
        L12:
            if (r15 != null) goto L14;
            $$$reportNull$$$0(4);
        L14:
            if (r16 != null) goto L16;
            $$$reportNull$$$0(5);
        L16:
            if (r17 != null) goto L18;
            $$$reportNull$$$0(6);
        L18:
            if (r19 != null) goto L20;
            $$$reportNull$$$0(7);
        L20:
            this.this$0 = r10;
            this.original = null;
            this.dispatchReceiverParameter = FunctionDescriptorImpl.access$000(r10);
            this.copyOverrides = true;
            this.signatureChange = false;
            this.preserveSourceElement = false;
            this.dropOriginalInContainingParts = false;
            this.isHiddenToOvercomeSignatureClash = r10.isHiddenToOvercomeSignatureClash();
            this.newTypeParameters = null;
            this.additionalAnnotations = null;
            this.isHiddenForResolutionEverywhereBesideSupercalls = r10.isHiddenForResolutionEverywhereBesideSupercalls();
            this.userDataMap = new LinkedHashMap();
            this.newHasSynthesizedParameterNames = null;
            this.justForTypeSubstitution = false;
            this.substitution = r11;
            this.newOwner = r12;
            this.newModality = r13;
            this.newVisibility = r14;
            this.kind = r15;
            this.newValueParameterDescriptors = r16;
            this.newContextReceiverParameters = r17;
            this.newExtensionReceiverParameter = r18;
            this.newReturnType = r19;
            this.name = r110;
        }

        static /* synthetic */ Annotations access$100(CopyConfiguration r10) {
            return r10.additionalAnnotations;
        }

        static /* synthetic */ List access$200(CopyConfiguration r10) {
            return r10.newTypeParameters;
        }

        static /* synthetic */ boolean access$300(CopyConfiguration r10) {
            return r10.isHiddenToOvercomeSignatureClash;
        }

        static /* synthetic */ boolean access$400(CopyConfiguration r10) {
            return r10.isHiddenForResolutionEverywhereBesideSupercalls;
        }

        static /* synthetic */ Boolean access$500(CopyConfiguration r10) {
            return r10.newHasSynthesizedParameterNames;
        }

        static /* synthetic */ Map access$600(CopyConfiguration r10) {
            return r10.userDataMap;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor build() {
            return this.this$0.doSubstitute(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public <V> FunctionDescriptor.CopyBuilder<FunctionDescriptor> putUserData(CallableDescriptor.UserDataKey<V> r10, V r11) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(39);
        L4:
            this.userDataMap.put(r10, r11);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setAdditionalAnnotations(Annotations r10) {
            return setAdditionalAnnotations(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setAdditionalAnnotations(Annotations r10) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(35);
        L4:
            this.additionalAnnotations = r10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setCopyOverrides(boolean r10) {
            return setCopyOverrides(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setCopyOverrides(boolean r10) {
            this.copyOverrides = r10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setDispatchReceiverParameter(ReceiverParameterDescriptor r10) {
            return setDispatchReceiverParameter(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setDispatchReceiverParameter(ReceiverParameterDescriptor r10) {
            this.dispatchReceiverParameter = r10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setDropOriginalInContainingParts() {
            return setDropOriginalInContainingParts();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setDropOriginalInContainingParts() {
            this.dropOriginalInContainingParts = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setExtensionReceiverParameter(ReceiverParameterDescriptor r10) {
            return setExtensionReceiverParameter(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setExtensionReceiverParameter(ReceiverParameterDescriptor r10) {
            this.newExtensionReceiverParameter = r10;
            return this;
        }

        public CopyConfiguration setHasSynthesizedParameterNames(boolean r10) {
            this.newHasSynthesizedParameterNames = Boolean.valueOf(r10);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setHiddenForResolutionEverywhereBesideSupercalls() {
            return setHiddenForResolutionEverywhereBesideSupercalls();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setHiddenForResolutionEverywhereBesideSupercalls() {
            this.isHiddenForResolutionEverywhereBesideSupercalls = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setHiddenToOvercomeSignatureClash() {
            return setHiddenToOvercomeSignatureClash();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setHiddenToOvercomeSignatureClash() {
            this.isHiddenToOvercomeSignatureClash = true;
            return this;
        }

        public CopyConfiguration setJustForTypeSubstitution(boolean r10) {
            this.justForTypeSubstitution = r10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setKind(CallableMemberDescriptor.Kind r10) {
            return setKind(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setKind(CallableMemberDescriptor.Kind r10) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(14);
        L4:
            this.kind = r10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setModality(Modality r10) {
            return setModality(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setModality(Modality r10) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(10);
        L4:
            this.newModality = r10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setName(Name r10) {
            return setName(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setName(Name r10) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(17);
        L4:
            this.name = r10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setOriginal(CallableMemberDescriptor r10) {
            return setOriginal(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setOriginal(CallableMemberDescriptor r10) {
            this.original = (FunctionDescriptor) r10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setOwner(DeclarationDescriptor r10) {
            return setOwner(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setOwner(DeclarationDescriptor r10) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(8);
        L4:
            this.newOwner = r10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setPreserveSourceElement() {
            return setPreserveSourceElement();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setPreserveSourceElement() {
            this.preserveSourceElement = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setReturnType(KotlinType r10) {
            return setReturnType(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setReturnType(KotlinType r10) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(23);
        L4:
            this.newReturnType = r10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setSignatureChange() {
            return setSignatureChange();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setSignatureChange() {
            this.signatureChange = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setSubstitution(TypeSubstitution r10) {
            return setSubstitution(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setSubstitution(TypeSubstitution r10) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(37);
        L4:
            this.substitution = r10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setTypeParameters(List r10) {
            return setTypeParameters(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setTypeParameters(List<TypeParameterDescriptor> r10) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(21);
        L4:
            this.newTypeParameters = r10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setValueParameters(List r10) {
            return setValueParameters(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setValueParameters(List<ValueParameterDescriptor> r10) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(19);
        L4:
            this.newValueParameterDescriptors = r10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setVisibility(DescriptorVisibility r10) {
            return setVisibility(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setVisibility(DescriptorVisibility r10) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(12);
        L4:
            this.newVisibility = r10;
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
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
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
        int r12 = 3;
    L9:
        Object[] r13 = new Object[r12];
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
        r13[0] = "containingDeclaration";
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
        r13[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
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
        r13[2] = "<init>";
        goto L53
    L44:
        r13[2] = "getSubstitutedValueParameters";
        goto L53
    L45:
        r13[2] = "doSubstitute";
        goto L53
    L46:
        r13[2] = "newCopyBuilder";
        goto L53
    L47:
        r13[2] = "substitute";
        goto L53
    L48:
        r13[2] = "setOverriddenDescriptors";
        goto L53
    L49:
        r13[2] = "setExtensionReceiverParameter";
        goto L53
    L50:
        r13[2] = "setReturnType";
        goto L53
    L51:
        r13[2] = "setVisibility";
        goto L53
    L52:
        r13[2] = "initialize";
    L53:
        String r14 = String.format(r11, r13);
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
        throw new IllegalArgumentException(r14);
    L57:
        throw new IllegalStateException(r14);
    L30:
        r13[1] = "getSourceToUseForCopy";
        goto L42
    L31:
        r13[1] = "copy";
        goto L42
    L32:
        r13[1] = "newCopyBuilder";
        goto L42
    L33:
        r13[1] = "getKind";
        goto L42
    L34:
        r13[1] = "getOriginal";
        goto L42
    L35:
        r13[1] = "getValueParameters";
        goto L42
    L36:
        r13[1] = "getTypeParameters";
        goto L42
    L37:
        r13[1] = "getVisibility";
        goto L42
    L38:
        r13[1] = "getModality";
        goto L42
    L39:
        r13[1] = "getOverriddenDescriptors";
        goto L42
    L40:
        r13[1] = "getContextReceiverParameters";
        goto L42
    L41:
        r13[1] = "initialize";
        goto L42
    L12:
        r13[0] = "configuration";
        goto L28
    L13:
        r13[0] = "substitutor";
        goto L28
    L14:
        r13[0] = "originalSubstitutor";
        goto L28
    L15:
        r13[0] = "overriddenDescriptors";
        goto L28
    L16:
        r13[0] = "extensionReceiverParameter";
        goto L28
    L17:
        r13[0] = "unsubstitutedReturnType";
        goto L28
    L18:
        r13[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
        goto L28
    L19:
        r13[0] = "visibility";
        goto L28
    L20:
        r13[0] = "unsubstitutedValueParameters";
        goto L28
    L21:
        r13[0] = "typeParameters";
        goto L28
    L22:
        r13[0] = "contextReceiverParameters";
        goto L28
    L23:
        r13[0] = "source";
        goto L28
    L24:
        r13[0] = "kind";
        goto L28
    L25:
        r13[0] = ActivityLifecycle.NAME;
        goto L28
    L26:
        r13[0] = "annotations";
        goto L28
    L8:
        r12 = 2;
        goto L9
    L4:
        r11 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    protected FunctionDescriptorImpl(DeclarationDescriptor r10, FunctionDescriptor r11, Annotations r12, Name r13, CallableMemberDescriptor.Kind r14, SourceElement r15) {
        if (r10 != null) goto L6;
        $$$reportNull$$$0(0);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(1);
    L8:
        if (r13 != null) goto L10;
        $$$reportNull$$$0(2);
    L10:
        if (r14 != null) goto L12;
        $$$reportNull$$$0(3);
    L12:
        if (r15 != null) goto L14;
        $$$reportNull$$$0(4);
    L14:
        super(r10, r12, r13, r15);
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
        if (r11 != null) goto L17;
        r11 = this;
    L17:
        this.original = r11;
        this.kind = r14;
    }

    static /* synthetic */ ReceiverParameterDescriptor access$000(FunctionDescriptorImpl r10) {
        return r10.dispatchReceiverParameter;
    }

    private SourceElement getSourceToUseForCopy(boolean r10, FunctionDescriptor r11) {
        if (r10 == false) goto L7;
        if (r11 != null) goto L6;
        r11 = getOriginal();
    L6:
        SourceElement r12 = r11.getSource();
    L8:
        if (r12 != null) goto L10;
        $$$reportNull$$$0(27);
    L10:
        return r12;
    L7:
        r12 = SourceElement.NO_SOURCE;
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

    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor r18, List<ValueParameterDescriptor> r19, TypeSubstitutor r20, boolean r21, boolean r22, boolean[] r23) {
        if (r19 != null) goto L5;
        $$$reportNull$$$0(30);
    L5:
        if (r20 != null) goto L7;
        $$$reportNull$$$0(31);
    L7:
        ArrayList r10 = new ArrayList(r19.size());
        Iterator<ValueParameterDescriptor> r11 = r19.iterator();
    L9:
        if (r11.hasNext() == false) goto L33;
        ValueParameterDescriptor r12 = r11.next();
        KotlinType r13 = r12.getType();
        Variance r14 = Variance.IN_VARIANCE;
        KotlinType r15 = r20.substitute(r13, r14);
        KotlinType r16 = r12.getVarargElementType();
        if (r16 != null) goto L13;
        KotlinType r17 = null;
    L14:
        if (r15 == null) goto L15;
        if (r15 != r12.getType()) goto L19;
        if (r16 != r17) goto L19;
    L22:
        if ((r12 instanceof ValueParameterDescriptorImpl.WithDestructuringDeclaration) == false) goto L24;
        final List<VariableDescriptor> r24 = ((ValueParameterDescriptorImpl.WithDestructuringDeclaration) r12).getDestructuringVariables();
        Function0<List<VariableDescriptor>> r110 = new AnonymousClass2(r24);
    L25:
        if (r21 == false) goto L27;
        ValueParameterDescriptor r25 = null;
    L28:
        int r26 = r12.getIndex();
        Annotations r27 = r12.getAnnotations();
        Name r111 = r12.getName();
        boolean r112 = r12.declaresDefaultValue();
        boolean r113 = r12.isCrossinline();
        boolean r114 = r12.isNoinline();
        if (r22 == false) goto L31;
        SourceElement r28 = r12.getSource();
    L32:
        r10.add(ValueParameterDescriptorImpl.createWithDestructuringDeclarations(r18, r25, r26, r27, r111, r15, r112, r113, r114, r17, r28, r110));
        goto L9
    L31:
        r28 = SourceElement.NO_SOURCE;
        goto L32
    L27:
        r25 = r12;
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
        r17 = r20.substitute(r16, r14);
        goto L14
    L33:
        return r10;
    }

    private void performOverriddenLazyCalculationIfNeeded() {
        Function0<Collection<FunctionDescriptor>> r10 = this.lazyOverriddenFunctionsTask;
        if (r10 == null) goto L6;
        this.overriddenFunctions = r10.invoke();
        this.lazyOverriddenFunctionsTask = null;
        return;
    }

    private void setHiddenForResolutionEverywhereBesideSupercalls(boolean r10) {
        this.isHiddenForResolutionEverywhereBesideSupercalls = r10;
    }

    private void setHiddenToOvercomeSignatureClash(boolean r10) {
        this.isHiddenToOvercomeSignatureClash = r10;
    }

    private void setInitialSignatureDescriptor(FunctionDescriptor r10) {
        this.initialSignatureDescriptor = r10;
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r10, D r11) {
        return r10.visitFunctionDescriptor(this, r11);
    }

    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor r10, Modality r11, DescriptorVisibility r12, CallableMemberDescriptor.Kind r13, boolean r14) {
        return copy(r10, r11, r12, r13, r14);
    }

    public FunctionDescriptor copy(DeclarationDescriptor r10, Modality r11, DescriptorVisibility r12, CallableMemberDescriptor.Kind r13, boolean r14) {
        FunctionDescriptor r15 = newCopyBuilder().setOwner(r10).setModality(r11).setVisibility(r12).setKind(r13).setCopyOverrides(r14).build();
        if (r15 != null) goto L5;
        $$$reportNull$$$0(26);
    L5:
        return r15;
    }

    protected abstract FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r10, FunctionDescriptor r11, CallableMemberDescriptor.Kind r12, Name r13, Annotations r14, SourceElement r15);

    protected FunctionDescriptor doSubstitute(CopyConfiguration r21) {
        if (r21 != null) goto L5;
        $$$reportNull$$$0(25);
    L5:
        boolean[] r10 = new boolean[1];
        if (CopyConfiguration.access$100(r21) == null) goto L8;
        Annotations r11 = AnnotationsKt.composeAnnotations(getAnnotations(), CopyConfiguration.access$100(r21));
    L9:
        DeclarationDescriptor r12 = r21.newOwner;
        FunctionDescriptor r13 = r21.original;
        FunctionDescriptorImpl r14 = createSubstitutedCopy(r12, r13, r21.kind, r21.name, r11, getSourceToUseForCopy(r21.preserveSourceElement, r13));
        if (CopyConfiguration.access$200(r21) != null) goto L12;
        List<TypeParameterDescriptor> r15 = getTypeParameters();
    L13:
        r10[0] = r10[0] | (!r15.isEmpty());
        ArrayList r16 = new ArrayList(r15.size());
        final TypeSubstitutor r17 = DescriptorSubstitutor.substituteTypeParameters(r15, r21.substitution, r14, r16, r10);
        if (r17 != null) goto L16;
        return null;
    L16:
        ArrayList r18 = new ArrayList();
        if (r21.newContextReceiverParameters.isEmpty() == true) goto L29;
        Iterator<ReceiverParameterDescriptor> r19 = r21.newContextReceiverParameters.iterator();
    L20:
        if (r19.hasNext() == false) goto L29;
        ReceiverParameterDescriptor r20 = r19.next();
        KotlinType r22 = r17.substitute(r20.getType(), Variance.IN_VARIANCE);
        if (r22 == null) goto L23;
        r18.add(DescriptorFactory.createContextReceiverParameterForCallable(r14, r22, r20.getAnnotations()));
        boolean r23 = r10[0];
        if (r22 == r20.getType()) goto L27;
        boolean r24 = true;
    L28:
        r10[0] = r24 | r23;
        goto L20
    L27:
        r24 = false;
        goto L28
    L23:
        return null;
    L29:
        ReceiverParameterDescriptor r25 = r21.newExtensionReceiverParameter;
        if (r25 == null) goto L39;
        KotlinType r26 = r17.substitute(r25.getType(), Variance.IN_VARIANCE);
        if (r26 != null) goto L34;
        return null;
    L34:
        ReceiverParameterDescriptorImpl r27 = new ReceiverParameterDescriptorImpl(r14, new ExtensionReceiver(r14, r26, r21.newExtensionReceiverParameter.getValue()), r21.newExtensionReceiverParameter.getAnnotations());
        boolean r28 = r10[0];
        if (r26 == r21.newExtensionReceiverParameter.getType()) goto L37;
        boolean r29 = true;
    L38:
        r10[0] = r29 | r28;
        ReceiverParameterDescriptorImpl r110 = r27;
    L40:
        ReceiverParameterDescriptor r30 = r21.dispatchReceiverParameter;
        if (r30 == null) goto L50;
        ReceiverParameterDescriptor r31 = r30.substitute(r17);
        if (r31 != null) goto L45;
        return null;
    L45:
        boolean r32 = r10[0];
        if (r31 == r21.dispatchReceiverParameter) goto L48;
        boolean r33 = true;
    L49:
        r10[0] = r32 | r33;
        ReceiverParameterDescriptor r111 = r31;
    L51:
        List<ValueParameterDescriptor> r34 = getSubstitutedValueParameters(r14, r21.newValueParameterDescriptors, r17, r21.dropOriginalInContainingParts, r21.preserveSourceElement, r10);
        if (r34 != null) goto L54;
        return null;
    L54:
        KotlinType r35 = r17.substitute(r21.newReturnType, Variance.OUT_VARIANCE);
        if (r35 != null) goto L57;
        return null;
    L57:
        boolean r36 = r10[0];
        if (r35 == r21.newReturnType) goto L60;
        boolean r37 = true;
    L61:
        r10[0] = r36 | r37;
        if (r10[0] == false) goto L64;
    L66:
        r14.initialize(r110, r111, r18, r16, r34, r35, r21.newModality, r21.newVisibility);
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
        if (CopyConfiguration.access$500(r21) == null) goto L69;
        boolean r38 = CopyConfiguration.access$500(r21).booleanValue();
    L70:
        r14.setHasSynthesizedParameterNames(r38);
        if (CopyConfiguration.access$600(r21).isEmpty() == true) goto L73;
    L74:
        Map<CallableDescriptor.UserDataKey<?>, Object> r39 = CopyConfiguration.access$600(r21);
        Map<CallableDescriptor.UserDataKey<?>, Object> r40 = this.userDataMap;
        if (r40 == null) goto L83;
        Iterator<Map.Entry<CallableDescriptor.UserDataKey<?>, Object>> r41 = r40.entrySet().iterator();
    L78:
        if (r41.hasNext() == false) goto L83;
        Map.Entry<CallableDescriptor.UserDataKey<?>, Object> r42 = r41.next();
        if (r39.containsKey(r42.getKey()) == true) goto L78;
        r39.put(r42.getKey(), r42.getValue());
    L83:
        if (r39.size() != 1) goto L85;
        r39 = Collections.singletonMap(r39.keySet().iterator().next(), r39.values().iterator().next());
    L85:
        r14.userDataMap = r39;
    L87:
        if (r21.signatureChange == true) goto L91;
        if (getInitialSignatureDescriptor() != null) goto L91;
    L96:
        if (r21.copyOverrides == true) goto L98;
    L107:
        return r14;
    L98:
        if (getOriginal().getOverriddenDescriptors().isEmpty() == true) goto L107;
        if (r21.substitution.isEmpty() == false) goto L105;
        Function0<Collection<FunctionDescriptor>> r43 = this.lazyOverriddenFunctionsTask;
        if (r43 != null) goto L106;
        r14.setOverriddenDescriptors(getOverriddenDescriptors());
    L106:
        r14.lazyOverriddenFunctionsTask = r43;
        goto L107
    L105:
        r43 = new AnonymousClass1(this, r17);
    L91:
        if (getInitialSignatureDescriptor() == null) goto L93;
        FunctionDescriptor r44 = getInitialSignatureDescriptor();
    L94:
        r14.setInitialSignatureDescriptor(r44.substitute(r17));
        goto L96
    L93:
        r44 = this;
        goto L94
    L73:
        if (this.userDataMap == null) goto L87;
    L69:
        r38 = this.hasSynthesizedParameterNames;
        goto L70
    L64:
        if (r21.justForTypeSubstitution == false) goto L66;
        return this;
    L60:
        r37 = false;
        goto L61
    L48:
        r33 = false;
        goto L49
    L50:
        r111 = null;
        goto L51
    L37:
        r29 = false;
        goto L38
    L39:
        r110 = null;
        goto L40
    L12:
        r15 = CopyConfiguration.access$200(r21);
        goto L13
    L8:
        r11 = getAnnotations();
        goto L9
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> r10 = this.contextReceiverParameters;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(13);
    L5:
        return r10;
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
        CallableMemberDescriptor.Kind r10 = this.kind;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(21);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        Modality r10 = this.modality;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(15);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
        return getOriginal();
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
        FunctionDescriptor r10 = this.original;
        ?? r11 = this;
        if (r10 == this) goto L6;
        r11 = r10.getOriginal();
    L6:
        if (r11 != 0) goto L8;
        $$$reportNull$$$0(20);
    L8:
        return r11;
    }

    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        performOverriddenLazyCalculationIfNeeded();
        Collection<? extends FunctionDescriptor> r10 = this.overriddenFunctions;
        if (r10 != null) goto L6;
        r10 = Collections.emptyList();
    L6:
        if (r10 != null) goto L8;
        $$$reportNull$$$0(14);
    L8:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public KotlinType getReturnType() {
        return this.unsubstitutedReturnType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> r10 = this.typeParameters;
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> r10) {
        Map<CallableDescriptor.UserDataKey<?>, Object> r11 = this.userDataMap;
        if (r11 != null) goto L7;
        return null;
    L7:
        return (V) r11.get(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> r10 = this.unsubstitutedValueParameters;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(19);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility r10 = this.visibility;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(16);
    L5:
        return r10;
    }

    public boolean hasStableParameterNames() {
        return this.hasStableParameterNames;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.hasSynthesizedParameterNames;
    }

    public FunctionDescriptorImpl initialize(ReceiverParameterDescriptor r10, ReceiverParameterDescriptor r11, List<ReceiverParameterDescriptor> r12, List<? extends TypeParameterDescriptor> r13, List<ValueParameterDescriptor> r14, KotlinType r15, Modality r16, DescriptorVisibility r17) {
        if (r12 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        if (r13 != null) goto L6;
        $$$reportNull$$$0(6);
    L6:
        if (r14 != null) goto L8;
        $$$reportNull$$$0(7);
    L8:
        if (r17 != null) goto L10;
        $$$reportNull$$$0(8);
    L10:
        this.typeParameters = CollectionsKt.toList(r13);
        this.unsubstitutedValueParameters = CollectionsKt.toList(r14);
        this.unsubstitutedReturnType = r15;
        this.modality = r16;
        this.visibility = r17;
        this.extensionReceiverParameter = r10;
        this.dispatchReceiverParameter = r11;
        this.contextReceiverParameters = r12;
        int r18 = 0;
        int r19 = 0;
    L12:
        if (r19 >= r13.size()) goto L19;
        TypeParameterDescriptor r20 = r13.get(r19);
        if (r20.getIndex() != r19) goto L17;
        r19 = r19 + 1;
        goto L12
    L17:
        throw new IllegalStateException(r20 + " index is " + r20.getIndex() + " but position is " + r19);
    L19:
        if (r18 >= r14.size()) goto L25;
        ValueParameterDescriptor r21 = r14.get(r18);
        if (r21.getIndex() != (r18 + 0)) goto L24;
        r18 = r18 + 1;
        goto L19
    L24:
        throw new IllegalStateException(r21 + "index is " + r21.getIndex() + " but position is " + r18);
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
        Iterator<? extends FunctionDescriptor> r10 = getOriginal().getOverriddenDescriptors().iterator();
    L7:
        if (r10.hasNext() == false) goto L11;
        if (r10.next().isInfix() == false) goto L7;
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
        Iterator<? extends FunctionDescriptor> r10 = getOriginal().getOverriddenDescriptors().iterator();
    L7:
        if (r10.hasNext() == false) goto L11;
        if (r10.next().isOperator() == false) goto L7;
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
        CopyConfiguration r10 = newCopyBuilder(TypeSubstitutor.EMPTY);
        if (r10 != null) goto L5;
        $$$reportNull$$$0(23);
    L5:
        return r10;
    }

    protected CopyConfiguration newCopyBuilder(TypeSubstitutor r14) {
        if (r14 != null) goto L5;
        $$$reportNull$$$0(24);
    L5:
        return new CopyConfiguration(this, r14.getSubstitution(), getContainingDeclaration(), getModality(), getVisibility(), getKind(), getValueParameters(), getContextReceiverParameters(), getExtensionReceiverParameter(), getReturnType(), null);
    }

    public <V> void putInUserDataMap(CallableDescriptor.UserDataKey<V> r10, Object r11) {
        if (this.userDataMap != null) goto L5;
        this.userDataMap = new LinkedHashMap();
    L5:
        this.userDataMap.put(r10, r11);
    }

    public void setActual(boolean r10) {
        this.isActual = r10;
    }

    public void setExpect(boolean r10) {
        this.isExpect = r10;
    }

    public void setExternal(boolean r10) {
        this.isExternal = r10;
    }

    public void setHasStableParameterNames(boolean r10) {
        this.hasStableParameterNames = r10;
    }

    public void setHasSynthesizedParameterNames(boolean r10) {
        this.hasSynthesizedParameterNames = r10;
    }

    public void setInfix(boolean r10) {
        this.isInfix = r10;
    }

    public void setInline(boolean r10) {
        this.isInline = r10;
    }

    public void setOperator(boolean r10) {
        this.isOperator = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> r10) {
        if (r10 != 0) goto L4;
        $$$reportNull$$$0(17);
    L4:
        this.overriddenFunctions = r10;
        Iterator r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L14;
        if (((FunctionDescriptor) r11.next()).isHiddenForResolutionEverywhereBesideSupercalls() == false) goto L6;
        this.isHiddenForResolutionEverywhereBesideSupercalls = true;
        return;
    }

    public void setReturnType(KotlinType r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(11);
    L4:
        this.unsubstitutedReturnType = r10;
    }

    public void setSuspend(boolean r10) {
        this.isSuspend = r10;
    }

    public void setTailrec(boolean r10) {
        this.isTailrec = r10;
    }

    public void setVisibility(DescriptorVisibility r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(10);
    L4:
        this.visibility = r10;
    }

    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r10) {
        return substitute(r10);
    }

    public FunctionDescriptor substitute(TypeSubstitutor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(22);
    L5:
        if (r10.isEmpty() == false) goto L8;
        return this;
    L8:
        return newCopyBuilder(r10).setOriginal(getOriginal()).setPreserveSourceElement().setJustForTypeSubstitution(true).build();
    }
}

package kotlin.reflect.jvm.internal.impl.builtins.functions;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nFunctionInvokeDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FunctionInvokeDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionInvokeDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,161:1\n2624#2,3:162\n1549#2:165\n1620#2,3:166\n1726#2,3:169\n1549#2:172\n1620#2,3:173\n1747#2,3:176\n*S KotlinDebug\n*F\n+ 1 FunctionInvokeDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionInvokeDescriptor\n*L\n63#1:162,3\n64#1:165\n64#1:166,3\n88#1:169,3\n92#1:172\n92#1:173,3\n106#1:176,3\n*E\n"})
public final class FunctionInvokeDescriptor extends SimpleFunctionDescriptorImpl {
    public static final Factory Factory = null;

    @SourceDebugExtension({"SMAP\nFunctionInvokeDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FunctionInvokeDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionInvokeDescriptor$Factory\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,161:1\n959#2,7:162\n1549#2:169\n1620#2,3:170\n*S KotlinDebug\n*F\n+ 1 FunctionInvokeDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionInvokeDescriptor$Factory\n*L\n122#1:162,7\n124#1:169\n124#1:170,3\n*E\n"})
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker r5) {
            this();
        }

        private final ValueParameterDescriptor createValueParameter(FunctionInvokeDescriptor r15, int r16, TypeParameterDescriptor r17) {
            String r5 = r17.getName().asString();
            if (Intrinsics.areEqual(r5, ExifInterface.GPS_DIRECTION_TRUE) == false) goto L6;
            String r10 = "instance";
        L10:
            return new ValueParameterDescriptorImpl(r15, null, r16, Annotations.Companion.getEMPTY(), Name.identifier(r10), r17.getDefaultType(), false, false, false, null, SourceElement.NO_SOURCE);
        L6:
            if (Intrinsics.areEqual(r5, ExifInterface.LONGITUDE_EAST) == false) goto L8;
            r10 = "receiver";
            goto L10
        L8:
            r10 = r5.toLowerCase(Locale.ROOT);
            goto L10
        }

        public final FunctionInvokeDescriptor create(FunctionClassDescriptor r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r11, "functionClass");
            List<TypeParameterDescriptor> r10 = r11.getDeclaredTypeParameters();
            FunctionInvokeDescriptor r5 = null;
            FunctionInvokeDescriptor r13 = new FunctionInvokeDescriptor(r11, r5, CallableMemberDescriptor.Kind.DECLARATION, r12, null);
            ReceiverParameterDescriptor r14 = r11.getThisAsReceiverParameter();
            List<ReceiverParameterDescriptor> r15 = CollectionsKt.emptyList();
            List<? extends TypeParameterDescriptor> r16 = CollectionsKt.emptyList();
            ArrayList r17 = new ArrayList();
            Iterator<T> r18 = r10.iterator();
        L4:
            if (r18.hasNext() == false) goto L8;
            Object r19 = r18.next();
            if (((TypeParameterDescriptor) r19).getVariance() != Variance.IN_VARIANCE) goto L8;
            r17.add(r19);
        L8:
            Iterable r110 = CollectionsKt.withIndex(r17);
            ArrayList r20 = new ArrayList(CollectionsKt.h(r110));
            Iterator r111 = r110.iterator();
        L10:
            if (r111.hasNext() == false) goto L12;
            IndexedValue r112 = (IndexedValue) r111.next();
            r20.add(FunctionInvokeDescriptor.Factory.createValueParameter(r13, r112.getIndex(), (TypeParameterDescriptor) r112.getValue()));
            goto L10
        L12:
            r13.initialize(null, r14, r15, r16, r20, ((TypeParameterDescriptor) CollectionsKt.last(r10)).getDefaultType(), Modality.ABSTRACT, DescriptorVisibilities.PUBLIC);
            r13.setHasSynthesizedParameterNames(true);
            return r13;
        }

        private Factory() {
        }
    }

    static {
        Factory = new Factory(null);
    }

    public /* synthetic */ FunctionInvokeDescriptor(DeclarationDescriptor r5, FunctionInvokeDescriptor r10, CallableMemberDescriptor.Kind r11, boolean r12, DefaultConstructorMarker r13) {
        this(r5, r10, r11, r12);
    }

    private final FunctionDescriptor replaceParameterNames(List<Name> r10) {
        int r5 = getValueParameters().size() - r10.size();
        boolean r11 = true;
        if (r5 != 0) goto L16;
        List r12 = CollectionsKt.zip(r10, getValueParameters());
        if (r12 != null) goto L7;
    L9:
        Iterator r13 = r12.iterator();
    L11:
        if (r13.hasNext() == false) goto L15;
        Pair r14 = (Pair) r13.next();
        if (Intrinsics.areEqual((Name) r14.component1(), ((ValueParameterDescriptor) r14.component2()).getName()) == true) goto L11;
    L15:
        return this;
    L7:
        if (r12.isEmpty() == false) goto L9;
    L16:
        List<ValueParameterDescriptor> r15 = getValueParameters();
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator<T> r17 = r15.iterator();
    L18:
        if (r17.hasNext() == false) goto L25;
        ValueParameterDescriptor r18 = (ValueParameterDescriptor) r17.next();
        Name r19 = r18.getName();
        int r20 = r18.getIndex();
        int r21 = r20 - r5;
        if (r21 < 0) goto L24;
        Name r22 = r10.get(r21);
        if (r22 == null) goto L24;
        r19 = r22;
    L24:
        r16.add(r18.copy(this, r19, r20));
        goto L18
    L25:
        FunctionDescriptorImpl.CopyConfiguration r23 = newCopyBuilder(TypeSubstitutor.EMPTY);
        if (r10.isEmpty() == false) goto L28;
    L27:
        r11 = false;
    L33:
        FunctionDescriptor r24 = super.doSubstitute(r23.setHasSynthesizedParameterNames(r11).setValueParameters(r16).setOriginal(getOriginal()));
        Intrinsics.checkNotNull(r24);
        return r24;
    L28:
        Iterator<T> r25 = r10.iterator();
    L30:
        if (r25.hasNext() == false) goto L27;
        if (((Name) r25.next()) != null) goto L30;
        goto L33
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r5, FunctionDescriptor r10, CallableMemberDescriptor.Kind r11, Name r12, Annotations r13, SourceElement r14) {
        Intrinsics.checkNotNullParameter(r5, "newOwner");
        Intrinsics.checkNotNullParameter(r11, "kind");
        Intrinsics.checkNotNullParameter(r13, "annotations");
        Intrinsics.checkNotNullParameter(r14, "source");
        return new FunctionInvokeDescriptor(r5, (FunctionInvokeDescriptor) r10, r11, isSuspend());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public FunctionDescriptor doSubstitute(FunctionDescriptorImpl.CopyConfiguration r5) {
        Intrinsics.checkNotNullParameter(r5, "configuration");
        FunctionInvokeDescriptor r10 = (FunctionInvokeDescriptor) super.doSubstitute(r5);
        if (r10 != null) goto L6;
        return null;
    L6:
        List<ValueParameterDescriptor> r11 = r10.getValueParameters();
        if (r11 != null) goto L9;
    L11:
        Iterator<T> r12 = r11.iterator();
    L13:
        if (r12.hasNext() == false) goto L27;
        if (FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(((ValueParameterDescriptor) r12.next()).getType()) == null) goto L13;
        List<ValueParameterDescriptor> r13 = r10.getValueParameters();
        ArrayList r14 = new ArrayList(CollectionsKt.h(r13));
        Iterator<T> r15 = r13.iterator();
    L18:
        if (r15.hasNext() == false) goto L21;
        r14.add(FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(((ValueParameterDescriptor) r15.next()).getType()));
        goto L18
    L21:
        return r10.replaceParameterNames(r14);
    L27:
        return r10;
    L9:
        if (r11.isEmpty() == false) goto L11;
        return r10;
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

    private FunctionInvokeDescriptor(DeclarationDescriptor r10, FunctionInvokeDescriptor r11, CallableMemberDescriptor.Kind r12, boolean r13) {
        super(r10, r11, Annotations.Companion.getEMPTY(), OperatorNameConventions.INVOKE, r12, SourceElement.NO_SOURCE);
        setOperator(true);
        setSuspend(r13);
        setHasStableParameterNames(false);
    }
}

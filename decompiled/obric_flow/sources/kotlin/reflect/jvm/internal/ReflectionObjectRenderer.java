package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0015\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\u0006\u0010\u001c\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "()V", "renderer", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "renderCallable", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "renderFunction", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "renderLambda", "invoke", "renderParameter", "parameter", "Lkotlin/reflect/jvm/internal/KParameterImpl;", "renderProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "renderType", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "appendReceiverType", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "receiver", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "appendReceivers", "callable", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ReflectionObjectRenderer {
    public static final ReflectionObjectRenderer INSTANCE = null;
    private static final DescriptorRenderer renderer = null;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[KParameter.Kind.values().length];
            r5[KParameter.Kind.EXTENSION_RECEIVER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[KParameter.Kind.INSTANCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[KParameter.Kind.VALUE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    static {
        INSTANCE = new ReflectionObjectRenderer();
        renderer = DescriptorRenderer.FQ_NAMES_IN_TYPES;
    }

    private ReflectionObjectRenderer() {
    }

    private final void appendReceiverType(StringBuilder r5, ReceiverParameterDescriptor r10) {
        if (r10 == null) goto L5;
        r5.append(renderType(r10.getType()));
        r5.append(".");
        return;
    }

    private final void appendReceivers(StringBuilder r5, CallableDescriptor r10) {
        ReceiverParameterDescriptor r11 = UtilKt.getInstanceReceiverParameter(r10);
        ReceiverParameterDescriptor r12 = r10.getExtensionReceiverParameter();
        appendReceiverType(r5, r11);
        if (r11 == null) goto L6;
        if (r12 == null) goto L6;
        boolean r13 = true;
    L7:
        if (r13 == false) goto L9;
        r5.append("(");
    L9:
        appendReceiverType(r5, r12);
        if (r13 == false) goto L13;
        r5.append(")");
        return;
    L13:
        return;
    L6:
        r13 = false;
        goto L7
    }

    private final String renderCallable(CallableDescriptor r5) {
        if ((r5 instanceof PropertyDescriptor) == false) goto L6;
        return renderProperty((PropertyDescriptor) r5);
    L6:
        if ((r5 instanceof FunctionDescriptor) == false) goto L10;
        return renderFunction((FunctionDescriptor) r5);
    L10:
        throw new IllegalStateException(("Illegal callable: " + r5).toString());
    }

    public final String renderFunction(FunctionDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "descriptor");
        StringBuilder r11 = new StringBuilder();
        r11.append("fun ");
        ReflectionObjectRenderer r12 = INSTANCE;
        r12.appendReceivers(r11, r10);
        r11.append(renderer.renderName(r10.getName(), true));
        CollectionsKt.p(r10.getValueParameters(), r11, ", ", "(", ")", ReflectionObjectRenderer$renderFunction$1$1.INSTANCE, 48);
        r11.append(": ");
        KotlinType r13 = r10.getReturnType();
        Intrinsics.checkNotNull(r13);
        r11.append(r12.renderType(r13));
        return r11.toString();
    }

    public final String renderLambda(FunctionDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "invoke");
        StringBuilder r11 = new StringBuilder();
        ReflectionObjectRenderer r12 = INSTANCE;
        r12.appendReceivers(r11, r10);
        CollectionsKt.p(r10.getValueParameters(), r11, ", ", "(", ")", ReflectionObjectRenderer$renderLambda$1$1.INSTANCE, 48);
        r11.append(" -> ");
        KotlinType r13 = r10.getReturnType();
        Intrinsics.checkNotNull(r13);
        r11.append(r12.renderType(r13));
        return r11.toString();
    }

    public final String renderParameter(KParameterImpl r5) {
        Intrinsics.checkNotNullParameter(r5, "parameter");
        StringBuilder r10 = new StringBuilder();
        int r11 = WhenMappings.$EnumSwitchMapping$0[r5.getKind().ordinal()];
        if (r11 != 1) goto L5;
        r10.append("extension receiver parameter");
    L12:
        r10.append(" of ");
        r10.append(INSTANCE.renderCallable(r5.getCallable().getDescriptor()));
        return r10.toString();
    L5:
        if (r11 != 2) goto L7;
        r10.append("instance parameter");
        goto L12
    L7:
        if (r11 != 3) goto L12;
        r10.append("parameter #" + r5.getIndex() + ' ' + r5.getName());
        goto L12
    }

    public final String renderProperty(PropertyDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        StringBuilder r10 = new StringBuilder();
        if (r5.isVar() == false) goto L5;
        String r11 = "var ";
    L6:
        r10.append(r11);
        ReflectionObjectRenderer r12 = INSTANCE;
        r12.appendReceivers(r10, r5);
        r10.append(renderer.renderName(r5.getName(), true));
        r10.append(": ");
        r10.append(r12.renderType(r5.getType()));
        return r10.toString();
    L5:
        r11 = "val ";
        goto L6
    }

    public final String renderType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return renderer.renderType(r5);
    }
}

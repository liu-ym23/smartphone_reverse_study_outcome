package kotlin.reflect.jvm.internal;

import com.bytedance.common.wschannel.WsConstants;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectionObjectRenderer {
    public static final ReflectionObjectRenderer INSTANCE = null;
    private static final DescriptorRenderer renderer = null;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[KParameter.Kind.values().length];
            r10[KParameter.Kind.EXTENSION_RECEIVER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[KParameter.Kind.INSTANCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[KParameter.Kind.VALUE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r10;
        }
    }

    static {
        INSTANCE = new ReflectionObjectRenderer();
        renderer = DescriptorRenderer.FQ_NAMES_IN_TYPES;
    }

    private ReflectionObjectRenderer() {
    }

    private final void appendReceiverType(StringBuilder r10, ReceiverParameterDescriptor r11) {
        if (r11 == null) goto L5;
        KotlinType r12 = r11.getType();
        Intrinsics.checkNotNullExpressionValue(r12, "receiver.type");
        r10.append(renderType(r12));
        r10.append(".");
        return;
    }

    private final void appendReceivers(StringBuilder r10, CallableDescriptor r11) {
        ReceiverParameterDescriptor r12 = UtilKt.getInstanceReceiverParameter(r11);
        ReceiverParameterDescriptor r13 = r11.getExtensionReceiverParameter();
        appendReceiverType(r10, r12);
        if (r12 == null) goto L6;
        if (r13 == null) goto L6;
        boolean r14 = true;
    L7:
        if (r14 == false) goto L9;
        r10.append("(");
    L9:
        appendReceiverType(r10, r13);
        if (r14 == false) goto L13;
        r10.append(")");
        return;
    L13:
        return;
    L6:
        r14 = false;
        goto L7
    }

    private final String renderCallable(CallableDescriptor r10) {
        if ((r10 instanceof PropertyDescriptor) == false) goto L6;
        return renderProperty((PropertyDescriptor) r10);
    L6:
        if ((r10 instanceof FunctionDescriptor) == false) goto L10;
        return renderFunction((FunctionDescriptor) r10);
    L10:
        throw new IllegalStateException(("Illegal callable: " + r10).toString());
    }

    public final String renderFunction(FunctionDescriptor r12) {
        Intrinsics.checkNotNullParameter(r12, "descriptor");
        StringBuilder r11 = new StringBuilder();
        r11.append("fun ");
        ReflectionObjectRenderer r10 = INSTANCE;
        r10.appendReceivers(r11, r12);
        DescriptorRenderer r13 = renderer;
        Name r14 = r12.getName();
        Intrinsics.checkNotNullExpressionValue(r14, "descriptor.name");
        r11.append(r13.renderName(r14, true));
        List<ValueParameterDescriptor> r15 = r12.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r15, "descriptor.valueParameters");
        CollectionsKt.joinTo$default(r15, r11, ", ", "(", ")", 0, null, ReflectionObjectRenderer$renderFunction$1$1.INSTANCE, 48, null);
        r11.append(": ");
        KotlinType r16 = r12.getReturnType();
        Intrinsics.checkNotNull(r16);
        r11.append(r10.renderType(r16));
        String r17 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r17, "StringBuilder().apply(builderAction).toString()");
        return r17;
    }

    public final String renderLambda(FunctionDescriptor r12) {
        Intrinsics.checkNotNullParameter(r12, "invoke");
        StringBuilder r11 = new StringBuilder();
        ReflectionObjectRenderer r10 = INSTANCE;
        r10.appendReceivers(r11, r12);
        List<ValueParameterDescriptor> r13 = r12.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r13, "invoke.valueParameters");
        CollectionsKt.joinTo$default(r13, r11, ", ", "(", ")", 0, null, ReflectionObjectRenderer$renderLambda$1$1.INSTANCE, 48, null);
        r11.append(" -> ");
        KotlinType r14 = r12.getReturnType();
        Intrinsics.checkNotNull(r14);
        r11.append(r10.renderType(r14));
        String r15 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r15, "StringBuilder().apply(builderAction).toString()");
        return r15;
    }

    public final String renderParameter(KParameterImpl r10) {
        Intrinsics.checkNotNullParameter(r10, "parameter");
        StringBuilder r11 = new StringBuilder();
        int r12 = WhenMappings.$EnumSwitchMapping$0[r10.getKind().ordinal()];
        if (r12 != 1) goto L5;
        String r13 = "extension receiver parameter";
    L12:
        r11.append(r13);
    L13:
        r11.append(" of ");
        r11.append(INSTANCE.renderCallable(r10.getCallable().getDescriptor()));
        String r14 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r14, "StringBuilder().apply(builderAction).toString()");
        return r14;
    L5:
        if (r12 != 2) goto L7;
        r13 = "instance parameter";
        goto L12
    L7:
        if (r12 != 3) goto L13;
        r13 = "parameter #" + r10.getIndex() + ' ' + r10.getName();
        goto L12
    }

    public final String renderProperty(PropertyDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "descriptor");
        StringBuilder r11 = new StringBuilder();
        if (r10.isVar() == false) goto L5;
        String r12 = "var ";
    L6:
        r11.append(r12);
        ReflectionObjectRenderer r13 = INSTANCE;
        r13.appendReceivers(r11, r10);
        DescriptorRenderer r14 = renderer;
        Name r15 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r15, "descriptor.name");
        r11.append(r14.renderName(r15, true));
        r11.append(": ");
        KotlinType r16 = r10.getType();
        Intrinsics.checkNotNullExpressionValue(r16, "descriptor.type");
        r11.append(r13.renderType(r16));
        String r17 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r17, "StringBuilder().apply(builderAction).toString()");
        return r17;
    L5:
        r12 = "val ";
        goto L6
    }

    public final String renderType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        return renderer.renderType(r10);
    }
}

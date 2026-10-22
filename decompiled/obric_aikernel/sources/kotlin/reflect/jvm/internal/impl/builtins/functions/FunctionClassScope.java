package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes3.dex */
public final class FunctionClassScope extends GivenFunctionsMemberScope {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[FunctionClassKind.values().length];
            r10[FunctionClassKind.Function.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r10[FunctionClassKind.SuspendFunction.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r10;
        }
    }

    public FunctionClassScope(StorageManager r10, FunctionClassDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "storageManager");
        Intrinsics.checkNotNullParameter(r11, "containingClass");
        super(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope
    protected List<FunctionDescriptor> computeDeclaredFunctions() {
        ClassDescriptor r10 = getContainingClass();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
        FunctionClassKind r11 = ((FunctionClassDescriptor) r10).getFunctionKind();
        int r12 = WhenMappings.$EnumSwitchMapping$0[r11.ordinal()];
        boolean r13 = true;
        if (r12 != 1) goto L5;
        FunctionInvokeDescriptor.Factory r14 = FunctionInvokeDescriptor.Factory;
        FunctionClassDescriptor r15 = (FunctionClassDescriptor) getContainingClass();
        r13 = false;
    L10:
        return CollectionsKt.listOf(r14.create(r15, r13));
    L5:
        if (r12 != 2) goto L11;
        r14 = FunctionInvokeDescriptor.Factory;
        r15 = (FunctionClassDescriptor) getContainingClass();
        goto L10
    L11:
        return CollectionsKt.emptyList();
    }
}

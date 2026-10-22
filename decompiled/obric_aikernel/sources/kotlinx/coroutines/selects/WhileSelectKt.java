package kotlinx.coroutines.selects;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nWhileSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt\n+ 2 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,33:1\n55#2,8:34\n*S KotlinDebug\n*F\n+ 1 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt\n*L\n31#1:34,8\n*E\n"})
public final class WhileSelectKt {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004c -> B:18:0x004f). Please report as a decompilation issue!!! */
    public static final Object a(Function1<? super b<? super Boolean>, Unit> r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof WhileSelectKt$whileSelect$1) == false) goto L7;
        WhileSelectKt$whileSelect$1 r12 = (WhileSelectKt$whileSelect$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r10 = (Function1) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L19:
        if (((Boolean) r14).booleanValue() == false) goto L21;
    L15:
        SelectImplementation r17 = new SelectImplementation(r12.getContext());
        r10.invoke(r17);
        r12.L$0 = r10;
        r12.label = 1;
        r14 = r17.r(r12);
        if (r14 != r15) goto L19;
        return r15;
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
    L7:
        r12 = new WhileSelectKt$whileSelect$1(r11);
        goto L8
    }
}

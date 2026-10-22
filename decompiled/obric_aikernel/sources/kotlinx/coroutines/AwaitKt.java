package kotlinx.coroutines;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,127:1\n37#2,2:128\n13579#3,2:130\n1855#4,2:132\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitKt\n*L\n42#1:128,2\n54#1:130,2\n66#1:132,2\n*E\n"})
public final class AwaitKt {
    public static final <T> Object a(Collection<? extends r0<? extends T>> r10, Continuation<? super List<? extends T>> r11) {
        if (r10.isEmpty() == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return new e((r0[]) r10.toArray(new r0[0])).c(r11);
    }

    public static final Object b(Collection<? extends v1> r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof AwaitKt$joinAll$3) == false) goto L7;
        AwaitKt$joinAll$3 r12 = (AwaitKt$joinAll$3) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        Iterator r17 = (Iterator) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L16:
        if (r17.hasNext() == false) goto L21;
        v1 r18 = (v1) r17.next();
        r12.L$0 = r17;
        r12.label = 1;
        if (r18.l(r12) != r15) goto L16;
        return r15;
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r17 = r10.iterator();
    L7:
        r12 = new AwaitKt$joinAll$3(r11);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0053 -> B:19:0x0056). Please report as a decompilation issue!!! */
    public static final Object c(v1[] r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof AwaitKt$joinAll$1) == false) goto L7;
        AwaitKt$joinAll$1 r12 = (AwaitKt$joinAll$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        int r17 = r12.I$1;
        int r18 = r12.I$0;
        v1[] r19 = (v1[]) r12.L$0;
        ResultKt.throwOnFailure(r14);
        v1[] r20 = r19;
    L19:
        r18 = r18 + 1;
    L15:
        if (r18 >= r17) goto L21;
        v1 r21 = r20[r18];
        r12.L$0 = r20;
        r12.I$0 = r18;
        r12.I$1 = r17;
        r12.label = 1;
        if (r21.l(r12) != r15) goto L19;
        return r15;
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r20 = r10;
        r17 = r10.length;
        r18 = 0;
    L7:
        r12 = new AwaitKt$joinAll$1(r11);
        goto L8
    }
}

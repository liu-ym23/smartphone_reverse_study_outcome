package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004\"\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a\"\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0004\"\u00020\nH\u0086@¢\u0006\u0002\u0010\u000b\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\fH\u0086@¢\u0006\u0002\u0010\r\u001a\u0018\u0010\u0007\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\n0\fH\u0086@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"awaitAll", "", ExifInterface.GPS_DIRECTION_TRUE, "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class f {
    public static final <T> Object a(Collection<? extends ar<? extends T>> r3, Continuation<? super List<? extends T>> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Continuation<? super List<? extends T>> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        if (r5.isEmpty() == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return new e((ar[]) ZeusTransformUtils.preCheckCast(r5.toArray(new ar[0]), ar[].class, "com.obric.memorydata.plugin")).a(r6);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x006c -> B:19:0x006f). Please report as a decompilation issue!!! */
    public static final Object a(bx[] r7, Continuation<? super Unit> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, AwaitKt$joinAll$1.class) == false) goto L7;
        AwaitKt$joinAll$1 r0 = (AwaitKt$joinAll$1) ZeusTransformUtils.preCheckCast(r9, AwaitKt$joinAll$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r11 = r0.I$1;
        int r4 = r0.I$0;
        bx[] r1 = (bx[]) ZeusTransformUtils.preCheckCast(r0.L$0, bx[].class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
        bx[] r12 = r1;
    L19:
        r4 = r4 + 1;
    L15:
        if (r4 >= r11) goto L21;
        bx r5 = r12[r4];
        r0.L$0 = r12;
        r0.I$0 = r4;
        r0.I$1 = r11;
        r0.label = 1;
        if (r5.a_(r0) != r2) goto L19;
        return r2;
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        r4 = 0;
        r12 = r7;
        r11 = r7.length;
    L7:
        r0 = new AwaitKt$joinAll$1(r9);
        goto L8
    }

    public static final Object b(Collection<? extends bx> r5, Continuation<? super Unit> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, AwaitKt$joinAll$3.class) == false) goto L7;
        AwaitKt$joinAll$3 r0 = (AwaitKt$joinAll$3) ZeusTransformUtils.preCheckCast(r8, AwaitKt$joinAll$3.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Iterator r10 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$0, Iterator.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L16:
        if (r10.hasNext() == false) goto L21;
        bx r11 = (bx) ZeusTransformUtils.preCheckCast(r10.next(), bx.class, "com.obric.memorydata.plugin");
        r0.L$0 = r10;
        r0.label = 1;
        if (r11.a_(r0) != r2) goto L16;
        return r2;
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        r0 = new AwaitKt$joinAll$3(r8);
        goto L8
    }
}

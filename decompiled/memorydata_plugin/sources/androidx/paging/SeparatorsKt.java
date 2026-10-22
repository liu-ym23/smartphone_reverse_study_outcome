package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\n\u001ak\u0010\u000b\u001a\u00020\f\"\b\b\u0000\u0010\r*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u0002H\r*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u00010\u000e2\b\u0010\u0004\u001a\u0004\u0018\u0001H\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\u0011\u001aI\u0010\u000b\u001a\u00020\f\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u000e2\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\u0012\u001ax\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u00150\u0014\"\b\b\u0000\u0010\u0002*\u0002H\r\"\b\b\u0001\u0010\r*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172.\u0010\u0018\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001ae\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\r0\u0001\"\b\b\u0000\u0010\r*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u0002H\r*\b\u0012\u0004\u0012\u0002H\u00020\u00012.\u0010\u0018\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"separatorPage", "Landroidx/paging/TransformablePage;", ExifInterface.GPS_DIRECTION_TRUE, "", "separator", "originalPageOffsets", "", "hintOriginalPageOffset", "", "hintOriginalIndex", "(Ljava/lang/Object;[III)Landroidx/paging/TransformablePage;", "addSeparatorPage", "", "R", "", "adjacentPageBefore", "adjacentPageAfter", "(Ljava/util/List;Ljava/lang/Object;Landroidx/paging/TransformablePage;Landroidx/paging/TransformablePage;II)V", "(Ljava/util/List;Ljava/lang/Object;[III)V", "insertEventSeparators", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PageEvent;", "terminalSeparatorType", "Landroidx/paging/TerminalSeparatorType;", "generator", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/flow/Flow;Landroidx/paging/TerminalSeparatorType;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "insertInternalSeparators", "(Landroidx/paging/TransformablePage;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SeparatorsKt {

    /* JADX INFO: renamed from: androidx.paging.SeparatorsKt$insertInternalSeparators$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.SeparatorsKt", f = "Separators.kt", i = {0, 0, 0, 0, 0, 0}, l = {82}, m = "insertInternalSeparators", n = {"$this$insertInternalSeparators", "generator", "outputList", "outputIndices", "item", "i"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
    static final class AnonymousClass1<R, T extends R> extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> r3) {
            super((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return SeparatorsKt.insertInternalSeparators(null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    public static final <R, T extends R> void addSeparatorPage(List<TransformablePage<R>> r2, R r3, TransformablePage<T> r4, TransformablePage<T> r5, int r6, int r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        int[] r0 = null;
        if (r4 == null) goto L5;
        int[] r9 = r4.getOriginalPageOffsets();
    L6:
        if (r5 == null) goto L8;
        r0 = r5.getOriginalPageOffsets();
    L8:
        if (r9 == null) goto L11;
        if (r0 == null) goto L11;
        r9 = CollectionsKt.toIntArray((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(ArraysKt.distinct(ArraysKt.plus(r9, r0)), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"));
    L16:
        addSeparatorPage(r8, r3, r9, r6, r7);
        return;
    L11:
        if (r9 != null) goto L14;
        if (r0 == null) goto L14;
        r9 = r0;
    L14:
        if (r9 == null) goto L19;
        if (r0 == null) goto L16;
    L19:
        throw new IllegalArgumentException("Separator page expected adjacentPageBefore or adjacentPageAfter, but both were null.");
    L5:
        r9 = null;
        goto L6
    }

    public static final <T> void addSeparatorPage(List<TransformablePage<T>> r2, T r3, int[] r4, int r5, int r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r4, "originalPageOffsets");
        if (r3 != null) goto L5;
        return;
    L5:
        r7.add(separatorPage(r3, r4, r5, r6));
    }

    public static final <T extends R, R> i<PageEvent<R>> insertEventSeparators(i<? extends PageEvent<T>> r4, TerminalSeparatorType r5, Function3<? super T, ? super T, ? super Continuation<? super R>, ? extends Object> r6) {
        final i r7 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.memorydata.plugin");
        Function3 r8 = (Function3) ZeusTransformUtils.wrapperContextForParams(r6, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r5, "terminalSeparatorType");
        Intrinsics.checkNotNullParameter(r8, "generator");
        final SeparatorState r0 = new SeparatorState(r5, (Function3) ZeusTransformUtils.preCheckCast(new SeparatorsKt$insertEventSeparators$separatorState$1(r8, null), Function3.class, "com.obric.memorydata.plugin"));
        return (i) ZeusTransformUtils.preCheckCast(new SeparatorsKt$insertEventSeparators$$inlined$map$1(r7, r0), i.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x010d -> B:28:0x0116). Please report as a decompilation issue!!! */
    public static final <R, T extends R> Object insertInternalSeparators(TransformablePage<T> r13, Function3<? super T, ? super T, ? super Continuation<? super R>, ? extends Object> r14, Continuation<? super TransformablePage<R>> r15) {
        Function3 r16 = (Function3) ZeusTransformUtils.wrapperContextForParams(r14, Function3.class, "com.obric.memorydata.plugin");
        Continuation r17 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r17, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r17, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r18 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r19 = r0.I$1;
        int r110 = r0.I$0;
        Object r4 = r0.L$4;
        ArrayList r6 = (ArrayList) ZeusTransformUtils.preCheckCast(r0.L$3, ArrayList.class, "com.obric.memorydata.plugin");
        ArrayList r7 = (ArrayList) ZeusTransformUtils.preCheckCast(r0.L$2, ArrayList.class, "com.obric.memorydata.plugin");
        Function3 r8 = (Function3) ZeusTransformUtils.preCheckCast(r0.L$1, Function3.class, "com.obric.memorydata.plugin");
        TransformablePage<T> r9 = (TransformablePage) ZeusTransformUtils.preCheckCast(r0.L$0, TransformablePage.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
        AnonymousClass1 r5 = r0;
        Function3 r1 = r8;
        ArrayList r10 = r7;
        ArrayList r11 = r6;
        Object r12 = r2;
    L28:
        if (r18 == null) goto L30;
        r10.add(r18);
        r11.add(Boxing.boxInt(r110));
    L30:
        r10.add(r4);
        r11.add(Boxing.boxInt(r110));
        int r111 = r110 + 1;
        Object r20 = r12;
        ArrayList r21 = r11;
        ArrayList r22 = r10;
        TransformablePage<T> r112 = r9;
    L23:
        if (r111 >= r19) goto L32;
        T r23 = r112.getData().get(r111);
        T r24 = r112.getData().get(r111 - 1);
        r5.L$0 = r112;
        r5.L$1 = r1;
        r5.L$2 = r22;
        r5.L$3 = r21;
        r5.L$4 = r23;
        r5.I$0 = r111;
        r5.I$1 = r19;
        r5.label = 1;
        Object r25 = r1.invoke(r24, r23, r5);
        if (r25 != r20) goto L27;
        return r20;
    L27:
        r9 = r112;
        r110 = r111;
        r18 = r25;
        ArrayList r113 = r21;
        r12 = r20;
        r4 = r23;
        r10 = r22;
        r11 = r113;
        goto L28
    L32:
        if (r22.size() != r112.getData().size()) goto L35;
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type androidx.paging.TransformablePage<R of androidx.paging.SeparatorsKt.insertInternalSeparators>");
        return r112;
    L35:
        return new TransformablePage(r112.getOriginalPageOffsets(), (List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.memorydata.plugin"), r112.getHintOriginalPageOffset(), (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.memorydata.plugin"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r18);
        if (r13.getData().isEmpty() == false) goto L18;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type androidx.paging.TransformablePage<R of androidx.paging.SeparatorsKt.insertInternalSeparators>");
        return r13;
    L18:
        int r114 = r13.getData().size() + 4;
        ArrayList r26 = new ArrayList(r114);
        r21 = new ArrayList(r114);
        r26.add(CollectionsKt.first(r13.getData()));
        List<Integer> r115 = r13.getHintOriginalIndices();
        if (r115 == null) goto L21;
        int r116 = ((Number) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r115), Number.class, "com.obric.memorydata.plugin")).intValue();
    L22:
        r21.add(Boxing.boxInt(r116));
        r22 = r26;
        r20 = r2;
        r5 = r0;
        r1 = r16;
        r112 = r13;
        r19 = r13.getData().size();
        r111 = 1;
        goto L23
    L21:
        r116 = 0;
    L7:
        r0 = new AnonymousClass1(r17);
        goto L8
    }

    public static final <T> TransformablePage<T> separatorPage(T r1, int[] r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "separator");
        Intrinsics.checkNotNullParameter(r2, "originalPageOffsets");
        return new TransformablePage(r2, CollectionsKt.listOf(r1), r3, CollectionsKt.listOf(Integer.valueOf(r4)));
    }
}

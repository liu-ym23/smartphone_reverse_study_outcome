package com.obric.memorydata.database.util.file_utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFShapeGroup;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lorg/apache/poi/xssf/usermodel/XSSFShape;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.database.util.file_utils.BaseExcelProcessor$getAllXSSFShapes$1", f = "BaseExcelProcessor.kt", i = {0, 0, 0, 0}, l = {225}, m = "invokeSuspend", n = {"$this$sequence", "processedGroups", "queue", "shape"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class BaseExcelProcessor$getAllXSSFShapes$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super XSSFShape>, Continuation<? super Unit>, Object> {
    final /* synthetic */ XSSFDrawing $drawing;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    BaseExcelProcessor$getAllXSSFShapes$1(XSSFDrawing r3, Continuation<? super BaseExcelProcessor$getAllXSSFShapes$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$drawing = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        BaseExcelProcessor$getAllXSSFShapes$1 r0 = new BaseExcelProcessor$getAllXSSFShapes$1(this.$drawing, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(SequenceScope<? super XSSFShape> r3, Continuation<? super Unit> r4) {
        return invoke2((SequenceScope) ZeusTransformUtils.preCheckCast(r3, SequenceScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super XSSFShape> r3, Continuation<? super Unit> r4) {
        return ((BaseExcelProcessor$getAllXSSFShapes$1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), BaseExcelProcessor$getAllXSSFShapes$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x00b7 -> B:14:0x00ba). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        XSSFShape r2 = (XSSFShape) ZeusTransformUtils.preCheckCast(this.L$3, XSSFShape.class, "com.obric.memorydata.plugin");
        ArrayDeque r4 = (ArrayDeque) ZeusTransformUtils.preCheckCast(this.L$2, ArrayDeque.class, "com.obric.memorydata.plugin");
        Set r5 = (Set) ZeusTransformUtils.preCheckCast(this.L$1, Set.class, "com.obric.memorydata.plugin");
        SequenceScope r6 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L15:
        if (ZeusTransformUtils.instanceOf(r2, XSSFShapeGroup.class) == true) goto L17;
    L10:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L33;
        r2 = (XSSFShape) ZeusTransformUtils.preCheckCast(r4.removeFirst(), XSSFShape.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r6;
        this.L$1 = r5;
        this.L$2 = r4;
        this.L$3 = r2;
        this.label = 1;
        if (r6.yield(r2, r12) != r0) goto L15;
        return r0;
    L33:
        return Unit.INSTANCE;
    L17:
        if (r5.add(r2) == false) goto L10;
        List<XSSFShape> r13 = this.$drawing.getShapes((XSSFShapeGroup) ZeusTransformUtils.preCheckCast(r2, XSSFShapeGroup.class, "com.obric.memorydata.plugin"));
        if (r13 == null) goto L10;
        List r14 = CollectionsKt.filterNotNull((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin"));
        if (r14 == null) goto L10;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r15.iterator();
    L24:
        if (r16.hasNext() == false) goto L28;
        Object r8 = r16.next();
        if (Intrinsics.areEqual((XSSFShape) ZeusTransformUtils.preCheckCast(r8, XSSFShape.class, "com.obric.memorydata.plugin"), r2) == true) goto L24;
        r7.add(r8);
        goto L24
    L28:
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L30:
        if (r17.hasNext() == false) goto L10;
        r4.addLast((XSSFShape) ZeusTransformUtils.preCheckCast(r17.next(), XSSFShape.class, "com.obric.memorydata.plugin"));
        goto L30
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        SequenceScope r18 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
        Set r3 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r4 = new ArrayDeque();
        List<XSSFShape> r9 = this.$drawing.getShapes();
        Intrinsics.checkNotNullExpressionValue(r9, "getShapes(...)");
        r4.addAll((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.filterNotNull((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"));
        r6 = r18;
        r5 = r3;
        goto L10
    }
}

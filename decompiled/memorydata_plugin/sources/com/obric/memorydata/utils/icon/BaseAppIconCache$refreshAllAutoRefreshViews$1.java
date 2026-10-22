package com.obric.memorydata.utils.icon;

import android.content.Context;
import android.widget.ImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.utils.icon.BaseAppIconCache$refreshAllAutoRefreshViews$1", f = "BaseAppIconCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BaseAppIconCache$refreshAllAutoRefreshViews$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;

    BaseAppIconCache$refreshAllAutoRefreshViews$1(Continuation<? super BaseAppIconCache$refreshAllAutoRefreshViews$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new BaseAppIconCache$refreshAllAutoRefreshViews$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((BaseAppIconCache$refreshAllAutoRefreshViews$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), BaseAppIconCache$refreshAllAutoRefreshViews$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r14);
        Iterator r13 = ((Map) ZeusTransformUtils.preCheckCast(b.c(), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L6:
        if (r13.hasNext() == false) goto L10;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        ImageView r4 = (ImageView) ZeusTransformUtils.preCheckCast(r15.getKey(), ImageView.class, "com.obric.memorydata.plugin");
        b.a r16 = (b.a) ZeusTransformUtils.preCheckCast(r15.getValue(), b.a.class, "com.obric.memorydata.plugin");
        if (r4.isAttachedToWindow() == false) goto L6;
        b r2 = b.f13229a;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r16.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r4);
        r2.a(r3, r4, r16.a(), r16.b(), r16.c(), r16.d(), r16.e(), r16.f(), r16.g(), r16.h());
        goto L6
    L10:
        Iterator r17 = ((Map) ZeusTransformUtils.preCheckCast(b.d(), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L12:
        if (r17.hasNext() == false) goto L17;
        Map.Entry r18 = (Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        ImageView r1 = (ImageView) ZeusTransformUtils.preCheckCast(r18.getKey(), ImageView.class, "com.obric.memorydata.plugin");
        b.C0724b r19 = (b.C0724b) ZeusTransformUtils.preCheckCast(r18.getValue(), b.C0724b.class, "com.obric.memorydata.plugin");
        if (r1.isAttachedToWindow() == false) goto L12;
        b r5 = b.f13229a;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r19.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r1);
        r5.a(r6, r1, r19.a(), r19.b());
        goto L12
    L17:
        return Unit.INSTANCE;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

package com.bytedance.ai.widget.cache;

import android.util.LruCache;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.e0;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.WidgetResourceLoader$loadRtsBytecodeFromPackage$2", f = "WidgetResourceLoader.kt", i = {0}, l = {408}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nWidgetResourceLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetResourceLoader.kt\ncom/bytedance/ai/widget/cache/WidgetResourceLoader$loadRtsBytecodeFromPackage$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,407:1\n318#2,11:408\n*S KotlinDebug\n*F\n+ 1 WidgetResourceLoader.kt\ncom/bytedance/ai/widget/cache/WidgetResourceLoader$loadRtsBytecodeFromPackage$2\n*L\n144#1:408,11\n*E\n"})
final class WidgetResourceLoader$loadRtsBytecodeFromPackage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f2953c;

    public WidgetResourceLoader$loadRtsBytecodeFromPackage$2(e r5, Continuation r10) {
        this.f2953c = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        WidgetResourceLoader$loadRtsBytecodeFromPackage$2 r11 = new WidgetResourceLoader$loadRtsBytecodeFromPackage$2(this.f2953c, r10);
        r11.f2952b = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super byte[]> r10) {
        e r11 = this.f2953c;
        WidgetResourceLoader$loadRtsBytecodeFromPackage$2 r12 = new WidgetResourceLoader$loadRtsBytecodeFromPackage$2(r11, r10);
        r12.f2952b = r5;
        return r12.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r15) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.f2951a;
        if (r10 == 0) goto L9;
        if (r10 != 1) goto L8;
        CoroutineScope r14 = (CoroutineScope) this.f2952b;
        ResultKt.throwOnFailure(r15);
        return r15;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r15);
        CoroutineScope r16 = (CoroutineScope) this.f2952b;
        e r11 = this.f2953c;
        this.f2952b = r16;
        this.f2951a = 1;
        l r17 = new l(1, IntrinsicsKt.intercepted(this));
        r17.w();
        AtomicReference r12 = new AtomicReference(r17);
        r17.y(new com.bytedance.ai.process.resource.b(r12, 4));
        String r13 = r11.f2988a.getPackageName();
        String r18 = r11.f2988a.getWidgetId();
        StringBuilder r19 = new StringBuilder("Loader(");
        androidx.room.jarjarred.org.antlr.runtime.a.D(r19, r11.f2989b, ") loadRtsBytecodeFromPackage: start loading, packageName = ", r13, ", widgetId = ");
        String r20 = androidx.room.jarjarred.org.antlr.runtime.a.v(r19, r18, "WidgetResourceLoader", "tag");
        t0.d r110 = com.bytedance.ai.utils.c.f2846a;
        if (r110 == null) goto L12;
        r110.i("WidgetResourceLoader", r20);
    L12:
        Widget r21 = r11.f2990c;
        if (r21 == null) goto L15;
        LruCache r111 = e0.f2711a;
        e0.k(null, e0.d(r21, r21.G), new com.bytedance.ai.process.resource.b(r12, 5), new com.bytedance.ai.process.resource.b(r12, 6), false);
    L23:
        StringBuilder r22 = new StringBuilder("Loader(");
        androidx.room.jarjarred.org.antlr.runtime.a.D(r22, r11.f2989b, ") loadRtsBytecodeFromPackage: end loading, packageName = ", r13, ", widgetId = ");
        String r23 = androidx.room.jarjarred.org.antlr.runtime.a.v(r22, r18, "WidgetResourceLoader", "tag");
        t0.d r24 = com.bytedance.ai.utils.c.f2846a;
        if (r24 == null) goto L26;
        r24.i("WidgetResourceLoader", r23);
    L26:
        Object r112 = r17.v();
        if (r112 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        DebugProbesKt.probeCoroutineSuspended(this);
    L29:
        if (r112 != r5) goto L31;
        return r5;
    L31:
        return r112;
    L15:
        Intrinsics.checkNotNullParameter("WidgetResourceLoader", "tag");
        t0.d r25 = com.bytedance.ai.utils.c.f2846a;
        if (r25 == null) goto L18;
        r25.e("WidgetResourceLoader", "loadRtsBytecodeFromPackage: widget is NULL");
    L18:
        j r26 = (j) r12.getAndSet(null);
        if (r26 == null) goto L23;
        if (r26.isActive() == false) goto L23;
        r26.resumeWith(Result.m124constructorimpl(null));
        goto L23
    }
}

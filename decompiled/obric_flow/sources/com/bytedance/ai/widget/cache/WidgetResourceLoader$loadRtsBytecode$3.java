package com.bytedance.ai.widget.cache;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.WidgetResourceLoader$loadRtsBytecode$3", f = "WidgetResourceLoader.kt", i = {}, l = {327}, m = "invokeSuspend", n = {}, s = {})
final class WidgetResourceLoader$loadRtsBytecode$3 extends SuspendLambda implements Function1<Continuation<? super byte[]>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f2949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2950c;
    public final /* synthetic */ String d;

    public WidgetResourceLoader$loadRtsBytecode$3(e r5, String r10, String r11, Continuation r12) {
        this.f2949b = r5;
        this.f2950c = r10;
        this.d = r11;
        super(1, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation r5) {
        return new WidgetResourceLoader$loadRtsBytecode$3(this.f2949b, this.f2950c, this.d, r5);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super byte[]> r5) {
        return ((WidgetResourceLoader$loadRtsBytecode$3) create(r5)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2948a;
        boolean r12 = true;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L14:
        byte[] r13 = (byte[]) r10;
        if (r13 != null) goto L17;
    L33:
        String r14 = f4.a.b(new StringBuilder("Loader("), this.f2949b.f2989b, ") loadRtsBytecode: ERROR, widget is NULL");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L37;
        r15.e("WidgetResourceLoader", r14);
    L37:
        return this.f2949b.e;
    L17:
        if (r13.length == 0) goto L33;
        String r16 = f4.a.b(new StringBuilder("Loader("), this.f2949b.f2989b, ") loadRtsBytecode: load from package successfully");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L22;
        r17.i("WidgetResourceLoader", r16);
    L22:
        this.f2949b.e = r13;
        boolean r18 = a.f2980a;
        String r19 = this.f2950c;
        String r20 = this.d;
        Intrinsics.checkNotNullParameter(r19, "packageName");
        Intrinsics.checkNotNullParameter(r20, "widgetId");
        Intrinsics.checkNotNullParameter(r13, "bytes");
        if (a.f2980a == false) goto L31;
        ConcurrentHashMap r21 = a.d;
        if (r21.size() >= 3) goto L31;
        if (r21.put(a.a(r19, r20), r13) != null) goto L31;
    L32:
        Boxing.boxBoolean(r12);
    L31:
        r12 = false;
        goto L32
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        String r22 = f4.a.b(new StringBuilder("Loader("), this.f2949b.f2989b, ") loadRtsBytecode: load from package start");
        t0.d r23 = com.bytedance.ai.utils.c.f2846a;
        if (r23 == null) goto L11;
        r23.i("WidgetResourceLoader", r22);
    L11:
        e r24 = this.f2949b;
        this.f2948a = 1;
        r10 = BuildersKt.withContext(t2.b.f22089a, new WidgetResourceLoader$loadRtsBytecodeFromPackage$2(r24, null), this);
        if (r10 != r5) goto L14;
        return r5;
    }
}

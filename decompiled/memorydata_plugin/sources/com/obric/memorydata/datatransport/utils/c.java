package com.obric.memorydata.datatransport.utils;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001Bè\u0001\u0012y\b\u0002\u0010\u0002\u001as\b\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012/\u0012-\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012d\b\u0002\u0010\u000f\u001a^\b\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012/\u0012-\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012JB\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0086@¢\u0006\u0002\u0010\u0017R\u0081\u0001\u0010\u0002\u001as\b\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012/\u0012-\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013Rl\u0010\u000f\u001a^\b\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012/\u0012-\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/AttachmentInputStreamOpener;", "", "privilegedOpen", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, ObricMemoryConstants.KEY_PACKAGE_NAME, "uri", "Lkotlin/Function2;", "Ljava/io/InputStream;", "Lkotlin/coroutines/Continuation;", "", "consume", "", "fallbackOpen", "Lkotlin/Function3;", "<init>", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function3;)V", "Lkotlin/jvm/functions/Function4;", "Lkotlin/jvm/functions/Function3;", "open", "Lcom/obric/memorydata/datatransport/utils/AttachmentStreamOpenResult;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function4<String, String, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Integer>, Object> f9830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function3<String, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object> f9831b;

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public c(Function4<? super String, ? super String, ? super Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object>, ? super Continuation<? super Integer>, ? extends Object> r3, Function3<? super String, ? super Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object>, ? super Continuation<? super Unit>, ? extends Object> r4) {
        Function4<String, String, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Integer>, Object> r5 = (Function4) ZeusTransformUtils.wrapperContextForParams(r3, Function4.class, "com.obric.memorydata.plugin");
        Function3<String, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object> r6 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "privilegedOpen");
        Intrinsics.checkNotNullParameter(r6, "fallbackOpen");
        this.f9830a = r5;
        this.f9831b = r6;
    }

    public /* synthetic */ c(Function4 r3, Function3 r4, int r5, DefaultConstructorMarker r6) {
        Function4 r7 = (Function4) ZeusTransformUtils.wrapperContextForParams(r3, Function4.class, "com.obric.memorydata.plugin");
        Function3 r8 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = (Function4) ZeusTransformUtils.preCheckCast(new AttachmentInputStreamOpener$1(null), Function4.class, "com.obric.memorydata.plugin");
    L6:
        if ((r5 & 2) == 0) goto L8;
        r8 = (Function3) ZeusTransformUtils.preCheckCast(new AttachmentInputStreamOpener$2(null), Function3.class, "com.obric.memorydata.plugin");
    L8:
        this(r7, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(String r12, String r13, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r14, Continuation<? super d> r15) {
        Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r16 = (Function2) ZeusTransformUtils.wrapperContextForParams(r14, Function2.class, "com.obric.memorydata.plugin");
        Continuation r17 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r17, AttachmentInputStreamOpener$open$1.class) == false) goto L7;
        AttachmentInputStreamOpener$open$1 r0 = (AttachmentInputStreamOpener$open$1) ZeusTransformUtils.preCheckCast(r17, AttachmentInputStreamOpener$open$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r18 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        int r5 = 1;
        if (r3 == 0) goto L26;
        if (r3 == 1) goto L21;
        if (r3 != 2) goto L20;
        int r11 = r0.I$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L15 CancellationException -> L17
    L60:
    L80:
        return (d) ZeusTransformUtils.preCheckCast(d.b.f9834a, d.class, "com.obric.memorydata.plugin");
    L15:
        th = th;
    L65:
        return (d) ZeusTransformUtils.preCheckCast(new d.a(r11, th), d.class, "com.obric.memorydata.plugin");
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        Ref.BooleanRef r19 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(r0.L$4, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r110 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$3, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r16 = (Function2) ZeusTransformUtils.preCheckCast(r0.L$2, Function2.class, "com.obric.memorydata.plugin");
        r13 = (String) ZeusTransformUtils.preCheckCast(r0.L$1, String.class, "com.obric.memorydata.plugin");
        c r4 = (c) ZeusTransformUtils.preCheckCast(r0.L$0, c.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L24 CancellationException -> L67
        Ref.BooleanRef r6 = r19;
        c this = r4;
    L79:
        r5 = ((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L33 CancellationException -> L67
    L45:
        Throwable r111 = (Throwable) ZeusTransformUtils.preCheckCast(r110.element, Throwable.class, "com.obric.memorydata.plugin");
        if (r111 == null) goto L53;
        if (ZeusTransformUtils.instanceOf(r111, CancellationException.class) == false) goto L50;
        throw r111;
    L50:
        return new d.a(r5, r111);
    L53:
        if (r6.element == true) goto L55;
        Function3<String, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object> r112 = this.f9831b;     // Catch: CancellationException -> L17 Throwable -> L62
        r0.L$0 = null;     // Catch: CancellationException -> L17 Throwable -> L62
        r0.L$1 = null;     // Catch: CancellationException -> L17 Throwable -> L62
        r0.L$2 = null;     // Catch: CancellationException -> L17 Throwable -> L62
        r0.L$3 = null;     // Catch: CancellationException -> L17 Throwable -> L62
        r0.L$4 = null;     // Catch: CancellationException -> L17 Throwable -> L62
        r0.I$0 = r5;     // Catch: CancellationException -> L17 Throwable -> L62
        r0.label = 2;     // Catch: CancellationException -> L17 Throwable -> L62
        if (r112.invoke(r13, r16, r0) != r2) goto L59;
        return r2;
    L59:
        r11 = r5;
    L62:
        th = th;
        r11 = r5;
        goto L65
    L55:
        return d.b.f9834a;
    L33:
        Object th = th;
        Ref.BooleanRef r9 = r6;
        r4 = this;
        r19 = r9;
    L38:
        if (r19.element == true) goto L44;
        Throwable r7 = (Throwable) ZeusTransformUtils.preCheckCast(r110.element, Throwable.class, "com.obric.memorydata.plugin");
        T r113 = th;
        if (r7 == null) goto L43;
        r113 = r7;
    L43:
        r110.element = r113;
    L44:
        c r10 = r4;
        r6 = r19;
        this = r10;
    L24:
        th = th;
        goto L38
    L26:
        ResultKt.throwOnFailure(r18);
        Ref.ObjectRef r114 = new Ref.ObjectRef();
        r6 = new Ref.BooleanRef();
        Function4<String, String, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Integer>, Object> r8 = this.f9830a;     // Catch: Throwable -> L35 CancellationException -> L67
        AttachmentInputStreamOpener$open$privilegedStatus$1 r20 = new AttachmentInputStreamOpener$open$privilegedStatus$1(r16, r6, r114, null);     // Catch: Throwable -> L35 CancellationException -> L67
        r0.L$0 = this;     // Catch: Throwable -> L35 CancellationException -> L67
        r0.L$1 = r13;     // Catch: Throwable -> L35 CancellationException -> L67
        r0.L$2 = r16;     // Catch: Throwable -> L35 CancellationException -> L67
        r0.L$3 = r114;     // Catch: Throwable -> L35 CancellationException -> L67
        r0.L$4 = r6;     // Catch: Throwable -> L35 CancellationException -> L67
        r0.label = 1;     // Catch: Throwable -> L35 CancellationException -> L67
        Object r115 = r8.invoke(r12, r13, r20, r0);     // Catch: Throwable -> L35 CancellationException -> L67
        if (r115 != r2) goto L30;
        return r2;
    L30:
        r18 = r115;
        r110 = r114;
    L35:
        th = move-exception;
        r4 = this;
        r19 = r6;
        th = th;
        r110 = r114;
    L17:
        e = move-exception;
        throw e;
    L67:
        e = move-exception;
        throw e;
    L7:
        r0 = new AttachmentInputStreamOpener$open$1(this, r17);
        goto L8
    }
}

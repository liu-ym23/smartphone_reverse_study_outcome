package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aQ\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\t\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"runBlocking", ExifInterface.GPS_DIRECTION_TRUE, "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/BuildersKt")
final /* synthetic */ class j {
    public static final <T> T a(CoroutineContext r5, Function2<? super al, ? super Continuation<? super T>, ? extends Object> r6) {
        CoroutineContext r7 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r5, CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        Thread r0 = Thread.currentThread();
        ContinuationInterceptor r2 = (ContinuationInterceptor) ZeusTransformUtils.preCheckCast(r7.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(ContinuationInterceptor.Key, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), ContinuationInterceptor.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        bg r3 = cx.f17302a.a();
        CoroutineContext r9 = ag.a((al) ZeusTransformUtils.preCheckCast(bp.f17245a, al.class, "com.obric.memorydata.plugin"), r7.plus((CoroutineContext) ZeusTransformUtils.preCheckCast(r3, CoroutineContext.class, "com.obric.memorydata.plugin")));
    L18:
        g r1 = new g(r9, r0, r3);
        r1.a(CoroutineStart.DEFAULT, r1, r8);
        return (T) r1.e();
    L5:
        bg r4 = null;
        if (ZeusTransformUtils.instanceOf(r2, bg.class) == false) goto L8;
        bg r10 = (bg) ZeusTransformUtils.preCheckCast(r2, bg.class, "com.obric.memorydata.plugin");
    L9:
        if (r10 != null) goto L11;
    L16:
        r3 = cx.f17302a.b();
    L17:
        r9 = ag.a((al) ZeusTransformUtils.preCheckCast(bp.f17245a, al.class, "com.obric.memorydata.plugin"), r7);
        goto L18
    L11:
        if (r10.g() == false) goto L13;
        r4 = r10;
    L13:
        if (r4 == null) goto L16;
        r3 = r4;
        goto L17
    L8:
        r10 = null;
        goto L9
    }

    public static /* synthetic */ Object a(CoroutineContext r1, Function2 r2, int r3, Object r4) {
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r1, CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = (CoroutineContext) ZeusTransformUtils.preCheckCast(EmptyCoroutineContext.INSTANCE, CoroutineContext.class, "com.obric.memorydata.plugin");
    L6:
        return i.a(r5, r6);
    }
}

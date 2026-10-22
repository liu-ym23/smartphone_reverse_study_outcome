package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002\u001a8\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012H\u0080\b¢\u0006\u0002\u0010\u0013\u001a4\u0010\u0014\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012H\u0080\b¢\u0006\u0002\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\n*\u00020\u0003H\u0002\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0003H\u0007\u001a\u0013\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c*\u00020\u001dH\u0080\u0010\u001a(\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006 "}, d2 = {"DEBUG_THREAD_NAME_SEPARATOR", "", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "foldCopies", "originalContext", "appendContext", "isNewCoroutine", "", "withContinuationContext", ExifInterface.GPS_DIRECTION_TRUE, "continuation", "Lkotlin/coroutines/Continuation;", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withCoroutineContext", "context", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hasCopyableElements", "newCoroutineContext", "addedContext", "Lkotlinx/coroutines/CoroutineScope;", "undispatchedCompletion", "Lkotlinx/coroutines/UndispatchedCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "updateUndispatchedCompletion", "oldValue", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ag {
    public static final String a(CoroutineContext r4) {
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin");
        if (an.b() == true) goto L5;
        return null;
    L5:
        aj r0 = (aj) ZeusTransformUtils.preCheckCast(r5.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(aj.f17208a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), aj.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        return null;
    L8:
        ak r6 = (ak) ZeusTransformUtils.preCheckCast(r5.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(ak.f17210a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), ak.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L12;
        String r7 = r6.a();
        if (r7 == null) goto L12;
    L14:
        return r7 + '#' + r0.a();
    L12:
        r7 = "coroutine";
        goto L14
    }

    public static final CoroutineContext a(CoroutineContext r2, CoroutineContext r3) {
        CoroutineContext r4 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin");
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        if (b(r5) == true) goto L7;
        return r4.plus(r5);
    L7:
        return a(r4, r5, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, kotlin.coroutines.CoroutineContext] */
    private static final CoroutineContext a(CoroutineContext r4, CoroutineContext r5, final boolean r6) {
        CoroutineContext r7 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin");
        ?? r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r5, CoroutineContext.class, "com.obric.memorydata.plugin");
        boolean r0 = b(r7);
        boolean r2 = b(r8);
        if (r0 == true) goto L7;
        if (r2 == true) goto L7;
        return r7.plus(r8);
    L7:
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = r8;
        CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.preCheckCast(r7.fold(EmptyCoroutineContext.INSTANCE, (Function2) ZeusTransformUtils.preCheckCast(new CoroutineContextKt$foldCopies$folded$1(r1, r6), Function2.class, "com.obric.memorydata.plugin")), CoroutineContext.class, "com.obric.memorydata.plugin");
        if (r2 == false) goto L11;
        r1.element = ((CoroutineContext) ZeusTransformUtils.preCheckCast(r1.element, CoroutineContext.class, "com.obric.memorydata.plugin")).fold(EmptyCoroutineContext.INSTANCE, (Function2) ZeusTransformUtils.preCheckCast(CoroutineContextKt$foldCopies$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin"));
    L11:
        return r9.plus((CoroutineContext) ZeusTransformUtils.preCheckCast(r1.element, CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    public static final CoroutineContext a(al r4, CoroutineContext r5) {
        al r6 = (al) ZeusTransformUtils.wrapperContextForParams(r4, al.class, "com.obric.memorydata.plugin");
        CoroutineContext r7 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r5, CoroutineContext.class, "com.obric.memorydata.plugin");
        CoroutineContext r8 = a(r6.getCoroutineContext(), r7, true);
        if (an.b() == false) goto L5;
        CoroutineContext r9 = r8.plus((CoroutineContext) ZeusTransformUtils.preCheckCast(new aj(an.d().incrementAndGet()), CoroutineContext.class, "com.obric.memorydata.plugin"));
    L7:
        if (r8 != ba.a()) goto L9;
        return r9;
    L9:
        if (r8.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(ContinuationInterceptor.Key, CoroutineContext.Key.class, "com.obric.memorydata.plugin")) == null) goto L11;
        return r9;
    L11:
        return r9.plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin"));
    L5:
        r9 = r8;
        goto L7
    }

    public static final dc<?> a(Continuation<?> r4, CoroutineContext r5, Object r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r5, CoroutineContext.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, CoroutineStackFrame.class) == true) goto L6;
        return null;
    L6:
        if (r8.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(dd.f17310a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")) == null) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return null;
    L11:
        dc<?> r9 = a((CoroutineStackFrame) ZeusTransformUtils.preCheckCast(r7, CoroutineStackFrame.class, "com.obric.memorydata.plugin"));
        if (r9 == null) goto L14;
        r9.a(r8, r6);
    L14:
        return r9;
    L8:
        r0 = false;
        goto L9
    }

    public static final dc<?> a(CoroutineStackFrame r3) {
        CoroutineStackFrame r4 = (CoroutineStackFrame) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineStackFrame.class, "com.obric.memorydata.plugin");
    L4:
        if (ZeusTransformUtils.instanceOf(r4, aw.class) == true) goto L5;
        r4 = r4.getCallerFrame();
        if (r4 == null) goto L8;
        if (ZeusTransformUtils.instanceOf(r4, dc.class) == false) goto L4;
        return (dc) ZeusTransformUtils.preCheckCast(r4, dc.class, "com.obric.memorydata.plugin");
    L8:
        return null;
    L5:
        return null;
    }

    private static final boolean b(CoroutineContext r4) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin")).fold(false, (Function2) ZeusTransformUtils.preCheckCast(CoroutineContextKt$hasCopyableElements$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }
}

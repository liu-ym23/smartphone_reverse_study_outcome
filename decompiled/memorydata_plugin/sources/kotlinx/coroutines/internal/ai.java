package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u001a9\u0010\b\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u000b\u001a\u0002H\t2\u0006\u0010\f\u001a\u0002H\t2\u0010\u0010\r\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u000f0\u000eH\u0002¢\u0006\u0002\u0010\u0010\u001a\u001e\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u000f0\u000e2\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014H\u0002\u001a1\u0010\u0015\u001a\u00020\u00162\u0010\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u000f0\u00182\u0010\u0010\f\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u000f0\u000eH\u0002¢\u0006\u0002\u0010\u0019\u001a\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\nH\u0080H¢\u0006\u0002\u0010\u001d\u001a+\u0010\u001e\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u001c\u001a\u0002H\t2\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0002\u0010\u001f\u001a\u001f\u0010 \u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u001c\u001a\u0002H\tH\u0000¢\u0006\u0002\u0010!\u001a,\u0010 \u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u001c\u001a\u0002H\t2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\"H\u0080\b¢\u0006\u0002\u0010#\u001a \u0010$\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u001c\u001a\u0002H\tH\u0081\b¢\u0006\u0002\u0010!\u001a\u001f\u0010%\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u001c\u001a\u0002H\tH\u0001¢\u0006\u0002\u0010!\u001a1\u0010&\u001a\u0018\u0012\u0004\u0012\u0002H\t\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0001j\u0002`\u000f0\u00180'\"\b\b\u0000\u0010\t*\u00020\n*\u0002H\tH\u0002¢\u0006\u0002\u0010(\u001a\u001c\u0010)\u001a\u00020**\u00060\u0001j\u0002`\u000f2\n\u0010+\u001a\u00060\u0001j\u0002`\u000fH\u0002\u001a#\u0010,\u001a\u00020-*\f\u0012\b\u0012\u00060\u0001j\u0002`\u000f0\u00182\u0006\u0010.\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010/\u001a\u0014\u00100\u001a\u00020\u0016*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a\u0010\u00101\u001a\u00020**\u00060\u0001j\u0002`\u000fH\u0000\u001a\u001b\u00102\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n*\u0002H\tH\u0002¢\u0006\u0002\u0010!\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\n \u0005*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000*\f\b\u0000\u00103\"\u00020\u00132\u00020\u0013*\f\b\u0000\u00104\"\u00020\u00012\u00020\u0001¨\u00065"}, d2 = {"ARTIFICIAL_FRAME", "Ljava/lang/StackTraceElement;", "baseContinuationImplClass", "", "baseContinuationImplClassName", "kotlin.jvm.PlatformType", "stackTraceRecoveryClass", "stackTraceRecoveryClassName", "createFinalException", ExifInterface.LONGITUDE_EAST, "", "cause", "result", "resultStackTrace", "Ljava/util/ArrayDeque;", "Lkotlinx/coroutines/internal/StackTraceElement;", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "createStackTrace", "continuation", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "mergeRecoveredTraces", "", "recoveredStacktrace", "", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "recoverAndThrow", "", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverFromStackFrame", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "unwrap", "unwrapImpl", "causeAndStacktrace", "Lkotlin/Pair;", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "elementWiseEquals", "", "e", "firstFrameIndex", "", "methodName", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "initCause", "isArtificial", "sanitizeStackTrace", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final StackTraceElement f17560a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f17561b = null;
    private static final String c = null;

    static {
        Object r0 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        Object r1 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        f17560a = new a.a().b();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        Object r4 = Result.m1421constructorimpl(ZeusTransformUtils.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl", "com.obric.memorydata.plugin").getCanonicalName());     // Catch: Throwable -> L5
    L8:
        if (Result.m1424exceptionOrNullimpl(r4) != null) goto L10;
        r1 = r4;
    L10:
        f17561b = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        Object r5 = Result.m1421constructorimpl(ZeusTransformUtils.forName("kotlinx.coroutines.internal.StackTraceRecoveryKt", "com.obric.memorydata.plugin").getCanonicalName());     // Catch: Throwable -> L13
    L16:
        if (Result.m1424exceptionOrNullimpl(r5) != null) goto L18;
        r0 = r5;
    L18:
        c = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        return;
    L13:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private static final int a(StackTraceElement[] r3, String r4) {
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (Intrinsics.areEqual(r4, r3[r1].getClassName()) == true) goto L12;
        r1 = r1 + 1;
        goto L3
    L12:
        return r1;
    L8:
        return -1;
    }

    public static final <E extends Throwable> E a(E r1) {
        if (kotlinx.coroutines.an.c() == true) goto L5;
        return r1;
    L5:
        Throwable r0 = n.a(r1);
        if (r0 != null) goto L9;
        return r1;
    L9:
        return (E) c(r0);
    }

    private static final <E extends Throwable> E a(E r6, E r7, ArrayDeque<StackTraceElement> r8) {
        r8.addFirst(f17560a);
        StackTraceElement[] r9 = r6.getStackTrace();
        int r0 = a(r9, f17561b);
        int r2 = 0;
        if (r0 != (-1)) goto L6;
        r7.setStackTrace((StackTraceElement[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).toArray(new StackTraceElement[0]), StackTraceElement[].class, "com.obric.memorydata.plugin"));
        return r7;
    L6:
        StackTraceElement[] r3 = new StackTraceElement[r8.size() + r0];
        int r4 = 0;
    L7:
        if (r4 >= r0) goto L9;
        r3[r4] = r9[r4];
        r4 = r4 + 1;
        goto L7
    L9:
        Iterator<StackTraceElement> r10 = r8.iterator();
    L11:
        if (r10.hasNext() == false) goto L13;
        int r11 = r2 + 1;
        r3[r2 + r0] = (StackTraceElement) ZeusTransformUtils.preCheckCast(r10.next(), StackTraceElement.class, "com.obric.memorydata.plugin");
        r2 = r11;
        goto L11
    L13:
        r7.setStackTrace(r3);
        return r7;
    }

    public static final /* synthetic */ Throwable a(Throwable r2, CoroutineStackFrame r3) {
        return b(r2, (CoroutineStackFrame) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineStackFrame.class, "com.obric.memorydata.plugin"));
    }

    private static final ArrayDeque<StackTraceElement> a(CoroutineStackFrame r2) {
        CoroutineStackFrame r3 = (CoroutineStackFrame) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineStackFrame.class, "com.obric.memorydata.plugin");
        ArrayDeque<StackTraceElement> r0 = new ArrayDeque();
        StackTraceElement r1 = r3.getStackTraceElement();
        if (r1 == null) goto L6;
        r0.add(r1);
    L6:
        if (ZeusTransformUtils.instanceOf(r3, CoroutineStackFrame.class) == true) goto L9;
        r3 = null;
    L9:
        if (r3 == null) goto L16;
        r3 = r3.getCallerFrame();
        if (r3 == null) goto L16;
        StackTraceElement r4 = r3.getStackTraceElement();
        if (r4 == null) goto L6;
        r0.add(r4);
    L16:
        return r0;
    }

    private static final void a(StackTraceElement[] r6, ArrayDeque<StackTraceElement> r7) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (a(r6[r1]) == true) goto L9;
        r1 = r1 + 1;
    L9:
        int r2 = r1 + 1;
        int r3 = r6.length - 1;
        if (r2 <= r3) goto L12;
        return;
    L12:
        if (a(r6[r3], (StackTraceElement) ZeusTransformUtils.preCheckCast(r7.getLast(), StackTraceElement.class, "com.obric.memorydata.plugin")) == false) goto L14;
        r7.removeLast();
    L14:
        r7.addFirst(r6[r3]);
        if (r3 == r2) goto L21;
        r3 = r3 - 1;
        goto L12
    L21:
        return;
    L8:
        r1 = -1;
        goto L9
    }

    public static final boolean a(StackTraceElement r4) {
        return StringsKt.startsWith$default(r4.getClassName(), a.b.a(), false, 2, null);
    }

    private static final boolean a(StackTraceElement r2, StackTraceElement r3) {
        if (r2.getLineNumber() == r3.getLineNumber()) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(r2.getMethodName(), r3.getMethodName()) == false) goto L11;
        if (Intrinsics.areEqual(r2.getFileName(), r3.getFileName()) == false) goto L11;
        if (Intrinsics.areEqual(r2.getClassName(), r3.getClassName()) == false) goto L11;
        return true;
    }

    public static final <E extends Throwable> E b(E r6) {
        E r0 = (E) r6.getCause();
        if (r0 != null) goto L5;
    L15:
        return r6;
    L5:
        if (Intrinsics.areEqual(r0.getClass(), r6.getClass()) == false) goto L15;
        StackTraceElement[] r1 = r6.getStackTrace();
        int r2 = r1.length;
        boolean r3 = false;
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L13;
        if (a(r1[r4]) == true) goto L11;
        r4 = r4 + 1;
        goto L8
    L11:
        r3 = true;
    L13:
        if (r3 == false) goto L15;
        return r0;
    }

    private static final <E extends Throwable> E b(E r4, CoroutineStackFrame r5) {
        CoroutineStackFrame r6 = (CoroutineStackFrame) ZeusTransformUtils.wrapperContextForParams(r5, CoroutineStackFrame.class, "com.obric.memorydata.plugin");
        Pair r0 = d(r4);
        Throwable r2 = (Throwable) ZeusTransformUtils.preCheckCast(r0.component1(), Throwable.class, "com.obric.memorydata.plugin");
        StackTraceElement[] r1 = (StackTraceElement[]) ZeusTransformUtils.preCheckCast(r0.component2(), StackTraceElement[].class, "com.obric.memorydata.plugin");
        Throwable r3 = n.a(r2);
        if (r3 != null) goto L5;
        return r4;
    L5:
        ArrayDeque<StackTraceElement> r7 = a(r6);
        if (r7.isEmpty() == false) goto L8;
        return r4;
    L8:
        if (r2 == r4) goto L11;
        a(r1, r7);
    L11:
        return (E) a(r2, r3, r7);
    }

    private static final <E extends Throwable> E c(E r7) {
        StackTraceElement[] r0 = r7.getStackTrace();
        int r1 = r0.length;
        int r2 = r0.length - 1;
        if (r2 < 0) goto L10;
    L4:
        int r4 = r2 - 1;
        if (Intrinsics.areEqual(c, r0[r2].getClassName()) == true) goto L11;
        if (r4 < 0) goto L10;
        r2 = r4;
    L11:
        int r5 = r2 + 1;
        int r6 = a(r0, f17561b);
        int r8 = 0;
        if (r6 != (-1)) goto L14;
        int r3 = 0;
    L15:
        int r9 = (r1 - r2) - r3;
        StackTraceElement[] r10 = new StackTraceElement[r9];
    L16:
        if (r8 >= r9) goto L21;
        if (r8 != 0) goto L19;
        StackTraceElement r11 = f17560a;
    L20:
        r10[r8] = r11;
        r8 = r8 + 1;
        goto L16
    L19:
        r11 = r0[(r5 + r8) - 1];
        goto L20
    L21:
        r7.setStackTrace(r10);
        return r7;
    L14:
        r3 = r1 - r6;
    L10:
        r2 = -1;
        goto L11
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> d(E r6) {
        Throwable r0 = r6.getCause();
        if (r0 == null) goto L17;
        if (Intrinsics.areEqual(r0.getClass(), r6.getClass()) == false) goto L17;
        StackTraceElement[] r2 = r6.getStackTrace();
        int r3 = r2.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L12;
        if (a(r2[r4]) == true) goto L10;
        r4 = r4 + 1;
        goto L7
    L10:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L21;
        return TuplesKt.to(r0, r2);
    L21:
        return TuplesKt.to(r6, new StackTraceElement[0]);
    L12:
        r5 = false;
    L17:
        return TuplesKt.to(r6, new StackTraceElement[0]);
    }
}

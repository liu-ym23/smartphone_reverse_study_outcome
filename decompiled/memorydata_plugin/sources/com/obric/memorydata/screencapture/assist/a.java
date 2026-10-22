package com.obric.memorydata.screencapture.assist;

import android.app.assist.AssistStructure;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.obric.aiagent.product.platform.api.IPlatformService;
import com.obric.aiagent.product.platform.api.app.IObricActivityManager;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.e;
import com.obric.memorydata.middleware.api.logging.g;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.sdk.screencapture.ViewTreeNode;
import com.obric.memorydata.utils.am;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.da;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015J.\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u001cH\u0002J0\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0002J4\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\n\u0010 \u001a\u00060!j\u0002`\"H\u0002J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\f\u0010$\u001a\u00020\u0005*\u00020%H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/memorydata/screencapture/assist/AssistStructureViewTreeCapture;", "", "<init>", "()V", "TAG", "", "STRUCTURE_KEY", "REQUEST_TIMEOUT_MS", "", "MAX_DEPTH", "", "MAX_VISITED_NODES", "MAX_RESULT_NODES", "nextRequestId", "Ljava/util/concurrent/atomic/AtomicInteger;", "capture", "", "Lcom/obric/memorydata/sdk/screencapture/ViewTreeNode;", "displayId", "visibleOnly", "", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logCaptureSuccess", "", "nodes", "requestId", "getAssistStructure", "Landroid/app/assist/AssistStructure;", "Landroid/os/Bundle;", "flattenSafely", "structure", "onAssistStructureReadFailed", "error", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "flatten", "resourceName", "Landroid/app/assist/AssistStructure$ViewNode;", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12791a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicInteger f12792b = null;

    /* JADX INFO: renamed from: com.obric.memorydata.screencapture.assist.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\n"}, d2 = {"com/obric/memorydata/screencapture/assist/AssistStructureViewTreeCapture$capture$receiver$1", "Landroid/app/ITopActivityAssistDataReceiver$Stub;", "onResultData", "", "callbackRequestId", "", "resultData", "Landroid/os/Bundle;", "onScreenshotData", "screenshotData", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class aaC0690a extends android.app.a.AbstractBinderC0004a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f12793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ w<Bundle> f12794b;

        aaC0690a(int r3, w<Bundle> r4) {
            w<Bundle> r5 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.memorydata.plugin");
            this.f12793a = r3;
            this.f12794b = r5;
        }

        @Override // android.app.a
        public void a(int r7, Bundle r8) {
            if (r7 != this.f12793a) goto L5;
            this.f12794b.a(r8);
            return;
        L5:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AssistViewTreeCapture", "ignore callback requestId=" + r7 + " expected=" + this.f12793a, null, 4, null);
        }

        @Override // android.app.a
        public void b(int r1, Bundle r2) {
        }
    }

    static {
        f12791a = new a();
        f12792b = new AtomicInteger();
    }

    private a() {
    }

    private final AssistStructure a(Bundle r5) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        if (Build.VERSION.SDK_INT < 33) goto L8;
        Object r6 = ZeusTransformUtils.preCheckCast(r5.getParcelable("structure", AssistStructure.class), AssistStructure.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
    L7:
        AssistStructure r7 = (AssistStructure) r6;     // Catch: Throwable -> L14
    L12:
        Object r8 = Result.m1421constructorimpl(r7);     // Catch: Throwable -> L14
    L17:
        if (Result.m1427isFailureimpl(r8) == true) goto L21;
        r0 = r8;
    L21:
        return (AssistStructure) ZeusTransformUtils.preCheckCast(r0, AssistStructure.class, "com.obric.memorydata.plugin");
    L8:
        Parcelable r9 = r5.getParcelable("structure");     // Catch: Throwable -> L14
        if (ZeusTransformUtils.instanceOf(r9, AssistStructure.class) == false) goto L11;
        r6 = ZeusTransformUtils.preCheckCast(r9, AssistStructure.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        goto L7
    L11:
        r7 = null;
    L14:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    private final String a(AssistStructure.ViewNode r7) {
        String r6 = r7.getIdEntry();
        if (r6 != null) goto L6;
        return "";
    L6:
        String r0 = r7.getIdType();
        String r8 = r7.getIdPackage();
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L14:
        if (r2 == true) goto L24;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L18;
    L21:
        boolean r5 = true;
    L22:
        if (r5 == true) goto L24;
        StringBuilder r9 = new StringBuilder().append(r8).append(':');
    L32:
        return r9.append(r0).append('/').append(r6).toString();
    L18:
        if (r4.length() == 0) goto L21;
        r5 = false;
    L24:
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L27;
    L28:
        r3 = true;
    L29:
        if (r3 == true) goto L33;
        r9 = new StringBuilder();
        goto L32
    L33:
        return r6;
    L27:
        if (r10.length() != 0) goto L29;
    L9:
        if (r1.length() == 0) goto L12;
        r2 = false;
        goto L14
    }

    private final List<ViewTreeNode> a(int r8, int r9, boolean r10, RuntimeException r11) {
        o r7 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.w.f11638a, o.class, "com.obric.memorydata.plugin");
        e r6 = new e("screen_capture", null, "capture", 2, null);
        g r0 = new g();
        r0.a("request_id", Integer.valueOf(r8));
        r0.a("display_id", Integer.valueOf(r9));
        r0.a("visible_only", Boolean.valueOf(r10));
        r0.a("error_type", r11.getClass().getSimpleName());
        r7.a("assist_structure_read_failed", "AssistStructure 读取失败，ViewTree 已降级为空", r6, r0.a());
        return null;
    }

    private final List<ViewTreeNode> a(AssistStructure r14, boolean r15) {
        ArrayList r13 = new ArrayList();
        Ref.IntRef r10 = new Ref.IntRef();
        int r11 = r14.getWindowNodeCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        AssistStructure.WindowNode r0 = r14.getWindowNodeAt(r12);
        AssistStructure.ViewNode r3 = r0.getRootViewNode();
        Intrinsics.checkNotNullExpressionValue(r3, "getRootViewNode(...)");
        a(r10, r13, r15, r3, r0.getLeft(), r0.getTop(), 0, 0, true, 0);
        r12 = r12 + 1;
        goto L3
    L6:
        return (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
    }

    private final List<ViewTreeNode> a(AssistStructure r3, boolean r4, int r5, int r6) {
        return a(r3, r4);
    L5:
        e = move-exception;
        return a(r5, r6, r4, (RuntimeException) ZeusTransformUtils.preCheckCast(e, RuntimeException.class, "com.obric.memorydata.plugin"));
    }

    private final void a(List<ViewTreeNode> r7, int r8, int r9, boolean r10) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AssistViewTreeCapture", "captured requestId=" + r8 + " displayId=" + r9 + " nodes=" + ((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin")).size() + " visibleOnly=" + r10, false, 4, null);
    }

    private static final void a(Ref.IntRef r20, ArrayList<ViewTreeNode> r21, boolean r22, AssistStructure.ViewNode r23, int r24, int r25, int r26, int r27, boolean r28, int r29) {
        if (r29 < 64) goto L5;
        return;
    L5:
        if (r20.element < 5000) goto L7;
        return;
    L7:
        if (r21.size() >= 500) goto L54;
        r20.element++;
        int r14 = (r24 + r23.getLeft()) - r26;
        int r15 = (r25 + r23.getTop()) - r27;
        if (r28 == true) goto L12;
    L14:
        boolean r16 = false;
    L15:
        if (r22 == false) goto L19;
        if (r16 == true) goto L19;
    L48:
        int r8 = r23.getChildCount();
        int r7 = 0;
    L49:
        if (r7 >= r8) goto L55;
        AssistStructure.ViewNode r3 = r23.getChildAt(r7);
        Intrinsics.checkNotNullExpressionValue(r3, "getChildAt(...)");
        int r17 = r8;
        a(r20, r21, r22, r3, r14, r15, r23.getScrollX(), r23.getScrollY(), r16, r29 + 1);
        r7 = r7 + 1;
        r8 = r17;
        goto L49
    L55:
        return;
    L19:
        CharSequence r1 = r23.getText();
        String r2 = null;
        if (r1 == null) goto L22;
        String r4 = r1.toString();
    L24:
        if (r4 != null) goto L26;
        String r5 = "";
    L27:
        CharSequence r6 = r23.getContentDescription();
        if (r6 == null) goto L30;
        r2 = r6.toString();
    L30:
        if (r2 != null) goto L32;
        String r9 = "";
    L34:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L36;
        boolean r10 = true;
    L37:
        if (r10 == false) goto L39;
    L43:
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(r21, Collection.class, "com.obric.memorydata.plugin");
        String r12 = f12791a.a(r23);
        String r13 = r23.getClassName();
        if (r13 != null) goto L46;
        String r18 = "";
    L47:
        r11.add(new ViewTreeNode(r5, r9, r12, r18, new Rect(r14, r15, r23.getWidth() + r14, r23.getHeight() + r15), r16));
        goto L48
    L46:
        r18 = r13;
        goto L47
    L39:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L41;
        boolean r19 = true;
    L42:
        if (r19 == false) goto L48;
    L41:
        r19 = false;
        goto L42
    L36:
        r10 = false;
        goto L37
    L32:
        r9 = r2;
        goto L34
    L26:
        r5 = r4;
        goto L27
    L22:
        r4 = null;
        goto L24
    L12:
        if (r23.getVisibility() != 0) goto L14;
        r16 = true;
        goto L15
    }

    public final Object a(int r18, boolean r19, Continuation<? super List<ViewTreeNode>> r20) {
        int r2 = r18;
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, AssistStructureViewTreeCapture$capture$1.class) == false) goto L7;
        AssistStructureViewTreeCapture$capture$1 r5 = (AssistStructureViewTreeCapture$capture$1) ZeusTransformUtils.preCheckCast(r3, AssistStructureViewTreeCapture$capture$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r5.label;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        int r1 = r5.I$1;
        boolean r8 = r5.Z$0;
        int r9 = r5.I$0;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r5.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        Object r10 = r4;
        boolean r11 = r8;
        r2 = r9;
    L38:
        Bundle r12 = (Bundle) ZeusTransformUtils.preCheckCast(r10, Bundle.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L42;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AssistViewTreeCapture", "request timeout requestId=" + r1 + " displayId=" + r2, null, 4, null);
        return null;
    L42:
        AssistStructure r13 = r0.a(r12);
        if (r13 != null) goto L46;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AssistViewTreeCapture", "result missing structure requestId=" + r1 + " keys=" + r12.keySet(), null, 4, null);
        return null;
    L46:
        List<ViewTreeNode> r14 = r0.a(r13, r11, r1, r2);
        if (r14 != null) goto L49;
        return null;
    L49:
        r0.a(r14, r1, r2, r11);
        return r14;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        IPlatformService r15 = am.f13169a.a();
        if (r15 == null) goto L17;
        IObricActivityManager r16 = r15.activityManager();
    L18:
        if (r16 != null) goto L21;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AssistViewTreeCapture", "request skipped displayId=" + r2 + " reason=activity_manager_unavailable", null, 4, null);
        return null;
    L21:
        int r17 = f12792b.incrementAndGet();
        w r110 = y.a(null, 1, null);
        aaC0690a r111 = new aaC0690a(r17, r110);
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L24
        a r21 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        Object r22 = Result.m1421constructorimpl(Boxing.boxBoolean(r16.requestTopActivityAssistData(r17, r2, (android.app.a) ZeusTransformUtils.preCheckCast(r111, android.app.a.class, "com.obric.memorydata.plugin"))));     // Catch: Throwable -> L24
    L26:
        Throwable r23 = Result.m1424exceptionOrNullimpl(r22);
        if (r23 == null) goto L31;
        RunLog.INSTANCE.error("AssistViewTreeCapture", "request failed requestId=" + r17 + " displayId=" + r2, r23);
        r22 = Boxing.boxBoolean(false);
    L31:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r22, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L34;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AssistViewTreeCapture", "request rejected requestId=" + r17 + " displayId=" + r2, null, 4, null);
        return null;
    L34:
        Function2 r24 = (Function2) ZeusTransformUtils.preCheckCast(new AssistStructureViewTreeCapture$capture$bundle$1(r110, null), Function2.class, "com.obric.memorydata.plugin");
        r5.L$0 = this;
        r5.I$0 = r2;
        r11 = r19;
        r5.Z$0 = r11;
        r5.I$1 = r17;
        r5.label = 1;
        Object r25 = da.b(2500, r24, r5);
        if (r25 != r6) goto L37;
        return r6;
    L37:
        r10 = r25;
        r0 = this;
        r1 = r17;
    L24:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r22 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L26
    L17:
        r16 = null;
    L7:
        r5 = new AssistStructureViewTreeCapture$capture$1(this, r3);
        goto L8
    }
}

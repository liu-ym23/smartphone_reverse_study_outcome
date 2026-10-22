package com.obric.aikernel.res.downloader;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001!B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u0018\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0019J\u0019\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/obric/aikernel/res/downloader/DownloadSlot;", "", OaidModel.KEY_ID, "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "callback", "Lcom/obric/aikernel/res/downloader/DownloadSlot$TaskCallback;", "yieldCheckIntervalMs", "", "(ILkotlinx/coroutines/CoroutineScope;Lcom/obric/aikernel/res/downloader/DownloadSlot$TaskCallback;J)V", "getCallback", "()Lcom/obric/aikernel/res/downloader/DownloadSlot$TaskCallback;", "getId", "()I", "isIdle", "", "()Z", "setIdle", "(Z)V", "job", "Lkotlinx/coroutines/Job;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "runTask", "task", "Lcom/obric/aikernel/res/downloader/DownloadTask;", "(Lcom/obric/aikernel/res/downloader/DownloadTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", CommonConsts.APM_INNER_EVENT_COST_START, "TaskCallback", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final al f6021b;
    private final a c;
    private final long d;
    private volatile boolean e;
    private bx f;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/obric/aikernel/res/downloader/DownloadSlot$TaskCallback;", "", "onTaskFinished", "", "task", "Lcom/obric/aikernel/res/downloader/DownloadTask;", "orderTask", "pendingHeadTask", "pickTask", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        Object a(Continuation<? super j> r1);

        j b();

        void b(j r1);

        void c(j r1);
    }

    public h(int r3, al r4, a r5, long r6) {
        al r7 = (al) ZeusTransformUtils.wrapperContextForParams(r4, al.class, "com.obric.memorydata.plugin");
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "scope");
        Intrinsics.checkNotNullParameter(r8, "callback");
        this.f6020a = r3;
        this.f6021b = r7;
        this.c = r8;
        this.d = r6;
    }

    public /* synthetic */ h(int r8, al r9, a r10, long r11, int r13, DefaultConstructorMarker r14) {
        al r3 = (al) ZeusTransformUtils.wrapperContextForParams(r9, al.class, "com.obric.memorydata.plugin");
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r10, a.class, "com.obric.memorydata.plugin");
        if ((r13 & 8) == 0) goto L5;
        r11 = 1000;
    L5:
        this(r8, r3, r4, r11);
    }

    public static final /* synthetic */ Object a(h r2, j r3, Continuation r4) {
        return r2.a(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Class, java.lang.Class<com.obric.aikernel.res.downloader.h>] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.aikernel.res.downloader.h] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00d8 -> B:36:0x00db). Please report as a decompilation issue!!! */
    private final Object a(j r18, Continuation<? super Unit> r19) {
        h r0 = this;
        j r1 = r18;
        ?? r2 = h.class;
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, DownloadSlot$runTask$1.class) == false) goto L7;
        DownloadSlot$runTask$1 r5 = (DownloadSlot$runTask$1) ZeusTransformUtils.preCheckCast(r3, DownloadSlot$runTask$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r5.label;
        Object r8 = null;
        if (r7 == 0) goto L26;
        if (r7 == 1) goto L23;
        if (r7 == 2) goto L20;
        if (r7 != 3) goto L19;
        r1 = (j) ZeusTransformUtils.preCheckCast(r5.L$1, j.class, "com.obric.memorydata.plugin");
        h r9 = (h) ZeusTransformUtils.preCheckCast(r5.L$0, r2, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L16
        r2 = r9;
    L47:
        Object r10 = Result.m1421constructorimpl(Boxing.boxBoolean(((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue()));     // Catch: Throwable -> L16
        ?? r11 = r2;
    L51:
        if (Result.m1427isFailureimpl(r10) == true) goto L55;
        r8 = r10;
    L55:
        if (Intrinsics.areEqual(r8, Boxing.boxBoolean(false)) == true) goto L57;
        r11.c.c(r1);     // Catch: Throwable -> L60
    L58:
        r1.k();
        return Unit.INSTANCE;
    L57:
        r11.c.b(r1);     // Catch: Throwable -> L60
        goto L58
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ar r12 = (ar) ZeusTransformUtils.preCheckCast(r5.L$2, ar.class, "com.obric.memorydata.plugin");
        r1 = (j) ZeusTransformUtils.preCheckCast(r5.L$1, j.class, "com.obric.memorydata.plugin");
        h r13 = (h) ZeusTransformUtils.preCheckCast(r5.L$0, r2, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L60
        h r14 = r13;
    L36:
        j r15 = r14.c.b();     // Catch: Throwable -> L60
        if (r15 != null) goto L39;
    L41:
        boolean r16 = false;
    L42:
        if (r16 == true) goto L43;
    L31:
        h r17 = r14;
        if (r12.a() == false) goto L44;
        long r110 = r14.d;     // Catch: Throwable -> L60
        r5.L$0 = r14;     // Catch: Throwable -> L60
        r5.L$1 = r1;     // Catch: Throwable -> L60
        r5.L$2 = r12;     // Catch: Throwable -> L60
        r5.label = 2;     // Catch: Throwable -> L60
        r14 = r14;
        if (au.a(r110, r5) != r6) goto L36;
        return r6;
    L44:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L16
        r5.L$0 = r17;     // Catch: Throwable -> L16
        r5.L$1 = r1;     // Catch: Throwable -> L16
        r5.L$2 = null;     // Catch: Throwable -> L16
        r5.label = 3;     // Catch: Throwable -> L16
        r4 = r12.a(r5);     // Catch: Throwable -> L16
        r2 = r17;
        if (r4 != r6) goto L47;
        return r6;
    L43:
        r1.c(false);     // Catch: Throwable -> L60
        com.obric.aikernel.runtime.utils.d.f6216a.b("DownloadController", "DownloadSlot: Slot" + r14.f6020a + ' ' + r1.a() + " yielded to " + r15.a() + " taskPrior=" + r1.b() + " pendingPrior=" + r15.b() + " taskSize=" + r1.h() + " pendingSize=" + r15.h() + ' ' + r1.i());     // Catch: Throwable -> L60
        r17 = r14;
        goto L44
    L39:
        if (i.a(r1, r15) != true) goto L41;
        r16 = true;
        goto L42
    L23:
        r1 = (j) ZeusTransformUtils.preCheckCast(r5.L$1, j.class, "com.obric.memorydata.plugin");
        r0 = (h) ZeusTransformUtils.preCheckCast(r5.L$0, r2, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L60
    L30:
        r14 = r0;
        r12 = (ar) ZeusTransformUtils.preCheckCast(r4, ar.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L60
        goto L31
    L26:
        ResultKt.throwOnFailure(r4);
        r18.j();
        r5.L$0 = r0;     // Catch: Throwable -> L60
        r5.L$1 = r1;     // Catch: Throwable -> L60
        r5.label = 1;     // Catch: Throwable -> L60
        r4 = r1.e(r5);     // Catch: Throwable -> L60
        if (r4 != r6) goto L30;
        return r6;
    L60:
        th = move-exception;
        r1.k();
        throw th;
    L16:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L60
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        r11 = r2;
    L7:
        r5 = new DownloadSlot$runTask$1(r0, r3);
        goto L8
    }

    public final int a() {
        return this.f6020a;
    }

    public final void a(boolean r1) {
        this.e = r1;
    }

    public final a b() {
        return this.c;
    }

    public final void c() {
        bx r0 = this.f;
        if (r0 == null) goto L9;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("job");
        r0 = null;
    L7:
        if (r0.a() == false) goto L9;
        return;
    L9:
        this.f = kotlinx.coroutines.i.a(this.f6021b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new DownloadSlot$start$2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}

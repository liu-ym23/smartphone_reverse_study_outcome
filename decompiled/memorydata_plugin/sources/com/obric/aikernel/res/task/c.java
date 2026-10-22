package com.obric.aikernel.res.task;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.update.MetadataRequestException;
import com.obric.aikernel.res.update.MetadataRequestFailureKind;
import com.obric.aikernel.res.update.UpdateResult;
import com.obric.aikernel.res.update.f;
import com.obric.aikernel.res.update.n;
import com.obric.aikernel.res.update.q;
import com.obric.aikernel.runtime.utils.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ+\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/obric/aikernel/res/task/UpdateDaemon;", "", "ctx", "Lcom/obric/aikernel/res/PrmContext;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "updater", "Lcom/obric/aikernel/res/update/PackageUpdater;", "(Lcom/obric/aikernel/res/PrmContext;Lkotlinx/coroutines/CoroutineScope;Lcom/obric/aikernel/res/update/PackageUpdater;)V", "destroy", "", "forceUpdateAll", "onlyFetchConfig", "", "caller", "", "triggerReason", "(ZLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", CommonConsts.APM_INNER_EVENT_COST_INIT, "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PrmContext f6104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final al f6105b;
    private final n c;

    public c(PrmContext r3, al r4, n r5) {
        al r6 = (al) ZeusTransformUtils.wrapperContextForParams(r4, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "ctx");
        Intrinsics.checkNotNullParameter(r6, "scope");
        Intrinsics.checkNotNullParameter(r5, "updater");
        this.f6104a = r3;
        this.f6105b = r6;
        this.c = r5;
    }

    public static final /* synthetic */ PrmContext a(c r0) {
        return r0.f6104a;
    }

    public static final /* synthetic */ Object a(c r2, boolean r3, String r4, String r5, Continuation r6) {
        return r2.a(r3, r4, r5, (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Object a(c r1, boolean r2, String r3, String r4, Continuation r5, int r6, Object r7) {
        Continuation<? super Unit> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = ":autoupdate";
    L6:
        return r1.a(r2, r3, r4, r8);
    }

    private final Object a(boolean r27, String r28, String r29, Continuation<? super Unit> r30) {
        c r1 = this;
        boolean r2 = r27;
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r30, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, UpdateDaemon$forceUpdateAll$1.class) == false) goto L7;
        UpdateDaemon$forceUpdateAll$1 r4 = (UpdateDaemon$forceUpdateAll$1) ZeusTransformUtils.preCheckCast(r0, UpdateDaemon$forceUpdateAll$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        UpdateDaemon$forceUpdateAll$1 r9 = r4;
        Object r3 = r9.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r9.label;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        boolean r7 = r9.Z$0;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r9.L$2, String.class, "com.obric.memorydata.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.L$1, String.class, "com.obric.memorydata.plugin");
        c r11 = (c) ZeusTransformUtils.preCheckCast(r9.L$0, c.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L14
        String r14 = r8;
        String r12 = r10;
        r2 = r7;
        r1 = r11;
        Object r13 = r3;
    L30:
        q r15 = (q) ZeusTransformUtils.preCheckCast(r13, q.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        d.f6216a.b(PackageResourceManager.TAG, "UpdateDaemon: autoupdate result: " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r15.a().values(), Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, (Function1) ZeusTransformUtils.preCheckCast(UpdateDaemon$forceUpdateAll$attemptResult$1$1$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 31, null));     // Catch: Throwable -> L54
        f r16 = r15.b();     // Catch: Throwable -> L54
        if (r16 == null) goto L33;
        boolean r17 = r16.c();     // Catch: Throwable -> L54
    L45:
        if (r16 == null) goto L47;
        MetadataRequestFailureKind r18 = r16.d();     // Catch: Throwable -> L54
    L48:
        int r19 = r15.c();     // Catch: Throwable -> L54
        if (r17 == false) goto L51;
        boolean r20 = true;
    L52:
        Object r21 = Result.m1421constructorimpl(new com.obric.aikernel.res.update.a(r12, r2, r20, r18, r14, r19));     // Catch: Throwable -> L54
    L62:
        boolean r22 = r2;
        String r23 = r12;
        String r24 = r14;
        Throwable r25 = Result.m1424exceptionOrNullimpl(r21);
        if (r25 == null) goto L74;
        d.f6216a.c(PackageResourceManager.TAG, "UpdateDaemon: autoupdate failed " + ExceptionsKt.stackTraceToString(r25));
        if (ZeusTransformUtils.instanceOf(r25, MetadataRequestException.class) == false) goto L68;
        MetadataRequestException r110 = (MetadataRequestException) ZeusTransformUtils.preCheckCast(r25, MetadataRequestException.class, "com.obric.memorydata.plugin");
    L69:
        if (r110 == null) goto L72;
        MetadataRequestFailureKind r26 = r110.getKind();
        if (r26 == null) goto L72;
    L73:
        r21 = new com.obric.aikernel.res.update.a(r23, r22, false, r26, r24, 0);
    L72:
        r26 = MetadataRequestFailureKind.UNKNOWN_TRANSPORT;
        goto L73
    L68:
        r110 = null;
    L74:
        com.obric.aikernel.res.update.a r31 = (com.obric.aikernel.res.update.a) ZeusTransformUtils.preCheckCast(r21, com.obric.aikernel.res.update.a.class, "com.obric.memorydata.plugin");
        PackageResourceManager.PresmConfig.d r32 = r1.f6104a.getConfig().getUpdateListener();
        if (r32 == null) goto L78;
        r32.a(r31);
    L78:
        return Unit.INSTANCE;
    L54:
        th = th;
    L61:
        Result.Companion r33 = Result.Companion;
        r21 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L62
    L51:
        r20 = false;
        goto L52
    L47:
        r18 = null;
        goto L48
    L33:
        Iterable r34 = (Iterable) ZeusTransformUtils.preCheckCast(r15.a().values(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        if (ZeusTransformUtils.instanceOf(r34, Collection.class) == true) goto L36;
    L38:
        Iterator r35 = r34.iterator();     // Catch: Throwable -> L54
    L40:
        if (r35.hasNext() == false) goto L44;
        if (((UpdateResult) ZeusTransformUtils.preCheckCast(r35.next(), UpdateResult.class, "com.obric.memorydata.plugin")).getSuccess() == true) goto L40;
        r17 = false;
    L44:
        r17 = true;
        goto L45
    L36:
        if (((Collection) ZeusTransformUtils.preCheckCast(r34, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L38;
    L14:
        th = th;
        r14 = r8;
        r12 = r10;
        r2 = r7;
        r1 = r11;
        goto L61
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r3);
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L58
        n r37 = r1.c;     // Catch: Throwable -> L58
        List<String> r38 = r1.f6104a.getMetadataCtrl$resource_manager_release().c();     // Catch: Throwable -> L58
        int r111 = 0;
        boolean r112 = true;
        boolean r210 = true;
        boolean r211 = false;
        if (r2 == false) goto L22;
        boolean r212 = true;
    L23:
        n.b r39 = new n.b(r28, r111, r112, r210, r211, r212, false, 82, null);     // Catch: Throwable -> L58
        r9.L$0 = r1;     // Catch: Throwable -> L58
        r12 = r28;
        r9.L$1 = r12;     // Catch: Throwable -> L56
        r14 = r29;
        r9.L$2 = r14;     // Catch: Throwable -> L54
        r9.Z$0 = r2;     // Catch: Throwable -> L54
        r9.label = 1;     // Catch: Throwable -> L54
        r13 = n.b(r37, r38, r39, null, r9, 4, null);     // Catch: Throwable -> L54
        if (r13 != r5) goto L30;
        return r5;
    L56:
        th = th;
    L60:
        r14 = r29;
        goto L61
    L22:
        r212 = false;
    L58:
        th = th;
        r12 = r28;
    L7:
        r4 = new UpdateDaemon$forceUpdateAll$1(r1, r0);
        goto L8
    }

    public static final /* synthetic */ al b(c r0) {
        return r0.f6105b;
    }

    public final void a() {
        i.a(this.f6105b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new UpdateDaemon$init$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}

package com.obric.memorydata.memory.review;

import android.content.Context;
import android.net.Uri;
import com.obric.capabilitykit.entity.EntityContentProvider;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019J\u0006\u0010\u001a\u001a\u00020\u0017J\u0016\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/memory/review/RecorderEntityReDonateManager;", "", "<init>", "()V", "TAG", "", "REINDEX_ALL_DATA", "COLD_START_DELAY_MS", "", "RETRY_DELAY_MS", "MAX_RETRY_COUNT", "", "KEY_RE_DONATE_DONE", "recorderEntityProviderUri", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "Landroid/net/Uri;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "coldStartCheckScheduled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "triggerStarted", "scheduleColdStartCheck", "", "onColdStartCheck", "Lkotlin/Function0;", "triggerOnEntryGateEnabled", "triggerOnceIfEnabled", AILabCheckPermissionTask.KEY_SOURCE, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f10379a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f10380b = null;
    private static final al c = null;
    private static final AtomicBoolean d = null;
    private static final AtomicBoolean e = null;

    static {
        f10379a = new d();
        f10380b = Uri.parse("content://" + AppInfo.Recorder.getPackageName() + ".EntityContentProvider");
        c = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        d = new AtomicBoolean(false);
        e = new AtomicBoolean(false);
    }

    private d() {
    }

    public static final /* synthetic */ Object a(d r2, String r3, Continuation r4) {
        return r2.a(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x012a -> B:38:0x0145). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x013f -> B:37:0x0142). Please report as a decompilation issue!!! */
    private final Object a(String r14, Continuation<? super Unit> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, RecorderEntityReDonateManager$triggerOnceIfEnabled$1.class) == false) goto L7;
        RecorderEntityReDonateManager$triggerOnceIfEnabled$1 r0 = (RecorderEntityReDonateManager$triggerOnceIfEnabled$1) ZeusTransformUtils.preCheckCast(r16, RecorderEntityReDonateManager$triggerOnceIfEnabled$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        int r4 = 0;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        int r18 = r0.I$1;
        int r3 = r0.I$0;
        IStore r5 = (IStore) ZeusTransformUtils.preCheckCast(r0.L$1, IStore.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
    L37:
        IStore r19 = r5;
        r4 = r18;
        r14 = r6;
    L38:
        r4 = r4 + 1;
    L27:
        if (r4 < 4) goto L45;
    L39:
        r19.save("recorder_entity_re_donate_done", true);
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        if (r3 == 0) goto L42;
        StringBuilder r110 = new StringBuilder();
        String r111 = "recorder entity re-donate triggered, source=";
    L43:
        IRunLog.a.a(r1, "RecorderEntityReDonateManager", r110.append(r111).append(r14).toString(), false, 4, null);
        return Unit.INSTANCE;
    L42:
        r110 = new StringBuilder();
        r111 = "recorder entity re-donate stopped after retries, source=";
        goto L43
    L45:
        ZeusProviderTransform.call(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), f10380b, EntityContentProvider.d, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        r3 = 1;
    L30:
        th = move-exception;
        RunLog.INSTANCE.error("RecorderEntityReDonateManager", "recorder entity re-donate failed to trigger, attempt=" + (r4 + 1) + "/4, source=" + r14, th);
        if (r4 >= 3) goto L38;
        r0.L$0 = r14;
        r0.L$1 = r19;
        r0.I$0 = r3;
        r0.I$1 = r4;
        r0.label = 1;
        if (au.a(10000, r0) != r17) goto L36;
        return r17;
    L36:
        r6 = r14;
        r18 = r4;
        r5 = r19;
        goto L37
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        if (com.obric.memorydata.database.c.b.f8850a.a() == true) goto L20;
        IRunLog r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r112 = new StringBuilder();
        String r113 = "skip recorder entity re-donate, entry gate disabled, source=";
    L17:
        IRunLog.a.a(r7, "RecorderEntityReDonateManager", r112.append(r113).append(r14).toString(), false, 4, null);
        return Unit.INSTANCE;
    L20:
        if (e.compareAndSet(false, true) == true) goto L22;
        r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r112 = new StringBuilder();
        r113 = "skip recorder entity re-donate, already started in process, source=";
        goto L17
    L22:
        r19 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        if (r19.getBoolean("recorder_entity_re_donate_done", false) == false) goto L25;
        r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r112 = new StringBuilder();
        r113 = "skip recorder entity re-donate, already triggered, source=";
        goto L17
    L25:
        r3 = 0;
    L7:
        r0 = new RecorderEntityReDonateManager$triggerOnceIfEnabled$1(this, r16);
        goto L8
    }

    public static /* synthetic */ void a(d r1, Function0 r2, int r3, Object r4) {
        Function0<Unit> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = $$Lambda$d$BE84ltDOH63YH1fUnKlrxgDKeuM.INSTANCE;
    L5:
        r1.a(r5);
    }

    private static final Unit b() {
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$BE84ltDOH63YH1fUnKlrxgDKeuM() {
        return b();
    }

    public final void a() {
        i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new RecorderEntityReDonateManager$triggerOnEntryGateEnabled$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void a(Function0<Unit> r8) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "onColdStartCheck");
        if (d.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new RecorderEntityReDonateManager$scheduleColdStartCheck$2(r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}

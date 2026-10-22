package com.obric.aikernel.res.downloader;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.keva.KevaImpl;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0003\b\u0011 \u0018\u0000 M2\u00020\u0001:\u0001MB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020#J\u0012\u0010'\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0006\u0010*\u001a\u00020%J\u0012\u0010+\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u0012\u0010.\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0017\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u00101J\u000e\u00102\u001a\u0002032\u0006\u0010&\u001a\u00020#J,\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u0002062\u0006\u0010&\u001a\u00020#2\u0006\u00107\u001a\u00020#2\f\u00108\u001a\b\u0012\u0004\u0012\u0002090\u000eJ\u0010\u0010:\u001a\u0004\u0018\u00010\u00172\u0006\u00107\u001a\u00020#J\u0006\u0010;\u001a\u00020%J\u0012\u0010<\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020\u0017H\u0002J\u0012\u0010?\u001a\u0004\u0018\u00010\u00172\u0006\u0010@\u001a\u00020\u0019H\u0002J\u001b\u0010A\u001a\u0004\u0018\u00010\u00172\u0006\u0010@\u001a\u00020\u0019H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010BJ\u000e\u0010C\u001a\u00020%2\u0006\u0010&\u001a\u00020#J\u0012\u0010D\u001a\u00020\u00192\b\u0010>\u001a\u0004\u0018\u00010\u0017H\u0003J,\u0010E\u001a\u00020\u00062\u0006\u0010&\u001a\u00020#2\u0006\u00107\u001a\u00020#2\u0014\b\u0002\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020%0GJ\b\u0010H\u001a\u00020%H\u0002J\u001e\u0010I\u001a\u00020%2\u0006\u0010>\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u00192\u0006\u0010J\u001a\u00020\u0006J\u0010\u0010K\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003J \u0010L\u001a\u00020%2\u0006\u0010&\u001a\u00020#2\u0006\u0010@\u001a\u00020\u00192\b\b\u0002\u0010J\u001a\u00020\u0006R\u0012\u0010\u0005\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u001c8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00170\u001c8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006N"}, d2 = {"Lcom/obric/aikernel/res/downloader/DownloadController;", "", "context", "Lcom/obric/aikernel/res/PrmContext;", "(Lcom/obric/aikernel/res/PrmContext;)V", "downloadForegroundServiceActive", "", "downloadListener", "com/obric/aikernel/res/downloader/DownloadController$downloadListener$2$1", "getDownloadListener", "()Lcom/obric/aikernel/res/downloader/DownloadController$downloadListener$2$1;", "downloadListener$delegate", "Lkotlin/Lazy;", "downloadSlots", "", "Lcom/obric/aikernel/res/downloader/DownloadSlot;", "monitorDepend", "com/obric/aikernel/res/downloader/DownloadController$monitorDepend$2$1", "getMonitorDepend", "()Lcom/obric/aikernel/res/downloader/DownloadController$monitorDepend$2$1;", "monitorDepend$delegate", "orderedTasks", "", "Lcom/obric/aikernel/res/downloader/DownloadTask;", "parallelSize", "", "prmContext", "progressLogCheckpoints", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "slotCallback", "com/obric/aikernel/res/downloader/DownloadController$slotCallback$1", "Lcom/obric/aikernel/res/downloader/DownloadController$slotCallback$1;", "taskMap", "", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "group", "clearProgressLogCheckpoint", "entity", "Lcom/ss/android/socialbase/downloader/model/DownloadInfo;", "destroy", "formatDownloadError", "e", "Lcom/ss/android/socialbase/downloader/exception/BaseException;", "formatDownloadEvent", "getDownloadInfos", "Lcom/google/gson/JsonObject;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGroupProgress", "", "getOrNewTask", "config", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "taskId", KevaImpl.PrivateConstants.FILES_DIR_NAME, "Lcom/obric/aikernel/res/downloader/DownloadTask$FileInfo;", "getTask", CommonConsts.APM_INNER_EVENT_COST_INIT, "maybeLogDownloadProgress", "orderTask", "task", "pick", "prior", "pickTask", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeGroup", "removeOrderedTaskLocked", "removeTask", "action", "Lkotlin/Function1;", "startSlots", "startTask", TraceCons.METRIC_BACKGROUND, "syncDownloadForegroundServiceLocked", "updateGroupProp", "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6012a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PrmContext f6013b;
    private final al c;
    private final Map<String, j> d;
    private final List<j> e;
    private final Map<Integer, Integer> f;
    private boolean g;
    private final int h;
    private final b i;
    private final List<h> j;
    private final Lazy k;
    private final Lazy l;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/aikernel/res/downloader/DownloadController$Companion;", "", "()V", "TAG", "", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016J\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"com/obric/aikernel/res/downloader/DownloadController$slotCallback$1", "Lcom/obric/aikernel/res/downloader/DownloadSlot$TaskCallback;", "maxPriorTask", "Lcom/obric/aikernel/res/downloader/DownloadTask;", "getMaxPriorTask", "()Lcom/obric/aikernel/res/downloader/DownloadTask;", "setMaxPriorTask", "(Lcom/obric/aikernel/res/downloader/DownloadTask;)V", "onTaskFinished", "", "task", "orderTask", "pendingHead", "pendingHeadTask", "pickTask", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f6014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private j f6015b;

        b(d r1) {
            this.f6014a = r1;
        }

        private final j c() {
            d r3 = this.f6014a;
            monitor-enter(r3);
            j r0 = (j) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(d.a(r3)), j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r3);
            return r0;
        L7:
            th = move-exception;
            throw th;
        }

        public final j a() {
            return this.f6015b;
        }

        @Override // com.obric.aikernel.res.downloader.h.a
        public Object a(Continuation<? super j> r8) {
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r9, DownloadController$slotCallback$1$pickTask$1.class) == false) goto L7;
            DownloadController$slotCallback$1$pickTask$1 r0 = (DownloadController$slotCallback$1$pickTask$1) ZeusTransformUtils.preCheckCast(r9, DownloadController$slotCallback$1$pickTask$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r10 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            int r4 = 0;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            b this = (b) ZeusTransformUtils.preCheckCast(r0.L$0, b.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r10);
        L21:
            j r11 = (j) ZeusTransformUtils.preCheckCast(r10, j.class, "com.obric.memorydata.plugin");
            if (r11 == null) goto L28;
            int r1 = r11.b();
            j r5 = this.f6015b;
            if (r5 == null) goto L26;
            r4 = r5.b();
        L26:
            if (r1 <= r4) goto L30;
            this.f6015b = r11;
            return r11;
        L30:
            return r11;
        L28:
            return null;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r10);
            com.obric.aikernel.runtime.utils.d.f6216a.a("DownloadController", "pickTask: remain count: " + d.a(this.f6014a).size());
            d r12 = this.f6014a;
            j r6 = this.f6015b;
            if (r6 == null) goto L17;
            int r7 = r6.b();
        L18:
            r0.L$0 = this;
            r0.label = 1;
            r10 = d.a(r12, r7, r0);
            if (r10 != r2) goto L21;
            return r2;
        L17:
            r7 = 0;
        L7:
            r0 = new DownloadController$slotCallback$1$pickTask$1(this, r9);
            goto L8
        }

        public final void a(j r1) {
            this.f6015b = r1;
        }

        @Override // com.obric.aikernel.res.downloader.h.a
        public j b() {
            return c();
        }

        @Override // com.obric.aikernel.res.downloader.h.a
        public void b(j r5) {
            Intrinsics.checkNotNullParameter(r5, "task");
            com.obric.aikernel.runtime.utils.d.f6216a.a("DownloadController", "reorderTask " + r5.a());
            d r0 = this.f6014a;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (Intrinsics.areEqual(this.f6015b, r5) == false) goto L7;
            this.f6015b = null;     // Catch: Throwable -> L11
        L7:
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r0);
            d.a(this.f6014a, r5);
            d.b(this.f6014a);
        }

        @Override // com.obric.aikernel.res.downloader.h.a
        public void c(j r8) {
            Intrinsics.checkNotNullParameter(r8, "task");
            com.obric.aikernel.runtime.utils.d.f6216a.a("DownloadController", "onTaskFinished " + r8.a());
            if (Intrinsics.areEqual(this.f6015b, r8) == false) goto L5;
            this.f6015b = null;
        L5:
            d r0 = this.f6014a;
            monitor-enter(r0);
            d.b(r0, r8);     // Catch: Throwable -> L23
            monitor-exit(r0);
            if (r8.l() == false) goto L12;
        L14:
            d r9 = this.f6014a;
            monitor-enter(r9);
            d.a(r9, d.c(r9));     // Catch: Throwable -> L20
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L20
            monitor-exit(r9);
            d.b(this.f6014a);
            return;
        L20:
            th = move-exception;
            throw th;
        L12:
            if (d.a(this.f6014a, "", r8.a(), null, 4, null) == true) goto L14;
            com.obric.aikernel.runtime.utils.d.f6216a.f("DownloadController", "onTaskFinished: removeTask " + r8.a() + " failed!");
        L23:
            th = move-exception;
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public c(CoroutineExceptionHandler.a r3) {
            super((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(r3, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext r2, Throwable r3) {
            com.obric.aikernel.runtime.utils.d.f6216a.c("DownloadController", ((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin")) + " crashed " + ExceptionsKt.stackTraceToString(r3));
        }
    }

    static {
        f6012a = new a(null);
    }

    public d(final PrmContext r19) {
        Intrinsics.checkNotNullParameter(r19, "context");
        this.f6013b = r19;
        this.c = am.a(ba.c().plus((CoroutineContext) ZeusTransformUtils.preCheckCast(new ak("DownloadController"), CoroutineContext.class, "com.obric.memorydata.plugin")).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(cu.a(null, 1, null), CoroutineContext.class, "com.obric.memorydata.plugin")).plus((CoroutineContext) ZeusTransformUtils.preCheckCast((CoroutineExceptionHandler) ZeusTransformUtils.preCheckCast(new c(CoroutineExceptionHandler.f17198b), CoroutineExceptionHandler.class, "com.obric.memorydata.plugin"), CoroutineContext.class, "com.obric.memorydata.plugin")));
        this.d = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.e = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.f = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        int r2 = r19.getConfig().getParallelDownloadNum();
        this.h = r2;
        this.i = new b(this);
        int[] r3 = new int[r2];
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r2), Collection.class, "com.obric.memorydata.plugin");
        int r6 = 0;
        int r8 = 0;
    L3:
        if (r6 >= r2) goto L5;
        int r7 = r3[r6];
        r4.add(new h(r8, this.c, (h.a) ZeusTransformUtils.preCheckCast(this.i, h.a.class, "com.obric.memorydata.plugin"), 0, 8, null));
        r6 = r6 + 1;
        r8 = r8 + 1;
        r2 = r2;
        goto L3
    L5:
        this.j = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        this.k = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new DownloadController$downloadListener$2(r19, this), Function0.class, "com.obric.memorydata.plugin"));
        this.l = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new DownloadController$monitorDepend$2(r19), Function0.class, "com.obric.memorydata.plugin"));
        a();
    }

    private final j a(int r6) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.e, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L6;
        Object r7 = ZeusTransformUtils.preCheckCast(null, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
    L8:
        j r8 = (j) r7;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r8;
    L6:
        if (((j) ZeusTransformUtils.preCheckCast(this.e.get(0), j.class, "com.obric.memorydata.plugin")).b() >= r6) goto L9;
        r7 = ZeusTransformUtils.preCheckCast(null, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        goto L8
    L9:
        r7 = ZeusTransformUtils.preCheckCast(this.e.remove(0), j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0075 -> B:20:0x0078). Please report as a decompilation issue!!! */
    private final Object a(int r8, Continuation<? super j> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, DownloadController$pickTask$1.class) == false) goto L7;
        DownloadController$pickTask$1 r0 = (DownloadController$pickTask$1) ZeusTransformUtils.preCheckCast(r10, DownloadController$pickTask$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r7 = r0.I$0;
        j r12 = (j) ZeusTransformUtils.preCheckCast(r0.L$1, j.class, "com.obric.memorydata.plugin");
        d r4 = (d) ZeusTransformUtils.preCheckCast(r0.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
        r8 = r7;
        d this = r4;
        Object r5 = r11;
        j r13 = r12;
    L21:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L22;
    L15:
        r13 = this.a(r8);
        if (r13 == null) goto L22;
        r0.L$0 = this;
        r0.L$1 = r13;
        r0.I$0 = r8;
        r0.label = 1;
        r5 = r13.d(r0);
        if (r5 != r2) goto L21;
        return r2;
    L22:
        return r13;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
    L7:
        r0 = new DownloadController$pickTask$1(this, r10);
        goto L8
    }

    public static final /* synthetic */ Object a(d r2, int r3, Continuation r4) {
        return r2.a(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ String a(d r0, BaseException r1) {
        return r0.a(r1);
    }

    private final String a(BaseException r2) {
        if (r2 == null) goto L15;
        String r1 = r2.getMessage();
        if (r1 == null) goto L15;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L15;
        String r4 = " error=" + r1;
        if (r4 == null) goto L15;
        return r4;
    L8:
        r3 = false;
    L15:
        return "";
    }

    public static final /* synthetic */ List a(d r0) {
        return r0.e;
    }

    private final void a(PrmContext r6) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.d.values(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(Boolean.valueOf(((j) ZeusTransformUtils.preCheckCast(r2.next(), j.class, "com.obric.memorydata.plugin")).p()));
        goto L4
    L6:
        boolean r3 = e.a(r6.getConfig().getAppConfig().getEnableDownloadForegroundService(), e.a((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
        if (r3 != this.g) goto L9;
        return;
    L9:
        this.g = r3;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L17
        d r5 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r3 == false) goto L14;
        Function0<Unit> r7 = r6.getConfig().getAppConfig().getStartDownloadForegroundService();     // Catch: Throwable -> L17
    L13:
        r7.invoke();     // Catch: Throwable -> L17
        Object r8 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 == null) goto L26;
        com.obric.aikernel.runtime.utils.d.f6216a.f("DownloadController", "sync download foreground service failed shouldRun=" + r3 + ' ' + r9);
        return;
    L26:
        return;
    L14:
        r7 = r6.getConfig().getAppConfig().getStopDownloadForegroundService();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public static final /* synthetic */ void a(d r0, PrmContext r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(d r0, j r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(d r0, DownloadInfo r1) {
        r0.b(r1);
    }

    private final synchronized void a(j r6) {
        monitor-enter(this);
        int r0 = e.a(this.e, r6, (Function2) ZeusTransformUtils.preCheckCast(DownloadController$orderTask$removed$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
        if (r0 <= 1) goto L6;
        com.obric.aikernel.runtime.utils.d.f6216a.b("DownloadController", "dedupe queued download task " + r6.a() + " removed=" + r0 + " queueSize=" + this.e.size() + " prior=" + r6.b() + " size=" + r6.h());     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private final void a(DownloadInfo r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        monitor-enter(this);
        Integer r0 = e.a((Integer) ZeusTransformUtils.preCheckCast(this.f.get(Integer.valueOf(r6.getId())), Integer.class, "com.obric.memorydata.plugin"), r6.getDownloadProcess());     // Catch: Throwable -> L14
        if (r0 == null) goto L9;
        this.f.put(Integer.valueOf(r6.getId()), Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue()));     // Catch: Throwable -> L14
    L10:
        monitor-exit(this);
        if (r0 == null) goto L19;
        com.obric.aikernel.runtime.utils.d.f6216a.b("DownloadController", "model download progress checkpoint=" + r0.intValue() + "% " + c(r6));
        return;
    L19:
        return;
    L9:
        r0 = null;
    L14:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ boolean a(d r1, String r2, String r3, Function1 r4, int r5, Object r6) {
        Function1<? super Boolean, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L6;
        r7 = (Function1) ZeusTransformUtils.preCheckCast(DownloadController$removeTask$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L6:
        return r1.a(r2, r3, r7);
    }

    public static final /* synthetic */ int b(d r0, j r1) {
        return r0.b(r1);
    }

    private final int b(j r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        return e.a(this.e, r1);
    }

    private final DownloadController$downloadListener$2.AnonymousClass1 b() {
        return (DownloadController$downloadListener$2.AnonymousClass1) ZeusTransformUtils.preCheckCast(this.k.getValue(), DownloadController$downloadListener$2.AnonymousClass1.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ String b(d r0, DownloadInfo r1) {
        return r0.c(r1);
    }

    public static final /* synthetic */ void b(d r0) {
        r0.d();
    }

    private final void b(DownloadInfo r3) {
        if (r3 == null) goto L11;
        int r4 = r3.getId();
        monitor-enter(this);
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(this.f.remove(Integer.valueOf(r4)), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ PrmContext c(d r0) {
        return r0.f6013b;
    }

    private final DownloadController$monitorDepend$2.AnonymousClass1 c() {
        return (DownloadController$monitorDepend$2.AnonymousClass1) ZeusTransformUtils.preCheckCast(this.l.getValue(), DownloadController$monitorDepend$2.AnonymousClass1.class, "com.obric.memorydata.plugin");
    }

    private final String c(DownloadInfo r3) {
        if (r3 != null) goto L5;
        return "downloadId=null name=null progress=null bytes=null/null savePath=null";
    L5:
        return "downloadId=" + r3.getId() + " name=" + r3.getName() + " progress=" + r3.getDownloadProcess() + "% bytes=" + r3.getCurBytes() + '/' + r3.getTotalBytes() + " savePath=" + r3.getSavePath();
    }

    public static final /* synthetic */ void c(d r0, DownloadInfo r1) {
        r0.a(r1);
    }

    private final synchronized void d() {
        monitor-enter(this);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.j, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L8;
        ((h) ZeusTransformUtils.preCheckCast(r0.next(), h.class, "com.obric.memorydata.plugin")).c();     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final j a(PackageResourceManager.PresmConfig r24, String r25, String r26, List<j.b> r27) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r24, "config");
        Intrinsics.checkNotNullParameter(r25, "group");
        Intrinsics.checkNotNullParameter(r26, "taskId");
        Intrinsics.checkNotNullParameter(r6, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        monitor-enter(this);
        j r2 = (j) ZeusTransformUtils.preCheckCast(this.d.get(r26), j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        boolean r4 = true;
        if (r2 != null) goto L7;
    L9:
        boolean r5 = false;
    L10:
        Object r7 = null;
        if (r5 == false) goto L16;
        com.obric.aikernel.runtime.utils.d.f6216a.b("DownloadController", "replace finished failed download task " + r26 + " for retry");     // Catch: Throwable -> L34
        this.d.remove(r26);     // Catch: Throwable -> L34
        b(r2);     // Catch: Throwable -> L34
        if (Intrinsics.areEqual(this.i.a(), r2) == false) goto L15;
        this.i.a(null);     // Catch: Throwable -> L34
    L15:
        r2 = null;
    L16:
        if (r2 != null) goto L27;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L34
    L19:
        if (r3.hasNext() == false) goto L23;
        Object r8 = r3.next();     // Catch: Throwable -> L34
        if (((j.b) ZeusTransformUtils.preCheckCast(r8, j.b.class, "com.obric.memorydata.plugin")).i() == false) goto L19;
        r7 = r8;
    L23:
        if (r7 == null) goto L25;
        boolean r9 = true;
    L26:
        String r0 = r26;
        j r11 = new j(r24, r26, this.c.getCoroutineContext(), r6, (IDownloadListener) ZeusTransformUtils.preCheckCast(b(), IDownloadListener.class, "com.obric.memorydata.plugin"), (IDownloadMonitorDepend) ZeusTransformUtils.preCheckCast(c(), IDownloadMonitorDepend.class, "com.obric.memorydata.plugin"), r9, null, null, (Function0) ZeusTransformUtils.preCheckCast(DownloadController$getOrNewTask$1$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin"), 0, 0, 3456, null);     // Catch: Throwable -> L34
        this.d.put(r0, r11);     // Catch: Throwable -> L34
        a(this.f6013b);     // Catch: Throwable -> L34
        r2 = r11;
        r4 = false;
    L28:
        r2.m();     // Catch: Throwable -> L34
        monitor-exit(this);
        String r1 = r0;
        r2.a(r25);
        if (r4 == false) goto L33;
        com.obric.aikernel.runtime.utils.d.f6216a.b("DownloadController", "reuse download task " + r1 + " group=" + r25 + ' ' + r2.i());
    L33:
        return r2;
    L25:
        r9 = false;
        goto L26
    L27:
        r0 = r26;
        goto L28
    L7:
        if (r2.o() != true) goto L9;
        r5 = true;
    L34:
        th = move-exception;
        throw th;
    }

    public final j a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        monitor-enter(this);
        j r4 = (j) ZeusTransformUtils.preCheckCast(this.d.get(r3), j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(this);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00b4 -> B:24:0x00b7). Please report as a decompilation issue!!! */
    public final Object a(Continuation<? super List<JsonObject>> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, DownloadController$getDownloadInfos$1.class) == false) goto L7;
        DownloadController$getDownloadInfos$1 r0 = (DownloadController$getDownloadInfos$1) ZeusTransformUtils.preCheckCast(r8, DownloadController$getDownloadInfos$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Iterator r6 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$1, Iterator.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(r0.L$0, Collection.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L24:
        CollectionsKt.addAll(r3, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L20:
        if (r6.hasNext() == false) goto L26;
        j r10 = (j) ZeusTransformUtils.preCheckCast(r6.next(), j.class, "com.obric.memorydata.plugin");
        r0.L$0 = r3;
        r0.L$1 = r6;
        r0.label = 1;
        r9 = r10.a(r0);
        if (r9 != r1) goto L24;
        return r1;
    L26:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        monitor-enter(this);
        List r11 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.d.values(), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
        monitor-exit(this);
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        r6 = r12.iterator();
        r3 = r13;
    L27:
        th = move-exception;
        throw th;
    L7:
        r0 = new DownloadController$getDownloadInfos$1(this, r8);
        goto L8
    }

    public final void a() {
    }

    public final synchronized void a(j r8, int r9, boolean r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r8, "task");     // Catch: Throwable -> L34
        int r0 = r8.b();     // Catch: Throwable -> L34
        boolean r1 = r8.c();     // Catch: Throwable -> L34
        boolean r2 = false;
        if (r10 == true) goto L9;
        if (r8.c() == false) goto L9;
        r8.a(false);     // Catch: Throwable -> L34
    L9:
        if (r9 <= r8.b()) goto L11;
        boolean r11 = true;
    L12:
        if (r11 == false) goto L14;
        int r4 = b(r8);     // Catch: Throwable -> L34
    L15:
        if (r11 == false) goto L17;
        r8.a(r9);     // Catch: Throwable -> L34
    L17:
        if (r11 == false) goto L19;
    L20:
        r2 = true;
    L21:
        if (r2 == false) goto L23;
        com.obric.aikernel.runtime.utils.d.f6216a.b("DownloadController", "updateTask " + r8.a() + " prior " + r0 + "->" + r8.b() + ", background:" + r1 + "->" + r8.c());     // Catch: Throwable -> L34
    L25:
        if (r8.d() == false) goto L31;
        if (r11 == false) goto L29;
        if (r4 <= 0) goto L29;
        a(r8);     // Catch: Throwable -> L34
        d();     // Catch: Throwable -> L34
    L29:
        monitor-exit(this);
        return;
    L31:
        a(r8);     // Catch: Throwable -> L34
        a(this.f6013b);     // Catch: Throwable -> L34
        d();     // Catch: Throwable -> L34
        r8.b(true);     // Catch: Throwable -> L34
        monitor-exit(this);
        return;
    L23:
        com.obric.aikernel.runtime.utils.d.f6216a.a("DownloadController", r8.a() + " prior " + r9 + ", background:" + r8.c());     // Catch: Throwable -> L34
        goto L25
    L19:
        if (r1 == r8.c()) goto L21;
    L14:
        r4 = 0;
        goto L15
    L11:
        r11 = false;
    L34:
        th = move-exception;
        throw th;
    }

    public final void a(String r9, int r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "group");
        monitor-enter(this);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.d.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L31
    L6:
        if (r0.hasNext() == false) goto L28;
        j r1 = (j) ZeusTransformUtils.preCheckCast(r0.next(), j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        if (r1.b(r9) == false) goto L6;
        int r2 = r1.b();     // Catch: Throwable -> L31
        boolean r3 = r1.c();     // Catch: Throwable -> L31
        int r4 = 0;
        if (r11 == true) goto L15;
        if (r1.c() == false) goto L15;
        r1.a(false);     // Catch: Throwable -> L31
    L15:
        if (r10 <= r1.b()) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L20;
        r4 = b(r1);     // Catch: Throwable -> L31
    L20:
        if (r5 == false) goto L24;
        r1.a(r10);     // Catch: Throwable -> L31
        if (r4 <= 0) goto L24;
        a(r1);     // Catch: Throwable -> L31
    L24:
        if (r5 == true) goto L27;
        if (r3 == r1.c()) goto L6;
    L27:
        com.obric.aikernel.runtime.utils.d.f6216a.b("DownloadController", "updatePrior " + r9 + ':' + r1.a() + " prior " + r2 + "->" + r1.b() + ", background:" + r3 + "->" + r1.c());     // Catch: Throwable -> L31
        goto L6
    L17:
        r5 = false;
        goto L18
    L28:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L31:
        th = move-exception;
        throw th;
    }

    public final boolean a(String r4, String r5, Function1<? super Boolean, Unit> r6) {
        Function1<? super Boolean, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "group");
        Intrinsics.checkNotNullParameter(r5, "taskId");
        Intrinsics.checkNotNullParameter(r7, "action");
        j r0 = a(r5);
        if (r0 != null) goto L5;
    L7:
        boolean r8 = false;
    L8:
        if (r8 == false) goto L20;
        monitor-enter(this);
        j r9 = (j) ZeusTransformUtils.preCheckCast(this.d.remove(r5), j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        b(r9);     // Catch: Throwable -> L16
        if (Intrinsics.areEqual(this.i.a(), r9) == false) goto L13;
        this.i.a(null);     // Catch: Throwable -> L16
    L13:
        a(this.f6013b);     // Catch: Throwable -> L16
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        return true;
    L16:
        th = move-exception;
        throw th;
    L20:
        return false;
    L5:
        if (r0.a(r4, r7) != true) goto L7;
        r8 = true;
        goto L8
    }

    public final void b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "group");
        monitor-enter(this);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.d.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L11
    L6:
        if (r0.hasNext() == false) goto L8;
        j.a((j) ZeusTransformUtils.preCheckCast(r0.next(), j.class, "com.obric.memorydata.plugin"), r5, null, 2, null);     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final float c(String r7) {
        Intrinsics.checkNotNullParameter(r7, "group");
        monitor-enter(this);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.d.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L16
        int r1 = 0;
        float r2 = 0.0f;
    L6:
        if (r0.hasNext() == false) goto L10;
        j r3 = (j) ZeusTransformUtils.preCheckCast(r0.next(), j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (r3.b(r7) == false) goto L6;
        r2 = r2 + r3.g();     // Catch: Throwable -> L16
        r1 = r1 + 1;     // Catch: Throwable -> L16
        goto L6
    L10:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        if (r1 != 0) goto L15;
        return 1.0f;
    L15:
        return r2 / r1;
    L16:
        th = move-exception;
        throw th;
    }
}

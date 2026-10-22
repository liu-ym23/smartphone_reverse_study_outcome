package com.obric.aikernel.res.installer;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.res.PrmContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J:\u0010\b\u001a\u00020\t2*\u0010\n\u001a&\b\u0001\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bø\u0001\u0000¢\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/obric/aikernel/res/installer/FusionInstaller;", "Lcom/obric/aikernel/res/installer/IInstaller;", "installers", "", "(Ljava/util/List;)V", "isLocalInstallerFinished", "Lkotlinx/coroutines/CompletableDeferred;", "Lcom/obric/aikernel/res/installer/IInstaller$InstallDetails;", "executeInitTask", "", "task", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;)V", "install", "", "context", "Lcom/obric/aikernel/res/PrmContext;", "type", "", ActivityLifecycle.NAME, "version", "installAllWithInfos", LocationMonitorConst.TAG, "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6047a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d> f6048b;
    private final w<List<Object>> c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/aikernel/res/installer/FusionInstaller$Companion;", "", "()V", "TAG", "", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f6047a = new a(null);
    }

    public c(List<? extends d> r3) {
        List<d> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "installers");
        this.f6048b = r4;
        this.c = y.a(null, 1, null);
    }

    public static final /* synthetic */ w a(c r0) {
        return r0.c;
    }

    @Override // com.obric.aikernel.res.installer.d
    public String a() {
        return "FusionInstaller";
    }

    @Override // com.obric.aikernel.res.installer.d
    public void a(PrmContext r1) {
        d.a.a(this, r1);
    }

    public final void a(Function2<? super List<Object>, ? super Continuation<? super Unit>, ? extends Object> r9) {
        Function2 r10 = (Function2) ZeusTransformUtils.wrapperContextForParams(r9, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "task");
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new FusionInstaller$executeInitTask$1(r10, this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // com.obric.aikernel.res.installer.d
    public boolean a(PrmContext r17, String r18, String r19, String r20) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "type");
        Intrinsics.checkNotNullParameter(r19, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r20, "version");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f6048b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L22;
        d r11 = (d) ZeusTransformUtils.preCheckCast(r9.next(), d.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        c r1 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        boolean r2 = r11.a(r17, r18, r19, r20);     // Catch: Throwable -> L8
        com.obric.aikernel.runtime.utils.d.f6216a.b("FusionInstaller", "install: " + r18 + ' ' + r19 + '@' + r20 + " from " + r11.a() + " is " + r2);     // Catch: Throwable -> L8
        Object r3 = Result.m1421constructorimpl(Boolean.valueOf(r2));     // Catch: Throwable -> L8
    L10:
        Throwable r12 = Result.m1424exceptionOrNullimpl(r3);
        if (r12 == null) goto L14;
        com.obric.aikernel.runtime.utils.d.f6216a.c("FusionInstaller", "install: " + r18 + ' ' + r19 + '@' + r20 + " from " + r11.a() + " error: " + ExceptionsKt.stackTraceToString(r12));
    L14:
        if (Result.m1427isFailureimpl(r3) == false) goto L16;
        r3 = null;
    L16:
        Boolean r4 = (Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L4;
        if (r4.booleanValue() == false) goto L4;
        return true;
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    L22:
        return false;
    }

    @Override // com.obric.aikernel.res.installer.d
    public List<Object> b(PrmContext r15) {
        Intrinsics.checkNotNullParameter(r15, "context");
        long r0 = System.currentTimeMillis();
        com.obric.aikernel.runtime.utils.d.f6216a.b("FusionInstaller", "installAllWithInfos start installerCount=" + this.f6048b.size());
        List<Object> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f6048b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L16;
        d r6 = (d) ZeusTransformUtils.preCheckCast(r3.next(), d.class, "com.obric.memorydata.plugin");
        long r7 = System.currentTimeMillis();
        com.obric.aikernel.runtime.utils.d.f6216a.b("FusionInstaller", "installAllWithInfos installer start tag=" + r6.a());
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L8
        Object r10 = Result.m1421constructorimpl(Boolean.valueOf(r2.addAll((Collection) ZeusTransformUtils.preCheckCast(r6.b(r15), Collection.class, "com.obric.memorydata.plugin"))));     // Catch: Throwable -> L8
    L10:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
        if (r11 == null) goto L14;
        com.obric.aikernel.runtime.utils.d.f6216a.c("FusionInstaller", "installAll: " + r6.a() + " error: " + ExceptionsKt.stackTraceToString(r11));
    L14:
        if (Result.m1428isSuccessimpl(r10) == false) goto L4;
        ((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        com.obric.aikernel.runtime.utils.d.f6216a.b("FusionInstaller", "installAllWithInfos installer end tag=" + r6.a() + " costMs=" + (System.currentTimeMillis() - r7));
    L8:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    L16:
        this.c.a(r2);
        com.obric.aikernel.runtime.utils.d.f6216a.b("FusionInstaller", "installAllWithInfos end costMs=" + (System.currentTimeMillis() - r0) + " installDetailCount=" + r2.size());
        return r2;
    }
}

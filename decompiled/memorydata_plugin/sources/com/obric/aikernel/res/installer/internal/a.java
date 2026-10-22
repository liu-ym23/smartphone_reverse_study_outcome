package com.obric.aikernel.res.installer.internal;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.installer.d;
import com.obric.aikernel.res.metadata.data.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J8\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000bH\u0002J\b\u0010\r\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/aikernel/res/installer/internal/ApkDataScanner;", "Lcom/obric/aikernel/res/installer/IInstaller;", "()V", "installAll", "", "context", "Lcom/obric/aikernel/res/PrmContext;", "scan", "type", "Lcom/obric/aikernel/res/metadata/data/BaseMetadata;", "builder", "Lkotlin/Function3;", "", LocationMonitorConst.TAG, "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a implements d {

    /* JADX INFO: renamed from: com.obric.aikernel.res.installer.internal.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0259a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f6049a;

        public C0259a(CoroutineExceptionHandler.a r2, a r3) {
            this.f6049a = r3;
            super((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(r2, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext r3, Throwable r4) {
            CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
            com.obric.aikernel.runtime.utils.d.f6216a.g(this.f6049a.a(), "scan failed: " + r4);
        }
    }

    public a() {
    }

    private final void a(PrmContext r23, com.obric.aikernel.res.metadata.data.d r24, Function3<? super String, ? super String, ? super String, ? extends com.obric.aikernel.res.metadata.data.d> r25) {
        Function3 r0 = (Function3) ZeusTransformUtils.wrapperContextForParams(r25, Function3.class, "com.obric.memorydata.plugin");
        File r11 = new File(r24.w());
        com.obric.aikernel.res.a.a.C0256a r12 = com.obric.aikernel.res.a.a.f6001a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r23.getConfig().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        al r14 = am.a(ba.c().plus((CoroutineContext) ZeusTransformUtils.preCheckCast(new ak(a()), CoroutineContext.class, "com.obric.memorydata.plugin")).plus((CoroutineContext) ZeusTransformUtils.preCheckCast((CoroutineExceptionHandler) ZeusTransformUtils.preCheckCast(new C0259a(CoroutineExceptionHandler.f17198b, this), CoroutineExceptionHandler.class, "com.obric.memorydata.plugin"), CoroutineContext.class, "com.obric.memorydata.plugin")));
        String[] r15 = r11.list($$Lambda$a$zEyBWKZ5dvU3lnIRPlhqrj7n3s.INSTANCE);
        if (r15 == null) goto L10;
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r15.length), Collection.class, "com.obric.memorydata.plugin");
        int r9 = r15.length;
        int r8 = 0;
    L5:
        if (r8 >= r9) goto L7;
        String r5 = r15[r8];
        int r21 = r9;
        Function3 r13 = r0;
        Function3 r26 = r0;
        Collection r1 = r10;
        r1.add(i.b(r14, null, null, (Function2) ZeusTransformUtils.preCheckCast(new ApkDataScanner$scan$2$1(new File(r11, r5), r23, r5, r12, r24, this, r13, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));
        r8 = r8 + 1;
        r10 = r1;
        r9 = r21;
        r0 = r26;
        goto L5
    L7:
        List r2 = (List) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new ApkDataScanner$scan$3$1((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), null), Function2.class, "com.obric.memorydata.plugin"), 1, null), List.class, "com.obric.memorydata.plugin");
        return;
    }

    private static final boolean a(File r0, String r1) {
        return r0.isDirectory();
    }

    /* JADX INFO: renamed from: lambda$zEyBWKZ5dvU3lnIRPlhqrj7n3-s, reason: not valid java name */
    public static /* synthetic */ boolean m203lambda$zEyBWKZ5dvU3lnIRPlhqrj7n3s(File r0, String r1) {
        return a(r0, r1);
    }

    @Override // com.obric.aikernel.res.installer.d
    public String a() {
        return "ApkDataScanner";
    }

    @Override // com.obric.aikernel.res.installer.d
    public void a(final PrmContext r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        a(r5, (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(new b("", "", r5.getConfig()), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.preCheckCast(new ApkDataScanner$installAll$1(r5), Function3.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aikernel.res.installer.d
    public boolean a(PrmContext r1, String r2, String r3, String r4) {
        return d.a.a(this, r1, r2, r3, r4);
    }

    @Override // com.obric.aikernel.res.installer.d
    public List<Object> b(PrmContext r1) {
        return d.a.b(this, r1);
    }
}

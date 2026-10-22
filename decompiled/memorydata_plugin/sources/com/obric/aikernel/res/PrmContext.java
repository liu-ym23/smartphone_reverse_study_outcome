package com.obric.aikernel.res;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.downloader.d;
import com.obric.aikernel.res.metadata.NativeLibVersionPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u001fJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\"JR\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020\u001c2\b\b\u0002\u0010)\u001a\u00020\u001c2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020,0+J\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/J\u001e\u00100\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001fJ\u000e\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"Lcom/obric/aikernel/res/PrmContext;", "", "config", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "manager", "Lcom/obric/aikernel/res/PackageResourceManager;", "(Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;Lcom/obric/aikernel/res/PackageResourceManager;)V", "getConfig", "()Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "downloadCtrl", "Lcom/obric/aikernel/res/downloader/DownloadController;", "getDownloadCtrl$resource_manager_release", "()Lcom/obric/aikernel/res/downloader/DownloadController;", "setDownloadCtrl$resource_manager_release", "(Lcom/obric/aikernel/res/downloader/DownloadController;)V", "metadataCtrl", "Lcom/obric/aikernel/res/metadata/controller/MetadataController;", "getMetadataCtrl$resource_manager_release", "()Lcom/obric/aikernel/res/metadata/controller/MetadataController;", "setMetadataCtrl$resource_manager_release", "(Lcom/obric/aikernel/res/metadata/controller/MetadataController;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope$resource_manager_release", "()Lkotlinx/coroutines/CoroutineScope;", "clean", "", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL, "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveNativeLibraryVersion", "", ActivityLifecycle.NAME, "getCurrentRunningVersions", "", "install", "type", "version", "cfg", "Lcom/google/gson/JsonObject;", "force", "fastCheck", "builder", "Lkotlin/Function1;", "Lcom/obric/aikernel/res/metadata/data/BaseMetadata;", "runInstaller", "installer", "Lcom/obric/aikernel/res/installer/IInstaller;", "tryInstallFromInstaller", "uninstallLibs", "metadata", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PrmContext {
    private final PackageResourceManager.PresmConfig config;
    public d downloadCtrl;
    private final PackageResourceManager manager;
    public com.obric.aikernel.res.metadata.controller.a metadataCtrl;
    private final al scope;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.a r3) {
            super((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(r3, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext r2, Throwable r3) {
            com.obric.aikernel.runtime.utils.d.f6216a.c(PackageResourceManager.TAG, ((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin")) + " crashed " + ExceptionsKt.stackTraceToString(r3));
        }
    }

    public PrmContext(PackageResourceManager.PresmConfig r3, PackageResourceManager r4) {
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "manager");
        this.config = r3;
        this.manager = r4;
        this.scope = am.a(new ak(PackageResourceManager.TAG).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(cu.a(null, 1, null), CoroutineContext.class, "com.obric.memorydata.plugin")).plus((CoroutineContext) ZeusTransformUtils.preCheckCast((CoroutineExceptionHandler) ZeusTransformUtils.preCheckCast(new a(CoroutineExceptionHandler.f17198b), CoroutineExceptionHandler.class, "com.obric.memorydata.plugin"), CoroutineContext.class, "com.obric.memorydata.plugin")));
    }

    public static /* synthetic */ Object clean$default(PrmContext r1, boolean r2, Continuation r3, int r4, Object r5) {
        Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = true;
    L6:
        return r1.clean(r2, r6);
    }

    public static /* synthetic */ boolean install$default(PrmContext r9, String r10, String r11, String r12, JsonObject r13, boolean r14, boolean r15, Function1 r16, int r17, Object r18) {
        Function1<? super String, ? extends com.obric.aikernel.res.metadata.data.d> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r16, Function1.class, "com.obric.memorydata.plugin");
        if ((r17 & 8) == 0) goto L5;
        JsonObject r5 = null;
    L7:
        if ((r17 & 16) == 0) goto L9;
        boolean r6 = false;
    L11:
        if ((r17 & 32) == 0) goto L13;
        boolean r7 = true;
    L15:
        return r9.install(r10, r11, r12, r5, r6, r7, r8);
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public final Object clean(boolean r3, Continuation<? super Unit> r4) {
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        PackageResourceManager r2 = this.manager;
        if (r3 == false) goto L9;
        Object r6 = r2.clean(r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r6;
    L8:
        return Unit.INSTANCE;
    L9:
        Object r7 = r2.cleanCache(r5);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r7;
    L13:
        return Unit.INSTANCE;
    }

    public final String getActiveNativeLibraryVersion(String r1) {
        Intrinsics.checkNotNullParameter(r1, ActivityLifecycle.NAME);
        return NativeLibVersionPolicy.INSTANCE.getVersion(r1);
    }

    public final PackageResourceManager.PresmConfig getConfig() {
        return this.config;
    }

    public final Set<String> getCurrentRunningVersions() {
        return (Set) ZeusTransformUtils.preCheckCast(this.manager.getRunningDepsGetter().invoke(), Set.class, "com.obric.memorydata.plugin");
    }

    public final d getDownloadCtrl$resource_manager_release() {
        d r0 = this.downloadCtrl;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("downloadCtrl");
        return null;
    }

    public final com.obric.aikernel.res.metadata.controller.a getMetadataCtrl$resource_manager_release() {
        com.obric.aikernel.res.metadata.controller.a r0 = this.metadataCtrl;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("metadataCtrl");
        return null;
    }

    public final al getScope$resource_manager_release() {
        return this.scope;
    }

    public final boolean install(String r8, String r9, String r10, JsonObject r11, boolean r12, boolean r13, Function1<? super String, ? extends com.obric.aikernel.res.metadata.data.d> r14) {
        Function1<? super String, ? extends com.obric.aikernel.res.metadata.data.d> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "type");
        Intrinsics.checkNotNullParameter(r9, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r10, "version");
        Intrinsics.checkNotNullParameter(r6, "builder");
        boolean r15 = Intrinsics.areEqual(r8, "package");
        com.obric.aikernel.res.metadata.controller.a r0 = getMetadataCtrl$resource_manager_release();
        if (r15 == false) goto L6;
        return r0.a(r9, r10, r11, r12, r13, r6);
    L6:
        return r0.a(r8, r9, r10, r12, r13, r6);
    }

    public final void runInstaller(com.obric.aikernel.res.installer.d r4) {
        com.obric.aikernel.res.installer.d r5 = (com.obric.aikernel.res.installer.d) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.aikernel.res.installer.d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "installer");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.m1421constructorimpl(r5.b(this));     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r3);
        if (r6 == null) goto L13;
        com.obric.aikernel.runtime.utils.d.f6216a.c(PackageResourceManager.TAG, "runInstaller " + r5.a() + " failed: " + ExceptionsKt.stackTraceToString(r6));
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void setDownloadCtrl$resource_manager_release(d r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.downloadCtrl = r2;
    }

    public final void setMetadataCtrl$resource_manager_release(com.obric.aikernel.res.metadata.controller.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.metadataCtrl = r2;
    }

    public final boolean tryInstallFromInstaller(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r4, "version");
        return this.manager.getFusionInstaller().a(this, r2, r3, r4);
    }

    public final void uninstallLibs(com.obric.aikernel.res.metadata.data.d r2) {
        Intrinsics.checkNotNullParameter(r2, "metadata");
        getMetadataCtrl$resource_manager_release().a(r2);
    }
}

package com.obric.aikernel.res;

import androidx.annotation.Keep;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.k;
import com.obric.aikernel.res.downloader.DownloadController;
import com.obric.aikernel.res.metadata.NativeLibVersionPolicy;
import com.obric.aikernel.res.metadata.controller.MetadataController;
import com.obric.aikernel.res.metadata.data.b;
import com.obric.aikernel.runtime.utils.d;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class PrmContext {
    private final PackageResourceManager.PresmConfig config;
    public DownloadController downloadCtrl;
    private final PackageResourceManager manager;
    public MetadataController metadataCtrl;
    private final l0 scope;

    @SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n*L\n1#1,110:1\n*E\n"})
    public static final class a extends AbstractCoroutineContextElement implements h0 {
        public a(h0.a r10) {
            super(r10);
        }

        @Override // kotlinx.coroutines.h0
        public void V(CoroutineContext r10, Throwable r11) {
            d.f5417a.f(PackageResourceManager.TAG, r10 + " crashed " + ExceptionsKt.stackTraceToString(r11));
        }
    }

    public PrmContext(PackageResourceManager.PresmConfig r10, PackageResourceManager r11) {
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r11, "manager");
        this.config = r10;
        this.manager = r11;
        this.scope = m0.a(new k0(PackageResourceManager.TAG).plus(z0.b()).plus(q2.b(null, 1, null)).plus(new a(h0.f10523d)));
    }

    public static /* synthetic */ Object clean$default(PrmContext r10, boolean r11, Continuation r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = true;
    L6:
        return r10.clean(r11, r12);
    }

    public static /* synthetic */ boolean install$default(PrmContext r10, String r11, String r12, String r13, k r14, boolean r15, boolean r16, Function1 r17, int r18, Object r19) {
        if ((r18 & 8) == 0) goto L5;
        k r20 = null;
    L7:
        if ((r18 & 16) == 0) goto L9;
        boolean r21 = false;
    L11:
        if ((r18 & 32) == 0) goto L13;
        boolean r22 = true;
    L15:
        return r10.install(r11, r12, r13, r20, r21, r22, r17);
    L13:
        r22 = r16;
        goto L15
    L9:
        r21 = r15;
        goto L11
    L5:
        r20 = r14;
        goto L7
    }

    public final Object clean(boolean r10, Continuation<? super Unit> r11) {
        PackageResourceManager r12 = this.manager;
        if (r10 == false) goto L9;
        Object r13 = r12.clean(r11);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r13;
    L8:
        return Unit.INSTANCE;
    L9:
        Object r14 = r12.cleanCache(r11);
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r14;
    L13:
        return Unit.INSTANCE;
    }

    public final String getActiveNativeLibraryVersion(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return NativeLibVersionPolicy.INSTANCE.getVersion(r10);
    }

    public final PackageResourceManager.PresmConfig getConfig() {
        return this.config;
    }

    public final Set<String> getCurrentRunningVersions() {
        return this.manager.getRunningDepsGetter().invoke();
    }

    public final DownloadController getDownloadCtrl$resource_manager_release() {
        DownloadController r10 = this.downloadCtrl;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("downloadCtrl");
        return null;
    }

    public final MetadataController getMetadataCtrl$resource_manager_release() {
        MetadataController r10 = this.metadataCtrl;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("metadataCtrl");
        return null;
    }

    public final l0 getScope$resource_manager_release() {
        return this.scope;
    }

    public final boolean install(String r10, String r11, String r12, k r13, boolean r14, boolean r15, Function1<? super String, ? extends b> r16) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "version");
        Intrinsics.checkNotNullParameter(r16, "builder");
        if (Intrinsics.areEqual(r10, "package") == false) goto L6;
        return getMetadataCtrl$resource_manager_release().w(r11, r12, r13, r14, r15, r16);
    L6:
        return getMetadataCtrl$resource_manager_release().u(r10, r11, r12, r14, r15, r16);
    }

    public final void runInstaller(com.obric.aikernel.res.installer.a r10) {
        Intrinsics.checkNotNullParameter(r10, "installer");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.m32constructorimpl(r10.b(this));     // Catch: Throwable -> L5
    L7:
        Throwable r13 = Result.m35exceptionOrNullimpl(r12);
        if (r13 == null) goto L13;
        d.f5417a.f(PackageResourceManager.TAG, "runInstaller " + r10.tag() + " failed: " + ExceptionsKt.stackTraceToString(r13));
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void setDownloadCtrl$resource_manager_release(DownloadController r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.downloadCtrl = r10;
    }

    public final void setMetadataCtrl$resource_manager_release(MetadataController r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.metadataCtrl = r10;
    }

    public final boolean tryInstallFromInstaller(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "version");
        return this.manager.getFusionInstaller().c(this, r10, r11, r12);
    }

    public final void uninstallLibs(b r10) {
        Intrinsics.checkNotNullParameter(r10, "metadata");
        getMetadataCtrl$resource_manager_release().E(r10);
    }
}

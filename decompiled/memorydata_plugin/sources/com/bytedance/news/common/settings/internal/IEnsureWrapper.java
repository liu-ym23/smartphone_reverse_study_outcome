package com.bytedance.news.common.settings.internal;

import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.services.apm.api.IEnsure;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class IEnsureWrapper implements IEnsure {
    private static volatile IEnsureWrapper INSTANCE;
    private IEnsure iEnsure;
    private Executor mExecutor;

    private IEnsureWrapper() {
        this.iEnsure = (IEnsure) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IEnsure.class), IEnsure.class, "com.obric.memorydata.plugin");
        SettingsConfigProvider r0 = (SettingsConfigProvider) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(SettingsConfigProvider.class), SettingsConfigProvider.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        if (r0.getConfig() == null) goto L8;
        this.mExecutor = r0.getConfig().c();
    L8:
        if (this.mExecutor != null) goto L11;
        this.mExecutor = Executors.newCachedThreadPool();
        return;
    }

    static /* synthetic */ IEnsure access$000(IEnsureWrapper r0) {
        return r0.iEnsure;
    }

    public static IEnsureWrapper getInstance() {
        if (INSTANCE != null) goto L15;
        monitor-enter(IEnsureWrapper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (INSTANCE != null) goto L9;
        INSTANCE = new IEnsureWrapper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(IEnsureWrapper.class);     // Catch: Throwable -> L11
    L15:
        return INSTANCE;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureFalse(boolean r1) {
        IEnsure r0 = this.iEnsure;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.ensureFalse(r1);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureFalse(boolean r1, String r2) {
        IEnsure r0 = this.iEnsure;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.ensureFalse(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureFalse(boolean r3, String r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        IEnsure r2 = this.iEnsure;
        if (r2 != null) goto L5;
        return false;
    L5:
        return r2.ensureFalse(r3, r4, r6);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureNotEmpty(Collection r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        IEnsure r2 = this.iEnsure;
        if (r2 != null) goto L5;
        return false;
    L5:
        return r2.ensureNotEmpty(r4);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureNotNull(Object r1) {
        IEnsure r0 = this.iEnsure;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.ensureNotNull(r1);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureNotNull(Object r1, String r2) {
        IEnsure r0 = this.iEnsure;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.ensureNotNull(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere() {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new AnonymousClass1(this));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(final String r3) {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new AnonymousClass2(this, r3));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(final String r3, Map<String, String> r4) {
        final Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new AnonymousClass5(this, r3, r5));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(final Throwable r3) {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new AnonymousClass3(this, r3));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(final Throwable r3, final String r4) {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new AnonymousClass4(this, r3, r4));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(final Throwable r3, final String r4, Map<String, String> r5) {
        final Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new AnonymousClass6(this, r3, r4, r6));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureTrue(boolean r1) {
        IEnsure r0 = this.iEnsure;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.ensureTrue(r1);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureTrue(boolean r1, String r2) {
        IEnsure r0 = this.iEnsure;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.ensureTrue(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureTrue(boolean r3, String r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        IEnsure r2 = this.iEnsure;
        if (r2 != null) goto L5;
        return false;
    L5:
        return r2.ensureTrue(r3, r4, r6);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void reportLogException(int r1, Throwable r2, String r3) {
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L6;
        r0.reportLogException(r1, r2, r3);
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void reportLogException(Throwable r1) {
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L6;
        r0.reportLogException(r1);
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void reportLogException(Throwable r1, String r2) {
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L6;
        r0.reportLogException(r1, r2);
        return;
    }
}

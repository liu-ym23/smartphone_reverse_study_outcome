package com.obric.memorydata.middleware.api.bdtracker;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001JE\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\nH\u0096\u0001J\u0017\u0010\r\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0096\u0001¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/middleware/api/bdtracker/MemoryAppLogSettings;", "Lcom/obric/memorydata/middleware/api/bdtracker/IMemoryAppLogSettings;", "<init>", "()V", "getIid", "", "getServerDeviceId", "registerDidListener", "", "onRemoteDidChanged", "Lkotlin/Function1;", "onIdLoaded", "onCurrentDid", "registerDidReadyListener", "onDidReady", "Lkotlin/Function0;", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryAppLogSettings implements IMemoryAppLogSettings {
    public static final MemoryAppLogSettings INSTANCE = null;
    private final /* synthetic */ IMemoryAppLogSettings $$delegate_0;

    static {
        INSTANCE = new MemoryAppLogSettings();
    }

    private MemoryAppLogSettings() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IMemoryAppLogSettings.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IMemoryAppLogSettings) ZeusTransformUtils.preCheckCast(r0, IMemoryAppLogSettings.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.IMemoryAppLogSettings
    public String getIid() {
        return this.$$delegate_0.getIid();
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.IMemoryAppLogSettings
    public String getServerDeviceId() {
        return this.$$delegate_0.getServerDeviceId();
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.IMemoryAppLogSettings
    public void registerDidListener(Function1<? super String, Unit> r3, Function1<? super String, Unit> r4, Function1<? super String, Unit> r5) {
        Function1<? super String, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function1<? super String, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function1<? super String, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "onRemoteDidChanged");
        Intrinsics.checkNotNullParameter(r7, "onIdLoaded");
        Intrinsics.checkNotNullParameter(r8, "onCurrentDid");
        this.$$delegate_0.registerDidListener(r6, r7, r8);
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.IMemoryAppLogSettings
    public void registerDidReadyListener(Function0<Unit> r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onDidReady");
        this.$$delegate_0.registerDidReadyListener(r4);
    }
}

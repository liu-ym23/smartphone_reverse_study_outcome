package com.obric.aee.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aee.BuildConfig;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\u0010\tJ\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0018\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0006H\u0016J \u0010!\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0016J\u0016\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&J&\u0010'\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006J\u0016\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/aee/impl/EngineConfig;", "Lcom/obric/pap/base/HostLogger;", "callback", "Lcom/obric/aee/EngineCallback;", "pipeHandler", "Lkotlin/Function2;", "", "", "", "(Lcom/obric/aee/EngineCallback;Lkotlin/jvm/functions/Function2;)V", "logDispatcherEnabled", "", "getLogDispatcherEnabled", "()Z", "setLogDispatcherEnabled", "(Z)V", "logThreadNamed", "minLogPriority", "", "getMinLogPriority", "()I", "setMinLogPriority", "(I)V", "getAdditionalAssetsHash", "getContext", "Landroid/content/Context;", "getGlobalConfig", "", "getHome", "Ljava/io/File;", "isLoggable", "priority", LocationMonitorConst.TAG, "log", Params.CONTENT, "onGlobalEvent", "event", "args", "Landroid/os/Bundle;", "onLog", "threadId", "onPipeData", "key", "data", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EngineConfig implements com.obric.pap.base.a {
    private final com.obric.aee.a callback;
    private boolean logDispatcherEnabled;
    private boolean logThreadNamed;
    private int minLogPriority;
    private final Function2<String, byte[], Unit> pipeHandler;

    public EngineConfig(com.obric.aee.a r3, Function2<? super String, ? super byte[], Unit> r4) {
        com.obric.aee.a r5 = (com.obric.aee.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aee.a.class, "com.obric.memorydata.plugin");
        Function2<String, byte[], Unit> r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Intrinsics.checkNotNullParameter(r6, "pipeHandler");
        this.callback = r5;
        this.pipeHandler = r6;
        this.logDispatcherEnabled = true;
        this.minLogPriority = 4;
    }

    public final String getAdditionalAssetsHash() {
        return BuildConfig.BUILD_UUID;
    }

    public final Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.callback.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    public final Map<String, String> getGlobalConfig() {
        return this.callback.c();
    }

    public final File getHome() {
        return new File(this.callback.a(), "Aee");
    }

    public final boolean getLogDispatcherEnabled() {
        return this.logDispatcherEnabled;
    }

    public final int getMinLogPriority() {
        return this.minLogPriority;
    }

    @Override // com.obric.pap.base.a
    public boolean isLoggable(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
        if (r2 < this.minLogPriority) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.pap.base.a
    public void log(int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r5, Params.CONTENT);
        if (isLoggable(r3, r4) == true) goto L5;
        return;
    L5:
        this.callback.a(r3, r4, Process.myTid() + ' ' + r5);
    }

    @Override // com.obric.pap.base.a
    public void log(int r3, String r4, Function0<String> r5) {
        com.obric.pap.base.a.C0796a.a(this, r3, r4, (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin"));
    }

    public void logD(String r1, String r2) {
        com.obric.pap.base.a.C0796a.b(this, r1, r2);
    }

    public void logD(String r3, Function0<String> r4) {
        com.obric.pap.base.a.C0796a.b(this, r3, (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.pap.base.a
    public void logE(String r1, String r2) {
        com.obric.pap.base.a.C0796a.e(this, r1, r2);
    }

    public void logE(String r3, Function0<String> r4) {
        com.obric.pap.base.a.C0796a.e(this, r3, (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.pap.base.a
    public void logI(String r1, String r2) {
        com.obric.pap.base.a.C0796a.c(this, r1, r2);
    }

    @Override // com.obric.pap.base.a
    public void logI(String r3, Function0<String> r4) {
        com.obric.pap.base.a.C0796a.c(this, r3, (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin"));
    }

    public void logV(String r1, String r2) {
        com.obric.pap.base.a.C0796a.a(this, r1, r2);
    }

    public void logV(String r3, Function0<String> r4) {
        com.obric.pap.base.a.C0796a.a(this, r3, (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.pap.base.a
    public void logW(String r1, String r2) {
        com.obric.pap.base.a.C0796a.d(this, r1, r2);
    }

    public void logW(String r3, Function0<String> r4) {
        com.obric.pap.base.a.C0796a.d(this, r3, (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin"));
    }

    public final void onGlobalEvent(String r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "args");
        this.callback.a(r2, r3);
    }

    public final void onLog(int r3, int r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r6, Params.CONTENT);
        if (this.logDispatcherEnabled == true) goto L5;
    L7:
        this.callback.a(r3, r5, r4 + ' ' + r6);
        return;
    L5:
        if (this.logThreadNamed == true) goto L7;
        Thread.currentThread().setName("Aee-LogDispatcher");
        this.logThreadNamed = true;
        goto L7
    }

    public final void onPipeData(String r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "data");
        this.pipeHandler.invoke(r2, r3);
    }

    public final void setLogDispatcherEnabled(boolean r1) {
        this.logDispatcherEnabled = r1;
    }

    public final void setMinLogPriority(int r1) {
        this.minLogPriority = r1;
    }
}

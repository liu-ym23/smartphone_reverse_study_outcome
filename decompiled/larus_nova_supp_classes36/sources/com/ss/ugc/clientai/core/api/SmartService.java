package com.ss.ugc.clientai.core.api;

import alc.c;
import alc.d;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u0000 22\u00020\u0001:\u000234B\u000f\u0012\u0006\u0010,\u001a\u00020\r¢\u0006\u0004\b0\u00101J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001a\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0016R*\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u001b0!j\b\u0012\u0004\u0012\u00020\u001b`\"8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0017\u0010,\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/ss/ugc/clientai/core/api/SmartService;", "", "Lcom/ss/ugc/clientai/core/api/SmartServiceConfig;", "config", "", "configService", "", "enable", "isEnvReady", "preloadEnv", "ensureReady", "Lcom/ss/ugc/clientai/core/api/SmartOutputData;", "lastResult", "", "method", "Lalc/d;", "params", "callExtMethod", "Lcom/ss/ugc/clientai/core/api/SmartInputData;", "extInputs", "runSync", "", "delayMs", "Lcom/ss/ugc/clientai/core/api/SmartService$a;", "callback", "runAsyncDelay", "runAsync", "Lalc/c;", "listener", "addResultChangedListener", "removeResultChangedListener", "resultData", "notifyResultChanged", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "listeners", "Ljava/util/ArrayList;", "getListeners", "()Ljava/util/ArrayList;", "Lcom/ss/ugc/clientai/core/api/SmartServiceConfig;", "getConfig", "()Lcom/ss/ugc/clientai/core/api/SmartServiceConfig;", "setConfig", "(Lcom/ss/ugc/clientai/core/api/SmartServiceConfig;)V", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "b", "core-api_release"}, k = 1, mv = {1, 4, 1})
public abstract class SmartService {
    public static final b Companion = null;
    private SmartServiceConfig config;
    private final ArrayList<c> listeners;
    private final String name;

    public interface a {
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    public d callExtMethod(String r1, d r2) {
        Intrinsics.checkNotNullParameter(r1, "method");
        return null;
    }

    public abstract boolean enable();

    public boolean isEnvReady() {
        return true;
    }

    public abstract SmartOutputData lastResult();

    public void preloadEnv() {
    }

    public void runAsyncDelay(long r1, SmartInputData r3, a r4) {
    }

    public SmartOutputData runSync(SmartInputData r1) {
        return null;
    }

    public boolean ensureReady() {
        if (isEnvReady() == false) goto L6;
        return true;
    L6:
        preloadEnv();
        return isEnvReady();
    }

    public final SmartServiceConfig getConfig() {
        return this.config;
    }

    public final ArrayList<c> getListeners() {
        return this.listeners;
    }

    public final String getName() {
        return this.name;
    }

    public SmartService(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.name = r2;
        this.listeners = new ArrayList();
    }

    public void addResultChangedListener(c r3) {
        if (r3 == null) goto L14;
        ArrayList<c> r0 = this.listeners;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (this.listeners.contains(r3) == true) goto L8;
        this.listeners.add(r3);     // Catch: Throwable -> L11
    L8:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    }

    public void configService(SmartServiceConfig r1) {
        this.config = r1;
    }

    public void notifyResultChanged(SmartOutputData r3) {
        if ((!this.listeners.isEmpty()) == false) goto L15;
        ArrayList<c> r4 = this.listeners;
        monitor-enter(r4);
        ArrayList r0 = new ArrayList(this.listeners);     // Catch: Throwable -> L12
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r4);
        Iterator r5 = r0.iterator();
    L10:
        if (r5.hasNext() == false) goto L19;
        ((c) r5.next()).a();
        goto L10
    L19:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void removeResultChangedListener(c r3) {
        if (r3 == null) goto L11;
        ArrayList<c> r0 = this.listeners;
        monitor-enter(r0);
        this.listeners.remove(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void setConfig(SmartServiceConfig r1) {
        this.config = r1;
    }

    public final void runAsync(SmartInputData r3, a r4) {
        runAsyncDelay(0, r3, r4);
    }

    public static /* synthetic */ d callExtMethod$default(SmartService r0, String r1, d r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = null;
    L7:
        return r0.callExtMethod(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callExtMethod");
    }
}

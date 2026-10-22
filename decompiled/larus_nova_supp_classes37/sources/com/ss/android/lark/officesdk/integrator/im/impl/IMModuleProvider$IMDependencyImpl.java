package com.ss.android.lark.officesdk.integrator.im.impl;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.integrator.im.dependency.IEnvDependency;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.l0;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@ClaymoreImpl(pmb.e.class)
public class IMModuleProvider$IMDependencyImpl implements pmb.e {
    l0 mModuleApiFetcher;

    public pmb.b getCCMDependency() {
        l0 r0 = this.mModuleApiFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(b.class);
        if (r2 != null) goto L22;
        monitor-enter(r0);
        if (r2 == null) goto L25;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        goto L22
    L25:
        r2 = b.class.newInstance();     // Catch: InstantiationException -> L9 IllegalAccessException -> L11 Throwable -> L18
    L14:
        if (r2 == null) goto L16;
        ((ConcurrentHashMap) r0.a).put(b.class, r2);     // Catch: Throwable -> L18
        goto L16
    L11:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L13:
        r2 = null;
    L9:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L22:
        return (pmb.b) r2;
    }

    public pmb.c getChatMemberPickerDependency() {
        l0 r0 = this.mModuleApiFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(c.class);
        if (r2 != null) goto L22;
        monitor-enter(r0);
        if (r2 == null) goto L25;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        goto L22
    L25:
        r2 = c.class.newInstance();     // Catch: InstantiationException -> L9 IllegalAccessException -> L11 Throwable -> L18
    L14:
        if (r2 == null) goto L16;
        ((ConcurrentHashMap) r0.a).put(c.class, r2);     // Catch: Throwable -> L18
        goto L16
    L11:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L13:
        r2 = null;
    L9:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L22:
        return (pmb.c) r2;
    }

    public pmb.d getCoreDependency() {
        l0 r0 = this.mModuleApiFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(CoreDependencyImpl.class);
        if (r2 != null) goto L22;
        monitor-enter(r0);
        if (r2 == null) goto L25;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        goto L22
    L25:
        r2 = CoreDependencyImpl.class.newInstance();     // Catch: InstantiationException -> L9 IllegalAccessException -> L11 Throwable -> L18
    L14:
        if (r2 == null) goto L16;
        ((ConcurrentHashMap) r0.a).put(CoreDependencyImpl.class, r2);     // Catch: Throwable -> L18
        goto L16
    L11:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L13:
        r2 = null;
    L9:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L22:
        return (pmb.d) r2;
    }

    public IEnvDependency getEnvDependency() {
        l0 r0 = this.mModuleApiFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(f.class);
        if (r2 != null) goto L22;
        monitor-enter(r0);
        if (r2 == null) goto L25;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        goto L22
    L25:
        r2 = f.class.newInstance();     // Catch: InstantiationException -> L9 IllegalAccessException -> L11 Throwable -> L18
    L14:
        if (r2 == null) goto L16;
        ((ConcurrentHashMap) r0.a).put(f.class, r2);     // Catch: Throwable -> L18
        goto L16
    L11:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L13:
        r2 = null;
    L9:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L22:
        return (IEnvDependency) r2;
    }

    public pmb.f getMigrateTempDependency() {
        l0 r0 = this.mModuleApiFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(k.class);
        if (r2 != null) goto L22;
        monitor-enter(r0);
        if (r2 == null) goto L25;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        goto L22
    L25:
        r2 = k.class.newInstance();     // Catch: InstantiationException -> L9 IllegalAccessException -> L11 Throwable -> L18
    L14:
        if (r2 == null) goto L16;
        ((ConcurrentHashMap) r0.a).put(k.class, r2);     // Catch: Throwable -> L18
        goto L16
    L11:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L13:
        r2 = null;
    L9:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L22:
        return (pmb.f) r2;
    }

    public pmb.g getOpenFeatureDependency() {
        l0 r0 = this.mModuleApiFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(m.class);
        if (r2 != null) goto L22;
        monitor-enter(r0);
        if (r2 == null) goto L25;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        goto L22
    L25:
        r2 = m.class.newInstance();     // Catch: InstantiationException -> L9 IllegalAccessException -> L11 Throwable -> L18
    L14:
        if (r2 == null) goto L16;
        ((ConcurrentHashMap) r0.a).put(m.class, r2);     // Catch: Throwable -> L18
        goto L16
    L11:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L13:
        r2 = null;
    L9:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L22:
        return (pmb.g) r2;
    }

    public pmb.h getOpenPlatformDependency() {
        l0 r0 = this.mModuleApiFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(n.class);
        if (r2 != null) goto L22;
        monitor-enter(r0);
        if (r2 == null) goto L25;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        goto L22
    L25:
        r2 = n.class.newInstance();     // Catch: InstantiationException -> L9 IllegalAccessException -> L11 Throwable -> L18
    L14:
        if (r2 == null) goto L16;
        ((ConcurrentHashMap) r0.a).put(n.class, r2);     // Catch: Throwable -> L18
        goto L16
    L11:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L13:
        r2 = null;
    L9:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L22:
        return (pmb.h) r2;
    }

    public pmb.i getPassportDependency() {
        l0 r0 = this.mModuleApiFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(o.class);
        if (r2 != null) goto L22;
        monitor-enter(r0);
        if (r2 == null) goto L25;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        goto L22
    L25:
        r2 = o.class.newInstance();     // Catch: InstantiationException -> L9 IllegalAccessException -> L11 Throwable -> L18
    L14:
        if (r2 == null) goto L16;
        ((ConcurrentHashMap) r0.a).put(o.class, r2);     // Catch: Throwable -> L18
        goto L16
    L11:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L13:
        r2 = null;
    L9:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L22:
        return (pmb.i) r2;
    }

    public pmb.j getSecurityComplianceDependency() {
        l0 r0 = this.mModuleApiFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(p.class);
        if (r2 != null) goto L22;
        monitor-enter(r0);
        if (r2 == null) goto L25;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        goto L22
    L25:
        r2 = p.class.newInstance();     // Catch: InstantiationException -> L9 IllegalAccessException -> L11 Throwable -> L18
    L14:
        if (r2 == null) goto L16;
        ((ConcurrentHashMap) r0.a).put(p.class, r2);     // Catch: Throwable -> L18
        goto L16
    L11:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L13:
        r2 = null;
    L9:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L22:
        return (pmb.j) r2;
    }

    public pmb.k getTranslateDependency() {
        l0 r0 = this.mModuleApiFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(t.class);
        if (r2 != null) goto L22;
        monitor-enter(r0);
        if (r2 == null) goto L25;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        goto L22
    L25:
        r2 = t.class.newInstance();     // Catch: InstantiationException -> L9 IllegalAccessException -> L11 Throwable -> L18
    L14:
        if (r2 == null) goto L16;
        ((ConcurrentHashMap) r0.a).put(t.class, r2);     // Catch: Throwable -> L18
        goto L16
    L11:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L13:
        r2 = null;
    L9:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L22:
        return (pmb.k) r2;
    }

    public pmb.l getVideoConferenceDependency() {
        l0 r0 = this.mModuleApiFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(u.class);
        if (r2 != null) goto L22;
        monitor-enter(r0);
        if (r2 == null) goto L25;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        goto L22
    L25:
        r2 = u.class.newInstance();     // Catch: InstantiationException -> L9 IllegalAccessException -> L11 Throwable -> L18
    L14:
        if (r2 == null) goto L16;
        ((ConcurrentHashMap) r0.a).put(u.class, r2);     // Catch: Throwable -> L18
        goto L16
    L11:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L13:
        r2 = null;
    L9:
        e = move-exception;
        Log.e("IMModuleProvider", "getApi failed", e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L22:
        return (pmb.l) r2;
    }

    public IMModuleProvider$IMDependencyImpl() {
        this.mModuleApiFetcher = new l0();
    }
}

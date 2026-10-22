package com.ss.android.lark.integrator.im.feed_shared;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.integrator.im.feed_shared.dependency.c;
import com.ss.android.lark.integrator.im.feed_shared.dependency.d;
import com.ss.android.lark.integrator.im.feed_shared.dependency.e;
import com.ss.android.lark.integrator.im.feed_shared.dependency.f;
import com.ss.android.lark.integrator.im.feed_shared.dependency.g;
import com.ss.android.lark.integrator.im.feed_shared.dependency.j;
import com.ss.android.lark.integrator.im.feed_shared.dependency.k;
import com.ss.android.lark.integrator.im.feed_shared.dependency.m;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.l0;
import java.util.concurrent.ConcurrentHashMap;
import peb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(b.class)
public class FeedSharedModuleDependency implements b {
    public static final String TAG = "FeedSharedModuleDependency";
    private static final l0 sDependencyFetcher = null;
    private final Context context;

    public class a implements b.e {
        public final void a() {
        }

        public final void b() {
        }

        public a() {
        }
    }

    public static /* synthetic */ b.c a(Class r0) {
        return lambda$getBrowserDependency$2(r0);
    }

    public static /* synthetic */ b.j b(Class r0) {
        return lambda$getResourceDependency$0(r0);
    }

    public static /* synthetic */ b.b c(Class r0) {
        return lambda$getAppConfigDependency$7(r0);
    }

    public static /* synthetic */ b.k d(Class r0) {
        return lambda$getSettingDependency$3(r0);
    }

    public static /* synthetic */ b.g e(Class r0) {
        return lambda$getGuideDependency$8(r0);
    }

    public static /* synthetic */ b.f f(Class r0) {
        return lambda$getFeatureGatingDependency$1(r0);
    }

    public static /* synthetic */ b.i g(Class r0) {
        return lambda$getPushDependency$9(r0);
    }

    public static /* synthetic */ b.a h(Class r0) {
        return lambda$getAccountDependency$6(r0);
    }

    public static /* synthetic */ b.d i(Class r0) {
        return lambda$getChatDependency$5(r0);
    }

    public static /* synthetic */ b.e j(FeedSharedModuleDependency r0, Class r1) {
        return r0.lambda$getDocDependency$4(r1);
    }

    static {
        sDependencyFetcher = new l0();
    }

    public b.a getAccountDependency() {
        l0 r0 = sDependencyFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(b.a.class);
        if (r2 != null) goto L15;
        monitor-enter(r0);
        if (r2 == null) goto L16;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r2 = h(b.a.class);     // Catch: Throwable -> L11
        if (r2 == null) goto L9;
        ((ConcurrentHashMap) r0.a).put(b.a.class, r2);     // Catch: Throwable -> L11
    L15:
        return (b.a) r2;
    }

    public b.b getAppConfigDependency() {
        l0 r0 = sDependencyFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(b.b.class);
        if (r2 != null) goto L15;
        monitor-enter(r0);
        if (r2 == null) goto L16;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r2 = c(b.b.class);     // Catch: Throwable -> L11
        if (r2 == null) goto L9;
        ((ConcurrentHashMap) r0.a).put(b.b.class, r2);     // Catch: Throwable -> L11
    L15:
        return (b.b) r2;
    }

    public b.c getBrowserDependency() {
        l0 r0 = sDependencyFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(b.c.class);
        if (r2 != null) goto L15;
        monitor-enter(r0);
        if (r2 == null) goto L16;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r2 = a(b.c.class);     // Catch: Throwable -> L11
        if (r2 == null) goto L9;
        ((ConcurrentHashMap) r0.a).put(b.c.class, r2);     // Catch: Throwable -> L11
    L15:
        return (b.c) r2;
    }

    public b.d getChatDependency() {
        l0 r0 = sDependencyFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(b.d.class);
        if (r2 != null) goto L15;
        monitor-enter(r0);
        if (r2 == null) goto L16;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r2 = i(b.d.class);     // Catch: Throwable -> L11
        if (r2 == null) goto L9;
        ((ConcurrentHashMap) r0.a).put(b.d.class, r2);     // Catch: Throwable -> L11
    L15:
        return (b.d) r2;
    }

    public b.e getDocDependency() {
        l0 r0 = sDependencyFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(b.e.class);
        if (r2 != null) goto L15;
        monitor-enter(r0);
        if (r2 == null) goto L16;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r2 = j(this, b.e.class);     // Catch: Throwable -> L11
        if (r2 == null) goto L9;
        ((ConcurrentHashMap) r0.a).put(b.e.class, r2);     // Catch: Throwable -> L11
    L15:
        return (b.e) r2;
    }

    public b.f getFeatureGatingDependency() {
        l0 r0 = sDependencyFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(b.f.class);
        if (r2 != null) goto L15;
        monitor-enter(r0);
        if (r2 == null) goto L16;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r2 = f(b.f.class);     // Catch: Throwable -> L11
        if (r2 == null) goto L9;
        ((ConcurrentHashMap) r0.a).put(b.f.class, r2);     // Catch: Throwable -> L11
    L15:
        return (b.f) r2;
    }

    public peb.a getFeedDependency() {
        return new f();
    }

    public b.g getGuideDependency() {
        l0 r0 = sDependencyFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(b.g.class);
        if (r2 != null) goto L15;
        monitor-enter(r0);
        if (r2 == null) goto L16;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r2 = e(b.g.class);     // Catch: Throwable -> L11
        if (r2 == null) goto L9;
        ((ConcurrentHashMap) r0.a).put(b.g.class, r2);     // Catch: Throwable -> L11
    L15:
        return (b.g) r2;
    }

    public b.i getPushDependency() {
        l0 r0 = sDependencyFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(b.i.class);
        if (r2 != null) goto L15;
        monitor-enter(r0);
        if (r2 == null) goto L16;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r2 = g(b.i.class);     // Catch: Throwable -> L11
        if (r2 == null) goto L9;
        ((ConcurrentHashMap) r0.a).put(b.i.class, r2);     // Catch: Throwable -> L11
    L15:
        return (b.i) r2;
    }

    public b.j getResourceDependency() {
        l0 r0 = sDependencyFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(b.j.class);
        if (r2 != null) goto L15;
        monitor-enter(r0);
        if (r2 == null) goto L16;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r2 = b(b.j.class);     // Catch: Throwable -> L11
        if (r2 == null) goto L9;
        ((ConcurrentHashMap) r0.a).put(b.j.class, r2);     // Catch: Throwable -> L11
    L15:
        return (b.j) r2;
    }

    public b.k getSettingDependency() {
        l0 r0 = sDependencyFetcher;
        Object r2 = ((ConcurrentHashMap) r0.a).get(b.k.class);
        if (r2 != null) goto L15;
        monitor-enter(r0);
        if (r2 == null) goto L16;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r2 = d(b.k.class);     // Catch: Throwable -> L11
        if (r2 == null) goto L9;
        ((ConcurrentHashMap) r0.a).put(b.k.class, r2);     // Catch: Throwable -> L11
    L15:
        return (b.k) r2;
    }

    public FeedSharedModuleDependency() {
        this.context = LarkContext.getApplication();
    }

    public Context getApplictaionContext() {
        return this.context;
    }

    private static /* synthetic */ b.a lambda$getAccountDependency$6(Class r0) {
        return new com.ss.android.lark.integrator.im.feed_shared.dependency.a();
    }

    private static /* synthetic */ b.b lambda$getAppConfigDependency$7(Class r0) {
        return new com.ss.android.lark.integrator.im.feed_shared.dependency.b();
    }

    private static /* synthetic */ b.c lambda$getBrowserDependency$2(Class r0) {
        return new c();
    }

    private static /* synthetic */ b.d lambda$getChatDependency$5(Class r0) {
        return new d();
    }

    private /* synthetic */ b.e lambda$getDocDependency$4(Class r1) {
        return new a();
    }

    private static /* synthetic */ b.f lambda$getFeatureGatingDependency$1(Class r0) {
        return new e();
    }

    private static /* synthetic */ b.g lambda$getGuideDependency$8(Class r0) {
        return new g();
    }

    private static /* synthetic */ b.i lambda$getPushDependency$9(Class r0) {
        return new j();
    }

    private static /* synthetic */ b.j lambda$getResourceDependency$0(Class r0) {
        return new k();
    }

    private static /* synthetic */ b.k lambda$getSettingDependency$3(Class r0) {
        return new m();
    }
}

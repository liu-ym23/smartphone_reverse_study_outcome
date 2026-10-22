package com.bytedance.android.livesdk.jsbridge;

import android.content.Context;
import com.bytedance.android.live.profile.api.IProfileService;
import com.bytedance.android.live.recharge.IRechargeServiceExternal;
import com.bytedance.android.livesdk.interactivity.api.ICommentService;
import com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService;
import com.bytedance.bdlocation.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n56.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/JsMethodsProvideServiceImpl;", "Lcom/bytedance/android/livesdkapi/jsb/IJsMethodsProvideService;", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "ctxRef", "Ln56/a;", "iesJsBridge", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ln56/c;", "provideIJavaMethods", "Lcom/bytedance/android/livesdkapi/jsb/IJsMethodsProvideService$IFactory;", "factory", BuildConfig.FLAVOR, "registerFactory", "unregisterFactory", "unregisterAllFactory", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class JsMethodsProvideServiceImpl implements IJsMethodsProvideService {

    public static final class a {
        public static final Set<IJsMethodsProvideService.IFactory> a = null;

        static {
            HashSet r0 = new HashSet();
            a = r0;
            IRechargeServiceExternal r1 = k.f(IRechargeServiceExternal.class);
            if (r1 == null) goto L7;
            IJsMethodsProvideService.IFactory r2 = r1.getRechargeJsFactory();
            if (r2 == null) goto L7;
            r0.add(r2);
        L7:
            ICommentService r3 = (ICommentService) k.f(ICommentService.class);
            if (r3 == null) goto L12;
            IJsMethodsProvideService.IFactory r4 = r3.getCommentJsFactory();
            if (r4 == null) goto L12;
            r0.add(r4);
        L12:
            r0.add(k.n(IProfileService.class).getLiveProfileJsFactory());
        }
    }

    public JsMethodsProvideServiceImpl() {
    }

    public synchronized void unregisterAllFactory() {
        monitor-enter(this);
        Set<IJsMethodsProvideService.IFactory> r0 = a.a;     // Catch: Throwable -> L6
        ((HashSet) a.a).clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void registerFactory(IJsMethodsProvideService.IFactory r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "factory");     // Catch: Throwable -> L6
        Set<IJsMethodsProvideService.IFactory> r0 = a.a;     // Catch: Throwable -> L6
        ((HashSet) a.a).add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void unregisterFactory(IJsMethodsProvideService.IFactory r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "factory");     // Catch: Throwable -> L6
        Set<IJsMethodsProvideService.IFactory> r0 = a.a;     // Catch: Throwable -> L6
        ((HashSet) a.a).remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public Map<String, c> provideIJavaMethods(WeakReference<Context> r4, n56.a r5) {
        HashMap r0 = new HashMap();
        Set<IJsMethodsProvideService.IFactory> r1 = a.a;
        Set<IJsMethodsProvideService.IFactory> r2 = a.a;
        if ((!r2.isEmpty()) == true) goto L6;
        r2 = null;
    L6:
        if (r2 == null) goto L13;
        Iterator<T> r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L13;
        Map r6 = ((IJsMethodsProvideService.IFactory) r3.next()).buildMethods(r4, r5);
        if (r6 == null) goto L9;
        r0.putAll(r6);
    L13:
        return r0;
    }
}

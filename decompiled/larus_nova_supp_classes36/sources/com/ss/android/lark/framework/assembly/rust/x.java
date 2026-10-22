package com.ss.android.lark.framework.assembly.rust;

import com.bytedance.lark.pb.basic.v1.DomainSettings;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.lark.pb.tool.v1.OnlineScenario;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService;
import com.ss.android.lark.framework.assembly.larksetting.LarkSettingModuleDependency;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passport_user.api.IUserListService;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class x implements te6.d {
    public final l0c.c a;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Future<Map<String, String>> a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ long c;

        public b(Future<Map<String, String>> r1, Ref.IntRef r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Map<String, String> r0 = this.a.get();     // Catch: Throwable -> L4
            opb.e r1 = opb.e.a.a;     // Catch: Throwable -> L4
            int r2 = this.b.element;     // Catch: Throwable -> L4
            long r3 = this.c;     // Catch: Throwable -> L4
            r1.getClass();     // Catch: Throwable -> L4
            opb.e.f(r2, true, r3, r0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ Ref.IntRef a;

        public c(Ref.IntRef r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            opb.e r0 = opb.e.a.a;     // Catch: Throwable -> L4
            int r1 = this.a.element;     // Catch: Throwable -> L4
            r0.getClass();     // Catch: Throwable -> L4
            opb.e.f(r1, false, 0, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ te6.c a;

        public d(te6.c r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            opb.e r0 = opb.e.a.a;     // Catch: Throwable -> L4
            te6.c r1 = this.a;     // Catch: Throwable -> L4
            r0.g(r1.g, r1.a, r1.b, false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<V> implements Callable {
        public final /* synthetic */ te6.c a;

        public e(te6.c r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public final Map<String, String> call() {
            ppb.a.InterfaceC0313a r0 = ((ppb.a) ApiUtils.getApi(ppb.a.class)).getFeatureGatingDependency();
            te6.c r1 = this.a;
            String r2 = r1.a;
            Map r3 = r1.g;
            ((LarkSettingModuleDependency.a) r0).getClass();
            return idb.f.a().getChangedKeysBySyncUpdate(r2, r3);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    static {
    }

    public final void onComplete() {
    }

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    @Inject
    public x(l0c.c r2) {
        Intrinsics.checkNotNullParameter(r2, "userFlowMonitor");
        this.a = r2;
    }

    public void onNext(te6.c r15) {
        Intrinsics.checkNotNullParameter(r15, "t");
        Log.i("RustOnlineResponseObserver", "onNext start");
        long r1 = System.currentTimeMillis();
        gpb.a r3 = (gpb.a) ApiUtils.getApi(gpb.a.class);
        IUserListService r4 = (IUserListService) e0c.k.a(LarkContext.getApplication(), IUserListService.class);
        this.a.a(String.valueOf(r15.f.getValue()));
        if (r15.d == true) goto L6;
        Log.i("RustOnlineResponseObserver", "onNext failed");
        return;
    L6:
        StringBuilder r5 = new StringBuilder("now isForeground: ");
        r5.append(r15.b);
        r5.append(", online uid: ");
        r5.append(r15.a);
        r5.append(", global uid: ");
        User r6 = r4.getForegroundUser();
        String r7 = null;
        if (r6 == null) goto L9;
        String r8 = r6.userId;
    L10:
        r5.append(r8);
        Log.i("RustOnlineResponseObserver", r5.toString());
        if (r15.b == false) goto L13;
        r4.q();
    L13:
        StringBuilder r9 = new StringBuilder("then global uid: ");
        User r10 = r4.getForegroundUser();
        if (r10 == null) goto L16;
        String r11 = r10.userId;
    L17:
        r9.append(r11);
        Log.i("RustOnlineResponseObserver", r9.toString());
        DomainSettings r12 = r15.e;
        if (r12 == null) goto L53;
        if (r15.b == false) goto L28;
        Log.i("RustOnlineResponseObserver", "sync execute start, before domain update.");
        LinkedHashMap r13 = new LinkedHashMap();
        List r14 = r12.pairs;
        if (r14 == null) goto L27;
        Iterator r16 = r14.iterator();
    L25:
        if (r16.hasNext() == false) goto L27;
        DomainSettings.Pair r17 = (DomainSettings.Pair) r16.next();
        r13.put(r17.alias_str, r17.domains);
    L27:
        jcb.b.c().h0(r13);
        Log.i("RustOnlineResponseObserver", "sync execute finish.");
        Log.i("RustOnlineResponseObserver", "updateDomainSettings from rust online response for foreground user.");
    L28:
        InitSDKRequest.EnvV2 r18 = r15.c;
        if (r18 == null) goto L33;
        InitSDKRequest.EnvV2.Type r19 = r18.type;
        if (r19 == null) goto L33;
        InitSDKRequest.EnvType r20 = InitSDKRequest.EnvType.fromValue(r19.getValue());
    L34:
        InitSDKRequest.EnvV2 r21 = r15.c;
        if (r21 == null) goto L37;
        String r22 = r21.unit;
    L38:
        if (r21 == null) goto L40;
        r7 = r21.brand;
    L40:
        IDomainConfigService r23 = jcb.b.c();
        String r24 = r15.a;
        if (r20 != null) goto L43;
        r20 = InitSDKRequest.EnvType.fromValue(r3.envType());
    L43:
        InitSDKRequest.EnvType r110 = r20;
        if (r22 != null) goto L46;
        r22 = r3.getUserUnit();
    L46:
        String r111 = r22;
        if (r7 != null) goto L49;
        r7 = r3.getTenantBrand();
    L49:
        r23.K0(r24, r110, r111, r7, r15.e);
        if (r15.b == false) goto L53;
        Log.i("RustOnlineResponseObserver", "updateFastDomainCache, after domain update");
        gcb.a.b();
        goto L53
    L37:
        r22 = null;
    L33:
        r20 = null;
    L53:
        if (CollectionUtils.isNotEmpty(r15.g) == false) goto L71;
        OnlineScenario r25 = r15.f;
        if (r25 != OnlineScenario.FIRST_TIME_LOGIN) goto L57;
    L60:
        boolean r26 = true;
    L61:
        Log.i("RustOnlineResponseObserver", "updateAppSettings, isSyncUpdate: " + r26 + ", OnlineScenario: " + r15.f);
        if (r26 == false) goto L70;
        Ref.IntRef r27 = new Ref.IntRef();
        if (r15.f != OnlineScenario.VERSION_CHANGED) goto L73;
        r27.element = 1;
    L73:
        Future r28 = CoreThreadPool.getDefault().getFixedThreadPool().submit(new e(r15));     // Catch: Exception -> L68
        long r29 = System.currentTimeMillis();     // Catch: Exception -> L68
        opb.e.a.a.g(r15.g, r15.a, r15.b, true);     // Catch: Exception -> L68
        long r30 = System.currentTimeMillis() - r29;     // Catch: Exception -> L68
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new b(r28, r27, r30));     // Catch: Exception -> L68
        Log.i("RustOnlineResponseObserver", "updateAppSettings success, syncCost: " + r30);     // Catch: Exception -> L68
    L68:
        e = move-exception;
        Log.e("RustOnlineResponseObserver", "updateAppSettings error", e);
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new c(r27));
        goto L71
    L70:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new d(r15));
        goto L71
    L57:
        if (r25 == OnlineScenario.VERSION_CHANGED) goto L60;
        r26 = false;
    L71:
        Log.i("RustOnlineResponseObserver", "onNext finish, cost: " + (System.currentTimeMillis() - r1));
        return;
    L16:
        r11 = null;
        goto L17
    L9:
        r8 = null;
        goto L10
    }

    public final /* bridge */ /* synthetic */ void onNext(Object r1) {
        onNext((te6.c) r1);
    }
}

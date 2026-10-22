package com.ss.android.lark.framework.assembly.appcontext;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.ApkUtil;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.appcontext.applifecycle.FocusHitPoint;
import com.ss.android.lark.appcontext.applifecycle.LifecycleHandler;
import com.ss.android.lark.appcontext.applifecycle.e;
import com.ss.android.lark.appcontext.applifecycle.n;
import com.ss.android.lark.appcontext.applifecycle.y;
import com.ss.android.lark.appcontext.applifecycle.z;
import com.ss.android.lark.appcontext.applifecycle2.api.AppLifecycle2;
import com.ss.android.lark.appcontext.applifecycle2.impl.c;
import com.ss.android.lark.appcontext.applifecycle2.impl.g;
import com.ss.android.lark.appcontext.applifecycle2.ipc.BroadcastRemoteStateService;
import com.ss.android.lark.appcontext.timingdector.MainPageLifecycleManager;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mva.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/framework/assembly/appcontext/InitAppLifecycleTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "", "dependency", "Lcom/ss/android/lark/appcontext/applifecycle/IRunningProcessChecker;", "<init>", "(Lcom/ss/android/lark/appcontext/applifecycle/IRunningProcessChecker;)V", "execute", "", "context", "Landroid/content/Context;", "Companion", "appcontext-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InitAppLifecycleTask extends AbstractLaunchTask<Object> {
    public static final AtomicBoolean d = null;
    public final z c;

    public static final class a {
    }

    public static final class b implements y {
        public final /* synthetic */ Context a;

        public b(Context r1) {
            this.a = r1;
        }

        public final void f(y.a r3, y.a r4) {
            Intrinsics.checkNotNullParameter(r3, "oldState");
            Intrinsics.checkNotNullParameter(r4, "newState");
            if (r4.c == true) goto L5;
            return;
        L5:
            if (r3.c == true) goto L12;
            String r5 = com.larksuite.framework.utils.z.b(this.a);
            boolean r6 = DevEnvUtil.isDebugMode(this.a);
            String r0 = ApkUtil.getAppVersionName(this.a);
            if (r6 == false) goto L9;
            r0 = r0 + "-debug";
        L9:
            Log.i("InitAppLifecycleTask", "app enter foreground, process=" + r5 + ", app_version=" + r0);
            return;
        }
    }

    static {
        d = new AtomicBoolean(false);
    }

    @Inject
    public InitAppLifecycleTask(z r2) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        this.c = r2;
    }

    public final void a(Context r12) {
        Intrinsics.checkNotNullParameter(r12, "context");
        boolean r1 = false;
        if (d.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        boolean r0 = r12 instanceof Application;
        if (r0 == false) goto L8;
        Application r3 = (Application) r12;
        LifecycleHandler.a(r3);
        MainPageLifecycleManager r4 = MainPageLifecycleManager.a.a;
        r4.getClass();
        r3.registerActivityLifecycleCallbacks(r4);
    L8:
        boolean r5 = this.c.canUseRunningProcess();
        AppLifecycle r6 = AppLifecycle.a.a;
        ArrayList r7 = new ArrayList();
        r6.getClass();
        if (r0 == false) goto L11;
        Application r8 = (Application) r12;
    L12:
        r6.b = r8;
        r6.m = r5;
        r6.n = true;
        String r9 = com.larksuite.framework.utils.z.c(r12);
        if (TextUtils.isEmpty(r9) == false) goto L15;
        r9 = "main";
    L15:
        r6.a = r9;
        Iterator r10 = r7.iterator();
    L17:
        if (r10.hasNext() == false) goto L21;
        String r11 = (String) r10.next();
        if (r6.a.startsWith(r11) == false) goto L17;
        Log.i("AppLifecycle", "init func, process " + r11 + ", not call setup");
    L28:
        Intrinsics.checkNotNullParameter(r12, "context");
        AppLifecycle2.ProcessStateSyncMode r13 = AppLifecycle2.ProcessStateSyncMode.SINGLE;
        ArrayList r14 = new ArrayList();
        if (com.larksuite.framework.utils.z.e(r12) == true) goto L49;
        String r15 = com.larksuite.framework.utils.z.b(r12);
        if (TextUtils.isEmpty(r15) == false) goto L33;
    L35:
        boolean r16 = false;
    L36:
        if (r16 == true) goto L49;
        if (o0.c(r12) == true) goto L48;
        String r17 = com.larksuite.framework.utils.z.b(r12);
        if (TextUtils.isEmpty(r17) == false) goto L43;
    L45:
        if (r1 == true) goto L48;
        AppLifecycle2.ProcessStateSyncMode r2 = AppLifecycle2.ProcessStateSyncMode.SINGLE;
    L50:
        Intrinsics.checkNotNullParameter(r2, "mode");
        lva.a r18 = new lva.a();
        Intrinsics.checkNotNullParameter(r18, "extension");
        r14.add(r18);
        if (r0 == false) goto L53;
        Application r19 = (Application) r12;
    L54:
        ArrayList r20 = new ArrayList(r14);
        AppLifecycle2.b r21 = new AppLifecycle2.b(r19, r2, r5, r20);
        c r22 = AppLifecycle2.a;
        Intrinsics.checkNotNullParameter(r21, "config");
        Application r23 = r21.getContext();
        String r24 = AppLifecycle2.c(r23);
        g r25 = new g(r24, new com.ss.android.lark.appcontext.applifecycle2.impl.a(r23, r20));
        Intrinsics.checkNotNullParameter("broadcast", "name");
        Intrinsics.checkNotNullParameter(r23, "application");
        if (Intrinsics.areEqual("broadcast", "broadcast") == false) goto L80;
        mva.b r26 = new BroadcastRemoteStateService(r23);
        int r27 = AppLifecycle2.c.a[r2.ordinal()];
        if (r27 != 1) goto L59;
    L66:
        AppLifecycle2.a = new c(r23, r25, r26, r5);
        LinkedList r28 = AppLifecycle2.b;
        monitor-enter(r28);
        Iterator r29 = r28.iterator();     // Catch: Throwable -> L76
    L70:
        if (r29.hasNext() == false) goto L72;
        AppLifecycle2.d((jva.b) r29.next());     // Catch: Throwable -> L76
        goto L70
    L72:
        AppLifecycle2.b.clear();     // Catch: Throwable -> L76
        Unit r30 = Unit.INSTANCE;     // Catch: Throwable -> L76
        monitor-exit(r28);
        Log.i("AppLifecycle2", "process: " + r24 + ", AppLifecycle2 init end");
        com.ss.android.lark.appcontext.applifecycle2.api.a.c(new b(r12));
        boolean r110 = FocusHitPoint.a;
        InitAppLifecycleTask$execute$2 r111 = InitAppLifecycleTask$execute$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r111, "logger");
        FocusHitPoint.d = r111;
        Log.i("InitAppLifecycleTask", "init finish, canUseRunningProcess:" + r5);
        return;
    L76:
        th = move-exception;
        throw th;
    L59:
        if (r27 != 2) goto L61;
        mva.b r31 = new d(r26);
    L65:
        r26 = r31;
        goto L66
    L61:
        if (r27 == 3) goto L63;
        r26 = new mva.b();
        goto L66
    L63:
        r31 = new mva.c(r24, r26);
        goto L65
    L80:
        throw new UnsupportedOperationException("process service broadcast not implement yet");
    L53:
        Context r32 = r12.getApplicationContext();
        Intrinsics.checkNotNull(r32, "null cannot be cast to non-null type android.app.Application");
        r19 = (Application) r32;
        goto L54
    L43:
        if (r17.contains(":sandboxed_process") == false) goto L45;
        r1 = true;
    L48:
        r2 = AppLifecycle2.ProcessStateSyncMode.ONLY_DETECTOR;
        goto L50
    L33:
        if (r15.contains(":simple") == false) goto L35;
        r16 = true;
    L49:
        r2 = AppLifecycle2.ProcessStateSyncMode.ONLY_TRIGGER;
        goto L50
    L21:
        com.ss.android.lark.appcontext.applifecycle.g r33 = r6.k;
        if (r33 == null) goto L24;
        Uri r34 = AppLifecycle.LifecycleContentProvider.g;
        r8.getContentResolver().unregisterContentObserver(r33);
    L24:
        n r35 = r6.l;
        if (r35 == null) goto L27;
        r8.unregisterActivityLifecycleCallbacks(r35);
    L27:
        r6.j = y.a.a(null, r6.g(), r6.a, 0);
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new e(r6, r8));
        com.ss.android.lark.appcontext.applifecycle.g r36 = new com.ss.android.lark.appcontext.applifecycle.g(r6, new Handler(Looper.getMainLooper()), r8);
        r6.k = r36;
        Uri r37 = AppLifecycle.LifecycleContentProvider.g;
        r8.getContentResolver().registerContentObserver(AppLifecycle.LifecycleContentProvider.a(r8), true, r36);
        n r38 = new n(r6);
        r6.l = r38;
        r8.registerActivityLifecycleCallbacks(r38);
        goto L28
    L11:
        r8 = (Application) r12.getApplicationContext();
        goto L12
    }
}

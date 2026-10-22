package com.larus.bmhome.chat.screenshot;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ScreenRecordManager {
    public static final CopyOnWriteArrayList<WeakReference<e>> a = null;
    public static final AtomicBoolean b = null;
    public static final Set<String> c = null;
    public static final Set<String> d = null;
    public static final Object e = null;
    public static boolean f;
    public static String g;
    public static final b h = null;

    public static final class a {
        public static final a a = null;
        public static k b;

        static {
            a = new a();
        }

        public a() {
        }

        public static void a(Context r6) {
            Intrinsics.checkNotNullParameter(r6, "context");
            Activity r2 = AppHost.a.a().getCurrentActivity();
            WindowManager r4 = null;
            if (r2 == null) goto L5;
            Object r3 = r2.getSystemService("window");
        L7:
            if ((r3 instanceof WindowManager) == false) goto L9;
            WindowManager r5 = (WindowManager) r3;
        L10:
            if (r5 != null) goto L25;
            Object r7 = r6.getSystemService("window");
            if ((r7 instanceof WindowManager) == false) goto L14;
            r4 = (WindowManager) r7;
        L14:
            if (r4 != null) goto L16;
            return;
        L16:
            r5 = r4;
        L25:
            Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L19
            Executor r9 = ContextCompat.getMainExecutor(r6);     // Catch: Throwable -> L19
            k r10 = b;     // Catch: Throwable -> L19
            Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L19
            int r11 = r5.addScreenRecordingCallback(r9, r10);     // Catch: Throwable -> L19
            FLogger.a.d("ScreenRecordManager", "Check current recording status: " + r11);     // Catch: Throwable -> L19
            k r1 = b;     // Catch: Throwable -> L19
            Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L19
            r1.accept(Integer.valueOf(r11));     // Catch: Throwable -> L19
            Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
        L21:
            Throwable r13 = Result.exceptionOrNull-impl(r12);
            if (r13 == null) goto L27;
            FLogger.a.e("ScreenRecordManager", "register screen recording callback error: ", r13);
            return;
        L27:
            return;
        L19:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            r12 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L21
        L9:
            r5 = null;
            goto L10
        L5:
            r3 = null;
            goto L7
        }
    }

    public static final class b implements f09.a.b {
        public b() {
        }

        public final void onAllActivityDestroyed() {
            CopyOnWriteArrayList<WeakReference<e>> r0 = ScreenRecordManager.a;
            ScreenRecordManager.b("app_background");
        }

        public final void onAppBackground() {
            CopyOnWriteArrayList<WeakReference<e>> r0 = ScreenRecordManager.a;
            ScreenRecordManager.b("app_background");
        }

        public final void onAppForeground() {
            if (Build.VERSION.SDK_INT < 35) goto L6;
            a r0 = a.a;
            Application r1 = AppHost.a.getApplication();
            r0.getClass();
            a.a(r1);
            return;
        }
    }

    public ScreenRecordManager() {
    }

    static {
        a = new CopyOnWriteArrayList();
        b = new AtomicBoolean(false);
        c = new LinkedHashSet();
        d = new LinkedHashSet();
        e = new Object();
        h = new b();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.larus.bmhome.chat.screenshot.j] */
    public static void a(e r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        Iterator<WeakReference<e>> r0 = a.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        if (Intrinsics.areEqual(r0.next().get(), r12) == false) goto L6;
        return;
    L10:
        com.larus.platform.service.g.a.i(new j());
        AtomicBoolean r1 = b;
        if (r1.get() == true) goto L43;
        AppHost.Companion r2 = AppHost.a;
        r2.a().j(h);
        if (Build.VERSION.SDK_INT < 35) goto L19;
        a r3 = a.a;
        Application r4 = r2.getApplication();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "context");
        if (a.b != null) goto L18;
        a.b = new k();
    L18:
        a.a(r4);
    L19:
        boolean r5 = true;
        r1.set(true);
        Keva r6 = Keva.getRepo("screen_record_crash_cache");
        Set r7 = r6.getStringSet("crash_msg_ids", null);
        Set r8 = r6.getStringSet("crash_log_ids", null);
        Set r9 = r7;
        if (r9 != null) goto L22;
    L25:
        boolean r10 = true;
    L26:
        if (r10 == false) goto L34;
        Set r11 = r8;
        if (r11 != null) goto L30;
    L33:
        if (r5 == true) goto L43;
    L30:
        if (r11.isEmpty() == true) goto L33;
        r5 = false;
    L34:
        if (r7 == null) goto L37;
        List r13 = CollectionsKt.toMutableList(r7);
        if (r13 == null) goto L37;
    L38:
        if (r8 == null) goto L41;
        List r14 = CollectionsKt.toMutableList(r8);
        if (r14 == null) goto L41;
    L42:
        r6.erase("crash_msg_ids");
        r6.erase("crash_log_ids");
        FLogger.a.i("ScreenRecordManager", "Found crash cache! Uploading " + r13.size() + " messages from previous session.");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ScreenRecordManager$checkAndUploadCrashData$1(r13, r14, null), 2, null);
    L41:
        r14 = new ArrayList();
    L37:
        r13 = new ArrayList();
        goto L38
    L22:
        if (r9.isEmpty() == true) goto L25;
        r10 = false;
    L43:
        a.add(new WeakReference(r12));
        FLogger.a.i("ScreenRecordManager", "addScreenRecordSessionListener");
    }

    public static void b(String r9) {
        FLogger.a.d("ScreenRecordManager", "End session due to ".concat(r9));
        if (f == true) goto L5;
        return;
    L5:
        String r0 = g;
        if (r0 != null) goto L8;
        return;
    L8:
        CopyOnWriteArrayList<WeakReference<e>> r1 = a;
        Iterator<WeakReference<e>> r2 = r1.iterator();
    L9:
        boolean r4 = true;
        if (r2.hasNext() == false) goto L18;
        WeakReference<e> r3 = r2.next();
        WeakReference<e> r6 = r3;
        Intrinsics.checkNotNullParameter(r6, "it");
        if (r6.get() == null) goto L16;
        r4 = false;
    L16:
        if (Boolean.valueOf(r4).booleanValue() == false) goto L9;
        r1.remove(r3);
        goto L9
    L18:
        Iterator<WeakReference<e>> r5 = r1.iterator();
    L20:
        if (r5.hasNext() == false) goto L24;
        e r7 = r5.next().get();
        if (r7 == null) goto L20;
        r7.b(r0, r9);
        goto L20
    L24:
        FLogger r8 = FLogger.a;
        StringBuilder r10 = new StringBuilder("Start processing session messages: msgIdsize - ");
        Set<String> r11 = c;
        r10.append(r11.size());
        r10.append(" logIdsize ");
        Set<String> r12 = d;
        r10.append(r12.size());
        r8.i("ScreenRecordManager", r10.toString());
        Object r13 = e;
        monitor-enter(r13);
        Pair r14 = new Pair(CollectionsKt.toList(r11), CollectionsKt.toList(r12));     // Catch: Throwable -> L44
        monitor-exit(r13);
        f = false;
        g = null;
        monitor-enter(r13);
        r11.clear();     // Catch: Throwable -> L41
        r12.clear();     // Catch: Throwable -> L41
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r13);
        if ((!((Collection) r14.getFirst()).isEmpty()) == true) goto L37;
        if ((!((Collection) r14.getSecond()).isEmpty()) == true) goto L37;
        return;
    L37:
        if (Intrinsics.areEqual(r9, "App crash") == false) goto L39;
        Keva r16 = Keva.getRepo("screen_record_crash_cache");
        r16.storeStringSet("crash_msg_ids", CollectionsKt.toSet((Iterable) r14.getFirst()));
        r16.storeStringSet("crash_log_ids", CollectionsKt.toSet((Iterable) r14.getSecond()));
        r8.i("ScreenRecordManager", "Saved " + ((List) r14.getFirst()).size() + " messages to Keva for next launch due to crash.");
        return;
    L39:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ScreenRecordManager$endSession$4(r14, null), 2, null);
        return;
    L41:
        th = move-exception;
        throw th;
    L44:
        th = move-exception;
        throw th;
    }

    public static void c(Collection r6, Collection r7) {
        Intrinsics.checkNotNullParameter(r6, "messageIdList");
        Intrinsics.checkNotNullParameter(r7, "logIdList");
        if (f == true) goto L5;
        return;
    L5:
        Object r0 = e;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L35
        Iterator r8 = r6.iterator();     // Catch: Throwable -> L35
    L8:
        boolean r3 = false;
        if (r8.hasNext() == false) goto L15;
        Object r2 = r8.next();     // Catch: Throwable -> L35
        if (((String) r2).length() <= 0) goto L13;
        r3 = true;
    L13:
        if (r3 == false) goto L8;
        r1.add(r2);     // Catch: Throwable -> L35
        goto L8
    L15:
        Iterator r9 = r1.iterator();     // Catch: Throwable -> L35
    L17:
        if (r9.hasNext() == false) goto L19;
        String r4 = (String) r9.next();     // Catch: Throwable -> L35
        c.add(r4);     // Catch: Throwable -> L35
        goto L17
    L19:
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L35
        Iterator r11 = r7.iterator();     // Catch: Throwable -> L35
    L21:
        if (r11.hasNext() == false) goto L28;
        Object r5 = r11.next();     // Catch: Throwable -> L35
        if (((String) r5).length() <= 0) goto L25;
        boolean r12 = true;
    L26:
        if (r12 == false) goto L21;
        r10.add(r5);     // Catch: Throwable -> L35
        goto L21
    L25:
        r12 = false;
        goto L26
    L28:
        Iterator r13 = r10.iterator();     // Catch: Throwable -> L35
    L30:
        if (r13.hasNext() == false) goto L32;
        String r14 = (String) r13.next();     // Catch: Throwable -> L35
        d.add(r14);     // Catch: Throwable -> L35
        goto L30
    L32:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(r0);
        return;
    L35:
        th = move-exception;
        throw th;
    }
}

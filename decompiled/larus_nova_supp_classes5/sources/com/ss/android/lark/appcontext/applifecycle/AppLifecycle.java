package com.ss.android.lark.appcontext.applifecycle;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.z;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class AppLifecycle {
    public String a;
    public Context b;
    public WeakReference<Activity> c;
    public final ActivityRecorder d;
    public WeakReference<Activity> e;
    public final Map<String, WeakReference<Activity>> f;
    public final Map<String, WeakReference<Activity>> g;
    public final CopyOnWriteArrayList<y> h;
    public final CopyOnWriteArrayList<com.ss.android.lark.appcontext.applifecycle.a> i;
    public y$a j;
    public g k;
    public n l;
    public boolean m;
    public boolean n;

    public static class LifecycleContentProvider extends ContentProvider {
        public static Uri g;
        public final List<ProcessRecord> a;
        public final List<ProcessRecord> b;
        public final List<ProcessRecord> c;
        public String d;
        public volatile boolean e;
        public final b f;

        @Override // android.content.ContentProvider
        public final boolean onCreate() {
            this.e = false;
            Context r1 = getContext();
            if (r1 != null) goto L6;
            Log.e("AppLifecycle", "onCreate get context is null, so return");
            return false;
        L6:
            Context r0 = r1.getApplicationContext();
            if (r0 != null) goto L10;
            Log.e("AppLifecycle", "getForegroundProcess: context is null, so return");
        L14:
            Log.i("AppLifecycle", "onCreate: init top process is " + this.d);
            return true;
        L10:
            if (a.a.m == false) goto L14;
            if (z.d(r0) == false) goto L14;
            this.d = "foreground";
            goto L14
        }

        public LifecycleContentProvider() {
            this.a = new ArrayList(2);
            this.b = new ArrayList(2);
            this.c = new ArrayList();
            this.f = new b();
        }

        public static Uri a(Context r2) {
            if (g != null) goto L6;
            g = UriProtector.parse("content://" + r2.getPackageName() + ".provider.applifecycle");
        L6:
            return g;
        }

        @Override // android.content.ContentProvider
        public String getType(Uri r2) {
            Log.e("AppLifecycle", "getType not support yet!");
            return null;
        }

        @Override // android.content.ContentProvider
        public Uri insert(Uri r2, ContentValues r3) {
            Log.e("AppLifecycle", "insert not support yet!");
            return r2;
        }

        public static Bundle c(Context r2, String r3, Bundle r4) {
            return r2.getContentResolver().call(a(r2), r3, "", r4);
        L4:
            e = move-exception;
            e.printStackTrace();
            Log.e("AppLifecycle", String.format("call method %s failed: %s", new Object[]{r3, e.getMessage()}));
            return null;
        }

        @Override // android.content.ContentProvider
        public Bundle call(String r11, String r12, Bundle r13) {
            Bundle r14 = new Bundle();
            int r3 = 0;
            ProcessRecord r4 = null;
            if ("getAppState".equals(r11) == false) goto L20;
            ArrayList r15 = new ArrayList(3);
            if (this.e == false) goto L7;
            r15.addAll(this.a);
        L10:
            String[] r16 = new String[r15.size()];
            String[] r0 = new String[r15.size()];
            long r6 = 0;
        L12:
            if (r3 >= r15.size()) goto L15;
            ProcessRecord r8 = (ProcessRecord) ListProtector.get(r15, r3);
            r16[r3] = r8.a;
            r0[r3] = r8.b;
            r6 = Math.max(r6, r8.c);
            r3 = r3 + 1;
            goto L12
        L15:
            if (r6 != 0) goto L17;
            r6 = SystemClock.elapsedRealtime();
        L17:
            r14.putStringArray("extra_top_process", r16);
            r14.putStringArray("extra_activity", r0);
            r14.putLong("extra_timestamp", r6);
            return r14;
        L7:
            if ("foreground".equals(this.d) == false) goto L10;
            r15.add(new ProcessRecord(this.d, null, SystemClock.elapsedRealtime()));
            goto L10
        L20:
            if ("getRecentStoppedActivity".equals(r11) == true) goto L22;
        L25:
            if (r13 != null) goto L27;
            return r14;
        L27:
            String r1 = r13.getString("extra_current_process");
            boolean r5 = r13.getBoolean("extra_is_front");
            String r2 = r13.getString("extra_activity");
            Lifecycle.Event r7 = Lifecycle.Event.values()[r13.getInt("extra_lifecycle_event")];
            ProcessRecord r17 = new ProcessRecord(r1, r2, r13.getLong("extra_timestamp"));
            if (TextUtils.isEmpty(r1) == false) goto L31;
            return r14;
        L31:
            if ("processToBackground".equals(r11) == false) goto L69;
            this.e = true;
            List<ProcessRecord> r9 = this.a;
        L33:
            ArrayList r10 = (ArrayList) r9;
            if (r3 >= r10.size()) goto L39;
            ProcessRecord r18 = (ProcessRecord) ListProtector.get(r10, r3);
            if (r1.equals(r18.a) == true) goto L37;
            r3 = r3 + 1;
            goto L33
        L37:
            r4 = r18;
        L39:
            if (r4 == null) goto L43;
            if (r4.c < r17.c) goto L43;
        L56:
            if (r7 != Lifecycle.Event.ON_STOP) goto L59;
            ((ArrayList) this.c).add(r17);
        L59:
            if (r7 != Lifecycle.Event.ON_DESTROY) goto L61;
        L62:
            int r19 = ((ArrayList) this.c).size() - 1;
        L63:
            if (r19 < 0) goto L68;
            ProcessRecord r110 = (ProcessRecord) ListProtector.get(this.c, r19);
            if (Objects.equals(r110.b, r2) == true) goto L66;
            r19 = r19 - 1;
            goto L63
        L66:
            ((ArrayList) this.c).remove(r110);
        L68:
            b r111 = this.f;
            r111.b = new o(this);
            r111.a.removeCallbacks(r111);
            r111.a.postDelayed(r111, 50);
            goto L69
        L61:
            if (r7 != Lifecycle.Event.ON_START) goto L68;
        L43:
            if (r7.compareTo(Lifecycle.Event.ON_START) > 0) goto L47;
            if (r5 == false) goto L47;
            ((ArrayList) this.a).add(r17);
            Collections.sort(this.a);
        L47:
            if (r7.compareTo(Lifecycle.Event.ON_STOP) < 0) goto L56;
            if (r4 == null) goto L56;
            List<ProcessRecord> r20 = this.a;
            a r21 = new a(r17);
            Intrinsics.checkNotNullParameter(r20, "list");
            Intrinsics.checkNotNullParameter(r21, "predicate");
            ArrayList r22 = (ArrayList) r20;
            Iterator r23 = r22.iterator();
        L51:
            if (r23.hasNext() == false) goto L56;
            Object r24 = r23.next();
            if (((Boolean) r21.invoke(r24)).booleanValue() == false) goto L51;
            r22.remove(r24);
        L69:
            return r14;
        L22:
            if (((ArrayList) this.c).isEmpty() == false) goto L24;
            return null;
        L24:
            r14.putParcelable("extra_recent_stopped_activity", (ProcessRecord) CollectionsKt.last(this.c));
            goto L25
        }

        @Override // android.content.ContentProvider
        public int delete(Uri r1, String r2, String[] r3) {
            Log.e("AppLifecycle", "delete not support yet!");
            return 0;
        }

        @Override // android.content.ContentProvider
        public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
            Log.e("AppLifecycle", "update not support yet!");
            return 0;
        }

        @Override // android.content.ContentProvider
        public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
            Log.e("AppLifecycle", "query not support yet!");
            return null;
        }

        public static void b(Context r2, String r3, Activity r4, Lifecycle.Event r5, boolean r6, long r7) {
            Bundle r0 = new Bundle();
            r0.putString("extra_current_process", r3);
            r0.putBoolean("extra_is_front", r6);
            r0.putLong("extra_timestamp", r7);
            if (r4 == null) goto L5;
            r0.putString("extra_activity", r4.getClass().getName());
            r0.putInt("extra_lifecycle_event", r5.ordinal());
        L5:
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new p(r3, r6, r2, r0));
        }
    }

    public static final class a {
        public static final AppLifecycle a = null;

        static {
            a = new AppLifecycle();
        }
    }

    public static class b implements Runnable {
        public final Handler a;
        public Runnable b;

        @Override // java.lang.Runnable
        public final void run() {
            Runnable r0 = this.b;     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            r0.run();     // Catch: Throwable -> L7
        L5:
            this.b = null;     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public b() {
            this.a = new Handler(Looper.getMainLooper());
        }
    }

    public final Activity e() {
        y$a r0 = this.j;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        ActivityRecorder r2 = this.d;
        d r3 = new d(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "accept");
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        r2.c(new ActivityRecorder.getFrontActivity.2(r3, r4));
        return (Activity) r4.element;
    L10:
        return null;
    L5:
        if (r0.d == false) goto L7;
        r1 = true;
        goto L8
    }

    public final Activity f() {
        return this.d.a();
    }

    public final boolean h() {
        y$a r0 = this.j;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (this.d.a() == null) goto L12;
        r1 = true;
    L12:
        if (z.e(this.b) == false) goto L20;
        if (r2 == r1) goto L20;
        Log.e("AppLifecycle", "isAppFront() app state not match, appFront:" + r2 + ", processFront:" + r1, new Throwable(), true);
        if (this.m == true) goto L21;
        if (r1 == false) goto L20;
        return true;
    L21:
        return z.d(this.b);
    L20:
        return r2;
    L5:
        if (r0.c == false) goto L7;
        r2 = true;
        goto L9
    }

    public AppLifecycle() {
        this.c = new WeakReference(null);
        this.d = new ActivityRecorder();
        this.e = new WeakReference(null);
        this.f = new HashMap();
        this.g = new LinkedHashMap();
        this.j = new y$a();
        this.m = false;
        this.n = false;
        this.h = new CopyOnWriteArrayList();
        this.i = new CopyOnWriteArrayList();
    }

    public final String g() {
        Activity r0 = f();
        if (r0 == null) goto L7;
        return r0.getClass().getName();
    L7:
        if (h() == false) goto L18;
        ActivityManager r1 = (ActivityManager) this.b.getSystemService("activity");
        if (r1 == null) goto L20;
        List<ActivityManager.RunningTaskInfo> r2 = r1.getRunningTasks(1);
        if (r2 != null) goto L13;
        return "";
    L13:
        if (r2.isEmpty() == true) goto L22;
        ComponentName r3 = ((ActivityManager.RunningTaskInfo) ListProtector.get(r2, 0)).topActivity;
        if (r3 != null) goto L17;
        return "";
    L17:
        return r3.getClassName();
    L22:
        return "";
    L20:
        return "";
    L18:
        return "";
    }

    public final void b(com.ss.android.lark.appcontext.applifecycle.a r2) {
        if (this.i.contains(r2) == true) goto L6;
        this.i.add(r2);
        return;
    }

    public final void c(y r2) {
        this.h.add(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v15, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final y$a d(Context r12) {
        String r0 = this.a;
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r0, "mCurrentProcessName");
        String r2 = null;
        Bundle r13 = LifecycleContentProvider.c(r12, "getAppState", null);
        if (r13 == null) goto L12;
        String[] r3 = r13.getStringArray("extra_top_process");
        String[] r4 = r13.getStringArray("extra_activity");
        long r5 = r13.getLong("extra_timestamp", r13.getLong("extra_timestamp"));
        if (r3 == null) goto L11;
        if (r4 == null) goto L11;
        ?? r14 = new ArrayList(r3.length);
        int r7 = 0;
    L9:
        if (r7 >= r3.length) goto L13;
        r14.add(new ProcessRecord(r3[r7], r4[r7], r5));
        r7 = r7 + 1;
    L13:
        Collection r6 = (Collection) r14;
        if (r6 != null) goto L16;
    L19:
        boolean r8 = true;
    L20:
        if (r8 == true) goto L56;
        Iterable r9 = (Iterable) r14;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r11 = r9.iterator();
    L24:
        if (r11.hasNext() == false) goto L26;
        r10.add(((ProcessRecord) r11.next()).a);
        goto L24
    L26:
        String[] r15 = (String[]) r10.toArray(new String[0]);
        ProcessRecord r16 = (ProcessRecord) ListProtector.get(r14, 0);
        if (r16 == null) goto L29;
        String r17 = r16.b;
    L30:
        ProcessRecord r18 = (ProcessRecord) ListProtector.get(r14, 0);
        if (r18 == null) goto L33;
        long r19 = r18.c;
    L34:
        if (r15 == null) goto L50;
        if (r15.length != 0) goto L38;
        boolean r110 = true;
    L40:
        if ((!r110) == false) goto L50;
        if (r0 == null) goto L50;
        Iterator r111 = ArrayIteratorKt.iterator(r15);
    L44:
        if (r111.hasNext() == false) goto L48;
        if (Intrinsics.areEqual(r0, (String) r111.next()) == false) goto L44;
        r2 = r0;
        goto L50
    L48:
        r2 = r15[0];
        goto L50
    L38:
        r110 = false;
    L50:
        return y$a.a(r2, r17, r0, r19);
    L33:
        r19 = SystemClock.elapsedRealtime();
        goto L34
    L29:
        r17 = null;
        goto L30
    L56:
        return y$a.a(null, null, r0, SystemClock.elapsedRealtime());
    L16:
        if (r6.isEmpty() == true) goto L19;
        r8 = false;
    L11:
        r14 = Collections.emptyList();
        goto L13
    L12:
        r14 = 0;
        goto L13
    }

    public final void j(com.ss.android.lark.appcontext.applifecycle.a r2) {
        this.i.remove(r2);
    }

    public static void a(AppLifecycle r3, y$a r4) {
        if (z.e(r3.b) == true) goto L5;
        return;
    L5:
        if (r3.n == false) goto L9;
        Log.i("AppLifecycle", String.format("hotfixNotifyAppStateChangeImmediately, newState:{isFront:%s, time:%s, top:%s}", new Object[]{Boolean.valueOf(r4.c), Long.valueOf(r4.e), r4.a}));
        r3.i(r3.j, r4);
        return;
    }

    public final void i(y$a r7, y$a r8) {
        y$a r0 = this.j;
        if (r0.e < r8.e) goto L5;
        return;
    L5:
        if (r0.equals(r8) == false) goto L7;
        return;
    L7:
        if (r8.c == true) goto L12;
        if (this.d.a() == null) goto L12;
        return;
    L12:
        if (z.e(this.b) == false) goto L22;
        boolean r1 = r8.c;
        boolean r3 = false;
        if (this.d.a() != null) goto L16;
        boolean r2 = true;
    L17:
        if (r1 != r2) goto L22;
        StringBuilder r4 = new StringBuilder("onAppStateChange() state not match, appFront:");
        r4.append(r8.c);
        r4.append("，topActivity:");
        if (f() == null) goto L21;
        r3 = true;
    L21:
        r4.append(r3);
        Log.e("AppLifecycle", r4.toString(), new Throwable(), true);
        goto L22
    L16:
        r2 = false;
    L22:
        this.j = r8;
        Log.i("AppLifecycle", "state changed, topProc:" + r8.a + "，appFront:" + r8.c + ", time:" + r8.e);
        Iterator<y> r5 = this.h.iterator();
    L24:
        if (r5.hasNext() == false) goto L29;
        r5.next().f(r7, r8);
        goto L24
    }
}

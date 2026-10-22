package com.lynx.basedevtool.logbox;

import a5a.l;
import a5a.m;
import a5a.n;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LogBoxProxy {
    private static final String TAG = "LogBoxProxy";
    private WeakReference<Context> mActivity;
    private String mErrNamespace;
    private Map<LogBoxLogLevel, List<String>> mLogs;
    private WeakReference<a5a.a> mProvider;

    public class a implements com.lynx.basedevtool.logbox.a.InterfaceC0031a {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        @Override // com.lynx.basedevtool.logbox.a.InterfaceC0031a
        public final void a(Context r7, a5a.c r8) {
            String r0 = this.a;
            if (r7 != null) goto L5;
            r8.b.b(r8.a, Boolean.FALSE);
            return;
        L5:
            AssetManager r9 = r7.getAssets();
            if (r9 != null) goto L9;
            r8.b.b(r8.a, Boolean.FALSE);
            return;
        L9:
            if (TextUtils.isEmpty(r0) == false) goto L51;
            r8.b.b(r8.a, Boolean.FALSE);
            return;
        L51:
            InputStream r10 = r9.open(r0);     // Catch: IOException -> L39
            BufferedReader r1 = new BufferedReader(new InputStreamReader(r10, StandardCharsets.UTF_8));     // Catch: Throwable -> L30
            StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L22
            char[] r3 = new char[8192];     // Catch: Throwable -> L22
        L14:
            int r5 = r1.read(r3, 0, 8192);     // Catch: Throwable -> L22
            if (r5 <= 0) goto L17;
            r2.append(r3, 0, r5);     // Catch: Throwable -> L22
            goto L14
        L17:
            String r4 = r2.toString();     // Catch: Throwable -> L22
            r8.b.b.a(r4);     // Catch: Throwable -> L22
            r8.b.b(r8.a, Boolean.TRUE);     // Catch: Throwable -> L22
            r1.close();     // Catch: Throwable -> L30
            if (r10 == null) goto L58;
            r10.close();     // Catch: IOException -> L39
            return;
        L58:
            return;
        L22:
            th = move-exception;
            throw th;     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            r1.close();     // Catch: Throwable -> L27
        L29:
            throw th;     // Catch: Throwable -> L30
        L27:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            throw th;     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            if (r10 != null) goto L46;
        L38:
            throw th;     // Catch: IOException -> L39
        L46:
            r10.close();     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L39
        L39:
            e = move-exception;
            e.getMessage();
            r8.b.b(r8.a, Boolean.FALSE);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ LogBoxLogLevel b;
        public final /* synthetic */ LogBoxProxy c;

        @Override // java.lang.Runnable
        public final void run() {
            LogBoxProxy.access$000(this.c, this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(LogBoxProxy r1, String r2, LogBoxLogLevel r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ LogBoxLogLevel a;
        public final /* synthetic */ LogBoxProxy b;

        public final void a() {
            List r0 = (List) LogBoxProxy.access$100(this.b).get(this.a);
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isEmpty() == true) goto L13;
            Iterator r1 = r0.iterator();
        L9:
            if (r1.hasNext() == false) goto L14;
            String r2 = (String) r1.next();
            n.a.a.a(r2, this.a, (Context) LogBoxProxy.access$200(this.b).get(), this.b);
            goto L9
        L14:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(LogBoxProxy r1, LogBoxLogLevel r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ LogBoxProxy a;

        public final void a() {
            n r0 = n.a.a;
            Context r1 = (Context) LogBoxProxy.access$200(this.a).get();
            LogBoxProxy r2 = this.a;
            if (r1 != null) goto L5;
            r0.getClass();
            l r3 = null;
        L6:
            if (r3 == null) goto L32;
            if (r2 == null) goto L33;
            Iterator r4 = ((HashMap) r3.b).entrySet().iterator();
        L11:
            if (r4.hasNext() == false) goto L17;
            Map.Entry r5 = (Map.Entry) r4.next();
            if (((l.a) r5.getValue()).b(r2) == false) goto L11;
            m r6 = r3.c;
            if (r6 == null) goto L11;
            LogBoxLogLevel r7 = (LogBoxLogLevel) r5.getKey();
            Map<LogBoxLogLevel, Boolean> r8 = r6.d;
            HashMap r9 = (HashMap) r8;
            r9.put(r7, Boolean.TRUE);
            goto L11
        L17:
            a5a.b r10 = r3.d;
            if (r10 != null) goto L20;
        L22:
            r3.e();
        L23:
            r2.clearAllLogs();
            return;
        L20:
            if (r10.isShowing() == false) goto L22;
            r3.d.b();
            l.a(r3.d);
            goto L23
        L33:
            return;
        L32:
            return;
        L5:
            r3 = r0.a.get(r1);
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(LogBoxProxy r1) {
            this.a = r1;
        }
    }

    private void showCacheLogMessage() {
        showCacheLogMessageByLogLevel(LogBoxLogLevel.Warn);
        showCacheLogMessageByLogLevel(LogBoxLogLevel.Error);
    }

    public void clearAllLogs() {
        Iterator<List<String>> r0 = this.mLogs.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().clear();
        goto L4
    }

    public String getEntryUrlForLogSrc() {
        a5a.a r0 = this.mProvider.get();
        if (r0 != null) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return r0.getEntryUrlForLogSrc();
    }

    public Map<String, Object> getLogSources() {
        a5a.a r0 = this.mProvider.get();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getLogSources();
    }

    public void reset() {
        d r0 = new d(this);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        r0.run();
        return;
    L8:
        b5a.c.a(r0);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public String getErrorNamespace() {
        return this.mErrNamespace;
    }

    public static /* synthetic */ Map access$100(LogBoxProxy r0) {
        return r0.mLogs;
    }

    public static /* synthetic */ WeakReference access$200(LogBoxProxy r0) {
        return r0.mActivity;
    }

    private Context findActivityByContext(Context r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if ((r3 instanceof ContextWrapper) == false) goto L11;
        if ((r3 instanceof Activity) == true) goto L9;
        r3 = ((ContextWrapper) r3).getBaseContext();
        goto L6
    L9:
        return r3;
    L11:
        return null;
    }

    private void showCacheLogMessageByLogLevel(LogBoxLogLevel r3) {
        c r0 = new c(this, r3);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        r0.run();
        return;
    L8:
        b5a.c.a(r0);
        return;
    L5:
        r4 = false;
        goto L6
    }

    public void attachContext(Context r2) {
        WeakReference<Context> r0 = this.mActivity;
        if (r0 != null) goto L5;
    L6:
        Context r3 = findActivityByContext(r2);
        if (r3 != null) goto L9;
        return;
    L9:
        this.mActivity = new WeakReference(r3);
        showCacheLogMessage();
        return;
    L5:
        if (r0.get() == null) goto L6;
    }

    public void clearLogsWithLevel(LogBoxLogLevel r2) {
        List<String> r3 = this.mLogs.get(r2);
        if (r3 == null) goto L6;
        r3.clear();
        return;
    }

    public String getLastLog(LogBoxLogLevel r3) {
        List<String> r4 = this.mLogs.get(r3);
        if (r4 != null) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        if (r4.isEmpty() == false) goto L9;
        return NameKeys.UnloadStrategy_No_Strategy;
    L9:
        return (String) ListProtector.get(r4, r4.size() - 1);
    }

    public int getLogCount(LogBoxLogLevel r2) {
        List<String> r3 = this.mLogs.get(r2);
        if (r3 != null) goto L6;
        return 0;
    L6:
        return r3.size();
    }

    public List<String> getLogMessages(LogBoxLogLevel r2) {
        List<String> r3 = this.mLogs.get(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return new ArrayList();
    }

    public String getLogSourceWithFileName(String r2) {
        a5a.a r0 = this.mProvider.get();
        if (r0 != null) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return r0.getLogSourceWithFileName(r2);
    }

    public void registerErrorParser(String r5) {
        com.lynx.basedevtool.logbox.a r0 = com.lynx.basedevtool.logbox.a.b.a;
        String r1 = this.mErrNamespace;
        a r2 = new a(r5);
        r0.getClass();
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        if (((HashMap) r0.a).get(r1) != null) goto L19;
        Map<String, com.lynx.basedevtool.logbox.a.InterfaceC0031a> r6 = r0.a;
        monitor-enter(r6);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (((HashMap) r0.a).get(r1) != null) goto L11;
        ((HashMap) r0.a).put(r1, r2);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r6);     // Catch: Throwable -> L13
        return;
    }

    private void onNewLog(String r3, LogBoxLogLevel r4) {
        Objects.toString(r4);
        List<String> r0 = this.mLogs.get(r4);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.add(r3);
        WeakReference<Context> r1 = this.mActivity;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.get() == null) goto L13;
        n.a.a.a(r3, r4, this.mActivity.get(), this);
        return;
    }

    public void showLogMessage(String r3, LogBoxLogLevel r4) {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        onNewLog(r3, r4);
        return;
    L8:
        b5a.c.a(new b(this, r3, r4));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public LogBoxProxy(Context r3, String r4, a5a.a r5) {
        this.mProvider = new WeakReference(r5);
        this.mActivity = new WeakReference(null);
        HashMap r6 = new HashMap();
        this.mLogs = r6;
        r6.put(LogBoxLogLevel.Error, new ArrayList());
        this.mLogs.put(LogBoxLogLevel.Warn, new ArrayList());
        if (r4 != null) goto L6;
        r4 = "__unknown__";
    L6:
        this.mErrNamespace = r4;
        attachContext(r3);
    }

    public static /* synthetic */ void access$000(LogBoxProxy r0, String r1, LogBoxLogLevel r2) {
        r0.onNewLog(r1, r2);
    }
}

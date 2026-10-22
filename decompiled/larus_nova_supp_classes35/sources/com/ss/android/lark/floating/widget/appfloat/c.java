package com.ss.android.lark.floating.widget.appfloat;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final c a = null;
    public static final Map<String, AppFloatManager> b = null;

    public static final class a implements Runnable {
        public final /* synthetic */ AppFloatManager a;

        public a(AppFloatManager r1, int r2, int r3) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AppFloatManager r0 = this.a;     // Catch: Throwable -> L6
            if (r0.e == null) goto L9;
            AppFloatManager.i(r0, null, null, 3);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public c() {
    }

    static {
        a = new c();
        b = new LinkedHashMap();
    }

    public static AppFloatManager a(String r1) {
        Map<String, AppFloatManager> r0 = b;
        if (r1 != null) goto L6;
        r1 = "default";
    L6:
        return (AppFloatManager) ((LinkedHashMap) r0).get(r1);
    }

    public final void update(String r5) {
        Map<String, AppFloatManager> r0 = b;
        if (r5 != null) goto L5;
        r5 = "default";
    L5:
        AppFloatManager r6 = (AppFloatManager) ((LinkedHashMap) r0).get(r5);
        if (r6 == null) goto L11;
        d r1 = r6.e;
        if (r1 == null) goto L12;
        r1.post(new a(r6, r1.getWidth(), r1.getHeight()));
        return;
    L12:
        return;
    }
}

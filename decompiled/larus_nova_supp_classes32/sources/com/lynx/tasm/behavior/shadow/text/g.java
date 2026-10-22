package com.lynx.tasm.behavior.shadow.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.fontface.FontFaceManager;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g {
    public static final Map<String, Typeface[]> a = null;
    public static final Map<Typeface, Typeface[]> b = null;
    public static final String[] c = null;
    public static final String[] d = null;
    public static final ConcurrentHashMap<String, a> e = null;
    public static final List<b> f = null;

    public static class a {
        public final Typeface a;

        public a(Typeface r1) {
            this.a = r1;
        }
    }

    public interface b {
        Typeface a(String r1, int r2);
    }

    public interface c {
        void a(Typeface r1, int r2);
    }

    public g() {
    }

    static {
        a = new HashMap();
        b = new HashMap();
        c = new String[]{NameKeys.UnloadStrategy_No_Strategy, "_bold", "_italic", "_bold_italic"};
        d = new String[]{".ttf", ".otf"};
        e = new ConcurrentHashMap();
        f = new ArrayList();
    }

    public static synchronized void a(b r2) {
        monitor-enter(g.class);
        ((ArrayList) f).add(r2);     // Catch: Throwable -> L7
        monitor-exit(g.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Typeface c(String r3, int r4) {
        monitor-enter(g.class);
        Typeface[] r1 = (Typeface[]) ((HashMap) a).get(r3);     // Catch: Throwable -> L24
        if (r1 == null) goto L10;
        Typeface r2 = r1[r4];     // Catch: Throwable -> L24
        if (r2 == null) goto L10;
        monitor-exit(g.class);
        return r2;
    L10:
        Iterator r5 = ((ArrayList) f).iterator();     // Catch: Throwable -> L24
    L12:
        if (r5.hasNext() == false) goto L21;
        b r6 = (b) r5.next();     // Catch: Throwable -> L24
        if (r6 == null) goto L12;
        Typeface r7 = r6.a(r3, r4);     // Catch: Throwable -> L24
        if (r7 == null) goto L12;
        b(r3, r4, r7);     // Catch: Throwable -> L24
        monitor-exit(g.class);
        return r7;
    L21:
        monitor-exit(g.class);
        return null;
    L24:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(String r3, int r4, Typeface r5) {
        monitor-enter(g.class);
        Map<String, Typeface[]> r1 = a;     // Catch: Throwable -> L10
        Typeface[] r2 = (Typeface[]) ((HashMap) r1).get(r3);     // Catch: Throwable -> L10
        if (r2 != null) goto L7;
        r2 = new Typeface[4];     // Catch: Throwable -> L10
        ((HashMap) r1).put(r3, r2);     // Catch: Throwable -> L10
    L7:
        r2[r4] = r5;     // Catch: Throwable -> L10
        ((HashMap) b).put(r5, r2);     // Catch: Throwable -> L10
        monitor-exit(g.class);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized Typeface d(LynxContext r7, String r8, int r9) {
        monitor-enter(g.class);
        String[] r1 = r8.split(",");     // Catch: Throwable -> L21
        int r2 = r1.length;     // Catch: Throwable -> L21
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L18;
        String r5 = com.lynx.tasm.utils.c.d(r1[r3]);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r5) == true) goto L17;
        Typeface r6 = c(r5, r9);     // Catch: Throwable -> L21
        if (r6 != null) goto L11;
        Typeface r4 = FontFaceManager.g.a.g(r7, r5, r9, null);     // Catch: Throwable -> L21
        if (r4 == null) goto L17;
        monitor-exit(g.class);
        return r4;
    L11:
        monitor-exit(g.class);
        return r6;
    L17:
        r3 = r3 + 1;
        goto L6
    L18:
        LLog.v("TypefaceCache", "Can't not find typeface for fontFamily: " + r8 + " in lynx.");     // Catch: Throwable -> L21
        monitor-exit(g.class);
        return null;
    L21:
        th = move-exception;
        throw th;
    }

    public static Typeface e(AssetManager r6, String r7, int r8, String r9) {
        String r0 = r7 + r9 + r8;
        ConcurrentHashMap<String, a> r1 = e;
        if (r1.containsKey(r0) == true) goto L5;
        String r10 = c[r8];
        StringBuilder r2 = new StringBuilder(32);
        r2.append(r9);
        String r3 = "/";
        if (r9.endsWith("/") == false) goto L9;
    L10:
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L11:
        r2.append(r3);
        r2.append(r7);
        r2.append(r10);
        int r11 = r2.length();
        String[] r12 = d;
        int r13 = r12.length;
        int r4 = 0;
    L12:
        if (r4 >= r13) goto L20;
        String r5 = r12[r4];
        String r14 = r2.toString();
        if (r14.endsWith(r5) == true) goto L22;
        r2.append(r5);
        r14 = r2.toString();
    L22:
        Typeface r15 = Typeface.createFromAsset(r6, r14);     // Catch: RuntimeException -> L18
        e.put(r0, new a(r15));     // Catch: RuntimeException -> L18
        return r15;
    L18:
        e = move-exception;
        LLog.w("TypefaceCache", "Exception happens whe cacheTypefaceFromAssets with message " + e.getMessage());
        r2.setLength(r11);
        r4 = r4 + 1;
        goto L12
    L20:
        e.put(r0, new a(null));
        return null;
    L9:
        if (r9.equals(NameKeys.UnloadStrategy_No_Strategy) == false) goto L11;
    L5:
        return r1.get(r0).a;
    }
}

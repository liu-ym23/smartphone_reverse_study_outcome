package com.bytedance.crash.nativecrash;

import ai.g0;
import android.os.Debug;
import androidx.annotation.Keep;
import cl.a;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.c;
import com.bytedance.crash.n;
import com.bytedance.crash.p;
import com.bytedance.crash.runtime.ConfigManager;
import com.bytedance.crash.util.ListMap;
import com.bytedance.crash.util.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l9.l;
import m.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NativeCrashCollector {
    public static void a(File r5, File r10, String r11) {
    L6:
        th = move-exception;
        c.f4025a.getClass();
        b.h("NPTH_CATCH", th);
        return;
    L4:
        if (n.f4062j.isEngMode() == false) goto L8;
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L6
        r12.add(r5.getAbsolutePath());     // Catch: Throwable -> L6
        r12.add(r10.getAbsolutePath());     // Catch: Throwable -> L6
        String r13 = g.f4181a;     // Catch: Throwable -> L6
        r12.add(new File(g.b(n.f4057a), r11).getAbsolutePath());     // Catch: Throwable -> L6
        a.x(r12);     // Catch: Throwable -> L6
    L8:
        g0 r14 = p.f;     // Catch: Throwable -> L6
        List r15 = ((ListMap) r14.f210b).a(CrashType.NATIVE);     // Catch: Throwable -> L6
        io.reactivex.exceptions.a.c("notifyNativeCrashEx: enter");     // Catch: Throwable -> L6
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L6
    L10:
        if (r16.hasNext() == false) goto L11;
        if (r16.next() != null) goto L21;
        io.reactivex.exceptions.a.c("notifyNativeCrashEx: begin");     // Catch: Throwable -> L18
        CrashType r17 = CrashType.LAUNCH;     // Catch: Throwable -> L18
        throw null;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        c.f4025a.getClass();     // Catch: Throwable -> L6
        b.h("NPTH_CATCH", th);     // Catch: Throwable -> L6
        goto L10
    L21:
        throw new ClassCastException();     // Catch: Throwable -> L6
    L11:
        ConfigManager r18 = n.f4062j;     // Catch: Throwable -> L6
        if (r18.isEngMode() == false) goto L30;
        io.reactivex.exceptions.a.c("notifyNativeCrashEx: sleep time = " + r18.getDelayTime());     // Catch: Throwable -> L6
        Thread.sleep(r18.getDelayTime());     // Catch: Throwable -> L6
        io.reactivex.exceptions.a.c("notifyNativeCrashEx: sleep end");     // Catch: Throwable -> L6
        return;
    }

    public static void b(String r5) {
        g0 r10 = p.f;
        ListMap r11 = (ListMap) r10.f209a;
        monitor-enter(r11);
        List r12 = ((ListMap) r10.f209a).a(CrashType.NATIVE);     // Catch: Throwable -> L15
        monitor-exit(r11);     // Catch: Throwable -> L15
        Iterator r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L14;
        ICrashCallback r14 = (ICrashCallback) r13.next();
        r14.onCrash(CrashType.NATIVE, r5, null);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        c.f4025a.getClass();
        b.h("NPTH_CATCH", th);
        goto L8
    L14:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Keep
    public static void onNativeCrash(String r10) {
        io.reactivex.exceptions.a.i("[onNativeCrash] enter");
        File r5 = g.e;
        if (r5 != null) goto L5;
        r5 = g.g(n.f4057a);
    L5:
        File r11 = new File(r5, n.f());
        if (p.f4086j == true) goto L8;
    L10:
        a.a.q(g.f(n.f4057a));
        File r12 = new File(g.f(n.f4057a), "viewTree.txt");
        if (r12.exists() == false) goto L37;
    L13:
        new JSONObject();
        com.bytedance.crash.upload.g.s().n();     // Catch: Throwable -> L21
        File r13 = new File(r11, r11.getName());     // Catch: Throwable -> L21
        z8.c r14 = l.f().g(CrashType.NATIVE, null, new q7.a(8, r10, false, r13), true);     // Catch: Throwable -> L21
        if (n.f4062j.isEngMode() == false) goto L19;
        i9.g r15 = new i9.g(r11);
        String r16 = g.f4181a;
        r15.d(new File(r11, "tombstone.txt"));
        b(r15.a());
        System.currentTimeMillis();
        String r17 = n.f();
        JSONObject r18 = r14.f23416a;
        a(g.f(n.f4057a), r11, r17);
        return;
    L19:
        b("");
        return;
    L21:
        th = move-exception;
        c.f4025a.getClass();     // Catch: Throwable -> L28
        b.h("NPTH_CATCH", th);     // Catch: Throwable -> L28
        if (n.f4062j.isEngMode() == false) goto L26;
        i9.g r19 = new i9.g(r11);
        String r20 = g.f4181a;
        r19.d(new File(r11, "tombstone.txt"));
        b(r19.a());
        System.currentTimeMillis();
        String r21 = n.f();
        a(g.f(n.f4057a), r11, r21);
        return;
    L26:
        b("");
        return;
    L28:
        th = move-exception;
        if (n.f4062j.isEngMode() == false) goto L32;
        i9.g r22 = new i9.g(r11);
        String r23 = g.f4181a;
        r22.d(new File(r11, "tombstone.txt"));
        b(r22.a());
        System.currentTimeMillis();
        String r24 = n.f();
        a(g.f(n.f4057a), r11, r24);
    L33:
        throw th;
    L32:
        b("");
        goto L33
    L37:
        a.p(r12, a.a.d());     // Catch: Throwable -> L34
        goto L13
    L8:
        if (Debug.isDebuggerConnected() == false) goto L10;
        a.s(r11.getAbsolutePath());
        goto L10
    }
}

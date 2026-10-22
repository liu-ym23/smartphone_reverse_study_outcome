package com.bytedance.crash.dumper;

import android.app.Activity;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.crash.util.JSONWriter;
import com.bytedance.crash.util.j;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.BufferedWriter;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class q {
    public static void a(File r11) {
        JSONArray r0 = new JSONArray();
        ArrayList r1 = bi4.a.d().h;
        BufferedWriter r3 = null;
        if (r1 != null) goto L5;
    L28:
        r0 = null;
    L29:
        if (r0 == null) goto L66;
        PolarisFileWrapper r2 = new PolarisFileWrapper(r11, "viewTree.txt");
        r2.getParentFile().mkdirs();     // Catch: Throwable -> L39
        BufferedWriter r12 = new BufferedWriter(new PolarisFileWriterWrapper(r2, false));     // Catch: Throwable -> L38
        new JSONWriter(r12).a(r0);     // Catch: Throwable -> L35
        r12.flush();     // Catch: Throwable -> L35
        com.bytedance.crash.util.g.a(r12);     // Catch: Throwable -> L39
    L44:
        return;
    L35:
        r3 = r12;
    L36:
        com.bytedance.crash.util.g.a(r3);     // Catch: Throwable -> L39
    L67:
        return;
    L66:
        return;
    L5:
        if (r1.size() <= 0) goto L28;
        LinkedList r4 = new LinkedList();
        Iterator r5 = r1.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        Activity r6 = (Activity) ((WeakReference) r5.next()).get();
        if (r6 == null) goto L9;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L9;
        View r8 = r7.peekDecorView();
        if (r8 == null) goto L9;
        JSONObject r9 = new JSONObject();
        r4.add(new Pair(r8, r9));
        r0.put(r9);
    L18:
        if (r4.isEmpty() == true) goto L29;
        Pair r10 = (Pair) r4.pop();
        View r13 = (View) r10.first;
        JSONObject r14 = (JSONObject) r10.second;
        j.h(r14, "cls", String.valueOf(r13.getClass()));
        if ((r13 instanceof ViewGroup) == false) goto L18;
        ViewGroup r15 = (ViewGroup) r13;
        int r16 = r15.getChildCount();
        JSONArray r17 = new JSONArray();
        j.h(r14, "children", r17);
        int r18 = 0;
    L22:
        if (r18 >= r16) goto L18;
        View r19 = r15.getChildAt(r18);     // Catch: Throwable -> L27
        if (r19 == null) goto L26;
        JSONObject r20 = new JSONObject();     // Catch: Throwable -> L27
        r17.put(r20);     // Catch: Throwable -> L27
        r4.push(new Pair(r19, r20));     // Catch: Throwable -> L27
    L26:
        r18 = r18 + 1;
        goto L22
    }
}

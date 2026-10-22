package idb;

import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static List<String> a() {
        c r0 = c.a.a;
        r0.getClass();
        ArrayList r5 = new ArrayList();
        String r1 = r0.g();
        long r6 = System.currentTimeMillis();
    L24:
        e = move-exception;
        Log.e("DefaultFeatureGatingHandler", "getAllFeaturesKeys failed with error cost " + (System.currentTimeMillis() - r6) + "ms.", e, true);
    L26:
        return r5;
    L4:
        if (TextUtils.isEmpty(r1) == false) goto L6;
        Log.i("DefaultFeatureGatingHandler", "getAllFeaturesKeys failed with empty config cost " + (System.currentTimeMillis() - r6) + "ms.");     // Catch: Exception -> L24
        goto L26
    L6:
        JSONObject r2 = JSON.parseObject(r1);     // Catch: Exception -> L24
        JSONArray r4 = r2.getJSONArray("online");     // Catch: Exception -> L24
        if (r4 != null) goto L9;
        Log.i("DefaultFeatureGatingHandler", "getAllFeaturesKeys failed with empty boolean values cost " + (System.currentTimeMillis() - r6) + "ms.");     // Catch: Exception -> L24
        goto L26
    L9:
        Iterator r3 = r4.iterator();     // Catch: Exception -> L24
    L10:
        if (r3 == null) goto L14;
        if (r3.hasNext() == false) goto L14;
        r5.add(r3.next().toString());     // Catch: Exception -> L24
    L14:
        JSONObject r7 = r2.getJSONObject("values");     // Catch: Exception -> L24
        if (r7 != null) goto L17;
        Log.i("DefaultFeatureGatingHandler", "getAllFeaturesKeys failed with empty string values cost " + (System.currentTimeMillis() - r6) + "ms.");     // Catch: Exception -> L24
        goto L26
    L17:
        Iterator r8 = r7.keySet().iterator();     // Catch: Exception -> L24
    L18:
        if (r8 == null) goto L22;
        if (r8.hasNext() == false) goto L22;
        r5.add(r8.next().toString());     // Catch: Exception -> L24
    L22:
        Log.i("DefaultFeatureGatingHandler", "getAllFeaturesKeys success cost " + (System.currentTimeMillis() - r6) + "ms.");     // Catch: Exception -> L24
        goto L26
    }

    public static Boolean b(String r12) {
        final c r0 = c.a.a;
        r0.getClass();
        boolean r4 = false;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L13;
        Future<HashSet<String>> r3 = r0.j;
        if (r3 != null) goto L11;
    L12:
        Log.i("DefaultFeatureGatingHandler", "getDefaultFG too early " + r12 + ", will block ui thread to load, start the timer.");
        long r8 = System.currentTimeMillis();
    L15:
        if (r0.j != null) goto L51;
        Object r5 = r0.i;
        monitor-enter(r5);
    L25:
        th = move-exception;
        throw th;
    L19:
        if (r0.j == null) goto L22;
        monitor-exit(r5);     // Catch: Throwable -> L25
    L48:
        goto L51
    L22:
        r0.j = CoreThreadPool.getDefault().getFixedThreadPool().submit(new a(r0));     // Catch: Throwable -> L25
        monitor-exit(r5);     // Catch: Throwable -> L25
    L51:
        if (r2 == false) goto L30;
        HashSet<String> r1 = r0.j.get(200, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L40 InterruptedException -> L42 ExecutionException -> L44
    L31:
        if (r1 != null) goto L33;
    L35:
        boolean r6 = false;
    L37:
        if (r8 <= 0) goto L39;
        Log.i("DefaultFeatureGatingHandler", "getDefaultFG too early " + r12 + ", block ui thread cost " + (System.currentTimeMillis() - r8) + "ms.");     // Catch: Throwable -> L40 InterruptedException -> L42 ExecutionException -> L44
    L39:
        r4 = r6;
    L47:
        return Boolean.valueOf(r4);
    L33:
        if (r1.contains(r12) == false) goto L35;
        r6 = true;
        goto L37
    L30:
        r1 = r0.j.get();     // Catch: Throwable -> L40 InterruptedException -> L42 ExecutionException -> L44
    L40:
        e = move-exception;
        Log.e("DefaultFeatureGatingHandler", "getDefaultFG failed with key " + r12, e, true);
        goto L47
    L11:
        if (r3.isDone() == false) goto L12;
    L13:
        r8 = 0;
        goto L15
    L5:
        r2 = false;
        goto L7
    }
}

package com.bytedance.bdinstall.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.DrLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NetUtils {
    public NetUtils() {
    }

    public static boolean isNetReady(Context r3) {
        NetworkInfo r4 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r4 == null) goto L12;
        if (r4.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static List<Pair<String, String>> parseRequestHeaders(Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        if (r6 != null) goto L5;
    L11:
        return r0;
    L5:
        if (r6.isEmpty() == true) goto L11;
        Iterator r7 = r6.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.add(new Pair(r2.getKey(), r2.getValue()));
        goto L8
    L10:
        DrLog.d("NetUtils#parseHeaders" + r0);
        goto L11
    }

    public static List<Pair<String, String>> parseResponseHeaders(Map<String, List<String>> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        if (r9 != null) goto L5;
    L17:
        return r0;
    L5:
        if (r9.isEmpty() == true) goto L17;
        Iterator r10 = r9.entrySet().iterator();
    L8:
        if (r10.hasNext() == false) goto L16;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L11:
        if (r3 >= ((List) ZeusTransformUtils.preCheckCast(r2.getValue(), List.class, "com.obric.memorydata.plugin")).size()) goto L8;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2.getKey(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L15;
        r0.add(new Pair(r2.getKey(), ((List) ZeusTransformUtils.preCheckCast(r2.getValue(), List.class, "com.obric.memorydata.plugin")).get(r3)));
    L15:
        r3 = r3 + 1;
        goto L11
    L16:
        DrLog.d("NetUtils#parseHeaders" + r0);
        goto L17
    }
}

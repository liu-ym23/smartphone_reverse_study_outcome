package com.bytedance.dataplatform;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static Map<String, Integer> a(Context r4, String r5) {
        SharedPreferences r6 = d((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), r5);
        ConcurrentHashMap r7 = new ConcurrentHashMap();
        Iterator<Map.Entry<String, ?>> r8 = r6.getAll().entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0.getValue(), Integer.class) == false) goto L4;
        r7.put((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin"), (Integer) ZeusTransformUtils.preCheckCast(r0.getValue(), Integer.class, "com.obric.memorydata.plugin"));
        goto L4
    L8:
        return r7;
    }

    public static JSONObject a(Context r2, String r3, String r4) {
        return new JSONObject(d((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3).getString(r4, ""));
    L6:
        return new JSONObject();
    }

    public static void a(Context r2, final String r3, final String r4, final String r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        l.a(new AnonymousClass3(r5, r6, r3, r4));
    }

    public static void a(Context r2, final String r3, final String r4, Set<String> r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        final Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        l.a(new AnonymousClass2(r6, r3, r4, r7));
    }

    public static void a(Context r2, final String r3, final String r4, final JSONObject r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        l.a(new AnonymousClass1(r6, r3, r4, r5));
    }

    public static void a(Context r2, final String r3, Map<String, String> r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        final Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        l.a(new AnonymousClass4(r5, r3, r6));
    }

    public static String b(Context r2, String r3, String r4) {
        return d((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3).getString(r4, "");
    }

    public static Map<String, String> b(Context r4, String r5) {
        SharedPreferences r6 = d((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), r5);
        ConcurrentHashMap r7 = new ConcurrentHashMap();
        Iterator<Map.Entry<String, ?>> r8 = r6.getAll().entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0.getValue(), String.class) == false) goto L4;
        r7.put((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.memorydata.plugin"));
        goto L4
    L8:
        return r7;
    }

    static /* synthetic */ SharedPreferences c(Context r2, String r3) {
        return d((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
    }

    public static Set<String> c(Context r2, String r3, String r4) {
        return new ConcurrentSkipListSet(d((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3).getStringSet(r4, new ConcurrentSkipListSet()));
    }

    private static SharedPreferences d(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        return r6.getSharedPreferences(r5, 0);
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L10;
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.createDeviceProtectedStorageContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(r5, 0);
    L10:
        throw new RuntimeException("abtest SharedPreferences :" + r5);
    }

    public static void d(Context r2, final String r3, final String r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        l.a(new AnonymousClass5(r5, r3, r4));
    }
}

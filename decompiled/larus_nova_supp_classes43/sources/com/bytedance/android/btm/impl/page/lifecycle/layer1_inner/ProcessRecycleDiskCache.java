package com.bytedance.android.btm.impl.page.lifecycle.layer1_inner;

import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g$a;
import com.bytedance.android.btm.api.model.BufferBtm;
import com.bytedance.android.btm.api.model.e;
import com.bytedance.android.btm.impl.BtmServiceImpl;
import com.bytedance.android.btm.impl.chain.BtmChainRecorder;
import com.bytedance.android.btm.impl.g;
import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.BufferQueue;
import com.bytedance.android.btm.impl.page.lifecycle.layer3.BtmPageLifecycleCallbackV2;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.page.model.i;
import com.bytedance.android.btm.impl.page.unknown.UnionChainRecorder;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.startnode.StartNodeManager;
import com.bytedance.android.btm.impl.util.SharedPreferenceUtil;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ProcessRecycleDiskCache {
    public static final Lazy a = null;

    public static final class a implements Runnable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ProcessRecycleDiskCache.d();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static SharedPreferenceUtil a() {
        return (SharedPreferenceUtil) a.getValue();
    }

    static {
        a = LazyKt.lazy(ProcessRecycleDiskCache$sharePreference$2.INSTANCE);
    }

    public static void c() {
        BtmHostDependManager r0 = BtmHostDependManager.F;
        r0.getClass();
        if (((Boolean) BtmHostDependManager.d.getValue(r0, BtmHostDependManager.a[2])).booleanValue() == true) goto L5;
    L7:
        d();
        return;
    L5:
        if (BtmSetting.d.c().b().d() != 1) goto L7;
        ALogger.e(ALogger.d, "ProcessRecycleDiskCache_downgrade", ProcessRecycleDiskCache$saveToCache$1.INSTANCE);
        com.bytedance.android.btm.impl.thread.b.e.b(a.a, true);
    }

    public static void d() {
        BtmChainRecorder r0 = com.bytedance.android.btm.impl.b.e.c();
        r0.getClass();
        Unit r1 = null;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L34
        SharedPreferenceUtil r11 = (SharedPreferenceUtil) r0.b.getValue();     // Catch: Throwable -> L34
        if (r11 == null) goto L17;
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L34
        Map r13 = r0.f;     // Catch: Throwable -> L34
        monitor-enter(r13);     // Catch: Throwable -> L34
        Iterator r14 = r0.f.entrySet().iterator();     // Catch: Throwable -> L14
    L9:
        if (r14.hasNext() == false) goto L11;
        Map.Entry r15 = (Map.Entry) r14.next();     // Catch: Throwable -> L14
        r12.putOpt((String) r15.getKey(), r15.getValue());     // Catch: Throwable -> L14
        goto L9
    L11:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r13);     // Catch: Throwable -> L34
        r11.a("key_btm_chain", r12.toString());     // Catch: Throwable -> L34
        goto L17
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L17:
        SharedPreferenceUtil r17 = (SharedPreferenceUtil) r0.b.getValue();     // Catch: Throwable -> L34
        if (r17 == null) goto L31;
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L34
        Map<String, e> r19 = BtmPageRecorder.k;     // Catch: Throwable -> L34
        monitor-enter(r19);     // Catch: Throwable -> L34
        Iterator<Map.Entry<String, e>> r20 = r19.entrySet().iterator();     // Catch: Throwable -> L28
    L23:
        if (r20.hasNext() == false) goto L25;
        Map.Entry<String, e> r21 = r20.next();     // Catch: Throwable -> L28
        r18.putOpt(r21.getKey(), ((Gson) r0.a.getValue()).toJson(r21.getValue()));     // Catch: Throwable -> L28
        goto L23
    L25:
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r19);     // Catch: Throwable -> L34
        r17.a("btmId_btmPageInfo_map", r18.toString());     // Catch: Throwable -> L34
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L34
    L32:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L34
    L36:
        Throwable r25 = Result.exceptionOrNull-impl(r24);
        if (r25 == null) goto L39;
        r25.printStackTrace();
    L39:
        UnionChainRecorder.a();
        SharedPreferenceUtil r26 = a();
        if (r26 == null) goto L42;
        r26.a("launch_id", com.bytedance.android.btm.impl.b.d);
    L42:
        SharedPreferenceUtil r27 = a();
        if (r27 == null) goto L46;
        r27.a("last_btmId", com.bytedance.android.btm.impl.page.b.d);
    L46:
        if (BtmSetting.d.c().d().t() == 1) goto L96;
    L60:
        StartNodeManager.f();
        g r28 = BtmServiceImpl.INSTANCE.getSaveCacheCallback();
        if (r28 == null) goto L64;
        r28.a();
    L64:
        if (BtmSetting.d.c().b().n() != 1) goto L107;
        String r29 = BufferQueue.a;
        SharedPreferenceUtil r30 = a();
        if (r30 == null) goto L72;
        String r31 = BufferQueue.g;
        BufferBtm r32 = BufferQueue.i;
        if (r32 == null) goto L70;
        String r33 = r32.toString();
    L71:
        r30.a(r31, r33);
        goto L72
    L70:
        r33 = null;
    L72:
        SharedPreferenceUtil r34 = a();
        if (r34 == null) goto L79;
        i r35 = BtmPageLifecycleCallbackV2.h;
        if (r35 == null) goto L77;
        String r36 = r35.toString();
    L78:
        r34.a("paused_info", r36);
        goto L79
    L77:
        r36 = null;
    L79:
        Map<String, PageInfoStack> r37 = fd.a.a;
        SharedPreferenceUtil r38 = a();
        if (r38 != null) goto L98;
    L86:
        Object r39 = Result.constructor-impl(r1);     // Catch: Throwable -> L88
    L91:
        if (Result.exceptionOrNull-impl(r39) == null) goto L108;
        g$a.b(BtmMonitor.c, 1121, "SingletonCache", null, false, 28);
        return;
    L108:
        return;
    L88:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r39 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L91
    L98:
        JSONObject r41 = new JSONObject();     // Catch: Throwable -> L88
        Iterator r42 = ((LinkedHashMap) fd.a.a).entrySet().iterator();     // Catch: Throwable -> L88
    L83:
        if (r42.hasNext() == false) goto L85;
        Map.Entry r43 = (Map.Entry) r42.next();     // Catch: Throwable -> L88
        r41.putOpt((String) r43.getKey(), r43.getValue());     // Catch: Throwable -> L88
        goto L83
    L85:
        r38.a("singleton_cache", r41.toString());     // Catch: Throwable -> L88
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L88
        goto L86
    L107:
        return;
    L96:
        Map<String, BufferBtm> r44 = BufferQueue.l;     // Catch: Throwable -> L58
        JSONObject r45 = new JSONObject();     // Catch: Throwable -> L58
        Iterator<Map.Entry<String, BufferBtm>> r46 = r44.entrySet().iterator();     // Catch: Throwable -> L58
    L50:
        if (r46.hasNext() == false) goto L52;
        Map.Entry<String, BufferBtm> r47 = r46.next();     // Catch: Throwable -> L58
        r45.put(r47.getKey(), r47.getValue().toString());     // Catch: Throwable -> L58
        goto L50
    L52:
        SharedPreferenceUtil r48 = a();     // Catch: Throwable -> L58
        if (r48 == null) goto L55;
        r48.a("last_buffer_btm_map", r45.toString());     // Catch: Throwable -> L58
        Unit r49 = Unit.INSTANCE;     // Catch: Throwable -> L58
    L56:
        Result.constructor-impl(r49);     // Catch: Throwable -> L58
        goto L60
    L55:
        r49 = null;
    L58:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L60
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L31:
        r23 = null;
    L34:
        th = move-exception;
        Result.Companion r51 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    }

    public static void b(PageInfoStack r10) {
        if (r10 == null) goto L4;
        final String r11 = r10.save();
    L5:
        ALogger.e(ALogger.d, "ProcessRecycleDiskCache_saveInfoStack", new ProcessRecycleDiskCache$saveInfoStack$1(r11));
        SharedPreferenceUtil r0 = a();
        if (r0 == null) goto L12;
        if (r11 != null) goto L10;
        r11 = "";
    L10:
        r0.a("page_info_stack", r11);
        return;
    L12:
        return;
    L4:
        r11 = null;
        goto L5
    }
}

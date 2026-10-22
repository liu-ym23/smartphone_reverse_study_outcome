package com.ss.ugc.effectplatform.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ugc.effectplatform.EffectConfig;
import java.io.BufferedReader;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public g() {
    }

    static {
    }

    public static /* synthetic */ HashMap b(EffectConfig r3, int r4) {
        boolean r1 = true;
        if ((r4 & 2) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r4 & 4) != 0) goto L11;
        r1 = false;
    L11:
        return a(r3, r0, r1);
    L5:
        r0 = false;
        goto L7
    }

    public static HashMap a(EffectConfig r18, boolean r19, boolean r20) {
        HashMap r2 = new HashMap();
        int r0 = r.a;
        if (r.b(r18.a) == true) goto L9;
        String r3 = r18.a;
        if (r3 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        r2.put(EffectConfiguration.KEY_ACCESS_KEY, r3);
    L9:
        if (r.b(r18.d) == true) goto L15;
        String r4 = r18.d;
        if (r4 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        r2.put(EffectConfiguration.KEY_DEVICE_ID, r4);
    L15:
        if (r.b(r18.g) == true) goto L21;
        String r5 = r18.g;
        if (r5 != null) goto L19;
        Intrinsics.throwNpe();
    L19:
        r2.put(EffectConfiguration.KEY_DEVICE_TYPE, r5);
    L21:
        if (r.b(r18.h) == true) goto L27;
        String r6 = r18.h;
        if (r6 != null) goto L25;
        Intrinsics.throwNpe();
    L25:
        r2.put("os_version", r6);
    L27:
        if (r.b(r18.f) == true) goto L33;
        String r7 = r18.f;
        if (r7 != null) goto L31;
        Intrinsics.throwNpe();
    L31:
        r2.put(EffectConfiguration.KEY_DEVICE_PLATFORM, r7);
    L33:
        if (r.b(r18.l) == true) goto L39;
        String r8 = r18.l;
        if (r8 != null) goto L37;
        Intrinsics.throwNpe();
    L37:
        r2.put(EffectConfiguration.KEY_REGION, r8);
    L39:
        if (r.b(r18.b) == true) goto L45;
        String r9 = r18.b;
        if (r9 != null) goto L43;
        Intrinsics.throwNpe();
    L43:
        r2.put(EffectConfiguration.KEY_SDK_VERSION, r9);
    L45:
        if (r.b(r18.c) == true) goto L51;
        String r10 = r18.c;
        if (r10 != null) goto L49;
        Intrinsics.throwNpe();
    L49:
        r2.put(EffectConfiguration.KEY_APP_VERSION, r10);
    L51:
        if (r.b(r18.e) == true) goto L57;
        String r11 = r18.e;
        if (r11 != null) goto L55;
        Intrinsics.throwNpe();
    L55:
        r2.put(EffectConfiguration.KEY_CHANNEL, r11);
    L57:
        if (r.b(r18.m) == true) goto L63;
        String r12 = r18.m;
        if (r12 != null) goto L61;
        Intrinsics.throwNpe();
    L61:
        r2.put(EffectConfiguration.KEY_APP_ID, r12);
    L63:
        if (r.b(r18.n) == true) goto L68;
        String r13 = r18.n;
        if (r13 != null) goto L67;
        Intrinsics.throwNpe();
    L67:
        r2.put(EffectConfiguration.KEY_APP_LANGUAGE, r13);
    L68:
        int r1 = bytekn.foundation.utils.a.a;
        HashMap<String, String> r14 = r18.o;
        if (r14 != null) goto L71;
    L74:
        boolean r15 = true;
    L75:
        if (r15 == true) goto L91;
        if (r19 == false) goto L78;
        HashMap<String, String> r16 = r18.o;
    L90:
        r2.putAll(r16);
        goto L91
    L78:
        HashMap<String, String> r17 = r18.o;
        LinkedHashMap r21 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r22 = r17.entrySet().iterator();
    L80:
        if (r22.hasNext() == false) goto L89;
        Map.Entry<String, String> r23 = r22.next();
        String r24 = r23.getKey();
        if ((!Intrinsics.areEqual(r24, EffectConfiguration.KEY_LX)) == true) goto L84;
    L86:
        boolean r25 = false;
    L87:
        if (r25 == false) goto L80;
        r21.put(r23.getKey(), r23.getValue());
        goto L80
    L84:
        if ((!Intrinsics.areEqual(r24, EffectConfiguration.KEY_LY)) == false) goto L86;
        r25 = true;
        goto L87
    L89:
        r16 = r21;
    L91:
        int r26 = r.a;
        if (r.b(r18.B) == true) goto L97;
        String r27 = r18.B;
        if (r27 != null) goto L96;
        Intrinsics.throwNpe();
    L96:
        r2.put(EffectConfiguration.KEY_GPU_INFO, r27);
    L97:
        Integer r28 = r18.O;
        if (r28 != null) goto L100;
    L102:
        new c();
        Object r29 = r18.G;
        HashMap r30 = new HashMap();
        r30.put("platform", 1);
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L105
        Object r32 = Result.constructor-impl(Float.valueOf(CastFloatProtector.parseFloat(((GPUUtils.a) GPUUtils.d.getValue()).b)));     // Catch: Throwable -> L105
    L108:
        if (Result.isFailure-impl(r32) == false) goto L110;
        r32 = null;
    L110:
        Float r33 = (Float) r32;
        if (r33 == null) goto L113;
        r30.put("gl_version", Float.valueOf(r33.floatValue()));
    L113:
        Lazy r34 = GPUUtils.d;
        r30.put("gl_vendor", ((GPUUtils.a) r34.getValue()).c);
        r30.put("gl_renderer", ((GPUUtils.a) r34.getValue()).a);
        if (r20 == false) goto L116;
        r30.put("gl_extension", ((GPUUtils.a) r34.getValue()).h);
    L116:
        if (r29 != null) goto L118;
    L168:
        Object r35 = ((ConcurrentHashMap) d.a).get("cache_key_cpu_model");
        if (r35 == null) goto L172;
        String r36 = (String) r35;
    L201:
        r30.put("cpu_vendor", r36);
        r30.put("os_version", Build.VERSION.RELEASE);
        String r37 = new JSONObject(r30).toString();
        if (r37 == null) goto L204;
        r2.put(EffectConfiguration.KEY_DEVICE_INFO, r37);
    L204:
        r2.put(EffectConfiguration.KEY_PLATFORM_AB_PARAM, String.valueOf(r18.s));
        String r38 = EffectPlatformAES.a;
        if (r38 == null) goto L207;
        r2.put(EffectConfiguration.KEY_PLATFORM_SDK_VERSION, r38);
    L207:
        return r2;
    L172:
        monitor-enter(d.class);
    L212:
        th = move-exception;
        throw th;
    L195:
        e = e;
        BufferedReader r39 = null;
    L221:
        e.printStackTrace();     // Catch: Throwable -> L208
    L198:
        d.a(r39);     // Catch: Throwable -> L212
        r36 = Build.HARDWARE;     // Catch: Throwable -> L212
        monitor-exit(d.class);
    L200:
        ((ConcurrentHashMap) d.a).put("cache_key_cpu_model", r36);
    L208:
        th = th;
    L209:
        BufferedReader r40 = r39;
    L210:
        d.a(r40);     // Catch: Throwable -> L212
        throw th;     // Catch: Throwable -> L212
    L193:
        th = th;
        r39 = null;
        goto L209
    L175:
        if (new PolarisFileWrapper("/proc/cpuinfo").exists() == false) goto L192;
        r40 = new BufferedReader(new PolarisFileReaderWrapper("/proc/cpuinfo"));     // Catch: Throwable -> L193 Exception -> L195
    L227:
        String r41 = r40.readLine();     // Catch: Throwable -> L188 Exception -> L190
        if (r41 == null) goto L187;
        if (r41.contains(":") == false) goto L227;
        String[] r42 = r41.split(":");     // Catch: Throwable -> L188 Exception -> L190
        if (r42[0].contains("Hardware") == false) goto L227;
        r36 = r42[1];     // Catch: Throwable -> L188 Exception -> L190
        d.a(r40);     // Catch: Throwable -> L212
        monitor-exit(d.class);
        goto L200
    L187:
        r39 = r40;
    L190:
        e = e;
        r39 = r40;
    L188:
        th = th;
        goto L210
    L192:
        r39 = null;
        goto L198
    L118:
        if ((r29 instanceof Context) == false) goto L168;
        Context r43 = (Context) r29;
        Object r44 = ((ConcurrentHashMap) d.a).get("cache_key_memory_info");
        if (r44 == null) goto L122;
        d.a r45 = (d.a) r44;
    L165:
        long r46 = r45.a;
        if (r46 <= 0) goto L168;
        r30.put("memory_total_size", Long.valueOf(r46));
        goto L168
    L122:
        d.a r47 = new d.a();
        ActivityManager.MemoryInfo r110 = new ActivityManager.MemoryInfo();     // Catch: Exception -> L127
        ActivityManager r111 = (ActivityManager) r43.getSystemService("activity");     // Catch: Exception -> L127
        if (r111 == null) goto L128;
        r111.getMemoryInfo(r110);     // Catch: Exception -> L127
        long r112 = r110.totalMem;     // Catch: Exception -> L127
    L130:
        if (r112 == (-1)) goto L231;
    L144:
        r47.a = r112;
        ActivityManager.MemoryInfo r48 = new ActivityManager.MemoryInfo();     // Catch: Exception -> L149
        ActivityManager r49 = (ActivityManager) r43.getSystemService("activity");     // Catch: Exception -> L149
        if (r49 == null) goto L150;
        r49.getMemoryInfo(r48);     // Catch: Exception -> L149
        long r113 = r48.availMem;     // Catch: Exception -> L149
    L152:
        if (r113 == (-1)) goto L236;
    L164:
        ((ConcurrentHashMap) d.a).put("cache_key_memory_info", r47);
        r45 = r47;
        goto L165
    L236:
        Closeable r50 = new PolarisFileInputStreamWrapper("/proc/meminfo");     // Catch: Throwable -> L158 Exception -> L162
        d.c("MemAvailable", r50);     // Catch: Throwable -> L156 Exception -> L216
    L156:
        th = th;
        Closeable r51 = r50;
    L160:
        d.a(r51);
        throw th;
    L163:
        d.a(r50);
        goto L164
    L162:
        r50 = null;
    L158:
        th = th;
        r51 = null;
    L150:
        r113 = -1;
        goto L152
    L231:
    L138:
        th = th;
        Closeable r52 = null;
    L140:
        d.a(r52);
        throw th;
    L132:
        if (new PolarisFileWrapper("/proc/meminfo").exists() == false) goto L142;
        Closeable r114 = new PolarisFileInputStreamWrapper("/proc/meminfo");     // Catch: Throwable -> L138 Exception -> L217
        r112 = ((long) d.c("MemTotal", r114)) * DownloadConstants.KB;
        goto L143
    L136:
        th = th;
        r52 = r114;
    L143:
        d.a(r114);
        goto L144
    L142:
        r114 = null;
    L128:
        r112 = -1;
    L105:
        th = move-exception;
        Result.Companion r53 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L108
    L100:
        if (r28.intValue() <= 0) goto L102;
        r2.put(EffectConfiguration.KEY_FILTER_TYPE, String.valueOf(r18.O));
        goto L102
    L71:
        if (r14.isEmpty() == true) goto L74;
        r15 = false;
        goto L75
    }
}

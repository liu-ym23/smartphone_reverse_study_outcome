package com.bytedance.android.live.core.privacy.av.impl;

import android.util.Log;
import com.bytedance.android.live.core.privacy.av.api.PrivacyConfig;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements com.bytedance.android.live.core.privacy.av.api.f {
    public static boolean a;
    public static boolean b;
    public static com.bytedance.android.live.core.privacy.av.api.g c;
    public static PrivacyConfig d;
    public static final ConcurrentHashMap<Integer, Boolean> e = null;
    public static final ConcurrentHashMap<Integer, Boolean> f = null;
    public static final g g = null;

    public g() {
    }

    static {
        g = new g();
        e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
    }

    public static boolean e() {
        if (c == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.f
    public final boolean a() {
        return !a;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.f
    public final boolean b() {
        return !b;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.f
    public final boolean c() {
        return b;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.f
    public final boolean d() {
        return a;
    }

    public static void f(int r15) {
        if (e() == true) goto L5;
        return;
    L5:
        ConcurrentHashMap<Integer, Boolean> r0 = e;
        r0.put(Integer.valueOf(r15), false);
        Iterator<T> r1 = r0.values().iterator();
    L6:
        boolean r2 = false;
    L8:
        if (r1.hasNext() == false) goto L15;
        Boolean r3 = (Boolean) r1.next();
        if (r2 == true) goto L13;
        if (r3.booleanValue() == false) goto L6;
    L13:
        r2 = true;
        goto L8
    L15:
        if (a != r2) goto L17;
    L53:
        q60.a.b.a("onAudioStatusChanged; isAudioActing=" + a + ", instanceHashCode=" + r15 + ", code=0");
        PrivacyConfig r4 = d;
        if (r4 != null) goto L56;
        return;
    L56:
        if (r4.h() != true) goto L70;
        PrivacyConfig r5 = d;
        if (r5 == null) goto L71;
        List<String> r6 = r5.d();
        if (r6 != null) goto L62;
        return;
    L62:
        if (r6.contains("av_status_change") != true) goto L73;
        q60.a.b.c(new com.bytedance.android.live.core.privacy.av.api.i("av_status_change", "onAudioStatusChanged", 0, "", "", "", "", MapsKt.mapOf(new Pair[]{new Pair("code", String.valueOf(0)), new Pair("isAudioActing", String.valueOf(a)), new Pair("instanceHashCode", String.valueOf(r15))})));
        return;
    L73:
        return;
    L71:
        return;
    L70:
        return;
    L17:
        if (r2 == false) goto L36;
        if (e() == false) goto L52;
        q60.a.b.a("onStartAudioCapture");
        com.bytedance.android.live.core.privacy.av.api.g r7 = c;
        if (r7 == null) goto L24;
        r7.f();
    L24:
        PrivacyConfig r8 = d;
        if (r8 == null) goto L52;
        if (r8.h() != true) goto L52;
        PrivacyConfig r9 = d;
        if (r9 == null) goto L52;
        List<String> r11 = r9.d();
        if (r11 == null) goto L52;
        if (r11.contains("av_operation") != true) goto L52;
        q60.a.b.c(new com.bytedance.android.live.core.privacy.av.api.i("av_operation", "onStartAudioCapture", 0, String.valueOf(Log.getStackTraceString(new Exception("onStartAudioCapture"))), "", "", "", Collections.emptyMap()));
    L52:
        a = r2;
        goto L53
    L36:
        if (e() == false) goto L52;
        q60.a.b.a("onStopAudioCapture");
        com.bytedance.android.live.core.privacy.av.api.g r12 = c;
        if (r12 == null) goto L41;
        r12.b();
    L41:
        PrivacyConfig r13 = d;
        if (r13 == null) goto L52;
        if (r13.h() != true) goto L52;
        PrivacyConfig r14 = d;
        if (r14 == null) goto L52;
        List<String> r16 = r14.d();
        if (r16 == null) goto L52;
        if (r16.contains("av_operation") != true) goto L52;
        q60.a.b.c(new com.bytedance.android.live.core.privacy.av.api.i("av_operation", "onStopAudioCapture", 0, String.valueOf(Log.getStackTraceString(new Exception("onStopAudioCapture"))), "", "", "", Collections.emptyMap()));
        goto L52
    }

    public static void g(int r16, int r17) {
        if (e() == true) goto L6;
        return;
    L6:
        if (r17 != 1) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        f.clear();
    L11:
        ConcurrentHashMap<Integer, Boolean> r4 = f;
        r4.put(Integer.valueOf(r16), Boolean.valueOf(r3));
        Iterator<T> r5 = r4.values().iterator();
    L12:
        boolean r6 = false;
    L14:
        if (r5.hasNext() == false) goto L21;
        Boolean r7 = (Boolean) r5.next();
        if (r6 == true) goto L19;
        if (r7.booleanValue() == false) goto L12;
    L19:
        r6 = true;
        goto L14
    L21:
        if (b != r6) goto L23;
    L59:
        q60.a.b.a("onVideoStatusChanged; isVideoActing=" + b + ", instanceHashCode=" + r16 + ", code=" + r17);
        PrivacyConfig r8 = d;
        if (r8 != null) goto L62;
        return;
    L62:
        if (r8.h() != true) goto L76;
        PrivacyConfig r9 = d;
        if (r9 == null) goto L77;
        List<String> r11 = r9.d();
        if (r11 != null) goto L68;
        return;
    L68:
        if (r11.contains("av_status_change") != true) goto L79;
        q60.a.b.c(new com.bytedance.android.live.core.privacy.av.api.i("av_status_change", "onVideoStatusChanged", 0, "", "", "", "", MapsKt.mapOf(new Pair[]{new Pair("code", String.valueOf(r17)), new Pair("isVideoActing", String.valueOf(a)), new Pair("instanceHashCode", String.valueOf(r16))})));
        return;
    L79:
        return;
    L77:
        return;
    L76:
        return;
    L23:
        if (r6 == false) goto L42;
        if (e() == false) goto L58;
        q60.a.b.a("onStartVideoCapture");
        com.bytedance.android.live.core.privacy.av.api.g r12 = c;
        if (r12 == null) goto L30;
        r12.a();
    L30:
        PrivacyConfig r13 = d;
        if (r13 == null) goto L58;
        if (r13.h() != true) goto L58;
        PrivacyConfig r14 = d;
        if (r14 == null) goto L58;
        List<String> r15 = r14.d();
        if (r15 == null) goto L58;
        if (r15.contains("av_operation") != true) goto L58;
        q60.a.b.c(new com.bytedance.android.live.core.privacy.av.api.i("av_operation", "onStartVideoCapture", 0, String.valueOf(Log.getStackTraceString(new Exception("onStartVideoCapture"))), "", "", "", Collections.emptyMap()));
    L58:
        b = r6;
        goto L59
    L42:
        if (e() == false) goto L58;
        q60.a.b.a("onStopVideoCapture");
        com.bytedance.android.live.core.privacy.av.api.g r18 = c;
        if (r18 == null) goto L47;
        r18.h();
    L47:
        PrivacyConfig r19 = d;
        if (r19 == null) goto L58;
        if (r19.h() != true) goto L58;
        PrivacyConfig r21 = d;
        if (r21 == null) goto L58;
        List<String> r22 = r21.d();
        if (r22 == null) goto L58;
        if (r22.contains("av_operation") != true) goto L58;
        q60.a.b.c(new com.bytedance.android.live.core.privacy.av.api.i("av_operation", "onStopVideoCapture", 0, String.valueOf(Log.getStackTraceString(new Exception("onStopVideoCapture"))), "", "", "", Collections.emptyMap()));
        goto L58
    L8:
        r3 = false;
        goto L9
    }
}

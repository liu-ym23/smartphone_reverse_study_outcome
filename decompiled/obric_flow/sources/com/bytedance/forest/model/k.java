package com.bytedance.forest.model;

import com.bytedance.forest.pollyfill.NetWorker;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetWorker f4378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function3 f4379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4380c;
    public int d;
    public int e;
    public boolean f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f4381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l f4382i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f4383j;

    public k() {
        LinkedHashMap r5 = new LinkedHashMap();
        this.f4381h = "";
        this.f4382i = null;
        this.f4383j = r5;
        List r10 = b.f4359a;
        this.f4378a = NetWorker.f4465a;
        this.d = 10485760;
        this.e = 4194304;
        this.f = false;
        this.g = true;
    }

    public final l a(String r14) {
        LinkedHashMap r5 = this.f4383j;
        if (r14 == null) goto L5;
        String r10 = r14;
    L6:
        l r11 = (l) r5.get(r10);
        if (r11 != null) goto L49;
        l r12 = null;
        if (com.lynx.tasm.behavior.utils.d.g(r14) == false) goto L18;
        l r13 = this.f4382i;
        if (r13 == null) goto L14;
        String r15 = r13.f4386b;
    L16:
        if (Intrinsics.areEqual(r14, r15) == false) goto L18;
        r11 = this.f4382i;
        goto L49
    L14:
        r15 = null;
    L18:
        Lazy r16 = l.f4384i;
        if (r14 != null) goto L22;
        r14 = "";
    L22:
        Lazy r17 = l.f4384i;
        l r18 = (l) ((Map) r17.getValue()).get(r14);
        if (r18 == null) goto L25;
        r11 = r18;
        goto L49
    L25:
        com.bytedance.geckox.g r19 = com.bytedance.geckox.h.a(r14);
        if (r19 == null) goto L48;
        com.bytedance.geckox.j r20 = r19.f4750a;
        String r21 = (String) r20.f4754a.get(0);
        if (r21 == null) goto L30;
        String r22 = r21;
    L31:
        String r23 = r20.f4755b.getAbsolutePath();
        if (r23 == null) goto L34;
        String r24 = r23;
    L35:
        long r25 = r20.getAppId();
        String r26 = r20.getAppVersion();
        if (r26 == null) goto L38;
        String r27 = r26;
    L39:
        String r28 = r20.getDeviceId();
        if (r28 == null) goto L42;
        String r110 = r28;
    L43:
        String r29 = r20.getRegion();
        if (r29 == null) goto L46;
        String r111 = r29;
    L47:
        r12 = new l(r22, r24, r25, r27, r110, r111, false);
        ((Map) r17.getValue()).put(r14, r12);
        goto L48
    L46:
        r111 = "";
        goto L47
    L42:
        r110 = "";
        goto L43
    L38:
        r27 = "";
        goto L39
    L34:
        r24 = "";
        goto L35
    L30:
        r22 = "";
    L48:
        r11 = r12;
    L49:
        if (r11 == null) goto L52;
        return r11;
    L52:
        return this.f4382i;
    L5:
        r10 = "";
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("{[host]=");
        r5.append(this.f4381h);
        r5.append(",[region]=");
        l r10 = this.f4382i;
        String r11 = null;
        if (r10 == null) goto L5;
        String r12 = r10.g;
    L6:
        r5.append(r12);
        r5.append(",[appId]=");
        l r13 = this.f4382i;
        if (r13 == null) goto L9;
        Long r14 = Long.valueOf(r13.d);
    L10:
        r5.append(r14);
        r5.append(",[appVersion]=");
        l r15 = this.f4382i;
        if (r15 == null) goto L13;
        String r16 = r15.e;
    L14:
        r5.append(r16);
        r5.append(",[did]=");
        l r17 = this.f4382i;
        if (r17 == null) goto L17;
        r11 = r17.f;
    L17:
        r5.append(r11);
        return r5.toString();
    L13:
        r16 = null;
        goto L14
    L9:
        r14 = null;
        goto L10
    L5:
        r12 = null;
        goto L6
    }
}

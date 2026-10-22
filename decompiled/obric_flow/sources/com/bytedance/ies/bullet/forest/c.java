package com.bytedance.ies.bullet.forest;

import cn.nubia.neopush.commons.Constant;
import com.bytedance.env.api.AccessKeyType;
import com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig;
import com.lynx.tasm.ui.image.f0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f5393a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.forest.model.k f5394b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f5395c = null;

    static {
        f5393a = new c();
        f5394b = new com.bytedance.forest.model.k();
        f5395c = new ConcurrentHashMap();
    }

    public static void a(String r21, GeckoConfig r22, wc.e r23, boolean r24) {
        String r5 = r22.getAccessKey();
        com.bytedance.forest.model.k r10 = f5394b;
        com.bytedance.forest.model.l r11 = (com.bytedance.forest.model.l) r10.f4383j.get(r5);
        LinkedHashMap r12 = r10.f4383j;
        if (r24 == true) goto L7;
        if (r11 == null) goto L7;
        StringBuilder r13 = com.lynx.tasm.utils.e.b("Gecko config of ", r5, " already exists! Config is ");
        r13.append(r12.get(r5));
        f0.f(60, "ForestConfigHelper", r13.toString());
    L13:
        if (f5395c.putIfAbsent(r21, r11) != null) goto L16;
        f0.f(60, "ForestConfigHelper", "Register minor gecko config=" + r12.get(r5) + " for " + r21);
        return;
    L16:
        StringBuilder r14 = com.lynx.tasm.utils.e.b("Gecko config of ", r21, " already exists! Config is ");
        r14.append(r12.get(r5));
        f0.f(60, "ForestConfigHelper", r14.toString());
        return;
    L7:
        String r15 = r23.f22828c;
        Intrinsics.checkNotNullParameter(r22, "<this>");
        Intrinsics.checkNotNullParameter(r15, Constant.APPID);
        String r16 = r23.d;
        Intrinsics.checkNotNullParameter(r16, "appVersion");
        String r17 = r23.e;
        Intrinsics.checkNotNullParameter(r17, "did");
        Intrinsics.checkNotNullParameter("CN", "region");
        String r18 = r22.getAccessKey();
        String r19 = r22.getOfflineDir();
        boolean r20 = r22.isRelativePath();
        Long r25 = StringsKt.toLongOrNull(r15);
        if (r25 == null) goto L10;
        long r110 = r25.longValue();
    L11:
        r11 = new com.bytedance.forest.model.l(r18, r19, r110, r16, r17, "CN", r20);
        r12.put(r5, r11);
        f0.f(60, "ForestConfigHelper", "Register minor gecko config=" + r12.get(r5) + " for " + r5);
        goto L13
    L10:
        r110 = 0;
        goto L11
    }

    public final synchronized void b(String r22, wc.e r23) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r22, "bid");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r23, "rlConfig");     // Catch: Throwable -> L9
        if (Intrinsics.areEqual(r22, "default_bid") == false) goto L50;
        com.bytedance.forest.model.k r5 = f5394b;     // Catch: Throwable -> L9
        AccessKeyType r10 = null;
        if (r5.f4382i == null) goto L11;
        f0.f(60, "ForestConfigHelper", "Default gecko config already exists! Config is " + r5.f4382i);     // Catch: Throwable -> L9
    L27:
        com.bytedance.env.api.e r11 = mn.h.b();     // Catch: Throwable -> L9
        if (r11 == null) goto L31;
        r10 = r11.a();     // Catch: Throwable -> L9
    L31:
        if (r10 != null) goto L33;
        int r12 = -1;
    L34:
        if (r12 == (-1)) goto L41;
        if (r12 != 1) goto L37;
        List r13 = CollectionsKt.listOf(new String[]{"36723dc3e85a23e701d1697d57de07ed", "0e99390a97a5105f755f73fe564a63ad", "5436709938b15832912cf5322009c03d", "46c563b112f40133a95aa5596d83790b", "e1927d8fdbbf6786914e8ca27307104b"});     // Catch: Throwable -> L9
    L42:
        Iterator r14 = r13.iterator();     // Catch: Throwable -> L9
    L44:
        if (r14.hasNext() == false) goto L58;
        String r15 = (String) r14.next();     // Catch: Throwable -> L9
        Long r16 = StringsKt.toLongOrNull(r23.f22828c);     // Catch: Throwable -> L9
        if (r16 == null) goto L48;
        long r17 = r16.longValue();     // Catch: Throwable -> L9
    L49:
        com.bytedance.forest.model.l r18 = new com.bytedance.forest.model.l(r15, "offlineX", r17, r23.d, r23.e, "CN", true);     // Catch: Throwable -> L9
        com.bytedance.forest.model.k r19 = f5394b;     // Catch: Throwable -> L9
        r19.f4383j.put(r15, r18);     // Catch: Throwable -> L9
        f0.f(60, "ForestConfigHelper", "Register annie gecko config=" + r19.f4383j.get(r15) + " when register default bid");     // Catch: Throwable -> L9
        goto L44
    L48:
        r17 = 0;
    L58:
        Iterator r20 = r23.g.entrySet().iterator();     // Catch: Throwable -> L9
    L59:
        if (r20.hasNext() == false) goto L70;
        GeckoConfig r21 = (GeckoConfig) ((Map.Entry) r20.next()).getValue();     // Catch: Throwable -> L9
        if (Intrinsics.areEqual(r22, "webcast") == false) goto L64;
    L67:
        boolean r24 = true;
    L68:
        a(r22, r21, r23, r24);     // Catch: Throwable -> L9
        goto L59
    L64:
        if (Intrinsics.areEqual(r22, "live") == true) goto L67;
        r24 = false;
        goto L68
    L70:
        monitor-exit(this);
        return;
    L37:
        if (r12 == 2) goto L39;
        r13 = CollectionsKt.listOf(new String[]{"5fb33cde3ebff01c8433ddc22aac0816", "c03e7f8feccb52c8e0f55f63b8025d0f", "6e5ea4687a1ae236f7677bed242a0bdd", "c772b372d999d01c25c1255e4d92ccad", "d8feacce0eae150c8140e5c435ccbbda"});     // Catch: Throwable -> L9
        goto L42
    L39:
        r13 = CollectionsKt.listOf(new String[]{"68f927652a5370ec9f4ae1dbaf56fd85", "07467e91f0656ae9451e9beef41d1d87", "92549089bbfda222da88c565422ff344", "feb359d0564d243c06dbcf0c0446d372", "afe58e0f6709cd80a6524f309678f67d"});     // Catch: Throwable -> L9
        goto L42
    L41:
        ConcurrentHashMap r25 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;     // Catch: Throwable -> L9
        r13 = CollectionsKt.listOf(new String[]{"5fb33cde3ebff01c8433ddc22aac0816", "c03e7f8feccb52c8e0f55f63b8025d0f", "6e5ea4687a1ae236f7677bed242a0bdd", "c772b372d999d01c25c1255e4d92ccad", "d8feacce0eae150c8140e5c435ccbbda"});     // Catch: Throwable -> L9
        goto L42
    L33:
        r12 = a.f5391a[r10.ordinal()];     // Catch: Throwable -> L9
        goto L34
    L11:
        r5.f = true;     // Catch: Throwable -> L9
        tc.c r26 = tc.c.f22119c;     // Catch: Throwable -> L9
        com.bytedance.ies.bullet.settings.b r27 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);     // Catch: Throwable -> L9
        if (r27 == null) goto L14;
        com.bytedance.ies.bullet.service.base.d r28 = (com.bytedance.ies.bullet.service.base.d) r27.f6163b.getValue();     // Catch: Throwable -> L9
    L15:
        int r110 = 5;
        if (r28 == null) goto L18;
        int r111 = r28.F;     // Catch: Throwable -> L9
    L19:
        r5.d = r111 * 1048576;     // Catch: Throwable -> L9
        if (r28 == null) goto L22;
        r110 = r28.G;     // Catch: Throwable -> L9
    L22:
        r5.e = r110 * 1048576;     // Catch: Throwable -> L9
        r5.f4379b = ForestConfigCenter$initForestConfig$1$1.f5366a;     // Catch: Throwable -> L9
        GeckoConfig r29 = r23.f;     // Catch: Throwable -> L9
        String r112 = r23.f22828c;     // Catch: Throwable -> L9
        String r113 = r23.d;     // Catch: Throwable -> L9
        String r114 = r23.e;     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r29, "<this>");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r112, Constant.APPID);     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r113, "appVersion");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r114, "did");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter("CN", "region");     // Catch: Throwable -> L9
        String r115 = r29.getAccessKey();     // Catch: Throwable -> L9
        String r116 = r29.getOfflineDir();     // Catch: Throwable -> L9
        boolean r117 = r29.isRelativePath();     // Catch: Throwable -> L9
        Long r30 = StringsKt.toLongOrNull(r112);     // Catch: Throwable -> L9
        if (r30 == null) goto L25;
        long r118 = r30.longValue();     // Catch: Throwable -> L9
    L26:
        com.bytedance.forest.model.l r31 = new com.bytedance.forest.model.l(r115, r116, r118, r113, r114, "CN", r117);     // Catch: Throwable -> L9
        r5.f4382i = r31;     // Catch: Throwable -> L9
        f5395c.put(r22, r31);     // Catch: Throwable -> L9
        f0.f(60, "ForestConfigHelper", "Register default gecko config=" + r5.f4382i);     // Catch: Throwable -> L9
        goto L27
    L25:
        r118 = 0;
        goto L26
    L18:
        r111 = 5;
        goto L19
    L14:
        r28 = null;
        goto L15
    L50:
        GeckoConfig r32 = r23.f;     // Catch: Throwable -> L9
        if (Intrinsics.areEqual(r22, "webcast") == false) goto L53;
    L56:
        boolean r33 = true;
    L57:
        a(r22, r32, r23, r33);     // Catch: Throwable -> L9
        goto L58
    L53:
        if (Intrinsics.areEqual(r22, "live") == true) goto L56;
        r33 = false;
    L9:
        th = move-exception;
        throw th;
    }
}

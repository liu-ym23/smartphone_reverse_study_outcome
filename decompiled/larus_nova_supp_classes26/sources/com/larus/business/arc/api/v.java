package com.larus.business.arc.api;

import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import nuc.v2;
import ouc.d0;
import ouc.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v {
    public static final Regex a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ArcPlatform.values().length];
            r0[ArcPlatform.ANDROID.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[ArcPlatform.HARMONY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            r0[ArcPlatform.IOS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L28:
            r0[ArcPlatform.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L9:
            a = r0;
            int[] r1 = new int[ArcRegion.values().length];
            r1[ArcRegion.MAINLAND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L30:
            r1[ArcRegion.OVERSEA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L22:
            r1[ArcRegion.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L13:
            b = r1;
        }
    }

    static {
        a = new Regex("[A-Za-z0-9_-]{1,80}");
    }

    public static final c a() {
        wt7.c r0 = wt7.a.a;
        juc.d<c> r1 = c.Companion.serializer();
        r0.getClass();
        c r2 = (c) wt7.c.a(null, r1);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new c(0);
    }

    public static final String b() {
        byte[] r0 = Random.Default.nextBytes(16);
        StringBuilder r1 = new StringBuilder(32);
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L6;
        int r4 = r0[r3] & 255;
        r1.append("0123456789abcdef".charAt(r4 >>> 4));
        r1.append("0123456789abcdef".charAt(r4 & 15));
        r3 = r3 + 1;
        goto L3
    L6:
        return r1.toString();
    }

    public static final String f(ArcPlatform r1) {
        int r2 = a.a[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "android";
    L5:
        if (r2 != 2) goto L7;
        return "harmony";
    L7:
        if (r2 != 3) goto L9;
        return "ios";
    L9:
        if (r2 != 4) goto L12;
        return "unknown";
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public static final String d(t r1, c r2) {
        wt7.c r0 = wt7.a.a;
        d0 r3 = e(r1, r2);
        juc.d r4 = d0.Companion.serializer();
        r0.getClass();
        String r5 = wt7.c.b(r3, r4);
        if (r5 != null) goto L6;
        return "{\"ok\":false,\"version\":1,\"command\":\"unknown\",\"code\":\"ARC_RUNTIME_SERIALIZATION_FAILED\",\"error\":\"Arc runtime could not serialize the result.\"}";
    L6:
        return r5;
    }

    public static final d0 e(t r7, c r8) {
        e0 r0 = new e0();
        ouc.j.a(r0, "ok", Boolean.valueOf(r7.a));
        ouc.j.b(r0, "version", 1);
        ouc.j.c(r0, "command", r7.b);
        ouc.j.c(r0, "platform", f(r8.a));
        ouc.j.c(r0, "packageName", r8.b);
        ouc.j.c(r0, "processName", r8.c);
        e0 r2 = new e0();
        ouc.j.c(r2, "platform", f(r8.a));
        ouc.j.c(r2, "packageName", r8.b);
        ouc.j.c(r2, "processName", r8.c);
        ouc.j.c(r2, "uid", r8.d);
        ouc.j.c(r2, "did", r8.e);
        ouc.j.c(r2, "channel", r8.f);
        ArcRegion r3 = r8.g;
        int r4 = a.b[r3.ordinal()];
        if (r4 != 1) goto L5;
        String r1 = "mainland";
    L13:
        ouc.j.c(r2, "region", r1);
        ouc.j.c(r2, "updateVersionCode", r8.h);
        Unit r9 = Unit.INSTANCE;
        r0.b("context", r2.a());
        s r10 = r7.g;
        if (Intrinsics.areEqual(r10, s.c.a) == false) goto L28;
        String r11 = r7.c;
        if (r11 == null) goto L18;
        ouc.j.c(r0, "code", r11);
    L18:
        String r12 = r7.d;
        if (r12 == null) goto L21;
        ouc.j.c(r0, "error", r12);
    L21:
        String r13 = r7.e;
        if (r13 == null) goto L24;
        ouc.j.c(r0, "group", r13);
    L24:
        String r14 = r7.f;
        if (r14 == null) goto L42;
        ouc.j.c(r0, "tool", r14);
    L42:
        return r0.a();
    L28:
        if ((r10 instanceof s.d) == false) goto L31;
        ((s.d) r10).getClass();
        r0.b("usage", null);
        goto L42
    L31:
        if ((r10 instanceof s.e) == false) goto L33;
        ((s.e) r10).getClass();
        ouc.j.b(r0, "group_count", 0);
        ouc.j.b(r0, "tool_count", 0);
        new ArrayList();
        throw null;
    L33:
        if ((r10 instanceof s.b) == false) goto L44;
        String r5 = r7.e;
        if (r5 == null) goto L37;
        ouc.j.c(r0, "group", r5);
    L37:
        String r15 = r7.f;
        if (r15 == null) goto L40;
        ouc.j.c(r0, "tool", r15);
    L40:
        ((s.b) r10).getClass();
        r0.b("descriptor", null);
        goto L42
    L44:
        if ((r10 instanceof s.a) == false) goto L54;
        ((s.a) r10).getClass();
        r0.b(MusicAppletPage.KEY_PATH, null);
        String r16 = r7.e;
        if (r16 == null) goto L48;
        ouc.j.c(r0, "group", r16);
    L48:
        String r17 = r7.f;
        if (r17 == null) goto L52;
        ouc.j.c(r0, "tool", r17);
    L52:
        throw new NoWhenBranchMatchedException();
    L54:
        throw new NoWhenBranchMatchedException();
    L5:
        if (r4 != 2) goto L7;
        r1 = "oversea";
        goto L13
    L7:
        if (r4 != 3) goto L10;
        r1 = "unknown";
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static final t c(String r3, String r4, String r5) {
        wt7.c r1 = wt7.a.a;
        kuc.a.f(StringCompanionObject.INSTANCE);
        nuc.f r2 = kuc.a.b(v2.a);
        r1.getClass();
        List r6 = (List) wt7.c.a(r3, r2);
        if (r6 == null) goto L18;
        String r7 = (String) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L18;
        String r8 = StringsKt.trim(r7).toString();
        if (r8 == null) goto L18;
        String r9 = r8.toLowerCase(Locale.ROOT);
        if (r9 == null) goto L18;
        if (r9.length() != 0) goto L13;
        boolean r10 = true;
    L14:
        if (r10 == false) goto L16;
        r9 = null;
    L16:
        if (r9 == null) goto L18;
    L20:
        return new t(r9, r4, r5);
    L13:
        r10 = false;
    L18:
        r9 = "unknown";
        goto L20
    }
}

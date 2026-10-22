package com.bytedance.android.btm.impl.util;

import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BtmFormatUtils {
    public static final Lazy a = null;
    public static final Regex b = null;

    static {
        a = LazyKt.lazy(BtmFormatUtils$pageBtmPattern$2.INSTANCE);
        b = new Regex("_[ikl][${index}0-9]*");
    }

    public static String a(final String r11) {
        ALogger r0 = ALogger.d;
        Function0<String> r1 = new BtmFormatUtils$format$1(r11);
        r0.getClass();
        com.bytedance.android.btm.api.inner.b r10 = (com.bytedance.android.btm.api.inner.b) ALogger.c.getValue(r0, ALogger.a[0]);
        if (r10 == null) goto L5;
        r10.a("BTMSDK_BTM_utils_BtmFormatUtil_format", r1);
    L5:
        List r12 = StringsKt.split$default(r11, new String[]{"."}, false, 0, 6, null);
        if (r12.size() != 5) goto L9;
        return r11;
    L9:
        if (r12.size() >= 2) goto L11;
    L27:
        StringBuilder r13 = new StringBuilder();
        r13.append(r11);
        StringBuilder r14 = new StringBuilder(".e");
        AtomicLong r15 = e.a;
        r14.append(UUID.randomUUID().toString());
        r13.append(r14.toString());
        return r13.toString();
    L11:
        if (r12.size() != 2) goto L16;
        if (StringsKt.startsWith$default((String) ListProtector.get(r12, 0), "a", false, 2, null) == false) goto L16;
        r11 = (r11 + ".c0") + ".d0";
    L16:
        if (r12.size() != 3) goto L21;
        if (StringsKt.startsWith$default((String) ListProtector.get(r12, 0), "a", false, 2, null) == false) goto L21;
        r11 = r11 + ".d0";
    L21:
        if (r12.size() != 4) goto L25;
        if (StringsKt.startsWith$default((String) ListProtector.get(r12, 0), "a", false, 2, null) == true) goto L27;
    L25:
        if (StringsKt.startsWith$default((String) ListProtector.get(r12, 0), "c", false, 2, null) == false) goto L27;
        r11 = BtmHostDependManager.F.d() + ".b0." + r11;
        goto L27
    }

    public static String b(String r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L10:
        if (r11 == false) goto L12;
        return "";
    L12:
        List r12 = StringsKt.split$default(r10, new String[]{"."}, false, 0, 6, null);
        if (r12.size() >= 2) goto L16;
        return "";
    L16:
        return ((String) ListProtector.get(r12, 0)) + "." + ((String) ListProtector.get(r12, 1));
    L5:
        if (r10.length() == 0) goto L8;
        r11 = false;
        goto L10
    }

    public static String c(String r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L10:
        if (r11 == false) goto L12;
        return "";
    L12:
        List r12 = StringsKt.split$default(r10, new String[]{"."}, false, 0, 6, null);
        if (r12.size() >= 2) goto L16;
        return "";
    L16:
        return ((String) ListProtector.get(r12, 0)) + "." + ((String) ListProtector.get(r12, 1)) + ".c0.d0";
    L5:
        if (r10.length() == 0) goto L8;
        r11 = false;
        goto L10
    }

    public static String d(String r10) {
        if (r10 != null) goto L5;
    L18:
        return null;
    L5:
        if (StringsKt.startsWith$default(r10, "aUnknown.", false, 2, null) != true) goto L18;
        List r11 = StringsKt.split$default(r10, new String[]{"."}, false, 0, 6, null);
        if (r11.size() > 1) goto L9;
        return IHostStyleUIDepend.TOAST_TYPE_ERROR;
    L9:
        if (((String) ListProtector.get(r11, 1)).length() <= 1) goto L19;
        String r12 = (String) ListProtector.get(r11, 1);
        if (r12 == null) goto L15;
        return r12.substring(1);
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        return IHostStyleUIDepend.TOAST_TYPE_ERROR;
    }

    public static String e(String r10) {
        if (r10 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return null;
    L11:
        String r11 = g(r10);
        if (Intrinsics.areEqual(r11, g("a0.b0.c0.d0")) == false) goto L14;
        return null;
    L14:
        return r11;
    L4:
        if (r10.length() == 0) goto L7;
        r0 = false;
        goto L9
    }

    public static String g(String r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        List r1 = StringsKt.split$default(r10, new String[]{"."}, false, 0, 6, null);
        if (r1.size() > 4) goto L8;
        return r10;
    L8:
        return ((String) ListProtector.get(r1, 0)) + "." + ((String) ListProtector.get(r1, 1)) + "." + ((String) ListProtector.get(r1, 2)) + "." + ((String) ListProtector.get(r1, 3));
    }

    public static String h(String r10) {
        String r11 = g(r10);
        if (r11 == null) goto L8;
        List r0 = StringsKt.split$default(r11, new String[]{"_i"}, false, 0, 6, null);
        if ((!r0.isEmpty()) == true) goto L7;
        return r11;
    L7:
        return (String) ListProtector.get(r0, 0);
    L8:
        return null;
    }

    public static boolean f(String r13, String r14) {
        if (r13 != null) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == true) goto L26;
        if (r14 != null) goto L12;
    L15:
        boolean r11 = true;
    L16:
        if (r11 == true) goto L26;
        List r15 = StringsKt.split$default(r13, new String[]{"."}, false, 0, 6, null);
        List r12 = StringsKt.split$default(r14, new String[]{"."}, false, 0, 6, null);
        r15.size();
        if (r12.size() != 1) goto L25;
        if (StringsKt.startsWith$default(r14, "b", false, 2, null) == false) goto L25;
        return Intrinsics.areEqual((String) ListProtector.get(r15, 1), (String) ListProtector.get(r12, 0));
    L25:
        return Intrinsics.areEqual((String) ListProtector.get(r15, 1), (String) ListProtector.get(r12, 1));
    L12:
        if (r14.length() == 0) goto L15;
        r11 = false;
    L26:
        return false;
    L5:
        if (r13.length() == 0) goto L8;
        r10 = false;
        goto L9
    }
}

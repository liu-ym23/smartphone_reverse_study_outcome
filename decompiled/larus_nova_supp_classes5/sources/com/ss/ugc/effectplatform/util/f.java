package com.ss.ugc.effectplatform.util;

import bytekn.foundation.io.file.FileManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String j(String r1) {
        return r1 + FileManager.a + "effect_version";
    }

    public static String d(String r1, String r2) {
        return r1 + FileManager.a + "category_version" + r2;
    }

    public static String k(String r2, String r3) {
        return "effectchannel" + r3 + r2;
    }

    public static String b(String r2, String r3, List r4) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r3);
        int r5 = bytekn.foundation.utils.a.a;
        if (r4 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        ArrayList r7 = null;
    L24:
        r0.append(r7);
        return r0.toString() + FileManager.a + "effectchannel" + r2;
    L11:
        r7 = new ArrayList();
        if (r4 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        Iterator r8 = r4.iterator();
    L16:
        if (r8.hasNext() == false) goto L24;
        Object r1 = r8.next();
        if (r1 == null) goto L22;
        String r9 = r1.toString();
        if (r9 == null) goto L22;
    L23:
        r7.add(r9);
    L22:
        r9 = "";
        goto L23
    L5:
        if (r4.isEmpty() == true) goto L8;
        r6 = false;
        goto L9
    }

    public static String e(String r2, String r3, Integer r4, Integer r5) {
        String r6 = "effectchannelinfosticker" + r3 + r2;
        if (r4 == null) goto L5;
        r6 = r6 + r4.intValue();
    L5:
        if (r5 != null) goto L7;
        return r6;
    L7:
        return r6 + r5.intValue();
    }

    public static String a(String r1, String r2, int r3, int r4, int r5) {
        return r1 + FileManager.a + "effectchannel" + r2 + r3 + "_" + r4 + "_" + r5;
    }

    public static String c(String r1, String r2, int r3, int r4, int r5) {
        return r1 + FileManager.a + "effectchannel" + r2 + r3 + "_" + r4 + "_" + r5 + "paging";
    }

    public static String f(String r1, String r2, boolean r3, String r4, int r5, int r6) {
        StringBuilder r0 = new StringBuilder();
        if (r3 == false) goto L5;
        r2 = r2 + r4 + r5 + r6;
    L5:
        r0.append(r2);
        r0.append("checked");
        return r0.toString() + FileManager.a + "effectchannel" + r1;
    }

    public static String g(String r0, String r1, boolean r2, String r3, int r4, int r5, int r6) {
        if (r2 == false) goto L4;
        String r7 = r1 + r3 + r4 + r5 + r6;
    L6:
        return r7 + FileManager.a + "effectchannel" + r0;
    L4:
        r7 = r1 + r6;
        goto L6
    }

    public static String h(String r1, String r2, String r3, int r4, int r5, int r6, String r7) {
        return (r2 + r3 + r4 + r5 + r6 + r7 + "paging_checked") + FileManager.a + "effectchannel" + r1;
    }

    public static String i(String r1, String r2, String r3, int r4, int r5, int r6, String r7) {
        return (r2 + r3 + r4 + r5 + r6 + r7 + "paging") + FileManager.a + "effectchannel" + r1;
    }
}

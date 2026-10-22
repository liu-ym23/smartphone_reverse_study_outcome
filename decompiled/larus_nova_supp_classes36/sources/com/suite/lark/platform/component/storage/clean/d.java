package com.suite.lark.platform.component.storage.clean;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public final Context getContext() {
        return null;
    }

    public static Pair a(File r12, List r13) {
        ArrayList r2 = null;
        boolean r3 = false;
        if (r12.isDirectory() == false) goto L8;
        StringBuilder r0 = new StringBuilder();
        r0.append(r12.getAbsolutePath());
        String r4 = r12.getAbsolutePath();
        String r5 = File.separator;
        if (StringsKt.endsWith$default(r4, r5, false, 2, null) == false) goto L7;
        r5 = "";
    L7:
        r0.append(r5);
        String r1 = r0.toString();
    L9:
        Intrinsics.checkNotNull(r1);
        boolean r6 = true;
        if (r13 != null) goto L12;
    L28:
        boolean r7 = false;
    L29:
        long r8 = 0;
        if (r7 == false) goto L32;
        Log.i("StorageCleaner", "file is in whitelist, path:" + r12.getAbsolutePath());
    L77:
        return TuplesKt.to(Boolean.valueOf(r6), Long.valueOf(r8));
    L32:
        if (r12.isDirectory() == false) goto L65;
        if (r13 == null) goto L41;
        ArrayList r9 = new ArrayList();
        Iterator r14 = r13.iterator();
    L36:
        if (r14.hasNext() == false) goto L40;
        Object r10 = r14.next();
        if (StringsKt.startsWith$default((String) r10, r1, false, 2, null) == false) goto L36;
        r9.add(r10);
        goto L36
    L40:
        r2 = r9;
    L41:
        File[] r15 = r12.listFiles();
        if (r15 == null) goto L51;
        int r11 = r15.length;
        int r16 = 0;
        boolean r17 = true;
    L44:
        if (r16 >= r11) goto L52;
        File r18 = r15[r16];
        Intrinsics.checkNotNull(r18);
        Pair r19 = a(r18, r2);
        boolean r20 = ((Boolean) r19.component1()).booleanValue();
        long r110 = ((Number) r19.component2()).longValue();
        if (r20 == false) goto L49;
        if (r17 == false) goto L49;
        r17 = true;
    L50:
        r8 = r8 + r110;
        r16 = r16 + 1;
    L49:
        r17 = false;
    L52:
        if (r2 != null) goto L54;
    L57:
        boolean r111 = true;
    L58:
        if (r111 == true) goto L60;
        r6 = r17;
        goto L77
    L60:
        if (r12.delete() == false) goto L63;
        if (r17 == false) goto L63;
        r3 = true;
    L63:
        r6 = r3;
        goto L77
    L54:
        if (r2.isEmpty() == true) goto L57;
        r111 = false;
        goto L58
    L51:
        r17 = true;
        goto L52
    L65:
        long r21 = r12.length();
        if (r12.delete() == true) goto L69;
        r21 = 0;
    L69:
        long r22 = r21 + 0;
        if (r21 == 0) goto L72;
    L73:
        r3 = true;
    L74:
        r6 = r3;
        r8 = r22;
        goto L77
    L72:
        if (r12.exists() == true) goto L74;
    L12:
        if (r13.isEmpty() == true) goto L28;
        Iterator r23 = r13.iterator();
    L16:
        if (r23.hasNext() == false) goto L28;
        String r24 = p.a((String) r23.next());
        if (Intrinsics.areEqual(r1, r24) == false) goto L20;
    L25:
        boolean r25 = true;
    L26:
        if (r25 == false) goto L16;
        r7 = true;
        goto L29
    L20:
        if (new PolarisFileWrapper(r24).isDirectory() == true) goto L22;
    L24:
        r25 = false;
        goto L26
    L22:
        if (StringsKt.startsWith$default(r1, r24, false, 2, null) == false) goto L24;
    L8:
        r1 = r12.getAbsolutePath();
        goto L9
    }
}

package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r {
    public static long a;
    public static List<nj0.g> b;

    static {
        b = CollectionsKt.emptyList();
    }

    public static void b(List r2) {
        Intrinsics.checkNotNullParameter(r2, "subtitleItemList");
        a = System.currentTimeMillis();
        b = r2;
    }

    public static boolean a(boolean r8, List r9) {
        Intrinsics.checkNotNullParameter(r9, "subtitleItemList");
        if (vm2.c.b().getSameSubtitleContentUpdateFrequencyOpt() == true) goto L5;
        return false;
    L5:
        if (r8 == false) goto L7;
    L9:
        int r10 = g0.a;
        List<nj0.g> r11 = b;
        Intrinsics.checkNotNullParameter(r11, "oldSubtitleList");
        Intrinsics.checkNotNullParameter(r9, "newSubtitleList");
        if (r11.size() != ((ArrayList) r9).size()) goto L23;
        int r0 = r11.size();
        int r2 = 0;
    L13:
        if (r2 >= r0) goto L25;
        nj0.g r4 = (nj0.g) ListProtector.get(r11, r2);
        nj0.g r5 = (nj0.g) ListProtector.get(r9, r2);
        if (Intrinsics.areEqual(r4.b, r5.b) == true) goto L17;
    L21:
        boolean r6 = false;
    L22:
        if (r6 == false) goto L23;
        r2 = r2 + 1;
        goto L13
    L17:
        if (Intrinsics.areEqual(r4.c, r5.c) == false) goto L21;
        if (r4.e != r5.e) goto L21;
        r6 = true;
        goto L22
    L25:
        boolean r12 = true;
    L26:
        if (r12 == false) goto L28;
        return true;
    L28:
        Iterator r13 = r9.iterator();
    L30:
        if (r13.hasNext() == false) goto L34;
        Object r14 = r13.next();
        if (((nj0.g) r14).e == false) goto L30;
    L36:
        if (((nj0.g) r14) == null) goto L38;
    L40:
        return false;
    L38:
        if ((System.currentTimeMillis() - a) >= vm2.c.b().getSameSubtitleContentUpdateFrequencyControlTime()) goto L40;
        return true;
    L34:
        r14 = null;
    L23:
        r12 = false;
        goto L26
    L7:
        if (vm2.c.b().getSubtitlePatchLynxEnable() == true) goto L9;
        return false;
    }
}

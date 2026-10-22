package com.ss.ugc.effectplatform.repository;

import b0.a;
import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.util.EffectUtilKt;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import z.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d {
    public static final b<String, Effect> a = null;
    public static final b<String, z.c<hlc.d>> b = null;
    public static final d c = null;

    public d() {
    }

    static {
        c = new d();
        a = new b(true);
        b = new b(true);
    }

    public static boolean c(String r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        return a.containsKey(r1);
    }

    public static void a(Effect r3, ExceptionResult r4) {
        if (r3 == null) goto L14;
        String r0 = com.ss.ugc.effectplatform.model.b.a(r3);
        if (r0 == null) goto L15;
        z.c r1 = (z.c) b.get(r0);
        if (r1 == null) goto L11;
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        ((hlc.d) r2.next()).onFail(r3, r4);
    L11:
        b.remove(r0);
        a.remove(r0);
        return;
    L15:
        return;
    }

    public static boolean b(Effect r5, boolean r6, Boolean r7) {
        if (r5 != null) goto L5;
    L20:
        return false;
    L5:
        if (StringsKt.isBlank(r5.getId()) == true) goto L20;
        if ((!Intrinsics.areEqual(r7, Boolean.TRUE)) == true) goto L10;
    L12:
        if (r6 == false) goto L15;
        String r8 = FileManager.a;
        return FileManager.d(r5.getUnzipPath() + FileManager.a + "effect_platform_children.tag");
    L15:
        String r9 = FileManager.a;
        boolean r10 = FileManager.d(r5.getUnzipPath());
        if (r10 == false) goto L19;
        int r11 = a.a;
        long r12 = System.currentTimeMillis();
        com.ss.ugc.effectplatform.algorithm.b.c.a();
        String r0 = r5.getUnzipPath();
        int r1 = com.ss.ugc.effectplatform.h.a;
        boolean r2 = EffectUtilKt.nativeCheckEffectChildrenFile(r0);
        Logger.INSTANCE.d("checkEffect", "checkEffectChildrenFile effect: " + r5.getEffect_id() + ", name: " + r5.getName() + ", result: " + r2 + ", time cost: " + (System.currentTimeMillis() - r12));
        return r2;
    L19:
        return r10;
    L10:
        if (c(com.ss.ugc.effectplatform.model.b.a(r5)) == false) goto L12;
        return false;
    }
}

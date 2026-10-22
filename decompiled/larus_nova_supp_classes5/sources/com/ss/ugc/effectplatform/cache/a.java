package com.ss.ugc.effectplatform.cache;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.io.file.f;
import bytekn.foundation.logger.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.algorithm.d;
import com.ss.ugc.effectplatform.cache.disklrucache.e;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import com.ss.ugc.effectplatform.util.k;
import com.ss.ugc.effectplatform.util.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a extends c {
    public static final a0.b<List<String>> n = null;
    public static final C0010a o = null;
    public final EffectConfig k;
    public final String l;
    public final d m;

    /* JADX INFO: renamed from: com.ss.ugc.effectplatform.cache.a$a, reason: collision with other inner class name */
    public static final class C0010a implements e {
        public C0010a() {
        }

        @Override // com.ss.ugc.effectplatform.cache.disklrucache.e
        public final boolean isAllowed(String r7) {
            if (r.b(r7) == false) goto L5;
            return false;
        L5:
            List r0 = (List) a.n.a;
            String r2 = null;
            Object r3 = null;
            if (r0 == null) goto L14;
            Iterator r1 = r0.iterator();
        L9:
            if (r1.hasNext() == false) goto L13;
            Object r4 = r1.next();
            if (new Regex((String) r4).containsMatchIn(r7) == false) goto L9;
            r3 = r4;
        L13:
            r2 = (String) r3;
        L14:
            if (r2 == null) goto L17;
            Logger.INSTANCE.d("AlgorithmModelCache", "cleaneffect: allowlist：customAllowList, key: " + r7 + " , regex: " + r2);
            return true;
        L17:
            return false;
        }
    }

    public static final class b {
    }

    static {
        n = new a0.b(null);
        o = new C0010a();
    }

    @Override // com.ss.ugc.effectplatform.cache.c
    public final void f() {
        super.f();
        c0.e r0 = com.ss.ugc.effectplatform.algorithm.c.a;
        r0.a();
        com.ss.ugc.effectplatform.algorithm.c.b.clear();     // Catch: Throwable -> L6
        com.ss.ugc.effectplatform.algorithm.c.c.b(false);     // Catch: Throwable -> L6
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r0.b();
        return;
    L6:
        th = move-exception;
        r0.b();
        throw th;
    }

    @Override // com.ss.ugc.effectplatform.cache.c, com.ss.ugc.effectplatform.cache.j
    public final void d(String r9) {
        com.ss.ugc.effectplatform.cache.disklrucache.a r0 = e();
        if (r0 == null) goto L25;
        Set<String> r1 = r0.f();
        if (r1 == null) goto L26;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        Object r3 = r2.next();
        String r4 = k.d((String) r3);
        com.ss.ugc.effectplatform.cache.disklrucache.a.w.getClass();
        if (Intrinsics.areEqual(r4, com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a.c(r9)) == false) goto L8;
    L13:
        String r5 = (String) r3;
        if (r5 == null) goto L27;
        com.ss.ugc.effectplatform.cache.disklrucache.a.w.getClass();
        if (Intrinsics.areEqual(r5, com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a.c(r5)) == false) goto L20;
        com.ss.ugc.effectplatform.cache.disklrucache.a r10 = e();
        if (r10 == null) goto L28;
        r10.k(r5);
        return;
    L28:
        return;
    L20:
        Logger.e$default(Logger.INSTANCE, "AlgorithmModelCache", "markUsed error! Invalid key: ".concat(r5), null, 4, null);
        return;
    L27:
        return;
    L12:
        r3 = null;
        goto L13
    L26:
        return;
    }

    public final com.ss.ugc.effectplatform.model.d i(String r14) {
        if (this.k.V == false) goto L5;
        r14 = bytekn.foundation.utils.c.a(r14);
    L5:
        c0.e r0 = com.ss.ugc.effectplatform.algorithm.c.a;
        r0.a();
        com.ss.ugc.effectplatform.algorithm.h r1 = (com.ss.ugc.effectplatform.algorithm.h) com.ss.ugc.effectplatform.algorithm.c.b.get(r14);     // Catch: Throwable -> L129
        r0.b();
        if (r1 == null) goto L14;
        ModelInfo r2 = r1.b;
        if (r2 == null) goto L14;
        String r3 = ilc.b.a(r2);
        if (r3 == null) goto L14;
    L15:
        EffectConfig r4 = this.k;
        boolean r5 = true;
        com.ss.ugc.effectplatform.preload.c r6 = null;
        if (r4.b0 == false) goto L25;
        l.a r7 = l.c;
        Object r8 = r4.G;
        r7.getClass();
        if (l.a.a(r8) == null) goto L20;
        k r9 = new k();
        r9.b = 1;
        r9.l = r14;
    L20:
        String r10 = FileManager.a;
        if (FileManager.d(null) == false) goto L25;
        int r15 = com.ss.ugc.effectplatform.model.d.g;
        Intrinsics.throwNpe();
        throw null;
    L25:
        com.ss.ugc.effectplatform.cache.disklrucache.a.w.getClass();
        String r11 = com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a.c(r14);
        com.ss.ugc.effectplatform.cache.disklrucache.a r12 = e();
        if (r12 == null) goto L37;
        Set<String> r13 = r12.f();
        if (r13 == null) goto L37;
        Iterator<T> r16 = r13.iterator();
    L31:
        if (r16.hasNext() == false) goto L35;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(k.d((String) r17), r11) == false) goto L31;
    L36:
        com.ss.ugc.effectplatform.preload.c r18 = (String) r17;
    L38:
        String r19 = "";
        if (r18 != null) goto L139;
    L73:
        com.ss.ugc.effectplatform.model.d r20 = null;
    L74:
        if (r20 == null) goto L76;
        String r21 = r20.a();
    L78:
        if (Intrinsics.areEqual(r3, r21) == false) goto L80;
        return r20;
    L80:
        EffectConfig r22 = this.k;
        if (r22.T == false) goto L120;
        com.ss.ugc.effectplatform.preload.b.a r23 = com.ss.ugc.effectplatform.preload.b.d;
        Object r24 = r22.G;
        r23.getClass();
        com.ss.ugc.effectplatform.preload.b r25 = com.ss.ugc.effectplatform.preload.b.a.a(r24);
        if (r25 != null) goto L134;
        r19 = null;
    L98:
        if (r19 == null) goto L120;
        if (r19.length() > 0) goto L103;
        r5 = false;
    L103:
        if (r5 == false) goto L120;
        StringBuilder r26 = new StringBuilder();
        r26.append(this.l);
        String r27 = FileManager.a;
        r26.append(FileManager.a);
        r26.append(r19);
        String r28 = r26.toString();
        if (FileManager.d(r28) == false) goto L117;
        Logger.INSTANCE.w("JKL", "[预加载][读取][模型][已下载][" + r14 + "][" + r19 + ']');
        com.ss.ugc.effectplatform.preload.c r110 = new com.ss.ugc.effectplatform.model.d(r28);
        r110.e = false;
        com.ss.ugc.effectplatform.preload.b.a r29 = com.ss.ugc.effectplatform.preload.b.d;
        Object r30 = this.k.G;
        r29.getClass();
        com.ss.ugc.effectplatform.preload.b r31 = com.ss.ugc.effectplatform.preload.b.a.a(r30);
        if (r31 == null) goto L109;
        r6 = r31.e(r19);
    L109:
        if (r6 == null) goto L114;
        klc.a r32 = (klc.a) this.k.v.a;
        if (r32 == null) goto L114;
        String r33 = r6.f;
        String r34 = r6.b;
        com.ss.ugc.effectplatform.util.i r35 = com.ss.ugc.effectplatform.util.i.a;
        klc.b.l(r32, r33, r34, com.ss.ugc.effectplatform.util.i.f(r28) / ((long) 1024));
    L114:
        if (Intrinsics.areEqual(r3, r110.a()) == false) goto L116;
        return r110;
    L116:
        r6 = r110;
        goto L120
    L117:
        Logger.INSTANCE.w("JKL", "[预加载][读取][模型][文件被意外删除][" + r14 + "][" + r19 + ']');
        com.ss.ugc.effectplatform.preload.b.a r111 = com.ss.ugc.effectplatform.preload.b.d;
        Object r36 = this.k.G;
        r111.getClass();
        com.ss.ugc.effectplatform.preload.b r112 = com.ss.ugc.effectplatform.preload.b.a.a(r36);
        if (r112 == null) goto L120;
        r112.c(r19);
        goto L120
    L134:
        SQLiteDatabase r37 = r25.a;     // Catch: Exception -> L95
        if (r37 == null) goto L98;
        Cursor r38 = r37.rawQuery("select * from preload_table where res_name=?", new String[]{r14});     // Catch: Exception -> L95
        if (r38 == null) goto L98;
        if (r38.moveToFirst() == true) goto L91;
    L93:
        r38.close();     // Catch: Exception -> L95
    L91:
        if (r38.isAfterLast() == true) goto L93;
        r19 = r38.getString(0);     // Catch: Exception -> L95
        r38.moveToNext();     // Catch: Exception -> L95
    L95:
        e = move-exception;
        e.printStackTrace();
    L120:
        if (r6 == null) goto L125;
        if (r20 == null) goto L125;
        String r113 = FileManager.a;
        if (new PolarisFileWrapper(r6.f).lastModified() > new PolarisFileWrapper(r20.f).lastModified()) goto L128;
        return r20;
    L128:
        return r6;
    L125:
        if (r20 == null) goto L128;
        return r20;
    L76:
        r21 = null;
        goto L78
    L139:
        com.ss.ugc.effectplatform.cache.disklrucache.a r39 = e();     // Catch: Throwable -> L57 Exception -> L59
        if (r39 == null) goto L44;
        com.ss.ugc.effectplatform.cache.disklrucache.a.d r40 = r39.e(r18);     // Catch: Throwable -> L57 Exception -> L59
    L45:
        if (r40 == null) goto L73;
        f r41 = r40.a[0];     // Catch: Exception -> L53 Throwable -> L68
        if (r41 == null) goto L55;
        String r42 = r41.b;     // Catch: Exception -> L53 Throwable -> L68
        if (r42 == null) goto L55;
        r20 = new com.ss.ugc.effectplatform.model.d(r42);     // Catch: Exception -> L53 Throwable -> L68
    L56:
        r40.close();
    L55:
        r20 = null;
    L53:
        Exception e = e;
    L61:
        Logger r43 = Logger.INSTANCE;     // Catch: Throwable -> L68
        String r44 = e.getMessage();     // Catch: Throwable -> L68
        if (r44 == null) goto L64;
        String r45 = r44;
    L65:
        Logger.e$default(r43, "DiskLruCache", r45, null, 4, null);     // Catch: Throwable -> L68
        if (r40 == null) goto L73;
        r40.close();
        goto L73
    L64:
        r45 = "";
        goto L65
    L44:
        r40 = null;
    L59:
        e = move-exception;
        e = e;
        r40 = null;
    L57:
        th = th;
    L70:
        if (r6 == null) goto L72;
        r6.close();
    L72:
        throw th;
    L68:
        th = th;
        r6 = r18;
        goto L70
    L35:
        r17 = null;
    L37:
        r18 = null;
    L14:
        r3 = "unknown";
    L129:
        th = move-exception;
        r0.b();
        throw th;
    }

    public static void h(Map r1, String r2, com.ss.ugc.effectplatform.model.d r3) {
        HashMap r4 = (HashMap) r1;
        List r0 = (List) r4.get(r2);
        if (r0 != null) goto L5;
        ArrayList r5 = new ArrayList();
        r5.add(r3);
        r4.put(r2, r5);
        return;
    L5:
        r0.add(r3);
    }

    public a(EffectConfig r11, String r12, String r13, int r14, d r15) {
        super(r12, r14, LongCompanionObject.MAX_VALUE, o, r11.X, r11.Y, r11.a0, 4);
        this.k = r11;
        this.l = r13;
        this.m = r15;
    }
}

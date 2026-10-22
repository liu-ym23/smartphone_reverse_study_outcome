package com.ss.ugc.effectplatform.download;

import blc.b;
import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import clc.a;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.cache.l;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.util.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mlc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h implements j {
    public final Effect a;
    public final b b;
    public final EffectConfig c;

    @Override // com.ss.ugc.effectplatform.download.j
    public final boolean a(String r29) {
        com.ss.ugc.effectplatform.util.i r2 = com.ss.ugc.effectplatform.util.i.a;
        String r3 = com.ss.ugc.effectplatform.util.i.g(r29);
        if (r3 == null) goto L152;
        String r5 = this.b.c;
        if (r5 != null) goto L7;
    L19:
        com.ss.ugc.effectplatform.cache.j r4 = com.ss.ugc.effectplatform.cache.h.a(r3);
        String r9 = " unzip failed!";
        String r10 = "fetch effect: ";
        if ((r4 instanceof com.ss.ugc.effectplatform.cache.i) == false) goto L108;
        Logger.INSTANCE.d("EffectUnZipper", "fetchEffect " + this.a.getEffect_id() + ", name: " + this.a.getName() + " unzip in EffectDiskLruCache");
        com.ss.ugc.effectplatform.cache.i r6 = (com.ss.ugc.effectplatform.cache.i) r4;
        Effect r7 = this.a;
        r6.getClass();
        String r14 = r7.getUnzipPath();
        if (r14 == null) goto L162;
        String r15 = com.ss.ugc.effectplatform.util.i.a(r7.getUnzipPath());
        if (r15 == null) goto L162;
        String r16 = FileManager.a;     // Catch: Exception -> L98
        FileManager.o(r15);     // Catch: Exception -> L98
        a r8 = (a) r6.k.w.a;     // Catch: Exception -> L98
        if (r8 != null) goto L28;
        Integer r11 = r7.getFile_url().getUrl_type();     // Catch: Exception -> L98
        if (r11 != null) goto L35;
    L37:
        if (r6.k.p == true) goto L40;
        boolean r0 = FileManager.q(r29, r15);     // Catch: Exception -> L98
    L41:
        if (r0 == true) goto L46;
        EffectConfig r12 = r6.k;     // Catch: Exception -> L98
        klc.a r13 = (klc.a) r12.v.a;     // Catch: Exception -> L98
        if (r13 == null) goto L45;
        klc.b.g(r13, false, r12, r7, "unzip failed!");     // Catch: Exception -> L98
    L45:
        r2.delete(r15);     // Catch: Exception -> L98
        return r0;
    L46:
        int r1 = b0.a.a;     // Catch: Exception -> L98
        long r17 = System.currentTimeMillis();     // Catch: Exception -> L98
        String r18 = p.a(r15) + "effect_platform_children.tag";     // Catch: Exception -> L98
        List r19 = FileManager.f(r15);     // Catch: Exception -> L66
        if (r19 == null) goto L53;
        List r20 = r19;     // Catch: Exception -> L66
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));     // Catch: Exception -> L66
        Iterator r22 = r20.iterator();     // Catch: Exception -> L66
    L51:
        if (r22.hasNext() == false) goto L54;
        r21.add(StringsKt.removePrefix((String) r22.next(), r15));     // Catch: Exception -> L66
    L54:
        if (r21 == null) goto L56;
        String r23 = FileManager.a;     // Catch: Exception -> L66
        FileManager.u(r18, CollectionsKt.joinToString$default(r21, null, null, null, 0, null, null, 63, null));     // Catch: Exception -> L66
    L56:
        Logger r24 = Logger.INSTANCE;     // Catch: Exception -> L66
        StringBuilder r25 = new StringBuilder();     // Catch: Exception -> L66
        r25.append("write effect: ");     // Catch: Exception -> L66
        r25.append(r7.getEffect_id());     // Catch: Exception -> L66
        r25.append(" children count: ");     // Catch: Exception -> L66
        if (r21 == null) goto L59;
        Integer r26 = Integer.valueOf(r21.size());     // Catch: Exception -> L66
    L60:
        r25.append(r26);     // Catch: Exception -> L66
        r25.append(" time cost: ");     // Catch: Exception -> L66
        int r27 = b0.a.a;     // Catch: Exception -> L66
        r25.append(System.currentTimeMillis() - r17);     // Catch: Exception -> L64
        r25.append(" ms");     // Catch: Exception -> L64
        r24.d("writeEffect", r25.toString());     // Catch: Exception -> L64
    L69:
        com.ss.ugc.effectplatform.util.i r28 = com.ss.ugc.effectplatform.util.i.a;     // Catch: Exception -> L80
        boolean r30 = com.ss.ugc.effectplatform.util.i.h(r15, r14, true);     // Catch: Exception -> L80
        if (r30 == true) goto L75;
        EffectConfig r31 = r6.k;     // Catch: Exception -> L80
        klc.a r32 = (klc.a) r31.v.a;     // Catch: Exception -> L80
        if (r32 == null) goto L74;
        klc.b.g(r32, false, r31, r7, "unzip failed!");     // Catch: Exception -> L80
    L74:
        r28.delete(r15);     // Catch: Exception -> L80
    L143:
        return r30;
    L75:
        String r33 = FileManager.a;     // Catch: Exception -> L80
        String r34 = FileManager.e(r14);     // Catch: Exception -> L80
        if (r34 == null) goto L90;
        com.ss.ugc.effectplatform.cache.disklrucache.a r35 = r6.e();     // Catch: Exception -> L80
        if (r35 == null) goto L82;
        com.ss.ugc.effectplatform.cache.disklrucache.a.w.getClass();     // Catch: Exception -> L80
        r35.b(com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a.c(r34));     // Catch: Exception -> L80
    L82:
        r6.remove(r7.getId() + ".zip");     // Catch: Exception -> L80
        c r36 = (c) com.ss.ugc.effectplatform.cache.i.l.a;     // Catch: Exception -> L80
        if (r36 == null) goto L85;
        r36.putString(r7.getId(), r7.getEffect_id());     // Catch: Exception -> L80
    L85:
        EffectConfig r37 = r6.k;     // Catch: Exception -> L80
        if (r37.b0 == false) goto L90;
        l.a r38 = l.c;     // Catch: Exception -> L80
        Object r39 = r37.G;     // Catch: Exception -> L80
        r38.getClass();     // Catch: Exception -> L80
        if (l.a.a(r39) == null) goto L90;
        new com.ss.ugc.effectplatform.cache.k(r7);     // Catch: Exception -> L80
    L90:
        if (r30 == false) goto L94;
        EffectConfig r40 = r6.k;
        klc.a r41 = (klc.a) r40.v.a;
        if (r41 == null) goto L143;
        klc.b.g(r41, true, r40, r7, "");
        goto L143
    L94:
        EffectConfig r42 = r6.k;
        klc.a r43 = (klc.a) r42.v.a;
        if (r43 == null) goto L143;
        klc.b.g(r43, false, r42, r7, "unzip failed!");
    L64:
        e = e;
    L155:
        Logger.INSTANCE.e("writeEffect", "write effect: " + r7.getEffect_id() + " children tag file failed!", e);     // Catch: Exception -> L80
        String r44 = FileManager.a;     // Catch: Exception -> L80
        FileManager.o(r18);     // Catch: Exception -> L80
    L80:
        e = e;
    L100:
        Logger.INSTANCE.e("EffectDiskLruCache", r10 + r7.getEffect_id() + ", name: " + r7.getName() + r9, e);
        com.ss.ugc.effectplatform.util.i r45 = com.ss.ugc.effectplatform.util.i.a;
        r45.delete(r15);
        String r46 = FileManager.a;
        String r47 = FileManager.e(r14);
        if (r47 == null) goto L103;
        r6.remove(r47);
    L103:
        r45.delete(r14);
        EffectConfig r48 = r6.k;
        klc.a r49 = (klc.a) r48.v.a;
        if (r49 == null) goto L106;
        klc.b.g(r49, false, r48, r7, e.getMessage());
    L106:
        throw e;
    L59:
        r26 = null;
        goto L60
    L53:
        r21 = null;
    L66:
        e = e;
    L40:
        r0 = FileManager.r(r29, r15);     // Catch: Exception -> L98
        goto L41
    L35:
        if (r11.intValue() == 1) goto L40;
    L28:
        if (r8.a() != 0) goto L30;
        r0 = true;
        goto L41
    L30:
        r0 = false;
    L98:
        e = e;
        r9 = " unzip failed!";
        r10 = "fetch effect: ";
    L162:
        return false;
    L108:
        Logger.INSTANCE.d("EffectUnZipper", "fetchEffect " + this.a.getEffect_id() + ", name: " + this.a.getName() + " unzip in old cache");
        String r50 = this.a.getUnzipPath();
        String r51 = com.ss.ugc.effectplatform.util.i.a(this.a.getUnzipPath());
        if (r51 != null) goto L157;
        return false;
    L157:
        String r52 = FileManager.a;     // Catch: Exception -> L144
        FileManager.o(r51);     // Catch: Exception -> L144
        a r53 = (a) this.c.w.a;     // Catch: Exception -> L144
        if (r53 != null) goto L113;
        Integer r54 = this.a.getFile_url().getUrl_type();     // Catch: Exception -> L144
        if (r54 != null) goto L121;
    L123:
        if (this.c.p == true) goto L126;
        boolean r55 = FileManager.q(r29, r51);     // Catch: Exception -> L144
    L127:
        if (r55 == true) goto L129;
    L131:
        r30 = false;
    L132:
        FileManager.o(r29);     // Catch: Exception -> L144
        if (r30 == true) goto L135;
        FileManager.o(r51);     // Catch: Exception -> L144
        FileManager.o(r50);     // Catch: Exception -> L144
    L135:
        if (r30 == false) goto L139;
        EffectConfig r56 = this.c;     // Catch: Exception -> L144
        klc.a r57 = (klc.a) r56.v.a;     // Catch: Exception -> L144
        if (r57 == null) goto L143;
        klc.b.g(r57, true, r56, this.a, "");     // Catch: Exception -> L144
        goto L143
    L139:
        EffectConfig r58 = this.c;     // Catch: Exception -> L144
        klc.a r59 = (klc.a) r58.v.a;     // Catch: Exception -> L144
        if (r59 == null) goto L143;
        klc.b.g(r59, false, r58, this.a, "unzip failed!");     // Catch: Exception -> L144
        goto L143
    L129:
        if (com.ss.ugc.effectplatform.util.i.h(r51, r50, true) == false) goto L131;
    L130:
        r30 = true;
    L126:
        r55 = FileManager.r(r29, r51);     // Catch: Exception -> L144
        goto L127
    L121:
        if (r54.intValue() == 1) goto L126;
    L113:
        if (r53.a() != 0) goto L131;
        if (com.ss.ugc.effectplatform.util.i.h(r51, r50, true) == false) goto L131;
    L144:
        e = move-exception;
        Logger.INSTANCE.e("EffectUnZipper", "fetch effect: " + this.a.getEffect_id() + ", name: " + this.a.getName() + " unzip failed!", e);
        String r60 = FileManager.a;
        FileManager.o(r51);
        FileManager.o(r50);
        EffectConfig r61 = this.c;
        klc.a r62 = (klc.a) r61.v.a;
        if (r62 == null) goto L148;
        klc.b.g(r62, false, r61, this.a, e.getMessage());
    L148:
        throw e;
    L7:
        if ((!Intrinsics.areEqual(r5, r3)) == false) goto L19;
        klc.a r63 = (klc.a) this.c.v.a;
        if (r63 == null) goto L19;
        HashMap r64 = new HashMap();
        String r110 = this.c.m;
        if (r110 != null) goto L14;
        r110 = "";
    L14:
        r64.put("app_id", r110);
        String r111 = this.c.a;
        if (r111 != null) goto L18;
        r111 = "";
    L18:
        r64.put(EffectConfiguration.KEY_ACCESS_KEY, r111);
        r64.put("effect_id", this.a.getEffect_id());
        r64.put("EffectDir", r5);
        r64.put("zippath", r3);
        r63.monitorStatusRate("effect_download_error", 1, r64);
        goto L19
    L152:
        return false;
    }

    public h(b r1, EffectConfig r2) {
        this.b = r1;
        this.c = r2;
        this.a = r1.a;
    }
}

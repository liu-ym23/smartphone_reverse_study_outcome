package com.ss.ugc.effectplatform.download;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.exception.CurrentEditingException;
import com.ss.ugc.effectplatform.model.Effect;
import kotlin.Pair;
import mlc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i implements k {
    public final Effect a;

    public static final class a {
    }

    static {
    }

    public i(Effect r1) {
        this.a = r1;
    }

    @Override // com.ss.ugc.effectplatform.download.k
    public final String a(d r23, long r24, e r26) {
        com.ss.ugc.effectplatform.util.i r0 = com.ss.ugc.effectplatform.util.i.a;
        String r1 = com.ss.ugc.effectplatform.util.i.g(this.a.getZipPath());
        if (r1 == null) goto L31;
        com.ss.ugc.effectplatform.cache.j r2 = com.ss.ugc.effectplatform.cache.h.a(r1);
        if ((r2 instanceof com.ss.ugc.effectplatform.cache.i) == false) goto L26;
        Integer r3 = this.a.getFile_url().getUrl_type();
        if (r3 != null) goto L10;
    L12:
        String r4 = this.a.getFile_url().getUri();
    L13:
        String r7 = r4;
        int r5 = b0.a.a;
        long r11 = System.currentTimeMillis();
        com.ss.ugc.effectplatform.cache.i r6 = (com.ss.ugc.effectplatform.cache.i) r2;
        Effect r13 = this.a;
        EffectWriteDisk.execWrite.zipPath.1 r10 = new EffectWriteDisk.execWrite.zipPath.1(r26);
        r6.getClass();
        com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a r8 = com.ss.ugc.effectplatform.cache.disklrucache.a.w;
        String r9 = r13.getId() + ".zip";
        r8.getClass();
        String r12 = com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a.c(r9);
        Pair r14 = r6.g(r12, r23, r7, r24, r10);     // Catch: Exception -> L21
        if (((Boolean) r14.getSecond()).booleanValue() == false) goto L19;
        c r15 = (c) com.ss.ugc.effectplatform.cache.i.l.a;     // Catch: Exception -> L21
        if (r15 == null) goto L19;
        r15.putString(r13.getId(), r13.getEffect_id());     // Catch: Exception -> L21
    L19:
        Logger r16 = Logger.INSTANCE;     // Catch: Exception -> L21
        r16.d("EffectDiskLruCache", "effect " + r13.getEffect_id() + ", name: " + r13.getName() + ", key: " + r12 + " end in disklrucache, result: " + ((Boolean) r14.getSecond()).booleanValue());     // Catch: Exception -> L21
        String r17 = (String) r14.getFirst();     // Catch: Exception -> L21
        Logger.e$default(r16, "JKL-timeCost", "rewrite file extra cost: " + (System.currentTimeMillis() - r11), null, 4, null);
        return r17;
    L21:
        e = move-exception;
        Logger.INSTANCE.e("EffectDiskLruCache", "fetch effect: " + r13.getEffect_id() + ", name: " + r13.getName() + " key: " + r12 + " write to disk failed!", e);
        if ((e instanceof CurrentEditingException) == true) goto L25;
        r6.remove(r12);
    L25:
        throw e;
    L10:
        if (r3.intValue() != 1) goto L12;
        r4 = this.a.getFile_url().getMd5();
        goto L13
    L26:
        com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a r18 = com.ss.ugc.effectplatform.cache.disklrucache.a.w;
        String r19 = this.a.getId() + ".zip";
        r18.getClass();
        String r20 = com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a.c(r19);
        if (r2 == null) goto L30;
        r2.b(r20, r23);
    L30:
        return this.a.getZipPath();
    L31:
        return null;
    }
}

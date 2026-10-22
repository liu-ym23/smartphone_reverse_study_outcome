package com.ss.ugc.effectplatform.cache;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.cache.disklrucache.e;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.util.r;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i extends c {
    public static final a0.b<mlc.c> l = null;
    public static final a0.b<String> m = null;
    public static final a0.b<List<String>> n = null;
    public static final a0.b<List<String>> o = null;
    public static final a p = null;
    public final EffectConfig k;

    public static final class a implements e {
        public final List<String> a;
        public final List<String> b;

        public a() {
            this.a = CollectionsKt.listOf(new String[]{"52310", "42494", "22435", "52308", "22428", "29412", "23202", "85256", "51522", "51092", "45973", "40781"});
            this.b = CollectionsKt.listOf(new String[]{"52352", "42504", "50593", "249501", "22146", "166469", "221655", "234650", "240739", "203226"});
        }

        public static boolean a(String r4) {
            Logger r0 = Logger.INSTANCE;
            StringBuilder r1 = new StringBuilder("cleaneffect: isCountry:");
            r1.append(r4);
            r1.append(" now:");
            a0.b<String> r2 = i.m;
            r1.append(r2);
            r0.d("EffectDiskLruCache", r1.toString());
            if (r.b(r4) == false) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(r4, (String) r2.a) == false) goto L7;
            return true;
        }

        @Override // com.ss.ugc.effectplatform.cache.disklrucache.e
        public final boolean isAllowed(String r9) {
            if (r.b(r9) == false) goto L5;
            return false;
        L5:
            Logger r0 = Logger.INSTANCE;
            r0.d("EffectDiskLruCache", "cleaneffect: allowlist：" + r9);
            mlc.c r2 = (mlc.c) i.l.a;
            if (r2 == null) goto L25;
            String r3 = r2.getString(r9, "");
            if (a("BR") == false) goto L14;
            if (this.a.contains(r3) == false) goto L14;
            r0.d("EffectDiskLruCache", "cleaneffect: allowlist：BR, key: " + r9);
            return true;
        L14:
            if (a("RU") == true) goto L16;
        L19:
            List r4 = (List) i.n.a;
            if (r4 == null) goto L25;
            if (r4.contains(r9) == false) goto L25;
            r0.d("EffectDiskLruCache", "cleaneffect: allowlist：draft, key: " + r9);
            return true;
        L16:
            if (this.b.contains(r3) == false) goto L19;
            r0.d("EffectDiskLruCache", "cleaneffect: allowlist：RU, key: " + r9);
            return true;
        L25:
            List r1 = (List) i.o.a;
            String r5 = null;
            Object r6 = null;
            if (r1 == null) goto L34;
            Iterator r7 = r1.iterator();
        L29:
            if (r7.hasNext() == false) goto L33;
            Object r8 = r7.next();
            if (new Regex((String) r8).containsMatchIn(r9) == false) goto L29;
            r6 = r8;
        L33:
            r5 = (String) r6;
        L34:
            if (r5 == null) goto L37;
            Logger.INSTANCE.d("EffectDiskLruCache", "cleaneffect: allowlist：customAllowList, key: " + r9 + " , regex: " + r5);
            return true;
        L37:
            return false;
        }
    }

    public static final class b {
    }

    static {
        l = new a0.b(null);
        m = new a0.b(null);
        n = new a0.b(null);
        o = new a0.b(null);
        p = new a();
    }

    @Override // com.ss.ugc.effectplatform.cache.c, com.ss.ugc.effectplatform.cache.j
    public final void clear() {
        super.clear();
        a0.b<mlc.c> r0 = l;
        mlc.c r1 = (mlc.c) r0.a;
        if (r1 == null) goto L5;
        r1.clear();
    L5:
        String r3 = "effectid_map";
        if (r.b("") == true) goto L9;
        r3 = "" + FileManager.a + "effectid_map";
    L9:
        int r2 = mlc.b.a;
        r0.a = mlc.b.a(r3, this.k.G);
    }

    public i(EffectConfig r11) {
        super(r11.i, 0, r11.L, p, r11.X, r11.Y, false, 134);
        this.k = r11;
        String r2 = "effectid_map";
        if (r.b("") == true) goto L6;
        r2 = "" + FileManager.a + "effectid_map";
    L6:
        int r0 = mlc.b.a;
        l.a = mlc.b.a(r2, r11.G);
        m.a = r11.l;
        a0.b<List<String>> r1 = n;
        r1.a = r11.F;
        Logger.INSTANCE.d("EffectDiskLruCache", this + " draftDIRAllowList:" + ((List) r1.a));
    }

    @Override // com.ss.ugc.effectplatform.cache.c, com.ss.ugc.effectplatform.cache.j
    public final void c(List<String> r4) {
        Logger.INSTANCE.d("EffectDiskLruCache", "updateDraftList: " + r4);
        n.a = r4;
    }

    public final void h(Effect r7) {
        remove(r7.getId() + ".zip");
        String r8 = r7.getUnzipPath();
        if (r8 == null) goto L14;
        String r0 = FileManager.a;     // Catch: Exception -> L9
        String r1 = FileManager.e(r8);     // Catch: Exception -> L9
        if (r1 == null) goto L7;
        remove(r1);     // Catch: Exception -> L9
    L7:
        FileManager.o(r8);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "EffectDiskLruCache", "remove effect failed! " + e.getMessage(), null, 4, null);
        return;
    }
}

package com.ss.ugc.effectplatform.download;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.io.file.f;
import bytekn.foundation.io.file.j;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.cache.l;
import com.ss.ugc.effectplatform.exception.CurrentEditingException;
import com.ss.ugc.effectplatform.exception.MD5Exception;
import com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel;
import com.ss.ugc.effectplatform.model.algorithm.FetchModelType;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import com.ss.ugc.effectplatform.util.i;
import com.ss.ugc.effectplatform.util.k;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class a {
    public ModelInfo a;
    public FetchModelType b;
    public String c;
    public final f d;
    public final com.ss.ugc.effectplatform.cache.a e;
    public final INetworkClient f;

    /* JADX INFO: renamed from: com.ss.ugc.effectplatform.download.a$a, reason: collision with other inner class name */
    public static final class C0005a {
    }

    public static final class b implements k {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r11v2 */
        public final String a(d r24, long r25, e r27) {
            a r0 = this.a;
            com.ss.ugc.effectplatform.cache.a r9 = r0.e;
            FetchModelType r2 = r0.b;
            if (r2 == null) goto L119;
            ModelInfo r1 = r0.a;
            if (r1 == null) goto L117;
            r9.getClass();
            String r3 = r1.getName();
            com.ss.ugc.effectplatform.cache.disklrucache.a.w.getClass();
            String r4 = com.ss.ugc.effectplatform.cache.disklrucache.a.a.c(r3);
            com.ss.ugc.effectplatform.cache.disklrucache.a r5 = r9.e();
            if (r5 == null) goto L20;
            Set r6 = r5.f();
            if (r6 == null) goto L20;
            Iterator r7 = r6.iterator();
        L12:
            if (r7.hasNext() == false) goto L20;
            String r8 = (String) r7.next();
            if (Intrinsics.areEqual(k.d(r8), r4) == false) goto L12;
            r9.remove(r8);
            EffectConfig r10 = r9.k;
            if (r10.b0 == false) goto L12;
            l.a r11 = l.c;
            Object r12 = r10.G;
            r11.getClass();
            if (l.a.a(r12) == null) goto L12;
            new com.ss.ugc.effectplatform.cache.k(r1, "");
        L20:
            String r13 = r1.getName();
            if (r9.k.V == false) goto L23;
            r13 = bytekn.foundation.utils.c.a(r13);
        L23:
            r1.setName(r13);
            String r14 = k.a(r1);
            com.ss.ugc.effectplatform.cache.disklrucache.a.w.getClass();
            String r15 = com.ss.ugc.effectplatform.cache.disklrucache.a.a.c(r14);
            int r16 = com.ss.ugc.effectplatform.cache.b.a[r2.ordinal()];
            if (r16 != 1) goto L26;
            r1 = r1;
            ExtendedUrlModel r17 = r1.getFile_url();
            if (r17 == null) goto L103;
            String r18 = r17.getUri();
        L104:
            String r19 = (String) r9.g(r15, r24, r18, 0, null).getFirst();
        L106:
            if (r9.k.b0 == false) goto L115;
            String r20 = FileManager.a;
            if (FileManager.d(r19) == false) goto L115;
            l.a r21 = l.c;
            Object r22 = r9.k.G;
            r21.getClass();
            if (l.a.a(r22) == null) goto L115;
            if (r19 != null) goto L114;
            Intrinsics.throwNpe();
        L114:
            new com.ss.ugc.effectplatform.cache.k(r1, r19);
        L115:
            return r19;
        L103:
            r18 = null;
            goto L104
        L26:
            if (r16 != 2) goto L99;
            ExtendedUrlModel r23 = r1.getFile_url();
            if (r23 == null) goto L30;
            String r26 = r23.getUri();
        L31:
            j r110 = "editor in currently editing!, key: ";
            StringBuilder r111 = new StringBuilder();
            r111.append(((com.ss.ugc.effectplatform.cache.c) r9).c);
            String r112 = FileManager.a;
            String r113 = FileManager.a;
            r111.append(r113);
            r111.append(r15);
            r111.append(".tmp");
            String r114 = r111.toString();
            String r28 = ((com.ss.ugc.effectplatform.cache.c) r9).c + r113 + r15 + "_unzip";
            i r115 = i.a;     // Catch: Throwable -> L83 Exception -> L85
            i.i(r114, r24);     // Catch: Throwable -> L83 Exception -> L85
            FileManager.r(r114, r28);     // Catch: Throwable -> L83 Exception -> L85
            List r116 = FileManager.m(r28);     // Catch: Throwable -> L83 Exception -> L85
            if (r116 != null) goto L35;
        L74:
            com.ss.ugc.effectplatform.cache.disklrucache.a.b r117 = null;
            Logger.e$default(Logger.INSTANCE, "DiskLruCacheImpl", "no file in unzipped dir! key: " + r15, null, 4, null);     // Catch: Throwable -> L79 Exception -> L81
        L123:
            FileManager.o(r114);     // Catch: Exception -> L122
            FileManager.o(r28);     // Catch: Exception -> L122
        L77:
            Pair r29 = new Pair("", Boolean.FALSE);
        L78:
            r19 = (String) r29.getFirst();
        L81:
            e = e;
        L88:
            com.ss.ugc.effectplatform.cache.disklrucache.a.b r30 = r117;
        L90:
            Logger.INSTANCE.e("DiskLruCacheImpl", "write: " + r15 + " ioException", e);     // Catch: Throwable -> L62
            if (r30 != null) goto L127;
        L93:
            throw e;     // Catch: Throwable -> L62
        L127:
            r30.a();     // Catch: Throwable -> L62 Exception -> L121
            goto L93
        L35:
            if ((!r116.isEmpty()) == true) goto L38;
            r116 = null;
        L38:
            if (r116 == null) goto L74;
            bytekn.foundation.io.file.d r31 = (bytekn.foundation.io.file.d) r116.get(0);     // Catch: Throwable -> L83 Exception -> L85
            if (r31 == null) goto L74;
            f r32 = r31.b;     // Catch: Throwable -> L83 Exception -> L85
            if (r32 == null) goto L46;
            String r33 = r32.b;     // Catch: Throwable -> L83 Exception -> L85
            if (r33 == null) goto L46;
            bytekn.foundation.io.file.b r34 = FileManager.j(r33);     // Catch: Throwable -> L83 Exception -> L85
        L47:
            if (r34 == null) goto L123;
            com.ss.ugc.effectplatform.cache.disklrucache.a r35 = r9.e();     // Catch: Throwable -> L83 Exception -> L85
            if (r35 == null) goto L52;
            r30 = r35.d(r15);     // Catch: Throwable -> L83 Exception -> L85
        L53:
            if (r30 != null) goto L131;
            r117 = null;
            Logger.e$default(Logger.INSTANCE, "DiskLruCacheImpl", "editor in currently editing!, key: " + r15, null, 4, null);     // Catch: Exception -> L71 Throwable -> L79
            throw new CurrentEditingException("editor in currently editing!, key: " + r15);     // Catch: Exception -> L71 Throwable -> L79
        L71:
            e = e;
            goto L90
        L131:
            j r118 = new j(r30.c());     // Catch: Exception -> L66 Throwable -> L83
            r1 = r1;
            String r36 = i.c(r34, r118, 0, null);     // Catch: Throwable -> L62 Exception -> L64
            if (Intrinsics.areEqual(r36, r26) == false) goto L60;
            r30.b();     // Catch: Throwable -> L62 Exception -> L64
            r29 = new Pair(((com.ss.ugc.effectplatform.cache.c) r9).c + r113 + r15, Boolean.TRUE);     // Catch: Throwable -> L62 Exception -> L64
            FileManager.o(r114);
            FileManager.o(r28);
            r118.close();
            goto L78
        L60:
            Logger.e$default(Logger.INSTANCE, "DiskLruCacheImpl", "write: " + r15 + " md5 not match! expected md: " + r26 + ", actual md5: " + r36, null, 4, null);     // Catch: Throwable -> L62 Exception -> L64
            throw new MD5Exception("write: " + r15 + " md5 not match! expected md: " + r26 + ", actual md5: " + r36);     // Catch: Throwable -> L62 Exception -> L64
        L64:
            e = e;
            goto L90
        L66:
            e = e;
            r117 = null;
            goto L90
        L52:
            r30 = null;
        L46:
            r34 = null;
        L79:
            th = th;
        L87:
            r110 = r116;
        L132:
            String r37 = FileManager.a;     // Catch: Exception -> L120
            FileManager.o(r114);     // Catch: Exception -> L120
            FileManager.o(r28);     // Catch: Exception -> L120
            if (r110 == 0) goto L97;
            r110.close();     // Catch: Exception -> L120
        L97:
            throw th;
        L62:
            th = th;
        L83:
            th = th;
            r116 = null;
        L85:
            e = e;
            r117 = null;
            goto L88
        L30:
            r26 = null;
            goto L31
        L99:
            throw new NoWhenBranchMatchedException();
        L117:
            throw new IllegalArgumentException("modelInfo is required!");
        L119:
            throw new IllegalArgumentException("fetchModelType is required!");
        }
    }

    static {
    }

    public a(com.ss.ugc.effectplatform.cache.a r1, INetworkClient r2) {
        this.e = r1;
        this.f = r2;
        this.c = "";
        f.a r3 = new f.a();
        r3.b = r2;
        r3.a = new b(this);
        r3.c = DownloadType.ALGORITHM;
        this.d = r3.a();
    }
}

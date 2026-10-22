package com.ss.ugc.effectplatform.task;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import com.ss.ugc.effectplatform.model.net.PreloadResourceList;
import com.ss.ugc.effectplatform.preload.DownloadType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b1 extends BaseTask {
    public com.ss.ugc.effectplatform.preload.d g;
    public final a0.b<String> h;
    public final EffectConfig i;
    public final PreloadResourceList j;
    public final String k;
    public final long l;
    public final com.ss.ugc.effectplatform.preload.e m;

    public static final class a {
    }

    public static final class b implements com.ss.ugc.effectplatform.download.k {
        public final /* synthetic */ b1 a;
        public final /* synthetic */ com.ss.ugc.effectplatform.preload.c b;

        public b(b1 r1, com.ss.ugc.effectplatform.preload.c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final String a(com.ss.ugc.effectplatform.download.d r1, long r2, com.ss.ugc.effectplatform.download.e r4) {
            com.ss.ugc.effectplatform.preload.b.a r3 = com.ss.ugc.effectplatform.preload.b.d;
            Object r5 = this.a.i.G;
            r3.getClass();
            com.ss.ugc.effectplatform.preload.b r6 = com.ss.ugc.effectplatform.preload.b.a.a(r5);
            if (r6 == null) goto L7;
            r6.d(this.b);
            return "";
        L7:
            return "";
        }
    }

    public static final class c implements com.ss.ugc.effectplatform.bridge.network.a {
        public final /* synthetic */ b1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public final void onProgress(int r1, long r2) {
        }

        public final void a(com.ss.ugc.effectplatform.download.g r14) {
            boolean r1 = true;
            String r4 = null;
            if (r14.a() == false) goto L17;
            Logger.INSTANCE.d("JKL", "[预加载][文件下载][成功][" + this.b + ']');
            com.ss.ugc.effectplatform.preload.e r0 = this.a.m;
            String r5 = this.c;
            long r6 = r14.e / ((long) 1024);
            ((ArrayList) r0.c).add(r5);
            r0.b += r6;
            c0.b r7 = r0.d;
            if (r7 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("countDown");
        L8:
            if (r7.a() == 0) goto L11;
            r1 = false;
        L11:
            if (r1 == false) goto L13;
            r0.a();
        L13:
            z.d<b1> r2 = com.ss.ugc.effectplatform.preload.h.a;
            com.ss.ugc.effectplatform.preload.h.a.remove(this.a);
            b1 r3 = this.a;
            boolean r8 = r14.a();
            Exception r15 = r14.f;
            if (r15 == null) goto L16;
            r4 = r15.getMessage();
        L16:
            r3.f(r8, r4, this.c, this.d);
        L39:
            ConcurrentHashMap r16 = llc.a.a;
            String r17 = this.d;
            llc.a.a(r17, r17);
            return;
        L17:
            long r9 = r14.e;
            if (r9 != (-2)) goto L21;
            Logger.INSTANCE.w("JKL", "[预加载][文件下载][暂停][" + this.b + ']');
            goto L39
        L21:
            if (r9 != (-3)) goto L23;
            Logger.INSTANCE.w("JKL", "[预加载][文件下载][取消][" + this.b + ']');
            goto L39
        L23:
            com.ss.ugc.effectplatform.preload.e r10 = this.a.m;
            c0.b r11 = r10.d;
            if (r11 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("countDown");
        L27:
            if (r11.a() == 0) goto L30;
            r1 = false;
        L30:
            if (r1 == false) goto L32;
            r10.a();
        L32:
            Logger.e$default(Logger.INSTANCE, "JKL", "[预加载][文件下载][失败][" + this.b + ']', null, 4, null);
            Exception r12 = r14.f;
            if (r12 == null) goto L35;
            r12.printStackTrace();
        L35:
            z.d<b1> r13 = com.ss.ugc.effectplatform.preload.h.a;
            com.ss.ugc.effectplatform.preload.h.a.remove(this.a);
            b1 r18 = this.a;
            boolean r19 = r14.a();
            Exception r110 = r14.f;
            if (r110 == null) goto L38;
            r4 = r110.getMessage();
        L38:
            r18.f(r19, r4, this.c, this.d);
            goto L39
        }

        public c(b1 r1, String r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public final void b() {
    }

    public final void a() {
        if (((BaseTask) this).b == false) goto L5;
        return;
    L5:
        String r10 = this.j.getKey();
        String r11 = this.j.getUri();
        String r0 = this.j.getType();
        String r2 = this.j.getVersion();
        String r12 = "";
        if (r2 == null) goto L8;
        String r16 = r2;
    L9:
        String r8 = this.j.getName();
        int r3 = b0.a.a;
        long r24 = System.currentTimeMillis();
        ArrayList r9 = new ArrayList();
        Iterator<T> r4 = this.j.getCdn_prefix_list().iterator();
    L11:
        if (r4.hasNext() == false) goto L14;
        r9.add(((String) r4.next()) + r11);
        goto L11
    L14:
        if (r9.isEmpty() == false) goto L16;
        return;
    L16:
        boolean r26 = Intrinsics.areEqual(this.j.getBlock_file_type(), "zip");
        boolean r27 = Intrinsics.areEqual(r0, "algorithm_resource");
        if (r27 == true) goto L100;
        com.ss.ugc.effectplatform.cache.disklrucache.a.w.getClass();
        String r1 = com.ss.ugc.effectplatform.cache.disklrucache.a.a.c(r11);
    L28:
        String r13 = r1;
        com.ss.ugc.effectplatform.preload.c r14 = new com.ss.ugc.effectplatform.preload.c(r13, r10, r11, r8, r24, this.k);
        EffectConfig r5 = this.i;
        if (r27 == false) goto L31;
        String r6 = r5.k;
    L32:
        StringBuilder r7 = new StringBuilder();
        r7.append(r6);
        String r15 = FileManager.a;
        String r17 = FileManager.a;
        r7.append(r17);
        r7.append(r13);
        if (FileManager.d(r7.toString()) == false) goto L36;
        Logger.INSTANCE.d("JKL", "[预加载][文件下载][默认缓存路径下，文件已存在，不重复下载][" + r13 + ']');
        return;
    L36:
        String r18 = this.i.j + r17 + r13;
        boolean r19 = true;
        if (FileManager.d(r18) == false) goto L56;
        com.ss.ugc.effectplatform.preload.b.a r20 = com.ss.ugc.effectplatform.preload.b.d;
        Object r21 = this.i.G;
        r20.getClass();
        com.ss.ugc.effectplatform.preload.b r22 = com.ss.ugc.effectplatform.preload.b.a.a(r21);
        if (r22 == null) goto L56;
        SQLiteDatabase r23 = r22.a;     // Catch: Exception -> L50
        if (r23 == null) goto L52;
        Cursor r25 = r23.rawQuery("select * from preload_table where file_name=?", new String[]{r13});     // Catch: Exception -> L50
        if (r25 == null) goto L52;
        if (r25.getCount() <= 0) goto L47;
        boolean r28 = true;
    L48:
        r25.close();     // Catch: Exception -> L50
    L53:
        if (r28 != true) goto L56;
        Logger.INSTANCE.d("JKL", "[预加载][文件下载][文件已存在，不重复下载][" + r13 + ']');
        return;
    L47:
        r28 = false;
    L52:
        r28 = false;
    L50:
        e = move-exception;
        e.printStackTrace();
    L56:
        com.ss.ugc.effectplatform.preload.d.a r29 = new com.ss.ugc.effectplatform.preload.d.a();
        INetworkClient r30 = (INetworkClient) this.i.u.a;
        if (r30 == null) goto L59;
        r29.b = r30;
    L59:
        StringBuilder r31 = new StringBuilder();
        r31.append(r18);
        if (r26 == false) goto L62;
        r12 = ".zip";
    L62:
        r31.append(r12);
        String r210 = r31.toString();
        if (r27 == false) goto L65;
        DownloadType r32 = DownloadType.ALGORITHM;
    L66:
        r29.c = r32;
        if (r26 == false) goto L69;
        r29.d = new com.ss.ugc.effectplatform.preload.i(this.i, r18);
    L69:
        r29.a = new b(this, r14);
        if (r29.b == null) goto L97;
        INetworkClient r33 = r29.b;
        if (r33 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("networkClient");
    L74:
        com.ss.ugc.effectplatform.download.k r34 = r29.a;
        if (r34 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("writeDisk");
    L77:
        this.g = new com.ss.ugc.effectplatform.preload.d(r33, r34, r29.d, r29.c);
        String r35 = (String) ListProtector.remove(r9, 0);
        this.h.a = r35;
        if (r35 == null) goto L105;
        llc.a.b(r11, r11);
        com.ss.ugc.effectplatform.preload.d r36 = this.g;     // Catch: Exception -> L84
        if (r36 == null) goto L106;
        r36.a(r35, r210, r9, this.l, r13, new c(this, r13, r10, r11));     // Catch: Exception -> L84
        return;
    L106:
        return;
    L84:
        e = move-exception;
        e.printStackTrace();
        com.ss.ugc.effectplatform.preload.e r37 = this.m;
        c0.b r38 = r37.d;
        if (r38 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("countDown");
    L89:
        if (r38.a() == 0) goto L92;
        r19 = false;
    L92:
        if (r19 == false) goto L94;
        r37.a();
    L94:
        Logger.e$default(Logger.INSTANCE, "JKL", "[预加载][文件下载][失败][" + r13 + "][" + bytekn.foundation.utils.b.a(e, 5) + ']', null, 4, null);
        com.ss.ugc.effectplatform.preload.h.a.remove(this);
        f(false, e.getMessage(), r10, r11);
        llc.a.a(r11, r11);
        return;
    L105:
        return;
    L97:
        throw new IllegalArgumentException("networkClient is required to setup!");
    L65:
        r32 = DownloadType.EFFECT;
        goto L66
    L31:
        r6 = r5.i;
        goto L32
    L100:
        String r39 = this.j.getLevel();     // Catch: Exception -> L24
        if (r39 == null) goto L22;
        int r40 = CastIntegerProtector.parseInt(r39);     // Catch: Exception -> L24
    L23:
        int r211 = r40;
    L26:
        String r41 = com.ss.ugc.effectplatform.util.k.a(new ModelInfo(r8, null, r16, new ExtendedUrlModel(null, r11, null, 5, null), 0, r211, 0, 82, null));
        com.ss.ugc.effectplatform.cache.disklrucache.a.w.getClass();
        r1 = com.ss.ugc.effectplatform.cache.disklrucache.a.a.c(r41);
        goto L28
    L22:
        r40 = 0;
    L24:
        e = move-exception;
        e.printStackTrace();
        r211 = 0;
        goto L26
    L8:
        r16 = "";
        goto L9
    }

    public final void pause() {
        super.pause();
        if (((BaseTask) this).d == false) goto L15;
        String r0 = (String) this.h.a;
        if (r0 == null) goto L16;
        com.ss.ugc.effectplatform.preload.d r1 = this.g;
        if (r1 == null) goto L17;
        INetworkClient r2 = r1.a;
        if ((r2 instanceof com.ss.ugc.effectplatform.bridge.network.b) == true) goto L11;
        r2 = null;
    L11:
        com.ss.ugc.effectplatform.bridge.network.b r3 = (com.ss.ugc.effectplatform.bridge.network.b) r2;
        if (r3 == null) goto L18;
        r3.pause(r0);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void f(boolean r5, String r6, String r7, String r8) {
        klc.a r0 = (klc.a) this.i.v.a;
        if (r0 == null) goto L10;
        Pair[] r1 = new Pair[4];
        r1[0] = TuplesKt.to(TabAppInfo.IMAGE_JSON_KEY, r7);
        r1[1] = TuplesKt.to("uri", r8);
        r1[2] = TuplesKt.to("block_uri", "");
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        r1[3] = TuplesKt.to("err_msg", r6);
        Map r9 = MapsKt.mutableMapOf(r1);
        r0.monitorStatusRate("preload_resource_success_rate", !r5 ? 1 : 0, r9);
        return;
    }

    public b1(EffectConfig r2, PreloadResourceList r3, String r4, long r5, String r7, com.ss.ugc.effectplatform.preload.e r8) {
        super(r7, null);
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.m = r8;
        this.h = new a0.b(null);
    }
}

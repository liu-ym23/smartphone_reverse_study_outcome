package com.bytedance.gkfs.storage;

import ai.j0;
import android.os.Handler;
import com.bytedance.gkfs.UtilsKt$traceTime$1$1;
import com.bytedance.gkfs.storage.io.GkFSBlockBuffer;
import com.bytedance.keva.Keva;
import com.lynx.tasm.behavior.ui.utils.p;
import com.lynx.tasm.utils.j;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.gkfs.d f4921a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static h f4922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f4923c = null;
    public static final ReentrantReadWriteLock d = null;

    static {
        f4921a = new com.bytedance.gkfs.d();
        f4923c = new AtomicBoolean(false);
        d = new ReentrantReadWriteLock();
    }

    public static e a(com.bytedance.gkfs.io.c r17) {
        UtilsKt$traceTime$1$1 r10 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        if (f4923c.get() == true) goto L30;
        ReentrantReadWriteLock.ReadLock r13 = d.readLock();
        r13.lock();
        long r11 = ((Number) r10.invoke()).longValue();     // Catch: Throwable -> L8
        h r5 = f4922b;     // Catch: Throwable -> L8
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("indexing");     // Catch: Throwable -> L8
    L10:
        r5.getClass();     // Catch: Throwable -> L8
        UtilsKt$traceTime$1$1 r12 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());     // Catch: Throwable -> L8
        b r14 = r5.a(r17);     // Catch: Throwable -> L8
        if (r14 == null) goto L16;
        a r15 = r5.h(r17, r14.f4917c);     // Catch: Throwable -> L8
        if (r15 == null) goto L16;
        b r16 = b.a(r14, r17, null, r15, ((Number) r12.invoke()).longValue(), 6);     // Catch: Throwable -> L8
    L15:
        b r18 = r16;
        if (r18 == null) goto L26;
        com.bytedance.gkfs.io.a r19 = r18.f4917c;     // Catch: Throwable -> L8
        final a r20 = r18.e;     // Catch: Throwable -> L8
        com.bytedance.gkfs.io.a r21 = GkFSBlockBuffer.f4940j;     // Catch: Throwable -> L8
        final GkFSBlockBuffer r22 = p.f(r19);     // Catch: Throwable -> L8
        if (r22 == null) goto L24;
        e r110 = new e(r17, r22.f4949i, new GkFSChunkStorage$findChunk$1$1$1(r20, r22), r18, r11, 0, ((Number) r10.invoke()).longValue(), r20.f4914b);     // Catch: Throwable -> L8
        r13.unlock();
        return r110;
    L24:
        throw new IOException("Not exist block file for id " + r19);     // Catch: Throwable -> L8
    L26:
        throw new IOException("can not find located block for chunk " + r17.f4858a);     // Catch: Throwable -> L8
    L16:
        r16 = null;
    L8:
        th = move-exception;
        r13.unlock();
        throw th;
    L30:
        throw new IOException("can not read GkFS file in tidyUp");
    }

    public static g b() {
        UtilsKt$traceTime$1$1 r5 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        AtomicBoolean r10 = f4923c;
        if (r10.compareAndSet(false, true) == true) goto L177;
        return null;
    L177:
        LinkedHashMap r11 = new LinkedHashMap();     // Catch: Throwable -> L9
        h r12 = f4922b;     // Catch: Throwable -> L9
        String r13 = "indexing";
        if (r12 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("indexing");     // Catch: Throwable -> L9
    L11:
        com.bytedance.gkfs.io.a r14 = GkFSBlockBuffer.f4940j;     // Catch: Throwable -> L9
        Map r15 = r12.e(p.l());     // Catch: Throwable -> L9
        long r16 = ((Number) r5.invoke()).longValue();     // Catch: Throwable -> L9
        Iterator r17 = r15.entrySet().iterator();     // Catch: Throwable -> L9
        int r18 = 0;
        int r19 = 0;
        int r110 = 0;
        int r26 = 0;
        long r111 = 0;
        long r112 = 0;
        long r21 = 0;
    L12:
        if (r17.hasNext() == false) goto L154;
        Map.Entry r20 = (Map.Entry) r17.next();     // Catch: Throwable -> L151
        com.bytedance.gkfs.io.a r113 = (com.bytedance.gkfs.io.a) r20.getKey();     // Catch: Throwable -> L151
        Map r114 = (Map) r20.getValue();     // Catch: Throwable -> L151
        ArrayList r22 = new ArrayList();     // Catch: Throwable -> L151
        Iterator r27 = r114.values().iterator();     // Catch: Throwable -> L151
    L16:
        if (r27.hasNext() == false) goto L35;
        c r23 = (c) r27.next();     // Catch: Throwable -> L9
        int r24 = r23.f4918a.e.f4914b;     // Catch: Throwable -> L9
        r17 = r17;
        if (r23.f4920c == true) goto L16;
        long r30 = r16;
        r21 = r21 + ((long) r24);     // Catch: Throwable -> L9
        r26 = r26 + 1;     // Catch: Throwable -> L9
        if (r23.f4919b == false) goto L22;
        r19 = r19 + 1;     // Catch: Throwable -> L9
    L22:
        h r25 = f4922b;     // Catch: Throwable -> L9
        if (r25 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException(r13);     // Catch: Throwable -> L9
    L25:
        b r28 = r25.a(r23.f4918a.f4916b);     // Catch: Throwable -> L9
        if (r28 != null) goto L28;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L28:
        String[] r29 = r28.d;     // Catch: Throwable -> L9
        int r115 = r29.length;     // Catch: Throwable -> L9
        r110 = r110 + r115;     // Catch: Throwable -> L9
        r112 = r112 + ((long) (r24 * r115));     // Catch: Throwable -> L9
        int r31 = r29.length;     // Catch: Throwable -> L9
        int r116 = 0;
    L29:
        if (r116 >= r31) goto L31;
        String r117 = r29[r116];     // Catch: Throwable -> L9
        r11.put(r117, Long.valueOf(new File(r117).length()));     // Catch: Throwable -> L9
        r116 = r116 + 1;     // Catch: Throwable -> L9
        r31 = r31;
        goto L29
    L31:
        Unit r32 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r22.add(r23);     // Catch: Throwable -> L9
        r16 = r30;
        goto L16
    L35:
        r17 = r17;
        r16 = r16;
        int r33 = (((Map) r20.getValue()).size() - r22.size()) + r18;     // Catch: Throwable -> L151
        if (r22.isEmpty() == true) goto L38;
        if (r22.size() == r114.size()) goto L153;
        com.bytedance.gkfs.io.a r34 = GkFSBlockBuffer.f4940j;     // Catch: Throwable -> L151
        GkFSBlockBuffer r35 = p.f(r113);     // Catch: Throwable -> L151
        if (r35 == null) goto L153;
        File r36 = r35.f4949i;     // Catch: Throwable -> L151
        File r37 = new File(r36.getAbsolutePath() + "-backup");     // Catch: Throwable -> L151
        File r118 = new File(r36.getAbsolutePath() + "-rewriting");     // Catch: Throwable -> L151
        ArrayList r119 = new ArrayList();     // Catch: Throwable -> L151
        long r38 = System.currentTimeMillis();     // Catch: Throwable -> L151
        Iterator r120 = r22.iterator();     // Catch: Throwable -> L151
        int r210 = 0;
    L52:
        if (r120.hasNext() == false) goto L55;
        int r39 = r33;
        r210 = r210 + ((c) r120.next()).f4918a.e.f4914b;
        r33 = r39;
        goto L52
    L55:
        int r310 = r33;
        int r40 = f.f4929a;     // Catch: Throwable -> L151
        Lazy r121 = com.bytedance.gkfs.e.f4831a;     // Catch: Throwable -> L151
        int r122 = r210 / r40;     // Catch: Throwable -> L151
        if ((r210 % r40) != 0) goto L59;
        int r211 = 0;
    L60:
        int r123 = (r122 + r211) * r40;
        Result.Companion r212 = Result.Companion;     // Catch: Throwable -> L126
        cb.a r41 = new cb.a(r123);     // Catch: Throwable -> L126
        int r124 = r22.size();     // Catch: Throwable -> L126
        AtomicBoolean r311 = r10;
        int r213 = r19;
        int r42 = 0;
        int r125 = 0;
    L63:
        if (r125 >= r124) goto L94;
        int r312 = r124;
        c r126 = (c) r22.get(r125);     // Catch: Throwable -> L92
        Map r313 = r15;
        a r43 = r126.f4918a.e;     // Catch: Throwable -> L90
        UtilsKt$traceTime$1$1 r314 = r5;
        db.a r44 = new db.a(r43, r35);     // Catch: Throwable -> L87
        int r45 = r43.f4914b;     // Catch: Throwable -> L87
        r11 = r11;
        long r46 = r111;
        cb.a.d(j.b(r44, r45), r41, r42, 0, 12);     // Catch: Throwable -> L85
        b r47 = r126.f4918a;     // Catch: Throwable -> L85
        r22 = r22;
        b r48 = b.a(r47, null, null, new a(r45, r42), 0, 23);     // Catch: Throwable -> L75
        h r49 = f4922b;     // Catch: Throwable -> L75
        if (r49 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException(r13);     // Catch: Throwable -> L75
    L80:
        String r127 = r13;
        r49.g(r48.f4916b, r48.f4917c, r48.e);     // Catch: Throwable -> L83
        r119.add(r48);     // Catch: Throwable -> L83
        r42 = r42 + r45;
        r125 = r125 + 1;
        r22 = r22;
        r13 = r127;
        r15 = r313;
        r124 = r312;
        r5 = r314;
        r11 = r11;
        r111 = r46;
    L83:
        th = th;
    L77:
        boolean r50 = true;
    L78:
        Object r51 = null;
    L185:
        Result.Companion r52 = Result.Companion;     // Catch: Throwable -> L133
        Object r53 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
    L131:
        if (Result.m131isSuccessimpl(r53) == false) goto L135;
        ((Boolean) r53).getClass();     // Catch: Throwable -> L133
        com.bytedance.gkfs.d.c(f4921a, "GkFSChunkStorage", "tidy up block " + r113.f4853a + " success", 0, 12);     // Catch: Throwable -> L133
        Unit r54 = Unit.INSTANCE;     // Catch: Throwable -> L133
    L135:
        Throwable r55 = Result.m127exceptionOrNullimpl(r53);     // Catch: Throwable -> L133
        if (r55 == null) goto L150;
        r118.delete();     // Catch: Throwable -> L133
        if (r36.exists() == false) goto L140;
    L142:
        Iterator r56 = CollectionsKt.withIndex(r119).iterator();     // Catch: Throwable -> L133
    L144:
        if (r56.hasNext() == false) goto L149;
        b r57 = ((c) r22.get(((IndexedValue) r56.next()).getIndex())).f4918a;     // Catch: Throwable -> L133
        h r58 = f4922b;     // Catch: Throwable -> L133
        if (r58 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException(r127);     // Catch: Throwable -> L133
    L148:
        r58.g(r57.f4916b, r57.f4917c, r57.e);     // Catch: Throwable -> L133
        goto L144
    L149:
        com.bytedance.gkfs.d.d(f4921a, "GkFSChunkStorage", "tidy up block " + r113.f4853a + " failed, cause by:" + r55.getMessage(), null, false, 28);     // Catch: Throwable -> L133
        Unit r59 = Unit.INSTANCE;     // Catch: Throwable -> L133
        goto L150
    L140:
        if (r37.exists() == false) goto L142;
        r37.renameTo(r36);     // Catch: Throwable -> L133
    L150:
        r13 = r127;
        r19 = r213;
        r15 = r313;
        r5 = r314;
        r11 = r11;
        r111 = (System.currentTimeMillis() - r38) + r46;     // Catch: Throwable -> L133
        r18 = r310;
        r10 = r311;
    L133:
        th = th;
    L134:
        AtomicBoolean r60 = r311;
    L195:
        throw th;     // Catch: Throwable -> L170
    L170:
        th = move-exception;
        r60.set(false);
        throw th;
    L75:
        th = th;
    L76:
        r127 = r13;
    L85:
        th = th;
        r22 = r22;
    L87:
        th = th;
    L89:
        r46 = r111;
        r50 = true;
        r127 = r13;
    L90:
        th = th;
        r314 = r5;
    L92:
        th = th;
        r314 = r5;
        r313 = r15;
        goto L89
    L94:
        r314 = r5;
        r22 = r22;
        r11 = r11;
        r313 = r15;
        r46 = r111;
        r50 = true;
        r127 = r13;
        FileOutputStream r61 = new FileOutputStream(r118);     // Catch: Throwable -> L124
        Iterator r62 = r41.f1167b.iterator();     // Catch: Throwable -> L117
    L98:
        if (r62.hasNext() == false) goto L103;
        r61.write((byte[]) r62.next());     // Catch: Throwable -> L101
    L101:
        th = move-exception;
        Throwable r63 = th;
        r51 = null;
    L199:
        throw r63;     // Catch: Throwable -> L120
    L120:
        th = move-exception;
        CloseableKt.closeFinally(r61, r63);     // Catch: Throwable -> L111
        throw th;     // Catch: Throwable -> L111
    L111:
        th = th;
        goto L185
    L103:
        Unit r64 = Unit.INSTANCE;     // Catch: Throwable -> L117
        r51 = null;
        CloseableKt.closeFinally(r61, null);     // Catch: Throwable -> L111
        r35.close();     // Catch: Throwable -> L111
        if (r36.renameTo(r37) == false) goto L116;
        if (r118.renameTo(r36) == false) goto L114;
        r53 = Result.m124constructorimpl(Boolean.valueOf(r37.delete()));     // Catch: Throwable -> L111
        goto L131
    L114:
        throw new IOException("rename " + r118 + " to block file failed");     // Catch: Throwable -> L111
    L116:
        throw new IOException("rename " + r36 + " to backup failed");     // Catch: Throwable -> L111
    L117:
        th = move-exception;
        r51 = null;
        r63 = th;
    L124:
        th = th;
    L126:
        th = th;
        r311 = r10;
        r314 = r5;
        r22 = r22;
        r11 = r11;
        r313 = r15;
        r213 = r19;
        r46 = r111;
        r50 = true;
        r51 = null;
        r127 = r13;
        goto L185
    L59:
        r211 = 1;
    L153:
        r13 = r13;
        r19 = r19;
        r18 = r33;
        r10 = r10;
        r15 = r15;
        r5 = r5;
        r11 = r11;
        r111 = r111;
        goto L12
    L38:
        com.bytedance.gkfs.io.a r65 = GkFSBlockBuffer.f4940j;     // Catch: Throwable -> L9
        GkFSBlockBuffer r66 = p.o(r113);     // Catch: Throwable -> L9
        if (r66 == null) goto L41;
        r66.close();     // Catch: Throwable -> L9
        Unit r67 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L41:
        File r68 = p.r(r113);     // Catch: Throwable -> L9
        if (r68 == null) goto L153;
        r68.delete();     // Catch: Throwable -> L9
    L151:
        th = th;
        r311 = r10;
        goto L134
    L154:
        r311 = r10;
        UtilsKt$traceTime$1$1 r315 = r5;
        LinkedHashMap r316 = r11;
        Map r317 = r15;
        long r318 = r16;
        long r410 = r111;
        Iterator r69 = r316.values().iterator();     // Catch: Throwable -> L133
        long r70 = 0;
    L156:
        if (r69.hasNext() == false) goto L158;
        r70 = r70 + ((Number) r69.next()).longValue();     // Catch: Throwable -> L133
        goto L156
    L158:
        long r71 = ((Number) r315.invoke()).longValue();     // Catch: Throwable -> L133
        int r72 = r316.size();     // Catch: Throwable -> L133
        long r73 = (r70 - ((long) ((r110 * 46) + (r316.size() * 13)))) + r112;     // Catch: Throwable -> L133
        Iterator r74 = r317.keySet().iterator();     // Catch: Throwable -> L133
        long r75 = 0;
    L160:
        if (r74.hasNext() == false) goto L166;
        com.bytedance.gkfs.io.a r128 = (com.bytedance.gkfs.io.a) r74.next();     // Catch: Throwable -> L133
        com.bytedance.gkfs.io.a r129 = GkFSBlockBuffer.f4940j;     // Catch: Throwable -> L133
        File r130 = p.r(r128);     // Catch: Throwable -> L133
        if (r130 == null) goto L164;
        long r131 = r130.length();     // Catch: Throwable -> L133
    L165:
        r75 = r75 + r131;     // Catch: Throwable -> L133
        goto L160
    L164:
        r131 = 0;
        goto L165
    L166:
        g r76 = new g(r18, r19, r318, r410, r71, new i(r21, r73, r72, r26, r70 + r75));     // Catch: Throwable -> L133
        r311.set(false);
        return r76;
    L9:
        th = th;
        r60 = r10;
        goto L195
    }

    public static LinkedHashMap c(File r40, List r41) {
        UtilsKt$traceTime$1$1 r5 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        long r10 = ((Number) r5.invoke()).longValue();
        LinkedHashMap r14 = new LinkedHashMap();
        ArrayList r15 = new ArrayList();
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator r17 = r41.iterator();
    L4:
        if (r17.hasNext() == false) goto L102;
        com.bytedance.gkfs.cdc.a r11 = (com.bytedance.gkfs.cdc.a) r17.next();
        com.bytedance.gkfs.io.c r13 = r11.f4819a;
        h r16 = f4922b;
        if (r16 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("indexing");
    L8:
        b r18 = r16.a(r13);
        if (r18 == null) goto L101;
        h r19 = f4922b;
        if (r19 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("indexing");
    L13:
        com.bytedance.gkfs.io.a r20 = r18.f4917c;
        final a r21 = r19.h(r13, r20);
        com.bytedance.gkfs.d r110 = f4921a;
        if (r21 != null) goto L15;
        String r22 = "can not find block indexing for chunk " + r11.f4819a.f4858a;
        com.bytedance.gkfs.d.f(r110, "GkFSChunkStorage", r22, 0, 28);
        ArrayList r23 = r15;
        r23.add(r11);
        r12.put(r13, r18);
        ((Handler) com.bytedance.gkfs.c.f4815b.getValue()).post(new com.bytedance.apm.d(r22, 3));
    L100:
        r10 = r10;
        r15 = r23;
        goto L4
    L15:
        com.bytedance.gkfs.io.a r24 = GkFSBlockBuffer.f4940j;
        final GkFSBlockBuffer r111 = p.f(r20);
        LinkedHashMap r26 = r14;
        String r112 = r13.f4858a;
        if (r111 == null) goto L17;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L42
        String r27 = "null cannot be cast to non-null type kotlin.Array<T>";
        db.a r113 = new db.a(r21, r111);     // Catch: Throwable -> L40
        cb.a r28 = j.b(r113, r21.f4914b);     // Catch: Throwable -> L33
        r10 = r10;
        CloseableKt.closeFinally(r113, null);     // Catch: Throwable -> L29
        com.bytedance.gkfs.io.c r29 = new com.bytedance.gkfs.io.c(r28, r28.f1168c);     // Catch: Throwable -> L29
        if (Intrinsics.areEqual(r29, r13) == false) goto L32;
        Object r30 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L45:
        Throwable r31 = Result.m127exceptionOrNullimpl(r30);
        if (r31 == null) goto L75;
        String r32 = r31.getMessage();
        if (r32 != null) goto L51;
        r32 = "";
    L51:
        com.bytedance.gkfs.d.f(r110, "GkFSChunkStorage", r32, 0, 28);
        ReentrantReadWriteLock r33 = d;
        ReentrantReadWriteLock.ReadLock r34 = r33.readLock();
        if (r33.getWriteHoldCount() != 0) goto L54;
        int r114 = r33.getReadHoldCount();
    L55:
        int r115 = 0;
    L56:
        if (r115 >= r114) goto L58;
        r34.unlock();
        r115 = r115 + 1;
        goto L56
    L58:
        ReentrantReadWriteLock.WriteLock r35 = r33.writeLock();
        r35.lock();
        h r116 = f4922b;     // Catch: Throwable -> L62
        if (r116 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("indexing");     // Catch: Throwable -> L62
    L64:
        r116.f(r13, r20);     // Catch: Throwable -> L62
        Unit r36 = Unit.INSTANCE;     // Catch: Throwable -> L62
        int r37 = 0;
    L66:
        if (r37 >= r114) goto L68;
        r34.lock();
        r37 = r37 + 1;
        goto L66
    L68:
        r35.unlock();
        r15.add(r11);
        r12.put(r13, r18);
        ((Handler) com.bytedance.gkfs.c.f4815b.getValue()).post(new com.bytedance.apm.d(r32, 2));
        Unit r38 = Unit.INSTANCE;
    L62:
        th = move-exception;
        int r117 = 0;
    L70:
        if (r117 >= r114) goto L72;
        r34.lock();
        r117 = r117 + 1;
        goto L70
    L72:
        r35.unlock();
        throw th;
    L54:
        r114 = 0;
    L75:
        if (Result.m131isSuccessimpl(r30) == false) goto L97;
        Unit r39 = (Unit) r30;
        h r42 = f4922b;
        if (r42 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("indexing");
    L79:
        b r43 = r42.a(r13);
        if (r43 == null) goto L96;
        Set r44 = ArraysKt.toMutableSet(r43.d);
        r44.add(r40.getAbsolutePath());
        Object[] r45 = r44.toArray(new String[0]);
        if (r45 == null) goto L94;
        b r118 = b.a(r43, null, (String[]) r45, null, 0, 27);
        r42.c().storeStringJustDisk(r112, h.i(r118).toString());
        b r46 = r42.a(r13);
        if (r46 == null) goto L92;
        if (ArraysKt.contains(r46.d, r40.getAbsolutePath()) == false) goto L88;
        b r119 = r46;
    L89:
        if (r119 == null) goto L92;
        LinkedHashMap r120 = r26;
        r120.put(r13, new e(r13, r111.f4949i, new GkFSChunkStorage$addChunks$$inlined$traceTime$lambda$1(r21, r111), b.a(r118, null, null, r21, ((Number) r5.invoke()).longValue(), 7), r10, 0, ((Number) r5.invoke()).longValue(), r21.f4914b));
        Unit r47 = Unit.INSTANCE;
    L98:
        Result.m123boximpl(r30);
        r12 = r12;
        r14 = r120;
        r10 = r10;
        r15 = r15;
        goto L4
    L88:
        r119 = null;
    L92:
        throw new IOException(j0.C("can not insert reference of ", r112));
    L94:
        throw new TypeCastException(r27);
    L96:
        throw new IOException(j0.C("can not find origin indexing info for ", r112));
    L97:
        r120 = r26;
        goto L98
    L32:
        throw new IOException("content of chunk " + r112 + " in block " + r111.f4949i + " may broken, hash is " + r29.f4858a);     // Catch: Throwable -> L29
    L33:
        th = move-exception;
        r10 = r10;
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        CloseableKt.closeFinally(r113, th);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L29:
        th = th;
    L44:
        Result.Companion r48 = Result.Companion;
        r30 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L40:
        th = th;
        r10 = r10;
    L42:
        th = th;
        r10 = r10;
        r27 = "null cannot be cast to non-null type kotlin.Array<T>";
        goto L44
    L17:
        String r49 = "can not find block file " + r20.f4853a + " for chunk " + r112;
        com.bytedance.gkfs.d.f(r110, "GkFSChunkStorage", r49, 0, 28);
        h r50 = f4922b;
        if (r50 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("indexing");
    L20:
        r50.f(r13, r20);
        r15.add(r11);
        r12.put(r13, r18);
        ((Handler) com.bytedance.gkfs.c.f4815b.getValue()).post(new com.bytedance.apm.d(r49, 1));
        r14 = r26;
        goto L4
    L101:
        r23 = r15;
        r23.add(r11);
        goto L100
    L102:
        long r210 = r10;
        LinkedHashMap r51 = r12;
        String r52 = "null cannot be cast to non-null type kotlin.Array<T>";
        ArrayList r53 = r15;
        LinkedHashMap r121 = r14;
        Iterator r54 = r53.iterator();
        int r55 = 0;
    L104:
        if (r54.hasNext() == false) goto L106;
        r55 = r55 + ((com.bytedance.gkfs.cdc.a) r54.next()).f4821c.f1168c;
        goto L104
    L106:
        int r56 = f.f4929a;
        Lazy r57 = com.bytedance.gkfs.e.f4831a;
        int r58 = r55 / r56;
        if ((r55 % r56) != 0) goto L109;
        int r59 = 0;
    L110:
        int r60 = (r58 + r59) * r56;
        ReentrantReadWriteLock r61 = GkFSBlockBuffer.f4943m;
        ReentrantReadWriteLock.ReadLock r62 = r61.readLock();
        if (r61.getWriteHoldCount() != 0) goto L113;
        int r63 = r61.getReadHoldCount();
    L114:
        int r64 = 0;
    L115:
        if (r64 >= r63) goto L117;
        r62.unlock();
        r64 = r64 + 1;
        goto L115
    L117:
        ReentrantReadWriteLock.WriteLock r65 = r61.writeLock();
        r65.lock();
        com.bytedance.gkfs.io.a r66 = GkFSBlockBuffer.f4940j;     // Catch: Throwable -> L122
        if (r66 != null) goto L124;
        Intrinsics.throwUninitializedPropertyAccessException("maxBlockId");     // Catch: Throwable -> L122
    L124:
        int r67 = r66.f4853a;     // Catch: Throwable -> L122
        if (r67 < 0) goto L149;
        int r122 = 0;
    L128:
        com.bytedance.gkfs.io.a r123 = new com.bytedance.gkfs.io.a(r122);     // Catch: Throwable -> L122
        com.bytedance.gkfs.io.a r124 = GkFSBlockBuffer.f4940j;     // Catch: Throwable -> L122
        GkFSBlockBuffer r125 = p.f(r123);     // Catch: Throwable -> L122
        if (r125 == null) goto L130;
        ReentrantReadWriteLock.ReadLock r126 = r125.f4946b.readLock();     // Catch: Throwable -> L122
        r126.lock();     // Catch: Throwable -> L122
        LinkedHashMap r310 = r121;
        long r127 = r125.f4945a;     // Catch: Throwable -> L146
        r126.unlock();     // Catch: Throwable -> L122
        if ((8388608 - r127) >= r60) goto L143;
        if (r122 == r67) goto L150;
        r122 = r122 + 1;     // Catch: Throwable -> L122
        r121 = r310;
    L150:
        com.bytedance.gkfs.io.a r128 = GkFSBlockBuffer.f4940j;     // Catch: Throwable -> L122
        if (r128 != null) goto L153;
        Intrinsics.throwUninitializedPropertyAccessException("maxBlockId");     // Catch: Throwable -> L122
    L153:
        com.bytedance.gkfs.io.a r68 = new com.bytedance.gkfs.io.a(r128.f4853a + 1);     // Catch: Throwable -> L122
        File r69 = p.r(r68);     // Catch: Throwable -> L122
        if (r69 != null) goto L157;
        Intrinsics.throwNpe();     // Catch: Throwable -> L122
    L157:
        if (r69.createNewFile() == false) goto L222;
        GkFSBlockBuffer r129 = new GkFSBlockBuffer(r68, r69, r60);     // Catch: Throwable -> L122
        GkFSBlockBuffer.f4940j = r68;     // Catch: Throwable -> L122
        GkFSBlockBuffer.f4944n.put(r68, new db.c(r129));     // Catch: Throwable -> L122
        r125 = r129;
        goto L143
    L222:
        int r211 = 0;
    L225:
        th = th;
    L226:
        int r130 = r211;
    L227:
        if (r130 >= r63) goto L229;
        r62.lock();
        r130 = r130 + 1;
        goto L227
    L229:
        r65.unlock();
        throw th;
    L224:
        throw new IOException("can not create block file " + r69);     // Catch: Throwable -> L225
    L143:
        final GkFSBlockBuffer r131 = r125;
        int r70 = 0;
    L161:
        if (r70 >= r63) goto L163;
        r62.lock();
        r70 = r70 + 1;
        goto L161
    L163:
        r65.unlock();
        String r132 = r40.getAbsolutePath();
        final cb.a r133 = new cb.a(r60);
        ReentrantReadWriteLock.ReadLock r71 = r131.f4946b.readLock();
        r71.lock();
        long r134 = r131.f4945a;     // Catch: Throwable -> L219
        r71.unlock();
        Ref.IntRef r135 = new Ref.IntRef();
        r135.element = 0;
        Iterator r136 = r53.iterator();
    L167:
        if (r136.hasNext() == false) goto L205;
        com.bytedance.gkfs.cdc.a r72 = (com.bytedance.gkfs.cdc.a) r136.next();
        cb.a r73 = r72.f4821c;
        int r74 = r135.element;
        int r75 = r73.f1168c;
        r73.c(r133, r74, r75);
        com.bytedance.gkfs.io.c r76 = r72.f4819a;
        b r77 = (b) r51.get(r76);
        if (r77 == null) goto L179;
        String[] r78 = r77.d;
        if (r78 == null) goto L179;
        Set r79 = ArraysKt.toMutableSet(r78);
        if (r79 == null) goto L179;
        r79.add(r132);
        Unit r80 = Unit.INSTANCE;
        Object[] r81 = r79.toArray(new String[0]);
        if (r81 == null) goto L178;
        String[] r82 = (String[]) r81;
        boolean r137 = false;
    L180:
        a r83 = new a(r75, ((long) r135.element) + r134);
        long r311 = ((Number) r5.invoke()).longValue();
        com.bytedance.gkfs.io.a r84 = r131.f4948h;
        final b r85 = new b(r76, r84, r82, r83, r311);
        String r212 = r52;
        h r86 = f4922b;
        if (r86 != null) goto L183;
        Intrinsics.throwUninitializedPropertyAccessException("indexing");
    L183:
        r86.getClass();
        long r213 = r134;
        LinkedHashMap r312 = r51;
        UtilsKt$traceTime$1$1 r87 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        Keva r88 = r86.c();
        String r138 = r76.f4858a;
        String r89 = r88.getStringJustDisk(r138, null);
        Ref.IntRef r313 = r135;
        r86.c().storeStringJustDisk(r138, h.i(r85).toString());
        b r139 = r86.a(r76);
        if (r139 == null) goto L204;
        if (Intrinsics.areEqual(r139.f4917c, r84) == true) goto L188;
    L190:
        r139 = null;
    L191:
        if (r139 == null) goto L204;
        Result.Companion r90 = Result.Companion;     // Catch: Throwable -> L194
        r86.g(r76, r84, r83);     // Catch: Throwable -> L194
        Object r91 = Result.m124constructorimpl(r83);     // Catch: Throwable -> L194
    L196:
        Throwable r92 = Result.m127exceptionOrNullimpl(r91);
        if (r92 != null) goto L198;
        b.a(r85, null, null, null, ((Number) r87.invoke()).longValue(), 15);
        LinkedHashMap r314 = r310;
        r314.put(r76, new e(r76, r131.f4949i, new GkFSChunkStorage$$special$$inlined$forEach$lambda$1(r85, r133, r131), r85, r210, 0, ((Number) r5.invoke()).longValue(), r75));
        r313.element += r75;
        r135 = r313;
        r310 = r314;
        r132 = r132;
        r134 = r213;
        r52 = r212;
        r5 = r5;
        r133 = r133;
        r51 = r312;
        r131 = r131;
        goto L167
    L198:
        if (r89 != null) goto L200;
        r86.c().erase(r138);
    L201:
        throw r92;
    L200:
        r86.c().storeStringJustDisk(r138, r89);
    L194:
        th = move-exception;
        Result.Companion r93 = Result.Companion;
        r91 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L196
    L188:
        if (Arrays.equals(r139.d, r82) == false) goto L190;
    L204:
        throw new IOException(j0.C("can not insert or cover indexing of ", r138));
    L178:
        throw new TypeCastException(r52);
    L179:
        r137 = false;
        r82 = new String[]{r132};
        goto L180
    L205:
        cb.a r315 = r133;
        LinkedHashMap r94 = r310;
        db.b r95 = new db.b(r60, r131);
        r95.d.e(r315.f1168c);     // Catch: Throwable -> L210
        Iterator r96 = r315.f1167b.iterator();     // Catch: Throwable -> L210
    L208:
        if (r96.hasNext() == false) goto L212;
        r95.write((byte[]) r96.next());     // Catch: Throwable -> L210
        goto L208
    L212:
        Unit r97 = Unit.INSTANCE;     // Catch: Throwable -> L210
        CloseableKt.closeFinally(r95, null);
        return r94;
    L210:
        th = move-exception;
        throw th;     // Catch: Throwable -> L216
    L216:
        th = move-exception;
        CloseableKt.closeFinally(r95, th);
        throw th;
    L219:
        th = move-exception;
        r71.unlock();
        throw th;
    L146:
        th = move-exception;
        r126.unlock();     // Catch: Throwable -> L122
        throw th;     // Catch: Throwable -> L122
    L130:
        File r98 = p.r(r123);     // Catch: Throwable -> L122
        if (r98 != null) goto L134;
        Intrinsics.throwNpe();     // Catch: Throwable -> L122
    L134:
        if (r98.createNewFile() == false) goto L137;
        GkFSBlockBuffer r99 = new GkFSBlockBuffer(r123, r98, r60);     // Catch: Throwable -> L122
        GkFSBlockBuffer.f4944n.put(r123, new db.c(r99));     // Catch: Throwable -> L122
        r125 = r99;
        r310 = r121;
        goto L143
    L137:
        throw new IOException("can not create block file " + r98);     // Catch: Throwable -> L122
    L149:
        r310 = r121;
    L122:
        th = th;
        r211 = 0;
        goto L226
    L113:
        r63 = 0;
        goto L114
    L109:
        r59 = 1;
        goto L110
    }
}

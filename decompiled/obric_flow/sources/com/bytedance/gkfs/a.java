package com.bytedance.gkfs;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import com.bytedance.android.anniex.container.i;
import com.bytedance.gkfs.cdc.CDCWindow;
import com.bytedance.gkfs.io.GkFSError;
import com.bytedance.gkfs.io.f;
import com.bytedance.gkfs.io.g;
import com.bytedance.gkfs.io.j;
import com.bytedance.gkfs.io.k;
import com.bytedance.gkfs.io.l;
import com.bytedance.gkfs.io.m;
import com.bytedance.gkfs.io.n;
import com.bytedance.gkfs.io.o;
import com.bytedance.gkfs.storage.h;
import com.bytedance.gkfs.storage.io.GkFSBlockBuffer;
import com.google.common.reflect.w;
import com.lynx.tasm.behavior.ui.utils.p;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.UnsignedKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f4810a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bd.d f4811b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f4812c = null;
    public static final d d = null;

    static {
        f4810a = new String[]{".so", ".dex", ".gkfsf"};
        f4811b = new bd.d(2);
        f4812c = new AtomicBoolean(false);
        d = new d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v13 */
    /* JADX WARN: Type inference failed for: r21v14 */
    /* JADX WARN: Type inference failed for: r21v15 */
    /* JADX WARN: Type inference failed for: r21v16 */
    /* JADX WARN: Type inference failed for: r21v17 */
    /* JADX WARN: Type inference failed for: r21v18 */
    /* JADX WARN: Type inference failed for: r21v19 */
    /* JADX WARN: Type inference failed for: r21v20 */
    /* JADX WARN: Type inference failed for: r21v22, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r21v23 */
    /* JADX WARN: Type inference failed for: r21v24 */
    /* JADX WARN: Type inference failed for: r21v25 */
    /* JADX WARN: Type inference failed for: r21v26 */
    /* JADX WARN: Type inference failed for: r21v27 */
    /* JADX WARN: Type inference failed for: r21v28 */
    /* JADX WARN: Type inference failed for: r21v29 */
    /* JADX WARN: Type inference failed for: r21v30 */
    /* JADX WARN: Type inference failed for: r21v31 */
    /* JADX WARN: Type inference failed for: r21v32 */
    /* JADX WARN: Type inference failed for: r21v33 */
    /* JADX WARN: Type inference failed for: r21v34 */
    /* JADX WARN: Type inference failed for: r21v6 */
    /* JADX WARN: Type inference failed for: r21v9 */
    /* JADX WARN: Type inference failed for: r7v25, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v42 */
    /* JADX WARN: Type inference failed for: r9v40, types: [java.util.List] */
    public static final m a(File r50, File r51) {
        File r5 = r50;
        bd.d r10 = f4811b;
        r10.getClass();
        CDCWindow r11 = (CDCWindow) r10.f905a;
        if (r50.length() > 2048) goto L5;
        com.bytedance.gkfs.cdc.b r12 = new com.bytedance.gkfs.cdc.b(r5, CollectionsKt.emptyList(), new cb.a(0), new com.bytedance.gkfs.cdc.c(new n(false, new IllegalStateException("size " + r50.length() + " is less than 2048"), GkFSError.f4840c), 0, 62));
        File r13 = r5;
    L99:
        com.bytedance.gkfs.cdc.c r14 = r12.d;
        n r15 = r14.f4825a;
        if (r15.f4895a == true) goto L110;
        StringBuilder r16 = new StringBuilder("cdc error on ");
        r16.append(r51);
        r16.append(" transferring, cause ");
        Throwable r17 = r15.f4896b;
        if (r17 == null) goto L104;
        String r18 = r17.getMessage();
    L105:
        r16.append(r18);
        String r19 = r16.toString();
        if (r15.f4897c == GkFSError.f4840c) goto L108;
        boolean r110 = true;
    L109:
        d.d(d, "GeckoFileSystem", r19, null, r110, 12);
        return new m(new j(r51, new k(1, 0, 6), CollectionsKt.emptyList()), r13, r14, new l(null, 0, 0, null, 0, 0, 0, 255));
    L108:
        r110 = false;
        goto L109
    L104:
        r18 = null;
        goto L105
    L110:
        w r20 = new w(r13, r51, r12);
        boolean r21 = r50.exists();
        List r22 = r12.f4823b;
        if (r21 == true) goto L114;
        l r23 = new l(new n(false, new IOException("source file " + r13 + " not exists!"), GkFSError.f4842i), 0, 0, null, 0, 0, 0, 254);
        com.bytedance.gkfs.cdc.c r111 = r14;
        r51 = r51;
        ?? r24 = r22;
    L113:
        boolean r25 = true;
        boolean r26 = false;
        List r27 = null;
        ?? r28 = r24;
    L244:
        n r29 = r23.f4888c;
        if (r29.f4895a == true) goto L247;
    L248:
        com.bytedance.gkfs.cdc.c r30 = r111;
        ?? r31 = new StringBuilder("write error on ");
        r31.append(r51);
        r31.append(" transferring, write error=");
        Throwable r32 = r29.f4896b;
        if (r32 == null) goto L261;
        ?? r33 = r32.getMessage();
    L262:
        r31.append(r33);
        r31.append(", headerMeta is empty:");
        if (((k) r20.f9377c) == k.d) goto L266;
        r25 = r26;
    L266:
        r31.append(r25);
        d.d(d, "GeckoFileSystem", r31.toString(), null, false, 28);
        m r34 = new m(new j(r51, (k) r20.f9377c, CollectionsKt.emptyList()), r13, r30, r23);
    L351:
        return r34;
    L261:
        r33 = r27;
        goto L262
    L247:
        if (Intrinsics.areEqual((k) r20.f9377c, k.d) == true) goto L248;
        Iterable r35 = CollectionsKt.withIndex(r28);
        ArrayList r36 = new ArrayList(CollectionsKt.h(r35));
        Iterator r37 = r35.iterator();
    L251:
        if (r37.hasNext() == false) goto L256;
        IndexedValue r38 = (IndexedValue) r37.next();
        f r39 = new f(((com.bytedance.gkfs.cdc.a) r38.getValue()).f4819a, ((com.bytedance.gkfs.cdc.a) r38.getValue()).f4820b);
        Object r40 = r23.f.f4864c.get(((com.bytedance.gkfs.cdc.a) r38.getValue()).f4819a);
        if (r40 != null) goto L255;
        Intrinsics.throwNpe();
    L255:
        r36.add(new com.bytedance.gkfs.io.d(r39, (com.bytedance.gkfs.storage.e) r40));
        goto L251
    L256:
        r34 = new m(new j(r51, (k) r20.f9377c, r36), r13, r111, r23);
        goto L351
    L114:
        long r112 = System.currentTimeMillis();
        File r113 = new File(r51.getAbsolutePath() + "-tmp");
        if (r113.exists() == false) goto L117;
        r113.delete();
    L117:
        Ref.LongRef r114 = new Ref.LongRef();
        r114.element = 0;
        LinkedHashMap r115 = new LinkedHashMap();
        r111 = r14;
        UtilsKt$traceTime$1$1 r116 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());     // Catch: Throwable -> L206
        LinkedHashMap r41 = com.bytedance.gkfs.storage.d.c(r51, r22);     // Catch: Throwable -> L206
        r114.element = ((Number) r116.invoke()).longValue();     // Catch: Throwable -> L206
        r115.putAll(r41);     // Catch: Throwable -> L206
        ((Handler) c.f4815b.getValue()).post(new g(1, r41, r20));     // Catch: Throwable -> L206
        Unit r42 = Unit.INSTANCE;     // Catch: Throwable -> L206
        UtilsKt$traceTime$1$1 r117 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L161
        ArrayList r44 = new ArrayList(CollectionsKt.h(r22));     // Catch: Throwable -> L161
        Iterator r45 = r22.iterator();     // Catch: Throwable -> L161
        ?? r210 = r21;
    L123:
        if (r45.hasNext() == false) goto L142;
        com.bytedance.gkfs.cdc.a r118 = (com.bytedance.gkfs.cdc.a) r45.next();     // Catch: Throwable -> L140
        Iterator r211 = r45;
        Ref.LongRef r212 = r114;
        com.bytedance.gkfs.storage.e r119 = (com.bytedance.gkfs.storage.e) r115.get(r118.f4819a);     // Catch: Throwable -> L136
        if (r119 == null) goto L139;
        com.bytedance.gkfs.io.c r120 = r119.f4925b;     // Catch: Throwable -> L136
        if (r120 == null) goto L139;
        LinkedHashMap r213 = r115;
        r44.add(new f(r120, r118.f4820b));     // Catch: Throwable -> L134
        r45 = r211;
        r114 = r212;
        r115 = r213;
        r210 = r211;
    L134:
        th = th;
    L135:
        ?? r214 = r22;
    L163:
        Result.Companion r46 = Result.Companion;
        Object r47 = Result.m124constructorimpl(ResultKt.createFailure(th));
        List r48 = r22;
        ?? r215 = r214;
    L164:
        Throwable r49 = Result.m127exceptionOrNullimpl(r47);
        if (r49 == null) goto L167;
        l r52 = new l(new n(false, new IOException("Error occur writing header when transferring to .gkfsf file", r49), GkFSError.f), 0, 0, null, 0, 0, 0, 254);
        r113.delete();
        Unit r53 = Unit.INSTANCE;
        r51 = r51;
        r23 = r52;
        r24 = r215;
        goto L113
    L167:
        long r216 = ((Number) r117.invoke()).longValue();
        UtilsKt$traceTime$1$1 r54 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        cb.a r55 = r12.f4824c;
        int r56 = r55.f1168c;
        if (r56 != 0) goto L309;
        List r57 = null;
    L195:
        long r310 = ((Number) r54.invoke()).longValue();
        if (r50.exists() == true) goto L199;
        r113.delete();
        r23 = new l(new n(false, new IOException("source file " + r13 + " not exists!"), GkFSError.f4842i), 0, 0, null, 0, 0, 0, 254);
        List r58 = r57;
    L193:
        r25 = true;
        r26 = false;
        r27 = r58;
        r28 = r215;
        goto L244
    L199:
        if (r113.renameTo(r51) == true) goto L201;
        r113.delete();
        r23 = new l(new n(false, new IOException(r113 + " rename failed, parent dir exists:" + r51.getParentFile().exists() + ", target file exists:" + r51.exists()), GkFSError.f4843j), 0, 0, null, 0, 0, 0, 254);
        r58 = r57;
        goto L193
    L201:
        n r217 = n.d;
        long r59 = ((k) r20.f9377c).f4885c;
        LinkedHashMap r60 = new LinkedHashMap(MapsKt.mapCapacity(r213.size()));
        Iterator r61 = r213.entrySet().iterator();
    L203:
        if (r61.hasNext() == false) goto L205;
        r60.put(((Map.Entry) r61.next()).getKey(), Long.valueOf(r212.element / ((long) r213.size())));
        goto L203
    L205:
        r23 = new l(r217, r216, r59, new com.bytedance.gkfs.io.e(r60, r213), r310, r56, System.currentTimeMillis() - r112, 16);
        r58 = r57;
        goto L193
    L309:
        FileOutputStream r62 = new FileOutputStream(r113, true);     // Catch: Throwable -> L190
        Iterator r63 = r55.f1167b.iterator();     // Catch: Throwable -> L183
    L172:
        if (r63.hasNext() == false) goto L177;
        r62.write((byte[]) r63.next());     // Catch: Throwable -> L175
    L175:
        th = move-exception;
        Throwable r64 = th;
        r48 = null;
    L318:
        throw r64;     // Catch: Throwable -> L186
    L186:
        th = move-exception;
        CloseableKt.closeFinally(r62, r64);     // Catch: Throwable -> L181
        throw th;     // Catch: Throwable -> L181
    L177:
        Unit r65 = Unit.INSTANCE;     // Catch: Throwable -> L183
        r57 = null;
        CloseableKt.closeFinally(r62, null);     // Catch: Throwable -> L181
    L183:
        th = move-exception;
        r48 = null;
        r64 = th;
    L181:
        th = th;
    L192:
        StringBuilder r121 = new StringBuilder("Error occur when transfer ");
        r121.append(r13);
        r121.append(" to ");
        r51 = r51;
        r121.append(r51);
        r121.append(", cause ");
        l r66 = new l(new n(false, new IOException(androidx.room.jarjarred.org.antlr.runtime.a.x(th, r121), th), GkFSError.f4841h), 0, 0, null, 0, 0, 0, 254);
        r113.delete();
        Unit r67 = Unit.INSTANCE;
        r23 = r66;
        r58 = r48;
    L190:
        th = th;
        r48 = null;
    L139:
        throw new IllegalStateException("Can not find recorded chunk storage info for " + r118.f4819a);     // Catch: Throwable -> L134
    L136:
        th = th;
        r213 = r115;
    L140:
        th = th;
        r213 = r115;
        r212 = r114;
        goto L135
    L142:
        r213 = r115;
        r212 = r114;
        FileOutputStream r68 = new FileOutputStream(r113);     // Catch: Throwable -> L134
        o.d(r68, r50.length(), r44);     // Catch: Throwable -> L154
        Unit r69 = Unit.INSTANCE;     // Catch: Throwable -> L154
    L145:
        CloseableKt.closeFinally(r68, null);     // Catch: Throwable -> L134
        long r122 = (r22.size() * 44) + 15;
        r215 = r22;
        r48 = null;
        r20.f9377c = new k(0, r122, 3);     // Catch: Throwable -> L150
        if (r113.length() != ((k) r20.f9377c).f4885c) goto L153;
        r47 = Result.m124constructorimpl(r69);     // Catch: Throwable -> L150
        goto L164
    L153:
        throw new IOException("Except size is " + ((k) r20.f9377c).f4885c + ", but receive " + r113.length() + " after writing");     // Catch: Throwable -> L150
    L150:
        th = th;
        r214 = r210;
    L154:
        th = move-exception;
        r210 = r22;
        throw th;     // Catch: Throwable -> L157
    L157:
        th = move-exception;
        CloseableKt.closeFinally(r68, th);     // Catch: Throwable -> L150
        throw th;     // Catch: Throwable -> L150
    L161:
        th = th;
        r214 = r22;
        r213 = r115;
        r212 = r114;
    L206:
        th = th;
    L208:
        r27 = null;
        StringBuilder r70 = new StringBuilder("Error occur when transfer ");
        r70.append(r13);
        r70.append(" to ");
        r70.append(r51);
        r70.append(", cause ");
        r26 = false;
        r23 = new l(new n(false, new IOException(androidx.room.jarjarred.org.antlr.runtime.a.x(th, r70), th), GkFSError.g), 0, 0, null, 0, 0, 0, 254);
        r113.delete();
        Iterator r71 = r22.iterator();
    L213:
        if (r71.hasNext() == false) goto L243;
        com.bytedance.gkfs.cdc.a r72 = (com.bytedance.gkfs.cdc.a) r71.next();
        d r73 = com.bytedance.gkfs.storage.d.f4921a;
        com.bytedance.gkfs.io.c r74 = r72.f4819a;
        ReentrantReadWriteLock r75 = com.bytedance.gkfs.storage.d.d;
        ReentrantReadWriteLock.ReadLock r76 = r75.readLock();
        if (r75.getWriteHoldCount() != 0) goto L217;
        int r77 = r75.getReadHoldCount();
    L218:
        int r123 = 0;
    L219:
        if (r123 >= r77) goto L221;
        r76.unlock();
        r123 = r123 + 1;
        goto L219
    L221:
        ReentrantReadWriteLock.WriteLock r78 = r75.writeLock();
        r78.lock();
        h r124 = com.bytedance.gkfs.storage.d.f4922b;     // Catch: Throwable -> L225
        if (r124 != null) goto L227;
        Intrinsics.throwUninitializedPropertyAccessException("indexing");     // Catch: Throwable -> L225
    L227:
        com.bytedance.gkfs.storage.b r79 = r124.b(r74, r51);     // Catch: Throwable -> L225
        if (r79 != null) goto L229;
        int r80 = 0;
    L235:
        if (r80 >= r77) goto L237;
        r76.lock();
        r80 = r80 + 1;
        goto L235
    L237:
        r78.unlock();
        goto L213
    L229:
        ArraysKt.contains(r79.d, r51.getAbsolutePath());     // Catch: Throwable -> L225
        int r81 = 0;
    L231:
        if (r81 >= r77) goto L233;
        r76.lock();
        r81 = r81 + 1;
        goto L231
    L233:
        r78.unlock();
    L225:
        th = move-exception;
        int r125 = 0;
    L239:
        if (r125 >= r77) goto L241;
        r76.lock();
        r125 = r125 + 1;
        goto L239
    L241:
        r78.unlock();
        throw th;
    L217:
        r77 = 0;
        goto L218
    L243:
        r25 = true;
        Unit r82 = Unit.INSTANCE;
        r28 = r22;
    L209:
        th = th;
        r111 = r14;
        goto L208
    L5:
        ArrayList r83 = new ArrayList();
        LinkedHashMap r84 = new LinkedHashMap();
        LinkedHashMap r85 = new LinkedHashMap();
        long r126 = System.currentTimeMillis();
        cb.a r127 = new cb.a(32768);
        BufferedInputStream r128 = new BufferedInputStream(new FileInputStream(r5), 8192);     // Catch: Throwable -> L86
        long r129 = System.currentTimeMillis();     // Catch: Throwable -> L82
        Iterator r130 = CollectionsKt.H(ByteStreamsKt.iterator(r128));     // Catch: Throwable -> L84
        int r86 = 0;
        int r131 = 0;
        int r218 = 0;
    L10:
        long r219 = 0;
        int r220 = 0;
    L11:
        if (r130.hasNext() == false) goto L54;
        IndexedValue r221 = (IndexedValue) r130.next();     // Catch: Throwable -> L50
        byte r87 = ((Number) r221.getValue()).byteValue();     // Catch: Throwable -> L50
        int r132 = r221.getIndex() - r86;
        int r88 = r127.f1168c;
        if (r132 >= r88) goto L53;
        int r89 = r132 / 4096;     // Catch: Throwable -> L50
        bd.d r222 = r10;
        Iterator r223 = r130;
        ((byte[]) r127.f1167b.get(r89))[r132 - (r89 * 4096)] = r87;     // Catch: Throwable -> L50
        final long r90 = System.nanoTime();     // Catch: Throwable -> L50
        Function0<Long> r91 = new UtilsKt$traceTimePrecise$1$1(r90);     // Catch: Throwable -> L50
        long r92 = ULong.m298constructorimpl(r11.a(r87));     // Catch: Throwable -> L50
        r219 = r219 + ((Number) r91.invoke()).longValue();     // Catch: Throwable -> L50
        Unit r93 = Unit.INSTANCE;     // Catch: Throwable -> L50
        BufferedInputStream r94 = r128;
        long r224 = r126;
    L41:
        th = th;
        r13 = r50;
    L43:
        r128 = r94;
        long r225 = r219;
    L316:
        com.bytedance.gkfs.cdc.b r95 = new com.bytedance.gkfs.cdc.b(r13, CollectionsKt.emptyList(), new cb.a(0), new com.bytedance.gkfs.cdc.c(new n(false, th, GkFSError.d), System.currentTimeMillis() - r224, 30));     // Catch: Throwable -> L268
        Result.Companion r96 = Result.Companion;     // Catch: Throwable -> L92
        if (r128 == null) goto L94;
        r128.close();     // Catch: Throwable -> L92
        Unit r97 = Unit.INSTANCE;     // Catch: Throwable -> L92
    L95:
        Result.m124constructorimpl(r97);     // Catch: Throwable -> L92
    L98:
        r12 = r95;
        ?? r226 = r225;
        goto L99
    L94:
        r97 = null;
    L92:
        th = move-exception;
        Result.Companion r98 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    L268:
        th = move-exception;
        Result.Companion r99 = Result.Companion;     // Catch: Throwable -> L273
        if (r128 == null) goto L275;
        r128.close();     // Catch: Throwable -> L273
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L273
    L276:
        Result.m124constructorimpl(r100);     // Catch: Throwable -> L273
        throw th;
    L275:
        r100 = null;
    L273:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        throw th;
    L19:
        if (((int) UnsignedKt.m478ulongRemaindereb3DHEI(r92, ULong.m298constructorimpl(8192))) != 4) goto L22;
        boolean r102 = true;
    L23:
        int r133 = r132 + 1;     // Catch: Throwable -> L41
        if (r102 == false) goto L27;
        if (r133 >= 2048) goto L27;
        r131 = r131 + 1;     // Catch: Throwable -> L41
        int r134 = 32768;
    L30:
        if (r102 == false) goto L32;
        if (r133 < 2048) goto L32;
    L33:
        r11.c();     // Catch: Throwable -> L41
        if (r133 <= 0) goto L36;
        bd.d r103 = r222;
    L38:
        if (r103 == null) goto L48;
        com.bytedance.gkfs.io.c r135 = new com.bytedance.gkfs.io.c(r127, r133);     // Catch: Throwable -> L44
        cb.a r136 = new cb.a(r133);     // Catch: Throwable -> L44
        CDCWindow r311 = r11;
        cb.a.d(r127, r136, 0, r133, 6);     // Catch: Throwable -> L44
        r83.add(new com.bytedance.gkfs.cdc.a(r135, r86, r136));     // Catch: Throwable -> L41
        r84.put(r135, Long.valueOf(System.currentTimeMillis() - r129));     // Catch: Throwable -> L41
        r85.put(r135, Long.valueOf(r219));     // Catch: Throwable -> L41
        r86 = r221.getIndex() + 1;     // Catch: Throwable -> L41
        r129 = System.currentTimeMillis();     // Catch: Throwable -> L41
        r5 = r50;
        r128 = r94;
        r10 = r222;
        r130 = r223;
        r126 = r224;
        r11 = r311;
        goto L10
    L44:
        th = move-exception;
        throw new IllegalStateException("ComputeHash error:" + th.getMessage() + ",{chunkSize:" + r133 + ", currentPos:" + r221.getIndex() + ", chunkStartPos:" + r86 + ", posInChunk=" + r132 + '}');     // Catch: Throwable -> L41
    L48:
        throw new IllegalStateException("Divided chunk size is ZERO, {currentPos:" + r221.getIndex() + ", chunkStartPos:" + r86 + ", posInChunk=" + r132 + '}');     // Catch: Throwable -> L41
    L36:
        r103 = null;
    L32:
        if (r133 >= r134) goto L33;
        r5 = r50;
        r220 = r132;
        r10 = r222;
        r130 = r223;
        r126 = r224;
        r128 = r94;
        r219 = r219;
    L27:
        r134 = 32768;
        if (r133 != 32768) goto L30;
        r218 = r218 + 1;     // Catch: Throwable -> L41
        goto L30
    L22:
        r102 = false;
        goto L23
    L53:
        throw new IndexOutOfBoundsException("index " + r132 + " is larger than array size " + r88);     // Catch: Throwable -> L41
    L50:
        th = th;
        r224 = r126;
        r13 = r50;
        r225 = r219;
        goto L316
    L54:
        BufferedInputStream r104 = r128;
        LinkedHashMap r227 = r85;
        com.bytedance.gkfs.cdc.c r105 = new com.bytedance.gkfs.cdc.c(n.d, r131, r218, r227, r84, System.currentTimeMillis() - r126);     // Catch: Throwable -> L41
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L57
        r104.close();     // Catch: Throwable -> L57
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L57
    L60:
        if (r83.isEmpty() == false) goto L62;
        r13 = r50;
        r12 = new com.bytedance.gkfs.cdc.b(r13, CollectionsKt.emptyList(), new cb.a(0), new com.bytedance.gkfs.cdc.c(new n(false, new IOException("can not find break point and file size:" + r50.length() + " is less than 32768"), GkFSError.e), 0, 62));
        r226 = r227;
        goto L99
    L62:
        r13 = r50;
        if (r220 <= 0) goto L65;
        int r107 = r220 + 1;
        cb.a r108 = new cb.a(r107);
        cb.a.d(r127, r108, 0, r107, 6);
    L66:
        Iterator r109 = r83.iterator();
        int r137 = 0;
    L68:
        if (r109.hasNext() == false) goto L70;
        r137 = r137 + ((com.bytedance.gkfs.cdc.a) r109.next()).f4821c.f1168c;
        goto L68
    L70:
        int r138 = r108.f1168c;
        if ((r137 + r138) == ((int) r50.length())) goto L81;
        GkFSError r139 = GkFSError.d;
        StringBuilder r140 = new StringBuilder("size of ");
        Iterator r141 = r83.iterator();
        int r142 = 0;
    L74:
        if (r141.hasNext() == false) goto L76;
        r142 = r142 + ((com.bytedance.gkfs.cdc.a) r141.next()).f4821c.f1168c;
        goto L74
    L76:
        r140.append(r142 + r138);
        r140.append("=chunks(");
        ArrayList r143 = new ArrayList(CollectionsKt.h(r83));
        Iterator r144 = r83.iterator();
    L78:
        if (r144.hasNext() == false) goto L80;
        r143.add(Integer.valueOf(((com.bytedance.gkfs.cdc.a) r144.next()).f4821c.f1168c));
        goto L78
    L80:
        r226 = 0;
        r140.append(CollectionsKt.q(r143, null, null, null, 0, null, null, 63));
        r140.append(") + tail(");
        r140.append(r138);
        r140.append(") not equals to file size ");
        r140.append(r50.length());
        r12 = new com.bytedance.gkfs.cdc.b(r13, r83, r108, new com.bytedance.gkfs.cdc.c(new n(false, new IllegalStateException(r140.toString()), r139), 0, 62));
        goto L99
    L81:
        r12 = new com.bytedance.gkfs.cdc.b(r13, r83, r108, r105);
        r226 = r227;
        goto L99
    L65:
        r108 = new cb.a(0);
    L57:
        th = move-exception;
        Result.Companion r145 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    L84:
        th = th;
        r13 = r5;
        r94 = r128;
        r224 = r126;
    L82:
        th = th;
        r13 = r5;
        r224 = r126;
        r225 = r219;
    L86:
        th = th;
        r13 = r5;
        r224 = r126;
        r128 = null;
        goto L316
    }

    public static com.bytedance.gkfs.storage.g b() {
        boolean r5 = f4812c.get();
        d r10 = d;
        if (r5 == true) goto L7;
        d.f(r10, "GeckoFileSystem", "invoke tidyUp without init", 0, 28);
        return null;
    L7:
        if (((Boolean) e.f4832b.getValue()).booleanValue() == true) goto L10;
        d.c(r10, "GeckoFileSystem", "invoke tidyUp in sub-process, skip", 0, 4);
        return null;
    L10:
        d.c(r10, "GeckoFileSystem", "start tidy up GkFS storage", 0, 4);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L13
        Object r12 = Result.m124constructorimpl(com.bytedance.gkfs.storage.d.b());     // Catch: Throwable -> L13
    L15:
        Throwable r13 = Result.m127exceptionOrNullimpl(r12);
        if (r13 == null) goto L18;
        d.d(d, "GeckoFileSystem", "tidy up failed, cause by " + r13, r13, false, 20);
    L18:
        ResultKt.throwOnFailure(r12);
        return (com.bytedance.gkfs.storage.g) r12;
    L13:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static void c(Context r10) {
        int r5 = 3;
        int r11 = 0;
        if (f4812c.compareAndSet(false, true) == false) goto L31;
        d r12 = com.bytedance.gkfs.storage.d.f4921a;
        Context r13 = r10.getApplicationContext();
        if (r13 == null) goto L30;
        Application r14 = (Application) r13;
        com.bytedance.gkfs.io.a r15 = GkFSBlockBuffer.f4940j;
        File r16 = new File(r14.getFilesDir(), "gkfs_chunk");
        r16.mkdirs();
        GkFSBlockBuffer.f4942l = r16;
        File[] r17 = r16.listFiles(db.d.f16632a);
        if (r17.length != 0) goto L9;
        File r18 = null;
    L21:
        if (r18 == null) goto L23;
        com.bytedance.gkfs.io.a r19 = p.e(r18);
    L24:
        GkFSBlockBuffer.f4940j = r19;
        d r20 = com.bytedance.gkfs.storage.d.f4921a;
        new File(r14.getFilesDir(), "keva/repo");
        com.bytedance.gkfs.storage.d.f4922b = new h(r20);
        ThreadPoolExecutor r110 = c.f4814a;
        d r111 = new d();
    L25:
        if (r11 >= 3) goto L27;
        c.f4814a.execute(new i(r11, r5, r111));
        r11 = r11 + 1;
        goto L25
    L27:
        ArrayList r112 = com.bytedance.geckox.p.f4771a;
        com.bytedance.geckox.p.b(GeckoFileSystem$init$1.f4797a);
        return;
    L23:
        r19 = com.bytedance.gkfs.io.a.f4852b;
        goto L24
    L9:
        File r21 = r17[0];
        int r22 = ArraysKt.getLastIndex(r17);
        if (r22 == 0) goto L20;
        com.bytedance.gkfs.io.a r23 = p.e(r21);
        if (1 > r22) goto L20;
        int r24 = r23.f4853a;
        int r25 = 1;
    L15:
        File r26 = r17[r25];
        com.bytedance.gkfs.io.a r27 = GkFSBlockBuffer.f4940j;
        int r28 = p.e(r26).f4853a;
        if (r24 >= r28) goto L18;
        r21 = r26;
        r24 = r28;
    L18:
        if (r25 == r22) goto L20;
        r25 = r25 + 1;
    L20:
        r18 = r21;
        goto L21
    L30:
        throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
    }

    public static boolean d(File r5) {
        final Ref.BooleanRef r10 = new Ref.BooleanRef();
        r10.element = true;
        e.a(r5, new GeckoFileSystem$delete$1(r10));
        boolean r11 = r10.element;
        boolean r12 = r5.delete() & r11;
        r10.element = r12;
        return r12;
    }

    public static void e(File r14) {
        boolean r5 = ((Boolean) e.f4832b.getValue()).booleanValue();
        d r10 = d;
        if (r5 == true) goto L7;
        d.c(r10, "GeckoFileSystem", "invoke store in sub-process, skip", 0, 4);
        CollectionsKt.emptyList();
        return;
    L7:
        if (f4812c.get() == true) goto L11;
        d.f(r10, "GeckoFileSystem", "invoke store without init", 0, 28);
        CollectionsKt.emptyList();
        return;
    L11:
        if (r14.exists() == true) goto L14;
        f8.b.c(o.b(r14, new File(""), new IOException(r14 + " not exists"), GkFSError.g));
        CollectionsKt.emptyList();
        return;
    L14:
        Lazy r11 = e.f4831a;
        if (((Boolean) r11.getValue()).booleanValue() == false) goto L17;
        e.b("开始迁移" + r14 + " 到GkFS");
    L17:
        final ArrayList r12 = new ArrayList();
        e.a(r14, new GeckoFileSystem$store$1(r12));
        d.c(r10, "GeckoFileSystem", "finish storing " + r14, r10.f4829a.getAndIncrement(), 8);
        if (((Boolean) r11.getValue()).booleanValue() == false) goto L86;
        e.b("迁移GkFS完成:" + r14);
        StringBuilder r15 = new StringBuilder("chunk size:");
        Iterator r13 = r12.iterator();
        long r16 = 0;
        long r17 = 0;
    L21:
        if (r13.hasNext() == false) goto L27;
        Iterator r18 = ((m) r13.next()).f4892a.f4882c.iterator();
        long r19 = 0;
    L24:
        if (r18.hasNext() == false) goto L26;
        r19 = r19 + ((long) ((com.bytedance.gkfs.io.d) r18.next()).f4861c.f4928i);
        goto L24
    L26:
        r17 = r17 + r19;
        goto L21
    L27:
        r15.append(r17);
        r15.append("\ncdcCost:");
        Iterator r20 = r12.iterator();
        long r21 = 0;
    L29:
        if (r20.hasNext() == false) goto L35;
        Iterator r22 = ((m) r20.next()).f4894c.d.values().iterator();
        long r110 = 0;
    L32:
        if (r22.hasNext() == false) goto L34;
        r110 = r110 + ((Number) r22.next()).longValue();
        goto L32
    L34:
        r21 = r21 + r110;
        goto L29
    L35:
        r15.append(r21);
        r15.append("\ncdcTotalCost:");
        Iterator r23 = r12.iterator();
        long r24 = 0;
    L37:
        if (r23.hasNext() == false) goto L39;
        r24 = r24 + ((m) r23.next()).f4894c.f;
        goto L37
    L39:
        r15.append(r24);
        r15.append("\ntotalSize:");
        ArrayList r25 = new ArrayList();
        Iterator r26 = r12.iterator();
    L41:
        if (r26.hasNext() == false) goto L47;
        Object r27 = r26.next();
        m r28 = (m) r27;
        if (r28.f4894c.f4825a.f4895a == false) goto L41;
        if (r28.d.f4888c.f4895a == false) goto L41;
        r25.add(r27);
        goto L41
    L47:
        Iterator r29 = r25.iterator();
        long r30 = 0;
    L49:
        if (r29.hasNext() == false) goto L51;
        r30 = r30 + ((m) r29.next()).d.f4887b;
        goto L49
    L51:
        r15.append(r30);
        r15.append("\ntotalTimeCost:");
        ArrayList r31 = new ArrayList();
        Iterator r32 = r12.iterator();
    L53:
        if (r32.hasNext() == false) goto L59;
        Object r33 = r32.next();
        m r34 = (m) r33;
        if (r34.f4894c.f4825a.f4895a == false) goto L53;
        if (r34.d.f4888c.f4895a == false) goto L53;
        r31.add(r33);
        goto L53
    L59:
        Iterator r35 = r31.iterator();
    L61:
        if (r35.hasNext() == false) goto L63;
        r16 = r16 + ((m) r35.next()).d.f4891j;
        goto L61
    L63:
        r15.append(r16);
        d.c(r10, "GeckoFileSystem", td.d.b("performance=", r15.toString()), 0, 12);
        return;
    }
}

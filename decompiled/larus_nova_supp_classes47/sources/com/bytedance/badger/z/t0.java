package com.bytedance.badger.z;

import android.content.Context;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataString;
import com.bytedance.badger.module.BadgerModuleBase;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t0 extends u0 {
    public t0() {
    }

    public static byte[] c(ByteBuffer r7, int r8, int r9, Inflater r10, byte[] r12, byte[] r13, int r14) {
        if (r14 > 0) goto L5;
        return null;
    L5:
        if (r8 >= 0) goto L7;
    L50:
        return null;
    L7:
        if ((r8 + 30) > r7.limit()) goto L50;
        if (r7.getInt(r8) == 67324752) goto L12;
        return null;
    L12:
        long r3 = ((((long) r8) + 30) + ((long) (r7.getShort(r8 + 26) & 65535))) + ((long) (65535 & r7.getShort(r8 + 28)));
        if (r3 <= r7.limit()) goto L15;
        return null;
    L15:
        int r15 = (int) r3;
        if (r9 != 0) goto L23;
        int r16 = r15 + 12;
        if ((r16 + 20) <= r7.limit()) goto L20;
        return null;
    L20:
        r7.position(r16);
        byte[] r17 = new byte[20];
        r7.get(r17);
        return r17;
    L23:
        if (r9 == 8) goto L26;
        return null;
    L26:
        if (r14 <= (r7.limit() - r15)) goto L28;
        return null;
    L28:
        r10.reset();
        int r2 = 0;
    L30:
        if (r14 <= 0) goto L46;
        if (r2 >= 32) goto L46;
        int r4 = Math.min(r14, r12.length);     // Catch: DataFormatException -> L43
        if (r4 <= 0) goto L34;
        r7.position(r15);     // Catch: DataFormatException -> L43
        r7.get(r12, 0, r4);     // Catch: DataFormatException -> L43
        r10.setInput(r12, 0, r4);     // Catch: DataFormatException -> L43
        r15 = r15 + r4;     // Catch: DataFormatException -> L43
        r14 = r14 - r4;     // Catch: DataFormatException -> L43
    L37:
        if (r10.needsInput() == true) goto L30;
        if (r2 >= 32) goto L30;
        int r5 = r10.inflate(r13, r2, 32 - r2);     // Catch: DataFormatException -> L43
        if (r5 == 0) goto L30;
        r2 = r2 + r5;
        goto L37
    L34:
        return null;
    L43:
        e = move-exception;
        com.bytedance.badger.e.c("AppUUIDProvider", "Failed to inflate due to data format error.", e);
        return null;
    L46:
        if (r2 >= 32) goto L49;
        return null;
    L49:
        return ArraysKt.copyOfRange(r13, 12, 32);
    }

    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v25 */
    public static String d(Context r24) {
        String r0 = r24.getPackageCodePath();
        ?? r1 = 0;
        if (r0 == null) goto L106;
        PolarisFileWrapper r2 = new PolarisFileWrapper(r0);
        if (r2.exists() == true) goto L7;
        return null;
    L7:
        ArrayList r3 = new ArrayList(4);
        RandomAccessFile r4 = new RandomAccessFile(r2, "r");
        FileChannel r6 = r4.getChannel();     // Catch: Throwable -> L99
        MappedByteBuffer r5 = r6.map(FileChannel.MapMode.READ_ONLY, 0, r6.size());     // Catch: Throwable -> L99
        r5.order(ByteOrder.LITTLE_ENDIAN);     // Catch: Throwable -> L99
        int r7 = r5.limit() - 65557;     // Catch: Throwable -> L99
        if (r7 >= 0) goto L11;
        r7 = 0;
    L11:
        int r8 = r5.limit() - 22;     // Catch: Throwable -> L99
        if (r8 >= r7) goto L14;
    L18:
        Integer r9 = null;
    L19:
        if (r9 == null) goto L97;
        int r10 = r9.intValue();     // Catch: Throwable -> L99
        int r12 = r5.getInt(r10 + 16);     // Catch: Throwable -> L99
        int r13 = 10;
        short r14 = 65535;
        int r15 = r5.getShort(r10 + 10) & 65535;     // Catch: Throwable -> L99
        Ref.IntRef r16 = new Ref.IntRef();     // Catch: Throwable -> L99
        r16.element = r12;     // Catch: Throwable -> L99
        byte[] r17 = new byte[128];     // Catch: Throwable -> L99
        Inflater r18 = new Inflater(true);     // Catch: Throwable -> L99
        byte[] r19 = new byte[4096];     // Catch: Throwable -> L99
        int r110 = 32;
        byte[] r20 = new byte[32];     // Catch: Throwable -> L99
        int r22 = 0;
    L22:
        if (r22 >= r15) goto L79;
        if ((r16.element + 46) > r5.limit()) goto L25;
        if (r5.getInt(r16.element) != 33639248) goto L31;
        int r111 = r5.getShort(r16.element + r13) & r14;     // Catch: Throwable -> L75
        int r23 = r5.getShort(r16.element + 28) & r14;     // Catch: Throwable -> L75
        int r25 = r5.getShort(r16.element + 30) & r14;     // Catch: Throwable -> L75
        int r26 = r5.getShort(r16.element + r110) & r14;     // Catch: Throwable -> L75
        int r112 = r5.getInt(r16.element + 20);     // Catch: Throwable -> L75
        int r27 = r5.getInt(r16.element + 42);     // Catch: Throwable -> L75
        byte[] r28 = r17;
        int r29 = r15;
        int r210 = r22;
        long r30 = ((long) r26) + (((((long) r16.element) + 46) + ((long) r23)) + ((long) r25));     // Catch: Throwable -> L75
        if (r30 > r5.limit()) goto L37;
        if (r23 <= 128) goto L43;
        byte[] r32 = new byte[r23];     // Catch: Throwable -> L75
    L44:
        r5.position(r16.element + 46);     // Catch: Throwable -> L75
        r5.get(r32, 0, r23);     // Catch: Throwable -> L75
        if (r23 >= 4) goto L48;
    L57:
        boolean r33 = false;
    L58:
        if (r33 == false) goto L70;
        if (r112 <= 0) goto L70;
        byte[] r113 = r19;
        Inflater r211 = r18;
        byte[] r114 = c(r5, r27, r111, r18, r113, r20, r112);     // Catch: Throwable -> L73
        if (r114 == null) goto L64;
        r3.add(r114);     // Catch: Throwable -> L73
    L71:
        r16.element = (int) r30;     // Catch: Throwable -> L73
        r22 = r210 + 1;
        r19 = r113;
        r17 = r28;
        r15 = r29;
        r18 = r211;
        r1 = 0;
        r13 = 10;
        r14 = 65535;
        r110 = 32;
        goto L22
    L64:
        com.bytedance.badger.e.e("AppUUIDProvider", "read  failed : " + new String(r32, 0, r23, Charsets.UTF_8));     // Catch: Throwable -> L73
        r211.end();     // Catch: Throwable -> L99
        CloseableKt.closeFinally(r4, null);
        return null;
    L73:
        th = th;
    L77:
        r211.end();     // Catch: Throwable -> L99
        throw th;     // Catch: Throwable -> L99
    L70:
        r113 = r19;
        r211 = r18;
        goto L71
    L48:
        if (r32[r23 - 4] != ((byte) 46)) goto L57;
        if (r32[r23 - 3] != ((byte) 100)) goto L57;
        if (r32[r23 - 2] != ((byte) 101)) goto L57;
        if (r32[r23 - 1] != ((byte) 120)) goto L57;
        r33 = true;
        goto L58
    L43:
        r32 = r28;
        goto L44
    L37:
        r18.end();     // Catch: Throwable -> L99
        CloseableKt.closeFinally(r4, null);
        return null;
    L31:
        r18.end();     // Catch: Throwable -> L99
        CloseableKt.closeFinally(r4, r1);
        return r1;
    L25:
        r18.end();     // Catch: Throwable -> L99
        CloseableKt.closeFinally(r4, r1);
        return r1;
    L75:
        th = th;
        r211 = r18;
        goto L77
    L79:
        r18.end();     // Catch: Throwable -> L99
        CloseableKt.closeFinally(r4, null);
        if (r3.isEmpty() == false) goto L83;
        return null;
    L83:
        ArrayList r34 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r35 = r3.iterator();
    L85:
        if (r35.hasNext() == false) goto L87;
        byte[] r36 = (byte[]) r35.next();
        r34.add(TuplesKt.to(ArraysKt.joinToString$default(r36, "", null, null, 0, null, h.a, 30, null), r36));
        goto L85
    L87:
        List r37 = CollectionsKt.sortedWith(r34, new s0());
        ArrayList r38 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r37, 10));
        Iterator r39 = r37.iterator();
    L89:
        if (r39.hasNext() == false) goto L91;
        r38.add((byte[]) ((Pair) r39.next()).component2());
        goto L89
    L91:
        MessageDigest r40 = MessageDigest.getInstance("MD5");
        Iterator r42 = r38.iterator();
    L93:
        if (r42.hasNext() == false) goto L96;
        r40.update((byte[]) r42.next());
        goto L93
    L96:
        return ArraysKt.joinToString$default(r40.digest(), "", null, null, 0, null, g.a, 30, null);
    L97:
        CloseableKt.closeFinally(r4, null);
        return null;
    L14:
        if (r5.getInt(r8) == 101010256) goto L15;
        if (r8 == r7) goto L18;
        r8 = r8 - 1;     // Catch: Throwable -> L99
        goto L14
    L15:
        r9 = Integer.valueOf(r8);     // Catch: Throwable -> L99
    L99:
        th = move-exception;
        throw th;     // Catch: Throwable -> L102
    L102:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L106:
        return null;
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r19, BadgerModuleBase.BadgerRequestData r20) {
        long r1 = System.currentTimeMillis();
        com.bytedance.badger.v.d.f0.getClass();
        com.bytedance.badger.v.f r0 = com.bytedance.badger.v.d.M;
        KProperty r3 = com.bytedance.badger.v.d.a[39];
        boolean r4 = false;
        String r5 = null;
        if (((Boolean) r0.a()).booleanValue() == true) goto L83;
    L10:
        PolarisFileWrapper r6 = new PolarisFileWrapper(r19.getPackageCodePath());
        if (r6.exists() == false) goto L64;
        PolarisZipFileWrapper r7 = new PolarisZipFileWrapper(r6);
        ArrayList r2 = Collections.list(r7.entries());     // Catch: Throwable -> L75
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L75
        Iterator r9 = r2.iterator();     // Catch: Throwable -> L75
    L16:
        if (r9.hasNext() == false) goto L20;
        Object r10 = r9.next();     // Catch: Throwable -> L75
        if (StringsKt.endsWith$default(((ZipEntry) r10).getName(), ".dex", false, 2, null) == false) goto L16;
        r8.add(r10);     // Catch: Throwable -> L75
        goto L16
    L20:
        List r12 = CollectionsKt.sortedWith(r8, new m0());     // Catch: Throwable -> L75
        if (r12.isEmpty() == true) goto L63;
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L75
        Iterator r14 = r12.iterator();     // Catch: Throwable -> L75
    L25:
        if (r14.hasNext() == false) goto L45;
        InputStream r15 = r7.getInputStream((ZipEntry) r14.next());     // Catch: Throwable -> L75
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Throwable -> L75
        throw th;     // Catch: Throwable -> L75
    L29:
        if (r15.skip(12) < 12) goto L33;
        byte[] r16 = new byte[20];     // Catch: Throwable -> L38
        if (r15.read(r16) != 20) goto L33;
        r13.add(r16);     // Catch: Throwable -> L38
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L75
        goto L25
    L33:
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L75
        goto L63
    L45:
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));     // Catch: Throwable -> L75
        Iterator r18 = r13.iterator();     // Catch: Throwable -> L75
    L47:
        if (r18.hasNext() == false) goto L51;
        byte[] r22 = (byte[]) r18.next();     // Catch: Throwable -> L75
        r17.add(TuplesKt.to(ArraysKt.joinToString$default(r22, "", null, null, 0, null, e.a, 30, null), r22));     // Catch: Throwable -> L75
        goto L47
    L51:
        List r23 = CollectionsKt.sortedWith(r17, new o0());     // Catch: Throwable -> L75
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));     // Catch: Throwable -> L75
        Iterator r25 = r23.iterator();     // Catch: Throwable -> L75
    L53:
        if (r25.hasNext() == false) goto L55;
        r24.add((byte[]) ((Pair) r25.next()).component2());     // Catch: Throwable -> L75
        goto L53
    L55:
        MessageDigest r26 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L75
        Iterator r27 = r24.iterator();     // Catch: Throwable -> L75
    L57:
        if (r27.hasNext() == false) goto L62;
        r26.update((byte[]) r27.next());     // Catch: Throwable -> L75
        goto L57
    L62:
        r5 = ArraysKt.joinToString$default(r26.digest(), "", null, null, 0, null, d.a, 30, null);     // Catch: Throwable -> L75
    L63:
        r7.close();
    L75:
        th = move-exception;
        r7.close();
        throw th;
    L64:
        String r28 = r5;
    L65:
        com.bytedance.badger.e.f("AppUUIDProvider", "cost " + (System.currentTimeMillis() - r1));
        if (r28 == null) goto L74;
        if (r28.length() <= 0) goto L70;
        r4 = true;
    L70:
        if (r4 != true) goto L74;
        return new BadgerResult.Success(new DataString(r28));
    L74:
        return new BadgerResult.Failure(BadgerResult.ERROR, "uuid is null");
    L83:
        r28 = d(r19);     // Catch: Exception -> L6
    L8:
        if (r28 == null) goto L10;
    L6:
        e = move-exception;
        com.bytedance.badger.e.c("AppUUIDProvider", "fast failed", e);
        r28 = null;
        goto L8
    }
}

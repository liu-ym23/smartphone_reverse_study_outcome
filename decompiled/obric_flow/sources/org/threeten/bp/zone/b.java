package org.threeten.bp.zone;

import ai.j0;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final CopyOnWriteArrayList d = null;
    public static final ConcurrentHashMap e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f21299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentSkipListMap f21300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArraySet f21301c;

    static {
        d = new CopyOnWriteArrayList();
        e = new ConcurrentHashMap(512, 0.75f, 2);
        if (e.f21303a.getAndSet(true) == true) goto L27;
        AtomicReference r5 = e.f21304b;
        e r10 = new e();
    L6:
        if (r5.compareAndSet(null, r10) == true) goto L10;
        if (r5.get() == null) goto L6;
    L10:
        ((e) r5.get()).getClass();
        Iterator r11 = Arrays.asList(new b[]{new b()}).iterator();     // Catch: Throwable -> L23
    L13:
        if (r11.hasNext() == false) goto L22;
        c((b) r11.next());     // Catch: ServiceConfigurationError -> L17
    L17:
        e = move-exception;
        if ((e.getCause() instanceof SecurityException) == true) goto L13;
        throw e;
    L22:
        return;
    L23:
        th = move-exception;
        throw new ServiceConfigurationError(th.getMessage(), th);
    L27:
        throw new IllegalStateException("Already initialized");
    }

    public b() {
        this.f21300b = new ConcurrentSkipListMap();
        this.f21301c = new CopyOnWriteArraySet();
        Object r5 = null;
        InputStream r10 = null;
        Enumeration<URL> r11 = b.class.getClassLoader().getResources("org/threeten/bp/TZDB.dat");     // Catch: Exception -> L30
        Object r12 = null;
        boolean r13 = false;
    L35:
    L24:
        e = e;
        r5 = r12;
    L32:
        throw new ZoneRulesException("Unable to load TZDB time-zone rules: " + r5, e);
    L6:
        if (r11.hasMoreElements() == false) goto L26;
        URL r14 = r11.nextElement();     // Catch: Exception -> L24
    L22:
        e = e;
        r5 = r14;
        goto L32
    L9:
        if (this.f21301c.add(r14.toExternalForm()) == true) goto L37;
        boolean r15 = false;
    L21:
        r13 = r13 | r15;
        r12 = r14;
        goto L35
    L37:
        InputStream r16 = r14.openStream();     // Catch: Throwable -> L16
        r15 = b(r16);     // Catch: Throwable -> L14
        if (r16 == null) goto L21;
        r16.close();     // Catch: Exception -> L22
    L14:
        th = th;
        r10 = r16;
    L17:
        if (r10 == null) goto L19;
        r10.close();     // Catch: Exception -> L22
    L19:
        throw th;     // Catch: Exception -> L22
    L16:
        th = th;
        goto L17
    L26:
        if (r13 == false) goto L29;
        return;
    L29:
        throw new ZoneRulesException("No time-zone rules found for 'TZDB'");
    L30:
        e = e;
        goto L32
    }

    public static d a(String r5, boolean r10) {
        jm.c.p(r5, "zoneId");
        ConcurrentHashMap r11 = e;
        b r12 = (b) r11.get(r5);
        if (r12 == null) goto L5;
        r12.getClass();
        jm.c.p(r5, "zoneId");
        a r13 = (a) r12.f21300b.lastEntry().getValue();
        int r14 = Arrays.binarySearch(r13.f21297b, r5);
        if (r14 >= 0) goto L25;
        d r15 = null;
    L18:
        if (r15 == null) goto L21;
        return r15;
    L21:
        throw new ZoneRulesException("Unknown time-zone ID: ".concat(r5));
    L25:
        short r16 = r13.f21298c[r14];     // Catch: Exception -> L22
        AtomicReferenceArray r17 = r13.d;     // Catch: Exception -> L22
        Object r18 = r17.get(r16);     // Catch: Exception -> L22
        if ((r18 instanceof byte[]) == false) goto L16;
        r18 = Ser.read(new DataInputStream(new ByteArrayInputStream((byte[]) r18)));     // Catch: Exception -> L22
        r17.set(r16, r18);     // Catch: Exception -> L22
    L16:
        r15 = (d) r18;     // Catch: Exception -> L22
    L22:
        e = move-exception;
        StringBuilder r19 = j0.x("Invalid binary time-zone data: TZDB:", r5, ", version: ");
        r19.append(r13.f21296a);
        throw new ZoneRulesException(r19.toString(), e);
    L5:
        if (r11.isEmpty() == false) goto L9;
        throw new ZoneRulesException("No time-zone data files registered");
    L9:
        throw new ZoneRulesException("Unknown time-zone ID: ".concat(r5));
    }

    public static void c(b r5) {
        jm.c.p(r5, "provider");
        r5.getClass();
        Iterator r10 = new HashSet(r5.f21299a).iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        String r11 = (String) r10.next();
        jm.c.p(r11, "zoneId");
        if (((b) e.putIfAbsent(r11, r5)) == null) goto L4;
        throw new ZoneRulesException("Unable to register zone as one already registered with that ID: " + r11 + ", currently loading from provider: " + r5);
    L10:
        d.add(r5);
    }

    public final boolean b(InputStream r14) {
        DataInputStream r5 = new DataInputStream(r14);
        if (r5.readByte() != 1) goto L36;
        if ("TZDB".equals(r5.readUTF()) == false) goto L34;
        int r15 = r5.readShort();
        String[] r10 = new String[r15];
        boolean r11 = false;
        int r12 = 0;
    L7:
        if (r12 >= r15) goto L9;
        r10[r12] = r5.readUTF();
        r12 = r12 + 1;
        goto L7
    L9:
        int r13 = r5.readShort();
        String[] r16 = new String[r13];
        int r17 = 0;
    L10:
        if (r17 >= r13) goto L12;
        r16[r17] = r5.readUTF();
        r17 = r17 + 1;
        goto L10
    L12:
        this.f21299a = Arrays.asList(r16);
        int r18 = r5.readShort();
        Object[] r19 = new Object[r18];
        int r20 = 0;
    L13:
        if (r20 >= r18) goto L15;
        byte[] r21 = new byte[r5.readShort()];
        r5.readFully(r21);
        r19[r20] = r21;
        r20 = r20 + 1;
        goto L13
    L15:
        AtomicReferenceArray r22 = new AtomicReferenceArray(r19);
        HashSet r23 = new HashSet(r15);
        int r24 = 0;
    L16:
        if (r24 >= r15) goto L21;
        int r25 = r5.readShort();
        String[] r26 = new String[r25];
        short[] r110 = new short[r25];
        int r111 = 0;
    L18:
        if (r111 >= r25) goto L20;
        r26[r111] = r16[r5.readShort()];
        r110[r111] = r5.readShort();
        r111 = r111 + 1;
        goto L18
    L20:
        r23.add(new a(r10[r24], r26, r110, r22));
        r24 = r24 + 1;
        goto L16
    L21:
        Iterator r112 = r23.iterator();
    L23:
        if (r112.hasNext() == false) goto L32;
        a r27 = (a) r112.next();
        a r28 = (a) this.f21300b.putIfAbsent(r27.f21296a, r27);
        if (r28 == null) goto L31;
        String r29 = r28.f21296a;
        String r30 = r27.f21296a;
        if (r29.equals(r30) == true) goto L31;
        throw new ZoneRulesException(j0.C("Data already loaded for TZDB time-zone rules version: ", r30));
    L31:
        r11 = true;
        goto L23
    L32:
        return r11;
    L34:
        throw new StreamCorruptedException("File format not recognised");
    L36:
        throw new StreamCorruptedException("File format not recognised");
    }

    public final String toString() {
        return "TZDB";
    }
}

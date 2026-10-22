package com.bytedance.memory.upload;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class c {

    static class a implements Callable<C0065c> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f2214c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ byte[] f2215g;

        a(String r10, byte[] r11) {
            this.f2214c = r10;
            this.f2215g = r11;
        }

        public C0065c a() {
            return c.b(this.f2214c, this.f2215g, 5000);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ C0065c call() {
            return a();
        }
    }

    static class b implements Comparator<Map.Entry<String, Long>> {
        b() {
        }

        public int a(Map.Entry<String, Long> r10, Map.Entry<String, Long> r11) {
            return r10.getValue().compareTo(r11.getValue());
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Map.Entry<String, Long> r10, Map.Entry<String, Long> r11) {
            return a(r10, r11);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.memory.upload.c$c, reason: collision with other inner class name */
    public static class C0065c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f2217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f2218c;

        public C0065c(String r10, long r11, boolean r12) {
            this.f2216a = r10;
            this.f2217b = r11;
            this.f2218c = r12;
        }
    }

    public static List<String> a(List<String> r10) {
        if (r10 != null) goto L4;
    L54:
        return r10;
    L4:
        if (r10.size() <= 1) goto L54;
        byte[] r11 = new byte[262144];
        ExecutorService r12 = Executors.newFixedThreadPool(Math.min(r10.size(), 4));
        ExecutorCompletionService r13 = new ExecutorCompletionService(r12);
        Iterator<String> r14 = r10.iterator();     // Catch: Throwable -> L49
    L9:
        if (r14.hasNext() == false) goto L11;
        r13.submit(new a(r14.next(), r11));     // Catch: Throwable -> L49
        goto L9
    L11:
        long r15 = System.currentTimeMillis();     // Catch: Throwable -> L49
        LinkedHashMap r16 = new LinkedHashMap();     // Catch: Throwable -> L49
        int r17 = 0;
    L13:
        if (r17 >= r10.size()) goto L27;
        long r18 = 5000 - (System.currentTimeMillis() - r15);
        if (r18 <= 0) goto L27;
        Future r19 = r13.poll(r18, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L55 Throwable -> L49
        if (r19 == null) goto L27;
        C0065c r20 = (C0065c) r19.get();     // Catch: Exception -> L26 Throwable -> L49
    L22:
        r17 = r17 + 1;
        if (r20.f2218c == false) goto L13;
        r16.put(r20.f2216a, Long.valueOf(r20.f2217b));     // Catch: Throwable -> L49
    L26:
        r17 = r17 + 1;     // Catch: Throwable -> L49
    L27:
        r12.shutdownNow();     // Catch: Throwable -> L49
        if (r16.isEmpty() == false) goto L34;
        ArrayList r21 = new ArrayList(r10);     // Catch: Throwable -> L49
        if (r12.isShutdown() == true) goto L33;
        r12.shutdownNow();
    L33:
        return r21;
    L34:
        ArrayList r22 = new ArrayList(r16.entrySet());     // Catch: Throwable -> L49
        Collections.sort(r22, new b());     // Catch: Throwable -> L49
        ArrayList r23 = new ArrayList();     // Catch: Throwable -> L49
        Iterator r24 = r22.iterator();     // Catch: Throwable -> L49
    L36:
        if (r24.hasNext() == false) goto L38;
        r23.add(((Map.Entry) r24.next()).getKey());     // Catch: Throwable -> L49
        goto L36
    L38:
        Iterator<String> r110 = r10.iterator();     // Catch: Throwable -> L49
    L40:
        if (r110.hasNext() == false) goto L46;
        String r25 = r110.next();     // Catch: Throwable -> L49
        if (r23.contains(r25) == true) goto L40;
        r23.add(r25);     // Catch: Throwable -> L49
        goto L40
    L46:
        if (r12.isShutdown() == true) goto L48;
        r12.shutdownNow();
    L48:
        return r23;
    L49:
        th = move-exception;
        if (r12.isShutdown() == true) goto L53;
        r12.shutdownNow();
    L53:
        throw th;
    }

    public static C0065c b(String r10, byte[] r11, int r12) {
        OutputStream r13 = null;
        HttpURLConnection r14 = (HttpURLConnection) new URL(r10).openConnection();     // Catch: Throwable -> L20 Exception -> L22
        r14.setConnectTimeout(r12);     // Catch: Exception -> L19 Throwable -> L33
        r14.setReadTimeout(r12);     // Catch: Exception -> L19 Throwable -> L33
        r14.setUseCaches(false);     // Catch: Exception -> L19 Throwable -> L33
        boolean r15 = true;
        r14.setDoOutput(true);     // Catch: Exception -> L19 Throwable -> L33
        r14.setRequestMethod(CloudConfig.REQUEST_TYPE_POST);     // Catch: Exception -> L19 Throwable -> L33
        r14.setRequestProperty(NetConst.KEY_CONTENT_TYPE, "application/octet-stream");     // Catch: Exception -> L19 Throwable -> L33
        r14.setFixedLengthStreamingMode(r11.length);     // Catch: Exception -> L19 Throwable -> L33
        long r16 = System.nanoTime();     // Catch: Exception -> L19 Throwable -> L33
        OutputStream r17 = r14.getOutputStream();     // Catch: Exception -> L40 Throwable -> L33
        r17.write(r11);     // Catch: Throwable -> L16 Exception -> L18
        r17.flush();     // Catch: Throwable -> L16 Exception -> L18
        r17.close();     // Catch: Throwable -> L16 Exception -> L18
        int r18 = r14.getResponseCode();     // Catch: Exception -> L40 Throwable -> L33
        long r19 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - r16);     // Catch: Exception -> L40 Throwable -> L33
        if (r18 >= 200) goto L10;
    L12:
        r15 = false;
    L13:
        C0065c r110 = new C0065c(r10, r19, r15);     // Catch: Exception -> L40 Throwable -> L33
        r14.disconnect();
        return r110;
    L10:
        if (r18 >= 300) goto L12;
    L18:
        r13 = r17;
    L16:
        th = th;
        r13 = r17;
    L34:
        if (r13 != null) goto L47;
    L36:
        if (r14 == null) goto L54;
        r14.disconnect();
        throw th;
    L54:
        throw th;
    L47:
        r13.close();     // Catch: Exception -> L39
    L24:
        if (r16 != 0) goto L26;
        long r111 = Long.MAX_VALUE;
    L27:
        C0065c r20 = new C0065c(r10, r111, false);     // Catch: Throwable -> L33
        if (r13 != null) goto L45;
    L30:
        if (r14 == null) goto L32;
        r14.disconnect();
    L32:
        return r20;
    L45:
        r13.close();     // Catch: Exception -> L41
        goto L30
    L26:
        r111 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - r16);     // Catch: Throwable -> L33
    L19:
        r16 = 0;
        goto L24
    L33:
        th = th;
    L22:
        r16 = 0;
        r14 = null;
    L20:
        th = th;
        r14 = null;
        goto L34
    }
}

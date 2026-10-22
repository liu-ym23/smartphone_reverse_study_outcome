package org.terracotta.utilities.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.slf4j.c;
import org.slf4j.d;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f20279a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f20280b = false;

    /* JADX INFO: renamed from: org.terracotta.utilities.a.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: org.terracotta.utilities.a.a$a, reason: collision with other inner class name */
    public static final class C0903a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Charset f20281a = null;

        static {
            f20281a = a();
        }

        private static Charset a() {
            Charset r1 = b();
            if (a.a() == true) goto L20;
        L19:
            return r1;
        L20:
            Iterator<String> r2 = a.a(r1, new String[]{"cmd", "/C", "chcp"}).iterator();     // Catch: Exception -> L17
        L6:
            if (r2.hasNext() == false) goto L15;
            String[] r3 = ((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin")).split(":\\s*");     // Catch: Exception -> L17
            if (r3.length != 2) goto L6;
            if (r3[1].matches("\\d+") == false) goto L6;
            if (Charset.isSupported(r3[1]) == false) goto L6;
            return Charset.forName(r3[1]);
        L15:
            a.b().info("Unable to determine the shell encoding from 'chcp'; using {}", r1);     // Catch: Exception -> L17
        L17:
            e = move-exception;
            a.b().info("Unable to determine the shell encoding from 'chcp'; using {}", r1, e);
            goto L19
        }

        private static Charset b() {
            Iterator r0 = Arrays.asList(new String[]{"sun.stdout.encoding", "sun.jnu.encoding"}).iterator();
        L4:
            if (r0.hasNext() == false) goto L12;
            String r1 = System.getProperty((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin"));
            if (r1 == null) goto L4;
            if (Charset.isSupported(r1) == false) goto L4;
            return Charset.forName(r1);
        L12:
            return Charset.defaultCharset();
        }
    }

    public static final class b implements Iterable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f20282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f20283b;

        private b(int r3, List<String> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.f20283b = r3;
            this.f20282a = Collections.unmodifiableList(r5);
        }

        /* synthetic */ b(int r2, List r3, AnonymousClass1 r4) {
            this(r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            return this.f20282a.iterator();
        }
    }

    static {
        f20279a = d.a(a.class);
        f20280b = System.getProperty("os.name", "").toLowerCase(Locale.ROOT).startsWith("win");
    }

    private a() {
    }

    public static b a(Charset r5, String... r6) {
        Process r0 = new ProcessBuilder(new String[0]).command(r6).redirectErrorStream(true).start();
        r0.getOutputStream().close();
        ArrayList r1 = new ArrayList();
        BufferedReader r2 = new BufferedReader(new InputStreamReader(r0.getInputStream(), r5));
    L27:
        String r7 = r2.readLine();     // Catch: Throwable -> L17
        if (r7 == null) goto L7;
        r1.add(r7);     // Catch: Throwable -> L17
        goto L27
    L7:
        r2.close();
        int r8 = r0.waitFor();     // Catch: InterruptedException -> L14
        c r3 = f20279a;
        if (r3.isDebugEnabled() == false) goto L13;
        r3.debug("Command: {}; rc={}", Arrays.toString(r6), Integer.valueOf(r8));
        r1.forEach($$Lambda$a$pCcKk9oT0yzPtwz0VcUY2NYB1uA.INSTANCE);
    L13:
        return new b(r8, r1, null);
    L14:
        e = move-exception;
        throw new IOException(e);
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L22
    L24:
        throw th;
    L22:
        th = move-exception;
        th.addSuppressed(th);
        goto L24
    }

    private static /* synthetic */ void a(String r2) {
        f20279a.debug("    {}", r2);
    }

    static /* synthetic */ boolean a() {
        return f20280b;
    }

    static /* synthetic */ c b() {
        return f20279a;
    }

    public static /* synthetic */ void lambda$pCcKk9oT0yzPtwz0VcUY2NYB1uA(String r0) {
        a(r0);
    }
}

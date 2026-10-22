package com.ss.android.ugc.aweme.framework.services;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class ConfigLoader {
    private static final Map<String, List<CacheItem>> CLASSES = null;
    private static final String[] DIRS = null;

    public ConfigLoader() {
    }

    static {
        DIRS = new String[]{"services/", "services/AwemeLive/", "services/AwemeIM/", "services/AwemeReactNative/", "services/AwemePush/", "services/AwemeShare/", "services/AwemeMain/", "services/AwemePlugin/", "services/SdkDebugger/", "services/AwemeMusic/", "services/AwemeVideo/", "services/AwemeFramework/", "services/AwemeCommerce/"};
        CLASSES = Collections.synchronizedMap(new LinkedHashMap());
        addCache("com.bytedance.geckox.settings.IGeckoRegister", "com.bytedance.android.ec.core.gecko.ECGeckoRegister");
    }

    private static void closeQuietly(Closeable r0) {
        if (r0 == null) goto L10;
        r0.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static <T> Iterator<T> iterator(Class<T> r3) {
        ClassLoader r0 = r3.getClassLoader();
        return new ConfigIterator(loadClasses(r3, r0), r3, r0);
    }

    private static List<CacheItem> parse(URL r5) {
        LinkedList r0 = new LinkedList();
        BufferedReader r1 = null;
        InputStream r6 = r5.openStream();     // Catch: Throwable -> L23 IOException -> L25
        InputStreamReader r2 = new InputStreamReader(r6);     // Catch: Throwable -> L19 IOException -> L21
    L41:
        BufferedReader r3 = new BufferedReader(r2);     // Catch: Throwable -> L15 IOException -> L17
        String r4 = r3.readLine();     // Catch: IOException -> L13 Throwable -> L30
    L7:
        if (r4 == null) goto L28;
        CacheItem r7 = CacheItem.fromConfig(r4);     // Catch: IOException -> L13 Throwable -> L30
        if (r7 == null) goto L11;
        r0.add(r7);     // Catch: IOException -> L13 Throwable -> L30
    L11:
        r4 = r3.readLine();     // Catch: IOException -> L13 Throwable -> L30
    L28:
        closeQuietly(r3);
        closeQuietly(r2);
        closeQuietly(r6);
        return r0;
    L13:
        IOException e = e;
    L27:
        e.printStackTrace();     // Catch: Throwable -> L30
    L30:
        th = th;
        r1 = r3;
    L32:
        closeQuietly(r1);
        closeQuietly(r2);
        closeQuietly(r6);
        throw th;
    L17:
        e = move-exception;
        r3 = null;
        e = e;
    L15:
        th = th;
    L21:
        e = move-exception;
        r3 = null;
        e = e;
        r2 = null;
    L19:
        th = th;
        r2 = null;
        goto L32
    L25:
        e = move-exception;
        r2 = null;
        r3 = null;
        e = e;
        r6 = null;
    L23:
        th = th;
        r6 = null;
        r2 = null;
        goto L32
    }

    private static List<CacheItem> parseSafely(URL r3) {
        int r0 = 0;
    L4:
        if (r0 >= 3) goto L18;
        return parse(r3);
    L7:
        e = move-exception;
        if (r0 >= 2) goto L16;
        Thread.sleep(2);     // Catch: InterruptedException -> L13
    L15:
        r0 = r0 + 1;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L16:
        throw e;
    L18:
        return new LinkedList();
    }

    private static void addCache(String r4, String r5) {
        String[] r6 = r5.split("\n");
        ArrayList r0 = new ArrayList();
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(CacheItem.fromConfig(r6[r2]));
        r2 = r2 + 1;
        goto L3
    L5:
        CLASSES.put(r4, r0);
    }

    private static <T> List<CacheItem> loadClasses(Class<T> r6, ClassLoader r7) {
        Map<String, List<CacheItem>> r0 = CLASSES;
        monitor-enter(r0);
        List<CacheItem> r1 = r0.get(r6.getName());     // Catch: Throwable -> L28
        if (r1 == null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L28
        return r1;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L28
        LinkedList r2 = new LinkedList();
        String[] r3 = DIRS;
        int r4 = r3.length;
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L17;
        Enumeration<URL> r8 = getUrls(r6, r7, r3[r5]);
    L12:
        if (r8 == null) goto L16;
        if (r8.hasMoreElements() == false) goto L16;
        r2.addAll(parseSafely(r8.nextElement()));
    L16:
        r5 = r5 + 1;
        goto L10
    L17:
        Map<String, List<CacheItem>> r9 = CLASSES;
        monitor-enter(r9);
    L25:
        th = move-exception;
        throw th;
    L20:
        if (r9.containsKey(r6.getName()) == true) goto L22;
        r9.put(r6.getName(), r2);     // Catch: Throwable -> L25
        List<CacheItem> r10 = r2;
    L23:
        monitor-exit(r9);     // Catch: Throwable -> L25
        return r10;
    L22:
        r10 = r9.get(r6.getName());     // Catch: Throwable -> L25
    L28:
        th = move-exception;
        throw th;
    }

    private static Enumeration<URL> getUrls(Class r1, ClassLoader r2, String r3) {
        String r4 = r3 + r1.getName();
        if (r2 == null) goto L16;
        return r2.getResources(r4);
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    L16:
        return ClassLoader.getSystemResources(r4);
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}

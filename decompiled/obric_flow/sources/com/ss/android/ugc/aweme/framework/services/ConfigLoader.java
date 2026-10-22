package com.ss.android.ugc.aweme.framework.services;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
abstract class ConfigLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f16202a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f16203b = null;

    public static class CacheItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f16205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f16206c;

        public CacheItem(String r5, boolean r10) {
            this.f16204a = r5;
            this.f16205b = r10;
        }

        public static CacheItem a(String r5) {
            if ("".equals(r5) == true) goto L9;
            String[] r10 = r5.split(":");
            boolean r11 = false;
            String r12 = r10[0];
            if (r10.length <= 1) goto L8;
            r11 = Boolean.parseBoolean(r10[1]);
        L8:
            return new CacheItem(r12, r11);
        L9:
            return null;
        }
    }

    public static class ConfigIterator<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f16207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ClassLoader f16208b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Class f16209c;
        public int d;

        public ConfigIterator(List r5, Class r10, ClassLoader r11) {
            this.d = 0;
            this.f16208b = r11;
            this.f16209c = r10;
            this.f16207a = r5;
        }

        public final Object a(CacheItem r5) {
            Class<?> r10 = Class.forName(r5.f16204a, false, this.f16208b);     // Catch: ClassNotFoundException -> L26
            if (this.f16209c.isAssignableFrom(r10) == false) goto L25;
            Constructor<?> r11 = r10.getDeclaredConstructor(null);     // Catch: InvocationTargetException -> L8 NoSuchMethodException -> L10 IllegalAccessException -> L12 InstantiationException -> L14
            r11.setAccessible(true);     // Catch: InvocationTargetException -> L8 NoSuchMethodException -> L10 IllegalAccessException -> L12 InstantiationException -> L14
            return r11.newInstance(null);
        L12:
            e = move-exception;
            throw new RuntimeException(e);
        L14:
            e = move-exception;
            throw new RuntimeException(e);
        L10:
            e = move-exception;
            throw new RuntimeException(e);
        L8:
            e = move-exception;
            throw new RuntimeException(e);
        L25:
            throw new RuntimeException(new ClassCastException("source: " + r10.getName() + ", dest: " + this.f16209c.getName()));
        L26:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            List r5 = this.f16207a;
            if (r5 != null) goto L5;
            return false;
        L5:
            if (this.d >= r5.size()) goto L10;
            return true;
        L10:
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            CacheItem r5 = (CacheItem) this.f16207a.get(this.d);
            this.d++;
            monitor-enter(r5);
            boolean r10 = r5.f16205b;     // Catch: Throwable -> L10
            if (r10 == false) goto L12;
            Object r11 = r5.f16206c;     // Catch: Throwable -> L10
            if (r11 == null) goto L12;
            monitor-exit(r5);     // Catch: Throwable -> L10
            return r11;
        L12:
            if (r10 == false) goto L16;
            Object r12 = a(r5);     // Catch: Throwable -> L10
            r5.f16206c = r12;     // Catch: Throwable -> L10
            monitor-exit(r5);     // Catch: Throwable -> L10
            return r12;
        L16:
            monitor-exit(r5);     // Catch: Throwable -> L10
            return a(r5);
        L10:
            th = move-exception;
            throw th;
        }
    }

    static {
        f16202a = new String[]{"services/", "services/AwemeLive/", "services/AwemeIM/", "services/AwemeReactNative/", "services/AwemePush/", "services/AwemeShare/", "services/AwemeMain/", "services/AwemePlugin/", "services/SdkDebugger/", "services/AwemeMusic/", "services/AwemeVideo/", "services/AwemeFramework/", "services/AwemeCommerce/"};
        f16203b = Collections.synchronizedMap(new LinkedHashMap());
    }

    public static LinkedList a(URL r5) {
        LinkedList r10 = new LinkedList();
        InputStream r11 = null;
        BufferedReader r12 = null;
        InputStream r13 = r5.openStream();     // Catch: Throwable -> L29 IOException -> L31
        InputStreamReader r14 = new InputStreamReader(r13);     // Catch: Throwable -> L24 IOException -> L27
    L47:
        BufferedReader r15 = new BufferedReader(r14);     // Catch: Throwable -> L20 IOException -> L22
        String r16 = r15.readLine();     // Catch: Throwable -> L11 IOException -> L13
    L7:
        if (r16 == null) goto L17;
        CacheItem r17 = CacheItem.a(r16);     // Catch: Throwable -> L11 IOException -> L13
        if (r17 == null) goto L15;
        r10.add(r17);     // Catch: Throwable -> L11 IOException -> L13
    L15:
        r16 = r15.readLine();     // Catch: Throwable -> L11 IOException -> L13
        goto L7
    L17:
        a(r15);
        a(r14);
        a(r13);
        return r10;
    L13:
        IOException e = e;
    L41:
        e.printStackTrace();     // Catch: Throwable -> L36
        a(r15);
        a(r14);
        a(r13);
        return r10;
    L36:
        Throwable th2 = th;
    L26:
        r11 = r13;
    L38:
        r13 = r11;
    L19:
        r12 = r15;
    L39:
        a(r12);
        a(r14);
        a(r13);
        throw th2;
    L11:
        th2 = th;
        goto L19
    L22:
        e = move-exception;
        r15 = null;
        e = e;
    L20:
        th2 = th;
    L27:
        e = move-exception;
        r15 = null;
        e = e;
        r14 = null;
    L24:
        th2 = th;
        r14 = null;
        r15 = null;
        goto L26
    L31:
        e = move-exception;
        r14 = null;
        r15 = null;
        e = e;
        r13 = null;
    L29:
        th = move-exception;
        th2 = th;
        r14 = null;
        r15 = null;
        goto L38
    }

    public static void a(Closeable r5) {
        if (r5 == null) goto L10;
        r5.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}

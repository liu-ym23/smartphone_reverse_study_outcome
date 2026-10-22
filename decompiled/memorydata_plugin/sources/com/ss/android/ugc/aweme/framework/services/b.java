package com.ss.android.ugc.aweme.framework.services;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes6.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f15737a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, List<a>> f15738b = null;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f15740b;
        public Object c;

        public a(String r1, boolean r2) {
            this.f15739a = r1;
            this.f15740b = r2;
        }

        public static a a(String r4) {
            if (r4 != null) goto L4;
            return null;
        L4:
            if ("".equals(r4) == true) goto L12;
            String[] r5 = r4.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            boolean r0 = false;
            String r1 = r5[0];
            if (r5.length <= 1) goto L9;
            r0 = Boolean.parseBoolean(r5[1]);
        L9:
            return new a(r1, r0);
        L12:
            return null;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.framework.services.b$b, reason: collision with other inner class name */
    private static class C0839b<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<a> f15741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ClassLoader f15742b;
        private Class c;
        private int d;

        public C0839b(List<a> r3, Class<T> r4, ClassLoader r5) {
            List<a> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            this.d = 0;
            this.f15742b = r5;
            this.c = r4;
            this.f15741a = r6;
        }

        private T a(a r3) {
            Class<?> r4 = Class.forName(r3.f15739a, false, this.f15742b);     // Catch: ClassNotFoundException -> L21
            if (this.c.isAssignableFrom(r4) == false) goto L20;
            Constructor<?> r2 = r4.getDeclaredConstructor(new Class[0]);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 InstantiationException -> L16
            r2.setAccessible(true);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 InstantiationException -> L16
            return (T) r2.newInstance(new Object[0]);
        L13:
            e = move-exception;
            throw new RuntimeException(e);
        L16:
            e = move-exception;
            throw new RuntimeException(e);
        L10:
            e = move-exception;
            throw new RuntimeException(e);
        L7:
            e = move-exception;
            throw new RuntimeException(e);
        L20:
            throw new RuntimeException(new ClassCastException("source: " + r4.getName() + ", dest: " + this.c.getName()));
        L21:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            List<a> r0 = this.f15741a;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (this.d >= r0.size()) goto L7;
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            a r0 = (a) ZeusTransformUtils.preCheckCast(this.f15741a.get(this.d), a.class, "com.obric.memorydata.plugin");
            this.d++;
            monitor-enter(r0);
        L19:
            th = move-exception;
            throw th;
        L5:
            if (r0.f15740b == false) goto L12;
            if (r0.c == null) goto L12;
            T r3 = (T) r0.c;
            monitor-exit(r0);     // Catch: Throwable -> L19
            return r3;
        L12:
            if (r0.f15740b == false) goto L16;
            r0.c = a(r0);     // Catch: Throwable -> L19
            T r4 = (T) r0.c;
            monitor-exit(r0);     // Catch: Throwable -> L19
            return r4;
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L19
            return a(r0);
        }
    }

    static {
        f15737a = new String[]{"services/", "services/AwemeLive/", "services/AwemeIM/", "services/AwemeReactNative/", "services/AwemePush/", "services/AwemeShare/", "services/AwemeMain/", "services/AwemePlugin/", "services/SdkDebugger/", "services/AwemeMusic/", "services/AwemeVideo/", "services/AwemeFramework/", "services/AwemeCommerce/"};
        f15738b = Collections.synchronizedMap(new LinkedHashMap());
    }

    private static Enumeration<URL> a(Class r1, ClassLoader r2, String r3) {
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

    public static <T> Iterator<T> a(Class<T> r3) {
        ClassLoader r0 = r3.getClassLoader();
        return new C0839b(a(r3, r0), r3, r0);
    }

    private static <T> List<a> a(Class<T> r8, ClassLoader r9) {
        Map<String, List<a>> r0 = f15738b;
        monitor-enter(r0);
        List<a> r1 = (List) ZeusTransformUtils.preCheckCast(r0.get(r8.getName()), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r1 == null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L28
        return r1;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L28
        List<a> r2 = new LinkedList();
        String[] r3 = f15737a;
        int r4 = r3.length;
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L17;
        Enumeration<URL> r6 = a(r8, r9, r3[r5]);
    L12:
        if (r6 == null) goto L16;
        if (r6.hasMoreElements() == false) goto L16;
        r2.addAll(a((URL) ZeusTransformUtils.preCheckCast(r6.nextElement(), URL.class, "com.obric.memorydata.plugin")));
    L16:
        r5 = r5 + 1;
        goto L10
    L17:
        Map<String, List<a>> r10 = f15738b;
        monitor-enter(r10);
    L25:
        th = move-exception;
        throw th;
    L20:
        if (r10.containsKey(r8.getName()) == true) goto L22;
        r10.put(r8.getName(), r2);     // Catch: Throwable -> L25
    L23:
        monitor-exit(r10);     // Catch: Throwable -> L25
        return r2;
    L22:
        r2 = (List) ZeusTransformUtils.preCheckCast(r10.get(r8.getName()), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
    L28:
        th = move-exception;
        throw th;
    }

    private static List<a> a(URL r3) {
        int r0 = 0;
    L4:
        if (r0 >= 3) goto L18;
        return b(r3);
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

    private static void a(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        r3.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private static List<a> b(URL r5) {
        LinkedList r0 = new LinkedList();
        BufferedReader r1 = null;
        InputStream r6 = r5.openStream();     // Catch: Throwable -> L22 IOException -> L24
    L40:
        InputStreamReader r2 = new InputStreamReader(r6);     // Catch: Throwable -> L18 IOException -> L20
        BufferedReader r3 = new BufferedReader(r2);     // Catch: Throwable -> L14 IOException -> L16
    L33:
        String r4 = r3.readLine();     // Catch: IOException -> L12 Throwable -> L29
        if (r4 == null) goto L27;
        a r7 = a.a(r4);     // Catch: IOException -> L12 Throwable -> L29
        if (r7 == null) goto L33;
        r0.add(r7);     // Catch: IOException -> L12 Throwable -> L29
    L27:
        a(r3);
        a(r2);
        a(r6);
        return r0;
    L12:
        IOException e = e;
    L26:
        e.printStackTrace();     // Catch: Throwable -> L29
    L29:
        th = th;
        r1 = r3;
    L31:
        a(r1);
        a(r2);
        a(r6);
        throw th;
    L16:
        e = move-exception;
        r3 = null;
        e = e;
    L14:
        th = th;
        goto L31
    L20:
        e = move-exception;
        r3 = null;
        e = e;
        r2 = null;
    L18:
        th = th;
        r2 = null;
    L24:
        e = move-exception;
        r2 = null;
        r3 = null;
        e = e;
        r6 = null;
    L22:
        th = th;
        r6 = null;
        r2 = null;
        goto L31
    }
}

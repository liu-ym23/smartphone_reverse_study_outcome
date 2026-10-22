package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nFastServiceLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastServiceLoader.kt\nkotlinx/coroutines/internal/FastServiceLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,161:1\n77#1,5:162\n77#1,5:168\n131#1,13:183\n1#2:167\n1360#3:173\n1446#3,5:174\n1549#3:179\n1620#3,3:180\n1064#4,2:196\n*S KotlinDebug\n*F\n+ 1 FastServiceLoader.kt\nkotlinx/coroutines/internal/FastServiceLoader\n*L\n60#1:162,5\n61#1:168,5\n117#1:183,13\n99#1:173\n99#1:174,5\n101#1:179\n101#1:180,3\n153#1:196,2\n*E\n"})
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f10565a = null;

    static {
        f10565a = new n();
    }

    private n() {
    }

    private final <S> S a(String r10, ClassLoader r11, Class<S> r12) {
        Class<?> r13 = Class.forName(r10, false, r11);
        if (r12.isAssignableFrom(r13) == false) goto L7;
        return r12.cast(r13.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    L7:
        throw new IllegalArgumentException(("Expected service of class " + r12 + ", but found " + r13).toString());
    }

    private final <S> List<S> b(Class<S> r10, ClassLoader r11) {
        return d(r10, r11);
    L5:
        return CollectionsKt.toList(ServiceLoader.load(r10, r11));
    }

    private final List<String> e(URL r10) {
        String r11 = r10.toString();
        if (StringsKt.startsWith$default(r11, "jar", false, 2, null) == false) goto L25;
        String r12 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(r11, "jar:file:", null, 2, null), '!', null, 2, null);
        String r13 = StringsKt.substringAfter$default(r11, "!/", null, 2, null);
        JarFile r14 = new JarFile(r12, false);
        BufferedReader r15 = new BufferedReader(new InputStreamReader(r14.getInputStream(new ZipEntry(r13)), "UTF-8"));     // Catch: Throwable -> L17
        List<String> r16 = f10565a.f(r15);     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L17
        r14.close();     // Catch: Throwable -> L10
        return r16;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L22
        throw th;
    L22:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);
        throw th;
    L25:
        BufferedReader r17 = new BufferedReader(new InputStreamReader(r10.openStream()));
        List<String> r18 = f10565a.f(r17);     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r17, null);
        return r18;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);
        throw th;
    }

    private final List<String> f(BufferedReader r10) {
        LinkedHashSet r11 = new LinkedHashSet();
    L3:
        String r12 = r10.readLine();
        if (r12 == null) goto L6;
        String r13 = StringsKt.trim(StringsKt.substringBefore$default(r12, "#", null, 2, null)).toString();
        boolean r14 = false;
        int r15 = 0;
    L9:
        if (r15 >= r13.length()) goto L20;
        char r16 = r13.charAt(r15);
        if (r16 != '.') goto L13;
    L16:
        boolean r17 = true;
    L17:
        if (r17 == false) goto L18;
        r15 = r15 + 1;
        goto L9
    L18:
        boolean r18 = false;
    L21:
        if (r18 == false) goto L28;
        if (r13.length() <= 0) goto L25;
        r14 = true;
    L25:
        if (r14 == false) goto L3;
        r11.add(r13);
        goto L3
    L28:
        throw new IllegalArgumentException(("Illegal service provider class name: " + r13).toString());
    L13:
        if (Character.isJavaIdentifierPart(r16) == true) goto L16;
        r17 = false;
        goto L17
    L20:
        r18 = true;
        goto L21
    L6:
        return CollectionsKt.toList(r11);
    }

    public final List<w> c() {
        if (o.a() == false) goto L5;
        ArrayList r10 = new ArrayList(2);     // Catch: Throwable -> L19
        w r11 = null;
        w r12 = (w) w.class.cast(Class.forName("kotlinx.coroutines.android.a", true, w.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));     // Catch: ClassNotFoundException -> L10 Throwable -> L19
    L11:
        if (r12 == null) goto L26;
        r10.add(r12);     // Catch: Throwable -> L19
    L26:
        r11 = (w) w.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, w.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));     // Catch: ClassNotFoundException -> L21 Throwable -> L19
    L16:
        if (r11 == null) goto L28;
        r10.add(r11);     // Catch: Throwable -> L19
        return r10;
    L28:
        return r10;
    L10:
        r12 = null;
    L20:
        return b(w.class, w.class.getClassLoader());
    L5:
        return b(w.class, w.class.getClassLoader());
    }

    public final <S> List<S> d(Class<S> r10, ClassLoader r11) {
        ArrayList r12 = Collections.list(r11.getResources("META-INF/services/" + r10.getName()));
        Intrinsics.checkNotNullExpressionValue(r12, "list(this)");
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        CollectionsKt.addAll(r13, f10565a.e((URL) r14.next()));
        goto L4
    L6:
        Set r15 = CollectionsKt.toSet(r13);
        if ((!r15.isEmpty()) == false) goto L14;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r17 = r15.iterator();
    L10:
        if (r17.hasNext() == false) goto L12;
        r16.add(f10565a.a((String) r17.next(), r11, r10));
        goto L10
    L12:
        return r16;
    L14:
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }
}

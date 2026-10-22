package kotlinx.coroutines.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\u0004H\u0082\bJ1\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\bH\u0002¢\u0006\u0002\u0010\u0010J*\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\b\u0000\u0010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0000¢\u0006\u0002\b\u0014J/\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\b\u0000\u0010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J,\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e*\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002H\u001e0!H\u0082\b¢\u0006\u0002\u0010\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "()V", "PREFIX", "", "createInstanceOf", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "baseClass", "Ljava/lang/Class;", "serviceClass", "getProviderInstance", "S", ActivityLifecycle.NAME, "loader", "Ljava/lang/ClassLoader;", "service", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "load", "", "loadMainDispatcherFactory", "loadMainDispatcherFactory$kotlinx_coroutines_core", "loadProviders", "loadProviders$kotlinx_coroutines_core", "parse", "url", "Ljava/net/URL;", "parseFile", "r", "Ljava/io/BufferedReader;", "use", "R", "Ljava/util/jar/JarFile;", "block", "Lkotlin/Function1;", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f17589a = null;

    static {
        f17589a = new o();
    }

    private o() {
    }

    private final <S> S a(String r1, ClassLoader r2, Class<S> r3) {
        Class<?> r4 = Class.forName(r1, false, r2);
        if (r3.isAssignableFrom(r4) == false) goto L7;
        return r3.cast(r4.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    L7:
        throw new IllegalArgumentException(("Expected service of class " + r3 + ", but found " + r4).toString());
    }

    private final List<String> a(BufferedReader r9) {
        Set r8 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
    L3:
        String r0 = r9.readLine();
        if (r0 == null) goto L6;
        String r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.substringBefore$default(r0, "#", null, 2, null), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        int r4 = 0;
    L9:
        if (r4 >= r2.length()) goto L20;
        char r5 = r2.charAt(r4);
        if (r5 != '.') goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == false) goto L18;
        r4 = r4 + 1;
        goto L9
    L18:
        boolean r7 = false;
    L21:
        if (r7 == false) goto L28;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L25;
        r3 = true;
    L25:
        if (r3 == false) goto L3;
        r8.add(r1);
        goto L3
    L28:
        throw new IllegalArgumentException(("Illegal service provider class name: " + r1).toString());
    L13:
        if (Character.isJavaIdentifierPart(r5) == true) goto L16;
        r6 = false;
        goto L17
    L20:
        r7 = true;
        goto L21
    L6:
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"));
    }

    private final List<String> a(URL r6) {
        String r5 = r6.toString();
        if (StringsKt.startsWith$default(r5, "jar", false, 2, null) == false) goto L25;
        String r7 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(r5, "jar:file:", null, 2, null), '!', null, 2, null);
        String r8 = StringsKt.substringAfter$default(r5, "!/", null, 2, null);
        JarFile r0 = new JarFile(r7, false);
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(new BufferedReader((Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r0.getInputStream(new ZipEntry(r8)), RpcUtils.CHARSET_UTF8), Reader.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        BufferedReader r10 = (BufferedReader) ZeusTransformUtils.preCheckCast(r9, BufferedReader.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        List<String> r11 = f17589a.a(r10);     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r9, null);     // Catch: Throwable -> L17
        r0.close();     // Catch: Throwable -> L10
        return r11;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L22
        throw th;
    L22:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);
        throw th;
    L25:
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(new BufferedReader((Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r6.openStream()), Reader.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");
        BufferedReader r13 = (BufferedReader) ZeusTransformUtils.preCheckCast(r12, BufferedReader.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        List<String> r14 = f17589a.a(r13);     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r12, null);
        return r14;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    }

    private final <S> List<S> b(Class<S> r1, ClassLoader r2) {
        return a(r1, r2);
    L5:
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(ServiceLoader.load(r1, r2), Iterable.class, "com.obric.memorydata.plugin"));
    }

    public final List<MainDispatcherFactory> a() {
        if (p.a() == false) goto L5;
        ArrayList r2 = new ArrayList(2);     // Catch: Throwable -> L20
        MainDispatcherFactory r4 = null;
        MainDispatcherFactory r3 = (MainDispatcherFactory) ZeusTransformUtils.preCheckCast(MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0])), MainDispatcherFactory.class, "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L10 Throwable -> L20
    L11:
        if (r3 == null) goto L23;
        r2.add(r3);     // Catch: Throwable -> L20
    L23:
        r4 = (MainDispatcherFactory) ZeusTransformUtils.preCheckCast(MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0])), MainDispatcherFactory.class, "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L22 Throwable -> L20
    L16:
        if (r4 == null) goto L18;
        r2.add(r4);     // Catch: Throwable -> L20
    L18:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    L10:
        r3 = null;
    L21:
        return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
    L5:
        return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
    }

    public final <S> List<S> a(Class<S> r5, ClassLoader r6) {
        ArrayList r4 = Collections.list(r6.getResources("META-INF/services/" + r5.getName()));
        Intrinsics.checkNotNullExpressionValue(r4, "list(...)");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        CollectionsKt.addAll(r0, (Iterable) ZeusTransformUtils.preCheckCast(f17589a.a((URL) ZeusTransformUtils.preCheckCast(r8.next(), URL.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        Set r9 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L15;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L13;
        r1.add(f17589a.a((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"), r6, r5));
        goto L10
    L13:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    L15:
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }
}

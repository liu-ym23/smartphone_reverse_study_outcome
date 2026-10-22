package com.larus.audio.call.arch;

import android.os.SystemClock;
import com.larus.audio.call.arch.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k0<C extends c> implements d<C> {
    public static final /* synthetic */ int d = 0;
    public final C a;
    public final Map<KClass<?>, com.larus.audio.call.arch.a<? super C>> b;
    public final List<com.larus.audio.call.arch.a<? super C>> c;

    public static final class a {
    }

    static {
    }

    public final void f() {
        Collection r0 = ((LinkedHashMap) this.b).values();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        ArrayList r4 = (ArrayList) this.c;
        if (r4.contains((com.larus.audio.call.arch.a) r3) == true) goto L4;
        r1.add(r3);
        goto L4
    L8:
        c("onStartAborted", r1, new e0());
    }

    public final C getContext() {
        return this.a;
    }

    public k0(C r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = new LinkedHashMap();
        this.c = new ArrayList();
    }

    @Override // com.larus.audio.call.arch.d
    public final void a(com.larus.audio.call.arch.a<? super C> r6) {
        Intrinsics.checkNotNullParameter(r6, "plugin");
        if (this.b.containsKey(Reflection.getOrCreateKotlinClass(r6.getClass())) == false) goto L5;
        com.larus.audio.call.util.e.a.i("LLMPluginContainer", "plugin have " + r6.T2() + ", hashCode: " + r6.hashCode());
        return;
    L5:
        this.b.put(Reflection.getOrCreateKotlinClass(r6.getClass()), r6);
        com.larus.audio.call.util.e.a.i("LLMPluginContainer", "register plugin " + r6.T2() + ", hashCode: " + r6.hashCode());
    }

    public final e d(KClass r7) {
        Intrinsics.checkNotNullParameter(r7, "clazz");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (JvmClassMappingKt.getJavaClass(r7).isInterface() == false) goto L17;
        Iterator r1 = ((LinkedHashMap) this.b).values().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r3 = r1.next();
        com.larus.audio.call.arch.a r4 = (com.larus.audio.call.arch.a) r3;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r4, "other");
        if (JvmClassMappingKt.getJavaClass(r7).isAssignableFrom(r4.getClass()) == false) goto L6;
    L11:
        Object r5 = (com.larus.audio.call.arch.a) r3;
        if (r5 != null) goto L14;
        RuntimeException r0 = new RuntimeException("plugin not exist , class = " + r7.getSimpleName());
        com.larus.audio.call.util.e.a.e("LLMPluginContainer", r0.getMessage(), r0);
        throw r0;
    L14:
        return (e) r5;
    L10:
        r3 = null;
        goto L11
    L17:
        IllegalArgumentException r2 = new IllegalArgumentException("interface required, KClass = " + r7.getQualifiedName());
        com.larus.audio.call.util.e.a.e("LLMPluginContainer", r2.getMessage(), r2);
        throw r2;
    }

    public final e e(KClass r7) {
        Intrinsics.checkNotNullParameter(r7, "clazz");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (JvmClassMappingKt.getJavaClass(r7).isInterface() == false) goto L15;
        Iterator r1 = ((LinkedHashMap) this.b).values().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();
        com.larus.audio.call.arch.a r4 = (com.larus.audio.call.arch.a) r2;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r4, "other");
        if (JvmClassMappingKt.getJavaClass(r7).isAssignableFrom(r4.getClass()) == false) goto L6;
    L11:
        Object r3 = (com.larus.audio.call.arch.a) r2;
        if ((r3 instanceof e) == true) goto L14;
        return null;
    L14:
        return (e) r3;
    L10:
        r2 = null;
        goto L11
    L15:
        com.larus.audio.call.util.e.a.e("LLMPluginContainer", "interface required, KClassclazz.name}");
        throw new IllegalArgumentException("interface required, KClassclazz.name}");
    }

    public final boolean g(i r4) {
        Intrinsics.checkNotNullParameter(r4, "isStale");
        ((ArrayList) this.c).clear();
        Iterator r0 = ((LinkedHashMap) this.b).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        com.larus.audio.call.arch.a r1 = (com.larus.audio.call.arch.a) r0.next();
        if (((Boolean) r4.invoke()).booleanValue() == true) goto L7;
        ((ArrayList) this.c).add(r1);
        r1.e3();
        goto L4
    L7:
        return false;
    L11:
        return !((Boolean) r4.invoke()).booleanValue();
    }

    public final void b(String r6, Function1<? super com.larus.audio.call.arch.a<?>, Unit> r7) {
        long r0 = SystemClock.elapsedRealtime();
        Iterator r2 = ((LinkedHashMap) this.b).entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r7.invoke(((Map.Entry) r2.next()).getValue());
        goto L4
    L6:
        com.larus.audio.call.util.e.a.i("LLMPluginContainer", r6 + " total cost: " + (SystemClock.elapsedRealtime() - r0) + "ms");
    }

    public static void c(String r4, Iterable r5, Function1 r6) {
        long r0 = SystemClock.elapsedRealtime();
        Iterator r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r6.invoke((com.larus.audio.call.arch.a) r7.next());
        goto L4
    L6:
        com.larus.audio.call.util.e.a.i("LLMPluginContainer", r4 + " total cost: " + (SystemClock.elapsedRealtime() - r0) + "ms");
    }
}

package com.bytedance.android.annie.service.network;

import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q extends a {
    public final /* synthetic */ LinkedHashMap<String, String> a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ Ref.ObjectRef<InputStream> c;
    public final /* synthetic */ Ref.ObjectRef<String> d;
    public final /* synthetic */ Ref.ObjectRef<Throwable> e;
    public final /* synthetic */ Ref.IntRef f;
    public final /* synthetic */ Ref.ObjectRef<WeakReference<Call<TypedInput>>> g;

    public final void a() {
        InputStream r10 = (InputStream) this.c.element;     // Catch: Throwable -> L7
        if (r10 == null) goto L20;
        r10.close();     // Catch: Throwable -> L7
    L20:
        WeakReference r11 = (WeakReference) this.g.element;     // Catch: Throwable -> L17
        if (r11 == null) goto L24;
        Call r12 = (Call) r11.get();     // Catch: Throwable -> L17
        if (r12 != null) goto L14;
        return;
    L14:
        if (r12.isCanceled() == true) goto L26;
        r12.cancel();     // Catch: Throwable -> L17
        return;
    L26:
        return;
    L24:
        return;
    L17:
        th = move-exception;
        b8.a r13 = b8.a.a;
        b8.a.a(new b8.b("HostNetworkDependImpl", LogLevel.ERROR, th, "close call failed"), true);
        return;
    L7:
        th = move-exception;
        b8.a r14 = b8.a.a;
        b8.a.a(new b8.b("HostNetworkDependImpl", LogLevel.ERROR, th, "close inputStream failed"), true);
        goto L20
    }

    public final Integer b() {
        return Integer.valueOf(this.f.element);
    }

    public final String c() {
        return (String) this.d.element;
    }

    public final Throwable d() {
        return (Throwable) this.e.element;
    }

    public final InputStream e() {
        return (InputStream) this.c.element;
    }

    public q(LinkedHashMap<String, String> r1, Ref.IntRef r10, Ref.ObjectRef<InputStream> r11, Ref.ObjectRef<String> r12, Ref.ObjectRef<Throwable> r13, Ref.IntRef r14, Ref.ObjectRef<WeakReference<Call<TypedInput>>> r15) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
    }
}

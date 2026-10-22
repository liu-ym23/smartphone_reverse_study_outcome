package iu;

import android.app.Application;
import android.content.Context;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18214a = null;

    static {
        f18214a = new a();
    }

    public static d b() {
        org.koin.core.a r5 = su.a.f22013b;
        if (r5 == null) goto L7;
        return (d) r5.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(d.class), null);
    L7:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    @Override // iu.c
    public final boolean a() {
        return b().a();
    }

    @Override // iu.d
    public final Application getApplication() {
        return b().getApplication();
    }

    @Override // iu.d
    public final Context getContext() {
        return b().getContext();
    }

    @Override // iu.d
    public final String getPackageName() {
        return b().getPackageName();
    }
}

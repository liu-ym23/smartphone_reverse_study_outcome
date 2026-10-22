package com.obric.flow.cardlistpage.mvi;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile MviLogLevel f11535a;

    static {
        f11535a = MviLogLevel.VERBOSE;
    }

    public static void a(MviLogLevel r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "level");
        Intrinsics.checkNotNullParameter(r11, "message");
        Intrinsics.checkNotNullParameter("MVI_STATE_LOG", "tag");
        Intrinsics.checkNotNullParameter(r10, "level");
        MviLogLevel r5 = f11535a;
        if (r5 != null) goto L6;
        r5 = MviLogLevel.INFO;
    L6:
        if (r10.compareTo(r5) < 0) goto L47;
        int r12 = g.f11534a[r10.ordinal()];     // Catch: Exception -> L44
        if (r12 != 1) goto L11;
        Intrinsics.checkNotNullParameter("MVI_STATE_LOG", "tag");     // Catch: Exception -> L44
        Intrinsics.checkNotNullParameter(r11, "msg");     // Catch: Exception -> L44
        org.koin.core.a r13 = su.a.f22013b;     // Catch: Exception -> L44
        if (r13 == null) goto L43;
        ((ju.b) r13.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).v("MVI_STATE_LOG", r11);     // Catch: Exception -> L44
        return;
    L43:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Exception -> L44
    L11:
        if (r12 != 2) goto L13;
        Intrinsics.checkNotNullParameter("MVI_STATE_LOG", "tag");     // Catch: Exception -> L44
        Intrinsics.checkNotNullParameter(r11, "msg");     // Catch: Exception -> L44
        org.koin.core.a r14 = su.a.f22013b;     // Catch: Exception -> L44
        if (r14 == null) goto L38;
        ((ju.b) r14.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).d("MVI_STATE_LOG", r11);     // Catch: Exception -> L44
        return;
    L38:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Exception -> L44
    L13:
        if (r12 != 3) goto L15;
        Intrinsics.checkNotNullParameter("MVI_STATE_LOG", "tag");     // Catch: Exception -> L44
        Intrinsics.checkNotNullParameter(r11, "msg");     // Catch: Exception -> L44
        org.koin.core.a r15 = su.a.f22013b;     // Catch: Exception -> L44
        if (r15 == null) goto L33;
        ((ju.b) r15.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MVI_STATE_LOG", r11);     // Catch: Exception -> L44
        return;
    L33:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Exception -> L44
    L15:
        if (r12 != 4) goto L17;
        Intrinsics.checkNotNullParameter("MVI_STATE_LOG", "tag");     // Catch: Exception -> L44
        Intrinsics.checkNotNullParameter(r11, "msg");     // Catch: Exception -> L44
        org.koin.core.a r16 = su.a.f22013b;     // Catch: Exception -> L44
        if (r16 == null) goto L28;
        ((ju.b) r16.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("MVI_STATE_LOG", r11);     // Catch: Exception -> L44
        return;
    L28:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Exception -> L44
    L17:
        if (r12 != 5) goto L53;
        Intrinsics.checkNotNullParameter("MVI_STATE_LOG", "tag");     // Catch: Exception -> L44
        Intrinsics.checkNotNullParameter(r11, "msg");     // Catch: Exception -> L44
        org.koin.core.a r17 = su.a.f22013b;     // Catch: Exception -> L44
        if (r17 == null) goto L23;
        ((ju.b) r17.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("MVI_STATE_LOG", r11);     // Catch: Exception -> L44
        return;
    L23:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Exception -> L44
    L53:
        return;
    L44:
        String r18 = j0.D("MVI_STATE_LOG", ": ", r11);
        System.out.println(r18);
        return;
    }
}

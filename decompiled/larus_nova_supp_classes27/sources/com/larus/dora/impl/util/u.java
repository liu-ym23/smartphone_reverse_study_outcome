package com.larus.dora.impl.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.drawable.Drawable;
import android.os.ParcelFileDescriptor;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.resource.DoraResourceTheme;
import com.larus.dora.impl.resource.DoraResourceType;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.NoWhenBranchMatchedException;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u {
    public static final u a = null;

    static {
        a = new u();
    }

    public u() {
    }

    public static AssetFileDescriptor d() {
        Intrinsics.checkNotNullParameter("dora_g_onboarding_opt_success.wav", "fileName");
        File r0 = f(DoraResourceDeviceType.G_SERIES, "assets/dora_g_onboarding_opt_success.wav");
        if (r0 != null) goto L11;
        g49.d.d("DoraGResources", "shared asset is missing: dora_g_onboarding_opt_success.wav");
        return null;
    L11:
        return new AssetFileDescriptor(ParcelFileDescriptor.open(r0, 268435456), 0, r0.length());
    L8:
        e = move-exception;
        g49.d.d("DoraGResources", "open shared asset (dora_g_onboarding_opt_success.wav) failed: " + e.getMessage());
        return null;
    }

    public final int a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return getIdentifier(r2, "drawable");
    }

    public final int b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return getIdentifier(r2, "raw");
    }

    public static Drawable c(Context r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "resourceName");
        return com.larus.dora.impl.resource.j0.f(com.larus.dora.impl.resource.j0.a, r7, DoraResourceDeviceType.G_SERIES, r8, null, 24);
    }

    public static File f(DoraResourceDeviceType r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "deviceType");
        Intrinsics.checkNotNullParameter(r5, "resourceName");
        boolean r0 = v19.h.a;
        if (v19.h.a(null) == false) goto L5;
        DoraResourceTheme r1 = DoraResourceTheme.NIGHT;
    L6:
        com.larus.dora.impl.resource.j0 r2 = com.larus.dora.impl.resource.j0.a;
        DoraResourceType r3 = DoraResourceType.RAW;
        r2.getClass();
        com.larus.dora.impl.resource.k r6 = com.larus.dora.impl.resource.j0.e(r4, r3, r5, r1);
        if ((r6 instanceof com.larus.dora.impl.resource.k.b) == false) goto L9;
        com.larus.dora.impl.resource.k.b r7 = (com.larus.dora.impl.resource.k.b) r6;
    L10:
        if (r7 != null) goto L12;
        return null;
    L12:
        return r7.a;
    L9:
        r7 = null;
        goto L10
    L5:
        r1 = DoraResourceTheme.LIGHT;
        goto L6
    }

    public final int getIdentifier(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "type");
        AppHost.Companion r0 = AppHost.a;
        int r5 = r0.getApplication().getResources().getIdentifier(r3, r4, r0.getApplication().getPackageName());
        if (Intrinsics.areEqual("drawable", r4) == false) goto L8;
        if (r5 > 0) goto L9;
        return 2131102509;
    L9:
        return r5;
    L8:
        return r5;
    }

    public static String e(Context r5, DoraResourceDeviceType r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "deviceType");
        Intrinsics.checkNotNullParameter(r7, "resourceName");
        com.larus.dora.impl.resource.j0 r3 = com.larus.dora.impl.resource.j0.a;
        DoraResourceType r4 = DoraResourceType.RAW;
        r3.getClass();
        DoraResourceTheme r8 = com.larus.dora.impl.resource.j0.h(r5);
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "deviceType");
        Intrinsics.checkNotNullParameter(r4, "resourceType");
        Intrinsics.checkNotNullParameter(r7, "resourceName");
        Intrinsics.checkNotNullParameter(r8, "theme");
        com.larus.dora.impl.resource.k r9 = com.larus.dora.impl.resource.j0.e(r6, r4, r7, r8);
        if ((r9 instanceof com.larus.dora.impl.resource.k.a) == false) goto L17;
        Reader r10 = new InputStreamReader(r5.getResources().openRawResource(((com.larus.dora.impl.resource.k.a) r9).a), Charsets.UTF_8);
        if ((r10 instanceof BufferedReader) == false) goto L7;
        BufferedReader r11 = (BufferedReader) r10;
    L35:
        String r12 = TextStreamsKt.readText(r11);     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r11, null);
    L30:
        return r12;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L7:
        r11 = new BufferedReader(r10, 8192);
        goto L35
    L17:
        if ((r9 instanceof com.larus.dora.impl.resource.k.b) == false) goto L29;
        File r13 = ((com.larus.dora.impl.resource.k.b) r9).a;
        Charset r14 = Charsets.UTF_8;
        Reader r15 = new InputStreamReader(new PolarisFileInputStreamWrapper(r13), r14);
        if ((r15 instanceof BufferedReader) == false) goto L21;
        BufferedReader r16 = (BufferedReader) r15;
    L33:
        r12 = TextStreamsKt.readText(r16);     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r16, null);
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);
        throw th;
    L21:
        r16 = new BufferedReader(r15, 8192);
        goto L33
    L29:
        if (r9 != null) goto L32;
        return null;
    L32:
        throw new NoWhenBranchMatchedException();
    }
}

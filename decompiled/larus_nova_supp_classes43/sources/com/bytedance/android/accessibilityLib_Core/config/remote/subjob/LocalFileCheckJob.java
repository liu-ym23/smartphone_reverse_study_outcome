package com.bytedance.android.accessibilityLib_Core.config.remote.subjob;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class LocalFileCheckJob {
    public static final /* synthetic */ int e = 0;
    public final Lazy a;
    public final String b;
    public final String c;
    public final b d;

    public static final class a {
    }

    static {
    }

    public LocalFileCheckJob(b r1) {
        this.d = r1;
        this.a = LazyKt.lazy(new LocalFileCheckJob$kevaRepo$2(this));
        this.b = "r_accessibility.txt_identify";
        this.c = "r_accessibility.txt_path";
    }

    public final void a(final String r11, final Function1<? super List<String>, Unit> r12) {
    L47:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L52;
        Context r0 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L52:
        if (("getLocalFileIfValid error = " + e.getMessage()) == null) goto L54;
        Context r13 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L54:
        r12.invoke(null);
        Unit r14 = Unit.INSTANCE;
        return;
    L4:
        if (("getLocalFileIfValid url = " + r11) == null) goto L6;
        Context r10 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L47
    L6:
        boolean r15 = false;
        if (r11 != null) goto L9;
    L12:
        boolean r16 = true;
    L13:
        if (r16 == false) goto L16;
        r12.invoke(null);     // Catch: Exception -> L47
        return;
    L16:
        final String r17 = StringsKt.substringAfterLast$default(r11, "/", null, 2, null);     // Catch: Exception -> L47
        if (("keyIdentifyValue = " + r17) == null) goto L19;
        Context r18 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L47
    L19:
        String r19 = ((Keva) this.a.getValue()).getString(this.b, "");     // Catch: Exception -> L47
        if (("localIdentify = " + r19) == null) goto L23;
        Context r20 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L47
    L23:
        if (Intrinsics.areEqual(r19, r17) == false) goto L38;
        Context r21 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L47
        String r1 = ((Keva) this.a.getValue()).getString(this.c, "");     // Catch: Exception -> L47
        String r22 = "localFilePath = " + r1;     // Catch: Exception -> L47
        if (r1 != null) goto L27;
    L28:
        r15 = true;
    L29:
        if (r15 == true) goto L38;
        PolarisFileWrapper r23 = new PolarisFileWrapper(r1);     // Catch: Exception -> L47
        if (r23.exists() == false) goto L38;
        Reader r24 = new InputStreamReader(new PolarisFileInputStreamWrapper(r23), Charsets.UTF_8);     // Catch: Exception -> L47
        if ((r24 instanceof BufferedReader) == false) goto L35;
        BufferedReader r25 = (BufferedReader) r24;     // Catch: Exception -> L47
    L36:
        List r110 = TextStreamsKt.readLines(r25);     // Catch: Exception -> L47
        String r26 = "rTxtLines.size = " + r110.size();     // Catch: Exception -> L47
        r12.invoke(r110);     // Catch: Exception -> L47
        return;
    L35:
        r25 = new BufferedReader(r24, 8192);     // Catch: Exception -> L47
        goto L36
    L27:
        if (r1.length() != 0) goto L29;
    L38:
        Context r27 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L47
        PolarisFileWrapper r28 = new PolarisFileWrapper(com.bytedance.android.accessibilityLib_Core.helper.a.a().getExternalFilesDir(null), "r_accessibility");     // Catch: Exception -> L47
        if (r28.exists() == true) goto L41;
        r28.mkdirs();     // Catch: Exception -> L47
    L41:
        com.bytedance.android.accessibilityLib_Core.config.remote.subjob.a r29 = new com.bytedance.android.accessibilityLib_Core.config.remote.subjob.a(r11, r28.getAbsolutePath());     // Catch: Exception -> L47
        b r30 = this.d;     // Catch: Exception -> L47
        if (r30 == null) goto L44;
        r30.a(r29, new LocalFileCheckJob$getLocalFileIfValid$$inlined$Try$lambda$1(r17, this, r11, r12));     // Catch: Exception -> L47
    L45:
        Unit r111 = Unit.INSTANCE;     // Catch: Exception -> L47
        return;
    L44:
        r12.invoke(null);     // Catch: Exception -> L47
        goto L45
    L9:
        if (r11.length() == 0) goto L12;
        r16 = false;
        goto L13
    }
}

package com.larus.dora.impl.feedback;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j implements qk4.n.c {
    public final /* synthetic */ kotlinx.coroutines.i<String> a;
    public final /* synthetic */ l b;

    public final void a(IOException r4) {
        if (r4 == null) goto L6;
        String r0 = r4.getMessage();
        if (r0 == null) goto L6;
    L7:
        String r1 = "Failed to fetch logs: ".concat(r0);
        pk4.j.c("DoraGFeedbackViewModel", r1, r4);
        kotlinx.coroutines.i<String> r2 = this.a;
        Result.Companion r3 = Result.Companion;
        if (r4 != null) goto L10;
        r4 = new IOException(r1);
    L10:
        r2.resumeWith(Result.constructor-impl(ResultKt.createFailure(r4)));
        return;
    L6:
        r0 = "Unknown error";
        goto L7
    }

    public final void onSuccess(String r10) {
        boolean r5 = false;
        if (r10 != null) goto L38;
    L10:
        boolean r8 = true;
    L11:
        if (r8 == false) goto L14;
        pk4.j.b("DoraGFeedbackViewModel", "Log file path is null or empty");     // Catch: Exception -> L8
        kotlinx.coroutines.i<String> r0 = this.a;     // Catch: Exception -> L8
        Result.Companion r1 = Result.Companion;     // Catch: Exception -> L8
        r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("Log file path is null or empty"))));     // Catch: Exception -> L8
        return;
    L14:
        pk4.j.d("DoraGFeedbackViewModel", "Temporary log file directory: " + r10);     // Catch: Exception -> L8
        PolarisFileWrapper r4 = new PolarisFileWrapper(r10);     // Catch: Exception -> L8
        if (r4.exists() == true) goto L18;
        String r11 = "Source log file does not exist: " + r10;     // Catch: Exception -> L8
        pk4.j.b("DoraGFeedbackViewModel", r11);     // Catch: Exception -> L8
        kotlinx.coroutines.i<String> r2 = this.a;     // Catch: Exception -> L8
        Result.Companion r3 = Result.Companion;     // Catch: Exception -> L8
        r2.resumeWith(Result.constructor-impl(ResultKt.createFailure(new FileNotFoundException(r11))));     // Catch: Exception -> L8
        return;
    L18:
        String r12 = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());     // Catch: Exception -> L8
        DoraDevice r6 = kj4.a.g().c();     // Catch: Exception -> L8
        if (r6 == null) goto L29;
        String r7 = r6.getSerialNumber();     // Catch: Exception -> L8
        if (r7 == null) goto L29;
        if (r7.length() <= 0) goto L25;
        r5 = true;
    L25:
        if (r5 == true) goto L28;
        r7 = null;
    L28:
        if (r7 == null) goto L29;
    L30:
        this.b.e = "DoraG_" + r12 + '_' + r7 + ".zip";     // Catch: Exception -> L8
        PolarisFileWrapper r13 = new PolarisFileWrapper(r4.getParentFile(), this.b.e);     // Catch: Exception -> L8
        if (r4.renameTo(r13) == true) goto L34;
        String r14 = "Failed to rename log file from " + r4.getName() + " to " + this.b.e;     // Catch: Exception -> L8
        pk4.j.b("DoraGFeedbackViewModel", r14);     // Catch: Exception -> L8
        kotlinx.coroutines.i<String> r9 = this.a;     // Catch: Exception -> L8
        Result.Companion r15 = Result.Companion;     // Catch: Exception -> L8
        r9.resumeWith(Result.constructor-impl(ResultKt.createFailure(new IOException(r14))));     // Catch: Exception -> L8
        return;
    L34:
        String r16 = r13.getAbsolutePath();     // Catch: Exception -> L8
        pk4.j.d("DoraGFeedbackViewModel", "Log file processed successfully. Path: " + r16);     // Catch: Exception -> L8
        this.a.resumeWith(Result.constructor-impl(r16));     // Catch: Exception -> L8
        return;
    L29:
        r7 = "unknown_sn";
        goto L30
    L38:
    L8:
        e = move-exception;
        pk4.j.c("DoraGFeedbackViewModel", "Error processing log file", e);
        kotlinx.coroutines.i<String> r17 = this.a;
        Result.Companion r18 = Result.Companion;
        r17.resumeWith(Result.constructor-impl(ResultKt.createFailure(e)));
        return;
    L5:
        if (r10.length() == 0) goto L10;
        r8 = false;
        goto L11
    }

    public j(kotlinx.coroutines.j r1, l r2) {
        this.a = r1;
        this.b = r2;
    }
}

package com.obric.assistant.reporter;

import android.content.Context;
import by7.g;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r13) {
        Intrinsics.checkNotNullParameter(r13, "context");
        PolarisFileWrapper r2 = new PolarisFileWrapper(r13.getFilesDir(), "obric_dialog_click_cache.txt");     // Catch: Exception -> L28
        if (r2.exists() == false) goto L30;
        PolarisFileInputStreamWrapper r3 = new PolarisFileInputStreamWrapper(r2);     // Catch: Exception -> L28
        FileChannel r4 = r3.getChannel();     // Catch: Throwable -> L23
        FileLock r5 = r4.lock(0, Long.MAX_VALUE, true);     // Catch: Throwable -> L18
        byte[] r6 = new byte[(int) r4.size()];     // Catch: Throwable -> L15
        r3.read(r6);     // Catch: Throwable -> L15
        String r7 = new String(r6, Charsets.UTF_8);     // Catch: Throwable -> L15
        r5.release();     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L23
        CloseableKt.closeFinally(r3, null);     // Catch: Exception -> L28
    L31:
        String r8 = r7;
        if (StringsKt.isBlank(r8) == false) goto L34;
        return;
    L34:
        Iterator r9 = StringsKt.split$default(r8, new String[]{"\n"}, false, 0, 6, null).iterator();
    L36:
        if (r9.hasNext() == false) goto L84;
        String r10 = StringsKt.trim((String) r9.next()).toString();
        if (r10.length() != 0) goto L40;
        boolean r11 = true;
    L41:
        if (r11 == true) goto L36;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L44
        JSONObject r14 = new JSONObject(r10);     // Catch: Throwable -> L44
        g.d.onEvent("obric_dialog_click", r14);     // Catch: Throwable -> L44
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L46:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L36;
        r16.toString();
    L44:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L46
    L40:
        r11 = false;
        goto L41
    L84:
        PolarisFileWrapper r18 = new PolarisFileWrapper(r13.getFilesDir(), "obric_dialog_click_cache.txt");     // Catch: Exception -> L74
        if (r18.exists() == false) goto L102;
        RandomAccessFile r19 = new RandomAccessFile(r18, "rw");     // Catch: Exception -> L74
        FileChannel r0 = r19.getChannel();     // Catch: Throwable -> L69
        FileLock r20 = r0.lock();     // Catch: Throwable -> L64
        r0.truncate(0);     // Catch: Throwable -> L61
        r19.getFD().sync();     // Catch: Throwable -> L61
        r20.release();     // Catch: Throwable -> L64
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L64
        CloseableKt.closeFinally(r0, null);     // Catch: Throwable -> L69
        CloseableKt.closeFinally(r19, null);     // Catch: Exception -> L74
        return;
    L61:
        th = move-exception;
        r20.release();     // Catch: Throwable -> L64
        throw th;     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        throw th;     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);     // Catch: Throwable -> L69
        throw th;     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        throw th;     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        CloseableKt.closeFinally(r19, th);     // Catch: Exception -> L74
        throw th;     // Catch: Exception -> L74
    L102:
        return;
    L74:
        e = move-exception;
        e.toString();
        return;
    L15:
        th = move-exception;
        r5.release();     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: Exception -> L28
        throw th;     // Catch: Exception -> L28
    L30:
        r7 = "";
    L28:
        e = move-exception;
        e.toString();
        goto L30
    }
}

package com.larus.business.debug.base.audio.module;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.Map;
import kotlin.io.FilesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class a0 implements Runnable {
    public final /* synthetic */ TTSModule a;

    public /* synthetic */ a0(TTSModule r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TTSModule r0 = this.a;
        boolean r1 = AudioDebugUtil.a;
        String r2 = r0.d;
        if (AudioDebugUtil.c == false) goto L70;
        PolarisFileWrapper r3 = new PolarisFileWrapper(r2);     // Catch: Exception -> L56
        if (r3.exists() == false) goto L55;
        Iterator r4 = ((Map) new Gson().fromJson(FilesKt.readText$default(r3, null, 1, null), new b0().getType())).entrySet().iterator();     // Catch: Exception -> L56
    L9:
        if (r4.hasNext() == false) goto L72;
        Map.Entry r5 = (Map.Entry) r4.next();     // Catch: Exception -> L56
        Object r6 = r5.getValue();     // Catch: Exception -> L56
        if ((r6 instanceof a68.c) == false) goto L15;
        a68.c r7 = (a68.c) r6;     // Catch: Exception -> L56
    L16:
        String r8 = "";
        if (r7 == null) goto L20;
        String r9 = r7.a();     // Catch: Exception -> L56
        if (r9 == null) goto L20;
    L21:
        Object r10 = r5.getValue();     // Catch: Exception -> L56
        if ((r10 instanceof a68.c) == false) goto L24;
        a68.c r11 = (a68.c) r10;     // Catch: Exception -> L56
    L25:
        if (r11 == null) goto L28;
        String r12 = r11.c();     // Catch: Exception -> L56
        if (r12 == null) goto L28;
    L29:
        Object r13 = r5.getValue();     // Catch: Exception -> L56
        if ((r13 instanceof a68.c) == false) goto L32;
        a68.c r14 = (a68.c) r13;     // Catch: Exception -> L56
    L33:
        if (r14 == null) goto L38;
        String r15 = r14.e();     // Catch: Exception -> L56
        if (r15 == null) goto L38;
        r8 = r15;
    L38:
        boolean r16 = false;
        if (StringsKt.contains$default(r8, "header", false, 2, null) == true) goto L9;
        if (r9.length() != 0) goto L43;
        boolean r17 = true;
    L44:
        if (r17 == true) goto L48;
        if (new PolarisFileWrapper(r9).exists() == false) goto L9;
    L48:
        if (r12.length() != 0) goto L50;
        r16 = true;
    L50:
        if (r16 == true) goto L53;
        if (new PolarisFileWrapper(r12).exists() == false) goto L9;
    L53:
        r0.c.put(r5.getKey(), r5.getValue());     // Catch: Exception -> L56
        goto L9
    L43:
        r17 = false;
        goto L44
    L32:
        r14 = null;
    L28:
        r12 = "";
        goto L29
    L24:
        r11 = null;
    L20:
        r9 = "";
        goto L21
    L15:
        r7 = null;
        goto L16
    L72:
        return;
    L55:
        return;
    L71:
        return;
    }
}

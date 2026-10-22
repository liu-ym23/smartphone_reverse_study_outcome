package com.larus.business.debug.base.audio.module;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.Map;
import kotlin.io.FilesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ ASRModule a;

    public /* synthetic */ a(ASRModule r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ASRModule r0 = this.a;
        boolean r1 = AudioDebugUtil.a;
        String r2 = r0.b;
        if (AudioDebugUtil.c == false) goto L38;
        PolarisFileWrapper r3 = new PolarisFileWrapper(r2);     // Catch: Exception -> L29
        if (r3.exists() == false) goto L28;
        Iterator r4 = ((Map) new Gson().fromJson(FilesKt.readText$default(r3, null, 1, null), new c().getType())).entrySet().iterator();     // Catch: Exception -> L29
    L9:
        if (r4.hasNext() == false) goto L40;
        Map.Entry r5 = (Map.Entry) r4.next();     // Catch: Exception -> L29
        Object r6 = r5.getValue();     // Catch: Exception -> L29
        if ((r6 instanceof a68.a) == false) goto L14;
        a68.a r7 = (a68.a) r6;     // Catch: Exception -> L29
    L15:
        if (r7 == null) goto L18;
        String r8 = r7.a();     // Catch: Exception -> L29
        if (r8 == null) goto L18;
    L20:
        if (r8.length() != 0) goto L22;
        boolean r9 = true;
    L23:
        if (r9 == true) goto L26;
        if (new PolarisFileWrapper(r8).exists() == false) goto L9;
    L26:
        r0.a.put(r5.getKey(), r5.getValue());     // Catch: Exception -> L29
        goto L9
    L22:
        r9 = false;
    L18:
        r8 = "";
        goto L20
    L14:
        r7 = null;
        goto L15
    L40:
        return;
    L28:
        return;
    L39:
        return;
    }
}

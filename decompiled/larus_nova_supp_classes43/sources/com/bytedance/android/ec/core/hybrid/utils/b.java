package com.bytedance.android.ec.core.hybrid.utils;

import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.host.api.core.api.ImagePreloadConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ ImagePreloadConfig c;

    public b(long r1, Map r10, ImagePreloadConfig r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final void a() {
        List r0 = (List) this.b.get(Long.valueOf(this.a));
        if (r0 == null) goto L8;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        String r10 = (String) r1.next();
        Map<String, JSONObject> r11 = c.a;
        ImageExtensionsKt.B(r10, c.a(this.c.getBizTag(), this.c.getSceneTag(), c.b), null, null, this.c.getPriority(), null, null, false, 192);
        goto L6
    L10:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

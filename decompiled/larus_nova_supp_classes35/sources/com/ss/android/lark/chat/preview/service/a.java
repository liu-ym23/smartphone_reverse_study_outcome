package com.ss.android.lark.chat.preview.service;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Runnable {
    public final /* synthetic */ d a;
    public final /* synthetic */ HashMap<String, UrlCardPreviewEntity> b;

    public a(d r1, HashMap<String, UrlCardPreviewEntity> r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList<ucb.a> r0 = this.a.a;     // Catch: Throwable -> L7
        HashMap<String, UrlCardPreviewEntity> r1 = this.b;     // Catch: Throwable -> L7
        Iterator<ucb.a> r2 = r0.iterator();     // Catch: Throwable -> L7
    L4:
        if (r2.hasNext() == false) goto L16;
        r2.next().a(r1);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}

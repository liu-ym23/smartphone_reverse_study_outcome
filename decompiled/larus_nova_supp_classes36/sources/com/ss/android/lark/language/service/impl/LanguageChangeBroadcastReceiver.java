package com.ss.android.lark.language.service.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class LanguageChangeBroadcastReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int b = 0;
    public final CopyOnWriteArrayList<zob.b> a;

    public LanguageChangeBroadcastReceiver() {
        this.a = new CopyOnWriteArrayList();
    }

    public static String a(Context r1) {
        return r1.getPackageName() + ".language.permissions.LANGUAGE_BROADCAST";
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r3, Intent r4) {
        Locale r5 = (Locale) r4.getSerializableExtra("KEY_ORIGIN_LOCALE");     // Catch: Exception -> L9
        Locale r6 = (Locale) r4.getSerializableExtra("KEY_NEW_LOCALE");     // Catch: Exception -> L9
        Iterator<zob.b> r0 = this.a.iterator();     // Catch: Exception -> L9
    L4:
        if (r0.hasNext() == false) goto L19;
        zob.b r1 = r0.next();     // Catch: Exception -> L9
        if (r1 == null) goto L4;
        r1.a(r5, r6);     // Catch: Exception -> L9
        goto L4
    L19:
        return;
    L9:
        e = move-exception;
        Log.e("LanguageChangeBroadcast", "language broadcast receiver occurs error: " + e.getMessage());
    }
}

package com.ss.android.lark.language.service.impl;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.language.api.LocaleWatchScene;
import com.ss.android.lark.log.Log;
import cpb.d;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import yob.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class SystemLocaleChangeReceiver extends BroadcastReceiver {
    public apb.b a;

    public SystemLocaleChangeReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r3, Intent r4) {
        if (this.a != null) goto L6;
        e.a().getClass();
        int r0 = a.f;
        this.a = a.b.a;
    L6:
        if ("android.intent.action.LOCALE_CHANGED".equals(r4.getAction()) == true) goto L8;
        return;
    L8:
        if (this.a.a() == false) goto L10;
        System.exit(0);
        return;
    L10:
        Log.d("LocaleChangeReceiver", "expect locale = " + this.a.getLanguageSetting() + ", curr = " + r3.getResources().getConfiguration().locale);
        Locale r5 = this.a.getLanguageSetting();
        e.a().getClass();
        Application r6 = com.larksuite.framework.utils.b.a;
        Intrinsics.checkNotNullParameter(LocaleWatchScene.CHANGE_LOCALE_FOLLOW_SYSTEM, "localeScene");
        Intrinsics.checkNotNullParameter(r6, "application");
        int r1 = cpb.c.a;
        int r2 = d.a;
        cpb.c.a.a(LocaleWatchScene.CHANGE_LOCALE_FOLLOW_SYSTEM, r6, r5, d.a.a(r6));
        this.a.m(com.larksuite.framework.utils.b.a, r5);
    }
}

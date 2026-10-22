package com.ss.android.lark.chameleonv2.container.webcontainer.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import com.ss.android.lark.officesdk.utils.di.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends View {
    public long a;
    public int b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ long d;
    public final /* synthetic */ int e;

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        if (r7.getAction() != 0) goto L36;
        long r1 = System.currentTimeMillis();
        int r8 = this.b;
        if (r8 != 0) goto L8;
        this.a = r1;
    L8:
        if ((r1 - this.a) <= this.d) goto L10;
        this.b = 0;
        goto L36
    L10:
        int r9 = r8 + 1;
        this.b = r9;
        if (r9 < this.e) goto L36;
        com.ss.android.lark.storage.a r10 = ChameleonDebugUtils.a;
        Context r11 = this.c;
        if (r11 != null) goto L16;
    L21:
        Activity r12 = null;
    L23:
        if (r12 == null) goto L34;
        com.ss.android.lark.storage.a r2 = ChameleonDebugUtils.a;
        Intrinsics.checkNotNullParameter(r12, "activity");
        if (b.a() == true) goto L38;
    L35:
        this.b = 0;
        goto L36
    L38:
        Intent r3 = new Intent("com.ss.android.lark.ACTION_CML_DEBUG_V2");     // Catch: Exception -> L32
        r3.addCategory("android.intent.category.DEFAULT");     // Catch: Exception -> L32
        r3.addFlags(268435456);     // Catch: Exception -> L32
        r3.setPackage(r12.getPackageName());     // Catch: Exception -> L32
        if (r12.getPackageManager().resolveActivity(r3, 0) != null) goto L30;
        j.b("CML_TAG_ChameleonDebugUtils", "CmlDebugActivity not resolve");     // Catch: Exception -> L32
    L37:
        goto L35
    L30:
        r12.startActivity(r3);     // Catch: Exception -> L32
    L32:
        e = move-exception;
        j.c("CML_TAG_ChameleonDebugUtils", "Failed to launch CmlDebugActivity", e);
        goto L35
    L34:
        j.b("CML_TAG_ChameleonDebugUtils", "Unable to find Activity from context");
    L16:
        if ((r11 instanceof ContextWrapper) == false) goto L21;
        if ((r11 instanceof Activity) == true) goto L19;
        r11 = ((ContextWrapper) r11).getBaseContext();
        goto L16
    L19:
        r12 = (Activity) r11;
    L36:
        return false;
    }

    public c(Context r1, long r2, int r4) {
        this.c = r1;
        this.d = r2;
        this.e = r4;
        super(r1);
    }
}

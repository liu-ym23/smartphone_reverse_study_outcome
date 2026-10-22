package com.bytedance.android.annie.pia;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.annie.ng.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements j {
    public final /* synthetic */ com.bytedance.android.annie.ng.d.a a;

    @Override // com.bytedance.android.annie.ng.j
    public final void onCallback() {
        c47.c r0 = b.a;
        Application r1 = this.a.a;
        Intrinsics.checkNotNullParameter(r1, "application");
        Context r10 = r1.getApplicationContext();
        if (r10 != null) goto L5;
        Context r11 = c47.c.a.a;
    L9:
        k47.b r12 = (k47.b) c47.b.b(k47.b.class);
        if (r12 == null) goto L13;
        r12.a(b.a);
        return;
    L13:
        return;
    L5:
        if (c47.c.a.a != null) goto L9;
        c47.c.a.a = r10;
        goto L9
    }

    public a(com.bytedance.android.annie.ng.d.a r1) {
        this.a = r1;
    }
}

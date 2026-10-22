package com.bytedance.android.bst.api;

import android.util.AndroidRuntimeException;
import android.view.View;
import com.bytedance.android.bst.api.ext.ExtKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public String a;
    public String b;
    public Object c;
    public String d;
    public int e;
    public g f;
    public final View g;

    public final d a() {
        if (this.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L8:
        d r1 = new d(this.g);
        r1.a = this.a;
        String r10 = this.b;
        if (r10 == null) goto L17;
        r1.b = r10;
        r1.c = this.c;
        r1.d = this.d;
        r1.e = this.e;
        g r11 = this.f;
        if (r11 == null) goto L15;
        r1.f = r11;
        return r1;
    L15:
        throw new AndroidRuntimeException("reporter is null");
    L17:
        throw new AndroidRuntimeException("event is empty");
    L5:
        r0 = false;
        goto L6
    }

    public e(View r1) {
        this.g = r1;
        this.a = "";
        this.e = -1;
    }
}

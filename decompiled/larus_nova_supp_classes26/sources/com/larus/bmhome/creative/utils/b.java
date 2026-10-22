package com.larus.bmhome.creative.utils;

import android.net.Uri;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.kmp.chat.TemplateInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final TemplateInfo.TemplateInfo a;
    public final String b;
    public boolean c;
    public final UserCreation d;
    public final Uri e;
    public final boolean f;

    public b() {
        this(null, null, false, null, null, false, 63);
    }

    public b(TemplateInfo.TemplateInfo r3, String r4, boolean r5, UserCreation r6, Uri r7, boolean r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r5 = true;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r7 = null;
    L18:
        if ((r9 & 32) == 0) goto L20;
        r8 = false;
    L20:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }
}

package com.ss.ugc.effectplatform.model;

import bytekn.foundation.io.file.FileManager;
import com.ss.ugc.effectplatform.util.k;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d {
    public static final /* synthetic */ int g = 0;
    public String a;
    public String b;
    public String c;
    public int d;
    public boolean e;
    public final String f;

    public static final class a {
    }

    static {
    }

    public final String a() {
        String r0 = this.c;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L14;
        String r2 = FileManager.a;
        String r3 = FileManager.e(this.f);
        if (r3 == null) goto L14;
        this.c = k.b(r3);
    L14:
        return this.c;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public final String b() {
        String r0 = this.a;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L14;
        String r2 = FileManager.a;
        String r3 = FileManager.e(this.f);
        if (r3 == null) goto L14;
        this.a = k.d(r3);
    L14:
        return this.a;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public final int c() {
        if (this.d != (-1)) goto L13;
        String r0 = FileManager.a;
        if (FileManager.d(this.f) == false) goto L9;
        String r1 = FileManager.e(this.f);
        if (r1 == null) goto L9;
        int r2 = k.e(r1);
    L11:
        this.d = r2;
    L9:
        r2 = 0;
    L13:
        return this.d;
    }

    public final String d() {
        String r0 = this.b;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L21;
        String r2 = FileManager.a;
        String r3 = FileManager.e(this.f);
        if (r3 == null) goto L21;
        StringsKt.lastIndexOf$default(r3, "/", 0, false, 6, null);
        int r8 = StringsKt.lastIndexOf$default(r3, "_v", 0, false, 6, null);
        if (StringsKt.contains$default(r3, "size", false, 2, null) == false) goto L15;
        int r4 = StringsKt.lastIndexOf$default(r3, "_size", 0, false, 6, null);
    L16:
        if (r8 <= 0) goto L18;
        String r5 = StringsKt.replace$default(r3.substring(r8 + 2, r4), '_', '.', false, 4, null);
    L19:
        this.b = r5;
        goto L21
    L18:
        r5 = "1.0";
        goto L19
    L15:
        r4 = StringsKt.lastIndexOf$default(r3, "_model", 0, false, 6, null);
    L21:
        return this.b;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public final String toString() {
        return "LocalModelInfo{name=" + b() + "',version=" + d() + "',size=" + c() + "'}";
    }

    public d(String r1) {
        this.f = r1;
        this.d = -1;
    }
}

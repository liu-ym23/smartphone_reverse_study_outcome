package com.ss.ugc.effectplatform;

import com.ss.ugc.effectplatform.model.Effect;
import java.util.LinkedHashMap;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final String[] e;

    /* JADX INFO: renamed from: com.ss.ugc.effectplatform.a$a, reason: collision with other inner class name */
    public static final class C0009a {
    }

    static {
    }

    public a() {
        this.b = true;
        this.c = true;
        this.d = true;
        this.e = new String[0];
        new LinkedHashMap();
        this.a = true;
    }

    public final boolean a(Effect r3) {
        if (this.a == false) goto L5;
    L13:
        return true;
    L5:
        if (r3 != null) goto L7;
        boolean r4 = false;
    L8:
        if (r4 == true) goto L10;
        return false;
    L10:
        if (this.b == true) goto L12;
        return false;
    L12:
        if (this.c == true) goto L13;
        return false;
    L7:
        r4 = ArraysKt.contains(this.e, r3.getPanel());
        goto L8
    }
}

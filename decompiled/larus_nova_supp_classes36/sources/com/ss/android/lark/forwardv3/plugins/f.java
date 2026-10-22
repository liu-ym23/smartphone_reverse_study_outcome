package com.ss.android.lark.forwardv3.plugins;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public final Fragment a;
    public final Map<String, i> b;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if ((!this.b.isEmpty()) == false) goto L11;
        Iterator r0 = ((LinkedHashMap) this.b).values().iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        ((i) r0.next()).d();
        goto L6
    L8:
        ((LinkedHashMap) this.b).clear();
        return;
    }

    public f(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "rootFragment");
        this.a = r2;
        this.b = new LinkedHashMap();
    }

    public final i b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "name");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        return null;
    L10:
        if (this.b.containsKey(r3) == true) goto L14;
        Log.e("ForwardPluginManager", "plugin not found or disabled");
        return null;
    L14:
        return (i) ((LinkedHashMap) this.b).get(r3);
    L5:
        r0 = false;
        goto L7
    }

    public final void c(String r2, i r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "plugin");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.b.put(r2, r3);
        r3.c();
        return;
    L5:
        r0 = false;
        goto L6
    }
}

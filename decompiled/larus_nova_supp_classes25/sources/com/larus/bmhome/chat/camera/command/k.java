package com.larus.bmhome.chat.camera.command;

import com.larus.camera.api.params.CameraOutputContext;
import com.larus.platform.model.action.SuggestedAction;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k {
    public static final ConcurrentHashMap<String, t> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static void b(String r1) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        a.remove(r1);
        return;
    L11:
        return;
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static String a(CameraOutputContext r5, SuggestedAction r6) {
        Intrinsics.checkNotNullParameter(r5, "outputContext");
        final long r0 = System.currentTimeMillis();
        ConcurrentHashMap<String, t> r2 = a;
        CollectionsKt.removeAll(r2.entrySet(), new j(r0));
        String r1 = UUID.randomUUID().toString();
        r2.put(r1, new t.a(r5, r6, System.currentTimeMillis()));
        return r1;
    }
}

package com.obric.assistant.upload.internal;

import com.larus.bmhome.rc.ResourceCenter;
import com.larus.im.bean.message.UplinkFileEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricUploadEntityCache {
    public static final ObricUploadEntityCache$entityMap$1 a = null;
    public static final ObricUploadEntityCache$usedEntity$1 b = null;
    public static final Object c = null;

    static {
        a = new ObricUploadEntityCache$entityMap$1();
        b = new ObricUploadEntityCache$usedEntity$1();
        c = new Object();
    }

    public static List a(List r5) {
        Intrinsics.checkNotNullParameter(r5, "identifiers");
        ArrayList r0 = new ArrayList();
        Object r1 = c;
        monitor-enter(r1);
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L18
    L6:
        if (r6.hasNext() == false) goto L15;
        String r2 = (String) r6.next();     // Catch: Throwable -> L18
        UplinkFileEntity r3 = (UplinkFileEntity) b.get(r2);     // Catch: Throwable -> L18
        if (r3 == null) goto L6;
        ResourceCenter r4 = ResourceCenter.a;     // Catch: Throwable -> L18
        String r7 = r3.getFileIdentifier();     // Catch: Throwable -> L18
        if (r7 != null) goto L12;
        r7 = "";
    L12:
        r4.getClass();     // Catch: Throwable -> L18
        if (ResourceCenter.d(r7) == false) goto L6;
        r0.add(r3);     // Catch: Throwable -> L18
        goto L6
    L15:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r1);
        return r0;
    L18:
        th = move-exception;
        throw th;
    }

    public static void b(String r2, UplinkFileEntity r3) {
        Intrinsics.checkNotNullParameter(r2, "identifier");
        Intrinsics.checkNotNullParameter(r3, "entity");
        Object r0 = c;
        monitor-enter(r0);
        a.put(r2, r3);     // Catch: Throwable -> L7
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}

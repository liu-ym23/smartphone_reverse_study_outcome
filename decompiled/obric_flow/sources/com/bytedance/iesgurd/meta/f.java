package com.bytedance.iesgurd.meta;

import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.n;
import com.bytedance.iesgurd.IESGurdUpdatePriority;
import com.bytedance.iesgurd.core.ReqType;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f6652a = null;

    static {
        f6652a = new ConcurrentHashMap();
    }

    public static PrepareMeta a(String r5, String r10) {
        ConcurrentHashMap r11 = (ConcurrentHashMap) f6652a.get(r5);
        if (r11 != null) goto L5;
        return null;
    L5:
        return (PrepareMeta) r11.get(r10);
    }

    public static void b(Long r10, String r11, String r12) {
        ConcurrentHashMap r5 = (ConcurrentHashMap) f6652a.get(r11);
        if (r5 == null) goto L11;
        PrepareMeta r13 = (PrepareMeta) r5.get(r12);
        if (r13 == null) goto L12;
        if (r10 != null) goto L8;
    L9:
        GeckoLogger.a("remove update meta:" + r11 + ',' + r12 + ",version:" + r13.getVersion());
        r5.remove(r12);
        return;
    L8:
        if (r13.getVersion() == r10.longValue()) goto L9;
        return;
    L12:
        return;
    }

    public static void c(final String r11, final String r12) {
        ConcurrentHashMap r5 = (ConcurrentHashMap) f6652a.get(r11);
        if (r5 == null) goto L5;
        PrepareMeta r10 = (PrepareMeta) r5.get(r12);
    L6:
        if (r10 != null) goto L10;
        ConcurrentHashMap r13 = va.b.f22564a;
        com.bytedance.geckox.c r14 = com.bytedance.geckox.b.f4736a;
        return;
    L10:
        if (r10.getInQueue() == false) goto L12;
        return;
    L12:
        r10.setInQueue(true);
        r10.ignoreBlocks();
        r10.setReqType(ReqType.UPDATE_BY_ACCESS);
        n r15 = new n("", null, null, false, IESGurdUpdatePriority.f6592c, new PrepareMetaManager$updateWhenAccess$params$1(r11, r12), false, 926);
        AtomicInteger r16 = hf.f.f17317a;
        hf.f.a(CollectionsKt.listOf(r10), r15);
        return;
    L5:
        r10 = null;
        goto L6
    }
}

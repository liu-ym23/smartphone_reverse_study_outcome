package com.bytedance.iesgurd.request;

import com.bytedance.geckox.l;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.keva.Keva;
import io.reactivex.internal.schedulers.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f6675c;
    public final Object d;

    public e(long r5, Map.Entry r10, g r11) {
        this.f6673a = 0;
        this.f6674b = r5;
        this.f6675c = r10;
        this.d = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f6673a) {
            case 0: goto L17;
            default: goto L5;
        };
    L17:
        boolean r5 = l.b();
        long r10 = this.f6674b;
        g r11 = (g) this.d;
        if (r5 == true) goto L20;
        GeckoLogger.a("gecko disable, cold start cancel: " + r10 + ", " + r11.e);
        return;
    L20:
        GeckoLogger.a("cold start delay update begin: " + r10 + ", " + r11.e);
        ArrayList r12 = new ArrayList();
        Iterator r13 = ((Iterable) ((Map.Entry) this.f6675c).getValue()).iterator();
    L22:
        if (r13.hasNext() == false) goto L37;
        PrepareMeta r14 = (PrepareMeta) r13.next();
        Keva r15 = com.bytedance.iesgurd.meta.e.f6649a;
        ChannelMeta r16 = com.bytedance.iesgurd.meta.e.a(r14.getAccessKey(), r14.getChannel());
        if (r16 == null) goto L26;
        Long r17 = r16.getId();
    L27:
        long r18 = r14.getVersion();
        if (r17 == null) goto L33;
        if (r17.longValue() == r18) goto L22;
    L33:
        r14.setReqType(r11.e);
        PrepareMeta.updateBlockType$default(r14, false, 1, null);
        if (r14.getBlockType() != null) goto L22;
        r12.add(r14);
        goto L22
    L26:
        r17 = null;
        goto L27
    L37:
        if (r12.isEmpty() == true) goto L54;
        AtomicInteger r19 = hf.f.f17317a;
        hf.f.a(r12, r11.f6683j);
        return;
    L54:
        return;
    L5:
        if (((r) this.d).d == true) goto L50;
        r r20 = (r) this.d;
        TimeUnit r21 = TimeUnit.MILLISECONDS;
        r20.getClass();
        long r22 = r21.convert(System.currentTimeMillis(), r21);
        long r23 = this.f6674b;
        if (r23 <= r22) goto L14;
        Thread.sleep(r23 - r22);     // Catch: InterruptedException -> L11
    L11:
        e = move-exception;
        Thread.currentThread().interrupt();
        wn.f.k(e);
        return;
    L14:
        if (((r) this.d).d == true) goto L52;
        ((Runnable) this.f6675c).run();
        return;
    L52:
        return;
    }

    public e(Runnable r5, r r10, long r11) {
        this.f6673a = 1;
        this.f6675c = r5;
        this.d = r10;
        this.f6674b = r11;
    }
}

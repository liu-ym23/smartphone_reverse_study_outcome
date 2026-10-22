package com.bytedance.android.btm.impl.page;

import android.os.MessageQueue;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.BufferBtm;
import com.bytedance.android.btm.impl.chain.BtmChainRecorder;
import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import com.bytedance.android.btm.impl.util.SchemaPathUtil;
import com.bytedance.android.btm.impl.util.d;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BufferQueue {
    public static final String a = "BufferQueue_addBufferBtm";
    public static final String b = "BufferQueue_addBufferPageBtm";
    public static final String c = "BufferQueue_peekPreFromBuffer";
    public static final String d = "BufferQueue_pollPreFromBuffer";
    public static final String e = "BufferQueue_getSourceBtmForPageBuffer";
    public static final String f = "BufferQueue_updateBufferPageBtm";
    public static final String g = "key_page_buffer";
    public static final LinkedBlockingQueue<BufferBtm> h = null;
    public static BufferBtm i;
    public static final WeakHashMap<BufferBtm, com.bytedance.android.btm.api.model.b> j = null;
    public static final Map<String, BufferBtm> k = null;
    public static final Map<String, BufferBtm> l = null;
    public static final Map<String, Pair<String, String>> m = null;
    public static final Map<BufferBtm, BufferBtm> n = null;
    public static final Map<BufferBtm, BufferBtm> o = null;
    public static final Map<BufferBtm, String> p = null;

    static {
        a = "BufferQueue_addBufferBtm";
        b = "BufferQueue_addBufferPageBtm";
        c = "BufferQueue_peekPreFromBuffer";
        d = "BufferQueue_pollPreFromBuffer";
        e = "BufferQueue_getSourceBtmForPageBuffer";
        f = "BufferQueue_updateBufferPageBtm";
        g = "key_page_buffer";
        h = new LinkedBlockingQueue();
        j = new WeakHashMap();
        k = Collections.synchronizedMap(new BufferQueue$sourceBtmTokenBufferBtmMap$1());
        l = Collections.synchronizedMap(new BufferQueue$usedTokenMap$1());
        m = Collections.synchronizedMap(new BufferQueue$usedTokenRelatedInfoMap$1());
        n = Collections.synchronizedMap(new BufferQueue$tokenBuffer2QueueBufferMap$1());
        o = Collections.synchronizedMap(new BufferQueue$queueBuffer2TokenBufferMap$1());
        p = Collections.synchronizedMap(new BufferQueue$lifeCycleBufferBtmUsageMap$1());
    }

    public static void a(final BufferBtm r10) {
        BtmSetting r0 = BtmSetting.d;
        if (r0.c().d().u() != 1) goto L5;
        h.clear();
    L5:
        h.add(r10);
        com.bytedance.android.btm.impl.thread.b r1 = com.bytedance.android.btm.impl.thread.b.e;
        Runnable r11 = new BufferQueue$addBtmQueue$1(r10);
        long r12 = r0.c().c().j();
        r1.getClass();
        com.bytedance.android.btm.impl.thread.b.c().schedule(r11, r12, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L8
        return;
    }

    public static void c(String r10) {
        String r0 = BtmPageRecorder.a;
        PageInfo r1 = BtmPageRecorder.j(b.b);
        BufferBtm.b r11 = BufferBtm.Companion;
        String r12 = "btm_from_push:" + System.currentTimeMillis();
        if (r1 == null) goto L7;
        String r13 = r1.getPageShowId();
        if (r13 == null) goto L7;
    L8:
        a(BufferBtm.b.c(r11, r10, 1, r12, null, null, r13));
        return;
    L7:
        r13 = "";
        goto L8
    }

    public static BufferBtm h(final PageInfo r10) {
        final PageInfo r0 = r10.copy();
        ALogger r1 = ALogger.d;
        String r11 = e;
        ALogger.j(r1, r11, new BufferQueue$getSourceBtmForPageBuffer$1(r0));
        final BufferBtm r12 = i;
        if (r12 != null) goto L6;
        ALogger.j(r1, r11, BufferQueue$getSourceBtmForPageBuffer$2.INSTANCE);
        return null;
    L6:
        Lazy r13 = BtmFormatUtils.a;
        if (Intrinsics.areEqual(BtmFormatUtils.g(r10.getBtmPre()), BtmFormatUtils.g("a0.b0.c0.d0")) == true) goto L9;
        String r14 = r10.getBtmPre();
        if (r14 != null) goto L19;
    L27:
        ALogger.j(r1, r11, new BufferQueue$getSourceBtmForPageBuffer$4(r12, r0));
        return r12;
    L19:
        if (r14.length() <= 0) goto L21;
        boolean r15 = true;
    L22:
        if (r15 != true) goto L27;
        if (r10.isFirstResumeV2() == true) goto L27;
        ALogger.j(r1, r11, new BufferQueue$getSourceBtmForPageBuffer$$inlined$let$lambda$2(r10, r0, r12));
        return null;
    L21:
        r15 = false;
        goto L22
    L9:
        if (r10.isFirstPage() == true) goto L11;
        return r12;
    L11:
        if (r10.isFirstResumeV2() == true) goto L13;
    L14:
        ALogger.j(r1, r11, new BufferQueue$getSourceBtmForPageBuffer$$inlined$let$lambda$1(r10, r0, r12));
        return null;
    L13:
        if (BtmSetting.d.c().d().p() != 1) goto L14;
        return r12;
    }

    public static BufferBtm i(final String r14) {
        ALogger r0 = ALogger.d;
        String r1 = c;
        ALogger.j(r0, r1, new BufferQueue$peekPreFromBuffer$1(r14));
        LinkedBlockingQueue<BufferBtm> r10 = h;
        if (r10.isEmpty() == false) goto L6;
        ALogger.j(r0, r1, BufferQueue$peekPreFromBuffer$2.INSTANCE);
        return null;
    L6:
        Iterator<BufferBtm> r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L21;
        final BufferBtm r12 = r11.next();
        if (r14 == null) goto L17;
        if ((!r12.getTargetPagesBtm().isEmpty()) == false) goto L17;
        if (f(r12, r14) == true) goto L17;
        ALogger.j(ALogger.d, c, new BufferQueue$peekPreFromBuffer$3$1(r12));
    L17:
        if (r12.getStep() != 0) goto L19;
        BtmMonitor.k(BtmMonitor.c, 1018, r12.toString(), null, null, true, false, null, false, null, null, 1004);
    L19:
        ALogger.j(ALogger.d, c, new BufferQueue$peekPreFromBuffer$3$2(r12));
        return r12;
    L21:
        ALogger.j(ALogger.d, c, BufferQueue$peekPreFromBuffer$4.INSTANCE);
        return null;
    }

    public static void k(final BufferBtm r10) {
        if (r10 == null) goto L4;
        i = r10;
    L4:
        ALogger.j(ALogger.d, f, new BufferQueue$updateBufferPageBtm$2(r10));
    }

    public static boolean f(BufferBtm r10, String r11) {
        String r12 = BtmFormatUtils.b(r11);
        if (r12.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return false;
    L8:
        List<String> r13 = r10.getTargetPagesBtm();
        if ((r13 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r14 = r13.iterator();
    L15:
        if (r14.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(BtmFormatUtils.b((String) r14.next()), r12) == false) goto L15;
        return true;
    L19:
        return false;
    L11:
        if (r13.isEmpty() == false) goto L13;
    L5:
        r0 = false;
        goto L6
    }

    public static BufferBtm j(final String r12, PageInfo r13) {
        ALogger r0 = ALogger.d;
        String r1 = d;
        ALogger.j(r0, r1, new BufferQueue$pollPreFromBuffer$1(r12));
        if (h.isEmpty() == false) goto L6;
        ALogger.j(r0, r1, BufferQueue$pollPreFromBuffer$2.INSTANCE);
        return null;
    L6:
        LinkedBlockingQueue<BufferBtm> r10 = h;
        BufferBtm r11 = r10.peek();
        if (r11 == null) goto L55;
        boolean r14 = false;
        if (r12 != null) goto L11;
    L15:
        boolean r15 = false;
    L16:
        if (r15 == false) goto L21;
        r10.poll();
        if (r10.isEmpty() == false) goto L6;
        ALogger.j(ALogger.d, d, BufferQueue$pollPreFromBuffer$4.INSTANCE);
        return null;
    L21:
        final BufferBtm r16 = r10.peek();
        if (r16 == null) goto L55;
        BtmSetting r17 = BtmSetting.d;
        if (r17.c().b().I() != 1) goto L47;
        if (r13 == null) goto L47;
        if (r17.c().b().J() != 1) goto L32;
        if (Intrinsics.areEqual(r16.getPageId(), r13.getPageId()) == false) goto L32;
        return null;
    L32:
        if (r13.isFirstResumeV2() == false) goto L35;
        d r18 = d.a;
        goto L47
    L35:
        if (r16.getStep() <= r13.getStep()) goto L47;
        if (r13.getStep() <= 0) goto L47;
        String r19 = r13.getBtmPre();
        if (r19 == null) goto L47;
        if (r19.length() <= 0) goto L43;
        r14 = true;
    L43:
        if (r14 != true) goto L47;
        final PageInfo r110 = r13.copy();
        ALogger.j(ALogger.d, d, new BufferQueue$pollPreFromBuffer$5(r16, r110));
        return null;
    L47:
        if (r16.getUseTimes() <= 1) goto L49;
        r16.setUseTimes(r16.getUseTimes() - 1);
    L51:
        if (r16.getStep() != 0) goto L53;
        BtmMonitor.k(BtmMonitor.c, 1018, r16.toString(), null, null, true, false, null, false, null, null, 1004);
    L53:
        ALogger.j(ALogger.d, d, new BufferQueue$pollPreFromBuffer$6(r16));
        return r16;
    L49:
        r10.poll();
        goto L51
    L11:
        if ((!r11.getTargetPagesBtm().isEmpty()) == false) goto L15;
        if (f(r11, r12) == true) goto L15;
        r15 = true;
    L55:
        return null;
    }

    public static BufferBtm g(final String r10, final String r11, Function1 r12) {
        ALogger r0 = ALogger.d;
        ALogger.g(r0, "SourceBtmToken:fetchBufferBtmBySourceBtmToken", new BufferQueue$fetchBufferBtmBySourceBtmToken$1(r10, r11));
        boolean r1 = false;
        if (r10 != null) goto L5;
    L8:
        boolean r13 = true;
    L10:
        if (r13 == false) goto L13;
        Unit r14 = (Unit) r12.invoke("source_btm_token is null");
        return null;
    L13:
        int r15 = SchemaPathUtil.a;
        BtmSetting r16 = BtmSetting.d;
        if (r16.c().c().F().f() != 0) goto L16;
        r1 = true;
    L16:
        if (r1 == false) goto L19;
        Unit r17 = (Unit) r12.invoke("schema function is turn off");
        return null;
    L19:
        final Ref.ObjectRef r18 = new Ref.ObjectRef();
        Map<String, BufferBtm> r19 = k;
        BufferBtm r20 = r19.get(r10);
        r18.element = r20;
        if (r20 == null) goto L22;
        r19.remove(r10);
    L24:
        if (r16.c().c().J() != 1) goto L34;
        BufferBtm r21 = (BufferBtm) r18.element;
        if (r21 == null) goto L32;
        Map<String, BufferBtm> r22 = l;
        BufferBtm.Companion.getClass();
        r22.put(r10, BufferBtm.b.a(r21));
        if (r16.c().b().X() != 1) goto L34;
        if (h.remove((BufferBtm) r18.element) == true) goto L34;
        MessageQueue r23 = com.bytedance.android.btm.impl.util.b.a;
        com.bytedance.android.btm.impl.util.b.a(new BufferQueue$fetchBufferBtmBySourceBtmToken$3(r10));
        goto L34
    L32:
        Unit r24 = (Unit) r12.invoke("token has consumed repeat");
        r18.element = l.get(r10);
    L34:
        if (((BufferBtm) r18.element) != null) goto L36;
        Unit r110 = (Unit) r12.invoke("get pre from sourceBtmToken fail");
        ALogger.g(r0, "SourceBtmToken:fetchBufferBtmBySourceBtmToken", new BufferQueue$fetchBufferBtmBySourceBtmToken$4(r10, r11));
    L38:
        return (BufferBtm) r18.element;
    L36:
        ALogger.g(r0, "SourceBtmToken:fetchBufferBtmBySourceBtmToken", new BufferQueue$fetchBufferBtmBySourceBtmToken$5(r10, r18, r11));
        goto L38
    L22:
        MessageQueue r25 = com.bytedance.android.btm.impl.util.b.a;
        com.bytedance.android.btm.impl.util.b.a(new BufferQueue$fetchBufferBtmBySourceBtmToken$2(r10));
        Unit r26 = (Unit) r12.invoke("Get buffer btm error by token");
        goto L24
    L5:
        if (r10.length() == 0) goto L8;
        r13 = false;
        goto L10
    }

    public static BufferBtm d(final String r12, PageInfo r13, final String r14, final String r15, Object r16) {
        final BufferBtm r10 = BufferBtm.b.c(BufferBtm.Companion, r12, r13.getStep(), r13.getPageId(), r14, r15, r13.getPageShowId());
        final PageInfo r11 = r13.copy();
        ALogger r17 = ALogger.d;
        String r18 = b;
        ALogger.j(r17, r18, new BufferQueue$addBufferPageBtm$1(r12, r11, r14, r15, r10));
        boolean r1 = true;
        if ((BtmSetting.d.c().c().G() & 1) == 0) goto L5;
        com.bytedance.android.btm.api.model.b r0 = new com.bytedance.android.btm.api.model.b(0);
        r13.setLatestPageBtmIdNode(r0);
        r0.c = r12;
        r0.a = r13.getPageShowId();
    L5:
        String r19 = BtmPageRecorder.a;
        BtmPageRecorder.q(r12, r13, false);
        i = r10;
        j.put(r10, r13.getLatestPageBtmIdNode());
        r13.setLatestPageBtmId(r12);
        String r20 = r13.getBtmPre();
        if (r20 != null) goto L8;
    L11:
        if (r1 == false) goto L13;
        ALogger.j(r17, r18, BufferQueue$addBufferPageBtm$3.INSTANCE);
    L19:
        return r10;
    L13:
        BtmChainRecorder r21 = com.bytedance.android.btm.impl.b.e.c();
        r21.d(r12, r20, false);
        com.bytedance.android.btm.impl.chain.a r22 = r21.b();
        if (r22 == null) goto L16;
        r22.a(r12, r13, null, r16);
    L16:
        com.bytedance.android.btm.api.model.b r23 = r13.getLatestPageBtmIdNode();
        if (r23 == null) goto L19;
        r23.b = r13.getPreBtmIdNode();
        goto L19
    L8:
        if (r20.length() == 0) goto L11;
        r1 = false;
        goto L11
    }

    public static void e(String r10, int r11, String r12, String r13, String r14, String r15) {
        BufferBtm.b r0 = BufferBtm.Companion;
        if (r13 != null) goto L6;
        r13 = "";
    L6:
        BufferBtm r16 = BufferBtm.b.c(r0, r10, r11, r12, r14, r15, r13);
        k.put(r10, r16);
    }

    public static void b(final String r14, final int r15, final List r16, PageInfo r17, final String r18, final String r19, boolean r20, BcmParams r21, Object r22) {
        BufferBtm.b r0 = BufferBtm.Companion;
        int r1 = r17.getStep();
        String r10 = r17.getPageId();
        String r11 = r17.getPageShowId();
        r0.getClass();
        final BufferBtm r12 = BufferBtm.b.b(r14, r1, r10, r18, r19, r11, r15, r16);
        final PageInfo r13 = r17.copy();
        ALogger r110 = ALogger.d;
        String r111 = a;
        ALogger.j(r110, r111, new BufferQueue$addBufferBtm$1(r14, r15, r16, r13, r18, r19, r12));
        a(r12);
        if (r20 == false) goto L8;
        BufferBtm r23 = BufferBtm.b.a(r12);
        k.put(r14, r23);
        if (BtmSetting.d.c().d().h().contains(2312) == true) goto L7;
        n.put(r23, r12);
        o.put(r12, r23);
    L7:
        MessageQueue r24 = com.bytedance.android.btm.impl.util.b.a;
        com.bytedance.android.btm.impl.util.b.a(new BufferQueue$addSourceBtmTokenBufferBtmMap$1(r14, r12, r17));
    L8:
        j.put(r12, r17.getLatestBtmIdNode());
        String r25 = r17.getBtmPre();
        r17.setLatestBtmId(r14);
        if (r25 != null) goto L11;
    L14:
        boolean r26 = true;
    L15:
        if (r26 == false) goto L17;
        ALogger.j(r110, r111, BufferQueue$addBufferBtm$2.INSTANCE);
        return;
    L17:
        BtmChainRecorder r27 = com.bytedance.android.btm.impl.b.e.c();
        r27.d(r14, r25, false);
        com.bytedance.android.btm.impl.chain.a r28 = r27.b();
        if (r28 == null) goto L23;
        if (r20 == false) goto L21;
        BcmParams r29 = r21;
    L22:
        r28.a(r14, r17, r29, r22);
        goto L23
    L21:
        r29 = null;
    L23:
        com.bytedance.android.btm.api.model.b r30 = r17.getLatestBtmIdNode();
        if (r30 == null) goto L28;
        r30.b = r17.getPreBtmIdNode();
        return;
    L28:
        return;
    L11:
        if (r25.length() == 0) goto L14;
        r26 = false;
        goto L15
    }
}

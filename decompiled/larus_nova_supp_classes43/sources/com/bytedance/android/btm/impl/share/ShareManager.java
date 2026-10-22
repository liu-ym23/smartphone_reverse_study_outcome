package com.bytedance.android.btm.impl.share;

import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.p;
import com.bytedance.android.btm.impl.BtmIdCreator;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.BufferQueue;
import com.bytedance.android.btm.impl.page.b;
import com.bytedance.android.btm.impl.page.lifecycle.layer3.BtmPageLifecycleCallbackV2;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.page.model.i;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import com.bytedance.android.btm.impl.util.f;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ShareManager {
    static {
    }

    public static void a(p r12) {
        if (BtmSetting.d.c().c().n() == 1) goto L5;
        return;
    L5:
        String r13 = r12.getType();
        BtmHostDependManager r0 = BtmHostDependManager.F;
        r0.getClass();
        String r14 = (String) ((Map) BtmHostDependManager.D.getValue(r0, BtmHostDependManager.a[24])).get(r13);
        Object r1 = null;
        if (r14 == null) goto L8;
        final String r15 = r14.concat(".d0");
    L9:
        if (r15 != null) goto L11;
        return;
    L11:
        if (BtmPageLifecycleCallbackV2.a == false) goto L13;
        ALogger.d.b("PushManager", false, ShareManager$setShareNodeInfo$1.INSTANCE);
        String r10 = BufferQueue.a;
        Lazy r11 = BtmFormatUtils.a;
        BufferQueue.c(BtmFormatUtils.a("a1128.b30506.".concat(r15)));
        return;
    L13:
        ALogger r16 = ALogger.d;
        r16.b("PushManager", false, ShareManager$getTopPage$1.INSTANCE);
        final Object r17 = b.b;
        if (r17 == null) goto L16;
        r16.b("PushManager", false, new ShareManager$getTopPage$2$1(r17));
        r1 = b.b;
    L26:
        if (r1 == null) goto L28;
        BtmIdCreator.f.c(new BtmItemBuilder(r15, Boolean.TRUE).withPageFinder(PageFinder.via(r1)).build());
        return;
    L28:
        final i r18 = BtmPageLifecycleCallbackV2.h;
        if (r18 == null) goto L40;
        r16.b("PushManager", false, ShareManager$setShareNodeInfo$2$1.INSTANCE);
        PageInfo r19 = r18.b;
        if (r19 == null) goto L41;
        r16.b("PushManager", false, new ShareManager$setShareNodeInfo$$inlined$apply$lambda$1(r18, r15));
        StringBuilder r20 = new StringBuilder();
        Lazy r21 = BtmFormatUtils.a;
        r20.append(BtmFormatUtils.b(r19.getPageBtm()));
        r20.append('.');
        r20.append(r15);
        String r22 = r20.toString();
        String r110 = BufferQueue.a;
        ArrayList r23 = new ArrayList();
        PageInfo r24 = r18.b;
        if (r24 != null) goto L35;
        Intrinsics.throwNpe();
    L35:
        BufferQueue.b(r22, 1, r23, r24, null, null, false, null, null);
        return;
    L41:
        return;
    L40:
        return;
    L16:
        i r25 = BtmPageLifecycleCallbackV2.h;
        if (r25 == null) goto L25;
        f<Object> r26 = r25.a;
        if (r26 == null) goto L25;
        final Object r27 = r26.get();
        if (r27 == null) goto L25;
        String r28 = BtmPageRecorder.a;
        if (BtmPageRecorder.j(r27) == null) goto L25;
        r16.b("PushManager", false, new ShareManager$getTopPage$3$1$1(r27));
        r1 = r27;
    L25:
        r16.b("PushManager", false, ShareManager$getTopPage$4.INSTANCE);
        goto L26
    L8:
        r15 = null;
        goto L9
    }
}

package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.CaptureAssemblyGiftResultModel;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l2 extends w20.m<w20.u7, CaptureAssemblyGiftResultModel> {
    public final com.bytedance.android.scope.j a;

    public l2(com.bytedance.android.scope.j r1) {
        this.a = r1;
    }

    public final void invoke(Object r11, CallContext r12) {
        w20.u7 r13 = (w20.u7) r11;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "context");
        com.bytedance.android.scope.j r14 = this.a;
        if (r14 == null) goto L57;
        com.bytedance.android.livesdk.gift.platform.core.scope.service.m0 r15 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.m0) com.bytedance.android.scope.m.e.d(r14, com.bytedance.android.livesdk.gift.platform.core.scope.service.m0.class);
        if (r15 == null) goto L58;
        Intrinsics.checkNotNullParameter(r13, "params");
        sz1.a r0 = new sz1.a();
        if (Lists.isEmpty(r13.f()) == true) goto L59;
        com.bytedance.android.livesdk.gift.platform.core.giftlist.i r1 = r15.c;
        Integer r2 = r13.b();
        long r3 = 0;
        if (r2 == null) goto L12;
        long r5 = r2.intValue();
    L13:
        String r4 = null;
        com.bytedance.android.livesdk.gift.model.h1 r6 = r1.o4(r5, null);
        if (r6 == null) goto L16;
        long r7 = r6.getDiamondCount();
    L17:
        String r8 = r13.e();
        if (r8 != null) goto L20;
        r8 = "";
    L20:
        r0.setMainText(r8);
        String r9 = r13.h();
        if (r9 != null) goto L23;
        r9 = "";
    L23:
        r0.setSubText(r9);
        Integer r16 = r13.g();
        if (r16 == null) goto L26;
        long r17 = r16.intValue();
    L27:
        r0.setTotalDiamonds(r17 - r7);
        String r18 = r13.d();
        if (r18 == null) goto L30;
        r4 = StringsKt.replace(r18, "data:image/png;base64,", "", false);
    L30:
        r0.setLocalIconBitmap(r4);
        ArrayList r19 = new ArrayList();
        List<w20.u7.c> r21 = r13.f();
        if (r21 == null) goto L46;
        Iterator<T> r22 = r21.iterator();
    L34:
        if (r22.hasNext() == false) goto L46;
        w20.u7.c r23 = (w20.u7.c) r22.next();
        com.bytedance.android.livesdk.gift.model.e3 r24 = vh7.f.c(com.bytedance.android.livesdk.gift.model.e3.class);
        Integer r25 = r23.b();
        if (r25 == null) goto L38;
        long r26 = r25.intValue();
    L39:
        r24.setPluginId(r26);
        HashMap r27 = new HashMap();
        HashMap<String, String> r28 = r23.a();
        if (r28 == null) goto L45;
        Iterator<Map.Entry<String, String>> r29 = r28.entrySet().iterator();
    L43:
        if (r29.hasNext() == false) goto L45;
        Map.Entry<String, String> r31 = r29.next();
        r27.put(r31.getKey(), r31.getValue());
    L45:
        r24.setItemPotentialValueHint(r27);
        r19.add(r24);
        goto L34
    L38:
        r26 = 0;
    L46:
        Intrinsics.checkNotNullParameter(r0, "$this$plugins");
        Intrinsics.checkNotNullParameter(r19, "value");
        r0.setPluginsFlex(r19);
        r0.setGiftToolbarFrame(r13.c());
        r0.setGiftCellFrame(r13.a());
        r0.setNewCard(true);
        Integer r110 = r13.b();
        if (r110 == null) goto L49;
        r3 = r110.intValue();
    L49:
        Intrinsics.checkNotNullParameter(r0, "card");
        ArrayList r111 = (ArrayList) r15.a.get(String.valueOf(r3));
        if (r111 != null) goto L52;
        r111 = new ArrayList();
    L52:
        r111.add(r0);
        r15.a.put(String.valueOf(r3), r111);
        return;
    L26:
        r17 = 0;
        goto L27
    L16:
        r7 = 0;
        goto L17
    L12:
        r5 = 0;
        goto L13
    L59:
        return;
    L58:
        return;
    }
}

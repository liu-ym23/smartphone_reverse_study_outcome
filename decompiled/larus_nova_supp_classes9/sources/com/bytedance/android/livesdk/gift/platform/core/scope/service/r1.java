package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.GiftDialogFragmentV3;
import com.bytedance.android.livesdk.message.model.l7;
import io.reactivex.functions.Action;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r1 implements Action {
    public final /* synthetic */ GiftMessageService a;

    public r1(GiftMessageService r1) {
        this.a = r1;
    }

    public final void run() {
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.g() == false) goto L5;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.n(this.a.l);
        return;
    L5:
        GiftMessageService r0 = this.a;
        OpenDialogService r1 = r0.y;
        q1 r2 = r0.m;
        GiftDialogFragmentV3 r3 = r1.b;
        if (r3 == null) goto L13;
        boolean r4 = true;
        if (r3.isShowing() != true) goto L13;
        if (r2 == null) goto L13;
        GiftDialogFragmentV3 r5 = r1.b;
        if (r5 == null) goto L14;
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((HashSet) r5.j).add(r2);
    L14:
        if (r4 == true) goto L75;
        GiftMessageService r6 = this.a;
        if (r6.q == null) goto L48;
        LinkedHashMap r7 = new LinkedHashMap();
        l7 r8 = r6.q;
        if (r8 == null) goto L20;
        Integer r9 = Integer.valueOf(r8.getRemindType());
    L21:
        r7.put("remind_type", String.valueOf(r9));
        l7 r10 = r6.q;
        if (r10 == null) goto L24;
        l7.a r11 = r10.getLynxParam();
    L25:
        if (r11 == null) goto L43;
        l7 r13 = r6.q;
        if (r13 == null) goto L29;
        l7.a r14 = r13.getLynxParam();
    L30:
        Intrinsics.checkNotNull(r14);
        r7.put("style", String.valueOf(r14.getType()));
        l7 r15 = r6.q;
        if (r15 == null) goto L33;
        l7.a r16 = r15.getLynxParam();
    L34:
        Intrinsics.checkNotNull(r16);
        r7.put("main_text", r16.getMainText());
        l7 r17 = r6.q;
        if (r17 == null) goto L37;
        l7.a r18 = r17.getLynxParam();
    L38:
        Intrinsics.checkNotNull(r18);
        r7.put("expire_day_text", r18.getExpireDayText());
        l7 r19 = r6.q;
        if (r19 == null) goto L41;
        l7.a r20 = r19.getLynxParam();
    L42:
        Intrinsics.checkNotNull(r20);
        r7.put("sub_text", r20.getSubText());
        goto L43
    L41:
        r20 = null;
        goto L42
    L37:
        r18 = null;
        goto L38
    L33:
        r16 = null;
        goto L34
    L29:
        r14 = null;
    L43:
        zz0.g r21 = com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class);
        Context r23 = r6.v;
        l7 r24 = r6.q;
        if (r24 == null) goto L46;
        String r25 = r24.getLynxSchema();
    L47:
        r21.S2(r23, com.bytedance.android.live.revenue.common.u.a(r25, r7));
        r6.q = null;
        goto L48
    L46:
        r25 = null;
        goto L47
    L24:
        r11 = null;
        goto L25
    L20:
        r9 = null;
    L48:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.n(null);
        i12.e r26 = i12.o.b();
        if (r26 == null) goto L51;
        Object r27 = com.bytedance.android.scope.m.e.d(r26, r3.class);
    L52:
        r3 r28 = (r3) r27;
        if (r28 == null) goto L55;
        r28.d = null;
    L55:
        OpenDialogService r29 = r6.y;
        q1 r30 = r6.m;
        if (r30 == null) goto L64;
        GiftDialogFragmentV3 r31 = r29.b;
        if (r31 == null) goto L64;
        Set<DialogInterface.OnDismissListener> r33 = r31.j;
        if (r33 == null) goto L63;
        TypeIntrinsics.asMutableCollection(r33).remove(r30);
        goto L64
    L63:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L64:
        if (r30 == null) goto L72;
        GiftDialogFragmentV3 r34 = r29.b;
        if (r34 == null) goto L76;
        Set<DialogInterface.OnDismissListener> r35 = r34.j;
        if (r35 == null) goto L71;
        TypeIntrinsics.asMutableCollection(r35).remove(r30);
        return;
    L71:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L76:
        return;
    L72:
        r29.getClass();
        return;
    L51:
        r27 = null;
        goto L52
    L75:
        return;
    L13:
        r4 = false;
        goto L14
    }
}

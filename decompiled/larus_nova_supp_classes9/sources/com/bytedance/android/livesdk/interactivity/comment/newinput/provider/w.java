package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.live.profit.privilege.model.danmu.DanmakuTabList;
import com.bytedance.android.livesdk.interactivity.comment.input.DanmakuTabAdapter;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w<T> implements Consumer {
    public final /* synthetic */ DanmakuSectionProvider.b a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g b;

    public w(DanmakuSectionProvider.b r1, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r11) {
        DanmakuTabList r13 = (DanmakuTabList) r11;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.b;
        if (r0 == null) goto L5;
        r0.E();
    L5:
        DanmakuSectionProvider.b r1 = this.a;
        boolean r2 = true;
        com.bytedance.android.live.profit.privilege.model.danmu.b r4 = null;
        if (r1.b.f0() == false) goto L48;
        if (r13 == null) goto L48;
        if (r13.isEmpty() == true) goto L48;
        if (r13.isPrivilegeBarrageAvailable() == false) goto L48;
        DanmakuTabAdapter r3 = r1.d;
        if (r3 == null) goto L69;
        r3.A2(r13);
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r14 = r1.f;
        if (r14 == null) goto L19;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r15 = r14.g;
        if (r15 == null) goto L19;
        com.bytedance.android.live.profit.privilege.model.danmu.b r16 = r15.d;
    L20:
        r3.z2(r16);
        com.bytedance.android.live.profit.privilege.a r17 = r1.i.f;
        if (r17 == null) goto L37;
        com.bytedance.live.datacontext.m r18 = r17.isInDanmakuMode();
        if (r18 == null) goto L37;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r5 = r1.f;
        if (r5 == null) goto L31;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r6 = r5.g;
        if (r6 == null) goto L31;
        com.bytedance.android.live.profit.privilege.model.danmu.b r7 = r6.d;
        if (r7 == null) goto L31;
        long r8 = r7.getDiamondCount();
    L33:
        if (r8 > 0) goto L36;
        r2 = false;
    L36:
        r18.setValue(Boolean.valueOf(r2));
    L31:
        r8 = 0;
    L37:
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r19 = r1.g;
        if (r19 != null) goto L40;
    L47:
        r3.notifyDataSetChanged();
        return;
    L40:
        if (r19.b == true) goto L47;
        if (r3.b >= ((ArrayList) r3.a).size()) goto L45;
        r4 = (com.bytedance.android.live.profit.privilege.model.danmu.b) ListProtector.get(r3.a, r3.b);
    L45:
        if (r4 == null) goto L47;
        r1.i.h.A(r4);
    L19:
        r16 = null;
        goto L20
    L69:
        return;
    L48:
        if (r13 != null) goto L50;
    L55:
        r1.g();
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r110 = r1.i.b;
        if (r110 == null) goto L58;
        r110.O(false);
    L58:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r111 = r1.b.V();
        if (r111 == null) goto L63;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r112 = r111.g;
        if (r112 == null) goto L63;
        r112.e = null;
    L63:
        com.bytedance.android.live.profit.privilege.a r113 = r1.i.f;
        if (r113 == null) goto L71;
        com.bytedance.live.datacontext.m r114 = r113.isInDanmakuMode();
        if (r114 == null) goto L72;
        r114.setValue(Boolean.FALSE);
        return;
    L72:
        return;
    L71:
        return;
    L50:
        if (r13.getErrorReason().length() <= 0) goto L52;
        boolean r9 = true;
    L53:
        if (r9 == false) goto L55;
        String r115 = r13.getErrorReason();
        r1.i.getClass();
        Map r10 = DanmakuSectionProvider.k();
        ((HashMap) r10).put("show_reason", r115);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_danmu_toast_show", r10, new Object[]{am2.x.class, IRoom.class});
        goto L55
    L52:
        r9 = false;
        goto L53
    }
}

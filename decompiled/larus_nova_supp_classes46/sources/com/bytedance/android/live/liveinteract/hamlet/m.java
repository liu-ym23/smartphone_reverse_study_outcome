package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ HamletAvatarWidget a;

    public m(HamletAvatarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        sh6.b r9 = (sh6.b) r8;
        HamletAvatarWidget r0 = this.a;
        Pair r1 = (Pair) sh6.c.b(r9);
        if (r1 == null) goto L5;
        Set r2 = (Set) r1.getFirst();
    L6:
        Pair r10 = (Pair) sh6.c.b(r9);
        if (r10 == null) goto L9;
        Set r11 = (Set) r10.getSecond();
    L10:
        r0.getClass();
        StringBuilder r3 = new StringBuilder("updateCPosition, enlargeList:");
        Gson r4 = GsonHelper.get();
        if (r2 == null) goto L13;
        List r5 = CollectionsKt.toList(r2);
    L14:
        r3.append(GsonProtectorUtils.toJson(r4, r5));
        r3.append("， ");
        Gson r6 = GsonHelper.get();
        if (r11 == null) goto L17;
        List r7 = CollectionsKt.toList(r11);
    L18:
        r3.append(GsonProtectorUtils.toJson(r6, r7));
        ALogger.i("HamletAvatar", r3.toString());
        IInteractService r12 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r12 == null) goto L23;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r13 = r12.getLinkUserInfoCenter();
        if (r13 == null) goto L23;
        long r14 = r13.getLastVersion();
    L24:
        int r15 = ff0.e.a;
        if (r2 == null) goto L28;
        List<String> r16 = CollectionsKt.toList(r2);
        if (r16 == null) goto L28;
    L29:
        if (r11 == null) goto L32;
        List<String> r17 = CollectionsKt.toList(r11);
        if (r17 == null) goto L32;
    L33:
        Intrinsics.checkNotNullParameter(r16, "enlargeUids");
        Intrinsics.checkNotNullParameter(r17, "normalUids");
        com.bytedance.android.live.liveinteract.hamlet.model.v r18 = new com.bytedance.android.live.liveinteract.hamlet.model.v();
        r18.e(r16);
        r18.b(r16);
        r18.d(r17);
        r18.c(r14);
        String r19 = GsonProtectorUtils.toJson(GsonHelper.get(), r18);
        r0.er(r19, null);
        ff0.d r20 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "updateCPosition", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("custom_msg", String.valueOf(r19))}), 12);
        return;
    L32:
        r17 = new ArrayList();
    L28:
        r16 = new ArrayList();
    L23:
        r14 = 0;
        goto L24
    L17:
        r7 = null;
        goto L18
    L13:
        r5 = null;
        goto L14
    L9:
        r11 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}

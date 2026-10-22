package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j extends com.bytedance.android.live.liveinteract.plantform.base.i.d {
    public final /* synthetic */ h a;

    public j(h r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r9) {
        this.a.f = r9;
        ei6.a r0 = null;
        if (r9 == null) goto L12;
        Iterator<T> r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        Object r1 = r10.next();
        if (Intrinsics.areEqual(((ILinkPlayerInfoBridge) r1).getInteractId(), tc0.c.h().f) == false) goto L6;
    L11:
        ILinkPlayerInfoBridge r2 = (ILinkPlayerInfoBridge) r1;
    L13:
        StringBuilder r11 = new StringBuilder("onOnlineListChanged ;; currentLinkType != lastLinkType == ");
        if (r2 == null) goto L16;
        Integer r3 = Integer.valueOf(r2.getLinkType());
    L17:
        boolean r4 = true;
        r11.append(!Intrinsics.areEqual(r3, this.a.e));
        r11.append("  ;; currentLinkType == ");
        if (r2 == null) goto L20;
        Integer r5 = Integer.valueOf(r2.getLinkType());
    L21:
        r11.append(r5);
        r11.append(" ;;  lastLinkType == ");
        r11.append(this.a.e);
        r11.append(" ;; rtcClient == ");
        WeakReference<ei6.a> r6 = this.a.b;
        if (r6 == null) goto L24;
        ei6.a r7 = r6.get();
    L25:
        r11.append(r7);
        ALogger.i("BlackFrameManager", r11.toString());
        if (hd0.c.f().h() == false) goto L32;
        if (r2 == null) goto L29;
        Integer r12 = Integer.valueOf(r2.getLinkType());
    L31:
        if ((!Intrinsics.areEqual(r12, this.a.e)) == false) goto L32;
    L53:
        WeakReference<ei6.a> r13 = this.a.b;
        if (r13 == null) goto L56;
        ei6.a r14 = r13.get();
    L57:
        if (r14 != null) goto L59;
        this.a.e = null;
    L64:
        h r15 = this.a;
        if (r2 == null) goto L67;
        Integer r8 = Integer.valueOf(r2.getLinkType());
    L68:
        WeakReference<ei6.a> r16 = this.a.b;
        if (r16 == null) goto L71;
        r0 = r16.get();
    L71:
        r15.f(r8, r0, "online_list_change");
        return;
    L67:
        r8 = null;
        goto L68
    L59:
        h r17 = this.a;
        if (r2 == null) goto L62;
        Integer r18 = Integer.valueOf(r2.getLinkType());
    L63:
        r17.e = r18;
        goto L64
    L62:
        r18 = null;
        goto L63
    L56:
        r14 = null;
        goto L57
    L29:
        r12 = null;
    L32:
        h r19 = this.a;
        if (r2 == null) goto L35;
        Integer r20 = Integer.valueOf(r2.getLinkType());
    L36:
        r19.getClass();
        if (r20 != null) goto L40;
    L42:
        boolean r21 = false;
    L44:
        if (((Boolean) vm2.d.I3.getValue(null, vm2.d.a[240(0xf0, float:3.36E-43)])).booleanValue() == false) goto L51;
        if (r21 == false) goto L51;
        if (r19.g.get() == false) goto L51;
        if (jc1.k.n(IKtvService.class).isMultiChorusEnable() == false) goto L51;
    L52:
        if (r4 == true) goto L53;
        return;
    L51:
        r4 = false;
        goto L52
    L40:
        if (r20.intValue() != 2) goto L42;
        r21 = true;
        goto L44
    L35:
        r20 = null;
        goto L36
    L24:
        r7 = null;
        goto L25
    L20:
        r5 = null;
        goto L21
    L16:
        r3 = null;
        goto L17
    L10:
        r1 = null;
        goto L11
    L12:
        r2 = null;
        goto L13
    }
}

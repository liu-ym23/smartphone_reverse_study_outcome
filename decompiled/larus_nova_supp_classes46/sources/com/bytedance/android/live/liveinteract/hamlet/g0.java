package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g0 extends com.bytedance.android.live.liveinteract.plantform.base.i.a<ILinkPlayerInfoBridge> {
    public final /* synthetic */ HamletAvatarWidget a;

    public g0(HamletAvatarWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r9) {
        HamletAvatarContext r0 = this.a.f;
        if (r0 == null) goto L8;
        if (r0.isCleared() != true) goto L8;
        return;
    L8:
        if (gh0.a.d() == false) goto L64;
        HamletAvatarContext r1 = this.a.f;
        if (r1 == null) goto L64;
        com.bytedance.live.datacontext.m<Boolean> r2 = r1.isMultiAvatarMode();
        if (r2 == null) goto L64;
        if (((Boolean) r2.getValue()).booleanValue() != true) goto L64;
        this.a.getClass();
        LinkedHashSet r3 = new LinkedHashSet();
        if (r9 == null) goto L27;
        Iterator<T> r4 = r9.iterator();
    L19:
        if (r4.hasNext() == false) goto L27;
        ILinkPlayerInfoBridge r5 = (ILinkPlayerInfoBridge) r4.next();
        if (r5.isEnlarged() == false) goto L19;
        IBaseUser r6 = r5.getUser();
        if (r6 == null) goto L19;
        String r7 = r6.getIdString();
        if (r7 == null) goto L19;
        r3.add(r7);
    L27:
        this.a.getClass();
        LinkedHashSet r8 = new LinkedHashSet();
        if (r9 == null) goto L39;
        Iterator<T> r10 = r9.iterator();
    L31:
        if (r10.hasNext() == false) goto L39;
        ILinkPlayerInfoBridge r11 = (ILinkPlayerInfoBridge) r10.next();
        if (r11.isEnlarged() == true) goto L31;
        IBaseUser r12 = r11.getUser();
        if (r12 == null) goto L31;
        String r13 = r12.getIdString();
        if (r13 == null) goto L31;
        r8.add(r13);
    L39:
        HamletAvatarContext r14 = this.a.f;
        if (r14 == null) goto L46;
        com.bytedance.live.datacontext.n<Pair<Set<String>, Set<String>>> r15 = r14.getCPositionList();
        if (r15 == null) goto L46;
        Pair r16 = (Pair) r15.getValue();
        if (r16 == null) goto L46;
        Set r17 = (Set) r16.getFirst();
    L47:
        this.a.getClass();
        if (r17 != null) goto L51;
    L57:
        boolean r18 = false;
    L58:
        if (r18 == true) goto L64;
        HamletAvatarContext r19 = this.a.f;
        if (r19 == null) goto L64;
        com.bytedance.live.datacontext.n<Pair<Set<String>, Set<String>>> r20 = r19.getCPositionList();
        if (r20 == null) goto L64;
        r20.setValue(new Pair(r3, r8));
        goto L64
    L51:
        if (r3.size() != r17.size()) goto L57;
        if (r3.containsAll(r17) == false) goto L57;
        if (r17.containsAll(r3) == false) goto L57;
        r18 = true;
    L46:
        r17 = null;
    L64:
        this.a.getClass();
        if (r9 != null) goto L67;
        Pair r21 = new Pair(Boolean.FALSE, 0);
    L95:
        boolean r22 = ((Boolean) r21.getFirst()).booleanValue();
        HamletAvatarContext r23 = this.a.f;
        if (r23 == null) goto L102;
        com.bytedance.live.datacontext.m<Boolean> r24 = r23.isSelfCPosition();
        if (r24 == null) goto L102;
        Boolean r25 = (Boolean) r24.getValue();
        if (r25 == null) goto L102;
        boolean r26 = r25.booleanValue();
    L103:
        ALogger.i("HamletAvatar", "onOnlineListChanged, selfIsCPositionUser=" + r22 + ", lastSelfCPosition=" + r26);
        if (r26 == r22) goto L113;
        HamletAvatarContext r27 = this.a.f;
        if (r27 == null) goto L110;
        com.bytedance.live.datacontext.m<Boolean> r28 = r27.isSelfCPosition();
        if (r28 == null) goto L110;
        r28.setValue(Boolean.valueOf(r22));
    L110:
        LayerEventDispatcher r29 = o70.c.a(Integer.valueOf(((Widget) this.a).dataCenter.hashCode()));
        if (r29 == null) goto L113;
        r29.b(new o42.c(false, true, "HAMLET_AVATAR_C_POSITION_CHANGED"));
    L113:
        if (r26 == false) goto L143;
        if (r22 == true) goto L144;
        cg6.a r30 = this.a.Eq();
        if (r30 == null) goto L145;
        hg6.g r31 = r30.getRtcManager();
        if (r31 != null) goto L120;
        return;
    L120:
        if (r31.A() != true) goto L147;
        this.a.gr();
        return;
    L147:
        return;
    L145:
        return;
    L144:
        return;
    L143:
        return;
    L102:
        r26 = false;
        goto L103
    L67:
        String r32 = je0.d.b0();
        if (r32 != null) goto L70;
    L73:
        boolean r33 = true;
    L74:
        if (r33 == false) goto L76;
        r21 = new Pair(Boolean.FALSE, 0);
        goto L95
    L76:
        Iterator<ILinkPlayerInfoBridge> r34 = r9.iterator();
        int r35 = 0;
    L78:
        if (r34.hasNext() == false) goto L87;
        IBaseUser r36 = r34.next().getUser();
        if (r36 == null) goto L82;
        String r37 = r36.getIdString();
    L84:
        if (Intrinsics.areEqual(r37, r32) == true) goto L88;
        r35 = r35 + 1;
    L88:
        if (r35 >= 0) goto L90;
    L94:
        r21 = new Pair(Boolean.FALSE, 0);
        goto L95
    L90:
        if (r35 >= r9.size()) goto L94;
        if (((ILinkPlayerInfoBridge) ListProtector.get(r9, r35)).isEnlarged() == false) goto L94;
        r21 = new Pair(Boolean.TRUE, Integer.valueOf(r35));
        goto L95
    L82:
        r37 = null;
        goto L84
    L87:
        r35 = -1;
        goto L88
    L70:
        if (r32.length() == 0) goto L73;
        r33 = false;
        goto L74
    }
}

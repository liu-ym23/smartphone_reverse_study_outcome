package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ HamletAvatarWidget a;

    public j(HamletAvatarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        Integer r7 = (Integer) r6;
        HamletAvatarContext r0 = HamletAvatarContext.Companion.getContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isMultiAvatarMode();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        boolean r3 = r2.booleanValue();
    L11:
        if (this.a.W3() == 0) goto L13;
        if (r3 == false) goto L13;
        return;
    L13:
        boolean r4 = true;
        if (r7.intValue() <= 0) goto L16;
        boolean r8 = true;
    L17:
        Boolean r5 = (Boolean) ((Widget) this.a).dataCenter.get("data_hamlet_avatar_status", Boolean.FALSE);
        HamletAvatarContext r9 = this.a.f;
        if (r9 == null) goto L24;
        com.bytedance.live.datacontext.m<Boolean> r10 = r9.isAvatarRending();
        if (r10 == null) goto L24;
        Boolean r11 = (Boolean) r10.getValue();
        if (r11 == null) goto L24;
        boolean r12 = r11.booleanValue();
    L26:
        if (r5.booleanValue() == false) goto L30;
        if (r12 == true) goto L30;
        if (r8 == true) goto L30;
    L31:
        HamletAvatarWidget r13 = this.a;
        r13.Sq(r4, r13.mg(0));
        return;
    L30:
        r4 = false;
    L24:
        r12 = false;
        goto L26
    L16:
        r8 = false;
    L9:
        r3 = false;
        goto L11
    }
}

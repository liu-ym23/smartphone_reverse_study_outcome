package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ HamletAvatarWidget a;

    public i(HamletAvatarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        Boolean r7 = (Boolean) r6;
        HamletAvatarContext.a r0 = HamletAvatarContext.Companion;
        HamletAvatarContext r1 = r0.getContext();
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r2 = r1.isStreamRending();
        if (r2 == null) goto L9;
        Boolean r3 = (Boolean) r2.getValue();
        if (r3 == null) goto L9;
        boolean r4 = r3.booleanValue();
    L10:
        if (r4 == false) goto L14;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.g r5 = this.a.s;
        if (r5 == null) goto L14;
        r5.c = r7;
        r5.c();
    L14:
        StringBuilder r8 = new StringBuilder("isAvatarRending changed , sendAvatarRenderChangedJSB, isRender=");
        r8.append(r7);
        r8.append("， currentCameraIndex=");
        r8.append(this.a.W3());
        r8.append(", isMultiAvatarMode=");
        HamletAvatarContext r9 = r0.getContext();
        if (r9 == null) goto L19;
        com.bytedance.live.datacontext.m<Boolean> r10 = r9.isMultiAvatarMode();
        if (r10 == null) goto L19;
        Boolean r11 = (Boolean) r10.getValue();
    L20:
        r8.append(r11);
        ALogger.e("HamletAvatar", r8.toString());
        this.a.Rq(r7.booleanValue());
        HamletAvatarContext r12 = r0.getContext();
        if (r12 == null) goto L27;
        com.bytedance.live.datacontext.m<Boolean> r13 = r12.isMultiAvatarMode();
        if (r13 == null) goto L27;
        Boolean r14 = (Boolean) r13.getValue();
        if (r14 == null) goto L27;
        boolean r15 = r14.booleanValue();
    L29:
        if (this.a.W3() == 0) goto L31;
        if (r15 == false) goto L31;
        return;
    L31:
        Boolean r16 = (Boolean) ((Widget) this.a).dataCenter.get("data_hamlet_avatar_status", Boolean.FALSE);
        HamletAvatarContext r17 = r0.getContext();
        if (r17 == null) goto L38;
        com.bytedance.live.datacontext.m<Integer> r18 = r17.getDirecting();
        if (r18 == null) goto L38;
        Integer r19 = (Integer) r18.getValue();
        if (r19 == null) goto L38;
        int r20 = r19.intValue();
    L39:
        boolean r21 = true;
        if (r20 <= 0) goto L42;
        boolean r22 = true;
    L44:
        if (r16.booleanValue() == true) goto L46;
    L49:
        r21 = false;
    L50:
        HamletAvatarWidget r23 = this.a;
        r23.Sq(r21, r23.mg(0));
        return;
    L46:
        if (r7.booleanValue() == true) goto L49;
        if (r22 == true) goto L49;
    L42:
        r22 = false;
    L38:
        r20 = 0;
    L27:
        r15 = false;
    L19:
        r11 = null;
    L9:
        r4 = false;
        goto L10
    }
}

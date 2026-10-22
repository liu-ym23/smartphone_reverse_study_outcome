package com.bytedance.android.livesdk.interactivity.interactive;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
    public final /* synthetic */ LiveInteractiveAnnieXHelper a;

    public g(LiveInteractiveAnnieXHelper r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, CallContext r4) {
        JSONObject r5 = (JSONObject) r3;
        Intrinsics.checkNotNullParameter(r5, "jsonObject");
        Intrinsics.checkNotNullParameter(r4, "callContext");
        LiveInteractiveAnnieXHelper r6 = this.a;
        DataCenter r0 = r6.q;
        Boolean r1 = null;
        if (r0 == null) goto L13;
        IRoom r2 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r0);
        if (r2 == null) goto L13;
        IRoomAuthStatus r7 = r2.getRoomAuthStatus();
        if (r7 == null) goto L13;
        IRoomAuthStatus.IRoomAuthSpecialStyle r8 = r7.getRoomAuthSpecialStyle();
        if (r8 == null) goto L13;
        IRoomAuthStatusStyle r9 = r8.getChatStyle();
        if (r9 == null) goto L13;
        Integer r10 = Integer.valueOf(r9.getUnableStyle());
    L14:
        r6.o = r10;
        o82.h.b("interactiveBannerShow[" + hashCode() + "] jsb invoke:" + r5);
        if (r5.has("show") == false) goto L29;
        boolean r11 = JSONObjectProtectorUtils.getBoolean(r5, "show");
        LiveInteractiveAnnieXHelper r13 = this.a;
        r13.m = r11 ? 1 : 0;
        if (r13.c() == false) goto L29;
        int r14 = 1;
        if (r11 == false) goto L26;
        DataCenter r15 = this.a.q;
        if (r15 == null) goto L24;
        r1 = (Boolean) r15.get("match_is_public_interact_tab", Boolean.TRUE);
    L24:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L30;
        this.a.s(true);
    L30:
        JSONObject r16 = new JSONObject();
        r16.put("code", r14);
        return r16;
    L26:
        this.a.p(true);
        DataCenter r17 = this.a.q;
        if (r17 == null) goto L30;
        r17.put("cmd_try_show_lock_view_guide_pop", Boolean.TRUE);
    L29:
        r14 = 0;
    L13:
        r10 = null;
        goto L14
    }
}

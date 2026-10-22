package com.bytedance.android.live.liveinteract.videotalk.themecompetition;

import android.view.View;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements c0.b {
    public View a;

    public i() {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void R9(View r1, DataCenter r2) {
    }

    public final /* synthetic */ void SY(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void onClick(View r6) {
        a r7 = b.a;
        Intrinsics.checkNotNullParameter("interaction_button", "source");
        LinkedHashMap r1 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r1, null, null, 6);
        r1.put("playmode_type", String.valueOf(11));
        r1.put("source", "interaction_button");
        j0.l().sendLog("livesdk_live_function_interact_playmode_panel_item_click", r1, new Object[]{IRoom.class});
        pj0.b r0 = ThemedCompetitionContext.Companion.c();
        if (r0 == null) goto L5;
        r0.ja("interaction_button");
    L5:
        com.bytedance.android.livesdk.sharedpref.e r8 = b6.R;
        Boolean r2 = Boolean.FALSE;
        r8.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r8, r2);
    }

    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r2.findViewById(2131384095);
        if (((Boolean) b6.R.getValue()).booleanValue() == false) goto L5;
        UIUtils.setViewVisibility(this.a, 0);
        return;
    L5:
        UIUtils.setViewVisibility(this.a, 8);
    }
}

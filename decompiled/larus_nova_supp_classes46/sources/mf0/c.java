package mf0;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements c0.b {
    public View a;
    public final Context b;

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

    public final /* synthetic */ void dv(e r1) {
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

    public c(Context r1) {
        this.b = r1;
    }

    public final void onClick(View r6) {
        LinkedHashMap r7 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r7, null, null, 6);
        r7.put("playmode_type", String.valueOf(15));
        r7.put("source", "interaction_button");
        j0.l().sendLog("livesdk_live_function_interact_playmode_panel_item_click", r7, new Object[]{IRoom.class});
        int r8 = b.a;
        b.a(this.b, "interaction_button");
        com.bytedance.android.livesdk.sharedpref.e r9 = b6.S;
        Boolean r0 = Boolean.FALSE;
        r9.getClass();
        f.d(r9, r0);
    }

    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r2.findViewById(2131384095);
        if (((Boolean) b6.S.getValue()).booleanValue() == false) goto L5;
        UIUtils.setViewVisibility(this.a, 0);
        return;
    L5:
        UIUtils.setViewVisibility(this.a, 8);
    }
}

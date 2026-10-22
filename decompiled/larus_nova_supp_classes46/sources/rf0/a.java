package rf0;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.liveinteract.plantform.utils.OpenPanelSource;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e;
import com.bytedance.ies.sdk.widgets.DataCenter;
import qf0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements c0.b {
    public final Context a;

    /* JADX INFO: renamed from: rf0.a$a, reason: collision with other inner class name */
    public static final class C0264a {
    }

    static {
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

    public final /* synthetic */ void dv(e r1) {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void p4(View r1, DataCenter r2) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public a(Context r1) {
        this.a = r1;
    }

    public final void onClick(View r3) {
        if (b.e() == false) goto L5;
        return;
    L5:
        String r4 = OpenPanelSource.INTERACTION_BUTTON.getValue();
        i0 r0 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.o1(r4);
        TalkRoomLogUtils.k0(10, "Link_panel", r4);
        b.d(this.a, r4);
    }
}

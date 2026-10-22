package bi0;

import android.view.View;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements c0.b {
    public b() {
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

    public final void onClick(View r5) {
        AdventureContext.Companion.getClass();
        Pair[] r2 = new Pair[2];
        if ((!AdventureContext.a.a()) == false) goto L5;
        String r0 = "start";
    L6:
        r2[0] = TuplesKt.to("type", r0);
        r2[1] = TuplesKt.to("request_page", "interact_panel");
        Map r1 = MapsKt.mapOf(r2);
        if (r5 == null) goto L10;
        String r3 = a.a;
        a.b(r5.getContext(), r1);
        return;
    L10:
        return;
    L5:
        r0 = "end";
        goto L6
    }
}

package com.bytedance.android.live.broadcastgame.api.toolbar;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/toolbar/GameExitBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameExitBehavior implements c0.b, Observer<KVData> {
    public View a;
    public final DataCenter b;

    public static final class a {
    }

    static {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
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

    public GameExitBehavior(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.b = r2;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L5;
        String r0 = r5.getKey();
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.hashCode() == (-1755796428)) goto L12;
        return;
    L12:
        if (r0.equals("cmd_hide_other_toolbar") == false) goto L28;
        if (r5 == null) goto L16;
        Boolean r6 = (Boolean) r5.getData(Boolean.FALSE);
        if (r6 == null) goto L16;
    L18:
        if (r6.booleanValue() == false) goto L23;
        View r7 = this.a;
        if (r7 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L22:
        r7.setVisibility(0);
        return;
    L23:
        View r8 = this.a;
        if (r8 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L26:
        r8.setVisibility(8);
        return;
    L16:
        r6 = Boolean.FALSE;
        goto L18
    L28:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void onClick(View r3) {
        ALogger.i("GameExitBehavior", "click to exit game");
        this.b.put("cmd_broadcast_game_finish", 0);
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        r3.removeObserver("cmd_hide_other_toolbar", this);
    }

    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        r3.observe("cmd_hide_other_toolbar", this);
        r2.setVisibility(8);
        this.a = r2;
    }
}

package fa1;

import am2.x;
import android.view.View;
import com.bytedance.android.live.room.share.ui.ScreenShotAutoObserveLandscapeDialog;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ ScreenShotAutoObserveLandscapeDialog a;

    public e(ScreenShotAutoObserveLandscapeDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        puc.a.openInstalledApp(this.a.getContext(), "com.tencent.mm");
        HashMap r6 = new HashMap();
        r6.put("share_platform", "weixin");
        g r0 = u.l();
        ScreenShotAutoObserveLandscapeDialog r1 = this.a;
        int r2 = ScreenShotAutoObserveLandscapeDialog.j;
        r1.getClass();
        r6.put("request_page", "live_screenshot");
        r0.sendLog("livesdk_share", r6, new Object[]{Room.class, x.class});
        ea1.a r7 = this.a.h;
        if (r7 == null) goto L5;
        r7.onDismiss();
    L5:
        ScreenShotAutoObserveLandscapeDialog r8 = this.a;
        r8.i = true;
        r8.dismissAllowingStateLoss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r9 = DialogFragmentLancet.sLastShowStack;
        if (r9 == null) goto L15;
        com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}

package fa1;

import am2.c0;
import am2.x;
import android.content.DialogInterface;
import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.setting.e0;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.room.api.IReportService;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant$BusinessSource;
import com.bytedance.android.live.room.share.ui.ScreenShotAutoObserveLandscapeDialog;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.i0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.HashMap;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ ScreenShotAutoObserveLandscapeDialog a;
    public final /* synthetic */ Room b;
    public final /* synthetic */ User c;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            ea1.a r2 = this.a.a.h;
            if (r2 == null) goto L6;
            r2.onDismiss();
            return;
        }
    }

    public d(ScreenShotAutoObserveLandscapeDialog r1, Room r2, User r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        if (((Boolean) e0.a.getValue()).booleanValue() == false) goto L5;
        ScreenShotAutoObserveLandscapeDialog r13 = this.a;
        int r2 = ScreenShotAutoObserveLandscapeDialog.j;
        HashMap r3 = new HashMap();
        r13.getClass();
        r3.put("request_page", "live_screenshot");
        r3.put("report_type", "report_anchor");
        r3.put("to_user_id", this.b.getOwnerUserIdString());
    L6:
        g r14 = u.l();
        int r1 = c0.b;
        int r4 = com.bytedance.android.live.room.share.util.e.a;
        r14.sendLog("livesdk_live_user_report", r3, new Object[]{Room.class, x.class, c0.a.a(k.n(ILinkServiceExternal.class).getMultiDataHolder().v())});
        String r15 = i0.a;
        i0.a = this.a.e;
        IReportService r5 = (IReportService) k.f(IReportService.class);
        if (r5 == null) goto L9;
        r5.screenShotReport(ReportConstant$BusinessSource.LandscapeScreenShot, this.a.getContext(), this.c, this.b, new a(this));
    L9:
        ScreenShotAutoObserveLandscapeDialog r16 = this.a;
        r16.i = true;
        r16.dismissAllowingStateLoss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r17 = DialogFragmentLancet.sLastShowStack;
        if (r17 == null) goto L19;
        com.bytedance.crash.d.d(r17, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L19:
        return;
    L5:
        ScreenShotAutoObserveLandscapeDialog r18 = this.a;
        int r6 = ScreenShotAutoObserveLandscapeDialog.j;
        r3 = new HashMap();
        r18.getClass();
        r3.put("request_page", "live_screenshot");
        goto L6
    }
}

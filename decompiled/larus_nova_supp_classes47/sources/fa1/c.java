package fa1;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.room.share.ui.ScreenShotAutoObserveLandscapeDialog;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.IShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.config.d51;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.vs.model.MatchShareParam;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ ScreenShotAutoObserveLandscapeDialog a;

    public static final class a implements IShareCallback {
        public final /* synthetic */ c a;

        public final boolean interceptReportAction(IShareParams r2) {
            Intrinsics.checkNotNullParameter(r2, "shareParams");
            return false;
        }

        public final /* synthetic */ void onShareUiDismiss() {
            IShareCallback.-CC.$default$onShareUiDismiss(this);
        }

        public final /* synthetic */ void onShareUiShow() {
            IShareCallback.-CC.$default$onShareUiShow(this);
        }

        public a(c r1) {
            this.a = r1;
        }

        public final void onFail(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "throwable");
            ea1.a r3 = this.a.a.h;
            if (r3 == null) goto L6;
            r3.onDismiss();
            return;
        }

        public final void onSuccess(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "platform");
            Intrinsics.checkNotNullParameter(r3, "shareType");
            ea1.a r4 = this.a.a.h;
            if (r4 == null) goto L6;
            r4.onDismiss();
            return;
        }
    }

    public c(ScreenShotAutoObserveLandscapeDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r25) {
        if ((this.a.getContext() instanceof Activity) == true) goto L5;
        return;
    L5:
        ScreenShotAutoObserveLandscapeDialog r0 = this.a;
        MatchShareParam r2 = r0.g;
        IRoom r3 = null;
        if (r2 == null) goto L8;
        IRoom r4 = r2.f;
    L9:
        if (r4 != null) goto L11;
        return;
    L11:
        String r1 = r0.e;
        if (StringsKt.startsWith$default(r1, "file://", false, 2, null) == true) goto L14;
        r1 = "file://" + r1;
    L14:
        ILiveShareService r5 = (ILiveShareService) k.n(ILiveShareService.class);
        MatchShareParam r6 = this.a.g;
        if (r6 == null) goto L17;
        r3 = r6.f;
    L17:
        ShareParams r7 = ShareParams.buildUponRoom(r3).setPlatform("chat_merge").setScreenshotImageUrl(r1).setEnterFrom("live_screenshot").setEnableLandscapeOpt(((d51) m50.a.getValue()).q()).build();
        Context r8 = this.a.getContext();
        if (r8 == null) goto L28;
        r5.share(new i81.a(null, (Activity) r8, null, r7, null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false), "ScreenShotAutoObserveLandscapeDialog", LiveShareType.SHARE_DIRECT, new a(this));
        HashMap r9 = new HashMap();
        r9.put("share_platform", "chat_merge");
        g r10 = u.l();
        this.a.getClass();
        r9.put("request_page", "live_screenshot");
        r10.sendLog("livesdk_share", r9, new Object[]{Room.class, x.class});
        ScreenShotAutoObserveLandscapeDialog r12 = this.a;
        r12.i = true;
        r12.dismissAllowingStateLoss();     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r13 = DialogFragmentLancet.sLastShowStack;
        if (r13 == null) goto L31;
        com.bytedance.crash.d.d(r13, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L31:
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L8:
        r4 = null;
        goto L9
    }
}

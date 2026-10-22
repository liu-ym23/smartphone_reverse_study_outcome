package lx0;

import am2.x;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.record.LiveScreenRecordPublishGuideDialog;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.business.depend.highlight.PublishHighlightVideoData;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ LiveScreenRecordPublishGuideDialog a;

    public b(LiveScreenRecordPublishGuideDialog r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [android.app.Dialog, com.bytedance.android.live.record.LiveScreenRecordPublishGuideDialog, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r22) {
        ?? r2 = this.a;
        int r0 = LiveScreenRecordPublishGuideDialog.G;
        r2.getClass();
        Pair[] r1 = new Pair[5];
        r1[0] = TuplesKt.to("event_page", "live_detail");
        r1[1] = TuplesKt.to("module_name", "comment_highlight_publish_guide");
        r1[2] = TuplesKt.to("highlights_content_id", (String) r2.F.d.getValue());
        DataCenter r3 = r2.F.c;
        String r7 = null;
        if (r3 == null) goto L7;
        Room r4 = z.o(r3);
        if (r4 == null) goto L7;
        String r5 = r4.getIdStr();
    L8:
        r1[3] = TuplesKt.to("room_id", String.valueOf(r5));
        r1[4] = TuplesKt.to("element_name", "publish");
        j0.l().sendLog("livesdk_comment_highlight_element_click", MapsKt.mutableMapOf(r1), new Object[]{IRoom.class, x.class});
        Activity r10 = ContextUtil.contextToActivity(r2.getContext());
        if (r10 == null) goto L61;
        DataCenter r6 = r2.F.c;
        if (r6 == null) goto L14;
        Room r8 = z.o(r6);
    L15:
        if (r8 == null) goto L19;
        User r9 = r8.getOwner();
        if (r9 == null) goto L19;
        String r12 = r9.getNickName();
    L20:
        String r14 = String.valueOf(r12);
        String r13 = r2.B;
        if (r8 == null) goto L23;
        String r15 = r8.getAnchorId();
    L24:
        String r16 = String.valueOf(r15);
        if (r8 == null) goto L27;
        String r17 = r8.getIdStr();
    L28:
        String r18 = String.valueOf(r17);
        String r19 = (String) r2.F.d.getValue();
        IMiddlewareUserService r20 = k.f(IMiddlewareUserService.class);
        if (r20 == null) goto L35;
        e r23 = r20.user();
        if (r23 == null) goto L35;
        IBaseUser r24 = r23.b();
        if (r24 == null) goto L35;
        r7 = r24.getIdString();
    L35:
        PublishHighlightVideoData r25 = new PublishHighlightVideoData(r13, r10, "guide_publish", "live_detail", r16, r14, r19, r18, String.valueOf(r7), r14.concat("的精彩瞬间"), "", new a(r2));
        r25.setHighlightsContentType("guide_publish");
        r2.W0(true);
        IMiddlewareHostBusiness r26 = k.f(IMiddlewareHostBusiness.class);
        if (r26 == null) goto L38;
        r26.openEditAndPublishPage(r25);
    L38:
        Handler r27 = DialogLancet.resolveDialogHandler(r2);
        if (r27 != null) goto L41;
    L43:
        DialogLancet.beforeDialogDismiss(r2);
        r2.dismiss();     // Catch: Throwable -> L46 Exception -> L48
    L53:
        DialogLancet.afterDialogDismiss(r2);
        return;
    L46:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r2);
        throw th;
    L48:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L46
        Throwable r28 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L46
        if (r28 == null) goto L53;
        d.d(r28, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L46
        goto L53
    L41:
        if (Looper.myLooper() == r27.getLooper()) goto L43;
        r27.post(DialogLancet.createDismissRunnable(r2));
        return;
    L27:
        r17 = null;
        goto L28
    L23:
        r15 = null;
    L19:
        r12 = null;
        goto L20
    L14:
        r8 = null;
        goto L15
    L61:
        return;
    L7:
        r5 = null;
        goto L8
    }
}

package com.bytedance.android.livesdk.interactivity.medialink.intercomment;

import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ MediaInteractCommentWidget a;

    public k(MediaInteractCommentWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        Integer r11 = (Integer) r10;
        if (r11 != null) goto L6;
    L15:
        int r5 = 2131251947;
        if (r11 != null) goto L19;
    L31:
        if (r11 != null) goto L34;
        return;
    L34:
        if (r11.intValue() != 0) goto L50;
        MediaInteractCommentWidget r13 = this.a;
        int r0 = MediaInteractCommentWidget.p;
        MediaInteractCommentView r14 = r13.zq();
        if (r14 == null) goto L42;
        boolean r1 = !this.a.d;
        HSImageView r15 = r14.a(2131379789);
        if (r1 == true) goto L41;
        r5 = 2131251942;
    L41:
        ImageLoader.bindDrawableResource(r15, r5);
    L42:
        this.a.Bq();
        return;
    L50:
        return;
    L19:
        if (r11.intValue() != 4) goto L31;
        this.a.h = System.currentTimeMillis();
        MediaInteractCommentView r16 = this.a.zq();
        if (r16 == null) goto L27;
        boolean r7 = !this.a.d;
        HSImageView r17 = r16.a(2131379789);
        if (r7 == true) goto L26;
        r5 = 2131251945;
    L26:
        ImageLoader.bindDrawableResource(r17, r5);
    L27:
        this.a.Bq();
        MediaInteractCommentWidget r18 = this.a;
        if (r18.d == false) goto L30;
        r18.g.getClass();
        HashMap r19 = new HashMap();
        r19.put("connection_scene", "connection");
        r19.put("channel_id", String.valueOf(e92.m.b()));
        d.a(r19);
        u.l().sendLog("livesdk_comment_interflow_start", r19, new Object[]{Room.class});
    L30:
        com.bytedance.android.livesdk.interactivity.api.base.b.a r110 = com.bytedance.android.livesdk.interactivity.api.base.b.m;
        q r2 = q.a;
        r110.getClass();
        com.bytedance.android.livesdk.interactivity.api.base.b.a.e();
        return;
    L6:
        if (r11.intValue() != 2) goto L15;
        MediaInteractCommentWidget r111 = this.a;
        if (r111.d == false) goto L47;
        MediaInteractCommentBeInviteDialog r6 = new MediaInteractCommentBeInviteDialog(((Widget) r111).context, new n(r111));
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L45;
        DialogLancet.handleBlockedDialogShow(r6);
    L14:
        this.a.g.getClass();
        HashMap r112 = new HashMap();
        r112.put("connection_scene", "connection");
        r112.put("channel_id", String.valueOf(e92.m.b()));
        d.a(r112);
        u.l().sendLog("livesdk_comment_interflow_recieve", r112, new Object[]{Room.class});
        return;
    L45:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L44
    L13:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
        goto L14
    }
}

package com.bytedance.android.livesdk.interactivity.publicscreen.panel.item;

import am2.c0;
import am2.l;
import am2.n;
import am2.x;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.m4;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.room.api.report.IMiddlewareReportService;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AudiencePanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.v;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.e2;
import com.bytedance.android.livesdk.n0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import p11.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends b {
    public h() {
        super(AudiencePanelItemSymbol.REPORT);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b
    public final int c() {
        if (((Boolean) n0.a.getValue()).booleanValue() == true) goto L5;
    L8:
        return 2131565179;
    L5:
        if (this.e.getShowOutside() == false) goto L8;
        return 2131565178;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final boolean canShow() {
        if (d() == false) goto L6;
        return false;
    L6:
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b
    public final void f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "name");
        super.f(r3);
        if (this.e.getShowOutside() == true) goto L10;
        View r4 = this.a;
        if (r4 == null) goto L11;
        TextView r5 = (TextView) r4.findViewById(2131375727);
        if (r5 == null) goto L12;
        r5.setText((CharSequence) ListProtector.get(this.e.getInsideName(), 0));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final void onClick(View r15) {
        super.onClick(r15);
        t r16 = this.c;
        LiveMode r1 = null;
        if ((r16 instanceof m4) == true) goto L5;
        r16 = null;
    L5:
        m4 r17 = (m4) r16;
        if (r17 == null) goto L74;
        IBaseUser r18 = r17.getUser();
        if (r18 == null) goto L76;
        t r0 = this.c;
        if (r0 == null) goto L70;
        UserProfileEvent r3 = com.bytedance.android.livesdk.interactivity.textmessage.utils.e.a(r0, r18, false);
        IMiddlewareReportService r4 = k.f(IMiddlewareReportService.class);
        if (r4 == null) goto L23;
        y71.a r8 = new y71.a(ReportConstant.BusinessSource.AudienceOperatePanel);
        r8.a = r18;
        IRoomContextService r9 = k.f(IRoomContextService.class);
        if (r9 == null) goto L21;
        o r10 = IRoomContextService.a.a(r9, null, 0, 3);
        if (r10 == null) goto L21;
        m r11 = r10.getRoom();
        if (r11 == null) goto L21;
        IRoom r13 = (IRoom) r11.getValue();
    L22:
        r8.b = r13;
        r8.c = r3.mSource;
        r8.f = r3.mCommentReportModel;
        r8.a(r3.getReportObject());
        r4.report(r8);
    L21:
        r13 = null;
    L23:
        String r19 = r18.getIdString();
        boolean r5 = r0 instanceof e2;
        if (r5 == false) goto L26;
        String r6 = "personal_profile";
    L28:
        if (r5 == false) goto L30;
        int r7 = 1;
    L31:
        IRoomContextService r14 = k.f(IRoomContextService.class);
        if (r14 == null) goto L38;
        o r20 = IRoomContextService.a.a(r14, null, 0, 3);
        if (r20 == null) goto L38;
        m r21 = r20.getRoom();
        if (r21 == null) goto L38;
        IRoom r23 = (IRoom) r21.getValue();
    L39:
        HashMap r24 = new HashMap();
        IMiddlewareReportService r110 = k.f(IMiddlewareReportService.class);
        if (r110 == null) goto L43;
        String r111 = r110.getReportType(r6, "data_card_audience", true);
        if (r111 == null) goto L43;
    L44:
        r24.put("report_type", r111);
        IMiddlewareReportService r112 = k.f(IMiddlewareReportService.class);
        if (r112 == null) goto L48;
        String r25 = r112.getRequestPage(r6, "data_card_audience");
        if (r25 == null) goto L48;
    L49:
        r24.put("request_page", r25);
        if (r19 != null) goto L52;
        r19 = BuildConfig.FLAVOR;
    L52:
        r24.put("to_user_id", r19);
        r24.put("to_comment_id", String.valueOf(r0.getMessageId()));
        r24.put("to_comment_type", String.valueOf(r7));
        if (r23 == null) goto L55;
        LiveMode r113 = r23.getStreamType();
    L56:
        int r2 = h1.a;
        String r114 = i1.a(r113);
        if (TextUtils.isEmpty(r114) == false) goto L69;
        if (r23 == null) goto L60;
        LiveMode r26 = r23.getStreamType();
    L62:
        if (r26 != LiveMode.MEDIA) goto L64;
        r114 = "media";
        goto L69
    L64:
        if (r23 == null) goto L67;
        r1 = r23.getStreamType();
    L67:
        if (r1 != LiveMode.OFFICIAL_ACTIVITY) goto L69;
        r114 = "official_activity";
        goto L69
    L60:
        r26 = null;
    L69:
        r24.put("live_type", r114);
        j0 r115 = j0.l();
        int r27 = c0.b;
        boolean r28 = com.bytedance.android.live.revenue.core.util.h.a;
        j r29 = com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class).getRevenueLinkDataHolder();
        l r30 = new l();
        r30.a = r29.getChannelId();
        r30.b = r29.a();
        r30.c = (int) r29.getDuration();
        r30.d = r29.A();
        r30.e = r29.getPkId();
        r30.h = r29.B();
        r30.i = r29.getRequestId();
        r30.a(Boolean.valueOf(r29.isOnceMore()));
        r30.f = r29.getTheme();
        r115.sendLog("livesdk_live_user_report", r24, new Object[]{IRoom.class, x.class, n.f(), new c0(r30)});
        goto L70
    L55:
        r113 = null;
    L48:
        r25 = BuildConfig.FLAVOR;
    L43:
        r111 = BuildConfig.FLAVOR;
    L38:
        r23 = null;
        goto L39
    L30:
        r7 = 2;
        goto L31
    L26:
        r6 = "live_barrage";
    L70:
        v r116 = this.d;
        if (r116 == null) goto L75;
        r116.l20(false);
        return;
    L75:
        return;
    L76:
        return;
    }
}

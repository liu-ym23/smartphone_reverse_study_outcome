package com.bytedance.android.livesdk.interactivity.publicscreen.viewholder;

import am2.x;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.base.model.message.b4;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.announcement.IMiddlewareAnnouncementService;
import com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.message.AppointmentInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class RoomIntroViewHolder$Companion$setAppointmentInfo$1 implements View.OnClickListener {
    public final /* synthetic */ AppointmentInfo a;
    public final /* synthetic */ b4 b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ ImageView d;
    public final /* synthetic */ DataCenter e;

    public RoomIntroViewHolder$Companion$setAppointmentInfo$1(AppointmentInfo r1, b4 r2, boolean r3, ImageView r4, DataCenter r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r15) {
        String r16 = this.a.getAppointmentId();     // Catch: Exception -> L44
        if (r16 == null) goto L47;
        final long r7 = CastLongProtector.parseLong(r16);     // Catch: Exception -> L44
        Boolean r17 = this.b.c;     // Catch: Exception -> L44
        if (r17 == null) goto L7;
        final boolean r1 = r17.booleanValue();     // Catch: Exception -> L44
    L8:
        o r18 = j0.l().c(x.class);     // Catch: Exception -> L44
        String r2 = BuildConfig.FLAVOR;
        if (r18 == null) goto L17;
        Map r3 = r18.getMap();     // Catch: Exception -> L44
        if (r3 == null) goto L17;
        String r4 = (String) r3.get("enter_from_merge");     // Catch: Exception -> L44
        if (r4 == null) goto L17;
        String r9 = r4;
    L18:
        if (r18 == null) goto L23;
        Map r19 = r18.getMap();     // Catch: Exception -> L44
        if (r19 == null) goto L23;
        String r110 = (String) r19.get("enter_method");     // Catch: Exception -> L44
        if (r110 == null) goto L23;
    L24:
        RoomIntroViewHolder.a r5 = RoomIntroViewHolder.w;     // Catch: Exception -> L44
        String r6 = this.a.getAppointmentId();     // Catch: Exception -> L44
        if (r6 == null) goto L28;
        r2 = r6;
    L28:
        List r8 = this.a.getScheduledWeekdays();     // Catch: Exception -> L44
        boolean r10 = this.c;     // Catch: Exception -> L44
        Boolean r11 = this.b.c;     // Catch: Exception -> L44
        if (r11 == null) goto L31;
        boolean r13 = r11.booleanValue();     // Catch: Exception -> L44
    L32:
        r5.getClass();     // Catch: Exception -> L44
        RoomIntroViewHolder.a.c("livesdk_live_announce_card_click", r2, r8, r10, r13);     // Catch: Exception -> L44
        Disposable r14 = RoomIntroViewHolder.p;     // Catch: Exception -> L44
        if (r14 == null) goto L35;
        r14.dispose();     // Catch: Exception -> L44
    L35:
        IMiddlewareAnnouncementService r111 = k.f(IMiddlewareAnnouncementService.class);     // Catch: Exception -> L44
        if (r111 == null) goto L41;
        if (r1 == true) goto L39;
        boolean r112 = true;
    L40:
        final String r20 = r9;
        final String r21 = r110;
        Function0<Unit> r113 = new RoomIntroViewHolder$Companion$setAppointmentInfo$1$$special$$inlined$let$lambda$1(r1, r20, r21, r7, this);     // Catch: Exception -> L44
        Disposable r114 = r111.subscribeAnnouncementOpt(r7, r9, r110, r112, "10034", r113);     // Catch: Exception -> L44
    L42:
        RoomIntroViewHolder.p = r114;     // Catch: Exception -> L44
        return;
    L39:
        r112 = false;
        goto L40
    L41:
        r114 = null;
        goto L42
    L31:
        r13 = false;
    L23:
        r110 = BuildConfig.FLAVOR;
    L17:
        r9 = BuildConfig.FLAVOR;
        goto L18
    L7:
        r1 = false;
        goto L8
    L47:
        return;
    }
}

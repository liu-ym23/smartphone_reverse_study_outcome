package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostVerify;
import com.bytedance.android.livesdk.message.model.cn;
import com.bytedance.android.livesdk.message.model.mj;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o3<T> implements Consumer {
    public final /* synthetic */ VerifyCodeWidget a;
    public final /* synthetic */ cn b;
    public final /* synthetic */ Room c;

    public o3(VerifyCodeWidget r1, cn r2, Room r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r12) {
        Response r13 = (Response) r12;
        VerifyCodeWidget r0 = this.a;
        cn r1 = this.b;
        LiveMode r2 = null;
        if (r13 == null) goto L5;
        hu2.c r14 = (hu2.c) ((BaseResponse) r13).data;
    L6:
        Room r3 = this.c;
        int r4 = VerifyCodeWidget.g;
        r0.getClass();
        if (r1 == null) goto L51;
        StringBuilder r5 = new StringBuilder("showVerifyCodeDialog, data=");
        if (r14 == null) goto L12;
        Long r6 = Long.valueOf(r14.codeType);
    L13:
        r5.append(r6);
        Logger.d("VerifyCodeWidget", r5.toString());
        IHostVerify r7 = TTLiveSDK.hostService().verify();
        Activity r8 = com.bytedance.android.live.core.utils.s2.a(((Widget) r0).context);
        if (r14 == null) goto L16;
        int r9 = (int) r14.codeType;
    L17:
        r7.showCaptcha(r8, r9, new q3(r0, r1, r14));
        r0.a.add(Observable.timer(r1.getDuration(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new r3(r0), s3.a));
        Room r15 = (Room) ((Widget) r0).dataCenter.get("data_room", null);
        if (r15 == null) goto L20;
        HashMap r10 = new HashMap();
        r10.put("_param_live_platform", "live");
        r10.put("anchor_id", r15.getOwnerUserIdString());
        r10.put("live_type", r0.zq(r15));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_verification_code_show", r10, new Object[0]);
    L20:
        if (r3 == null) goto L23;
        r2 = r3.getStreamType();
    L23:
        if (r2 != LiveMode.SCREEN_RECORD) goto L50;
        String r16 = ((Widget) r0).context.getString(2131923050, new Object[]{Long.valueOf(r1.getDuration())});
        if (rx1.m.e(((Widget) r0).context) == false) goto L28;
        xs2.b.a().post(new mj(true, r16, r1.getDuration()));
        String r17 = "floating_window";
    L48:
        r0.f = r17;
        r0.Aq();
        return;
    L28:
        if (NotificationManagerCompat.from(((Widget) r0).context).areNotificationsEnabled() == false) goto L47;
        Context r11 = ((Widget) r0).context;
        Object r18 = r11.getSystemService("notification");
        if (r18 == null) goto L46;
        NotificationManager r19 = (NotificationManager) r18;
        int r20 = Build.VERSION.SDK_INT;
        if (r20 >= 26) goto L34;
    L36:
        Intent r21 = new Intent();
        if (r20 < 23) goto L39;
        int r22 = 1140850688;
    L40:
        PendingIntent r23 = PendingIntent.getActivity(r11, 0, r21, r22);
        if (r20 < 26) goto L43;
        NotificationCompat.Builder r24 = new NotificationCompat.Builder(r11, r0.e);
    L44:
        r24.setContentTitle(r16).setSmallIcon(2131251680).setOngoing(false).setWhen(System.currentTimeMillis()).setContentIntent(r23).setCategory("event").setOnlyAlertOnce(true).setAutoCancel(true);
        r24.setVisibility(1);
        NotificationManagerCompat.from(r11).notify(2131389869, r24.build());
        r0.Aq();
        r17 = "push";
        goto L48
    L43:
        r24 = new NotificationCompat.Builder(r11);
        goto L44
    L39:
        r22 = 1073741824;
        goto L40
    L34:
        if (r19.getNotificationChannel(r0.e) != null) goto L36;
        NotificationChannel r25 = new NotificationChannel(r0.e, r11.getString(2131919861), 4);
        r25.enableVibration(false);
        r19.createNotificationChannel(r25);
        goto L36
    L46:
        throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
    L47:
        IESUIUtils.displayToast(((Widget) r0).context, r16);
        r17 = "toast";
        goto L48
    L50:
        return;
    L16:
        r9 = 0;
        goto L17
    L12:
        r6 = null;
        goto L13
    L51:
        return;
    L5:
        r14 = null;
        goto L6
    }
}

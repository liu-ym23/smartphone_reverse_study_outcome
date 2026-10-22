package com.bytedance.android.livesdk.jsbridge.methods;

import androidx.core.app.NotificationManagerCompat;
import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.android.livesdk.dislike.NotificationSettingBottomDialog;
import com.bytedance.android.livesdkapi.live.NotificationSettingCallBack;
import com.bytedance.android.livesdkapi.live.UGDialoOnClickCallBack;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LivePlayNotifyIntegrateConfig;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "openLiveNotificationPanel")
public final class t2 extends o<v2, OpenLiveNotificationPanelResultModel> implements UGDialoOnClickCallBack {
    public static boolean b;
    public final LinkedList<Pair<v2, CallContext>> a;

    public static final class a {
    }

    public static final class b implements NotificationSettingCallBack {
        public final /* synthetic */ CallContext a;
        public final /* synthetic */ Object b;

        public final void onFailure() {
        }

        public b(CallContext r1, Object r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onSuccess(String r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "anchorId");
            JSONObject r4 = new JSONObject();
            r4.put("status", r3);     // Catch: Throwable -> L5
            this.a.b("H5_setLiveNotificationStatus", r4);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Logger.e(th.getMessage());
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ Pair a;
        public final /* synthetic */ t2 b;

        public c(Pair r1, t2 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.j((v2) this.a.getFirst(), (CallContext) this.a.getSecond());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public t2() {
        this.a = new LinkedList();
    }

    public final void onDialog(Boolean r5) {
        b = false;
        IMiddlewareLiveService r0 = jc1.k.f(IMiddlewareLiveService.class);
        if (r0 == null) goto L6;
        r0.unRegisterUgDialog(this);
    L6:
        if (this.a.isEmpty() == false) goto L8;
        return;
    L8:
        if (r5 != null) goto L10;
        return;
    L10:
        if (r5.booleanValue() == true) goto L12;
        return;
    L12:
        if (this.a.isEmpty() == true) goto L17;
        Pair<v2, CallContext> r6 = this.a.pop();
        ThreadUtils.a().postDelayed(new c(r6, this), 1000);
        goto L12
    }

    public static void k(String r2, String r3) {
        com.bytedance.android.livesdk.log.j0.l().sendLog("live_start_notice", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("event_author_name", r3), TuplesKt.to("event_author_id", r2), TuplesKt.to("enter_from_merge", "others_homepage")}), new Object[0]);
    }

    public final void invoke(Object r4, CallContext r5) {
        v2 r6 = (v2) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
    L34:
        OpenLiveNotificationPanelResultModel r7 = new OpenLiveNotificationPanelResultModel();
        r7.a(OpenLiveNotificationPanelResultModel.Code.Failed);
        Unit r8 = Unit.INSTANCE;
        finishWithResult(r7);
        return;
    L4:
        if (LivePlayNotifyIntegrateConfig.enableLiveModifyDialogClose() == true) goto L10;
        NotificationSettingBottomDialog.a r0 = new NotificationSettingBottomDialog.a();     // Catch: Throwable -> L34
        r0.b = r6.b();     // Catch: Throwable -> L34
        r0.a = "others_homepage";     // Catch: Throwable -> L34
        Integer r9 = r6.a();     // Catch: Throwable -> L34
        if (r9 == null) goto L8;
        Long r10 = Long.valueOf(r9.intValue());     // Catch: Throwable -> L34
    L9:
        r0.c = r10;     // Catch: Throwable -> L34
        NotificationSettingBottomDialog r11 = r0.a();     // Catch: Throwable -> L34
        r11.m = new u2(r5);     // Catch: Throwable -> L34
        bn2.k.e(r5.getContext(), r11);     // Catch: Throwable -> L34
        return;
    L8:
        r10 = null;
        goto L9
    L10:
        Object r1 = r6.a();     // Catch: Throwable -> L34
        if (r1 != null) goto L14;
        r1 = 0L;     // Catch: Throwable -> L34
    L14:
        if (NotificationManagerCompat.from(r5.getContext()).areNotificationsEnabled() == false) goto L16;
    L32:
        j(r6, r5);     // Catch: Throwable -> L34
        return;
    L16:
        if (LivePlayNotifyIntegrateConfig.enableSubscribeUGDialog() == false) goto L32;
        if (Intrinsics.areEqual(r1, 3) == true) goto L22;
        if (Intrinsics.areEqual(r1, 2) == false) goto L32;
    L22:
        if (b == true) goto L38;
        b = true;     // Catch: Throwable -> L34
        String r2 = r6.b();     // Catch: Throwable -> L34
        if (r2 == null) goto L31;
        String r3 = r6.c();     // Catch: Throwable -> L34
        if (r3 == null) goto L31;
        IMiddlewareLiveService r13 = jc1.k.f(IMiddlewareLiveService.class);     // Catch: Throwable -> L34
        if (r13 == null) goto L30;
        r13.registerUgDialog(this);     // Catch: Throwable -> L34
    L30:
        k(r2, r3);     // Catch: Throwable -> L34
    L31:
        this.a.add(new Pair(r6, r5));     // Catch: Throwable -> L34
        return;
    }

    public final void j(v2 r10, CallContext r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        Number r0 = r10.a();
        if (r0 != null) goto L5;
        r0 = 0L;
    L5:
        String r3 = r10.b();
        if (r3 == null) goto L12;
        ILiveService r1 = jc1.k.f(ILiveService.class);
        if (r1 == null) goto L10;
        r1.notificationSettingModify(r11.getContext(), r3, com.bytedance.android.livesdk.dislike.x.a(r0.longValue()), "others_homepage", new b(r11, r0), !LivePlayNotifyIntegrateConfig.enableSubscribeUGDialog());
    L10:
        OpenLiveNotificationPanelResultModel r13 = new OpenLiveNotificationPanelResultModel();
        r13.a(OpenLiveNotificationPanelResultModel.Code.Success);
        Unit r14 = Unit.INSTANCE;
        finishWithResult(r13);
        return;
    }
}

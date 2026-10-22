package com.bytedance.android.live.network.impl.interceptor;

import android.app.Activity;
import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.i2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.config.j2;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdkapi.ILiveActivityResultListener;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class DSLimitInterceptor implements q {
    public static final Pattern a = null;
    public static Dialog b;
    public static final Lazy c = null;
    public static final DSLimitInterceptor d = null;

    public DSLimitInterceptor() {
    }

    static {
        d = new DSLimitInterceptor();
        a = PatternProtector.compile(".*/webcast/gift/send.*");
        c = LazyKt.lazy(DSLimitInterceptor$mHandler$2.INSTANCE);
    }

    public static final void d(Activity r6, String r7) {
        j r1 = new j();
        if ((r6 instanceof ILiveActivityResultListener) == false) goto L6;
        ((ILiveActivityResultListener) r6).setOnLiveActivityResultListener(new o(r6, r1));
    L6:
        if (tb1.c.a == false) goto L16;
        Uri r8 = i2.e(UriProtector.parse((String) j2.a.getValue()), "enter_from").buildUpon().appendQueryParameter("request_page", "live_detail").appendQueryParameter("enter_from", r7).appendQueryParameter("request_code", String.valueOf(101)).build();     // Catch: Exception -> L11
        if (r8 == null) goto L17;
        TTLiveSDK.hostService().action().handleSchema(r6, r8.toString(), new Bundle());     // Catch: Exception -> L11
        return;
    L17:
        return;
    L11:
        e = move-exception;
        ALogger.e("DSLimitInterceptor", e);
        return;
    }

    @Override // com.bytedance.android.live.network.impl.interceptor.q
    public final void c(String r3, ExtraResponse r4) {
        Intrinsics.checkNotNullParameter(r4, "response");
        Intrinsics.checkNotNullParameter("live_detail", "requestPage");
        f(r3, 0, r4.data);
    }

    public static boolean e(int r5, RequestError r6, Object r7) {
        boolean r2 = false;
        switch(r5) {
            case 4017006: goto L48;
            case 4017007: goto L18;
            case 4017013: goto L48;
            case 4017016: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        do0.b.a(r5, r7);
        if (r6 == null) goto L8;
        r6.setBlockNotice(true);
    L8:
        Dialog r8 = b;
        if (r8 != null) goto L11;
    L13:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_name_verification_popup_show", null, new Object[]{am2.x.class, Room.class});
        Activity r9 = jc1.k.n(IHostApp.class).getCurrentActivity();
        if (r9 == null) goto L61;
        ((Handler) c.getValue()).post(new m(r9));
        return true;
    L61:
        return false;
    L11:
        if (r8.isShowing() != true) goto L13;
        return true;
    L18:
        if (r6 == null) goto L20;
        r6.setBlockNotice(true);
    L20:
        Dialog r10 = b;
        if (r10 != null) goto L23;
    L25:
        if (r6 == null) goto L27;
        String r11 = r6.prompts;
    L28:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_sms_verification_popup_show", null, new Object[]{am2.x.class, Room.class});
        xs2.b.a().post(new HorizontalPlayEvent(1));
        Activity r12 = jc1.k.n(IHostApp.class).getCurrentActivity();
        if (r12 == null) goto L62;
        String r13 = TTLiveSDK.hostService().user().getBindPhoneNumber();
        int r0 = do0.b.a;
        if (r13 != null) goto L34;
    L37:
        boolean r1 = true;
    L38:
        HashMap r3 = new HashMap();
        r3.put("info", String.valueOf(!r1));
        r3.put("type", "bindPhone");
        LiveSlardarMonitor.monitorStatus("ttlive_service_ds_limit", 0, r3);
        if (r13 != null) goto L41;
    L42:
        r2 = true;
    L43:
        if (r2 == false) goto L45;
        String r4 = s1.B(2131915306);
    L46:
        ((Handler) c.getValue()).post(new n(r11, r12, r4, r13));
        return true;
    L45:
        r4 = s1.B(2131916307);
        goto L46
    L41:
        if (r13.length() != 0) goto L43;
    L34:
        if (r13.length() == 0) goto L37;
        r1 = false;
        goto L38
    L62:
        return false;
    L27:
        r11 = null;
        goto L28
    L23:
        if (r10.isShowing() != true) goto L25;
        return true;
    L48:
        do0.b.a(r5, r7);
        if (r6 == null) goto L51;
        r6.setBlockNotice(true);
    L51:
        Dialog r14 = b;
        if (r14 != null) goto L54;
    L56:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_consume_interrupt_popup_show", null, new Object[]{am2.x.class, Room.class});
        Activity r15 = jc1.k.n(IHostApp.class).getCurrentActivity();
        if (r15 == null) goto L63;
        ((Handler) c.getValue()).post(new h(r5, r6, r15));
        return true;
    L63:
        return false;
    L54:
        if (r14.isShowing() != true) goto L56;
        return true;
    }

    public static void f(String r2, int r3, Object r4) {
        if (r3 != 0) goto L40;
        Pattern r0 = a;     // Catch: Exception -> L36
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        if (r0.matcher(r2).matches() == true) goto L9;
        return;
    L9:
        if ((r4 instanceof p2) == false) goto L42;
        com.bytedance.android.live.core.model.profit.a r5 = ((p2) r4).getCalmPeriod();     // Catch: Exception -> L36
        if (r5 == null) goto L13;
        String r6 = r5.b();     // Catch: Exception -> L36
    L15:
        if (r6 != null) goto L17;
    L20:
        boolean r7 = true;
    L21:
        if (r7 == true) goto L43;
        ApiServerException r8 = new ApiServerException(4017005);     // Catch: Exception -> L36
        r8.setBlockNotice(true);     // Catch: Exception -> L36
        Dialog r1 = b;     // Catch: Exception -> L36
        if (r1 != null) goto L25;
    L28:
        do0.b.a(r3, r4);     // Catch: Exception -> L36
        com.bytedance.android.live.core.model.profit.a r9 = ((p2) r4).getCalmPeriod();     // Catch: Exception -> L36
        if (r9 != null) goto L31;
        return;
    L31:
        Activity r10 = jc1.k.n(IHostApp.class).getCurrentActivity();     // Catch: Exception -> L36
        if (r10 != null) goto L34;
        return;
    L34:
        ((Handler) c.getValue()).post(new i(r9, r10));     // Catch: Exception -> L36
        throw r8;     // Catch: Exception -> L36
    L25:
        if (r1.isShowing() != true) goto L28;
        throw r8;     // Catch: Exception -> L36
    L43:
        return;
    L17:
        if (r6.length() == 0) goto L20;
        r7 = false;
        goto L21
    L13:
        r6 = null;
        goto L15
    L42:
        return;
    L36:
        e = move-exception;
        ALogger.e("DSLimitInterceptor", "pattern throws=" + e.getMessage());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.network.impl.interceptor.q
    public final boolean b(int r3, com.bytedance.android.live.network.response.c r4, RequestError r5) {
        Intrinsics.checkNotNullParameter(r4, "response");
        Intrinsics.checkNotNullParameter("live_detail", "requestPage");
        if ((r4 instanceof ExtraResponse) == false) goto L5;
        String r6 = ((ExtraResponse) r4).data.toString();
    L7:
        return e(r3, r5, r6);
    L5:
        r6 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.network.impl.interceptor.q
    public final boolean a(String r2, int r3, BaseResponse<?, ?> r4, String r5, RequestError r6) {
        Intrinsics.checkNotNullParameter(r4, "response");
        Intrinsics.checkNotNullParameter("live_detail", "requestPage");
        if (e(r3, r6, r4.data) == false) goto L6;
        return true;
    L6:
        f(r2, r3, r4.data);
        return false;
    }
}

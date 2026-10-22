package com.bytedance.android.live.core.verify.interceptor;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.MinorExtra;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.verify.monitor.RealNameFullMonitor;
import com.bytedance.android.live.network.NetworkSettingKeys;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.config.fm0;
import com.bytedance.android.livesdk.config.fy0;
import com.bytedance.android.livesdk.config.j2;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.m7;
import com.bytedance.android.livesdk.recharge.model.RechargeVerifyTraceStep;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.ILiveActivityResultListener;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.LiveRealNameOptConfig;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v80.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class MinorInterceptor {
    public static Handler a;
    public static final List<Integer> b = null;
    public static final LiveRealNameOptConfig c = null;
    public static final MinorInterceptor d = null;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ t80.a c;

        public a(int r1, String r2, t80.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r13, int r14) {
            MinorInterceptor r15 = MinorInterceptor.d;
            int r0 = this.a;
            String r1 = this.b;
            t80.a r2 = this.c;
            r15.getClass();
            Boolean r16 = (Boolean) fm0.a.getValue();
            String r8 = GamePromoteDataContext.GAME_TYPE_MOBILE;
            if (r0 != 42201) goto L9;
            HashMap r3 = new HashMap();
            r3.put("button_type", "cancel");
            if (r16.booleanValue() == true) goto L8;
            r8 = "0";
        L8:
            r3.put("is_cert_v3", r8);
            u.l().sendLog("livesdk_name_verification_popup_click", r3, new Object[]{x.class, Room.class});
        L18:
            ALogger.i("MinorInterceptor", "verify dialog canceled， statusCode：" + r0 + ", isUsing cert version 3.0: " + r16);
            t80.a r17 = this.c;
            if (r17 == null) goto L21;
            r17.onVerifyResult(0);
        L21:
            RealNameFullMonitor.d(this.a, "cancel");
            int r18 = do0.a.a;
            do0.a.b(RechargeVerifyTraceStep.STEP_RECHARGE_VERIFY_CANCEL_CLICK, this.a, "", "", "");
            r13.dismiss();
            return;
        L9:
            HashMap r5 = new HashMap();
            r5.put("request_page", r1);
            if (r2 != null) goto L12;
            String r4 = "consume";
        L13:
            r5.put("popup_source", r4);
            r5.put("click_result", "cancel");
            if (r16.booleanValue() == true) goto L17;
            r8 = "0";
        L17:
            r5.put("is_cert_v3", r8);
            u.l().sendLog("livesdk_popup_for_identification_click", r5, new Object[]{x.class, Room.class});
            goto L18
        L12:
            r4 = "recharge";
            goto L13
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ t80.a c;
        public final /* synthetic */ Function0 d;

        public b(int r1, String r2, t80.a r3, Function0 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r13, int r14) {
            MinorInterceptor r15 = MinorInterceptor.d;
            int r0 = this.a;
            String r1 = this.b;
            t80.a r2 = this.c;
            r15.getClass();
            Boolean r16 = (Boolean) fm0.a.getValue();
            String r7 = GamePromoteDataContext.GAME_TYPE_MOBILE;
            if (r0 != 42201) goto L9;
            HashMap r3 = new HashMap();
            r3.put("button_type", "confirm");
            if (r16.booleanValue() == true) goto L8;
            r7 = "0";
        L8:
            r3.put("is_cert_v3", r7);
            u.l().sendLog("livesdk_name_verification_popup_click", r3, new Object[]{x.class, Room.class});
        L18:
            ALogger.i("MinorInterceptor", "verify dialog click confirm， statusCode：" + r0 + ", isUsing cert version 3.0: " + r16);
            RealNameFullMonitor.d(this.a, "sure");
            this.d.invoke();
            int r17 = do0.a.a;
            do0.a.b(RechargeVerifyTraceStep.STEP_RECHARGE_VERIFY_CONFIRM_CLICK, this.a, "", "", "");
            r13.dismiss();
            return;
        L9:
            HashMap r4 = new HashMap();
            r4.put("request_page", r1);
            if (r2 != null) goto L12;
            String r5 = "consume";
        L13:
            r4.put("popup_source", r5);
            r4.put("click_result", "confirm");
            if (r16.booleanValue() == true) goto L17;
            r7 = "0";
        L17:
            r4.put("is_cert_v3", r7);
            u.l().sendLog("livesdk_popup_for_identification_click", r4, new Object[]{x.class, Room.class});
            goto L18
        L12:
            r5 = "recharge";
            goto L13
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ t80.a b;

        public c(int r1, t80.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r2) {
            RealNameFullMonitor.d(this.a, "cancel");
            t80.a r3 = this.b;
            if (r3 == null) goto L6;
            r3.onVerifyResult(0);
            return;
        }
    }

    public MinorInterceptor() {
    }

    static {
        d = new MinorInterceptor();
        b = CollectionsKt.listOf(new Integer[]{42200, 42201, 42202});
        c = (LiveRealNameOptConfig) m7.a.getValue();
    }

    public static Handler e() {
        if (a != null) goto L6;
        a = new Handler(Looper.getMainLooper());
    L6:
        return a;
    }

    public static final boolean d(MinorInterceptor r5, String r6, int r7) {
        r5.getClass();
        if (r7 != 42201) goto L39;
        List r8 = c.getInterceptorRegexList();
        if (r8.isEmpty() == false) goto L10;
        r8 = null;
    L10:
        if (r8 == null) goto L22;
        d.getClass();
        String r3 = new URL(r6).getPath();     // Catch: Exception -> L20
        if (r3 == null) goto L22;
        ALogger.i("MinorInterceptor", "checkIfPathMatchesAnyRegex-- URL(urlStr).path:".concat(r3));     // Catch: Exception -> L20
        Iterator r9 = r8.iterator();     // Catch: Exception -> L20
    L16:
        if (r9.hasNext() == false) goto L22;
        if (r3.equals((String) r9.next()) == false) goto L16;
        boolean r11 = true;
    L23:
        StringBuilder r2 = new StringBuilder("newVerifyEnable--enable:");
        LiveRealNameOptConfig r4 = c;
        r2.append(r4.getEnable());
        r2.append(",url：");
        r2.append(r6);
        r2.append(" interceptorRegexList: ");
        r2.append(r4.getInterceptorRegexList());
        r2.append("，pathRegexMatch=");
        r2.append(r11);
        r2.append(", realNameConfig.lynxSchema=");
        r2.append(r4.getLynxSchema());
        ALogger.i("MinorInterceptor", r2.toString());
        com.bytedance.android.live.base.abtest.b.a r12 = com.bytedance.android.live.base.abtest.b.b;
        ClientABTestKey<Integer> r1 = com.bytedance.android.live.base.abtest.a.e;
        r12.getClass();
        int r13 = ((Number) com.bytedance.android.live.base.abtest.b.a.a(r1)).intValue();
        if (r4.getEnable() == true) goto L27;
        if (r13 == 1) goto L27;
        return false;
    L27:
        if (r2.a(r4.getLynxSchema()) == false) goto L37;
        if (r11 == false) goto L38;
        return true;
    L38:
        return false;
    L37:
        return false;
    L20:
        e = move-exception;
        ALogger.i("MinorInterceptor", "checkIfPathMatchesAnyRegex--Exception-- urlStr:" + r6 + "--e=" + e);
    L22:
        r11 = false;
        goto L23
    L39:
        return false;
    }

    public final void f(int r18, RequestError r19, Extra r21) {
        Extra r0 = r21;
        Intrinsics.checkNotNullParameter("live_detail", "requestPage");
        if (b.contains(Integer.valueOf(r18)) == true) goto L5;
        return;
    L5:
        if (r0 != null) goto L7;
    L21:
        h(null, r18, "live_detail", r19, null);
        return;
    L7:
        if ((r0 instanceof MinorExtra) == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L21;
        MinorExtra r1 = (MinorExtra) r0;
        String r7 = r1.getScene();
        String r9 = r1.getTicket();
        if (r7 != null) goto L14;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L20;
        d.h(null, r18, "live_detail", r19, null);
        return;
    L20:
        d.g(null, r18, "live_detail", r19, null, r7, r1.getFlow(), r9, true);
        return;
    L14:
        if (r7.length() == 0) goto L17;
        r2 = false;
        goto L18
    }

    public static final void c(MinorInterceptor r2, Activity r3, String r4, t80.a r5) {
        r2.getClass();
        Uri r6 = UriProtector.parse(c.getLynxSchema()).buildUpon().appendQueryParameter("request_url", new URL(r4).getPath()).appendQueryParameter("request_code", String.valueOf(101)).build();     // Catch: Exception -> L11
        if (r6 == null) goto L8;
        TTLiveSDK.hostService().action().handleSchema(r3, r6.toString(), new Bundle());     // Catch: Exception -> L11
        if (r5 == null) goto L14;
        r5.onVerifyResult(0);     // Catch: Exception -> L11
    L14:
        return;
    L8:
        if (r5 == null) goto L14;
        r5.onVerifyResult(1);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        ALogger.i("MinorInterceptor", "newVerifyByLynxPage--Exception--e=" + e);
    }

    public static final void b(MinorInterceptor r11, Activity r12, int r13, String r14, t80.a r15) {
        r11.getClass();
        if (r15 != null) goto L5;
        String r16 = "consume";
    L6:
        com.bytedance.android.live.core.verify.interceptor.b r0 = new com.bytedance.android.live.core.verify.interceptor.b(r13, r15, r12);
        ALogger.i("MinorInterceptor", "start to verify with old live certification");
        if ((r13 & 1) == 0) goto L22;
        if ((r13 & 2) == 0) goto L22;
        if ((r12 instanceof ILiveActivityResultListener) == false) goto L14;
        ((ILiveActivityResultListener) r12).setOnLiveActivityResultListener(new com.bytedance.android.live.core.verify.interceptor.c(r12, r0));
    L14:
        if (tb1.c.a == false) goto L33;
        Uri r17 = UriProtector.parse((String) j2.a.getValue()).buildUpon().appendQueryParameter("request_page", r14).appendQueryParameter("request_code", String.valueOf(101)).build();     // Catch: Exception -> L19
        if (r17 == null) goto L34;
        TTLiveSDK.hostService().action().handleSchema(r12, r17.toString(), new Bundle());     // Catch: Exception -> L19
        return;
    L34:
        return;
    L19:
        e = move-exception;
        ALogger.e("MinorInterceptor", e);
        return;
    L33:
        return;
    L22:
        if ((r13 & 2) == 0) goto L36;
        Bundle r7 = new Bundle();
        r7.putString("enter_from", "minor");
        r7.putString("request_page", r14);
        r7.putString("popup_source", r16);
        IUserService r18 = k.f(IUserService.class);
        if (r18 != null) goto L26;
    L28:
        String r19 = null;
    L29:
        com.bytedance.android.live.core.verify.utils.a.p(r12, null, "recharge", r19, r7, new d(r0), e.a, false);
        return;
    L26:
        if (r18.user().isLogin() == false) goto L28;
        r19 = r18.user().a(r18.user().n());
        goto L29
    L36:
        return;
    L5:
        r16 = "recharge";
        goto L6
    }

    public final void h(Activity r13, final int r14, final String r15, final RequestError r16, final t80.a r17) {
        Intrinsics.checkNotNullParameter(r15, "requestPage");
        int r0 = do0.a.a;
        RechargeVerifyTraceStep r1 = RechargeVerifyTraceStep.STEP_RECHARGE_MINOR_VERIFY_2;
        if (r16 == null) goto L5;
        String r2 = r16.url;
    L6:
        do0.a.b(r1, r14, "", "", r2);
        ALogger.i("MinorInterceptor", "start minor certification with authentication old， statusCode：" + r14);
        if (r14 != 42201) goto L25;
        final int r6 = 3;
        if (r13 != null) goto L11;
        Activity r11 = k.n(IHostApp.class).getCurrentActivity();
    L12:
        if (r11 != null) goto L16;
        if (r17 == null) goto L58;
        r17.onVerifyResult(1);
        return;
    L58:
        return;
    L16:
        if (r16 == null) goto L18;
        r16.setBlockNotice(true);
    L18:
        u.l().sendLog("livesdk_name_verification_popup_show", null, new Object[]{x.class, Room.class});
        if ((!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) == false) goto L23;
        Handler r7 = e();
        if (r7 == null) goto L60;
        final Activity r3 = r11;
        r7.post(new MinorInterceptor$minorInterceptOld$1(r3, r14, r15, r17, r16));
        return;
    L60:
        return;
    L23:
        final Activity r4 = r11;
        j(this, r11, r14, r15, r17, new MinorInterceptor$minorInterceptOld$2(r16, r14, r4, r17, r6, r15));
        return;
    L11:
        r11 = r13;
        goto L12
    L25:
        if (r14 != 42202) goto L46;
        if (r13 != null) goto L28;
        final Activity r5 = k.n(IHostApp.class).getCurrentActivity();
    L29:
        if (r5 != null) goto L33;
        if (r17 == null) goto L59;
        r17.onVerifyResult(1);
        return;
    L59:
        return;
    L33:
        if (r16 == null) goto L35;
        r16.setBlockNotice(true);
    L35:
        HashMap r8 = new HashMap();
        r8.put("request_page", r15);
        if (r17 != null) goto L38;
        String r9 = "consume";
    L39:
        r8.put("popup_source", r9);
        u.l().sendLog("livesdk_popup_for_identification_show", r8, new Object[]{x.class, Room.class});
        if ((!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) == false) goto L44;
        Handler r12 = e();
        if (r12 == null) goto L63;
        r12.post(new MinorInterceptor$minorInterceptOld$3(r5, r14, r15, r17));
        return;
    L63:
        return;
    L44:
        j(this, r5, r14, r15, r17, new MinorInterceptor$minorInterceptOld$4(r5, r15, r17));
        return;
    L38:
        r9 = "recharge";
        goto L39
    L28:
        r5 = r13;
        goto L29
    L46:
        if (r14 != 42200) goto L66;
        if (r16 == null) goto L67;
        if (r17 == null) goto L51;
        r17.onVerifyResult(1);
    L51:
        if (((Boolean) NetworkSettingKeys.MINOR_INTERCEPT_USE_SERVER_PROMPTS.getValue()).booleanValue() == true) goto L53;
        r16.alert = s1.B(2131920460);
        return;
    L53:
        if (StringUtils.isEmpty(r16.prompts) == true) goto L55;
        r16.alert = r16.prompts;
        return;
    L55:
        r16.alert = s1.B(2131920460);
        return;
    L67:
        return;
    L66:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static void i(Activity r1, int r2, String r3, t80.a r4, boolean r5, Function0 r6) {
        if (r5 == false) goto L8;
        c9.b r7 = new c9.b();
        r7.a = r1;
        r7.b = 2;
        r7.e = r1.getText(2131923432);
        r7.f = s1.B(2131916539);
        r7.g = 17;
        String r8 = s1.B(2131922826);
        a r0 = new a(r2, r3, r4);
        r7.j = r8;
        r7.k = r0;
        String r9 = s1.B(2131920657);
        b r11 = new b(r2, r3, r4, r6);
        r7.l = r9;
        r7.m = r11;
        r7.n = new c(r2, r4);
        c9 r12 = new c9(r7.a, r7);
        if (DialogLancet.shouldBlockDialogShow(r12) == false) goto L11;
        DialogLancet.handleBlockedDialogShow(r12);
        return;
    L11:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L7:
        DialogLancet.beforeDialogShow(r12);
        r12.show();
        DialogLancet.afterDialogShow(r12);
        return;
    L8:
        RealNameFullMonitor.d(r2, "sure");
        r6.invoke();
    }

    public static /* synthetic */ void j(MinorInterceptor r6, Activity r7, int r8, String r9, t80.a r11, Function0 r12) {
        r6.getClass();
        i(r7, r8, r9, r11, true, r12);
    }

    public static final void a(MinorInterceptor r8, String r9, String r11, String r12, boolean r13, Context r14, t80.a r15) {
        r8.getClass();
        ALogger.i("MinorInterceptor", "start minor certification with authentication 3.0， scene：" + r9 + ", flow: " + r11);
        Map r16 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("faceOnly", String.valueOf(r13))});
        y80.b r0 = y80.c.a();
        f r1 = new f();
        r1.e = r12;
        Intrinsics.checkNotNullParameter(r9, "scene");
        r1.c.put("scene", r9);
        Intrinsics.checkNotNullParameter(r11, "flow");
        r1.c.put("flow", r11);
        r1.d = r13;
        r1.a = r14;
        com.bytedance.android.live.core.verify.interceptor.a r17 = new com.bytedance.android.live.core.verify.interceptor.a(r1, r9, r11, r15, r16);
        Intrinsics.checkNotNullParameter(r17, "callback");
        r1.b = r17;
        int r18 = do0.a.a;
        do0.a.a(RechargeVerifyTraceStep.STEP_RECHARGE_VERIFY_SDK, 0, r9, r11, "", r16);
        if (r0 == null) goto L8;
        y80.a r19 = r0.a;
        if (r19 == null) goto L9;
        r19.a(r1.getContext(), r1);
        return;
    L9:
        return;
    }

    public final void g(Activity r17, final int r18, String r19, final RequestError r21, final t80.a r22, final String r23, final String r24, final String r25, final boolean r26) {
        Intrinsics.checkNotNullParameter(r19, "requestPage");
        if (b.contains(Integer.valueOf(r18)) == true) goto L6;
        return;
    L6:
        if (r23 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L16;
        h(r17, r18, "live_detail", r21, r22);
        return;
    L16:
        if (((Boolean) fm0.a.getValue()).booleanValue() == true) goto L22;
        if (r23 != null) goto L19;
    L21:
        h(r17, r18, "live_detail", r21, r22);
        return;
    L19:
        if (r23.equals(fy0.a.getValue()) != true) goto L21;
    L22:
        final String r12 = "live_detail";
        Intrinsics.checkNotNullParameter("live_detail", "requestPage");
        ALogger.i("MinorInterceptor", "start minor certification with authentication version 3.0， statusCode：" + r18);
        int r0 = do0.a.a;
        RechargeVerifyTraceStep r1 = RechargeVerifyTraceStep.STEP_RECHARGE_MINOR_VERIFY_3;
        if (r21 == null) goto L25;
        String r6 = r21.url;
    L26:
        do0.a.b(r1, r18, r23, r24, r6);
        final Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = r17;
        if (r17 != null) goto L30;
        r7.element = k.n(IHostApp.class).getCurrentActivity();
    L30:
        if (((Activity) r7.element) != null) goto L33;
        if (r22 == null) goto L43;
        r22.onVerifyResult(1);
        return;
    L43:
        return;
    L33:
        if (r23 == null) goto L45;
        if (r24 != null) goto L36;
        return;
    L36:
        if ((!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) == false) goto L40;
        d.getClass();
        Handler r9 = e();
        if (r9 == null) goto L47;
        r9.post(new MinorInterceptor$minorInterceptV3$$inlined$lets$lambda$1(r23, r24, r7, r18, r22, r26, r21, r25));
        return;
    L47:
        return;
    L40:
        MinorInterceptor r13 = d;
        Activity r14 = (Activity) r7.element;
        Function0<Unit> r15 = new MinorInterceptor$minorInterceptV3$$inlined$lets$lambda$2(r23, r24, r7, r18, r12, r22, r26, r21, r25);
        r13.getClass();
        i(r14, r18, "live_detail", r22, r26, r15);
        return;
    L45:
        return;
    L25:
        r6 = null;
        goto L26
    L8:
        if (r23.length() == 0) goto L11;
        r5 = false;
        goto L12
    }
}

package com.larus.uaigc.spring.component;

import android.os.Bundle;
import android.os.SystemClock;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.uaigc.lynx.pocket.ClickPocketInfo;
import com.larus.uaigc.lynx.pocket.Pocket;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u000e\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016JI\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010!J(\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0017H\u0016J\u0012\u0010(\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010+\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J<\u0010,\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u00010\u00172\b\u0010.\u001a\u0004\u0018\u00010\u00172\b\u0010/\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u00100\u001a\u0002012\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0002J&\u00104\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u00010\u00172\b\u0010.\u001a\u0004\u0018\u00010\u00172\b\u0010/\u001a\u0004\u0018\u00010\u0017H\u0016J<\u00105\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00172\b\b\u0002\u00100\u001a\u0002012\n\b\u0002\u00102\u001a\u0004\u0018\u000103J[\u00106\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u00107\u001a\u0004\u0018\u00010\f2\b\u00108\u001a\u0004\u0018\u00010\f2\b\u00109\u001a\u0004\u0018\u00010\f2\b\u0010 \u001a\u0004\u0018\u00010\u00172\b\b\u0002\u00100\u001a\u0002012\n\b\u0002\u00102\u001a\u0004\u0018\u000103¢\u0006\u0002\u0010:R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006<"}, d2 = {"Lcom/larus/uaigc/spring/component/SpringMainVenueReportComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/uaigc/spring/ability/SpringMainVenueReportAbility;", "<init>", "()V", "argumentData", "Lcom/larus/uaigc/spring/launcher/SpringMainVenueArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/spring/launcher/SpringMainVenueArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "leaveStartTime", "", "appBackGroundListener", "com/larus/uaigc/spring/component/SpringMainVenueReportComponent$appBackGroundListener$1", "Lcom/larus/uaigc/spring/component/SpringMainVenueReportComponent$appBackGroundListener$1;", "onCreate", "", "onAttach", "onDestroy", "onResume", "reportLeaveEvent", "leaveType", "", "reportPocketPageShowed", "pocketCacheUsage", "", "lynxViewLoadResult", "schemaHandleTime", "onLoadStartTimeMs", "nativeFirstFrameTimeMs", "lynxFirstFrameTimeMs", "loadErrorMsg", "(ZLjava/lang/Boolean;JJJJLjava/lang/String;)V", "reportApplyResult", "pocketId", "result", "", "pocketType", CustomFeedPlayerEvent.EXTRA_KEY_REASON, "onClickPocketInfoChange", "pocketInfo", "Lcom/larus/uaigc/lynx/pocket/ClickPocketInfo;", "onAlbumClickPocketInfoChange", "mobShowSpringGuideSingleQuestion", "springGuideCardId", "actionBarTemplateId", "actionBarKey", "params", "Lorg/json/JSONObject;", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "reportShowSpringGuideSingleQuestion", "mobPocketApplyResult", "mobPocketPageShowed", "createToLoadDuration", "createToNativeFirstFrameDuration", "createToLynxDuration", "(ZLjava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lorg/json/JSONObject;Lcom/ixigua/lib/track/ITrackNode;)V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SpringMainVenueReportComponent extends BaseContentWidget implements zz9.d {
    public final Lazy m;
    public long n;
    public final b o;

    public static final class a {
    }

    public static final class b implements f09.a.b {
        public final /* synthetic */ SpringMainVenueReportComponent a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
            this.a.j3("leave_app");
        }

        public final void onAppForeground() {
            SpringMainVenueReportComponent r0 = this.a;
            r0.n = SystemClock.elapsedRealtime();
        }

        public b(SpringMainVenueReportComponent r1) {
            this.a = r1;
        }
    }

    public static final class c implements Function0<a0a.b> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(a0a.b.class));
        }
    }

    static {
    }

    public final void onDestroy() {
        AppHost.a.a().c(this.o);
        j3("leave_page");
        IAIChatRenderTraceService.a.l();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, zz9.d.class);
        AppHost.a.a().j(this.o);
    }

    public SpringMainVenueReportComponent() {
        this.m = LazyKt.lazy(new c(this));
        this.o = new b(this);
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        IAIChatRenderTraceService.Companion r0 = IAIChatRenderTraceService.a;
        Pair[] r1 = new Pair[5];
        r1[0] = TuplesKt.to("key_current_page", "spring_guide_2026");
        r1[1] = TuplesKt.to("key_click_from", "spring_guide_2026");
        a0a.b r2 = (a0a.b) this.m.getValue();
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.b();
    L6:
        r1[2] = TuplesKt.to("key_enter_method", r4);
        a0a.b r5 = (a0a.b) this.m.getValue();
        if (r5 == null) goto L9;
        r3 = r5.a();
    L9:
        r1[3] = TuplesKt.to("key_action_bar_key", r3);
        r1[4] = TuplesKt.to("spring_guide_card_id", "");
        r0.h(MapsKt.mapOf(r1));
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onResume() {
        this.n = SystemClock.elapsedRealtime();
    }

    @Override // zz9.d
    public final void Lj(ClickPocketInfo r7) {
        if (r7 == null) goto L7;
        Pocket r0 = r7.getPocket();
        if (r0 == null) goto L7;
        String r1 = r0.getPocketId();
        if (r1 == null) goto L7;
    L9:
        if (r7 == null) goto L18;
        Pocket r8 = r7.getPocket();
        if (r8 == null) goto L18;
        Integer r9 = r8.getPocketType();
        if (r9 == null) goto L18;
        if (r9.intValue() != 3) goto L18;
        boolean r10 = true;
    L19:
        if (r10 == false) goto L21;
        String r11 = "1";
    L22:
        IAIChatRenderTraceService.a.h(MapsKt.mapOf(new Pair[]{TuplesKt.to("spring_guide_card_id", r1), TuplesKt.to("key_overview_click_form_addition", r11)}));
        return;
    L21:
        r11 = "0";
    L18:
        r10 = false;
    L7:
        r1 = "";
        goto L9
    }

    @Override // zz9.d
    public final void O2(ClickPocketInfo r3) {
        if (r3 == null) goto L5;
        IAIChatRenderTraceService.a.h(MapsKt.mapOf(TuplesKt.to("key_has_album_pocket", "1")));
        return;
    L5:
        IAIChatRenderTraceService.a.h(MapsKt.mapOf(TuplesKt.to("key_has_album_pocket", "0")));
    }

    @Override // zz9.d
    public final void j3(String r7) {
        Intrinsics.checkNotNullParameter(r7, "leaveType");
        if (this.n > 0) goto L5;
        return;
    L5:
        long r0 = SystemClock.elapsedRealtime() - this.n;
        this.n = 0;
        Long r1 = Long.valueOf(r0);
        com.larus.platform.service.o r2 = com.larus.platform.service.o.a;
        JSONObject r3 = new JSONObject();
        r3.putOpt("leave_type", r7);
        r3.putOpt("duration", r1);
        Unit r8 = Unit.INSTANCE;
        r2.reportEvent("leave_spring_guide_2026_page", r3);
    }

    @Override // zz9.d
    public final void EN(String r9, String r10) {
        JSONObject r0 = new JSONObject();
        r0.put("card_type", "input");
        if (r9 == null) goto L6;
        r0.putOpt("spring_guide_card_id", r9);
    L6:
        if (r10 == null) goto L8;
        r0.putOpt("action_bar_key", r10);
    L8:
        com.larus.platform.service.g.a.monitorEventForSlardar("show_spring_guide_single_question", r0, null, null);
        JSONObject r1 = new JSONObject();
        r1.putOpt("card_type", "input");     // Catch: JSONException -> L15
        if (r9 == null) goto L12;
        r1.putOpt("spring_guide_card_id", r9);     // Catch: JSONException -> L15
    L12:
        if (r10 == null) goto L17;
        r1.putOpt("action_bar_key", r10);     // Catch: JSONException -> L15
    L17:
        TrackParams r11 = new TrackParams().merge(r1);
        by7.a r12 = new by7.a("show_spring_guide_single_question");
        r12.a.merge(r11);
        r12.b();
        return;
    L15:
        e = move-exception;
        FLogger.a.e("SpringMainVenueReportComponent", "error in SpringMainVenueReportComponent mobShowSpringGuideSingleQuestion " + e.getLocalizedMessage());
        goto L17
    }

    @Override // zz9.d
    public final void W7(String r10, int r11, int r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "pocketId");
        Intrinsics.checkNotNullParameter(r13, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        JSONObject r2 = new JSONObject();
        r2.put("pocket_id", r10);
        r2.put("result", r11);
        r2.put("pocket_type", r12);
        r2.put(CustomFeedPlayerEvent.EXTRA_KEY_REASON, r13);
        com.larus.platform.service.g.a.monitorEventForSlardar("pocket_apply_result", r2, null, null);
        JSONObject r3 = new JSONObject();
        Intrinsics.checkNotNullParameter(r10, "pocketId");
        Intrinsics.checkNotNullParameter(r13, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        Intrinsics.checkNotNullParameter(r3, "params");
        r3.putOpt("pocket_id", r10);     // Catch: JSONException -> L5
        r3.putOpt("result", Integer.valueOf(r11));     // Catch: JSONException -> L5
        r3.putOpt("pocket_type", Integer.valueOf(r12));     // Catch: JSONException -> L5
        r3.putOpt(CustomFeedPlayerEvent.EXTRA_KEY_REASON, r13);     // Catch: JSONException -> L5
    L7:
        TrackParams r14 = new TrackParams().merge(r3);
        by7.a r15 = new by7.a("pocket_apply_result");
        r15.a.merge(r14);
        r15.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("SpringMainVenueReportComponent", "error in SpringMainVenueReportComponent mobPocketApplyResult " + e.getLocalizedMessage());
        goto L7
    }

    @Override // zz9.d
    public final void uI(boolean r20, Boolean r21, long r22, long r24, long r26, long r28, String r30) {
        String r11 = r30;
        if (r21 != null) goto L5;
    L12:
        FLogger.a.e("SpringMainVenueReportComponent", "[reportPocketPageShowed] invalid params");
    L13:
        FLogger.a.i("SpringMainVenueReportComponent", "[reportPocketPageShowed] pocketCacheUsage = " + r20 + ", schemaHandleTime = " + r22 + ", onLoadStartTimeMs = " + r24 + ", nativeFirstFrameTimeMs = " + r26 + ", lynxFirstFrameTimeMs = " + r28 + ", loadErrorMsg = " + r11);
        long r5 = r24 - r22;
        long r7 = r26 - r22;
        long r3 = r28 - r22;
        JSONObject r9 = new JSONObject();
        a0a.b r10 = (a0a.b) this.m.getValue();
        if (r10 == null) goto L26;
        Bundle r12 = r10.a;
        if (r12 == null) goto L18;
        String r13 = r12.getString("enter_schema");
    L19:
        if (r13 == null) goto L26;
        if ((!StringsKt.isBlank(r13)) == true) goto L24;
        r13 = null;
    L24:
        if (r13 == null) goto L26;
        r9.put("enter_url", r13);
        goto L26
    L18:
        r13 = null;
    L26:
        r9.put("enter_method", "outer_link");
        com.larus.platform.service.i r16 = com.larus.platform.service.i.a;
        r9.put("is_cold_launch", r16.a() ? 1 : 0);
        r9.put("pocket_cache_usage", r20);
        r9.put("lynx_view_load_result", r21);
        r9.put("create_to_load_duration", r5);
        r9.put("create_to_native_firstFrame_duration", r7);
        r9.put("create_to_lynx_duration", r3);
        if (r11 != null) goto L29;
        Object r2 = "";
    L30:
        r9.put("error_msg", r2);
        com.larus.platform.service.g.a.monitorEventForSlardar("pocket_page_showed", r9, null, null);
        Object r4 = Long.valueOf(r5);
        Object r6 = Long.valueOf(r7);
        Object r8 = Long.valueOf(r3);
        if (r11 != null) goto L33;
        r11 = "";
    L33:
        JSONObject r14 = new JSONObject();
        a0a.b r15 = (a0a.b) this.m.getValue();
        if (r15 == null) goto L46;
        Bundle r17 = r15.a;
        if (r17 == null) goto L38;
        String r18 = r17.getString("enter_schema");
    L39:
        if (r18 == null) goto L46;
        if ((!StringsKt.isBlank(r18)) == true) goto L44;
        r18 = null;
    L44:
        if (r18 == null) goto L46;
        r14.put("enter_url", r18);
        goto L46
    L38:
        r18 = null;
    L46:
        r14.put("enter_method", "outer_link");
        r14.put("is_cold_launch", r16.a() ? 1 : 0);
        Unit r0 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r14, "params");
        if (r4 != null) goto L64;
    L50:
        if (r6 == null) goto L54;
        r14.putOpt("create_to_native_firstFrame_duration", r6);     // Catch: JSONException -> L52
    L54:
        if (r8 == null) goto L57;
        r14.putOpt("create_to_lynx_duration", r8);     // Catch: JSONException -> L52
    L57:
        if (r21 == null) goto L59;
        r14.putOpt("lynx_view_load_result", r21);     // Catch: JSONException -> L52
    L59:
        r14.putOpt("error_msg", r11);     // Catch: JSONException -> L52
        r14.putOpt("pocket_cache_usage", Boolean.valueOf(r20));     // Catch: JSONException -> L52
    L62:
        TrackParams r1 = new TrackParams().merge(r14);
        by7.a r19 = new by7.a("pocket_page_showed");
        r19.a.merge(r1);
        r19.b();
        return;
    L52:
        e = move-exception;
        FLogger.a.e("SpringMainVenueReportComponent", "error in SpringMainVenueReportComponent mobPocketPageShowed " + e.getLocalizedMessage());
        goto L62
    L64:
        r14.putOpt("create_to_load_duration", r4);     // Catch: JSONException -> L52
        goto L50
    L29:
        r2 = r11;
        goto L30
    L5:
        if (r22 < 0) goto L12;
        if (r24 < 0) goto L12;
        if (r26 < 0) goto L12;
        if (r28 >= 0) goto L13;
        goto L12
    }
}

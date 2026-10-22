package com.larus.common.venue.impl.venue.component;

import android.os.Bundle;
import android.os.SystemClock;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u000e\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016JA\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u001fJ(\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0016H\u0016J\u0012\u0010&\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J>\u0010)\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00162\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-H\u0002JU\u0010.\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010/\u001a\u0004\u0018\u00010\f2\b\u00100\u001a\u0004\u0018\u00010\f2\b\u00101\u001a\u0004\u0018\u00010\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-H\u0002¢\u0006\u0002\u00102R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u00064"}, d2 = {"Lcom/larus/common/venue/impl/venue/component/FlowCommonVenueReportComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/common/venue/impl/venue/ability/FlowCommonVenueReportAbility;", "<init>", "()V", "argumentData", "Lcom/larus/common/venue/impl/venue/launcher/FlowCommonVenueArgumentData;", "getArgumentData", "()Lcom/larus/common/venue/impl/venue/launcher/FlowCommonVenueArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "leaveStartTime", "", "appBackGroundListener", "com/larus/common/venue/impl/venue/component/FlowCommonVenueReportComponent$appBackGroundListener$1", "Lcom/larus/common/venue/impl/venue/component/FlowCommonVenueReportComponent$appBackGroundListener$1;", "onAttach", "", "onDestroy", "onResume", "reportLeaveEvent", "leaveType", "", "reportPocketPageShowed", "lynxViewLoadResult", "", "schemaHandleTime", "onLoadStartTimeMs", "nativeFirstFrameTimeMs", "lynxFirstFrameTimeMs", "loadErrorMsg", "(Ljava/lang/Boolean;JJJJLjava/lang/String;)V", "reportApplyResult", "pocketId", "result", "", "pocketType", "reason", "onClickPocketInfoChange", "pocketInfo", "Lcom/larus/common/venue/impl/venue/component/ClickPocketInfo;", "mobPocketApplyResult", "params", "Lorg/json/JSONObject;", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "mobPocketPageShowed", "createToLoadDuration", "createToNativeFirstFrameDuration", "createToLynxDuration", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lorg/json/JSONObject;Lcom/ixigua/lib/track/ITrackNode;)V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowCommonVenueReportComponent extends BaseContentWidget implements v09.c {
    public final Lazy m;
    public long n;
    public final b o;

    public static final class a {
    }

    public static final class b implements f09.a.b {
        public final /* synthetic */ FlowCommonVenueReportComponent a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
            this.a.j3("leave_app");
        }

        public final void onAppForeground() {
            FlowCommonVenueReportComponent r0 = this.a;
            r0.n = SystemClock.elapsedRealtime();
        }

        public b(FlowCommonVenueReportComponent r1) {
            this.a = r1;
        }
    }

    public static final class c implements Function0<x09.a> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(x09.a.class));
        }
    }

    static {
    }

    @Override // v09.c
    public final void Gr() {
    }

    public final void onDestroy() {
        AppHost.a.a().c(this.o);
        j3("leave_page");
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, v09.c.class);
        AppHost.a.a().j(this.o);
    }

    public FlowCommonVenueReportComponent() {
        this.m = LazyKt.lazy(new c(this));
        this.o = new b(this);
    }

    public final void onResume() {
        this.n = SystemClock.elapsedRealtime();
    }

    @Override // v09.c
    public final void j3(String r5) {
        Intrinsics.checkNotNullParameter(r5, "leaveType");
        if (this.n > 0) goto L5;
        return;
    L5:
        SystemClock.elapsedRealtime();
        this.n = 0;
    }

    @Override // v09.c
    public final void W7(String r9, int r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "pocketId");
        Intrinsics.checkNotNullParameter(r12, "reason");
        JSONObject r1 = new JSONObject();
        r1.put("pocket_id", r9);
        r1.put("result", r10);
        r1.put("pocket_type", r11);
        r1.put("reason", r12);
        com.larus.platform.service.g.a.monitorEventForSlardar("common_venue_pocket_apply_result", r1, null, null);
        JSONObject r2 = new JSONObject();
        r2.putOpt("pocket_id", r9);     // Catch: JSONException -> L5
        r2.putOpt("result", Integer.valueOf(r10));     // Catch: JSONException -> L5
        r2.putOpt("pocket_type", Integer.valueOf(r11));     // Catch: JSONException -> L5
        r2.putOpt("reason", r12);     // Catch: JSONException -> L5
    L7:
        TrackParams r13 = new TrackParams().merge(r2);
        by7.a r14 = new by7.a("common_venue_pocket_apply_result");
        r14.a.merge(r13);
        r14.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("FlowCommonVenueReportComponent", "error in FlowCommonVenueReportComponent mobPocketApplyResult " + e.getLocalizedMessage());
        goto L7
    }

    @Override // v09.c
    public final void Fd(Boolean r20, long r21, long r23, long r25, long r27, String r210) {
        String r10 = r210;
        if (r20 != null) goto L5;
    L12:
        FLogger.a.e("FlowCommonVenueReportComponent", "[reportPocketPageShowed] invalid params");
    L13:
        FLogger.a.i("FlowCommonVenueReportComponent", "[reportPocketPageShowed] schemaHandleTime = " + r21 + ", onLoadStartTimeMs = " + r23 + ", nativeFirstFrameTimeMs = " + r25 + ", lynxFirstFrameTimeMs = " + r27 + ", loadErrorMsg = " + r10);
        long r4 = r23 - r21;
        long r6 = r25 - r21;
        long r2 = r27 - r21;
        JSONObject r8 = new JSONObject();
        x09.a r9 = (x09.a) this.m.getValue();
        if (r9 == null) goto L26;
        Bundle r11 = r9.a;
        if (r11 == null) goto L18;
        String r12 = r11.getString("enter_schema");
    L19:
        if (r12 == null) goto L26;
        if ((!StringsKt.isBlank(r12)) == true) goto L24;
        r12 = null;
    L24:
        if (r12 == null) goto L26;
        r8.put("enter_url", r12);
        goto L26
    L18:
        r12 = null;
    L26:
        r8.put(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, "outer_link");
        com.larus.platform.service.i r16 = com.larus.platform.service.i.a;
        r8.put("is_cold_launch", r16.a() ? 1 : 0);
        r8.put("lynx_view_load_result", r20);
        r8.put("create_to_load_duration", r4);
        r8.put("create_to_native_firstFrame_duration", r6);
        r8.put("create_to_lynx_duration", r2);
        if (r10 != null) goto L29;
        Object r0 = "";
    L30:
        r8.put("error_msg", r0);
        com.larus.platform.service.g.a.monitorEventForSlardar("common_venue_pocket_page_showed", r8, null, null);
        Object r1 = Long.valueOf(r4);
        Object r5 = Long.valueOf(r6);
        Object r3 = Long.valueOf(r2);
        if (r10 != null) goto L33;
        r10 = "";
    L33:
        JSONObject r7 = new JSONObject();
        x09.a r13 = (x09.a) this.m.getValue();
        if (r13 == null) goto L46;
        Bundle r14 = r13.a;
        if (r14 == null) goto L38;
        String r15 = r14.getString("enter_schema");
    L39:
        if (r15 == null) goto L46;
        if ((!StringsKt.isBlank(r15)) == true) goto L44;
        r15 = null;
    L44:
        if (r15 == null) goto L46;
        r7.put("enter_url", r15);
        goto L46
    L38:
        r15 = null;
    L46:
        r7.put(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, "outer_link");
        r7.put("is_cold_launch", r16.a() ? 1 : 0);
        Unit r17 = Unit.INSTANCE;
        if (r1 != null) goto L64;
    L50:
        if (r5 == null) goto L54;
        r7.putOpt("create_to_native_firstFrame_duration", r5);     // Catch: JSONException -> L52
    L54:
        if (r3 == null) goto L57;
        r7.putOpt("create_to_lynx_duration", r3);     // Catch: JSONException -> L52
    L57:
        if (r20 == null) goto L59;
        r7.putOpt("lynx_view_load_result", r20);     // Catch: JSONException -> L52
    L59:
        r7.putOpt("error_msg", r10);     // Catch: JSONException -> L52
    L62:
        TrackParams r18 = new TrackParams().merge(r7);
        by7.a r22 = new by7.a("common_venue_pocket_page_showed");
        r22.a.merge(r18);
        r22.b();
        return;
    L52:
        e = move-exception;
        FLogger.a.e("FlowCommonVenueReportComponent", "error in FlowCommonVenueReportComponent mobPocketPageShowed " + e.getLocalizedMessage());
        goto L62
    L64:
        r7.putOpt("create_to_load_duration", r1);     // Catch: JSONException -> L52
        goto L50
    L29:
        r0 = r10;
        goto L30
    L5:
        if (r21 < 0) goto L12;
        if (r23 < 0) goto L12;
        if (r25 < 0) goto L12;
        if (r27 >= 0) goto L13;
        goto L12
    }
}

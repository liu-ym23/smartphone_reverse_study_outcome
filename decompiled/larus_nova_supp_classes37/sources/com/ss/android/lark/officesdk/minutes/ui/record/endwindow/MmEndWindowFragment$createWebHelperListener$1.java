package com.ss.android.lark.officesdk.minutes.ui.record.endwindow;

import android.graphics.Bitmap;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmMarkedSpeakerType;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoStatisticInfo;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.CloseReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.MmLocationIdentityType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmEndWindowChangeSpeakerOrigin;
import com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmEndWindowChangeSpeakerResponse;
import com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmEndWindowWebHelper;
import com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmMinutesInfoToJS;
import com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.w;
import com.ss.android.lark.officesdk.minutes.ui.record.speaker.MmSpeakerMarkPanelFactory;
import com.ss.android.lark.officesdk.minutes.ui.service.MmRecordingUiProviders;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Message;
import com.ss.android.lark.officewebview.bridge.Status;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.e0;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmEndWindowFragment$createWebHelperListener$1 implements w {
    public final /* synthetic */ MmEndWindowFragment a;

    public static final class a implements gqb.a {
        public final /* synthetic */ MmEndWindowFragment a;
        public final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.b b;

        public final void b() {
            int r0 = bwb.b.a;
            MmUiLogScene r1 = MmUiLogScene.END_WINDOW;
            MmEndWindowFragment r2 = this.a;
            int r3 = MmEndWindowFragment.D;
            bwb.b.f(r1, "openLocationChooser", "cancelled", r2.U90());
        }

        public a(MmEndWindowFragment r1, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(FragmentActivity r9, POIInfo r10) {
            Intrinsics.checkNotNullParameter(r9, "activity");
            if (r10 != null) goto L6;
            int r11 = bwb.b.a;
            MmUiLogScene r12 = MmUiLogScene.END_WINDOW;
            MmEndWindowFragment r0 = this.a;
            int r1 = MmEndWindowFragment.D;
            bwb.b.d(r12, "openLocationChooser", "handleResult data is null", r0.U90());
            return;
        L6:
            int r2 = bwb.b.a;
            MmUiLogScene r3 = MmUiLogScene.END_WINDOW;
            String r4 = "handleResult: " + r10.getLocationName();
            MmEndWindowFragment r5 = this.a;
            int r6 = MmEndWindowFragment.D;
            bwb.b.f(r3, "openLocationChooser", r4, r5.U90());
            MmEndWindowWebHelper r13 = this.a.s;
            if (r13 == null) goto L14;
            String r7 = r10.getLocationName();
            if (r7 != null) goto L11;
            r7 = "";
        L11:
            Intrinsics.checkNotNullParameter(r7, AppbrandHostConstants.Schema_BDP_LOG.FIELD_LOCATION);
            MmMinutesInfoToJS r8 = new MmMinutesInfoToJS(null, r7, 1, null);
            Message r14 = new Message();
            r14.setCallbackID("minutes.updateMinutesInfo");
            r14.setData(e0.c(r8));
            String r15 = e0.c(r14);
            StringCompanionObject r16 = StringCompanionObject.INSTANCE;
            String r17 = String.format("LarkWebViewJavaScriptBridge.nativeCallBack(%s);", Arrays.copyOf(new Object[]{r15}, 1));
            bwb.b.f(MmUiLogScene.WEB, "updateLocation", "script=" + r17, r13.f());
            OfficeWebView r18 = r13.g;
            if (r18 == null) goto L14;
            r18.evaluateJavascript(r17, null);
        L14:
            MmEndWindowViewModel r19 = this.a.ia0();
            String r20 = this.b.a;
            double r21 = r10.getLatitude();
            double r22 = r10.getLongitude();
            String r23 = r10.getLocationName();
            if (r23 != null) goto L17;
            String r24 = "";
        L18:
            r19.uploadLocation(r20, r21, r22, r24);
            return;
        L17:
            r24 = r23;
            goto L18
        }
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.w
    public final com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.a a() {
        return this.a.ga0().G().r();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.w
    public final String d() {
        return this.a.ga0().J().a();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.w
    public final void g() {
        MmEndWindowFragment r1 = this.a;
        boolean r2 = true;
        r1.z = true;
        Job r3 = r1.y;
        JSONObject r4 = null;
        if (r3 == null) goto L5;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L5:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r5 = this.a.ia0().getLatestEntity();
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.c r6 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.b;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r7 = this.a.ga0().N();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "entity");
        Intrinsics.checkNotNullParameter(r7, "businessTracker");
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r8 = r7.c(r5.a);
        if (r8 == null) goto L9;
        MmRecordingCommonParam r9 = r8.b;
        if (r9 == null) goto L9;
    L10:
        String r10 = r9.getTrackerRecordId();
        if (r10.length() == 0) goto L15;
        r2 = false;
    L15:
        if (r2 == false) goto L17;
        lvb.a.h("MmRecordingEndWindowMetrics", "[trackEndWindowShown] skip, recordingId is empty");
    L24:
        this.a.ia0().dispatchEvent(c.C0054c.a);
        return;
    L17:
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.c.b r11 = r6.a.remove(r10);
        if (r11 != null) goto L20;
        lvb.a.h("MmRecordingEndWindowMetrics", "[trackEndWindowShown] missing context, recordingId=".concat(r10));
        goto L24
    L20:
        long r12 = RangesKt.coerceAtLeast(System.currentTimeMillis() - r11.d, 0);
        lvb.a.e("MmRecordingEndWindowMetrics", "[trackEndWindowShown] recordingId=" + r10 + ", traceId=" + r11.a.getRecordingTraceId() + ", latencyMs=" + r12);
        MmRecordingCommonParam r13 = r11.a;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r14 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r14.e("endwindow_shown_latency", String.valueOf(r12));
        r14.e("source", r11.b);
        DoubaoStatisticInfo r15 = r11.c;
        if (r15 == null) goto L23;
        r4 = r15.toJSONObject();
    L23:
        r14.f(r4);
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.a("display_endwindow", r13, r14.a());
    L9:
        r9 = new MmRecordingCommonParam(null, null, false, null, r5.d.getMeetingId(), null, null, null, null, null, null, 2031, null);
        goto L10
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.w
    public final com.ss.android.lark.officesdk.minutes.service.foundation.feature.a getFeatureService() {
        return this.a.ga0().getFeatureService();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.w
    public final com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.b getSettingsService() {
        return this.a.ga0().getSettingsService();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.w
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c i() {
        return this.a.ia0().getLatestEntity();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.w
    public final boolean isDarkMode() {
        MmEndWindowFragment r0 = this.a;
        int r1 = MmEndWindowFragment.D;
        Boolean r2 = r0.h;
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.booleanValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.w
    public final String k() {
        return this.a.ga0().J().c();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.w
    public final void l() {
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r0 = this.a.ia0().getLatestEntity();
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.b r1 = this.a.ia0().resolveUploadLocationIdentity(r0);
        if (StringsKt.isBlank(r1.a) == false) goto L14;
        int r2 = bwb.b.a;
        MmUiLogScene r3 = MmUiLogScene.END_WINDOW;
        MmLocationIdentityType r4 = r1.b;
        int r5 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.b.a.a[r4.ordinal()];
        if (r5 != 1) goto L7;
        String r6 = "recordingId is empty";
    L12:
        bwb.b.d(r3, "openLocationChooser", r6, this.a.U90());
        return;
    L7:
        if (r5 != 2) goto L10;
        r6 = "minutesToken is empty";
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    L14:
        FragmentActivity r7 = this.a.getActivity();
        if (r7 != null) goto L18;
        MmEndWindowFragment r8 = this.a;
        int r9 = bwb.b.a;
        bwb.b.d(MmUiLogScene.END_WINDOW, "openLocationChooser", "activity is null", r8.U90());
        return;
    L18:
        int r10 = bwb.b.a;
        bwb.b.g(MmUiLogScene.END_WINDOW, "openLocationChooser", null, this.a.U90(), 4);
        int r11 = wvb.c.a;
        wvb.c.a(r7, new a(this.a, r1));
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.w
    public final void n() {
        int r0 = bwb.b.a;
        MmUiLogScene r1 = MmUiLogScene.END_WINDOW;
        MmEndWindowFragment r2 = this.a;
        int r3 = MmEndWindowFragment.D;
        bwb.b.f(r1, "onThemeChanged", "fromWeb", r2.U90());
        MmEndWindowFragment r4 = this.a;
        r4.getClass();
        bwb.b.g(r1, "updateUiWhenThemeChanged", null, r4.U90(), 4);
        r4.da0();
    }

    public MmEndWindowFragment$createWebHelperListener$1(MmEndWindowFragment r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.w
    public final void e(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        MmEndWindowFragment r0 = this.a;
        int r1 = MmEndWindowFragment.D;
        r0.getClass();
        e r2 = e.a;
        MmRecordingUILaunchMode r3 = r0.x;
        r2.getClass();
        e.b(r3).getCapability().c();
        int r4 = bwb.b.a;
        bwb.b.f(MmUiLogScene.END_WINDOW, "openWebPageFromHost", "skip, host bridge capability disabled, url=" + r5, r0.U90());
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.w
    public final void f(int r7) {
        int r0 = bwb.b.a;
        MmEndWindowFragment r2 = this.a;
        int r3 = MmEndWindowFragment.D;
        bwb.b.f(MmUiLogScene.END_WINDOW, "finishPage", "errCode: " + r7, r2.U90());
        Job r1 = this.a.y;
        if (r1 == null) goto L6;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L6:
        if (r7 != (-99)) goto L8;
    L12:
        if (r7 != (-99)) goto L14;
        this.a.ea0(CloseReason.WEBVIEW_CALLBACK_NORMAL);
        return;
    L14:
        this.a.ea0(CloseReason.WEBVIEW_CALLBACK_ERROR);
        return;
    L8:
        if (r7 == (-100)) goto L12;
        MmEndWindowFragment r4 = this.a;
        if (r4.z == true) goto L12;
        MmEndWindowFragment.ja0(r4, Integer.valueOf(r7), "webview callback failed", null, 4);
        goto L12
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.w
    public final void j(String r5) {
        Intrinsics.checkNotNullParameter(r5, "userId");
        MmEndWindowFragment r0 = this.a;
        int r1 = MmEndWindowFragment.D;
        r0.getClass();
        e r2 = e.a;
        MmRecordingUILaunchMode r3 = r0.x;
        r2.getClass();
        e.b(r3).getCapability().c();
        int r4 = bwb.b.a;
        bwb.b.f(MmUiLogScene.END_WINDOW, "openProfileFromHost", "skip, host bridge capability disabled, userId=" + r5, r0.U90());
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.w
    public final void b(String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "eventParams");
        MmEndWindowFragment r2 = this.a;
        int r3 = MmEndWindowFragment.D;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.c r4 = r2.ha0();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "eventParams");
        if (r4.a.d(r4.c) == true) goto L5;
        lvb.a.b(r4.b, "[trackWebEvent] commonParam invalid, sessionId=" + r4.c);
        return;
    L5:
        r4.a.i(r4.c, r5, r6);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.w
    public final void h(MmEndWindowChangeSpeakerOrigin r14, xwb.d r15) {
        Intrinsics.checkNotNullParameter(r15, "callback");
        MmEndWindowFragment r2 = this.a;
        int r0 = MmEndWindowFragment.D;
        if (r14 != null) goto L5;
        r2.getClass();
        int r16 = bwb.b.a;
        bwb.b.d(MmUiLogScene.END_WINDOW, "onChangeSpeaker", "origin is null", r2.U90());
        Status r17 = Status.FAILURE;
        Gson r1 = e0.a;
        MmEndWindowChangeSpeakerResponse.Companion.getClass();
        r15.a(r17, e0.c(MmEndWindowChangeSpeakerResponse.a.a()));
        return;
    L5:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r3 = r2.ia0().getLatestEntity();
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r4 = r3.g.a.get(r14.getClusterId());
        if (r4 != null) goto L8;
        r4 = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c(r14.getClusterId(), null, null, null, null, MmMarkedSpeakerType.CLUSTER_ID, 30);
    L8:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r10 = r4;
        int r5 = bwb.b.a;
        bwb.b.f(MmUiLogScene.END_WINDOW, "onChangeSpeaker", "clusterId=" + r14.getClusterId() + ", oldSpeaker=" + r10, r2.U90());
        int r6 = MmSpeakerMarkPanelFactory.a;
        MmSpeakerMarkPanelFactory.a(new com.ss.android.lark.officesdk.minutes.ui.record.speaker.b(r2, r2.getChildFragmentManager(), ((MmRecordingUiProviders) r2.u.getValue()).b(), r2.ga0(), r3.d.getMeetingId(), r14.getClusterId(), System.currentTimeMillis(), r10, new com.ss.android.lark.officesdk.minutes.ui.record.endwindow.a(r2, r15, r14), r2.x));
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.w
    public final Object o(String r5, Continuation<? super Result<String>> r6) {
        if ((r6 instanceof MmEndWindowFragment$createWebHelperListener$1$updateTitle$1) == false) goto L7;
        MmEndWindowFragment$createWebHelperListener$1$updateTitle$1 r0 = (MmEndWindowFragment$createWebHelperListener$1$updateTitle$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
        return ((Result) r7).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        MmEndWindowViewModel r8 = this.a.ia0();
        r0.label = 1;
        Object r9 = r8.m407updateTitlegIAlus(r5, r0);
        if (r9 != r2) goto L18;
        return r2;
    L18:
        return r9;
    L7:
        r0 = new MmEndWindowFragment$createWebHelperListener$1$updateTitle$1(this, r6);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.w
    public final Object m(String r9, int r10, Continuation<? super Bitmap> r11) {
        return this.a.ga0().O().e(new com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.c(r9, r10, r10, 0, 0), r11);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.w
    public final Object c(String r10, String r11, int r12, Continuation<? super Bitmap> r13) {
        return this.a.ga0().O().d(new com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.b(r10, r11, r12, r12, 0, 0), r13);
    }
}

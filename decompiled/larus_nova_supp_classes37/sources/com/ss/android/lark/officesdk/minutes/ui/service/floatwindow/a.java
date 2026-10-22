package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.floating.widget.appfloat.AppFloatManager;
import com.ss.android.lark.floating.widget.appfloat.WindowManagerLayoutParamsInternal;
import com.ss.android.lark.floating.widget.appfloat.h;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRootRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.p;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.q;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host.d;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model.MmRecordingFloatDismissReason;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model.MmRecordingFloatFailureReason;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model.MmRecordingFloatHostType;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model.MmRecordingFloatLifecycleState;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model.MmRecordingFloatSide;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import gwb.c;
import hwb.e;
import hwb.f;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import xfb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final d a = null;
    public static final Map<String, e> b = null;
    public static String c;
    public static MmRecordingFloatHostType d;
    public static hwb.d e;
    public static final Map<String, gwb.e> f = null;
    public static final Map<String, gwb.d> g = null;
    public static final b h = null;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0071a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingFloatHostType.values().length];
            r0[MmRecordingFloatHostType.SYSTEM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MmRecordingFloatHostType.ACTIVITY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MmRecordingFloatHostType.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class b implements c {
        public b() {
        }

        @Override // gwb.c
        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "recordingId");
            d r0 = a.a;
            a.c(r2, MmRecordingFloatDismissReason.USER_CLOSE);
        }

        @Override // gwb.c
        public final void f(String r6) {
            Intrinsics.checkNotNullParameter(r6, "recordingId");
            d r0 = a.a;
            a.a(r6, MmRecordingFloatLifecycleState.SHOWN, true);
            gwb.d r1 = (gwb.d) ((LinkedHashMap) a.g).get(r6);
            if (r1 == null) goto L5;
            MmRecordingSession r2 = r1.b(r6);
        L6:
            if (r2 != null) goto L8;
            int r3 = bwb.b.a;
            bwb.b.g(MmUiLogScene.FLOAT, "trackFloatWindowView", "skip, session missing, recordingId=" + r6, null, 8);
        L12:
            gwb.e r7 = a.f.remove(r6);
            if (r7 == null) goto L16;
            r7.a();
            return;
        L16:
            return;
        L8:
            a.f(r6, "small_window");
            com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.e r4 = (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.e) r2.b.N().d.getValue();
            r4.getClass();
            Intrinsics.checkNotNullParameter(r6, "sessionId");
            if (r4.a.d(r6) == true) goto L11;
            lvb.a.b("MmRecordFloatWindowTracker", "[trackView] commonParam invalid, sessionId=".concat(r6));
            goto L12
        L11:
            r4.a.g(r6, "vc_record_float_window_view", new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d().a());
            goto L12
        L5:
            r2 = null;
            goto L6
        }

        @Override // gwb.c
        public final void b(String r17, hwb.d r18) {
            Intrinsics.checkNotNullParameter(r17, "recordingId");
            Intrinsics.checkNotNullParameter(r18, "state");
            Map<String, e> r2 = a.b;
            e r3 = (e) ((LinkedHashMap) r2).get(r17);
            if (r3 != null) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual(a.c, r17) == true) goto L8;
        L10:
            boolean r4 = false;
        L11:
            if (r4 == false) goto L13;
            hwb.d r5 = a.e;
        L14:
            Integer r6 = r18.c;
            if (r6 != null) goto L19;
            if (r5 == null) goto L18;
            r6 = r5.c;
            goto L19
        L18:
            Integer r11 = null;
        L20:
            Integer r7 = r18.d;
            if (r7 != null) goto L25;
            if (r5 == null) goto L24;
            r7 = r5.d;
            goto L25
        L24:
            Integer r12 = null;
        L26:
            Integer r8 = r18.f;
            if (r8 != null) goto L31;
            if (r5 == null) goto L30;
            r8 = r5.f;
            goto L31
        L30:
            Integer r14 = null;
        L32:
            Integer r9 = r18.g;
            if (r9 != null) goto L38;
            if (r5 == null) goto L36;
            Integer r10 = r5.g;
        L37:
            Integer r15 = r10;
        L39:
            boolean r13 = r18.a;
            MmRecordingFloatSide r16 = r18.b;
            boolean r19 = r18.e;
            Intrinsics.checkNotNullParameter(r16, "side");
            hwb.d r1 = new hwb.d(r13, r16, r11, r12, r19, r14, r15);
            a.c = r17;
            a.d = r3.c;
            a.e = r1;
            int r20 = bwb.b.a;
            bwb.b.g(MmUiLogScene.FLOAT, "saveLayoutState", "recordingId=" + r17 + ", hostType=" + r3.c + ", x=" + r1.c + ", y=" + r1.d + ", expanded=" + r1.a + ", side=" + r1.b + ", expandedX=" + r1.f + ", expandedY=" + r1.g, null, 8);
            r2.put(r17, e.a(r3, false, null, r1, 47));
            return;
        L36:
            r10 = null;
            goto L37
        L38:
            r15 = r9;
        L31:
            r14 = r8;
        L25:
            r12 = r7;
        L19:
            r11 = r6;
            goto L20
        L13:
            r5 = r3.e;
            goto L14
        L8:
            if (a.d != r3.c) goto L10;
            r4 = true;
            goto L11
        }

        @Override // gwb.c
        public final void c(String r3, MmRecordingFloatFailureReason r4) {
            Intrinsics.checkNotNullParameter(r3, "recordingId");
            Intrinsics.checkNotNullParameter(r4, "reason");
            d r0 = a.a;
            a.a(r3, MmRecordingFloatLifecycleState.DISMISSED, false);
            gwb.e r1 = a.f.remove(r3);
            if (r1 == null) goto L5;
            r1.c(r4);
        L5:
            a.g.remove(r3);
        }

        @Override // gwb.c
        public final void d(String r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r6, "recordingId");
            int r0 = bwb.b.a;
            bwb.b.g(MmUiLogScene.FLOAT, "onHostVisibilityChanged", "recordingId=" + r6 + ", visible=" + r7, null, 8);
            d r1 = a.a;
            a.a(r6, MmRecordingFloatLifecycleState.SHOWN, r7);
        }

        @Override // gwb.c
        public final void e(String r2, MmRecordingFloatDismissReason r3) {
            Intrinsics.checkNotNullParameter(r2, "recordingId");
            Intrinsics.checkNotNullParameter(r3, "reason");
            d r4 = a.a;
            a.a(r2, MmRecordingFloatLifecycleState.DISMISSED, false);
            gwb.e r5 = a.f.remove(r2);
            if (r5 == null) goto L5;
            r5.c(MmRecordingFloatFailureReason.HOST_CREATE_FAILED);
        L5:
            a.g.remove(r2);
        }
    }

    public a() {
    }

    static {
        a = new d();
        b = new LinkedHashMap();
        f = new LinkedHashMap();
        g = new LinkedHashMap();
        h = new b();
    }

    public static boolean b(f r0) {
        r0.getClass();
        r0.getClass();
        throw null;
    }

    public static void c(String r12, MmRecordingFloatDismissReason r13) {
        Intrinsics.checkNotNullParameter(r12, "recordingId");
        Intrinsics.checkNotNullParameter(r13, "reason");
        int r1 = bwb.b.a;
        MmUiLogScene r2 = MmUiLogScene.FLOAT;
        bwb.b.g(r2, "dismiss", "recordingId=" + r12 + ", reason=" + r13, null, 8);
        f.remove(r12);
        d r3 = a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r12, "recordingId");
        bwb.b.g(r2, "dismiss", "recordingId=" + r12, null, 8);
        com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host.b r7 = r3.b;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r12, "recordingId");
        hwb.c r8 = r7.b;
        if (r8 == null) goto L5;
        String r9 = r8.a;
    L6:
        boolean r10 = false;
        if (Intrinsics.areEqual(r9, r12) == false) goto L18;
        bwb.b.g(r2, "dismiss", "recordingId=" + r12, null, 8);
        WeakReference<Activity> r11 = r7.c;
        if (r11 == null) goto L17;
        Activity r14 = r11.get();
        if (r14 == null) goto L17;
        FrameLayout r15 = (FrameLayout) com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host.b.a(r14.getWindow()).findViewById(R.id.content);
        ViewGroup r16 = (ViewGroup) r15.findViewWithTag(r12);
        if (r16 == null) goto L17;
        r15.removeView(r16);
    L17:
        r7.d();
        r7.b = null;
        r7.c = null;
        r7.d = null;
        r7.i = false;
        r7.e();
        r8.e.e(r12, MmRecordingFloatDismissReason.HOST_DISMISS);
    L18:
        com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host.e r4 = r3.a;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r12, "recordingId");
        bwb.b.g(r2, "dismiss", "recordingId=".concat(r12), null, 8);
        r4.c();
        r4.i();
        r4.d();
        tfb.a.b r0 = tfb.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("core.appfloat.windowsize_refactor") == false) goto L35;
        g r5 = g.e;
        if (r5 != null) goto L24;
        r5 = new g();
        g.e = r5;
    L24:
        Log.i("ScreenSizeManager", "clear");
        WeakReference r6 = r5.a;
        if (r6 == null) goto L31;
        View r17 = (View) r6.get();
        if (r17 == null) goto L31;
        WindowManager r18 = r5.b;
        if (r18 == null) goto L31;
        r18.removeView(r17);
    L31:
        WeakReference r19 = r5.a;
        if (r19 == null) goto L34;
        r19.clear();
    L34:
        r5.d.removeCallbacksAndMessages(null);
    L35:
        Map r20 = com.ss.android.lark.floating.widget.appfloat.c.b;
        AppFloatManager r21 = (AppFloatManager) ((LinkedHashMap) r20).get(r12);
        if (r21 == null) goto L58;
        StringBuilder r22 = new StringBuilder("exitAnim, ParentFrameLayout@");
        com.ss.android.lark.floating.widget.appfloat.d r23 = r21.e;
        if (r23 == null) goto L40;
        Integer r24 = Integer.valueOf(r23.hashCode());
    L41:
        r22.append(r24);
        Log.i("AppFloatManager", r22.toString());
        com.ss.android.lark.floating.widget.appfloat.d r25 = r21.e;
        if (r25 == null) goto L44;
        r25.setLayoutListener(null);
    L44:
        Animator r26 = r21.m;
        if (r26 == null) goto L47;
        r26.cancel();
    L47:
        r21.m = null;
        com.ss.android.lark.floating.widget.appfloat.d r27 = r21.e;
        if (r27 == null) goto L57;
        h r28 = r21.e();
        WindowManager r29 = r21.f();
        vfb.a r30 = r21.b;
        Intrinsics.checkNotNullParameter(r27, "view");
        Intrinsics.checkNotNullParameter(r28, "params");
        Intrinsics.checkNotNullParameter(r29, "windowManager");
        Intrinsics.checkNotNullParameter(r30, "config");
        wfb.b r31 = r30.D;
        if (r31 == null) goto L53;
        ValueAnimator r32 = r31.b(r27, r28, r29);
    L54:
        if (r32 != null) goto L56;
        r21.d();
        goto L57
    L56:
        AppFloatManager r33 = (AppFloatManager) TypeIntrinsics.asMutableMap(r20).remove(r21.b.d);
        WindowManagerLayoutParamsInternal r34 = r21.e().a;
        ((WindowManager.LayoutParams) r34).flags = (((WindowManager.LayoutParams) r34).flags & (-41)) | 40;
        h r35 = r21.e();
        int r36 = r21.g;
        WindowManagerLayoutParamsInternal r37 = r35.a;
        ((WindowManager.LayoutParams) r37).flags = (r36 & r36) | (((WindowManager.LayoutParams) r37).flags & (~r36));
        r32.addListener(new com.ss.android.lark.floating.widget.appfloat.b(r21));
        r32.start();
        r21.m = r32;
        goto L57
    L53:
        r32 = null;
    L57:
        Unit r38 = Unit.INSTANCE;
        goto L58
    L40:
        r24 = null;
    L58:
        b.remove(r12);
        g.remove(r12);
        if (r13 != MmRecordingFloatDismissReason.RECORDING_END) goto L61;
    L64:
        r10 = true;
    L65:
        if (r10 == true) goto L67;
        return;
    L67:
        if (Intrinsics.areEqual(c, r12) == false) goto L71;
        c = null;
        d = null;
        e = null;
        return;
    L71:
        return;
    L61:
        if (r13 == MmRecordingFloatDismissReason.RECORDING_INTERRUPTED) goto L64;
        if (r13 != MmRecordingFloatDismissReason.SESSION_INACTIVE) goto L65;
    L5:
        r9 = null;
        goto L6
    }

    public static void f(String r17, String r18) {
        gwb.d r2 = (gwb.d) ((LinkedHashMap) g).get(r17);
        if (r2 == null) goto L67;
        MmRecordingSession r0 = r2.b(r17);
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.a == RecordingSessionType.STANDALONE_AI_INTERPRETATION) goto L10;
        return;
    L10:
        q r3 = (q) r0.b.N().m.getValue();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r18, "windowType");
        String r4 = r0.e();
        if (StringsKt.isBlank(r4) == false) goto L13;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L71;
        MmStandaloneAIInterpretationRootRepo r5 = r0.h();
        p r7 = null;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r8 = null;
        if (r5 == null) goto L58;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.b r9 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.b) r5.a().t().b().getValue();
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f r10 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f) r5.l().l().b().getValue();
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r11 = r10.c;
        String r12 = r11.a;
        if ((!StringsKt.isBlank(r12)) == true) goto L26;
        r12 = null;
    L26:
        if (r12 == null) goto L28;
        r8 = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c(r12, r11.b);
    L28:
        if (r8 != null) goto L30;
        r8 = r9.f;
    L30:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r13 = r9.g;
        if (r13 != null) goto L33;
        r13 = r9.i;
    L33:
        String r14 = "";
        if (r8 == null) goto L37;
        String r15 = r8.a;
        if (r15 == null) goto L37;
    L40:
        String r16 = r15;
    L42:
        if (r13 == null) goto L47;
        String r19 = r13.a;
        if (r19 == null) goto L47;
        String r110 = r19;
    L51:
        boolean r111 = r10.e;
        boolean r112 = r5.a().t().s0();
        MmRecordingAudioService r20 = r0.a();
        if (r20 != null) goto L54;
    L56:
        boolean r113 = false;
    L57:
        r7 = new p(r16, r110, r111, r112, r113);
        goto L58
    L54:
        if (r20.s == true) goto L56;
        r113 = true;
    L47:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r21 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) CollectionsKt.firstOrNull(r9.c);
        if (r21 == null) goto L50;
        r14 = r21.a;
    L50:
        r110 = r14;
    L37:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r22 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) CollectionsKt.firstOrNull(r9.b);
        if (r22 == null) goto L41;
        r15 = r22.a;
        goto L40
    L41:
        r16 = "";
    L58:
        if (r7 != null) goto L61;
        return;
    L61:
        if (r3.c(r0, r7, "in_the_process", r18) == false) goto L70;
        r3.a(r4, r18, "in_the_process");
        return;
    L70:
        return;
    L71:
        return;
    L13:
        Object r23 = r3.b;
        monitor-enter(r23);
        r6 = r3.c.contains(r4);     // Catch: Throwable -> L64
        monitor-exit(r23);
    L64:
        th = move-exception;
        throw th;
    }

    public static final void a(String r4, MmRecordingFloatLifecycleState r5, boolean r6) {
        Map<String, e> r0 = b;
        e r1 = (e) ((LinkedHashMap) r0).get(r4);
        if (r1 == null) goto L7;
        r0.put(r4, e.a(r1, r6, r5, null, 53));
        return;
    }

    public static void d(Context r5, f r6, gwb.e r7) {
        r6.getClass();
        int r2 = bwb.b.a;
        MmUiLogScene r3 = MmUiLogScene.FLOAT;
        StringBuilder r4 = new StringBuilder("skip fallback disabled, recordingId=");
        r6.getClass();
        r4.append(null);
        bwb.b.g(r3, "showActivityFallback", r4.toString(), null, 8);
        r7.c(MmRecordingFloatFailureReason.NO_PERMISSION);
    }

    public static void e(Context r6, f r7, MmRecordingFloatHostType r8) {
        Map<String, e> r9 = b;
        r7.getClass();
        e r10 = (e) ((LinkedHashMap) r9).get(null);
        String r0 = c;
        r7.getClass();
        if (Intrinsics.areEqual(r0, null) == true) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r10 == null) goto L11;
        MmRecordingFloatHostType r3 = r10.c;
    L12:
        if (r3 != r8) goto L14;
        boolean r4 = true;
    L15:
        if (r1 == false) goto L17;
        hwb.d r5 = e;
    L21:
        if (r5 != null) goto L23;
        r5 = new hwb.d(0);
    L23:
        if (r1 == false) goto L25;
        String r2 = "active";
    L28:
        int r11 = bwb.b.a;
        MmUiLogScene r12 = MmUiLogScene.FLOAT;
        StringBuilder r13 = new StringBuilder("recordingId=");
        r7.getClass();
        r13.append(null);
        r13.append(", targetHostType=");
        r13.append(r8);
        r13.append(", source=");
        r13.append(r2);
        r13.append(", activeHostType=");
        r13.append(d);
        r13.append(", currentHostType=");
        if (r10 == null) goto L31;
        MmRecordingFloatHostType r14 = r10.c;
    L32:
        r13.append(r14);
        r13.append(", x=");
        r13.append(r5.c);
        r13.append(", y=");
        r13.append(r5.d);
        r13.append(", expanded=");
        r13.append(r5.a);
        r13.append(", side=");
        r13.append(r5.b);
        r13.append(", expandedX=");
        r13.append(r5.f);
        r13.append(", expandedY=");
        r13.append(r5.g);
        bwb.b.g(r12, "createHostConfig", r13.toString(), null, 8);
        r7.getClass();
        new com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.style.a();
        r7.getClass();
        new com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.style.b(null);
        r7.getClass();
        r7.getClass();
        r7.getClass();
        throw null;
    L31:
        r14 = null;
        goto L32
    L25:
        if (r4 == false) goto L27;
        r2 = "state";
        goto L28
    L27:
        r2 = "default";
        goto L28
    L17:
        if (r4 == false) goto L20;
        if (r10 == null) goto L20;
        r5 = r10.e;
    L20:
        r5 = null;
        goto L21
    L14:
        r4 = false;
        goto L15
    L11:
        r3 = null;
        goto L12
    L5:
        if (d != r8) goto L7;
        r1 = true;
        goto L9
    }
}

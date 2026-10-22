package com.larus.camera.impl.utils;

import android.os.SystemClock;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.trace.ReeditType;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.entity.EduIntentMode;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r extends i implements j0 {
    public static final /* synthetic */ int j = 0;
    public final ICameraEventExt g;
    public long h;
    public long i;

    public static final class a {
        public static String a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "captureMode");
            switch(r1.hashCode()) {
                case -1332250801: goto L18;
                case -861871587: goto L14;
                case 358782896: goto L10;
                case 1556930703: goto L6;
                default: goto L21;
            };
        L21:
            return "general";
        L6:
            if (r1.equals("CAPTURE_MODE_EDU_GENERAL_PHOTO") == false) goto L21;
            return "qa_take_photos";
        L10:
            if (r1.equals("CAPTURE_MODE_EDU_CALCULATION_PHOTO") == false) goto L21;
            return "oral_calculation";
        L14:
            if (r1.equals("CAPTURE_MODE_EDU_ARTICLE_PHOTO") == false) goto L21;
            return "essay_report";
        L18:
            if (r1.equals("CAPTURE_MODE_EDU_HOMEWORK_PHOTO") == false) goto L21;
            return "check";
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OutputParam.ResultType.values().length];
            r0[OutputParam.ResultType.PHOTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[OutputParam.ResultType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void O(Integer r1) {
        throw null;
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void E0() {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("current_page", "picture_crop");
        r1.put("previous_page", "camera_confirm");
        Unit r2 = Unit.INSTANCE;
        r0.reportEvent("enter_page", r1);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void y() {
        this.c++;
        FLogger.a.i("CameraTracer", "autoRecordCameraTipsCount seeCount=" + this.c);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void A0() {
        this.d = SystemClock.elapsedRealtime();
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void C() {
        this.h = SystemClock.elapsedRealtime();
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void C0(String r12) {
        Intrinsics.checkNotNullParameter(r12, "captureMode");
        i.P0(this, "camera_action", "flash", r12, this.g, null, null, null, null, 240);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void I(String r12) {
        Intrinsics.checkNotNullParameter(r12, "captureMode");
        i.P0(this, "album_authorization", "authorize", r12, this.g, null, null, null, null, 240);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void I0(String r9) {
        Intrinsics.checkNotNullParameter(r9, "captureMode");
        U0(SystemClock.elapsedRealtime() - this.h, "switch_tab", true, r9, this.g, null);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void K(String r12) {
        Intrinsics.checkNotNullParameter(r12, "captureMode");
        i.P0(this, "album_authorization", "unauthorize", r12, this.g, null, null, null, null, 240);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void L(String r12) {
        Intrinsics.checkNotNullParameter(r12, "captureMode");
        i.P0(this, "camera_action", "album", r12, this.g, null, null, null, null, 240);
        i.R0(r12, "camera_page_icon", "camera_page_icon", this.g);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void N(String r12) {
        Intrinsics.checkNotNullParameter(r12, "captureMode");
        i.P0(this, "camera_action", "torch", r12, this.g, null, null, null, null, 240);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "captureMode");
        i.X0("album_authorization", r4, this.g, null);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void c(String r12) {
        Intrinsics.checkNotNullParameter(r12, "captureMode");
        i.P0(this, "camera_action", "focus", r12, this.g, null, null, null, null, 240);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void f0(CaptureResultDetectLogic.a r5) {
        Intrinsics.checkNotNullParameter(r5, "mobInfo");
        Intrinsics.checkNotNullParameter(r5, "mobInfo");
        JSONObject r0 = new JSONObject();
        r0.put("status", r5.a);
        r0.put("duration", r5.b);
        r0.put("error_msg", r5.f);
        r0.put("pre_process_duration", r5.c);
        r0.put("original_image_size", r5.d);
        r0.put("compressed_image_size", r5.e);
        com.larus.platform.service.o.a.reportEvent("camera_capture_intent_detect", r0);
        com.larus.platform.service.g.a.monitorEventForSlardar("camera_capture_intent_detect", r0, null, null);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void o(String r12) {
        Intrinsics.checkNotNullParameter(r12, "captureMode");
        i.P0(this, "camera_action", "select_photo", r12, this.g, null, null, null, null, 240);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void z0(String r12) {
        Intrinsics.checkNotNullParameter(r12, "captureMode");
        i.P0(this, "camera_action", "take", r12, this.g, null, null, null, null, 240);
    }

    public r(ICameraEventExt r1, com.larus.camera.impl.ui.base.f r2) {
        super(r2);
        this.g = r1;
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void D0(String r10, Boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "captureMode");
        i.Q0(this, "confirm", r10, this.g, r11, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void H0(boolean r13, String r14) {
        Intrinsics.checkNotNullParameter(r14, "captureMode");
        U0(SystemClock.elapsedRealtime() - this.h, "click_leave", r13, r14, this.g, null);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void K0(boolean r13, String r14) {
        Intrinsics.checkNotNullParameter(r14, "captureMode");
        U0(SystemClock.elapsedRealtime() - this.h, "click_album", r13, r14, this.g, null);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void T(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "captureMode");
        Intrinsics.checkNotNullParameter(r13, "button");
        i.P0(this, "camera_action", r13, r12, this.g, null, null, null, null, 240);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void V(String r10, Boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "captureMode");
        i.Q0(this, "input_function_switch", r10, this.g, r11, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void Y(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "captureMode");
        Intrinsics.checkNotNullParameter(r13, "toCaptureMode");
        i.P0(this, "camera_action", "switch_tab", r12, this.g, r13, null, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void a0(String r10, Boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "captureMode");
        i.Q0(this, "download", r10, this.g, r11, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void e0(String r10, Boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "captureMode");
        i.Q0(this, "rotate", r10, this.g, r11, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void k0(OutputParam.ResultType r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "contentType");
        int r4 = b.a[r2.ordinal()];
        if (r4 != 1) goto L5;
        String r5 = ReeditType.IMAGE;
    L10:
        this.e = r5;
        if (r3 == false) goto L13;
        String r6 = "upload";
    L14:
        this.f = r6;
        return;
    L13:
        r6 = "shoot";
        goto L14
    L5:
        if (r4 != 2) goto L8;
        r5 = "video";
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void m(String r10, Boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "captureMode");
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == false) goto L5;
        String r0 = "single_question_mode";
    L6:
        i.Q0(this, r0, r10, this.g, r11, null, null, 224);
        return;
    L5:
        r0 = "multi_question_mode";
        goto L6
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void m0(boolean r13, String r14) {
        Intrinsics.checkNotNullParameter(r14, "captureMode");
        long r5 = SystemClock.elapsedRealtime() - this.h;
        ICameraEventExt r10 = this.g;
        if (this.d <= 0) goto L5;
        Long r0 = Long.valueOf(SystemClock.elapsedRealtime() - this.d);
    L6:
        U0(r5, "success", r13, r14, r10, r0);
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void o0(boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "captureMode");
        this.h = SystemClock.elapsedRealtime();
        ICameraEventExt r8 = this.g;
        Intrinsics.checkNotNullParameter(r11, "captureMode");
        x r0 = this.a;
        if (r0 == null) goto L5;
        String r7 = r0.a();
    L6:
        if (r8 == null) goto L10;
        JSONObject r1 = r8.enterPageEventExt();
        if (r1 == null) goto L10;
        String r2 = r1.optString("current_page");
    L11:
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L19;
        r2 = "camera";
    L19:
        i.T0(r2, r11, r7, null, r8);
        Map r4 = IAIChatRenderTraceService.a.i();
        if (r4 == null) goto L22;
        String r5 = (String) r4.get("key_current_page");
    L22:
        i.S0("camera", r10, r11, null, r7, r8);
        return;
    L13:
        if (r2.length() == 0) goto L16;
        r3 = false;
    L10:
        r2 = null;
        goto L11
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void q(String r10, Boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "captureMode");
        i.Q0(this, "input_icon", r10, this.g, r11, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void r0(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "captureMode");
        Intrinsics.checkNotNullParameter(r5, "captureMode");
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("camera_type", i.N0(r5));
        r1.put("success", r4);
        r1.put("picture_from", "takePhoto");
        Unit r6 = Unit.INSTANCE;
        r0.reportEvent("camera_validate_result", r1);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void v0(String r10, Boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "captureMode");
        i.Q0(this, "retake", r10, this.g, r11, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void x(String r10, Boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "captureMode");
        i.Q0(this, "input", r10, this.g, r11, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void D(boolean r10, boolean r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "captureMode");
        this.i = SystemClock.elapsedRealtime();
        ICameraEventExt r8 = this.g;
        Intrinsics.checkNotNullParameter(r12, "captureMode");
        x r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L5;
        String r7 = r0.a();
    L6:
        if (r11 == false) goto L8;
        r1 = "album";
    L8:
        i.T0("camera_confirm", r12, r7, r1, r8);
        i.S0("camera_confirm", r10, r12, Boolean.valueOf(r11), r7, r8);
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void J(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter("camera", "currentPage");
        Intrinsics.checkNotNullParameter(r3, "captureMode");
        Intrinsics.checkNotNullParameter(r4, "clickFrom");
        Intrinsics.checkNotNullParameter(r5, "enterMethod");
        i.R0(r3, r4, r5, this.g);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void J0(String r10, String r11, Boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "captureMode");
        Intrinsics.checkNotNullParameter(r11, "button");
        i.Q0(this, r11, r10, this.g, r12, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void M(String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "captureMode");
        Intrinsics.checkNotNullParameter(r13, "buttonType");
        Intrinsics.checkNotNullParameter(r14, "switchMethod");
        i.P0(this, "camera_action", r13, r12, this.g, null, null, null, r14, 112);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void n0(String r10, Boolean r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "captureMode");
        i.Q0(this, "modify_range", r10, this.g, r11, Integer.valueOf(r12), null, 160);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void p(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "itemType");
        Intrinsics.checkNotNullParameter(r3, "captureMode");
        i.X0(r2, r3, this.g, r4);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void w(String r10, String r11, Boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "captureMode");
        Intrinsics.checkNotNullParameter(r11, "buttonType");
        i.Q0(this, r11, r10, this.g, r12, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void w0(boolean r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "captureMode");
        Intrinsics.checkNotNullParameter(r15, "leaveReason");
        U0(SystemClock.elapsedRealtime() - this.h, r15, r13, r14, this.g, null);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void c0(String r5, String r6, Integer r7, Boolean r8) {
        Intrinsics.checkNotNullParameter(r5, "itemType");
        Intrinsics.checkNotNullParameter(r6, "captureMode");
        ICameraEventExt r2 = this.g;
        Intrinsics.checkNotNullParameter(r5, "itemType");
        Intrinsics.checkNotNullParameter(r6, "captureMode");
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        if (r2 != null) goto L5;
        JSONObject r1 = new JSONObject();
    L8:
        r1.put("camera_type", i.N0(r6));
        r1.put("item_type", r5);
        r1.put("current_page", "camera_confirm");
        r1.put("tab_name", a.a(r6));
        if (r7 == null) goto L11;
        r1.put("item_rank", r7.intValue());
    L11:
        if (r8 == null) goto L13;
        r1.put("is_default", r8.booleanValue() ? 1 : 0);
    L13:
        Unit r9 = Unit.INSTANCE;
        r0.reportEvent("camera_item_show", r1);
        return;
    L5:
        Intrinsics.checkNotNullParameter(r2, "$this$jsonObject");
        r1 = r2.cameraItemShowEventExt();
        if (r1 != null) goto L8;
        r1 = new JSONObject();
        goto L8
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void i0(String r5, String r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r5, "captureMode");
        Intrinsics.checkNotNullParameter(r6, "toast");
        Intrinsics.checkNotNullParameter(r5, "captureMode");
        Intrinsics.checkNotNullParameter(r6, "toast");
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("validate_scenario", "rejection_detection");
        r1.put("camera_type", "edu");
        r1.put("toast_text", r6);
        r1.put("tab_name", a.a(r5));
        r1.put("success", r7 ? 1 : 0);
        r1.put("picture_from", i.W0(Boolean.valueOf(r8)));
        Unit r9 = Unit.INSTANCE;
        r0.reportEvent("camera_validate_result", r1);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void q0(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "currentPage");
        Intrinsics.checkNotNullParameter(r3, "captureMode");
        Intrinsics.checkNotNullParameter(r4, "enterMethod");
        Intrinsics.checkNotNullParameter(r5, "previousPage");
        i.T0(r2, r3, r4, r5, this.g);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void Z(String r10, String r11, Boolean r12, Integer r13, Boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "captureMode");
        Intrinsics.checkNotNullParameter(r11, "buttonType");
        i.Q0(this, r11, r10, this.g, r12, r13, r14, 32);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void j0(String r12, String r13, String r14, String r15, String r16) {
        Intrinsics.checkNotNullParameter(r12, "captureMode");
        Intrinsics.checkNotNullParameter(r13, "zoomButtonType");
        i.P0(this, "camera_action", r13, r12, this.g, null, r14, r15, r16, 16);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void n(String r5, String r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r5, "buttonName");
        Intrinsics.checkNotNullParameter(r6, "currentPage");
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("camera_type", "general");
        r1.put("item_type", "camera_action");
        r1.put("button_type", r5);
        r1.put("current_page", r6);
        if (r7 == null) goto L5;
        r1.put("bot_id", r7);
    L5:
        if (r8 == null) goto L7;
        r1.put("click_from", r8);
    L7:
        if (r9 == null) goto L9;
        r1.put("switch_method", r9);
    L9:
        String r10 = this.e;
        if (r10 == null) goto L12;
        r1.put("content_type", r10);
    L12:
        String r11 = this.f;
        if (r11 == null) goto L15;
        r1.put("content_source", r11);
    L15:
        ICameraEventExt r12 = this.g;
        if (r12 == null) goto L18;
        JSONObject r13 = r12.getExtraParams();
    L19:
        i.M0(r1, r13);
        Unit r14 = Unit.INSTANCE;
        r0.reportEvent("click_camera_button", r1);
        return;
    L18:
        r13 = null;
        goto L19
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void F0(boolean r13, boolean r14, String r15, Boolean r16, Boolean r17, EduIntentMode r18) {
        Intrinsics.checkNotNullParameter(r15, "captureMode");
        i.V0(SystemClock.elapsedRealtime() - this.i, "other", r13, r14, r15, this.g, r16, r17, r18);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void U(String r5, String r6, String r7, String r8, JSONObject r9, by7.e r10) {
        Intrinsics.checkNotNullParameter(r9, "params");
        r9.putOpt("button_type", "edit_entrance");     // Catch: JSONException -> L13
        r9.put("current_page", r7);     // Catch: JSONException -> L13
        if (r5 == null) goto L6;
        r9.putOpt("button_name", r5);     // Catch: JSONException -> L13
    L6:
        r9.putOpt("show_from", "camera_confirm");     // Catch: JSONException -> L13
        if (r6 == null) goto L9;
        r9.put("bot_id", r6);     // Catch: JSONException -> L13
    L9:
        r9.put("enter_method", "click_camera_confirm_image_edit_button");     // Catch: JSONException -> L13
        if (o0.d(r8) == false) goto L15;
        r9.put("previous_page", r8);     // Catch: JSONException -> L13
    L15:
        TrackParams r11 = new TrackParams().merge(r9);
        by7.a r12 = new by7.a("image_edit_function_click");
        if (r10 == null) goto L18;
        r12.b = r10;
    L18:
        r12.a.merge(r11);
        r12.b();
        return;
    L13:
        e = move-exception;
        FLogger.a.e("CameraTracer", "error in mobImageEditFunctionShow " + e.getLocalizedMessage());
        goto L15
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void a(String r13, boolean r14, boolean r15, String r16, Boolean r17, Boolean r18, EduIntentMode r19) {
        Intrinsics.checkNotNullParameter(r13, "leaveReason");
        Intrinsics.checkNotNullParameter(r16, "captureMode");
        i.V0(SystemClock.elapsedRealtime() - this.i, r13, r14, r15, r16, this.g, r17, r18, r19);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void L0(String r2, String r3, String r4, String r5, String r6, String r7, String r8, JSONObject r9, by7.e r10) {
        Intrinsics.checkNotNullParameter(r9, "params");
        r9.putOpt("button_type", r2);     // Catch: JSONException -> L16
        r9.put("current_page", r7);     // Catch: JSONException -> L16
        if (r3 == null) goto L6;
        r9.putOpt("button_name", r3);     // Catch: JSONException -> L16
    L6:
        if (r4 == null) goto L8;
        r9.putOpt("show_from", r4);     // Catch: JSONException -> L16
    L8:
        if (r5 == null) goto L10;
        r9.put("bot_id", r5);     // Catch: JSONException -> L16
    L10:
        if (r6 == null) goto L13;
        r9.put("enter_method", r6);     // Catch: JSONException -> L16
    L13:
        if (o0.d(r8) == false) goto L18;
        r9.put("previous_page", r8);     // Catch: JSONException -> L16
    L18:
        TrackParams r11 = new TrackParams().merge(r9);
        by7.a r12 = new by7.a("image_edit_function_show");
        if (r10 == null) goto L21;
        r12.b = r10;
    L21:
        r12.a.merge(r11);
        r12.b();
        return;
    L16:
        e = move-exception;
        FLogger.a.e("CameraTracer", "error in mobImageEditFunctionShow " + e.getLocalizedMessage());
        goto L18
    }
}

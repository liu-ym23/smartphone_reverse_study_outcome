package com.larus.camera.impl.utils;

import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.camera.impl.entity.EduIntentMode;
import com.larus.camera.impl.ui.component.generalonly.CameraTabTipsShowOrder;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.utils.o0;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v19.e6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class i {
    public final x a;
    public Integer b;
    public int c;
    public long d;
    public String e;
    public String f;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[EduIntentMode.values().length];
            r0[EduIntentMode.COMMON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[EduIntentMode.SINGLE_QUESTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[EduIntentMode.MULTI_QUESTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public i(com.larus.camera.impl.ui.base.f r1) {
        this.a = r1;
    }

    public static String N0(String r1) {
        if (fx8.a.e.contains(r1) == false) goto L6;
        return "edu";
    L6:
        if (fx8.a.b.contains(r1) == false) goto L9;
        return "scan";
    L9:
        if (fx8.a.c.contains(r1) == false) goto L11;
        return "health";
    L11:
        return "general";
    }

    public static String W0(Boolean r1) {
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L6;
        return "select_photo";
    L6:
        if (Intrinsics.areEqual(r1, Boolean.FALSE) == false) goto L8;
        return "take_photo";
    L8:
        return "null";
    }

    public static void M0(JSONObject r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, "mobObject");
        boolean r0 = true;
        if (r6 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L46;
        String r3 = r6.optString("canvas_type");
        Intrinsics.checkNotNull(r3);
        if (r3.length() <= 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
        r5.put("canvas_type", r3);
    L15:
        String r7 = r6.optString("presentation_id");
        Intrinsics.checkNotNull(r7);
        if (r7.length() <= 0) goto L18;
        boolean r8 = true;
    L19:
        if (r8 == false) goto L21;
        r5.put("presentation_id", r7);
    L21:
        String r9 = r6.optString("resource_id");
        Intrinsics.checkNotNull(r9);
        if (r9.length() <= 0) goto L24;
        boolean r10 = true;
    L25:
        if (r10 == false) goto L27;
        r5.put("resource_id", r9);
    L27:
        int r11 = r6.optInt("resource_type");
        if (r11 == 0) goto L30;
        r5.put("resource_type", r11);
    L30:
        String r12 = r6.optString("artifact_meta_id");
        Intrinsics.checkNotNull(r12);
        if (r12.length() <= 0) goto L33;
        boolean r13 = true;
    L34:
        if (r13 == false) goto L36;
        r5.put("artifact_meta_id", r12);
    L36:
        int r14 = r6.optInt("artifact_type");
        if (r14 == 0) goto L39;
        r5.put("artifact_type", r14);
    L39:
        String r15 = r6.optString("aippt_task_id");
        Intrinsics.checkNotNull(r15);
        if (r15.length() > 0) goto L43;
        r0 = false;
    L43:
        if (r0 == false) goto L47;
        r5.put("aippt_task_id", r15);
        return;
    L47:
        return;
    L33:
        r13 = false;
        goto L34
    L24:
        r10 = false;
        goto L25
    L18:
        r8 = false;
        goto L19
    L12:
        r4 = false;
        goto L13
    L46:
        return;
    L5:
        if (r6.optInt("is_ai_ppt", 0) != 1) goto L7;
        r2 = true;
        goto L8
    }

    public static void R0(String r5, String r6, String r7, ICameraEventExt r8) {
        Intrinsics.checkNotNullParameter("camera", "currentPage");
        Intrinsics.checkNotNullParameter(r5, "captureMode");
        Intrinsics.checkNotNullParameter(r6, "clickFrom");
        Intrinsics.checkNotNullParameter(r7, "enterMethod");
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        if (r8 != null) goto L5;
        JSONObject r2 = new JSONObject();
    L8:
        r2.put("camera_type", N0(r5));
        r2.put("current_page", "camera");
        int r1 = r.j;
        r2.put("tab_name", r.a.a(r5));
        r2.put("enter_method", r7);
        r2.put("click_from", r6);
        e6.a.getClass();
        r2.put("album_status", e6.a());
        if (r8 == null) goto L11;
        JSONObject r9 = r8.getExtraParams();
    L12:
        M0(r2, r9);
        Unit r10 = Unit.INSTANCE;
        r0.reportEvent("click_upload_entrance", r2);
        return;
    L11:
        r9 = null;
        goto L12
    L5:
        Intrinsics.checkNotNullParameter(r8, "$this$jsonObject");
        r2 = r8.clickCameraButtonEventExt();
        if (r2 != null) goto L8;
        r2 = new JSONObject();
        goto L8
    }

    public static void X0(String r3, String r4, ICameraEventExt r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "itemType");
        Intrinsics.checkNotNullParameter(r4, "captureMode");
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        if (r5 != null) goto L5;
        JSONObject r7 = new JSONObject();
    L8:
        r7.put("camera_type", N0(r4));
        r7.put("item_type", r3);
        r7.put("current_page", "camera");
        int r8 = r.j;
        r7.put("tab_name", r.a.a(r4));
        if (r6 == null) goto L11;
        r7.put("intro_text_info", r6);
    L11:
        Unit r9 = Unit.INSTANCE;
        r0.reportEvent("camera_item_show", r7);
        return;
    L5:
        Intrinsics.checkNotNullParameter(r5, "$this$jsonObject");
        r7 = r5.cameraItemShowEventExt();
        if (r7 != null) goto L8;
        r7 = new JSONObject();
        goto L8
    }

    public static void T0(String r2, String r3, String r4, String r5, ICameraEventExt r6) {
        Intrinsics.checkNotNullParameter(r2, "currentPage");
        Intrinsics.checkNotNullParameter(r3, "captureMode");
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        if (r6 != null) goto L5;
        JSONObject r7 = new JSONObject();
    L8:
        r7.put("current_page", r2);
        int r8 = r.j;
        r7.put("current_tab", r.a.a(r3));
        if (o0.d(r4) == false) goto L12;
        r7.put("enter_method", r4);
    L12:
        if (o0.d(r5) == false) goto L14;
        r7.put("previous_page", r5);
    L14:
        Unit r9 = Unit.INSTANCE;
        r0.reportEvent("enter_page", r7);
        return;
    L5:
        Intrinsics.checkNotNullParameter(r6, "$this$jsonObject");
        r7 = r6.enterPageEventExt();
        if (r7 != null) goto L8;
        r7 = new JSONObject();
        goto L8
    }

    public static void S0(String r4, boolean r5, String r6, Boolean r7, String r8, ICameraEventExt r9) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        if (r9 != null) goto L5;
        JSONObject r1 = new JSONObject();
    L8:
        r1.put("camera_type", N0(r6));
        r1.put("current_page", r4);
        if (r5 == false) goto L11;
        String r10 = "slide";
    L12:
        r1.put("enter_method", r10);
        int r11 = r.j;
        r1.put("tab_name", r.a.a(r6));
        r1.put("picture_from", W0(r7));
        JSONObject r12 = null;
        if (r9 == null) goto L17;
        JSONObject r13 = r9.getExtraParams();
        if (r13 == null) goto L17;
        Integer r14 = Integer.valueOf(r13.optInt("is_ai_doc", 0));
    L18:
        r1.put("is_ai_doc", r14);
        if (o0.d(r8) == false) goto L21;
        r1.put("click_from", r8);
    L21:
        if (r9 == null) goto L23;
        r12 = r9.getExtraParams();
    L23:
        M0(r1, r12);
        Unit r15 = Unit.INSTANCE;
        r0.reportEvent("enter_camera", r1);
        return;
    L17:
        r14 = null;
        goto L18
    L11:
        r10 = "click";
        goto L12
    L5:
        Intrinsics.checkNotNullParameter(r9, "$this$jsonObject");
        r1 = r9.enterCameraEventExt();
        if (r1 != null) goto L8;
        r1 = new JSONObject();
        goto L8
    }

    public final void U0(long r4, String r6, boolean r7, String r8, ICameraEventExt r9, Long r10) {
        Intrinsics.checkNotNullParameter(r6, "leaveReason");
        Intrinsics.checkNotNullParameter(r8, "captureMode");
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        if (r9 != null) goto L5;
        JSONObject r1 = new JSONObject();
    L8:
        r1.put("stay_time", r4);
        r1.put("leave_reason", r6);
        r1.put("camera_type", N0(r8));
        r1.put("current_page", "camera");
        if (r7 == false) goto L11;
        String r5 = "slide";
    L12:
        r1.put("enter_method", r5);
        int r11 = r.j;
        r1.put("tab_name", r.a.a(r8));
        Integer r12 = this.b;
        if (r12 == null) goto L20;
        CameraTabTipsShowOrder r13 = CameraTabTipsShowOrder.ORDER;
        if (r12.intValue() != r13.getType()) goto L17;
        r1.put("tips_type", r13.getMobStr());
        goto L20
    L17:
        CameraTabTipsShowOrder r14 = CameraTabTipsShowOrder.RANDOM;
        if (r12.intValue() != r14.getType()) goto L20;
        r1.put("tips_type", r14.getMobStr());
    L20:
        r1.put("tips_count", this.c);
        x r15 = this.a;
        JSONObject r16 = null;
        if (r15 == null) goto L23;
        String r17 = r15.a();
    L25:
        if (o0.d(r17) == false) goto L27;
        r1.put("click_from", r17);
    L27:
        if (r10 == null) goto L29;
        r1.put("video_time", r10.longValue());
    L29:
        if (r9 == null) goto L31;
        r16 = r9.getExtraParams();
    L31:
        M0(r1, r16);
        Unit r18 = Unit.INSTANCE;
        r0.reportEvent("leave_camera", r1);
        this.c = 0;
        this.d = 0;
        return;
    L23:
        r17 = null;
        goto L25
    L11:
        r5 = "click";
        goto L12
    L5:
        Intrinsics.checkNotNullParameter(r9, "$this$jsonObject");
        r1 = r9.leaveCameraEventExt();
        if (r1 != null) goto L8;
        r1 = new JSONObject();
        goto L8
    }

    public static void Q0(i r16, String r17, String r18, ICameraEventExt r19, Boolean r20, Integer r21, Boolean r22, int r23) {
        if ((r23 & 32) == 0) goto L5;
        String r3 = "camera_confirm";
    L7:
        if ((r23 & 64) == 0) goto L9;
        Integer r13 = null;
    L11:
        if ((r23 & 128) == 0) goto L13;
        Boolean r14 = null;
    L14:
        r16.getClass();
        Intrinsics.checkNotNullParameter("camera_action", "itemType");
        Intrinsics.checkNotNullParameter(r17, "buttonType");
        Intrinsics.checkNotNullParameter(r18, "captureMode");
        Intrinsics.checkNotNullParameter(r3, "currentPage");
        O0(r16, "camera_action", r17, r3, r18, r19, r20, null, null, null, null, r16.e, r16.f, r13, r14, 10112);
        return;
    L13:
        r14 = r22;
        goto L14
    L9:
        r13 = r21;
        goto L11
    L5:
        r3 = null;
        goto L7
    }

    public static void V0(long r2, String r4, boolean r5, boolean r6, String r7, ICameraEventExt r8, Boolean r9, Boolean r10, EduIntentMode r11) {
        Intrinsics.checkNotNullParameter(r4, "leaveReason");
        Intrinsics.checkNotNullParameter(r7, "captureMode");
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        if (r8 != null) goto L5;
        JSONObject r12 = new JSONObject();
    L8:
        r12.put("stay_time", r2);
        r12.put("leave_reason", r4);
        r12.put("camera_type", N0(r7));
        r12.put("picture_from", W0(Boolean.valueOf(r5)));
        r12.put("current_page", "camera_confirm");
        if (r10 == null) goto L11;
        r12.put("change_range", r10.booleanValue() ? 1 : 0);
    L11:
        if (r6 == false) goto L13;
        String r3 = "slide";
    L14:
        r12.put("enter_method", r3);
        int r13 = r.j;
        r12.put("tab_name", r.a.a(r7));
        if (r9 != null) goto L17;
    L21:
        if (r11 != null) goto L23;
        int r14 = -1;
    L25:
        if (r14 != 1) goto L27;
        String r15 = TriggerSendLoading.NO_LOADING;
    L33:
        r12.put("if_edu_intention", r15);
        Unit r16 = Unit.INSTANCE;
        r0.reportEvent("leave_camera_confirm", r12);
        return;
    L27:
        if (r14 != 2) goto L29;
    L31:
        r15 = "1";
        goto L33
    L29:
        if (r14 == 3) goto L31;
        r15 = "-1";
        goto L33
    L23:
        r14 = a.a[r11.ordinal()];
        goto L25
    L17:
        if (r9.booleanValue() == false) goto L19;
        String r17 = "multi";
    L20:
        r12.put("search_type", r17);
        goto L21
    L19:
        r17 = "single";
        goto L20
    L13:
        r3 = "click";
        goto L14
    L5:
        Intrinsics.checkNotNullParameter(r8, "$this$jsonObject");
        r12 = r8.leaveCameraConfirmEventExt();
        if (r12 != null) goto L8;
        r12 = new JSONObject();
        goto L8
    }

    public static void P0(i r19, String r20, String r21, String r22, ICameraEventExt r23, String r24, String r25, String r26, String r27, int r28) {
        if ((r28 & 16) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r28 & 32) == 0) goto L9;
        String r11 = null;
    L11:
        if ((r28 & 64) == 0) goto L13;
        String r12 = null;
    L15:
        if ((r28 & 128) == 0) goto L17;
        String r13 = null;
    L18:
        r19.getClass();
        Intrinsics.checkNotNullParameter(r20, "itemType");
        Intrinsics.checkNotNullParameter(r21, "buttonType");
        Intrinsics.checkNotNullParameter(r22, "captureMode");
        O0(r19, r20, r21, "camera", r22, r23, null, r10, r11, r12, r13, null, null, null, null, 64512);
        return;
    L17:
        r13 = r27;
        goto L18
    L13:
        r12 = r26;
        goto L15
    L9:
        r11 = r25;
        goto L11
    L5:
        r10 = r24;
        goto L7
    }

    public static void O0(i r13, String r14, String r15, String r16, String r17, ICameraEventExt r18, Boolean r19, String r20, String r21, String r22, String r23, String r24, String r25, Integer r26, Boolean r27, int r28) {
        JSONObject r3 = null;
        if ((r28 & 128) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r28 & 256) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r28 & 512) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r28 & 2048) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r28 & 4096) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r28 & 16384) == 0) goto L25;
        Integer r8 = null;
    L27:
        if ((r28 & 32768) == 0) goto L29;
        Boolean r1 = null;
    L30:
        r13.getClass();
        com.larus.platform.service.o r9 = com.larus.platform.service.o.a;
        if (r18 != null) goto L33;
        JSONObject r10 = new JSONObject();
    L36:
        r10.put("camera_type", N0(r17));
        r10.put("item_type", r14);
        r10.put("button_type", r15);
        r10.put("current_page", r16);
        int r11 = r.j;
        r10.put("tab_name", r.a.a(r17));
        if (r8 == null) goto L39;
        r10.put("item_rank", r8.intValue());
    L39:
        if (r1 == null) goto L41;
        r10.put("is_default", r1.booleanValue() ? 1 : 0);
    L41:
        if (r20 == null) goto L43;
        r10.put("to_camera_type", N0(r20));
        r10.put("to_tab", r.a.a(r20));
    L43:
        if (r19 != null) goto L45;
    L49:
        if (r2 == null) goto L51;
        r10.put("from_focus", r2);
    L51:
        if (r4 == null) goto L53;
        r10.put("to_focus", r4);
    L53:
        if (r5 == null) goto L55;
        r10.put("switch_method", r5);
    L55:
        if (r6 == null) goto L57;
        r10.put("content_type", r6);
    L57:
        if (r7 == null) goto L59;
        r10.put("content_source", r7);
    L59:
        if (r18 == null) goto L61;
        r3 = r18.getExtraParams();
    L61:
        M0(r10, r3);
        Unit r0 = Unit.INSTANCE;
        r9.reportEvent("click_camera_button", r10);
        return;
    L45:
        if (r19.booleanValue() == false) goto L47;
        String r12 = "multi";
    L48:
        r10.put("search_type", r12);
        goto L49
    L47:
        r12 = "single";
        goto L48
    L33:
        Intrinsics.checkNotNullParameter(r18, "$this$jsonObject");
        r10 = r18.clickCameraButtonEventExt();
        if (r10 != null) goto L36;
        r10 = new JSONObject();
        goto L36
    L29:
        r1 = r27;
        goto L30
    L25:
        r8 = r26;
        goto L27
    L21:
        r7 = r25;
        goto L23
    L17:
        r6 = r24;
        goto L19
    L13:
        r5 = r23;
        goto L15
    L9:
        r4 = r22;
        goto L11
    L5:
        r2 = r21;
        goto L7
    }
}

package com.larus.bmhome.chat.trace.multimodal;

import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.utils.c;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import ic8.m0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public a() {
    }

    public static void b(String r5, ProcessFileResultCode r6, m0 r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "fileIdentifier");
        MultimodalCommonParamManager.CommonParam r0 = MultimodalCommonParamManager.a(r5);
        String r1 = null;
        if (r0 == null) goto L22;
        if (r7 == null) goto L8;
        String r2 = r7.f;
        if (r2 == null) goto L8;
        r0.setFileMD5(r2);
    L8:
        if (r7 == null) goto L10;
        r0.setFileSize(Integer.valueOf((int) r7.c));
    L10:
        if (r7 == null) goto L14;
        String r3 = r7.b;
        if (r3 == null) goto L14;
        r0.setFileType(StringsKt.substringAfterLast$default(r3, '.', null, 2, null));
    L14:
        if (r7 == null) goto L22;
        String r9 = r7.d;
        if (r9 == null) goto L22;
        String r4 = r0.getFileType();
        if (r4 == null) goto L21;
        r9 = r4;
    L21:
        r0.setFileType(r9);
    L22:
        JSONObject r10 = new JSONObject();
        if (r6 == null) goto L25;
        String r11 = r6.getErrorType();
    L26:
        r10.put("send_file_process_msg", r11);
        if (r6 == null) goto L29;
        String r12 = r6.getValue();
    L30:
        r10.put("send_file_process_msg_detail", r12);
        if (r6 == null) goto L33;
        r1 = r6.getValue();
    L33:
        r10.put("detail_error_msg", r1);
        ResourceCenter.a.getClass();
        boolean r13 = ResourceCenter.d(r5);
        r10.put("resource_center_enabled", r13);
        if (r13 == false) goto L36;
        Intrinsics.checkNotNullParameter(r5, "identifier");
        r10.put("resource_id", ResourceCenter.e.get(r5));
        r10.put("resource_scene_id", ResourceCenter.g(r5).getTitle());
    L36:
        if (r8 == null) goto L38;
        r10.put("extra", r8);
    L38:
        JSONObject r14 = com.larus.bmhome.chat.trace.appreciable.a.b(MultimodalCommonParamManager.a(r5), r10);
        FLogger.a.d("MultimodalSendFailTrace", "onSendFailed, event=im_send_multimodal_fail, param=" + r14);
        o.a.reportEvent("im_send_multimodal_fail", r14);
        c.a("im_send_multimodal_fail", r14, true);
        return;
    L29:
        r12 = null;
        goto L30
    L25:
        r11 = null;
        goto L26
    }

    public static /* synthetic */ void c(String r1, ProcessFileResultCode r2, m0 r3, int r4) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        b(r1, r2, r3, null);
    }

    public static void d(String r3, String r4, boolean r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r6, "errorMsg");
        MultimodalCommonParamManager.CommonParam r0 = MultimodalCommonParamManager.a(r3);
        JSONObject r1 = new JSONObject();
        r1.put("error_msg", r6);
        r1.put("is_open_by_cache", r5 ? 1 : 0);
        r1.put(MusicAppletPage.KEY_MESSAGE_ID, r4);
        r1.put("tosKey", r7);
        boolean r9 = o0.d(r8);
        r1.put("resource_center_enabled", r9);
        if (r9 == false) goto L5;
        r1.put("resource_id", r8);
    L5:
        JSONObject r10 = com.larus.bmhome.chat.trace.appreciable.a.b(r0, r1);
        FLogger.a.d("MultimodalSendFailTrace", "onSendFailed, event=message_file_open_error, param=" + r10);
        o.a.reportEvent("message_file_open_error", r10);
        c.a("message_file_open_error", r10, true);
        MultimodalCommonParamManager.b(r3);
    }

    public static void a(String r3, String r4, String r5, String r6, String r7, boolean r8, Map r9) {
        Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r5, "errorMsg");
        MultimodalCommonParamManager.CommonParam r0 = MultimodalCommonParamManager.a(r3);
        JSONObject r1 = new JSONObject();
        r1.put("error_msg", r5);
        r1.put("is_open_by_cache", 0);
        r1.put(MusicAppletPage.KEY_MESSAGE_ID, r4);
        r1.put("tosKey", r6);
        r1.put("src", r7);
        r1.put("is_multi_img", r8 ? 1 : 0);
        if (r9 == null) goto L5;
        r1.put("extra", new JSONObject(r9).toString());
    L5:
        JSONObject r10 = com.larus.bmhome.chat.trace.appreciable.a.b(r0, r1);
        FLogger.a.d("MultimodalSendFailTrace", "onSendFailed, event=message_image_load_error, param=" + r10);
        o.a.reportEvent("message_image_load_error", r10);
        c.a("message_image_load_error", r10, true);
        MultimodalCommonParamManager.b(r3);
    }
}

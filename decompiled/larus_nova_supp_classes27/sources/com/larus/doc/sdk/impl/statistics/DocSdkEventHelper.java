package com.larus.doc.sdk.impl.statistics;

import by7.a;
import com.ixigua.lib.track.TrackParams;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.office.OfflineDocReportGate;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.c0;
import tx9.y3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JQ\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J{\u0010\u0018\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\rJ&\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005J\u0083\u0001\u0010%\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010&\u001a\u0004\u0018\u00010\u00112\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010\u00052\b\u0010*\u001a\u0004\u0018\u00010\u00112\b\u0010+\u001a\u0004\u0018\u00010\u00052\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010\u00052\b\u0010/\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u00100JG\u00101\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u00102R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/larus/doc/sdk/impl/statistics/DocSdkEventHelper;", "", "<init>", "()V", "TAG", "", "PAGE_AI_DOC_DETAIL", "CLICK_FROM_INSERT_FILE", "DOCX_TYPE", "EVENT_TEXT_SELECTION_BAR_SHOW", "EVENT_TEXT_SELECTION_BAR_CLICK", "EVENT_OUTPUT_PREVIEW_EXIT", "reportToolbarButtonShow", "", "pageToken", "artifactMetaId", "resourceType", "", "buttonName", "conversationId", "previousPage", "params", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "reportToolbarButtonClick", "buttonNameLevelOne", "buttonNameLevelTwo", "buttonLevel", "messageId", "offlineCreateAttemptId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "reportClickUploadEntrance", "reportUploadAttachmentStatus", "isSuccess", "", "picType", "errorMessage", "reportOutputPreviewExit", "contentLength", "duration", "", "leaveReason", "isFinishGeneration", "feishuRecordId", "feishuRecordContentType", "recordScene", "isGeneralAgent", "chatId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "reportContextMenuItemShow", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocSdkEventHelper {
    private static final String CLICK_FROM_INSERT_FILE = "insert_file";
    private static final String DOCX_TYPE = "docx";
    private static final String EVENT_OUTPUT_PREVIEW_EXIT = "output_preview_exit";
    private static final String EVENT_TEXT_SELECTION_BAR_CLICK = "text_selection_bar_click";
    private static final String EVENT_TEXT_SELECTION_BAR_SHOW = "text_selection_bar_show";
    public static final DocSdkEventHelper INSTANCE = null;
    private static final String PAGE_AI_DOC_DETAIL = "ai_doc_detail";
    private static final String TAG = "DocSdkEventHelper";

    static {
        INSTANCE = new DocSdkEventHelper();
    }

    private DocSdkEventHelper() {
    }

    public static /* synthetic */ Unit a(JSONObject r0, String r1) {
        return reportToolbarButtonClick$lambda$0(r0, r1);
    }

    public final void reportClickUploadEntrance() {
        c0.H(null, CLICK_FROM_INSERT_FILE, null, null, null, PAGE_AI_DOC_DETAIL, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, null, null, 33546205);
    }

    private static final Unit reportToolbarButtonClick$lambda$0(JSONObject r1, String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        r1.put("message_id", r2);
    L10:
        TrackParams r3 = new TrackParams().merge(r1);
        a r4 = new a(EVENT_TEXT_SELECTION_BAR_CLICK);
        r4.a.merge(r3);
        r4.b();
        return Unit.INSTANCE;
    L4:
        if (StringsKt.isBlank(r2) == true) goto L7;
        r0 = false;
        goto L8
    }

    public final void reportUploadAttachmentStatus(boolean r410, String r50, String r51) {
        if (r410 == false) goto L4;
        String r0 = "1";
    L5:
        y3.a(null, PAGE_AI_DOC_DETAIL, null, r51, "pic", r50, r0, null, null, CLICK_FROM_INSERT_FILE, null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -33556603, 65535);
        return;
    L4:
        r0 = "0";
        goto L5
    }

    public static /* synthetic */ void reportUploadAttachmentStatus$default(DocSdkEventHelper r1, boolean r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.reportUploadAttachmentStatus(r2, r3, r4);
    }

    public final void reportContextMenuItemShow(String r11, String r12, Integer r13, String r14, String r15, String r16) {
        reportToolbarButtonShow$default(this, r11, r12, r13, r14, r15, r16, null, 64, null);
    }

    public final void reportToolbarButtonShow(String r2, String r3, Integer r4, String r5, String r6, String r7, JSONObject r8) {
        Intrinsics.checkNotNullParameter(r8, "params");
        if (r2 != null) goto L20;
    L7:
        if (r3 == null) goto L9;
        r8.put("artifact_meta_id", r3);     // Catch: JSONException -> L5
    L9:
        if (r5 == null) goto L11;
        r8.put("button_name_level_one", r5);     // Catch: JSONException -> L5
    L11:
        if (r6 == null) goto L13;
        r8.put("conversation_id", r6);     // Catch: JSONException -> L5
    L13:
        r8.put("resource_type", r4);     // Catch: JSONException -> L5
        r8.put("current_page", PAGE_AI_DOC_DETAIL);     // Catch: JSONException -> L5
        if (r7 == null) goto L18;
        r8.put(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r7);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e(TAG, "error in DocSdkEventHelper reportOutputPreviewToolShow: " + e.getLocalizedMessage());
    L18:
        TrackParams r9 = new TrackParams().merge(r8);
        a r10 = new a(EVENT_TEXT_SELECTION_BAR_SHOW);
        r10.a.merge(r9);
        r10.b();
        return;
    L20:
        r8.put("page_token", r2);     // Catch: JSONException -> L5
        goto L7
    }

    public static /* synthetic */ void reportToolbarButtonShow$default(DocSdkEventHelper r9, String r10, String r11, Integer r12, String r13, String r14, String r15, JSONObject r16, int r17, Object r18) {
        if ((r17 & 64) == 0) goto L5;
        JSONObject r8 = new JSONObject();
    L6:
        r9.reportToolbarButtonShow(r10, r11, r12, r13, r14, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    public final void reportToolbarButtonClick(String r2, String r3, Integer r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r12, "params");
        if (r2 != null) goto L26;
    L7:
        if (r3 == null) goto L9;
        r12.put("artifact_meta_id", r3);     // Catch: JSONException -> L5
    L9:
        if (r5 == null) goto L11;
        r12.put("button_name_level_one", r5);     // Catch: JSONException -> L5
    L11:
        if (r6 == null) goto L13;
        r12.put("button_name_level_two", r6);     // Catch: JSONException -> L5
    L13:
        if (r7 == null) goto L15;
        r12.put("button_level", r7);     // Catch: JSONException -> L5
    L15:
        if (r8 == null) goto L17;
        r12.put("conversation_id", r8);     // Catch: JSONException -> L5
    L17:
        if (r10 == null) goto L19;
        r12.put("message_id", r10);     // Catch: JSONException -> L5
    L19:
        r12.put("resource_type", r4);     // Catch: JSONException -> L5
        r12.put("current_page", PAGE_AI_DOC_DETAIL);     // Catch: JSONException -> L5
        if (r9 == null) goto L24;
        r12.put(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r9);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e(TAG, "error in DocSdkEventHelper reportOutputPreviewToolShow: " + e.getLocalizedMessage());
    L24:
        final JSONObject r13 = new JSONObject(r12.toString());
        OfflineDocReportGate r14 = OfflineDocReportGate.a;
        Function1 r15 = new s39.a(r13);
        r14.getClass();
        OfflineDocReportGate.d(r11, r15);
        return;
    L26:
        r12.put("page_token", r2);     // Catch: JSONException -> L5
        goto L7
    }

    public final void reportOutputPreviewExit(String r3, String r4, Integer r5, Integer r6, Long r7, String r8, Integer r9, String r10, String r11, String r12, String r13, String r14) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L39
        if (r3 == null) goto L5;
        r0.put("page_token", r3);     // Catch: Exception -> L39
    L5:
        if (r4 == null) goto L7;
        r0.put("artifact_meta_id", r4);     // Catch: Exception -> L39
    L7:
        if (r6 == null) goto L9;
        r0.put("content_length", r6.intValue());     // Catch: Exception -> L39
    L9:
        if (r8 == null) goto L11;
        r0.put("leave_reason", r8);     // Catch: Exception -> L39
    L11:
        if (r7 == null) goto L13;
        r0.put("duration", r7.longValue());     // Catch: Exception -> L39
    L13:
        if (r9 == null) goto L15;
        r0.put("is_finish_generation", r9.intValue());     // Catch: Exception -> L39
    L15:
        if (r10 == null) goto L17;
        r0.put("feishu_record_id", r10);     // Catch: Exception -> L39
    L17:
        if (r11 == null) goto L19;
        r0.put("feishu_record_generated_type", r11);     // Catch: Exception -> L39
    L19:
        if (r12 == null) goto L22;
        r0.put("record_scene", r12);     // Catch: Exception -> L39
    L22:
        if (r13 != null) goto L24;
    L27:
        boolean r15 = true;
    L29:
        if ((true ^ r15) == true) goto L32;
        r13 = null;
    L32:
        if (r13 != null) goto L34;
        r13 = "0";
    L34:
        r0.put("is_general_agent", r13);     // Catch: Exception -> L39
        if (r14 != null) goto L37;
        r14 = "";
    L37:
        r0.put("chat_id", r14);     // Catch: Exception -> L39
        r0.put("current_page", PAGE_AI_DOC_DETAIL);     // Catch: Exception -> L39
        r0.put("resource_type", r5);     // Catch: Exception -> L39
        TrackParams r16 = new TrackParams().merge(r0);     // Catch: Exception -> L39
        a r17 = new a(EVENT_OUTPUT_PREVIEW_EXIT);     // Catch: Exception -> L39
        r17.a.merge(r16);     // Catch: Exception -> L39
        r17.b();     // Catch: Exception -> L39
        return;
    L24:
        if (r13.length() == 0) goto L27;
        r15 = false;
    L39:
        e = move-exception;
        FLogger.a.e(TAG, "error in DocSdkEventHelper reportOutputPreviewExit: " + e.getLocalizedMessage());
    }

    public static /* synthetic */ void reportToolbarButtonClick$default(DocSdkEventHelper r14, String r15, String r16, Integer r17, String r18, String r110, String r20, String r21, String r22, String r23, String r24, JSONObject r25, int r26, Object r27) {
        if ((r26 & 512) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r26 & 1024) == 0) goto L9;
        JSONObject r13 = new JSONObject();
    L10:
        r14.reportToolbarButtonClick(r15, r16, r17, r18, r110, r20, r21, r22, r23, r12, r13);
        return;
    L9:
        r13 = r25;
        goto L10
    L5:
        r12 = r24;
        goto L7
    }
}

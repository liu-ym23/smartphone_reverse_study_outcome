package com.larus.drive.sdk.impl.utils;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.ee.drive.preview.DrivePreviewOpenRequest;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.impl.store.DrivePreviewRequestStore;
import com.larus.office.base.preview.OfficePreviewNavigator;
import com.larus.office.base.preview.OfficePreviewType;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k {
    public static final k a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficePreviewType.values().length];
            r0[OfficePreviewType.DOCX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[OfficePreviewType.SLIDES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[OfficePreviewType.SHEETS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[OfficePreviewType.BITABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[OfficePreviewType.FILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[OfficePreviewType.WIKI.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
        a = new k();
    }

    public k() {
    }

    public static String b() {
        e0 r0 = (e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L7;
        LaunchInfo r1 = r0.a;
        if (r1 == null) goto L7;
        return r1.W();
    L7:
        return null;
    }

    public static boolean c() {
        if (z2.a.f4() == true) goto L5;
    L9:
        FLogger.a.i("DrivePreviewHelper", "skip office miniapp preview because switch disabled");
        return false;
    L5:
        if (com.larus.platform.exp.i.a.a() == false) goto L9;
        return true;
    }

    public static Boolean i(OfficeSpaceItem r2) {
        Boolean r0 = j((String) r2.getExtra().get("is_file_owner"));
        if (r0 != null) goto L8;
        Boolean r1 = j((String) r2.getExtra().get("is_slides_owner"));
        if (r1 == null) goto L7;
        return r1;
    L7:
        return j((String) r2.getExtra().get("is_sheet_owner"));
    L8:
        return r0;
    }

    public static Boolean j(String r3) {
        if (r3 == null) goto L5;
        String r4 = r3.toLowerCase(Locale.ROOT);
    L6:
        if (r4 == null) goto L31;
        int r1 = r4.hashCode();
        if (r1 == 48) goto L27;
        if (r1 == 49) goto L23;
        if (r1 == 3569038) goto L20;
        if (r1 == 97196323) goto L17;
        return null;
    L17:
        if (r4.equals("false") == true) goto L30;
        return null;
    L30:
        return Boolean.FALSE;
    L20:
        if (r4.equals("true") == true) goto L32;
        return null;
    L32:
        return Boolean.TRUE;
    L23:
        if (r4.equals("1") == true) goto L32;
        return null;
    L27:
        if (r4.equals("0") == true) goto L30;
        return null;
    L31:
        return null;
    L5:
        r4 = null;
        goto L6
    }

    public static OfficeSpaceItem k(DriveFileItem r15) {
        String r0 = r15.b;
        if (StringsKt.isBlank(r0) == false) goto L5;
        r0 = r15.c;
    L5:
        String r2 = r0;
        int r3 = r15.d;
        String r4 = r15.a;
        String r5 = r15.e;
        if (r15.j != DriveFileType.FOLDER) goto L8;
        boolean r1 = true;
    L9:
        LinkedHashMap r9 = new LinkedHashMap();
        String r6 = null;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L21
        String r11 = r15.l;     // Catch: Throwable -> L21
        if (r11 != null) goto L13;
    L18:
        JSONObject r12 = null;
    L19:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L21
    L24:
        if (Result.exceptionOrNull-impl(r13) == null) goto L27;
        FLogger.a.i("DrivePreviewHelper", "parse drive file extra failed");
    L27:
        if (Result.isFailure-impl(r13) == false) goto L29;
        r13 = null;
    L29:
        JSONObject r14 = (JSONObject) r13;
        if (r14 == null) goto L39;
        Iterator<String> r16 = r14.keys();
        if (r16 == null) goto L39;
    L34:
        if (r16.hasNext() == false) goto L39;
        String r17 = r16.next();
        Object r18 = r14.opt(r17);
        if (r18 == null) goto L34;
        r9.put(r17, r18.toString());
    L39:
        CharSequence r110 = (CharSequence) r9.get("file_ext");
        if (r110 != null) goto L42;
    L45:
        boolean r111 = true;
    L46:
        if (r111 == false) goto L52;
        String r7 = r15.d(false);
        if ((true ^ StringsKt.isBlank(r7)) == false) goto L50;
        r6 = r7;
    L50:
        if (r6 == null) goto L52;
        r9.put("file_ext", r6);
    L52:
        r9.put("is_file_owner", String.valueOf(r15.g()));
        return new OfficeSpaceItem(r2, r3, r4, r5, null, r1, r9, null, Integer.valueOf(r15.d), 0, 656, null);
    L42:
        if (StringsKt.isBlank(r110) == true) goto L45;
        r111 = false;
        goto L46
    L13:
        if ((!StringsKt.isBlank(r11)) == true) goto L16;
        r11 = null;
    L16:
        if (r11 == null) goto L18;
        r12 = new JSONObject(r11);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L8:
        r1 = false;
        goto L9
    }

    public static boolean h(Context r3, OfficeSpaceItem r4) {
        String r0 = r4.getUrl();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        FLogger.a.i("DrivePreviewHelper", "skip webview preview because url is empty, objType=" + r4.getObjType());
        return false;
    L12:
        OfficePreviewNavigator r2 = OfficePreviewNavigator.a;
        String r5 = r4.getUrl();
        r2.getClass();
        return OfficePreviewNavigator.b(r3, r5, null);
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static boolean e(Context r2, DriveFileItem r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "file");
        Intrinsics.checkNotNullParameter(r4, "source");
        if (r3.j != DriveFileType.FOLDER) goto L7;
        FLogger.a.i("DrivePreviewHelper", "skip drive file preview because file is folder");
        return false;
    L7:
        return f(r2, k(r3), r4);
    }

    public static boolean f(Context r110, OfficeSpaceItem r20, String r21) {
        com.larus.office.base.preview.c r1 = com.larus.office.base.preview.c.a;
        String r2 = r20.getUrl();
        Integer r3 = r20.getRealType();
        if (r3 != null) goto L5;
    L13:
        int r4 = r20.getObjType();
    L14:
        com.larus.office.base.preview.e r5 = r1.k(r2, Integer.valueOf(r4), r20.getToken());
        if (r5 == null) goto L26;
        String r7 = r5.c;
        int r8 = r5.b;
        String r6 = r5.d;
        if (r6 != null) goto L19;
        r6 = r20.getUrl();
    L19:
        OfficeSpaceItem r9 = OfficeSpaceItem.copy$default(r20, r7, r8, null, r6, null, false, null, null, Integer.valueOf(r5.b), 0, 756, null);
        if (g(r110, r5, r9, r21) == false) goto L22;
    L23:
        return true;
    L22:
        if (h(r110, r9) == true) goto L23;
        return false;
    L26:
        return h(r110, r20);
    L5:
        if (r3.intValue() <= 0) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L13;
        r4 = r3.intValue();
        goto L14
    L7:
        r10 = false;
        goto L8
    }

    public static boolean g(Context r20, com.larus.office.base.preview.e r21, OfficeSpaceItem r22, String r23) {
        OfficePreviewType r3 = r21.a;
        int[] r4 = a.a;
        boolean r6 = true;
        switch(r4[r3.ordinal()]) {
            case 1: goto L23;
            case 2: goto L23;
            case 3: goto L23;
            case 4: goto L23;
            case 5: goto L20;
            case 6: goto L6;
            default: goto L59;
        };
    L23:
        OfficePreviewNavigator r12 = OfficePreviewNavigator.a;
        Bundle r11 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("drive_override_current_page", "ai_space_detail"), TuplesKt.to("open_chat_with_new_local_conv", Boolean.valueOf(z2.a.isOfficeDocNewConversationEnable())), TuplesKt.to("doc_title", r22.getTitle())});
        int r5 = r4[r21.a.ordinal()];
        if (r5 != 2) goto L26;
        String r16 = b();
        if (r16 != null) goto L50;
        String r7 = "";
    L51:
        r11.putString("bot_id", r7);
        r11.putString("section_id", "");
        r11.putString("artifact_version_id", "");
        r11.putInt("resource_version", 0);
        r11.putString("artifact_meta_id", "");
        r11.putString("resource_id", r21.c);
        r11.putString("message_id", "");
        r11.putString("aippt_task_id", "");
        r11.putString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, "aippt_new_detail_direct_enter");
        r11.putString(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, "ai_space_list");
        r11.putLong("click_timestamp", System.currentTimeMillis());
        Boolean r1 = i(r22);
        if (r1 == null) goto L54;
        r11.putBoolean("is_slides_owner", r1.booleanValue());
    L54:
        int r2 = r21.b;
        String r8 = r21.c;
        String r0 = r21.f;
        if (r0 != null) goto L57;
        r0 = r22.getUrl();
    L57:
        com.larus.office.base.preview.b r13 = new com.larus.office.base.preview.b(r20, r2, r8, "ai_space_list", "ai_space_list", null, null, null, r0, r11, 224);
        r12.getClass();
        return OfficePreviewNavigator.a(r13);
    L50:
        r7 = r16;
        goto L51
    L26:
        if (r5 != 3) goto L54;
        String r9 = b();
        if (r9 != null) goto L31;
        r9 = "";
    L31:
        r11.putString("bot_id", r9);
        r11.putString("section_id", "");
        r11.putString("artifact_version_id", "");
        r11.putString("artifact_meta_id", "");
        r11.putString("resource_id", r21.c);
        r11.putString("message_id", "");
        r11.putString("aippt_task_id", "");
        r11.putString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, "aippt_new_detail_direct_enter");
        r11.putString(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, "ai_space_list");
        r11.putLong("click_timestamp", System.currentTimeMillis());
        String r10 = (String) r22.getExtra().get("sheet");
        if (r10 != null) goto L34;
    L39:
        String r14 = (String) r22.getExtra().get("resource_version");
        if (r14 == null) goto L44;
        Integer r15 = StringsKt.toIntOrNull(r14);
        if (r15 == null) goto L44;
        r11.putInt("resource_version", r15.intValue());
    L44:
        Boolean r17 = i(r22);
        if (r17 == null) goto L54;
        r11.putBoolean("is_sheet_owner", r17.booleanValue());
        goto L54
    L34:
        if ((!StringsKt.isBlank(r10)) == false) goto L36;
        String r18 = r10;
    L37:
        if (r18 == null) goto L39;
        r11.putString("sheet", r18);
        goto L39
    L36:
        r18 = null;
        goto L37
    L59:
        return false;
    L6:
        if (c() == true) goto L8;
        return false;
    L8:
        String r24 = r22.getUrl();
        if (r24 != null) goto L11;
    L14:
        boolean r25 = true;
    L15:
        if (r25 == false) goto L17;
        FLogger.a.i("DrivePreviewHelper", "skip wiki preview because url is empty");
        r6 = false;
    L60:
        return r6;
    L17:
        SmartRouter.buildRoute(r20, a(r22, "wiki", null, null, null)).d();
        goto L60
    L11:
        if (StringsKt.isBlank(r24) == true) goto L14;
        r25 = false;
        goto L15
    L20:
        if (c() == true) goto L61;
        return false;
    L61:
        return d(r20, r22, r23, null, null);
    }

    public static String a(OfficeSpaceItem r22, String r23, DrivePreviewOpenRequest r24, String r25, String r26) {
        StringBuilder r8 = new StringBuilder("sslocal://doubao_apps?app_id=db_1JOlsY6&path=detail");
        r8.append("&route_mode=" + ApplicationRouter.Mode.NAVIGATE.getValue());
        List r9 = CollectionsKt.createListBuilder();
        r9.add(TuplesKt.to("biz", r23));
        switch(r23.hashCode()) {
            case -899647262: goto L19;
            case 3649456: goto L15;
            case 95852938: goto L10;
            case 109403487: goto L6;
            default: goto L23;
        };
    L6:
        if (r23.equals("sheet") == false) goto L23;
        r9.add(TuplesKt.to("sheets_token", r22.getToken()));
        r9.add(TuplesKt.to("resource_type", "12"));
        goto L23
    L10:
        if (r23.equals("drive") == false) goto L23;
        if (r24 == null) goto L23;
        DrivePreviewRequestStore r2 = DrivePreviewRequestStore.a;
        Intrinsics.checkNotNullParameter(r24, "request");
        r9.add(TuplesKt.to("drive_preview_request_id", r2.f(r24, null, null, null)));
        r9.add(TuplesKt.to("drive_preview_request", GsonProtectorUtils.toJson(new Gson(), DrivePreviewOpenRequest.copy$default(r24, null, new ArrayList(), null, null, 13, null))));
        goto L23
    L15:
        if (r23.equals("wiki") == false) goto L23;
        r9.add(TuplesKt.to("wiki_url", r22.getUrl()));
        r9.add(TuplesKt.to("page_token", r22.getToken()));
        r9.add(TuplesKt.to("resource_type", "16"));
        goto L23
    L19:
        if (r23.equals("slides") == false) goto L23;
        r9.add(TuplesKt.to("slides_token", r22.getToken()));
        r9.add(TuplesKt.to("resource_type", "9"));
    L23:
        if (r25 != null) goto L25;
    L27:
        String r3 = null;
    L28:
        r9.add(TuplesKt.to("conversation_id", r3));
        if (r26 != null) goto L31;
    L33:
        String r4 = null;
    L35:
        if (r4 != null) goto L38;
        r4 = "";
    L38:
        if (r4.length() != 0) goto L40;
        boolean r5 = true;
    L41:
        if (r5 == false) goto L45;
        a.getClass();
        r4 = b();
        if (r4 != null) goto L45;
        r4 = "";
    L45:
        r9.add(TuplesKt.to("bot_id", r4));
        r9.add(TuplesKt.to("section_id", ""));
        r9.add(TuplesKt.to("artifact_version_id", ""));
        if (Intrinsics.areEqual(r23, "slides") == false) goto L49;
        r9.add(TuplesKt.to("resource_version", "0"));
    L49:
        if (Intrinsics.areEqual(r23, "slides") == false) goto L51;
    L52:
        r9.add(TuplesKt.to("drive_override_current_page", "ai_space_detail"));
    L53:
        r9.add(TuplesKt.to("artifact_meta_id", ""));
        r9.add(TuplesKt.to("resource_id", r22.getToken()));
        r9.add(TuplesKt.to("message_id", ""));
        r9.add(TuplesKt.to("aippt_task_id", ""));
        r9.add(TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_ENTER_FROM, "ai_space_list"));
        r9.add(TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, "aippt_new_detail_direct_enter"));
        r9.add(TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, "ai_space_list"));
        r9.add(TuplesKt.to("click_timestamp", String.valueOf(System.currentTimeMillis())));
        List r0 = CollectionsKt.build(r9);
        ArrayList r13 = new ArrayList();
        Iterator r1 = r0.iterator();
    L55:
        if (r1.hasNext() == false) goto L68;
        Pair r6 = (Pair) r1.next();
        String r7 = (String) r6.component1();
        String r10 = (String) r6.component2();
        if (r10 != null) goto L59;
    L62:
        boolean r11 = true;
    L63:
        if (r11 == false) goto L65;
        String r12 = null;
    L66:
        if (r12 == null) goto L55;
        r13.add(r12);
        goto L55
    L65:
        r12 = r7 + '=' + URLEncoder.encode(r10, "UTF-8");
        goto L66
    L59:
        if (r10.length() == 0) goto L62;
        r11 = false;
        goto L63
    L68:
        r8.append("&query=" + URLEncoder.encode(CollectionsKt.joinToString$default(r13, "&", null, null, 0, null, null, 62, null), "UTF-8"));
        return r8.toString();
    L51:
        if (Intrinsics.areEqual(r23, "sheet") == false) goto L53;
    L40:
        r5 = false;
        goto L41
    L31:
        if ((!StringsKt.isBlank(r26)) == false) goto L33;
        r4 = r26;
        goto L35
    L25:
        if ((!StringsKt.isBlank(r25)) == false) goto L27;
        r3 = r25;
        goto L28
    }

    public static boolean d(Context r10, OfficeSpaceItem r11, String r12, String r13, String r14) {
        String r0 = r11.getUrl();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        FLogger.a.i("DrivePreviewHelper", "skip preview because url is empty, objType=" + r11.getObjType());
        return false;
    L12:
        DrivePreviewOpenItem r4 = l.a(r11);
        List r2 = r11.getFileList();
        ArrayList r5 = new ArrayList(r11.getFileList().size());
        Iterator r3 = r2.iterator();
    L14:
        if (r3.hasNext() == false) goto L16;
        r5.add(l.a((OfficeSpaceItem) r3.next()));
        goto L14
    L16:
        DrivePreviewOpenRequest r6 = new DrivePreviewOpenRequest(r4, r5, r12, null, 8, null);
        com.bytedance.ee.drive.preview.d r15 = com.larus.drive.sdk.impl.service.t.a;
        com.bytedance.ee.drive.preview.d r16 = com.larus.drive.sdk.impl.service.t.a;
        if (r16 == null) goto L21;
        DrivePreviewOpenRequest r17 = r16.o9(r6);
        if (r17 == null) goto L21;
        r6 = r17;
    L21:
        SmartRouter.buildRoute(r10, a(r11, "drive", r6, r13, r14)).d();
        return true;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }
}

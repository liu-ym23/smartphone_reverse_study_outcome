package p29;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {

    /* JADX INFO: renamed from: p29.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0135a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ResourceType.values().length];
            r0[ResourceType.AVATAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ResourceType.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ResourceType.VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static void a(String r5) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("current_page", r5);     // Catch: JSONException -> L5
    L7:
        TrackParams r6 = new TrackParams().merge(r0);
        by7.a r2 = new by7.a("click_create_button");
        r2.a.merge(r6);
        r2.b();
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L10
        g.a.monitorEventForSlardar("click_create_button", r0, null, null);     // Catch: Throwable -> L10
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L21;
        FLogger.a.e("CommunityEventHelper", "slardar report error,  click_create_button " + r9.getLocalizedMessage());
        return;
    L21:
        return;
    L10:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        e = move-exception;
        FLogger.a.e("CommunityEventHelper", "error in CommunityEventHelper mobClickCreateButton " + e.getLocalizedMessage());
        goto L7
    }

    public static void b(String r2, String r3, String r4, String r5, String r6, String r7, String r8, int r9) {
        if ((r9 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r9 & 128) == 0) goto L9;
        r8 = null;
    L9:
        if ((r9 & 256) == 0) goto L11;
        JSONObject r10 = new JSONObject();
    L12:
        Intrinsics.checkNotNullParameter(r4, "tabId");
        Intrinsics.checkNotNullParameter(r5, "tabName");
        Intrinsics.checkNotNullParameter(r7, "enterMethod");
        Intrinsics.checkNotNullParameter(r10, "params");
        r10.putOpt("template_page_type", r8);     // Catch: JSONException -> L15
        r10.put("current_page", r2);     // Catch: JSONException -> L15
        r10.put("bot_id", r3);     // Catch: JSONException -> L15
        r10.put("tab_id", r4);     // Catch: JSONException -> L15
        r10.put("tab_name", r5);     // Catch: JSONException -> L15
        r10.put("from_tab_id", r6);     // Catch: JSONException -> L15
        r10.put("tab_type", null);     // Catch: JSONException -> L15
        r10.put(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, r7);     // Catch: JSONException -> L15
    L17:
        TrackParams r11 = new TrackParams().merge(r10);
        by7.a r12 = new by7.a("enter_ai_generate_tab_category_page");
        r12.a.merge(r11);
        r12.b();
        return;
    L15:
        e = move-exception;
        FLogger.a.e("CommunityEventHelper", "error in CommunityEventHelper mobEnterAIGenerateTabCategoryPage " + e.getLocalizedMessage());
        goto L17
    L11:
        r10 = null;
        goto L12
    }

    public static void c(String r2, String r3, String r4, String r5, String r6, Integer r7, Boolean r8, String r9, String r10, int r11) {
        JSONObject r1 = null;
        if ((r11 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r11 & 64) == 0) goto L24;
        r8 = Boolean.FALSE;
    L24:
        if ((r11 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r11 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r11 & 512) == 0) goto L32;
        r1 = new JSONObject();
    L32:
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.putOpt("recommend_from", r2);     // Catch: JSONException -> L35
        r1.putOpt("current_page", r3);     // Catch: JSONException -> L35
        r1.putOpt("is_image_reference_public", r8);     // Catch: JSONException -> L35
        r1.putOpt("creation_sub_type", r6);     // Catch: JSONException -> L35
        r1.putOpt("creation_id", r4);     // Catch: JSONException -> L35
        r1.putOpt("image_reference_cnt", r7);     // Catch: JSONException -> L35
        r1.putOpt("creator_id", r9);     // Catch: JSONException -> L35
        r1.putOpt("message_id", r5);     // Catch: JSONException -> L35
        r1.putOpt("template_rec_req_id", r10);     // Catch: JSONException -> L35
    L37:
        TrackParams r12 = new TrackParams().merge(r1);
        by7.a r13 = new by7.a("long_press_creation_prompt");
        r13.a.merge(r12);
        r13.b();
        return;
    L35:
        e = move-exception;
        FLogger.a.e("CommunityEventHelper", "error in CommunityEventHelper mobLongPressCreationPrompt " + e.getLocalizedMessage());
        goto L37
    }
}

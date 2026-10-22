package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class v {
    public static void a(String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, Boolean r26, Integer r27, Boolean r28, String r29, String r30, String r31, Boolean r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, Boolean r42, Boolean r43, Integer r44, String r45, String r46, Boolean r47, Boolean r48, TraceFragment r49) {
        JSONObject r12 = new JSONObject();
        Intrinsics.checkNotNullParameter(r12, "params");
        if (r14 != null) goto L95;
    L7:
        if (r15 == null) goto L9;
        r12.put("enter_method", r15);     // Catch: JSONException -> L5
    L9:
        r12.put("if_allow_search", r16);     // Catch: JSONException -> L5
        r12.put("if_auto_filled", r17);     // Catch: JSONException -> L5
        r12.put("if_generate_picture", r18);     // Catch: JSONException -> L5
        r12.put("if_has_voice", r19);     // Catch: JSONException -> L5
        r12.put("if_system_prompt_added", r20);     // Catch: JSONException -> L5
        r12.put("is_edited", r21);     // Catch: JSONException -> L5
        if (r22 == null) goto L12;
        r12.put("previous_page", r22);     // Catch: JSONException -> L5
    L12:
        r12.put("profile_photo_type", r23);     // Catch: JSONException -> L5
        r12.put("create_way", r24);     // Catch: JSONException -> L5
        if (r25 == null) goto L15;
        r12.put("creation_id", r25);     // Catch: JSONException -> L5
    L15:
        String r0 = "0";
        if (r26 != null) goto L18;
    L22:
        if (r27 == null) goto L24;
        r12.put("sp_cnt", r27.intValue());     // Catch: JSONException -> L5
    L24:
        if (r28 != null) goto L26;
    L30:
        if (r29 == null) goto L32;
        r12.put("from_activity_name", r29);     // Catch: JSONException -> L5
    L32:
        if (r30 == null) goto L34;
        r12.put("from_activity_module", r30);     // Catch: JSONException -> L5
    L34:
        r12.put("image_type", r31);     // Catch: JSONException -> L5
        if (r32 != null) goto L37;
    L41:
        if (r33 == null) goto L43;
        r12.put("voice_id", r33);     // Catch: JSONException -> L5
    L43:
        if (r34 == null) goto L46;
        r12.put("voice_type", r34);     // Catch: JSONException -> L5
    L46:
        if (com.larus.utils.o0.d(r39) == false) goto L49;
        r12.put("suggested_prompt_add_type", r39);     // Catch: JSONException -> L5
    L49:
        if (com.larus.utils.o0.d(r40) == false) goto L52;
        r12.put("bio_add_type", r40);     // Catch: JSONException -> L5
    L52:
        if (com.larus.utils.o0.d(r41) == false) goto L54;
        r12.put("onboarding_add_type", r41);     // Catch: JSONException -> L5
    L54:
        if (r42 != null) goto L56;
    L60:
        if (r43 != null) goto L62;
    L66:
        if (r44 == null) goto L68;
        r12.put("polish_cnt", String.valueOf(r44.intValue()));     // Catch: JSONException -> L5
    L68:
        if (r45 == null) goto L70;
        r12.put("polish_status", r45);     // Catch: JSONException -> L5
    L70:
        if (r46 == null) goto L72;
        r12.put("private_status", r46);     // Catch: JSONException -> L5
    L72:
        if (r47 == null) goto L80;
        boolean r3 = r47.booleanValue();     // Catch: JSONException -> L5
        if (Intrinsics.areEqual(r45, "1") == false) goto L80;
        if (r3 == false) goto L78;
        Object r4 = "1";
    L79:
        r12.put("if_polish_use_internet", r4);     // Catch: JSONException -> L5
        goto L80
    L78:
        r4 = "0";
    L80:
        if (r48 == null) goto L87;
        boolean r5 = r48.booleanValue();     // Catch: JSONException -> L5
        if (Intrinsics.areEqual(r17, "1") == false) goto L87;
        if (r5 == false) goto L86;
        r0 = "1";
    L86:
        r12.put("if_auto_fill_use_internet", r0);     // Catch: JSONException -> L5
    L87:
        r12.putOpt("name_add_type", r35).putOpt("sp_add_type", r36).putOpt("profile_photo_add_type", r37).putOpt("voice_add_type", r38);     // Catch: JSONException -> L5
    L90:
        TrackParams r1 = new TrackParams().merge(r12);
        by7.a r2 = new by7.a("cancel_create_new_bot");
        if (r49 == null) goto L93;
        r2.b = r49;
    L93:
        r2.a.merge(r1);
        r2.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("CancelEventHelper", "error in CancelEventHelper cancelCreateNewBot " + e.getLocalizedMessage());
        goto L90
    L62:
        if (r43.booleanValue() == false) goto L64;
        Object r6 = "1";
    L65:
        r12.put("if_polish", r6);     // Catch: JSONException -> L5
        goto L66
    L64:
        r6 = "0";
        goto L65
    L56:
        if (r42.booleanValue() == false) goto L58;
        Object r7 = "1";
    L59:
        r12.put("if_has_bio", r7);     // Catch: JSONException -> L5
        goto L60
    L58:
        r7 = "0";
        goto L59
    L37:
        if (r32.booleanValue() == false) goto L39;
        Object r8 = "1";
    L40:
        r12.put("background_status", r8);     // Catch: JSONException -> L5
        goto L41
    L39:
        r8 = "0";
        goto L40
    L26:
        if (r28.booleanValue() == false) goto L28;
        Object r9 = "1";
    L29:
        r12.put("sp_status", r9);     // Catch: JSONException -> L5
        goto L30
    L28:
        r9 = "0";
        goto L29
    L18:
        if (r26.booleanValue() == false) goto L20;
        Object r10 = "1";
    L21:
        r12.put("if_has_onboarding", r10);     // Catch: JSONException -> L5
        goto L22
    L20:
        r10 = "0";
        goto L21
    L95:
        r12.put("enter_from", r14);     // Catch: JSONException -> L5
        goto L7
    }
}

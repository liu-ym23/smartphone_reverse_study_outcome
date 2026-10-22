package v2a;

import com.ixigua.lib.track.TrackParams;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.base.g1;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.xelement.webview.LynxUIWebView;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g implements b {
    public static final g a = null;
    public static String b;
    public static long c;
    public static String d;
    public static long e;

    public g() {
    }

    static {
        a = new g();
        b = NameKeys.UnloadStrategy_No_Strategy;
        c = -1;
        d = NameKeys.UnloadStrategy_No_Strategy;
        e = -1;
    }

    public final void f() {
        if (c != (-1)) goto L6;
        c = System.currentTimeMillis();
        return;
    }

    public final void e(boolean r6, String r7) {
        String r0 = d;
        String r2 = b;
        Integer r8 = Integer.valueOf(r6 ? 1 : 0);
        JSONObject r3 = new JSONObject();
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        if (r0 != null) goto L18;
    L7:
        if (r2 == null) goto L9;
        r3.put("voice_remix_id", r2);     // Catch: JSONException -> L5
    L9:
        r3.put("current_page", "bot_voice_change");     // Catch: JSONException -> L5
        if (r8 == null) goto L12;
        r3.put("is_fold", r8.intValue());     // Catch: JSONException -> L5
    L12:
        if (r7 == null) goto L16;
        r3.put("unfold_method", r7);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("VoiceEventHelper", "error in VoiceEventHelper mobVoiceMixBarShow " + e.getLocalizedMessage());
    L16:
        TrackParams r9 = new TrackParams().merge(r3);
        by7.a r10 = new by7.a("voice_mix_bar_show");
        r10.a.merge(r9);
        r10.b();
        return;
    L18:
        r3.put("bot_id", r0);     // Catch: JSONException -> L5
        goto L7
    }

    public static void b(w2a.f r12, String r13, SpeakerVoice r14, by7.e r15) {
        String r0 = d;
        Float r1 = Float.valueOf(r12.d / 10.0f);
        Float r2 = Float.valueOf(r12.e / 10.0f);
        List<MixVoice> r3 = r12.a;
        String r4 = null;
        if (r3 == null) goto L5;
        String r5 = w2a.i.a(r3);
    L6:
        String r6 = w2a.i.b(r12.a);
        List<MixVoice> r16 = r12.a;
        if (r16 == null) goto L9;
        int r17 = r16.size();
    L10:
        Integer r18 = Integer.valueOf(r17);
        if (r14 == null) goto L13;
        String r7 = r14.getId();
    L14:
        if (r14 != null) goto L16;
        String r8 = null;
    L20:
        if (r14 != null) goto L22;
        String r9 = null;
    L26:
        String r10 = b;
        if (r14 == null) goto L29;
        String r11 = r14.getName();
    L30:
        if (r14 == null) goto L32;
        r4 = r14.getStyleId();
    L32:
        JSONObject r19 = new JSONObject();
        Intrinsics.checkNotNullParameter(r19, LynxResourceModule.PARAMS_KEY);
        if (r7 != null) goto L67;
    L37:
        if (r0 == null) goto L39;
        r19.put("bot_id", r0);     // Catch: JSONException -> L35
    L39:
        if (r13 == null) goto L41;
        r19.put("click_from", r13);     // Catch: JSONException -> L35
    L41:
        if (r1 == null) goto L43;
        r19.put("voice_pitch", r1);     // Catch: JSONException -> L35
    L43:
        if (r2 == null) goto L45;
        r19.put("voice_speed", r2);     // Catch: JSONException -> L35
    L45:
        if (r18 == null) goto L47;
        r19.put("voice_origin_cnt", r18.intValue());     // Catch: JSONException -> L35
    L47:
        r19.put("if_voice_ratio_default", r6);     // Catch: JSONException -> L35
        if (r10 == null) goto L50;
        r19.put("voice_remix_id", r10);     // Catch: JSONException -> L35
    L50:
        if (r5 == null) goto L52;
        r19.put("is_best_match", r5);     // Catch: JSONException -> L35
    L52:
        if (r8 == null) goto L54;
        r19.put("is_public", r8);     // Catch: JSONException -> L35
    L54:
        if (r9 == null) goto L56;
        r19.put("voice_type", r9);     // Catch: JSONException -> L35
    L56:
        if (r4 == null) goto L58;
        r19.put("speaker_id", r4);     // Catch: JSONException -> L35
    L58:
        if (r11 == null) goto L62;
        r19.put("speaker_name", r11);     // Catch: JSONException -> L35
    L35:
        e = move-exception;
        FLogger.a.e("VoiceEventHelper", "error in VoiceEventHelper mobVoiceAudition " + e.getLocalizedMessage());
    L62:
        TrackParams r110 = new TrackParams().merge(r19);
        by7.a r111 = new by7.a("voice_audition");
        if (r15 == null) goto L65;
        r111.b = r15;
    L65:
        r111.a.merge(r110);
        r111.b();
        return;
    L67:
        r19.put("voice_id", r7);     // Catch: JSONException -> L35
        goto L37
    L29:
        r11 = null;
        goto L30
    L22:
        if (r14.isUgcVoice() == false) goto L24;
        r9 = "self_create";
        goto L26
    L24:
        r9 = LynxUIWebView.DEFAULT;
        goto L26
    L16:
        if (r14.getPrivateStatus() != 1) goto L18;
        r8 = "1";
        goto L20
    L18:
        r8 = "0";
        goto L20
    L13:
        r7 = null;
        goto L14
    L9:
        r17 = 0;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public final void c(String r11, String r12, String r13, SpeakerVoice r14) {
        if (r14 != null) goto L4;
        return;
    L4:
        String r0 = d;
        String r3 = "1";
        if (r14.getPrivateStatus() != 1) goto L7;
        Object r1 = "1";
    L8:
        String r2 = r14.getId();
        if (r14.isUgcVoice() == false) goto L11;
        String r5 = "self_create";
    L13:
        if (r14.getBestMatch() == true) goto L16;
        r3 = "0";
    L16:
        String r4 = b;
        String r6 = r14.getStyleId();
        String r15 = r14.getName();
        JSONObject r8 = new JSONObject();
        Intrinsics.checkNotNullParameter(r8, LynxResourceModule.PARAMS_KEY);
        if (r2 != null) goto L39;
    L21:
        if (r0 == null) goto L23;
        r8.put("bot_id", r0);     // Catch: JSONException -> L19
    L23:
        if (r4 == null) goto L25;
        r8.put("voice_remix_id", r4);     // Catch: JSONException -> L19
    L25:
        r8.put("current_page", "bot_voice_change");     // Catch: JSONException -> L19
        r8.put("click_from", r11);     // Catch: JSONException -> L19
        if (r12 == null) goto L28;
        r8.put("click_position", r12);     // Catch: JSONException -> L19
    L28:
        if (r13 == null) goto L30;
        r8.put("current_tab", r13);     // Catch: JSONException -> L19
    L30:
        r8.put("is_best_match", r3);     // Catch: JSONException -> L19
        r8.put("is_public", r1);     // Catch: JSONException -> L19
        r8.put("voice_type", r5);     // Catch: JSONException -> L19
        if (r6 == null) goto L33;
        r8.put("speaker_id", r6);     // Catch: JSONException -> L19
    L33:
        if (r15 == null) goto L37;
        r8.put("speaker_name", r15);     // Catch: JSONException -> L19
    L19:
        e = move-exception;
        FLogger.a.e("VoiceEventHelper", "error in VoiceEventHelper mobVoiceCellFunctionClick " + e.getLocalizedMessage());
    L37:
        TrackParams r16 = new TrackParams().merge(r8);
        by7.a r17 = new by7.a("voice_cell_function_click");
        r17.a.merge(r16);
        r17.b();
        return;
    L39:
        r8.put("voice_id", r2);     // Catch: JSONException -> L19
        goto L21
    L11:
        r5 = LynxUIWebView.DEFAULT;
        goto L13
    L7:
        r1 = "0";
        goto L8
    }

    public static void d(boolean r4, String r5, String r6, String r7, String r8, by7.e r9) {
        String r0 = d;
        String r1 = b;
        Integer r10 = Integer.valueOf(r4 ? 1 : 0);
        JSONObject r2 = new JSONObject();
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        if (r0 != null) goto L25;
    L7:
        if (r1 == null) goto L9;
        r2.put("voice_remix_id", r1);     // Catch: JSONException -> L5
    L9:
        if (r5 == null) goto L11;
        r2.put("voice_id", r5);     // Catch: JSONException -> L5
    L11:
        if (r10 == null) goto L13;
        r2.put("is_fold", r10.intValue());     // Catch: JSONException -> L5
    L13:
        r2.put("click_from", r6);     // Catch: JSONException -> L5
        if (r7 == null) goto L16;
        r2.put("speaker_id", r7);     // Catch: JSONException -> L5
    L16:
        if (r8 == null) goto L20;
        r2.put("speaker_name", r8);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("VoiceEventHelper", "error in VoiceEventHelper mobVoiceMixBarClick " + e.getLocalizedMessage());
    L20:
        TrackParams r11 = new TrackParams().merge(r2);
        by7.a r12 = new by7.a("voice_mix_bar_click");
        if (r9 == null) goto L23;
        r12.b = r9;
    L23:
        r12.a.merge(r11);
        r12.b();
        return;
    L25:
        r2.put("bot_id", r0);     // Catch: JSONException -> L5
        goto L7
    }

    @Override // v2a.b
    public final void a(w2a.f r26, String r27, String r28, String r29, SpeakerVoice r30, String r31) {
        Intrinsics.checkNotNullParameter(r27, "previousPage");
        Intrinsics.checkNotNullParameter(r29, "scene");
        if (r26 != null) goto L5;
        return;
    L5:
        List<MixVoice> r1 = r26.a;
        if (r1 != null) goto L8;
    L13:
        SpeakerVoice r2 = null;
    L14:
        g1 r4 = g1.a;
        String r8 = d;
        String r11 = b;
        float r12 = r26.d / 10.0f;
        float r13 = r26.e / 10.0f;
        List<MixVoice> r5 = r26.a;
        if (r5 == null) goto L17;
        int r14 = r5.size();
    L18:
        String r16 = w2a.i.b(r26.a);
        String r17 = w2a.i.a(r26.a);
        Integer r0 = r26.i;
        if (r0 == null) goto L21;
        String r3 = String.valueOf(r0.intValue() + 1);
    L22:
        p2a.d.a.a(r4, r2, r8, false, null, r27, r31, null, null, r11, Float.valueOf(r12), Float.valueOf(r13), Integer.valueOf(r14), r16, r17, r3, null, null, r29, r28, null, null, 3342732);
        return;
    L21:
        r3 = null;
        goto L22
    L17:
        r14 = 0;
        goto L18
    L8:
        if (r1.size() <= 1) goto L10;
        r2 = r30;
        goto L14
    L10:
        MixVoice r6 = (MixVoice) CollectionsKt.firstOrNull(r1);
        if (r6 == null) goto L13;
        r2 = r6.getVoiceItem();
        goto L14
    }
}

package kr8;

import android.os.Bundle;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.music.mob.MusicAppletMob$createContextCache$1;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.platform.service.AccountService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n {
    public static final n a = null;
    public static final MusicAppletMob$createContextCache$1 b = null;
    public static final MusicAppletMob$createContextCache$1 c = null;

    public n() {
    }

    static {
        a = new n();
        b = new MusicAppletMob$createContextCache$1();
        c = new MusicAppletMob$createContextCache$1();
    }

    public static String i(String r1) {
        if (r1 != null) goto L4;
    L6:
        return null;
    L4:
        if ((!StringsKt.isBlank(r1)) == false) goto L6;
        return r1;
    }

    public static String l(long r4) {
        Long r5 = Long.valueOf(r4);
        if (r5.longValue() <= 0) goto L5;
        boolean r6 = true;
    L7:
        if (r6 == true) goto L10;
        r5 = null;
    L10:
        if (r5 != null) goto L12;
        return null;
    L12:
        return r5.toString();
    L5:
        r6 = false;
        goto L7
    }

    public static void g(String r1, JSONObject r2) {
        com.larus.platform.service.o.a.reportEvent(r1, r2);
    }

    public static String h(Bundle r0, String r1) {
        if (r0 == null) goto L4;
        String r2 = r0.getString(r1);
    L6:
        return i(r2);
    L4:
        r2 = null;
        goto L6
    }

    public static JSONObject j(o r2, String r3) {
        JSONObject r4 = k(r2, r3);
        f(r4, "video_id", r2.f);
        f(r4, "user_id", r2.g);
        f(r4, "genre_id", r2.h);
        f(r4, "genre_name", r2.i);
        f(r4, "gender_id", r2.j);
        f(r4, "gender_name", r2.k);
        f(r4, "model_id", r2.l);
        f(r4, "model_name", r2.m);
        f(r4, "template_id", r2.n);
        return r4;
    }

    public static JSONObject k(o r2, String r3) {
        JSONObject r0 = new JSONObject();
        r0.put("current_page", r3);
        r0.put("app_enter_method", r2.b);
        r0.put("app_key", r2.c);
        String r4 = r2.d;
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.put("doubao_apps_message_id", r4);
        return r0;
    }

    public final synchronized JSONObject b(String r4, String r5) {
        monitor-enter(this);
        if (r5 != null) goto L32;
    L8:
        r5 = null;
    L9:
        if (r4 != null) goto L11;
    L19:
        if (r5 == null) goto L22;
        o r6 = (o) c.get(r5);     // Catch: Throwable -> L29
    L23:
        if (r6 != null) goto L26;
        monitor-exit(this);
        return null;
    L26:
        JSONObject r7 = d(r6, null, true);     // Catch: Throwable -> L29
        monitor-exit(this);
        return r7;
    L29:
        th = move-exception;
        throw th;
    L22:
        r6 = null;
        goto L23
    L11:
        if ((!StringsKt.isBlank(r4)) == true) goto L14;
        r4 = null;
    L14:
        if (r4 == null) goto L19;
        r6 = (o) b.remove(r4);     // Catch: Throwable -> L29
        if (r6 == null) goto L19;
        if (r5 == null) goto L26;
        c.put(r5, r6);     // Catch: Throwable -> L29
        goto L26
    L32:
        if ((!StringsKt.isBlank(r5)) == false) goto L8;
        goto L8
    }

    public static JSONObject c(o r1, String r2, boolean r3) {
        JSONObject r4 = d(r1, r2, r3);
        if (r1 == null) goto L6;
        f(r4, "video_id", r1.f);
        f(r4, "user_id", r1.g);
        f(r4, "genre_id", r1.h);
        f(r4, "genre_name", r1.i);
        f(r4, "gender_id", r1.j);
        f(r4, "gender_name", r1.k);
        f(r4, "model_id", r1.l);
        f(r4, "model_name", r1.m);
        f(r4, "template_id", r1.n);
    L6:
        return r4;
    }

    public static JSONObject d(o r3, String r4, boolean r5) {
        JSONObject r0 = new JSONObject();
        if (r3 == null) goto L18;
        if (r4 == null) goto L11;
        String r1 = r3.a;
        if (StringsKt.isBlank(r1) == true) goto L10;
        r4 = r1;
    L10:
        r0.put("current_page", r4);
    L11:
        r0.put("app_enter_method", r3.b);
        if (r5 == false) goto L14;
        r0.put("from_entrance", r3.e);
    L14:
        r0.put("app_key", r3.c);
        String r6 = r3.d;
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        r0.put("doubao_apps_message_id", r6);
    L18:
        return r0;
    }

    public static JSONObject e(o r4, MusicCreationContent r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "currentPage");
        boolean r0 = true;
        JSONObject r7 = c(r4, r6, true);
        if (r5 == null) goto L44;
        boolean r8 = r5.getCoverEdited();
        String r1 = TriggerSendLoading.NO_LOADING;
        if (r8 == false) goto L8;
        Object r9 = TriggerSendLoading.NO_LOADING;
    L9:
        r7.put("is_default_cover", r9);
        if (r5.getTitleEdited() == false) goto L12;
        Object r10 = TriggerSendLoading.NO_LOADING;
    L13:
        r7.put("is_default_title", r10);
        String r11 = r5.getLyrics();
        if (r11 != null) goto L16;
    L19:
        boolean r12 = true;
    L20:
        if (r12 == false) goto L31;
        String r13 = r5.getLyricsSeekContent();
        if (r13 != null) goto L24;
    L27:
        boolean r14 = true;
    L28:
        if (r14 == false) goto L31;
        r0 = false;
        goto L31
    L24:
        if (StringsKt.isBlank(r13) == true) goto L27;
        r14 = false;
    L31:
        if (r0 == false) goto L33;
        Object r15 = "1";
    L34:
        r7.put("is_lyric", r15);
        boolean r16 = r5 instanceof bq8.a;
        if (r16 == false) goto L37;
        r1 = "1";
    L37:
        r7.put("is_template", r1);
        String r2 = null;
        if (r16 == false) goto L40;
        bq8.a r17 = (bq8.a) r5;
    L41:
        if (r17 == null) goto L43;
        r2 = l(r17.a);
    L43:
        f(r7, "template_id", r2);
        goto L44
    L40:
        r17 = null;
        goto L41
    L33:
        r15 = TriggerSendLoading.NO_LOADING;
        goto L34
    L16:
        if (StringsKt.isBlank(r11) == true) goto L19;
        r12 = false;
        goto L20
    L12:
        r10 = "1";
        goto L13
    L8:
        r9 = "1";
    L44:
        return r7;
    }

    public static void f(JSONObject r0, String r1, String r2) {
        String r3 = i(r2);
        if (r3 == null) goto L6;
        r0.put(r1, r3);
        return;
    }

    public static o a(Bundle r24, com.larus.bmhome.music.player.j r25, MusicCreationContent r26, Message r27, String r28, String r29, int r30) {
        String r2 = null;
        if ((r30 & 2) == 0) goto L5;
        com.larus.bmhome.music.player.j r1 = null;
    L7:
        if ((r30 & 4) == 0) goto L9;
        MusicCreationContent r3 = null;
    L11:
        if ((r30 & 8) == 0) goto L13;
        Message r4 = null;
    L15:
        if ((r30 & 16) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r30 & 32) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r3 instanceof bq8.a) == false) goto L25;
        bq8.a r7 = (bq8.a) r3;
    L26:
        if (r7 == null) goto L28;
        bq8.d r8 = r7.b();
    L29:
        if (r6 != null) goto L37;
        String r9 = h(r24, MusicAppletPage.KEY_PATH);
        if (Intrinsics.areEqual(r9, MusicAppletPage.TEMPLATE_DETAIL.getValue()) == false) goto L34;
        r6 = "music_template_detail";
        goto L37
    L34:
        if (Intrinsics.areEqual(r9, MusicAppletPage.CHAT_MUSIC_DETAIL.getValue()) == false) goto L36;
        r6 = "music_detail";
        goto L37
    L36:
        r6 = "template_page";
    L37:
        String r10 = r6;
        String r11 = h(r24, "app_enter_method");
        if (r11 == null) goto L40;
        String r12 = r11;
    L57:
        String r13 = h(r24, "app_key");
        if (r13 != null) goto L60;
        r13 = MusicAppletPage.APP_ID;
    L60:
        String r14 = r13;
        String r15 = h(r24, MusicAppletPage.KEY_MESSAGE_ID);
        if (r15 != null) goto L72;
        String r16 = h(r24, MusicAppletPage.KEY_MESSAGE_ID);
        if (r16 != null) goto L71;
        if (r1 == null) goto L66;
        r16 = r1.j();
    L67:
        if (r16 != null) goto L71;
        if (r4 == null) goto L70;
        r16 = r4.getMessageId();
        goto L71
    L70:
        String r17 = null;
    L73:
        if (r5 != null) goto L78;
        String r18 = h(r24, "from_entrance");
        if (r18 != null) goto L77;
        r18 = "self";
    L77:
        r5 = r18;
    L78:
        String r19 = r5;
        if (r1 == null) goto L81;
        String r20 = r1.o();
    L82:
        String r21 = i(r20);
        if (r21 != null) goto L87;
        if (r3 == null) goto L86;
        r21 = r3.getVid();
        goto L87
    L86:
        String r110 = null;
    L88:
        String r111 = AccountService.a.getUserId();
        if (r8 == null) goto L93;
        bq8.e r22 = r8.c;
        if (r22 == null) goto L93;
        String r112 = l(r22.a);
    L94:
        if (r8 == null) goto L98;
        bq8.e r23 = r8.c;
        if (r23 == null) goto L98;
        String r113 = r23.b;
    L99:
        if (r8 == null) goto L103;
        bq8.e r31 = r8.b;
        if (r31 == null) goto L103;
        String r114 = l(r31.a);
    L104:
        if (r8 == null) goto L108;
        bq8.e r32 = r8.b;
        if (r32 == null) goto L108;
        String r210 = r32.b;
    L109:
        String r211 = h(r24, "model_id");
        String r212 = h(r24, "model_name");
        if (r7 == null) goto L121;
        Long r0 = Long.valueOf(r7.a);
        if (r0.longValue() <= 0) goto L114;
        boolean r33 = true;
    L115:
        if (r33 == true) goto L118;
        r0 = null;
    L118:
        if (r0 == null) goto L121;
        String r34 = r0.toString();
        if (r34 == null) goto L121;
    L125:
        return new o(r10, r12, r14, r17, r19, r110, r111, r112, r113, r114, r210, r211, r212, r34);
    L114:
        r33 = false;
    L121:
        if (r3 == null) goto L123;
        r2 = r3.getUseTemplateId();
    L123:
        r34 = i(r2);
    L108:
        r210 = null;
    L103:
        r114 = null;
    L98:
        r113 = null;
    L93:
        r112 = null;
    L87:
        r110 = r21;
        goto L88
    L81:
        r20 = null;
        goto L82
    L66:
        r16 = null;
    L71:
        r17 = r16;
        goto L73
    L72:
        r17 = r15;
        goto L73
    L40:
        String r35 = h(r24, MusicAppletPage.KEY_SOURCE);
        if (r35 == null) goto L55;
        int r36 = r35.hashCode();
        if (r36 != (-2133883658)) goto L45;
        String r37 = "action_bar_schema";
    L54:
        r35.equals(r37);
        goto L55
    L45:
        if (r36 != (-180266685)) goto L47;
        r37 = MusicAppletPage.SOURCE_TEMPLATE_LIST;
        goto L54
    L47:
        if (r36 != 1619589015) goto L55;
        String r38 = "chat_card";
        if (r35.equals("chat_card") == false) goto L55;
    L56:
        r12 = r38;
    L55:
        r38 = "action_bar";
        goto L56
    L28:
        r8 = null;
        goto L29
    L25:
        r7 = null;
        goto L26
    L21:
        r6 = r29;
        goto L23
    L17:
        r5 = r28;
        goto L19
    L13:
        r4 = r27;
        goto L15
    L9:
        r3 = r26;
        goto L11
    L5:
        r1 = r25;
        goto L7
    }
}

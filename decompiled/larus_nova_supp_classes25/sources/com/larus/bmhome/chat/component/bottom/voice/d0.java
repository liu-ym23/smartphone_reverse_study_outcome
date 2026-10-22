package com.larus.bmhome.chat.component.bottom.voice;

import android.net.Uri;
import androidx.collection.LruCache;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import yc9.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d0 {
    public static final /* synthetic */ int d = 0;
    public final t1a.b a;
    public long b;
    public boolean c;

    public static final class a {
        public static void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            FLogger.a.i("VoiceMixInput", r2);
        }
    }

    static {
    }

    public d0(t1a.b r2) {
        Intrinsics.checkNotNullParameter(r2, "vContext");
        this.a = r2;
    }

    public static String b(t1a.b r5) {
        g1 r6 = r5.getAbility(g1.class);
        String r0 = null;
        if (r6 == null) goto L25;
        String r1 = r6.uM();
        if (r1 == null) goto L25;
        NestedFileContent r7 = r6.b6(r1);
        if (r7 == null) goto L20;
        v0.g(r7);
        List r8 = r7.getEntities();
        if (r8 == null) goto L18;
        UplinkFileEntity r9 = (UplinkFileEntity) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L18;
        Uri r10 = r9.getUri();
        if (r10 == null) goto L18;
        String r11 = r10.toString();
        if (r11 == null) goto L18;
        String r12 = (String) com.larus.utils.l.b(r11, "image_from_scene");
    L19:
        boolean r3 = CollectionsKt.contains(CollectionsKt.listOf(new String[]{"shoot", "shoot_ocr"}), r12);
        boolean r13 = CollectionsKt.contains(CollectionsKt.listOf(new String[]{"album", "album_ocr"}), r12);
    L21:
        if (r13 == false) goto L23;
        r0 = "album";
        goto L25
    L23:
        if (r3 == false) goto L25;
        r0 = "shoot";
    L18:
        r12 = null;
        goto L19
    L20:
        r3 = false;
        r13 = false;
    L25:
        if (r0 != null) goto L28;
        return "keyboard";
    L28:
        return r0;
    }

    public static String a(wc9.e r2, BotModel r3) {
        LruCache r0 = ko8.a.a;
        String r1 = null;
        if (r2 == null) goto L5;
        Integer r4 = r2.v;
    L6:
        if (r3 == null) goto L8;
        Integer r5 = r3.getBotType();
    L9:
        if (r3 == null) goto L14;
        BotCreatorInfo r6 = r3.getBotCreatorInfo();
        if (r6 == null) goto L14;
        r1 = r6.getId();
    L14:
        return ko8.a.f(r4, r5, Intrinsics.areEqual(r1, AccountService.a.getUserId()));
    L8:
        r5 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }

    public final void c(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "enterMethod");
        Intrinsics.checkNotNullParameter(r10, "inputPosition");
        if (this.c == false) goto L5;
        return;
    L5:
        this.c = true;
        this.b = System.currentTimeMillis();
        com.larus.bmhome.chat.component.cvs.y r0 = this.a.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        String r1 = null;
        if (r0 == null) goto L8;
        BotModel r2 = r0.j0();
    L9:
        if (r0 == null) goto L11;
        wc9.e r3 = r0.h();
    L12:
        com.larus.platform.service.o r4 = com.larus.platform.service.o.a;
        JSONObject r5 = new JSONObject();
        if (r2 == null) goto L15;
        String r6 = r2.getBotId();
    L16:
        String r7 = "";
        if (r6 != null) goto L19;
        r6 = "";
    L19:
        r5.put("bot_id", r6);
        r5.put("chat_type", a(r3, r2));
        r5.put("current_page", "chat");
        if (r3 == null) goto L22;
        r1 = r3.a;
    L22:
        if (r1 == null) goto L25;
        r7 = r1;
    L25:
        r5.put("conversation_id", r7);
        if (r3 == null) goto L32;
        String r8 = r3.B;
        if (r8 == null) goto L32;
        Long r11 = StringsKt.toLongOrNull(r8);
        if (r11 == null) goto L32;
        long r12 = r11.longValue();
    L33:
        r5.put("section_id", r12);
        r5.put("enter_method", r9);
        r5.put("scene", b(this.a));
        r5.put("input_position", r10);
        Unit r13 = Unit.INSTANCE;
        r4.reportEvent("audio_complement_click", r5);
        return;
    L32:
        r12 = 0;
        goto L33
    L15:
        r6 = null;
        goto L16
    L11:
        r3 = null;
        goto L12
    L8:
        r2 = null;
        goto L9
    }

    public static /* synthetic */ void e(d0 r6, int r7, int r8, String r9, String r10) {
        r6.d(r7, r8, r9, r10, "end");
    }

    public final void d(int r9, int r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "enterMethod");
        Intrinsics.checkNotNullParameter(r12, "endMethod");
        Intrinsics.checkNotNullParameter(r13, "inputPosition");
        if (this.c == true) goto L5;
        return;
    L5:
        this.c = false;
        com.larus.bmhome.chat.component.cvs.y r0 = this.a.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        String r1 = null;
        if (r0 == null) goto L8;
        BotModel r2 = r0.j0();
    L9:
        if (r0 == null) goto L11;
        wc9.e r3 = r0.h();
    L12:
        com.larus.platform.service.o r4 = com.larus.platform.service.o.a;
        JSONObject r5 = new JSONObject();
        if (r2 == null) goto L15;
        String r6 = r2.getBotId();
    L16:
        String r7 = "";
        if (r6 != null) goto L19;
        r6 = "";
    L19:
        r5.put("bot_id", r6);
        r5.put("chat_type", a(r3, r2));
        r5.put("current_page", "chat");
        if (r3 == null) goto L22;
        r1 = r3.a;
    L22:
        if (r1 == null) goto L25;
        r7 = r1;
    L25:
        r5.put("conversation_id", r7);
        if (r3 == null) goto L32;
        String r8 = r3.B;
        if (r8 == null) goto L32;
        Long r14 = StringsKt.toLongOrNull(r8);
        if (r14 == null) goto L32;
        long r15 = r14.longValue();
    L33:
        r5.put("section_id", r15);
        r5.put("is_cover_keyboard", "1");
        r5.put("scene", b(this.a));
        r5.put("enter_method", r11);
        r5.put("end_method", r12);
        r5.put("user_content_length", r9);
        r5.put("user_speaking_content_length", r10);
        r5.put("user_speaking_duration", System.currentTimeMillis() - this.b);
        r5.put("input_position", r13);
        Unit r16 = Unit.INSTANCE;
        r4.reportEvent("audio_complement_end", r5);
        return;
    L32:
        r15 = 0;
        goto L33
    L15:
        r6 = null;
        goto L16
    L11:
        r3 = null;
        goto L12
    L8:
        r2 = null;
        goto L9
    }
}

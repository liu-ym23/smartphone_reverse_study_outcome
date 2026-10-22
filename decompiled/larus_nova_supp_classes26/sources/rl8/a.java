package rl8;

import androidx.collection.LruCache;
import com.larus.bmhome.bigimg.m1;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.gallery.api.GalleryType;
import com.larus.gallery.api.IGalleryDataSource;
import com.larus.gallery.api.b0;
import com.larus.gallery.api.m;
import com.larus.gallery.api.q;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements IGalleryDataSource<ty8.b> {
    public final ty8.a a;
    public final List<List<com.larus.bmhome.bigimg.l>> b;
    public final JSONObject c;

    public final boolean b() {
        return false;
    }

    public final boolean h() {
        return true;
    }

    public final int k() {
        return 0;
    }

    public final Object c(Continuation<? super b0<? extends List<ty8.b>>> r22) {
        if (this.b.isEmpty() == true) goto L5;
        List r1 = CollectionsKt.flatten(this.b);
    L6:
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L71;
        com.larus.bmhome.bigimg.l r4 = (com.larus.bmhome.bigimg.l) r3.next();
        String r5 = r4.b;
        String r6 = r4.d;
        q0 r7 = this.a.e;
        String r8 = null;
        if (r7 == null) goto L16;
        q0.a r9 = r7.getProvider();
        if (r9 == null) goto L16;
        y r10 = r9.u0();
        if (r10 == null) goto L16;
        wc9.e r11 = r10.h();
    L17:
        BotModel r12 = this.a.a;
        JSONObject r13 = this.c;
        if (r13 == null) goto L20;
        JSONObject r14 = new JSONObject(r13.toString());
    L21:
        JSONObject r15 = r14;
        r15.put("user_type", "bot");
        r15.put("enter_picture_method", "chat");
        r15.put("enter_from", "chat");
        Message r16 = this.a.b;
        if (r16 == null) goto L24;
        String r17 = r16.getMessageId();
    L25:
        String r18 = "";
        if (r17 != null) goto L28;
        r17 = "";
    L28:
        r15.put(MusicAppletPage.KEY_MESSAGE_ID, r17);
        Message r19 = this.a.b;
        if (r19 == null) goto L31;
        String r20 = r19.getReplyId();
    L32:
        if (r20 != null) goto L34;
        r20 = "";
    L34:
        r15.put("reply_id", r20);
        if (r11 == null) goto L38;
        String r21 = r11.a;
        if (r21 == null) goto L38;
    L39:
        r15.put(MusicAppletPage.KEY_CONVERSATION_ID, r21);
        if (r12 == null) goto L45;
        String r23 = r12.getBotId();
        if (r23 == null) goto L45;
        r18 = r23;
    L45:
        r15.put("bot_id", r18);
        Message r24 = this.a.b;
        if (r24 == null) goto L48;
        String r25 = com.larus.bmhome.chat.bean.d.x(r24).getReqId();
    L49:
        r15.putOpt("req_id", r25);
        r15.putOpt("doc_id", r4.k);
        LruCache<String, wc9.e> r26 = ko8.a.a;
        if (r11 == null) goto L52;
        Integer r27 = r11.v;
    L53:
        if (r12 == null) goto L55;
        Integer r28 = r12.getBotType();
    L56:
        if (r12 == null) goto L60;
        BotCreatorInfo r29 = r12.getBotCreatorInfo();
        if (r29 == null) goto L60;
        r8 = r29.getId();
    L60:
        r15.put("chat_type", ko8.a.f(r27, r28, Intrinsics.areEqual(r8, AccountService.a.getUserId())));
        r15.put("current_page", "picture_detail");
        String r30 = r4.a;
        if (r30 == null) goto L64;
        r15.put("pic_id", r30);
    L64:
        if (r15.has("rich_media_type") == true) goto L66;
        r15.put("rich_media_type", "mixed_picture");
    L66:
        ty8.b r110 = new ty8.b(this.a.b, new m1(r5, r6, null, null, null, null, 60), null, GalleryType.Image, r15, null, r4.a, r4.j, 588);
        r110.j.put("chat_gallery_data_scene", "main_bot");
        r110.j.put("chat_gallery_data_tos_key", r4.c);
        String r31 = r4.i;
        if (r31 == null) goto L69;
        r110.j.put("chat_gallery_data_source_url", r31);
    L69:
        r2.add(r110);
        goto L8
    L55:
        r28 = null;
        goto L56
    L52:
        r27 = null;
        goto L53
    L48:
        r25 = null;
    L38:
        r21 = "";
        goto L39
    L31:
        r20 = null;
        goto L32
    L24:
        r17 = null;
        goto L25
    L20:
        r14 = new JSONObject();
    L16:
        r11 = null;
        goto L17
    L71:
        return new b0.b(r2, false, false);
    L5:
        r1 = CollectionsKt.emptyList();
        goto L6
    }

    public final Object d(Object r1, Continuation r2) {
        ty8.b r3 = (ty8.b) r1;
        return IGalleryDataSource.DefaultImpls.a();
    }

    public final Object e(List<ty8.b> r1, Continuation<? super List<Pair<ty8.b, com.larus.gallery.api.k>>> r2) {
        return IGalleryDataSource.DefaultImpls.c(this, r1, r2);
    }

    public final Object f(Object r1, Continuation r2) {
        return (ty8.b) r1;
    }

    public final Object g(Object r1, Continuation r2) {
        ty8.b r3 = (ty8.b) r1;
        return IGalleryDataSource.DefaultImpls.b();
    }

    public final Object i(Object r22, Continuation r23) {
        ty8.b r0 = (ty8.b) r22;
        GalleryType r2 = r0.e;
        m1 r1 = r0.b;
        if (r1 == null) goto L5;
        String r4 = r1.a;
    L6:
        if (r1 == null) goto L8;
        String r5 = r1.b;
    L9:
        m r12 = new m(r4, r5, null, null, null, null, null, 508);
        nr9.g r3 = r0.c;
        if (r3 == null) goto L12;
        q r6 = new q(UUID.randomUUID().toString(), r3, 0, null, null, 60);
    L14:
        return new com.larus.gallery.api.k(r2, r12, r6, null, r0.a, 8);
    L12:
        r6 = null;
        goto L14
    L8:
        r5 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }

    public final boolean j(Object r1, Object r2) {
        return Intrinsics.areEqual((ty8.b) r1, (ty8.b) r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(ty8.a r2, List<? extends List<com.larus.bmhome.bigimg.l>> r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "galleryContext");
        Intrinsics.checkNotNullParameter(r3, "images");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}

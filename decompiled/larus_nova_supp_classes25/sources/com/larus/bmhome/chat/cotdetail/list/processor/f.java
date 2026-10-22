package com.larus.bmhome.chat.cotdetail.list.processor;

import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.interactionpanel.w;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f implements by7.e {
    public static final /* synthetic */ int f = 0;
    public final String a;
    public final Message b;
    public final String c;
    public final BotModel d;
    public final by7.e e;

    public static final class a {
        public static f a(Fragment r12, Message r13, BotModel r14) {
            Intrinsics.checkNotNullParameter(r13, "message");
            by7.e r1 = null;
            if (z2.a.enableMessageMenuTimestamp() == true) goto L6;
            return null;
        L6:
            if ((r12 instanceof fe8.a) == false) goto L8;
            fe8.a r0 = (fe8.a) r12;
        L9:
            if (r0 != null) goto L11;
            return null;
        L11:
            w r2 = r0.vF();
            if (r2 == null) goto L14;
            String r3 = r2.a;
        L15:
            if (r3 == null) goto L43;
            int r4 = r3.hashCode();
            String r5 = "organizer";
            if (r4 == (-2141605073)) goto L31;
            if (r4 == (-874443254)) goto L28;
            if (r4 != (-59919290)) goto L43;
            if (r3.equals("sub_agent") == false) goto L43;
            r5 = "subagent";
        L33:
            String r7 = r5;
            String r6 = r0.K();
            if (r6 != null) goto L38;
            r6 = r13.getConversationId();
            if (r6 != null) goto L38;
            r6 = "";
        L38:
            String r9 = r6;
            if ((r12 instanceof by7.e) == false) goto L42;
            r1 = (by7.e) r12;
        L42:
            return new f(r7, r13, r9, r14, r1);
        L28:
            if (r3.equals("thread") == true) goto L33;
        L31:
            if (r3.equals("organizer") == true) goto L33;
        L43:
            return null;
        L14:
            r3 = null;
            goto L15
        L8:
            r0 = null;
            goto L9
        }
    }

    static {
    }

    public final by7.e referrerTrackNode() {
        return null;
    }

    public final by7.e parentTrackNode() {
        return this.e;
    }

    public final void b(List<? extends ot8.a> r9) {
        Intrinsics.checkNotNullParameter(r9, "items");
        if (z2.a.enableMessageMenuTimestamp() == true) goto L5;
        return;
    L5:
        LruCache r0 = ko8.a.a;
        ko8.a.l(r9, this.b, this.d, this, "default", "long_press_answer", new JSONObject().put("show_module", this.a).put("conversation_id", this.c));
    }

    public final void fillTrackParams(TrackParams r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        if (z2.a.enableMessageMenuTimestamp() == true) goto L5;
        return;
    L5:
        r4.put("show_module", this.a);
        String r0 = this.b.getMessageId();
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        r4.put("message_id", r0);
        r4.put("conversation_id", this.c);
        String r1 = TrackParams.optString$default(r4, "select_range", null, 2, null);
        if (r1 != null) goto L11;
        return;
    L11:
        switch(r1.hashCode()) {
            case -1298275439: goto L30;
            case -939315361: goto L26;
            case 3655434: goto L23;
            case 728960751: goto L20;
            case 1262736995: goto L17;
            case 1949288814: goto L14;
            default: goto L36;
        };
    L36:
        return;
    L14:
        if (r1.equals("paragraph") == false) goto L37;
    L28:
        r4.put("select_range", "part");
        return;
    L37:
        return;
    L17:
        if (r1.equals("sentence") == true) goto L28;
        return;
    L20:
        if (r1.equals("custom_range") == true) goto L28;
        return;
    L23:
        if (r1.equals("word") == true) goto L28;
        return;
    L26:
        if (r1.equals("mark_text") == true) goto L28;
        return;
    L30:
        if (r1.equals("entire") == false) goto L42;
        r4.put("select_range", "all");
        return;
    }

    public final void a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "name");
        if (z2.a.enableMessageMenuTimestamp() == true) goto L5;
        return;
    L5:
        TrackParams r0 = new TrackParams();
        BotModel r1 = this.d;
        if (r1 == null) goto L8;
        String r2 = r1.getBotId();
    L9:
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        TrackParams r3 = r0.put("bot_id", r2).put("chat_type", "default").put("click_from", "long_press_answer");
        if (r5 == null) goto L14;
        r3.put("select_range", r5).put("content_type", ChatDraftItem.TYPE_TEXT);
    L14:
        by7.a r6 = new by7.a(r4);
        r6.b = this;
        r6.a.merge(r3);
        r6.b();
        return;
    L8:
        r2 = null;
        goto L9
    }

    public f(String r1, Message r2, String r3, BotModel r4, by7.e r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}

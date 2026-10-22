package km8;

import android.content.Context;
import android.os.Bundle;
import androidx.collection.LruCache;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.im.bean.bot.BotMemoryConfig;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.o;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g implements b {
    public final AttachReceiver a;
    public final Function0<ChatParam> b;
    public final Function0<BotModel> c;
    public final String d;
    public final by7.e e;
    public final q0 f;
    public final Lazy g;
    public final Lazy h;

    public g() {
        this(null, null, null, null, null, null, 63);
    }

    @Override // km8.b
    public final boolean a() {
        Function0<BotModel> r0 = this.c;
        if (r0 == null) goto L11;
        BotModel r1 = (BotModel) r0.invoke();
        if (r1 == null) goto L11;
        BotMemoryConfig r2 = r1.getBotMemoryConfig();
        if (r2 == null) goto L11;
        Boolean r3 = r2.getEnableBotMemory();
        if (r3 == null) goto L11;
    L23:
        return r3.booleanValue();
    L11:
        y r4 = (y) this.g.getValue();
        if (r4 == null) goto L18;
        BotModel r5 = r4.j0();
        if (r5 == null) goto L18;
        BotMemoryConfig r6 = r5.getBotMemoryConfig();
        if (r6 == null) goto L18;
        r3 = r6.getEnableBotMemory();
    L19:
        if (r3 != null) goto L23;
        return false;
    L18:
        r3 = null;
        goto L19
    }

    public final String e() {
        Function0<BotModel> r0 = this.c;
        if (r0 == null) goto L8;
        BotModel r1 = (BotModel) r0.invoke();
        if (r1 == null) goto L8;
        String r2 = r1.getBotId();
        if (r2 == null) goto L8;
        return r2;
    L8:
        y r3 = (y) this.g.getValue();
        if (r3 != null) goto L14;
        return null;
    L14:
        return r3.getBotId();
    }

    public final String f() {
        ChatParam r0 = (ChatParam) this.h.getValue();
        if (r0 == null) goto L5;
        String r1 = r0.d;
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    @Override // km8.b
    public final void c(Context r4, String r5) {
        com.bytedance.router.i r6 = SmartRouter.buildRoute(r4, "//flow/ltm_settings");
        Pair[] r0 = new Pair[4];
        r0[0] = TuplesKt.to("bot_id", e());
        String r1 = this.d;
        if (r1 != null) goto L8;
        y r2 = (y) this.g.getValue();
        if (r2 == null) goto L7;
        r1 = r2.Y1();
        goto L8
    L7:
        r1 = null;
    L8:
        r0[1] = TuplesKt.to("chat_ltm_conversation_id", r1);
        r0[2] = TuplesKt.to("chat_ltm_previous_page", f());
        r0[3] = TuplesKt.to("chat_ltm_target_memory_content", r5);
        Bundle r7 = com.larus.utils.f.c(r0);
        by7.e r3 = this.e;
        if (r3 == null) goto L11;
        by7.h.k(r7, r3);
    L11:
        r6.c.putExtras(r7);
        r6.c.addFlags(536870912);
        r6.d = 2130772401;
        r6.e = 2130772399;
        r6.d();
    }

    @Override // km8.b
    public final void b(String r43, int r44, Message r45) {
        Intrinsics.checkNotNullParameter(r43, "memoryStatus");
        ri8.c r1 = ri8.c.a;
        String r2 = null;
        if (r45 == null) goto L5;
        String r3 = r45.getMessageId();
    L7:
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        String r4 = this.d;
        if (r4 != null) goto L15;
        y r5 = (y) this.g.getValue();
        if (r5 == null) goto L14;
        r4 = r5.Y1();
        goto L15
    L14:
        r4 = null;
    L15:
        if (r45 == null) goto L17;
        String r6 = r45.getReplyId();
    L18:
        String r7 = f();
        ChatParam r8 = (ChatParam) this.h.getValue();
        if (r8 == null) goto L21;
        String r19 = r8.c;
    L22:
        String r27 = e();
        if (r45 == null) goto L25;
        r2 = com.larus.bmhome.chat.bean.d.x(r45).getReqId();
    L25:
        String r28 = r2;
        LruCache<String, wc9.e> r9 = ko8.a.a;
        String r10 = ko8.a.c(r45);
        if (r10 != null) goto L28;
        String r31 = "";
    L29:
        String r11 = ko8.a.d(r45);
        if (r11 != null) goto L32;
        String r41 = "";
    L33:
        ri8.c.m(null, r3, r4, r6, r7, r19, Integer.valueOf(r44), 1, "slideshow", "within_text", "memory_status", r27, null, null, null, null, null, null, r28, null, null, null, null, null, null, null, r31, r41, null, null, r43, null, null, null, null, null, null, null, -1275334655, 63);
        o r12 = o.a;
        JSONObject r13 = new JSONObject();
        r13.putOpt("current_page", f());
        r13.putOpt("memory_status", r43);
        Unit r14 = Unit.INSTANCE;
        r12.reportEvent("memory_detail_show", r13);
        return;
    L32:
        r41 = r11;
        goto L33
    L28:
        r31 = r10;
        goto L29
    L21:
        r19 = null;
        goto L22
    L17:
        r6 = null;
        goto L18
    L5:
        r3 = null;
        goto L7
    }

    @Override // km8.b
    public final void d(String r43, int r44, Message r45) {
        Intrinsics.checkNotNullParameter(r43, "memoryStatus");
        ri8.c r1 = ri8.c.a;
        q0 r2 = this.f;
        if (r2 == null) goto L6;
        LruSet r3 = r2.E7();
        if (r3 == null) goto L6;
    L7:
        String r4 = null;
        if (r45 == null) goto L10;
        String r5 = r45.getMessageId();
    L11:
        String r6 = this.d;
        if (r6 != null) goto L17;
        y r7 = (y) this.g.getValue();
        if (r7 == null) goto L16;
        r6 = r7.Y1();
        goto L17
    L16:
        r6 = null;
    L17:
        if (r45 == null) goto L19;
        String r8 = r45.getReplyId();
    L20:
        String r9 = f();
        ChatParam r10 = (ChatParam) this.h.getValue();
        if (r10 == null) goto L23;
        String r11 = r10.c;
    L24:
        String r19 = e();
        if (r45 == null) goto L27;
        r4 = com.larus.bmhome.chat.bean.d.x(r45).getReqId();
    L27:
        String r28 = r4;
        LruCache<String, wc9.e> r12 = ko8.a.a;
        String r13 = ko8.a.c(r45);
        if (r13 != null) goto L30;
        String r29 = "";
    L31:
        String r14 = ko8.a.d(r45);
        if (r14 != null) goto L34;
        String r33 = "";
    L35:
        ri8.c.n(r3, null, r5, r6, r8, r9, r11, Integer.valueOf(r44), 1, "slideshow", "within_text", "memory_status", r19, null, null, null, null, r28, null, null, null, null, null, null, null, null, r29, r33, null, null, null, r43, null, null, null, null, null, null, 1946017794, 63);
        return;
    L34:
        r33 = r14;
        goto L35
    L30:
        r29 = r13;
        goto L31
    L23:
        r11 = null;
        goto L24
    L19:
        r8 = null;
        goto L20
    L10:
        r5 = null;
    L6:
        r3 = new LruSet(1);
        goto L7
    }

    public g(AttachReceiver r3, Function0 r4, Function0 r5, String r6, by7.e r7, q0 r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r7 = null;
    L18:
        if ((r9 & 32) == 0) goto L20;
        r8 = null;
    L20:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = LazyKt.lazy(new c(this));
        this.h = LazyKt.lazy(new d(this));
    }
}

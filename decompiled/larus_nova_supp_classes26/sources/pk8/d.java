package pk8;

import android.content.Context;
import com.larus.bmhome.chat.ChatParam;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ResearchProcessBlock;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ne8.k;
import ok8.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public pk8.a a;
    public e b;
    public final Lazy c;

    public static final class a {
    }

    public static final class b implements g {
        public final /* synthetic */ d a;

        @Override // ok8.g
        public final void a() {
            pk8.a r0 = this.a.a;
            if (r0 == null) goto L6;
            r0.a();
            return;
        }

        /* JADX WARN: Type inference failed for: r5v1, types: [pk8.c] */
        public final void c() {
            final d r0 = this.a;
            e r1 = r0.b;
            String r2 = null;
            if (r1 == null) goto L5;
            final Message r3 = r1.c;
        L6:
            if (r1 == null) goto L28;
            final ResearchProcessBlock r4 = r1.b;
            if (r4 == null) goto L31;
            pk8.a r5 = r0.a;
            if (r5 == null) goto L13;
            Set<Object> r6 = r5.c();
        L14:
            StringBuilder r7 = new StringBuilder("deep_research_progress_card_show_");
            if (r3 == null) goto L17;
            r2 = r3.getMessageId();
        L17:
            r7.append(r2);
            String r8 = r7.toString();
            ?? r9 = new c(r0, r3, r4);
            if (r6 == null) goto L22;
            boolean r10 = true;
            if (r6.contains(r8) != true) goto L22;
        L23:
            if (r10 == true) goto L29;
            r9.invoke();
            if (r6 == null) goto L30;
            r6.add(r8);
            return;
        L30:
            return;
        L29:
            return;
        L22:
            r10 = false;
            goto L23
        L13:
            r6 = null;
            goto L14
        L31:
            return;
        L28:
            return;
        L5:
            r3 = null;
            goto L6
        }

        public b(d r1) {
            this.a = r1;
        }

        @Override // ok8.g
        public final void b(Context r55) {
            Intrinsics.checkNotNullParameter(r55, "context");
            e r1 = this.a.b;
            if (r1 == null) goto L73;
            ResearchProcessBlock r2 = r1.b;
            if (r2 == null) goto L74;
            String r3 = r2.getResourceId();
            boolean r4 = true;
            if (r3 != null) goto L10;
        L13:
            boolean r5 = true;
        L14:
            if (r5 == false) goto L16;
            return;
        L16:
            pk8.a r6 = this.a.a;
            String r11 = null;
            if (r6 == null) goto L19;
            BotModel r7 = r6.B0();
        L20:
            pk8.a r8 = this.a.a;
            if (r8 == null) goto L23;
            Long r9 = r8.b();
        L24:
            e r10 = this.a.b;
            if (r10 == null) goto L27;
            Message r12 = r10.c;
        L28:
            int r13 = k.a;
            String r14 = r2.getResourceId();
            if (r14 != null) goto L31;
            r14 = "";
        L31:
            String r15 = r2.getResourceId();
            if (r15 != null) goto L34;
        L36:
            r4 = false;
        L37:
            if (r12 == null) goto L39;
            String r16 = r12.getConversationId();
        L40:
            k.b(r55, r14, r4, r12, r16, r7, r9, r2.title, "dr_process_card");
            pk8.a r17 = this.a.a;
            if (r17 == null) goto L43;
            ChatParam r18 = r17.getChatParam();
        L44:
            ri8.c r19 = ri8.c.a;
            if (r12 == null) goto L47;
            String r25 = r12.getSenderId();
        L48:
            if (r18 == null) goto L50;
            String r110 = r18.d;
        L51:
            if (r12 == null) goto L55;
            Map r20 = r12.getExt();
            if (r20 == null) goto L55;
            String r21 = (String) r20.get("deep_research_id");
        L56:
            if (r21 != null) goto L58;
            String r37 = "";
        L59:
            String r22 = r2.title;
            if (r12 == null) goto L62;
            String r111 = r12.getMessageId();
        L63:
            if (r12 == null) goto L65;
            String r112 = r12.getConversationId();
        L66:
            if (r12 == null) goto L68;
            String r113 = r12.getReplyId();
        L69:
            if (r18 == null) goto L71;
            r11 = r18.c;
        L71:
            ri8.c.m(null, r111, r112, r113, r110, r11, null, null, null, null, "dr_process_card", r25, null, null, "unfold", null, null, null, null, null, null, null, null, r37, r22, null, null, null, null, null, null, null, null, null, null, null, null, null, -25185792, 63);
            return;
        L68:
            r113 = null;
            goto L69
        L65:
            r112 = null;
            goto L66
        L62:
            r111 = null;
            goto L63
        L58:
            r37 = r21;
        L55:
            r21 = null;
            goto L56
        L50:
            r110 = null;
            goto L51
        L47:
            r25 = null;
            goto L48
        L43:
            r18 = null;
            goto L44
        L39:
            r16 = null;
            goto L40
        L34:
            if (StringsKt.contains$default(r15, "report", false, 2, null) == true) goto L36;
        L27:
            r12 = null;
            goto L28
        L23:
            r9 = null;
            goto L24
        L19:
            r7 = null;
            goto L20
        L10:
            if (r3.length() == 0) goto L13;
            r5 = false;
            goto L14
        L74:
            return;
        }
    }

    static {
    }

    public d() {
        this.c = LazyKt.lazy(new pk8.b(this));
    }
}

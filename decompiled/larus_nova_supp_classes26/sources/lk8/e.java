package lk8;

import android.content.Context;
import com.larus.bmhome.chat.ChatParam;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ResearchBlock;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import ne8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public lk8.a a;
    public b b;
    public final Lazy c;

    public static final class a implements kk8.e {
        public final /* synthetic */ e a;

        /* JADX WARN: Type inference failed for: r4v2, types: [lk8.c] */
        public final void c() {
            final e r0 = this.a;
            lk8.a r1 = r0.a;
            if (r1 == null) goto L22;
            final Message r2 = r1.a;
            if (r2 == null) goto L25;
            b r3 = r0.b;
            if (r3 == null) goto L10;
            Set<Object> r4 = r3.c();
        L11:
            String r5 = "deep_research_card_show_" + r2.getMessageId();
            ?? r6 = new c(r0, r2);
            if (r4 == null) goto L16;
            boolean r7 = true;
            if (r4.contains(r5) != true) goto L16;
        L17:
            if (r7 == true) goto L23;
            r6.invoke();
            if (r4 == null) goto L24;
            r4.add(r5);
            return;
        L24:
            return;
        L23:
            return;
        L16:
            r7 = false;
            goto L17
        L10:
            r4 = null;
            goto L11
        L25:
            return;
        }

        public a(e r1) {
            this.a = r1;
        }

        @Override // kk8.e
        public final void a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            b r3 = this.a.b;
            if (r3 == null) goto L6;
            r3.a();
            return;
        }

        @Override // kk8.e
        public final void b(Context r54) {
            Intrinsics.checkNotNullParameter(r54, "context");
            lk8.a r1 = this.a.a;
            if (r1 == null) goto L50;
            ResearchBlock r3 = r1.d;
            if (r3 == null) goto L51;
            Message r2 = r1.a;
            if (r2 == null) goto L52;
            String r4 = r3.getResourceId();
            if (r4 != null) goto L13;
        L16:
            boolean r5 = true;
        L17:
            if (r5 == false) goto L19;
            return;
        L19:
            b r6 = this.a.b;
            String r11 = null;
            if (r6 == null) goto L22;
            BotModel r7 = r6.B0();
        L23:
            b r8 = this.a.b;
            if (r8 == null) goto L26;
            Long r9 = r8.b();
        L27:
            int r10 = k.a;
            String r12 = r3.getResourceId();
            if (r12 != null) goto L30;
            r12 = "";
        L30:
            k.b(r54, r12, false, r2, r2.getConversationId(), r7, r9, null, "dr_report_card");
            b r13 = this.a.b;
            if (r13 == null) goto L33;
            ChatParam r14 = r13.getChatParam();
        L34:
            ri8.c r15 = ri8.c.a;
            String r24 = r2.getSenderId();
            if (r14 == null) goto L37;
            String r17 = r14.d;
        L38:
            Map r16 = r2.getExt();
            if (r16 == null) goto L41;
            String r18 = (String) r16.get("deep_research_id");
        L42:
            if (r18 != null) goto L44;
            String r36 = "";
        L45:
            String r19 = r2.getMessageId();
            String r110 = r2.getConversationId();
            String r111 = r2.getReplyId();
            if (r14 == null) goto L48;
            r11 = r14.c;
        L48:
            ri8.c.m(null, r19, r110, r111, r17, r11, null, null, null, null, "dr_report_card", r24, null, null, "unfold", null, null, null, null, null, null, null, null, r36, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -8408576, 63);
            return;
        L44:
            r36 = r18;
            goto L45
        L41:
            r18 = null;
            goto L42
        L37:
            r17 = null;
            goto L38
        L33:
            r14 = null;
            goto L34
        L26:
            r9 = null;
            goto L27
        L22:
            r7 = null;
            goto L23
        L13:
            if (r4.length() == 0) goto L16;
            r5 = false;
            goto L17
        L52:
            return;
        L51:
            return;
        }
    }

    public e() {
        this.c = LazyKt.lazy(new d(this));
    }
}

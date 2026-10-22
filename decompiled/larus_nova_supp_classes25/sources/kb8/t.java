package kb8;

import com.larus.bmhome.chat.ChatParam;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.RecommendFrom;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t implements p {
    public final kc8.b a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;

    public t(kc8.b r1) {
        this.a = r1;
        this.b = LazyKt.lazy(new q(this));
        this.c = LazyKt.lazy(new r(this));
        this.d = LazyKt.lazy(new s(this));
    }

    public final BotModel c(Message r71) {
        kc8.b r1 = this.a;
        if (r1 == null) goto L10;
        y r2 = r1.a;
        if (r2 == null) goto L10;
        Function0<BotModel> r3 = r2.l;
        if (r3 == null) goto L10;
        BotModel r4 = (BotModel) r3.invoke();
        if (r4 == null) goto L10;
    L14:
        return r4;
    L10:
        String r5 = r71.getSenderId();
        if (r5 != null) goto L13;
        r5 = "unknown";
    L13:
        r4 = new BotModel(r5, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
        goto L14
    }

    @Override // kb8.p
    public final void a(String r24, String r25, int r26, Message r27, String r28) {
        Intrinsics.checkNotNullParameter(r24, "cardId");
        Intrinsics.checkNotNullParameter(r27, "message");
        int r2 = oi8.n.a;
        ChatParam r3 = (ChatParam) this.c.getValue();
        String r4 = c(r27).getBotId();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        String r7 = r4;
        de8.c r5 = (de8.c) this.d.getValue();
        if (r5 == null) goto L8;
        String r9 = ve8.c.b(r5.C());
    L9:
        de8.c r6 = (de8.c) this.d.getValue();
        if (r6 == null) goto L14;
        RecommendFrom r8 = r6.d;
        if (r8 == null) goto L14;
        String r10 = r8.c;
    L15:
        de8.c r11 = (de8.c) this.d.getValue();
        if (r11 == null) goto L20;
        RecommendFrom r12 = r11.d;
        if (r12 == null) goto L20;
        String r13 = r12.b;
    L21:
        String r14 = (String) this.b.getValue();
        if (r14 != null) goto L24;
        r14 = "other_default";
    L24:
        oi8.n.a(r27, r3, Integer.valueOf(r26), null, r24, "link", r7, "open_media", r9, r10, r13, r14, null, null, null, r25, null, null, null, null, r28, 2023688);
        return;
    L20:
        r13 = null;
    L14:
        r10 = null;
        goto L15
    L8:
        r9 = null;
        goto L9
    }

    @Override // kb8.p
    public final void b(String r20, String r21, String r22, int r23, Message r24, String r25) {
        Intrinsics.checkNotNullParameter(r20, "cardId");
        Intrinsics.checkNotNullParameter(r24, "message");
        int r2 = oi8.n.a;
        ChatParam r3 = (ChatParam) this.c.getValue();
        String r4 = c(r24).getBotId();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        String r7 = r4;
        oi8.n.b(r24, r3, Integer.valueOf(r23), null, r20, "link", r7, null, null, null, r21, r22, null, null, null, null, r25, 124808);
    }
}

package il8;

import android.view.View;
import android.view.ViewGroup;
import androidx.collection.LruCache;
import cb8.x1;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.chat.standarduikit.generictool.view.GenericToolView;
import com.larus.bmhome.chat.standarduikit.generictool.view.GenericToolViewStage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.GenericToolBlock;
import jl8.f;
import jl8.g;
import kc8.x;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends jc8.b<il8.a> {
    public hl8.c d;
    public kc8.b e;
    public final Lazy f;

    public static final class a implements kl8.b {
        public kc8.b a;

        @Override // kl8.b
        public final void a() {
        }

        public a(kc8.b r1) {
            this.a = r1;
        }

        @Override // kl8.b
        public final void b(Message r44, String r45, int r46) {
            ri8.c r1 = ri8.c.a;
            kc8.b r2 = this.a;
            if (r2 == null) goto L8;
            y r3 = r2.a;
            if (r3 == null) goto L8;
            LruSet r4 = r3.y;
            if (r4 == null) goto L8;
        L9:
            LruSet r5 = r4;
            String r6 = null;
            if (r44 == null) goto L12;
            String r7 = r44.getMessageId();
        L13:
            kc8.b r8 = this.a;
            if (r8 == null) goto L20;
            y r9 = r8.a;
            if (r9 == null) goto L20;
            Function0 r10 = r9.f;
            if (r10 == null) goto L20;
            String r11 = (String) r10.invoke();
        L21:
            if (r44 == null) goto L23;
            String r12 = r44.getReplyId();
        L24:
            kc8.b r13 = this.a;
            if (r13 == null) goto L33;
            y r14 = r13.a;
            if (r14 == null) goto L33;
            Function0 r15 = r14.m;
            if (r15 == null) goto L33;
            ChatParam r16 = (ChatParam) r15.invoke();
            if (r16 == null) goto L33;
            String r17 = r16.d;
        L35:
            if (r17 != null) goto L37;
            String r18 = "";
        L38:
            kc8.b r19 = this.a;
            if (r19 == null) goto L47;
            y r20 = r19.a;
            if (r20 == null) goto L47;
            Function0 r21 = r20.m;
            if (r21 == null) goto L47;
            ChatParam r22 = (ChatParam) r21.invoke();
            if (r22 == null) goto L47;
            String r110 = r22.c;
        L48:
            kc8.b r23 = this.a;
            if (r23 == null) goto L57;
            y r24 = r23.a;
            if (r24 == null) goto L57;
            Function0 r25 = r24.l;
            if (r25 == null) goto L57;
            BotModel r26 = (BotModel) r25.invoke();
            if (r26 == null) goto L57;
            String r27 = r26.getBotId();
        L58:
            if (r44 == null) goto L60;
            r6 = com.larus.bmhome.chat.bean.d.x(r44).getReqId();
        L60:
            LruCache<String, e> r28 = ko8.a.a;
            String r29 = ko8.a.c(r44);
            if (r29 != null) goto L63;
            String r210 = "";
        L64:
            ri8.c.n(r5, null, r7, r11, r12, r18, r110, Integer.valueOf(r46), 1, "slideshow", "within_text", "tool_card", r27, null, null, null, null, r6, null, null, null, null, null, null, null, null, r210, null, r45, null, null, null, null, null, null, null, null, null, -335683582, 63);
            return;
        L63:
            r210 = r29;
        L57:
            r27 = null;
        L47:
            r110 = null;
            goto L48
        L37:
            r18 = r17;
        L33:
            r17 = null;
            goto L35
        L23:
            r12 = null;
        L20:
            r11 = null;
            goto L21
        L12:
            r7 = null;
        L8:
            r4 = new LruSet(1);
            goto L9
        }
    }

    public final String c() {
        return "GenericToolBlockHolder";
    }

    public d() {
        this.f = LazyKt.lazy(new c(this));
    }

    public final jc8.d f(jc8.a r2) {
        il8.a r3 = (il8.a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return jc8.e.d(r3);
    }

    public final void g(jc8.a r29) {
        il8.a r1 = (il8.a) r29;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        this.e = jc8.c.a(this, kc8.b.class);
        ((a) this.f.getValue()).a = this.e;
        BlockContent r2 = ((jc8.a) r1).a.getContent();
        Function0 r3 = null;
        if (r2 == null) goto L5;
        GenericToolBlock r7 = r2.getGenericToolBlock();
    L6:
        int r9 = x1.b(((jc8.b) this).a, r1, il8.a.class);
        boolean r11 = false;
        Pair r5 = new Pair(0, 0);
        Message r6 = r1.j();
        boolean r8 = b.a(r1);
        kc8.b r4 = this.e;
        if (r4 == null) goto L11;
        x r10 = r4.i;
        if (r10 == null) goto L11;
        Integer r12 = r10.a;
    L12:
        kl8.a r13 = new kl8.a(r5, r6, r7, r8, r9, r12);
        hl8.c r14 = this.d;
        if (r14 == null) goto L38;
        a r15 = (a) this.f.getValue();
        Intrinsics.checkNotNullParameter(r13, "vmData");
        kl8.e r16 = (kl8.e) r14.c.getValue();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r13, "vmData");
        r16.a = r13;
        r16.b = r15;
        kl8.a r17 = ((kl8.e) r14.c.getValue()).a;
        if (r17 != null) goto L17;
        f r18 = new f(null, null, null, null, null, null, 0, null, false, false, false, 0, 0, 0, 16383);
    L29:
        final kl8.e r19 = (kl8.e) r14.c.getValue();
        r19.getClass();
        Function0 r20 = new kl8.c(r19);
        kl8.a r21 = r19.a;
        if (r21 != null) goto L32;
    L34:
        if (r11 == false) goto L36;
        r3 = new kl8.d(r19);
    L36:
        ((GenericToolView) r14.b.getValue()).a(r18, new g(r20, r3));
        return;
    L32:
        if (r21.h != true) goto L34;
        r11 = true;
        goto L34
    L17:
        GenericToolBlock r22 = r17.c;
        if (r22 != null) goto L21;
        r18 = new f(null, null, null, null, null, null, 0, null, false, false, false, 0, 0, 0, 16383);
        goto L29
    L21:
        if (r17.d == false) goto L23;
        GenericToolViewStage r23 = GenericToolViewStage.FINISHED;
    L24:
        GenericToolViewStage r110 = r23;
        String r111 = r22.iconUrl;
        String r112 = r22.iconUrlDark;
        String r113 = r22.title;
        Pair<Integer, Integer> r24 = r17.a;
        Message r25 = r17.b;
        if (r25 == null) goto L27;
        String r114 = r25.getMessageId();
    L28:
        r18 = new f(r111, r112, r113, r110, r24, r114, r17.e, r17.f, r17.g, false, false, 0, 0, 0, 15872);
        goto L29
    L27:
        r114 = null;
        goto L28
    L23:
        r23 = GenericToolViewStage.LOADING;
        goto L24
    L38:
        return;
    L11:
        r12 = null;
        goto L12
    L5:
        r7 = null;
        goto L6
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        hl8.c r0 = new hl8.c(r2.getContext());
        this.d = r0;
        return (GenericToolView) r0.b.getValue();
    }
}

package jk8;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.e5;
import com.larus.bmhome.chat.standarduikit.deepresearchcard.view.DeepResearchCardView;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.ResearchBlock;
import java.util.Set;
import jc8.d;
import jc8.e;
import kc8.y;
import kc8.z;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c extends jc8.b<jk8.a> {
    public ik8.b d;
    public kc8.b e;
    public final Lazy f;

    public static final class a implements lk8.b {
        public final /* synthetic */ c a;

        @Override // lk8.b
        public final BotModel B0() {
            kc8.b r0 = this.a.e;
            if (r0 == null) goto L9;
            y r1 = r0.a;
            if (r1 == null) goto L9;
            Function0 r2 = r1.l;
            if (r2 == null) goto L9;
            return (BotModel) r2.invoke();
        L9:
            return null;
        }

        @Override // lk8.b
        public final void a() {
            kc8.b r0 = this.a.e;
            if (r0 == null) goto L10;
            y r1 = r0.a;
            if (r1 == null) goto L11;
            z r2 = r1.A;
            if (r2 == null) goto L12;
            z.a.a(r2, null, null, 7);
            return;
        L12:
            return;
        L11:
            return;
        }

        @Override // lk8.b
        public final Long b() {
            kc8.b r0 = this.a.e;
            if (r0 == null) goto L11;
            y r1 = r0.a;
            if (r1 == null) goto L11;
            Function0 r2 = r1.o;
            if (r2 == null) goto L11;
            de8.c r3 = (de8.c) r2.invoke();
            if (r3 == null) goto L11;
            return Long.valueOf(r3.n);
        L11:
            return null;
        }

        @Override // lk8.b
        public final Set<Object> c() {
            kc8.b r0 = this.a.e;
            if (r0 == null) goto L11;
            y r1 = r0.a;
            if (r1 == null) goto L11;
            q0 r2 = r1.x;
            if (r2 == null) goto L11;
            ChatMessageList r3 = r2.B7();
            if (r3 == null) goto L11;
            Object r4 = r3.getTag(2131384073);
        L13:
            if (TypeIntrinsics.isMutableSet(r4) == true) goto L15;
            return null;
        L15:
            return (Set) r4;
        L11:
            r4 = null;
            goto L13
        }

        @Override // lk8.b
        public final ChatParam getChatParam() {
            kc8.b r0 = this.a.e;
            if (r0 == null) goto L9;
            y r1 = r0.a;
            if (r1 == null) goto L9;
            Function0 r2 = r1.m;
            if (r2 == null) goto L9;
            return (ChatParam) r2.invoke();
        L9:
            return null;
        }

        public a(c r1) {
            this.a = r1;
        }
    }

    public final String c() {
        return "ResearchBlockHolder";
    }

    public c() {
        this.f = LazyKt.lazy(new b(this));
    }

    public final d f(jc8.a r2) {
        jk8.a r3 = (jk8.a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    public final void g(jc8.a r59) {
        jk8.a r1 = (jk8.a) r59;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        this.e = jc8.c.a(this, kc8.b.class);
        ik8.b r2 = this.d;
        if (r2 == null) goto L45;
        cd8.a r3 = jc8.c.a(this, cd8.a.class);
        if (r3 == null) goto L7;
        int r10 = r3.a;
    L8:
        kc8.b r4 = this.e;
        if (r4 == null) goto L17;
        y r5 = r4.a;
        if (r5 == null) goto L17;
        Function0 r6 = r5.p;
        if (r6 == null) goto L17;
        e5 r7 = (e5) r6.invoke();
        if (r7 == null) goto L17;
        boolean r11 = r7.e;
    L18:
        Message r8 = r1.j();
        boolean r9 = r1.m();
        boolean r12 = r1.n();
        BlockContent r13 = ((jc8.a) r1).a.getContent();
        ResearchBlock r14 = null;
        if (r13 == null) goto L21;
        ResearchBlock r15 = r13.getResearchBlock();
    L22:
        lk8.a r16 = new lk8.a(r8, r9, r12, r15, r10, r11);
        a r17 = (a) this.f.getValue();
        Intrinsics.checkNotNullParameter(r16, "vmData");
        lk8.e r18 = r2.c;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r16, "vmData");
        r18.a = r16;
        r18.b = r17;
        lk8.e r19 = r2.c;
        r19.getClass();
        lk8.a r20 = r19.a;
        if (r20 == null) goto L26;
        Message r21 = r20.a;
        if (r21 == null) goto L26;
    L27:
        Message r22 = r21;
        lk8.a r23 = r19.a;
        if (r23 == null) goto L30;
        boolean r24 = r23.b;
    L31:
        if (r23 == null) goto L33;
        boolean r25 = r23.c;
    L34:
        if (r23 == null) goto L36;
        r14 = r23.d;
    L36:
        ResearchBlock r26 = r14;
        if (r23 == null) goto L39;
        int r110 = r23.e;
    L40:
        if (r23 == null) goto L42;
        boolean r111 = r23.f;
    L43:
        ((DeepResearchCardView) r2.b.getValue()).R5(new kk8.d(r22, r24, r25, r26, r110, r111), (lk8.e.a) r2.c.c.getValue());
        return;
    L42:
        r111 = false;
        goto L43
    L39:
        r110 = 0;
        goto L40
    L33:
        r25 = false;
        goto L34
    L30:
        r24 = false;
    L26:
        r21 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
        goto L27
    L21:
        r15 = null;
    L17:
        r11 = false;
        goto L18
    L7:
        r10 = 0;
        goto L8
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        ik8.b r0 = new ik8.b(r2.getContext());
        this.d = r0;
        return (DeepResearchCardView) r0.b.getValue();
    }
}

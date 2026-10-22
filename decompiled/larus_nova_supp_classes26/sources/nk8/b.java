package nk8;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.standarduikit.deepresearchprogresscard.view.DeepResearchProgressCard;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.ResearchProcessBlock;
import fb8.i;
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
import ok8.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends jc8.b<i> {
    public mk8.c d;
    public kc8.b e;
    public final Lazy f;

    public static final class a implements pk8.a {
        public final /* synthetic */ b a;

        @Override // pk8.a
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

        @Override // pk8.a
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

        @Override // pk8.a
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

        @Override // pk8.a
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

        @Override // pk8.a
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

        public a(b r1) {
            this.a = r1;
        }
    }

    public final String c() {
        return "ResearchProgressCardBlockHolder";
    }

    public final void i() {
    }

    public b() {
        this.f = LazyKt.lazy(new nk8.a(this));
    }

    public final d f(jc8.a r2) {
        i r3 = (i) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    public final void g(jc8.a r6) {
        i r7 = (i) r6;
        Intrinsics.checkNotNullParameter(r7, "blockModel");
        this.e = jc8.c.a(this, kc8.b.class);
        mk8.c r0 = this.d;
        if (r0 == null) goto L16;
        boolean r2 = ((jc8.a) r7).a.isFinish();
        BlockContent r3 = ((jc8.a) r7).a.getContent();
        ResearchProcessBlock r4 = null;
        if (r3 == null) goto L7;
        ResearchProcessBlock r5 = r3.getResearchProcessBlock();
    L8:
        pk8.e r1 = new pk8.e(r2, r5, r7.j());
        a r8 = (a) this.f.getValue();
        Intrinsics.checkNotNullParameter(r1, "vmData");
        pk8.d r9 = (pk8.d) r0.c.getValue();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "vmData");
        r9.b = r1;
        r9.a = r8;
        pk8.d r10 = (pk8.d) r0.c.getValue();
        r10.getClass();
        pk8.e r11 = r10.b;
        if (r11 == null) goto L11;
        boolean r12 = r11.a;
    L12:
        if (r11 == null) goto L14;
        r4 = r11.b;
    L14:
        ((DeepResearchProgressCard) r0.b.getValue()).S5(new f(r12, r4), (pk8.d.b) ((pk8.d) r0.c.getValue()).c.getValue());
        return;
    L11:
        r12 = false;
        goto L12
    L7:
        r5 = null;
        goto L8
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        mk8.c r0 = new mk8.c(r2.getContext());
        this.d = r0;
        return (DeepResearchProgressCard) r0.b.getValue();
    }
}

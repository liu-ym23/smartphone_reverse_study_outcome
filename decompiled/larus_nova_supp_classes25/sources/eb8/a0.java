package eb8;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.widget.DeepResearchWebCard;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a0 extends jc8.b<nk8.c> {
    public DeepResearchWebCard d;
    public kc8.b e;

    @Override // jc8.b
    public final String c() {
        return "ResearchWebpageBlockHolder";
    }

    public a0() {
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r2) {
        nk8.c r3 = (nk8.c) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return jc8.e.d(r3);
    }

    @Override // jc8.b
    public final void g(jc8.a r9) {
        nk8.c r10 = (nk8.c) r9;
        Intrinsics.checkNotNullParameter(r10, "blockModel");
        this.e = (kc8.b) jc8.c.a(this, kc8.b.class);
        DeepResearchWebCard r1 = this.d;
        if (r1 == null) goto L37;
        Block r5 = r10.a;
        kc8.b r0 = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (r0 == null) goto L10;
        kc8.y r2 = r0.a;
        if (r2 == null) goto L10;
        Fragment r3 = r2.a;
    L11:
        cd8.a r4 = (cd8.a) jc8.c.a(this, cd8.a.class);
        if (r4 == null) goto L14;
        int r6 = r4.a;
    L15:
        kc8.b r7 = this.e;
        if (r7 == null) goto L20;
        kc8.y r8 = r7.a;
        if (r8 == null) goto L20;
        kc8.z r11 = r8.A;
    L21:
        Message r12 = r10.j();
        kc8.b r13 = this.e;
        if (r13 == null) goto L30;
        kc8.y r14 = r13.a;
        if (r14 == null) goto L30;
        q0 r15 = r14.x;
        if (r15 == null) goto L30;
        ChatMessageList r16 = r15.B7();
        if (r16 == null) goto L30;
        Object r17 = r16.getTag(2131384073);
    L32:
        if (TypeIntrinsics.isMutableSet(r17) == false) goto L34;
        Set<Object> r18 = (Set) r17;
    L35:
        r1.S5(r3, r11, r12, r5, r6, r18);
        return;
    L34:
        r18 = null;
    L30:
        r17 = null;
    L20:
        r11 = null;
        goto L21
    L14:
        r6 = 0;
    L10:
        r3 = null;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, com.larus.bmhome.chat.layout.widget.DeepResearchWebCard] */
    @Override // jc8.b
    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        ?? r0 = new DeepResearchWebCard(r2.getContext());
        this.d = r0;
        return r0;
    }
}

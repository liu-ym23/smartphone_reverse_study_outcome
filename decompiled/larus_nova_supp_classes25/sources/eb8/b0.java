package eb8;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.view.RiskTipsTextView;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b0 extends jc8.b<fb8.j> {
    public RiskTipsTextView d;

    @Override // jc8.b
    public final String c() {
        return "RiskTipsBlockHolder";
    }

    public b0() {
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r6) {
        fb8.j r7 = (fb8.j) r6;
        Intrinsics.checkNotNullParameter(r7, "blockModel");
        boolean r0 = r7.m();
        boolean r8 = r7.n();
        if (r0 == false) goto L7;
        if (r8 == false) goto L7;
        return new jc8.d(c7.b(16), c7.b(12), c7.b(16), c7.b(14));
    L7:
        if (r0 == true) goto L14;
        if (r8 == false) goto L12;
        return new jc8.d(c7.b(16), c7.b(6), c7.b(16), c7.b(14));
    L12:
        return new jc8.d(c7.b(16), c7.b(6), c7.b(16), c7.b(6));
    L14:
        return new jc8.d(c7.b(16), c7.b(12), c7.b(16), c7.b(6));
    }

    @Override // jc8.b
    public final void g(jc8.a r5) {
        fb8.j r6 = (fb8.j) r5;
        Intrinsics.checkNotNullParameter(r6, "blockModel");
        RiskTipsTextView r0 = this.d;
        if (r0 == null) goto L13;
        kc8.b r1 = (kc8.b) jc8.c.a(this, kc8.b.class);
        Block r2 = r6.a;
        Message r3 = r6.j();
        boolean r7 = r6.n();
        if (r1 == null) goto L10;
        kc8.y r4 = r1.a;
        if (r4 == null) goto L10;
        kc8.z r8 = r4.A;
    L11:
        r0.a(r3, r2, r7, r8);
        return;
    L10:
        r8 = null;
        goto L11
    }

    @Override // jc8.b
    public final View h(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "viewGroup");
        RiskTipsTextView r0 = new RiskTipsTextView(r5.getContext(), null, 6, 0);
        this.d = r0;
        return r0;
    }
}

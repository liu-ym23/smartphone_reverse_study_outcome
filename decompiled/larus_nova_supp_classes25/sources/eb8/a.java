package eb8;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.deepresearch.view.AbsBlockView;
import com.larus.im.bean.message.block.Block;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a extends jc8.b<fb8.a> {
    public com.larus.bmhome.chat.deepresearch.view.g d;

    @Override // jc8.b
    public final String c() {
        return "AuthIdentityBlockHolder";
    }

    @Override // jc8.b
    public final void i() {
    }

    public a() {
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r2) {
        Intrinsics.checkNotNullParameter((fb8.a) r2, "blockModel");
        return new jc8.d(0, 0, 0, 0);
    }

    @Override // jc8.b
    public final void g(jc8.a r3) {
        fb8.a r4 = (fb8.a) r3;
        Intrinsics.checkNotNullParameter(r4, "blockModel");
        com.larus.bmhome.chat.deepresearch.view.g r0 = this.d;
        if (r0 == null) goto L6;
        Block r5 = r4.a;
        int r1 = AbsBlockView.a;
        r0.a(r5, null);
        return;
    }

    @Override // jc8.b
    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        com.larus.bmhome.chat.deepresearch.view.g r0 = new com.larus.bmhome.chat.deepresearch.view.g(r2.getContext());
        this.d = r0;
        return r0;
    }
}

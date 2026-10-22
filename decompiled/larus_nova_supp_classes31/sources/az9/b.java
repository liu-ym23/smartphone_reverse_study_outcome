package az9;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.LoadingBlock;
import com.larus.uaigc.chat.block.createloading.CreationLoadingBlockView;
import jc8.d;
import jc8.e;
import kc8.y;
import kc8.z;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b extends jc8.b<a> {
    public FrameLayout d;

    public final String c() {
        return "CreationLoadingBlockHolder";
    }

    public b() {
    }

    public final d f(jc8.a r2) {
        a r3 = (a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    public final void g(jc8.a r10) {
        a r11 = (a) r10;
        Intrinsics.checkNotNullParameter(r11, "blockModel");
        kc8.b r0 = jc8.c.a(this, kc8.b.class);
        FrameLayout r1 = this.d;
        if (r1 == null) goto L41;
        CreationLoadingBlockView r3 = null;
        if (r1.getChildCount() != 0) goto L8;
        r1.addView(new CreationLoadingBlockView(r1.getContext(), null, 6, 0));
    L8:
        View r2 = r1.getChildAt(0);
        boolean r4 = r2 instanceof CreationLoadingBlockView;
        if (r4 == false) goto L11;
        CreationLoadingBlockView r5 = (CreationLoadingBlockView) r2;
    L12:
        if (r5 == null) goto L28;
        BlockContent r6 = ((jc8.a) r11).a.getContent();
        if (r6 == null) goto L18;
        LoadingBlock r7 = r6.getLoadingBlock();
        if (r7 == null) goto L18;
        String r8 = r7.text;
    L19:
        if (r8 != null) goto L21;
        r8 = "";
    L21:
        if (r0 == null) goto L25;
        y r9 = r0.a;
        if (r9 == null) goto L25;
        final z r12 = r9.A;
    L26:
        Intrinsics.checkNotNullParameter(r8, "loadingText");
        r5.a.a.setOnLongClickListener(new c(r12));
        r5.a.b.getLoadingText().setText(r8);
        r5.a.b.a();
    L25:
        r12 = null;
    L18:
        r8 = null;
    L28:
        if (r11.m() == false) goto L33;
        if (r4 == false) goto L31;
        r3 = (CreationLoadingBlockView) r2;
    L31:
        if (r3 == null) goto L38;
        r3.a(0);
        return;
    L38:
        return;
    L33:
        if (r4 == false) goto L35;
        r3 = (CreationLoadingBlockView) r2;
    L35:
        if (r3 == null) goto L40;
        r3.a(i5.q());
        return;
    L40:
        return;
    L11:
        r5 = null;
        goto L12
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        FrameLayout r0 = new FrameLayout(r2.getContext());
        this.d = r0;
        return r0;
    }
}

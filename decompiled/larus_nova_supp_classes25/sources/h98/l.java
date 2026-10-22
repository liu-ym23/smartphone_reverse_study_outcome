package h98;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.DoraDiarySummaryBlock;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l extends jc8.b<j> {
    public CustomMarkdownTextView d;
    public Fragment e;

    @Override // jc8.b
    public final String c() {
        return "DiarySummaryBlockHolder";
    }

    @Override // jc8.b
    public final void i() {
        CustomMarkdownTextView r0 = this.d;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public l() {
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r3) {
        Intrinsics.checkNotNullParameter((j) r3, "blockModel");
        return new jc8.d(0, c7.b(12), 0, 0);
    }

    @Override // jc8.b
    public final void g(jc8.a r5) {
        j r6 = (j) r5;
        Intrinsics.checkNotNullParameter(r6, "blockModel");
        Intrinsics.checkNotNullParameter(r6, "blockModel");
        BlockContent r7 = r6.a.getContent();
        lw8.l r0 = null;
        if (r7 == null) goto L7;
        DoraDiarySummaryBlock r8 = r7.getDoraDiarySummaryBlock();
        if (r8 == null) goto L7;
        String r9 = r8.content;
    L8:
        if (r9 != null) goto L10;
        r9 = "";
    L10:
        CustomMarkdownTextView r1 = this.d;
        if (r1 == null) goto L21;
        gw8.c.a.getClass();
        gw8.c r2 = gw8.c.a.b();
        if (r2 == null) goto L16;
        r0 = gw8.c.b.b(r2, r1, r9, true, i.a(null));
    L16:
        if (r0 == null) goto L18;
        r1.setMarkdown(r0);
        return;
    L18:
        r1.setText(r9);
        return;
    L21:
        return;
    L7:
        r9 = null;
        goto L8
    }

    @Override // jc8.b
    public final View h(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "viewGroup");
        Context r0 = r5.getContext();
        ViewGroup.LayoutParams r1 = r5.getLayoutParams();
        if (r1 != null) goto L5;
        r1 = new LinearLayout.LayoutParams(-1, -2);
    L5:
        r1.width = -1;
        r1.height = -2;
        r5.setLayoutParams(r1);
        View r6 = LayoutInflater.from(r0).inflate(2131563210, r5, false);
        CustomMarkdownTextView r2 = r6.findViewById(2131369075);
        this.d = r2;
        if (r2 == null) goto L8;
        r2.setLineSpacing(0.0f, 1.3f);
    L8:
        Intrinsics.checkNotNull(r6);
        this.e = ViewExtKt.i(r6);
        CustomMarkdownTextView r3 = this.d;
        if (r3 == null) goto L11;
        r3.setOnLongClickListener(new k(this));
    L11:
        return r6;
    }
}

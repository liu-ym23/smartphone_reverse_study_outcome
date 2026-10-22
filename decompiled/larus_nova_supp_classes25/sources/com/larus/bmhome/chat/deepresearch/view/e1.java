package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e1 extends AbsBlockView {
    public final Lazy b;
    public fh8.f c;

    private final vg8.m getMarkdownRenderHelper() {
        return (vg8.m) this.b.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.larus.bmhome.chat.layout.widget.v0 r0 = getMarkdownRenderHelper().g;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMarkdownRenderHelper().c();
    }

    public e1(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = LazyKt.lazy(new d1());
        this.c = new fh8.g().a();
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(Block r63, Map<String, Object> r64) {
        if (r64 == null) goto L5;
        Object r0 = r64.get("block_view_markdown_common_input");
    L7:
        if ((r0 instanceof fh8.f) == false) goto L9;
        fh8.f r1 = (fh8.f) r0;
    L10:
        if (r1 != null) goto L12;
        r1 = new fh8.g().a();
    L12:
        fh8.f r8 = r1;
        Message r3 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
        tb8.a r5 = new tb8.a(null, null, null, null, false, null, 63);
        fh8.t.a r2 = new fh8.t.a();
        r2.a = ContextCompat.getColor(getContext(), v19.c.b(2130972082, getContext(), 2131103146));
        r2.b = i5.o();
        r2.c = i5.E();
        r2.d = false;
        r2.e = false;
        r2.f = null;
        r2.g = true;
        d(r3, r63, r5, r2.a(), new fh8.l(false, false, UUID.randomUUID().toString(), true, null, false, false, false, false, null, null, 4080), r8);
        return;
    L9:
        r1 = null;
        goto L10
    L5:
        r0 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        setOrientation(1);
    }

    public final void d(final Message r17, final Block r18, final tb8.a r19, final fh8.t r20, final fh8.l r21, fh8.f r22) {
        Intrinsics.checkNotNullParameter(r17, "message");
        Intrinsics.checkNotNullParameter(r19, "deepThinkParentContext");
        Intrinsics.checkNotNullParameter(r20, "renderViewConfig");
        Intrinsics.checkNotNullParameter(r21, "markdownRenderConfig");
        Intrinsics.checkNotNullParameter(r22, "commonInputData");
        fh8.g r12 = fh8.h.a(r22);
        r12.j = r21.e;
        r12.i = new z0(this, r17, r18, r19, r20, r21);
        this.c = r12.a();
        vg8.m r0 = getMarkdownRenderHelper();
        if (r18 == null) goto L5;
        String r1 = qf8.a.c(r18, r17, 2);
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        fh8.e.a(r0, this, r1, r20, r21, new a1(r19), new b1(r19), new c1(), null, this.c, r18, null, 1152);
        return;
    L5:
        r1 = null;
        goto L6
    }
}

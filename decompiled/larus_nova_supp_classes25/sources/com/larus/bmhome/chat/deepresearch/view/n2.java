package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.larus.im.bean.message.block.Block;
import com.larus.list.expose.ExposureTrackerExtKt;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n2 extends AbsFoldableHeaderBlockView {
    public j2 n;
    public boolean o;

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsFoldableHeaderBlockView
    public final boolean d() {
        return this.o;
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsFoldableHeaderBlockView
    public View getContentBlockView() {
        return this.n;
    }

    public n2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.o = true;
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsFoldableHeaderBlockView, com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(final Block r4, Map<String, Object> r5) {
        List r0 = AbsBlockView.a.c(r4);
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        boolean r2 = !r1;
        this.o = r2;
        if (r2 == true) goto L20;
        Map r3 = null;
        if (r5 == null) goto L14;
        Object r6 = r5.get("block_view_extra_fold_states");
    L16:
        if (TypeIntrinsics.isMutableMap(r6) == false) goto L18;
        r3 = (Map) r6;
    L18:
        if (r3 == null) goto L20;
        Boolean r7 = (Boolean) r3.put(e(r4), Boolean.TRUE);
        goto L20
    L14:
        r6 = null;
    L20:
        j2 r8 = this.n;
        if (r8 == null) goto L23;
        r8.a(r4, r5);
    L23:
        super.a(r4, r5);
        ExposureTrackerExtKt.a(this, new k2(this, r4));
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsFoldableHeaderBlockView, com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.b(r3, r4);
        j2 r5 = new j2(r3);
        this.n = r5;
        addView(r5, new LinearLayout.LayoutParams(-1, -2));
    }
}

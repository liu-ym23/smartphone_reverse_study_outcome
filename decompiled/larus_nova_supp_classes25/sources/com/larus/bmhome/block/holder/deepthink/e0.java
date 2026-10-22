package com.larus.bmhome.block.holder.deepthink;

import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.markdown.reference.AbsSearchResultBlockWidget;
import com.larus.bmhome.chat.markdown.reference.MarkdownReferenceWidget;
import com.larus.bmhome.chat.markdown.reference.SearchReferenceData;
import com.larus.bmhome.chat.markdown.reference.Stage;
import com.larus.bmhome.chat.markdown.reference.ToolType;
import com.larus.bmhome.utils.z3;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.LocalLifeBlock;
import com.larus.im.bean.message.block.SearchQueryResultExtend;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e0 extends jc8.b<gb8.k> {
    public MarkdownReferenceWidget d;

    @Override // jc8.b
    public final String c() {
        return "PoiBlockHolder";
    }

    @Override // jc8.b
    public final void i() {
        MarkdownReferenceWidget r0 = this.d;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    public e0() {
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r2) {
        gb8.k r3 = (gb8.k) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return j0.a(this.a, r3);
    }

    @Override // jc8.b
    public final void g(jc8.a r2) {
        gb8.k r3 = (gb8.k) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        MarkdownReferenceWidget r0 = this.d;
        if (r0 == null) goto L7;
        j(r3, r0);
        return;
    }

    @Override // jc8.b
    public final View h(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        MarkdownReferenceWidget r0 = new MarkdownReferenceWidget(r3.getContext(), null);
        this.d = r0;
        return r0;
    }

    public final void j(final gb8.k r39, final AbsSearchResultBlockWidget<SearchReferenceData> r40) {
        tb8.a r2 = (tb8.a) jc8.c.a(this, tb8.a.class);
        cd8.a r3 = (cd8.a) jc8.c.a(this, cd8.a.class);
        if (r3 == null) goto L5;
        int r7 = r3.a;
    L6:
        kc8.b r11 = (kc8.b) jc8.c.a(this, kc8.b.class);
        BlockContent r4 = r39.a.getContent();
        if (r4 == null) goto L20;
        LocalLifeBlock r5 = r4.getLocalLifeBlock();
        if (r5 == null) goto L20;
        String r8 = r5.summary;
        List r15 = r5.queries;
        if (r39.a.isFinish() == false) goto L14;
        Stage r9 = Stage.Searched;
    L15:
        Integer r17 = Integer.valueOf(r9.getValue());
        SearchQueryResultExtend r10 = r5.extendFields;
        if (r10 == null) goto L18;
        Integer r18 = r10.thinkingIndex;
    L19:
        SearchReferenceData r6 = new SearchReferenceData(r8, null, r15, r8, r17, r18, r5.iconUrl, r5.iconUrlDark, ToolType.SearchPoi.getValue(), false, 514, null);
    L21:
        int r12 = com.larus.bmhome.chat.markdown.imagetool.f.a;
        kc8.b r13 = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (r13 == null) goto L24;
        fh8.f r14 = z3.a(r13, r39.j()).a();
    L25:
        fh8.f r16 = com.larus.bmhome.chat.markdown.imagetool.f.b(r2, r14, new d0(this, r39, r40));
        if (r11 == null) goto L30;
        kc8.p r1 = r11.e;
        if (r1 == null) goto L30;
        Integer r19 = Integer.valueOf(r1.a);
    L31:
        Size r20 = AbsSearchResultBlockWidget.h(r40, r6, r7, r16, r19, null, r11, null, 80);
        ViewGroup.LayoutParams r21 = r40.getLayoutParams();
        if (r21 == null) goto L34;
        r21.width = r20.getWidth();
    L34:
        ViewGroup.LayoutParams r22 = r40.getLayoutParams();
        if (r22 == null) goto L38;
        r22.height = r20.getHeight();
        return;
    L38:
        return;
    L30:
        r19 = null;
        goto L31
    L24:
        r14 = new fh8.f(0);
        goto L25
    L18:
        r18 = null;
        goto L19
    L14:
        r9 = Stage.Searching;
    L20:
        r6 = new SearchReferenceData(null, null, null, null, null, null, null, null, null, false, 1023, null);
        goto L21
    L5:
        r7 = 0;
        goto L6
    }
}

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
import com.larus.im.bean.message.Reference;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.LinkReaderBlock;
import com.larus.im.bean.message.block.SearchQueryResultExtend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c0 extends jc8.b<gb8.j> {
    public MarkdownReferenceWidget d;

    @Override // jc8.b
    public final String c() {
        return "LinkReaderBlockHolder";
    }

    @Override // jc8.b
    public final void i() {
        MarkdownReferenceWidget r0 = this.d;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    public c0() {
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r2) {
        gb8.j r3 = (gb8.j) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return j0.a(this.a, r3);
    }

    @Override // jc8.b
    public final void g(jc8.a r2) {
        gb8.j r3 = (gb8.j) r2;
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

    public final void j(final gb8.j r40, final MarkdownReferenceWidget r41) {
        tb8.a r2 = (tb8.a) jc8.c.a(this, tb8.a.class);
        cd8.a r3 = (cd8.a) jc8.c.a(this, cd8.a.class);
        if (r3 == null) goto L5;
        int r4 = r3.a;
    L6:
        kc8.b r12 = (kc8.b) jc8.c.a(this, kc8.b.class);
        BlockContent r5 = r40.a.getContent();
        if (r5 == null) goto L32;
        LinkReaderBlock r6 = r5.getLinkReaderBlock();
        if (r6 == null) goto L32;
        String r14 = r6.summary;
        List r7 = r6.items;
        if (r7 == null) goto L18;
        List r8 = r7;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r10 = r8.iterator();
    L15:
        if (r10.hasNext() == false) goto L17;
        r9.add(new Reference((TextCard) r10.next(), null, null, 6, null));
        goto L15
    L17:
        ArrayList r15 = r9;
    L19:
        String r11 = r6.summary;
        if (r40.a.isFinish() == false) goto L22;
        Stage r13 = Stage.Searched;
    L23:
        int r16 = r13.getValue();
        SearchQueryResultExtend r17 = r6.extendFields;
        if (r17 == null) goto L26;
        Integer r19 = r17.thinkingIndex;
    L27:
        String r18 = r6.iconUrl;
        String r110 = r6.iconUrlDark;
        String r22 = ToolType.LinkReader.getValue();
        String r20 = r6.url;
        if (r20 == null) goto L30;
        List r111 = CollectionsKt.listOf(r20);
    L31:
        SearchReferenceData r21 = new SearchReferenceData(r14, r15, r111, r11, Integer.valueOf(r16), r19, r18, r110, r22, false, 512, null);
    L33:
        SearchReferenceData r23 = r21;
        int r24 = RangesKt.coerceAtLeast(r4 - i5.q(), 0);
        int r25 = com.larus.bmhome.chat.markdown.imagetool.f.a;
        kc8.b r26 = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (r26 == null) goto L36;
        fh8.f r27 = z3.a(r26, r40.j()).a();
    L37:
        fh8.f r28 = com.larus.bmhome.chat.markdown.imagetool.f.b(r2, r27, new b0(this, r40, r41));
        if (r12 == null) goto L42;
        kc8.p r1 = r12.e;
        if (r1 == null) goto L42;
        Integer r112 = Integer.valueOf(r1.a);
    L43:
        Size r29 = AbsSearchResultBlockWidget.h(r41, r23, r24, r28, r112, null, r12, null, 80);
        ViewGroup.LayoutParams r30 = r41.getLayoutParams();
        if (r30 == null) goto L46;
        r30.width = r29.getWidth();
    L46:
        ViewGroup.LayoutParams r31 = r41.getLayoutParams();
        if (r31 == null) goto L51;
        r31.height = r29.getHeight();
        return;
    L51:
        return;
    L42:
        r112 = null;
        goto L43
    L36:
        r27 = new fh8.f(0);
        goto L37
    L30:
        r111 = null;
        goto L31
    L26:
        r19 = null;
        goto L27
    L22:
        r13 = Stage.Searching;
        goto L23
    L18:
        r15 = null;
    L32:
        r21 = new SearchReferenceData(null, null, null, null, null, null, null, null, null, false, 1023, null);
        goto L33
    L5:
        r4 = 0;
        goto L6
    }
}

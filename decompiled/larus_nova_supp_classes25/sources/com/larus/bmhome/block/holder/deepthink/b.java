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
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.ArtifactOPBlock;
import com.larus.im.bean.message.block.ArtifactOPStatus;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.DisplayHeader;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b extends jc8.b<gb8.a> {
    public kc8.b d;
    public MarkdownReferenceWidget e;

    public static final class a {
    }

    static {
    }

    @Override // jc8.b
    public final String c() {
        return "ArtifactOpBlockHolder";
    }

    @Override // jc8.b
    public final void i() {
        MarkdownReferenceWidget r0 = this.e;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    public b() {
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r2) {
        gb8.a r3 = (gb8.a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return j0.a(this.a, r3);
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.bmhome.block.holder.deepthink.a] */
    @Override // jc8.b
    public final void g(jc8.a r29) {
        final gb8.a r1 = (gb8.a) r29;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        this.d = (kc8.b) jc8.c.a(this, kc8.b.class);
        BlockContent r2 = r1.a.getContent();
        if (r2 == null) goto L87;
        final ArtifactOPBlock r3 = r2.getArtifactOpBlock();
        if (r3 == null) goto L91;
        cd8.a r4 = (cd8.a) jc8.c.a(this, cd8.a.class);
        final boolean r5 = false;
        if (r4 == null) goto L10;
        int r7 = r4.a;
    L11:
        FLogger r6 = FLogger.a;
        StringBuilder r8 = new StringBuilder("onBindBlockView title=");
        DisplayHeader r9 = r3.getHeader();
        ViewGroup.MarginLayoutParams r14 = null;
        if (r9 == null) goto L14;
        String r10 = r9.getSummary();
    L15:
        r8.append(r10);
        r6.d("ArtifactOpBlockHolder", r8.toString());
        kc8.b r11 = (kc8.b) jc8.c.a(this, kc8.b.class);
        ArtifactBlock r12 = r3.getArtifact();
        if (r12 == null) goto L20;
        Integer r13 = r12.getResourceType();
        if (r13 == null) goto L20;
        int r15 = r13.intValue();
    L22:
        if (r15 != 12) goto L24;
    L26:
        r5 = true;
    L27:
        MarkdownReferenceWidget r16 = this.e;
        if (r16 == null) goto L88;
        DisplayHeader r17 = r3.getHeader();
        if (r17 == null) goto L35;
        String r18 = r17.getSummary();
        if (r18 == null) goto L35;
        String r19 = r18;
    L36:
        DisplayHeader r20 = r3.getHeader();
        if (r20 == null) goto L42;
        String r21 = r20.getSummary();
        if (r21 == null) goto L42;
        String r110 = r21;
    L43:
        Integer r22 = r3.getStatus();
        int r23 = ArtifactOPStatus.SUCCEED.getValue();
        if (r22 != null) goto L47;
    L48:
        Integer r24 = r3.getStatus();
        int r25 = ArtifactOPStatus.FAILED.getValue();
        if (r24 != null) goto L52;
    L54:
        int r26 = Stage.Searching.getValue();
    L56:
        Integer r27 = Integer.valueOf(r26);
        DisplayHeader r28 = r3.getHeader();
        if (r28 == null) goto L59;
        String r210 = r28.getIconUrl();
    L60:
        DisplayHeader r30 = r3.getHeader();
        if (r30 == null) goto L63;
        String r211 = r30.getIconUrlDark();
    L64:
        SearchReferenceData r31 = new SearchReferenceData(r19, null, null, r110, r27, null, r210, r211, ToolType.SearchPlugin.getValue(), true, 38, null);
        fh8.f r32 = z3.a(r11, r1.j()).a();
        if (r11 == null) goto L69;
        kc8.p r33 = r11.e;
        if (r33 == null) goto L69;
        Integer r34 = Integer.valueOf(r33.a);
    L70:
        Size r35 = AbsSearchResultBlockWidget.h(r16, r31, r7, r32, r34, Boolean.valueOf(r5), null, new com.larus.bmhome.block.holder.deepthink.a(r3, this, r5, r1), 32);
        if (r35 == null) goto L89;
        MarkdownReferenceWidget r36 = this.e;
        if (r36 == null) goto L75;
        ViewGroup.LayoutParams r37 = r36.getLayoutParams();
    L77:
        if ((r37 instanceof ViewGroup.MarginLayoutParams) == false) goto L79;
        r14 = (ViewGroup.MarginLayoutParams) r37;
    L79:
        if (r14 == null) goto L81;
        r14.width = r35.getWidth();
    L81:
        if (r14 == null) goto L83;
        r14.height = r35.getHeight();
    L83:
        MarkdownReferenceWidget r38 = this.e;
        if (r38 == null) goto L90;
        r38.setLayoutParams(r14);
        return;
    L90:
        return;
    L75:
        r37 = null;
        goto L77
    L89:
        return;
    L69:
        r34 = null;
        goto L70
    L63:
        r211 = null;
        goto L64
    L59:
        r210 = null;
        goto L60
    L52:
        if (r24.intValue() != r25) goto L54;
    L55:
        r26 = Stage.Searched.getValue();
        goto L56
    L47:
        if (r22.intValue() == r23) goto L55;
    L42:
        r110 = "";
    L35:
        r19 = "";
        goto L36
    L88:
        return;
    L24:
        if (r15 == 5) goto L26;
        if (r15 != 0) goto L27;
    L20:
        r15 = 0;
        goto L22
    L14:
        r10 = null;
        goto L15
    L10:
        r7 = 0;
        goto L11
    L91:
        return;
    }

    @Override // jc8.b
    public final View h(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        MarkdownReferenceWidget r0 = new MarkdownReferenceWidget(r3.getContext(), null);
        this.e = r0;
        return r0;
    }
}

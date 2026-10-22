package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView;
import com.larus.bmhome.chat.markdown.reference.ToolType;
import com.larus.bmhome.chat.markdown.view.DeepThinkCommonToolHeader;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.CodeBlock;
import com.larus.im.bean.message.block.SearchQueryResultExtend;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 .2\u00020\u0001:\u0001.B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010#\u001a\u00020\"J\b\u0010$\u001a\u0004\u0018\u00010 J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u0013H\u0002J\b\u0010'\u001a\u00020\"H\u0002J\b\u0010(\u001a\u00020\"H\u0002J4\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020 2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010 H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/view/ExpandTitleCodeBlockView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "toolHeader", "Lcom/larus/bmhome/chat/markdown/view/DeepThinkCommonToolHeader;", "codeView", "Lcom/larus/bmhome/chat/markdown/code/ClickableMarkdownCodeView;", "markdownCommonInputData", "Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "toolType", "Lcom/larus/bmhome/chat/markdown/reference/ToolType;", "isFold", "", "hasClickFoldWhenDeepThinkCompleteExpand", "currentThinkFoldStatus", "Lcom/larus/bmhome/chat/bean/DeepThinkFoldStatus;", "isBlockFinish", "codeBlock", "Lcom/larus/im/bean/message/block/CodeBlock;", "codeParseModel", "Lcom/larus/bmhome/chat/deepresearch/util/CodeParserModel;", "config", "Lcom/larus/bmhome/chat/deepresearch/view/ExpandTitleCodeBlockConfig;", "hasBoundData", "boundBlockId", "", "bindData", "", "onViewRecycled", "currentToolTitle", "updateFoldStatus", "isUserClick", "updateBackgroundColor", "mobShowCard", "mobClickCard", "cardType", "clickEffect", "clickPosition", "codeType", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ExpandTitleCodeBlockView extends LinearLayout {
    public static final /* synthetic */ int k = 0;
    public final DeepThinkCommonToolHeader a;
    public final ClickableMarkdownCodeView b;
    public final ToolType c;
    public boolean d;
    public boolean e;
    public CodeBlock f;
    public oe8.b g;
    public l h;
    public boolean i;
    public String j;

    public static final class a {
    }

    static {
    }

    public ExpandTitleCodeBlockView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ExpandTitleCodeBlockView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void b(boolean r12) {
        if (r12 == false) goto L5;
        this.d = !this.d;
    L5:
        String r1 = "";
        String r2 = null;
        if (this.d == true) goto L19;
        ClickableMarkdownCodeView r13 = this.b;
        oe8.b r3 = this.g;
        if (r3 == null) goto L10;
        String r4 = r3.b;
    L11:
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        if (r3 == null) goto L15;
        String r5 = r3.a;
    L16:
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        ClickableMarkdownCodeView.d(r13, r4, r5, this.e);
        goto L19
    L15:
        r5 = null;
        goto L16
    L10:
        r4 = null;
    L19:
        boolean r6 = false;
        if (this.e == true) goto L39;
        l r14 = this.h;
        if (r14 == null) goto L28;
        Message r15 = r14.d;
        if (r15 == null) goto L28;
        if (com.larus.bmhome.chat.bean.d.j0(r15) != true) goto L28;
        boolean r16 = true;
    L29:
        if (r16 == true) goto L39;
        DeepThinkCommonToolHeader r17 = this.a;
        CodeBlock r7 = this.f;
        if (r7 == null) goto L34;
        String r8 = r7.summary;
    L35:
        if (r8 == null) goto L38;
        r1 = r8;
    L38:
        r17.c(CollectionsKt.listOf(r1));
        this.a.a(this.c, this.d);
    L51:
        DeepThinkCommonToolHeader r18 = this.a;
        ToolType r9 = this.c;
        CodeBlock r10 = this.f;
        if (r10 == null) goto L54;
        String r11 = r10.code;
    L55:
        if (r11 != null) goto L57;
    L60:
        boolean r19 = true;
    L61:
        if (r19 == true) goto L69;
        l r20 = this.h;
        if (r20 != null) goto L65;
    L67:
        boolean r21 = false;
    L68:
        if (r21 == true) goto L69;
    L70:
        CodeBlock r22 = this.f;
        if (r22 == null) goto L73;
        String r23 = r22.iconUrl;
    L74:
        if (r22 == null) goto L76;
        r2 = r22.iconUrlDark;
    L76:
        r18.b(r9, r6, r23, r2);
        com.larus.utils.e1.y(this.b, true ^ this.d);
        l r110 = this.h;
        if (r110 == null) goto L81;
        Integer r111 = r110.l;
        if (r111 == null) goto L81;
        int r112 = r111.intValue();
    L82:
        this.a.setBackgroundResource(r112);
        return;
    L81:
        r112 = 2131239260;
        goto L82
    L73:
        r23 = null;
        goto L74
    L65:
        if (r20.p != true) goto L67;
        r21 = true;
    L69:
        r6 = true;
        goto L70
    L57:
        if (r11.length() == 0) goto L60;
        r19 = false;
        goto L61
    L54:
        r11 = null;
        goto L55
    L34:
        r8 = null;
    L28:
        r16 = false;
    L39:
        DeepThinkCommonToolHeader r24 = this.a;
        ToolType r25 = this.c;
        CodeBlock r113 = this.f;
        if (r113 == null) goto L42;
        String r114 = r113.summary;
    L43:
        if (r114 != null) goto L45;
        String r26 = "";
    L46:
        boolean r27 = this.d;
        l r115 = this.h;
        if (r115 == null) goto L49;
        Boolean r28 = Boolean.valueOf(r115.p);
    L50:
        r24.d(r25, r26, r27, r28, null);
        goto L51
    L49:
        r28 = null;
        goto L50
    L45:
        r26 = r114;
        goto L46
    L42:
        r114 = null;
        goto L43
    }

    public ExpandTitleCodeBlockView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        DeepThinkCommonToolHeader r7 = new DeepThinkCommonToolHeader(r4, null);
        this.a = r7;
        ClickableMarkdownCodeView r0 = new ClickableMarkdownCodeView(r4, null, 6, 0);
        this.b = r0;
        this.c = ToolType.CodeRunning;
        this.d = true;
        setOrientation(1);
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-2, -2);
        r8.bottomMargin = j19.c.c(8);
        Unit r1 = Unit.INSTANCE;
        addView(r7, r8);
        addView(r0, new LinearLayout.LayoutParams(-1, -2));
        com.larus.utils.e1.d(r7, new m(this));
    }

    public /* synthetic */ ExpandTitleCodeBlockView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static void a(ExpandTitleCodeBlockView r26, String r27, String r28, String r29, String r30, int r31) {
        Boolean r2 = null;
        if ((r31 & 2) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r31 & 4) == 0) goto L9;
        String r17 = null;
    L11:
        if ((r31 & 8) == 0) goto L13;
        String r22 = null;
    L14:
        int r3 = oi8.n.a;
        l r4 = r26.h;
        if (r4 == null) goto L53;
        Message r5 = r4.d;
        if (r5 == null) goto L54;
        ChatParam r6 = r4.c;
        CodeBlock r7 = r26.f;
        if (r7 == null) goto L24;
        SearchQueryResultExtend r8 = r7.extendFields;
        if (r8 == null) goto L24;
        Integer r9 = r8.thinkingIndex;
    L25:
        Block r10 = r4.h;
        if (r10 == null) goto L28;
        String r11 = r10.getBlockId();
    L30:
        if (r11 != null) goto L32;
        String r12 = "";
    L33:
        l r0 = r26.h;
        if (r0 == null) goto L36;
        String r15 = r0.b;
    L37:
        if (r0 == null) goto L39;
        String r13 = r0.a;
    L40:
        if (r13 != null) goto L42;
        String r14 = "";
    L43:
        if (r0 == null) goto L47;
        Message r16 = r0.d;
        if (r16 == null) goto L47;
        r2 = Boolean.valueOf(com.larus.im.bean.message.a.C0(r16));
    L47:
        Boolean r18 = r2;
        if (r1 != null) goto L50;
        String r19 = "";
    L51:
        oi8.n.a(r5, r6, null, r9, r12, r27, r14, r19, null, null, null, r15, r18, r17, null, null, null, null, r22, "thinking_progress", null, 2592516);
        return;
    L50:
        r19 = r1;
        goto L51
    L42:
        r14 = r13;
        goto L43
    L39:
        r13 = null;
        goto L40
    L36:
        r15 = null;
        goto L37
    L32:
        r12 = r11;
        goto L33
    L28:
        r11 = null;
    L24:
        r9 = null;
        goto L25
    L54:
        return;
    L53:
        return;
    L13:
        r22 = r30;
        goto L14
    L9:
        r17 = r29;
        goto L11
    L5:
        r1 = r28;
        goto L7
    }
}

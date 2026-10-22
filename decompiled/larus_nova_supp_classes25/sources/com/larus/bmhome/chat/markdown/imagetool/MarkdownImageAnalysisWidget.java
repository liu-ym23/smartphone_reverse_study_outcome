package com.larus.bmhome.chat.markdown.imagetool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.markdown.reference.ToolType;
import com.larus.bmhome.chat.markdown.view.DeepThinkImageAnalysisViewArch;
import com.larus.im.bean.message.VLMImage;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.ImageAnalysisBlock;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\u0019H\u0016R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/markdown/imagetool/MarkdownImageAnalysisWidget;", "Lcom/larus/bmhome/chat/markdown/imagetool/AbsMarkdownImageToolWidget;", "Lcom/larus/im/bean/message/block/Block;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "imageAnalysisView", "Lcom/larus/bmhome/chat/markdown/view/DeepThinkImageAnalysisViewArch;", "getImageAnalysisView", "()Lcom/larus/bmhome/chat/markdown/view/DeepThinkImageAnalysisViewArch;", "imageAnalysisView$delegate", "Lkotlin/Lazy;", "imageAnalysisBlock", "Lcom/larus/im/bean/message/block/ImageAnalysisBlock;", "isSearching", "", "hasImage", "toolType", "Lcom/larus/bmhome/chat/markdown/reference/ToolType;", "toolName", "", "initExtraData", "", "onToolHeaderData", "Lcom/larus/bmhome/chat/markdown/imagetool/AbsMarkdownImageToolWidget$ToolHeaderData;", "shouldHide", "refreshImageView", "maxWidth", "", "onViewRecycled", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MarkdownImageAnalysisWidget extends AbsMarkdownImageToolWidget<Block> {
    public static final /* synthetic */ int u = 0;
    public final Lazy s;
    public ImageAnalysisBlock t;

    private final DeepThinkImageAnalysisViewArch getImageAnalysisView() {
        return (DeepThinkImageAnalysisViewArch) this.s.getValue();
    }

    @Override // com.larus.bmhome.chat.markdown.imagetool.AbsMarkdownImageToolWidget
    public final AbsMarkdownImageToolWidget.a f() {
        ImageAnalysisBlock r1 = this.t;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.summary;
    L6:
        String r4 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        List r5 = CollectionsKt.listOf(r3);
        ImageAnalysisBlock r6 = this.t;
        if (r6 == null) goto L12;
        String r7 = r6.summary;
    L13:
        if (r7 == null) goto L16;
        r4 = r7;
    L16:
        if (r6 == null) goto L18;
        String r8 = r6.iconUrl;
    L19:
        if (r6 == null) goto L22;
        r2 = r6.iconUrlDark;
    L22:
        return new AbsMarkdownImageToolWidget.a(r5, r4, r8, r2);
    L18:
        r8 = null;
        goto L19
    L12:
        r7 = null;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.markdown.imagetool.AbsMarkdownImageToolWidget
    public final boolean i() {
        if (this.t != null) goto L7;
        return true;
    L7:
        return super.i();
    }

    @Override // com.larus.bmhome.chat.markdown.imagetool.AbsMarkdownImageToolWidget
    public final boolean b() {
        Block r0 = getData();
        if (r0 == null) goto L14;
        BlockContent r1 = r0.getContent();
        if (r1 == null) goto L15;
        ImageAnalysisBlock r2 = r1.getImageAnalysisBlock();
        if (r2 == null) goto L16;
        List r3 = r2.results;
        if (r3 != null) goto L11;
        return false;
    L11:
        if ((!r3.isEmpty()) != true) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    L15:
        return false;
    L14:
        return false;
    }

    @Override // com.larus.bmhome.chat.markdown.imagetool.AbsMarkdownImageToolWidget
    public final void c() {
        Block r0 = getData();
        if (r0 == null) goto L7;
        BlockContent r1 = r0.getContent();
        if (r1 == null) goto L7;
        ImageAnalysisBlock r2 = r1.getImageAnalysisBlock();
    L8:
        this.t = r2;
        return;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.larus.bmhome.chat.markdown.imagetool.AbsMarkdownImageToolWidget
    public final boolean d() {
        Block r0 = getData();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isFinish() == true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.bmhome.chat.markdown.imagetool.AbsMarkdownImageToolWidget
    public final void g() {
        ExposeXTrackerExtKt.e(getImageAnalysisView().getBinding().b);
        super.g();
    }

    @Override // com.larus.bmhome.chat.markdown.imagetool.AbsMarkdownImageToolWidget
    public final String j() {
        Block r0 = getData();
        if (r0 == null) goto L9;
        BlockContent r1 = r0.getContent();
        if (r1 == null) goto L9;
        ImageAnalysisBlock r2 = r1.getImageAnalysisBlock();
        if (r2 == null) goto L9;
        return r2.toolName;
    L9:
        return null;
    }

    @Override // com.larus.bmhome.chat.markdown.imagetool.AbsMarkdownImageToolWidget
    public final ToolType k() {
        return ToolType.ImageAnalysis;
    }

    public MarkdownImageAnalysisWidget(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // com.larus.bmhome.chat.markdown.imagetool.AbsMarkdownImageToolWidget
    public final void h(int r5) {
        if (this.l == null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
    L27:
        e1.o(getImageAnalysisView());
        return;
    L11:
        if (getSearching() == true) goto L27;
        if (this.b == true) goto L27;
        if (getHasImage() == false) goto L27;
        if (getImageAnalysisView().getParent() != null) goto L26;
        addView(getImageAnalysisView());
        ViewGroup.LayoutParams r1 = getImageAnalysisView().getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        int r2 = i5.c0();
        ((FrameLayout.LayoutParams) r1).topMargin = r2;
        DeepThinkImageAnalysisViewArch r3 = getImageAnalysisView();
        ImageAnalysisBlock r4 = this.t;
        if (r4 == null) goto L21;
        List<VLMImage> r6 = r4.results;
    L22:
        fh8.f r7 = getMarkdownCommonInputData();
        if (r7 != null) goto L25;
        r7 = new fh8.f(0);
    L25:
        r3.a(r6, r7, r5);
        goto L26
    L21:
        r6 = null;
    L26:
        e1.x(getImageAnalysisView());
        return;
    L5:
        if (this.f == DeepThinkFoldStatus.CompleteExpand) goto L8;
        r0 = false;
        goto L9
    }

    public MarkdownImageAnalysisWidget(final Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.s = LazyKt.lazy(new h(r2));
    }
}

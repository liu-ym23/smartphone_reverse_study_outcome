package com.larus.bmhome.chat.markdown.imagetool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.markdown.reference.SearchReferenceData;
import com.larus.bmhome.chat.markdown.reference.ToolType;
import com.larus.bmhome.chat.markdown.reference.r;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.chat.gallery.api.PreviewScene;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.Reference;
import com.larus.im.bean.message.VLMImage;
import com.larus.im.bean.message.VLMMixerSearchResult;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.e1;
import do8.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kc8.s;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\fH\u0014J\b\u0010\"\u001a\u00020 H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/markdown/imagetool/MarkdownImageSearchWidget;", "Lcom/larus/bmhome/chat/markdown/imagetool/AbsMarkdownImageToolWidget;", "Lcom/larus/bmhome/chat/markdown/reference/SearchReferenceData;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "flowVlmVMDependency", "Lcom/larus/bmhome/chat/standarduikit/vlm/viewmodel/FlowVlmVMDependency;", "cardPosition", "", "getCardPosition", "()Ljava/lang/Integer;", "setCardPosition", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "cardVlmAssembler", "Lcom/larus/bmhome/chat/standarduikit/vlm/assembler/VLMContainerAssembler;", "getCardVlmAssembler", "()Lcom/larus/bmhome/chat/standarduikit/vlm/assembler/VLMContainerAssembler;", "cardVlmAssembler$delegate", "Lkotlin/Lazy;", "isSearching", "", "hasImage", "toolType", "Lcom/larus/bmhome/chat/markdown/reference/ToolType;", "onToolHeaderData", "Lcom/larus/bmhome/chat/markdown/imagetool/AbsMarkdownImageToolWidget$ToolHeaderData;", "refreshImageView", "", "maxWidth", "tryCreateFlowVlmVMDependency", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MarkdownImageSearchWidget extends AbsMarkdownImageToolWidget<SearchReferenceData> {
    public static final /* synthetic */ int v = 0;
    public do8.a s;
    public Integer t;
    public final Lazy u;

    public static final class a {
        public static k a(int r18, SearchReferenceData r19, Message r20, Integer r21, ToolType r22, Boolean r23, Boolean r24) {
            ArrayList r0 = new ArrayList();
            if (r19 == null) goto L12;
            List<Reference> r1 = r19.getReference();
            if (r1 == null) goto L12;
            Iterator<T> r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L12;
            VLMImage r3 = ((Reference) r2.next()).getImageCard();
            if (r3 == null) goto L8;
            r0.add(r3);
        L12:
            VLMMixerSearchResult r7 = new VLMMixerSearchResult(null, r0, 1, null);
            if (r22 == null) goto L15;
            String r5 = r22.getValue();
        L16:
            JSONObject r10 = new JSONObject();
            r10.put("picture_type", "search");
            return new k(r18, r5, r20, r7, r21, false, r10, null, null, r23, PreviewScene.SEARCH_IMAGE, null, r24, 6560);
        L15:
            r5 = null;
            goto L16
        }
    }

    static {
    }

    private final bo8.c getCardVlmAssembler() {
        return (bo8.c) this.u.getValue();
    }

    @Override // com.larus.bmhome.chat.markdown.imagetool.AbsMarkdownImageToolWidget
    public final AbsMarkdownImageToolWidget.a f() {
        List<String> r1 = com.larus.bmhome.chat.markdown.reference.a.b(getData());
        String r2 = com.larus.bmhome.chat.markdown.reference.a.a(getData());
        SearchReferenceData r3 = getData();
        String r4 = null;
        if (r3 == null) goto L5;
        String r5 = r3.getIcon();
    L6:
        SearchReferenceData r6 = getData();
        if (r6 == null) goto L10;
        r4 = r6.getIconDark();
    L10:
        return new AbsMarkdownImageToolWidget.a(r1, r2, r5, r4);
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.markdown.imagetool.AbsMarkdownImageToolWidget
    public final ToolType k() {
        ToolType.a r0 = ToolType.Companion;
        SearchReferenceData r1 = getData();
        if (r1 == null) goto L6;
        String r2 = r1.getToolType();
        if (r2 == null) goto L6;
    L7:
        r0.getClass();
        return ToolType.a.a(r2);
    L6:
        r2 = ToolType.SearchImage.getValue();
        goto L7
    }

    @Override // com.larus.bmhome.chat.markdown.imagetool.AbsMarkdownImageToolWidget
    public final boolean b() {
        SearchReferenceData r0 = getData();
        if (r0 == null) goto L28;
        List<Reference> r1 = r0.getReference();
        if (r1 == null) goto L29;
        List<Reference> r2 = r1;
        if ((r2 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L10;
        if (((Reference) r3.next()).getImageCard() == null) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L13;
        boolean r5 = true;
    L20:
        if (r5 != true) goto L30;
        return true;
    L30:
        return false;
    L17:
        r4 = false;
    L10:
        r5 = false;
        goto L20
    L9:
        if (r2.isEmpty() == false) goto L11;
    L29:
        return false;
    L28:
        return false;
    }

    @Override // com.larus.bmhome.chat.markdown.imagetool.AbsMarkdownImageToolWidget
    public final boolean d() {
        SearchReferenceData r0 = getData();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r.c(r0) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final Integer getCardPosition() {
        return this.t;
    }

    public MarkdownImageSearchWidget(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // com.larus.bmhome.chat.markdown.imagetool.AbsMarkdownImageToolWidget
    public final void h(int r19) {
        if (this.l == null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
    L48:
        e1.o(getCardVlmAssembler().b());
        return;
    L11:
        if (getSearching() == true) goto L48;
        if (this.b == true) goto L48;
        if (getHasImage() == false) goto L48;
        if (getCardVlmAssembler().b().getParent() != null) goto L47;
        addView(getCardVlmAssembler().b());
        ViewGroup.LayoutParams r2 = getCardVlmAssembler().b().getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) r2).topMargin = i5.c0();
        fh8.f r3 = getMarkdownCommonInputData();
        Boolean r4 = null;
        if (r3 == null) goto L21;
        Message r5 = r3.b;
    L22:
        SearchReferenceData r6 = getData();
        Integer r7 = this.t;
        ToolType r8 = k();
        kc8.b r9 = getBlockDependConfig();
        if (r9 == null) goto L27;
        s r10 = r9.k;
        if (r10 == null) goto L27;
        Boolean r11 = r10.a;
    L28:
        k r12 = a.a(r19, r6, r5, r7, r8, r11, Boolean.TRUE);
        do8.h r13 = this.s;
        if (r13 != null) goto L46;
        fh8.f r14 = getMarkdownCommonInputData();
        if (r14 == null) goto L33;
        AttachReceiver r15 = r14.o;
    L34:
        fh8.f r16 = getMarkdownCommonInputData();
        if (r16 == null) goto L37;
        q0 r17 = r16.q;
    L38:
        fh8.f r18 = getMarkdownCommonInputData();
        if (r18 == null) goto L41;
        LruSet<String> r110 = r18.g;
    L42:
        fh8.f r20 = getMarkdownCommonInputData();
        if (r20 == null) goto L45;
        r4 = r20.h;
    L45:
        r13 = new do8.h(r15, null, null, null, null, null, null, r17, r110, r4, null, null, 3198);
        goto L46
    L41:
        r110 = null;
        goto L42
    L37:
        r17 = null;
        goto L38
    L33:
        r15 = null;
    L46:
        this.s = r13;
        getCardVlmAssembler().a(r12, this.s);
    L27:
        r11 = null;
        goto L28
    L21:
        r5 = null;
    L47:
        e1.x(getCardVlmAssembler().b());
        return;
    L5:
        if (this.f == DeepThinkFoldStatus.CompleteExpand) goto L8;
        r1 = false;
        goto L9
    }

    public final void setCardPosition(Integer r1) {
        this.t = r1;
    }

    public MarkdownImageSearchWidget(final Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.u = LazyKt.lazy(new i(r2));
    }
}

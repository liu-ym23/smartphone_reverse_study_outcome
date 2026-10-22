package com.larus.bmhome.block.newheader.thinkcontent;

import android.content.Context;
import android.graphics.RectF;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.AtMostHeightLinearLayout;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.message.Message;
import fh8.c;
import fh8.f;
import fh8.g;
import fh8.h;
import fh8.t;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nb8.i;
import nb8.l;
import usc.e;
import v19.c7;
import vg8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u00020\u0005:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0016R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/block/newheader/thinkcontent/DeepThinkContentView;", "Lcom/larus/bmhome/chat/layout/widget/AtMostHeightLinearLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/block/newheader/thinkcontent/DeepThinkContentViewInput;", "Lcom/larus/bmhome/block/newheader/thinkcontent/DeepThinkContentViewOutput;", "Lcom/larus/bmhome/block/newheader/IRecyclableLifecycle;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "output", "markdownRenderHelper", "Lcom/larus/bmhome/chat/list/cell/text/markdown/MarkdownRenderHelper;", "getMarkdownRenderHelper", "()Lcom/larus/bmhome/chat/list/cell/text/markdown/MarkdownRenderHelper;", "markdownRenderHelper$delegate", "Lkotlin/Lazy;", "bindData", "", "input", "getCustomMarkView", "Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;", "markAllSpanNeedRefresh", "renderContentMessage", "onRecycle", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepThinkContentView extends AtMostHeightLinearLayout implements hb8.a {
    public static final /* synthetic */ int c = 0;
    public l a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public DeepThinkContentView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepThinkContentView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final m getMarkdownRenderHelper() {
        return (m) this.b.getValue();
    }

    private final CustomMarkdownTextView getCustomMarkView() {
        int r0 = getChildCount();
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L20;
        View r4 = getChildAt(r2);
        if ((r4 instanceof FrameLayout) == false) goto L8;
        FrameLayout r5 = (FrameLayout) r4;
    L9:
        if (r5 == null) goto L19;
        int r6 = r5.getChildCount();
        int r7 = 0;
    L11:
        if (r7 >= r6) goto L19;
        CustomMarkdownTextView r8 = r5.getChildAt(r7);
        if ((r8 instanceof CustomMarkdownTextView) == false) goto L15;
        CustomMarkdownTextView r9 = r8;
    L16:
        if (r9 != null) goto L17;
        r7 = r7 + 1;
        goto L11
    L17:
        return r9;
    L15:
        r9 = null;
    L19:
        r2 = r2 + 1;
        goto L4
    L8:
        r5 = null;
        goto L9
    L20:
        return null;
    }

    @Override // hb8.a
    public final void f() {
        getMarkdownRenderHelper().d(this);
        removeAllViews();
    }

    public final void a(i r28, l r29) {
        Intrinsics.checkNotNullParameter(r28, "input");
        Intrinsics.checkNotNullParameter(r29, "output");
        this.a = r29;
        if (r28.c == true) goto L6;
        return;
    L6:
        if (r28.g == false) goto L20;
        CustomMarkdownTextView r1 = getCustomMarkView();
        if (r1 == null) goto L20;
        CharSequence r2 = r1.getText();
        if ((r2 instanceof Spanned) == false) goto L12;
        Spanned r3 = (Spanned) r2;
    L13:
        if (r3 == null) goto L15;
        e[] r4 = (e[]) r3.getSpans(0, r3.length(), e.class);
    L16:
        if (r4 == null) goto L20;
        int r5 = r4.length;
        int r6 = 0;
    L18:
        if (r6 >= r5) goto L20;
        r4[r6].j();
        r6 = r6 + 1;
        goto L18
    L15:
        r4 = null;
        goto L16
    L12:
        r3 = null;
    L20:
        Message r7 = r28.e;
        String r8 = r28.f;
        f r9 = r28.d;
        t.a r10 = r28.h;
        if (d.e0(r7) == false) goto L23;
    L27:
        boolean r15 = false;
    L28:
        fh8.l r11 = new fh8.l(r15, r28.a, "deep_thinking", true, r7.getMessageId() + "-deepThink", false, false, false, false, null, null, 4064);
        r10.i = new RectF((float) c7.b(16), (float) c7.b(12), (float) c7.b(16), (float) c7.b(12));
        if (d.f0(r7) == true) goto L31;
    L33:
        g r12 = h.a(r9);
        r12.j = r11.e;
        r12.p = new c(r28.b, 2);
        r12.i = new nb8.e(this);
        String r13 = r8;
        fh8.e.a(getMarkdownRenderHelper(), this, r13, r10.a(), r11, new nb8.f(this), new nb8.g(this), new nb8.h(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("isDeepThink", Boolean.TRUE)}), r12.a(), null, null, 1536);
        return;
    L31:
        if (StringsKt.endsWith$default(r8, "\n\n", false, 2, null) == false) goto L33;
        r8 = r8 + 160;
        goto L33
    L23:
        if (r7.getMessageStatusLocal() != 23) goto L25;
    L26:
        r15 = true;
        goto L28
    L25:
        if (r7.getMessageStatusLocal() != 22) goto L27;
        goto L26
    }

    public DeepThinkContentView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setOrientation(1);
        this.b = LazyKt.lazy(new nb8.d());
    }

    public /* synthetic */ DeepThinkContentView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

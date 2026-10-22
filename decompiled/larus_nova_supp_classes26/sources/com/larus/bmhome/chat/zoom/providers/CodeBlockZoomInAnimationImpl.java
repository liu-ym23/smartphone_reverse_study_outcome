package com.larus.bmhome.chat.zoom.providers;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView;
import com.larus.bmhome.chat.zoom.IZoomInAnimationProvider;
import com.larus.bmhome.chat.zoom.ZoomInAnimationAction;
import com.larus.bmhome.chat.zoom.ZoomInAnimationEndStrategy;
import com.larus.bmhome.chat.zoom.ZoomInAnimationEnqueueStrategy;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.CodeBlock;
import de8.d;
import gb8.c;
import jc8.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oe8.b;
import so8.w;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/chat/zoom/providers/CodeBlockZoomInAnimationImpl;", "Lcom/larus/bmhome/chat/zoom/IZoomInAnimationProvider;", "<init>", "()V", "blockBizModelClassName", "", "isSupport", "", "blockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "supportContext", "Lcom/larus/bmhome/chat/zoom/SupportContext;", "getAnimationID", "getAnimationView", "Landroid/view/View;", "context", "Landroid/content/Context;", "bindAnimationView", "", "view", "providerBindContext", "Lcom/larus/bmhome/chat/zoom/ProviderBindContext;", "getAnimationAction", "Lcom/larus/bmhome/chat/zoom/ZoomInAnimationAction;", "getAnimationConfig", "Lcom/larus/bmhome/chat/zoom/ZoomInAnimationConfig;", "onRecycle", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CodeBlockZoomInAnimationImpl implements IZoomInAnimationProvider {
    public CodeBlockZoomInAnimationImpl() {
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final String h() {
        return c.class.getName();
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final String a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        return r2.h();
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final so8.c b(a r8) {
        Intrinsics.checkNotNullParameter(r8, "blockBizModel");
        ZoomInAnimationEnqueueStrategy r9 = ZoomInAnimationEnqueueStrategy.ENQUEUE;
        ZoomInAnimationEndStrategy r0 = ZoomInAnimationEndStrategy.PASSIVE_WAIT;
        return new so8.c(c7.b(180), r9, r0, new Rect(c7.b(16), c7.b(11), c7.b(16), c7.b(14)));
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final void e(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Object r3 = r2.getTag(2131393420);
        if ((r3 instanceof ClickableMarkdownCodeView) == false) goto L5;
        ClickableMarkdownCodeView r4 = (ClickableMarkdownCodeView) r3;
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        r4.p();
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final ZoomInAnimationAction f(a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        if (r2.a.isFinish() == false) goto L6;
        return ZoomInAnimationAction.HIDE;
    L6:
        return ZoomInAnimationAction.SHOW;
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final View c(Context r4, a r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "blockBizModel");
        View r6 = new ClickableMarkdownCodeView(r4, null, 6, 0);
        FrameLayout r0 = new FrameLayout(r4);
        r0.addView(r6, new ViewGroup.LayoutParams(-1, -2));
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r0.setBackgroundResource(2131242981);
        r0.setTag(2131393420, r6);
        return r0;
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final void d(View r29, final a r30) {
        Intrinsics.checkNotNullParameter(r29, "view");
        Intrinsics.checkNotNullParameter(r30, "blockBizModel");
        Object r0 = r29.getTag(2131393420);
        if ((r0 instanceof ClickableMarkdownCodeView) == false) goto L5;
        ClickableMarkdownCodeView r1 = (ClickableMarkdownCodeView) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        BlockContent r2 = r30.a.getContent();
        if (r2 == null) goto L11;
        final CodeBlock r3 = r2.getCodeBlock();
    L12:
        int r4 = oe8.a.a;
        if (r3 == null) goto L15;
        String r5 = r3.code;
    L17:
        if (r5 != null) goto L19;
        r5 = "";
    L19:
        b r6 = oe8.a.a(r5, false);
        final String r12 = r6.a;
        ClickableMarkdownCodeView r7 = r1;
        ClickableMarkdownCodeView.n(r7, r30.j().getSenderId(), r30.j(), false, Long.valueOf(d.a(null)), null, null, new to8.a(r30, r3, r12), new to8.b(), new to8.b(), null, null, Integer.valueOf(c7.b(180)), null, null, null, null, null, null, null, null, false, 2094592);
        String r8 = r6.b;
        String r9 = r6.a;
        if (r9 != null) goto L22;
        r9 = "";
    L22:
        ClickableMarkdownCodeView.d(r1, r8, r9, r30.a.isFinish());
        return;
    L15:
        r5 = null;
        goto L17
    L11:
        r3 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final boolean g(a r3, so8.a r4) {
        Intrinsics.checkNotNullParameter(r3, "blockBizModel");
        if ((r3 instanceof c) == true) goto L5;
    L7:
        boolean r5 = false;
    L9:
        if (r3.a.isFinish() == false) goto L11;
        Intrinsics.checkNotNullParameter(r3, "blockBizModel");
        w.a(r3.h());
    L11:
        return r5;
    L5:
        if (r0.a(r3, r4) == false) goto L7;
        r5 = true;
        goto L9
    }
}

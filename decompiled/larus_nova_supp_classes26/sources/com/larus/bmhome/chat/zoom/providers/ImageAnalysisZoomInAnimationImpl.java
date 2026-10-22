package com.larus.bmhome.chat.zoom.providers;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.markdown.view.DeepThinkImageAnalysisViewArch;
import com.larus.bmhome.chat.zoom.IZoomInAnimationProvider;
import com.larus.bmhome.chat.zoom.ZoomInAnimationAction;
import com.larus.bmhome.chat.zoom.ZoomInAnimationEndStrategy;
import com.larus.bmhome.chat.zoom.ZoomInAnimationEnqueueStrategy;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.ImageAnalysisBlock;
import fh8.f;
import gb8.e;
import java.util.List;
import jc8.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import so8.c;
import so8.w;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/zoom/providers/ImageAnalysisZoomInAnimationImpl;", "Lcom/larus/bmhome/chat/zoom/IZoomInAnimationProvider;", "<init>", "()V", "blockBizModelClassName", "", "isSupport", "", "blockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "supportContext", "Lcom/larus/bmhome/chat/zoom/SupportContext;", "getAnimationID", "getAnimationView", "Landroid/view/View;", "context", "Landroid/content/Context;", "bindAnimationView", "", "view", "providerBindContext", "Lcom/larus/bmhome/chat/zoom/ProviderBindContext;", "getAnimationAction", "Lcom/larus/bmhome/chat/zoom/ZoomInAnimationAction;", "getAnimationConfig", "Lcom/larus/bmhome/chat/zoom/ZoomInAnimationConfig;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageAnalysisZoomInAnimationImpl implements IZoomInAnimationProvider {
    public ImageAnalysisZoomInAnimationImpl() {
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final String h() {
        return e.class.getName();
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final String a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        return r2.h();
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final c b(a r9) {
        Intrinsics.checkNotNullParameter(r9, "blockBizModel");
        return new c(c7.b(180), ZoomInAnimationEnqueueStrategy.SKIP_IF_BUSY, ZoomInAnimationEndStrategy.TIMER_CONTROL, new Rect(c7.b(16), c7.b(11), c7.b(16), c7.b(14)));
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final void e(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final ZoomInAnimationAction f(a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        return ZoomInAnimationAction.SHOW;
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final View c(Context r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "blockBizModel");
        return new DeepThinkImageAnalysisViewArch(r2, null);
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final void d(View r3, a r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "blockBizModel");
        List r1 = null;
        if ((r3 instanceof DeepThinkImageAnalysisViewArch) == false) goto L5;
        DeepThinkImageAnalysisViewArch r5 = (DeepThinkImageAnalysisViewArch) r3;
    L6:
        BlockContent r6 = r4.a.getContent();
        if (r6 == null) goto L11;
        ImageAnalysisBlock r7 = r6.getImageAnalysisBlock();
        if (r7 == null) goto L11;
        r1 = r7.results;
    L11:
        if (r5 == null) goto L14;
        r5.a(r1, new f(0), 0);
        return;
    L14:
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final boolean g(a r4, so8.a r5) {
        Intrinsics.checkNotNullParameter(r4, "blockBizModel");
        boolean r2 = false;
        if ((r4 instanceof e) == true) goto L6;
        return false;
    L6:
        if (r4.a.isFinish() == true) goto L8;
    L12:
        if (r2 == false) goto L14;
        Intrinsics.checkNotNullParameter(r4, "blockBizModel");
        w.a(r4.h());
    L14:
        return r2;
    L8:
        if (d.f0(r4.j()) == false) goto L12;
        if (r0.a(r4, r5) == false) goto L12;
        r2 = true;
        goto L12
    }
}

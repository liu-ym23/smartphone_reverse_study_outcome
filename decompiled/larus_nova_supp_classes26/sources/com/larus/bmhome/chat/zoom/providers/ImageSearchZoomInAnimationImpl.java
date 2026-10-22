package com.larus.bmhome.chat.zoom.providers;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.VlmImageSearchConf;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.markdown.imagetool.MarkdownImageSearchWidget;
import com.larus.bmhome.chat.markdown.reference.SearchReferenceData;
import com.larus.bmhome.chat.markdown.reference.ToolType;
import com.larus.bmhome.chat.markdown.reference.r;
import com.larus.bmhome.chat.zoom.IZoomInAnimationProvider;
import com.larus.bmhome.chat.zoom.ZoomInAnimationAction;
import com.larus.bmhome.chat.zoom.ZoomInAnimationEndStrategy;
import com.larus.bmhome.chat.zoom.ZoomInAnimationEnqueueStrategy;
import com.larus.im.bean.message.Message;
import do8.h;
import gb8.f;
import jc8.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import so8.c;
import so8.w;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/zoom/providers/ImageSearchZoomInAnimationImpl;", "Lcom/larus/bmhome/chat/zoom/IZoomInAnimationProvider;", "<init>", "()V", "blockBizModelClassName", "", "isSupport", "", "blockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "supportContext", "Lcom/larus/bmhome/chat/zoom/SupportContext;", "getAnimationID", "getAnimationView", "Landroid/view/View;", "context", "Landroid/content/Context;", "bindAnimationView", "", "view", "providerBindContext", "Lcom/larus/bmhome/chat/zoom/ProviderBindContext;", "getAnimationAction", "Lcom/larus/bmhome/chat/zoom/ZoomInAnimationAction;", "getAnimationConfig", "Lcom/larus/bmhome/chat/zoom/ZoomInAnimationConfig;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageSearchZoomInAnimationImpl implements IZoomInAnimationProvider {
    public ImageSearchZoomInAnimationImpl() {
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final String h() {
        return f.class.getName();
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final String a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        return String.valueOf(r2.a.getBlockId());
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final c b(a r8) {
        Intrinsics.checkNotNullParameter(r8, "blockBizModel");
        return new c(c7.b(180), ZoomInAnimationEnqueueStrategy.SKIP_IF_BUSY, ZoomInAnimationEndStrategy.TIMER_CONTROL, new Rect(0, c7.b(11), 0, c7.b(14)));
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
    public final View c(Context r6, a r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "blockBizModel");
        bo8.c r8 = new bo8.c(r6, new th8.f.b(true, c7.b(400), c7.b(180), c7.b(180)));
        RecyclerView r9 = r8.b();
        r9.setTag(2131393420, r8);
        return r9;
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final void d(View r19, a r20) {
        Intrinsics.checkNotNullParameter(r19, "view");
        Intrinsics.checkNotNullParameter(r20, "blockBizModel");
        Object r0 = r19.getTag(2131393420);
        if ((r0 instanceof bo8.c) == false) goto L5;
        bo8.c r1 = (bo8.c) r0;
    L7:
        if ((r20 instanceof f) == true) goto L9;
        return;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        int r2 = MarkdownImageSearchWidget.v;
        SearchReferenceData r4 = ((f) r20).o();
        Message r5 = r20.j();
        ToolType.a r3 = ToolType.Companion;
        String r6 = ((f) r20).o().getToolType();
        if (r6 != null) goto L14;
        r6 = ToolType.SearchImage.getValue();
    L14:
        r3.getClass();
        r1.a(MarkdownImageSearchWidget.a.a(0, r4, r5, null, ToolType.a.a(r6), null, Boolean.FALSE), new h(null, null, null, null, null, null, null, null, null, null, null, null, 3073));
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final boolean g(a r4, so8.a r5) {
        Intrinsics.checkNotNullParameter(r4, "blockBizModel");
        e0 r0 = (e0) AuthModelDelegate.b.e().getValue();
        boolean r1 = false;
        if (r0 == null) goto L9;
        LaunchInfo r2 = r0.a;
        if (r2 == null) goto L9;
        VlmImageSearchConf r3 = r2.C1();
        if (r3 == null) goto L9;
        boolean r6 = Intrinsics.areEqual(r3.b(), Boolean.TRUE);
    L10:
        if (r6 == true) goto L13;
        return false;
    L13:
        if ((r4 instanceof f) == true) goto L16;
        return false;
    L16:
        if (r0.a(r4, r5) == true) goto L19;
        return false;
    L19:
        if (r.b(((f) r4).o()) == true) goto L21;
    L23:
        if (r1 == false) goto L25;
        w.a(a(r4));
    L25:
        return r1;
    L21:
        if (d.f0(r4.j()) == false) goto L23;
        r1 = true;
    L9:
        r6 = false;
        goto L10
    }
}

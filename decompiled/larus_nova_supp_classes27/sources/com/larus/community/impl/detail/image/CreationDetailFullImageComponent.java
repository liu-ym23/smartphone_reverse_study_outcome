package com.larus.community.impl.detail.image;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.community.api.spi.ICommunityHostBehaviorProvider;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/larus/community/impl/detail/image/CreationDetailFullImageComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/community/impl/detail/image/CreationDetailFullImageAbility;", "<init>", "()V", "creationDetailImageAbility", "Lcom/larus/community/impl/detail/image/CreationDetailImageAbility;", "getCreationDetailImageAbility", "()Lcom/larus/community/impl/detail/image/CreationDetailImageAbility;", "creationDetailImageAbility$delegate", "Lkotlin/Lazy;", "onAttach", "", "onViewCreated", "view", "Landroid/view/View;", "onBackPressed", "", "bindView", "creationDetailImageView", "Lcom/larus/community/impl/detail/image/CreationDetailImageView;", "onDestroy", "bindViewerListener", "containerView", "Lcom/larus/community/impl/detail/image/CreationFullscreenImageViewer;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailFullImageComponent extends BaseContentWidget implements a {
    public static final /* synthetic */ int n = 0;
    public final Lazy m;

    public final void onDestroy() {
        int r0 = e29.d.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Intrinsics.checkNotNullParameter(r1, "fragment");
        ICommunityHostBehaviorProvider r2 = e29.d.c();
        if (r2 == null) goto L5;
        r2.b(r1, false);
    L5:
        View r3 = F2();
        if ((r3 instanceof CreationFullscreenImageViewer) == false) goto L8;
        CreationFullscreenImageViewer r4 = (CreationFullscreenImageViewer) r3;
    L9:
        if (r4 == null) goto L12;
        r4.setViewerListener(null);
        return;
    L12:
        return;
    L8:
        r4 = null;
        goto L9
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, a.class);
    }

    public CreationDetailFullImageComponent() {
        this.m = LazyKt.lazy(new b(this));
    }

    @Override // com.larus.community.impl.detail.image.a
    public final boolean onBackPressed() {
        View r0 = F2();
        if ((r0 instanceof CreationFullscreenImageViewer) == false) goto L5;
        CreationFullscreenImageViewer r1 = (CreationFullscreenImageViewer) r0;
    L7:
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r1.d == true) goto L11;
        boolean r2 = false;
    L15:
        if (r2 != true) goto L19;
        return true;
    L19:
        return false;
    L11:
        if (r1.e == true) goto L13;
        r1.e();
    L13:
        r2 = true;
        goto L15
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.community.impl.detail.image.a
    public final void P9(CreationDetailImageView r3) {
        View r0 = F2();
        if ((r0 instanceof CreationFullscreenImageViewer) == false) goto L5;
        CreationFullscreenImageViewer r1 = (CreationFullscreenImageViewer) r0;
    L6:
        if (r1 == null) goto L13;
        r1.setViewerListener(new c(this));
        if (r3 == null) goto L14;
        CreationZoomableDraweeView r4 = r3.getImageView();
        if (r4 == null) goto L15;
        r1.setSourceView(r4);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onViewCreated(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        View r3 = F2();
        if ((r3 instanceof CreationFullscreenImageViewer) == false) goto L5;
        CreationFullscreenImageViewer r4 = (CreationFullscreenImageViewer) r3;
    L6:
        if (r4 == null) goto L13;
        r4.setViewerListener(new c(this));
        d r0 = (d) this.m.getValue();
        if (r0 == null) goto L14;
        CreationZoomableDraweeView r1 = r0.Jp();
        if (r1 == null) goto L15;
        r4.setSourceView(r1);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r4 = null;
        goto L6
    }
}

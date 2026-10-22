package com.larus.photopicker.v2.impl.ui;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.photopicker.v2.impl.databinding.LarusItemPreviewImageV2Binding;
import com.larus.photopicker.v2.impl.others.scale.ScaleGestureLayout;
import com.larus.utils.m0;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import op9.d;
import vp9.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MediaPreviewImageFragment;", "Lcom/larus/photopicker/v2/impl/ui/BaseMediaPreviewItemFragment;", "<init>", "()V", "binding", "Lcom/larus/photopicker/v2/impl/databinding/LarusItemPreviewImageV2Binding;", "provideGestureLayout", "Lcom/larus/photopicker/v2/impl/others/scale/ScaleGestureLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "nonNullMediaItem", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "view", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaPreviewImageFragment extends BaseMediaPreviewItemFragment {
    public static final /* synthetic */ int k = 0;
    public LarusItemPreviewImageV2Binding j;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.photopicker.v2.impl.ui.BaseMediaPreviewItemFragment
    public final ScaleGestureLayout V90() {
        LarusItemPreviewImageV2Binding r0 = this.j;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L6:
        return r0.b;
    }

    public MediaPreviewImageFragment() {
    }

    @Override // com.larus.photopicker.v2.impl.ui.BaseMediaPreviewItemFragment
    public final void T90(d r9, View r10) {
        Intrinsics.checkNotNullParameter(r9, "nonNullMediaItem");
        Intrinsics.checkNotNullParameter(r10, "view");
        super.T90(r9, r10);
        int r0 = m0.a;
        final int r1 = m0.b(r10.getContext());
        final int r11 = m0.a(r10.getContext());
        LarusItemPreviewImageV2Binding r2 = this.j;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L5:
        final SimpleDraweeView r3 = r2.c;
        final Uri r4 = r9.a.b;
        ImageLoaderKt.x(r3, r4, "photo_picker_v2_MediaPreviewImageFragment", null, new p(r4, r3, r1, r11), 4);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131562613, r3, false);
        ScaleGestureLayout r6 = (ScaleGestureLayout) r5;
        SimpleDraweeView r0 = ViewBindings.findChildViewById(r5, 2131382925);
        if (r0 == null) goto L7;
        LarusItemPreviewImageV2Binding r7 = new LarusItemPreviewImageV2Binding(r6, r6, r0);
        this.j = r7;
        return r7.a;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131382925)));
    }
}

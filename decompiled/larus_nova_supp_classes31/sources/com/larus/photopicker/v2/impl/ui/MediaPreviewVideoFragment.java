package com.larus.photopicker.v2.impl.ui;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.VideoView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.photopicker.v2.impl.databinding.LarusItemPreviewVideoV2Binding;
import com.larus.photopicker.v2.impl.others.scale.ScaleGestureLayout;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import op9.d;
import vp9.q;
import vp9.r;
import vp9.s;
import wp9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MediaPreviewVideoFragment;", "Lcom/larus/photopicker/v2/impl/ui/BaseMediaPreviewItemFragment;", "<init>", "()V", "binding", "Lcom/larus/photopicker/v2/impl/databinding/LarusItemPreviewVideoV2Binding;", "isReadyPlaying", "", "provideGestureLayout", "Lcom/larus/photopicker/v2/impl/others/scale/ScaleGestureLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "nonNullMediaItem", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "view", "onResume", "onPause", "onDestroyView", "playVideo", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaPreviewVideoFragment extends BaseMediaPreviewItemFragment {
    public static final /* synthetic */ int l = 0;
    public LarusItemPreviewVideoV2Binding j;
    public boolean k;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.photopicker.v2.impl.ui.BaseMediaPreviewItemFragment
    public final ScaleGestureLayout V90() {
        LarusItemPreviewVideoV2Binding r0 = this.j;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L6:
        return r0.b;
    }

    @Override // com.larus.photopicker.v2.impl.ui.BaseMediaPreviewItemFragment
    public final void onDestroyView() {
        super.onDestroyView();
        LarusItemPreviewVideoV2Binding r0 = this.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.f.stopPlayback();
    }

    @Override // com.larus.photopicker.v2.impl.ui.BaseMediaPreviewItemFragment
    public final void onPause() {
        super.onPause();
        LarusItemPreviewVideoV2Binding r0 = this.j;
        LarusItemPreviewVideoV2Binding r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L6:
        if (r0.f.isPlaying() == false) goto L13;
        LarusItemPreviewVideoV2Binding r2 = this.j;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L11:
        r1.f.pause();
        return;
    L10:
        r1 = r2;
        goto L11
    }

    @Override // com.larus.photopicker.v2.impl.ui.BaseMediaPreviewItemFragment
    public final void onResume() {
        super.onResume();
        if (this.k == false) goto L17;
        LarusItemPreviewVideoV2Binding r0 = this.j;
        LarusItemPreviewVideoV2Binding r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L8:
        if (r0.f.isPlaying() == false) goto L10;
        return;
    L10:
        if (isResumed() == false) goto L19;
        LarusItemPreviewVideoV2Binding r2 = this.j;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r1.f.start();
        return;
    L14:
        r1 = r2;
        goto L15
    L19:
        return;
    }

    public MediaPreviewVideoFragment() {
    }

    @Override // com.larus.photopicker.v2.impl.ui.BaseMediaPreviewItemFragment
    public final void T90(d r5, View r6) {
        Intrinsics.checkNotNullParameter(r5, "nonNullMediaItem");
        Intrinsics.checkNotNullParameter(r6, "view");
        super.T90(r5, r6);
        Uri r7 = r5.a.b;
        LarusItemPreviewVideoV2Binding r8 = this.j;
        LarusItemPreviewVideoV2Binding r0 = null;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L5:
        b.a(r8.c, r7, "photo_picker_v2_MediaPreviewVideoFragment", -1, -1);
        LarusItemPreviewVideoV2Binding r9 = this.j;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L8:
        VideoView r10 = r9.f;
        LarusItemPreviewVideoV2Binding r2 = this.j;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        e1.x(r0.e);
        r10.setVideoURI(r7);
        r10.setOnPreparedListener(new q(this));
        r10.setOnInfoListener(new r(this));
        r10.setOnErrorListener(new s(this));
        return;
    L11:
        r0 = r2;
        goto L12
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131562616, r9, false);
        ScaleGestureLayout r2 = (ScaleGestureLayout) r11;
        int r12 = 2131382980;
        SimpleDraweeView r3 = ViewBindings.findChildViewById(r11, 2131382980);
        if (r3 == null) goto L13;
        r12 = 2131382981;
        AppCompatImageView r4 = ViewBindings.findChildViewById(r11, 2131382981);
        if (r4 == null) goto L13;
        r12 = 2131382983;
        ProgressBar r5 = (ProgressBar) ViewBindings.findChildViewById(r11, 2131382983);
        if (r5 == null) goto L13;
        r12 = 2131382985;
        VideoView r6 = (VideoView) ViewBindings.findChildViewById(r11, 2131382985);
        if (r6 == null) goto L13;
        LarusItemPreviewVideoV2Binding r13 = new LarusItemPreviewVideoV2Binding(r2, r2, r3, r4, r5, r6);
        this.j = r13;
        return r13.a;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}

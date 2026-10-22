package com.larus.doc.impl.video.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.doc.biz.impl.databinding.LarusDocVideoDetailControlViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J!\u0010\u001a\u001a\u00020\u00102\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00100\u001c¢\u0006\u0002\b\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lcom/larus/doc/impl/video/widget/VideoPlayControlView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/doc/impl/video/widget/IVideoPlayControl;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/doc/biz/impl/databinding/LarusDocVideoDetailControlViewBinding;", "getBinding", "()Lcom/larus/doc/biz/impl/databinding/LarusDocVideoDetailControlViewBinding;", "onDownloadClick", "", "onClick", "Lkotlin/Function0;", "updateProgress", "percent", "", "smooth", "", "showDownloadLoading", "loading", "configProgressView", "config", "Lkotlin/Function1;", "Lcom/larus/doc/impl/video/widget/PlayerProgressView;", "Lkotlin/ExtensionFunctionType;", "asView", "Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoPlayControlView extends ConstraintLayout {
    public static final /* synthetic */ int b = 0;
    public final LarusDocVideoDetailControlViewBinding a;

    public VideoPlayControlView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VideoPlayControlView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final LarusDocVideoDetailControlViewBinding getBinding() {
        return this.a;
    }

    public final void I4(boolean r1) {
        if (r1 == false) goto L4;
        this.a.b.T5();
        return;
    L4:
        this.a.b.R5();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoPlayControlView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131562138, this);
        int r5 = 2131370179;
        CommonDownLoadLayout r6 = ViewBindings.findChildViewById(this, 2131370179);
        if (r6 == null) goto L11;
        r5 = 2131381490;
        if (ViewBindings.findChildViewById(this, 2131381490) == null) goto L11;
        r5 = 2131382471;
        PlayerProgressView r7 = (PlayerProgressView) ViewBindings.findChildViewById(this, 2131382471);
        if (r7 == null) goto L11;
        this.a = new LarusDocVideoDetailControlViewBinding(this, r6, r7);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public /* synthetic */ VideoPlayControlView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

package com.larus.bmhome.video.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.databinding.LarusUserVideoDetailControlViewBinding;
import com.larus.bmhome.video.fragment.m;
import com.larus.common_ui.video.progress.PlayerProgressView;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qs8.a;
import qs8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0016J!\u0010\u001b\u001a\u00020\u00102\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00100\u001d¢\u0006\u0002\b\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\u0014\u0010\"\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012J\u000e\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006%"}, d2 = {"Lcom/larus/bmhome/video/view/UserVideoPlayControlView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/video/view/IVideoPlayControl;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bmhome/databinding/LarusUserVideoDetailControlViewBinding;", "getBinding", "()Lcom/larus/bmhome/databinding/LarusUserVideoDetailControlViewBinding;", "onDownloadClick", "", "onClick", "Lkotlin/Function0;", "updateProgress", "percent", "", "smooth", "", "showDownloadLoading", "loading", "hideDownloadComplete", "configProgressView", "config", "Lkotlin/Function1;", "Lcom/larus/common_ui/video/progress/PlayerProgressView;", "Lkotlin/ExtensionFunctionType;", "asView", "Landroid/view/View;", "onShareClick", "setShareIconVisibility", "visible", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserVideoPlayControlView extends ConstraintLayout implements a {
    public static final /* synthetic */ int b = 0;
    public final LarusUserVideoDetailControlViewBinding a;

    public UserVideoPlayControlView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public UserVideoPlayControlView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qs8.a
    public final View asView() {
        return this;
    }

    @Override // qs8.a
    public void setProgressViewVisibility(boolean r1) {
    }

    @Override // qs8.a
    public final void h3() {
        e1.o(this.a.c);
    }

    public final LarusUserVideoDetailControlViewBinding getBinding() {
        return this.a;
    }

    @Override // qs8.a
    public final void I4(boolean r1) {
        if (r1 == false) goto L4;
        e1.o(this.a.d);
        e1.x(this.a.b);
        return;
    L4:
        e1.o(this.a.b);
        e1.x(this.a.d);
    }

    @Override // qs8.a
    public final void d5(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onClick");
        final m r4 = (m) r3;
        e1.d(this.a.c, new c(r4));
    }

    public final void setShareIconVisibility(boolean r1) {
        if (r1 == false) goto L4;
        e1.x(this.a.f);
        return;
    L4:
        e1.o(this.a.f);
    }

    @Override // qs8.a
    public final void z1(Function1<? super PlayerProgressView, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        r2.invoke(this.a.e);
    }

    @Override // qs8.a
    public final void J1(float r2, boolean r3) {
        this.a.e.J1(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UserVideoPlayControlView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        LayoutInflater.from(r8).inflate(2131563193, this);
        int r11 = 2131370176;
        ProgressBar r2 = (ProgressBar) ViewBindings.findChildViewById(this, 2131370176);
        if (r2 == null) goto L19;
        r11 = 2131370179;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(this, 2131370179);
        if (r3 == null) goto L19;
        r11 = 2131374677;
        AppCompatImageView r4 = ViewBindings.findChildViewById(this, 2131374677);
        if (r4 == null) goto L19;
        r11 = 2131374711;
        if (ViewBindings.findChildViewById(this, 2131374711) == null) goto L19;
        r11 = 2131381490;
        if (((LinearLayout) ViewBindings.findChildViewById(this, 2131381490)) == null) goto L19;
        r11 = 2131382471;
        PlayerProgressView r5 = ViewBindings.findChildViewById(this, 2131382471);
        if (r5 == null) goto L19;
        r11 = 2131386095;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(this, 2131386095);
        if (r6 == null) goto L19;
        this.a = new LarusUserVideoDetailControlViewBinding(this, r2, r3, r4, r5, r6);
        return;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r11)));
    }

    public /* synthetic */ UserVideoPlayControlView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

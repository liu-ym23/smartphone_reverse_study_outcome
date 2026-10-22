package com.larus.community.impl.share;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.UIUtils;
import com.larus.common_ui.widget.ShadowLayout;
import com.larus.utils.m0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0007J \u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0015H\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0019H\u0002J\b\u0010)\u001a\u00020\u001fH\u0002J\u0006\u0010*\u001a\u00020\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/community/impl/share/ShareSingleImageItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "lifecycleCoroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "<init>", "(Landroid/view/View;Landroidx/lifecycle/LifecycleCoroutineScope;)V", "getLifecycleCoroutineScope", "()Landroidx/lifecycle/LifecycleCoroutineScope;", "imageView", "Landroidx/appcompat/widget/AppCompatImageView;", "llVideoDuration", "Landroid/widget/LinearLayout;", "tvVideoDuration", "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", "shadowLayout", "Lcom/larus/common_ui/widget/ShadowLayout;", "itemWidth", "", "itemPuzzleHeight", "itemSingleHeight", "frescoCloseableHolder", "Lcom/larus/community/impl/share/FrescoCloseableHolder;", "currentFinalBitmap", "Landroid/graphics/Bitmap;", "bindJob", "Lkotlinx/coroutines/Job;", "bind", "", "shareImageSingleItem", "Lcom/larus/community/impl/share/ShareImageSingleItem;", "updatePreviewLayout", "sourceWidth", "sourceHeight", "itemHeight", "isCurrentBind", "", "closeableHolder", "cleanupBitmaps", "destroy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareSingleImageItemViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int l = 0;
    public final LifecycleCoroutineScope a;
    public final AppCompatImageView b;
    public final LinearLayout c;
    public final TextView d;
    public final ProgressBar e;
    public final ShadowLayout f;
    public final int g;
    public final int h;
    public final int i;
    public m j;
    public Job k;

    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r8, Outline r9) {
            Intrinsics.checkNotNullParameter(r8, "view");
            Intrinsics.checkNotNullParameter(r9, "outline");
            r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight(), i5.r0());
        }
    }

    public final void U3() {
        Job r0 = this.k;
        final m r1 = this.j;
        boolean r2 = true;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.k = null;
        this.j = null;
        this.b.setImageDrawable(null);
        if (r0 != null) goto L8;
    L10:
        r2 = false;
    L11:
        if (r2 == false) goto L13;
        r0.invokeOnCompletion(new t(r1));
        return;
    L13:
        if (r1 == null) goto L17;
        r1.b();
        return;
    L17:
        return;
    L8:
        if (r0.isCompleted() == true) goto L10;
        goto L10
    }

    public ShareSingleImageItemViewHolder(View r7, LifecycleCoroutineScope r8) {
        Intrinsics.checkNotNullParameter(r7, "itemView");
        Intrinsics.checkNotNullParameter(r8, "lifecycleCoroutineScope");
        super(r7);
        this.a = r8;
        AppCompatImageView r9 = r7.findViewById(2131386138);
        this.b = r9;
        this.c = (LinearLayout) r7.findViewById(2131378932);
        this.d = (TextView) r7.findViewById(2131391685);
        this.e = (ProgressBar) r7.findViewById(2131383286);
        this.f = (ShadowLayout) r7.findViewById(2131386038);
        this.g = UIUtils.getScreenWidth(r7.getContext()) - i5.l0();
        int r0 = m0.a;
        this.h = (int) ((((double) m0.a(r7.getContext())) * 0.8d) - ((double) i5.P()));
        this.i = (int) ((((double) m0.a(r7.getContext())) * 0.8d) - ((double) i5.F()));
        r9.setOutlineProvider(new a());
        r9.setClipToOutline(true);
    }

    public static final void T3(ShareSingleImageItemViewHolder r2, int r3, int r4, int r5) {
        r2.getClass();
        if (r3 <= 0) goto L12;
        if (r4 <= 0) goto L13;
        float r1 = r5;
        float r0 = r2.g / r1;
        float r6 = r3 / r4;
        ViewGroup.LayoutParams r7 = r2.b.getLayoutParams();
        if (r0 >= r6) goto L9;
        int r8 = r2.g;
        r7.width = r8;
        r7.height = MathKt.roundToInt(r8 / r6);
    L10:
        r2.b.setLayoutParams(r7);
        r2.b.invalidateOutline();
        ViewGroup.LayoutParams r9 = r2.f.getLayoutParams();
        r9.width = r7.width + i5.l0();
        r9.height = r7.height + i5.l0();
        r2.f.setLayoutParams(r9);
        r2.b.setImageResource(2131102535);
        return;
    L9:
        r7.width = MathKt.roundToInt(r1 * r6);
        r7.height = r5;
        goto L10
    L13:
        return;
    }
}

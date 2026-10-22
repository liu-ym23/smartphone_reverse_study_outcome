package com.larus.community.impl.share;

import android.graphics.Bitmap;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.UIUtils;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.common_ui.widget.ShadowLayout;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.m0;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J$\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010\u00112\b\u0010#\u001a\u0004\u0018\u00010\u0011H\u0002J&\u0010$\u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u00112\b\u0010\"\u001a\u0004\u0018\u00010\u00112\b\u0010#\u001a\u0004\u0018\u00010\u0011H\u0002J(\u0010%\u001a\u0004\u0018\u00010\u00112\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u001aH\u0002J\u0006\u0010+\u001a\u00020\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/community/impl/share/SharePuzzleImageItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "lifecycleCoroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "<init>", "(Landroid/view/View;Landroidx/lifecycle/LifecycleCoroutineScope;)V", "getLifecycleCoroutineScope", "()Landroidx/lifecycle/LifecycleCoroutineScope;", "imageView", "Landroidx/appcompat/widget/AppCompatImageView;", "shadowLayout", "Lcom/larus/common_ui/widget/ShadowLayout;", "frescoCloseableHolder", "Lcom/larus/community/impl/share/FrescoCloseableHolder;", "currentResultBitmap", "Landroid/graphics/Bitmap;", "bindJob", "Lkotlinx/coroutines/Job;", "progressBar", "Landroid/widget/ProgressBar;", "itemWidth", "", "itemHeight", "bind", "", "shareImagePuzzleItem", "Lcom/larus/community/impl/share/ShareImagePuzzleItem;", "isCurrentBind", "", "closeableHolder", "isOwnedResultBitmap", "resultBitmap", "rawBitmap", "refBitmap", "recycleOwnedResultBitmap", "fetchBitmap", "url", "", "cacheKey", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/community/impl/share/FrescoCloseableHolder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanupBitmaps", "destroy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SharePuzzleImageItemViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int j = 0;
    public final LifecycleCoroutineScope a;
    public final AppCompatImageView b;
    public final ShadowLayout c;
    public m d;
    public Bitmap e;
    public Job f;
    public final ProgressBar g;
    public final int h;
    public final int i;

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
        Job r0 = this.f;
        final m r1 = this.d;
        boolean r2 = true;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.f = null;
        this.d = null;
        this.b.setImageDrawable(null);
        if (r0 != null) goto L8;
    L10:
        r2 = false;
    L11:
        if (r2 == false) goto L13;
        r0.invokeOnCompletion(new s(r1));
    L15:
        this.e = null;
        return;
    L13:
        if (r1 == null) goto L15;
        r1.b();
        goto L15
    L8:
        if (r0.isCompleted() == true) goto L10;
        goto L10
    }

    public SharePuzzleImageItemViewHolder(View r5, LifecycleCoroutineScope r6) {
        Intrinsics.checkNotNullParameter(r5, "itemView");
        Intrinsics.checkNotNullParameter(r6, "lifecycleCoroutineScope");
        super(r5);
        this.a = r6;
        AppCompatImageView r7 = r5.findViewById(2131386123);
        this.b = r7;
        this.c = (ShadowLayout) r5.findViewById(2131386038);
        this.g = (ProgressBar) r5.findViewById(2131383286);
        this.h = UIUtils.getScreenWidth(r5.getContext()) - i5.l0();
        int r0 = m0.a;
        this.i = (int) ((((double) m0.a(r5.getContext())) * 0.8d) - ((double) i5.P()));
        r7.setOutlineProvider(new a());
        r7.setClipToOutline(true);
    }

    public static final Object T3(SharePuzzleImageItemViewHolder r4, String r5, String r6, m r7, Continuation r8) {
        r4.getClass();
        if ((r8 instanceof SharePuzzleImageItemViewHolder$fetchBitmap$1) == false) goto L7;
        SharePuzzleImageItemViewHolder$fetchBitmap$1 r0 = (SharePuzzleImageItemViewHolder$fetchBitmap$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 != 1) goto L15;
        r7 = (m) r0.L$1;
        r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L31
    L20:
        CloseableReference<CloseableImage> r11 = (CloseableReference) r9;     // Catch: Throwable -> L31
        if (r11 == null) goto L28;
        r7.a(r6, r11);     // Catch: Throwable -> L31
        Object r12 = r11.get();     // Catch: Throwable -> L31
        if ((r12 instanceof CloseableStaticBitmap) == false) goto L25;
        CloseableStaticBitmap r13 = (CloseableStaticBitmap) r12;     // Catch: Throwable -> L31
    L26:
        if (r13 == null) goto L28;
        Bitmap r14 = r13.getUnderlyingBitmap();     // Catch: Throwable -> L31
    L29:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L31
    L33:
        Object r16 = r15;
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L40;
        if ((r17 instanceof CancellationException) == false) goto L40;
        throw r17;
    L40:
        if (Result.isFailure-impl(r16) == true) goto L42;
        return r16;
    L42:
        return null;
    L25:
        r13 = null;
    L28:
        r14 = null;
        goto L29
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r9);
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L31
        r0.L$0 = r6;     // Catch: Throwable -> L31
        r0.L$1 = r7;     // Catch: Throwable -> L31
        r0.label = 1;     // Catch: Throwable -> L31
        r9 = ImageLoaderKt.i(r5, "creation_share", null, r0, 60);     // Catch: Throwable -> L31
        if (r9 != r10) goto L20;
        return r10;
    L31:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new SharePuzzleImageItemViewHolder$fetchBitmap$1(r4, r8);
        goto L8
    }
}

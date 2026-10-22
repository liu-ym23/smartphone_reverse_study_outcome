package com.larus.community.impl.detail.prompt;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.Image;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/community/impl/detail/prompt/CreationDetailPromptRefImageViewerDialog;", "Landroidx/fragment/app/DialogFragment;", "activity", "Landroidx/fragment/app/FragmentActivity;", "image", "Lcom/larus/platform/api/Image;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/larus/platform/api/Image;)V", "()V", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageViewContainer", "Landroid/widget/FrameLayout;", "currentBitmapReference", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "getTheme", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "view", "Landroid/view/View;", "addAction", "fillImageViewAndResize", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailPromptRefImageViewerDialog extends DialogFragment {
    public final Image d;
    public SimpleDraweeView e;
    public FrameLayout f;

    public static final class a {
    }

    static {
    }

    public CreationDetailPromptRefImageViewerDialog() {
        this(null);
        S90(this);     // Catch: IllegalStateException -> L5
        return;
    L5:
        FLogger.a.e("CreationDetailPromptRefImageViewerDialog", "fallback by dismiss failed");
    }

    public final int getTheme() {
        return 2131952450;
    }

    public CreationDetailPromptRefImageViewerDialog(Image r1) {
        this.d = r1;
    }

    public static void S90(CreationDetailPromptRefImageViewerDialog r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final Dialog onCreateDialog(Bundle r10) {
        View r0 = LayoutInflater.from(getContext()).inflate(2131561999, null);
        if (r0 == null) goto L5;
        this.e = r0.findViewById(2131392618);
        FrameLayout r1 = (FrameLayout) r0.findViewById(2131392619);
        this.f = r1;
        if (r1 == null) goto L9;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
    L11:
        if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L13;
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
    L14:
        if (r3 == null) goto L18;
        r3.topMargin = AppHost.a.getApplication().getResources().getDimensionPixelSize(v19.c.b(2130971490, null, 2131167350));
        int r4 = m0.a;
        r3.width = m0.b(getContext());
        int r5 = m0.b(getContext());
        float r6 = r5 / 0.75f;
        r3.height = (int) RangesKt.coerceAtMost(RangesKt.coerceAtMost(c7.b(600), RangesKt.coerceAtMost(m0.a(getContext()) * 0.7f, r6)), r6 * 1.0f);
        FrameLayout r7 = this.f;
        if (r7 == null) goto L18;
        r7.setLayoutParams(r3);
    L18:
        r0.setOnClickListener(new k(this));
        SimpleDraweeView r8 = this.e;
        if (r8 == null) goto L21;
        r8.setOnClickListener(new l(this));
    L21:
        RoundingParams r9 = RoundingParams.fromCornersRadius(i5.h());
        SimpleDraweeView r11 = this.e;
        if (r11 == null) goto L26;
        GenericDraweeHierarchy r12 = r11.getHierarchy();
        if (r12 == null) goto L26;
        r12.setRoundingParams(r9);
    L26:
        Image r13 = this.d;
        if (r13 == null) goto L29;
        String r14 = r13.a;
    L30:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationDetailPromptRefImageViewerDialog$fillImageViewAndResize$1(r14, this, null), 3, null);
        Dialog r15 = super.onCreateDialog(r10);
        r15.setContentView(r0);
        Window r16 = r15.getWindow();
        if (r16 == null) goto L33;
        r16.setLayout(-1, -1);
    L33:
        Window r17 = r15.getWindow();
        if (r17 == null) goto L36;
        r17.setDimAmount(0.85f);
    L36:
        return r15;
    L29:
        r14 = null;
        goto L30
    L13:
        r3 = null;
        goto L14
    L9:
        r2 = null;
        goto L11
    L5:
        return super.onCreateDialog(r10);
    }
}

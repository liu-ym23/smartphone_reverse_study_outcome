package com.larus.account.saas.ui.internal.widget;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larus/account/saas/ui/internal/widget/AccountSaasCircleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "account-saas-ui-android_release"}, k = 1, mv = {1, 7, 1})
public final class AccountSaasCircleImageView extends AppCompatImageView {

    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r4, Outline r5) {
            Intrinsics.checkNotNullParameter(r4, "view");
            Intrinsics.checkNotNullParameter(r5, "outline");
            int r0 = RangesKt.coerceAtMost(r4.getWidth(), r4.getHeight());
            if (r0 > 0) goto L5;
            return;
        L5:
            int r1 = (r4.getWidth() - r0) / 2;
            int r6 = (r4.getHeight() - r0) / 2;
            r5.setOval(r1, r6, r1 + r0, r0 + r6);
        }
    }

    public AccountSaasCircleImageView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AccountSaasCircleImageView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AccountSaasCircleImageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        setClipToOutline(true);
        setOutlineProvider(new a());
    }

    public /* synthetic */ AccountSaasCircleImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.ImageView*/.onSizeChanged(r1, r2, r3, r4);
        invalidateOutline();
    }
}

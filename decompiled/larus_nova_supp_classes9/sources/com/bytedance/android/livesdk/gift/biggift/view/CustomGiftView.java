package com.bytedance.android.livesdk.gift.biggift.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.livesdk.gift.model.q3;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000b\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/gift/biggift/view/CustomGiftView;", "Landroid/widget/RelativeLayout;", "Lcom/bytedance/android/livesdk/gift/biggift/view/CustomGiftHintDialog$a;", "onCustomGiftDialogListener", BuildConfig.FLAVOR, "setOnCustomGiftDialogListener", "Lcom/bytedance/android/livesdk/gift/model/q3;", "info", "setDialogData", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomGiftView extends RelativeLayout {
    public FrameLayout a;
    public CustomGiftHintDialog b;
    public TextView c;

    public CustomGiftView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        a(r2);
    }

    public final void a(Context r2) {
        LayoutInflater.from(r2).inflate(2131567647, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.a = (FrameLayout) findViewById(2131368403);
        this.b = (CustomGiftHintDialog) findViewById(2131368398);
        this.c = (TextView) findViewById(2131368402);
        FrameLayout r3 = this.a;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftLeftLayout");
    L5:
        ViewUtilsKt.f(r3);
    }

    public final void setDialogData(q3 r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        CustomGiftHintDialog r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftHintDialog");
    L5:
        r0.setData(r3);
        FrameLayout r4 = this.a;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftLeftLayout");
    L8:
        ViewUtilsKt.e(r4);
    }

    public final void setOnCustomGiftDialogListener(CustomGiftHintDialog.a r3) {
        Intrinsics.checkNotNullParameter(r3, "onCustomGiftDialogListener");
        CustomGiftHintDialog r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftHintDialog");
    L5:
        r0.setOnCustomGiftDialogListener(r3);
    }

    public CustomGiftView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        a(r2);
    }
}

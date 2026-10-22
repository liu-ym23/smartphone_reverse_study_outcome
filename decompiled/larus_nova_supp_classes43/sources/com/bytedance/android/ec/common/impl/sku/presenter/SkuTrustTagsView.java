package com.bytedance.android.ec.common.impl.sku.presenter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.ec.common.impl.sku.view.SkuTrustTagContentView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/presenter/SkuTrustTagsView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/ec/common/impl/sku/view/SkuTrustTagContentView;", "a", "Lcom/bytedance/android/ec/common/impl/sku/view/SkuTrustTagContentView;", "getContentView", "()Lcom/bytedance/android/ec/common/impl/sku/view/SkuTrustTagContentView;", "setContentView", "(Lcom/bytedance/android/ec/common/impl/sku/view/SkuTrustTagContentView;)V", "contentView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuTrustTagsView extends LinearLayout {
    public SkuTrustTagContentView a;

    public SkuTrustTagsView(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public SkuTrustTagsView(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    public final SkuTrustTagContentView getContentView() {
        return this.a;
    }

    public final void setContentView(SkuTrustTagContentView r1) {
        this.a = r1;
    }

    public SkuTrustTagsView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        setPadding(com.bytedance.android.shopping.extensions.b.b(8), 0, com.bytedance.android.shopping.extensions.b.b(8), 0);
        setGravity(16);
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-2, -2);
        r13.gravity = 16;
        Unit r14 = Unit.INSTANCE;
        setLayoutParams(r13);
    }

    public /* synthetic */ SkuTrustTagsView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}

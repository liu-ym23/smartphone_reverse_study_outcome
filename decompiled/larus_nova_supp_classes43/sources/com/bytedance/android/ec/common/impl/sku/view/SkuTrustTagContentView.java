package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.ec.model.sku.ContentInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/view/SkuTrustTagContentView;", "Landroid/widget/LinearLayout;", "", "a", "Z", "getHasExposed", "()Z", "setHasExposed", "(Z)V", "hasExposed", "", "Lcom/bytedance/android/ec/model/sku/ContentInfo;", "b", "Ljava/util/List;", "getShowContents", "()Ljava/util/List;", "setShowContents", "(Ljava/util/List;)V", "showContents", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuTrustTagContentView extends LinearLayout {
    public boolean a;
    public List<ContentInfo> b;

    public SkuTrustTagContentView(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public SkuTrustTagContentView(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    public final boolean getHasExposed() {
        return this.a;
    }

    public final List<ContentInfo> getShowContents() {
        return this.b;
    }

    public final void setHasExposed(boolean r1) {
        this.a = r1;
    }

    public final void setShowContents(List<ContentInfo> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.b = r10;
    }

    public SkuTrustTagContentView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.b = new ArrayList();
    }

    public /* synthetic */ SkuTrustTagContentView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}

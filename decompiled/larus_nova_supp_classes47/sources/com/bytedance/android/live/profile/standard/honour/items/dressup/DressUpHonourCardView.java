package com.bytedance.android.live.profile.standard.honour.items.dressup;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.live.profile.standard.honour.items.StandardHonourCardView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016R\u001d\u0010\r\u001a\u0004\u0018\u00010\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/profile/standard/honour/items/dressup/DressUpHonourCardView;", "Lcom/bytedance/android/live/profile/standard/honour/items/StandardHonourCardView;", "Lcom/bytedance/android/live/profile/standard/honour/items/dressup/b;", "", "scale", "", "setDressIconScale", "alpha", "setDressIconAlpha", "i", "Lkotlin/Lazy;", "getTransitionViewHolder", "()Lcom/bytedance/android/live/profile/standard/honour/items/dressup/b;", "transitionViewHolder", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DressUpHonourCardView extends StandardHonourCardView implements b {
    public static final /* synthetic */ int j = 0;
    public final Lazy i;

    public DressUpHonourCardView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DressUpHonourCardView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final b getTransitionViewHolder() {
        return (b) this.i.getValue();
    }

    @Override // com.bytedance.android.live.profile.standard.honour.items.dressup.b
    public void setDressIconAlpha(float r2) {
        b r0 = getTransitionViewHolder();
        if (r0 == null) goto L6;
        r0.setDressIconAlpha(r2);
        return;
    }

    @Override // com.bytedance.android.live.profile.standard.honour.items.dressup.b
    public void setDressIconScale(float r2) {
        b r0 = getTransitionViewHolder();
        if (r0 == null) goto L6;
        r0.setDressIconScale(r2);
        return;
    }

    public DressUpHonourCardView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.i = LazyKt.lazy(new DressUpHonourCardView$transitionViewHolder$2(this));
    }

    public /* synthetic */ DressUpHonourCardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

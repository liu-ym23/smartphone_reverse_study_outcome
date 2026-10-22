package com.bytedance.android.live.profile.standard.honour.items.dressup;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.live.profile.standard.honour.items.standardv3.StandardHonourCardViewV3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profile/standard/honour/items/dressup/DressUpHonourCardViewV3;", "Lcom/bytedance/android/live/profile/standard/honour/items/standardv3/StandardHonourCardViewV3;", "Lcom/bytedance/android/live/profile/standard/honour/items/dressup/b;", "", "scale", "", "setDressIconScale", "alpha", "setDressIconAlpha", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DressUpHonourCardViewV3 extends StandardHonourCardViewV3 implements b {
    public DressUpHonourCardViewV3(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DressUpHonourCardViewV3(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.live.profile.standard.honour.items.dressup.b
    public void setDressIconAlpha(float r1) {
    }

    @Override // com.bytedance.android.live.profile.standard.honour.items.dressup.b
    public void setDressIconScale(float r1) {
    }

    public DressUpHonourCardViewV3(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ DressUpHonourCardViewV3(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

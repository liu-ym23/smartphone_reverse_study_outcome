package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.view.error;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.scope.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lp0.a;
import lp0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/view/error/OpenPlatformFullScreenErrorView;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/view/error/AbsOpenPlatformErrorView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getLayoutId", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformFullScreenErrorView extends AbsOpenPlatformErrorView {
    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.view.error.AbsOpenPlatformErrorView
    public int getLayoutId() {
        m r0 = m.e;
        r0.getClass();
        if (b.d((a) r0.a(m.d, a.class)) == false) goto L5;
        return 2131566937;
    L5:
        return 2131566938;
    }

    public OpenPlatformFullScreenErrorView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public OpenPlatformFullScreenErrorView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public OpenPlatformFullScreenErrorView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }
}

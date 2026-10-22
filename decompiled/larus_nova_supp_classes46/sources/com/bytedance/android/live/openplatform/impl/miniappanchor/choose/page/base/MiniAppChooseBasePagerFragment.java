package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base;

import android.os.Bundle;
import android.view.View;
import com.bytedance.android.live.core.ui.BaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/base/MiniAppChooseBasePagerFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MiniAppChooseBasePagerFragment extends BaseFragment {
    public boolean d;
    public boolean e;

    public abstract void S90();

    public void onDestroyView() {
        super.onDestroyView();
        this.e = false;
        this.d = false;
    }

    public MiniAppChooseBasePagerFragment() {
    }

    public final void setUserVisibleHint(boolean r1) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r1);
        if (r1 == true) goto L5;
        return;
    L5:
        if (getUserVisibleHint() == true) goto L7;
        return;
    L7:
        if (this.d == true) goto L9;
        return;
    L9:
        if (this.e == true) goto L15;
        S90();
        this.e = true;
        return;
    }

    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        this.d = true;
        if (getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (this.d == true) goto L7;
        return;
    L7:
        if (this.e == true) goto L12;
        S90();
        this.e = true;
        return;
    }
}

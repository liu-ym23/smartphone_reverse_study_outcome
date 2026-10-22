package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractLinkRecordFragment;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkRecordFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b0 implements View.OnClickListener {
    public final /* synthetic */ InteractRecordContainerFragment a;

    public b0(InteractRecordContainerFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        InteractRecordContainerFragment r4 = this.a;
        int r0 = InteractRecordContainerFragment.o;
        boolean r1 = true;
        if (r4.ba0(2131384040).getCurrentItem() == 1) goto L7;
        r1 = false;
    L7:
        if (r1 == false) goto L14;
        InteractPkRecordFragment r2 = this.a.i;
        if (r2 != null) goto L11;
        return;
    L11:
        if (((LinearLayout) r2.fa0(2131378691)).isShown() == true) goto L13;
        UtilityKotlinExtentionsKt.w(r2.fa0(2131378691));
        return;
    L13:
        UtilityKotlinExtentionsKt.t(r2.fa0(2131378691));
        return;
    L14:
        InteractLinkRecordFragment r5 = this.a.j;
        if (r5 != null) goto L17;
        return;
    L17:
        if (((LinearLayout) r5.fa0(2131378691)).isShown() == true) goto L19;
        UtilityKotlinExtentionsKt.w(r5.fa0(2131378691));
        return;
    L19:
        UtilityKotlinExtentionsKt.t(r5.fa0(2131378691));
    }
}

package com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b;
import com.bytedance.android.live.ktv.common.ordersong.view.KtvTextSwitcher;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/CommonOrderFirstLevelTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/BaseFirstLevelTabFragment;", "<init>", "()V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public class CommonOrderFirstLevelTabFragment extends BaseFirstLevelTabFragment {
    public ConstraintLayout s;
    public View t;
    public KtvTextSwitcher u;
    public ConstraintLayout v;
    public TextView w;
    public FrameLayout x;

    public CommonOrderFirstLevelTabFragment() {
        super(null, null);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment, com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public final int getLayoutId() {
        return 2131566457;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a
    public String aK() {
        return s1.B(2131918483);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a
    public final FirstLevelTab VL() {
        return FirstLevelTab.OrderSongTab;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment, com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public void initView(View r3) {
        super.initView(r3);
        FrameLayout r0 = null;
        if (r3 == null) goto L5;
        ConstraintLayout r1 = (ConstraintLayout) r3.findViewById(2131377062);
    L6:
        this.s = r1;
        if (r3 == null) goto L9;
        View r2 = r3.findViewById(2131377063);
    L10:
        this.t = r2;
        if (r3 == null) goto L13;
        KtvTextSwitcher r4 = (KtvTextSwitcher) r3.findViewById(2131388509);
    L14:
        this.u = r4;
        if (r3 == null) goto L17;
        ConstraintLayout r5 = (ConstraintLayout) r3.findViewById(2131382415);
    L18:
        this.v = r5;
        if (r3 == null) goto L21;
        TextView r6 = (TextView) r3.findViewById(2131382417);
    L22:
        this.w = r6;
        if (r3 == null) goto L25;
        TextView r7 = (TextView) r3.findViewById(2131382416);
    L25:
        if (r3 == null) goto L27;
        r0 = (FrameLayout) r3.findViewById(2131385643);
    L27:
        this.x = r0;
        return;
    L21:
        r6 = null;
        goto L22
    L17:
        r5 = null;
        goto L18
    L13:
        r4 = null;
        goto L14
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public CommonOrderFirstLevelTabFragment(String r1, b r2) {
        super(r1, r2);
    }
}

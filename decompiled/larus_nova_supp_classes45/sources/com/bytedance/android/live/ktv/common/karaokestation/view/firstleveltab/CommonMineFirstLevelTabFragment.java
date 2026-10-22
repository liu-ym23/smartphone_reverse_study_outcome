package com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b;
import com.bytedance.android.live.ktv.common.ordersong.view.SongTextSwitcher;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/CommonMineFirstLevelTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/BaseFirstLevelTabFragment;", "<init>", "()V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public class CommonMineFirstLevelTabFragment extends BaseFirstLevelTabFragment {
    public FrameLayout s;
    public SongTextSwitcher t;
    public ConstraintLayout u;
    public TextView v;
    public View w;

    public CommonMineFirstLevelTabFragment() {
        super(null, null);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment
    public final boolean U90() {
        return false;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment, com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public final int getLayoutId() {
        return 2131566456;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a
    public final String aK() {
        return s1.B(2131918415);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a
    public final FirstLevelTab VL() {
        return FirstLevelTab.MySongTab;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment, com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public void initView(View r3) {
        super.initView(r3);
        View r0 = null;
        if (r3 == null) goto L5;
        FrameLayout r1 = (FrameLayout) r3.findViewById(2131385881);
    L6:
        this.s = r1;
        if (r3 == null) goto L9;
        SongTextSwitcher r2 = (SongTextSwitcher) r3.findViewById(2131386993);
    L10:
        this.t = r2;
        if (r3 == null) goto L13;
        ConstraintLayout r4 = (ConstraintLayout) r3.findViewById(2131382415);
    L14:
        this.u = r4;
        if (r3 == null) goto L17;
        TextView r5 = (TextView) r3.findViewById(2131382417);
    L18:
        this.v = r5;
        if (r3 == null) goto L21;
        TextView r6 = (TextView) r3.findViewById(2131382416);
    L21:
        if (r3 == null) goto L23;
        r0 = r3.findViewById(2131379657);
    L23:
        this.w = r0;
        return;
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

    public CommonMineFirstLevelTabFragment(String r1, b r2) {
        super(r1, r2);
    }
}

package com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.ktv.common.commonui.KtvCommonEmptyView;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/CommonDefaultSecondLevelTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/BaseSecondLevelTabFragment;", "<init>", "()V", "a", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public class CommonDefaultSecondLevelTabFragment extends BaseSecondLevelTabFragment {
    public static final /* synthetic */ int n = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public int getLayoutId() {
        return 2131566452;
    }

    public CommonDefaultSecondLevelTabFragment() {
        y r0 = new y(0, 0, 65535);
        Intrinsics.checkNotNullParameter(r0, "secondLevelTabData");
        super(r0, null);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public void initView(View r3) {
        if (r3 == null) goto L4;
        ConstraintLayout r0 = r3.findViewById(2131387826);
    L4:
        KtvCommonEmptyView r1 = null;
        if (r3 == null) goto L7;
        CommonSongListView r2 = (CommonSongListView) r3.findViewById(2131380498);
    L8:
        this.g = r2;
        if (r3 == null) goto L11;
        r1 = (KtvCommonEmptyView) r3.findViewById(2131371607);
    L11:
        this.h = r1;
        if (r1 == null) goto L15;
        r1.b(this.k.c, false);
        return;
    L15:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public CommonDefaultSecondLevelTabFragment(y r2, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3) {
        Intrinsics.checkNotNullParameter(r2, "secondLevelTabData");
        super(r2, r3);
    }
}

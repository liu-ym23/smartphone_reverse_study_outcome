package com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.commonui.KtvCommonEmptyView;
import com.bytedance.android.live.ktv.common.karaokestation.model.SecondLevelTabViewSelectedType;
import com.bytedance.android.live.ktv.common.karaokestation.model.UpdateTabType;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/CustomSecondLevelTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/BaseTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/c;", "<init>", "()V", "a", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CustomSecondLevelTabFragment extends BaseTabFragment implements c {
    public static final /* synthetic */ int k = 0;
    public FrameLayout e;
    public final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b f;
    public final y g;
    public final Function3<Fragment, FrameLayout, View, Unit> h;
    public final Function0<Unit> i;
    public final Function2<Integer, String, Unit> j;

    public static final class a {
    }

    static {
    }

    public CustomSecondLevelTabFragment() {
        this(null, new y(0, 0, 65535), null, null, null);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c
    public final void W30(Function0<Unit> r1) {
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public final int getLayoutId() {
        return 2131566489;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c
    public final boolean yf() {
        return false;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c
    public final String Ms() {
        return this.g.c;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c
    public final void O0() {
        Function0<Unit> r0 = this.i;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public final void initData() {
        Function3<Fragment, FrameLayout, View, Unit> r0 = this.h;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke(this, this.e, getView());
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public final void initView(View r2) {
        if (r2 == null) goto L4;
        ConstraintLayout r0 = r2.findViewById(2131387826);
    L4:
        if (r2 == null) goto L6;
        FrameLayout r1 = (FrameLayout) r2.findViewById(2131368413);
    L7:
        this.e = r1;
        if (r2 == null) goto L11;
        KtvCommonEmptyView r3 = (KtvCommonEmptyView) r2.findViewById(2131371607);
        return;
    L11:
        return;
    L6:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c
    public final Function3<List<MusicPanel>, List<Object>, y, Unit> ms(List<? extends Object> r1) {
        return IBaseSecondLevelTab$getFillAdapterDataAction$1.INSTANCE;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c
    public final void ok(y r3, Function3<? super List<MusicPanel>, ? super List<Object>, ? super y, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "secondLevelTabData");
        Intrinsics.checkNotNullParameter(r4, "fillAdapterDataAction");
        Intrinsics.checkNotNullParameter(r3, "secondLevelTabData");
        Intrinsics.checkNotNullParameter(r4, "fillAdapterDataAction");
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c
    public final void rs(SecondLevelTabViewSelectedType r4, y r5) {
        Intrinsics.checkNotNullParameter(r4, "secondLevelTabViewSelectedType");
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r6 = this.f;
        String r0 = null;
        if (r6 == null) goto L7;
        Pair<Integer, UpdateTabType> r7 = r6.getSelectedFirstLevelTabValue();
        if (r7 == null) goto L7;
        Integer r8 = (Integer) r7.getFirst();
    L8:
        if (r5 == null) goto L10;
        Integer r1 = Integer.valueOf(r5.k);
    L11:
        boolean r9 = Intrinsics.areEqual(r8, r1);
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2 = this.f;
        if (r2 == null) goto L19;
        if (r5 == null) goto L15;
        int r3 = r5.k;
    L16:
        y r11 = r2.getSelectedSecondLevelTabData(r3);
        if (r11 == null) goto L19;
        String r12 = r11.c;
    L20:
        if (r5 == null) goto L22;
        r0 = r5.c;
    L22:
        boolean r13 = Intrinsics.areEqual(r12, r0);
        if (r9 == false) goto L30;
        if (r13 == false) goto L31;
        if (r5 == null) goto L32;
        ALogger.i("CustomSecondLevelTabFragment", "onSecondLevelTabSelectStateChange ;; " + r5.d);
        Function2<Integer, String, Unit> r14 = this.j;
        if (r14 == null) goto L33;
        Unit r15 = (Unit) r14.invoke(Integer.valueOf(r5.k), r5.d);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L15:
        r3 = 0;
    L19:
        r12 = null;
        goto L20
    L10:
        r1 = null;
    L7:
        r8 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomSecondLevelTabFragment(com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2, y r3, Function3<? super Fragment, ? super FrameLayout, ? super View, Unit> r4, Function0<Unit> r5, Function2<? super Integer, ? super String, Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "secondLevelTabData");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = r6;
    }
}

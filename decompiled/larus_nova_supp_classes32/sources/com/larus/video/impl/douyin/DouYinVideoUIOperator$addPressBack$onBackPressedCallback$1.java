package com.larus.video.impl.douyin;

import androidx.activity.OnBackPressedCallback;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/larus/video/impl/douyin/DouYinVideoUIOperator$addPressBack$onBackPressedCallback$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", NameKeys.UnloadStrategy_No_Strategy, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DouYinVideoUIOperator$addPressBack$onBackPressedCallback$1 extends OnBackPressedCallback {
    public final /* synthetic */ pr9.h a;
    public final /* synthetic */ v b;

    public final void handleOnBackPressed() {
        pr9.h r0 = this.a;
        if (r0 == null) goto L5;
        boolean r1 = r0.onBackPressed();
    L6:
        if (r1 == true) goto L12;
        e19.t r2 = e19.t.j;
        e19.t r3 = e19.t.a.a();
        if (r3 == null) goto L10;
        DouYinVideoActivity r4 = this.b.a;
        Intrinsics.checkNotNullParameter(r4, "activity");
        com.larus.common_ui.floatwindow.view.c r5 = r3.c;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r4, "activity");
        r5.c.i(r4);
    L10:
        this.b.a.supportFinishAfterTransition();
        return;
    L12:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public DouYinVideoUIOperator$addPressBack$onBackPressedCallback$1(pr9.h r1, v r2) {
        this.a = r1;
        this.b = r2;
        super(true);
    }
}

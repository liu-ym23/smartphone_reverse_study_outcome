package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/wm/MultiLinkEnlargeWindowManager;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/wm/CommonMultiLinkWindowManager;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkEnlargeWindowManager extends CommonMultiLinkWindowManager {
    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void L() {
        l1();
        if (this.M != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        boolean r1 = this.n;
        if (r1 == false) goto L16;
        hg6.g r2 = BaseMultiLinkWindowManager.h0(r1);
        if (r2 == null) goto L15;
        r2.v();
        return;
    L15:
        return;
    L16:
        return;
    L14:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void O() {
        super.O();
        if (this.M != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        boolean r1 = this.n;
        if (r1 == false) goto L16;
        hg6.g r2 = BaseMultiLinkWindowManager.h0(r1);
        if (r2 == null) goto L15;
        r2.U();
        return;
    L15:
        return;
    L16:
        return;
    L14:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void end() {
        super.end();
        if (this.M != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        boolean r1 = this.n;
        if (r1 == false) goto L16;
        hg6.g r2 = BaseMultiLinkWindowManager.h0(r1);
        if (r2 == null) goto L15;
        r2.U();
        return;
    L15:
        return;
    L16:
        return;
    L14:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void l(boolean r2, Pair<Integer, Integer> r3, Pair<Integer, Integer> r4) {
        Intrinsics.checkNotNullParameter(r3, "livePlayerVideoSize");
        Intrinsics.checkNotNullParameter(r4, "livePlayerLayoutSize");
        super.l(r2, r3, r4);
        if (this.M != null) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L14;
        boolean r6 = this.n;
        if (r6 == false) goto L16;
        hg6.g r7 = BaseMultiLinkWindowManager.h0(r6);
        if (r7 == null) goto L15;
        r7.v();
        return;
    L15:
        return;
    L16:
        return;
    L14:
        return;
    L5:
        r5 = false;
        goto L6
    }

    public MultiLinkEnlargeWindowManager(Context r2, ConstraintLayout r3, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r4, zj0.c r5, com.bytedance.android.live.liveinteract.plantform.datamerge.d r6, DataCenter r7, tf0.o.a r8, PlatformMultiLinkWidget r9, View r10, GLSurfaceView r11, com.bytedance.android.live.pushstream.d r12, PlatformMultiLinkWidget r13) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "layoutConfig");
        Intrinsics.checkNotNullParameter(r6, "dataMergeCenter");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        Intrinsics.checkNotNullParameter(r8, "callBack");
        Intrinsics.checkNotNullParameter(r9, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r10, "interactEmojiLayout");
        Intrinsics.checkNotNullParameter(r11, "renderContainer");
        super(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }
}

package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b1 extends e {
    public final ViewGroup l;
    public final IRoom m;

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.e
    public final FrameLayout c() {
        return (FrameLayout) this.l.findViewById(2131370477);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.e
    public final FrameLayout d() {
        return (FrameLayout) this.l.findViewById(2131370478);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.e
    public final FrameLayout e() {
        return (FrameLayout) this.l.findViewById(2131380433);
    }

    public b1(Context r2, ih0.b r3, ViewGroup r4, String r5, IRoom r6, boolean r7, String r8, DataCenter r9) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "service");
        Intrinsics.checkNotNullParameter(r4, "mLinkRootView");
        Intrinsics.checkNotNullParameter(r5, "mBizId");
        Intrinsics.checkNotNullParameter(r6, "mRoom");
        super(r2, r3, r4, r5, r6, r7, r8, r9);
        this.l = r4;
        this.m = r6;
    }
}

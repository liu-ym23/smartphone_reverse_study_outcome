package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.view.View;
import android.widget.CompoundButton;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ AudioTalkSettingFragment a;

    public h(AudioTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r4, boolean r5) {
        AudioTalkSettingFragment r6 = this.a;
        IRoom r0 = r6.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L5:
        com.bytedance.android.live.liveinteract.linkpanel.util.o.O(r0, r5, r6.m);
        View r1 = r6.h;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L9:
        if (r1.findViewById(2131381839).getVisibility() != 0) goto L14;
        View r7 = r6.h;
        if (r7 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L13:
        UtilityKotlinExtentionsKt.t(r7.findViewById(2131381839));
    L14:
        com.bytedance.android.live.liveinteract.linkpanel.util.w.e(r5);
    }
}

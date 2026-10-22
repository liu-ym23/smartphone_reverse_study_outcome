package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livehostapi.business.shareinter.ILiveIMShareTitleWithConListListener;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMContact;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMShareContactType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements ILiveIMShareTitleWithConListListener {
    public final /* synthetic */ AudienceShareIMElement a;
    public final /* synthetic */ ViewGroup b;

    public final void onCancelClick() {
        ALogger.i("MoreMixSharePanel", "onCancelClick");
    }

    public final void onContactVisible(boolean r2) {
        ALogger.i("MoreMixSharePanel", "onContactVisible");
        ViewGroup r3 = this.a.j;
        if (r3 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r3);
    L5:
        ViewGroup r4 = this.a.k;
        if (r4 == null) goto L9;
        UtilityKotlinExtentionsKt.t(r4);
        return;
    }

    public final void onScrollStateChanged(int r2) {
        ALogger.i("MoreMixSharePanel", "onScrollStateChanged");
    }

    public i(AudienceShareIMElement r1, ViewGroup r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onContactCancelSelect(LiveIMShareContactType r3, LiveIMContact r4) {
        Intrinsics.checkNotNullParameter(r3, "itemType");
        AudienceShareIMElement.m(this.a, r3, r4, false);
    }

    public final void onItemClick(LiveIMShareContactType r4, LiveIMContact r5) {
        Intrinsics.checkNotNullParameter(r4, "itemType");
        ALogger.i("MoreMixSharePanel", "onItemClick");
        ViewGroup r0 = this.a.f;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = a1.h(r0);
    L6:
        if (r2 != 0) goto L13;
        AudienceShareIMElement r3 = this.a;
        ViewGroup r6 = r3.f;
        if (r6 == null) goto L13;
        ViewGroup r7 = r3.e;
        if (r7 == null) goto L12;
        r1 = r7.getBottom();
    L12:
        a1.o(r6, r1);
    L13:
        AudienceShareIMElement.m(this.a, r4, r5, true);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public final void onItemVisible(LiveIMContact r1, String r2) {
        ALogger.i("MoreMixSharePanel", "onItemVisible");
    }
}

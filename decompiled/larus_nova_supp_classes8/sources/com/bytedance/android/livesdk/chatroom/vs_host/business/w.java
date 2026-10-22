package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.model.share.VsLiveShareType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w implements yr1.p, com.bytedance.android.scope.o {
    public w() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yr1.p
    public final void removePublishCallback(String r2) {
        Intrinsics.checkNotNullParameter(r2, "publishCallbackId");
        jc1.k.n(IHostShare.class).removePublishCallback(r2);
    }

    @Override // yr1.p
    public final View getQuickShotWatermark(Context r2, String r3) {
        return jc1.k.n(IHostShare.class).getQuickShotWatermark(r2, r3);
    }

    @Override // yr1.p
    public final void a(xr1.a r23, String r24, VsLiveShareType r25, com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior.r.c r26) {
        Intrinsics.checkNotNullParameter(r23, "liveShareParams");
        Intrinsics.checkNotNullParameter(r24, "sourcePage");
        Intrinsics.checkNotNullParameter(r25, "shareType");
        ILiveShareService r2 = jc1.k.n(ILiveShareService.class);
        ShareParams r8 = r23.d;
        i81.a r0 = new i81.a(null, r23.getActivity(), null, r8, null, null, null, null, null, null, r23.k, Boolean.FALSE, null, null, null, null, false);
        switch(v.a[r25.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        LiveShareType r3 = LiveShareType.REPORT_DIALOG;
    L13:
        r2.share(r0, r24, r3, r26);
        return;
    L7:
        r3 = LiveShareType.SHARE_TEXT2FANSGROUP;
        goto L13
    L8:
        r3 = LiveShareType.SHARE_VIDEO2FANSGROUP;
        goto L13
    L9:
        r3 = LiveShareType.SHARE_ACTIVITY;
        goto L13
    L10:
        r3 = LiveShareType.SHARE_DIALOG;
        goto L13
    L11:
        r3 = LiveShareType.SHARE_THIRD;
        goto L13
    L12:
        r3 = LiveShareType.SHARE_IM;
        goto L13
    L5:
        throw new NoWhenBranchMatchedException();
    }

    @Override // yr1.p
    public final String publishToStory(Activity r8, String r9, String r10, String r11, String r12, Function1<? super Boolean, Unit> r13) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r10, "content");
        Intrinsics.checkNotNullParameter("entertainment_live_book_message_interaction_guide", "shootWay");
        Intrinsics.checkNotNullParameter("live", "enterFrom");
        return jc1.k.n(IHostShare.class).publishToStory(r8, r9, r10, "entertainment_live_book_message_interaction_guide", "live", r13);
    }
}

package com.bytedance.android.livesdk.feed.openui.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomIntentBuilder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ SimpleLiveView a;

    public j(SimpleLiveView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        SimpleLiveView r7 = this.a;
        int r0 = SimpleLiveView.g;
        r7.getClass();
        Bundle r1 = new Bundle();
        Room r2 = r7.a;
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.getLog_pb();
    L6:
        r1.putString("log_pb", r4);
        Room r5 = r7.a;
        if (r5 == null) goto L9;
        String r8 = r5.getRequestId();
    L10:
        r1.putString("request_id", r8);
        r1.putString("enter_from_merge", r7.b);
        r1.putString("enter_method", "main_tab");
        Room r9 = r7.a;
        if (r9 == null) goto L13;
        String r10 = r9.getOwnerUserIdString();
    L14:
        r1.putString("anchor_id", r10);
        r1.putString("live.intent.extra.EXTRA_LIVE_FEED_URL_NEW", r7.e);
        Bundle r11 = LiveRoomIntentBuilder.buildBundle(r7.getContext(), r7.a, "homepage_hot", r1);
        if (r11 != null) goto L17;
        return;
    L17:
        if (TTLiveSDK.hostService() != null) goto L19;
        return;
    L19:
        if (TTLiveSDK.hostService().action() == null) goto L34;
        r11.putAll(ArgumentsBuilder.buildRoomArgs(r7.a));
        if (r11.get("live.intent.extra.USER_ID") != null) goto L26;
        Room r12 = r7.a;
        if (r12 == null) goto L25;
        r3 = r12.getOwnerUserIdString();
    L25:
        r11.putString("live.intent.extra.USER_ID", r3);
    L26:
        int r13 = kw1.c.a;
        kw1.c.b(r7.getContext(), r1);
        IHostAction r14 = TTLiveSDK.hostService().action();
        Context r15 = r7.getContext();
        Room r16 = r7.a;
        if (r16 == null) goto L29;
        long r17 = r16.id;
    L30:
        r14.startLive(r15, r17, r11);
        return;
    L29:
        r17 = 0;
        goto L30
    L34:
        return;
    L13:
        r10 = null;
        goto L14
    L9:
        r8 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}

package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.d0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Maybe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements com.bytedance.android.scope.o, vr1.c {
    public e() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vr1.c
    public final void c() {
        int r0 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.a;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.l("livesdk_match_chat_badgeview_click", new HashMap());
    }

    @Override // vr1.c
    public final boolean a(DataCenter r5) {
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, r5, 0, 2);
        if (r6 != null) goto L6;
        return false;
    L6:
        if (ChatChannelUtils.b(r6) == null) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // vr1.c
    public final Long f(DataCenter r5) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r6 = ChatChannelUtils.f(RoomContext.a.c(RoomContext.Companion, r5, 0, 2));
        if (r6 == null) goto L9;
        com.bytedance.live.datacontext.m r7 = r6.getState();
        if (r7 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.api.base.d r8 = (com.bytedance.android.livesdk.interactivity.api.base.d) r7.getValue();
        if (r8 == null) goto L9;
        return Long.valueOf(r8.b);
    L9:
        return null;
    }

    @Override // vr1.c
    public final void d(DataCenter r5, CompositeDisposable r6, d0 r7) {
        Intrinsics.checkNotNullParameter(r7, "callback");
        com.bytedance.live.datacontext.j r8 = ChatChannelUtils.n(RoomContext.a.c(RoomContext.Companion, r5, 0, 2));
        if (r8 == null) goto L10;
        Maybe r9 = r8.b();
        if (r9 == null) goto L11;
        Disposable r10 = r9.subscribe(new d(r7, r6));
        if (r10 == null) goto L12;
        RxUtilKt.c(r10, r6);
        return;
    L12:
        return;
    L11:
        return;
    }
}

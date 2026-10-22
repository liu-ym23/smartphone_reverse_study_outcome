package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.settings.config.y0;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomInteractData;
import com.bytedance.android.livesdkapi.depend.model.live.UserWorldChatInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class RoomSquareCreator implements com.bytedance.android.livesdk.chatroom.w {
    public CompositeDisposable a;
    public boolean b;
    public final RoomContext c;
    public final DataCenter d;

    public static final class a {
    }

    static {
    }

    public final void a() {
        CompositeDisposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b = false;
    }

    public final void b(Room r7) {
        if (this.b == false) goto L5;
        return;
    L5:
        y0 r0 = com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.d.a;
        DataCenter r1 = this.d;
        Intrinsics.checkNotNullParameter(r7, "room");
        Intrinsics.checkNotNullParameter(r1, "dataCenter");
        boolean r2 = r7.getRoomAuthStatus().isEnableWorldSquare();
        RoomInteractData r3 = r7.getRoomInteractData();
        boolean r4 = false;
        if (r3 == null) goto L12;
        UserWorldChatInfo r5 = r3.getSquareInfo();
        if (r5 == null) goto L12;
        if (r5.getEnableRoomSquare() != true) goto L12;
        boolean r6 = true;
    L13:
        boolean r8 = r7.isMergeVSRoom();
        if (c1.b(r1) == false) goto L16;
    L19:
        boolean r9 = true;
    L21:
        if (com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.d.b == false) goto L27;
        if (r6 == false) goto L27;
        if (r2 == false) goto L27;
        if (r8 == true) goto L27;
        if (r9 == true) goto L27;
        r4 = true;
    L27:
        if (r4 == false) goto L34;
        com.bytedance.android.livesdk.interactivity.api.h r10 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r10 == null) goto L35;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r11 = r10.getPublicScreenContext();
        if (r11 == null) goto L36;
        n32.a.a(r11, new RoomSquareCreator$tryInitSquare$1(this));
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L16:
        if (c1.c(r1) == true) goto L19;
        r9 = false;
    L12:
        r6 = false;
        goto L13
    }

    public RoomSquareCreator(RoomContext r2, DataCenter r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.c = r2;
        this.d = r3;
    }
}

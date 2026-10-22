package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w1 {
    public static final boolean a(d90.d r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isAnchor");
        DataCenter r3 = r2.h;
        if (r3 == null) goto L7;
        Boolean r4 = (Boolean) r3.get("data_is_anchor", Boolean.FALSE);
        if (r4 == null) goto L7;
        return r4.booleanValue();
    L7:
        return false;
    }

    public static final boolean b(d90.d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isLandscape");
        return !c(r1);
    }

    public static final boolean c(d90.d r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isPortrait");
        DataCenter r3 = r2.h;
        if (r3 == null) goto L7;
        Boolean r4 = (Boolean) r3.get("data_is_portrait", Boolean.TRUE);
        if (r4 == null) goto L7;
        return r4.booleanValue();
    L7:
        return true;
    }

    public static final boolean d(d90.d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isVSRoom");
        IRoom r2 = e(r1);
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.isMergeVSRoom();
    }

    public static final IRoom e(d90.d r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$vsRoom");
        DataCenter r0 = r6.h;
        IRoom r1 = null;
        if (r0 == null) goto L5;
        IRoom r2 = (IRoom) r0.get("data_room");
    L6:
        DataCenter r7 = r6.h;
        if (r7 == null) goto L10;
        r1 = (IRoom) r7.get("data_prepare_room");
    L10:
        if (r2 == null) goto L12;
        long r4 = r2.getId();
    L14:
        if (r4 <= 0) goto L17;
        return r2;
    L17:
        return r1;
    L12:
        r4 = 0;
        goto L14
    L5:
        r2 = null;
        goto L6
    }
}

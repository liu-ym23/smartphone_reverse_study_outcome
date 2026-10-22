package d90;

import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static final boolean a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isAnchor");
        DataCenter r3 = r2.h;
        if (r3 == null) goto L7;
        Boolean r4 = (Boolean) r3.get("data_is_anchor", Boolean.FALSE);
        if (r4 == null) goto L7;
        return r4.booleanValue();
    L7:
        return false;
    }

    public static final boolean b(d r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isAudienceMediaRoom");
        IRoom r0 = k(r2);
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.isMediaRoom() != true) goto L9;
        if (a(r2) == true) goto L9;
        return true;
    }

    public static final boolean c(d r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isMiddlewareAnchor");
        DataCenter r3 = r2.h;
        if (r3 == null) goto L7;
        Boolean r4 = (Boolean) r3.get("data_is_anchor", Boolean.FALSE);
        if (r4 == null) goto L7;
        return r4.booleanValue();
    L7:
        return false;
    }

    public static final boolean d(d r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isMiddlewareAudienceMediaRoom");
        Room r0 = j(r2);
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.isMediaRoom() != true) goto L9;
        if (c(r2) == true) goto L9;
        return true;
    }

    public static final boolean e(d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isMiddlewareLandscape");
        return !h(r1);
    }

    public static final boolean f(d r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$isMiddlewareLandscapeMarginOpt");
        Intrinsics.checkNotNullParameter(r5, "$this$isLandscape");
        if ((!f.a(r5)) == false) goto L11;
        MiddlewareRoomContext r6 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r5.h, 0, 2);
        if (r6 == null) goto L11;
        m r7 = r6.isOptLandscapeMargin();
        if (r7 == null) goto L11;
        if (((Boolean) r7.getValue()).booleanValue() != true) goto L11;
        return true;
    L11:
        return false;
    }

    public static final boolean g(d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isMiddlewareMediaOrVs");
        if (d(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (i(r1) == true) goto L8;
        return false;
    }

    public static final boolean h(d r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isMiddlewarePortrait");
        DataCenter r3 = r2.h;
        if (r3 == null) goto L7;
        Boolean r4 = (Boolean) r3.get("data_is_portrait", Boolean.TRUE);
        if (r4 == null) goto L7;
        return r4.booleanValue();
    L7:
        return true;
    }

    public static final boolean i(d r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$isMiddlewareVSRoom");
        Intrinsics.checkNotNullParameter(r6, "$this$middlewareVSRoom");
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
        if (r4 > 0) goto L17;
        r2 = r1;
    L17:
        if (r2 != null) goto L21;
        return false;
    L21:
        return r2.isMergeVSRoom();
    L12:
        r4 = 0;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public static final Room j(d r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$middlewareRoom");
        DataCenter r3 = r2.h;
        if (r3 != null) goto L5;
        return null;
    L5:
        return (Room) r3.get("data_room", null);
    }

    public static final IRoom k(d r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$room");
        DataCenter r3 = r2.h;
        if (r3 != null) goto L5;
        return null;
    L5:
        return (IRoom) r3.get("data_room", null);
    }

    public static final MiddlewareRoomContext l(d r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$roomContext");
        return MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r4.h, 0, 2);
    }
}

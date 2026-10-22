package com.bytedance.android.livesdk.feedback.utils;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.u50;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feedback.event.IFeedbackRoomAction;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final String a(ImageModel r3) {
        if (r3 == null) goto L16;
        List r4 = r3.mUrls;
        if (r4 != null) goto L7;
        return null;
    L7:
        if (r4.size() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
        r4 = null;
    L13:
        if (r4 != null) goto L15;
        return null;
    L15:
        return (String) ListProtector.get(r4, 0);
    L9:
        r1 = false;
        goto L10
    L16:
        return null;
    }

    @JvmStatic
    public static final boolean b(DataCenter r12, int r13) {
        Boolean r0 = u50.a.getValue().a();
        if (r0 == null) goto L5;
        boolean r1 = r0.booleanValue();
    L6:
        if (r1 == true) goto L8;
        return false;
    L8:
        if (r12 != null) goto L10;
        return false;
    L10:
        if (z.m(r12, true) == false) goto L51;
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, r12, 0, 2);
        if (r2 == null) goto L48;
        m r3 = r2.getFeedbackInterceptClose();
        if (r3 == null) goto L49;
        List r4 = (List) r3.getValue();
        if (r4 == null) goto L50;
        Iterator r5 = r4.iterator();
        boolean r6 = false;
    L20:
        if (r5.hasNext() == false) goto L36;
        IFeedbackRoomAction r7 = (IFeedbackRoomAction) ((WeakReference) r5.next()).get();
        if (r7 != null) goto L23;
        r5.remove();
        goto L20
    L23:
        if (r6 == true) goto L20;
        r6 = r7.interceptRoomClose(r13);
        if (r6 == false) goto L20;
        int r8 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r9 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LightFeedbackUtil", "page");
        r9.a = "LightFeedbackUtil";
        r9.c("shouldInterceptLeaveRoom");
        Pair[] r10 = new Pair[3];
        Room r11 = z.o(r12);
        String r14 = null;
        if (r11 == null) goto L29;
        String r15 = r11.getIdStr();
    L30:
        r10[0] = TuplesKt.to("roomId", r15);
        r10[1] = TuplesKt.to("room action", Integer.valueOf(r13));
        r10[2] = TuplesKt.to("interceptor", r7);
        r9.b(r10);
        r9.d();
        StringBuilder r16 = new StringBuilder("shouldInterceptLeaveRoom.roomId:");
        Room r17 = z.o(r12);
        if (r17 == null) goto L33;
        r14 = r17.getIdStr();
    L33:
        r16.append(r14);
        r16.append("\tthe interceptor:");
        r16.append(r7);
        ALogger.i("LightFeedbackUtil", r16.toString());
        goto L20
    L29:
        r15 = null;
        goto L30
    L36:
        return r6;
    L50:
        return false;
    L49:
        return false;
    L48:
        return false;
    L51:
        return false;
    L5:
        r1 = false;
        goto L6
    }
}

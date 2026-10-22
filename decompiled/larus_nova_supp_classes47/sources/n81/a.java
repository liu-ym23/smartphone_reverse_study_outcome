package n81;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.r4;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(DataCenter r5) {
        if (r5 == null) goto L7;
        Boolean r1 = (Boolean) r5.get("data_is_anchor", Boolean.FALSE);
        if (r1 == null) goto L7;
        boolean r2 = r1.booleanValue();
    L8:
        if (r2 == false) goto L10;
        return false;
    L10:
        if (((Boolean) r4.a.getValue()).booleanValue() == false) goto L23;
        MiddlewareRoomContext r6 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r5, 0, 2);
        if (r6 == null) goto L18;
        m r7 = r6.getRoomTabAppointmentShowed();
        if (r7 == null) goto L18;
        Boolean r8 = (Boolean) r7.getValue();
        if (r8 == null) goto L18;
        boolean r9 = r8.booleanValue();
    L19:
        if (r9 == true) goto L24;
        return true;
    L24:
        return false;
    L18:
        r9 = false;
        goto L19
    L23:
        return false;
    L7:
        r2 = false;
        goto L8
    }

    public static void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, Constants.OperatorKey.MSG);
        ALogger.i("AudienceRoomLabelUtils", r1);
    }
}

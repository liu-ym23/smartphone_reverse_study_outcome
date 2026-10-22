package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class VSMediaUIConfigHelper {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(VSMediaUIConfigHelper$setting$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean a(MiddlewareRoomContext r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.isVSRoom() != true) goto L9;
        return true;
    L9:
        if (r3.isMediaRoom() == true) goto L11;
        return false;
    L11:
        if (((Boolean) r3.isAnchor().getValue()).booleanValue() == true) goto L23;
        com.bytedance.live.datacontext.n r4 = r3.getTemplateContext();
        if (r4 == null) goto L24;
        z70.b r5 = (z70.b) r4.getValue();
        if (r5 != null) goto L17;
        return false;
    L17:
        if (r5.k() == true) goto L19;
        return false;
    L19:
        if (((Boolean) a.getValue()).booleanValue() == false) goto L27;
        return true;
    L27:
        return false;
    L24:
        return false;
    L23:
        return false;
    }

    @JvmStatic
    public static final boolean b(DataCenter r4) {
        MiddlewareRoomContext r5 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r4, 0, 2);
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.isVSRoom() == false) goto L9;
        return true;
    L9:
        if (r5.isMediaRoom() == true) goto L11;
        return false;
    L11:
        if (((Boolean) r5.isAnchor().getValue()).booleanValue() == true) goto L23;
        com.bytedance.live.datacontext.n r6 = r5.getTemplateContext();
        if (r6 == null) goto L24;
        z70.b r7 = (z70.b) r6.getValue();
        if (r7 != null) goto L17;
        return false;
    L17:
        if (r7.k() == true) goto L19;
        return false;
    L19:
        if (((Boolean) a.getValue()).booleanValue() == false) goto L27;
        return true;
    L27:
        return false;
    L24:
        return false;
    L23:
        return false;
    }

    @JvmStatic
    public static final boolean c(d90.d r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (d90.e.i(r3) == false) goto L9;
        return true;
    L9:
        if (d90.e.d(r3) == false) goto L18;
        z70.b r4 = ((h70.b) r3).a;
        if (r4 != null) goto L13;
        return false;
    L13:
        if (r4.k() == true) goto L15;
        return false;
    L15:
        if (((Boolean) a.getValue()).booleanValue() == false) goto L21;
        return true;
    L21:
        return false;
    L18:
        return false;
    }
}

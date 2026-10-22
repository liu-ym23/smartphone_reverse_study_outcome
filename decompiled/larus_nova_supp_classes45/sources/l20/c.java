package l20;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcast.xplay.XplayMessageType;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.livehostapi.business.depend.xplay.IXplayMessageInterface;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements IXplayMessageInterface.ReceiveMsgListener {
    public IXplayMessageInterface a;
    public final HashMap<XplayMessageType, h10.a> b;

    public final void onReceiveExitGameRequest() {
        XplayLog.a("XplayMessageManager", "onReceiveExitGameRequest");
    }

    public c() {
        this.b = new HashMap();
    }

    public final void onReceiveCustomMsg(String r5) {
        int r0 = XplayLog.a;
        XplayLog.c("XplayMessageManager", "onReceiveCustomMsg: " + r5);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl((a10.d) GsonHelper.get().fromJson(r5, a10.d.class));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.exceptionOrNull-impl(r6);
        if (r2 == null) goto L11;
        int r3 = XplayLog.a;
        XplayLog.b("XplayMessageManager", r2.toString());
    L11:
        if (Result.isFailure-impl(r6) == false) goto L13;
        r6 = null;
    L13:
        a10.d r7 = (a10.d) r6;
        if (r7 != null) goto L17;
        XplayLog.b("XplayMessageManager", "message receive null!");
        return;
    L17:
        HashMap<XplayMessageType, h10.a> r4 = this.b;
        XplayMessageType.a r8 = XplayMessageType.Companion;
        String r9 = r7.a();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "messageKey");
        XplayMessageType r11 = (XplayMessageType) XplayMessageType.access$getTypeMap$cp().get(r9);
        if (r11 != null) goto L20;
        r11 = XplayMessageType.UNKNOWN;
    L20:
        h10.a r12 = r4.get(r11);
        if (r12 != null) goto L24;
        int r13 = XplayLog.a;
        XplayLog.c("XplayMessageManager", "no listener, message: " + r7.a());
        return;
    L24:
        r12.a(r7);
        return;
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}

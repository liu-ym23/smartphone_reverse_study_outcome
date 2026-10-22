package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.setting.NewBroadcastSharedConfig;
import com.bytedance.android.livesdk.config.ss;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s3 extends h<k1, LiveScreenRecordActionResultModel> {

    public static final class a {
    }

    static {
    }

    public s3() {
    }

    public final void j(String r3) {
        ALogger.e("ScreenRecordActionMethod", r3);
        LiveScreenRecordActionResultModel r0 = new LiveScreenRecordActionResultModel();
        r0.a(LiveScreenRecordActionResultModel.Code.Failed);
        r0.b(r3);
        Unit r4 = Unit.INSTANCE;
        finishWithResult(r0);
    }

    public final void invoke(Object r7, CallContext r8) {
        k1 r9 = (k1) r7;
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        if (((Boolean) ss.a.getValue()).booleanValue() == true) goto L5;
        j("disabled");
        return;
    L5:
        boolean r0 = com.bytedance.android.livesdk.service.l.d().e().isRecording();
        String r1 = com.bytedance.android.livesdk.service.l.d().e().getSource();
        String r2 = r9.getType();
        String r10 = r9.a();
        ALogger.i("ScreenRecordActionMethod", "isRecording=" + r0 + " curSource=" + r1 + " type=" + r2 + " source=" + r10);
        boolean r3 = false;
        if (r2 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == true) goto L61;
        if (r10 != null) goto L15;
    L16:
        r3 = true;
    L17:
        if (r3 == true) goto L61;
        if (r2 == null) goto L60;
        int r4 = r2.hashCode();
        if (r4 == (-588535212)) goto L32;
        if (r4 != (-426842636)) goto L60;
        if (r2.equals("stop_recording") == false) goto L60;
        if (r0 == false) goto L30;
        xs2.b.a().post(new zg1.d3(r10));
        finishWithSuccess();
        ALogger.i("ScreenRecordActionMethod", "stop record success");
        return;
    L30:
        j("not recording");
        return;
    L32:
        if (r2.equals("start_recording") == false) goto L60;
        if (r0 == true) goto L59;
        com.bytedance.android.live.pushstream.d r6 = null;
        RoomContext r11 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r11 == null) goto L63;
        com.bytedance.live.datacontext.j r13 = r11.getLiveStream();
        if (r13 == null) goto L63;
        com.bytedance.android.live.pushstream.d r14 = (com.bytedance.android.live.pushstream.d) r13.getValue();
        if (r14 == null) goto L63;
        r6 = r14;
    L56:
        if (r6 != null) goto L58;
        j("failed to get liveStream");
        return;
    L58:
        finishWithSuccess();
        MainThreadPostUtils.b(new t3(r6, r10));
        ALogger.i("ScreenRecordActionMethod", "start record success");
        return;
    L63:
    L54:
        e = move-exception;
        ALogger.e("ScreenRecordActionMethod", "getLiveStream error", e);
        goto L56
    L43:
        if (NewBroadcastSharedConfig.a().booleanValue() == false) goto L47;
        g00.c r15 = (g00.c) com.bytedance.android.scope.m.e.d(f00.a.b, g00.c.class);     // Catch: Exception -> L54
        if (r15 == null) goto L50;
        r15.init();     // Catch: Exception -> L54
    L50:
        IPushStreamService r16 = jc1.k.f(IPushStreamService.class);     // Catch: Exception -> L54
        if (r16 == null) goto L56;
        r6 = r16.getRecordLiveStream(r8.getContext());     // Catch: Exception -> L54
        goto L56
    L47:
        IBroadcastService r17 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);     // Catch: Exception -> L54
        if (r17 == null) goto L50;
        r17.init();     // Catch: Exception -> L54
        goto L50
    L59:
        j("already recording");
        return;
    L60:
        j("type " + r2 + " is not supported");
        return;
    L15:
        if (r10.length() != 0) goto L17;
    L61:
        j("invalid type " + r2 + " or source " + r10);
        return;
    L8:
        if (r2.length() == 0) goto L11;
        r5 = false;
        goto L12
    }
}

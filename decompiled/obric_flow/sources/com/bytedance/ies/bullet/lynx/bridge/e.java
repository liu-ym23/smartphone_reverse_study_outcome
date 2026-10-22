package com.bytedance.ies.bullet.lynx.bridge;

import android.os.Looper;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.bullet.service.base.i;
import com.bytedance.ies.bullet.service.base.x;
import java.util.concurrent.Callable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f5611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxBridgeModule f5612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5613c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public e(boolean r5, LynxBridgeModule r10, int r11, String r12, String r13) {
        this.f5611a = r5;
        this.f5612b = r10;
        this.f5613c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        boolean r5 = this.f5611a;
        LynxBridgeModule r10 = this.f5612b;
        int r11 = this.f5613c;
        String r12 = this.d;
        String r13 = this.e;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L12
        if (r5 == true) goto L6;
        int r15 = -1;
    L7:
        tc.c r16 = tc.c.f22119c;     // Catch: Throwable -> L12
        tc.c r17 = tc.c.f22119c;     // Catch: Throwable -> L12
        com.bytedance.ies.bullet.core.e r18 = LynxBridgeModule.access$getBulletContext$p(r10);     // Catch: Throwable -> L12
        if (r18 == null) goto L14;
        String r19 = r18.f;     // Catch: Throwable -> L12
        if (r19 == null) goto L14;
    L15:
        i r20 = (i) r17.a(i.class, r19);     // Catch: Throwable -> L12
        String r21 = null;
        if (r20 == null) goto L42;
        x r22 = new x("bdx_monitor_bridge_pv");     // Catch: Throwable -> L12
        com.bytedance.ies.bullet.core.e r23 = LynxBridgeModule.access$getBulletContext$p(r10);     // Catch: Throwable -> L12
        if (r23 == null) goto L20;
        ad.a r24 = r23.f5303q;     // Catch: Throwable -> L12
    L21:
        r22.f6027j = r24;     // Catch: Throwable -> L12
        String r25 = "child";
        if (r11 != 0) goto L25;
        Object r26 = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
    L27:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L29;
        r25 = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
    L29:
        JSONObject r27 = new JSONObject();     // Catch: Throwable -> L12
        r27.put("method_name", r12);     // Catch: Throwable -> L12
        com.bytedance.ies.bullet.core.e r28 = LynxBridgeModule.access$getBulletContext$p(r10);     // Catch: Throwable -> L12
        if (r28 == null) goto L34;
        ad.a r29 = r28.f5303q;     // Catch: Throwable -> L12
        if (r29 == null) goto L34;
        r21 = r29.f157a.toString();     // Catch: Throwable -> L12
    L34:
        r27.put("_full_url", r21);     // Catch: Throwable -> L12
        r27.put("type", r13);     // Catch: Throwable -> L12
        r27.put("call_thread", r26);     // Catch: Throwable -> L12
        r27.put("callback_thread", r25);     // Catch: Throwable -> L12
        r27.put("result", r15);     // Catch: Throwable -> L12
        r22.e = r27;     // Catch: Throwable -> L12
        com.bytedance.ies.bullet.core.e r110 = LynxBridgeModule.access$getBulletContext$p(r10);     // Catch: Throwable -> L12
        if (r110 == null) goto L40;
        ad.a r111 = r110.f5303q;     // Catch: Throwable -> L12
        if (r111 == null) goto L40;
        String r112 = r111.a();     // Catch: Throwable -> L12
        if (r112 == null) goto L40;
    L41:
        r22.f6023b = r112;     // Catch: Throwable -> L12
        r22.f6024c = "lynx";     // Catch: Throwable -> L12
        r22.f6026i = Boolean.TRUE;     // Catch: Throwable -> L12
        JSONObject r113 = new JSONObject();     // Catch: Throwable -> L12
        r113.put(WsConstants.KEY_PLATFORM, 3);     // Catch: Throwable -> L12
        r22.g = r113;     // Catch: Throwable -> L12
        ((com.bytedance.ies.bullet.service.monitor.i) r20).d(r22);     // Catch: Throwable -> L12
    L43:
        Object r114 = Result.m124constructorimpl(r20);     // Catch: Throwable -> L12
    L47:
        return Result.m123boximpl(r114);
    L40:
        r112 = "Unknown";
        goto L41
    L25:
        r26 = "child";
        goto L27
    L20:
        r24 = null;
        goto L21
    L42:
        r20 = null;
    L14:
        r19 = "default_bid";
        goto L15
    L6:
        r15 = 1;
    L12:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r114 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L47
    }
}

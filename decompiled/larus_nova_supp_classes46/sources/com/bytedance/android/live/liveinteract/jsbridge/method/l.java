package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.anchormodelink.model.DynamicCenterUpdateType;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import w20.a7;
import w20.lf;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l extends a7<lf, UpdateLinkmicStatusResultModel> {
    public IKtvService a;
    public final DataCenter b;
    public final boolean c;
    public final t d;
    public final IJsBridgeManager e;
    public final s f;

    public final void invoke(Object r5, CallContext r6) {
        lf r7 = (lf) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        String r0 = r7.getType();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = r7.a();
        if (r2 == null) goto L9;
        r1 = r2;
    L9:
        JsonObject r8 = r7.b();
        Intrinsics.checkNotNullParameter(r1, "bizId");
        if (Intrinsics.areEqual(r1, "dynamic_center") == false) goto L17;
        my.c r9 = new my.c(DynamicCenterUpdateType.valueOf(r0), r1, r8);
        k r10 = new k(this);
        s r3 = this.f;
        if (r3 == null) goto L14;
        r3.P0(r9, r10, this.c);
        return;
    L14:
        iy.g r4 = com.bytedance.android.live.anchormodelink.linkroom.a.a;
        iy.g r11 = com.bytedance.android.live.anchormodelink.linkroom.a.a(this.b);
        if (r11 == null) goto L59;
        r11.P0(r9, r10, this.c);
        return;
    L59:
        return;
    L17:
        ALogger.i("DynamicUpdate", "updateLinkmicStatus: " + r0 + ", " + r8 + ", " + r1 + ", isFeed=" + this.c);
        Object r12 = null;
        DynamicUpdateType r13 = DynamicUpdateType.valueOf(r0.toUpperCase(Locale.ROOT));     // Catch: Exception -> L20
    L21:
        if (r13 != null) goto L23;
        finishWithFailure(new Throwable(r0.concat(" not defined in DynamicUpdateType")));
        return;
    L23:
        ih0.f r14 = new ih0.f(r6.d, r13, r1, r8);
        t r15 = this.d;
        if (r15 == null) goto L26;
        r15.B1(r14, new i(this), this.c);
        return;
    L26:
        j r16 = new j(this);
        if (this.a != null) goto L29;
        this.a = jc1.k.f(IKtvService.class);
    L29:
        IKtvService r17 = this.a;
        if (r17 == null) goto L32;
        Object r18 = r17.getRealTimeChorusMicManager();
    L34:
        if ((r18 instanceof t) == false) goto L37;
        r12 = r18;
    L37:
        t r19 = (t) r12;
        if (r19 == null) goto L40;
        r19.B1(r14, r16, this.c);
    L40:
        if (r8 != null) goto L56;
    L45:
        long r20 = 0;
    L46:
        ih0.b r21 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(this.b, r20);
        if (r21 == null) goto L49;
        r21.B1(r14, r16, this.c);
    L49:
        IInteractService r22 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r22 == null) goto L63;
        r22.updateLinkMicStatus(r14, r16, this.e);
        return;
    L63:
        return;
    L56:
        JsonElement r23 = r8.get("room_id");     // Catch: Exception -> L53
        if (r23 == null) goto L45;
        r20 = r23.getAsLong();     // Catch: Exception -> L53
    L32:
        r18 = null;
    L20:
        r13 = null;
        goto L21
    }

    public l(DataCenter r1, boolean r2, t r3, IJsBridgeManager r4, s r5) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }

    public /* synthetic */ l(DataCenter r7, boolean r8, com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r9, IJsBridgeManager r10, s r11, int r12) {
        if ((r12 & 2) == 0) goto L5;
        boolean r2 = false;
    L7:
        if ((r12 & 4) == 0) goto L9;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r3 = null;
    L11:
        if ((r12 & 8) == 0) goto L13;
        IJsBridgeManager r4 = null;
    L15:
        if ((r12 & 16) == 0) goto L17;
        s r5 = null;
    L18:
        this(r7, r2, r3, r4, r5);
        return;
    L17:
        r5 = r11;
        goto L18
    L13:
        r4 = r10;
        goto L15
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }
}

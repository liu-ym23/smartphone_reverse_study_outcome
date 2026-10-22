package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.anchormodelink.model.DynamicCenterGetType;
import com.bytedance.android.live.browser.jsbridge.base.GetLinkmicStatusResultModel;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.voicechat.radio.context.RadioStageContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import w20.o9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends w20.l1<o9, GetLinkmicStatusResultModel> {
    public final DataCenter a;
    public final t b;
    public final s c;

    public final void invoke(Object r5, CallContext r6) {
        o9 r7 = (o9) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        String r8 = r7.getType();
        String r0 = "";
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        String r1 = r7.a();
        if (r1 == null) goto L9;
        r0 = r1;
    L9:
        JsonObject r9 = r7.b();
        Intrinsics.checkNotNullParameter(r0, "bizId");
        JsonObject r2 = null;
        if (Intrinsics.areEqual(r0, "dynamic_center") == false) goto L17;
        my.b r3 = new my.b(DynamicCenterGetType.valueOf(r8), r0, r9);
        s r10 = this.c;
        if (r10 == null) goto L14;
        JsonObject r11 = r10.C(r3);
    L30:
        GetLinkmicStatusResultModel r12 = new GetLinkmicStatusResultModel();
        r12.b(GetLinkmicStatusResultModel.Code.Success);
        r12.c(r11);
        r12.d("get success");
        Objects.toString(r12.a());
        finishWithResult(r12);
        return;
    L14:
        iy.g r13 = com.bytedance.android.live.anchormodelink.linkroom.a.a;
        iy.g r14 = com.bytedance.android.live.anchormodelink.linkroom.a.a(this.a);
        if (r14 == null) goto L28;
        r2 = r14.C(r3);
    L28:
        r11 = r2;
        goto L30
    L17:
        ih0.e r4 = new ih0.e(DynamicGetType.valueOf(r8.toUpperCase(Locale.ROOT)), r0, r9);
        ih0.b r15 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(this.a);
        t r16 = this.b;
        if (r16 == null) goto L20;
        JsonObject r17 = r16.T(r4);
    L23:
        if (r17 != null) goto L29;
        if (r15 != null) goto L29;
        jk0.c r18 = RadioStageContext.Companion.a();
        if (r18 == null) goto L28;
        r2 = r18.T(r4);
    L29:
        r11 = r17;
        goto L30
    L20:
        if (r15 == null) goto L22;
        r17 = r15.T(r4);
        goto L23
    L22:
        r17 = null;
        goto L23
    }

    public c(DataCenter r1, t r2, s r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public /* synthetic */ c(DataCenter r1, boolean r2, s r3, int r4) {
        if ((r4 & 8) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, null, r3);
    }
}

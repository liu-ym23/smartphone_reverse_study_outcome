package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateConcertStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.concert_stage.interfaces.IConcertUpdateStatusCallback;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import w20.jb;
import w20.p3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends p3<jb, LiveUpdateConcertStatusResultModel> {
    public final b a;

    public static final class a {
    }

    public static final class b {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        public final void a(IConcertUpdateStatusCallback.Code r9, String r10, JsonObject r11) {
            Intrinsics.checkNotNullParameter(r9, "errCode");
            Intrinsics.checkNotNullParameter(r10, "errMsg");
            LiveUpdateConcertStatusResultModel r0 = new LiveUpdateConcertStatusResultModel();
            LiveUpdateConcertStatusResultModel.Code[] r1 = LiveUpdateConcertStatusResultModel.Code.values();
            int r2 = r1.length;
            int r4 = 0;
        L3:
            if (r4 >= r2) goto L11;
            LiveUpdateConcertStatusResultModel.Code r5 = r1[r4];
            if (r5.getValue() != r9.getValue()) goto L7;
            boolean r6 = true;
        L8:
            if (r6 == true) goto L12;
            r4 = r4 + 1;
        L12:
            if (r5 != null) goto L14;
            r5 = LiveUpdateConcertStatusResultModel.Code.Failed;
        L14:
            r0.a(r5);
            r0.c(r10);
            r0.b(r11);
            this.a.finishWithResult(r0);
            return;
        L7:
            r6 = false;
            goto L8
        L11:
            r5 = null;
            goto L12
        }
    }

    static {
    }

    public h() {
        this.a = new b(this);
    }

    public final void invoke(Object r4, CallContext r5) {
        jb r6 = (jb) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        String r7 = r6.getType();
        String r0 = "";
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        String r1 = r6.a();
        if (r1 == null) goto L9;
        r0 = r1;
    L9:
        JsonObject r8 = r6.b();
        ALogger.i("DynamicUpdateConcertStatusMethod", "DynamicUpdateConcertStatusMethod#invoke: type=" + r7 + ", bizId=" + r0 + ", extra=" + r8);
        IKtvService r2 = jc1.k.f(IKtvService.class);
        if (r2 == null) goto L15;
        gd2.f r3 = r2.getConcertStageService();
        if (r3 == null) goto L16;
        r3.h(new hd2.c(r0, r7, r8), this.a);
        return;
    L16:
        return;
    }
}

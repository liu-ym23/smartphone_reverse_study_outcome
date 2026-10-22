package com.bytedance.android.livesdk.gamecp;

import android.app.Activity;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w implements ov.b {

    public static final class a implements qb4.f {
        public final /* synthetic */ qv.a a;

        public a(qv.a r1) {
            this.a = r1;
        }

        public final void onFail(int r1, JSONObject r2) {
            qv.a r3 = this.a;
            if (r3 == null) goto L6;
            r3.onFailure(r1);
            return;
        }

        public final void onSuccess(int r1, JSONObject r2) {
            qv.a r3 = this.a;
            if (r3 == null) goto L6;
            r3.onSuccess();
            return;
        }
    }

    public w() {
    }

    public final void Z1(Activity r3, String r4, qv.a r5) {
        if (r3 == null) goto L16;
        if (r4 == null) goto L17;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        jc4.m r1 = new jc4.m(r4);     // Catch: Throwable -> L11
        qb4.b r6 = qb4.b.c.a;     // Catch: Throwable -> L11
        if (r6 == null) goto L8;
        r6.i(r3, r1, new a(r5));     // Catch: Throwable -> L11
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Result.constructor-impl(r7);     // Catch: Throwable -> L11
        return;
    L8:
        r7 = null;
    L11:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L17:
        return;
    }
}

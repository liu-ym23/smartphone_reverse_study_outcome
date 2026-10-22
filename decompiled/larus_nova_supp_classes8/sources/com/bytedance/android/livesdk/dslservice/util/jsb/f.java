package com.bytedance.android.livesdk.dslservice.util.jsb;

import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.n0;
import com.bytedance.android.livesdk.dslservice.slice.SliceViewUtilsKt;
import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import kotlin.jvm.internal.Intrinsics;
import yt1.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements IBaseCallbackSchemaHandler.SchemaCallback<String> {
    public final /* synthetic */ String a;
    public final /* synthetic */ j b;
    public final /* synthetic */ String c;

    public final void onComplete() {
    }

    public final void onFailure(Throwable r3) {
        String r4 = this.c;
        if (r4 != null) goto L5;
        return;
    L5:
        if (((Boolean) n0.a.getValue()).booleanValue() == false) goto L9;
        j r0 = this.b;
        if (r0 == null) goto L16;
        r0.b(r4, null);
        return;
    L16:
        return;
    L9:
        j r1 = this.b;
        if (r1 == null) goto L18;
        r r2 = r1.a();
        if (r2 == null) goto L19;
        SliceViewUtilsKt.b(r2, r4, null);
        return;
    L19:
        return;
    }

    public final void onSuccess(Integer r3, Object r4) {
        String r5 = (String) r4;
        Intrinsics.checkNotNullParameter(r5, "response");
        String r6 = this.a;
        if (r6 == null) goto L15;
        ALogger.i("DSLAction-SubscribeAnchorPlay", "onSuccess" + r5);
        if (((Boolean) n0.a.getValue()).booleanValue() == false) goto L9;
        j r7 = this.b;
        if (r7 == null) goto L16;
        r7.b(r6, null);
        return;
    L16:
        return;
    L9:
        j r8 = this.b;
        if (r8 == null) goto L18;
        r r9 = r8.a();
        if (r9 == null) goto L19;
        SliceViewUtilsKt.b(r9, r6, null);
        return;
    L19:
        return;
    L18:
        return;
    }

    public f(String r1, j r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

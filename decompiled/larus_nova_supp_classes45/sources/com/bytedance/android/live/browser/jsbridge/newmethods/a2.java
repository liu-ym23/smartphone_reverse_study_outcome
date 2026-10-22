package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "clipScreen")
public final class a2 extends b<b2, ClipScreenResultModel> {
    public final TokenCert a;
    public final View b;

    public a2(View r2) {
        this.b = r2;
        this.a = TokenCert.Companion.with("bpea-live_clipScreen_jsb_clip_screen_method");
    }

    public static ClipScreenResultModel j(boolean r1) {
        ClipScreenResultModel r0 = new ClipScreenResultModel();
        if (r1 == false) goto L5;
        ClipScreenResultModel.Code r2 = ClipScreenResultModel.Code.Success;
    L6:
        r0.b(r2);
        r0.c(new ClipScreenResultModel.a());
        return r0;
    L5:
        r2 = ClipScreenResultModel.Code.Failed;
        goto L6
    }

    public final void invoke(Object r6, CallContext r7) {
        b2 r8 = (b2) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        if (r8.c() != null) goto L5;
    L20:
        finishWithResult(j(false));
        return;
    L5:
        if (r8.d() == null) goto L20;
        if (r8.b() == null) goto L20;
        if (r8.a() == null) goto L20;
        if (this.b == null) goto L20;
        Context r9 = r7.getContext();
        Cert r0 = this.a;
        if (Build.VERSION.SDK_INT < 29) goto L16;
    L19:
        k(r9, r8);
        return;
    L16:
        if (m60.c.d(r9, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}) == true) goto L19;
        Activity r3 = ContextUtil.contextToActivity(r9);
        SettingKey<Boolean> r4 = m60.i.a;
        new m60.i.b(r3).b(new z1(this, r9, r8), null, r0, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"});
    }

    public final void k(Context r8, b2 r9) {
        UtilityKotlinExtentionsKt.i(0);
        String r1 = com.bytedance.android.livesdk.share.g.a;
        View r2 = this.b;
        Double r3 = r9.c();
        Intrinsics.checkNotNull(r3);
        int r4 = (int) UtilityKotlinExtentionsKt.h((float) r3.doubleValue());
        Double r5 = r9.d();
        Intrinsics.checkNotNull(r5);
        int r6 = (int) UtilityKotlinExtentionsKt.h((float) r5.doubleValue());
        Double r7 = r9.b();
        Intrinsics.checkNotNull(r7);
        int r11 = (int) UtilityKotlinExtentionsKt.h((float) r7.doubleValue());
        Double r12 = r9.a();
        Intrinsics.checkNotNull(r12);
        int r13 = (int) UtilityKotlinExtentionsKt.h((float) r12.doubleValue());
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter("clip_screen_method", "name");
        Bitmap r14 = com.bytedance.android.livesdk.share.g.a(r2);     // Catch: Exception -> L13
        if (r14 != null) goto L6;
    L15:
        Uri r15 = null;
    L16:
        if (r15 == null) goto L21;
        ClipScreenResultModel r0 = j(true);
        ClipScreenResultModel.a r16 = r0.a();
        if (r16 == null) goto L20;
        r16.b(1);
        r16.a(r15.toString());
    L20:
        Unit r17 = Unit.INSTANCE;
        finishWithResult(r0);
        return;
    L21:
        finishWithResult(j(false));
        return;
    L6:
        if (r11 <= r14.getWidth()) goto L9;
        r11 = r14.getWidth();     // Catch: Exception -> L13
    L9:
        if (r13 <= r14.getHeight()) goto L11;
        r13 = r14.getHeight();     // Catch: Exception -> L13
    L11:
        r15 = com.bytedance.android.livesdk.share.g.c(r8, Bitmap.createBitmap(r14, r4, r6, r11, r13));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        ALogger.d("ttlive_poster", "clipBitmapAndSave failure: " + e.getMessage());
        goto L15
    }
}

package com.bytedance.android.live.browser.jsbridge.upload;

import androidx.fragment.app.Fragment;
import bolts.Task;
import com.bytedance.android.live.browser.jsbridge.base.GetPictureResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.IMiddlewareLiveSDKService;
import com.bytedance.android.livesdk.config.vv0;
import com.bytedance.android.livesdk.config.wv0;
import com.bytedance.android.livesdk.utils.k2;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import w20.r1;
import w20.r9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x extends r1<r9, GetPictureResultModel> implements com.bytedance.android.live.room.g.b {
    public com.bytedance.android.live.room.g a;
    public final Fragment b;

    public final /* synthetic */ void c() {
    }

    public final /* synthetic */ void e(String r1, String r2, String r3) {
    }

    public final void g(String r1, int r2) {
    }

    public final /* synthetic */ void h() {
    }

    public final /* synthetic */ void onError(String r1) {
    }

    public final void onCanceled() {
        finishWithFailure(new IllegalStateException("canceled"));
    }

    public x(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.b = r2;
    }

    public final void invoke(Object r13, CallContext r14) {
        r9 r0 = (r9) r13;
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r14, "context");
        Integer r1 = r0.b();     // Catch: Exception -> L21
        if (r1 == null) goto L6;
        int r2 = r1.intValue();     // Catch: Exception -> L21
    L7:
        wv0 r3 = wv0.a;     // Catch: Exception -> L21
        int r8 = Math.max(r2, ((Integer) r3.getValue()).intValue());     // Catch: Exception -> L21
        Integer r4 = r0.a();     // Catch: Exception -> L21
        if (r4 == null) goto L10;
        int r5 = r4.intValue();     // Catch: Exception -> L21
    L11:
        vv0 r6 = vv0.a;     // Catch: Exception -> L21
        int r9 = Math.max(r5, ((Integer) r6.getValue()).intValue());     // Catch: Exception -> L21
        Integer r7 = r0.b();     // Catch: Exception -> L21
        if (r7 != null) goto L14;
        r7 = (Integer) r3.getValue();     // Catch: Exception -> L21
    L14:
        int r11 = Math.max(1, r7.intValue());     // Catch: Exception -> L21
        Integer r12 = r0.a();     // Catch: Exception -> L21
        if (r12 != null) goto L17;
        r12 = (Integer) r6.getValue();     // Catch: Exception -> L21
    L17:
        int r15 = Math.max(1, r12.intValue());     // Catch: Exception -> L21
        k2 r16 = jc1.k.n(IMiddlewareLiveSDKService.class).createImagePicker(null, this.b, "pick_custom_gift_picture", null, r11, r15, r8, r9, this, null);     // Catch: Exception -> L21
        this.a = r16;     // Catch: Exception -> L21
        if (r16 == null) goto L26;
        r16.u(false, false, 0);     // Catch: Exception -> L21
        return;
    L26:
        return;
    L10:
        r5 = 1;
        goto L11
    L6:
        r2 = 1;
    L21:
        e = move-exception;
        finishWithFailure(e);
    }

    public final void b(String r1, String r2, IThemeShowArea r3, ThemeUpLoadListener r4, int r5) {
        ALogger.i("cwz", r1);
        Task.callInBackground(new v(this, r1)).continueWith(new w(this, r1), Task.UI_THREAD_EXECUTOR);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        finishWithFailure(e);
    }
}

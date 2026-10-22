package com.bytedance.android.livesdk.jsbridge.methods;

import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Action;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g1 implements Action {
    public final /* synthetic */ d1 a;
    public final /* synthetic */ d1.b b;

    public g1(d1 r1, d1.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        km3.g r0 = this.a.e;
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
    L21:
        com.bytedance.android.live.core.utils.f2.b(2131922151, 0);
        d1 r3 = this.a;
        d1.b r4 = this.b;
        r3.getClass();
        com.bytedance.android.livesdk.jsbridge.methods.draft.d r5 = new com.bytedance.android.livesdk.jsbridge.methods.draft.d();
        String r6 = r4.k().a();
        Intrinsics.checkNotNullParameter(r6, "anchorId");
        ((HashMap) r5.a).put("anchor_id", r6);
        String r7 = r4.e();
        Intrinsics.checkNotNullParameter(r7, "roomId");
        ((HashMap) r5.a).put("room_id", r7);
        String r8 = r4.k().b();
        Intrinsics.checkNotNullParameter(r8, "commodityId");
        ((HashMap) r5.a).put("commodity_id", r8);
        String r9 = String.valueOf(r4.k().c());
        Intrinsics.checkNotNullParameter(r9, "commodityType");
        ((HashMap) r5.a).put("commodity_type", r9);
        String r10 = r4.k().f();
        Intrinsics.checkNotNullParameter(r10, "isECom");
        ((HashMap) r5.a).put("is_ecom", r10);
        String r11 = r4.l();
        Intrinsics.checkNotNullParameter(r11, "videoId");
        ((HashMap) r5.a).put("video_id", r11);
        String r13 = r4.k().d();
        Intrinsics.checkNotNullParameter(r13, "pageName");
        ((HashMap) r5.a).put("page_name", r13);
        String r14 = r4.k().e();
        Intrinsics.checkNotNullParameter(r14, "sourcePage");
        ((HashMap) r5.a).put("source_page", r14);
        Map<String, String> r15 = r5.a;
        Intrinsics.checkNotNullParameter("livesdk_product_video_save_success", "event");
        Intrinsics.checkNotNullParameter("livesdk_product_video_save_success", "eventName");
        Intrinsics.checkNotNullParameter(r15, "params");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_product_video_save_success", r15, new Object[0]);
    }
}

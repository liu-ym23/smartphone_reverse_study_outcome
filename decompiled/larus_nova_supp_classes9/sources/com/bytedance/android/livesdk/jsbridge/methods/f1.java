package com.bytedance.android.livesdk.jsbridge.methods;

import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f1<T> implements Consumer {
    public final /* synthetic */ d1 a;
    public final /* synthetic */ d1.b b;

    public f1(d1 r1, d1.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        Throwable r7 = (Throwable) r6;
        km3.g r8 = this.a.e;
        if (r8 == null) goto L21;
        Handler r0 = DialogLancet.resolveDialogHandler(r8);
        if (r0 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r8);
        r8.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r8);
        goto L21
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r1 == null) goto L18;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r8);
        throw th;
    L7:
        if (Looper.myLooper() == r0.getLooper()) goto L9;
        r0.post(DialogLancet.createDismissRunnable(r8));
    L21:
        com.bytedance.android.live.core.utils.f2.b(2131922149, 0);
        d1 r9 = this.a;
        d1.b r2 = this.b;
        r9.getClass();
        com.bytedance.android.livesdk.jsbridge.methods.draft.d r10 = new com.bytedance.android.livesdk.jsbridge.methods.draft.d();
        String r3 = r2.k().a();
        Intrinsics.checkNotNullParameter(r3, "anchorId");
        ((HashMap) r10.a).put("anchor_id", r3);
        String r4 = r2.e();
        Intrinsics.checkNotNullParameter(r4, "roomId");
        ((HashMap) r10.a).put("room_id", r4);
        String r5 = r2.k().b();
        Intrinsics.checkNotNullParameter(r5, "commodityId");
        ((HashMap) r10.a).put("commodity_id", r5);
        String r11 = String.valueOf(r2.k().c());
        Intrinsics.checkNotNullParameter(r11, "commodityType");
        ((HashMap) r10.a).put("commodity_type", r11);
        String r13 = r2.k().f();
        Intrinsics.checkNotNullParameter(r13, "isECom");
        ((HashMap) r10.a).put("is_ecom", r13);
        String r14 = r2.l();
        Intrinsics.checkNotNullParameter(r14, "videoId");
        ((HashMap) r10.a).put("video_id", r14);
        String r15 = r2.k().d();
        Intrinsics.checkNotNullParameter(r15, "pageName");
        ((HashMap) r10.a).put("page_name", r15);
        String r16 = r2.k().e();
        Intrinsics.checkNotNullParameter(r16, "sourcePage");
        ((HashMap) r10.a).put("source_page", r16);
        Map<String, String> r17 = r10.a;
        Intrinsics.checkNotNullParameter("livesdk_product_video_save_fail", "event");
        Intrinsics.checkNotNullParameter("livesdk_product_video_save_fail", "eventName");
        Intrinsics.checkNotNullParameter(r17, "params");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_product_video_save_fail", r17, new Object[0]);
    }
}

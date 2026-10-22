package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.room.api.experience.service.ILiveTopSpeedExpService;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/experencepanel/TopSpeedGuideDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopSpeedGuideDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int B = 0;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ TopSpeedGuideDialog a;

        public b(TopSpeedGuideDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommonStandardBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ TopSpeedGuideDialog a;

        public c(TopSpeedGuideDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.bytedance.android.live.room.api.playopt.topspeed.log.a.a("click");
            ILiveTopSpeedExpService r5 = k.f(ILiveTopSpeedExpService.class);
            if (r5 == null) goto L5;
            r5.showExpOptDialog();
        L5:
            CommonStandardBottomDialog r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L8;
        L10:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L13 Exception -> L15
        L19:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L13:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L15:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
            if (r1 == null) goto L19;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
            goto L19
        L8:
            if (Looper.myLooper() == r0.getLooper()) goto L10;
            r0.post(DialogLancet.createDismissRunnable(r6));
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565786;
    }

    public TopSpeedGuideDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, false);
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        ImageView r3 = (ImageView) findViewById(2131374804);
        if (r3 == null) goto L5;
        r3.setOnClickListener(new b(this));
    L5:
        TextView r4 = (TextView) findViewById(2131368844);
        if (r4 == null) goto L18;
        String r0 = TopSpeedModeUtils.d().c();
        if (r0 != null) goto L10;
    L13:
        boolean r1 = true;
    L14:
        if (r1 == false) goto L16;
        String r5 = "开启后，系统将自动关闭部分直播间动效、消息、功能和后台任务，改善卡顿、发热、耗电问题";
    L17:
        r4.setText(r5);
        goto L18
    L16:
        r5 = String.valueOf(TopSpeedModeUtils.d().c());
        goto L17
    L10:
        if (r0.length() == 0) goto L13;
        r1 = false;
    L18:
        TextView r6 = (TextView) findViewById(2131381533);
        if (r6 == null) goto L21;
        r6.setOnClickListener(new c(this));
    L21:
        com.bytedance.android.live.room.api.playopt.topspeed.log.a.a("show");
    }
}

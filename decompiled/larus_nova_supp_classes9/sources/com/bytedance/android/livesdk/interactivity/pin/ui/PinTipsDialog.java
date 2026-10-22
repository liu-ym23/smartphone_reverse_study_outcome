package com.bytedance.android.livesdk.interactivity.pin.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.wg0;
import com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.PinContainerAppLogger;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.crash.d;
import com.bytedance.live.datacontext.i;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import g42.h;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/ui/PinTipsDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PinTipsDialog extends CommonStandardBottomDialog {
    public final String B;
    public Button C;
    public Button D;
    public HSImageView E;
    public final h<?> F;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ PinTipsDialog a;

        public a(PinTipsDialog r1) {
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
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PinTipsDialog a;
        public final /* synthetic */ boolean b;

        public b(PinTipsDialog r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            k42.b.a(this.a.F);
            int r5 = PinContainerAppLogger.a;
            PinContainerAppLogger.d(this.b, this.a.F.a);
            CommonStandardBottomDialog r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L12:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r6));
        }
    }

    public final int getLayoutId() {
        return 2131566739;
    }

    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        this.C = (Button) findViewById(2131364679);
        this.D = (Button) findViewById(2131381563);
        this.E = findViewById(2131375115);
        ImageModel r7 = new ImageModel();
        boolean r2 = false;
        r7.setUrls(CollectionsKt.mutableListOf(new String[]{this.B}));
        ImageUtil.loadImage(this.E, r7, 0);
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r8 == null) goto L9;
        i r9 = r8.isAnchor();
        if (r9 == null) goto L9;
        Boolean r10 = (Boolean) r9.getValue();
        if (r10 == null) goto L9;
        r2 = r10.booleanValue();
    L9:
        int r11 = PinContainerAppLogger.a;
        PinContainerAppLogger.e(r2, this.F.a);
        Button r13 = this.C;
        if (r13 == null) goto L12;
        r13.setOnClickListener(new a(this));
    L12:
        Button r14 = this.D;
        if (r14 == null) goto L15;
        r14.setOnClickListener(new b(this, r2));
    L15:
        f.d(new e("has_show_pin_tips_dialog", Boolean.FALSE), Boolean.TRUE);
    }

    public PinTipsDialog(Context r2, h<?> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        super(r2, false);
        this.F = r3;
        this.B = (String) wg0.a.getValue();
    }
}

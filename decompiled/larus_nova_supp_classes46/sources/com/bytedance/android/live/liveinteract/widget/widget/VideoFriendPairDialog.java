package com.bytedance.android.live.liveinteract.widget.widget;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.plantform.model.h0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/widget/widget/VideoFriendPairDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "Lcom/bytedance/android/live/liveinteract/widget/widget/PairUserAdapter$PairUserViewHolder$a;", "Lcom/bytedance/android/live/liveinteract/widget/widget/VideoFriendSelectPairDialog$a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoFriendPairDialog extends CommonBottomDialog implements PairUserAdapter.PairUserViewHolder.a, VideoFriendSelectPairDialog.a {

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ VideoFriendPairDialog a;

        public a(VideoFriendPairDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommonBottomDialog r5 = this.a;
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

    public final int getLayoutId() {
        return 2131565789;
    }

    public final void M0() {
        com.bytedance.android.livesdk.sharedpref.e r0 = b6.a0;
        Long r1 = (Long) r0.getValue();
        if (r1 == null) goto L8;
        if (r1.longValue() != 0) goto L8;
    L11:
        ((TextView) findViewById(2131390404)).setVisibility(8);
        com.bytedance.android.livesdk.sharedpref.f.d(r0, 0L);
        throw null;
    L8:
        if ((SystemClock.elapsedRealtime() - ((Number) r0.getValue()).longValue()) >= ((Number) vm2.d.r5.getValue(null, vm2.d.a[327(0x147, float:4.58E-43)])).longValue()) goto L11;
        ((TextView) findViewById(2131390404)).setVisibility(0);
        throw null;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        throw null;
    }

    @Override // com.bytedance.android.live.liveinteract.widget.widget.VideoFriendSelectPairDialog.a
    public final void A0(List<? extends h0> r2) {
        Intrinsics.checkNotNullParameter(r2, "users");
        if (r2.size() > 0) goto L5;
        return;
    L5:
        findViewById(2131384982).setVisibility(0);
        ((LinearLayout) findViewById(2131371557)).setVisibility(8);
        throw null;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setCanceledOnTouchOutside(true);
        ((FrameLayout) findViewById(2131376031)).setOnClickListener(new a(this));
        M0();
        throw null;
    }
}

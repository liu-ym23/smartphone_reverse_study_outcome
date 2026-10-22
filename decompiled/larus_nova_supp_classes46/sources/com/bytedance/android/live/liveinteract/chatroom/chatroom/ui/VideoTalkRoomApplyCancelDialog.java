package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.LinkCommonBottomDialog;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rj0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/ui/VideoTalkRoomApplyCancelDialog;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/LinkCommonBottomDialog;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoTalkRoomApplyCancelDialog extends LinkCommonBottomDialog {
    public static final /* synthetic */ int e = 0;
    public final CompositeDisposable a;
    public final DataCenter b;
    public final int c;
    public final boolean d;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ VideoTalkRoomApplyCancelDialog a;

        public b(VideoTalkRoomApplyCancelDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            if (this.a.c <= 0) goto L5;
            int r5 = bh0.a.a;
            int r6 = 101;
        L6:
            l.n2.getClass();
            l r0 = l.a.a();
            if (r0 == null) goto L9;
            l.b.a(r0, this.a.c, r6, "video_talk_apply_click");
        L9:
            CommonBottomDialog r7 = this.a;
            Handler r1 = DialogLancet.resolveDialogHandler(r7);
            if (r1 != null) goto L12;
        L14:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L17 Exception -> L19
        L23:
            DialogLancet.afterDialogDismiss(r7);
            return;
        L17:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L19:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
            if (r2 == null) goto L23;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
            goto L23
        L12:
            if (Looper.myLooper() == r1.getLooper()) goto L14;
            r1.post(DialogLancet.createDismissRunnable(r7));
            return;
        L5:
            int r8 = bh0.a.a;
            r6 = 102;
            goto L6
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ VideoTalkRoomApplyCancelDialog a;

        public c(VideoTalkRoomApplyCancelDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            if (com.bytedance.android.live.liveinteract.videotalk.a.a == true) goto L24;
            l.n2.getClass();
            l r5 = l.a.a();
            if (r5 == null) goto L7;
            l.b.c(r5, null, 7);
        L7:
            CommonBottomDialog r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L10;
        L12:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L15 Exception -> L17
        L21:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L15:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L17:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
            if (r1 == null) goto L21;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
            goto L21
        L10:
            if (Looper.myLooper() == r0.getLooper()) goto L12;
            r0.post(DialogLancet.createDismissRunnable(r6));
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ VideoTalkRoomApplyCancelDialog a;

        public d(VideoTalkRoomApplyCancelDialog r1) {
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

    static {
    }

    public final int getLayoutId() {
        return 2131565797;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.dispose();
    }

    public final void onCreate(Bundle r12) {
        super.onCreate(r12);
        if (this.d == false) goto L5;
        ((TextView) findViewById(2131392388)).setVisibility(0);
        ((TextView) findViewById(2131365120)).setVisibility(8);
        ((FrameLayout) findViewById(2131377420)).setVisibility(8);
    L10:
        ((TextView) findViewById(2131392388)).setOnClickListener(new b(this));
        ((TextView) findViewById(2131365120)).setOnClickListener(new c(this));
        ((TextView) findViewById(2131365114)).setOnClickListener(new d(this));
        return;
    L5:
        ((TextView) findViewById(2131392388)).setVisibility(8);
        ((TextView) findViewById(2131365120)).setVisibility(0);
        DataCenter r13 = this.b;
        if (r13 == null) goto L10;
        IRoom r14 = a0.m(r13).a;
        if (r14 == null) goto L10;
        long r7 = r14.getId();
        Disposable r15 = ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).getUserWaitingRankPosition(r7, r7, 8, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new j(this), k.a);
        this.a.add(r15);
        goto L10
    }

    public VideoTalkRoomApplyCancelDialog(Context r2, DataCenter r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = r3;
        this.c = r4;
        this.d = false;
        this.a = new CompositeDisposable();
    }
}

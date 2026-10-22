package com.bytedance.android.live.liveinteract.revenue.fight.dialog;

import am2.x;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.LinkCommonBottomDialog;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.e;
import com.bytedance.android.livesdk.chatroom.viewmodel.f;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.chatroom.viewmodel.j;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rj0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/fight/dialog/TeamFightApplyDialog;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/LinkCommonBottomDialog;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TeamFightApplyDialog extends LinkCommonBottomDialog {
    public final IRoom a;
    public View b;
    public View c;
    public final CompositeDisposable d;
    public final int e;
    public final String f;
    public final LinkApplyType g;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ TeamFightApplyDialog a;

        public a(TeamFightApplyDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            if (((i) r4).a == 5) goto L21;
            CommonBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L14:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r1 == null) goto L18;
            d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L7:
            if (Looper.myLooper() == r0.getLooper()) goto L9;
            r0.post(DialogLancet.createDismissRunnable(r5));
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ TeamFightApplyDialog a;

        public b(TeamFightApplyDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            if (((j) r4).a == 12) goto L21;
            CommonBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L14:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r1 == null) goto L18;
            d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L7:
            if (Looper.myLooper() == r0.getLooper()) goto L9;
            r0.post(DialogLancet.createDismissRunnable(r5));
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ TeamFightApplyDialog a;

        public c(TeamFightApplyDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Integer r5 = (Integer) r4;
            if (r5 != null) goto L6;
            return;
        L6:
            if (r5.intValue() != 4) goto L24;
            CommonBottomDialog r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L10;
        L12:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L15 Exception -> L17
        L21:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L17:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
            if (r1 == null) goto L21;
            d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L10:
            if (Looper.myLooper() == r0.getLooper()) goto L12;
            r0.post(DialogLancet.createDismissRunnable(r6));
            return;
        }
    }

    public final int getLayoutId() {
        if (li0.d.e() == false) goto L6;
        return 2131565542;
    L6:
        return 2131565541;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d.dispose();
    }

    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.b = findViewById(2131384113);
        this.c = findViewById(2131364304);
        View r0 = this.b;
        if (r0 == null) goto L5;
        r0.setOnClickListener(x0.a(new AnonymousClass1(this)));
    L5:
        View r1 = this.c;
        if (r1 == null) goto L9;
        r1.setOnClickListener(x0.a(new AnonymousClass2(this)));
    L9:
        if (this.a.isLiveTypeAudio() == false) goto L21;
        u r2 = m.h(null, Long.valueOf(this.a.getId()), 1);
        if (r2 == null) goto L32;
        com.bytedance.live.datacontext.j r3 = r2.s();
        if (r3 == null) goto L32;
        f r4 = (f) r3.getValue();
        if (r4 == null) goto L32;
        BehaviorSubject r5 = r4.a();
        if (r5 == null) goto L32;
        Disposable r7 = r5.subscribe(new a(this));
        if (r7 == null) goto L32;
        this.d.add(r7);
    L32:
        TeamFightContext r8 = TeamFightContext.Companion.getContext();
        if (r8 == null) goto L41;
        com.bytedance.live.datacontext.m<Integer> r9 = r8.getFightStatus();
        if (r9 == null) goto L41;
        Observable r10 = r9.a();
        if (r10 == null) goto L41;
        Disposable r11 = r10.subscribe(new c(this));
        if (r11 == null) goto L41;
        this.d.add(r11);
    L41:
        li0.b r12 = li0.b.b;
        HashMap r13 = new HashMap();
        li0.b.k(r13);
        TalkRoomLogUtils.B0(r13, null, null, 6);
        j0.l().sendLog("livesdk_grouppk_user_apply_page_show", r13, new Object[]{IRoom.class, x.class});
        ALogger.w("TeamFight", "TeamFightApplyDialog show pos=" + this.e + " source=" + this.f);
        return;
    L21:
        u r14 = m.h(null, Long.valueOf(this.a.getId()), 1);
        if (r14 == null) goto L32;
        com.bytedance.live.datacontext.j r15 = r14.getVideoTalkRoomSubScene();
        if (r15 == null) goto L32;
        e r16 = (e) r15.getValue();
        if (r16 == null) goto L32;
        BehaviorSubject r17 = r16.a();
        if (r17 == null) goto L32;
        Disposable r18 = r17.subscribe(new b(this));
        if (r18 == null) goto L32;
        this.d.add(r18);
        goto L32
    }

    public static final void M0(TeamFightApplyDialog r10, int r11) {
        int r0 = r10.e;
        if (1 <= r0) goto L6;
    L8:
        r0 = -1;
    L10:
        if (r10.a.isLiveTypeAudio() == false) goto L17;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r2 = IVoiceChatGuestService.a.a();
        if (r2 == null) goto L24;
        String r5 = r10.f;
        if (r5 != null) goto L16;
        r5 = "team_fight";
    L16:
        r2.teamFightApply(r11, r0, r5, r10.g.getValue(), "teamId=" + r11 + ",pos=" + r0);
    L24:
        li0.b r12 = li0.b.b;
        String r13 = li0.b.d(r11);
        Intrinsics.checkNotNullParameter(r13, "buttonType");
        HashMap r14 = new HashMap();
        r14.put("button_type", r13);
        li0.b.k(r14);
        TalkRoomLogUtils.B0(r14, null, null, 6);
        j0.l().sendLog("livesdk_grouppk_user_apply_page_click", r14, new Object[]{IRoom.class, x.class});
        return;
    L17:
        l.n2.getClass();
        l r3 = l.a.a();
        if (r3 == null) goto L24;
        String r6 = r10.f;
        if (r6 == null) goto L22;
        int r7 = CastIntegerProtector.parseInt(r6);
    L23:
        l.b.b(r3, r0, r7, "teamId=" + r11 + ",pos=" + r0, "", Integer.valueOf(r11), r10.g, 64);
        goto L24
    L22:
        int r8 = bh0.a.a;
        r7 = 100;
        goto L23
    L6:
        if (8 < r0) goto L8;
        goto L8
    }

    public TeamFightApplyDialog(Context r2, DataCenter r3, int r4, String r5, LinkApplyType r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "applyType");
        super(r2);
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.a = a0.n(r3);
        this.d = new CompositeDisposable();
    }
}

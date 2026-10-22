package com.bytedance.android.live.liveinteract.revenue.fight.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.LinkCommonBottomDialog;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.e;
import com.bytedance.android.livesdk.chatroom.viewmodel.f;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.chatroom.viewmodel.j;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rj0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/fight/dialog/TeamFightInviteDialog;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/LinkCommonBottomDialog;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TeamFightInviteDialog extends LinkCommonBottomDialog {
    public HSImageView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public final IRoomBase e;
    public final IBaseUser f;
    public final CompositeDisposable g;
    public final com.bytedance.android.live.liveinteract.videolink.a h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ TeamFightInviteDialog a;

        public a(TeamFightInviteDialog r1) {
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
        public final /* synthetic */ TeamFightInviteDialog a;

        public b(TeamFightInviteDialog r1) {
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
        public final /* synthetic */ TeamFightInviteDialog a;

        public c(TeamFightInviteDialog r1) {
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
        if (li0.d.e() == false) goto L5;
        return 2131565543;
    L5:
        return 2131565544;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g.dispose();
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.a = findViewById(2131363703);
        this.b = (TextView) findViewById(2131392055);
        this.c = (TextView) findViewById(2131384115);
        this.d = (TextView) findViewById(2131364306);
        ImageUtil.loadRoundImage(this.a, this.f.getAvatarMedium());
        TextView r0 = this.b;
        if (r0 == null) goto L5;
        r0.setText(this.f.getNickName());
    L5:
        TextView r1 = this.c;
        if (r1 == null) goto L8;
        r1.setOnClickListener(x0.a(new AnonymousClass1(this)));
    L8:
        TextView r2 = this.d;
        if (r2 == null) goto L12;
        r2.setOnClickListener(x0.a(new AnonymousClass2(this)));
    L12:
        if (this.e.isLiveTypeAudio() == false) goto L24;
        u r3 = m.h(null, Long.valueOf(IRoomKtKt.getId(this.e)), 1);
        if (r3 == null) goto L35;
        com.bytedance.live.datacontext.j r4 = r3.s();
        if (r4 == null) goto L35;
        f r6 = (f) r4.getValue();
        if (r6 == null) goto L35;
        BehaviorSubject r7 = r6.a();
        if (r7 == null) goto L35;
        Disposable r8 = r7.subscribe(new a(this));
        if (r8 == null) goto L35;
        this.g.add(r8);
    L35:
        TeamFightContext r9 = TeamFightContext.Companion.getContext();
        if (r9 == null) goto L44;
        com.bytedance.live.datacontext.m<Integer> r10 = r9.getFightStatus();
        if (r10 == null) goto L44;
        Observable r11 = r10.a();
        if (r11 == null) goto L44;
        Disposable r12 = r11.subscribe(new c(this));
        if (r12 == null) goto L44;
        this.g.add(r12);
    L44:
        li0.b r13 = li0.b.b;
        String r14 = this.f.getIdString();
        HashMap r15 = new HashMap();
        r15.put("to_user_id", String.valueOf(r14));
        li0.b.k(r15);
        TalkRoomLogUtils.B0(r15, null, null, 6);
        i0 r16 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.i1(r15);
        j0.l().sendLog("livesdk_grouppk_invite_page_show", r15, new Object[]{IRoom.class});
        ALogger.w("TeamFight", "TeamFightInviteDialog show " + this.h);
        return;
    L24:
        u r17 = m.h(null, Long.valueOf(IRoomKtKt.getId(this.e)), 1);
        if (r17 == null) goto L35;
        com.bytedance.live.datacontext.j r18 = r17.getVideoTalkRoomSubScene();
        if (r18 == null) goto L35;
        e r19 = (e) r18.getValue();
        if (r19 == null) goto L35;
        BehaviorSubject r20 = r19.a();
        if (r20 == null) goto L35;
        Disposable r21 = r20.subscribe(new b(this));
        if (r21 == null) goto L35;
        this.g.add(r21);
        goto L35
    }

    public TeamFightInviteDialog(Context r2, com.bytedance.android.live.liveinteract.videolink.a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "inviteParams");
        super(r2, 0);
        this.h = r3;
        this.e = r3.g;
        this.f = r3.h;
        this.g = new CompositeDisposable();
    }

    public static final void M0(TeamFightInviteDialog r5, int r6) {
        r5.getClass();
        li0.b r0 = li0.b.b;
        String r1 = r5.f.getIdString();
        String r2 = li0.b.d(r6);
        Intrinsics.checkNotNullParameter(r2, "buttonType");
        HashMap r3 = new HashMap();
        r3.put("to_user_id", String.valueOf(r1));
        r3.put("button_type", r2);
        li0.b.k(r3);
        TalkRoomLogUtils.B0(r3, null, null, 6);
        i0 r4 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.i1(r3);
        j0.l().sendLog("livesdk_grouppk_invite_page_click", r3, new Object[]{IRoom.class});
        if (r5.e.isLiveTypeAudio() == false) goto L7;
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r7 = IVoiceChatAdminService.a.a();
        if (r7 == null) goto L14;
        com.bytedance.android.live.liveinteract.videolink.a r8 = r5.h;
        r8.b = r6;
        r7.invite(r8);
        return;
    L14:
        return;
    L7:
        k.m2.getClass();
        k r9 = k.a.a();
        if (r9 == null) goto L10;
        com.bytedance.android.live.liveinteract.videolink.a r10 = r5.h;
        r10.b = r6;
        r9.invite(r10);
        return;
    L10:
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.k r11 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r11 == null) goto L17;
        com.bytedance.android.live.liveinteract.videolink.a r12 = r5.h;
        r12.b = r6;
        r11.invite(r12);
        return;
    }
}

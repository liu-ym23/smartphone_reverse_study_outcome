package com.bytedance.android.live.liveinteract.revenue.fight.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.LinkCommonBottomDialog;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.model.j0;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.model.interact.x;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.f;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.chatroom.viewmodel.j;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/fight/dialog/TeamFightWaitingDialog;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/LinkCommonBottomDialog;", "Lcom/bytedance/android/livesdk/app/dataholder/Observer;", "", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TeamFightWaitingDialog extends LinkCommonBottomDialog implements Observer<Integer> {
    public final IRoom a;
    public final CompositeDisposable b;
    public View c;
    public HSImageView d;
    public ImageView e;
    public ImageView f;
    public TextView g;
    public TextView h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ TeamFightWaitingDialog a;

        public a(TeamFightWaitingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
            if (r6 == null) goto L32;
            x r7 = (x) r6.data;
            if (r7 != null) goto L8;
            return;
        L8:
            if (r7.getPrompt().length() <= 0) goto L10;
            boolean r0 = true;
        L11:
            if (r0 == false) goto L15;
            TextView r1 = this.a.g;
            if (r1 == null) goto L15;
            r1.setText(r7.getPrompt());
        L15:
            TextView r2 = this.a.h;
            if (r2 == null) goto L18;
            r2.setText(sb2.a.h(r7.getDisplayText(), "", false));
        L18:
            j0 r3 = r7.getJoinTeamInfo();
            if (r3 == null) goto L26;
            TeamFightContext r4 = TeamFightContext.Companion.getContext();
            if (r4 == null) goto L25;
            m<Integer> r8 = r4.getCurrentApplyTeam();
            if (r8 == null) goto L25;
            r8.setValue(Integer.valueOf((int) r3.getTeamId()));
        L25:
            this.a.N0();
        L26:
            StringBuilder r9 = new StringBuilder("getItemOffset: prompt=");
            r9.append(r7.getPrompt());
            r9.append(" joinTeamInfo=");
            j0 r10 = r7.getJoinTeamInfo();
            if (r10 == null) goto L29;
            Long r11 = Long.valueOf(r10.getTeamId());
        L30:
            r9.append(r11.longValue());
            ALogger.w("TeamFight", r9.toString());
            return;
        L29:
            r11 = null;
            goto L30
        L10:
            r0 = false;
            goto L11
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ TeamFightWaitingDialog a;

        public b(TeamFightWaitingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            ALogger.e("TeamFight", "getItemOffset failed, dismiss " + ((Throwable) r4));
            Observer r5 = this.a;
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

    public static final class c<T> implements Consumer {
        public final /* synthetic */ TeamFightWaitingDialog a;

        public c(TeamFightWaitingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            if (((i) r4).a == 5) goto L21;
            Observer r5 = this.a;
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
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r1 == null) goto L18;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
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

    public static final class d<T> implements Consumer {
        public final /* synthetic */ TeamFightWaitingDialog a;

        public d(TeamFightWaitingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            if (((j) r4).a == 12) goto L21;
            Observer r5 = this.a;
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
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r1 == null) goto L18;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
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

    public static final class e<T> implements Consumer {
        public final /* synthetic */ TeamFightWaitingDialog a;

        public e(TeamFightWaitingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Integer r5 = (Integer) r4;
            if (r5 != null) goto L6;
            return;
        L6:
            if (r5.intValue() != 4) goto L24;
            Observer r6 = this.a;
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
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
            if (r1 == null) goto L21;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
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
        return 2131565545;
    }

    public static boolean M0() {
        TeamFightContext r0 = TeamFightContext.Companion.getContext();
        if (r0 == null) goto L9;
        m<Integer> r1 = r0.getCurrentApplyTeam();
        if (r1 == null) goto L9;
        if (((Number) r1.getValue()).intValue() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public final void N0() {
        ImageView r0 = this.f;
        if (r0 != null) goto L5;
    L9:
        ImageView r1 = this.e;
        if (r1 != null) goto L12;
        return;
    L12:
        if (M0() == false) goto L14;
        int r2 = 2131253107;
    L15:
        r1.setImageResource(r2);
        return;
    L14:
        r2 = 2131253105;
        goto L15
    L5:
        if (M0() == false) goto L7;
        int r3 = 2131253110;
    L8:
        r0.setImageResource(r3);
        goto L9
    L7:
        r3 = 2131253109;
        goto L8
    }

    public final void onDetachedFromWindow() {
        hd0.c.f().e(this);
        this.b.dispose();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onChanged(Object r3) {
        Integer r4 = (Integer) r3;
        if (r4 != null) goto L6;
    L7:
        if (r4 != null) goto L10;
        return;
    L10:
        if (r4.intValue() != 0) goto L32;
    L11:
        Handler r5 = DialogLancet.resolveDialogHandler(this);
        if (r5 != null) goto L14;
    L16:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L19 Exception -> L21
    L25:
        DialogLancet.afterDialogDismiss(this);
        return;
    L19:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L19
        Throwable r6 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L19
        if (r6 == null) goto L25;
        com.bytedance.crash.d.d(r6, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L19
        goto L25
    L14:
        if (Looper.myLooper() == r5.getLooper()) goto L16;
        r5.post(DialogLancet.createDismissRunnable(this));
        return;
    L32:
        return;
    L6:
        if (r4.intValue() == 2) goto L11;
        goto L7
    }

    public final void onCreate(Bundle r11) {
        super.onCreate(r11);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.c = findViewById(2131365114);
        this.d = findViewById(2131362565);
        this.e = (ImageView) findViewById(2131363186);
        this.f = (ImageView) findViewById(2131388294);
        this.g = (TextView) findViewById(2131374198);
        this.h = (TextView) findViewById(2131392988);
        HSImageView r0 = this.d;
        IRoom r1 = this.a;
        if (r1 == null) goto L7;
        IBaseUser r2 = r1.getBaseOwner();
        if (r2 == null) goto L7;
        k r3 = r2.getAvatarThumbKt();
    L8:
        ImageUtil.loadRoundImage(r0, r3);
        N0();
        TextView r4 = this.g;
        if (r4 != null) goto L11;
    L15:
        int r8 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        LinkAudienceApi r5 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        IRoom r6 = this.a;
        long r7 = 0;
        if (r6 == null) goto L18;
        long r9 = r6.getRoomId();
    L19:
        IRoom r10 = this.a;
        if (r10 == null) goto L22;
        r7 = r10.getRoomId();
    L22:
        Disposable r12 = r5.getUserWaitingRankPosition(r9, r7, r8, 2).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this), new b(this));
        if (r12 == null) goto L25;
        this.b.add(r12);
    L25:
        View r13 = this.c;
        if (r13 == null) goto L28;
        r13.setOnClickListener(x0.a(new AnonymousClass4(this)));
    L28:
        hd0.c.f().c(this);
        if (this.a.isLiveTypeAudio() == false) goto L41;
        u r14 = com.bytedance.android.live.liveinteract.api.utils.m.h(null, Long.valueOf(this.a.getId()), 1);
        if (r14 == null) goto L52;
        com.bytedance.live.datacontext.j r15 = r14.s();
        if (r15 == null) goto L52;
        f r16 = (f) r15.getValue();
        if (r16 == null) goto L52;
        BehaviorSubject r17 = r16.a();
        if (r17 == null) goto L52;
        Disposable r18 = r17.subscribe(new c(this));
        if (r18 == null) goto L52;
        this.b.add(r18);
    L52:
        TeamFightContext r19 = TeamFightContext.Companion.getContext();
        if (r19 == null) goto L61;
        m<Integer> r110 = r19.getFightStatus();
        if (r110 == null) goto L61;
        Observable r111 = r110.a();
        if (r111 == null) goto L61;
        Disposable r112 = r111.subscribe(new e(this));
        if (r112 == null) goto L61;
        this.b.add(r112);
    L61:
        li0.b r113 = li0.b.b;
        li0.b.h("show");
        ALogger.w("TeamFight", "TeamFightWaitingDialog show");
        return;
    L41:
        u r114 = com.bytedance.android.live.liveinteract.api.utils.m.h(null, Long.valueOf(this.a.getId()), 1);
        if (r114 == null) goto L52;
        com.bytedance.live.datacontext.j r115 = r114.getVideoTalkRoomSubScene();
        if (r115 == null) goto L52;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r116 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r115.getValue();
        if (r116 == null) goto L52;
        BehaviorSubject r117 = r116.a();
        if (r117 == null) goto L52;
        Disposable r118 = r117.subscribe(new d(this));
        if (r118 == null) goto L52;
        this.b.add(r118);
        goto L52
    L18:
        r9 = 0;
        goto L19
    L11:
        if (M0() == false) goto L13;
        String r20 = s1.B(2131922774);
    L14:
        r4.setText(r20);
        goto L15
    L13:
        r20 = s1.B(2131922773);
    L7:
        r3 = null;
        goto L8
    }

    public TeamFightWaitingDialog(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2);
        this.a = (IRoom) r3.get("data_room", vh7.f.c(IRoom.class));
        this.b = new CompositeDisposable();
    }
}

package com.bytedance.android.livesdk.chatroom.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.setting.CoreSettingUtil;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IVSCompatRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o2 implements View.OnClickListener {
    public final /* synthetic */ VSAnchorInfoWidget a;

    public static final class a implements Runnable {
        public final /* synthetic */ o2 a;

        public a(o2 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VSAnchorInfoWidget r0 = this.a.a;     // Catch: Throwable -> L10
            TextView r1 = r0.c;     // Catch: Throwable -> L10
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("vsAnchorFollow");     // Catch: Throwable -> L10
        L5:
            r1.setVisibility(4);     // Catch: Throwable -> L10
            ProgressBar r2 = r0.g;     // Catch: Throwable -> L10
            if (r2 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("vsFollowProgress");     // Catch: Throwable -> L10
        L8:
            r2.setVisibility(0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    public static final class b implements Observer<FollowPair> {
        public final /* synthetic */ o2 a;

        public final void onComplete() {
            VSAnchorInfoWidget r0 = this.a.a;
            TextView r1 = r0.c;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("vsAnchorFollow");
        L5:
            r1.setVisibility(0);
            ProgressBar r2 = r0.g;
            if (r2 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("vsFollowProgress");
        L8:
            r2.setVisibility(8);
        }

        public b(o2 r1) {
            this.a = r1;
        }

        public final void onError(Throwable r4) {
            Intrinsics.checkNotNullParameter(r4, "e");
            VSAnchorInfoWidget r0 = this.a.a;
            TextView r1 = r0.c;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("vsAnchorFollow");
        L5:
            r1.setVisibility(0);
            ProgressBar r2 = r0.g;
            if (r2 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("vsFollowProgress");
        L8:
            r2.setVisibility(8);
            if ((r4 instanceof ApiServerException) == false) goto L12;
            IESUIUtils.displayToast(((Widget) this.a.a).context, ((ApiServerException) r4).getPrompt());
            return;
        L12:
            com.bytedance.android.live.core.utils.f2.b(2131919727, 0);
        }

        public final void onNext(Object r4) {
            FollowPair r5 = (FollowPair) r4;
            Intrinsics.checkNotNullParameter(r5, "t");
            Room r0 = this.a.a.o;
            if (r0 == null) goto L8;
            User r1 = r0.getOwner();
            if (r1 == null) goto L8;
            r1.setFollowStatus(r5.followStatus);
        L8:
            if (r5.getFollowStatus() == 0) goto L16;
            this.a.a.yq();
            VSAnchorInfoWidget r6 = this.a.a;
            Context r2 = ((Widget) r6).context;
            String r3 = null;
            if ((r2 instanceof Activity) == true) goto L12;
            r2 = null;
        L12:
            Activity r7 = (Activity) r2;
            Room r8 = r6.o;
            if (r8 == null) goto L15;
            r3 = r8.getOwnerUserIdString();
        L15:
            com.bytedance.android.live.core.utils.e1.a(r7, r3);
            return;
        L16:
            this.a.a.zq();
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
            this.a.a.l.add(r2);
        }
    }

    public o2(VSAnchorInfoWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        Context r12 = r11.getContext();
        if ((r12 instanceof Activity) == true) goto L5;
        r12 = null;
    L5:
        Activity r13 = (Activity) r12;
        if (r13 == null) goto L58;
        VSAnchorInfoWidget r0 = this.a;
        ((Widget) r0).dataCenter.put("data_user_follow_sate", Integer.valueOf(r0.n));
        r2 r1 = r2.a.a;
        Room r2 = this.a.o;
        if (r2 == null) goto L13;
        User r3 = r2.getOwner();
        if (r3 == null) goto L13;
        String r4 = r3.getIdStr();
        if (r4 == null) goto L13;
    L14:
        DataCenter r5 = ((Widget) this.a).dataCenter;
        Room r6 = com.bytedance.android.live.core.utils.z.a;
        Intrinsics.checkNotNullParameter(r5, "$this$vsCompatRoom");
        IVSCompatRoom r7 = com.bytedance.android.live.core.utils.z.q(r5);
        if (r7 == null) goto L57;
        DataCenter r8 = ((Widget) this.a).dataCenter;
        a r9 = new a(this);
        com.bytedance.android.livesdk.vs.f r10 = com.bytedance.android.livesdk.vs.f.c;
        if (r8 == null) goto L19;
        r10 = com.bytedance.android.livesdk.vs.f.a(r8);
    L19:
        HashMap r14 = new HashMap();
        r14.put("to_user_id", r4);
        r14.put("vs_click_relation_type", "audience_to_official_account");
        r14.put("vs_follow_position", "top_left_follow");
        if (VSDataContext.getInteractionContext(r8) == null) goto L22;
        ((Boolean) VSDataContext.getInteractionContext(r8).isVSLive().getValue()).booleanValue();
    L22:
        r10.c("follow", r14, new Object[0]);
        String r15 = "";
        if (com.bytedance.android.live.base.model.user.n0.b(r4) == true) goto L25;
        Observable r16 = Observable.error(new IllegalArgumentException("activity or user id or room is null or invalid"));
    L29:
        if (r16 == null) goto L33;
        Observable r17 = r16.observeOn(AndroidSchedulers.mainThread());
        if (r17 == null) goto L33;
        r17.subscribe(new b(this));
    L33:
        Room r18 = this.a.o;
        HashMap r19 = new HashMap();
        if (r18 == null) goto L36;
        String r20 = r18.getOwnerUserIdString();
    L37:
        r19.put("to_user_id", String.valueOf(r20));
        if (r18 == null) goto L40;
        LiveMode r21 = r18.getStreamType();
    L41:
        int r22 = com.bytedance.android.live.core.utils.h1.a;
        r19.put("live_type", com.bytedance.android.live.core.utils.i1.a(r21));
        RoomContext r23 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r23 == null) goto L48;
        com.bytedance.live.datacontext.m r24 = r23.isCleanMode();
        if (r24 == null) goto L48;
        if (((Boolean) r24.getValue()).booleanValue() != true) goto L48;
        String r25 = "1";
    L49:
        r19.put("if_clear_mode", r25);
        com.bytedance.android.livesdk.log.g r26 = com.bytedance.android.livesdk.log.u.l();
        Object[] r27 = new Object[5];
        if (r18 == null) goto L55;
        String r110 = r18.getOwnerUserIdString();
        if (r110 == null) goto L55;
        r15 = r110;
    L55:
        r27[0] = new FollowLog("live", r15);
        r27[1] = am2.x.class;
        r27[2] = Room.class;
        r27[3] = am2.n.f();
        r27[4] = am2.q.class;
        r26.sendLog("livesdk_follow", r19, r27);
        return;
    L48:
        r25 = "0";
        goto L49
    L40:
        r21 = null;
        goto L41
    L36:
        r20 = null;
        goto L37
    L25:
        if (jc1.k.f(IUserService.class).user().isLogin() == true) goto L27;
        new Bundle();
        com.bytedance.android.livesdk.user.f r28 = jc1.k.f(IUserService.class).user();
        com.bytedance.android.livesdk.user.l.a r29 = new com.bytedance.android.livesdk.user.l.a();
        r29.a = CoreSettingUtil.getLoginPromptForFollow();
        r29.b = CoreSettingUtil.getLoginImageForFollow();
        r29.e = "";
        r29.c = 0;
        r16 = r28.login(r13, new com.bytedance.android.livesdk.user.l(r29)).flatMap(new q2(r13, r4, r7, r9));
        goto L29
    L27:
        r16 = r2.a(r13, r4, Long.valueOf(r7.getRoomId()), r9);
        goto L29
    L57:
        throw new IllegalStateException("got vs compat room failed");
    L13:
        r4 = "-1";
        goto L14
    }
}

package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.dislike.NotificationSettingBottomDialog;
import com.bytedance.android.livesdk.user.UserApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class NotifyAction extends OptionAction {
    public final ActionsManager e;
    public long f;
    public final boolean g;

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r7) {
        Intrinsics.checkNotNullParameter(r7, "v");
        final NotificationSettingBottomDialog.a r8 = new NotificationSettingBottomDialog.a();
        r8.a = "long_press";
        Room r0 = this.b;
        CompositeDisposable r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getOwnerUserIdString();
    L6:
        r8.b = r2;
        r8.c = Long.valueOf(this.f);
        if (this.g == false) goto L50;
        ActionsManager r3 = this.e;
        Function1<Long, Unit> r4 = new NotifyAction$doClick$1(this, r8);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "execute");
        HashMap r9 = new HashMap();
        Room r5 = r3.d;
        if (r5 == null) goto L13;
        User r6 = r5.getOwner();
        if (r6 == null) goto L13;
        String r10 = r6.getIdStr();
    L14:
        r9.put("target_uid", String.valueOf(r10));
        Room r11 = r3.d;
        if (r11 == null) goto L19;
        User r12 = r11.getOwner();
        if (r12 == null) goto L19;
        String r13 = r12.getCastSecUid();
    L20:
        r9.put("sec_target_uid", String.valueOf(r13));
        r9.put("packed_level", String.valueOf(2));
        r9.put("request_from", "live_push_settings");
        Room r14 = r3.d;
        if (r14 == null) goto L23;
        Long r15 = Long.valueOf(r14.id);
    L24:
        r9.put("current_room_id", String.valueOf(r15));
        Room r16 = r3.d;
        if (r16 == null) goto L29;
        User r17 = r16.getOwner();
        if (r17 == null) goto L29;
        String r18 = r17.getIdStr();
    L30:
        r9.put("anchor_id", String.valueOf(r18));
        Room r19 = r3.d;
        if (r19 == null) goto L35;
        User r20 = r19.getOwner();
        if (r20 == null) goto L35;
        String r21 = r20.getCastSecUid();
    L36:
        r9.put("sec_anchor_id", String.valueOf(r21));
        Ref.LongRef r22 = new Ref.LongRef();
        Room r23 = r3.d;
        if (r23 == null) goto L43;
        User r24 = r23.getOwner();
        if (r24 == null) goto L43;
        FollowInfo r25 = r24.getFollowInfo();
        if (r25 == null) goto L43;
        long r26 = r25.getPushStatus();
    L44:
        r22.element = r26;
        Disposable r27 = ((UserApi) com.bytedance.android.live.network.c.b().e(UserApi.class)).queryUser(r9).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.dislike.a(r3, r22, r4), new com.bytedance.android.livesdk.dislike.b(r3, r4, r22));
        RoomContext r28 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r28 == null) goto L49;
        com.bytedance.live.datacontext.i r29 = r28.getCompositeDisposable();
        if (r29 == null) goto L49;
        r1 = (CompositeDisposable) r29.getValue();
    L49:
        RxUtilKt.c(r27, r1);
        return;
    L43:
        r26 = 2;
    L35:
        r21 = null;
    L29:
        r18 = null;
        goto L30
    L23:
        r15 = null;
    L19:
        r13 = null;
    L13:
        r10 = null;
        goto L14
    L50:
        NotificationSettingBottomDialog r30 = r8.a();
        HashMap r31 = bn2.k.a;
        bn2.k.b(r30.p, r30.o, r30.n);
        com.bytedance.android.livesdk.dislike.m r32 = this.e.c;
        if (r32 == null) goto L53;
        r1 = r32.getContext();
    L53:
        bn2.k.e(r1, r30);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public NotifyAction(ActionsManager r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "actionsManager");
        super(r2);
        this.e = r2;
        this.f = r3;
        this.g = true;
    }
}

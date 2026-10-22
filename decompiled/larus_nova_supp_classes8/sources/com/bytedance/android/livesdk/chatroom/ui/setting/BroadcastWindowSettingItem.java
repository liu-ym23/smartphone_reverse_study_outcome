package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.content.Context;
import com.bytedance.android.live.adapter.binding.BaseSettingViewHolder;
import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.roommanage.LiveRoomManageAppLogger;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class BroadcastWindowSettingItem extends mx.l {
    public BroadcastWindowSettingItem() {
        String r2 = s1.B(2131918908);
        String r3 = s1.B(2131918911);
        va1.b r0 = va1.b.a.a;
        ((IBroadcastService) r0.a(IBroadcastService.class)).broadcastFloatWindowManager();
        com.bytedance.android.livesdk.sharedpref.e r9 = com.bytedance.android.livesdk.sharedpref.b.z0;
        super(r2, r3, false, ((Boolean) r9.getValue()).booleanValue(), false, null, 112);
        com.bytedance.android.livesdk.sharedpref.f.d(r9, Boolean.FALSE);
        ((IBroadcastService) r0.a(IBroadcastService.class)).broadcastFloatWindowManager();
        Boolean r1 = (Boolean) com.bytedance.android.livesdk.sharedpref.b.c2.getValue();
    }

    public final void c(SwitchSettingViewHolder r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r7, "holder");
        ((mx.l) this).l = r8;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(this, "item");
        ((mx.a) this).h = false;
        ((BaseSettingViewHolder) r7).c.setVisibility(8);
        jc1.k.n(IBroadcastService.class).broadcastFloatWindowManager();
        Room r5 = null;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L7;
        r5 = (Room) r2.getValue();
    L7:
        LiveRoomManageAppLogger.c(r5, true, r8);
        if (r8 == true) goto L10;
        com.bytedance.android.livesdk.sharedpref.e r9 = com.bytedance.android.livesdk.sharedpref.b.c2;
        Boolean r10 = Boolean.FALSE;
        r9.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r9, r10);
        LiveRoomManageAppLogger.c(r5, false, false);
        return;
    L10:
        com.bytedance.android.livesdk.sharedpref.e r11 = com.bytedance.android.livesdk.sharedpref.b.c2;
        Boolean r3 = Boolean.TRUE;
        r11.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r11, r3);
        com.bytedance.android.livesdk.sharedpref.e r12 = com.bytedance.android.livesdk.sharedpref.b.e2;
        Long r4 = Long.valueOf(System.currentTimeMillis());
        r12.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r12, r4);
        f2.b(2131915340, 0);
        Disposable r13 = ((mx.l) this).m;
        if (r13 != null) goto L13;
    L17:
        final Context r14 = r7.d.getContext();
        ((mx.l) this).m = RxUtilKt.n(Observable.timer(2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()), new BroadcastWindowSettingItem$onCheckStateChanged$1(r14));
        return;
    L13:
        if (r13.isDisposed() == true) goto L17;
        Disposable r15 = ((mx.l) this).m;
        if (r15 == null) goto L17;
        r15.dispose();
        goto L17
    }
}

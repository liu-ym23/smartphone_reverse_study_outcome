package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.helper;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livehostapi.business.IHostFeed;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.foundation.depend.OnSwitchAccountListener;
import com.bytedance.android.livehostapi.foundation.depend.SwitchAccountSource;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.e3;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveSwitchAccountConfig;
import com.bytedance.live.kmp.core.KmpEnv;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final long a = 0;
    public static final LiveSwitchAccountConfig b = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.helper.a$a, reason: collision with other inner class name */
    public static final class C0084a implements OnSwitchAccountListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Room b;

        public final void onFail() {
            LiveSwitchAccountConfig r0 = a.b;
            ALogger.e("LiveSwitchAccountHelper", "switch account fail");
        }

        public final void onSuccess() {
            LiveSwitchAccountConfig r0 = a.b;
            e r1 = com.bytedance.android.livesdk.sharedpref.b.p3;
            Boolean r2 = Boolean.TRUE;
            r1.getClass();
            f.d(r1, r2);
            ALogger.i("LiveSwitchAccountHelper", "switch account success, isLivePlayActivity=" + this.a);
            Room r3 = this.b;
            String r4 = g4.f("enter_from_merge");
            String r5 = g4.f("enter_method");
            Bundle r6 = ArgumentsBuilder.buildRoomArgs(r3);
            r6.putBoolean("live_reenter_room", true);
            Object r7 = k.n(IHostFeed.class).getFeedTab(a.a).get("feed_url");
            if ((r7 instanceof String) == true) goto L5;
            r7 = null;
        L5:
            r6.putString("live.intent.extra.FEED_URL", (String) r7);
            r6.putBoolean("live.intent.extra.FROM_NEW_STYLE", true);
            Bundle r8 = new Bundle();
            r8.putString("enter_from_merge", r4);
            r8.putString("enter_method", r5);
            r6.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", r8);
            LiveSwitchAccountConfig r9 = a.b;
            if (r2.a(r9.getScheme()) == false) goto L8;
            r6.putString("extra_live_enter_room_handle_schema", r9.getScheme());
        L8:
            k.n(IHostAction.class).startLive(s1.getContext(), r3.getRoomId(), r6);
        }

        public C0084a(boolean r1, Room r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L5;
        long r1 = 1;
    L6:
        a = r1;
        b = (LiveSwitchAccountConfig) e3.a.getValue();
        new CompositeDisposable();
        return;
    L5:
        r1 = -1;
        goto L6
    }

    public static boolean a(int r2) {
        LiveSwitchAccountConfig r0 = b;
        if (r0.getEnable() == true) goto L5;
    L9:
        return false;
    L5:
        if (r2 < r0.getMinLevel()) goto L7;
    L8:
        return true;
    L7:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.p3.getValue()).booleanValue() == false) goto L9;
        goto L8
    }

    public static void b(SwitchAccountSource r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        IHostApp r0 = k.f(IHostApp.class);
        if (r0 != null) goto L5;
        return;
    L5:
        Class r1 = r0.getLiveActivityClass();
        Activity r2 = r0.getTopActivity();
        ALogger.i("LiveSwitchAccountHelper", "show switch account page, liveActivity=" + r1 + ", topActivity=" + r2);
        boolean r3 = TextUtils.equals(r1.getName(), r2.getClass().getName());
        ArrayList r4 = new ArrayList();
        IRoomService r5 = k.f(IRoomService.class);
        if (r5 == null) goto L12;
        Room r7 = r5.getCurrentRoomFromRoomContext();
        if (r7 == null) goto L13;
        r0.showSwitchAccount(r2, r6, r4, new C0084a(r3, r7));
        return;
    L13:
        return;
    }
}

package com.bytedance.android.livesdk.chatroom.ui.framework.widget.room;

import android.app.Activity;
import android.util.Pair;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.bytedance.android.livesdk.jsbridge.methods.o0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements kf1.a {
    public final /* synthetic */ RoomCloseInterceptorWidget a;

    public final String tag() {
        return "RewardInterceptor";
    }

    public final CloseRoomInterceptList config() {
        return CloseRoomInterceptList.DEFAULT;
    }

    public j(RoomCloseInterceptorWidget r1) {
        this.a = r1;
    }

    public final boolean qa(Runnable r11, boolean r12) {
        RoomCloseInterceptorWidget r13 = this.a;
        boolean r0 = RoomCloseInterceptorWidget.g;
        Room r14 = r13.getRoom();
        if (r14 != null) goto L5;
        return false;
    L5:
        Activity r1 = RoomCloseInterceptorWidget.wq(this.a);
        if (r1 != null) goto L8;
        return false;
    L8:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = this.a.a;
        DialogFragment r3 = null;
        if (r2 == null) goto L11;
        FragmentManager r4 = r2.ea();
    L12:
        if (r4 != null) goto L14;
        return false;
    L14:
        Pair r5 = (Pair) o0.a.get(r1);
        if (r5 != null) goto L18;
        return false;
    L18:
        if ((!Intrinsics.areEqual(String.valueOf(r14.id) + "", (String) r5.first)) == false) goto L21;
        return false;
    L21:
        if ((!Intrinsics.areEqual("reward", (String) r5.second)) == false) goto L24;
        return false;
    L24:
        if (tb1.c.c == true) goto L26;
        return false;
    L26:
        IHostBusiness r6 = jc1.k.f(IHostBusiness.class);
        if (r6 == null) goto L29;
        r3 = r6.showRewardDetainmentDialog(r1, String.valueOf(r14.id) + "", null, r11);
    L29:
        if (r3 != null) goto L31;
        return false;
    L31:
        LandscapeRestrictionOperation r15 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, "RewardDetainment", r15);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r3, r15) == false) goto L38;
    L36:
        return true;
    L38:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L37
    L35:
        r3.show(r4, "RewardDetainment");
        goto L36
    L11:
        r4 = null;
        goto L12
    }
}

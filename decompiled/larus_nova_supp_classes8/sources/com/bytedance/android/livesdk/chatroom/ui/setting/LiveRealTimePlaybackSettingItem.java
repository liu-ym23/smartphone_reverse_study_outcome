package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import nz.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveRealTimePlaybackSettingItem extends mx.l {
    public static final /* synthetic */ int v = 0;
    public final Lazy p;
    public final Lazy q;
    public final o r;
    public final Context s;
    public final ListDialogAbility t;
    public final boolean u;

    public final void e() {
        super.e();
        HashMap r0 = new HashMap();
        r0.put("anchor_id", (String) this.p.getValue());
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.M0.getValue()).booleanValue() == false) goto L5;
        String r1 = "on";
    L6:
        r0.put("status", r1);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_real_time_playback_button_show", r0, new Object[]{Room.class});
        return;
    L5:
        r1 = "off";
        goto L6
    }

    public final View.OnClickListener f() {
        return this.r;
    }

    public final Context getContext() {
        return this.s;
    }

    public final boolean b(boolean r3) {
        if (this.u == false) goto L9;
        if (r3 == true) goto L6;
        f2.c(s1.B(2131914894), 0);
        return true;
    L6:
        f2.c(s1.B(2131914850), 0);
        return true;
    L9:
        return false;
    }

    public final void c(SwitchSettingViewHolder r8, final boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        boolean r1 = ((mx.l) this).l;
        Intrinsics.checkNotNullParameter(r8, "holder");
        ((mx.l) this).l = r1;
        if (this.u == false) goto L5;
        return;
    L5:
        FragmentActivity r0 = ContextUtil.contextToFragmentActivity(this.s);
        if (r0 == null) goto L9;
        int r10 = a0.a;
        a0.c(r0, 5, r9, 0, new LiveRealTimePlaybackSettingItem$onCheckStateChanged$$inlined$let$lambda$1(this, r9), LiveRealTimePlaybackSettingItem$onCheckStateChanged$1$2.INSTANCE);
        return;
    }

    public LiveRealTimePlaybackSettingItem(Context r10, ListDialogAbility r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "ability");
        super(s1.B(2131919839), null, r12, false, false, null, 122);
        this.s = r10;
        this.t = r11;
        this.u = true;
        this.p = LazyKt.lazy(LiveRealTimePlaybackSettingItem$anchorId$2.INSTANCE);
        this.q = InfraKotlinExtsKt.mainThreadLazy(new LiveRealTimePlaybackSettingItem$mTitleIntroduceDialog$2(this));
        this.r = new o(this);
    }
}

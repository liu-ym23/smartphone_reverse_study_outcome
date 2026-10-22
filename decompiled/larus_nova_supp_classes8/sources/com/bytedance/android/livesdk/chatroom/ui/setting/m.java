package com.bytedance.android.livesdk.chatroom.ui.setting;

import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.model.interact.AudioSubtitleContent;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m extends mx.l {
    public boolean p;
    public final ListDialogAbility q;

    public static final class a implements nj0.c {
        public final /* synthetic */ m a;
        public final /* synthetic */ boolean b;

        public a(m r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(boolean r3, CustomApiServerException r4) {
            this.a.p = false;
            if (r3 == true) goto L5;
            if (r4 == null) goto L11;
            String r5 = com.bytedance.android.live.broadcastgame.api.openplatform.h.b(r4);
            if (r5 == null) goto L11;
        L12:
            f2.c(r5, 0);
            MultiTypeAdapter r6 = this.a.q.listAdapter();
            if (r6 == null) goto L18;
            int r7 = mx.l.o;
            mx.l.a.b(r6, this.a, !this.b);
            return;
        L18:
            return;
        L11:
            r5 = s1.B(2131919516);
            goto L12
        L5:
            if (this.b == false) goto L7;
            ((IAudioSubtitleContent) b6.p0.getValue()).setStatus(AudioSubtitleContent.SwitchStatus.SWITCH_ON.getValue());
            return;
        L7:
            ((IAudioSubtitleContent) b6.p0.getValue()).setStatus(AudioSubtitleContent.SwitchStatus.SWITCH_OFF.getValue());
        }
    }

    public final void e() {
        super.e();
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.N1;
        if (((Boolean) r0.getValue()).booleanValue() == true) goto L6;
        Boolean r1 = Boolean.TRUE;
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);
        return;
    }

    public final boolean b(boolean r1) {
        if (this.p == false) goto L6;
        return true;
    L6:
        return false;
    }

    public m(Room r9, ListDialogAbility r10) {
        Intrinsics.checkNotNullParameter(r9, "room");
        Intrinsics.checkNotNullParameter(r10, "ability");
        String r1 = s1.B(2131919512);
        String r2 = s1.B(2131919513);
        if (((IAudioSubtitleContent) b6.p0.getValue()).getStatus() != AudioSubtitleContent.SwitchStatus.SWITCH_ON.getValue()) goto L5;
        boolean r11 = true;
    L6:
        super(r1, r2, r11, !((Boolean) com.bytedance.android.livesdk.sharedpref.b.N1.getValue()).booleanValue(), !((Boolean) jc1.k.n(IInteractService.class).subtitleExceptPlayModeOpen().first).booleanValue(), (String) jc1.k.n(IInteractService.class).subtitleExceptPlayModeOpen().second, 64);
        this.q = r10;
        return;
    L5:
        r11 = false;
        goto L6
    }

    public final void c(SwitchSettingViewHolder r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        if (this.p == false) goto L6;
        f2.c(s1.B(2131919517), 0);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r3, "holder");
        ((mx.l) this).l = r4;
        this.p = true;
        IInteractService r5 = jc1.k.f(IInteractService.class);
        if (r5 == null) goto L10;
        r5.anchorAudioSubtitleSwitchSetting(r4, "more", new a(this, r4));
        return;
    }
}
